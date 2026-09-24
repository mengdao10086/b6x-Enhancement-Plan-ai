#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""B6X 温控参数定义 —— CI 校验脚本

定位：本文件**只做校验**，不含任何生成逻辑；来源清单（gen_params.SOURCES）与产物清单
（gen_params.PRODUCTS）一律从 gen_params 取，不在此重复声明第二份。

断言（任一不过即非 0 退出）：
  A 产物可复现：重跑生成逻辑，与落盘的 4 个产物必须一致（比较按换行归一化） → 退出 1
  B 产物自洽：55 键齐全、必需字段完整、min ≤ default/factory ≤ max、分组可解析 → 退出 1
  C 三源无漂移：与 profile.conf / 逻辑说明.md 参数表 / tempctrl.c 对账（含包名） → 退出 2
  D 产物形态自检：C 头括号配平、X 宏实参个数、tempctrl.c 格式串转换符 vs 实参 → 退出 1
    （本机与 CI 均无 C 编译器，D 是编译期错误的替代检查）

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
import sys

sys.dont_write_bytecode = True   # 不在 参数定义/ 里留 __pycache__（.gitignore 未覆盖它）
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gen_params  # noqa: E402  同目录模块，标准库路径规则即可导入

EXPECTED_KEY_COUNT = 55
VALID_TYPES = ("switch", "int", "multi", "path", "enum")


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
    arity = {"CFG_PERF_INT_KEYS": 4, "CFG_SYSFS_KEYS": 7}
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
    return "D 产物形态自检：%s" % "；".join(notes)


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
