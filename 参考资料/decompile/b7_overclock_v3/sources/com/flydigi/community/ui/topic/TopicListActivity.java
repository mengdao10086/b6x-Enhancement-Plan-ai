package com.flydigi.community.ui.topic;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.common.p;
import com.flydigi.community.R;
import i9.a;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.b.f31926k)
public final class TopicListActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(getString(R.string.community_topic));
        d0.v0(n3(), TopicListFragment.f14085x8.a(getIntent().getBooleanExtra(a.b.f31934s, false)), R.id.fl_container);
    }
}
