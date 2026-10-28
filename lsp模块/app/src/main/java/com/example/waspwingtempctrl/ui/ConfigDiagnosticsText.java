package com.example.waspwingtempctrl.ui;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;

import java.io.File;

/**
 * 配置诊断文本（GUI 专用）：路径 / 定义 / 未定义键与读取提示。
 *
 * <p>从 {@code ConfigStore} 搬到 :app，core 不再携带这段展示文案；只读 {@link ConfigStore}
 * 的公共访问器与快照，不碰文件。
 */
final class ConfigDiagnosticsText {

    private ConfigDiagnosticsText() {
    }

    static String describeState(ConfigStore store) {
        return describeState(store, store.read());
    }

    static String describeState(ConfigStore store, Snapshot snap) {
        StringBuilder sb = new StringBuilder(describePaths(store)).append('\n')
                .append(describeDefinitions(store)).append('\n');
        appendUnknownAndNotes(sb, snap);
        return sb.toString();
    }

    static String describePaths(ConfigStore store) {
        File configFile = store.getConfigFile();
        return "配置文件: " + configFile.getAbsolutePath()
                + (store.exists() ? "（存在，" + configFile.length() + " B）" : "（不存在）")
                + '\n'
                + "C 端路径: " + store.daemonConfigPath()
                + (store.isPathAlignedWithDaemon() ? "（一致）" : "（不一致！守护进程读不到 app 写的配置）");
    }

    static String describeDefinitions(ConfigStore store) {
        return "参数定义: params.json · "
                + (store.paramsLoadError().isEmpty() ? store.keyCount() + " 键" : store.paramsLoadError());
    }

    static String describePathsAndNotes(ConfigStore store, Snapshot snap) {
        StringBuilder sb = new StringBuilder(describePaths(store)).append('\n');
        appendUnknownAndNotes(sb, snap);
        return sb.toString();
    }

    private static void appendUnknownAndNotes(StringBuilder sb, Snapshot snap) {
        if (!snap.unknownKeys.isEmpty()) {
            sb.append("未定义键: ").append(snap.unknownKeys.size())
                    .append(" 项（不影响使用）").append('\n');
        }
        for (String note : snap.notes) {
            sb.append("提示: ").append(note).append('\n');
        }
    }
}
