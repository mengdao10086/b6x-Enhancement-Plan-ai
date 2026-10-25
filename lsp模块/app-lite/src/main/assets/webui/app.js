/* 骨架占位：只证明 defs()/snapshot() 能取到数据。真前端由 L2b 实现。 */
(function () {
    'use strict';

    function call(name) {
        try {
            return window.WaspBridge[name]();
        } catch (e) {
            return JSON.stringify({ok: false, error: String(e)});
        }
    }

    function show(id, value) {
        var node = document.getElementById(id);
        if (node) {
            node.textContent = value;
        }
    }

    function preview(raw, limit) {
        return raw.length > limit ? raw.slice(0, limit) + '\n…（已截断，共 ' + raw.length + ' 字符）' : raw;
    }

    function init() {
        var defsRaw = call('defs');
        try {
            var defs = JSON.parse(defsRaw);
            if (defs && defs.ok === false) {
                show('defs-meta', '读取失败：' + (defs.error || '未知错误'));
            } else if (defs && defs.keys) {
                show('defs-meta', 'params.json：' + defs.keys.length + ' 个键 / '
                    + (defs.groups ? defs.groups.length : 0) + ' 个分组');
            } else {
                show('defs-meta', '返回内容不是预期的 params.json');
            }
        } catch (e) {
            show('defs-meta', '解析失败：' + String(e));
        }
        show('defs-out', preview(defsRaw, 4000));
        show('snap-out', preview(call('snapshot'), 8000));
    }

    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }
})();
