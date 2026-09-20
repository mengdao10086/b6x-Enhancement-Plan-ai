package com.example.waspwingtempctrl.ui;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/**
 * 配置页的诊断区（<b>只读展示</b>）：{@link ConfigStore#describeState()}（含落点是否与守护进程一致、
 * 护栏键自检、键数）与配置 mtime。
 *
 * <p>本区整块默认折叠（{@code config_diag_body} 初始 gone）：数据文件信息、键渲染自检
 * （由 {@link ConfigFormFragment} 写进 {@code config_diag_selfcheck}）与本节正文都在折叠体内，
 * 展开才占高度。本类只管自己的两个 TextView，不碰自检那份（它每次刷新都会被整段覆盖）。
 *
 * <p>本区不提供任何写动作：出厂配置由 {@link com.example.waspwingtempctrl.Deployer} 在部署时写出
 * （{@code ConfigStore.writeFactoryIfAbsent()} 的 javadoc 明确"界面不要自己调"），
 * 界面另开一个写入口就是绕过 I5 的重复写入路径。
 *
 * <p>只调 {@link ConfigStore} 的公开接口，不碰文件、不拼 shell；读取在后台线程，主线程只做渲染。
 */
final class ConfigDiagnostics {

    private final ConfigStore store;
    private final ExecutorService io;
    private final Handler main;

    private final View body;
    private final TextView arrowView;
    private final TextView mtimeView;
    private final TextView stateView;

    private boolean expanded;
    private boolean refreshQueued;
    private boolean released;

    ConfigDiagnostics(@NonNull View pageRoot, @NonNull ConfigStore store, @NonNull ExecutorService io,
                      @NonNull Handler main) {
        this.store = store;
        this.io = io;
        this.main = main;

        body = pageRoot.findViewById(R.id.config_diag_body);
        arrowView = pageRoot.findViewById(R.id.config_diag_arrow);
        mtimeView = pageRoot.findViewById(R.id.config_diag_mtime);
        stateView = pageRoot.findViewById(R.id.config_diag_text);

        pageRoot.findViewById(R.id.config_diag_header).setOnClickListener(v -> setExpanded(!expanded));
        pageRoot.findViewById(R.id.config_diag_refresh).setOnClickListener(v -> refresh());
        setExpanded(false);
    }

    void setExpanded(boolean value) {
        expanded = value;
        body.setVisibility(value ? View.VISIBLE : View.GONE);
        arrowView.setText(value ? R.string.config_arrow_expanded : R.string.config_arrow_collapsed);
        arrowView.setContentDescription(body.getContext().getString(
                value ? R.string.config_action_collapse : R.string.config_action_expand));
    }

    /** 后台重读诊断信息（落点一致性 / 护栏自检 / 未知键 / mtime）。 */
    void refresh() {
        if (released || refreshQueued || io.isShutdown()) {
            return;
        }
        refreshQueued = true;
        io.execute(new Runnable() {
            @Override
            public void run() {
                // describeState() 内部已含一次读取；mtime 取快照自己的字段，不再多读一次
                final Snapshot snapshot = store.read();
                final String state = store.describeState();
                main.post(new Runnable() {
                    @Override
                    public void run() {
                        apply(snapshot, state);
                    }
                });
            }
        });
    }

    private void apply(Snapshot snapshot, String state) {
        refreshQueued = false;
        if (released) {
            return;
        }
        stateView.setText(state);
        if (snapshot.exists) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date(snapshot.mtimeMs));
            mtimeView.setText(mtimeView.getContext().getString(R.string.config_diag_mtime, time));
        } else {
            mtimeView.setText(mtimeView.getContext().getString(R.string.config_diag_mtime_missing));
        }
    }

    /** 页面视图销毁时调：断开视图引用，避免后台回调打到已销毁的视图上。 */
    void release() {
        released = true;
    }
}
