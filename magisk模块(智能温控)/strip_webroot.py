#!/usr/bin/env python3
r"""
strip_webroot.py — 就地剥离 WebUI 前端资源的「整行注释」与行首缩进

只用于 CI 打包：作用于 CI 里的模块副本，仓库源码保持可读。

安全规则（务必遵守，改动前先读）：
  1. 只删「整行都是注释」的行；绝不解析、绝不删改行内注释。
  2. 块注释 /* ... */ 跨行时，中间行整体删除；同一行内闭合且后面无代码才删。
  3. // 只在「去掉前导空白后以 // 开头」时才算注释行。
  4. 含代码的行一律原样保留（仅去行首空白，不影响行尾、不影响 ASI）。
     已实测：app.js 的正则字面量（/^\w+=/, /\s*#.*$/, /"/g）都在代码行内，
     而注释判定只看行首，故不受影响；style.css 的 6 处行尾 /* */ 均在同一行闭合，
     按规则 4 整行保留，不会产生悬空注释状态。
  5. 二进制读写，行尾符（CRLF/LF）原样保留 —— schema.js 是 CRLF，其余是 LF。
  6. 幂等：对已剥离的文件再跑一次输出完全不变。

用法: python3 strip_webroot.py <webroot 目录> [更多目录...]
"""

import os
import sys

FILES = ("app.js", "schema.js", "style.css", "index.html")


def strip_bytes(data: bytes) -> bytes:
    out = []
    in_block = False
    for raw in data.split(b"\n"):
        cr = raw.endswith(b"\r")
        core, eol = (raw[:-1], b"\r") if cr else (raw, b"")
        s = core.strip()

        if in_block:
            if b"*/" in s:
                in_block = False
                rest = s.split(b"*/", 1)[1].strip()
                if rest:
                    out.append(rest + eol)
            continue

        if not s:                                  # 空行：保留（去空白后为空）
            out.append(eol)
        elif s.startswith(b"//"):                  # 整行行注释
            continue
        elif s.startswith(b"/*"):                  # 块注释起始行
            if b"*/" not in s:
                in_block = True
            else:
                rest = s.split(b"*/", 1)[1].strip()
                if rest:
                    out.append(rest + eol)
        elif s.startswith(b"<!--") and b"-->" in s:  # 单行 HTML 注释
            rest = s.split(b"-->", 1)[1].strip()
            if rest:
                out.append(rest + eol)
        else:                                      # 代码行：仅去行首空白
            out.append(core.lstrip(b" \t") + eol)
    return b"\n".join(out)


def main(argv):
    if len(argv) < 2:
        print("usage: strip_webroot.py <webroot dir> [...]", file=sys.stderr)
        return 2

    total_before = total_after = 0
    seen = 0
    for root in argv[1:]:
        if not os.path.isdir(root):
            print("error: not a directory: %s" % root, file=sys.stderr)
            return 1
        for name in FILES:
            path = os.path.join(root, name)
            if not os.path.isfile(path):
                continue
            seen += 1
            with open(path, "rb") as f:
                before = f.read()
            after = strip_bytes(before)
            if after != before:
                with open(path, "wb") as f:
                    f.write(after)
            total_before += len(before)
            total_after += len(after)
            print("[strip] %-11s %7d -> %7d  (-%d, %.1f%%)"
                  % (name, len(before), len(after), len(before) - len(after),
                     (len(before) - len(after)) * 100.0 / len(before)))

    if not seen:
        print("error: no target files found in: %s" % " ".join(argv[1:]),
              file=sys.stderr)
        return 1

    print("[strip] total      %7d -> %7d  (-%d, %.1f%%)"
          % (total_before, total_after, total_before - total_after,
             (total_before - total_after) * 100.0 / total_before))
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv))
