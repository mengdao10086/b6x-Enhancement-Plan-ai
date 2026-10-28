package com.example.waspwingtempctrl.ui;

import android.content.Context;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.Deployer;
import com.example.waspwingtempctrl.RootShell;

/**
 * 状态页诊断串（GUI 专用）：部署状态 + 配置状态 + root 诊断。阻塞，须在后台线程调用。
 */
final class DeployDiagnostics {

    private DeployDiagnostics() {
    }

    static String build(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 部署 ===\n").append(Deployer.get(context).probe().describe()).append('\n');
        sb.append("=== 配置 ===\n").append(ConfigDiagnosticsText.describeState(ConfigStore.get(context))).append('\n');
        sb.append("=== root ===\n").append(RootShell.get(context).buildDiagnostics());
        return sb.toString();
    }
}
