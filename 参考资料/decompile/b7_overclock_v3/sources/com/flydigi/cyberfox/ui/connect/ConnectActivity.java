package com.flydigi.cyberfox.ui.connect;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.cyberfox.R;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.c.f31944c)
public final class ConnectActivity extends p {

    @hk.e
    @Autowired(name = "key_device_code")
    @yt.k
    public String K2 = "all";

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        this.C1.setText(getString(R.string.cf_title_connection_with_device_name, new Object[]{getString(s6.a.b(this.K2))}));
        d0.v0(n3(), ConnectFragment.f14215q8.a(this.K2), R.id.fl_container);
    }
}
