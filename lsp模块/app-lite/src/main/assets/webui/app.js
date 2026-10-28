/* 飞智温控增强 Lite —— 真实前端（ES5，零外部资源）。
 * 桥契约见 .claude/subagent方案存放区/webui极简版-方案.md 的「WebBridge 契约」。
 */
(function () {
    'use strict';

    var SERIES = [
        {id: 'batt', label: '电池温度', color: '#F44336', axis: 'left', fmt: 'temp', on: true},
        {id: 'cool', label: '制冷', color: '#4CAF50', axis: 'right', fmt: 'int', on: true},
        {id: 'rpm', label: '风扇(百rpm)', color: '#9C27B0', axis: 'left', fmt: 'rpm', on: true},
        {id: 'hot', label: '热端温度', color: '#E91E63', axis: 'left', fmt: 'temp', on: true},
        {id: 'cold', label: '冷端温度', color: '#2196F3', axis: 'left', fmt: 'temp', on: false},
        {id: 'cpu', label: 'CPU温度', color: '#FF9800', axis: 'left', fmt: 'temp', on: false}
    ];

    var MAIN_GROUPS = ['debug', 'perf', 'sysfs', 'launch'];
    var WEBUI_KEYS = ['UI_GAP_SEC', 'UI_RPM_AXIS_MIN', 'UI_BACK_HIDE', 'UI_AUTO_UPDATE'];
    var TABS = ['status', 'config', 'chart', 'log'];
    var THEME_KEY = 'lite.theme';
    // 生效主题以控制台消息上报给原生（决定底部导航栏颜色），不新增桥方法；
    // 放行黑底前不上报，免得黑屏期间底部先亮出一条浅色导航栏
    var THEME_LOG_PREFIX = 'lite-theme:';
    var booted = false;
    var LOG_MAX = 500;

    var state = {
        defs: null,
        snapshot: null,
        values: {},
        rows: {},
        groups: {},
        badges: {},
        expanded: {},
        tab: 'config',
        timers: {chart: null, log: null, status: null},
        statusRetryTimer: null,
        statusEnteredAt: 0,
        writeTimer: null,
        pending: {},
        pendingMeta: {},
        pendingTarget: {},
        theme: 'follow',
        chart: {
            points: [],
            lastT: 0,
            lastPoint: null,
            windowSec: 360,
            detectSec: 3,
            gapMax: 15,
            rpmAxisMin: 3000,
            maxLines: 720,
            maxWindow: 720,
            drawCount: 0,
            canvas: null,
            ctx: null,
            loaded: false,
            series: {batt: true, cool: true, rpm: true, hot: true, cold: false, cpu: false}
        },
        log: {loaded: false, lastLine: null, count: 0, follow: true},
        statusLoaded: false,
        busy: false,
        settingsTimer: null,
        confirmTimer: null,
        confirmAction: null
    };

    var cache = {};
    var ERR_WORDS = ['失败', '错误', '无法', '异常', 'error', 'fail'];
    var WARN_WORDS = ['警告', '未生效', '超时', '未就绪', '断联', '断开', '丢失', '停滞', '强制'];

    function hasAny(line, words) {
        for (var i = 0; i < words.length; i++) {
            if (line.indexOf(words[i]) !== -1) {
                return true;
            }
        }
        return false;
    }

    // ==================== 基础工具 ====================

    function $(id) {
        if (!cache[id]) {
            cache[id] = document.getElementById(id);
        }
        return cache[id];
    }

    function make(tag, cls) {
        var e = document.createElement(tag);
        if (cls) {
            e.className = cls;
        }
        return e;
    }

    function textOf(v) {
        return v === null || v === undefined ? '' : String(v);
    }

    function hasClass(e, c) {
        return (' ' + e.className + ' ').indexOf(' ' + c + ' ') !== -1;
    }

    function addClass(e, c) {
        if (!hasClass(e, c)) {
            e.className = e.className ? e.className + ' ' + c : c;
        }
    }

    function removeClass(e, c) {
        if (!hasClass(e, c)) {
            return;
        }
        e.className = (' ' + e.className + ' ').replace(' ' + c + ' ', ' ')
            .replace(/^\s+|\s+$/g, '').replace(/\s+/g, ' ');
    }

    function toggleClass(e, c, on) {
        if (on) {
            addClass(e, c);
        } else {
            removeClass(e, c);
        }
    }

    function clear(e) {
        if (e) {
            e.textContent = '';
        }
    }

    function asInt(v) {
        var n = parseInt(textOf(v), 10);
        return isNaN(n) ? 0 : n;
    }

    function parseIntStrict(raw) {
        var s = textOf(raw).replace(/\s+/g, '');
        if (!/^-?\d+$/.test(s)) {
            return null;
        }
        return parseInt(s, 10);
    }

    function call(name, arg) {
        var api = window.WaspBridge;
        if (!api || typeof api[name] !== 'function') {
            return {ok: false, error: '桥不可用：' + name};
        }
        try {
            var raw = arguments.length > 1 ? api[name](arg) : api[name]();
            return JSON.parse(raw);
        } catch (e) {
            return {ok: false, error: '调用 ' + name + ' 失败：' + (e && e.message ? e.message : e)};
        }
    }

    function showBanner(msg, info) {
        var b = $('banner');
        if (!b) {
            return;
        }
        b.textContent = textOf(msg);
        toggleClass(b, 'hidden', !msg);
        toggleClass(b, 'info', !!info);
    }

    function appendBanner(msg, info) {
        if (!msg) {
            return;
        }
        var b = $('banner');
        var cur = b.textContent;
        showBanner(cur ? cur + '\n' + msg : msg, info);
    }

    /** 未捕获异常/初始化失败：不白屏，把原因写进 banner。自身绝不再抛。 */
    function reportFatal(message, detail) {
        try {
            var text = '运行时错误：' + textOf(message) + (detail ? '\n' + detail : '');
            var b = document.getElementById('banner');
            if (!b) {
                b = document.createElement('div');
                b.setAttribute('id', 'banner');
                if (document.body && document.body.appendChild) {
                    document.body.appendChild(b);
                }
            }
            b.className = 'banner';
            b.textContent = text;
            // 出错也要放行黑底，否则页面一直全黑看不到提示
            revealPage();
            if (window.console && window.console.error) {
                window.console.error(text);
            }
        } catch (ignore) {
            // 兜底路径本身不能再抛
        }
    }

    window.onerror = function (msg, src, line, col, err) {
        reportFatal(msg, (src || '') + ':' + line + (err && err.stack ? '\n' + err.stack : ''));
        return false;
    };

    function showMessage(id, msg, ok) {
        var e = $(id);
        if (!e) {
            return;
        }
        e.textContent = textOf(msg);
        toggleClass(e, 'error', !ok);
    }

    // ==================== 配置值 ====================

    function defaultValue(meta) {
        var d = meta['default'];
        if (meta.type === 'table') {
            return d && d.length ? d.join('\n') : '';
        }
        if (meta.type === 'multi') {
            var arr = d || [];
            var out = [];
            for (var i = 0; i < arr.length; i++) {
                out.push(textOf(arr[i]));
            }
            return out.join(' ');
        }
        return d === null || d === undefined ? '' : String(d);
    }

    function factoryText(meta) {
        var f = meta.factory;
        if (meta.type === 'table') {
            return f && f.length ? f.join('\n') : '';
        }
        if (meta.type === 'multi') {
            var arr = f || [];
            var out = [];
            for (var i = 0; i < arr.length; i++) {
                out.push(textOf(arr[i]));
            }
            return out.join(' ');
        }
        if (f === null || f === undefined) {
            return defaultValue(meta);
        }
        return String(f);
    }

    function factoryPayload(meta) {
        var f = meta.factory;
        if (meta.type === 'table') {
            return f && f.length ? f.join('\n') : '';
        }
        if (meta.type === 'multi') {
            return f || [];
        }
        if (f === null || f === undefined) {
            return defaultValue(meta);
        }
        if (meta.type === 'switch' || meta.type === 'int') {
            return asInt(f);
        }
        return textOf(f);
    }

    function valueOf(key) {
        if (state.values[key] !== undefined && state.values[key] !== null) {
            return String(state.values[key]);
        }
        var meta = state.defs && state.defs.keys ? state.defs.keys[key] : null;
        return meta ? defaultValue(meta) : '';
    }

    function serializeValue(v) {
        if (v && typeof v === 'object' && typeof v.length === 'number') {
            var out = [];
            for (var i = 0; i < v.length; i++) {
                out.push(textOf(v[i]));
            }
            return out.join(' ');
        }
        return textOf(v);
    }

    function numsOf(value, count) {
        var parts = textOf(value).split(/\s+/);
        var out = [];
        for (var i = 0; i < count; i++) {
            var n = parseInt(parts[i], 10);
            out.push(isNaN(n) ? 0 : n);
        }
        return out;
    }

    // ==================== 外观（跟随/浅色/深色，存 localStorage） ====================

    function themeLoad() {
        var t = 'follow';
        try {
            t = window.localStorage ? window.localStorage.getItem(THEME_KEY) : '';
        } catch (e) {
            t = '';
        }
        return t === 'light' || t === 'dark' ? t : 'follow';
    }

    function sysDark() {
        if (typeof window.__sysDark === 'boolean') {
            return window.__sysDark;
        }
        try {
            var hash = String((window.location && window.location.hash) || '');
            if (hash.indexOf('dark') !== -1) {
                return true;
            }
            if (hash.indexOf('light') !== -1) {
                return false;
            }
        } catch (ignore) {
            // file:// 下 location 不可用时继续回退
        }
        if (window.matchMedia) {
            try {
                var mq = window.matchMedia('(prefers-color-scheme: dark)');
                return !!(mq && mq.matches);
            } catch (e) {
                return false;
            }
        }
        return false;
    }

    function applyTheme(theme) {
        state.theme = theme;
        var root = document.documentElement;
        if (!root) {
            return;
        }
        var effective = effectiveTheme(theme);
        root.setAttribute('data-theme', effective);
        logTheme(effective);
        var sel = $('theme-select');
        if (sel) {
            sel.value = theme;
        }
    }

    function applySystemTheme() {
        if (state.theme === 'follow') {
            applyTheme('follow');
        }
    }

    function effectiveTheme(theme) {
        var t = theme === 'light' || theme === 'dark' ? theme : 'follow';
        return t === 'follow' ? (sysDark() ? 'dark' : 'light') : t;
    }

    function logTheme(effective) {
        if (!booted) {
            return;
        }
        if (window.console && window.console.log) {
            window.console.log(THEME_LOG_PREFIX + effective);
        }
    }

    /** 首帧黑底放行：主题已定、内容已渲染后才显示页面，避免浅色底先闪一下 */
    function revealPage() {
        var root = document.documentElement;
        if (root) {
            root.className = 'booted';
        }
        booted = true;
        logTheme(effectiveTheme(state.theme));
    }

    function themeSave(theme) {
        try {
            if (window.localStorage) {
                window.localStorage.setItem(THEME_KEY, theme);
            }
        } catch (e) {
            // 存储不可用时仅本次会话生效
        }
    }

    // ==================== 快照 ====================

    function applySnapshot(snap) {
        state.snapshot = snap;
        state.values = {};
        var defs = state.defs;
        var values = snap && snap.ok && snap.values ? snap.values : {};
        var key;
        if (defs && defs.keys) {
            for (key in defs.keys) {
                if (Object.prototype.hasOwnProperty.call(defs.keys, key)) {
                    state.values[key] = values[key] !== undefined
                        ? String(values[key]) : defaultValue(defs.keys[key]);
                }
            }
        }
        var unknown = [];
        for (key in values) {
            if (Object.prototype.hasOwnProperty.call(values, key)
                && (!defs || !defs.keys || !defs.keys[key])) {
                unknown.push(key);
            }
        }
        if (unknown.length) {
            appendBanner('配置里有 ' + unknown.length + ' 个未知键（已忽略）：' + unknown.join(', '));
        }
        if (!snap || !snap.ok) {
            appendBanner('读取当前配置失败：' + ((snap && snap.error) || '未知错误'));
        } else if (snap.notes && snap.notes.length) {
            appendBanner(snap.notes.join(' / '), true);
        }
    }

    // ==================== 配置表单 ====================

    function init() {
        state.rows = {};
        state.values = {};
        state.defs = null;
        state.groups = {};
        state.badges = {};
        state.expanded = {};
        state.pending = {};
        state.pendingMeta = {};
        state.pendingTarget = {};
        clear($('banner'));
        clear($('config-groups'));
        clear($('settings-rows'));
        clear($('chart-windows'));
        clear($('chart-legend'));
        clear($('chart-meta'));
        clear($('chart-message'));
        clear($('log-lines'));
        clear($('log-message'));
        clear($('settings-message'));
        clear($('status-actions'));
        clear($('status-message'));
        applyTheme(themeLoad());

        var defs = call('defs');
        if (!defs || !defs.keys) {
            showBanner('读取参数定义失败：' + ((defs && defs.error) || '返回格式不符'));
        } else {
            state.defs = defs;
        }
        buildGroupIndex();
        applySnapshot(call('snapshot'));
        renderConfig();
        renderSettings();
        initChartControls();
        bindUi();
        state.statusLoaded = false;
        state.chart.loaded = false;
        state.log.loaded = false;
        state.log.lastLine = null;
        state.log.count = 0;
        state.log.follow = true;
        showTab('config');
        revealPage();
    }

    function buildGroupIndex() {
        var groups = state.defs && state.defs.groups ? state.defs.groups : [];
        for (var i = 0; i < groups.length; i++) {
            state.groups[groups[i].id] = groups[i];
        }
    }

    function groupById(id) {
        return state.groups[id] || null;
    }

    function renderConfig() {
        var container = $('config-groups');
        if (!container) {
            return;
        }
        clear(container);
        if (!state.defs || !state.defs.keys) {
            return;
        }
        for (var i = 0; i < MAIN_GROUPS.length; i++) {
            var group = groupById(MAIN_GROUPS[i]);
            if (group) {
                container.appendChild(renderGroup(group, {}));
            }
        }
        fitAllRows();
        refreshGates();
    }

    function setGroupOpen(group, card, body, open) {
        state.expanded[group.id] = open;
        if (body._fadeTimer) {
            clearTimeout(body._fadeTimer);
            body._fadeTimer = null;
        }
        if (open) {
            removeClass(card, 'collapsed');
            body.style.opacity = '0';
            body._fadeTimer = setTimeout(function () {
                body.style.opacity = '1';
                body._fadeTimer = null;
            }, 20);
        } else {
            body.style.opacity = '0';
            body._fadeTimer = setTimeout(function () {
                addClass(card, 'collapsed');
                body.style.opacity = '';
                body._fadeTimer = null;
            }, 160);
        }
    }

    function renderGroup(group, opts) {
        opts = opts || {};
        var keyList = opts.keys || group.keys || [];
        var card = make('section', 'group');
        card.setAttribute('data-group', group.id);
        var open = opts.expanded !== undefined ? opts.expanded : !!state.expanded[group.id];
        if (!open) {
            addClass(card, 'collapsed');
        }

        var head = make('div', 'group-head');
        var title = make('h2', 'group-title');
        title.textContent = group.title || group.id;
        head.appendChild(title);
        var body = make('div', 'group-body');

        if (!opts.noBadge) {
            var badge = make('span', 'badge hidden');
            head.appendChild(badge);
            state.badges[group.id] = badge;
        }

        var sw = null;
        if (!opts.noMaster && group.master && state.defs.keys[group.master]) {
            var mmeta = state.defs.keys[group.master];
            sw = make('input', 'switch');
            sw.type = 'checkbox';
            sw.checked = asInt(valueOf(group.master)) === 1;
            sw.title = mmeta.label || group.master;
            sw.onchange = (function (meta) {
                return function () {
                    writeKey(meta, this.checked ? 1 : 0, 'config');
                };
            })(mmeta);
            head.appendChild(sw);
            state.rows[group.master] = {row: card, controls: [sw], meta: mmeta, master: true};
        }

        head.onclick = function (e) {
            if (e && e.target && (e.target === sw || e.target.tagName === 'INPUT')) {
                return;
            }
            setGroupOpen(group, card, body, hasClass(card, 'collapsed'));
        };

        for (var i = 0; i < keyList.length; i++) {
            var meta = state.defs.keys[keyList[i]];
            if (meta) {
                body.appendChild(renderRow(meta, 'config'));
            }
        }

        if (!opts.noReset) {
            var reset = make('button', 'group-reset');
            reset.type = 'button';
            reset.textContent = '恢复本组出厂值';
            reset.onclick = (function (g) {
                return function () {
                    resetGroup(g);
                };
            })(group);
            body.appendChild(reset);
        }

        card.appendChild(head);
        card.appendChild(body);
        return card;
    }

    function renderRow(meta, target) {
        var row = make('div', 'row');
        row.setAttribute('data-key', meta.key);
        var entry = {row: row, controls: [], meta: meta, target: target || 'config'};
        state.rows[meta.key] = entry;
        if (meta.type === 'table') {
            addClass(row, 'row-table');
        }

        var label = make('label', 'row-label');
        label.textContent = meta.label || meta.key;
        // 参数名与 ? 同组：? 紧跟名称 4px（与 GUI 一致），整组吃掉左侧空档
        var head = make('div', 'row-head');
        head.appendChild(label);

        var hints = [];
        var note = noteText(meta);
        var descBtn = null;
        var descBox = null;
        if (note) {
            descBtn = make('button', 'desc-btn');
            descBtn.type = 'button';
            descBtn.textContent = '?';
            descBtn.title = '说明';
            descBox = make('div', 'row-desc hidden');
            descBox.textContent = note;
            descBtn.onclick = (function (box, btn) {
                return function () {
                    var show = hasClass(box, 'hidden');
                    toggleClass(box, 'hidden', !show);
                    toggleClass(btn, 'on', show);
                };
            })(descBox, descBtn);
            head.appendChild(descBtn);
        }
        row.appendChild(head);

        var ctrl = make('div', 'row-control');
        var value = valueOf(meta.key);
        var type = meta.type || 'int';
        var i;

        if (type === 'switch') {
            var sw = make('input', 'switch');
            sw.type = 'checkbox';
            sw.checked = asInt(value) === 1;
            sw.onchange = (function (m, t) {
                return function () {
                    writeKey(m, this.checked ? 1 : 0, t);
                };
            })(meta, entry.target);
            ctrl.appendChild(sw);
            entry.controls.push(sw);
        } else if (type === 'multi') {
            var fields = meta.fields || [];
            var nums = numsOf(value, fields.length);
            var multiInputs = [];
            var multiHint = make('div', 'row-hint');
            for (i = 0; i < fields.length; i++) {
                var fi = makeMultiInput(fields[i], nums[i]);
                multiInputs.push(fi.input);
                ctrl.appendChild(fi.wrap);
            }
            var commitMulti = function () {
                var out = [];
                for (var j = 0; j < multiInputs.length; j++) {
                    var r = clampInput(multiInputs[j], meta.fields[j], multiHint);
                    if (r === null) {
                        return;
                    }
                    out.push(r);
                }
                writeKey(meta, out, entry.target);
            };
            for (i = 0; i < multiInputs.length; i++) {
                multiInputs[i].onchange = commitMulti;
            }
            hints.push(multiHint);
            entry.controls = multiInputs.slice(0);
        } else if (type === 'enum') {
            var sel = make('select');
            var options = meta.options || [];
            for (i = 0; i < options.length; i++) {
                var opt = make('option');
                opt.value = textOf(options[i].value);
                opt.textContent = options[i].label || textOf(options[i].value);
                sel.appendChild(opt);
            }
            sel.value = value;
            sel.onchange = (function (m, t) {
                return function () {
                    writeKey(m, this.value, t);
                };
            })(meta, entry.target);
            ctrl.appendChild(sel);
            entry.controls.push(sel);
        } else if (type === 'path') {
            var txt = make('input');
            txt.type = 'text';
            txt.value = value;
            txt.onchange = (function (m, t) {
                return function () {
                    writeKey(m, this.value, t);
                };
            })(meta, entry.target);
            ctrl.appendChild(txt);
            entry.controls.push(txt);
        } else if (type === 'table') {
            ctrl.appendChild(renderCut(meta, value, entry));
        } else {
            var num = make('input');
            num.type = 'number';
            num.value = value;
            if (meta.min !== null && meta.min !== undefined) {
                num.min = String(meta.min);
            }
            if (meta.max !== null && meta.max !== undefined) {
                num.max = String(meta.max);
            }
            var hint = make('div', 'row-hint');
            num.onchange = (function (m, input, hintEl, t) {
                return function () {
                    var r = clampInput(input, m, hintEl);
                    if (r !== null) {
                        writeKey(m, r, t);
                    }
                };
            })(meta, num, hint, entry.target);
            num.oninput = (function (input, m, hintEl) {
                return function () {
                    removeClass(input, 'invalid');
                    hintEl.textContent = rangeHint(m, input.value);
                };
            })(num, meta, hint);
            ctrl.appendChild(num);
            hints.push(hint);
            entry.controls.push(num);
        }

        row.appendChild(ctrl);
        for (i = 0; i < hints.length; i++) {
            row.appendChild(hints[i]);
        }
        if (descBox) {
            row.appendChild(descBox);
        }
        return row;
    }

    function noteText(meta) {
        var notes = meta.uiNote;
        if (notes && notes.length) {
            var parts = [];
            for (var i = 0; i < notes.length; i++) {
                parts.push((notes[i].title ? notes[i].title + '：' : '') + textOf(notes[i].text));
            }
            return parts.join('\n\n');
        }
        return textOf(meta.desc);
    }

    function makeMultiInput(field, value) {
        var wrap = make('span', 'field');
        var input = make('input');
        input.type = 'number';
        input.value = textOf(value);
        if (field.min !== null && field.min !== undefined) {
            input.min = String(field.min);
        }
        if (field.max !== null && field.max !== undefined) {
            input.max = String(field.max);
        }
        input.title = field.label || '';
        if (field.unit) {
            input.title = (input.title ? input.title + ' ' : '') + '（' + field.unit + '）';
        }
        wrap.appendChild(input);
        return {wrap: wrap, input: input};
    }

    function rangeHint(meta, raw) {
        if (textOf(raw).replace(/\s+/g, '') === '') {
            return '';
        }
        var n = parseIntStrict(raw);
        if (n === null) {
            return '请输入整数';
        }
        if (meta.min !== null && meta.min !== undefined && n < meta.min) {
            return '范围 ' + meta.min + '~' + (meta.max === null || meta.max === undefined ? '∞' : meta.max);
        }
        if (meta.max !== null && meta.max !== undefined && n > meta.max) {
            return '范围 ' + (meta.min === null || meta.min === undefined ? '∞' : meta.min) + '~' + meta.max;
        }
        return '';
    }

    function clampInput(input, meta, hintEl) {
        var raw = textOf(input.value);
        if (raw.replace(/\s+/g, '') === '') {
            if (hintEl) {
                hintEl.textContent = '不能为空';
            }
            addClass(input, 'invalid');
            return null;
        }
        var n = parseIntStrict(raw);
        if (n === null) {
            if (hintEl) {
                hintEl.textContent = '请输入整数';
            }
            addClass(input, 'invalid');
            return null;
        }
        var c = n;
        if (meta.min !== null && meta.min !== undefined && c < meta.min) {
            c = meta.min;
        }
        if (meta.max !== null && meta.max !== undefined && c > meta.max) {
            c = meta.max;
        }
        if (c !== n) {
            input.value = String(c);
            if (hintEl) {
                hintEl.textContent = '已钳制到 ' + c + '（' + rangeHint(meta, n) + '）';
            }
        } else {
            removeClass(input, 'invalid');
            if (hintEl) {
                hintEl.textContent = '';
            }
        }
        return c;
    }

    // ---------- 分段倍率（PID_CUT）：一行一簇，行内每四元组一个点 ----------

    function parseCut(value) {
        var lines = textOf(value).split('\n');
        var out = [];
        for (var i = 0; i < lines.length; i++) {
            if (lines[i].replace(/\s+/g, '') === '') {
                continue;
            }
            var segs = lines[i].split(',');
            for (var j = 0; j < segs.length; j++) {
                segs[j] = segs[j].replace(/^\s+|\s+$/g, '');
            }
            out.push(segs);
        }
        return out;
    }

    function cutLineValid(segs) {
        if (segs.length % 4 !== 0) {
            return false;
        }
        for (var i = 0; i < segs.length; i++) {
            var s = textOf(segs[i]).replace(/\s+/g, '');
            if (s !== '' && parseIntStrict(s) === null) {
                return false;
            }
        }
        return true;
    }

    function cutFields(meta) {
        var f = meta.rowFields && meta.rowFields.length ? meta.rowFields : [];
        if (f.length < 4) {
            f = [{label: '冷值'}, {label: 'KDP 增益'}, {label: '升温率'}, {label: '降温率'}];
        }
        return f;
    }

    function renderCut(meta, value, entry) {
        var wrap = make('div', 'table-wrap');
        var fields = cutFields(meta);
        var clusters = parseCut(value);
        var bad = 0;

        function commit(target) {
            if (bad || hasClass(entry.row, 'disabled') || hasClass(entry.row, 'hidden')) {
                return;
            }
            var lines = [];
            for (var c = 0; c < clusters.length; c++) {
                if (clusters[c].length) {
                    lines.push(clusters[c].join(','));
                }
            }
            writeKey(meta, lines.join('\n'), target || entry.target);
        }

        function draw() {
            clear(wrap);
            bad = 0;
            entry.controls = [];
            entry.extraControls = [];
            var ci;
            for (ci = 0; ci < clusters.length; ci++) {
                var segs = clusters[ci];
                if (!cutLineValid(segs)) {
                    bad++;
                    var raw = make('div', 'row-hint');
                    raw.textContent = '第 ' + (ci + 1) + ' 行段数不是 4 的倍数或含非整数，已暂停写入：'
                        + segs.join(',');
                    wrap.appendChild(raw);
                    continue;
                }
                wrap.appendChild(renderCluster(ci, segs));
            }
            if (bad) {
                var stop = make('div', 'row-hint');
                stop.textContent = '格式异常时不会写盘，请外部修正后刷新页面。';
                wrap.appendChild(stop);
            }
            var addCluster = make('button', 'ki-add ki-actions');
            addCluster.type = 'button';
            addCluster.textContent = '添加簇';
            addCluster.onclick = function () {
                clusters.push(['', '', '', '']);
                draw();
                commit();
            };
            wrap.appendChild(addCluster);
            entry.extraControls.push(addCluster);
            refreshGates();
        }

        function renderCluster(ci, segs) {
            var card = make('div', 'ki-cluster');
            var head = make('div', 'ki-head');
            var title = make('span', 'ki-title');
            var points = Math.floor(segs.length / 4);
            title.textContent = '簇 ' + (ci + 1) + ' · ' + points + ' 点';
            head.appendChild(title);
            var delCluster = make('button', 'ki-del');
            delCluster.type = 'button';
            delCluster.textContent = '删簇';
            delCluster.onclick = function () {
                clusters.splice(ci, 1);
                draw();
                commit();
            };
            head.appendChild(delCluster);
            card.appendChild(head);
            entry.extraControls.push(delCluster);

            var table = make('table', 'ki-grid');
            var thead = make('thead');
            var htr = make('tr');
            for (var h = 0; h < 4; h++) {
                var th = make('th');
                th.textContent = fields[h].label || ('列' + (h + 1));
                if (fields[h].unit) {
                    th.title = fields[h].unit;
                }
                htr.appendChild(th);
            }
            var actTh = make('th');
            actTh.textContent = '';
            htr.appendChild(actTh);
            thead.appendChild(htr);
            table.appendChild(thead);

            var tbody = make('tbody');
            for (var pi = 0; pi < points; pi++) {
                var tr = make('tr');
                for (var c = 0; c < 4; c++) {
                    var td = make('td');
                    var inp = make('input');
                    inp.type = 'number';
                    var field = fields[c];
                    if (field.min !== null && field.min !== undefined) {
                        inp.min = String(field.min);
                    }
                    if (field.max !== null && field.max !== undefined) {
                        inp.max = String(field.max);
                    }
                    inp.value = textOf(segs[pi * 4 + c]).replace(/\s+/g, '');
                    inp.onchange = (function (segIndex, fieldMeta) {
                        return function () {
                            var raw = textOf(this.value).replace(/\s+/g, '');
                            if (raw === '') {
                                segs[segIndex] = '';
                                removeClass(this, 'invalid');
                                commit();
                                return;
                            }
                            var n = parseIntStrict(raw);
                            if (n === null) {
                                addClass(this, 'invalid');
                                showMessage('config-message', '分段倍率只能是整数，已暂不写入', false);
                                return;
                            }
                            if (fieldMeta.min !== null && fieldMeta.min !== undefined && n < fieldMeta.min) {
                                n = fieldMeta.min;
                            }
                            if (fieldMeta.max !== null && fieldMeta.max !== undefined && n > fieldMeta.max) {
                                n = fieldMeta.max;
                            }
                            this.value = String(n);
                            segs[segIndex] = String(n);
                            removeClass(this, 'invalid');
                            commit();
                        };
                    })(pi * 4 + c, field);
                    td.appendChild(inp);
                    tr.appendChild(td);
                    entry.controls.push(inp);
                }
                var tdAct = make('td');
                var delPoint = make('button', 'ki-del');
                delPoint.type = 'button';
                delPoint.textContent = '删点';
                delPoint.onclick = (function (pointIndex) {
                    return function () {
                        segs.splice(pointIndex * 4, 4);
                        draw();
                        commit();
                    };
                })(pi);
                tdAct.appendChild(delPoint);
                tr.appendChild(tdAct);
                tbody.appendChild(tr);
                entry.extraControls.push(delPoint);
            }
            table.appendChild(tbody);
            card.appendChild(table);

            var addPoint = make('button', 'ki-del ki-actions');
            addPoint.type = 'button';
            addPoint.textContent = '添加点';
            addPoint.onclick = function () {
                segs.push('', '', '', '');
                draw();
                commit();
            };
            card.appendChild(addPoint);
            entry.extraControls.push(addPoint);
            return card;
        }

        draw();
        return wrap;
    }

    // ---------- 写入 ----------

    function writeKey(meta, value, target) {
        state.values[meta.key] = serializeValue(value);
        state.pending[meta.key] = value;
        state.pendingMeta[meta.key] = meta;
        state.pendingTarget[meta.key] = target || 'config';
        // 值变了才重算宽度（提交时算一次，不跟着按键重排）
        fitEntry(state.rows[meta.key]);
        if (state.writeTimer) {
            clearTimeout(state.writeTimer);
        }
        state.writeTimer = setTimeout(flushWrites, 300);
        if (meta.key === 'UI_GAP_SEC' || meta.key === 'UI_RPM_AXIS_MIN') {
            refreshChartConfig();
            if (state.tab === 'chart') {
                drawChart();
            }
        }
        refreshGates();
    }

    function flushWrites() {
        if (state.writeTimer) {
            clearTimeout(state.writeTimer);
            state.writeTimer = null;
        }
        var payload = state.pending;
        var metas = state.pendingMeta;
        var targets = state.pendingTarget;
        var keys = [];
        var key;
        for (key in payload) {
            if (Object.prototype.hasOwnProperty.call(payload, key)) {
                keys.push(key);
            }
        }
        state.pending = {};
        state.pendingMeta = {};
        state.pendingTarget = {};
        if (!keys.length) {
            return;
        }
        var target = targets[keys[0]] === 'settings' ? 'settings' : 'config';
        var res = call('setValues', JSON.stringify(payload));
        var meta;
        if (res && res.ok) {
            showMessage(target + '-message',
                (res.message || '已写入') + '（changed=' + res.changed + ', skipped=' + res.skipped + '）',
                true);
        } else {
            showMessage(target + '-message',
                '写入失败：' + ((res && res.error) || '未知错误'), false);
        }
        for (var i = 0; i < keys.length; i++) {
            meta = metas[keys[i]];
            if (meta && (meta.key === 'UI_GAP_SEC' || meta.key === 'UI_RPM_AXIS_MIN')) {
                refreshChartConfig();
            }
        }
        refreshGates();
    }

    function openConfirm(title, text, onOk) {
        if (state.confirmTimer) {
            clearTimeout(state.confirmTimer);
            state.confirmTimer = null;
        }
        $('confirm-title').textContent = title;
        $('confirm-text').textContent = text;
        state.confirmAction = onOk;
        var backdrop = $('confirm-backdrop');
        removeClass(backdrop, 'hidden');
        removeClass(backdrop, 'fade-out');
    }

    function closeConfirm(flush) {
        if (flush !== false) {
            flushWrites();
        }
        state.confirmAction = null;
        var backdrop = $('confirm-backdrop');
        addClass(backdrop, 'fade-out');
        if (state.confirmTimer) {
            clearTimeout(state.confirmTimer);
        }
        state.confirmTimer = setTimeout(function () {
            addClass(backdrop, 'hidden');
            removeClass(backdrop, 'fade-out');
            state.confirmTimer = null;
        }, 160);
    }

    function runConfirm() {
        var action = state.confirmAction;
        closeConfirm(false);
        if (action) {
            action();
        }
    }

    function resetGroup(group, keysOverride, messageId, label) {
        if (!group || !state.defs || !state.defs.keys) {
            return;
        }
        var keys = (keysOverride || group.keys || []).slice(0);
        if (group.master) {
            keys.unshift(group.master);
        }
        if (!keys.length) {
            return;
        }
        var title = label || group.title || group.id;
        openConfirm('恢复出厂值',
            '将「' + title + '」的 ' + keys.length + ' 项恢复为出厂值？',
            function () {
                doResetGroup(group, keys, messageId, title);
            });
    }

    function doResetGroup(group, keys, messageId, title) {
        flushWrites();
        var payload = {};
        var values = {};
        var i;
        for (i = 0; i < keys.length; i++) {
            var meta = state.defs.keys[keys[i]];
            if (!meta) {
                continue;
            }
            payload[meta.key] = factoryPayload(meta);
            values[meta.key] = factoryText(meta);
        }
        var res = call('setValues', JSON.stringify(payload));
        var msgId = messageId || 'config-message';
        if (res && res.ok) {
            for (var k in values) {
                if (Object.prototype.hasOwnProperty.call(values, k)) {
                    state.values[k] = values[k];
                }
            }
            renderConfig();
            renderSettings();
            showMessage(msgId,
                '已恢复「' + title + '」出厂值' + (res.changed ? '' : '（无变化）'), true);
        } else {
            showMessage(msgId, '恢复失败：' + ((res && res.error) || '未知错误'), false);
        }
    }

    // ---------- 门禁与徽标 ----------

    function refreshGates() {
        if (!state.defs || !state.defs.groups) {
            return;
        }
        var groups = state.defs.groups;
        for (var gi = 0; gi < groups.length; gi++) {
            var group = groups[gi];
            var masterOn = group.master ? asInt(valueOf(group.master)) === 1 : true;
            var inactive = 0;
            var keys = group.keys || [];
            for (var ki = 0; ki < keys.length; ki++) {
                var meta = state.defs.keys[keys[ki]];
                var entry = state.rows[keys[ki]];
                if (!meta || !entry) {
                    continue;
                }
                var active = masterOn;
                var req = meta.requires || [];
                for (var ri = 0; ri < req.length; ri++) {
                    if (asInt(valueOf(req[ri])) !== 1) {
                        active = false;
                    }
                }
                var hidden = false;
                var hw = meta.hiddenWhen || [];
                for (var hi = 0; hi < hw.length; hi++) {
                    if (asInt(valueOf(hw[hi])) === 1) {
                        hidden = true;
                    }
                }
                if (!active && !hidden) {
                    inactive++;
                }
                toggleClass(entry.row, 'disabled', !active);
                toggleClass(entry.row, 'hidden', hidden);
                for (var ci = 0; ci < entry.controls.length; ci++) {
                    entry.controls[ci].disabled = !active || hidden;
                }
                var extras = entry.extraControls || [];
                for (var ei = 0; ei < extras.length; ei++) {
                    extras[ei].disabled = !active || hidden;
                }
            }
            var badge = state.badges[group.id];
            if (badge) {
                badge.textContent = inactive ? '未生效 ' + inactive : '';
                toggleClass(badge, 'hidden', inactive === 0);
            }
            var masterRow = group.master ? state.rows[group.master] : null;
            if (masterRow && masterRow.controls.length) {
                masterRow.controls[0].checked = asInt(valueOf(group.master)) === 1;
            }
        }
    }

    // ==================== 设置弹层 ====================

    function renderSettings() {
        var box = $('settings-rows');
        if (!box) {
            return;
        }
        clear(box);
        var group = groupById('webui');
        if (!group || !state.defs || !state.defs.keys) {
            return;
        }
        for (var i = 0; i < WEBUI_KEYS.length; i++) {
            var meta = state.defs.keys[WEBUI_KEYS[i]];
            if (meta) {
                box.appendChild(renderRow(meta, 'settings'));
            }
        }
        fitAllRows();
        refreshGates();
    }

    function openSettings() {
        if (state.settingsTimer) {
            clearTimeout(state.settingsTimer);
            state.settingsTimer = null;
        }
        var backdrop = $('settings-backdrop');
        removeClass(backdrop, 'hidden');
        removeClass(backdrop, 'fade-out');
        renderSettings();
    }

    function closeSettings() {
        flushWrites();
        var backdrop = $('settings-backdrop');
        addClass(backdrop, 'fade-out');
        if (state.settingsTimer) {
            clearTimeout(state.settingsTimer);
        }
        state.settingsTimer = setTimeout(function () {
            addClass(backdrop, 'hidden');
            removeClass(backdrop, 'fade-out');
            state.settingsTimer = null;
        }, 160);
    }

    // ==================== 纵轴定标（精简版：整档步长 + 不裁点） ====================

    var TICK_CAP = 256;

    function ticksOf(lo, hi, step) {
        if (!(step > 0)) {
            return [lo, hi];
        }
        var out = [];
        var firstMult = Math.ceil(lo / step - 1e-9) * step;
        if (Math.abs(lo - firstMult) > step * 1e-6) {
            out.push(lo);
        }
        for (var v = firstMult; v <= hi + 1e-9 && out.length < TICK_CAP - 1; v += step) {
            out.push(v);
        }
        var lastMult = Math.floor(hi / step + 1e-9) * step;
        if (hi - lastMult > step * 1e-6 && out.length < TICK_CAP) {
            out.push(hi);
        }
        return out;
    }

    /** 取 1/2/5×10^n 的整档步长；floor/ceil 扩张到整档，绝不裁点。 */
    function axisFit(dmin, dmax) {
        if (!(dmax > dmin)) {
            dmax = dmin + 1;
        }
        var raw = (dmax - dmin) / 4;
        var mag = Math.pow(10, Math.floor(Math.log(raw) / Math.LN10));
        var norm = raw / mag;
        var step = mag * (norm <= 1 ? 1 : (norm <= 2 ? 2 : (norm <= 5 ? 5 : 10)));
        return {min: Math.floor(dmin / step) * step, max: Math.ceil(dmax / step) * step, step: step};
    }

    /** 同 ChartAxis.range：右轴不自算刻度，step 无意义。 */
    function axisRange(min, max) {
        if (!(max > min)) {
            max = min + 1;
        }
        return {min: min, max: max, step: 0};
    }

    function axisY(axis, v, padT, h) {
        return padT + h * (1 - (v - axis.min) / (axis.max - axis.min));
    }

    /** 同 ChartAxis.fmtTick：按 step 的小数位输出，整数不带 .0。 */
    function fmtTick(v, step) {
        var s = String(step);
        var dot = s.indexOf('.');
        var dec = dot >= 0 ? Math.min(2, s.length - dot - 1) : 0;
        var t = v.toFixed(dec);
        if (dec > 0 && t.slice(-2) === '.0') {
            t = t.slice(0, -2);
        }
        return t;
    }

    function coldRange() {
        var on = asInt(valueOf('PERF_ENABLED')) === 1;
        var start = on ? numsOf(valueOf('COLD_RPM_MAP'), 1)[0] : 40;
        var high = on ? numsOf(valueOf('PID_COLD_RANGE'), 3)[1] : 190;
        if (start < 0) {
            start = 0;
        }
        if (start > 194) {
            start = 194;
        }
        return {min: 1, start: start, max: high > 0 ? high : 190};
    }

    // ==================== 曲线 ====================

    function refreshChartConfig() {
        var gap = numsOf(valueOf('UI_GAP_SEC'), 2);
        state.chart.detectSec = gap[0] > 0 ? gap[0] : 3;
        state.chart.gapMax = gap[1] > 0 ? gap[1] : 15;
        state.chart.rpmAxisMin = asInt(valueOf('UI_RPM_AXIS_MIN'));
        var chartDef = state.defs ? state.defs.chart : null;
        if (chartDef && chartDef.rollingMaxLines) {
            state.chart.maxLines = chartDef.rollingMaxLines;
        }
        if (chartDef && chartDef.windowOptionsSec && chartDef.windowOptionsSec.length) {
            var maxWin = 0;
            for (var i = 0; i < chartDef.windowOptionsSec.length; i++) {
                if (chartDef.windowOptionsSec[i] > maxWin) {
                    maxWin = chartDef.windowOptionsSec[i];
                }
            }
            state.chart.maxWindow = maxWin || 720;
        }
    }

    function initChartControls() {
        state.chart.canvas = $('chart-canvas');
        state.chart.ctx = state.chart.canvas && state.chart.canvas.getContext
            ? state.chart.canvas.getContext('2d') : null;
        refreshChartConfig();
        var chartDef = state.defs ? state.defs.chart : null;
        var options = chartDef && chartDef.windowOptionsSec
            ? chartDef.windowOptionsSec : [120, 180, 240, 360, 480, 720];
        var defWin = chartDef && chartDef.windowDefaultSec ? chartDef.windowDefaultSec : 360;
        state.chart.windowSec = defWin;
        var winBox = $('chart-windows');
        clear(winBox);
        for (var i = 0; i < options.length; i++) {
            var btn = make('button', 'win-btn');
            btn.type = 'button';
            btn.textContent = options[i] + 's';
            btn.setAttribute('data-window', String(options[i]));
            if (options[i] === defWin) {
                addClass(btn, 'active');
            }
            btn.onclick = (function (sec, el) {
                return function () {
                    state.chart.windowSec = sec;
                    var all = winBox.children;
                    for (var j = 0; j < all.length; j++) {
                        removeClass(all[j], 'active');
                    }
                    addClass(el, 'active');
                    drawChart();
                };
            })(options[i], btn);
            winBox.appendChild(btn);
        }

        var legend = $('chart-legend');
        clear(legend);
        for (var s = 0; s < SERIES.length; s++) {
            var label = make('label');
            var box = make('input');
            box.type = 'checkbox';
            box.checked = !!state.chart.series[SERIES[s].id];
            box.onchange = (function (id) {
                return function () {
                    state.chart.series[id] = this.checked;
                    drawChart();
                };
            })(SERIES[s].id);
            var swatch = make('span', 'swatch');
            swatch.style.background = SERIES[s].color;
            var name = make('span');
            name.textContent = SERIES[s].label;
            label.appendChild(box);
            label.appendChild(swatch);
            label.appendChild(name);
            legend.appendChild(label);
        }
    }

    function parseChartLine(line) {
        var parts = String(line).split(',');
        if (parts.length < 8) {
            return null;
        }
        var nums = [];
        for (var i = 0; i < 8; i++) {
            var n = parseInt(parts[i], 10);
            if (isNaN(n)) {
                return null;
            }
            nums.push(n);
        }
        return {
            t: nums[0],
            batt: nums[1],
            cpu: nums[2],
            hot: nums[3],
            cold: nums[4],
            rpm: nums[5],
            cool: nums[6]
        };
    }

    function chartIngest(text) {
        var lines = String(text || '').split('\n');
        var parsed = [];
        var maxT = 0;
        for (var i = 0; i < lines.length; i++) {
            var p = parseChartLine(lines[i]);
            if (p) {
                parsed.push(p);
                if (p.t > maxT) {
                    maxT = p.t;
                }
            }
        }
        if (state.chart.lastT && maxT && maxT < state.chart.lastT - 5) {
            state.chart.points = [];
            state.chart.lastT = 0;
            state.chart.lastPoint = null;
        }
        var added = 0;
        for (var j = 0; j < parsed.length; j++) {
            var point = parsed[j];
            if (state.chart.lastT && point.t <= state.chart.lastT) {
                continue;
            }
            var prev = state.chart.lastPoint;
            if (prev) {
                var dt = point.t - prev.t;
                var step = dt > state.chart.detectSec ? Math.min(dt, state.chart.gapMax) : 1;
                point.unit = prev.unit + step;
            } else {
                point.unit = 0;
            }
            state.chart.points.push(point);
            state.chart.lastPoint = point;
            state.chart.lastT = point.t;
            added++;
        }
        if (added) {
            pruneChart();
            drawChart();
        }
        return added;
    }

    function pruneChart() {
        var points = state.chart.points;
        while (points.length > state.chart.maxLines) {
            points.shift();
        }
        var oldest = state.chart.lastT - state.chart.maxWindow;
        while (points.length > 1 && points[0].t < oldest) {
            points.shift();
        }
    }

    function visiblePoints() {
        var points = state.chart.points;
        if (!points.length) {
            return [];
        }
        var newest = state.chart.lastT;
        var win = state.chart.windowSec;
        var out = [];
        for (var i = 0; i < points.length; i++) {
            if (points[i].t >= newest - win) {
                out.push(points[i]);
            }
        }
        if (out.length < 2 && points.length >= 2) {
            out = points.slice(points.length - 2);
        }
        return out;
    }

    function seriesValue(id, p) {
        var v = p[id];
        if (v === null || v === undefined || v < 0) {
            return null;
        }
        if (id === 'rpm') {
            return v / 100;
        }
        if (id === 'cool') {
            return v;
        }
        return v / 10;
    }

    function drawChart() {
        var chart = state.chart;
        var canvas = chart.canvas;
        var ctx = chart.ctx;
        if (!canvas || !ctx) {
            return;
        }
        var W = Math.round(canvas.clientWidth || 0);
        var H = Math.round(canvas.clientHeight || 0);
        if (!W || !H) {
            return;
        }
        var dpr = Math.min(window.devicePixelRatio || 1, 3);
        var bw = Math.round(W * dpr);
        var bh = Math.round(H * dpr);
        if (canvas.width !== bw) {
            canvas.width = bw;
        }
        if (canvas.height !== bh) {
            canvas.height = bh;
        }
        ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
        ctx.clearRect(0, 0, W, H);
        chart.drawCount++;

        var pts = visiblePoints();
        var padL = 44;
        var padR = 40;
        var padT = 14;
        var padB = 24;
        if (pts.length < 2) {
            ctx.fillStyle = '#77808c';
            ctx.font = '12px sans-serif';
            ctx.fillText('采样中…', padL, H / 2);
            return;
        }

        var first = pts[0];
        var last = pts[pts.length - 1];
        var span = last.unit - first.unit;
        if (span <= 0) {
            span = 1;
        }

        var i;
        var s;
        var rpmMin = chart.rpmAxisMin > 0 ? chart.rpmAxisMin : 0;

        function collectLeft(ignoreMin) {
            var out = [];
            for (var pi = 0; pi < pts.length; pi++) {
                var pp = pts[pi];
                for (var si = 0; si < SERIES.length; si++) {
                    var dd = SERIES[si];
                    if (!chart.series[dd.id] || dd.axis !== 'left') {
                        continue;
                    }
                    var vv = seriesValue(dd.id, pp);
                    if (vv === null) {
                        continue;
                    }
                    if (!ignoreMin && dd.id === 'rpm' && rpmMin > 0
                        && pp.rpm >= 0 && pp.rpm < rpmMin) {
                        continue;
                    }
                    out.push(vv);
                }
            }
            return out;
        }

        var leftValues = collectLeft(false);
        if (!leftValues.length && rpmMin > 0) {
            leftValues = collectLeft(true);
        }
        var coolValues = [];
        for (i = 0; i < pts.length; i++) {
            var cool = seriesValue('cool', pts[i]);
            if (cool !== null && chart.series.cool) {
                coolValues.push(cool);
            }
        }
        // 左轴：整档吸附（ChartAxis.fit），无 8% 人工留白
        var lAxis = null;
        if (leftValues.length) {
            var dmin = leftValues[0];
            var dmax = leftValues[0];
            for (i = 1; i < leftValues.length; i++) {
                if (leftValues[i] < dmin) {
                    dmin = leftValues[i];
                }
                if (leftValues[i] > dmax) {
                    dmax = leftValues[i];
                }
            }
            lAxis = axisFit(dmin, dmax);
        }
        // 右轴：下限恒 1，上限 = 窗口内制冷峰值夹进 [映射起始强度, 制冷上限]（同 ChartView）
        var rAxis = null;
        if (chart.series.cool) {
            var cr = coldRange();
            var peak = coolValues.length ? coolValues[0] : null;
            for (i = 1; i < coolValues.length; i++) {
                if (coolValues[i] > peak) {
                    peak = coolValues[i];
                }
            }
            var top = peak === null ? cr.max : Math.max(cr.start, Math.min(cr.max, peak));
            rAxis = axisRange(cr.min, top);
        }
        if (!lAxis && !rAxis) {
            return;
        }

        function xOf(pt) {
            return padL + (W - padL - padR) * (pt.unit - first.unit) / span;
        }

        function yLeft(v) {
            return axisY(lAxis, v, padT, H - padT - padB);
        }

        function yRight(v) {
            return axisY(rAxis, v, padT, H - padT - padB);
        }

        // 网格：位置与刻度文字都跟左轴走；右轴只在同一高度标整数、不画线
        ctx.strokeStyle = chartGridColor();
        ctx.lineWidth = 1;
        ctx.fillStyle = '#77808c';
        ctx.font = '10px sans-serif';
        var tickVals = lAxis ? ticksOf(lAxis.min, lAxis.max, lAxis.step) : [];
        var rightTexts = [];
        if (lAxis && rAxis) {
            var lSpan = lAxis.max - lAxis.min;
            var cSpan = rAxis.max - rAxis.min;
            for (i = 0; i < tickVals.length; i++) {
                var n = Math.round(rAxis.min + cSpan * (tickVals[i] - lAxis.min) / lSpan);
                if (n < rAxis.min) {
                    n = Math.floor(rAxis.min);
                }
                if (n > rAxis.max) {
                    n = Math.floor(rAxis.max);
                }
                rightTexts.push(String(n));
            }
        }
        for (i = 0; i < tickVals.length; i++) {
            var gy = yLeft(tickVals[i]);
            ctx.beginPath();
            ctx.moveTo(padL, gy);
            ctx.lineTo(W - padR, gy);
            ctx.stroke();
            ctx.fillText(fmtTick(tickVals[i], lAxis.step), 4, gy + 3);
            if (rightTexts.length) {
                ctx.fillText(rightTexts[i], W - padR + 6, gy + 3);
            }
        }

        function drawSeries(color, id, yFn) {
            ctx.strokeStyle = color;
            ctx.lineWidth = 2;
            ctx.beginPath();
            var drawing = false;
            for (var k = 0; k < pts.length; k++) {
                var v = seriesValue(id, pts[k]);
                if (v === null) {
                    drawing = false;
                    continue;
                }
                var x = xOf(pts[k]);
                var yv = yFn(v);
                if (!drawing) {
                    ctx.moveTo(x, yv);
                    drawing = true;
                } else {
                    ctx.lineTo(x, yv);
                }
            }
            ctx.stroke();
        }

        for (s = 0; s < SERIES.length; s++) {
            var sd = SERIES[s];
            if (!chart.series[sd.id]) {
                continue;
            }
            if (sd.axis === 'right') {
                if (rAxis) {
                    drawSeries(sd.color, sd.id, yRight);
                }
            } else if (lAxis) {
                drawSeries(sd.color, sd.id, yLeft);
            }
        }
    }

    /** 网格线取主题边框色的浅值，避免抢曲线。 */
    function chartGridColor() {
        var dark = document.documentElement
            && document.documentElement.getAttribute('data-theme') === 'dark';
        return dark ? 'rgba(255,255,255,0.10)' : 'rgba(0,0,0,0.08)';
    }

    function chartPoll() {
        var res = call('chartData');
        if (!res || !res.ok) {
            showMessage('chart-message', '读取曲线失败：' + ((res && res.error) || '未知错误'), false);
            return;
        }
        showMessage('chart-message', '', true);
        chartIngest(res.text || '');
        var pts = visiblePoints();
        var newest = pts.length ? pts[pts.length - 1].t : state.chart.lastT;
        $('chart-meta').textContent = '样本 ' + pts.length + ' / 窗口 ' + state.chart.windowSec
            + 's' + (newest ? ' / 最新 ' + timeText(newest) : '');
    }

    function timeText(t) {
        var d = new Date(t * 1000);

        function two(n) {
            return n < 10 ? '0' + n : String(n);
        }

        return two(d.getHours()) + ':' + two(d.getMinutes()) + ':' + two(d.getSeconds());
    }

    function chartOpen() {
        if (!state.chart.loaded) {
            state.chart.loaded = true;
            chartPoll();
        }
        if (!state.timers.chart) {
            state.timers.chart = setInterval(chartPoll, 1000);
        }
        drawChart();
    }

    function chartClose() {
        if (state.timers.chart) {
            clearInterval(state.timers.chart);
            state.timers.chart = null;
        }
    }

    // ==================== 日志 ====================

    function nearBottom(box) {
        return box.scrollHeight - box.scrollTop - box.clientHeight < 24;
    }

    function updateJumpButton() {
        var btn = $('log-jump');
        if (btn) {
            toggleClass(btn, 'jump-off', !!state.log.follow);
        }
    }

    function scrollLogBottom() {
        var box = $('log-lines');
        if (box) {
            box.scrollTop = box.scrollHeight;
            state.log.follow = true;
            updateJumpButton();
        }
    }

    function logPoll() {
        var res = call('logs');
        if (!res || !res.ok) {
            showMessage('log-message', '读取日志失败：' + ((res && res.error) || '未知错误'), false);
            return;
        }
        showMessage('log-message', '', true);
        logIngest(res.text || '');
    }

    function logIngest(text) {
        var lines = String(text || '').split('\n');
        while (lines.length && lines[lines.length - 1] === '') {
            lines.pop();
        }
        var box = $('log-lines');
        if (!box) {
            return;
        }
        var first = state.log.lastLine === null;
        var atBottom = first || nearBottom(box);
        var fresh = [];
        if (first) {
            fresh = lines;
        } else {
            var idx = -1;
            for (var i = lines.length - 1; i >= 0; i--) {
                if (lines[i] === state.log.lastLine) {
                    idx = i;
                    break;
                }
            }
            fresh = idx >= 0 ? lines.slice(idx + 1) : lines;
        }
        for (var j = 0; j < fresh.length; j++) {
            var div = make('div', 'log-line');
            div.textContent = fresh[j];
            if (hasAny(fresh[j], ERR_WORDS)) {
                addClass(div, 'err');
            } else if (hasAny(fresh[j], WARN_WORDS)) {
                addClass(div, 'warn');
            }
            box.appendChild(div);
            state.log.count++;
        }
        var heightBeforeTrim = box.scrollHeight;
        while (box.children.length > LOG_MAX) {
            box.removeChild(box.children[0]);
        }
        var removedHeight = heightBeforeTrim - box.scrollHeight;
        if (removedHeight > 0 && !atBottom) {
            var top = box.scrollTop - removedHeight;
            box.scrollTop = top > 0 ? top : 0;
        }
        if (lines.length) {
            state.log.lastLine = lines[lines.length - 1];
        }
        state.log.follow = atBottom;
        if (atBottom) {
            box.scrollTop = box.scrollHeight;
        }
        updateJumpButton();
    }

    function logOpen() {
        if (!state.log.loaded) {
            state.log.loaded = true;
            logPoll();
        }
        if (!state.timers.log) {
            state.timers.log = setInterval(logPoll, 1000);
        }
        if (state.log.follow) {
            scrollLogBottom();
        }
        updateJumpButton();
    }

    function logClose() {
        if (state.timers.log) {
            clearInterval(state.timers.log);
            state.timers.log = null;
        }
    }

    // ==================== 状态与动作 ====================

    function renderStatus(res) {
        var summary = $('status-summary');
        if (!res || !res.ok) {
            summary.textContent = '读取失败：' + ((res && res.error) || '未知错误');
            addClass(summary, 'error');
            return;
        }
        removeClass(summary, 'error');
        var s = res.status || {};
        var lines = [];
        lines.push('root：' + (s.suOk ? '可用' : '不可用'));
        lines.push('守护进程：' + (s.daemonRunning ? '运行中（PID ' + (s.daemonPids || '?') + '）' : '未运行'));
        lines.push('看门狗：' + (s.watchdogCount || 0) + ' 个（' + (s.watchdogPids || '无') + '）');
        lines.push('部署：' + (s.deployed ? '已就位' : '未就位'));
        lines.push('二进制：' + (s.binExists
            ? (s.binHashOk ? '存在且哈希一致' : '存在但哈希不一致') : '不存在'));
        lines.push('脚本：' + (s.scriptPresent
            ? (s.scriptHashOk ? '存在且哈希一致' : '存在但哈希不一致') : '不存在'));
        lines.push('配置：' + (s.configPresent ? '存在' : '不存在')
            + (s.configPathAligned ? '（路径一致）' : '（路径不一致）'));
        if (s.configPath) {
            lines.push('配置路径：' + s.configPath);
        }
        if (res.describe) {
            lines.push('');
            lines.push(res.describe);
        }
        summary.textContent = lines.join('\n');
    }

    function loadStatus() {
        var t0 = Date.now();
        var res = call('status');
        if (res && res.pending) {
            showStatusPending();
            scheduleStatusRetry(300);
            return;
        }
        renderStatus(res);
        logStatusTiming(t0);
    }

    /** 无缓存时给个占位；已有旧结果就保留，避免闪空 */
    function showStatusPending() {
        var summary = $('status-summary');
        if (summary && summary.textContent === '尚未读取') {
            summary.textContent = '正在读取状态…';
        }
    }

    /** 桥侧 probe 已改后台：缓存就绪后再补取一次，免得展示落后一个轮询周期 */
    function scheduleStatusRetry(delay) {
        if (state.statusRetryTimer !== null) {
            return;
        }
        state.statusRetryTimer = setTimeout(function () {
            state.statusRetryTimer = null;
            if (state.tab === 'status') {
                loadStatus();
            }
        }, delay);
    }

    function logStatusTiming(callMs) {
        if (!state.statusEnteredAt) {
            return;
        }
        var waited = Date.now() - state.statusEnteredAt;
        state.statusEnteredAt = 0;
        if (window.console && window.console.log) {
            window.console.log('[lite-status] call=' + callMs + 'ms firstData=' + waited + 'ms');
        }
    }

    /** 状态页驻留时慢速轮询；每次 probe 会起一趟 root shell，故不跟日志一样按秒跑 */
    function statusPoll() {
        if (state.busy) {
            return;
        }
        loadStatus();
        scheduleStatusRetry(1400);
    }

    function statusOpen() {
        state.statusEnteredAt = Date.now();
        loadStatus();
        scheduleStatusRetry(1400);
        if (!state.timers.status) {
            state.timers.status = setInterval(statusPoll, 5000);
        }
    }

    function statusClose() {
        if (state.timers.status) {
            clearInterval(state.timers.status);
            state.timers.status = null;
        }
        if (state.statusRetryTimer !== null) {
            clearTimeout(state.statusRetryTimer);
            state.statusRetryTimer = null;
        }
    }

    function buildActions() {
        var box = $('status-actions');
        clear(box);
        var actions = [
            {id: 'deploy', label: '部署'},
            {id: 'uninstall', label: '卸载部署'},
            {id: 'startDaemon', label: '启动守护进程'},
            {id: 'stopDaemon', label: '停止守护进程'}
        ];
        for (var i = 0; i < actions.length; i++) {
            var btn = make('button', 'action-btn');
            btn.type = 'button';
            btn.textContent = actions[i].label;
            btn.setAttribute('data-action', actions[i].id);
            btn.onclick = (function (id) {
                return function () {
                    doAction(id);
                };
            })(actions[i].id);
            box.appendChild(btn);
        }
    }

    function setActionsDisabled(disabled) {
        var buttons = $('status-actions').children;
        for (var i = 0; i < buttons.length; i++) {
            buttons[i].disabled = disabled;
        }
    }

    function doAction(name) {
        if (state.busy) {
            return;
        }
        state.busy = true;
        setActionsDisabled(true);
        showMessage('status-message', '执行中：' + name + '…', true);
        setTimeout(function () {
            var res = call(name);
            state.busy = false;
            setActionsDisabled(false);
            var ok = !!(res && res.ok);
            showMessage('status-message', (res && (res.describe || res.action)) || (ok ? '完成' : '失败'), ok);
            if (res && res.status) {
                renderStatus({ok: true, status: res.status, describe: res.describe});
            } else {
                $('status-summary').textContent = ((res && (res.describe || res.error)) || '动作已返回')
                    + '\n（本次动作未返回状态，未补探）';
            }
        }, 0);
    }

    // ==================== 页签、滑动与轮询 ====================

    function rowOf(el) {
        while (el && el !== document.body) {
            if (hasClass(el, 'row')) {
                return el;
            }
            el = el.parentNode;
        }
        return null;
    }

    /** 点行内空白处把焦点交给该行第一个输入框：视觉高度之外补一块热区 */
    function focusRowInput(e) {
        var target = e.target;
        var tag = target && target.tagName ? target.tagName : '';
        if (tag === 'INPUT' || tag === 'SELECT' || tag === 'TEXTAREA'
            || tag === 'BUTTON' || tag === 'A') {
            return;
        }
        var row = rowOf(target);
        if (!row || hasClass(row, 'row-table') || row.offsetParent === null) {
            return;
        }
        var controls = row.querySelectorAll('input, select');
        for (var i = 0; i < controls.length; i++) {
            if (controls[i].type !== 'checkbox' && !controls[i].disabled) {
                controls[i].focus();
                return;
            }
        }
    }

    /** 只有弹层、以及真的能横向滚动的容器才让出横向手势；普通控件不拦翻页 */
    function blocksSwipe(el) {
        while (el && el !== document.body) {
            var cls = textOf(el.className);
            if (cls.indexOf('backdrop') !== -1 || cls.indexOf('dialog') !== -1) {
                return true;
            }
            if (el.scrollWidth - el.clientWidth > 4 && scrollsX(el)) {
                return true;
            }
            el = el.parentNode;
        }
        return false;
    }

    function scrollsX(el) {
        if (!window.getComputedStyle) {
            return false;
        }
        try {
            var ox = window.getComputedStyle(el).overflowX;
            return ox === 'auto' || ox === 'scroll';
        } catch (e) {
            return false;
        }
    }

    // ==================== 输入框宽度（canvas 实测文本） ====================

    /** 全局复用一个 2d context；字体按字段缓存，避免每次渲染重启上下文 */
    var measureCtx = null;
    var measureFont = '';

    function textMeasureCtx() {
        if (!measureCtx) {
            try {
                var c = document.createElement('canvas');
                measureCtx = c.getContext ? c.getContext('2d') : null;
            } catch (e) {
                measureCtx = null;
            }
        }
        return measureCtx;
    }

    function fontOf(el) {
        if (el.__mfont) {
            return el.__mfont;
        }
        try {
            var cs = window.getComputedStyle ? window.getComputedStyle(el) : null;
            if (!cs) {
                return '';
            }
            var font = cs.font;
            if (!font) {
                font = (cs.fontStyle || '') + ' ' + (cs.fontWeight || '') + ' '
                    + (cs.fontSize || '13px') + ' ' + (cs.fontFamily || 'sans-serif');
            }
            el.__mfont = font;
            return font;
        } catch (e) {
            return '';
        }
    }

    /** 文本像素宽；量不到返回 -1 */
    function measureTextWidth(el, text) {
        var ctx = textMeasureCtx();
        var font = fontOf(el);
        if (!ctx || !font) {
            return -1;
        }
        if (font !== measureFont) {
            ctx.font = font;
            measureFont = font;
        }
        try {
            return ctx.measureText(String(text)).width;
        } catch (e) {
            return -1;
        }
    }

    function inputMinWidth(el) {
        return el && el.type === 'number' ? 44 : 120;
    }

    /** 宽度 = max(文本宽 + 左右内边距/边框 + 余量, 最小宽)；量不到就保留 CSS 固定宽 */
    function fitInputWidth(el) {
        if (!el || el.tagName !== 'INPUT' || el.type === 'checkbox') {
            return;
        }
        try {
            var cs = window.getComputedStyle ? window.getComputedStyle(el) : null;
            if (!cs) {
                return;
            }
            var pad = (parseFloat(cs.paddingLeft) || 0) + (parseFloat(cs.paddingRight) || 0)
                + (parseFloat(cs.borderLeftWidth) || 0) + (parseFloat(cs.borderRightWidth) || 0);
            var min = inputMinWidth(el);
            var width = min;
            if (el.value) {
                var textWidth = measureTextWidth(el, el.value);
                if (textWidth < 0) {
                    return;
                }
                width = Math.max(min, Math.ceil(textWidth + pad + 4));
            }
            el.style.width = width + 'px';
        } catch (e) {
            // 失败时保持现有（CSS 固定）宽度
        }
    }

    function fitEntry(entry) {
        if (!entry || !entry.controls) {
            return;
        }
        for (var i = 0; i < entry.controls.length; i++) {
            fitInputWidth(entry.controls[i]);
        }
    }

    /** 建行/回填后统一算一次，不在每次按键时重排 */
    function fitAllRows() {
        for (var key in state.rows) {
            if (Object.prototype.hasOwnProperty.call(state.rows, key)) {
                fitEntry(state.rows[key]);
            }
        }
    }

    /** 输入框内容是否溢出可见宽度（需要横拖查看） */
    function inputOverflows(el) {
        var tag = el && el.tagName ? el.tagName : '';
        if (tag !== 'INPUT' && tag !== 'TEXTAREA') {
            return false;
        }
        var value = el.value;
        if (!value) {
            return false;
        }
        try {
            var cs = window.getComputedStyle ? window.getComputedStyle(el) : null;
            if (!cs) {
                return false;
            }
            var textWidth = measureTextWidth(el, value);
            if (textWidth < 0) {
                return false;
            }
            var padL = parseFloat(cs.paddingLeft) || 0;
            var padR = parseFloat(cs.paddingRight) || 0;
            var inner = el.clientWidth - padL - padR;
            return inner > 0 && textWidth > inner + 3;
        } catch (e) {
            return false;
        }
    }

    function shiftTab(delta) {
        var idx = -1;
        for (var i = 0; i < TABS.length; i++) {
            if (TABS[i] === state.tab) {
                idx = i;
            }
        }
        if (idx < 0) {
            return;
        }
        var next = idx + delta;
        if (next < 0 || next >= TABS.length) {
            return;
        }
        showTab(TABS[next]);
    }

    function initSwipe() {
        if (!document || !document.addEventListener) {
            return;
        }
        var startX = 0;
        var startY = 0;
        var tracking = false;
        var blocked = false;

        function onStart(e) {
            var t = e.touches && e.touches[0];
            if (!t) {
                tracking = false;
                return;
            }
            startX = t.clientX;
            startY = t.clientY;
            tracking = true;
            // 起点在输入框内且内容溢出：让用户横拖看内容；内容不溢出则照常按位移判定
            blocked = blocksSwipe(e.target) || inputOverflows(e.target);
        }

        function onMove(e) {
            if (!tracking) {
                return;
            }
            var t = e.touches && e.touches[0];
            if (!t) {
                return;
            }
            var dx = Math.abs(t.clientX - startX);
            var dy = Math.abs(t.clientY - startY);
            // 纵向为主交给页面滚动，不抢
            if (dy > 12 && dy * 1.5 > dx) {
                tracking = false;
            }
        }

        function onEnd(e) {
            if (!tracking) {
                return;
            }
            tracking = false;
            var t = e.changedTouches && e.changedTouches[0];
            if (!t || blocked) {
                return;
            }
            var dx = t.clientX - startX;
            var dy = t.clientY - startY;
            var adx = Math.abs(dx);
            var ady = Math.abs(dy);
            if (adx >= 40 && adx > ady * 1.5) {
                shiftTab(dx < 0 ? 1 : -1);
            }
        }

        try {
            document.addEventListener('touchstart', onStart, {passive: true});
            document.addEventListener('touchmove', onMove, {passive: true});
            document.addEventListener('touchend', onEnd, {passive: true});
        } catch (e) {
            document.addEventListener('touchstart', onStart, false);
            document.addEventListener('touchmove', onMove, false);
            document.addEventListener('touchend', onEnd, false);
        }
    }

    function bindUi() {
        var tabs = $('tabs').children;
        for (var i = 0; i < tabs.length; i++) {
            var name = tabs[i].getAttribute('data-tab');
            tabs[i].onclick = (function (tabName) {
                return function () {
                    showTab(tabName);
                };
            })(name);
        }
        $('log-jump').onclick = function () {
            scrollLogBottom();
        };
        $('open-settings').onclick = function () {
            openSettings();
        };
        $('settings-close').onclick = function () {
            closeSettings();
        };
        $('settings-backdrop').onclick = function (e) {
            if (e && e.target === this) {
                closeSettings();
            }
        };
        $('confirm-cancel').onclick = function () {
            closeConfirm();
        };
        $('confirm-ok').onclick = function () {
            runConfirm();
        };
        $('confirm-backdrop').onclick = function (e) {
            if (e && e.target === this) {
                closeConfirm();
            }
        };
        $('settings-reset').onclick = function () {
            resetGroup(groupById('webui'), WEBUI_KEYS, 'settings-message', '界面参数（可见项）');
        };
        $('theme-select').onchange = function () {
            var theme = this.value;
            applyTheme(theme);
            themeSave(theme);
        };

        var logBox = $('log-lines');
        if (logBox && logBox.addEventListener) {
            logBox.addEventListener('scroll', function () {
                state.log.follow = nearBottom(logBox);
                updateJumpButton();
            });
        }

        document.addEventListener('click', focusRowInput, false);

        var resizeTimer = null;
        if (window.addEventListener) {
            window.addEventListener('resize', function () {
                if (resizeTimer) {
                    clearTimeout(resizeTimer);
                }
                resizeTimer = setTimeout(drawChart, 150);
            });
        }

        buildActions();
        initSwipe();
        refreshGates();
    }

    function showTab(name) {
        flushWrites();
        state.tab = name;
        var tabs = $('tabs').children;
        var i;
        for (i = 0; i < tabs.length; i++) {
            toggleClass(tabs[i], 'active', tabs[i].getAttribute('data-tab') === name);
        }
        for (i = 0; i < TABS.length; i++) {
            toggleClass($('page-' + TABS[i]), 'active', TABS[i] === name);
        }
        if (name !== 'chart') {
            chartClose();
        }
        if (name !== 'log') {
            logClose();
        }
        if (name !== 'status') {
            statusClose();
        }
        if (name === 'status') {
            statusOpen();
        } else if (name === 'chart') {
            chartOpen();
        } else if (name === 'log') {
            logOpen();
        }
    }

    // ==================== 导出 ====================

    function safeInit() {
        try {
            init();
        } catch (e) {
            reportFatal(e && e.message ? e.message : e, e && e.stack ? e.stack : '');
        }
    }

    window.LiteApp = {
        init: safeInit,
        applySysTheme: applySystemTheme,
        _state: state,
        _test: {
            showTab: showTab,
            chartIngest: chartIngest,
            chartPoll: chartPoll,
            drawChart: drawChart,
            logPoll: logPoll,
            logIngest: logIngest,
            doAction: doAction,
            writeKey: writeKey,
            flushWrites: flushWrites,
            refreshGates: refreshGates,
            visiblePoints: visiblePoints,
            parseChartLine: parseChartLine,
            axisFit: axisFit,
            axisRange: axisRange,
            ticksOf: ticksOf,
            fmtTick: fmtTick,
            coldRange: coldRange,
            resetGroup: resetGroup,
            runConfirm: runConfirm,
            closeConfirm: closeConfirm,
            renderCut: renderCut,
            fitInputWidth: fitInputWidth,
            fitAllRows: fitAllRows,
            inputOverflows: inputOverflows,
            openSettings: openSettings,
            closeSettings: closeSettings,
            shiftTab: shiftTab
        }
    };

    if (!window.__LITE_TEST__) {
        safeInit();
    }
})();
