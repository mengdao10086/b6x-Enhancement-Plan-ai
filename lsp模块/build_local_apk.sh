#!/bin/sh
# ============================================================================
# 本地打包：编译 C 守护程序 → 注入 core assets → 构建 GUI/lite release → 校验 APK
# ----------------------------------------------------------------------------
# 为什么需要本脚本：tempctrl-arm64 是 CI 产物、被 .gitignore 忽略，干净 clone 直接
# ./gradlew assembleRelease 会静默产出「不含 daemon」的 APK。本脚本把 C 编译与资产
# 校验放在 Gradle 之前，任一环失败即退出。
#
# 用法（Git Bash / Linux，需本机 NDK 与 Android SDK）：
#   sh lsp模块/build_local_apk.sh
# 可选环境变量：
#   ANDROID_NDK_HOME   NDK 根目录（默认回退 D:/tools/android-ndk-r27c）
#   AAPT2              aapt2 路径（默认回退 D:/tools/android-sdk/build-tools/34.0.0/aapt2.exe）
#
# 不提交编译产物：tempctrl-arm64 仍由 .gitignore 忽略。
# ============================================================================
set -eu

# Git Bash 的 pwd 是 /d/... 形式；Windows 版 clang 在该 cwd 下建临时文件会失败，
# 优先用 pwd -W 取 D:/... 形式（非 MSYS 环境没有 -W，回退普通 pwd）。
ROOT=$(cd "$(dirname "$0")" && pwd -W 2>/dev/null || pwd)
cd "$ROOT"

NDK="${ANDROID_NDK_HOME:-${ANDROID_NDK_ROOT:-}}"
if [ -z "$NDK" ] && [ -d "D:/tools/android-ndk-r27c" ]; then
    NDK="D:/tools/android-ndk-r27c"
fi
if [ -z "$NDK" ] || [ ! -d "$NDK/toolchains/llvm/prebuilt" ]; then
    echo "error: 未找到 NDK（设 ANDROID_NDK_HOME 或放到 D:/tools/android-ndk-r27c）" >&2
    exit 1
fi

case "$(uname -s)" in
    MINGW*|MSYS*|CYGWIN*) HOST=windows-x86_64; EXT=.cmd ;;
    *)                    HOST=linux-x86_64;   EXT= ;;
esac
CC="$NDK/toolchains/llvm/prebuilt/$HOST/bin/aarch64-linux-android21-clang$EXT"
if [ ! -x "$CC" ] && [ ! -f "$CC" ]; then
    echo "error: NDK clang 不存在：$CC" >&2
    exit 1
fi

BIN="core/src/main/assets/tempctrl-arm64"
OUT="build/tempctrl-arm64"
mkdir -p build

echo "=== 编译 C 守护程序（arm64） ==="
# 变量名不要用 TMP：Windows 的 clang 用 TMP 环境变量建临时文件，覆盖它会直接编译失败。
# 用相对路径交给 clang：Windows NDK 对含中文/空格的绝对路径建临时文件也会失败。
CC="$CC" sh daemon/build_tempctrl.sh daemon/tempctrl.c "$OUT"

echo "=== 修补 PT_TLS（无 PT_TLS 时为空操作） ==="
if command -v python3 >/dev/null 2>&1; then
    python3 daemon/patch_tls.py "$OUT"
elif command -v python >/dev/null 2>&1; then
    python daemon/patch_tls.py "$OUT"
else
    echo "error: 未找到 python3/python，无法执行 patch_tls.py" >&2
    exit 1
fi

[ -s "$OUT" ] || { echo "error: 编译产物为空：$OUT" >&2; exit 1; }
cp "$OUT" "$BIN"
echo "已注入：$BIN ($(stat -c%s "$BIN" 2>/dev/null || wc -c < "$BIN") bytes)"

echo "=== 构建 GUI + lite release ==="
./gradlew :app:assembleRelease :app-lite:assembleRelease

echo "=== 校验 APK 内含 daemon 二进制 ==="
GUI="$ROOT/app/build/outputs/apk/release/app-release.apk"
LITE="$ROOT/app-lite/build/outputs/apk/release/app-lite-release.apk"
for apk in "$GUI" "$LITE"; do
    [ -f "$apk" ] || { echo "error: 缺少产物 $apk" >&2; exit 1; }
    unzip -l "$apk" | grep -q 'assets/tempctrl-arm64' \
        || { echo "error: $apk 不含 assets/tempctrl-arm64" >&2; exit 1; }
done

AAPT2="${AAPT2:-D:/tools/android-sdk/build-tools/34.0.0/aapt2.exe}"
if [ -x "$AAPT2" ]; then
    GUI_VC=$("$AAPT2" dump badging "$GUI" | sed -nE "s/^package: name='[^']+' versionCode='([0-9]+)'.*/\1/p" | head -1)
    LITE_VC=$("$AAPT2" dump badging "$LITE" | sed -nE "s/^package: name='[^']+' versionCode='([0-9]+)'.*/\1/p" | head -1)
    [ -n "$GUI_VC" ] && [ "$GUI_VC" = "$LITE_VC" ] \
        || { echo "error: 两 APK versionCode 不一致：GUI=$GUI_VC lite=$LITE_VC" >&2; exit 1; }
    echo "versionCode 一致：$GUI_VC"
fi

echo "=== 完成 ==="
echo "GUI : $GUI"
echo "lite: $LITE"
