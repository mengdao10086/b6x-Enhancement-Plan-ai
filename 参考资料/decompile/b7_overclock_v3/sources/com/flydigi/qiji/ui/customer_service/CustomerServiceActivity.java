package com.flydigi.qiji.ui.customer_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.n0;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.p;
import com.flydigi.data.DataConstant;
import com.flydigi.web.WebFragment;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = a.f.f31976e)
public final class CustomerServiceActivity extends p {

    @hk.e
    @l
    @Autowired(name = DataConstant.WEB_URL)
    public String K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        if (n0.m(this.K2)) {
            finish();
        }
        e4();
        this.C1.setText(R.string.app_customer_service);
        if (d0.A(n3(), CustomerServiceFragment.class) == null) {
            d0.v0(n3(), CustomerServiceFragment.f16101t8.a(this.K2), R.id.fl_container);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@k Menu menu) {
        f0.p(menu, "menu");
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@k Intent intent) {
        f0.p(intent, "intent");
        super.onNewIntent(intent);
        this.K2 = intent.getStringExtra(DataConstant.WEB_URL);
        WebFragment webFragment = (WebFragment) a4(WebFragment.class.getSimpleName());
        if (webFragment == null) {
            d0.v0(n3(), WebFragment.e6(this.K2), R.id.fl_container);
        } else {
            Bundle bundle = new Bundle();
            bundle.putAll(intent.getExtras());
            webFragment.c5(bundle);
            webFragment.j6();
        }
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(@k MenuItem item) {
        f0.p(item, "item");
        if (item.getItemId() == R.id.menu_diagnose) {
            h3.a.j().d(a.d.f31961q).navigation();
        }
        return super.onOptionsItemSelected(item);
    }
}
