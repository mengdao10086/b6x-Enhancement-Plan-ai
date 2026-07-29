package com.flydigi.account.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.flydigi.account.R;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class NicknameEditActivity extends com.flydigi.base.common.p {
    public static Intent j4(Context context) {
        return new Intent(context, (Class<?>) NicknameEditActivity.class);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        if (a4(NicknameEditFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), NicknameEditFragment.j6(), NicknameEditFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
