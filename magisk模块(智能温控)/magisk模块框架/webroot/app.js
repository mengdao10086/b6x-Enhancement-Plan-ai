/* ============================================================
 * B6X 智能温控 WebUI — 主逻辑
 * 仅 KSU 系（KernelSU / KSU-Next / APatch）原生 WebUI
 * ============================================================ */
(function () {
  'use strict';

  // 全局错误捕获：任何 JS 异常都显示到横幅，便于真机诊断（必须先于可能崩溃的初始化）
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
    var ph = inp.placeholder || '';
    var len = Math.max(val.length, ph.length, 1);
    // 修正：ch 单位只计内容宽，输入框 box-sizing:border-box 另有左右 padding(7px×2)+border(1px×2)=16px，
    // 长数字（日志上限/缩放系数等）会被截掉末位。补上该偏移。
    inp.style.width = 'calc(' + (len + 1) + 'ch + 16px)';
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
        // 实测同步形态只返回"最后一行"：必须确认第一行 __B6XA__ 是否出现，否则误判为完整多行
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
        // 剥离行内注释（如 LOG_MAX=7936   # 字节），与 C 解析器行为一致（atoi/sscanf 停在非数字处）
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
    if (key === 'PERF_ENABLED' || key === 'DEBUG_ENABLED' || key === 'CTRL_MODE') updateCollapse();
    if (key === 'CTRL_MODE' && !opts.noScroll) scrollModePanel(val);   // 控制模式：横滑到对应面板（滚动同步时 noScroll 不触发）
    scheduleSave();
  }

  // ---------- 折叠逻辑：固定默认收起 + 组头点击手动展开（不随开关状态） ----------
  function masterOn(key) { return S.values[key] !== '0'; }
  function ctrlMode() { return S.values['CTRL_MODE'] !== undefined ? S.values['CTRL_MODE'] : '1'; }

  // 分组是否有可折叠内容（子面板/模式面板/档位表/直接参数）；无折叠内容的分组
  // 不渲染小三角、不响应组头点击，说明区常显
  function hasCollapsible(g) {
    return !!(g.subKeys || g.modePanels || g.gearTables || (g.keys && g.keys.length));
  }

  function onHeaderClick(g) {
    if (!hasCollapsible(g)) return;   // 无折叠内容，组头点击无动作
    // 所有大类固定默认收起、不随开关状态展开；组头点击仅做会话级手动展开/收起（不持久化）
    S.manualExpand[g.id] = !S.manualExpand[g.id];
    updateCollapse();
  }

  function updateCollapse() {
    SCHEMA.groups.forEach(function (g) {
      if (!hasCollapsible(g)) return;   // 无折叠内容：说明区常显，不处理折叠
      var head = $('head-' + g.id), chev = $('chev-' + g.id), badge = $('badge-' + g.id);
      var body = $('body-' + g.id);
      if (!head || !body) return;
      // 全部大类固定默认收起、不随开关状态展开；仅组头点击做会话级手动展开/收起
      var open = !!S.manualExpand[g.id];
      body.classList.toggle('collapsed', !open);
      chev.classList.toggle('on', open);
      // 模式子面板（[2] 控制模式）：seg 按钮 active 跟随 CTRL_MODE；展开时对齐横滑面板
      // （收起期间 scrollTo 对 display:none 元素无效，位置可能失准，需在展开时重对齐）
      if (g.modePanels) {
        var cm = ctrlMode();
        head.querySelectorAll('.seg-btn').forEach(function (b) {
          b.classList.toggle('active', b.dataset.mode === cm);
        });
        if (open) {
          var ms = $('mode-slider-' + g.id);
          if (ms) ms.scrollLeft = cm === '1' ? 0 : ms.clientWidth;
        }
      }
      // 组头暗色/徽标仍反映开关实际状态（仅视觉提示，不影响折叠）
      var swKey = g.master || g.headerSwitch;
      var swOn = swKey ? masterOn(swKey) : true;
      head.classList.toggle('off', !swOn);
      if (badge) badge.classList.toggle('hidden', swOn);
    });
  }

  // ---------- 控制模式横滑（PID / Gear 两侧，类似顶部曲线/日志） ----------
  function scrollModePanel(modeVal) {
    var ms = $('mode-slider-g4');
    if (!ms) return;
    ms.scrollTo({ left: modeVal === '1' ? 0 : ms.clientWidth, behavior: 'smooth' });
  }

  function initModeSlider() {
    var ms = $('mode-slider-g4');
    if (!ms) return;
    var initVal = ctrlMode();
    ms.scrollLeft = initVal === '1' ? 0 : ms.clientWidth;   // 初始对齐当前模式（无动画）
    // 滚动停止后才同步 CTRL_MODE：滚动过程实时 setValue 会经 setValue→scrollModePanel 反向触发 scrollTo，
    // 造成点击开关时值被滚过中点前的判定改回（抖动回原位）、惯性滑动被 smooth 接管而卡顿。
    // 同步用 noScroll，只更新值+保存，不触发滚动。
    var syncMode = debounce(function () {
      var p = ms.scrollLeft / Math.max(1, ms.clientWidth);
      var newVal = p > 0.5 ? '0' : '1';
      var cur = ctrlMode();
      if (newVal !== cur) setValue('CTRL_MODE', newVal, { noScroll: true });
    }, 120);
    ms.addEventListener('scroll', syncMode, { passive: true });
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
        row.appendChild(buildNumInput(key + '::' + i, parts[i] || '0', f.min, f.max, 1, f.label));
      });
      row.addEventListener('input', function () {
        var out = [];
        def.fields.forEach(function (f, i) {
          var inp = row.querySelector('[data-multi-key="' + key + '::' + i + '"]');
          out.push(inp ? inp.value : '0');
        });
        setValue(key, out.join(' '));
      });
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
      if (g.modePanels) {
        // [2] 控制模式：PID / Gear 分段按钮（类似顶部实时曲线/日志），点击切换模式并横滑面板
        var seg = document.createElement('div');
        seg.className = 'seg head-switch';
        g.modePanels.forEach(function (p) {
          var btn = document.createElement('button');
          btn.type = 'button';
          btn.className = 'seg-btn';
          btn.dataset.mode = p.when;
          btn.textContent = (p.when === '1') ? 'PID' : 'Gear';
          btn.addEventListener('click', function (e) {
            e.stopPropagation();
            setValue('CTRL_MODE', p.when);
          });
          seg.appendChild(btn);
        });
        head.appendChild(seg);
      } else {
        var swEl = buildSwitchEl(g.headerSwitch);
        swEl.classList.add('head-switch');
        swEl.addEventListener('click', function (e) { e.stopPropagation(); });
        head.appendChild(swEl);
      }
    }
    head.addEventListener('click', function () { onHeaderClick(g); });
    sec.appendChild(head);

    var body = document.createElement('div');
    body.id = 'body-' + g.id;
    body.className = 'group-body' + (hasCollapsible(g) ? '' : ' compact');
    sec.appendChild(body);

    // 头部开关的说明：作为分组首行说明（原"独立条目"的说明迁到这里）
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

    // 档位表
    if (g.gearTables) appendGearBoxes(body, g.gearTables);

    // 模式子面板（[4] 控制模式）：PID / Gear 两侧横滑切换（类似顶部实时曲线/日志）
    if (g.modePanels) {
      var slider = document.createElement('div');
      slider.className = 'mode-slider';
      slider.id = 'mode-slider-' + g.id;
      g.modePanels.forEach(function (p) {
        var sub = document.createElement('div');
        sub.id = 'sub-' + g.id + '-' + p.when;
        sub.className = 'group-body sub-panel mode-panel';
        if (p.title) {
          var pt = document.createElement('div');
          pt.className = 'sub-panel-title';
          pt.textContent = p.title;
          sub.appendChild(pt);
        }
        p.keys.forEach(function (k) {
          if (SCHEMA.keys[k]) sub.appendChild(buildControl(k));
        });
        if (p.gearTables) appendGearBoxes(sub, p.gearTables);
        slider.appendChild(sub);
      });
      body.appendChild(slider);
    }

    return sec;
  }

  // 档位表容器（普通分组或模式子面板共用）
  function appendGearBoxes(container, gearTables) {
    gearTables.forEach(function (family) {
      var box = document.createElement('div');
      box.className = 'gear-box';
      box.innerHTML = '<div class="gear-title">' + (family === 'GEAR_B6X_' ? 'B6X 档位表' : 'B7X 档位表') + '</div>';
      var table = document.createElement('div');
      table.id = 'gearTable-' + family.replace(/_/g, '-');
      table.className = 'gear-table';
      box.appendChild(table);
      var addBtn = document.createElement('button');
      addBtn.className = 'btn-add';
      addBtn.textContent = '+ 添加档位';
      addBtn.addEventListener('click', function () { addGearRow(family); });
      box.appendChild(addBtn);
      container.appendChild(box);
      renderGearTable(table, family);
    });
  }

  // ---------- 档位表 ----------
  function renderGearTable(container, family) {
    var rows = S.items.filter(function (it) {
      return it.type === 'kv' && it.key.indexOf(family) === 0;
    }).sort(function (a, b) {
      return parseInt(a.key.slice(family.length), 10) - parseInt(b.key.slice(family.length), 10);
    });
    container.innerHTML = '';
    var headRow = document.createElement('div');
    headRow.className = 'gear-row gear-head';
    headRow.innerHTML = '<span>档</span>' + SCHEMA.gearRow.fields.map(function (f) {
      return '<span>' + f.label + '</span>';
    }).join('') + '<span></span>';
    container.appendChild(headRow);

    rows.forEach(function (it) {
      var n = it.key.slice(family.length);
      var parts = String(it.value).split(',');
      var row = document.createElement('div');
      row.className = 'gear-row';
      row.dataset.gearKey = it.key;   // 供长按排序读取顺序
      var num = document.createElement('span');
      num.className = 'gear-n';
      num.textContent = n;
      row.appendChild(num);
      var ref = { key: it.key, parts: parts, row: row };
      SCHEMA.gearRow.fields.forEach(function (f, i) {
        var inp = document.createElement('input');
        inp.type = 'number'; inp.min = f.min; inp.max = f.max;
        inp.value = parts[i] !== undefined ? parts[i] : '';
        inp.dataset.rowField = '1';
        inp.addEventListener('input', function () { onGearFieldInput(ref, i, inp); });
        row.appendChild(inp);
      });
      var del = document.createElement('button');
      del.className = 'btn-del';
      del.textContent = '×';
      del.addEventListener('click', function () { removeGearRow(it.key); });
      row.appendChild(del);
      container.appendChild(row);
    });
    initGearDrag(container, family);
  }

  // 长按拖动排序：长按一行进入拖动 → 上下移动重排 → 松手重编号并自动保存
  function initGearDrag(container, family) {
    container.querySelectorAll('.gear-row:not(.gear-head)').forEach(function (row) {
      var timer = null, dragging = false, startY = 0;
      row.addEventListener('touchstart', function (e) {
        if (e.target.tagName === 'INPUT') return;   // 不拦截输入框编辑
        startY = e.touches[0].clientY;
        timer = setTimeout(function () {
          dragging = true;
          row.classList.add('dragging');
          container.classList.add('dragmode');
        }, 450);
      }, { passive: true });
      row.addEventListener('touchmove', function (e) {
        if (!dragging) {
          if (Math.abs(e.touches[0].clientY - startY) > 10) clearTimeout(timer);
          return;
        }
        e.preventDefault();
        var y = e.touches[0].clientY;
        var rows = container.querySelectorAll('.gear-row:not(.gear-head)');
        for (var i = 0; i < rows.length; i++) {
          if (rows[i] === row) continue;
          var r = rows[i].getBoundingClientRect();
          if (y < r.top + r.height / 2) { container.insertBefore(row, rows[i]); return; }
        }
        container.appendChild(row);
      }, { passive: false });
      function endDrag() {
        clearTimeout(timer);
        if (dragging) {
          dragging = false;
          row.classList.remove('dragging');
          container.classList.remove('dragmode');
          commitGearOrder(container, family);
        }
      }
      row.addEventListener('touchend', endDrag);
      row.addEventListener('touchcancel', endDrag);
    });
  }

  // 按 DOM 顺序重排该族档位行，重编号 N=1..count，并自动保存
  function commitGearOrder(container, family) {
    var keys = [];
    container.querySelectorAll('.gear-row[data-gear-key]').forEach(function (r) {
      keys.push(r.dataset.gearKey);
    });
    var byKey = {};
    S.items.forEach(function (it) {
      if (it.type === 'kv' && it.key.indexOf(family) === 0) byKey[it.key] = it;
    });
    var oldKeys = Object.keys(byKey);
    var newItems = keys.map(function (k, i) {
      var it = byKey[k];
      var nk = family + (i + 1);
      if (S.values[nk] === undefined && S.values[k] !== undefined) S.values[nk] = S.values[k];
      it.key = nk;
      it.raw = nk + '=' + it.value;
      return it;
    });
    oldKeys.forEach(function (k) {
      if (S.values[k] !== undefined && S.items.indexOf(byKey[k]) === -1) delete S.values[k];
    });
    S.items = S.items.filter(function (it) { return !(it.type === 'kv' && it.key.indexOf(family) === 0); }).concat(newItems);
    renderGearTable(container, family);
    scheduleSave();
  }

  function onGearFieldInput(ref, idx, inp) {
    var f = SCHEMA.gearRow.fields[idx];
    clampNumInput(inp, f.min, f.max);
    ref.parts[idx] = inp.value;
    S.values[ref.key] = ref.parts.join(',');
    S.dirty[ref.key] = true;
    scheduleSave();
  }

  function addGearRow(family) {
    var existing = S.items.filter(function (it) {
      return it.type === 'kv' && it.key.indexOf(family) === 0;
    }).map(function (it) { return parseInt(it.key.slice(family.length), 10); });
    var n = 1;
    while (existing.indexOf(n) !== -1 && n <= SCHEMA.gearRow.maxN) n++;
    if (n > SCHEMA.gearRow.maxN) { toast('已达最大 ' + SCHEMA.gearRow.maxN + ' 档'); return; }
    var key = family + n;
    var item = { type: 'kv', key: key, value: SCHEMA.gearRow.defaultValue, raw: key + '=' + SCHEMA.gearRow.defaultValue };
    // 插入到同族最后一行之后（或文件末尾）
    var idx = -1;
    S.items.forEach(function (it, i) {
      if (it.type === 'kv' && it.key.indexOf(family) === 0) idx = i;
    });
    S.items.splice(idx + 1, 0, item);
    S.values[key] = item.value;
    S.dirtySpecial = true;
    renderGearTable($('gearTable-' + family.replace(/_/g, '-')), family);
    scheduleSave();
  }

  function removeGearRow(key) {
    var idx = S.items.findIndex(function (it) { return it.type === 'kv' && it.key === key; });
    if (idx >= 0) S.items.splice(idx, 1);
    delete S.values[key];
    delete S.dirty[key];
    S.dirtySpecial = true;
    var family = key.slice(0, key.lastIndexOf('_') + 1);
    renderGearTable($('gearTable-' + family.replace(/_/g, '-')), family);
    scheduleSave();
  }

  // ---------- 改即存（防抖自动写配置） ----------
  var saveTimer = null;
  function scheduleSave() {
    clearTimeout(saveTimer);
    saveTimer = setTimeout(save, 600);
  }

  function b64(str) {
    // 兼容中文注释（实际配置为 ASCII，安全起见走 UTF-8）
    return btoa(unescape(encodeURIComponent(str)));
  }

  async function save() {
    if (!Bridge.available) { toast('无桥接，无法保存', 'err'); return; }
    if (!Object.keys(S.dirty).length && !S.dirtySpecial) return;
    var text = rebuildConfig();
    var r = await Bridge.exec('echo ' + b64(text) + ' | base64 -d > ' + CFG);
    if (r.errno !== 0) { toast('保存失败: ' + (r.stderr || 'errno ' + r.errno), 'err'); return; }
    // 修复：把刚写入的内容同步回 S.items 快照，否则下次保存会用页面加载时的旧值覆盖其他项
    // （例：先存 DEBUG_PID=1，再改 DEBUG_ENABLED 保存时会把 DEBUG_PID 冲回页面加载时的 0）
    S.items = parseConfig(text);
    S.values = buildValues(S.items);
    S.dirty = {}; S.dirtySpecial = false;
    // 保存只重置 dirty，不清空 S.manualExpand：
    // 折叠状态是会话级 UI 状态，保存配置不应重置它，否则切模式触发保存会把手动展开的分组折叠回去
    updateCollapse();
    toast('已保存');
  }

  // ---------- 曲线数据：读 C 每 1s 写的数据文件（无现场采样，减少 exec） ----------
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
        rpm: raw(num(5)), coldReal: raw(num(6)), gearCold: raw(num(7))
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
  // 测量一律绕过 scrollWidth：部分 WebView 对 overflow:hidden 的容器不报告溢出内容，
  // 会导致字体不缩、尾部被裁。文本宽度优先用 canvas.measureText（最稳定），canvas
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
    // 探针不可用 → canvas 兜底（数字按等比宽测量，比 tabular 窄，加 5% 保险避免低估）
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
  // 裁切在父级 .chart-tools（overflow:hidden），与 transform 不同坐标系 → 缩放后内容必然落在可用区内，
  // 规避 WebView 对子元素缩放（calc/zoom）兼容性问题
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

  // 制冷轴辅助：tempctrl.c COLD_MIN=1（轴下限从 1 开始）；COLD_MAP 第一值 = 制冷→风扇映射
  // 起始强度。总开关（PERF_ENABLED=1）开启时取配置实际值，否则回退默认 40。轴最低显示范围 = [1, 起始强度]
  function coldMapStart() {
    if (S.values['PERF_ENABLED'] !== '1') return 40;   // 总开关未开启 → 默认 40
    var cm = S.values['COLD_MAP'];
    if (cm == null) return 40;
    var n = parseInt(String(cm).split(/[\s,]+/)[0], 10);
    return isFinite(n) && n > 0 ? n : 40;
  }
  var drawAxisDiag = false;   // 制冷轴范围一次性诊断

  // ---------- 曲线（双纵轴：左 ℃/rpm，右 cold） ----------
  function drawChart() {
    var cv = $('chart'), dpr = window.devicePixelRatio || 1;
    var cw = cv.clientWidth, ch = cv.clientHeight;
    if (!cw || !ch) return;
    cv.width = cw * dpr; cv.height = ch * dpr;
    var ctx = cv.getContext('2d');
    ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
    ctx.clearRect(0, 0, cw, ch);
    var padL = 36, padR = 36, padT = 16, padB = 4;
    var W = cw - padL - padR, H = ch - padT - padB;
    var data = S.samples.slice(-(S.window || 360));   // 只画最近 window 秒
    var leftSeries = S.series.filter(function (s) { return s.on && s.axis === 'left'; });
    var rightSeries = S.series.filter(function (s) { return s.on && s.axis === 'right'; });

    // —— 断联感知布局 ——
    // C 端断联时不写曲线数据行（重连才续写），曲线数据里断联表现为相邻采样时间戳跳变。
    // 相邻采样时间差 > 5s 视为一次断联：断开曲线，并在该处插入固定 5s 宽的空白，
    // 直观标记"这里断开过"（空白宽度 = 正常绘制 5s 的宽度）。
    var GAP_SEC = 5;
    var gap = new Array(data.length);
    var totalGap = 0, di;
    for (di = 0; di < data.length; di++) {
      if (di > 0 && data[di].t - data[di - 1].t > GAP_SEC) totalGap += GAP_SEC;
      gap[di] = totalGap;
    }
    var totalUnits = (data.length > 1 ? data.length - 1 : 0) + totalGap;

    if (data.length < 2 || (!leftSeries.length && !rightSeries.length)) {
      ctx.fillStyle = '#888'; ctx.font = '12px system-ui';
      ctx.fillText(data.length < 2 ? '采样中…' : '无曲线', padL + W / 2 - 24, padT + H / 2);
      return;
    }
    // 取值：左轴 = 温度(℃) 或 风扇转速÷100；右轴 = 制冷强度
    function leftV(s, d) { return s.key === 'rpm' ? (d.rpm == null ? null : d.rpm / 100) : d[s.key]; }
    function rightV(s, d) { return d[s.key]; }
    // 计算一轴的范围（上下各留 5% 余量）
    function range(series, getV) {
      var mn = Infinity, mx = -Infinity;
      series.forEach(function (s) {
        data.forEach(function (d) { var v = getV(s, d); if (v == null) return; if (v < mn) mn = v; if (v > mx) mx = v; });
      });
      if (!isFinite(mn) || !isFinite(mx)) return null;
      var sp = (mx - mn) || 1;
      return { min: mn - sp * 0.05, max: mx + sp * 0.05 };
    }
    var L = range(leftSeries, leftV), R = range(rightSeries, rightV);
    // 制冷强度轴（右轴）：从 COLD_MIN=1 开始，最低显示范围覆盖到制冷→风扇映射起始强度（COLD_MAP 第一值）
    if (R) {
      R.min = 1;
      var coldFanStart = coldMapStart();
      if (R.max < coldFanStart) R.max = coldFanStart;
      if (!drawAxisDiag) { drawAxisDiag = true; uiLog('[轴] 制冷轴: ' + R.min + '~' + R.max + '（起始强度=' + coldFanStart + '）'); }
    }
    // 修复：单轴全无效值时该轴 range() 返回 null（此前守卫只挡双轴都空），
    // 直接 return 会让 L/R 为 null 的轴在 plot 的 yOf 里解引用崩溃。
    // 双轴都不可画（全 null）则无曲线可画；仅一轴有效时仍画该轴。
    if (!L && !R) return;
    function yOf(axis, v) { return padT + H * (1 - (v - axis.min) / (axis.max - axis.min)); }
    ctx.font = '10px system-ui'; ctx.fillStyle = '#888';
    // 刻度数量随高度自适应：越高刻度越多（信息密度提升），越矮越少（避免拥挤）
    function tickCount(h) {
      var n = Math.round((h - 30) / 70);   // 每 70px 一条刻度
      if (n < 3) n = 3;                     // 至少 3 条（2 段）
      if (n > 10) n = 10;                   // 至多 10 条
      return n;
    }
    var nTick = tickCount(H);
    // 左轴刻度 + 网格
    if (L) {
      ctx.textAlign = 'right';
      for (var i = 0; i <= nTick; i++) {
        var val = L.min + (L.max - L.min) * i / nTick;
        var y = yOf(L, val);
        ctx.fillText(val.toFixed(1), padL - 4, y + 3);
        ctx.strokeStyle = 'rgba(128,128,128,0.15)';
        ctx.beginPath(); ctx.moveTo(padL, y); ctx.lineTo(padL + W, y); ctx.stroke();
      }
      // 轴标题靠左绘制：允许向右突出到曲线区内（避免标题过长挤压曲线横向空间）
      ctx.textAlign = 'left';
      ctx.fillText('℃/百rpm', 2, padT - 7);
    }
    // 右轴刻度
    if (R) {
      ctx.textAlign = 'left';
      for (var j = 0; j <= nTick; j++) {
        var rval = R.min + (R.max - R.min) * j / nTick;
        var ry = yOf(R, rval);
        ctx.fillText(rval.toFixed(0), padL + W + 4, ry + 3);
      }
      ctx.fillText('cold', padL + W + 4, padT - 7);
      ctx.textAlign = 'right';
    }
    // 画线
    function plot(series, getV, axis) {
      if (!axis) return;   // 该轴范围无效（全 null），跳过该轴绘制
      series.forEach(function (s) {
        ctx.strokeStyle = s.color; ctx.lineWidth = 1.6;
        ctx.beginPath();
        var started = false;
        for (var di = 0; di < data.length; di++) {
          if (di > 0 && data[di].t - data[di - 1].t > GAP_SEC) started = false;   // 断联处断开，空白不连桥
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
    // 滚动停止后才按最终位置同步高亮：滚动过程实时判定会在平滑滚动刚起步时把高亮改回旧面板，
    // 造成点击切换时先高亮目标→又闪回旧面板→滚过中点再高亮目标（闪烁）
    var syncSeg = debounce(function () {
      var p = slider.scrollLeft / Math.max(1, slider.clientWidth);
      setSegActive(p > 0.5 ? 'log' : 'chart');
    }, 120);
    slider.addEventListener('scroll', syncSeg, { passive: true });
    // 图钉：图标蓝底状态完全由 body 的 pin-fixed 类驱动（初始/点击后都走 syncPinState），
    // 不依赖 classList.toggle 返回值，避免个别 WebView 下图标常蓝。
    $('pinBtn').addEventListener('click', function () {
      document.body.classList.toggle('pin-fixed');
      var pinned = document.body.classList.contains('pin-fixed');
      document.body.classList.toggle('pin-scroll', !pinned);   // 互斥：移除另一类，避免 CSS 冲突锁死
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
    if (SCHEMA.chartWindowOptions.indexOf(w) === -1) w = 360;   // 旧自定义值回落默认挡位
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
    // 窗口尺寸变化、字体异步加载完成、WebView 布局变化时重新适配，避免裁切
    window.addEventListener('resize', refitBars);
    if (document.fonts && document.fonts.ready) document.fonts.ready.then(refitBars);
    if (window.ResizeObserver) {
      var ro = new ResizeObserver(refitBars);
      ro.observe($('ctInner'));
      ro.observe($('liveRow'));
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

  // ---------- 模式面板：自适应高度横滑（容器高度跟随激活面板，消除空区） ----------
  function syncModeHeight() {
    var ms = $('mode-slider-g4');
    if (!ms) return;
    var p = ms.scrollLeft / Math.max(1, ms.clientWidth);
    var idx = p > 0.5 ? 1 : 0;
    var panels = ms.querySelectorAll('.mode-panel');
    if (!panels[idx]) return;
    // 面板底相对容器顶的距离（含 margin），设为容器高度则面板完整可见
    var h = panels[idx].getBoundingClientRect().bottom - ms.getBoundingClientRect().top;
    if (h > 0) ms.style.height = h + 'px';   // >0 防收起时误设 0
  }

  function initModeHeight() {
    var ms = $('mode-slider-g4');
    if (!ms) return;
    var settle = debounce(syncModeHeight, 80);
    ms.addEventListener('scroll', settle, { passive: true });
    if (window.ResizeObserver) {
      // 面板内容（档位表增删等）变化时联动容器高度
      var ro = new ResizeObserver(syncModeHeight);
      ms.querySelectorAll('.mode-panel').forEach(function (p) { ro.observe(p); });
    }
    syncModeHeight();
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
          (g.modePanels || []).forEach(function (p) { gk = gk.concat(p.keys || []); });
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
    initModeSlider();
    initModeHeight();
    initTopHeight();
    updateCollapse();
    if (errText) reportError(errText);
    else if (!Bridge.available) reportError('未检测到 WebUI 桥接 — 请在 KernelSU / KSU-Next / APatch 管理器内打开本模块 WebUI');
    else uiLog('已加载 · 桥接=' + (Bridge.kind || '?'));   // 合并进 UI 诊断日志（默认收起）
    uiLog('[fit] 诊断版已加载（下方应有 [fit] chartTools/liveRow 适配行与 [轴] 制冷轴行；若无 = 仍是旧版 app.js 缓存，请强刷 WebUI）');
    refreshCurve();                    // 曲线：读 C 数据文件，每秒一次
    setInterval(refreshCurve, 1000);
    refreshLog();                      // 日志：5 秒刷新一次（增量缓存，减少 exec）
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
      fitOneLine: fitOneLine, updateLiveRow: updateLiveRow, refitBars: refitBars,   // 单行适配逻辑测试钩子
      fitChartTools: fitChartTools,                           // 时间窗口+图例子窗口整体缩放
      coldMapStart: coldMapStart,                             // 制冷→风扇映射起始强度
      init: init, renderGroups: renderGroups, updateCollapse: updateCollapse,
      onHeaderClick: onHeaderClick, setValue: setValue,
      S: S, SCHEMA: SCHEMA
    };
  }
  document.addEventListener('DOMContentLoaded', init);
})();
