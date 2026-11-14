#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""B6X 温控参数定义 —— 生成脚本（R1 单一来源）

定位（本文件是唯一实现处）：
  · 唯一手写处是 参数定义/params.def.json（参数键）与 参数定义/protocol.def.json（跨端协议）。
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
PROTO_DEF_PATH = os.path.join(HERE, "protocol.def.json")

# --------------------------------------------------------------------------
# 来源清单（三源）：check_params.py 直接引用此处，不得在别处重复声明
# --------------------------------------------------------------------------

Source = namedtuple("Source", "id path desc")

SOURCES = (
    Source("conf", "lsp模块/daemon/profile.conf",
           "配置文件出厂模板（部署到设备，C 端热重载）"),
    Source("doc", "lsp模块/daemon/逻辑说明.md",
           "设计说明的参数表段（lsp模块/daemon/；其余章节不由本工具维护）"),
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
    Product("params.json", "lsp模块/core/src/main/assets/params.json", "full",
            "界面消费的键/范围/默认值（APK assets）"),
    Product("profile.conf", "lsp模块/daemon/profile.conf", "full",
            "配置文件出厂模板（含注释）"),
    Product("doc-table", "lsp模块/daemon/逻辑说明.md", "region",
            "逻辑说明.md 的参数表段（标记区间内）"),
    Product("c-header", "lsp模块/daemon/params_generated.h", "full",
            "C 端键表与 clamp 边界（供 tempctrl.c 包含）"),
    Product("protocol-c-header", "lsp模块/daemon/protocol_generated.h", "full",
            "协议常量 C 头（status/广播 action/路径/列枚举/清理清单）"),
    Product("protocol-java", "lsp模块/core/src/main/java/com/example/waspwingtempctrl/Protocol.java",
            "full", "协议常量 Java 类（与 C/JS 同源同值）"),
    Product("tempctrl-region", "lsp模块/daemon/tempctrl.c", "region",
            "tempctrl.c 内的 WebUI 列/广播区块（生成）"),
    Product("webui-js", "lsp模块/app-lite/src/main/assets/webui/app.js", "region",
            "WebUI 曲线列常量区块（生成）"),
    Product("deploy-sh", "lsp模块/core/src/main/assets/deploy/b6x-tempctrl.sh", "region",
            "部署脚本路径常量与清理清单区块（生成）"),
    Product("mainhook-mirror", "lsp模块/core/src/main/java/com/example/waspwingtempctrl/MainHook.java",
            "region", "广播 extra 镜像注释（CI R2 文本断言用，实际调用引用 Protocol 常量）"),
)

DOC_START = "<!-- params-table:start （本节由 参数定义/gen_params.py 生成，勿手改） -->"
DOC_END = "<!-- params-table:end -->"

C_PROTO_START = "/* protocol-const:start （本节由 参数定义/gen_params.py 从 protocol.def.json 生成，勿手改） */"
C_PROTO_END = "/* protocol-const:end */"
JS_PROTO_START = "    /* protocol-webui:start （本节由 参数定义/gen_params.py 生成，勿手改） */"
JS_PROTO_END = "    /* protocol-webui:end */"
SH_PROTO_START = "# protocol-const:start （本节由 参数定义/gen_params.py 从 protocol.def.json 生成，勿手改）"
SH_PROTO_END = "# protocol-const:end"
MH_PROTO_START = ("    /* protocol-extras-mirror:start （本节由 参数定义/gen_params.py 生成，勿手改；"
                  "实际调用使用 Protocol 的 EXTRA_* 常量） */")
MH_PROTO_END = "    /* protocol-extras-mirror:end */"

REGION_MARKERS = {
    "doc-table": (DOC_START, DOC_END),
    "tempctrl-region": (C_PROTO_START, C_PROTO_END),
    "webui-js": (JS_PROTO_START, JS_PROTO_END),
    "deploy-sh": (SH_PROTO_START, SH_PROTO_END),
    "mainhook-mirror": (MH_PROTO_START, MH_PROTO_END),
}

PROTO_DEF_REL = "参数定义/protocol.def.json"

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


def load_protocol():
    protocol = json.loads(read_text(PROTO_DEF_PATH))
    problems = validate_protocol(protocol)
    if problems:
        raise ValueError("protocol.def.json 非法：\n  - " + "\n  - ".join(problems))
    return protocol


_IDENT_RE = re.compile(r"^[A-Za-z_][A-Za-z0-9_]*$")


def validate_protocol(protocol):
    """协议定义的独立自检（生成与校验共用同一份规则）。"""
    problems = []

    def ident(value, where):
        if not isinstance(value, str) or not _IDENT_RE.match(value):
            problems.append("%s 不是合法标识符：%r" % (where, value))

    app = protocol.get("app") or {}
    host = app.get("hostPackage")
    if not isinstance(host, str) or not re.fullmatch(r"[a-z][a-z0-9_]*(\.[a-z][a-z0-9_]*)+", host):
        problems.append("app.hostPackage 不是合法包名：%r" % (host,))
    if not isinstance(app.get("scriptName"), str) or not app.get("scriptName"):
        problems.append("app.scriptName 为空")

    webui = protocol.get("webui") or {}
    cols = webui.get("cols") or []
    if webui.get("count") != len(cols):
        problems.append("webui.count=%r ≠ cols 条数 %d" % (webui.get("count"), len(cols)))
    seen_idx, seen_name = set(), set()
    for i, col in enumerate(cols):
        ident(col.get("name"), "webui.cols[%d].name" % i)
        if col.get("name") in seen_name:
            problems.append("webui 列名重复：%r" % col.get("name"))
        seen_name.add(col.get("name"))
        if col.get("index") in seen_idx:
            problems.append("webui 列下标重复：%r" % col.get("index"))
        seen_idx.add(col.get("index"))
        if col.get("cType") not in ("int", "long"):
            problems.append("webui.cols[%d].cType 非法：%r" % (i, col.get("cType")))
        if not col.get("label"):
            problems.append("webui.cols[%d].label 为空" % i)
    if seen_idx != set(range(len(cols))):
        problems.append("webui 列下标必须是 0..%d 连续：%s"
                        % (len(cols) - 1, sorted(seen_idx)))
    legacy = webui.get("legacyMinCols")
    if not isinstance(legacy, int) or legacy < 1 or legacy > len(cols):
        problems.append("webui.legacyMinCols 非法：%r" % (legacy,))

    status = protocol.get("status") or {}
    fields = status.get("fields") or []
    if not fields:
        problems.append("status.fields 为空")
    seen_stf = set()
    for i, f in enumerate(fields):
        ident(f.get("const"), "status.fields[%d].const" % i)
        if f.get("const") in seen_stf:
            problems.append("status 常量名重复：%r" % f.get("const"))
        seen_stf.add(f.get("const"))
        if not isinstance(f.get("name"), str) or not f.get("name"):
            problems.append("status.fields[%d].name 为空" % i)

    broadcast = protocol.get("broadcast") or {}
    actions = broadcast.get("actions") or []
    if len(actions) != 2:
        problems.append("broadcast.actions 应为 2 条（B6X/B7X），实际 %d" % len(actions))
    for a in actions:
        ident(a.get("cConst"), "broadcast.actions.cConst")
        ident(a.get("javaConst"), "broadcast.actions.javaConst")
        if not isinstance(a.get("value"), str) or not a.get("value"):
            problems.append("broadcast action 值为空：%r" % (a,))
    extras = broadcast.get("extras") or []
    if not extras:
        problems.append("broadcast.extras 为空")
    if len(set(extras)) != len(extras):
        problems.append("broadcast.extras 有重复：%s" % extras)

    paths = protocol.get("paths") or []
    by_id = {}
    for i, p in enumerate(paths):
        ident(p.get("const"), "paths[%d].const" % i)
        if not p.get("id") or p.get("id") in by_id:
            problems.append("paths[%d].id 为空或重复：%r" % (i, p.get("id")))
        by_id[p.get("id")] = p
        kind = p.get("kind")
        if kind == "absolute":
            if not isinstance(p.get("value"), str) or not p.get("value").startswith("/"):
                problems.append("路径 %r 的 value 必须是绝对路径" % p.get("id"))
        elif kind == "private_name":
            if not isinstance(p.get("name"), str) or not p.get("name") or "/" in p["name"]:
                problems.append("路径 %r 的 name 必须是非空纯文件名" % p.get("id"))
        elif kind == "literal":
            if not isinstance(p.get("value"), str):
                problems.append("路径 %r 的 value 必须是字符串" % p.get("id"))
        else:
            problems.append("路径 %r 的 kind 非法：%r" % (p.get("id"), kind))

    cleanup = protocol.get("cleanup") or {}
    for surface in ("daemon", "service_script", "app", "app_private"):
        ids = cleanup.get(surface)
        if not isinstance(ids, list) or not ids:
            problems.append("cleanup.%s 为空" % surface)
            continue
        if len(set(ids)) != len(ids):
            problems.append("cleanup.%s 有重复项" % surface)
        for pid in ids:
            p = by_id.get(pid)
            if p is None:
                problems.append("cleanup.%s 引用了不存在的路径 %r" % (surface, pid))
            elif surface in ("daemon", "service_script", "app") and p.get("kind") != "absolute":
                problems.append("cleanup.%s 的 %r 必须是绝对路径（shell unlink 口径）"
                                % (surface, pid))
            elif surface == "app_private" and p.get("kind") != "private_name":
                problems.append("cleanup.app_private 的 %r 必须是私有目录文件名" % pid)

    for plain in ("coldmax", "btRequest"):
        if not (protocol.get(plain) or {}).get("field"):
            problems.append("%s.field 为空" % plain)
    return problems


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
    # 布尔子字段（定义里 fields[].bool = true）要在产物里带上：界面据此渲成开关而非数字输入框。
    # 只在真为 true 时输出，避免每个字段都多一个恒 false 的键。
    if field.get("bool"):
        out["bool"] = True
    out["min"] = field["min"]
    out["max"] = field["max"]
    out["default"] = field["default"]
    return out


def _ui_plain(s):
    """界面化：去掉 markdown 强调/代码标记（文档专属，浮窗不渲染）。"""
    return s.replace("**", "").replace("`", "").strip()


_UI_DROP = ("由界面补写",)      # 只对配置文件成立的话


def _ui_clean(lines):
    """confNote 原文 → 界面浮窗可用文本：去段标（--- 标题 ---）、去前导空白、去配置文件专属标记与句子。"""
    out = []
    for raw in lines:
        s = _ui_plain(raw)
        if not s:
            continue
        if re.fullmatch(r"-{2,}.*-{2,}", s):        # --- 小节标题 --- （配置文件里的分隔，界面不需要）
            continue
        s = s.lstrip("#").strip()                   # 配置文件行首注释标记
        if not s or any(d in s for d in _UI_DROP):
            continue
        out.append(s)
    return out


def _ui_note(entry, labels=None):
    """由定义里的注释原文构建界面浮窗用的 uiNote（有序小节）；无任何注释时返回 []（则该键不输出 uiNote）。

    小节：作用（docDesc，缺则 desc）· 填写指导（confNote 清洗后）· 取值（rangeNote）·
    默认（defaultNote/factoryNote）· 生效条件（requires/hiddenWhen）。
    """
    nodes = []
    doc = _ui_plain(entry.get("docDesc") or entry.get("desc") or "")
    if doc:
        nodes.append({"title": "作用", "text": doc})
    guide = _ui_clean(entry.get("confNote") or [])
    if guide:
        nodes.append({"title": "填写指导", "text": "\n".join(guide)})
    if entry.get("rangeNote"):
        nodes.append({"title": "取值", "text": _ui_plain(entry["rangeNote"])})
    defaults = [_ui_plain(entry[k]) for k in ("defaultNote", "factoryNote") if entry.get(k)]
    if defaults:
        nodes.append({"title": "默认", "text": "\n".join(defaults)})
    labels = labels or {}

    def _label(k):
        return "%s（%s）" % (labels[k], k) if labels.get(k) else k

    conds = []
    if entry.get("requires"):
        conds.append("需先开启：" + " / ".join(_label(k) for k in entry["requires"]))
    if entry.get("hiddenWhen"):
        conds.append("以下键任一开启时本项隐藏："
                     + " / ".join(_label(k) for k in entry["hiddenWhen"]))
    if conds:
        nodes.append({"title": "生效条件", "text": "\n".join(conds)})
    # 「有注释才输出」：定义里写了 docDesc 或 confNote 才输出；都没有的键不产出 uiNote（逐字节不变）。
    if not nodes or not (entry.get("docDesc") or entry.get("confNote")):
        return []
    return nodes


def build_params_json(definition):
    """由定义构建界面消费的 params.json（键序完全由定义决定，保证幂等）。"""
    keys_out = {}
    labels = {e["key"]: e["label"] for e in definition["keys"]}
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
        # 反向依赖：这些键中任一为 1 时本行在界面上隐藏（仅界面渲染用，不给 C 端）。
        # 只有定义里写了才输出，未写则产物与改动前逐字节一致。
        if entry.get("hiddenWhen"):
            item["hiddenWhen"] = list(entry["hiddenWhen"])
        for opt in ("defaultNote", "factoryNote", "rangeNote"):
            if entry.get(opt):
                item[opt] = entry[opt]
        # 界面「说明浮窗」用的注释小节（顺序：作用 / 填写指导 / 取值 / 默认 / 生效条件）；
        # 只有定义里写了 docDesc/confNote 的键才输出，其余键产物逐字节不变。
        ui = _ui_note(entry, labels)
        if ui:
            item["uiNote"] = ui
        fields = entry.get("fields")
        item["fields"] = [_field_product(f) for f in fields] if fields else None
        # 表键（type=table）：界面按 rowPrefix 拼配置键、按 rowFields 校验逐字段、用 defaultRows 初始化表
        if entry["type"] == "table":
            item["rowPrefix"] = entry["rowPrefix"]
            row_fields = []
            for f in (entry.get("rowFields") or []):
                fo = {"label": f["label"], "min": f["min"], "max": f["max"],
                      "unit": f.get("unit", "")}
                if f.get("unitNote"):
                    fo["unitNote"] = f["unitNote"]
                # 允许留空的字段（如 PID_CUT 的三个倍率）：界面据此允许空输入，语义由 C 端定义
                if f.get("allowEmpty"):
                    fo["allowEmpty"] = True
                row_fields.append(fo)
            item["rowFields"] = row_fields
            item["defaultRows"] = list(entry.get("defaultRows") or [])
        # enum 的取值域（value = 落盘文本，label = 界面文案）与 fields 平级；
        # 只有 enum 键输出它，其余类型不带这个键。取值域的合法性由 check_params.py 校验。
        if entry["type"] == "enum":
            item["options"] = [{"value": opt["value"], "label": opt["label"]}
                               for opt in entry.get("options") or []]
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
        "compat": _compat_product(definition),
    }


def _compat_product(definition):
    """定义里的 compat 段 → 产物里逐字段原样透传（缺段时给空壳，产物仍自洽）。

    只放界面要用的三块：daemonAccept（判据）/ cleanup（清理候选）/ renames（旧名标注）。
    段内 notes 是定义内部溯源，不进产物（与其它段的 notes 同口径）。
    """
    c = definition.get("compat") or {}
    accept = c.get("daemonAccept") or {}
    cleanup = c.get("cleanup") or {}
    return {
        "daemonAccept": {
            "prefixes": list(accept.get("prefixes", [])),
            "exact": list(accept.get("exact", [])),
        },
        "cleanup": {
            "prefixes": list(cleanup.get("prefixes", [])),
            "exact": list(cleanup.get("exact", [])),
            "counterparts": dict(cleanup.get("counterparts", {})),
        },
        "renames": dict(c.get("renames", {})),
    }


def render_params_json(definition):
    # 紧凑输出（无缩进/无多余空格）：语义不变，仅减小落盘体积（APK 内该资产约省 1.6 KB）
    return json.dumps(build_params_json(definition), ensure_ascii=False,
                      separators=(",", ":")) + "\n"


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
            # 表键：一个簇一行，键名 = rowPrefix + 序号（从 1 起），行值 = defaultRows 对应项
            if entry["type"] == "table":
                for i, row in enumerate(entry.get("defaultRows") or []):
                    out.append("%s%d=%s" % (entry["rowPrefix"], i + 1, row))
                continue
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
    if entry["type"] == "table":
        return " ".join(str(v) for v in (entry.get("defaultRows") or []))
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
#   表驱动键（perf-int / sysfs 两张 X 表）的 clamp 边界随表行生成，C 端展开即用；
#   多值键与 SK_ZONE/SK_RESCAN 的解析仍在 tempctrl.c 手写，其边界只由审计核对。
#   只输出 C 端有展开点的宏：逐键/逐字段的 CFG_MIN/MAX_* 曾全量生成但无人引用，
#   2026-11-13 删除（唯一例外是 PID_CUT 的表键宏，解析代码直接引用）。
# --------------------------------------------------------------------------

# 配置项在 tempctrl.c 内的结构体实例名：生成头里的变量引用一律写成 <实例>.<字段>，
# 展开点（&var / var = def / &ivar / svar）因此无需感知结构体；审计侧剥掉该前缀后
# 与 params.def.json 的 audit.cVars 比对。
C_CFG_INSTANCE = "g_cfg"


def c_var_ref(name):
    """C 变量名 → 生成头内的结构体字段引用（g_cfg.<name>）。"""
    return "%s.%s" % (C_CFG_INSTANCE, name)


def first_cvar(definition, key):
    """键在 tempctrl.c 内的首个 C 变量名（无则 None）。"""
    vars_ = definition["audit"]["cVars"].get(key) or []
    return vars_[0] if vars_ else None


def _c_default(entry):
    val = entry["default"]
    if isinstance(val, str):
        return json.dumps(val, ensure_ascii=False)
    return str(val)


def c_layer_defaults(definition, group):
    """某层各 **int 取值位** 的代码默认值 → [(C 变量, 默认值)]（定义顺序，保证幂等）。

    用途：层开关由 1→0 时把该层运行时参数批量赋回默认值（复位代码在 tempctrl.c）。
    · C 变量取自 audit.cVars（fields[].cVar 可能为 null，不可用）；
    · 默认值 = 该取值位的 default（单值键取键 default，多值键取字段 default），
      它与 C 端 static 初值的一致性由 audit 的默认值核对逐位保证；
    · 路径键不入表：`type=path` 没有数值语义，默认值由 CFG_DEFAULT_* 宏与
      set_default_log_path() 分别处理（后者含"私有目录不可用→兜底"逻辑）。
    """
    rows = []
    c_vars_all = definition.get("audit", {}).get("cVars", {})
    for entry in definition["keys"]:
        if entry["group"] != group or entry["role"] == "master":
            continue                      # 各层总开关自身不复位（PERF 默认 1，复位会立刻自开）
        if not entry.get("daemonConsumes", True):
            continue
        if entry["type"] == "path":
            continue
        c_vars = c_vars_all.get(entry["key"]) or []
        if entry["type"] == "multi":
            for i, field in enumerate(entry.get("fields") or []):
                if i < len(c_vars) and c_vars[i]:
                    rows.append((c_vars[i], field["default"]))
        elif c_vars and c_vars[0]:
            rows.append((c_vars[0], entry["default"]))
    return rows


def build_c_header(definition):
    entries = definition["keys"]
    daemon = [e for e in entries if e.get("daemonConsumes", True)]
    perf_int = [e for e in entries if e.get("cTable") == "perf-int"]
    sysfs = [e for e in entries if e.get("cTable") == "sysfs"]

    lines = []
    lines.append("/* 本文件由 python 参数定义/gen_params.py 生成，勿手改。")
    lines.append(" * 唯一手写处：%s；改动后重跑生成脚本。" % DEF_REL)
    lines.append(" * 只定义宏。X 宏的展开点必须在 struct SysfsCfgKey / enum SK_* 与配置结构体")
    lines.append(" * 实例（%s，见 tempctrl.c）声明之后。 */" % C_CFG_INSTANCE)
    lines.append("#ifndef PARAMS_GENERATED_H")
    lines.append("#define PARAMS_GENERATED_H")
    lines.append("")

    lines.append("/* 性能层单值键表（PERF_ENABLED=1）→ INT_CFG_KEYS[]：X(键名, C 变量, min, max) */")
    lines.append("#define %s(X) \\" % C_TABLE_MACRO["perf-int"])
    rows = []
    for e in perf_int:
        rows.append('    X("%s", %s, %d, %d)'
                    % (e["key"], c_var_ref(first_cvar(definition, e["key"])), e["min"], e["max"]))
    lines.append(" \\\n".join(rows))
    lines.append("")

    lines.append("/* sysfs 层键表（SYSFS_ENABLED=1）→ SYSFS_CFG_KEYS[]：")
    lines.append(" *   X(键名, kind, ivar, imin, imax, svar, ssize)")
    lines.append(" * kind/SK_INT 槽位钳制范围由本表给出；SK_ZONE/SK_RESCAN 的逐字段校验在 tempctrl.c 解析代码内。 */")
    lines.append("#define %s(X) \\" % C_TABLE_MACRO["sysfs"])
    rows = []
    for e in sysfs:
        cvar = first_cvar(definition, e["key"])
        if e.get("cKind") == "SK_INT":
            rows.append('    X("%s", SK_INT, &%s, %d, %d, NULL, 0)'
                        % (e["key"], c_var_ref(cvar), e["min"], e["max"]))
        elif e.get("cKind") == "SK_PATH":
            rows.append('    X("%s", SK_PATH, NULL, 0, 0, %s, sizeof(%s))'
                        % (e["key"], c_var_ref(cvar), c_var_ref(cvar)))
        else:
            rows.append('    X("%s", %s, NULL, 0, 0, NULL, 0)'
                        % (e["key"], e.get("cKind")))
    lines.append(" \\\n".join(rows))
    lines.append("")

    # LOG_FILE 的默认值由 set_default_log_path() 在运行期按二进制名派生，不生成宏
    # （固化路径会绕过「私有目录不可用→兜底 /cache」的逻辑）。
    paths = [e for e in daemon if e["type"] == "path" and e["key"] != "LOG_FILE"]
    lines.append("/* 路径键默认值（C 端同名变量初值；LOG_FILE 不在此列，运行期由 PRIVATE_DIR + 二进制名派生）*/")
    for e in paths:
        lines.append("#define CFG_DEFAULT_%s %s" % (e["key"], _c_default(e)))
    lines.append("")

    tables = [e for e in daemon if e["type"] == "table"]
    if tables:
        lines.append("/* 表键（type=table）：行前缀、逐字段 clamp 边界与默认行。解析代码在 tempctrl.c")
        lines.append(" * 手写，用这些宏取前缀/边界/默认行，避免与定义各写一份（行数可变，故不并入上方 X 表）。 */")
        for e in tables:
            lines.append("#define CFG_ROW_PREFIX_%s %s"
                         % (e["key"], json.dumps(e["rowPrefix"], ensure_ascii=False)))
            for i, f in enumerate(e.get("rowFields") or []):
                lines.append("#define CFG_MIN_%s_F%d %d" % (e["key"], i + 1, f["min"]))
                lines.append("#define CFG_MAX_%s_F%d %d" % (e["key"], i + 1, f["max"]))
            for i, row in enumerate(e.get("defaultRows") or []):
                lines.append("#define CFG_DEFAULT_%s_%d %s"
                             % (e["key"], i + 1, json.dumps(row, ensure_ascii=False)))
        lines.append("")

    lines.append("/* 各层 int 取值位的**代码默认值**表：层开关由 1→0 时，tempctrl.c 展开本表把该层")
    lines.append(" * 运行时参数批量赋回代码默认值（= 等同该层配置不存在）。行格式 X(C 变量, 默认值)。")
    lines.append(" * 路径键不入表：非 LOG_FILE 的走上方 CFG_DEFAULT_* 宏；LOG_FILE 走 set_default_log_path()")
    lines.append(" * （该函数按二进制名派生路径，私有目录不可用时兜底 /cache，照抄宏会绕过兜底）。")
    lines.append(" * 各层总开关自身同样不入表（PERF_ENABLED 默认 1，复位它会立刻自我重开）。 */")
    for group, macro in (("perf", "CFG_PERF_DEFAULTS"), ("sysfs", "CFG_SYSFS_DEFAULTS")):
        lines.append("#define %s(X) \\" % macro)
        rows = ['    X(%s, %d)' % (c_var_ref(var), val)
                for var, val in c_layer_defaults(definition, group)]
        lines.append(" \\\n".join(rows))
        lines.append("")

    lines.append("#endif  /* PARAMS_GENERATED_H */")
    return "\n".join(lines) + "\n"


# --------------------------------------------------------------------------
# 协议产物构建（protocol.def.json → C 头 / Java 常量 / C·JS·脚本区间）
# --------------------------------------------------------------------------

def _c_str(s):
    """C/Java/JS 通用双引号字符串字面量（本文件的取值均为 ASCII 路径/标识，无转义歧义）。"""
    return json.dumps(s, ensure_ascii=False)


def _upper_ident(name):
    return re.sub(r"[^A-Za-z0-9]+", "_", name).upper()


def _java_extra_const(name):
    """camelCase extra → Java 常量名：windOC → EXTRA_WIND_OC。"""
    s = re.sub(r"([a-z0-9])([A-Z])", r"\1_\2", name)
    return "EXTRA_" + _upper_ident(s)


def _protocol_paths(protocol):
    return {p["id"]: p for p in protocol["paths"]}


def build_protocol_c_header(protocol):
    """协议常量 C 头：status 字段、广播 action、路径/文件名、列枚举、清理清单。"""
    lines = []
    lines.append("/* 本文件由 python 参数定义/gen_params.py 生成，勿手改。")
    lines.append(" * 唯一手写处：%s；改动后重跑生成脚本。" % PROTO_DEF_REL)
    lines.append(" * 私有目录路径依赖 PRIVATE_DIR，故本头须在 PRIVATE_DIR 定义之后包含。 */")
    lines.append("#ifndef PROTOCOL_GENERATED_H")
    lines.append("#define PROTOCOL_GENERATED_H")
    lines.append("")

    lines.append("/* status 文件字段名（行格式「字段名=值」，字段名含 '='） */")
    for f in protocol["status"]["fields"]:
        lines.append('#define %-20s %s' % (f["const"], _c_str(f["name"] + "=")))
    lines.append("")

    lines.append("/* 广播 action（与 Java Protocol.ACTION_* 同值） */")
    for a in protocol["broadcast"]["actions"]:
        lines.append('#define %-20s %s' % (a["cConst"], _c_str(a["value"])))
    lines.append("")

    lines.append("/* 路径与文件名（R10：core/daemon/脚本三方同源） */")
    for p in protocol["paths"]:
        const, kind = p["const"], p["kind"]
        if kind == "absolute":
            lines.append('#define PROTO_PATH_%-16s %s' % (const, _c_str(p["value"])))
        elif kind == "private_name":
            lines.append('#define PROTO_NAME_%-16s %s' % (const, _c_str(p["name"])))
            lines.append('#define PROTO_PATH_%-16s PRIVATE_DIR "/%s"' % (const, p["name"]))
        else:
            lines.append('#define PROTO_%-21s %s' % (const, _c_str(p["value"])))
    lines.append("")

    lines.append("/* 宿主包名与脚本名（R22：与 params.def.json appPackage 一致，CI 断言） */")
    lines.append('#define PROTO_HOST_PKG       %s' % _c_str(protocol["app"]["hostPackage"]))
    lines.append('#define PROTO_HOST_DATA_DIR  "/data/data/" PROTO_HOST_PKG')
    lines.append('#define PROTO_SCRIPT_NAME    %s' % _c_str(protocol["app"]["scriptName"]))
    lines.append("")
    lines.append('#define PROTO_COLDMAX_FIELD  %s' % _c_str(protocol["coldmax"]["field"]))
    lines.append('#define PROTO_BT_REQ_FIELD   %s' % _c_str(protocol["btRequest"]["field"]))
    lines.append("")

    lines.append("/* WebUI 曲线列下标（写端用位置实参，读端按这些常量取列） */")
    lines.append("enum WebuiDataCol {")
    for col in protocol["webui"]["cols"]:
        lines.append("    WEBUI_COL_%s = %d,   /* %s（%s） */"
                     % (_upper_ident(col["name"]), col["index"],
                        col["label"], col.get("unit", "")))
    lines.append("    WEBUI_COL_COUNT = %d" % protocol["webui"]["count"])
    lines.append("};")
    lines.append("#define WEBUI_COLS_LEGACY_MIN %d" % protocol["webui"]["legacyMinCols"])
    lines.append("")

    by_id = _protocol_paths(protocol)
    ids = protocol["cleanup"]["daemon"]
    lines.append("/* 卸载清理清单（daemon 执行面）：X(绝对路径宏) */")
    lines.append("#define PROTO_CLEANUP_DAEMON(X) \\")
    rows = ["    X(PROTO_PATH_%s)" % by_id[pid]["const"] for pid in ids]
    lines.append(" \\\n".join(rows))
    lines.append("")
    lines.append("#endif  /* PROTOCOL_GENERATED_H */")
    return "\n".join(lines) + "\n"


def build_protocol_java(protocol):
    """协议常量 Java 类：列下标、status 字段、广播 action/extra、路径与清理清单。"""
    lines = []
    lines.append("package com.example.waspwingtempctrl;")
    lines.append("")
    lines.append("/**")
    lines.append(" * 跨端协议常量。由 {@code python 参数定义/gen_params.py} 从")
    lines.append(" * {@code %s} 生成，勿手改。" % PROTO_DEF_REL)
    lines.append(" *")
    lines.append(" * <p>C 端对应 {@code lsp模块/daemon/protocol_generated.h}；WebUI 对应 app.js 的生成区块。")
    lines.append(" */")
    lines.append("public final class Protocol {")
    lines.append("")
    lines.append("    private Protocol() {")
    lines.append("    }")
    lines.append("")

    lines.append("    // ==================== WebUI 曲线列（tempctrl_webui.data） ====================")
    for col in protocol["webui"]["cols"]:
        lines.append("    public static final int WEBUI_COL_%s = %d;"
                     % (_upper_ident(col["name"]), col["index"]))
    lines.append("    public static final int WEBUI_COL_COUNT = %d;" % protocol["webui"]["count"])
    lines.append("    public static final int WEBUI_COLS_LEGACY_MIN = %d;"
                 % protocol["webui"]["legacyMinCols"])
    lines.append("")

    lines.append("    // ==================== status 文件字段名 ====================")
    for f in protocol["status"]["fields"]:
        lines.append("    public static final String %s = %s;"
                     % (f["const"], _c_str(f["name"] + "=")))
    lines.append("")

    lines.append("    // ==================== 广播 action 与 extra ====================")
    for a in protocol["broadcast"]["actions"]:
        lines.append("    public static final String %s = %s;"
                     % (a["javaConst"], _c_str(a["value"])))
    for e in protocol["broadcast"]["extras"]:
        lines.append("    public static final String %s = %s;"
                     % (_java_extra_const(e), _c_str(e)))
    lines.append("")

    lines.append("    // ==================== 路径与文件名 ====================")
    for p in protocol["paths"]:
        const, kind = p["const"], p["kind"]
        if kind == "absolute":
            lines.append("    public static final String PATH_%s = %s;"
                         % (const, _c_str(p["value"])))
        elif kind == "private_name":
            lines.append("    public static final String NAME_%s = %s;"
                         % (const, _c_str(p["name"])))
        else:
            lines.append("    public static final String %s = %s;"
                         % (const, _c_str(p["value"])))
    lines.append("    public static final String HOST_PKG = %s;"
                 % _c_str(protocol["app"]["hostPackage"]))
    lines.append("    public static final String SCRIPT_NAME = %s;"
                 % _c_str(protocol["app"]["scriptName"]))
    lines.append("    public static final String COLDMAX_FIELD = %s;"
                 % _c_str(protocol["coldmax"]["field"]))
    lines.append("    public static final String BT_REQ_FIELD = %s;"
                 % _c_str(protocol["btRequest"]["field"]))
    lines.append("")

    by_id = _protocol_paths(protocol)
    for surface, const in (("app", "CLEANUP_APP"), ("app_private", "CLEANUP_APP_PRIVATE")):
        lines.append("    /** 卸载清理清单（%s 执行面）。 */" % surface)
        lines.append("    public static final String[] %s = {" % const)
        for pid in protocol["cleanup"][surface]:
            p = by_id[pid]
            value = p["value"] if p["kind"] == "absolute" else p["name"]
            lines.append("        %s," % _c_str(value))
        lines.append("    };")
        lines.append("")
    if lines[-1] == "":
        lines.pop()
    lines.append("}")
    return "\n".join(lines) + "\n"


def render_tempctrl_protocol_region(definition, protocol):
    """tempctrl.c 内的生成区块。

    这里保留字面量是为了 CI 既有的文本断言（`#define WEBUI_DATA_COLS 数字` /
    `BROADCAST_EXTRAS[] = { "..." }` 的 sed/grep）继续生效；字面量本身由
    protocol.def.json 生成，手改会被断言 A 判为漂移。
    """
    cols = protocol["webui"]["cols"]
    specs = {"int": "%d", "long": "%ld"}
    fmt = ",".join(specs[c["cType"]] for c in cols) + "\n"
    order = "，".join("%d=%s" % (c["index"], c["label"]) for c in cols)
    lines = [C_PROTO_START]
    lines.append('#include "protocol_generated.h"')
    lines.append("")
    lines.append("/* WebUI 曲线列契约：列数唯一声明（CI R7 断言本行数字 = WEBUI_ROW_FMT 的转换符个数）")
    lines.append(" * 列序：%s" % order)
    lines.append(" * 列序与语义的权威声明是 %s 的 webui.cols。" % PROTO_DEF_REL)
    lines.append(" */")
    lines.append("#define WEBUI_DATA_PATH       PROTO_PATH_DATA")
    lines.append("#define WEBUI_DATA_MAX_LINES  %d" % definition["chart"]["rollingMaxLines"])
    lines.append("#define WEBUI_DATA_COLS       %d" % len(cols))
    lines.append("#define WEBUI_ROW_FMT         %s" % _c_str(fmt))
    lines.append("")
    lines.append("/* 广播 extra 名单（action 宏在 protocol_generated.h）；须与 Java Protocol.java 一致 */")
    lines.append("static const char *const BROADCAST_EXTRAS[] = {")
    for e in protocol["broadcast"]["extras"]:
        lines.append("    %s," % _c_str(e))
    lines.append("};")
    lines.append("#define BROADCAST_EXTRAS_N  ((int)(sizeof(BROADCAST_EXTRAS) / sizeof(BROADCAST_EXTRAS[0])))")
    lines.append(C_PROTO_END)
    return "\n".join(lines) + "\n"


def render_webui_js_region(protocol):
    lines = [JS_PROTO_START]
    for col in protocol["webui"]["cols"]:
        lines.append("    var WEBUI_COL_%s = %d;"
                     % (_upper_ident(col["name"]), col["index"]))
    lines.append("    var WEBUI_COL_COUNT = %d;" % protocol["webui"]["count"])
    lines.append("    var WEBUI_COLS_LEGACY_MIN = %d;" % protocol["webui"]["legacyMinCols"])
    lines.append(JS_PROTO_END)
    return "\n".join(lines) + "\n"


def render_deploy_sh_region(protocol):
    by_id = _protocol_paths(protocol)
    lines = [SH_PROTO_START]
    lines.append("HOST_PKG=%s" % protocol["app"]["hostPackage"])
    lines.append("HOST_DIR=/data/data/$HOST_PKG")
    lines.append("HOST_FILES=$HOST_DIR/files")
    lines.append("SCRIPT_NAME=%s" % protocol["app"]["scriptName"])
    for p in protocol["paths"]:
        const, kind = p["const"], p["kind"]
        if kind == "absolute":
            lines.append("PROTO_PATH_%s=%s" % (const, p["value"]))
        elif kind == "private_name":
            lines.append("PROTO_NAME_%s=%s" % (const, p["name"]))
        else:
            lines.append("PROTO_%s=%s" % (const, p["value"]))
    lines.append("BIN=$PROTO_PATH_BIN")
    lines.append("SVC_LOG=$PROTO_PATH_SERVICE_LOG")
    lines.append("AU_CONF=$HOST_FILES/$PROTO_NAME_CONFIG")
    lines.append("AU_STAMP=$HOST_FILES/$PROTO_NAME_DEPLOY_STAMP")
    lines.append("AU_MANIFEST=$HOST_FILES/$PROTO_NAME_MANIFEST")
    special = {"bin": "$BIN", "bin_new": "$BIN.new", "service_log": "$SVC_LOG"}
    tokens = []
    for pid in protocol["cleanup"]["service_script"]:
        tokens.append(special.get(pid, "$PROTO_PATH_%s" % by_id[pid]["const"]))
    lines.append('PROTO_CLEANUP_PATHS="%s"' % " ".join(tokens))
    lines.append(SH_PROTO_END)
    return "\n".join(lines) + "\n"


def render_mainhook_mirror(protocol):
    """MainHook 的广播 extra 文本镜像。

    CI 的 R2 步骤按 `getIntExtra("...")` 文本 grep 两端 extra 名；实际调用已改为
    Protocol.EXTRA_*，故由生成器写一段只含注释的镜像供该断言读取。
    check_params 会核对镜像与 protocol.def.json 的 extra 顺序一致。
    """
    lines = [MH_PROTO_START]
    for e in protocol["broadcast"]["extras"]:
        lines.append('    // getIntExtra("%s", 0)' % e)
    lines.append(MH_PROTO_END)
    return "\n".join(lines) + "\n"


# --------------------------------------------------------------------------
# 产物写入
# --------------------------------------------------------------------------

PROTOCOL_PRODUCTS = ("protocol-c-header", "protocol-java", "tempctrl-region",
                     "webui-js", "deploy-sh", "mainhook-mirror")


def render_product(pid, definition, protocol=None):
    if pid == "params.json":
        return render_params_json(definition)
    if pid == "profile.conf":
        return render_conf(definition)
    if pid == "c-header":
        return build_c_header(definition)
    if pid == "doc-table":
        return render_doc_region(definition)
    if pid in PROTOCOL_PRODUCTS:
        protocol = protocol or load_protocol()
        if pid == "protocol-c-header":
            return build_protocol_c_header(protocol)
        if pid == "protocol-java":
            return build_protocol_java(protocol)
        if pid == "tempctrl-region":
            return render_tempctrl_protocol_region(definition, protocol)
        if pid == "webui-js":
            return render_webui_js_region(protocol)
        if pid == "deploy-sh":
            return render_deploy_sh_region(protocol)
        return render_mainhook_mirror(protocol)
    raise KeyError(pid)


def find_region(text, pid):
    """返回产物 pid 的生成区间 (起点, 终点)；终点 = 结束标记行尾（不含换行）。"""
    if pid not in REGION_MARKERS:
        raise KeyError(pid)
    start, end = REGION_MARKERS[pid]
    i = text.find(start)
    j = text.find(end)
    if i < 0 or j < 0:
        raise ValueError("%s 缺少生成区间标记（%s ... %s）" % (pid, start, end))
    return i, j + len(end)


def find_doc_region(text):
    return find_region(text, "doc-table")


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
    i, j = find_region(current, pid)
    return current[:i] + text.rstrip("\n") + current[j:]


def write_product(pid, definition):
    product = product_by_id(pid)
    path = product_path(product)
    text = render_product(pid, definition)
    if product.kind == "full":
        new_text = text
    else:
        current = read_text(path) if os.path.exists(path) else ""
        i, j = find_region(current, pid)
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
                 "parse_common_cfg", "config_apply_prepass_key", "load_config"):
        body = _func_body(c_text, func)
        for m in re.finditer(r'strcmp\(\s*key\s*,\s*"([A-Z0-9_]+)"\s*\)', body):
            found.setdefault(m.group(1), func)
    return found


def parse_c_defaults(c_text):
    """static/局部 int 与 char[] 初值 → {var: 初值文本}。

    配置项已收进配置结构体，不再有独立 static 初值；同时解析该实例的指定初始化器
    （.FIELD = value），字段名按原变量名登记，供默认值审计继续逐位核对。
    """
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
    # 配置结构体实例的指定初始化器（行内可带 // 注释；字符串内的 // 不切分）
    m = re.search(r"struct\s+TempCfg\s*\{.*?\}\s*;\s*(?:static\s+)?struct\s+TempCfg\s+%s\s*=\s*\{(.*?)\n\};"
                  % re.escape(C_CFG_INSTANCE), c_text, re.S)
    if m:
        for line in m.group(1).splitlines():
            mm = re.match(r"\s*\.(\w+)\s*=\s*(.+)$", line)
            if not mm:
                continue
            var, raw = mm.group(1), mm.group(2)
            if '"' in raw:
                q = re.search(r'"([^"]*)"', raw)
                defaults.setdefault(var, q.group(1) if q else "")
            else:
                raw = raw.split("//", 1)[0].strip().rstrip(",").strip()
                if re.match(r"^-?\d+$", raw):
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
    for m in re.finditer(r'X\(\s*"([A-Z0-9_]+)"\s*,\s*(?:%s\.)?(\w+)\s*,\s*'
                         r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*\)'
                         % re.escape(C_CFG_INSTANCE), body):
        lo, hi = resolve(m.group(3)), resolve(m.group(4))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(2), set()).add((lo, hi))

    body = _block(gen_text, r"#define\s+%s\(X\)" % C_TABLE_MACRO["sysfs"], r"\n\n")
    for m in re.finditer(r'X\(\s*"([A-Z0-9_]+)"\s*,\s*(SK_\w+)\s*,\s*&?(?:%s\.)?(\w+)\s*,\s*'
                         r'([A-Za-z_0-9]+)\s*,\s*([A-Za-z_0-9]+)\s*,'
                         % re.escape(C_CFG_INSTANCE), body):
        if m.group(2) != "SK_INT":
            continue          # SK_PATH 无范围；SK_ZONE / SK_RESCAN 的 clamp 在调用点收
        lo, hi = resolve(m.group(4)), resolve(m.group(5))
        if lo is not None and hi is not None:
            ranges.setdefault(m.group(3), set()).add((lo, hi))
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


def expected_conf_keys(entries):
    """profile.conf 应有的键序列：table 键展开为 rowPrefix + 序号（1 起），其余为键名。"""
    out = []
    for e in entries:
        if e.get("type") == "table":
            for i in range(len(e.get("defaultRows") or [])):
                out.append("%s%d" % (e["rowPrefix"], i + 1))
        else:
            out.append(e["key"])
    return out


def table_binding_problems(entry, c_text, h_text):
    """table 键在生成头与 tempctrl.c 的绑定核对：行前缀、逐字段边界、默认行都必须单源引用。"""
    probs = []
    key = entry["key"]
    pref_macro = "CFG_ROW_PREFIX_%s" % key
    if ("#define %s %s" % (pref_macro, json.dumps(entry["rowPrefix"], ensure_ascii=False))) not in h_text:
        probs.append("表键 %s 的生成头缺少行前缀宏 %s" % (key, pref_macro))
    if pref_macro not in c_text:
        probs.append("表键 %s 的解析未引用 %s（行前缀未单一来源）" % (key, pref_macro))
    for i, f in enumerate(entry.get("rowFields") or []):
        for kind in ("MIN", "MAX"):
            mac = "CFG_%s_%s_F%d" % (kind, key, i + 1)
            if mac not in c_text:
                probs.append("表键 %s 第 %d 字段的边界未引用 %s" % (key, i + 1, mac))
    for i in range(len(entry.get("defaultRows") or [])):
        mac = "CFG_DEFAULT_%s_%d" % (key, i + 1)
        if mac not in c_text:
            probs.append("表键 %s 第 %d 个默认行未引用 %s（复位时无法取到默认行）" % (key, i + 1, mac))
    return probs


def _c_key_accept(c_text, gen_text):
    """tempctrl.c 里按 key 比较的 strncmp 接受集（前缀 / 整键），宏名就地展开。

    只认 `strncmp(key, …)`——锚在 `key` 上，避免把 strncmp(q,…)/strncmp(p,…) 等非「键比较」处
    （迁移函数里对行字符串的比较）误当接受集。前缀 = 以 '_' 结尾者，其余按整键收。
    """
    smac = dict(parse_c_string_macros(c_text))
    smac.update(parse_c_string_macros(gen_text))
    prefixes, exact = set(), set()
    for m in re.finditer(r'strncmp\(\s*key\s*,\s*(?:"([^"]*)"|(\w+))\s*,', c_text):
        lit, ident = m.group(1), m.group(2)
        val = lit if lit is not None else smac.get(ident, "")
        if not val:
            continue
        (prefixes if val.endswith("_") else exact).add(val)
    return prefixes, exact


def audit_compat(definition, findings):
    """compat.daemonAccept 与 tempctrl.c 真实接受集双向核对（防两处漂移）。"""
    def err(msg):
        findings.append(("ERROR", msg))

    def info(msg):
        findings.append(("INFO", msg))

    compat = definition.get("compat")
    if not compat:
        err("定义缺少 compat 段（未定义键判据 / 遗留键清理的单一来源）")
        return
    accept = compat.get("daemonAccept") or {}
    declared_prefixes = set(accept.get("prefixes", []))
    declared_exact = set(accept.get("exact", []))
    exempted = accept.get("exempted") or {}
    if not isinstance(exempted, dict):
        err("compat.daemonAccept.exempted 应为「键 → 理由」的对象")
        exempted = {}
    table_prefixes = set(e.get("rowPrefix") for e in definition["keys"]
                         if e.get("type") == "table" and e.get("rowPrefix"))

    c_src = next(s for s in SOURCES if s.id == "c")
    c_text = read_text(source_path(c_src))
    gen_text = read_text(product_path(product_by_id("c-header")))
    c_prefixes, c_exact = _c_key_accept(c_text, gen_text)
    c_all = c_prefixes | c_exact

    # 方向 1：声明的（界面判「未定义」要用的）必须真被 C 接受
    for p in sorted(declared_prefixes):
        if p not in c_prefixes:
            err("compat.daemonAccept.prefixes 声明了 %r，但 tempctrl.c 未按此前缀接受键" % p)
    for e in sorted(declared_exact):
        if e not in c_exact:
            err("compat.daemonAccept.exact 声明了 %r，但 tempctrl.c 未接受该整键" % e)

    # 方向 2：C 接受的每一项（非表前缀）必须被「声明 ∪ 表前缀 ∪ 豁免」覆盖，否则判据会漏
    for p in sorted(c_prefixes):
        if p not in declared_prefixes and p not in table_prefixes and p not in exempted:
            err("tempctrl.c 接受的键前缀 %r 既未在 compat.daemonAccept 声明、也不是表前缀、"
                "也未列入 exempted" % p)
    for e in sorted(c_exact):
        if e not in declared_exact and e not in exempted:
            err("tempctrl.c 接受的整键 %r 未在 compat.daemonAccept.exact 声明、也未列入 exempted" % e)

    # 豁免项自身必须成立：真是 C 的接受项、不在声明里、且写了理由
    for name, reason in sorted(exempted.items()):
        if name not in c_all:
            err("compat.daemonAccept.exempted 含 %r，但 tempctrl.c 并不接受它（豁免失效，应删）" % name)
        if name in declared_prefixes or name in declared_exact:
            err("compat.daemonAccept.exempted 含 %r，但它同时又出现在声明里（自相矛盾）" % name)
        if not str(reason).strip():
            err("compat.daemonAccept.exempted 的 %r 未写理由" % name)

    # 清理族前缀必须落在已声明接受集内（清理只碰「C 端认得」或「两边都不认」的键）
    cleanup = compat.get("cleanup") or {}
    for p in sorted(set(cleanup.get("prefixes", []))):
        if p not in declared_prefixes:
            err("compat.cleanup.prefixes 含 %r，但它不在 daemonAccept.prefixes 里" % p)
    for _old, new in sorted((cleanup.get("counterparts") or {}).items()):
        if new not in table_prefixes:
            err("compat.cleanup.counterparts 的现表前缀 %r 不是任何表的 rowPrefix" % new)
    info("compat：C 接受 %s；界面判据声明 %s / 表前缀 %s / 有意豁免 %s"
         % (sorted(c_all), sorted(declared_prefixes | declared_exact),
            sorted(table_prefixes), sorted(exempted)))


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
        expect_conf = expected_conf_keys(entries)   # table 键在此展开为其 rowPrefix+序号 行
        if conf_keys != expect_conf:
            err("profile.conf 键集合/顺序与定义不一致：多 %s / 少 %s / 顺序不同 %s"
                % (sorted(set(conf_keys) - set(expect_conf)),
                   sorted(set(expect_conf) - set(conf_keys)),
                   conf_keys != expect_conf and not (set(conf_keys) ^ set(expect_conf))))
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
        # table 键（无 cTable）：解析由 tempctrl.c 手写，靠行前缀宏确认它被处理了，
        # 并逐项核对逐字段边界/默认行宏的引用（绑定宏见生成头的「表键」段）。
        h_text = read_text(product_path(product_by_id("c-header")))
        for e in entries:
            if e.get("type") != "table" or not e.get("daemonConsumes", True):
                continue
            for p in table_binding_problems(e, c_text, h_text):
                err(p)
            if ("CFG_ROW_PREFIX_%s" % e["key"]) in c_text:
                table_keys.append(e["key"])
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
            if entry.get("type") == "table":
                continue        # 表键行数可变、无固定取值位，其 C 绑定由 table_binding_problems 单独核对
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
            elif rule["kind"] == "structInitEqualDefaults":
                # 结构体成员没有独立 static 初值，parse_c_defaults 抓不到（如层总开关存在
                # struct PrepassCfg 里）。按成员名取其在结构体声明中的序号，与该实例的
                # 初始化列表逐位比对，避免 cVars 只能映射到「不存在的变量」而恒跳过。
                sname, inst = rule["struct"], rule["instance"]
                members = rule.get("members") or {}
                sbody = _block(c_text, r"struct\s+%s\s*\{" % re.escape(sname), r"\};")
                order = re.findall(r"(?m)^\s*int\s+(\w+)\s*;", sbody)
                minit = re.search(r"struct\s+%s\s+%s\s*=\s*\{([^}]*)\}"
                                  % (re.escape(sname), re.escape(inst)), c_text)
                if not order or not minit:
                    info("crossCheck「%s」无法自动核对：未找到 struct %s 的声明或 %s 的初始化列表"
                         % (rid, sname, inst))
                else:
                    vals = [v.strip() for v in minit.group(1).split(",")]
                    for member, key in sorted(members.items()):
                        entry = next((e for e in entries if e["key"] == key), None)
                        if entry is None:
                            err("crossCheck「%s」引用了不存在的键 %s" % (rid, key))
                        elif member not in order:
                            err("crossCheck「%s」：struct %s 无成员 %s"
                                % (rid, sname, member))
                        elif order.index(member) >= len(vals):
                            err("crossCheck「%s」：%s 的初始化列表缺成员 %s"
                                % (rid, inst, member))
                        elif vals[order.index(member)] != str(entry["default"]):
                            err("crossCheck「%s」不一致：%s.%s=%s ≠ 定义 %s 的 default=%s"
                                % (rid, inst, member, vals[order.index(member)],
                                   key, entry["default"]))
            else:
                err("未知 crossCheck 类型 %r（%s）" % (rule["kind"], rid))

    # ---- 4. R4 包名单一来源 / R6 本项目包名 ----
    audit_packages(definition, findings)
    audit_app_package(definition, findings)
    audit_compat(definition, findings)

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
