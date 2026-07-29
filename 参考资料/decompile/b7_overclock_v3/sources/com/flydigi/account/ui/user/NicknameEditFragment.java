package com.flydigi.account.ui.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.flydigi.account.R;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.LoginBaseResponse;
import com.flydigi.data.bean.FZUserAccount;
import g.p0;
import m5.c0;
import m5.f0;

/* JADX INFO: loaded from: classes2.dex */
public class NicknameEditFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public EditText f13259o8;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f6(String str, LoginBaseResponse loginBaseResponse) throws Exception {
        FZUserAccount fZUserAccountH = a5.f.i().h();
        fZUserAccountH.username = str;
        a5.f.i().u(fZUserAccountH);
        this.f13317d8.setResult(-1);
        this.f13317d8.finish();
    }

    public static /* synthetic */ void g6(Throwable th2) throws Exception {
        com.flydigi.base.common.o.E(th2.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h6(String str, LoginBaseResponse loginBaseResponse) throws Exception {
        d6(str);
    }

    public static /* synthetic */ void i6(Throwable th2) throws Exception {
        com.flydigi.base.common.o.E(th2.getMessage());
    }

    public static NicknameEditFragment j6() {
        return new NicknameEditFragment();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.account_fragment_text_edit;
    }

    @Override // androidx.fragment.app.Fragment
    public void N3(@yt.k Menu menu, @yt.k MenuInflater menuInflater) {
        super.N3(menu, menuInflater);
        menuInflater.inflate(R.menu.account_set_nickname, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean Y3(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            I5();
        }
        if (itemId != R.id.menu_reset_nickname) {
            return true;
        }
        k6();
        return true;
    }

    public final void d6(final String str) {
        ((c5.b) f0.i().k().g(c5.b.class)).t(a5.f.i().l(), str).s0(c0.q()).s0(c0.t()).s0(o5.l.d()).s0(y1()).F5(new dj.g() { // from class: com.flydigi.account.ui.user.a
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f13263a.f6(str, (LoginBaseResponse) obj);
            }
        }, new dj.g() { // from class: com.flydigi.account.ui.user.d
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                NicknameEditFragment.g6((Throwable) obj);
            }
        });
    }

    public final void e6(final String str) {
        ((c5.b) f0.i().k().g(c5.b.class)).w(str).s0(c0.q()).s0(c0.t()).s0(o5.l.d()).s0(y1()).F5(new dj.g() { // from class: com.flydigi.account.ui.user.b
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f13265a.h6(str, (LoginBaseResponse) obj);
            }
        }, new dj.g() { // from class: com.flydigi.account.ui.user.c
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                NicknameEditFragment.i6((Throwable) obj);
            }
        });
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        i5(true);
        J5(view);
        this.f13321h8.setText(R.string.account_personal_information_nickname);
        this.f13259o8 = (EditText) F5(R.id.et_nickname);
        String str = a5.f.i().h().username;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13259o8.setText(str);
    }

    public final void k6() {
        String strTrim = this.f13259o8.getText().toString().trim();
        if (strTrim.length() < 4 || strTrim.length() > 18) {
            com.flydigi.base.common.o.E(c3(R.string.account_nickname_hint));
        } else {
            e6(strTrim);
        }
    }
}
