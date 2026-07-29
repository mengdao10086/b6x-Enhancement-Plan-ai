package com.flydigi.device_manager.ui.connection;

import android.os.Bundle;
import android.view.MenuItem;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.device_manager.R;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.d.f31955k)
public class KeyboardMouseConnectGuideActivity extends com.flydigi.base.common.p {

    @Autowired(name = "type")
    public int K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        if (d0.B(n3(), KeyboardMouseConnectGuideFragment.class.getSimpleName()) == null) {
            d0.v0(n3(), KeyboardMouseConnectGuideFragment.D6(this.K2), R.id.fl_container);
        }
        e4();
        this.C1.setText(R.string.device_connect_guide);
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        d4();
        return true;
    }
}
