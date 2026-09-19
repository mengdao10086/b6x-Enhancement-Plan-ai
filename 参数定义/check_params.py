#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""B6X 温控参数定义 —— CI 校验脚本

断言（任一不过即非 0 退出）：
  A 产物可复现：重跑生成逻辑，与落盘的 assets/params.json 必须逐字节一致   → 退出 1
  B 产物自洽：52 键齐全、必需字段完整、min ≤ default/factory ≤ max、分组可解析 → 退出 1
  C 四源无漂移：与 schema.js / profile.conf / 逻辑说明.md / tempctrl.c 对账     → 退出 2

用法：
    python 参数定义/check_params.py
    python 参数定义/check_params.py --no-audit     # 只查产物（线 A 正在改 tempctrl.c 时临时用）

零第三方依赖（仅标准库）。

CI 接线（写入 .github/workflows/build.yml，本脚本不改该文件）：
    在「构建 LSPosed 模块」job 的 **checkout 之后、Gradle 编译之前**加一步
      - name: 校验参数定义产物
        run: python 参数定义/check_params.py
    （该步骤需在 tempctrl.c 与 assets/params.json 都已就位的工作树上运行；
      它同时充当 R1 要求的「生成后 git diff --exit-code」等价校验。）
"""

import argparse
import io
import json
import os
import sys

sys.dont_write_bytecode = True   # 不在 参数定义/ 里留 __pycache__（.gitignore 未覆盖它）
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import gen_params  # noqa: E402  同目录模块，标准库路径规则即可导入

EXPECTED_KEY_COUNT = 52
VALID_TYPES = ("switch", "int", "multi", "path")


class Failure(Exception):
    pass


def fail_check_a(definition):
    """A 产物可复现。"""
    path = gen_params.product_path(definition)
    expected = gen_params.render(gen_params.build_product(definition))
    if not os.path.exists(path):
        raise Failure("产物不存在：%s（先跑 python 参数定义/gen_params.py）" % path)
    with io.open(path, "r", encoding="utf-8") as fh:
        actual = fh.read()
    if actual != expected:
        raise Failure("产物与定义不一致（手改过 params.json，或定义改了没重新生成）：%s" % path)
    return "A 产物可复现：%s 与定义逐字节一致" % (
        os.path.relpath(path, gen_params.REPO).replace("\\", "/"))


def _num_ok(v):
    return isinstance(v, int) and not isinstance(v, bool)


def fail_check_b(definition):
    """B 产物自洽（不依赖生成逻辑，独立复核）。"""
    with io.open(gen_params.product_path(definition), "r", encoding="utf-8") as fh:
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

    if problems:
        raise Failure("产物字段问题 %d 条：\n  - %s"
                      % (len(problems), "\n  - ".join(problems)))
    return "B 产物自洽：%d 键 / %d 分组，字段完整且默认值均落范围内" % (
        len(keys), len(product["groups"]))


def main(argv=None):
    ap = argparse.ArgumentParser(description="B6X 参数定义 CI 校验")
    ap.add_argument("--no-audit", action="store_true",
                    help="跳过四源漂移审计（线 A 正在改 tempctrl.c 时临时用）")
    args = ap.parse_args(argv)

    try:
        definition = gen_params.load_def()
    except Exception as exc:  # noqa: BLE001
        print("[FAIL] 定义文件不可读：%s" % exc)
        return 1

    try:
        print("[PASS] " + fail_check_a(definition))
        print("[PASS] " + fail_check_b(definition))
    except Failure as exc:
        print("[FAIL] " + str(exc))
        return 1

    if args.no_audit:
        print("[SKIP] 四源漂移审计（--no-audit）")
        return 0

    findings = gen_params.audit(definition, verbose=False)
    errors = [t for lvl, t in findings if lvl == "ERROR"]
    for t in errors:
        print("[FAIL] " + t)
    if errors:
        print("[FAIL] C 四源漂移 %d 条" % len(errors))
        return 2
    print("[PASS] C 四源无漂移（schema.js / profile.conf / 逻辑说明.md / tempctrl.c）")
    return 0


if __name__ == "__main__":
    sys.exit(main())
