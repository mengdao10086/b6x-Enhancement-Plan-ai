package com.flydigi.community.ui.my.like;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import i9.a;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(extras = 10000000, path = a.b.f31924i)
public final class MyLikeArticleActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.community_my_collect_title);
        if (d0.A(n3(), MyLikeArticleFragment.class) == null) {
            d0.v0(n3(), MyLikeArticleFragment.f13980y8.a(), R.id.fl_container);
        }
    }
}
