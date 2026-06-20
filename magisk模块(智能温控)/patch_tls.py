#!/usr/bin/env python3
"""
patch_tls.py — 修正 ARM64 ELF 可执行文件的 PT_TLS 段对齐

Android Bionic (ARM64) 要求 PT_TLS 段的 p_align >= 64，
但 NDK 默认静态编译生成的 p_align = 8，导致无法执行。

用法: python3 patch_tls.py <elf_file>
"""

import struct
import sys
import os
import subprocess


def patch_tls_align(path: str) -> bool:
    """将 ELF 中 PT_TLS 段 p_align 强制设为 64，返回是否修改过。"""

    with open(path, 'r+b') as f:
        ident = f.read(64)
        if ident[:4] != b'\x7fELF':
            print(f'error: not an ELF file: {path}', file=sys.stderr)
            return False

        if ident[4] != 2:  # EI_CLASS: 1=32bit, 2=64bit
            print(f'error: not a 64-bit ELF: {path}', file=sys.stderr)
            return False

        # 64-bit ELF header 布局
        phoff = struct.unpack_from('<Q', ident, 0x20)[0]
        phentsize = struct.unpack_from('<H', ident, 0x36)[0]
        phnum = struct.unpack_from('<H', ident, 0x38)[0]

        if phentsize < 56:
            print(f'error: program header too small ({phentsize})', file=sys.stderr)
            return False

        PT_TLS = 7
        patched = False

        for i in range(phnum):
            ph_offset = phoff + i * phentsize
            f.seek(ph_offset)
            ph = f.read(phentsize)

            p_type = struct.unpack_from('<I', ph, 0)[0]
            if p_type != PT_TLS:
                continue

            p_align = struct.unpack_from('<Q', ph, 0x30)[0]
            if p_align >= 64:
                print(f'PT_TLS p_align = {p_align} (OK, >= 64)')
                return True

            f.seek(ph_offset + 0x30)
            f.write(struct.pack('<Q', 64))
            print(f'PT_TLS p_align patched: {p_align} -> 64')
            patched = True

        if not patched:
            print('warning: no PT_TLS segment found', file=sys.stderr)

        return patched


def verify(path: str):
    """用 readelf 验证修补结果。"""
    try:
        result = subprocess.run(
            ['readelf', '-l', path],
            capture_output=True, text=True
        )
        for line in result.stdout.split('\n'):
            if 'TLS' in line or 'alignment' in line.lower():
                print(f'  verify: {line.strip()}')
    except FileNotFoundError:
        print('  verify: readelf not available, skip')


def main():
    if len(sys.argv) != 2:
        print(f'usage: {sys.argv[0]} <elf_file>', file=sys.stderr)
        sys.exit(1)

    path = sys.argv[1]
    if not os.path.exists(path):
        print(f'error: file not found: {path}', file=sys.stderr)
        sys.exit(1)

    patched = patch_tls_align(path)
    verify(path)
    sys.exit(0 if patched else 1)


if __name__ == '__main__':
    main()
