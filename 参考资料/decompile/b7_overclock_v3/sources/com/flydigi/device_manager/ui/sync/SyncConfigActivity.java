package com.flydigi.device_manager.ui.sync;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.sync.SyncConfigFragment;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(extras = 10000000, path = a.d.f31958n)
public final class SyncConfigActivity extends com.flydigi.base.common.p implements SyncConfigFragment.b {

    @hk.e
    @Autowired(name = a.d.f31963s)
    public boolean K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        if (this.K2) {
            this.C1.setText(R.string.device_choose_config);
        } else {
            this.C1.setText(R.string.device_config_cloud_sync_title);
        }
        if (com.blankj.utilcode.util.d0.B(n3(), SyncConfigFragment.class.getSimpleName()) == null) {
            com.blankj.utilcode.util.d0.v0(n3(), SyncConfigFragment.f15397y8.a(Boolean.valueOf(this.K2)), R.id.fl_container);
        }
    }

    @Override // com.flydigi.device_manager.ui.sync.SyncConfigFragment.b
    public void w2(@yt.k String gameName, @yt.k String code) {
        kotlin.jvm.internal.f0.p(gameName, "gameName");
        kotlin.jvm.internal.f0.p(code, "code");
        com.blankj.utilcode.util.d0.v0(n3(), ShareSuccessFragment.f15393p8.a(gameName, code), R.id.fl_container);
    }
}
