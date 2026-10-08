#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""B6X 温控参数定义 —— CI 校验脚本

定位：本文件**只做校验**，不含任何生成逻辑；来源清单（gen_params.SOURCES）与产物清单
（gen_params.PRODUCTS）一律从 gen_params 取，不在此重复声明第二份。

断言（任一不过即非 0 退出）：
  A 产物可复现：重跑生成逻辑，与落盘的 4 个产物必须一致（比较按换行归一化） → 退出 1
  B 产物自洽：56 键齐全、必需字段完整、min ≤ default/factory ≤ max、分组可解析 → 退出 1
  C 三源无漂移：与 profile.conf / 逻辑说明.md 参数表 / tempctrl.c 对账（含包名） → 退出 2
  D 产物形态自检：C 头括号配平、X 宏实参个数、tempctrl.c 格式串转换符 vs 实参、
    **层默认值表覆盖面**（PERF/SYSFS 每个守护进程取值位要么在表里、要么在显式白名单里；
    表内默认值与定义一致；总开关不入表）→ 退出 1
    （本机与 CI 均无 C 编译器，D 是编译期错误的替代检查）
  E 跨端对拍：编译 lsp模块/daemon/ki_cut.h 的宿主程序，比对 参数定义/ki_cut_golden.json
    → 不一致退出 1；本机无 C 编译器时跳过（CI 的 ubuntu 有 gcc，必跑）
  F 配置行缓冲护栏：load_config 的配置读行缓冲字节数 ≥ 「KI_CUT 满点数、最大字段宽」的单行
    长度（含行尾换行）→ 不足退出 1。**静态字面比对，不执行 C、不验运行时行为**

用法：
    python 参数定义/check_params.py
    python 参数定义/check_params.py --no-audit     # 只查产物（线 2 正在改 tempctrl.c 时临时用）

零第三方依赖（仅标准库）。

CI 接线（写入 .github/workflows/build.yml，本脚本不改该文件）：
    在「构建 LSPosed 模块」job 的 **checkout 之后、Gradle 编译之前**加一步
      - name: 校验参数定义产物
        run: python 参数定义/check_params.py
    （该步骤需在 tempctrl.c 与全部产物都已就位的工作树上运行；
      它同时充当 R1 要求的「生成后 git diff --exit-code」等价校验。）
"""

import argparse
import io
import json
import os
import re
import shutil
import subprocess
import sys
import tempfile

sys.dont_write_bytecode = True   # 不在 参数定义/ 里留 __pycache__（.gitignore 未覆盖它）
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gen_params  # noqa: E402  同目录模块，标准库路径规则即可导入

EXPECTED_KEY_COUNT = 55
VALID_TYPES = ("switch", "int", "multi", "path", "enum", "table")


class Failure(Exception):
    pass


def _rel(path):
    return os.path.relpath(path, gen_params.REPO).replace("\\", "/")


def fail_check_a(definition):
    """A 产物可复现：4 个产物逐一与重跑结果比较。"""
    notes = []
    for product in gen_params.PRODUCTS:
        path = gen_params.product_path(product)
        if not os.path.exists(path):
            raise Failure("产物不存在：%s（先跑 python 参数定义/gen_params.py）" % _rel(path))
        expected = gen_params.expected_product(product.id, definition)
        with io.open(path, "r", encoding="utf-8") as fh:
            actual = fh.read()
        if actual != expected:
            raise Failure("产物与定义不一致（手改过，或定义改了没重新生成）：%s" % _rel(path))
        notes.append("%s%s" % (product.path, "（区间）" if product.kind == "region" else ""))
    return "A 产物可复现：%d 个产物与定义一致（按换行归一化）—— %s" % (len(notes), " / ".join(notes))


def _num_ok(v):
    return isinstance(v, int) and not isinstance(v, bool)


def fail_check_b(definition):
    """B 产物自洽（不依赖生成逻辑，独立复核）。"""
    with io.open(gen_params.product_path(
            gen_params.product_by_id("params.json")), "r", encoding="utf-8") as fh:
        product = json.load(fh)

    keys = product["keys"]
    if len(keys) != EXPECTED_KEY_COUNT:
        raise Failure("键数 %d ≠ %d" % (len(keys), EXPECTED_KEY_COUNT))

    group_ids = [g["id"] for g in product["groups"]]
    master_of = {g["master"]: g["id"] for g in product["groups"] if g["master"]}
    members = set()
    for g in product["groups"]:
        if len(set(g["keys"])) != len(g["keys"]):
            raise Failure("分组 %s 的键列表有重复" % g["id"])
        members.update(g["keys"])
    if members != set(keys) - set(master_of):
        raise Failure("分组键列表与 keys 不一致：多 %s / 少 %s"
                      % (sorted(members - (set(keys) - set(master_of))),
                         sorted((set(keys) - set(master_of)) - members)))

    problems = []
    for name, k in keys.items():
        for field in ("key", "group", "role", "type", "label", "desc",
                      "unit", "unitNote", "default", "factory", "min", "max",
                      "requires", "daemonConsumes"):
            if field not in k:
                problems.append("%s 缺字段 %s" % (name, field))
        if k.get("key") != name:
            problems.append("%s 的 key 字段自相矛盾" % name)
        if k.get("group") not in group_ids:
            problems.append("%s 的分组 %r 不存在" % (name, k.get("group")))
        if k.get("type") not in VALID_TYPES:
            problems.append("%s 的类型 %r 非法" % (name, k.get("type")))
        if not isinstance(k.get("label"), str) or not k["label"].strip():
            problems.append("%s 的 label 为空" % name)
        if not isinstance(k.get("desc"), str) or not k["desc"].strip():
            problems.append("%s 的 desc 为空" % name)
        if not k.get("unit") and not k.get("unitNote"):
            problems.append("%s 无单位且未写 unitNote 说明原因" % name)
        for req in k.get("requires", []):
            if req not in keys:
                problems.append("%s 的前置键 %r 不存在" % (name, req))
        for hid in k.get("hiddenWhen", []):
            if hid not in keys:
                problems.append("%s 的隐藏条件键 %r 不存在" % (name, hid))
        if k.get("role") == "master" and master_of.get(name) != k.get("group"):
            problems.append("%s 标记为组头开关，但分组 %r 的 master 不是它"
                            % (name, k.get("group")))

        if k["type"] in ("int", "switch"):
            if not (_num_ok(k["min"]) and _num_ok(k["max"]) and k["min"] <= k["max"]):
                problems.append("%s 的 min/max 非法：%r/%r" % (name, k["min"], k["max"]))
            for f in ("default", "factory"):
                if not _num_ok(k[f]) or not (k["min"] <= k[f] <= k["max"]):
                    problems.append("%s 的 %s=%r 越出 [%r,%r]"
                                    % (name, f, k[f], k["min"], k["max"]))
        elif k["type"] == "multi":
            if k["min"] is not None or k["max"] is not None:
                problems.append("%s 为多值键，min/max 应为 null（范围逐字段给）" % name)
            if not k.get("rangeNote"):
                problems.append("%s 为多值键但缺 rangeNote" % name)
            fields = k.get("fields") or []
            if not fields:
                problems.append("%s 为多值键但 fields 为空" % name)
            if len(k["default"]) != len(fields) or len(k["factory"]) != len(fields):
                problems.append("%s 的默认值个数与 fields 个数不符" % name)
            for i, f in enumerate(fields):
                if not f.get("label"):
                    problems.append("%s 第 %d 字段缺 label" % (name, i + 1))
                if not f.get("unit") and not f.get("unitNote"):
                    problems.append("%s 第 %d 字段无单位且未写 unitNote" % (name, i + 1))
                if not (_num_ok(f["min"]) and _num_ok(f["max"]) and f["min"] <= f["max"]):
                    problems.append("%s 第 %d 字段 min/max 非法" % (name, i + 1))
                if not (f["min"] <= f["default"] <= f["max"]):
                    problems.append("%s 第 %d 字段 default=%r 越出 [%r,%r]"
                                    % (name, i + 1, f["default"], f["min"], f["max"]))
                if not (f["min"] <= k["default"][i] <= f["max"]):
                    problems.append("%s 第 %d 个默认值 %r 越出字段范围"
                                    % (name, i + 1, k["default"][i]))
                if not (f["min"] <= k["factory"][i] <= f["max"]):
                    problems.append("%s 第 %d 个出厂值 %r 越出字段范围"
                                    % (name, i + 1, k["factory"][i]))
        elif k["type"] == "table":
            # 表键：范围在 rowFields（逐字段），默认行在 defaultRows（逗号分隔，值个数须为字段数的整数倍）
            if k["min"] is not None or k["max"] is not None:
                problems.append("%s 为表键，min/max 应为 null（逐字段见 rowFields）" % name)
            if not k.get("rangeNote"):
                problems.append("%s 为表键但缺 rangeNote" % name)
            if not isinstance(k.get("rowPrefix"), str) or not k.get("rowPrefix"):
                problems.append("%s 为表键但缺 rowPrefix" % name)
            fields = k.get("rowFields") or []
            if not fields:
                problems.append("%s 为表键但 rowFields 为空" % name)
            for i, f in enumerate(fields):
                if not f.get("label"):
                    problems.append("%s 第 %d 字段缺 label" % (name, i + 1))
                if not f.get("unit") and not f.get("unitNote"):
                    problems.append("%s 第 %d 字段无单位且未写 unitNote" % (name, i + 1))
                if not (_num_ok(f.get("min")) and _num_ok(f.get("max")) and f["min"] <= f["max"]):
                    problems.append("%s 第 %d 字段 min/max 非法" % (name, i + 1))
            rows = k.get("defaultRows") or []
            if not rows:
                problems.append("%s 为表键但 defaultRows 为空" % name)
            nf = len(fields)
            for ri, row in enumerate(rows):
                if not isinstance(row, str) or not row.strip():
                    problems.append("%s 第 %d 个默认行不是非空字符串" % (name, ri + 1))
                    continue
                toks = row.split(",")
                if nf and len(toks) % nf != 0:
                    problems.append("%s 第 %d 个默认行的值个数 %d 不是字段数 %d 的整数倍"
                                    % (name, ri + 1, len(toks), nf))
                for j, tok in enumerate(toks):
                    s = tok.strip()
                    if not s and nf and fields[j % nf].get("allowEmpty"):
                        continue                 # 允许留空的字段：空 token 合法（= 该轴跳过此点）
                    if not re.fullmatch(r"-?\d+", s):
                        problems.append("%s 第 %d 个默认行第 %d 值 %r 非整数"
                                        % (name, ri + 1, j + 1, tok))
                        continue
                    if nf:
                        fld = fields[j % nf]
                        if not (fld["min"] <= int(s) <= fld["max"]):
                            problems.append("%s 第 %d 个默认行第 %d 值 %s 越出字段范围 [%s,%s]"
                                            % (name, ri + 1, j + 1, s, fld["min"], fld["max"]))
            for f in ("default", "factory"):
                if list(k[f] or []) != list(rows):
                    problems.append("%s 的 %s 应与 defaultRows 一致" % (name, f))
        elif k["type"] == "path":
            if k["min"] is not None or k["max"] is not None:
                problems.append("%s 为路径键，min/max 应为 null" % name)
            if not isinstance(k["default"], str) or not k["default"]:
                problems.append("%s 的默认值应为非空字符串" % name)
            if not k.get("rangeNote"):
                problems.append("%s 为路径键但缺 rangeNote" % name)
        elif k["type"] == "enum":
            # 文本枚举：值域由 options 给出（不是数值 range），default/factory 必须落在值域内。
            if k["min"] is not None or k["max"] is not None:
                problems.append("%s 为枚举键，min/max 应为 null（值域见 options）" % name)
            options = k.get("options") or []
            if not options:
                problems.append("%s 为枚举键但 options 为空" % name)
            values = []
            for i, opt in enumerate(options):
                if not isinstance(opt, dict):
                    problems.append("%s 第 %d 个选项不是对象" % (name, i + 1))
                    continue
                if not isinstance(opt.get("value"), str) or not opt["value"].strip():
                    problems.append("%s 第 %d 个选项缺 value" % (name, i + 1))
                    continue
                if not isinstance(opt.get("label"), str) or not opt["label"].strip():
                    problems.append("%s 第 %d 个选项缺 label" % (name, i + 1))
                if opt["value"] in values:
                    problems.append("%s 的 options 取值域重复：%r" % (name, opt["value"]))
                values.append(opt["value"])
            if values:
                for f in ("default", "factory"):
                    if k[f] not in values:
                        problems.append("%s 的 %s=%r 不在 options 取值域 %s 内"
                                        % (name, f, k[f], values))

    if problems:
        raise Failure("产物字段问题 %d 条：\n  - %s"
                      % (len(problems), "\n  - ".join(problems)))
    return "B 产物自洽：%d 键 / %d 分组，字段完整且默认值均落范围内" % (
        len(keys), len(product["groups"]))


# --------------------------------------------------------------------------
# D 产物形态自检（无 C 编译器 → 用静态检查替代编译期错误）
# --------------------------------------------------------------------------

def _strip_c_comments(text):
    """去掉 C 注释（字符串/字符字面量内的注释符号不误删）。"""
    out = []
    i = 0
    n = len(text)
    while i < n:
        ch = text[i]
        if ch == '"' or ch == "'":
            q = ch
            out.append(ch)
            i += 1
            while i < n:
                out.append(text[i])
                if text[i] == "\\":
                    if i + 1 < n:
                        out.append(text[i + 1])
                        i += 1
                elif text[i] == q:
                    i += 1
                    break
                i += 1
            continue
        if ch == "/" and i + 1 < n and text[i + 1] == "/":
            while i < n and text[i] != "\n":
                i += 1
            continue
        if ch == "/" and i + 1 < n and text[i + 1] == "*":
            i += 2
            while i + 1 < n and not (text[i] == "*" and text[i + 1] == "/"):
                i += 1
            i += 2
            continue
        out.append(ch)
        i += 1
    return "".join(out)


def _split_args(arg_text):
    """按顶层逗号切分实参（括号/方括号深度为 0 处）。"""
    args = []
    depth = 0
    cur = []
    i = 0
    n = len(arg_text)
    while i < n:
        ch = arg_text[i]
        if ch in "([{":
            depth += 1
        elif ch in ")]}":
            depth -= 1
        if ch == "," and depth == 0:
            args.append("".join(cur).strip())
            cur = []
        else:
            cur.append(ch)
        i += 1
    if "".join(cur).strip():
        args.append("".join(cur).strip())
    return args


def _call_args(text, open_paren):
    """从 '(' 处取配对实参文本。"""
    depth = 0
    i = open_paren
    while i < len(text):
        ch = text[i]
        if ch == "(":
            depth += 1
        elif ch == ")":
            depth -= 1
            if depth == 0:
                return text[open_paren + 1:i]
        i += 1
    return None


def fail_check_d(definition):
    """D 产物形态自检：C 头结构 + C 端格式串（无编译器时的替代检查）。"""
    notes = []

    # ---- D1 生成头：括号配平 + X 宏实参个数 ----
    h_path = gen_params.product_path(gen_params.product_by_id("c-header"))
    with io.open(h_path, "r", encoding="utf-8") as fh:
        h_text = fh.read()
    code = _strip_c_comments(h_text)
    for pair in (("(", ")"), ("{", "}"), ("[", "]")):
        if code.count(pair[0]) != code.count(pair[1]):
            raise Failure("D1 %s 括号不配平：%r %d 个 / %r %d 个"
                          % (_rel(h_path), pair[0], code.count(pair[0]),
                             pair[1], code.count(pair[1])))
    arity = {"CFG_PERF_INT_KEYS": 4, "CFG_SYSFS_KEYS": 7,
             "CFG_PERF_DEFAULTS": 2, "CFG_SYSFS_DEFAULTS": 2}
    for name in arity:
        rows = re.findall(r"(?m)^\s*X\((.*?)\)\s*\\?$", h_text)
        body = gen_params._block(h_text, r"#define\s+%s\(X\)" % name, r"(?m)^#define\s")
        rows = re.findall(r"(?m)^\s*X\((.*)\)\s*\\?$", body)
        if not rows:
            raise Failure("D1 %s 内没有 X(...) 行" % name)
        for row in rows:
            if len(_split_args(row)) != arity[name]:
                raise Failure("D1 %s 的 X 宏实参个数 %d ≠ 声明 %d：X(%s)"
                              % (name, len(_split_args(row)), arity[name], row))
    notes.append("头文件括号配平 / X 宏实参个数（%d 行）"
                 % sum(len(re.findall(r"(?m)^\s*X\(", gen_params._block(
                     h_text, r"#define\s+%s\(X\)" % n, r"(?m)^#define\s"))) for n in arity))

    # ---- D2 C 端格式串：转换符个数 vs 实参个数 ----
    c_path = gen_params.source_path(
        next(s for s in gen_params.SOURCES if s.id == "c"))
    with io.open(c_path, "r", encoding="utf-8") as fh:
        c_text = fh.read()
    str_macros = gen_params.parse_c_string_macros(c_text)
    code = _strip_c_comments(c_text)
    # 函数名 → 格式串所在实参序号（0 起）
    fmt_pos = {
        "write_log": 0, "pid_log": 0, "printf": 0,
        "debug_log": 1, "fprintf": 1, "sprintf": 1, "sscanf": 1, "fscanf": 1,
        "snprintf": 2, "asprintf": 1,
    }
    spec_re = re.compile(r"%[-+ #0']*(?:\*|\d+)?(?:\.(?:\*|\d+))?(?:hh|h|ll|l|j|z|t|L)?[diouxXeEfFgGaAcspn%]")
    checked = 0
    skipped = 0
    problems = []
    for m in re.finditer(r"\b(%s)\s*\(" % "|".join(fmt_pos), code):
        name = m.group(1)
        if re.search(r"#\s*define\s+%s\s*\(" % name, code[:m.start()].rsplit("\n", 1)[-1]):
            continue
        raw = _call_args(code, m.end() - 1)
        if raw is None:
            continue
        args = _split_args(raw)
        idx = fmt_pos[name]
        if len(args) <= idx:
            problems.append("%s 调用实参不足（%d 个）" % (name, len(args)))
            continue
        fmt_arg = args[idx]
        literal = None
        parts = re.findall(r'"((?:[^"\\]|\\.)*)"', fmt_arg)
        if parts and re.fullmatch(r'\s*(?:"(?:[^"\\]|\\.)*"\s*)+', fmt_arg):
            literal = "".join(parts)
        elif re.fullmatch(r"[A-Za-z_]\w*", fmt_arg) and fmt_arg in str_macros:
            literal = str_macros[fmt_arg]
        if literal is None:
            skipped += 1                 # 格式串是变量/拼接/跨宏，无法静态核对
            continue
        n_args = len(args) - (idx + 1)
        n_spec = 0
        for sm in spec_re.finditer(literal):
            if sm.group(0) == "%%":
                continue
            n_spec += 1 + sm.group(0).count("*")
        checked += 1
        if n_spec != n_args:
            line_no = code[:m.start()].count("\n") + 1
            problems.append("%s:%d %s 格式串需 %d 个参数，实际 %d 个：%s"
                            % (_rel(c_path), line_no, name, n_spec, n_args, literal))
    if problems:
        raise Failure("D2 格式串核对失败 %d 条：\n  - %s"
                      % (len(problems), "\n  - ".join(problems)))
    notes.append("C 格式串核对 %d 处（%d 处格式串非字面量已跳过）" % (checked, skipped))
    notes.append(fail_check_d3(definition, h_text, c_text))
    return "D 产物形态自检：%s" % "；".join(notes)


# --------------------------------------------------------------------------
# D3 层默认值表覆盖面（层开关 1→0 复位用）
# --------------------------------------------------------------------------

# 层 id → 生成头里的默认值表宏（须与 gen_params.build_c_header 写出的一致）
LAYER_DEFAULT_TABLES = {"perf": "CFG_PERF_DEFAULTS", "sysfs": "CFG_SYSFS_DEFAULTS"}

# 不进默认值表、由专段代码显式复位的路径键。目前只有 LOG_FILE：它由
# set_default_log_path() 按二进制名派生（私有目录不可用时兜底 /cache），
# 照抄 CFG_DEFAULT_LOG_FILE 会绕过兜底。
DEFAULT_TABLE_EXEMPT = ("LOG_FILE",)


def _fmt_default(val):
    """默认值在 C 表里的文本形态（bool 按 0/1 写，与 C 端 int 变量一致）。"""
    if isinstance(val, bool):
        return "1" if val else "0"
    return str(val)


def _default_table_rows(h_text, macro):
    """生成头里某张默认值表的行 → [(C 变量, 默认值文本)]。"""
    body = gen_params._block(h_text, r"#define\s+%s\(X\)" % macro, r"(?m)^#define\s")
    rows = []
    for m in re.finditer(r"(?m)^\s*X\((.*)\)\s*\\?$", body):
        args = _split_args(m.group(1))
        if len(args) != 2:
            raise Failure("D3 %s 的行不是 X(C 变量, 默认值)：X(%s)" % (macro, m.group(1)))
        rows.append((args[0], args[1]))
    return rows


def _c_function_blocks(text):
    """粗切 C 源的顶层「函数体」块（每块含它的签名行与收尾一行）。

    只用于把「某层的复位行」定位到「该层的复位函数」里：以行首的 `签名 {` 起、以行首 `}` 收。
    tempctrl.c 全篇用这一种大括号风格（收尾括号单独占行），故不解析语法。
    """
    blocks, cur, in_fn = [], [], False
    for line in text.splitlines():
        if not in_fn:
            if re.match(r"^(?:static\s+)?[A-Za-z_][\w \*]*\([^;{]*\)\s*\{\s*$", line):
                in_fn, cur = True, [line]
            continue
        cur.append(line)
        if line.startswith("}"):
            blocks.append("\n".join(cur))
            in_fn = False
    return blocks


def fail_check_d3(definition, h_text, c_text):
    """D3 层默认值表覆盖面与取值。

    作用：以后新增键若忘了我复位（没进默认值表），校验直接红，而不是静默漏掉；
    同时挡住"复位时把总开关一起复位"（PERF_ENABLED 默认 1，复位会立刻自我重开）。
    路径键不进默认值表（无 int 语义），其复位是 tempctrl.c 里的手写行，故单独核对
    「生成头有 CFG_DEFAULT_<键>」+「C 源里有该键的复位落点」两件事（只看前者会漏掉
    "宏在、复位行被删"——例如删掉 affinity_spec 的复位行，亲和会在层关闭后停在旧值）。
    """
    c_vars_all = definition.get("audit", {}).get("cVars", {})
    owner = {}          # C 变量 → [(键, 该取值位的默认值文本)]
    for e in definition["keys"]:
        if not e.get("daemonConsumes", True):
            continue
        c_vars = c_vars_all.get(e["key"]) or []
        fields = e.get("fields")
        for i, v in enumerate(c_vars):
            if not v:
                continue
            if fields and i < len(fields):
                val = fields[i]["default"]
            else:
                val = e["default"]
            owner.setdefault(v, []).append((e, _fmt_default(val)))

    problems = []
    counts = []
    for group, macro in LAYER_DEFAULT_TABLES.items():
        rows = _default_table_rows(h_text, macro)
        table_vars = [v for v, _ in rows]
        if len(set(table_vars)) != len(table_vars):
            problems.append("D3 %s 内 C 变量重复出现" % macro)

        # 该层应当进表的取值位（int 口径）；路径键走白名单 / CFG_DEFAULT_*，不进表
        expect = []
        paths = []
        for e in definition["keys"]:
            if e["group"] != group or e["role"] == "master":
                continue            # 总开关自身不复位
            if not e.get("daemonConsumes", True):
                continue
            if e["type"] == "path":
                paths.append(e["key"])
                continue
            for i, v in enumerate(c_vars_all.get(e["key"]) or []):
                if v is None:
                    problems.append("D3 %s 的取值位 %d 在 audit.cVars 里为空，运行时无法复位"
                                    % (e["key"], i + 1))
                else:
                    expect.append(v)

        missing = [v for v in expect if v not in table_vars]
        if missing:
            problems.append("D3 %s 漏了取值位（新增键后忘了纳入默认值表）：%s" % (macro, missing))
        extra = [v for v in table_vars if v not in expect]
        if extra:
            problems.append("D3 %s 含非本层取值位：%s" % (macro, extra))
        # 本层的复位函数 = 展开本层默认值表的那个函数（与 int 取值位同源，不另立名册）
        layer_fn = next((b for b in _c_function_blocks(c_text) if macro in b), None)
        for key in paths:
            if key in DEFAULT_TABLE_EXEMPT:
                continue
            if "#define CFG_DEFAULT_%s " % key not in h_text:
                problems.append("D3 %s 为路径键，既不在默认值表、也不在白名单 %s，"
                                "且生成头里没有 CFG_DEFAULT_%s"
                                % (key, list(DEFAULT_TABLE_EXEMPT), key))
                continue
            # 复位落点：路径键的复位是手写行（不进默认值表），必须能在**本层复位函数内**看到
            # 「C 变量与 CFG_DEFAULT_<键> 同一行」的赋值。只查宏存在（或只查"全文件出现过"）
            # 会漏掉"复位行被删"——层开关 1→0 时该键就停在旧值，正是默认值表那条路靠 D3 挡住的。
            cvars = [v for v in (c_vars_all.get(key) or []) if v]
            if not cvars:
                problems.append("D3 %s 为路径键但 audit.cVars 未给 C 变量，无法核对复位落点" % key)
                continue
            if layer_fn is None:
                scope, where = c_text, "tempctrl.c 内"
            else:
                scope, where = layer_fn, "该层复位函数（展开 %s 的那个）内" % macro
            for cvar in cvars:
                if not any(("CFG_DEFAULT_%s" % key) in line and cvar in line
                           for line in scope.splitlines()):
                    problems.append("D3 %s 的复位在%s没找到（应为同一行同时出现 %s 与 "
                                    "CFG_DEFAULT_%s 的赋值，如 strncpy(%s, CFG_DEFAULT_%s, ...)；"
                                    "只把默认值写进生成头、或只在别处写过一次，都不算本层复位）"
                                    % (key, where, cvar, key, cvar, key))

        # 总开关 / 跨层变量不得进表；表内默认值必须等于定义
        for v, got in rows:
            slots = owner.get(v)
            if not slots:
                problems.append("D3 %s 的 C 变量 %s 在 audit.cVars 里查不到归属" % (macro, v))
                continue
            for e, expect_default in slots:
                if e["role"] == "master":
                    problems.append("D3 %s 含总开关 %s（键 %s）：复位它会让该层立刻自我重开"
                                    % (macro, v, e["key"]))
                elif e["group"] != group:
                    problems.append("D3 %s 含跨层变量 %s（属 %s 层键 %s）"
                                    % (macro, v, e["group"], e["key"]))
                if got != expect_default:
                    problems.append("D3 %s 的 %s 默认值 %s ≠ 定义 %s（键 %s）"
                                    % (macro, v, got, expect_default, e["key"]))
        counts.append("%s %d 位" % (macro, len(rows)))

    for key in DEFAULT_TABLE_EXEMPT:
        e = next((x for x in definition["keys"] if x["key"] == key), None)
        if e is None or e["type"] != "path" or not e.get("daemonConsumes", True):
            problems.append("D3 白名单 DEFAULT_TABLE_EXEMPT 的 %s 不是守护进程消费的路径键" % key)

    if problems:
        raise Failure("D3 默认值表覆盖面失败 %d 条：\n  - %s"
                      % (len(problems), "\n  - ".join(problems)))
    return ("D3 默认值表覆盖面（%s；路径键 %s 单独处理、其余路径键逐键核对"
            "「本层复位函数内有 CFG_DEFAULT_* 复位行」，各层总开关均不在表内）"
            % (" / ".join(counts), "、".join(DEFAULT_TABLE_EXEMPT)))


# --------------------------------------------------------------------------
# E 跨端对拍：lsp模块/daemon/ki_cut.h 求值实现 vs 参数定义/ki_cut_golden.json
# --------------------------------------------------------------------------

def _pt_literal(p):
    """golden 的一个点 [冷值, KDP, 升, 降] → C 聚合初始化 {cold, kdp, up, dn, skip}。
    三个倍率字段为 null 表示该轴留空（置对应 skip 位），值填 KI_CUT_NONE 占位（求值时按 skip 跳过）。
    冷值是横坐标、必填，不可为 null。"""
    if len(p) != 4:
        raise Failure("golden 用例的点应为 [冷值,KDP,升,降] 四元：%r" % (p,))
    cold = p[0]
    if cold is None:
        raise Failure("golden 用例的冷值不可为 null（冷值必填）：%r" % (p,))
    vals = []
    skip = 0
    for i, v in enumerate(p[1:4]):
        if v is None:
            skip |= (1 << i)                 # bit0=KDP、bit1=升、bit2=降，对应 KI_CUT_SKIP_*
            vals.append("KI_CUT_NONE")
        else:
            vals.append(str(int(v)))
    return "{%d,%s,%d}" % (cold, ",".join(vals), skip)


def _build_harness(cases):
    """由 golden 用例现写一个宿主 C 程序（内含 ki_cut.h，逐条求值并按序打印）。"""
    lines = ["#include <stdio.h>", '#include "ki_cut.h"', ""]
    for ci, case in enumerate(cases):
        clusters = case["clusters"]
        for gi, cl in enumerate(clusters):
            pts = ", ".join(_pt_literal(p) for p in cl)
            lines.append("static const KiCutPoint c{0}_{1}[] = {{{2}}};".format(ci, gi, pts))
        if clusters:
            inits = ", ".join("{{c{0}_{1}, {2}}}".format(ci, gi, len(cl))
                              for gi, cl in enumerate(clusters))
            lines.append("static const KiCutCluster cs{0}[] = {{{1}}};".format(ci, inits))
    lines.append("")
    lines.append("int main(void) {")
    lines.append("    float kdp, up, dn;")
    for ci, case in enumerate(cases):
        clusters = case["clusters"]
        ptr = "cs%d" % ci if clusters else "0"
        lines.append("    ki_cut_eval({0}, {1}, {2}, &kdp, &up, &dn);".format(
            ptr, len(clusters), case["cold"]))
        lines.append('    printf("{0} %.6f %.6f %.6f\\n", kdp, up, dn);'.format(ci))
    lines.append("    return 0;")
    lines.append("}")
    return "\n".join(lines) + "\n"


def fail_check_e(definition):
    """E 跨端对拍（CI 上运行）：编译 ki_cut.h 的宿主程序，逐条比对 golden 期望值。

    本机无 C 编译器（cc/gcc/clang 全无）时**跳过、不失败**；CI（ubuntu 有 gcc）必跑。
    对拍程序与临时文件都写在临时目录，不改动仓库任何文件。
    """
    golden_path = os.path.join(gen_params.REPO, "参数定义", "ki_cut_golden.json")
    header_path = os.path.join(gen_params.REPO, "lsp模块", "daemon", "ki_cut.h")
    if not os.path.exists(golden_path):
        raise Failure("E 缺少 golden 文件：%s（跨端对拍需它）" % _rel(golden_path))
    if not os.path.exists(header_path):
        raise Failure("E 缺少求值头：%s" % _rel(header_path))

    cc = next((shutil.which(c) for c in ("cc", "gcc", "clang") if shutil.which(c)), None)
    if not cc:
        return ("E 跨端对拍：本机无 C 编译器（cc/gcc/clang），已跳过"
                "（CI 的 ubuntu 上由 gcc 执行；golden 见 %s）" % _rel(golden_path))

    with io.open(golden_path, "r", encoding="utf-8") as fh:
        golden = json.load(fh)
    tol = float(golden.get("tolerance", 0.02))
    cases = golden["cases"]

    tmpd = tempfile.mkdtemp(prefix="kicut_")
    try:
        cfile = os.path.join(tmpd, "harness.c")
        exe = os.path.join(tmpd, "harness")
        with io.open(cfile, "w", encoding="utf-8", newline="\n") as fh:
            fh.write(_build_harness(cases))
        cp = subprocess.run([cc, "-O2", "-std=c99", "-I", os.path.dirname(header_path),
                             "-o", exe, cfile], capture_output=True, text=True)
        if cp.returncode != 0:
            raise Failure("E 对拍程序编译失败：\n%s\n%s" % (cp.stdout, cp.stderr))
        cp = subprocess.run([exe], capture_output=True, text=True)
        if cp.returncode != 0:
            raise Failure("E 对拍程序运行失败：\n%s\n%s" % (cp.stdout, cp.stderr))

        bad = []
        seen = 0
        for line in cp.stdout.splitlines():
            line = line.strip()
            if not line:
                continue
            idx_s, kdp_s, up_s, dn_s = line.split()
            case = cases[int(idx_s)]
            seen += 1
            if (abs(float(kdp_s) - case["kdp"]) > tol
                    or abs(float(up_s) - case["up"]) > tol
                    or abs(float(dn_s) - case["dn"]) > tol):
                bad.append("%s：C=(%s,%s,%s) ≠ golden=(%s,%s,%s)"
                           % (case["name"], kdp_s, up_s, dn_s,
                              case["kdp"], case["up"], case["dn"]))
        if seen != len(cases):
            raise Failure("E 对拍程序输出 %d 行 ≠ 用例 %d 条" % (seen, len(cases)))
        if bad:
            raise Failure("E 跨端对拍失败 %d 条：\n  - %s" % (len(bad), "\n  - ".join(bad)))
        return ("E 跨端对拍：%s 的求值与 %s 的 %d 组用例一致（容差 %g）"
                % (_rel(header_path), _rel(golden_path), len(cases), tol))
    finally:
        shutil.rmtree(tmpd, ignore_errors=True)


def fail_check_f(definition):
    """F 配置行缓冲护栏（**静态字面比对，非运行时执行**）。

    绑定两处字面量：`tempctrl.c` 中 `load_config` 的配置读行缓冲字节数，与 `ki_cut.h` 的
    `KI_CUT_MAX_POINTS`；断言前者足以容纳「满点数、最大字段宽」的 `KI_CUT_<n>` 单行（含换行）。
    目的是防止将来单独调大 `KI_CUT_MAX_POINTS`（或字段上限）而漏改缓冲，重演 fgets 截断。
    抓取方式：从 `load_config` 函数起点之后取首个 `char line[N]`；任一字面量抓不到即**失败**（不静默放过）。
    """
    h_path = gen_params.product_path(gen_params.product_by_id("c-header"))
    c_path = gen_params.source_path(
        next(s for s in gen_params.SOURCES if s.id == "c"))
    ki_path = os.path.join(gen_params.REPO, "lsp模块", "daemon", "ki_cut.h")
    with io.open(h_path, "r", encoding="utf-8") as fh:
        h_text = fh.read()
    with io.open(c_path, "r", encoding="utf-8") as fh:
        c_text = fh.read()
    if not os.path.exists(ki_path):
        raise Failure("F 未找到 ki_cut.h（%s）" % _rel(ki_path))
    with io.open(ki_path, "r", encoding="utf-8") as fh:
        ki_text = fh.read()

    def _macro_int(name, text, where):
        m = re.search(r"#define\s+%s\s+(\d+)" % re.escape(name), text)
        if not m:
            raise Failure("F 未找到宏 %s（%s；静态护栏依赖其字面量）" % (name, where))
        return int(m.group(1))

    max_points = _macro_int("KI_CUT_MAX_POINTS", ki_text, "ki_cut.h")

    mfn = re.search(r"static\s+\w+\s+load_config\s*\([^)]*\)\s*\{", c_text)
    if not mfn:
        raise Failure("F 未找到 load_config 定义，无法取配置读行缓冲大小")
    mbuf = re.search(r"char\s+line\s*\[\s*(\d+)\s*\]", c_text[mfn.end():])
    if not mbuf:
        raise Failure("F load_config 内未找到 char line[N] 配置行缓冲")
    buf = int(mbuf.group(1))

    mpfx = re.search(r'#define\s+CFG_ROW_PREFIX_PID_CUT\s+"([^"]*)"', h_text)
    if not mpfx:
        raise Failure("F 未找到 CFG_ROW_PREFIX_PID_CUT（params_generated.h）")
    pfx = mpfx.group(1)
    f1 = _macro_int("CFG_MAX_PID_CUT_F1", h_text, "params_generated.h")
    f2 = _macro_int("CFG_MAX_PID_CUT_F2", h_text, "params_generated.h")
    f3 = _macro_int("CFG_MAX_PID_CUT_F3", h_text, "params_generated.h")
    f4 = _macro_int("CFG_MAX_PID_CUT_F4", h_text, "params_generated.h")
    max_cluster = _macro_int("KI_CUT_MAX_CLUSTERS", c_text, "tempctrl.c")

    quad = "%d,%d,%d,%d" % (f1, f2, f3, f4)
    need = len("%s%d=%s\n" % (pfx, max_cluster, ",".join([quad] * max_points)))
    if buf - 1 < need:                     # fgets 最多读 buf-1 字节
        raise Failure(
            "F 配置行缓冲 char line[%d] 不足：PID_CUT 满 %d 点行最长 %d 字节（含换行），"
            "load_config 会截断整行 → 请同步放宽其 char line[]" % (buf, max_points, need))
    return ("F 配置行缓冲静态护栏：load_config char line[%d] ≥ PID_CUT 满 %d 点最长行 %d 字节"
            "（静态字面比对，非运行时执行）" % (buf, max_points, need))


def main(argv=None):
    ap = argparse.ArgumentParser(description="B6X 参数定义 CI 校验")
    ap.add_argument("--no-audit", action="store_true",
                    help="跳过三源漂移审计（线 2 正在改 tempctrl.c 时临时用）")
    args = ap.parse_args(argv)

    try:
        definition = gen_params.load_def()
    except Exception as exc:  # noqa: BLE001
        print("[FAIL] 定义文件不可读：%s" % exc)
        return 1

    try:
        print("[PASS] " + fail_check_a(definition))
        print("[PASS] " + fail_check_b(definition))
        print("[PASS] " + fail_check_d(definition))
        print("[PASS] " + fail_check_e(definition))
        print("[PASS] " + fail_check_f(definition))
    except Failure as exc:
        print("[FAIL] " + str(exc))
        return 1

    sources = " / ".join(s.path for s in gen_params.SOURCES)
    if args.no_audit:
        print("[SKIP] 三源漂移审计（--no-audit）：%s" % sources)
        return 0

    findings = gen_params.audit(definition)
    errors = [t for lvl, t in findings if lvl == "ERROR"]
    for t in errors:
        print("[FAIL] " + t)
    if errors:
        print("[FAIL] C 三源漂移 %d 条" % len(errors))
        return 2
    print("[PASS] C 三源无漂移（%s）" % sources)
    return 0


if __name__ == "__main__":
    sys.exit(main())
