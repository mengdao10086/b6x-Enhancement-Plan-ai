#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""B6X 温控参数定义 —— 生成脚本（R1 单一来源）

用法：
    python 参数定义/gen_params.py              # 生成 assets/params.json（幂等）
    python 参数定义/gen_params.py --audit      # 只做四源漂移审计，不写文件（漂移则退出 2）
    python 参数定义/gen_params.py --audit --quiet

来源：参数定义/params.def.json（唯一手写处）
产物：lsp模块(apk修复+温控接口)/app/src/main/assets/params.json

零第三方依赖（仅标准库）。定位 C 侧信息一律用「函数名 / 键名 / 表名 + 关键判据」，
不写死行号（本工程索引行号恒比工作树小 1，行号不可靠）。
"""

import argparse
import io
import json
import os
import re
import sys

HERE = os.path.dirname(os.path.abspath(__file__))
REPO = os.path.dirname(HERE)

DEF_PATH = os.path.join(HERE, "params.def.json")
PRODUCT_REL_DEFAULT = "lsp模块(apk修复+温控接口)/app/src/main/assets/params.json"

MAGISK_DIR = os.path.join(REPO, "magisk模块(智能温控)")
C_PATH = os.path.join(MAGISK_DIR, "tempctrl.c")
CONF_PATH = os.path.join(MAGISK_DIR, "magisk模块框架", "profile.conf")
SCHEMA_PATH = os.path.join(MAGISK_DIR, "magisk模块框架", "webroot", "schema.js")
DOC_PATH = os.path.join(MAGISK_DIR, "逻辑说明.md")

REQUIRED_KEY_FIELDS = (
    "key", "group", "role", "type", "label", "desc",
    "unit", "default", "factory", "min", "max", "requires",
    "daemonConsumes", "fields",
)


def read_text(path):
    with io.open(path, "r", encoding="utf-8") as fh:
        return fh.read()


def load_def():
    return json.loads(read_text(DEF_PATH))


# --------------------------------------------------------------------------
# 产物构建
# --------------------------------------------------------------------------

def _field_product(field):
    out = {
        "label": field["label"],
        "unit": field.get("unit", ""),
    }
    if field.get("unitNote"):
        out["unitNote"] = field["unitNote"]
    out["min"] = field["min"]
    out["max"] = field["max"]
    out["default"] = field["default"]
    return out


def build_product(definition):
    """由定义构建界面消费的 params.json（键序完全由定义决定，保证幂等）。"""
    keys_out = {}
    for entry in definition["keys"]:
        item = {
            "key": entry["key"],
            "group": entry["group"],
            "role": entry["role"],
            "type": entry["type"],
            "label": entry["label"],
            "desc": entry["desc"],
            "unit": entry["unit"],
            "unitNote": entry.get("unitNote", ""),
            "default": entry["default"],
            "factory": entry["factory"],
            "min": entry["min"],
            "max": entry["max"],
            "requires": list(entry.get("requires", [])),
            "daemonConsumes": bool(entry.get("daemonConsumes", True)),
        }
        for opt in ("defaultNote", "factoryNote", "rangeNote"):
            if entry.get(opt):
                item[opt] = entry[opt]
        fields = entry.get("fields")
        item["fields"] = [_field_product(f) for f in fields] if fields else None
        keys_out[entry["key"]] = item

    groups_out = []
    for group in definition["groups"]:
        members = [e["key"] for e in definition["keys"]
                   if e["group"] == group["id"] and e["role"] != "master"]
        groups_out.append({
            "id": group["id"],
            "title": group["title"],
            "master": group["master"],
            "keys": members,
        })

    chart = definition["chart"]
    return {
        "formatVersion": definition["meta"]["productFormatVersion"],
        "moduleId": definition["meta"]["moduleId"],
        "configFileName": definition["meta"]["configFileName"],
        "generatedFrom": "参数定义/params.def.json",
        "chart": {
            "windowOptionsSec": list(chart["windowOptionsSec"]),
            "windowDefaultSec": chart["windowDefaultSec"],
            "rollingMaxLines": chart["rollingMaxLines"],
        },
        "groups": groups_out,
        "keys": keys_out,
    }


def render(product):
    return json.dumps(product, ensure_ascii=False, indent=2) + "\n"


def product_path(definition):
    return os.path.join(REPO, definition["meta"]["productPath"]
                        if definition["meta"].get("productPath") else PRODUCT_REL_DEFAULT)


def write_product(definition):
    path = product_path(definition)
    text = render(build_product(definition))
    changed = True
    if os.path.exists(path):
        changed = read_text(path) != text
    if changed:
        d = os.path.dirname(path)
        if not os.path.isdir(d):
            os.makedirs(d)
        with io.open(path, "w", encoding="utf-8", newline="\n") as fh:
            fh.write(text)
    return path, changed, text


# --------------------------------------------------------------------------
# 四源审计：定位一律用「函数名 / 表名 / 键名」判据，不用行号
# --------------------------------------------------------------------------

def _block(text, start_pat, stop_pat):
    """从匹配 start_pat 处起，截到下一个匹配 stop_pat 处，返回块文本。"""
    m = re.search(start_pat, text)
    if not m:
        return ""
    rest = text[m.end():]
    m2 = re.search(stop_pat, rest)
    return rest[:m2.start()] if m2 else rest


def _func_body(text, func_name):
    """按函数名取函数体（从 `func_name(` 的定义起，到下一个顶层 `}`）。"""
    m = re.search(r"\b%s\s*\([^;{]*\)\s*\{" % re.escape(func_name), text)
    if not m:
        return ""
    depth = 1
    i = m.end()
    while i < len(text) and depth:
        if text[i] == "{":
            depth += 1
        elif text[i] == "}":
            depth -= 1
        i += 1
    return text[m.end():i]


def parse_c_macros(c_text):
    macros = {}
    for m in re.finditer(r"^#define\s+(\w+)\s+([0-9]+)\s*(?://.*)?$", c_text, re.M):
        macros[m.group(1)] = m.group(2)
    return macros


def parse_c_string_macros(c_text):
    """单行 `#define NAME "value"` → {NAME: value}。

    只认**单行、无续行反斜杠、无拼接**的字面量。跨行/拼接宏一律不收，
    由调用方报「无法自动核对」，避免脆弱解析给出假通过。
    """
    macros = {}
    for m in re.finditer(r'^#define\s+(\w+)\s+"([^"\\]*)"\s*(?://.*)?$', c_text, re.M):
        macros[m.group(1)] = m.group(2)
    return macros


def parse_gradle_application_id(gradle_text):
    m = re.search(r'^\s*applicationId\s*=\s*"([^"]+)"', gradle_text, re.M)
    return m.group(1) if m else None


def parse_c_keys(c_text):
    """C 端实际解析的配置键集合 + 各键出处。"""
    found = {}

    table = _block(c_text, r"INT_CFG_KEYS\s*\[\s*\]\s*=\s*\{", r"\n\};")
    for m in re.finditer(r'\{\s*"([A-Z0-9_]+)"\s*,\s*&(\w+)\s*,\s*'
                         r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*\}', table):
        found[m.group(1)] = "INT_CFG_KEYS"

    for func in ("parse_debug_cfg", "parse_sysfs_cfg", "parse_pid_cfg",
                 "parse_common_cfg", "load_config"):
        body = _func_body(c_text, func)
        for m in re.finditer(r'strcmp\(\s*key\s*,\s*"([A-Z0-9_]+)"\s*\)', body):
            found.setdefault(m.group(1), func)

    sysfs_body = _func_body(c_text, "is_sysfs_key")
    found["__is_sysfs_key__"] = set(
        m.group(1) for m in re.finditer(r'strcmp\(\s*key\s*,\s*"([A-Z0-9_]+)"\s*\)', sysfs_body))
    return found


def parse_c_defaults(c_text):
    """static/局部 int 与 char[] 初值 → {var: 初值文本}。"""
    defaults = {}
    pat = re.compile(r"(?m)^\s*(?:static\s+)?(?:const\s+)?(?:int|char)\s+(\w+)\s*"
                     r"(?:\[[^\]]*\])?\s*=\s*([^;]+);")
    for m in pat.finditer(c_text):
        var, raw = m.group(1), m.group(2).strip()
        if raw.startswith('"'):
            q = re.search(r'"([^"]*)"', raw)
            defaults.setdefault(var, q.group(1) if q else "")
        else:
            num = re.match(r"^-?\d+$", raw)
            if num:
                defaults.setdefault(var, raw)
    return defaults


def parse_c_ranges(c_text, macros):
    """C 端各变量的 clamp / 表内范围 → {var: set((lo, hi))}（宏名就地展开）。"""
    ranges = {}

    def resolve(tok):
        tok = tok.strip()
        if re.match(r"^-?\d+$", tok):
            return int(tok)
        if tok in macros:
            return int(macros[tok])
        return None

    table = _block(c_text, r"INT_CFG_KEYS\s*\[\s*\]\s*=\s*\{", r"\n\};")
    for m in re.finditer(r'\{\s*"([A-Z0-9_]+)"\s*,\s*&(\w+)\s*,\s*'
                         r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*\}', table):
        lo, hi = resolve(m.group(3)), resolve(m.group(4))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(2), set()).add((lo, hi))

    for m in re.finditer(r"(\w+)\s*=\s*clamp\(\s*[^,]+,\s*([A-Za-z_0-9]+)\s*,"
                         r"\s*([A-Za-z_0-9]+)\s*\)", c_text):
        lo, hi = resolve(m.group(2)), resolve(m.group(3))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(1), set()).add((lo, hi))
    return ranges


def parse_conf_keys(conf_text):
    keys = []
    for line in conf_text.splitlines():
        s = line.strip()
        if not s or s.startswith("#") or "=" not in s:
            continue
        keys.append(s.split("=", 1)[0].strip())
    return keys


def parse_schema_keys(schema_text):
    body = _block(schema_text, r"keys\s*:\s*\{", r"\n\s*\},\s*\n")
    keys = [m.group(1) for m in re.finditer(r'^ {4}([A-Z][A-Z0-9_]*)\s*:\s*\{',
                                            body, re.M)]
    return keys


def parse_doc_keys(doc_text):
    """定位参数表：找表头行（含「参数」「默认值」「说明」），再收 52 行键行。"""
    lines = doc_text.splitlines()
    start = None
    for i, line in enumerate(lines):
        if "默认值" in line and "说明" in line and line.lstrip().startswith("|"):
            start = i + 2  # 跳过表头与其下的分隔行
            break
    if start is None:
        return []
    keys = []
    for line in lines[start:]:
        if not line.lstrip().startswith("|"):
            break
        m = re.match(r"\|\s*`([A-Z0-9_]+)`", line)
        if not m:
            break
        keys.append(m.group(1))
    return keys


def audit(definition, repo_paths=None, verbose=True):
    """四源漂移审计。返回 findings 列表；每项 (级别, 文本)，级别 ∈ ERROR/INFO。"""
    paths = repo_paths or {}
    c_path = paths.get("c", C_PATH)
    conf_path = paths.get("conf", CONF_PATH)
    schema_path = paths.get("schema", SCHEMA_PATH)
    doc_path = paths.get("doc", DOC_PATH)

    findings = []
    def err(msg):
        findings.append(("ERROR", msg))
    def info(msg):
        findings.append(("INFO", msg))

    entries = definition["keys"]
    def_keys = [e["key"] for e in entries]
    daemon_keys = [e["key"] for e in entries if e.get("daemonConsumes", True)]
    webui_keys = [e["key"] for e in entries if not e.get("daemonConsumes", True)]

    missing_files = [p for p in (c_path, conf_path, schema_path, doc_path)
                     if not os.path.exists(p)]
    for p in missing_files:
        info("来源文件不存在，跳过对应核对：%s" % p)

    # ---- 1. 四份来源的键集合 ----
    if os.path.exists(conf_path):
        conf_keys = parse_conf_keys(read_text(conf_path))
        if conf_keys != def_keys:
            err("profile.conf 键集合/顺序与定义不一致：多 %s / 少 %s / 顺序不同 %s"
                % (sorted(set(conf_keys) - set(def_keys)),
                   sorted(set(def_keys) - set(conf_keys)),
                   conf_keys != def_keys and not (set(conf_keys) ^ set(def_keys))))
    if os.path.exists(schema_path):
        schema_keys = parse_schema_keys(read_text(schema_path))
        if set(schema_keys) != set(def_keys):
            err("schema.js keys 与定义不一致：多 %s / 少 %s"
                % (sorted(set(schema_keys) - set(def_keys)),
                   sorted(set(def_keys) - set(schema_keys))))
        elif schema_keys != def_keys:
            info("schema.js keys 与定义键序不同（不影响功能；schema.js 文件头已将该自述标注为已知失效项）")
    if os.path.exists(doc_path):
        doc_keys = parse_doc_keys(read_text(doc_path))
        if set(doc_keys) != set(def_keys):
            err("逻辑说明.md 参数表与定义不一致：多 %s / 少 %s"
                % (sorted(set(doc_keys) - set(def_keys)),
                   sorted(set(def_keys) - set(doc_keys))))
        else:
            info("逻辑说明.md 参数表键序与定义不同（文档为按功能重排的扁平表，属预期）")

    if os.path.exists(c_path):
        c_text = read_text(c_path)
        macros = parse_c_macros(c_text)
        c_keys = parse_c_keys(c_text)
        table_keys = [k for k in c_keys if not k.startswith("__")]
        if set(table_keys) != set(daemon_keys):
            err("tempctrl.c 解析的键与定义（daemonConsumes=true）不一致：C 多 %s / C 少 %s"
                % (sorted(set(table_keys) - set(daemon_keys)),
                   sorted(set(daemon_keys) - set(table_keys))))
        for wk in webui_keys:
            if wk in table_keys:
                err("定义声明 %s 守护进程不消费，但 tempctrl.c 实际解析了它" % wk)

        sysfs_group = set(e["key"] for e in entries
                          if e["group"] == "sysfs" and e["role"] != "master")
        is_sysfs = c_keys.get("__is_sysfs_key__", set())
        if is_sysfs != sysfs_group:
            err("is_sysfs_key() 的键集合与 sysfs 分组不一致（漏改会被静默忽略）：函数多 %s / 少 %s"
                % (sorted(is_sysfs - sysfs_group), sorted(sysfs_group - is_sysfs)))

        # ---- 2. C 端默认值 / clamp 范围 ----
        defaults = parse_c_defaults(c_text)
        ranges = parse_c_ranges(c_text, macros)
        c_vars = definition.get("audit", {}).get("cVars", {})
        skip_default = definition.get("audit", {}).get("skipDefault", {})

        tally = {"d_ok": 0, "d_exempt": 0, "d_novar": 0,
                 "r_ok": 0, "r_noclamp": 0, "r_novar": 0, "r_multi": 0}
        noclamp = []
        for entry in entries:
            key = entry["key"]
            if not entry.get("daemonConsumes", True):
                continue
            vars_ = c_vars.get(key)
            if vars_ is None:
                err("audit.cVars 缺少 %s 的 C 变量映射" % key)
                continue
            fields = entry.get("fields")
            if fields:
                slots = [(vars_[i] if i < len(vars_) else None,
                          f["default"], f["min"], f["max"])
                         for i, f in enumerate(fields)]
                for i, f in enumerate(fields):
                    if f.get("cVar") and i < len(vars_) and f["cVar"] != vars_[i]:
                        err("定义内部矛盾 %s[%d]：fields[].cVar=%r ≠ audit.cVars=%r"
                            % (key, i + 1, f["cVar"], vars_[i]))
            else:
                slots = [(vars_[0] if vars_ else None, entry["default"],
                          entry["min"], entry["max"])]
            if len(vars_) != len(slots):
                err("audit.cVars[%s] 长度 %d 与取值位 %d 不匹配"
                    % (key, len(vars_), len(slots)))
                continue
            for idx, (slot_var, sdefault, smin, smax) in enumerate(slots):
                label = "%s[%d]" % (key, idx + 1)
                if slot_var is None:
                    tally["d_novar"] += 1
                    tally["r_novar"] += 1
                    continue
                if key in skip_default:
                    tally["d_exempt"] += 1
                elif slot_var not in defaults:
                    tally["d_novar"] += 1
                    info("%s：C 内未找到 %s 的静态初值，未核对默认值" % (label, slot_var))
                elif defaults[slot_var] != str(sdefault):
                    err("默认值不一致 %s：定义 %r ≠ C 内 %s=%r"
                        % (label, sdefault, slot_var, defaults[slot_var]))
                else:
                    tally["d_ok"] += 1

                if slot_var not in ranges:
                    tally["r_noclamp"] += 1
                    noclamp.append(label)
                else:
                    got = ranges[slot_var]
                    if len(got) > 1:
                        tally["r_multi"] += 1
                        info("变量 %s 有多处 clamp 范围 %s，已逐处核对" % (slot_var, sorted(got)))
                    for lo, hi in got:
                        if (lo, hi) != (smin, smax):
                            err("范围不一致 %s：定义 [%s,%s] ≠ C 内 %s clamp [%d,%d]"
                                % (label, smin, smax, slot_var, lo, hi))
                        else:
                            tally["r_ok"] += 1
        info("C 侧自动核对（取值位口径）：默认值 通过 %d / 豁免 %d / 无 C 变量 %d；"
             "范围 通过 %d / 无 clamp %d / 无 C 变量 %d（其中多处 clamp 的变量 %d 个）"
             % (tally["d_ok"], tally["d_exempt"], tally["d_novar"],
                tally["r_ok"], tally["r_noclamp"], tally["r_novar"], tally["r_multi"]))
        if noclamp:
            info("范围无法自动核对（C 端无 clamp，须人眼核对）：%s" % ", ".join(noclamp))

        # ---- 3. crossChecks：跨「默认值 ↔ C 宏 ↔ applicationId」的一致性 ----
        str_macros = parse_c_string_macros(c_text)
        for rule in definition.get("audit", {}).get("crossChecks", []):
            rid = rule.get("id", rule.get("kind", "?"))
            if rule["kind"] == "defaultEqualsMacroPrefix":
                entry = next((e for e in entries if e["key"] == rule["key"]), None)
                macro_val = str_macros.get(rule["macro"])
                if entry is None:
                    err("crossCheck「%s」引用了不存在的键 %s" % (rid, rule["key"]))
                elif macro_val is None:
                    info("crossCheck「%s」无法自动核对：tempctrl.c 内未找到单行字符串宏 %s"
                         % (rid, rule["macro"]))
                else:
                    expect = macro_val.rstrip("/") + "/" + rule["suffix"]
                    for f in ("default", "factory"):
                        if entry[f] != expect:
                            err("crossCheck「%s」不一致：%s 的 %s=%r ≠ 由 %s 推出的 %r"
                                % (rid, rule["key"], f, entry[f], rule["macro"], expect))
            elif rule["kind"] == "macroEqualsAppIdPrivateDir":
                macro_val = str_macros.get(rule["macro"])
                gpath = os.path.join(REPO, rule["gradleRelPath"])
                app_id = (parse_gradle_application_id(read_text(gpath))
                          if os.path.exists(gpath) else None)
                if macro_val is None or app_id is None:
                    info("crossCheck「%s」无法自动核对：宏 %s %s；applicationId %s"
                         % (rid, rule["macro"],
                            "缺失" if macro_val is None else repr(macro_val),
                            "缺失" if app_id is None else repr(app_id)))
                else:
                    expect = "/data/data/%s/files" % app_id
                    if macro_val != expect:
                        err("crossCheck「%s」不一致：tempctrl.c 的 %s=%r ≠ /data/data/<applicationId>/files = %r"
                            % (rid, rule["macro"], macro_val, expect))

    return findings


# --------------------------------------------------------------------------

def main(argv=None):
    ap = argparse.ArgumentParser(description="B6X 参数定义生成 / 四源审计")
    ap.add_argument("--audit", action="store_true", help="只做四源漂移审计，不写产物")
    ap.add_argument("--quiet", action="store_true", help="只输出结论行")
    args = ap.parse_args(argv)

    definition = load_def()

    if not args.audit:
        path, changed, _ = write_product(definition)
        n = len(definition["keys"])
        print("[gen_params] 已生成 %d 键 → %s%s"
              % (n, os.path.relpath(path, REPO).replace("\\", "/"),
                 "（内容有更新）" if changed else "（无变化）"))
        return 0

    findings = audit(definition)
    errors = [t for lvl, t in findings if lvl == "ERROR"]
    infos = [t for lvl, t in findings if lvl == "INFO"]
    if not args.quiet:
        for t in infos:
            print("[INFO ] " + t)
    for t in errors:
        print("[ERROR] " + t)
    print("[audit ] 漂移错误 %d 条 / 提示 %d 条" % (len(errors), len(infos)))
    return 2 if errors else 0


if __name__ == "__main__":
    sys.exit(main())
