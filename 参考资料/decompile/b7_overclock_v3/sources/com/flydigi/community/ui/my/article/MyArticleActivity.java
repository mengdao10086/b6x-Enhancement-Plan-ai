package com.flydigi.community.ui.my.article;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(extras = 10000000, path = a.b.f31923h)
public final class MyArticleActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @l Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Fragment fragmentB = d0.B(n3(), MyArticleFragment.class.getSimpleName());
        f0.n(fragmentB, "null cannot be cast to non-null type com.flydigi.community.ui.my.article.MyArticleFragment");
        MyArticleFragment myArticleFragment = (MyArticleFragment) fragmentB;
        if (i10 == 8196 && i11 == -1) {
            myArticleFragment.n6();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.community_title_my_published_article);
        Fragment fragmentA4 = a4(MyArticleFragment.class.getSimpleName());
        if (fragmentA4 == null) {
            fragmentA4 = MyArticleFragment.f13944x8.a();
        }
        d0.y0(n3(), fragmentA4, R.id.fl_container, MyArticleFragment.class.getSimpleName());
    }
}
