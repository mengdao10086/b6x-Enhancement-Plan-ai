package com.example.waspwingtempctrl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;

/**
 * 静态快捷方式的透明入口：只执行动作，不显示界面。
 *
 * <p>两条快捷方式（kill daemon / 临时停止）都落到本 Activity，靠 {@code intent.action} 区分。
 * 动作执行完（含失败）弹一个 Toast 后立即 {@link #finish()}。
 *
 * <p><b>调用方校验</b>：静态快捷方式要求目标 Activity 导出，任何应用都能显式启动本页、带上同名
 * action。故动作前先确认调用方是当前默认桌面或本应用自身；普通应用拿不到 {@code startActivity}
 * 的调用方身份时（见 {@link #resolveCallerPackage()}），先弹一次确认框，用户确认后才执行，
 * 避免被第三方应用静默停温控。方案与限制见 {@link #resolveCallerPackage()} 的注释。
 *
 * <p>root 与配置文件读写都会阻塞，因此全部放在后台线程；Activity 在动作期间保持透明，
 * root 授权框弹出时不会被提前销毁。
 */
public final class ShortcutActionActivity extends Activity {

    private static final String TAG = "ShortcutAction";

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

    /** 动作只执行一次：确认框的肯定按钮与后续重建都不会重复触发。 */
    private boolean actionStarted;

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
        if (isTrustedCaller(action)) {
            startAction(action);
        } else {
            confirmAndStart(action);
        }
    }

    /**
     * 调用方是否可信：当前默认桌面（静态快捷方式的宿主）或本应用自身。
     *
     * <p>判定只使用系统填写的身份，<b>不信任 {@code getReferrer()}</b>——它由调用方自行设置，
     * 可被伪造成任意包名。识别不到时返回 false，交由确认框兜底。
     */
    private boolean isTrustedCaller(String action) {
        String caller = resolveCallerPackage();
        String home = defaultHomePackage();
        boolean trusted = caller != null
                && (caller.equals(getPackageName()) || caller.equals(home));
        Log.i(TAG, "action=" + action + " caller=" + caller + " home=" + home
                + " trusted=" + trusted);
        return trusted;
    }

    /**
     * 尽力取调用方包名；取不到返回 null（调用方不可信，走确认框）。
     *
     * <p>普通应用拿不到 {@code startActivity} 的调用方：{@code getLaunchedFromPackage()}（API 34+）
     * 只在调用方显式共享身份、同 uid 或平台签名等条件下才有值；{@code getCallingPackage()} 只覆盖
     * {@code startActivityForResult}。两者都由系统填写，调用方无法伪造；{@code getReferrer()} 可伪造，
     * 故不作为信任依据。
     */
    private String resolveCallerPackage() {
        if (Build.VERSION.SDK_INT >= 34) {   // getLaunchedFromPackage 自 Android 14 起提供
            try {
                String pkg = getLaunchedFromPackage();
                if (pkg != null && !pkg.isEmpty()) {
                    return pkg;
                }
            } catch (Throwable ignored) {
                // 拿不到身份：按不可信处理
            }
        }
        try {
            String pkg = getCallingPackage();
            if (pkg != null && !pkg.isEmpty()) {
                return pkg;
            }
        } catch (Throwable ignored) {
            // 同上
        }
        return null;
    }

    /**
     * 当前默认桌面包名；取不到返回 null。Android 11+ 需 AndroidManifest 的 HOME
     * {@code <queries>} 声明，否则这里会因包可见性过滤拿不到结果（同样按不可信处理）。
     */
    private String defaultHomePackage() {
        try {
            Intent home = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME);
            ResolveInfo info = getPackageManager()
                    .resolveActivity(home, PackageManager.MATCH_DEFAULT_ONLY);
            if (info != null && info.activityInfo != null) {
                return info.activityInfo.packageName;
            }
        } catch (Throwable ignored) {
            // 取不到：按不可信处理
        }
        return null;
    }

    /**
     * 调用方无法确认时：先确认、再执行。桌面长按进入的正常用户多一次确认；第三方应用即使拉起本页，
     * 也必须由用户确认，不能静默停温控。文案复用状态页 kill 的既有确认串；临时停止没有现成串，
     * 在这里就地写一句（strings.xml 不在本包白名单，收尾包可迁入资源）。
     */
    private void confirmAndStart(String action) {
        final boolean kill = ACTION_KILL_DAEMON.equals(action);
        String message = kill
                ? getString(R.string.status_dialog_stop_message)
                : getString(R.string.shortcut_temp_stop_message);
        AlertDialog dialog = new AlertDialog.Builder(this,
                android.R.style.Theme_Material_Dialog_Alert)
                .setTitle(kill ? R.string.status_dialog_stop_title
                        : R.string.shortcut_temp_stop_long)
                .setMessage(message)
                .setPositiveButton(kill ? R.string.status_dialog_stop_confirm
                                : R.string.shortcut_temp_stop_short,
                        (d, w) -> startAction(action))
                .setNegativeButton(R.string.status_dialog_cancel, (d, w) -> finish())
                .create();
        // 点外部不吞掉确认：必须明确选“取消 / 确认”，返回键等同取消
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnCancelListener(d -> finish());
        try {
            dialog.show();
        } catch (Throwable t) {
            // 窗口异常不执行动作，也不把异常抛给系统
            showResult(getString(R.string.shortcut_toast_error));
        }
    }

    /** 起后台动作线程；确认框与 onNewIntent 都不会让它跑第二次。 */
    private void startAction(String action) {
        if (actionStarted) {
            return;
        }
        actionStarted = true;
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
