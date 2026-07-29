package com.flydigi.account.ui.reset;

import android.os.Bundle;
import android.text.Editable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.o;
import com.blankj.utilcode.util.r0;
import com.flydigi.account.R;
import com.flydigi.account.ui.reset.a;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import g.n0;
import g.p0;
import g.v;
import p5.t;

/* JADX INFO: loaded from: classes2.dex */
public class ResetPasswordFragment extends FZFragment implements a.b {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public d5.f f13237o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public a.InterfaceC0131a f13238p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f13239q8 = false;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public final Runnable f13240r8 = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ResetPasswordFragment.this.f13237o8.f26063n.setVisibility(0);
        }
    }

    public class b extends t {
        public b() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                ResetPasswordFragment resetPasswordFragment = ResetPasswordFragment.this;
                resetPasswordFragment.x6(resetPasswordFragment.f13237o8.f26056g, R.drawable.account_ic_phone_black);
                ResetPasswordFragment.this.f13237o8.f26059j.setVisibility(0);
            } else {
                ResetPasswordFragment resetPasswordFragment2 = ResetPasswordFragment.this;
                resetPasswordFragment2.x6(resetPasswordFragment2.f13237o8.f26056g, R.drawable.account_ic_phone_gray);
                ResetPasswordFragment.this.f13237o8.f26059j.setVisibility(8);
            }
            ResetPasswordFragment.this.n6(Boolean.FALSE);
            ResetPasswordFragment.this.f13237o8.f26062m.setEnabled(r0.n(editable));
        }

        @Override // p5.t, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ResetPasswordFragment.this.H5().g(ResetPasswordFragment.this.f13240r8);
            ResetPasswordFragment.this.f13237o8.f26063n.setVisibility(4);
        }
    }

    public class c extends t {
        public c() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                ResetPasswordFragment resetPasswordFragment = ResetPasswordFragment.this;
                resetPasswordFragment.x6(resetPasswordFragment.f13237o8.f26058i, R.drawable.account_ic_system_code_black);
            } else {
                ResetPasswordFragment resetPasswordFragment2 = ResetPasswordFragment.this;
                resetPasswordFragment2.x6(resetPasswordFragment2.f13237o8.f26058i, R.drawable.account_ic_system_code_gray);
            }
            ResetPasswordFragment.this.n6(Boolean.FALSE);
        }

        @Override // p5.t, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ResetPasswordFragment.this.H5().g(ResetPasswordFragment.this.f13240r8);
            ResetPasswordFragment.this.f13237o8.f26063n.setVisibility(4);
        }
    }

    public class d extends t {
        public d() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                ResetPasswordFragment resetPasswordFragment = ResetPasswordFragment.this;
                resetPasswordFragment.x6(resetPasswordFragment.f13237o8.f26057h, R.drawable.account_ic_password_black);
                ResetPasswordFragment.this.f13237o8.f26060k.setVisibility(0);
                ResetPasswordFragment.this.f13237o8.f26061l.setVisibility(0);
            } else {
                ResetPasswordFragment resetPasswordFragment2 = ResetPasswordFragment.this;
                resetPasswordFragment2.x6(resetPasswordFragment2.f13237o8.f26057h, R.drawable.account_ic_password_gray);
                ResetPasswordFragment.this.f13237o8.f26061l.setVisibility(8);
                ResetPasswordFragment.this.f13237o8.f26060k.setVisibility(8);
            }
            ResetPasswordFragment.this.n6(Boolean.FALSE);
        }

        @Override // p5.t, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ResetPasswordFragment.this.H5().g(ResetPasswordFragment.this.f13240r8);
            ResetPasswordFragment.this.f13237o8.f26063n.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p6(Long l10) throws Exception {
        this.f13237o8.f26062m.setText(d3(R.string.account_countdown_simple, l10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q6(View view) {
        this.f13237o8.f26056g.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r6(View view) {
        this.f13237o8.f26057h.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s6(View view) {
        if (this.f13239q8) {
            this.f13237o8.f26061l.setImageResource(R.drawable.account_ic_password_visible);
            this.f13237o8.f26057h.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.f13237o8.f26061l.setImageResource(R.drawable.account_ic_password_invisible);
            this.f13237o8.f26057h.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        EditText editText = this.f13237o8.f26057h;
        editText.setSelection(editText.getText().length());
        this.f13239q8 = !this.f13239q8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(View view) {
        view.setEnabled(false);
        this.f13238p8.c(m5.b.d(this.f13237o8.f26056g.getText().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u6(View view) {
        if (n6(Boolean.TRUE).booleanValue()) {
            KeyboardUtils.j(P4());
            String strTrim = this.f13237o8.f26056g.getText().toString().trim();
            String strTrim2 = this.f13237o8.f26057h.getText().toString().trim();
            this.f13238p8.m(m5.b.d(strTrim), m5.b.c(strTrim2), this.f13237o8.f26058i.getText().toString().trim());
        }
    }

    public static ResetPasswordFragment v6() {
        return new ResetPasswordFragment();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.f13238p8 = new ResetPasswordPresenter(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.account_fragment_reset_password;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @p0
    public View O3(@yt.k LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        d5.f fVarD = d5.f.d(layoutInflater, viewGroup, false);
        this.f13237o8 = fVarD;
        return fVarD.getRoot();
    }

    @Override // com.flydigi.account.ui.reset.a.b
    public void Y1() {
        I5();
    }

    @Override // com.flydigi.account.ui.reset.a.b
    public void f(@n0 String str, boolean z10) {
        E0();
        if (z10) {
            y6(str, R.id.btn_reset);
        }
        d5.f fVar = this.f13237o8;
        fVar.f26062m.setEnabled(fVar.f26056g.length() > 0 && r0.n(this.f13237o8.f26056g.getText()));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@yt.k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f13237o8.f26056g.addTextChangedListener(new b());
        this.f13237o8.f26058i.addTextChangedListener(new c());
        this.f13237o8.f26057h.addTextChangedListener(new d());
        o.r(this.f13237o8.f26059j, new View.OnClickListener() { // from class: com.flydigi.account.ui.reset.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13251a.q6(view2);
            }
        });
        o.r(this.f13237o8.f26060k, new View.OnClickListener() { // from class: com.flydigi.account.ui.reset.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13252a.r6(view2);
            }
        });
        o.r(this.f13237o8.f26061l, new View.OnClickListener() { // from class: com.flydigi.account.ui.reset.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13249a.s6(view2);
            }
        });
        o.r(this.f13237o8.f26062m, new View.OnClickListener() { // from class: com.flydigi.account.ui.reset.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13250a.t6(view2);
            }
        });
        o.r(this.f13237o8.f26055f, new View.OnClickListener() { // from class: com.flydigi.account.ui.reset.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13248a.u6(view2);
            }
        });
    }

    @Override // com.flydigi.account.ui.reset.a.b
    public void k() {
        o5.l.f(120).b4(aj.a.c()).s0(y1()).R1(new dj.a() { // from class: com.flydigi.account.ui.reset.g
            @Override // dj.a
            public final void run() throws Exception {
                this.f13253a.o6();
            }
        }).E5(new dj.g() { // from class: com.flydigi.account.ui.reset.h
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f13254a.p6((Long) obj);
            }
        });
    }

    public final Boolean n6(Boolean bool) {
        String strTrim = this.f13237o8.f26056g.getText().toString().trim();
        String strTrim2 = this.f13237o8.f26057h.getText().toString().trim();
        String strTrim3 = this.f13237o8.f26058i.getText().toString().trim();
        this.f13237o8.f26055f.setEnabled(false);
        if (com.blankj.utilcode.util.n0.x(strTrim) && !r0.n(strTrim)) {
            y6(c3(R.string.account_phone_number_not_valid), R.id.area_account);
            x6(this.f13237o8.f26056g, R.drawable.account_ic_phone_red);
            return Boolean.FALSE;
        }
        if (com.blankj.utilcode.util.n0.m(strTrim3)) {
            if (bool.booleanValue()) {
                y6(c3(R.string.account_please_input_verify_code), R.id.area_verify_code);
                x6(this.f13237o8.f26058i, R.drawable.account_ic_system_code_red);
            }
            return Boolean.FALSE;
        }
        if (com.blankj.utilcode.util.n0.m(strTrim2)) {
            if (bool.booleanValue()) {
                y6(c3(R.string.account_error_type_wrong_password), R.id.area_password);
                x6(this.f13237o8.f26057h, R.drawable.account_ic_password_red);
            }
            return Boolean.FALSE;
        }
        if (r0.k(DataConstant.REGEX_STRONG_PASSWORD, strTrim2)) {
            z6();
            return Boolean.TRUE;
        }
        y6(c3(R.string.account_error_type_wrong_password), R.id.area_password);
        x6(this.f13237o8.f26057h, R.drawable.account_ic_password_red);
        return Boolean.FALSE;
    }

    /* JADX INFO: renamed from: w6, reason: merged with bridge method [inline-methods] */
    public final void o6() {
        this.f13237o8.f26062m.setEnabled(true);
        this.f13237o8.f26062m.setText(R.string.account_get_verify_code);
    }

    public final void x6(EditText editText, @v int i10) {
        editText.setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
    }

    public final void y6(String str, int i10) {
        this.f13237o8.f26063n.setText(str);
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.H(this.f13237o8.f26053d);
        dVar.K(R.id.tv_message, 3, i10, 4);
        dVar.r(this.f13237o8.f26053d);
        this.f13237o8.f26063n.setVisibility(0);
    }

    public final void z6() {
        H5().g(this.f13240r8);
        this.f13237o8.f26055f.setEnabled(true);
        this.f13237o8.f26063n.setText("");
        this.f13237o8.f26063n.setVisibility(4);
    }
}
