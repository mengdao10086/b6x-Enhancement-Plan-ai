/* ============================================================
 * B6X 智能温控 WebUI — 主逻辑
 * 仅 KSU 系（KernelSU / KSU-Next / APatch）原生 WebUI
 * ============================================================ */
(function () {
  'use strict';

  // 全局错误捕获：任何 JS 异常都显示到横幅（必须先于可能崩溃的初始化）
  function reportError(msg) {
    var b = $('bridgeBanner');
    if (b) {
      b.classList.remove('hidden');
      b.classList.add('err');
      b.textContent = msg;
    }
    try { console.error('[WebUI] ' + msg); } catch (e) {}
  }
  window.addEventListener('error', function (e) {
    reportError('JS 错误: ' + (e.message || e.error) + ' @ ' + (e.filename || '').split('/').pop() + ':' + e.lineno);
  });
  window.addEventListener('unhandledrejection', function (e) {
    reportError('Promise 异常: ' + (e.reason && e.reason.message ? e.reason.message : e.reason));
  });

  var SCHEMA = window.B6X_SCHEMA;
  if (!SCHEMA) { reportError('schema.js 未加载，页面无法初始化'); return; }
  var CFG = SCHEMA.configPath;

  // ---------- 小工具 ----------
  function $(id) { return document.getElementById(id); }
  function uiLog(msg) {
    var el = $('uiDiagBody');
    if (el) {
      el.textContent += '[' + new Date().toTimeString().slice(0, 8) + '] ' + msg + '\n';
      el.scrollTop = el.scrollHeight;
    }
    try { console.log('[UI] ' + msg); } catch (e) {}
  }
  function fitInput(inp) {
    var val = String(inp.value || '');
    // 输入框宽度按内容自适应（值长 + 2ch 余量），上限交给 CSS max-width:100% 兜底，最小 5ch
    var ch = Math.max(val.length, 1) + 2;
    inp.style.width = 'calc(' + Math.max(ch, 5) + 'ch + 12px)';
  }
  function debounce(fn, ms) {
    var t;
    return function () { clearTimeout(t); t = setTimeout(fn, ms); };
  }
  // 安全的 localStorage 包装（WebView 禁用/测试环境时静默降级）
  function storeGet(k) { try { return window.localStorage ? window.localStorage.getItem(k) : null; } catch (e) { return null; } }
  function storeSet(k, v) { try { if (window.localStorage) window.localStorage.setItem(k, v); } catch (e) {} }
  function toast(msg, kind) {
    var t = $('toast');
    t.textContent = msg;
    t.className = 'toast show' + (kind === 'err' ? ' err' : '');
    clearTimeout(t._h);
    t._h = setTimeout(function () { t.className = 'toast'; }, 2200);
  }

  // ---------- 桥接：识别注入全局并归一化 exec ----------
  var Bridge = (function () {
    var w = window;
    var api = null, kind = '';
    if (w.kernelsu && w.kernelsu.console && typeof w.kernelsu.console.exec === 'function') {
      api = w.kernelsu.console.exec.bind(w.kernelsu.console); kind = 'kernelsu-console';
    } else if (w.kernelsu && typeof w.kernelsu.exec === 'function') {
      api = w.kernelsu.exec.bind(w.kernelsu); kind = 'kernelsu';
    } else if (w.ksu && typeof w.ksu.exec === 'function') {
      // KernelSU 管理器真实形态：addJavascriptInterface(WebViewInterface, "ksu")
      //   exec(cmd): String                 同步，直接返回输出（实测部分版本只返回首行）
      //   exec(cmd, callbackName: String)   异步，回调 = 全局函数名（字符串，不是函数对象！），返回完整输出
      // 探测：同步能返回完整多行 → 用同步；否则走异步回调名（KernelSU 官方 npm 库即此形态）
      api = (function () {
        var useAsync = false, probe = null;
        try { probe = w.ksu.exec("printf '__B6XA__\\n__B6XB__\\n__B6XC__'"); }
        catch (e) {}
        // 同步形态只返回"最后一行"，确认第一行 __B6XA__ 出现
        useAsync = !(typeof probe === 'string' && probe.indexOf('__B6XA__') !== -1);
        uiLog('ksu 探测: 同步返回=' + JSON.stringify(probe) + ' → useAsync=' + useAsync);
        return function (cmd, cb) {
          if (!useAsync) {
            try {
              var r = w.ksu.exec(cmd);
              if (typeof r === 'string') { cb({ errno: 0, stdout: r, stderr: '' }); return; }
            } catch (e) {}
          }
          var name = '__b6xKsuCb_' + Math.random().toString(36).slice(2, 10);
          var fired = false;
          window[name] = function (code, out, err) {
            if (fired) return; fired = true; delete window[name];
            cb({ errno: (typeof code === 'number' ? code : 0), stdout: out || '', stderr: err || '' });
          };
          try { w.ksu.exec(cmd, name); }
          catch (e2) {
            if (!fired) { fired = true; delete window[name]; cb({ errno: -1, stdout: '', stderr: 'ksu.exec: ' + e2.message }); }
          }
        };
      })();
      kind = 'ksu';
    } else if (w.mMRL && w.mMRL.console && typeof w.mMRL.console.exec === 'function') {
      api = w.mMRL.console.exec.bind(w.mMRL.console); kind = 'mmrl';
    }
    if (!api) uiLog('桥接: 未检测到 (kernelsu=' + typeof w.kernelsu + ', ksu=' + typeof w.ksu + ', mMRL=' + typeof w.mMRL + ')');
    else uiLog('桥接: ' + kind);
    // 兼容三种返回形态：Promise<{errno,stdout,stderr}> / 回调(errno,stdout,stderr) / 回调({errno,stdout,stderr})
    function normResult(a, b, c) {
      if (a && typeof a === 'object') {
        return {
          errno: (a.errno !== undefined ? a.errno : (a.code !== undefined ? a.code : 0)),
          stdout: a.stdout || '',
          stderr: a.stderr || ''
        };
      }
      return { errno: (typeof a === 'number' ? a : -1), stdout: b || '', stderr: c || '' };
    }
    return {
      kind: kind,
      available: !!api,
      exec: function (cmd) {
        if (!api) return Promise.resolve({ errno: -1, stdout: '', stderr: 'NO_BRIDGE' });
        return new Promise(function (resolve) {
          var settled = false;
          function done(a, b, c) { if (!settled) { settled = true; resolve(normResult(a, b, c)); } }
          var r;
          try { r = api(cmd, done); }
          catch (e) { uiLog('exec 异常: ' + String(cmd).slice(0, 60) + ' → ' + e.message); done({ errno: -1, stdout: '', stderr: 'bridge threw: ' + e.message }); }
          if (r && typeof r.then === 'function') {
            r.then(function (res) { done(res); }, function (err) {
              done({ errno: -1, stdout: '', stderr: String((err && err.message) || err) });
            });
          } else if (typeof r === 'string') {
            done({ errno: 0, stdout: r, stderr: '' });      // 同步返回字符串
          } else if (r && typeof r === 'object') {
            done(r);                                        // 同步返回结果对象
          }
          // 兜底超时：桥接既不回调也不返回 thenable → 悬挂变可见错误
          setTimeout(function () {
            if (!settled) uiLog('exec 超时(8s): ' + String(cmd).slice(0, 60));
            done({ errno: -2, stdout: '', stderr: 'bridge 超时(8s): ' + String(cmd).slice(0, 60) });
          }, 8000);
        });
      }
    };
  })();

  // ---------- 状态 ----------
  var S = {
    items: [],            // [{type:'kv'|'comment'|'blank', raw, key?, value?}]
    values: {},           // key -> 当前值字符串
    dirty: {},            // key -> true（值被改过）
    manualExpand: {},     // 本会话手动展开的分组（默认全部收起，点击组头展开，不持久化）
    samples: [],
    series: [
      // 图例顺序；默认除 CPU 外全显示；axis 决定走左/右纵轴
      // （实时数值列顺序由 updateLiveRow 独立维护，不受本数组顺序影响）
      { key: 'batt', label: '电池℃', color: '#f44336', on: true, unit: '°C', axis: 'left' },
      { key: 'coldReal', label: '制冷', color: '#4caf50', on: true, unit: '', axis: 'right' },
      { key: 'rpm', label: '风扇rpm', color: '#9c27b0', on: true, unit: 'rpm', axis: 'left' },
      { key: 'hot', label: '热端℃', color: '#e91e63', on: true, unit: '°C', axis: 'left' },
      { key: 'cold', label: '冷端℃', color: '#2196f3', on: false, unit: '°C', axis: 'left' },
      { key: 'cpu', label: 'CPU℃', color: '#ff9800', on: false, unit: '°C', axis: 'left' }
    ],
    logText: '',
    logFilter: '',
    manualScroll: false
  };

  // ---------- 配置解析 / 重建（注释保留） ----------
  function parseConfig(text) {
    var lines = text.split('\n');
    return lines.map(function (raw) {
      var m = raw.match(/^([A-Za-z0-9_]+)=([^\r\n]*)/);   // 兼容 CRLF/LF 行尾
      if (m) {
        // 剥离行内注释（如 LOG_MAX=7936   # 字节）
        var value = m[2].replace(/\s*#.*$/, '');
        return { type: 'kv', raw: raw, key: m[1], value: value };
      }
      if (/^\s*#/.test(raw)) return { type: 'comment', raw: raw };
      return { type: 'blank', raw: raw };
    });
  }
  function buildValues(items) {
    var v = {};
    items.forEach(function (it) { if (it.type === 'kv') v[it.key] = it.value; });
    return v;
  }
  function rebuildConfig() {
    return S.items.map(function (it) {
      if (it.type !== 'kv') return it.raw;
      if (S.dirty[it.key]) return it.key + '=' + S.values[it.key];
      return it.raw;
    }).join('\n');
  }

  function setValue(key, val, opts) {
    opts = opts || {};
    S.values[key] = val;
    S.dirty[key] = true;
    var el = document.querySelector('[data-key="' + key.replace(/"/g, '\\"') + '"]');
    if (el) {
      if (el.type === 'checkbox') el.checked = (val !== '0');
      else if (el.tagName === 'INPUT' && !el.dataset.rowField) el.value = val;
    }
    if (key === 'PERF_ENABLED' || key === 'DEBUG_ENABLED') updateCollapse();
    scheduleSave();
  }

  // ---------- 折叠逻辑：固定默认收起 + 组头点击手动展开（不随开关状态） ----------
  function masterOn(key) { return S.values[key] !== '0'; }

  // 分组是否有可折叠内容（子面板/模式面板/档位表/直接参数）；无折叠内容的分组
  // 不渲染小三角、不响应组头点击，说明区常显
  function hasCollapsible(g) {
    return !!(g.subKeys || (g.keys && g.keys.length));
  }

  function onHeaderClick(g) {
    if (!hasCollapsible(g)) return;   // 无折叠内容，组头点击无动作
    // 所有大类固定默认收起、不随开关状态展开；组头点击仅做会话级手动展开/收起（不持久化）
    S.manualExpand[g.id] = !S.manualExpand[g.id];
    updateCollapse();
  }

  function updateCollapse() {
    var toggled = false;   // 是否有分组刚展开/收起（展开后参数行才可测量）
    SCHEMA.groups.forEach(function (g) {
      if (!hasCollapsible(g)) return;   // 无折叠内容：说明区常显，不处理折叠
      var head = $('head-' + g.id), chev = $('chev-' + g.id), badge = $('badge-' + g.id);
      var body = $('body-' + g.id);
      if (!head || !body) return;
      // 全部大类固定默认收起、不随开关状态展开；仅组头点击做会话级手动展开/收起
      var open = !!S.manualExpand[g.id];
      if (body.classList.contains('collapsed') === open) toggled = true;
      body.classList.toggle('collapsed', !open);
      chev.classList.toggle('on', open);
      // 组头暗色/徽标仍反映开关实际状态（仅视觉提示，不影响折叠）
      var swKey = g.master || g.headerSwitch;
      var swOn = swKey ? masterOn(swKey) : true;
      head.classList.toggle('off', !swOn);
      if (badge) badge.classList.toggle('hidden', swOn);
    });
    if (toggled) fitParamRows();
  }

  // ---------- 控件构建 ----------
  function buildSwitchEl(key, defVal) {
    var val = S.values[key] !== undefined ? S.values[key] : (defVal !== undefined ? defVal : '0');
    var lab = document.createElement('label');
    lab.className = 'switch';
    var cb = document.createElement('input');
    cb.type = 'checkbox'; cb.dataset.key = key; cb.checked = (val !== '0');
    cb.addEventListener('change', function () { setValue(key, cb.checked ? '1' : '0'); });
    lab.appendChild(cb); lab.appendChild(document.createElement('i'));
    return lab;
  }

  // 字段名行：紧贴该输入框下方，只写字段名（数值框下方各跟一行；勾选框名已在框旁，不重复）
  function buildFieldName(text) {
    var name = document.createElement('span');
    name.className = 'field-name';
    name.textContent = text;
    return name;
  }

  function buildControl(key) {
    var def = SCHEMA.keys[key];

    // 标签区：label + 说明
    var wrap = document.createElement('div');
    wrap.className = 'ctrl';
    wrap.innerHTML = '<div class="ctrl-label">' + esc(def.label) +
      (String(def.desc).trim() ? '<div class="ctrl-desc">' + esc(def.desc) + '</div>' : '') + '</div>';

    // 控件区：按类型分发构建
    var val = S.values[key] !== undefined ? S.values[key] : def.value || '';

    if (def.type === 'switch') {
      wrap.appendChild(buildSwitchEl(key, def.value || ''));
    } else if (def.type === 'int') {
      wrap.appendChild(buildNumInput(key, val, def.min, def.max, def.step || 1, def.unit || ''));
    } else if (def.type === 'multi') {
      var parts = String(val).split(/\s+/);
      var row = document.createElement('div');
      row.className = 'multi';
      def.fields.forEach(function (f, i) {
        if (f.min === 0 && f.max === 1) {
          // 0/1 布尔字段（开关/模式位）：渲成 checkbox，勾→1 未勾→0，替代数字输入框
          var box = document.createElement('label');
          box.className = 'multicheck';
          var cb = document.createElement('input');
          cb.type = 'checkbox'; cb.dataset.multiKey = key + '::' + i;
          cb.checked = (parts[i] || '0') === '1';
          var tf = document.createElement('span');
          tf.textContent = f.label;
          box.appendChild(cb); box.appendChild(tf);
          row.appendChild(box);
        } else {
          // 数值字段：框 + 紧贴其下的字段名（竖排时各自跟着自己的框走）
          var field = document.createElement('div');
          field.className = 'multi-field';
          field.appendChild(buildNumInput(key + '::' + i, parts[i] || '0', f.min, f.max, 1, f.label));
          field.appendChild(buildFieldName(f.label));
          row.appendChild(field);
        }
      });
      function onMultiChange() {
        var out = [];
        def.fields.forEach(function (f, i) {
          var el = row.querySelector('[data-multi-key="' + key + '::' + i + '"]');
          if (el && el.type === 'checkbox') out.push(el.checked ? '1' : '0');
          else out.push(el ? el.value : '0');
        });
        setValue(key, out.join(' '));
      }
      row.addEventListener('input', onMultiChange);
      row.addEventListener('change', onMultiChange);   // checkbox 用 change 事件
      wrap.appendChild(row);

    } else if (def.type === 'path') {
      var inp = document.createElement('input');
      inp.type = 'text'; inp.className = 'text'; inp.dataset.key = key;
      inp.value = val;
      fitInput(inp);
      inp.addEventListener('input', function () { setValue(key, inp.value); fitInput(inp); });
      wrap.appendChild(inp);
    }
    return wrap;
  }

  // 数字输入框钳制到 [min,max]，并把钳制后的值同步回 input.value；输入非数字返回 null
  function clampNumInput(inp, min, max) {
    var n = parseInt(inp.value, 10);
    if (isNaN(n)) return null;
    if (n < min) { inp.value = min; n = min; }
    if (n > max) { inp.value = max; n = max; }
    return n;
  }

  function buildNumInput(key, val, min, max, step, placeholder) {
    var inp = document.createElement('input');
    inp.type = 'number'; inp.min = min; inp.max = max; inp.step = step;
    var isRow = key.indexOf('::') === -1;
    inp.dataset.key = key; inp.dataset.multiKey = key;
    if (isRow) inp.dataset.rowField = '1';
    inp.value = val;
    fitInput(inp);
    inp.addEventListener('input', function () {
      var n = clampNumInput(inp, min, max);
      if (n != null && isRow) setValue(key, String(n)); // multi 子输入不直接写 dirty
      fitInput(inp);
    });
    if (placeholder) inp.placeholder = placeholder;
    return inp;
  }

  // multi 值变化时联动其它子输入（号码输入框 value 直接改，不需要重渲染）
  function esc(s) {
    return String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
  }

  // ---------- 分组渲染 ----------
  // 分组首行说明（头部开关说明 / 分组说明共用）
  function appendNote(container, text) {
    var note = document.createElement('div');
    note.className = 'group-note';
    note.textContent = text;
    container.appendChild(note);
  }

  function buildGroup(g) {
    var sec = document.createElement('section');
    sec.className = 'group' + (g.master === 'PERF_ENABLED' || g.master === 'DEBUG_ENABLED' ? ' mastergroup' : '');
    sec.id = 'group-' + g.id;

    var head = document.createElement('header');
    head.id = 'head-' + g.id;
    head.className = 'group-head';
    head.innerHTML = (hasCollapsible(g) ? '<span class="chev" id="chev-' + g.id + '"></span>' : '') +
      '<span class="g-title">' + esc(g.title) + '</span>' +
      '<span class="badge hidden" id="badge-' + g.id + '">未生效</span>';
    if (g.headerSwitch && SCHEMA.keys[g.headerSwitch]) {
      var swEl = buildSwitchEl(g.headerSwitch);
      swEl.classList.add('head-switch');
      swEl.addEventListener('click', function (e) { e.stopPropagation(); });
      head.appendChild(swEl);
    }
    head.addEventListener('click', function () { onHeaderClick(g); });
    sec.appendChild(head);

    var body = document.createElement('div');
    body.id = 'body-' + g.id;
    body.className = 'group-body' + (hasCollapsible(g) ? '' : ' compact');
    sec.appendChild(body);

    // 头部开关的说明：作为分组首行说明
    if (g.headerSwitch && SCHEMA.keys[g.headerSwitch] && String(SCHEMA.keys[g.headerSwitch].desc).trim()) {
      appendNote(body, SCHEMA.keys[g.headerSwitch].desc);
    }
    if (g.note) appendNote(body, g.note);

    // 控件
    g.keys.forEach(function (k) {
      if (!SCHEMA.keys[k]) return; // 未知键（应保留原样，不渲染）
      body.appendChild(buildControl(k));
    });

    // g1：DEBUG_* 子开关面板
    if (g.subKeys) {
      var sub = document.createElement('div');
      sub.id = 'sub-' + g.id;
      sub.className = 'group-body sub-panel';
      g.subKeys.forEach(function (k) {
        if (SCHEMA.keys[k]) sub.appendChild(buildControl(k));
      });
      body.appendChild(sub);
    }

    return sec;
  }

  // ---------- 参数行排布：逐行取最矮（说明列 × 输入框组行数 多候选实测） ----------
  // 行宽由屏幕固定（不可改），参数区整体高度 = 各行高之和，故逐行压行高即为整体最小面积。
  // 说明列两种：① 与输入框组同行（说明列被挤窄 → 折行多）；② 输入框组另起一行（说明独占整行）。
  // multi 输入框组占几行：不限宽（自然排）/ 限宽到恰好 2 行 / 恰好 3 行——组窄了说明列变宽，
  // 两者互相拉扯，故不凭直觉，逐个候选真实测行高后取最矮。
  // 字段名与框同属一个 .multi-field，框折行时字段名跟着走；开关字段名内联，不占名字行。
  var MULTI_MAX_LINES = 3;     // 输入框组最多评估到几行
  function setRowLayout(row, label, share) {
    row.style.flexWrap = 'wrap';
    label.style.flex = share ? '1 1 0' : '1 1 100%';      // 基准 0：与输入框同行；基准 100%：说明独占整行
    label.style.minWidth = share ? '0' : '100%';
  }
  // 把字段宽按顺序切成 n 段（每段一行）时，最小可能的"最宽行"宽度 = 恰好排成 n 行所需的限宽
  function multiCapFor(ws, n, gap) {
    var k = ws.length;
    if (n >= k) return Math.max.apply(null, ws);           // 每行至少一个字段
    function lineW(a, b) { var w = 0; for (var i = a; i < b; i++) w += ws[i] + (i > a ? gap : 0); return w; }
    var best = Infinity;
    (function rec(start, lines, maxW) {
      if (maxW >= best) return;
      if (lines === 1) { best = Math.min(best, Math.max(maxW, lineW(start, k))); return; }
      for (var end = start + 1; end <= k - (lines - 1); end++) rec(end, lines - 1, Math.max(maxW, lineW(start, end)));
    })(0, n, 0);
    return best;
  }
  // 候选限宽列表：'' = 不限宽（自然排）；字段数不足的 N 行候选直接跳过
  function multiCaps(ws, gap) {
    var k = ws.length;
    if (k < 2) return [''];
    var caps = [''];
    for (var n = 2; n <= MULTI_MAX_LINES && n <= k; n++) caps.push(Math.ceil(multiCapFor(ws, n, gap)));
    return caps;
  }
  function multiFieldWidths(multi) {
    var fields = multi.children, ws = [], i;
    for (i = 0; i < fields.length; i++) ws.push(fields[i].offsetWidth);
    return ws;
  }
  // 输入框组实际占几行（按子项顶坐标分行，横排折行后行内顶坐标一致）
  function multiLines(multi) {
    var fields = multi.children, tops = {}, i, n = 0;
    for (i = 0; i < fields.length; i++) {
      if (tops[fields[i].offsetTop] === undefined) { tops[fields[i].offsetTop] = 1; n++; }
    }
    return n || 1;
  }
  // 开关是否独占一行（仅"需要换行"时用：占满整行宽度，其余字段在剩下的空间里折行）
  function setSwitchOwnLine(multi, own) {
    var fields = multi.children, i;
    for (i = 0; i < fields.length; i++) {
      if (fields[i].classList.contains('multicheck')) fields[i].style.flex = own ? '0 0 100%' : '';
    }
  }
  function fitParamRow(row) {
    if (!row.clientWidth) return;                        // 未挂载 / 所属分组收起：测不到尺寸
    var label = row.querySelector('.ctrl-label');
    if (!label) return;
    var multi = row.querySelector('.multi');
    var kids = row.children, ctrlW = 0, i;
    for (i = 0; i < kids.length; i++) if (kids[i] !== label) ctrlW += kids[i].offsetWidth;
    if (!ctrlW) return;                                  // 无输入框的行不处理
    var gap = parseFloat(window.getComputedStyle(row).columnGap) || 0;
    var ws = multi ? multiFieldWidths(multi) : null;
    var hasSwitch = !!(multi && multi.querySelector('.multicheck'));
    var key = row.clientWidth + '/' + ctrlW + (ws ? '/' + ws.join(',') : '');
    if (row.dataset.fitKey === key) return;              // 行宽与输入框/字段宽未变 → 上次结论仍有效
    row.dataset.fitKey = key;
    var caps = ws ? multiCaps(ws, gap) : [''];
    var owns = hasSwitch ? [false, true] : [false];      // true：开关独占一行
    var best = null;
    caps.forEach(function (cap) {
      owns.forEach(function (own) {
        [true, false].forEach(function (share) {
          if (multi) { multi.style.maxWidth = cap === '' ? '' : cap + 'px'; setSwitchOwnLine(multi, own); }
          setRowLayout(row, label, share);
          // 含开关的组：单行时开关不得独占（保持现状）；折行时开关必须独占
          if (hasSwitch && own !== (multiLines(multi) > 1)) return;
          var h = row.offsetHeight;
          if (!best || h < best.h) best = { h: h, share: share, cap: cap, own: own };
        });
      });
    });
    if (best) {
      if (multi) { multi.style.maxWidth = best.cap === '' ? '' : best.cap + 'px'; setSwitchOwnLine(multi, best.own); }
      setRowLayout(row, label, best.share);
    } else if (multi) {
      // 无可行组合（理论不可达）：退回不限宽 + 含开关则独占行 + 说明同行
      multi.style.maxWidth = '';
      setSwitchOwnLine(multi, hasSwitch);
      setRowLayout(row, label, true);
    }
  }
  // force=true：字体/视口变化会改变实测宽度 → 清缓存整体重算
  function fitParamRows(force) {
    var rows = document.querySelectorAll('#groups .ctrl');
    for (var i = 0; i < rows.length; i++) {
      if (force) rows[i].dataset.fitKey = '';
      fitParamRow(rows[i]);
    }
  }
  // 首次 + 视口/字体变化后重算（分组展开时由 updateCollapse 触发）
  function initParamLayout() {
    fitParamRows();
    window.addEventListener('resize', debounce(function () { fitParamRows(true); }, 150));
    if (document.fonts && document.fonts.ready) document.fonts.ready.then(function () { fitParamRows(true); });
  }

  // ---------- 档位表（已随 Gear 删除） ----------
  // ---------- 改即存（防抖自动写配置） ----------
  var saveTimer = null;
  function scheduleSave() {
    clearTimeout(saveTimer);
    saveTimer = setTimeout(save, 600);
  }

  function b64(str) {
    // 兼容中文注释（实际配置为 ASCII；走 UTF-8）
    return btoa(unescape(encodeURIComponent(str)));
  }

  async function save() {
    if (!Bridge.available) { toast('无桥接，无法保存', 'err'); return; }
    if (!Object.keys(S.dirty).length && !S.dirtySpecial) return;
    var text = rebuildConfig();
    var r = await Bridge.exec('echo ' + b64(text) + ' | base64 -d > ' + CFG);
    if (r.errno !== 0) { toast('保存失败: ' + (r.stderr || 'errno ' + r.errno), 'err'); return; }
    // 把刚写入的内容同步回 S.items 快照
    S.items = parseConfig(text);
    S.values = buildValues(S.items);
    S.dirty = {}; S.dirtySpecial = false;
    // 保存只重置 dirty，不清空 S.manualExpand
    updateCollapse();
    toast('已保存');
  }

  // ---------- 曲线数据：读 C 每 1s 写的数据文件（无现场采样） ----------
  function parseDataLines(text) {
    // 行格式：epoch,电池(0.1°C),CPU(0.1°C),热端(0.1°C),冷端(0.1°C),实际转速,实际制冷,目标制冷（未就绪为 -1）
    // 温度列 ×0.1°C → °C（负数/未就绪视为 null）；转速/制冷列保持原值
    var out = [];
    var lines = String(text || '').split('\n');
    function num(j) { var n = parseInt(p[j], 10); return isNaN(n) ? null : n; }
    function temp(v) { return v != null && v >= 0 ? v / 10 : null; }
    function raw(v) { return v != null && v >= 0 ? v : null; }
    for (var i = 0; i < lines.length; i++) {
      var p = lines[i].trim().split(',');
      if (p.length < 8) continue;
      out.push({
        t: num(0),
        batt: temp(num(1)), cpu: temp(num(2)), hot: temp(num(3)), cold: temp(num(4)),
        rpm: raw(num(5)), coldReal: raw(num(6))
      });
    }
    return out;
  }

  async function refreshCurve() {
    var r = await Bridge.exec('cat ' + SCHEMA.dataFile + ' 2>/dev/null');
    if (r.errno !== 0) { uiLog('数据文件读取失败 errno=' + r.errno); return; }
    if (!(r.stdout || '').trim()) { uiLog('数据文件为空（daemon 未在写入？）'); return; }
    S.samples = parseDataLines(r.stdout);
    var last = S.samples[S.samples.length - 1];
    if (last) updateLiveRow(last);
    drawChart();
    fitChartTools();   // 时间窗口+图例子窗口每刷重校准
  }

  // ---------- 单行自适应字号（图例栏 / 实时数据栏共用） ----------
  // 测量一律绕过 scrollWidth：部分 WebView 对 overflow:hidden 的容器不报告溢出内容。
  // 文本宽度优先用 canvas.measureText（最稳定），canvas
  // 不可用再用隐藏探针兜底；图例等多子项元素直接累加子项 offsetWidth + gap。
  var fitCv = null, fitProxy = null;
  function textWidth(t, fs, refEl) {
    var cs = refEl ? window.getComputedStyle(refEl) : null;
    var fam = (cs && cs.fontFamily) || '';
    // 隐藏探针优先：能如实反映 font-variant-numeric(tabular-nums 数字定宽)、letter-spacing 等实际渲染宽度
    if (!fitProxy) {
      fitProxy = document.createElement('div');
      fitProxy.style.cssText = 'position:fixed;visibility:hidden;pointer-events:none;white-space:nowrap;top:0;left:-9999px;';
      document.body.appendChild(fitProxy);
    }
    fitProxy.style.font = fs + 'px ' + fam;
    if (cs) {
      fitProxy.style.fontVariantNumeric = cs.fontVariantNumeric || '';
      fitProxy.style.letterSpacing = cs.letterSpacing || '';
    }
    fitProxy.textContent = t;
    var w = fitProxy.offsetWidth;
    if (w > 0) return w;
    // 探针不可用 → canvas 兜底（数字按等比宽测量，比 tabular 窄，加 5% 保险）
    if (!fitCv) fitCv = document.createElement('canvas');
    var c = fitCv.getContext && fitCv.getContext('2d');
    if (c) {
      c.font = fs + 'px ' + fam;
      try { var m = c.measureText(t).width; if (m > 0) return m * 1.05; } catch (e) { }
    }
    return 0;
  }
  function contentWidth(el) {
    if (el.childElementCount) {
      var kids = el.children, t = 0, i;
      for (i = 0; i < kids.length; i++) t += kids[i].offsetWidth;
      var g = parseFloat(window.getComputedStyle(el).columnGap);
      if (isFinite(g)) t += g * Math.max(0, kids.length - 1);
      return t;
    }
    return textWidth(el.textContent, parseFloat(el.style.fontSize) || 11, el);
  }
  // 单行完整显示（实时数值栏）：纯文本，字号缩小（0.1px 步进），4% 缓冲余量
  function fitOneLine(el, maxFs, minFs, bufferPct) {
    if (!el) return { avail: 0, total: 0, fs: 0, skip: '无元素' };
    var max = maxFs || 11, min = minFs == null ? 7 : minFs;
    var avail = el.clientWidth;
    if (!avail) return { avail: 0, total: 0, fs: 0, skip: 'clientWidth=0' };
    var fitLimit = avail * (bufferPct == null ? 0.96 : bufferPct);   // 4% 余量
    el.style.fontSize = max + 'px';
    var total = contentWidth(el);
    var fs = max;
    if (total > fitLimit) {
      fs = Math.max(min, Math.round(max * fitLimit / total * 10) / 10);   // 0.1px 步进，贴合更准
      el.style.fontSize = fs + 'px';
      var guard = 0;
      while (guard++ < 40 && fs > min && contentWidth(el) > fitLimit) {
        fs = Math.max(min, Math.round((fs - 0.1) * 10) / 10);
        el.style.fontSize = fs + 'px';
      }
    }
    return { avail: avail, total: total, fs: fs, skip: '' };
  }
  // 整体缩放子窗口（时间窗口 + 图例）：内部保持固定值，超宽时整个 transform: scale。
  // 裁切在父级 .chart-tools（overflow:hidden），与 transform 不同坐标系 → 缩放后内容落在可用区内
  function fitChartTools() {
    var wrap = $('ctInner');
    if (!wrap) return null;
    var avail = wrap.parentElement ? wrap.parentElement.clientWidth : 0;
    if (!avail) return null;
    var total = wrap.offsetWidth;                  // 自然宽（transform 不影响 offsetWidth）
    var fitLimit = avail * 0.96;                   // 4% 余量
    var z = total > fitLimit ? Math.max(0.5, fitLimit / total) : 1;
    wrap.style.transformOrigin = 'left top';
    wrap.style.transform = z < 1 ? 'scale(' + z.toFixed(4) + ')' : 'none';
    return { avail: avail, total: total, fs: Math.round(11 * z * 10) / 10, z: z, skip: '' };
  }
  var fitDiag = {};   // 适配诊断：结果变化时输出 可用宽/内容宽/字号/缩放/跳过原因
  function diagFit(id, r) {
    if (!r) return;
    var prev = fitDiag[id];
    if (!prev || prev.fs !== r.fs || prev.skip !== r.skip ||
        Math.abs(prev.avail - r.avail) >= 1 || Math.abs(prev.total - r.total) >= 1) {
      fitDiag[id] = r;
      uiLog('[fit] ' + id + ': 可用=' + r.avail + ' 内容=' + Math.round(r.total) +
            ' 字号=' + r.fs + (r.z ? ' 缩放=' + (r.z * 100).toFixed(0) + '%' : '') +
            (r.skip ? ' 跳过:' + r.skip : ''));
    }
  }
  function refitBars() {
    diagFit('chartTools', fitChartTools());
    diagFit('liveRow', fitOneLine($('liveRow'), 11, null, 0.96));
  }

  function updateLiveRow(o) {
    var bits = [];
    if (o.batt != null) bits.push('电池 ' + o.batt.toFixed(1) + '°C');
    if (o.cpu != null) bits.push('CPU ' + o.cpu.toFixed(1) + '°C');
    if (o.coldReal != null) bits.push('制冷 ' + o.coldReal);
    if (o.rpm != null) bits.push('风扇 ' + o.rpm + 'rpm');
    if (o.cold != null) bits.push('冷端 ' + o.cold.toFixed(1) + '°C');
    if (o.hot != null) bits.push('热端 ' + o.hot.toFixed(1) + '°C');
    var el = $('liveRow');
    el.textContent = bits.length ? bits.join(' · ') : '等待数据…';
    diagFit('liveRow', fitOneLine(el, 11, null, 0.96));   // 每帧重算；tabular-nums 定宽同字符数字号稳定
  }

  // 制冷轴辅助：右轴上限固定 = PID_COLD_RANGE 制冷上限（B6X 上限，默认 190）。
  // 按配置取 B6X 上限；总开关(PERF_ENABLED=1)未开启时回退默认 190。
  function pidColdMax() {
    if (S.values['PERF_ENABLED'] !== '1') return 190;   // 总开关未开启 → 默认 190
    var pc = S.values['PID_COLD_RANGE'];
    if (pc == null) return 190;
    var n = parseInt(String(pc).split(/[\s,]+/)[1], 10);   // 第二值 = B6X 上限
    return isFinite(n) && n > 0 ? n : 190;
  }
  var drawAxisDiag = false;   // 制冷轴范围一次性诊断

  // 读可配置秒数（profile.conf WebUI 键，缺省/非法回落默认值）
  function gapSec(key, def) { var n = parseFloat(S.values[key]); return isFinite(n) && n >= 0 ? n : def; }

  // ---------- B：整档刻度 / 数值格式化 ----------
  // 档位梯子：1、2、3，加所有 ≥5 的 5 的整数倍；最小档位即 1（无亚单位档位）
  var TICK_SMALL = [1, 2, 3, 5];
  var TICK_SEG_MIN = 3, TICK_SEG_MAX = 4, TICK_PREF = 3.5;   // 目标段数 3~4，理想步长 = 跨度÷3.5
  // 枚举 [lo, hi] 内的全部档位（升序）
  function ladderIn(lo, hi) {
    var out = [], i, k;
    for (i = 0; i < 3; i++) { if (TICK_SMALL[i] >= lo && TICK_SMALL[i] <= hi) out.push(TICK_SMALL[i]); }
    var k0 = Math.max(1, Math.ceil(lo / 5 - 1e-9));
    for (k = k0; 5 * k <= hi + 1e-9; k++) out.push(5 * k);
    return out;
  }
  // 离 t 最近的档位（闭式，无搜索）：平局取较小档位
  function nearestLadder(t) {
    if (!(t > 1)) return 1;
    if (t < 5) {
      var best = 1, bd = Infinity;
      for (var i = 0; i < TICK_SMALL.length; i++) {
        var d = Math.abs(TICK_SMALL[i] - t);
        if (d < bd) { bd = d; best = TICK_SMALL[i]; }
      }
      return best;
    }
    var a = 5 * Math.floor(t / 5), b = 5 * Math.ceil(t / 5);
    return (t - a) <= (b - t) ? Math.max(1, a) : b;
  }
  // 刻度值数组的唯一来源（原先 drawGrid 内另有一份同构实现，已合并到此，改动请只改这里）
  // 轴按 step 渲染出的刻度值数组（非整档对齐补原点刻度、末档补 max）
  function ticksOf(lo, hi, step) {
    var vals = [], v;
    var firstMult = Math.ceil(lo / step - 1e-9) * step;
    if (Math.abs(lo - firstMult) > step * 1e-6) vals.push(lo);
    for (v = firstMult; v <= hi + 1e-9; v += step) vals.push(v);
    var lastMult = Math.floor(hi / step + 1e-9) * step;
    if (hi - lastMult > step * 1e-6) vals.push(hi);
    return vals;
  }
  // 选档：先筛出能形成 3~4 段的候选档位，再取离「跨度÷3.5」最近者；无候选则纯取最近。
  // 候选必落在 [跨度/4, 跨度)：步长≥跨度时段数≤2、步长<跨度/4 时段数≥5，故该区间枚举完备。
  // 上下界按档位 floor/ceil 扩张，绝不裁点。
  function pickAxis(dmin, dmax) {
    if (!(dmax > dmin)) dmax = dmin + 1;
    var span = dmax - dmin, target = span / TICK_PREF, best = null;
    var cands = ladderIn(span / 4 * (1 - 1e-9), span * (1 + 1e-9));
    for (var i = 0; i < cands.length; i++) {
      var st = cands[i];
      var lo = Math.floor(dmin / st) * st, hi = Math.ceil(dmax / st) * st;
      var n = ticksOf(lo, hi, st).length - 1;      // 段数 = 实际渲染刻度数 − 1
      if (n < TICK_SEG_MIN || n > TICK_SEG_MAX) continue;
      var d = Math.abs(st - target);
      if (!best || d < best.d) best = { step: st, d: d };
    }
    return (best || { step: nearestLadder(target) }).step;
  }
  // 由数据最小/最大求整档轴（保证 min≤dmin、max≥dmax，绝不裁点）
  function niceAxis(dmin, dmax) {
    if (!(dmax > dmin)) dmax = dmin + 1;
    var step = pickAxis(dmin, dmax);
    return { min: Math.floor(dmin / step) * step, max: Math.ceil(dmax / step) * step, step: step };
  }
  // 按 step 决定小数位（整数去掉 .0；2.5 → 1 位）
  function fmtTick(v, step) {
    var s = String(step), dot = s.indexOf('.');
    var dec = dot >= 0 ? Math.min(2, s.length - dot - 1) : 0;
    var t = v.toFixed(dec);
    if (dec > 0 && t.slice(-2) === '.0') t = t.slice(0, -2);
    return t;
  }

  // ---------- 热端温度曲线滤波（零相位双向平滑 + 最小步长） ----------
  // 曲线仅用于展示、且 drawChart 每次重绘都对整段样本重算，故可用非因果平滑：
  // 前向一遍 EMA 后，再对结果反向做一遍同一 EMA（等价 filtfilt）。两遍互为共轭 → 相位为零，
  // 阶跃响应是对称 S 形（首尾斜率都趋 0），稳态等于原始值（无指数拖尾、无稳态偏置）。
  // 平滑强度：单遍 EMA 白噪声方差抑制 = α/(2−α)；两遍 = [α/(2−α)]²·[1 + 2(1−α)²/(2α−α²)]。
  var HOT_SMOOTH_ALPHA = 0.15;      // 每遍 EMA 权重（双向，实际平滑强于同 α 单遍）
  // 最小步长：输出只取该值的整数倍。热端采样本身即 0.1°C 量化，故 0.1 就是显示量子；
  // 作用是消灭平滑后残留的亚格点微挪（0.02 级抖动），而非改变曲线整体形状。
  var HOT_SMOOTH_MIN_STEP = 0.05;
  // 对一段连续有效样本就地双向平滑，结果写回 hotF。反向一遍以段末前向值为初值（末端延拓）：
  // 末尾沿用因果值、不引入跳变，段内为完整零相位。
  function smoothHotSegment(samples, idx) {
    var m = idx.length, j, prev, cur;
    prev = samples[idx[0]].hot;
    samples[idx[0]].hotF = prev;
    for (j = 1; j < m; j++) {
      prev += HOT_SMOOTH_ALPHA * (samples[idx[j]].hot - prev);
      samples[idx[j]].hotF = prev;
    }
    cur = samples[idx[m - 1]].hotF;
    for (j = m - 2; j >= 0; j--) {
      cur += HOT_SMOOTH_ALPHA * (samples[idx[j]].hotF - cur);
      samples[idx[j]].hotF = cur;
    }
    // 第三遍：最小步长量化。偏差达阈值才吸附到最近的 0.1 格点（一次可跨多格），
    // 吸附后残差 ≤ 半格(0.05)；阈值取 0.9 格：须 > 半格才不会吸附后抖动，又须 < 1 格，
    // 否则末级台阶（差值恰为 0.1）永远跨不过去、稳态会像旧实现一样永久差 0.1。
    // 锚点须对齐 0.1 整格（原始值即整格），否则整条曲线会带一个常数偏移、且稳态不落在真值上。
    var q = Math.round(samples[idx[0]].hotF / HOT_SMOOTH_MIN_STEP) * HOT_SMOOTH_MIN_STEP;
    var thr = HOT_SMOOTH_MIN_STEP * 0.9;
    samples[idx[0]].hotF = q;
    for (j = 1; j < m; j++) {
      var dx = samples[idx[j]].hotF - q;
      if (dx >= thr || dx <= -thr) q += HOT_SMOOTH_MIN_STEP * Math.round(dx / HOT_SMOOTH_MIN_STEP);
      samples[idx[j]].hotF = q;
    }
  }
  // 顺序平滑整个样本序列（结果与显示窗口无关，同一份数据每次得到同一曲线）
  function applyHotFilter(samples) {
    var seg = [], i, n = samples.length;
    for (i = 0; i < n; i++) {
      if (samples[i].hot == null || samples[i].hot < 0) {   // 无效值：断档，段结束
        samples[i].hotF = null;
        if (seg.length) { smoothHotSegment(samples, seg); seg = []; }
        continue;
      }
      seg.push(i);
    }
    if (seg.length) smoothHotSegment(samples, seg);
  }

  // ---------- 曲线（双纵轴：左 ℃/rpm，右 cold） ----------
  function drawChart() {
    applyHotFilter(S.samples);                        // 热端滤波（曲线专用；实时数值栏仍显示原始值）
    var cv = $('chart'), dpr = window.devicePixelRatio || 1;
    var cw = cv.clientWidth, ch = cv.clientHeight;
    if (!cw || !ch) return;
    cv.width = cw * dpr; cv.height = ch * dpr;
    var ctx = cv.getContext('2d');
    ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
    ctx.clearRect(0, 0, cw, ch);
    var padL = 36, padR = 36, padT = 16, padB = 4;
    var W = cw - padL - padR, H = ch - padT - padB;
    var data = S.samples.slice(-(S.window || 360));   // 先按条数收紧
    // 再按时间戳收紧到"最近 window 秒"：纵轴/曲线只依据显示窗口内的样本。
    // 否则断联或稀疏采样时条数≠秒数，窗口之外的早期样本会抬高纵轴上下限。
    var winSec = S.window || 360;
    var lastT = data[data.length - 1].t;
    if (data.length > 1 && isFinite(lastT)) {
      var cutoff = lastT - winSec;
      var start = 0;
      while (start < data.length - 1 && data[start].t < cutoff) start++;
      if (start > 0) data = data.slice(start);
    }
    var leftSeries = S.series.filter(function (s) { return s.on && s.axis === 'left'; });
    var rightSeries = S.series.filter(function (s) { return s.on && s.axis === 'right'; });

    // —— 断联感知布局 ——
    // C 端断联时不写曲线数据行（重连才续写），曲线数据里断联表现为相邻采样时间戳跳变。
    // 相邻采样时间差 > 断联判定阈值 视为一次断联：断开曲线，并按真实断开时长插入空白
    // （空白宽度 = 正常绘制该秒数的宽度，封顶到最大宽度），直观反映断联长短。
    // 阈值/最大宽度由 profile.conf 配置（WEBUI_GAP_DETECT_SEC / WEBUI_GAP_MAX_SEC）。
    var gapDetectSec = gapSec('WEBUI_GAP_DETECT_SEC', 5);
    var gapMaxSec    = gapSec('WEBUI_GAP_MAX_SEC', 15);
    var gap = new Array(data.length);
    var totalGap = 0, di;
    for (di = 0; di < data.length; di++) {
      if (di > 0) {
        var dt = data[di].t - data[di - 1].t;
        if (dt > gapDetectSec) totalGap += Math.min(dt, gapMaxSec);
      }
      gap[di] = totalGap;
    }
    var totalUnits = (data.length > 1 ? data.length - 1 : 0) + totalGap;

    if (data.length < 2 || (!leftSeries.length && !rightSeries.length)) {
      ctx.fillStyle = '#888'; ctx.font = '12px system-ui';
      ctx.fillText(data.length < 2 ? '采样中…' : '无曲线', padL + W / 2 - 24, padT + H / 2);
      return;
    }
    // 取值：左轴 = 温度(℃) 或 风扇转速÷100；右轴 = 制冷强度；热端取滤波后的曲线值
    function leftV(s, d) { return s.key === 'rpm' ? (d.rpm == null ? null : d.rpm / 100) : (s.key === 'hot' ? d.hotF : d[s.key]); }
    function rightV(s, d) { return d[s.key]; }
    var dark = !!(window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches);
    // 数据范围（未 padding，供整档轴；保证 min≤数据min、max≥数据max，绝不裁点）
    function extent(series, getV) {
      var mn = Infinity, mx = -Infinity;
      series.forEach(function (s) {
        data.forEach(function (d) { var v = getV(s, d); if (v == null) return; if (v < mn) mn = v; if (v > mx) mx = v; });
      });
      if (!isFinite(mn) || !isFinite(mx)) return null;
      return { min: mn, max: mx };
    }
    var Lext = extent(leftSeries, leftV);
    var L = null, R = null;
    if (Lext) L = niceAxis(Lext.min, Lext.max);
    // 制冷强度轴（右轴）：固定范围 [COLD_MIN=1, 制冷上限]。上限取 PID_COLD_RANGE 第二值（B6X 上限，默认 190），
    // 不随数据浮动、不用映射起始强度保底；右轴只提供「值→高度」映射，刻度文字由左轴横线位置决定。
    if (rightSeries.length) {
      var cHigh = pidColdMax();
      R = { min: 1, max: cHigh };
      if (!drawAxisDiag) { drawAxisDiag = true; uiLog('[轴] 制冷轴固定 1~' + R.max + '（PID_COLD_RANGE 第二值，默认 190）'); }
    }
    // 单轴全无效值时该轴 null。
    // 双轴都不可画（全 null）则无曲线可画；仅一轴有效时仍画该轴。
    if (!L && !R) return;
    function yOf(axis, v) { return padT + H * (1 - (v - axis.min) / (axis.max - axis.min)); }
    // 刻度网格 + 轴标题（B 整档：只改标签与网格位置，不动数据点 x 映射）
    // 左轴网格 + 刻度（整图唯一一套横线；右轴不再自算刻度、不再单独画线）
    function drawGrid(axis) {
      ctx.font = '10px system-ui'; ctx.fillStyle = '#888';
      ctx.textAlign = 'right';
      var step = axis.step;
      // 刻度值：轴非整档对齐补一个原点刻度；末档补 max
      var vals = ticksOf(axis.min, axis.max, step);
      for (var i = 0; i < vals.length; i++) {
        var val = vals[i];
        var y = yOf(axis, val);
        ctx.fillText(fmtTick(val, step), padL - 4, y + 3);
        ctx.strokeStyle = 'rgba(128,128,128,0.15)';
        ctx.beginPath(); ctx.moveTo(padL, y); ctx.lineTo(padL + W, y); ctx.stroke();
      }
      ctx.textAlign = 'left';
      ctx.fillText('℃/百rpm', 2, padT - 7);
    }
    // 右轴刻度文字：沿左轴每条横线的高度标一个制冷强度整数（不画线）。
    // 值 = 把该高度线性映射进 [1, 制冷上限] 后四舍五入；左轴无可依刻度时（左轴全关）不标。
    function drawRightColdLabels(leftAxis, coldAxis) {
      var lSpan = leftAxis.max - leftAxis.min;
      var cSpan = coldAxis.max - coldAxis.min;
      if (!(lSpan > 0) || !(cSpan > 0)) return;
      var xTxt = padL + W + 4;
      ctx.font = '10px system-ui'; ctx.fillStyle = '#888'; ctx.textAlign = 'left';
      var vals = ticksOf(leftAxis.min, leftAxis.max, leftAxis.step);
      for (var i = 0; i < vals.length; i++) {
        var n = Math.round(coldAxis.min + cSpan * (vals[i] - leftAxis.min) / lSpan);
        if (n < coldAxis.min) n = coldAxis.min;
        if (n > coldAxis.max) n = coldAxis.max;
        ctx.fillText(String(n), xTxt, yOf(leftAxis, vals[i]) + 3);
      }
      ctx.fillText('制冷', padL + W + 4, padT - 7);
    }
    // 渲染顺序：网格 → 折线 → 标注
    if (L) drawGrid(L);
    if (L && R) drawRightColdLabels(L, R);
    // 画线
    function plot(series, getV, axis) {
      if (!axis) return;   // 该轴范围无效（全 null），跳过该轴绘制
      series.forEach(function (s) {
        ctx.strokeStyle = s.color; ctx.lineWidth = 1.6;
        ctx.beginPath();
        var started = false;
        for (var di = 0; di < data.length; di++) {
          if (di > 0 && data[di].t - data[di - 1].t > gapDetectSec) started = false;   // 断联处断开，空白不连桥
          var v = getV(s, data[di]);
          if (v == null) continue;
          var x = padL + W * ((di + gap[di]) / totalUnits);
          var y = yOf(axis, v);
          if (started) ctx.lineTo(x, y); else { ctx.moveTo(x, y); started = true; }
        }
        ctx.stroke();
      });
    }
    plot(leftSeries, leftV, L);
    plot(rightSeries, rightV, R);

    // ===== A 当前值标注：每条序列最后一个有效采样点（曲线头部指针）=====
    // 头部合并逻辑（组上下端都落进阈值才合并）+ 标签优先放在空间大的一侧。
    function drawHeadMarkers() {
      var LABEL_H = 11;                                // 标签近似高度（10px 字体）
      var MERGE_Y = gapSec('WEBUI_LABEL_MERGE_PX', 9); // 合并阈值（px，默认 9≈0.8×标签高）
      // 标签取实际物理值：温度 ℃ 一位小数、风扇转速换算回实际 rpm（纵轴单位仍是 ÷100 的百rpm）
      function headLabel(s, v) { return s.unit === '°C' ? (v.toFixed(1) + '°C') : (s.key === 'rpm' ? (Math.round(v * 100) + 'rpm') : (s.key === 'coldReal' ? '' + v : (v + '%'))); }
      var entries = [];
      function collect(series, getV, axis) {
        if (!axis) return;
        series.forEach(function (s) {
          var last = -1, lv = null;
          for (var k = data.length - 1; k >= 0; k--) { var hv = getV(s, data[k]); if (hv != null) { last = k; lv = hv; break; } }
          if (last < 0) return;
          var x = padL + W * ((last + gap[last]) / totalUnits);
          var y = yOf(axis, lv);
          if (y < padT) y = padT;              // 对准曲线端点（顶满时与边框交点一致，不再偏下）
          if (y > padT + H) y = padT + H;
          entries.push({ x: x, y: y, color: s.color, label: headLabel(s, lv) });
        });
      }
      collect(leftSeries, leftV, L);
      collect(rightSeries, rightV, R);
      if (!entries.length) return;
      ctx.font = '10px system-ui';
      entries.forEach(function (e) {
        e.w = ctx.measureText(e.label).width;
        e.tx = e.x + 6;
        if (e.tx + e.w > padL + W) e.tx = e.x - 6 - e.w;
        if (e.tx < 2) e.tx = 2;
      });
      // 按 y 升序；组的上下端都落进阈值(< MERGE_Y)才合并，否则断成新组
      entries.sort(function (a, b) { return a.y - b.y; });
      var clusters = [], cur = null;
      entries.forEach(function (e) {
        if (cur && e.y - cur[0].y < MERGE_Y) cur.push(e);
        else { cur = [e]; clusters.push(cur); }
      });
      // 标签基准 y：取空间更大的一侧（上方空间大→放上面；下方大→放下面）
      function sideY(cl) {
        var top = cl[0].y, bot = cl[cl.length - 1].y;
        if ((top - padT) >= (padT + H - bot)) return top - 4;   // 上面
        return bot + LABEL_H + 1;                               // 下面
      }
      function dot(e) {
        ctx.fillStyle = e.color;
        ctx.beginPath(); ctx.arc(e.x, e.y, 3.2, 0, Math.PI * 2); ctx.fill();
        ctx.strokeStyle = dark ? '#101418' : '#ffffff'; ctx.lineWidth = 1; ctx.stroke();
      }
      clusters.forEach(function (c) {
        var ly = sideY(c);
        if (ly < padT) ly = padT;
        if (ly > padT + H + LABEL_H) ly = padT + H + LABEL_H;
        if (c.length === 1) {
          dot(c[0]);
          ctx.font = '10px system-ui'; ctx.fillStyle = c[0].color;
          ctx.fillText(c[0].label, c[0].tx, ly);
          return;
        }
        // 合并为一行：每段自身颜色，' / ' 灰间隔
        var cx = 0; c.forEach(function (e) { cx += e.x; }); cx /= c.length;
        var sep = ctx.measureText(' / ').width;
        var total = c.reduce(function (s, e) { return s + e.w; }, 0) + sep * (c.length - 1);
        var tx = cx + 6;
        if (tx + total > padL + W) tx = cx - 6 - total;
        if (tx < 2) tx = 2;
        ctx.font = '10px system-ui';
        for (var i = 0; i < c.length; i++) {
          ctx.fillStyle = c[i].color;
          ctx.fillText(c[i].label, tx, ly);
          tx += c[i].w;
          if (i < c.length - 1) { ctx.fillStyle = '#888'; ctx.fillText(' / ', tx, ly); tx += sep; }
        }
        c.forEach(dot);
      });
    }
    drawHeadMarkers();
    ctx.textAlign = 'left';
  }

  // ---------- 日志 ----------
  function logLineClass(l) {
    if (/\[DEBUG\]/.test(l)) return 'lg-debug';
    if (/\[PID\]/.test(l)) return 'lg-pid';
    if (/(失败|错误|无法|error|fail|异常)/i.test(l)) return 'lg-err';
    if (/^\[\d\d \d\d:\d\d:\d\d\]/.test(l)) return 'lg-time';
    return '';
  }

  async function refreshLog() {
    var logFile = S.values.LOG_FILE || '/cache/tempctrl.log';
    var r = await Bridge.exec('tail -c 400000 ' + logFile + ' 2>/dev/null');
    if (r.errno !== 0) { S.logText = ''; } else { S.logText = r.stdout || ''; }
    renderLog();
    if (!S.manualScroll) scrollLogBottom();
  }

  function renderLog() {
    var view = $('logView');
    var lines = (S.logText || '').split('\n');
    if (lines.length && lines[lines.length - 1] === '') lines.pop();
    var kw = S.logFilter.trim().toLowerCase();
    if (kw) lines = lines.filter(function (l) { return l.toLowerCase().indexOf(kw) !== -1; });
    view.textContent = '';
    var frag = document.createDocumentFragment();
    var start = Math.max(0, lines.length - 400);
    if (start > 0) frag.appendChild(document.createTextNode('…（较早 ' + start + ' 行省略，打开 DEBUG 后日志会更大）\n'));
    for (var i = start; i < lines.length; i++) {
      var cls = logLineClass(lines[i]);
      var span = document.createElement('span');
      if (cls) span.className = cls;
      span.textContent = lines[i] + '\n';
      frag.appendChild(span);
    }
    view.appendChild(frag);
  }

  function scrollLogBottom() {
    var v = $('logView');
    v.scrollTop = v.scrollHeight;
  }

  // ---------- 顶部横滑容器 + 固定/滚动隐藏 ----------
  function initTop() {
    var slider = $('topSlider');
    var seg = $('seg');
    function setSegActive(name) {
      seg.querySelectorAll('.seg-btn').forEach(function (b) { b.classList.toggle('active', b.dataset.panel === name); });
    }
    function goTo(name) {
      slider.scrollTo({ left: name === 'log' ? slider.clientWidth : 0, behavior: 'smooth' });
      setSegActive(name);
    }
    seg.querySelectorAll('.seg-btn').forEach(function (b) {
      b.addEventListener('click', function () { goTo(b.dataset.panel); });
    });
    // 滚动停止后才按最终位置同步高亮
    var syncSeg = debounce(function () {
      var p = slider.scrollLeft / Math.max(1, slider.clientWidth);
      setSegActive(p > 0.5 ? 'log' : 'chart');
    }, 120);
    slider.addEventListener('scroll', syncSeg, { passive: true });
    // 图钉：图标蓝底状态完全由 body 的 pin-fixed 类驱动（初始/点击后都走 syncPinState）
    $('pinBtn').addEventListener('click', function () {
      document.body.classList.toggle('pin-fixed');
      var pinned = document.body.classList.contains('pin-fixed');
      document.body.classList.toggle('pin-scroll', !pinned);   // 互斥：移除另一类
      syncPinState();
    });
  }

  // ---------- 曲线控件 ----------
  function setChartWindow(v) {
    S.window = parseInt(v, 10) || 360;
    storeSet('b6xChartWindow', String(S.window));
    updateWindowUI();
    drawChart();
  }

  function updateWindowUI() {
    var wbox = $('chartWindow');
    wbox.querySelectorAll('.win-btn').forEach(function (x) {
      x.classList.toggle('active', x.dataset.w === String(S.window));
    });
  }

  function initChartUI() {
    var w = parseInt(storeGet('b6xChartWindow') || '360', 10);
    if (SCHEMA.chartWindowOptions.indexOf(w) === -1) w = 360;   // 非可选值回落默认挡位
    S.window = w;
    var wbox = $('chartWindow');
    SCHEMA.chartWindowOptions.forEach(function (v) {
      var b = document.createElement('button');
      b.className = 'win-btn';
      b.textContent = v + 's';
      b.dataset.w = String(v);
      b.addEventListener('click', function () { setChartWindow(v); });
      wbox.appendChild(b);
    });
    updateWindowUI();

    var st = $('seriesToggle');
    S.series.forEach(function (s) {
      var lab = document.createElement('label');
      lab.className = 'series-item';
      var inp = document.createElement('input');
      inp.type = 'checkbox'; inp.checked = s.on;
      var ic = document.createElement('i');
      ic.style.background = s.color;
      lab.appendChild(inp); lab.appendChild(ic);
      lab.appendChild(document.createTextNode(s.label));
      inp.addEventListener('change', function () { s.on = inp.checked; drawChart(); });
      st.appendChild(lab);
    });
    refitBars();   // 图例 + 实时数据栏首次适配（两侧留白与全局左侧 10px 一致）
    // 窗口尺寸变化、字体异步加载完成、WebView 布局变化时重新适配
    window.addEventListener('resize', refitBars);
    if (document.fonts && document.fonts.ready) document.fonts.ready.then(refitBars);
    if (window.ResizeObserver) {
      var ro = new ResizeObserver(refitBars);
      ro.observe($('ctInner'));
      ro.observe($('liveRow'));
    }
    // 曲线画布尺寸变化即重绘（rAF 节流）
    if (window.ResizeObserver) {
      var rafP = null;
      var chartRo = new ResizeObserver(function () {
        if (rafP != null) return;
        rafP = requestAnimationFrame(function () {
          rafP = null;
          drawChart();
        });
      });
      chartRo.observe($('chart'));
    }
  }

  // ---------- 日志 UI ----------
  function initLogUI() {
    $('logFilter').addEventListener('input', function () { S.logFilter = this.value; renderLog(); if (!S.manualScroll) scrollLogBottom(); });
    $('logView').addEventListener('scroll', function () {
      var v = this;
      var near = v.scrollHeight - v.scrollTop - v.clientHeight < 40;
      S.manualScroll = !near;
      $('logFollowBtn').classList.toggle('off', !near);
    }, { passive: true });
    $('logFollowBtn').addEventListener('click', function () { S.manualScroll = false; scrollLogBottom(); $('logFollowBtn').classList.remove('off'); });
  }

  // ---------- 顶部高度：点住即拖动改高度（不记忆，每次加载回默认 = 渲染窗口的 2/5，pin-fixed/pin-scroll 均生效） ----------
  var TOP_H_MIN = 15, TOP_H_MAX = 80;      // dvh 范围
  var TOP_H_DEFAULT = 36;                  // 默认顶部高度（dvh）

  function applyTopHeight(v) {
    document.documentElement.style.setProperty('--top-h', v + 'dvh');
  }

  function initTopHeight() {
    applyTopHeight(TOP_H_DEFAULT);   // 不记忆上次调整值，每次打开回到默认

    var hd = $('topHandle');
    if (!hd) return;
    var active = false, startY = 0, startH = 0;
    function onDown(e) {
      var t = e.touches ? e.touches[0] : e;
      startY = t.clientY;
      startH = parseFloat(getComputedStyle(document.documentElement).getPropertyValue('--top-h')) || TOP_H_DEFAULT;
      active = true;                          // 点住即进入调整，无需长按
      hd.classList.add('dragging');
    }
    function onMove(e) {
      if (!active) return;
      e.preventDefault();
      var t = e.touches ? e.touches[0] : e;
      var dvh = (t.clientY - startY) / (window.innerHeight || 100) * 100;
      var v = startH + dvh;
      if (v < TOP_H_MIN) v = TOP_H_MIN;
      if (v > TOP_H_MAX) v = TOP_H_MAX;
      applyTopHeight(v);
    }
    function onUp() {
      if (!active) return;
      active = false;
      hd.classList.remove('dragging');
      if (typeof drawChart === 'function') drawChart();   // 高度定下后立即重绘（纵轴刻度数随之变化）
    }
    hd.addEventListener('touchstart', onDown, { passive: false });
    hd.addEventListener('touchmove', onMove, { passive: false });
    hd.addEventListener('touchend', onUp);
    hd.addEventListener('mousedown', onDown);
    window.addEventListener('mousemove', onMove);
    window.addEventListener('mouseup', onUp);
  }

  // 图钉状态同步：仅固定时蓝色（蓝底 = body 有 pin-fixed）
  function syncPinState() {
    $('pinBtn').classList.toggle('active', document.body.classList.contains('pin-fixed'));
  }

  // ---------- 启动 ----------
  async function init() {
    var errText = null;
    var bridgeLine = '桥接=' + (Bridge.kind || '无') + (Bridge.available ? '' : '（未检测到注入全局）');
    // 读取配置失败也不中止：渲染空结构，确切错误信息显示到横幅
    try {
      var r = await Bridge.exec('cat ' + CFG + ' 2>/dev/null');
      uiLog('配置读取: errno=' + r.errno + ' stdout长度=' + (r.stdout || '').length + ' 前120字=' + JSON.stringify((r.stdout || '').slice(0, 120)));
      if (r.errno !== 0) {
        errText = '读取配置失败 errno=' + r.errno + (r.stderr ? ' stderr=' + r.stderr : '') + ' — ' + bridgeLine;
        S.items = []; S.values = {};
      } else {
        S.items = parseConfig(r.stdout || '');
        S.values = buildValues(S.items);
        uiLog('配置解析: 共' + S.items.length + '行, PERF_ENABLED=' + JSON.stringify(S.values.PERF_ENABLED) + ', 键数=' + Object.keys(S.values).length);
        var emptyKeys = [];
        SCHEMA.groups.forEach(function (g) {
          var gk = (g.keys || []).concat(g.subKeys || []).concat(g.headerSwitch ? [g.headerSwitch] : []);
          gk.forEach(function (k) {
            if (SCHEMA.keys[k] && (S.values[k] === undefined || S.values[k] === '')) emptyKeys.push(k);
          });
        });
        if (emptyKeys.length) uiLog('空值/缺失的键: ' + emptyKeys.join(', '));
        else uiLog('空值/缺失的键: 无');
      }
    } catch (e) {
      errText = '初始化异常: ' + e.message + ' — ' + bridgeLine;
      S.items = []; S.values = {};
    }
    try {
      renderGroups();
    } catch (e) {
      errText = (errText ? errText + ' | ' : '') + '渲染异常: ' + e.message;
    }
    initTop();
    syncPinState();
    initChartUI();
    initLogUI();
    initTopHeight();
    updateCollapse();
    initParamLayout();   // 参数行排布（输入框可多行）
    if (errText) reportError(errText);
    else if (!Bridge.available) reportError('未检测到 WebUI 桥接 — 请在 KernelSU / KSU-Next / APatch 管理器内打开本模块 WebUI');
    else uiLog('已加载 · 桥接=' + (Bridge.kind || '?'));   // 合并进 UI 诊断日志（默认收起）
    uiLog('[fit] 诊断版已加载（下方应有 [fit] chartTools/liveRow 适配行与 [轴] 制冷轴行；若无 = 仍是旧版 app.js 缓存，请强刷 WebUI）');
    refreshCurve();                    // 曲线：读 C 数据文件，每秒一次
    setInterval(refreshCurve, 1000);
    refreshLog();                      // 日志：5 秒刷新一次（增量缓存）
    setInterval(refreshLog, 5000);
  }

  function renderGroups() {
    var root = $('groups');
    root.innerHTML = '';
    SCHEMA.groups.forEach(function (g) {
      root.appendChild(buildGroup(g));
    });
  }

  // 测试钩子：仅当 window.__B6X_TEST__ 显式开启时暴露内部（生产 WebView 无此全局，无影响）
  if (window.__B6X_TEST__) {
    window.__B6X_TEST__ = {
      parseConfig: parseConfig, buildValues: buildValues, rebuildConfig: rebuildConfig,
      parseDataLines: parseDataLines,
      smoothHotSegment: smoothHotSegment, applyHotFilter: applyHotFilter,   // 热端曲线滤波（零相位双向）
      fitParamRow: fitParamRow, fitParamRows: fitParamRows,           // 参数行排布
      multiCapFor: multiCapFor, multiCaps: multiCaps,                 // 输入框组限宽候选
      fitOneLine: fitOneLine, updateLiveRow: updateLiveRow, refitBars: refitBars,   // 单行适配逻辑测试钩子
      fitChartTools: fitChartTools,                           // 时间窗口+图例子窗口整体缩放
      init: init, renderGroups: renderGroups, updateCollapse: updateCollapse,
      onHeaderClick: onHeaderClick, setValue: setValue,
      S: S, SCHEMA: SCHEMA
    };
  }
  document.addEventListener('DOMContentLoaded', init);
})();
