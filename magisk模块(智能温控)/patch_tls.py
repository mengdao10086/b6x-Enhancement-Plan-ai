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
    """将 ELF 中 PT_TLS 段 p_align 强制设为 64。

    返回是否已处理成功（True=成功，无需区分"已修补"还是"原本就满足"）：
    True = 已修补，或原本 p_align>=64 无需修改（同样视为成功）；
    False = 打开失败 / 非 ELF / 非 64 位 / 头越界或损坏 / 未找到 PT_TLS。
    """

    try:
        f = open(path, 'r+b')
    except OSError as e:
        print(f'error: cannot open {path}: {e}', file=sys.stderr)
        return False
    with f:
        ident = f.read(64)
        # 修复：读 ph/取 phoff 前先校验头部长度，小文件/截断文件直接友好报错，
        # 否则 struct.unpack_from 会抛 struct.error 崩溃
        if len(ident) < 64:
            print(f'error: file too small to be a 64-bit ELF header: {path}', file=sys.stderr)
            return False
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
            if len(ph) < phentsize:
                # 程序头越界/文件被截断：继续读会 struct.error，友好报错返回
                print(f'error: program header {i} truncated (offset {ph_offset})', file=sys.stderr)
                return False

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
        # 修复：旧过滤 ('TLS' in line / 'alignment' in lower) 会误匹配表头行且取不到 Align 列。
        # 改为按表头拆分列：程序头行的首列是段类型，末列是 Align（p_align），
        # 只输出 PT_TLS 行的 Align 值。
        for line in result.stdout.split('\n'):
            cols = line.split()
            if cols and cols[0] == 'TLS':
                print(f'  verify: PT_TLS Align = {cols[-1]}')
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
