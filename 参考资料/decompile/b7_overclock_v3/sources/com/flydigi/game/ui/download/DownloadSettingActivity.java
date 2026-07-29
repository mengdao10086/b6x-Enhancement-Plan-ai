package com.flydigi.game.ui.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.flydigi.base.common.p;
import com.flydigi.game.R;
import g.p0;
import o5.a;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadSettingActivity extends p {
    public static void j4(Context context) {
        context.startActivity(new Intent(context, (Class<?>) DownloadSettingActivity.class));
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (a4(DownloadSettingFragment.class.getSimpleName()) == null) {
            a.m(n3(), DownloadSettingFragment.b6(), DownloadSettingFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
