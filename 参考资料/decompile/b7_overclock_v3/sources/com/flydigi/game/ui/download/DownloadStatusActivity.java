package com.flydigi.game.ui.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.p;
import com.flydigi.game.R;
import com.flydigi.game.ui.download.DownloadStatusFragment;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.e.f31970f)
public class DownloadStatusActivity extends p implements DownloadStatusFragment.c {
    public static void j4(Context context) {
        context.startActivity(new Intent(context, (Class<?>) DownloadStatusActivity.class));
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (a4(DownloadStatusFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), DownloadStatusFragment.h6(), DownloadStatusFragment.class.getSimpleName(), R.id.fl_container);
        }
    }

    @Override // com.flydigi.game.ui.download.DownloadStatusFragment.c
    public void x1() {
        o5.a.m0(n3(), DownloadSettingFragment.b6(), DownloadSettingFragment.class.getSimpleName(), R.id.fl_container, true);
    }
}
