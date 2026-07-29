package com.flydigi.account.ui.login;

import android.os.Bundle;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d0;
import com.flydigi.account.R;
import com.flydigi.base.common.p;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.C0378a.f31905b)
public final class LoginActivity extends p {
    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment_with_toolbar;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        e5.a aVar = e5.a.f26658a;
        TextView mTVTitle = this.C1;
        f0.o(mTVTitle, "mTVTitle");
        aVar.a(mTVTitle, R.string.account_login);
        if (a4(LoginFragment.class.getSimpleName()) == null) {
            d0.v0(n3(), LoginFragment.N6(), R.id.fl_container);
        }
    }
}
