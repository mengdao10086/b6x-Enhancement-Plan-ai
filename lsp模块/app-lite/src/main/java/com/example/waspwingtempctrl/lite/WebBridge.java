package com.example.waspwingtempctrl.lite;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.example.waspwingtempctrl.AppFiles;
import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.Deployer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * WebView 与 core 之间的最小桥。契约（方法名 / 入参 / 返回格式）见
 * {@code .claude/subagent方案存放区/webui极简版-方案.md} 的「WebBridge 契约」一节。
 *
 * <p><b>线程</b>：{@link JavascriptInterface} 方法由 WebView 的 JavaBridge 线程调用，
 * <b>不是主线程</b>，因此这里的阻塞 I/O / su 调用不需要再切线程；前端也不要并发调用
 * 部署类方法（桥内按调用顺序串行进入）。
 *
 * <p>所有方法返回 JSON 字符串，失败统一为 {@code {"ok":false,"error":"…"}}。
 * {@link #defs()} 例外：成功时直接返回 params.json 原始串（本身就是 JSON）。
 */
public final class WebBridge {

    /** 前端通过 {@code window.WaspBridge} 访问。 */
    public static final String JS_NAME = "WaspBridge";

    /** 日志/曲线 tail 上限：占位页够用，避免一次把大文件搬进 JS。 */
    private static final int TAIL_BYTES = 65536;
    private static final String PARAMS_ASSET = "params.json";

    private final Context appContext;
    /** defs 原始串：首次调用读一次，之后直接复用（不随每次调用 open）。 */
    private String defsCache;

    WebBridge(Context context) {
        this.appContext = context.getApplicationContext();
    }

    // ==================== 只读 ====================

    /** params.json 原始串（唯一一份，来自 core 资产）。 */
    @JavascriptInterface
    public String defs() {
        String cached = defsCache;
        if (cached != null) {
            return cached;
        }
        synchronized (this) {
            if (defsCache == null) {
                try {
                    defsCache = readAsset(appContext, PARAMS_ASSET);
                } catch (IOException e) {
                    return error("读取 assets/" + PARAMS_ASSET + " 失败：" + e.getMessage());
                }
            }
            return defsCache;
        }
    }

    /**
     * 当前配置：{@code {"ok":true,"exists":…,"mtime":…,"values":{KEY:"字面量"},
     * "unknown":[…],"removable":[…],"notes":[…]}}。多值键按配置文件原文（空格分隔）。
     */
    @JavascriptInterface
    public String snapshot() {
        try {
            ConfigStore store = ConfigStore.get(appContext);
            ConfigStore.Snapshot snapshot = store.read();
            JSONObject out = new JSONObject();
            out.put("ok", true);
            out.put("exists", snapshot.exists);
            out.put("mtime", snapshot.mtimeMs);
            JSONObject values = new JSONObject();
            for (Map.Entry<String, ConfigStore.Value> entry : snapshot.values.entrySet()) {
                values.put(entry.getKey(), entry.getValue().format());
            }
            out.put("values", values);
            out.put("unknown", new JSONArray(snapshot.unknownKeys));
            out.put("removable", new JSONArray(snapshot.removableKeys));
            out.put("notes", new JSONArray(snapshot.notes));
            return out.toString();
        } catch (Exception e) {
            return error("读取配置失败：" + e.getMessage());
        }
    }

    /** 曲线数据 tail：{@code {"ok":true,"text":"…"}}；失败带 AppFiles.diagnose 原文。 */
    @JavascriptInterface
    public String chartData() {
        return tail(AppFiles.dataFile(appContext));
    }

    /** 守护进程日志 tail：{@code {"ok":true,"text":"…"}}；失败带 AppFiles.diagnose 原文。 */
    @JavascriptInterface
    public String logs() {
        return tail(AppFiles.logFile(appContext));
    }

    /** 部署状态：直接这一次 probe 的结果（含 describe 文本）。 */
    @JavascriptInterface
    public String status() {
        try {
            Deployer.Status status = Deployer.get(appContext).probe();
            JSONObject out = new JSONObject();
            out.put("ok", true);
            out.put("status", statusJson(status));
            out.put("describe", status.describe());
            return out.toString();
        } catch (Exception e) {
            return error("读取部署状态失败：" + e.getMessage());
        }
    }

    // ==================== 写入 / 动作 ====================

    /**
     * 批量写配置。入参 {@code {"KEY": <int|int[]|"text">, …}}；
     * 返回 WriteResult：{@code {"ok":…,"skipped":…,"changed":…,"replaced":…,
     * "appended":…,"mtime":…,"error":"…","message":"…"}}。
     */
    @JavascriptInterface
    public String setValues(String json) {
        if (json == null || json.trim().isEmpty()) {
            return error("入参为空");
        }
        try {
            JSONObject in = new JSONObject(json);
            LinkedHashMap<String, ConfigStore.Value> changes = new LinkedHashMap<>();
            Iterator<String> keys = in.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object raw = in.get(key);
                if (raw instanceof JSONArray) {
                    JSONArray array = (JSONArray) raw;
                    int[] numbers = new int[array.length()];
                    for (int i = 0; i < array.length(); i++) {
                        numbers[i] = array.getInt(i);
                    }
                    changes.put(key, ConfigStore.Value.ofNumbers(numbers));
                } else if (raw instanceof Number) {
                    changes.put(key, ConfigStore.Value.ofInt(((Number) raw).intValue()));
                } else {
                    changes.put(key, ConfigStore.Value.ofText(String.valueOf(raw)));
                }
            }
            ConfigStore.WriteResult result = ConfigStore.get(appContext).setAll(changes);
            JSONObject out = new JSONObject();
            out.put("ok", result.ok);
            out.put("skipped", result.skipped);
            out.put("changed", result.changed);
            out.put("replaced", result.replaced);
            out.put("appended", result.appended);
            out.put("mtime", result.mtimeMs);
            out.put("error", result.error);
            out.put("message", result.describe());
            return out.toString();
        } catch (Exception e) {
            return error("写入配置失败：" + e.getMessage());
        }
    }

    @JavascriptInterface
    public String deploy() {
        return action(Deployer.get(appContext).deploy());
    }

    @JavascriptInterface
    public String uninstall() {
        return action(Deployer.get(appContext).uninstall());
    }

    @JavascriptInterface
    public String startDaemon() {
        return action(Deployer.get(appContext).startDaemon());
    }

    @JavascriptInterface
    public String stopDaemon() {
        return action(Deployer.get(appContext).stopDaemon());
    }

    // ==================== 内部 ====================

    /**
     * 动作结果：直接复用 Deployer 收尾时那次 probe 的 {@link Deployer.Result#status}
     * （为 null 时不补探，前端读 describe 即可）。
     */
    private String action(Deployer.Result result) {
        try {
            JSONObject out = new JSONObject();
            out.put("ok", result.ok);
            out.put("action", result.action);
            out.put("error", result.error);
            out.put("steps", new JSONArray(result.steps));
            out.put("describe", result.describe());
            if (result.status != null) {
                out.put("status", statusJson(result.status));
            }
            return out.toString();
        } catch (Exception e) {
            return error("序列化动作结果失败：" + e.getMessage());
        }
    }

    private String tail(File file) {
        try {
            return text(AppFiles.readTailText(file, TAIL_BYTES));
        } catch (IOException e) {
            return error(AppFiles.diagnose(file) + "\n" + e.getMessage());
        }
    }

    private static String text(String value) {
        try {
            JSONObject out = new JSONObject();
            out.put("ok", true);
            out.put("text", value);
            return out.toString();
        } catch (Exception e) {
            return error("序列化文本失败：" + e.getMessage());
        }
    }

    private static JSONObject statusJson(Deployer.Status s) throws Exception {
        JSONObject o = new JSONObject();
        o.put("suOk", s.suOk);
        o.put("binExists", s.binExists);
        o.put("binExecutable", s.binExecutable);
        o.put("binHashOk", s.binHashOk);
        o.put("binMd5", s.binMd5);
        o.put("scriptPath", s.scriptPath);
        o.put("scriptPresent", s.scriptPresent);
        o.put("scriptHashOk", s.scriptHashOk);
        o.put("configPresent", s.configPresent);
        o.put("configPathAligned", s.configPathAligned);
        o.put("daemonRunning", s.daemonRunning);
        o.put("daemonPids", s.daemonPids);
        o.put("watchdogCount", s.watchdogCount);
        o.put("watchdogPids", s.watchdogPids);
        o.put("deployed", s.deployed);
        o.put("configPath", s.configPath);
        o.put("notes", new JSONArray(s.notes));
        return o;
    }

    private static String error(String message) {
        try {
            JSONObject out = new JSONObject();
            out.put("ok", false);
            out.put("error", message == null ? "" : message);
            return out.toString();
        } catch (Exception e) {
            return "{\"ok\":false,\"error\":\"serialize failed\"}";
        }
    }

    private static String readAsset(Context context, String name) throws IOException {
        try (InputStream in = context.getAssets().open(name);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            return new String(out.toByteArray(), StandardCharsets.UTF_8);
        }
    }
}
