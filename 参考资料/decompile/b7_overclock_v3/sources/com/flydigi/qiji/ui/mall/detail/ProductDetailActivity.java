package com.flydigi.qiji.ui.mall.detail;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.p;
import i9.a;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@Route(path = a.f.f31977f)
public final class ProductDetailActivity extends p {

    @hk.e
    @Autowired(name = a.f.f31978g)
    public int K2 = -1;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        e4();
        this.C1.setText(getString(R.string.app_title_product_detail));
        Fragment fragmentA = d0.A(n3(), ProductDetailFragment.class);
        if (fragmentA == null) {
            fragmentA = ProductDetailFragment.f16158y8.a(this.K2);
        }
        d0.v0(n3(), fragmentA, R.id.fl_container);
    }
}
