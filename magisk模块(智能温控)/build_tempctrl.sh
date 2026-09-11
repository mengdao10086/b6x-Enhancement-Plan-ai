#!/bin/sh
# 本文件是编译参数的唯一来源，build.yml 与 CLAUDE.md 均引用此处。
# 修改编译参数请只改本文件，不要在别处复制副本。
#
# 用法: CC=<clang 完整路径> sh build_tempctrl.sh <源码路径> <输出路径>
# 例:   CC=/opt/ndk/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android21-clang \
#         sh "magisk模块(智能温控)/build_tempctrl.sh" "magisk模块(智能温控)/tempctrl.c" tempctrl
#
# 链接方式：NDK 对 API 21+ 默认 -pie，动态链接（不传 -static）；依赖设备 /system/lib64/libc.so。
set -e

if [ -z "$CC" ]; then
    echo "error: 环境变量 CC 未设置（应指向 NDK 的 aarch64-linux-android21-clang）" >&2
    exit 1
fi

if [ -z "$1" ]; then
    echo "error: 缺少参数 1：源码路径" >&2
    exit 1
fi

if [ -z "$2" ]; then
    echo "error: 缺少参数 2：输出路径" >&2
    exit 1
fi

SRC="$1"
OUT="$2"

"$CC" \
    -O2 \
    -ffunction-sections -fdata-sections \
    -Wl,--gc-sections -Wl,--strip-all \
    -fno-unwind-tables -fno-asynchronous-unwind-tables \
    -o "$OUT" "$SRC"
