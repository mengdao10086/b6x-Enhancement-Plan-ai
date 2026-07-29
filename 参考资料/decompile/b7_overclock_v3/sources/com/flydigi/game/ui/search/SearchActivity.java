package com.flydigi.game.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.game.R;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.e.f31971g)
public class SearchActivity extends p {
    public static void j4(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SearchActivity.class));
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (a4(SearchFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), SearchFragment.v6(), SearchFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
