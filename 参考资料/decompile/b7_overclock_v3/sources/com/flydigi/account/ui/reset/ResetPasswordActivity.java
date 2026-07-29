package com.flydigi.account.ui.reset;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.account.R;
import com.flydigi.base.common.p;
import g.p0;
import i9.a;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.C0378a.f31909f)
public class ResetPasswordActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.account_reset_password);
        if (a4(ResetPasswordFragment.class.getSimpleName()) == null) {
            o5.a.m(n3(), ResetPasswordFragment.v6(), ResetPasswordFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
