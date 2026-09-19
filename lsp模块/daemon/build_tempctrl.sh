#!/bin/sh
# ============================================================================
# tempctrl 构建环境约束（唯一权威说明；其它文件一律指向本段，不得复制）
# ----------------------------------------------------------------------------
# 1. 工具链：NDK r27c 的 aarch64-linux-android21-clang，只在 GitHub Actions CI 上编译。
# 2. 不得用 Termux 编译：Termux 的 clang 链接 Termux 自带 libc（非 Android bionic），
#    产物在真机上 PT_TLS 对齐错误不可用（编出来只能看语法错误）。
# 3. 链接方式：NDK 对 API 21+ 默认 -pie 动态链接，刻意不传 -static；
#    依赖设备 /system/lib64/libc.so。静态链接会带出 PT_TLS p_align=8 问题（见第 5 条）。
# 4. -lm 必需：动态链接下 libm 是独立的 libm.so，代码用了 powf，删掉会 undefined symbol。
# 5. patch_tls.py 在编译后由 CI 执行：PT_TLS p_align < 64 时改写为 64；
#    无 PT_TLS 段或已满足 >= 64 时为空操作（可安全重复执行）。
# 6. 本文件是编译参数的唯一来源，build.yml 与文档只调用本脚本，勿在别处复制命令行。
# ============================================================================
#
# 用法: CC=<clang 完整路径> sh build_tempctrl.sh <源码路径> <输出路径>
# 例:   CC=/opt/ndk/toolchains/llvm/prebuilt/linux-x86_64/bin/aarch64-linux-android21-clang \
#         sh "lsp模块/daemon/build_tempctrl.sh" "lsp模块/daemon/tempctrl.c" tempctrl
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
    -o "$OUT" "$SRC" -lm
