package com.flydigi.community.ui.my.config;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import i9.a;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(extras = 10000000, path = a.b.f31922g)
public final class MySharedConfigActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @l Intent intent) {
        super.onActivityResult(i10, i11, intent);
        MySharedConfigFragment mySharedConfigFragment = (MySharedConfigFragment) a4(MySharedConfigFragment.class.getSimpleName());
        if (i10 == 8196 && i11 == -1 && mySharedConfigFragment != null) {
            mySharedConfigFragment.n6();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.community_title_my_shared_config);
        if (a4(MySharedConfigFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), MySharedConfigFragment.f13962x8.a(), MySharedConfigFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
