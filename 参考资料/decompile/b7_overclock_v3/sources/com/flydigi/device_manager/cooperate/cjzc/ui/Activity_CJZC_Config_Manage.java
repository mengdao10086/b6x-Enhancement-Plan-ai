package com.flydigi.device_manager.cooperate.cjzc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.d;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import y6.b;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class Activity_CJZC_Config_Manage extends d {
    public ListView J7;
    public b K7;
    public TextView M7;
    public int L7 = -1;
    public int N7 = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean A4(AdapterView adapterView, View view, int i10, long j10) {
        this.L7 = i10;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) Activity_Dialog_Vertical.class);
        intent.putExtra("title", "删除配置");
        intent.putExtra(SocialConstants.PARAM_APP_DESC, "您确定要删除该配置吗？");
        intent.putExtra(CommonNetImpl.CANCEL, "取消");
        intent.putExtra("confirm", "确定");
        startActivityForResult(intent, 100);
        overridePendingTransition(R.anim.open_enter, R.anim.close_enter);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z4(AdapterView adapterView, View view, int i10, long j10) {
        Intent intent = new Intent();
        intent.putExtra(CommonNetImpl.POSITION, i10);
        setResult(100, intent);
        finish();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("position:");
        sb2.append(i10);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_cjzc_config_manage;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 100 && intent.getIntExtra(CommonNetImpl.RESULT, -1) == 1) {
            Activity_CJZC.f14395v8.remove(this.L7);
            Activity_CJZC.u5();
            this.K7.notifyDataSetChanged();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.floatview_config_manager_import);
        y4();
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Activity_CJZC.f14395v8.size() == 0) {
            this.M7.setVisibility(0);
        } else {
            this.M7.setVisibility(8);
        }
    }

    @Override // com.flydigi.device_manager.d
    public void s4(@k GamepadInfo gamepadInfo) {
        super.s4(gamepadInfo);
        if (!gamepadInfo.isConnected() || this.N7 == gamepadInfo.getDeviceMode()) {
            return;
        }
        int deviceMode = gamepadInfo.getDeviceMode();
        this.N7 = deviceMode;
        this.K7.a(deviceMode);
        this.K7.notifyDataSetChanged();
    }

    public final void y4() {
        this.M7 = (TextView) findViewById(R.id.config_notice);
        this.J7 = (ListView) findViewById(R.id.listview);
        b bVar = new b(getApplicationContext(), Activity_CJZC.f14395v8);
        this.K7 = bVar;
        this.J7.setAdapter((ListAdapter) bVar);
        this.J7.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: a7.m
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f289a.z4(adapterView, view, i10, j10);
            }
        });
        this.J7.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: a7.n
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
                return this.f290a.A4(adapterView, view, i10, j10);
            }
        });
    }
}
