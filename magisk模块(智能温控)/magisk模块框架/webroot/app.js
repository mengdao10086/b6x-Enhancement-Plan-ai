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
    inp.style.width = (len + 1) + 'ch';
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
    manualExpand: {},     // 本会话手动展开的分组（开关关着也能展开查看，不持久）
    manualCollapse: {},   // 本会话手动折叠的分组（不持久）
    samples: [],
    series: [
      // 图例顺序；默认除 CPU 外全显示；axis 决定走左/右纵轴
      // （实时数值列顺序由 updateLiveRow 独立维护，不受本数组顺序影响）
      { key: 'batt', label: '电池℃', color: '#f44336', on: true, unit: '°C', axis: 'left' },
      { key: 'coldReal', label: '制冷', color: '#4caf50', on: true, unit: '', axis: 'right' },
      { key: 'rpm', label: '风扇rpm', color: '#9c27b0', on: true, unit: 'rpm', axis: 'left' },
      { key: 'cold', label: '冷端℃', color: '#2196f3', on: true, unit: '°C', axis: 'left' },
      { key: 'hot', label: '热端℃', color: '#e91e63', on: true, unit: '°C', axis: 'left' },
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

  // ---------- 折叠逻辑：开关驱动 + 手动展开仅查看/编辑（不改总开关） ----------
  function masterOn(key) { return S.values[key] !== '0'; }

  // 分组是否有可折叠内容（子面板/模式面板/档位表/直接参数）；无折叠内容的分组（如 [4] 自动拉起）
  // 不渲染小三角、不响应组头点击，说明区常显
  function hasCollapsible(g) {
    return !!(g.subKeys || g.modePanels || g.gearTables || (g.keys && g.keys.length));
  }

  function onHeaderClick(g) {
    if (!hasCollapsible(g)) return;   // 无折叠内容（如 [4] 自动拉起），组头点击无动作
    if (g.master) {
      if (masterOn(g.master)) S.manualCollapse[g.id] = !S.manualCollapse[g.id]; // 会话级折叠
      else S.manualExpand[g.id] = !S.manualExpand[g.id]; // 手动展开仅查看，不改总开关
    } else {
      S.manualExpand[g.id] = !S.manualExpand[g.id];
    }
    updateCollapse();
  }

  function updateCollapse() {
    var perfOn = masterOn('PERF_ENABLED');
    // 总开关状态变化：控制模式（master=PERF_ENABLED 的组）展开跟随总开关（幂等）——
    // 打开→确保展开（清 manualCollapse），关闭→确保折叠（清 manualExpand）；
    // 总开关不变时保留手动折叠/展开（manualCollapse/manualExpand 不被清除）
    if (S._prevPerf !== undefined && S._prevPerf !== perfOn) {
      SCHEMA.groups.forEach(function (g) {
        if (g.master === 'PERF_ENABLED') {
          if (perfOn) delete S.manualCollapse[g.id];
          else delete S.manualExpand[g.id];
        }
      });
    }
    S._prevPerf = perfOn;
    SCHEMA.groups.forEach(function (g) {
      if (!hasCollapsible(g)) return;   // 无折叠内容（如 [4] 自动拉起）：说明区常显，不处理折叠
      var head = $('head-' + g.id), chev = $('chev-' + g.id), badge = $('badge-' + g.id);
      var body = $('body-' + g.id);
      if (!head || !body) return;
      var open, off;
      // 模式子面板（[2] 控制模式）：PID / Gear 横滑切换（滑动由 CTRL_MODE 驱动，见 setValue/initModeSlider）
      if (g.master === 'PERF_ENABLED') {
        open = perfOn ? !S.manualCollapse[g.id] : !!S.manualExpand[g.id];
        off = !perfOn;
        body.classList.toggle('collapsed', !open);
        head.classList.toggle('off', off);
        if (badge) badge.classList.toggle('hidden', !off);
        chev.classList.toggle('on', open);
        if (g.modePanels) {   // [2] 控制模式：seg 按钮 active 跟随 CTRL_MODE
          var ctrlMode = S.values['CTRL_MODE'] !== undefined ? S.values['CTRL_MODE'] : '1';
          head.querySelectorAll('.seg-btn').forEach(function (b) {
            b.classList.toggle('active', b.dataset.mode === ctrlMode);
          });
        }
      } else if (g.headerSwitch) {
        // 开关驱动子面板（[0] 日志&调试、[3] sysfs 等）：
        // 开关关 → 折叠整个 body（含子面板），消除空 body 的 padding 残留（"下巴长"）；
        // 可手动展开查看/编辑（不改总开关）
        var swOn = masterOn(g.headerSwitch);
        open = swOn ? !S.manualCollapse[g.id] : !!S.manualExpand[g.id];
        body.classList.toggle('collapsed', !open);
        head.classList.toggle('off', !swOn);
        if (badge) badge.classList.toggle('hidden', swOn);
        chev.classList.toggle('on', open);
      }
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
    var initVal = S.values['CTRL_MODE'] !== undefined ? S.values['CTRL_MODE'] : '1';
    ms.scrollLeft = initVal === '1' ? 0 : ms.clientWidth;   // 初始对齐当前模式（无动画）
    // 滚动停止后才同步 CTRL_MODE：滚动过程实时 setValue 会经 setValue→scrollModePanel 反向触发 scrollTo，
    // 造成点击开关时值被滚过中点前的判定改回（抖动回原位）、惯性滑动被 smooth 接管而卡顿。
    // 同步用 noScroll，只更新值+保存，不触发滚动。
    var syncMode = debounce(function () {
      var p = ms.scrollLeft / Math.max(1, ms.clientWidth);
      var newVal = p > 0.5 ? '0' : '1';
      var cur = S.values['CTRL_MODE'] !== undefined ? S.values['CTRL_MODE'] : '1';
      if (newVal !== cur) setValue('CTRL_MODE', newVal, { noScroll: true });
    }, 120);
    ms.addEventListener('scroll', syncMode, { passive: true });
  }

  // ---------- 控件构建 ----------
  function buildSwitchEl(key) {
    var val = S.values[key] !== undefined ? S.values[key] : '0';
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
    var wrap = document.createElement('div');
    wrap.className = 'ctrl';
    wrap.innerHTML = '<div class="ctrl-label">' + esc(def.label) +
      (String(def.desc).trim() ? '<div class="ctrl-desc">' + esc(def.desc) + '</div>' : '') + '</div>';

    var val = S.values[key] !== undefined ? S.values[key] : def.value || '';

    if (def.type === 'switch') {
      var lab = document.createElement('label');
      lab.className = 'switch';
      var cb = document.createElement('input');
      cb.type = 'checkbox'; cb.dataset.key = key; cb.checked = (val !== '0');
      cb.addEventListener('change', function () { setValue(key, cb.checked ? '1' : '0'); });
      lab.appendChild(cb); lab.appendChild(document.createElement('i'));
      wrap.appendChild(lab);
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

  function buildNumInput(key, val, min, max, step, placeholder) {
    var inp = document.createElement('input');
    inp.type = 'number'; inp.min = min; inp.max = max; inp.step = step;
    inp.dataset.key = key; inp.dataset.multiKey = key;
    if (key.indexOf('::') === -1) inp.dataset.rowField = '1';
    inp.value = val;
    fitInput(inp);
    inp.addEventListener('input', function () {
      var n = parseInt(inp.value, 10);
      if (!isNaN(n)) {
        if (n < min) { inp.value = min; n = min; }
        if (n > max) { inp.value = max; n = max; }
        if (key.indexOf('::') === -1) setValue(key, String(n)); // multi 子输入不直接写 dirty
      }
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
      var hnote = document.createElement('div');
      hnote.className = 'group-note';
      hnote.textContent = SCHEMA.keys[g.headerSwitch].desc;
      body.appendChild(hnote);
    }
    if (g.note) {
      var gnote = document.createElement('div');
      gnote.className = 'group-note';
      gnote.textContent = g.note;
      body.appendChild(gnote);
    }

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
    var n = parseInt(inp.value, 10);
    var f = SCHEMA.gearRow.fields[idx];
    if (!isNaN(n)) {
      if (n < f.min) { inp.value = f.min; n = f.min; }
      if (n > f.max) { inp.value = f.max; n = f.max; }
    }
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
    S.dirty = {}; S.dirtySpecial = false;
    // 保存只重置 dirty，不清空 S.manualExpand/S.manualCollapse：
    // 折叠状态是会话级 UI 状态，保存配置不应重置它，否则切模式触发保存会把手动展开的分组折叠回去
    updateCollapse();
    toast('已保存');
  }

  // ---------- 曲线数据：读 C 每 1s 写的数据文件（无现场采样，减少 exec） ----------
  function parseDataLines(text) {
    // 行格式：epoch,电池(0.1°C),CPU(0.1°C),热端(0.1°C),冷端(0.1°C),实际转速,实际制冷,目标制冷（未就绪为 -1）
    // 温度统一 ÷10 → °C（一位小数）；转速/制冷保持原值
    var out = [];
    var lines = String(text || '').split('\n');
    for (var i = 0; i < lines.length; i++) {
      var p = lines[i].trim().split(',');
      if (p.length < 8) continue;
      function num(j) { var n = parseInt(p[j], 10); return isNaN(n) ? null : n; }
      var e = num(0), batt = num(1), cpu = num(2), hot = num(3), cold = num(4);
      var rpm = num(5), coldReal = num(6), gearCold = num(7);
      out.push({
        t: e,
        batt: batt != null && batt >= 0 ? batt / 10 : null,
        cpu: cpu != null && cpu >= 0 ? cpu / 10 : null,
        hot: hot != null && hot >= 0 ? hot / 10 : null,
        cold: cold != null && cold >= 0 ? cold / 10 : null,
        rpm: rpm != null && rpm >= 0 ? rpm : null,
        coldReal: coldReal != null && coldReal >= 0 ? coldReal : null,
        gearCold: gearCold != null && gearCold >= 0 ? gearCold : null
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
  }

  function updateLiveRow(o) {
    var bits = [];
    if (o.batt != null) bits.push('电池 ' + o.batt.toFixed(1) + '°C');
    if (o.cpu != null) bits.push('CPU ' + o.cpu.toFixed(1) + '°C');
    if (o.coldReal != null) bits.push('制冷 ' + o.coldReal);
    if (o.rpm != null) bits.push('风扇 ' + o.rpm + 'rpm');
    if (o.cold != null) bits.push('冷端 ' + o.cold.toFixed(1) + '°C');
    if (o.hot != null) bits.push('热端 ' + o.hot.toFixed(1) + '°C');
    $('liveRow').textContent = bits.length ? bits.join(' · ') : '等待数据…';
  }

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
    var data = S.samples.slice(-(S.window || 240));   // 只画最近 window 秒
    var leftSeries = S.series.filter(function (s) { return s.on && s.axis === 'left'; });
    var rightSeries = S.series.filter(function (s) { return s.on && s.axis === 'right'; });
    if (data.length < 2 || (!leftSeries.length && !rightSeries.length)) {
      ctx.fillStyle = '#888'; ctx.font = '12px system-ui';
      ctx.fillText(data.length < 2 ? '采样中…' : '无曲线', padL + W / 2 - 24, padT + H / 2);
      return;
    }
    // 取值：左轴 = 温度(℃) 或 风扇转速÷100；右轴 = 制冷强度
    function leftV(s, d) { return s.key === 'rpm' ? (d.rpm == null ? null : d.rpm / 100) : d[s.key]; }
    function rightV(s, d) { return d[s.key]; }
    // 计算一轴的范围（上下各留 10% 余量）
    function range(series, getV) {
      var mn = Infinity, mx = -Infinity;
      series.forEach(function (s) {
        data.forEach(function (d) { var v = getV(s, d); if (v == null) return; if (v < mn) mn = v; if (v > mx) mx = v; });
      });
      if (!isFinite(mn) || !isFinite(mx)) return null;
      var sp = (mx - mn) || 1;
      return { min: mn - sp * 0.1, max: mx + sp * 0.1 };
    }
    var L = range(leftSeries, leftV), R = range(rightSeries, rightV);
    function yOf(axis, v) { return padT + H * (1 - (v - axis.min) / (axis.max - axis.min)); }
    ctx.font = '10px system-ui'; ctx.fillStyle = '#888';
    // 左轴刻度 + 网格
    if (L) {
      ctx.textAlign = 'right';
      for (var i = 0; i <= 4; i++) {
        var val = L.min + (L.max - L.min) * i / 4;
        var y = yOf(L, val);
        ctx.fillText(val.toFixed(1), padL - 4, y + 3);
        ctx.strokeStyle = 'rgba(128,128,128,0.15)';
        ctx.beginPath(); ctx.moveTo(padL, y); ctx.lineTo(padL + W, y); ctx.stroke();
      }
      // 轴标题靠左绘制：允许向右突出到曲线区内（避免标题过长挤压曲线横向空间）
      ctx.textAlign = 'left';
      ctx.fillText('℃/百rpm', 2, padT - 2);
    }
    // 右轴刻度
    if (R) {
      ctx.textAlign = 'left';
      for (var j = 0; j <= 4; j++) {
        var rval = R.min + (R.max - R.min) * j / 4;
        var ry = yOf(R, rval);
        ctx.fillText(rval.toFixed(0), padL + W + 4, ry + 3);
      }
      ctx.fillText('cold', padL + W + 4, padT - 2);
      ctx.textAlign = 'right';
    }
    // 画线
    function plot(series, getV, axis) {
      series.forEach(function (s) {
        ctx.strokeStyle = s.color; ctx.lineWidth = 1.6;
        ctx.beginPath();
        var started = false;
        data.forEach(function (d) {
          var v = getV(s, d);
          if (v == null) return;
          var x = padL + W * (data.length === 1 ? 0.5 : (data.indexOf(d) / (data.length - 1)));
          var y = yOf(axis, v);
          if (started) ctx.lineTo(x, y); else { ctx.moveTo(x, y); started = true; }
        });
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
    function goTo(name) {
      slider.scrollTo({ left: name === 'log' ? slider.clientWidth : 0, behavior: 'smooth' });
      seg.querySelectorAll('.seg-btn').forEach(function (b) { b.classList.toggle('active', b.dataset.panel === name); });
    }
    seg.querySelectorAll('.seg-btn').forEach(function (b) {
      b.addEventListener('click', function () { goTo(b.dataset.panel); });
    });
    // 滚动停止后才按最终位置同步高亮：滚动过程实时判定会在平滑滚动刚起步时把高亮改回旧面板，
    // 造成点击切换时先高亮目标→又闪回旧面板→滚过中点再高亮目标（闪烁）
    var syncSeg = debounce(function () {
      var p = slider.scrollLeft / Math.max(1, slider.clientWidth);
      var name = p > 0.5 ? 'log' : 'chart';
      seg.querySelectorAll('.seg-btn').forEach(function (b) { b.classList.toggle('active', b.dataset.panel === name); });
    }, 120);
    slider.addEventListener('scroll', syncSeg, { passive: true });
    $('pinBtn').addEventListener('click', function () {
      var pinned = document.body.classList.toggle('pin-fixed');
      document.body.classList.toggle('pin-scroll', !pinned);   // 互斥：移除另一类，避免 CSS 冲突锁死
      $('pinBtn').classList.toggle('active', pinned);
    });
  }

  // ---------- 曲线控件 ----------
  function setChartWindow(v) {
    S.window = parseInt(v, 10) || 240;
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
    var w = parseInt(storeGet('b6xChartWindow') || '240', 10);
    if (SCHEMA.chartWindowOptions.indexOf(w) === -1) w = 240;   // 旧自定义值回落默认挡位
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
    initChartUI();
    initLogUI();
    initModeSlider();
    updateCollapse();
    if (errText) reportError(errText);
    else if (!Bridge.available) reportError('未检测到 WebUI 桥接 — 请在 KernelSU / KSU-Next / APatch 管理器内打开本模块 WebUI');
    else uiLog('已加载 · 桥接=' + (Bridge.kind || '?'));   // 合并进 UI 诊断日志（默认收起）
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
      init: init, renderGroups: renderGroups, updateCollapse: updateCollapse,
      onHeaderClick: onHeaderClick, setValue: setValue,
      S: S, SCHEMA: SCHEMA
    };
  }
  document.addEventListener('DOMContentLoaded', init);
})();
