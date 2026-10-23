#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""PID_CUT 行尾换行回归测试

背景：fgets 读入的行带 '\\n'，入口若不裁剪，PID_CUT_<n> 按逗号切分后最后一个 token
变成 "65\\n"，严格整数校验判非整数，整行失效（恒报「第 4 点」）。

本脚本**从 tempctrl.c 原样抽取**解析链源码（trim_* → config_parse_line → ki_cut_tok_int
→ ki_cut_parse_row），拼进最小宿主程序编译执行——测的是生产源码文本，不是复写实现。

正例：带 \\n / \\r\\n 的多值行应完整解析出 4 个四元组。
负例：1,100,abc,50 仍判非整数、保持该簇上次值（校验不得被放松）。

编译策略（自动选择）：
  1. 有 host cc/gcc/clang → 直接编译本机可执行文件运行；
  2. 否则（Windows 本机）→ NDK clang 编 wasm32 + node 运行。
     本机实测 NDK：D:/tools/android-ndk-r27c（可用环境变量 NDK_CLANG 覆盖）。

用法：
    python "lsp模块/daemon/PID_CUT解析回归测试.py" [tempctrl.c 路径]
    （不给源码路径时用同目录的 tempctrl.c；给路径可对旧版本做回归复现）

输出：同目录 PID_CUT解析回归结果.log（屏幕同时打印）。
退出码：0 = 全部通过；非 0 = 失败（首个失败用例号）或环境不满足。
"""

import os
import re
import shutil
import subprocess
import sys
import tempfile

HERE = os.path.dirname(os.path.abspath(__file__))
DEFAULT_SRC = os.path.join(HERE, "tempctrl.c")
LOG_PATH = os.path.join(HERE, "PID_CUT解析回归结果.log")

# 需要原样抽取的生产函数（顺序即拼接顺序：被调者在前）
FUNCS = [
    "clamp",
    "trim_line",
    "trim_right",
    "trim_value",
    "config_parse_line",
    "ki_cut_tok_int",
    "ki_cut_parse_row",
]


def code_mask(s):
    """标记每个字符是否处于代码区（注释/字符串/字符常量之外）。"""
    n = len(s)
    mask = bytearray(b"\x01") * n
    i = 0
    while i < n:
        if s.startswith("//", i):
            j = s.find("\n", i)
            j = n if j < 0 else j
            mask[i:j] = b"\x00" * (j - i)
            i = j
        elif s.startswith("/*", i):
            j = s.find("*/", i + 2)
            j = n if j < 0 else j + 2
            mask[i:j] = b"\x00" * (j - i)
            i = j
        elif s[i] in "\"'":
            q = s[i]
            j = i + 1
            while j < n:
                if s[j] == "\\":
                    j += 2
                    continue
                if s[j] == q:
                    j += 1
                    break
                j += 1
            mask[i:j] = b"\x00" * (j - i)
            i = j
        else:
            i += 1
    return mask


def match_pair(s, mask, start):
    """start 指向 '(' 或 '{'，返回配对的闭括号下标（跳过注释/字符串）。"""
    assert s[start] in "({"
    open_c = s[start]
    close_c = ")" if open_c == "(" else "}"
    depth = 0
    for i in range(start, len(s)):
        if not mask[i]:
            continue
        if s[i] == open_c:
            depth += 1
        elif s[i] == close_c:
            depth -= 1
            if depth == 0:
                return i
    return -1


def extract_function(s, mask, name):
    """抽取函数定义全文（含 static/inline 前缀到闭括号）。"""
    for m in re.finditer(r"\b" + re.escape(name) + r"\s*\(", s):
        i = m.start()
        if not mask[i]:
            continue
        popen = s.index("(", m.start())
        pclose = match_pair(s, mask, popen)
        if pclose < 0:
            continue
        j = pclose + 1
        while j < len(s) and s[j] in " \t\r\n":
            j += 1
        if j >= len(s) or s[j] != "{":
            continue      # 前向声明（以 ';' 结束）
        line_start = s.rfind("\n", 0, i) + 1
        if "static" not in s[line_start:i]:
            continue      # 调用点/注释
        bend = match_pair(s, mask, j)
        if bend < 0:
            continue
        return s[line_start:bend + 1]
    raise SystemExit("error: 在源码中找不到函数 %s 的定义" % name)


def extract_define(s, name):
    m = re.search(r"(?m)^#define\s+" + re.escape(name) + r"\b[^\n]*$", s)
    if not m:
        raise SystemExit("error: 在源码中找不到宏 %s" % name)
    return m.group(0)


HARNESS_HEAD = r"""/* 由 PID_CUT解析回归测试.py 生成，勿手改 */
#ifdef PID_CUT_TEST_STANDALONE
typedef __SIZE_TYPE__ size_t;
#define NULL ((void *)0)
#define T_EXPORT(n) __attribute__((export_name(#n)))
#else
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define T_EXPORT(n)
#endif
#include "ki_cut.h"
#include "params_generated.h"

/* 被抽取的函数定义在下方，前置声明供测试驱动调用 */
static char *config_parse_line(char *line, char **out_key);
static void ki_cut_parse_row(const char *idx_str, const char *val_str);

#ifdef PID_CUT_TEST_STANDALONE
void *memcpy(void *dst, const void *src, size_t n) {
    unsigned char *d = (unsigned char *)dst;
    const unsigned char *s2 = (const unsigned char *)src;
    for (size_t i = 0; i < n; i++) d[i] = s2[i];
    return dst;
}
void *memset(void *dst, int c, size_t n) {
    unsigned char *d = (unsigned char *)dst;
    for (size_t i = 0; i < n; i++) d[i] = (unsigned char)c;
    return dst;
}
size_t strlen(const char *s) { size_t n = 0; while (s[n]) n++; return n; }
char *strchr(const char *s, int c) {
    for (;; s++) { if (*s == (char)c) return (char *)s; if (!*s) return NULL; }
}
/* 仅覆盖本测试用到的十进制路径（生产侧只以 base 10 调用） */
long strtol(const char *s, char **end, int base) {
    const char *p = s;
    while (*p == ' ' || *p == '\t' || *p == '\n' || *p == '\r') p++;
    int neg = 0;
    if (*p == '+' || *p == '-') { neg = (*p == '-'); p++; }
    long v = 0; int any = 0;
    if (base == 10) {
        while (*p >= '0' && *p <= '9') { v = v * 10 + (*p - '0'); p++; any = 1; }
    }
    if (!any) { if (end) *end = (char *)s; return 0; }
    if (end) *end = (char *)p;
    return neg ? -v : v;
}
#endif
"""

# 解析状态（生产侧同形声明；KI_CUT_MAX_CLUSTERS 由源码抽取）
HARNESS_STATE = r"""
static KiCutPoint ki_cut_rows[KI_CUT_MAX_CLUSTERS][KI_CUT_MAX_POINTS];
static int ki_cut_cnt[KI_CUT_MAX_CLUSTERS];
static int pidcut_new_seen[KI_CUT_MAX_CLUSTERS];

static char g_log[512];
static int g_log_count;
static void write_log(const char *fmt, ...) {
    g_log_count++;
    size_t i = 0;
    while (i + 1 < sizeof(g_log) && fmt[i]) { g_log[i] = fmt[i]; i++; }
    g_log[i] = '\0';
}

static char g_line[2048];

static int str_has(const char *s, const char *needle) {
    size_t nl = strlen(needle);
    if (nl == 0) return 1;
    for (size_t i = 0; s[i]; i++) {
        size_t j = 0;
        while (j < nl && s[i + j] == needle[j]) j++;
        if (j == nl) return 1;
    }
    return 0;
}

/* reset=1 模拟首次装载（清空该簇）；reset=0 模拟后续重载失败时的「保持上次值」 */
static int parse_copy(const char *line, int reset) {
    size_t n = strlen(line);
    if (n >= sizeof(g_line)) n = sizeof(g_line) - 1;
    for (size_t i = 0; i < n; i++) g_line[i] = line[i];
    g_line[n] = '\0';
    if (reset) { ki_cut_cnt[0] = 0; pidcut_new_seen[0] = 0; }
    g_log_count = 0;
    g_log[0] = '\0';
    char *key = NULL;
    char *val = config_parse_line(g_line, &key);
    if (!val) return -1;
    ki_cut_parse_row(key + sizeof(CFG_ROW_PREFIX_PID_CUT) - 1, val);
    return ki_cut_cnt[0];
}

static int g_fail_case;
static int g_cur_case;
static char g_fail_log[512];

static void bad(void) {
    if (g_fail_case) return;
    g_fail_case = g_cur_case;
    size_t i = 0;
    while (i + 1 < sizeof(g_fail_log) && g_log[i]) { g_fail_log[i] = g_log[i]; i++; }
    g_fail_log[i] = '\0';
}

static void expect_rows(const int want[][4], int n) {
    for (int k = 0; k < n; k++) {
        const KiCutPoint *p = &ki_cut_rows[0][k];
        if (p->cold != want[k][0] || p->kdp != want[k][1]
                || p->up != want[k][2] || p->dn != want[k][3]) bad();
    }
}

static int run_all(void) {
    static const int p1[4][4] = {{1, 100, 100, 50}, {2, 100, 90, 80},
                                 {3, 100, 80, 70},  {4, 100, 70, 60}};
    static const int p2[4][4] = {{5, 100, 95, 85}, {6, 100, 85, 75},
                                 {7, 100, 75, 65},  {8, 100, 65, 55}};
    g_fail_case = 0;
    g_fail_log[0] = '\0';

    /* 1：行尾 \\n —— 4 个四元组全部生效，且无任何告警日志 */
    g_cur_case = 1;
    if (parse_copy("PID_CUT_1=1,100,100,50,2,100,90,80,3,100,80,70,4,100,70,60\n", 1) != 4
            || g_log_count != 0) bad();
    expect_rows(p1, 4);

    /* 2：行尾 \\r\\n —— 同样完整解析 */
    g_cur_case = 2;
    if (parse_copy("PID_CUT_1=5,100,95,85,6,100,85,75,7,100,75,65,8,100,65,55\r\n", 1) != 4
            || g_log_count != 0) bad();
    expect_rows(p2, 4);

    /* 3（负向）：真非整数仍报错，且保持该簇上次值（不部分覆盖） */
    g_cur_case = 3;
    parse_copy("PID_CUT_1=1,100,100,50,2,100,90,80,3,100,80,70,4,100,70,60\n", 1);
    if (parse_copy("PID_CUT_1=1,100,abc,50\n", 0) != 4
            || !str_has(g_log, "非整数")) bad();
    expect_rows(p1, 4);

    /* 4（负向）：段数非四元组整数倍仍整行忽略 */
    g_cur_case = 4;
    parse_copy("PID_CUT_1=1,100,100,50,2,100,90,80,3,100,80,70,4,100,70,60\n", 1);
    if (parse_copy("PID_CUT_1=1,100,100\n", 0) != 4
            || !str_has(g_log, "非四元组整数倍")) bad();
    expect_rows(p1, 4);

    /* 5：空值（仅行尾换行）按「清空该簇」哨兵处理 */
    g_cur_case = 5;
    if (parse_copy("PID_CUT_1=\n", 1) != 0) bad();

    return g_fail_case == 0;
}

#ifdef PID_CUT_TEST_STANDALONE
T_EXPORT(run_all) int t_run_all(void) { return run_all(); }
T_EXPORT(fail_case) int t_fail_case(void) { return g_fail_case; }
T_EXPORT(fail_log_len) int t_fail_log_len(void) { return (int)strlen(g_fail_log); }
T_EXPORT(fail_log_byte) int t_fail_log_byte(int i) { return (unsigned char)g_fail_log[i]; }
#else
int main(void) {
    int ok = run_all();
    if (ok) {
        printf("PASS 全部 5 个用例（含 \\n / \\r\\n 正例与 3 个负向）\n");
        return 0;
    }
    printf("FAIL 首个失败用例 #%d；该用例日志：%s\n", g_fail_case, g_fail_log);
    return g_fail_case;
}
#endif
"""

NODE_RUNNER = r"""
const fs = require('fs');
const buf = fs.readFileSync(process.argv[2]);
WebAssembly.instantiate(buf, {}).then(({ instance }) => {
  const e = instance.exports;
  const ok = e.run_all();
  let log = '';
  if (!ok) {
    const n = e.fail_log_len();
    const bytes = new Uint8Array(n);
    for (let i = 0; i < n; i++) bytes[i] = e.fail_log_byte(i);
    log = Buffer.from(bytes).toString('utf8');
  }
  console.log(ok ? 'PASS 全部 5 个用例（含 \\n / \\r\\n 正例与 3 个负向）'
                 : `FAIL 首个失败用例 #${e.fail_case()}；该用例日志：${log}`);
  process.exit(ok ? 0 : e.fail_case());
});
"""


def build_harness(src_text):
    mask = code_mask(src_text)
    return (
        HARNESS_HEAD
        + extract_define(src_text, "KI_CUT_MAX_CLUSTERS")
        + "\n"
        + HARNESS_STATE
        + "\n"
        + "\n\n".join(extract_function(src_text, mask, fn) for fn in FUNCS)
        + "\n"
    )


def find_host_cc():
    for name in ("cc", "gcc", "clang"):
        p = shutil.which(name)
        if p:
            return p
    return None


def run(cmd, cwd=None):
    return subprocess.run(cmd, cwd=cwd, stdout=subprocess.PIPE,
                          stderr=subprocess.STDOUT, text=True,
                          encoding="utf-8", errors="replace")


def find_wasm_clang():
    env = os.environ.get("NDK_CLANG")
    if env and os.path.isfile(env):
        return env
    candidates = [
        r"D:/tools/android-ndk-r27c/toolchains/llvm/prebuilt/windows-x86_64/bin/clang.exe",
    ]
    ndk_home = os.environ.get("ANDROID_NDK_HOME") or os.environ.get("NDK_HOME")
    if ndk_home:
        for host in ("windows-x86_64", "linux-x86_64", "darwin-x86_64"):
            candidates.insert(0, os.path.join(ndk_home, "toolchains/llvm/prebuilt",
                                              host, "bin/clang"))
    for c in candidates:
        if os.path.isfile(c):
            return c
    return None


def main():
    src_path = os.path.abspath(sys.argv[1]) if len(sys.argv) > 1 else DEFAULT_SRC
    if not os.path.isfile(src_path):
        raise SystemExit("error: 源码不存在：%s" % src_path)
    with open(src_path, "r", encoding="utf-8") as fh:
        src_text = fh.read()

    harness = build_harness(src_text)
    work = tempfile.mkdtemp(prefix="pidcut-test-")
    c_path = os.path.join(work, "harness.c")
    with open(c_path, "w", encoding="utf-8") as fh:
        fh.write(harness)

    lines = ["源码：%s" % src_path]
    try:
        cc = find_host_cc()
        if cc:
            exe = os.path.join(work, "harness.exe" if os.name == "nt" else "harness")
            cp = run([cc, "-std=c99", "-O1", "-I", HERE, "-o", exe, c_path])
            lines.append("编译：%s" % cc)
            lines.extend(cp.stdout.strip().splitlines())
            if cp.returncode != 0:
                raise SystemExit("error: host 编译失败\n" + cp.stdout)
            rp = run([exe])
            lines.append("运行：host 原生")
        else:
            clang = find_wasm_clang()
            node = shutil.which("node") or shutil.which("node.exe")
            if not clang or not node:
                raise SystemExit("error: 无 host C 编译器，且未找到 NDK clang / node；"
                                 "可用 NDK_CLANG=<clang 路径> 指定")
            wasm = os.path.join(work, "harness.wasm")
            cp = run([clang, "--target=wasm32", "-nostdlib", "-fno-builtin", "-O1",
                      "-DPID_CUT_TEST_STANDALONE", "-I", HERE,
                      "-Wl,--no-entry", "-Wl,--export-memory",
                      "-o", wasm, c_path])
            lines.append("编译：%s（wasm32）" % clang)
            lines.extend(cp.stdout.strip().splitlines())
            if cp.returncode != 0:
                raise SystemExit("error: wasm 编译失败\n" + cp.stdout)
            runner = os.path.join(work, "run.cjs")
            with open(runner, "w", encoding="utf-8") as fh:
                fh.write(NODE_RUNNER)
            rp = run([node, runner, wasm])
            lines.append("运行：node + wasm32")
        lines.extend(rp.stdout.strip().splitlines())
        out = "\n".join(lines)
        print(out)
        with open(LOG_PATH, "w", encoding="utf-8") as fh:
            fh.write(out + "\n")
        return rp.returncode
    finally:
        shutil.rmtree(work, ignore_errors=True)


if __name__ == "__main__":
    sys.exit(main())
