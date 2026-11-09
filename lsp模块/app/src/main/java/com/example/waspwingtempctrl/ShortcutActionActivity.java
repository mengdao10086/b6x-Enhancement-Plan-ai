package com.example.waspwingtempctrl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.Collections;

/**
 * 静态快捷方式的透明入口：只执行动作，不显示界面。
 *
 * <p>两条快捷方式（kill daemon / 临时停止）都落到本 Activity，靠 {@code intent.action} 区分。
 * 动作执行完（含失败）弹一个 Toast 后立即 {@link #finish()}。
 *
 * <p>root 与配置文件读写都会阻塞，因此全部放在后台线程；Activity 在动作期间保持透明，
 * root 授权框弹出时不会被提前销毁。
 */
public final class ShortcutActionActivity extends Activity {

    /** 与 res/xml/shortcuts.xml 中的 android:action 保持一致。 */
    private static final String ACTION_KILL_DAEMON =
            "com.example.waspwingtempctrl.action.KILL_DAEMON";
    private static final String ACTION_TEMP_STOP =
            "com.example.waspwingtempctrl.action.TEMP_STOP";

    /** 临时停止参数键；定义在 params.json，本类只按约定读写。 */
    private static final String KEY_UI_TEMP_STOP = "UI_TEMP_STOP";

    /** Toast 里单行展示的最大字符数，超出截断，避免关键信息被系统折叠掉。 */
    private static final int TOAST_REASON_MAX_CHARS = 80;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 已执行过一次的界面被重建时不再重复执行（例如进程回收后的恢复）
        if (savedInstanceState != null) {
            finish();
            return;
        }
        String action = getIntent() == null ? null : getIntent().getAction();
        if (!ACTION_KILL_DAEMON.equals(action) && !ACTION_TEMP_STOP.equals(action)) {
            showResult(getString(R.string.shortcut_toast_unknown_action));
            return;
        }
        new Thread(() -> runAction(action), "shortcut-action").start();
    }

    private void runAction(String action) {
        String message;
        try {
            message = ACTION_KILL_DAEMON.equals(action) ? runKillDaemon() : runTempStop();
        } catch (Throwable t) {
            // 快捷方式入口不允许把异常抛给系统导致崩溃
            message = getString(R.string.shortcut_toast_error);
        }
        showResult(message);
    }

    /** kill daemon：复用状态页同一个 {@link Deployer#stopDaemon()} 实现。 */
    private String runKillDaemon() {
        Deployer.Result result = Deployer.get(this).stopDaemon();
        if (result.ok) {
            return getString(R.string.shortcut_toast_kill_ok);
        }
        String error = result.error == null ? "" : result.error;
        if (error.startsWith("root 执行失败")) {
            return getString(R.string.shortcut_toast_root_denied);
        }
        return getString(R.string.shortcut_toast_kill_failed,
                concise(error.isEmpty() ? "未知原因" : error));
    }

    /** 临时停止：只把参数键置 1，实际停止由守护进程读取该键后执行。 */
    private String runTempStop() {
        ConfigStore.WriteResult result = ConfigStore.get(this).setAll(
                Collections.singletonMap(KEY_UI_TEMP_STOP, ConfigStore.Value.ofInt(1)));
        if (result.ok) {
            return getString(R.string.shortcut_toast_temp_stop_ok);
        }
        return getString(R.string.shortcut_toast_temp_stop_failed, concise(result.error));
    }

    /** 把可能带换行的失败原因压成一行，并限制 Toast 文本长度。 */
    private static String concise(String text) {
        if (text == null) {
            return "";
        }
        String oneLine = text.replace('\n', ' ').trim();
        if (oneLine.length() <= TOAST_REASON_MAX_CHARS) {
            return oneLine;
        }
        return oneLine.substring(0, TOAST_REASON_MAX_CHARS) + "…";
    }

    /** 回到主线程弹 Toast，随后收起透明界面；Toast 用 application context，不随界面销毁丢失。 */
    private void showResult(String message) {
        mainHandler.post(() -> {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            if (!isFinishing()) {
                finish();
            }
        });
    }
}
