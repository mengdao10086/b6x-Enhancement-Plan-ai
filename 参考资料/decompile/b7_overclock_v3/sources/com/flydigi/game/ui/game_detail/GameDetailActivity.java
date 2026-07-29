package com.flydigi.game.ui.game_detail;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.data.DataConstant;
import com.flydigi.game.R;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.e.f31969e)
public class GameDetailActivity extends p {

    @Autowired(name = DataConstant.KEY_GAME_ID)
    public String K2;

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        h3.a.j().l(this);
        if (a4(GameDetailFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), GameDetailFragment.K6(this.K2), GameDetailFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
