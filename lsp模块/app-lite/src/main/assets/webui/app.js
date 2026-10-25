/* 飞智温控增强 Lite —— 真实前端（ES5，零外部资源）。
 * 桥契约见 .claude/subagent方案存放区/webui极简版-方案.md 的「WebBridge 契约」。
 */
(function () {
    'use strict';

    var SERIES = [
        {id: 'batt', label: '电池温度', color: '#2d7ff9'},
        {id: 'cpu', label: 'CPU温度', color: '#e5484d'},
        {id: 'hot', label: '热端温度', color: '#f5a623'},
        {id: 'rpm', label: '风扇(÷100)', color: '#30a46c'},
        {id: 'cold', label: '制冷', color: '#8e4ec6'}
    ];

    var state = {
        defs: null,
        snapshot: null,
        values: {},
        rows: {},
        tab: 'config',
        timers: {chart: null, log: null},
        chart: {
            points: [],
            lastT: 0,
            lastPoint: null,
            windowSec: 360,
            detectSec: 3,
            gapMax: 15,
            maxLines: 720,
            maxWindow: 720,
            drawCount: 0,
            canvas: null,
            ctx: null,
            loaded: false,
            series: {batt: true, cpu: true, hot: false, rpm: true, cold: false}
        },
        log: {loaded: false, lastLine: null, count: 0, autoScroll: true},
        statusLoaded: false,
        busy: false
    };

    var cache = {};

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
            return d && d.length ? textOf(d[0]) : '';
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
        clear(cache['banner']);
        clear($('config-groups'));
        clear($('chart-windows'));
        clear($('chart-legend'));
        clear($('chart-meta'));
        clear($('chart-message'));
        clear($('log-lines'));
        clear($('log-message'));
        clear($('status-actions'));
        clear($('status-message'));

        var defs = call('defs');
        if (!defs || !defs.keys) {
            showBanner('读取参数定义失败：' + ((defs && defs.error) || '返回格式不符'));
        } else {
            state.defs = defs;
        }

        applySnapshot(call('snapshot'));
        renderConfig();
        initChartControls();
        bindUi();
        state.statusLoaded = false;
        state.chart.loaded = false;
        state.log.loaded = false;
        state.log.lastLine = null;
        state.log.count = 0;
        state.log.autoScroll = true;
        showTab('config');
    }

    function renderConfig() {
        var container = $('config-groups');
        if (!container) {
            return;
        }
        clear(container);
        if (!state.defs || !state.defs.groups || !state.defs.keys) {
            return;
        }
        var groups = state.defs.groups;
        for (var gi = 0; gi < groups.length; gi++) {
            var group = groups[gi];
            var card = make('section', 'group');
            card.setAttribute('data-group', group.id);
            var head = make('div', 'group-head');
            var title = make('h2', 'group-title');
            title.textContent = group.title || group.id;
            head.appendChild(title);

            if (group.master && state.defs.keys[group.master]) {
                var mmeta = state.defs.keys[group.master];
                var wrap = make('span', 'row-control');
                var sw = make('input', 'switch');
                sw.type = 'checkbox';
                sw.setAttribute('data-key', group.master);
                sw.checked = asInt(valueOf(group.master)) === 1;
                sw.title = mmeta.label || group.master;
                sw.onchange = (function (meta) {
                    return function () {
                        writeKey(meta, this.checked ? 1 : 0);
                    };
                })(mmeta);
                wrap.appendChild(sw);
                head.appendChild(wrap);
                state.rows[group.master] = {row: card, controls: [sw], meta: mmeta, master: true};
            }

            var toggle = make('button', 'group-toggle');
            toggle.type = 'button';
            toggle.textContent = '收起';
            head.appendChild(toggle);

            var body = make('div', 'group-body');
            toggle.onclick = (function (cardEl, bodyEl, btn) {
                return function () {
                    var collapsed = hasClass(cardEl, 'collapsed');
                    if (collapsed) {
                        removeClass(cardEl, 'collapsed');
                        bodyEl.style.opacity = '0';
                        setTimeout(function () {
                            bodyEl.style.opacity = '1';
                        }, 0);
                        btn.textContent = '收起';
                    } else {
                        bodyEl.style.opacity = '0';
                        setTimeout(function () {
                            addClass(cardEl, 'collapsed');
                            bodyEl.style.opacity = '';
                        }, 150);
                        btn.textContent = '展开';
                    }
                };
            })(card, body, toggle);

            var keys = group.keys || [];
            for (var ki = 0; ki < keys.length; ki++) {
                var meta = state.defs.keys[keys[ki]];
                if (meta) {
                    body.appendChild(renderRow(meta));
                }
            }

            card.appendChild(head);
            card.appendChild(body);
            container.appendChild(card);
        }
    }

    function renderRow(meta) {
        var row = make('div', 'row');
        row.setAttribute('data-key', meta.key);
        var entry = {row: row, controls: [], meta: meta};
        state.rows[meta.key] = entry;

        var label = make('label', 'row-label');
        label.textContent = meta.label || meta.key;
        row.appendChild(label);

        var ctrl = make('div', 'row-control');
        var value = valueOf(meta.key);
        var type = meta.type || 'int';
        var i;

        if (type === 'switch') {
            var sw = make('input', 'switch');
            sw.type = 'checkbox';
            sw.checked = asInt(value) === 1;
            sw.onchange = (function (m) {
                return function () {
                    writeKey(m, this.checked ? 1 : 0);
                };
            })(meta);
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
                writeKey(meta, out);
            };
            for (i = 0; i < multiInputs.length; i++) {
                multiInputs[i].onchange = commitMulti;
            }
            row.appendChild(multiHint);
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
            sel.onchange = (function (m) {
                return function () {
                    writeKey(m, this.value);
                };
            })(meta);
            ctrl.appendChild(sel);
            entry.controls.push(sel);
        } else if (type === 'path') {
            var txt = make('input');
            txt.type = 'text';
            txt.value = value;
            txt.onchange = (function (m) {
                return function () {
                    writeKey(m, this.value);
                };
            })(meta);
            ctrl.appendChild(txt);
            entry.controls.push(txt);
        } else if (type === 'table') {
            ctrl.appendChild(renderTable(meta, value, entry));
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
            num.onchange = (function (m, input, hintEl) {
                return function () {
                    var r = clampInput(input, m, hintEl);
                    if (r !== null) {
                        writeKey(m, r);
                    }
                };
            })(meta, num, hint);
            num.oninput = (function (input, m, hintEl) {
                return function () {
                    removeClass(input, 'invalid');
                    hintEl.textContent = rangeHint(m, input.value);
                };
            })(num, meta, hint);
            ctrl.appendChild(num);
            row.appendChild(hint);
            entry.controls.push(num);
        }

        row.appendChild(ctrl);
        if (meta.unit) {
            var unit = make('span', 'unit');
            unit.textContent = meta.unit;
            row.appendChild(unit);
        }
        if ((meta.uiNote && meta.uiNote.length) || meta.desc) {
            var note = make('button', 'note-btn');
            note.type = 'button';
            note.textContent = '?';
            note.title = '说明';
            note.onclick = (function (m) {
                return function () {
                    openNote(m);
                };
            })(meta);
            row.appendChild(note);
            entry.noteBtn = note;
        }
        return row;
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
        wrap.appendChild(input);
        if (field.unit) {
            var u = make('span', 'unit');
            u.textContent = field.unit;
            wrap.appendChild(u);
        }
        return {wrap: wrap, input: input};
    }

    function rangeHint(meta, raw) {
        if (textOf(raw).replace(/\s+/g, '') === '') {
            return '';
        }
        var n = parseInt(raw, 10);
        if (isNaN(n)) {
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
        var n = parseInt(raw, 10);
        if (isNaN(n)) {
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
                hintEl.textContent = '已钳制到 ' + c + '（范围 ' + rangeHint(meta, n) + '）';
            }
        } else {
            removeClass(input, 'invalid');
            if (hintEl) {
                hintEl.textContent = '';
            }
        }
        return c;
    }

    function parseTable(value) {
        var rows = textOf(value).split('\n');
        var out = [];
        for (var i = 0; i < rows.length; i++) {
            if (rows[i] === '') {
                continue;
            }
            out.push(rows[i].split(','));
        }
        return out;
    }

    function renderTable(meta, value, entry) {
        var wrap = make('div', 'table-wrap');
        var fields = meta.rowFields || [];
        var rows = parseTable(value);
        var table = make('table', 'kid-table');
        var thead = make('thead');
        var htr = make('tr');
        var i;
        for (i = 0; i < fields.length; i++) {
            var th = make('th');
            th.textContent = fields[i].label || ('列' + (i + 1));
            if (fields[i].min !== null && fields[i].min !== undefined) {
                th.title = '范围 ' + fields[i].min + '~' + fields[i].max;
            }
            htr.appendChild(th);
        }
        var actTh = make('th');
        actTh.textContent = '';
        htr.appendChild(actTh);
        thead.appendChild(htr);
        table.appendChild(thead);

        var tbody = make('tbody');
        table.appendChild(tbody);
        var controls = [];

        function commit() {
            var out = [];
            for (var r = 0; r < tbody.children.length; r++) {
                var tr = tbody.children[r];
                var cells = [];
                for (var c = 0; c < fields.length; c++) {
                    var inp = tr.children[c].children[0];
                    var raw = textOf(inp.value).replace(/\s+/g, '');
                    if (raw === '') {
                        cells.push('');
                        continue;
                    }
                    var n = parseInt(raw, 10);
                    if (isNaN(n)) {
                        inp.value = '';
                        cells.push('');
                        continue;
                    }
                    if (fields[c].min !== null && fields[c].min !== undefined && n < fields[c].min) {
                        n = fields[c].min;
                    }
                    if (fields[c].max !== null && fields[c].max !== undefined && n > fields[c].max) {
                        n = fields[c].max;
                    }
                    inp.value = String(n);
                    cells.push(String(n));
                }
                out.push(cells.join(','));
            }
            writeKey(meta, out.join('\n'));
        }

        function addRow(values) {
            var tr = make('tr');
            for (var c = 0; c < fields.length; c++) {
                var td = make('td');
                var inp = make('input');
                inp.type = 'number';
                if (fields[c].min !== null && fields[c].min !== undefined) {
                    inp.min = String(fields[c].min);
                }
                if (fields[c].max !== null && fields[c].max !== undefined) {
                    inp.max = String(fields[c].max);
                }
                inp.value = values && values[c] !== undefined ? textOf(values[c]) : '';
                inp.onchange = commit;
                td.appendChild(inp);
                tr.appendChild(td);
                controls.push(inp);
            }
            var tdAct = make('td');
            var del = make('button', 'del-row');
            del.type = 'button';
            del.textContent = '删';
            del.onclick = function () {
                tbody.removeChild(tr);
                commit();
            };
            tdAct.appendChild(del);
            tr.appendChild(tdAct);
            tbody.appendChild(tr);
        }

        for (i = 0; i < rows.length; i++) {
            addRow(rows[i]);
        }
        var empty = make('div', 'meta');
        empty.textContent = rows.length ? '' : '（空表）';
        wrap.appendChild(empty);
        wrap.appendChild(table);

        var add = make('button', 'add-row');
        add.type = 'button';
        add.textContent = '添加一行';
        add.onclick = function () {
            addRow([]);
        };
        wrap.appendChild(add);

        entry.controls = controls;
        entry.table = table;
        return wrap;
    }

    function writeKey(meta, value) {
        var payload = {};
        payload[meta.key] = value;
        var res = call('setValues', JSON.stringify(payload));
        if (res && res.ok) {
            state.values[meta.key] = serializeValue(value);
            showMessage('config-message',
                (res.message || '已写入') + '（skipped=' + res.skipped + ', changed=' + res.changed + '）',
                true);
            if (meta.key === 'UI_GAP_SEC') {
                refreshChartConfig();
            }
        } else {
            showMessage('config-message',
                '写入失败：' + ((res && res.error) || '未知错误'), false);
        }
        refreshGates();
    }

    function refreshGates() {
        if (!state.defs || !state.defs.groups) {
            return;
        }
        var groups = state.defs.groups;
        for (var gi = 0; gi < groups.length; gi++) {
            var group = groups[gi];
            var masterOn = group.master ? asInt(valueOf(group.master)) === 1 : true;
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
                toggleClass(entry.row, 'disabled', !active);
                toggleClass(entry.row, 'hidden', hidden);
                for (var ci = 0; ci < entry.controls.length; ci++) {
                    entry.controls[ci].disabled = !active || hidden;
                }
            }
            if (group.master && state.rows[group.master]
                && state.rows[group.master].controls.length) {
                state.rows[group.master].controls[0].checked = asInt(valueOf(group.master)) === 1;
            }
        }
    }

    // ==================== 说明浮窗（按需渲染） ====================

    function openNote(meta) {
        var body = $('note-body');
        var title = $('note-title');
        if (!body || !title) {
            return;
        }
        clear(body);
        title.textContent = meta.label || meta.key;
        var notes = meta.uiNote || [];
        if (notes.length) {
            for (var i = 0; i < notes.length; i++) {
                var section = make('div', 'note-section');
                if (notes[i].title) {
                    var h = make('h3');
                    h.textContent = notes[i].title;
                    section.appendChild(h);
                }
                var p = make('p');
                p.textContent = notes[i].text || '';
                section.appendChild(p);
                body.appendChild(section);
            }
        } else {
            var only = make('div', 'note-section');
            var p2 = make('p');
            p2.textContent = meta.desc || '（无说明）';
            only.appendChild(p2);
            body.appendChild(only);
        }
        removeClass($('note-backdrop'), 'hidden');
    }

    function closeNote() {
        clear($('note-body'));
        addClass($('note-backdrop'), 'hidden');
    }

    // ==================== 曲线 ====================

    function refreshChartConfig() {
        var gap = numsOf(valueOf('UI_GAP_SEC'), 2);
        state.chart.detectSec = gap[0] > 0 ? gap[0] : 3;
        state.chart.gapMax = gap[1] > 0 ? gap[1] : 15;
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
            coldReal: nums[6]
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

    function drawChart() {
        var chart = state.chart;
        var canvas = chart.canvas;
        var ctx = chart.ctx;
        if (!canvas || !ctx) {
            return;
        }
        var W = canvas.clientWidth || 360;
        var H = canvas.clientHeight || 240;
        if (canvas.width !== W) {
            canvas.width = W;
        }
        if (canvas.height !== H) {
            canvas.height = H;
        }
        ctx.clearRect(0, 0, W, H);
        chart.drawCount++;

        var pts = visiblePoints();
        var padL = 44, padR = 40, padT = 14, padB = 24;
        if (pts.length < 2) {
            ctx.fillStyle = '#77808c';
            ctx.font = '12px sans-serif';
            ctx.fillText('暂无数据', padL, H / 2);
            return;
        }

        var first = pts[0];
        var last = pts[pts.length - 1];
        var span = last.unit - first.unit;
        if (span <= 0) {
            span = 1;
        }

        var leftValues = [];
        var coldValues = [];
        var i;
        for (i = 0; i < pts.length; i++) {
            var p = pts[i];
            if (chart.series.batt && p.batt >= 0) {
                leftValues.push(p.batt / 10);
            }
            if (chart.series.cpu && p.cpu >= 0) {
                leftValues.push(p.cpu / 10);
            }
            if (chart.series.hot && p.hot >= 0) {
                leftValues.push(p.hot / 10);
            }
            if (chart.series.rpm && p.rpm >= 0) {
                leftValues.push(p.rpm / 100);
            }
            if (chart.series.cold && p.coldReal >= 0) {
                coldValues.push(p.coldReal);
            }
        }
        var leftMin = 0;
        var leftMax = 50;
        if (leftValues.length) {
            leftMin = leftValues[0];
            leftMax = leftValues[0];
            for (i = 1; i < leftValues.length; i++) {
                if (leftValues[i] < leftMin) {
                    leftMin = leftValues[i];
                }
                if (leftValues[i] > leftMax) {
                    leftMax = leftValues[i];
                }
            }
        }
        var pad = Math.max(1, (leftMax - leftMin) * 0.08);
        leftMin -= pad;
        leftMax += pad;
        if (leftMax - leftMin < 1) {
            leftMax = leftMin + 1;
        }
        var coldMax = 40;
        for (i = 0; i < coldValues.length; i++) {
            if (coldValues[i] > coldMax) {
                coldMax = coldValues[i];
            }
        }

        function xOf(pt) {
            return padL + (W - padL - padR) * (pt.unit - first.unit) / span;
        }

        function yLeft(v) {
            return padT + (H - padT - padB) * (1 - (v - leftMin) / (leftMax - leftMin));
        }

        function yRight(v) {
            return padT + (H - padT - padB) * (1 - (v - 1) / (coldMax - 1));
        }

        ctx.strokeStyle = '#e4e7ec';
        ctx.lineWidth = 1;
        ctx.fillStyle = '#77808c';
        ctx.font = '10px sans-serif';
        for (i = 0; i <= 4; i++) {
            var y = padT + (H - padT - padB) * i / 4;
            ctx.beginPath();
            ctx.moveTo(padL, y);
            ctx.lineTo(W - padR, y);
            ctx.stroke();
            var leftLabel = (leftMax - (leftMax - leftMin) * i / 4).toFixed(1);
            ctx.fillText(leftLabel, 4, y + 3);
            if (chart.series.cold) {
                var coldLabel = Math.round(coldMax - (coldMax - 1) * i / 4);
                ctx.fillText(String(coldLabel), W - padR + 6, y + 3);
            }
        }

        function drawSeries(color, getter, yFn) {
            ctx.strokeStyle = color;
            ctx.lineWidth = 1.5;
            ctx.beginPath();
            var drawing = false;
            for (var k = 0; k < pts.length; k++) {
                var v = getter(pts[k]);
                if (v === null || v === undefined || v < 0) {
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

        if (chart.series.batt) {
            drawSeries('#2d7ff9', function (pt) {
                return pt.batt >= 0 ? pt.batt / 10 : -1;
            }, yLeft);
        }
        if (chart.series.cpu) {
            drawSeries('#e5484d', function (pt) {
                return pt.cpu >= 0 ? pt.cpu / 10 : -1;
            }, yLeft);
        }
        if (chart.series.hot) {
            drawSeries('#f5a623', function (pt) {
                return pt.hot >= 0 ? pt.hot / 10 : -1;
            }, yLeft);
        }
        if (chart.series.rpm) {
            drawSeries('#30a46c', function (pt) {
                return pt.rpm >= 0 ? pt.rpm / 100 : -1;
            }, yLeft);
        }
        if (chart.series.cold) {
            drawSeries('#8e4ec6', function (pt) {
                return pt.coldReal >= 0 ? pt.coldReal : -1;
            }, yRight);
        }
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
    }

    function chartClose() {
        if (state.timers.chart) {
            clearInterval(state.timers.chart);
            state.timers.chart = null;
        }
    }

    // ==================== 日志 ====================

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
        var fresh = [];
        if (state.log.lastLine === null) {
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
        var box = $('log-lines');
        for (var j = 0; j < fresh.length; j++) {
            var div = make('div', 'log-line');
            div.textContent = fresh[j];
            if (fresh[j].indexOf('[ERROR]') !== -1 || fresh[j].indexOf('错误') !== -1) {
                addClass(div, 'err');
            } else if (fresh[j].indexOf('[WARN]') !== -1 || fresh[j].indexOf('警告') !== -1) {
                addClass(div, 'warn');
            }
            box.appendChild(div);
            state.log.count++;
        }
        while (box.children.length > 500) {
            box.removeChild(box.children[0]);
        }
        if (lines.length) {
            state.log.lastLine = lines[lines.length - 1];
        }
        if (state.log.autoScroll) {
            box.scrollTop = box.scrollHeight;
        }
    }

    function logOpen() {
        if (!state.log.loaded) {
            state.log.loaded = true;
            logPoll();
        }
        if (!state.timers.log) {
            state.timers.log = setInterval(logPoll, 1000);
        }
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
        renderStatus(call('status'));
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

    // ==================== 页签与轮询 ====================

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
        $('status-refresh').onclick = function () {
            loadStatus();
        };
        $('log-scroll').onclick = function () {
            state.log.autoScroll = !state.log.autoScroll;
            this.textContent = '自动滚底：' + (state.log.autoScroll ? '开' : '关');
        };
        $('log-refresh').onclick = function () {
            logPoll();
        };
        $('note-close').onclick = function () {
            closeNote();
        };
        buildActions();
        refreshGates();
    }

    function showTab(name) {
        state.tab = name;
        var tabs = $('tabs').children;
        var i;
        for (i = 0; i < tabs.length; i++) {
            toggleClass(tabs[i], 'active', tabs[i].getAttribute('data-tab') === name);
        }
        var pages = ['status', 'config', 'chart', 'log'];
        for (i = 0; i < pages.length; i++) {
            toggleClass($('page-' + pages[i]), 'active', pages[i] === name);
        }
        if (name !== 'chart') {
            chartClose();
        }
        if (name !== 'log') {
            logClose();
        }
        if (name === 'status') {
            loadStatus();
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
        _state: state,
        _test: {
            showTab: showTab,
            chartIngest: chartIngest,
            chartPoll: chartPoll,
            drawChart: drawChart,
            logPoll: logPoll,
            doAction: doAction,
            openNote: openNote,
            closeNote: closeNote,
            writeKey: writeKey,
            refreshGates: refreshGates,
            visiblePoints: visiblePoints,
            parseChartLine: parseChartLine
        }
    };

    if (!window.__LITE_TEST__) {
        safeInit();
    }
})();
