#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""B6X 温控参数定义 —— 生成脚本（R1 单一来源）

定位（本文件是唯一实现处）：
  · 唯一手写处是 参数定义/params.def.json。
  · 全部产物由本文件生成；**来源清单（SOURCES）与产物清单（PRODUCTS）也只在本文件声明**。
  · check_params.py 只做校验，一律 import 本文件的常量与函数，不另行声明来源/产物。

用法：
    python 参数定义/gen_params.py            # 生成全部产物（幂等）
    python 参数定义/gen_params.py --audit    # 只做三源漂移审计，不写文件（漂移则退出 2）
    python 参数定义/gen_params.py --audit --quiet

零第三方依赖（仅标准库）。定位 C 侧信息一律用「函数名 / 键名 / 表名 / 宏名 + 关键判据」，
不写死行号（本工程索引行号恒比工作树小 1，行号不可靠）。
"""

import argparse
import io
import json
import os
import re
import sys
from collections import namedtuple

HERE = os.path.dirname(os.path.abspath(__file__))
REPO = os.path.dirname(HERE)

DEF_PATH = os.path.join(HERE, "params.def.json")

# --------------------------------------------------------------------------
# 来源清单（三源）：check_params.py 直接引用此处，不得在别处重复声明
# --------------------------------------------------------------------------

Source = namedtuple("Source", "id path desc")

SOURCES = (
    Source("conf", "lsp模块/daemon/profile.conf",
           "配置文件出厂模板（部署到设备，C 端热重载）"),
    Source("doc", "逻辑说明.md",
           "设计说明的参数表段（仓库根；其余章节不由本工具维护）"),
    Source("c", "lsp模块/daemon/tempctrl.c",
           "守护进程源码：解析的键、clamp 边界、护栏"),
)


def source_path(source):
    return os.path.join(REPO, source.path)


# --------------------------------------------------------------------------
# 产物清单：check_params.py 断言 A 逐项复核
#   kind = full   → 整个文件由定义生成
#   kind = region → 只重写文件内的标记区间（其余内容由人工维护）
# --------------------------------------------------------------------------

Product = namedtuple("Product", "id path kind desc")

PRODUCTS = (
    Product("params.json", "lsp模块/app/src/main/assets/params.json", "full",
            "界面消费的键/范围/默认值（APK assets）"),
    Product("profile.conf", "lsp模块/daemon/profile.conf", "full",
            "配置文件出厂模板（含注释）"),
    Product("doc-table", "逻辑说明.md", "region",
            "逻辑说明.md 的参数表段（标记区间内）"),
    Product("c-header", "lsp模块/daemon/params_generated.h", "full",
            "C 端键表与 clamp 边界（供 tempctrl.c 包含）"),
)

DOC_START = "<!-- params-table:start （本节由 参数定义/gen_params.py 生成，勿手改） -->"
DOC_END = "<!-- params-table:end -->"

DEF_REL = "参数定义/params.def.json"

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


def product_path(product):
    return os.path.join(REPO, product.path)


def product_by_id(pid):
    for p in PRODUCTS:
        if p.id == pid:
            return p
    raise KeyError(pid)


# --------------------------------------------------------------------------
# 产物构建：assets/params.json
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


def build_params_json(definition):
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
        "generatedFrom": DEF_REL,
        "chart": {
            "windowOptionsSec": list(chart["windowOptionsSec"]),
            "windowDefaultSec": chart["windowDefaultSec"],
            "rollingMaxLines": chart["rollingMaxLines"],
        },
        "groups": groups_out,
        "keys": keys_out,
    }


def render_params_json(definition):
    return json.dumps(build_params_json(definition), ensure_ascii=False,
                      indent=2) + "\n"


# --------------------------------------------------------------------------
# 产物构建：profile.conf
# --------------------------------------------------------------------------

def group_tag(group):
    m = re.match(r"^(\[\d+\])\s*", group["title"])
    return m.group(1) if m else ""


def _conf_value(entry):
    """profile.conf 写出的是**出厂值**（配置文件不存在时由部署流程写入的值）。"""
    val = entry["factory"]
    if entry["type"] == "multi":
        return " ".join(str(v) for v in val)
    return str(val)


def _conf_inline_pads(entries):
    """行内注释对齐：定义中**相邻**的带 confInline 的键为一段，段内 '#' 对齐到最宽 KEY=VALUE + 4。"""
    pads = {}
    run = []

    def flush():
        if run:
            width = max(len("%s=%s" % (e["key"], _conf_value(e))) for e in run) + 4
            for e in run:
                pads[e["key"]] = width
    for entry in entries:
        if entry.get("confInline"):
            run.append(entry)
        else:
            flush()
            run = []
    flush()
    return pads


def render_conf(definition):
    out = []
    for line in definition["conf"]["header"]:
        out.append(("# " + line).rstrip())
    out.append("")

    for group in definition["groups"]:
        tag = group_tag(group)
        entries = [e for e in definition["keys"] if e["group"] == group["id"]]
        pads = _conf_inline_pads(entries)
        first = True
        for entry in entries:
            section = entry.get("confSection")
            if section:
                if not first:
                    out.append("")
                out.append(("# %s %s" % (tag, section)).rstrip())
            elif first:
                out.append(("# " + group["title"]
                            + group.get("confTitleNote", "")).rstrip())
            elif entry.get("confNote"):
                out.append("")
            first = False
            for line in (entry.get("confNote") or []):
                out.append(("# " + line).rstrip())
            text = "%s=%s" % (entry["key"], _conf_value(entry))
            if entry.get("confInline"):
                text = text.ljust(pads[entry["key"]]) + "# " + entry["confInline"]
            out.append(text)
        out.append("")

    while out and out[-1] == "":
        out.pop()
    return "\n".join(out) + "\n"


# --------------------------------------------------------------------------
# 产物构建：逻辑说明.md 的参数表段（标记区间）
# --------------------------------------------------------------------------

def doc_order_key(entry):
    return entry.get("docOrder", 0)


def _doc_default_cell(entry):
    val = entry["default"]
    if entry["type"] == "multi":
        return " ".join(str(v) for v in val)
    return str(val)


def render_doc_region(definition):
    entries = sorted([e for e in definition["keys"] if e.get("docDesc")],
                     key=doc_order_key)
    out = [DOC_START]
    for line in definition["doc"]["intro"]:
        out.append(("> " + line).rstrip() if line else ">")
    out.append("")
    out.append("| 参数 | 默认值 | 说明 |")
    out.append("|------|--------|------|")
    for entry in entries:
        out.append("| `%s` | %s | %s |"
                   % (entry["key"], _doc_default_cell(entry), entry["docDesc"]))
    out.append(DOC_END)
    return "\n".join(out) + "\n"


def find_doc_region(text):
    """返回 (起点, 终点)；起点 = 起始标记行首，终点 = 结束标记行尾（不含换行）。"""
    i = text.find(DOC_START)
    j = text.find(DOC_END)
    if i < 0 or j < 0:
        raise ValueError("逻辑说明.md 缺少参数表标记区间（%s ... %s）"
                         % (DOC_START, DOC_END))
    return i, j + len(DOC_END)


# --------------------------------------------------------------------------
# 产物构建：C 端键表与 clamp 边界（params_generated.h）
#   逐键/逐字段的 clamp 边界全部由定义给出；多值键的**解析代码**仍在 tempctrl.c
#   手写（取位、全或无提交等语义不在定义表达范围内），只由审计覆盖。
# --------------------------------------------------------------------------

def first_cvar(definition, key):
    """键在 tempctrl.c 内的首个 C 变量名（无则 None）。"""
    vars_ = definition["audit"]["cVars"].get(key) or []
    return vars_[0] if vars_ else None


def c_slot_ident(entry, idx):
    """clamp 边界宏的标识：单值键 = 键名；多值键 = 键名_字段序号（1 起）。"""
    if entry["type"] == "multi":
        return "%s_%d" % (entry["key"], idx + 1)
    return entry["key"]


def _c_default(entry):
    val = entry["default"]
    if isinstance(val, str):
        return json.dumps(val, ensure_ascii=False)
    return str(val)


def build_c_header(definition):
    entries = definition["keys"]
    daemon = [e for e in entries if e.get("daemonConsumes", True)]
    webui = [e for e in entries if not e.get("daemonConsumes", True)]
    perf_int = [e for e in entries if e.get("cTable") == "perf-int"]
    sysfs = [e for e in entries if e.get("cTable") == "sysfs"]

    lines = []
    lines.append("/* 本文件由 python 参数定义/gen_params.py 生成，勿手改。")
    lines.append(" * 唯一手写处：%s；改动后重跑生成脚本。" % DEF_REL)
    lines.append(" * 只定义宏。X 宏的展开点必须在 struct SysfsCfgKey / enum SK_* 与所有被取地址的")
    lines.append(" * static 变量（BATT_TEMP_PATH、log_file_path、LOG_MAX 等）声明之后。 */")
    lines.append("#ifndef PARAMS_GENERATED_H")
    lines.append("#define PARAMS_GENERATED_H")
    lines.append("")
    lines.append("/* 键数：守护进程消费 / 仅界面读取 */")
    lines.append("#define CFG_DAEMON_KEY_COUNT %d" % len(daemon))
    lines.append("#define CFG_WEBUI_KEY_COUNT %d" % len(webui))
    lines.append("")

    lines.append("/* 性能层单值键表（PERF_ENABLED=1）→ INT_CFG_KEYS[]：X(键名, C 变量, min, max) */")
    lines.append("#define %s(X) \\" % C_TABLE_MACRO["perf-int"])
    rows = []
    for e in perf_int:
        rows.append('    X("%s", %s, %d, %d)'
                    % (e["key"], first_cvar(definition, e["key"]), e["min"], e["max"]))
    lines.append(" \\\n".join(rows))
    lines.append("")

    lines.append("/* sysfs 层键表（SYSFS_ENABLED=1）→ SYSFS_CFG_KEYS[]：")
    lines.append(" *   X(键名, kind, ivar, imin, imax, svar, ssize)")
    lines.append(" * kind/SK_INT 槽位钳制范围由本表给出；SK_ZONE/SK_RESCAN 的逐字段范围见 CFG_MIN/MAX_*。 */")
    lines.append("#define %s(X) \\" % C_TABLE_MACRO["sysfs"])
    rows = []
    for e in sysfs:
        cvar = first_cvar(definition, e["key"])
        if e.get("cKind") == "SK_INT":
            rows.append('    X("%s", SK_INT, &%s, %d, %d, NULL, 0)'
                        % (e["key"], cvar, e["min"], e["max"]))
        elif e.get("cKind") == "SK_PATH":
            rows.append('    X("%s", SK_PATH, NULL, 0, 0, %s, sizeof(%s))'
                        % (e["key"], cvar, cvar))
        else:
            rows.append('    X("%s", %s, NULL, 0, 0, NULL, 0)'
                        % (e["key"], e.get("cKind")))
    lines.append(" \\\n".join(rows))
    lines.append("")

    lines.append("/* 逐键/逐字段 clamp 边界（单值键 = 键名；多值键 = 键名_字段序号）。")
    lines.append(" * 多值键与 SK_ZONE/SK_RESCAN 的解析代码仍在 tempctrl.c 手写，此处只提供边界值。 */")
    for e in daemon:
        if e["type"] not in ("int", "multi"):
            continue
        fields = e.get("fields")
        if e["type"] == "multi" and fields:
            for i, f in enumerate(fields):
                if f.get("bool"):
                    continue
                ident = c_slot_ident(e, i)
                cvar = f.get("cVar")
                tail = ("  /* C 变量 %s */" % cvar) if cvar else ""
                lines.append("#define CFG_MIN_%s %d%s" % (ident, f["min"], tail))
                lines.append("#define CFG_MAX_%s %d" % (ident, f["max"]))
        else:
            cvar = first_cvar(definition, e["key"])
            tail = ("  /* C 变量 %s */" % cvar) if cvar else ""
            lines.append("#define CFG_MIN_%s %d%s" % (e["key"], e["min"], tail))
            lines.append("#define CFG_MAX_%s %d" % (e["key"], e["max"]))
    lines.append("")

    paths = [e for e in daemon if e["type"] == "path"]
    lines.append("/* 路径键默认值（C 端同名变量初值；LOG_FILE 运行期由 PRIVATE_DIR + 二进制名派生）*/")
    for e in paths:
        lines.append("#define CFG_DEFAULT_%s %s" % (e["key"], _c_default(e)))
    lines.append("")
    lines.append("#endif  /* PARAMS_GENERATED_H */")
    return "\n".join(lines) + "\n"


# --------------------------------------------------------------------------
# 产物写入
# --------------------------------------------------------------------------

def render_product(pid, definition):
    if pid == "params.json":
        return render_params_json(definition)
    if pid == "profile.conf":
        return render_conf(definition)
    if pid == "c-header":
        return build_c_header(definition)
    if pid == "doc-table":
        return render_doc_region(definition)
    raise KeyError(pid)


def expected_product(pid, definition):
    """产物应有的落盘内容（全文口径；region 产物返回整文件应有内容）。"""
    product = product_by_id(pid)
    text = render_product(pid, definition)
    path = product_path(product)
    if product.kind == "full":
        return text
    if not os.path.exists(path):
        raise IOError("产物不存在：%s" % path)
    current = read_text(path)
    i, j = find_doc_region(current)
    return current[:i] + text.rstrip("\n") + current[j:]


def write_product(pid, definition):
    product = product_by_id(pid)
    path = product_path(product)
    text = render_product(pid, definition)
    if product.kind == "full":
        new_text = text
    else:
        current = read_text(path) if os.path.exists(path) else ""
        i, j = find_doc_region(current)
        new_text = current[:i] + text.rstrip("\n") + current[j:]
    old_text = read_text(path) if os.path.exists(path) else None
    changed = old_text != new_text
    if changed:
        d = os.path.dirname(path)
        if d and not os.path.isdir(d):
            os.makedirs(d)
        with io.open(path, "w", encoding="utf-8", newline="\n") as fh:
            fh.write(new_text)
    return path, changed


def write_all(definition):
    return [write_product(p.id, definition) for p in PRODUCTS]


# --------------------------------------------------------------------------
# 三源审计：定位一律用「函数名 / 表名 / 键名 / 宏名」判据，不用行号
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


C_TABLE_NAME = {"perf-int": "INT_CFG_KEYS", "sysfs": "SYSFS_CFG_KEYS"}

# 各表在生成头里的 X 宏名（写出与检测共用这一份）。
# 与 C_TABLE_NAME 的区别必须留意：那是 C 端的**数组名**，这是生成头里的**宏名**。
# 原先检测用数组名去匹配、产物写的却是宏名，两者在接入前必然失配（故此前一直没暴露）。
C_TABLE_MACRO = {"perf-int": "CFG_PERF_INT_KEYS", "sysfs": "CFG_SYSFS_KEYS"}

INT_ROW_RE = re.compile(r'\{\s*"([A-Z0-9_]+)"\s*,\s*&(\w+)\s*,\s*'
                        r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*\}')
SYSFS_ROW_RE = re.compile(r'\{\s*"([A-Z0-9_]+)"\s*,\s*(SK_\w+)\s*,\s*([^,]+?)\s*,\s*'
                          r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*,\s*([^,]+?)\s*,\s*([^}]+?)\s*\}')


def _c_table_block(c_text, table):
    return _block(c_text, r"%s\s*\[\s*\]\s*=\s*\{" % table, r"\n\};")


def _adopted_tables(c_text):
    """表体已被生成头接管的表 id 列表（C 源里只剩 `<宏名>(CFG_ROW)` 展开形态）。

    判据是"表初始化处调用了生成头里的 X 宏"，`parse_c_tables` / `parse_c_ranges` /
    `audit` 三处共用，避免各写一份正则而漏改其一。两种调用形式都认：生成头的宏名
    （`CFG_PERF_INT_KEYS`），以及与 C 端数组同名的旧写法（`INT_CFG_KEYS`）。
    """
    adopted = []
    for pid, table in C_TABLE_NAME.items():
        if any(re.search(r"%s\s*\(\s*\w+\s*\)" % name, c_text)
               for name in (table, C_TABLE_MACRO[pid])):
            adopted.append(pid)
    return adopted


def parse_c_tables(c_text):
    """C 端两张键表的 (键, 变量/kind, min, max) 行集合。

    表体若已被生成头接管（`<表名>(CFG_ROW)` 形态）则返回空行集，交由调用方按产物口径处理。
    """
    rows = {"perf-int": [], "sysfs": []}
    adopted = _adopted_tables(c_text)
    for pid, table in C_TABLE_NAME.items():
        if pid in adopted:
            continue          # 表体由 params_generated.h 的 X 宏展开
        body = _c_table_block(c_text, table)
        if pid == "perf-int":
            for m in INT_ROW_RE.finditer(body):
                rows[pid].append((m.group(1), m.group(2), m.group(3), m.group(4)))
        else:
            for m in SYSFS_ROW_RE.finditer(body):
                rows[pid].append((m.group(1), m.group(3).strip("& "), m.group(4), m.group(5)))
    return rows


def parse_c_keys(c_text):
    """C 端实际解析的配置键集合 + 各键出处。"""
    found = {}
    tables = parse_c_tables(c_text)
    for pid, table in C_TABLE_NAME.items():
        for row in tables[pid]:
            found[row[0]] = table
    for func in ("parse_debug_cfg", "parse_sysfs_cfg", "parse_pid_cfg",
                 "parse_common_cfg", "load_config"):
        body = _func_body(c_text, func)
        for m in re.finditer(r'strcmp\(\s*key\s*,\s*"([A-Z0-9_]+)"\s*\)', body):
            found.setdefault(m.group(1), func)
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


def parse_generated_ranges(gen_text):
    """`params_generated.h` 的两张 X 宏键表 → {C 变量: set((lo, hi))}。

    表体改由生成头承接后，C 源里不再有可抓的字面量行，范围的真源就是这里；
    它是否最新由断言 A（重跑生成 + 逐字节比对）保证，两者合起来才是完整链路。
    """
    gen_macros = parse_c_macros(gen_text)
    ranges = {}

    def resolve(tok):
        tok = tok.strip()
        if re.match(r"^-?\d+$", tok):
            return int(tok)
        if tok in gen_macros:
            return int(gen_macros[tok])
        return None

    body = _block(gen_text, r"#define\s+%s\(X\)" % C_TABLE_MACRO["perf-int"], r"\n\n")
    for m in re.finditer(r'X\(\s*"([A-Z0-9_]+)"\s*,\s*(\w+)\s*,\s*'
                         r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*\)', body):
        lo, hi = resolve(m.group(3)), resolve(m.group(4))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(2), set()).add((lo, hi))

    body = _block(gen_text, r"#define\s+%s\(X\)" % C_TABLE_MACRO["sysfs"], r"\n\n")
    for m in re.finditer(r'X\(\s*"([A-Z0-9_]+)"\s*,\s*(SK_\w+)\s*,\s*([^,]+?)\s*,\s*'
                         r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*,', body):
        if m.group(2) != "SK_INT":
            continue          # SK_PATH 无范围；SK_ZONE / SK_RESCAN 的 clamp 在调用点收
        lo, hi = resolve(m.group(4)), resolve(m.group(5))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(3).strip("& "), set()).add((lo, hi))
    return ranges


def parse_c_ranges(c_text, macros):
    """C 端各变量的 clamp / 表内范围 → {var: set((lo, hi))}（宏名就地展开）。

    表体已被生成头接管的表，其范围改从产物 `params_generated.h` 读（见
    {@link parse_generated_ranges}）；仍手写在 C 源的表照旧抓字面量行。
    """
    ranges = {}
    adopted = _adopted_tables(c_text)

    def resolve(tok):
        tok = tok.strip()
        if re.match(r"^-?\d+$", tok):
            return int(tok)
        if tok in macros:
            return int(macros[tok])
        return None

    if "perf-int" not in adopted:
        table = _block(c_text, r"INT_CFG_KEYS\s*\[\s*\]\s*=\s*\{", r"\n\};")
        for m in INT_ROW_RE.finditer(table):
            lo, hi = resolve(m.group(3)), resolve(m.group(4))
            if lo is not None and hi is not None:
                ranges.setdefault(m.group(2), set()).add((lo, hi))

    if "sysfs" not in adopted:
        sysfs_table = _block(c_text, r"SYSFS_CFG_KEYS\s*\[\s*\]\s*=\s*\{", r"\n\};")
        for m in SYSFS_ROW_RE.finditer(sysfs_table):
            if m.group(2) != "SK_INT":
                continue      # SK_PATH 无范围；SK_ZONE / SK_RESCAN 的 clamp 在下方按调用点收
            lo, hi = resolve(m.group(4)), resolve(m.group(5))
            if lo is not None and hi is not None:
                ranges.setdefault(m.group(3).strip("& "), set()).add((lo, hi))

    for m in re.finditer(r"(\w+)\s*=\s*clamp\(\s*[^,]+,\s*([A-Za-z_0-9]+)\s*,"
                         r"\s*([A-Za-z_0-9]+)\s*\)", c_text):
        lo, hi = resolve(m.group(2)), resolve(m.group(3))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(1), set()).add((lo, hi))

    if adopted:
        gen_path = product_path(product_by_id("c-header"))
        if os.path.exists(gen_path):
            for var, got in parse_generated_ranges(read_text(gen_path)).items():
                ranges.setdefault(var, set()).update(got)
    return ranges


def _range_expected(smin, smax):
    """该取值位是否应当有可核对的 clamp 范围。

    无范围（None）＝ 路径键等，没有数值语义；布尔域 (0,1) ＝ `type=switch` 或多值键的
    使能位，C 端按非零判真、不存在可越界的中间态。两者之外都必须能在 C 端找到 clamp。
    """
    if smin is None or smax is None:
        return False
    return (smin, smax) != (0, 1)


def parse_conf_keys(conf_text):
    keys = []
    for line in conf_text.splitlines():
        s = line.strip()
        if not s or s.startswith("#") or "=" not in s:
            continue
        keys.append(s.split("=", 1)[0].strip())
    return keys


def parse_doc_keys(doc_text):
    """定位参数表标记区间内的键行（表头之下的 `| \\`KEY\\` | ...` 行）。"""
    try:
        i, j = find_doc_region(doc_text)
    except ValueError:
        return []
    keys = []
    for line in doc_text[i:j].splitlines():
        m = re.match(r"^\|\s*`([A-Z0-9_]+)`", line)
        if m:
            keys.append(m.group(1))
    return keys


def parse_literals(text, prefix_pat):
    """收集文本中形如 com.flydigi.x / com.fdg.x 的包名字面量（排序去重）。"""
    return sorted(set(re.findall(prefix_pat, text)))


# 反向核对只认「应用包名」形态：4 段全小写（com.<brand>.<product>.<flavor>）。
# 不认广播 action（com.flydigi.SET_TEMPERATURE）与 SDK 类名（com.flydigi.sdk.waspwing.WaspWingManager）。
PKG_LITERAL_PAT = r"com\.(?:flydigi|fdg)\.[a-z][a-z0-9_]*\.[a-z][a-z0-9_]*(?![\w.])"


def audit_packages(definition, findings):
    """R4：飞智三个包名的单一来源核对（五处手抄 → def 一处声明）。"""
    spec = definition.get("packages")
    if not spec:
        findings.append(("ERROR", "定义缺少 packages 段（R4 包名单一来源）"))
        return
    apps = {a["id"]: a["value"] for a in spec["apps"]}
    declared = set(apps.values())
    for site in spec["sites"]:
        path = os.path.join(REPO, site["file"])
        if not os.path.exists(path):
            findings.append(("INFO", "包名核对跳过（文件不存在）：%s" % site["file"]))
            continue
        text = read_text(path)
        if site["check"] == "cMacroSet":
            got = parse_c_string_macros(text)
            for aid in site["expect"]:
                macro = apps and next(a for a in spec["apps"] if a["id"] == aid)["cMacro"]
                if got.get(macro) != apps[aid]:
                    findings.append(("ERROR",
                                     "R4 %s 的 %s=%r ≠ 定义 %r"
                                     % (site["file"], macro, got.get(macro), apps[aid])))
        elif site["check"] == "javaConstSet":
            got = dict(re.findall(r'(PACKAGE_\w+)\s*=\s*"([^"]+)"', text))
            for a in spec["apps"]:
                if not a.get("javaConst"):
                    continue
                if got.get(a["javaConst"]) != a["value"]:
                    findings.append(("ERROR",
                                     "R4 %s 的 %s=%r ≠ 定义 %r"
                                     % (site["file"], a["javaConst"],
                                        got.get(a["javaConst"]), a["value"])))
        elif site["check"] == "xmlItemSet":
            got = set(re.findall(r"<item>([^<]+)</item>", text))
            if got != declared:
                findings.append(("ERROR", "R4 %s 的 <item> 集合与定义不一致：多 %s / 少 %s"
                                 % (site["file"], sorted(got - declared),
                                    sorted(declared - got))))
        elif site["check"] == "literalsPresent":
            for aid in site["expect"]:
                short = next((a.get("short") for a in spec["apps"] if a["id"] == aid), None)
                if apps[aid] not in text and not (short and short in text):
                    findings.append(("ERROR", "R4 %s 未出现包名 %s（或其简称 %s）"
                                     % (site["file"], apps[aid], short)))
        else:
            findings.append(("ERROR", "R4 未知核对方式 %r（%s）"
                             % (site["check"], site["file"])))
        extra = set(parse_literals(text, PKG_LITERAL_PAT)) - declared
        if extra:
            findings.append(("ERROR", "R4 %s 出现未声明的飞智包名：%s（应进定义 packages 段）"
                             % (site["file"], sorted(extra))))


def audit_app_package(definition, findings):
    """R6：本项目包名 —— applicationId 为真源，其余落点由它推出。"""
    spec = definition.get("appPackage")
    if not spec:
        findings.append(("ERROR", "定义缺少 appPackage 段（R6 本项目包名）"))
        return
    value = spec["value"]
    expected_dir = "/data/data/%s/files" % value

    truth_path = os.path.join(REPO, spec["truthFile"])
    app_id = (parse_gradle_application_id(read_text(truth_path))
              if os.path.exists(truth_path) else None)
    if app_id is None:
        findings.append(("INFO", "R6 无法读取 applicationId：%s" % spec["truthFile"]))
    elif app_id != value:
        findings.append(("ERROR", "R6 真源不一致：%s 的 applicationId=%r ≠ 定义 %r"
                         % (spec["truthFile"], app_id, value)))

    for site in spec["privateDirSites"]:
        path = os.path.join(REPO, site["file"])
        if not os.path.exists(path):
            findings.append(("INFO", "R6 核对跳过（文件不存在）：%s" % site["file"]))
            continue
        text = read_text(path)
        if site["kind"] == "cMacro":
            got = parse_c_string_macros(text).get(site["name"])
        elif site["kind"] == "javaConst":
            m = re.search(r'%s\s*=\s*"([^"]+)"' % re.escape(site["name"]), text)
            got = m.group(1) if m else None
        else:
            findings.append(("ERROR", "R6 未知核对方式 %r（%s）"
                             % (site["kind"], site["file"])))
            continue
        if got != expected_dir:
            findings.append(("ERROR", "R6 %s 的 %s=%r ≠ /data/data/<applicationId>/files = %r"
                             % (site["file"], site["name"], got, expected_dir)))


def audit(definition, verbose=True):
    """三源漂移审计。返回 findings 列表；每项 (级别, 文本)，级别 ∈ ERROR/INFO。"""
    paths = {s.id: source_path(s) for s in SOURCES}
    c_path = paths["c"]
    conf_path = paths["conf"]
    doc_path = paths["doc"]

    findings = []
    def err(msg):
        findings.append(("ERROR", msg))
    def info(msg):
        findings.append(("INFO", msg))

    entries = definition["keys"]
    def_keys = [e["key"] for e in entries]
    daemon_keys = [e["key"] for e in entries if e.get("daemonConsumes", True)]
    webui_keys = [e["key"] for e in entries if not e.get("daemonConsumes", True)]

    for s in SOURCES:
        if not os.path.exists(paths[s.id]):
            info("来源文件不存在，跳过对应核对：%s" % s.path)

    # ---- 0. 分组标题必须带 [N] 段标（profile.conf 段标自它派生） ----
    for group in definition["groups"]:
        if not group_tag(group):
            err("分组 %r 的标题缺少「[N]」段标（profile.conf 段标自组标题派生）"
                % group["id"])

    # ---- 1. 三份来源的键集合 ----
    if os.path.exists(conf_path):
        conf_keys = parse_conf_keys(read_text(conf_path))
        if conf_keys != def_keys:
            err("profile.conf 键集合/顺序与定义不一致：多 %s / 少 %s / 顺序不同 %s"
                % (sorted(set(conf_keys) - set(def_keys)),
                   sorted(set(def_keys) - set(conf_keys)),
                   conf_keys != def_keys and not (set(conf_keys) ^ set(def_keys))))
    if os.path.exists(doc_path):
        doc_keys = parse_doc_keys(read_text(doc_path))
        doc_order = [e["key"] for e in sorted(
            [e for e in entries if e.get("docDesc")], key=doc_order_key)]
        if set(doc_keys) != set(def_keys):
            err("逻辑说明.md 参数表与定义不一致：多 %s / 少 %s"
                % (sorted(set(doc_keys) - set(def_keys)),
                   sorted(set(def_keys) - set(doc_keys))))
        elif doc_keys != doc_order:
            err("逻辑说明.md 参数表键序 ≠ 定义的 docOrder")
        orders = [e["docOrder"] for e in entries if e.get("docDesc")]
        if len(orders) != len(def_keys) or len(set(orders)) != len(orders):
            err("docOrder 缺项或重复：%d 项 / %d 键"
                % (len(set(orders)), len(def_keys)))

    if os.path.exists(c_path):
        c_text = read_text(c_path)
        macros = parse_c_macros(c_text)
        c_tables = parse_c_tables(c_text)
        c_keys = parse_c_keys(c_text)
        table_keys = list(c_keys)
        adopted = _adopted_tables(c_text)
        for pid in adopted:
            table_keys.extend(e["key"] for e in entries if e.get("cTable") == pid)
        if adopted and '#include "params_generated.h"' not in c_text:
            err("tempctrl.c 用 X 宏展开键表（%s）但未 #include \"params_generated.h\""
                % ", ".join(C_TABLE_NAME[p] for p in adopted))
        if adopted:
            info("C 端键表已由 params_generated.h 承接，按产物口径核对：%s"
                 % ", ".join(C_TABLE_NAME[p] for p in adopted))

        if set(table_keys) != set(daemon_keys):
            err("tempctrl.c 解析的键与定义（daemonConsumes=true）不一致：C 多 %s / C 少 %s"
                % (sorted(set(table_keys) - set(daemon_keys)),
                   sorted(set(daemon_keys) - set(table_keys))))
        for wk in webui_keys:
            if wk in table_keys:
                err("定义声明 %s 守护进程不消费，但 tempctrl.c 实际解析了它" % wk)

        # 两张表的**归属**核对：同一键不得同时/错位地落进另一张表（PERF 与 SYSFS 是两个独立开关）
        for pid, table in C_TABLE_NAME.items():
            if pid in adopted:
                continue
            expect = [e["key"] for e in entries if e.get("cTable") == pid]
            got = [row[0] for row in c_tables[pid]]
            if set(got) != set(expect):
                err("%s 表的键与定义 cTable=%r 不一致：C 多 %s / C 少 %s"
                    % (table, pid, sorted(set(got) - set(expect)),
                       sorted(set(expect) - set(got))))
            elif got != expect:
                info("%s 表键序与定义不同（不影响功能）" % table)

        sysfs_group = set(e["key"] for e in entries
                          if e["group"] == "sysfs" and e["role"] != "master")
        if "sysfs" in adopted:
            got_sysfs = set(e["key"] for e in entries if e.get("cTable") == "sysfs")
        else:
            got_sysfs = set(row[0] for row in c_tables["sysfs"])
        if got_sysfs != sysfs_group:
            err("SYSFS_CFG_KEYS 的键集合与 sysfs 分组不一致（漏改会被静默忽略）：表多 %s / 表少 %s"
                % (sorted(got_sysfs - sysfs_group), sorted(sysfs_group - got_sysfs)))

        # ---- 2. C 端默认值 / clamp 范围 ----
        defaults = parse_c_defaults(c_text)
        ranges = parse_c_ranges(c_text, macros)
        c_vars = definition.get("audit", {}).get("cVars", {})
        skip_default = definition.get("audit", {}).get("skipDefault", {})

        tally = {"d_ok": 0, "d_exempt": 0, "d_novar": 0,
                 "r_ok": 0, "r_exempt": 0, "r_noclamp": 0, "r_novar": 0, "r_multi": 0}
        novar = []
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
                    novar.append(label)
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
                    if not _range_expected(smin, smax):
                        # 定义本身没有数值范围（路径键）或只有布尔域（开关 / 多值键使能位）：
                        # 前者无数值语义，后者 C 端按非零判真、无中间态可越界，都不该有 clamp
                        tally["r_exempt"] += 1
                    else:
                        # 声明了数值范围、C 变量也真实存在，却找不到 clamp ——
                        # 这不是"跳过"，是核对缺位：删掉 clamp 也不会红，必须报错
                        tally["r_noclamp"] += 1
                        err("范围无法核对 %s：定义 [%s,%s]，但 C 内未找到 %s 的 clamp"
                            % (label, smin, smax, slot_var))
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
             "范围 通过 %d / 无范围豁免 %d / 声明了却未找到 clamp %d / 无 C 变量 %d"
             "（其中多处 clamp 的变量 %d 个）"
             % (tally["d_ok"], tally["d_exempt"], tally["d_novar"],
                tally["r_ok"], tally["r_exempt"], tally["r_noclamp"],
                tally["r_novar"], tally["r_multi"]))
        if novar:
            # 这些取值位在 audit.cVars 里显式写 null（多值键的使能位、内部结构体字段等），
            # 无法按 C 变量名核对。列出它们，免得"豁免"变成看不见的洞。
            info("C 端无对应变量、未核对（定义已显式声明为 null）：%s" % ", ".join(novar))

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
                app_id = definition.get("appPackage", {}).get("value")
                if macro_val is None or app_id is None:
                    info("crossCheck「%s」无法自动核对：宏 %s %s；定义 appPackage %s"
                         % (rid, rule["macro"],
                            "缺失" if macro_val is None else repr(macro_val),
                            "缺失" if app_id is None else repr(app_id)))
                else:
                    expect = "/data/data/%s/files" % app_id
                    if macro_val != expect:
                        err("crossCheck「%s」不一致：tempctrl.c 的 %s=%r ≠ /data/data/<applicationId>/files = %r"
                            % (rid, rule["macro"], macro_val, expect))
            elif rule["kind"] == "chartMaxEqualsMacro":
                macro_val = macros.get(rule["macro"])
                chart = definition["chart"]
                if macro_val is None:
                    info("crossCheck「%s」无法自动核对：tempctrl.c 内未找到数值宏 %s"
                         % (rid, rule["macro"]))
                elif int(macro_val) != chart["rollingMaxLines"]:
                    err("crossCheck「%s」不一致：C 宏 %s=%s ≠ 定义 rollingMaxLines=%d"
                        % (rid, rule["macro"], macro_val, chart["rollingMaxLines"]))
                if max(chart["windowOptionsSec"]) != chart["rollingMaxLines"]:
                    err("曲线档位上限 %d ≠ rollingMaxLines %d（档位不得超过缓冲容量）"
                        % (max(chart["windowOptionsSec"]), chart["rollingMaxLines"]))
                if chart["windowDefaultSec"] not in chart["windowOptionsSec"]:
                    err("曲线默认档位 %d 不在档位表内"
                        % chart["windowDefaultSec"])
            else:
                err("未知 crossCheck 类型 %r（%s）" % (rule["kind"], rid))

    # ---- 4. R4 包名单一来源 / R6 本项目包名 ----
    audit_packages(definition, findings)
    audit_app_package(definition, findings)

    return findings


# --------------------------------------------------------------------------

def main(argv=None):
    ap = argparse.ArgumentParser(description="B6X 参数定义生成 / 三源审计")
    ap.add_argument("--audit", action="store_true", help="只做三源漂移审计，不写产物")
    ap.add_argument("--quiet", action="store_true", help="只输出结论行")
    args = ap.parse_args(argv)

    definition = load_def()

    if not args.audit:
        n = len(definition["keys"])
        for path, changed in write_all(definition):
            print("[gen_params] %d 键 → %s%s"
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
