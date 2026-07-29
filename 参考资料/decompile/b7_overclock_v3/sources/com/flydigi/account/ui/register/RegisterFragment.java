package com.flydigi.account.ui.register;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.o;
import com.blankj.utilcode.util.r0;
import com.flydigi.account.R;
import com.flydigi.account.ui.register.a;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.data.LoginBaseResponse;
import g.n0;
import g.p0;
import g.v;
import o5.l;
import o5.p;
import p5.t;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterFragment extends FZFragment implements a.b {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public d5.e f13214o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f13215p8 = false;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public final Runnable f13216q8 = new a();

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public a.InterfaceC0129a f13217r8;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RegisterFragment.this.f13214o8.f26048q.setVisibility(0);
        }
    }

    public class b extends t {
        public b() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                RegisterFragment registerFragment = RegisterFragment.this;
                registerFragment.y6(registerFragment.f13214o8.f26039h, R.drawable.account_ic_phone_black);
                RegisterFragment.this.f13214o8.f26042k.setVisibility(0);
            } else {
                RegisterFragment registerFragment2 = RegisterFragment.this;
                registerFragment2.y6(registerFragment2.f13214o8.f26039h, R.drawable.account_ic_phone_gray);
                RegisterFragment.this.f13214o8.f26042k.setVisibility(8);
            }
            RegisterFragment.this.n6(Boolean.FALSE);
            RegisterFragment.this.f13214o8.f26047p.setEnabled(r0.n(editable));
        }

        @Override // p5.t, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            RegisterFragment.this.H5().g(RegisterFragment.this.f13216q8);
            RegisterFragment.this.f13214o8.f26048q.setVisibility(4);
        }
    }

    public class c extends t {
        public c() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                RegisterFragment registerFragment = RegisterFragment.this;
                registerFragment.y6(registerFragment.f13214o8.f26041j, R.drawable.account_ic_system_code_black);
            } else {
                RegisterFragment registerFragment2 = RegisterFragment.this;
                registerFragment2.y6(registerFragment2.f13214o8.f26041j, R.drawable.account_ic_system_code_gray);
            }
            RegisterFragment.this.n6(Boolean.FALSE);
        }

        @Override // p5.t, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            RegisterFragment.this.H5().g(RegisterFragment.this.f13216q8);
            RegisterFragment.this.f13214o8.f26048q.setVisibility(4);
        }
    }

    public class d extends t {
        public d() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                RegisterFragment registerFragment = RegisterFragment.this;
                registerFragment.y6(registerFragment.f13214o8.f26040i, R.drawable.account_ic_password_black);
                RegisterFragment.this.f13214o8.f26043l.setVisibility(0);
            } else {
                RegisterFragment registerFragment2 = RegisterFragment.this;
                registerFragment2.y6(registerFragment2.f13214o8.f26040i, R.drawable.account_ic_password_gray);
                RegisterFragment.this.f13214o8.f26043l.setVisibility(8);
            }
            RegisterFragment.this.n6(Boolean.FALSE);
        }

        @Override // p5.t, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            RegisterFragment.this.H5().g(RegisterFragment.this.f13216q8);
            RegisterFragment.this.f13214o8.f26048q.setVisibility(4);
        }
    }

    public class e extends ClickableSpan {
        public e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=818&hideTop=1" : "https://bbs.flydigi.com/reads/1035&hideTop=1").withString(DataConstant.WEB_TITLE, RegisterFragment.this.c3(R.string.account_title_user_agreement)).navigation();
        }
    }

    public class f extends ClickableSpan {
        public f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=1008&hideTop=1" : "https://bbs.flydigi.com/reads/1034&hideTop=1").withString(DataConstant.WEB_TITLE, RegisterFragment.this.c3(R.string.account_title_privacy_policy)).navigation();
        }
    }

    public static RegisterFragment o6() {
        return new RegisterFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r6(Long l10) throws Exception {
        this.f13214o8.f26047p.setText(d3(R.string.account_countdown_simple, l10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s6(View view) {
        this.f13214o8.f26039h.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(View view) {
        this.f13214o8.f26040i.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u6(View view) {
        if (this.f13215p8) {
            this.f13214o8.f26044m.setImageResource(R.drawable.account_ic_password_visible);
            this.f13214o8.f26040i.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.f13214o8.f26044m.setImageResource(R.drawable.account_ic_password_invisible);
            this.f13214o8.f26040i.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        EditText editText = this.f13214o8.f26040i;
        editText.setSelection(editText.getText().length());
        this.f13215p8 = !this.f13215p8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v6(View view) {
        view.setEnabled(false);
        this.f13217r8.c(m5.b.d(this.f13214o8.f26039h.getText().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w6(View view) {
        if (n6(Boolean.TRUE).booleanValue()) {
            KeyboardUtils.j(P4());
            if (this.f13214o8.f26038g.isChecked()) {
                this.f13217r8.h(m5.b.d(this.f13214o8.f26039h.getText().toString().trim()), m5.b.c(this.f13214o8.f26040i.getText().toString().trim()), this.f13214o8.f26041j.getText().toString().trim());
            } else {
                ToastUtils.R(d3(R.string.account_please_agree_user_policy, c3(R.string.account_title_user_agreement), c3(R.string.account_title_privacy_policy)));
                z6();
            }
        }
    }

    public final void A6(String str, int i10) {
        this.f13214o8.f26048q.setText(str);
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.H(this.f13214o8.f26035d);
        dVar.K(R.id.tv_message, 3, i10, 4);
        dVar.r(this.f13214o8.f26035d);
        this.f13214o8.f26048q.setVisibility(0);
    }

    public final void B6() {
        H5().g(this.f13216q8);
        this.f13214o8.f26037f.setEnabled(true);
        this.f13214o8.f26048q.setText("");
        this.f13214o8.f26048q.setVisibility(4);
    }

    @Override // com.flydigi.account.ui.register.a.b
    public void I(@n0 LoginBaseResponse loginBaseResponse) {
        I5();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.f13217r8 = new RegisterPresenter(this);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.account_fragment_register;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @p0
    public View O3(@k LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        d5.e eVarD = d5.e.d(layoutInflater, viewGroup, false);
        this.f13214o8 = eVarD;
        return eVarD.getRoot();
    }

    @Override // com.flydigi.account.ui.register.a.b
    public void f(@n0 String str, boolean z10) {
        E0();
        if (z10) {
            A6(str, R.id.btn_register);
        } else {
            H5().g(this.f13216q8);
            H5().f(this.f13216q8, 1000L);
        }
        d5.e eVar = this.f13214o8;
        eVar.f26047p.setEnabled(eVar.f26039h.length() > 0 && r0.n(this.f13214o8.f26039h.getText()));
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.f13214o8.f26039h.addTextChangedListener(new b());
        this.f13214o8.f26041j.addTextChangedListener(new c());
        this.f13214o8.f26040i.addTextChangedListener(new d());
        o.r(this.f13214o8.f26042k, new View.OnClickListener() { // from class: com.flydigi.account.ui.register.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13229a.s6(view2);
            }
        });
        o.r(this.f13214o8.f26043l, new View.OnClickListener() { // from class: com.flydigi.account.ui.register.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13231a.t6(view2);
            }
        });
        o.r(this.f13214o8.f26044m, new View.OnClickListener() { // from class: com.flydigi.account.ui.register.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13230a.u6(view2);
            }
        });
        o.r(this.f13214o8.f26047p, new View.OnClickListener() { // from class: com.flydigi.account.ui.register.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13228a.v6(view2);
            }
        });
        o.r(this.f13214o8.f26037f, new View.OnClickListener() { // from class: com.flydigi.account.ui.register.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f13232a.w6(view2);
            }
        });
        p6();
    }

    @Override // com.flydigi.account.ui.register.a.b
    public void k() {
        l.f(120).b4(aj.a.c()).s0(y1()).R1(new dj.a() { // from class: com.flydigi.account.ui.register.g
            @Override // dj.a
            public final void run() throws Exception {
                this.f13233a.q6();
            }
        }).E5(new dj.g() { // from class: com.flydigi.account.ui.register.h
            @Override // dj.g
            public final void accept(Object obj) throws Exception {
                this.f13234a.r6((Long) obj);
            }
        });
    }

    public final Boolean n6(Boolean bool) {
        String strTrim = this.f13214o8.f26039h.getText().toString().trim();
        String strTrim2 = this.f13214o8.f26040i.getText().toString().trim();
        String strTrim3 = this.f13214o8.f26041j.getText().toString().trim();
        this.f13214o8.f26037f.setEnabled(false);
        if (com.blankj.utilcode.util.n0.x(strTrim) && !r0.n(strTrim)) {
            A6(c3(R.string.account_phone_number_not_valid), R.id.area_account);
            y6(this.f13214o8.f26039h, R.drawable.account_ic_phone_red);
            return Boolean.FALSE;
        }
        if (com.blankj.utilcode.util.n0.m(strTrim3)) {
            if (bool.booleanValue()) {
                A6(c3(R.string.account_please_input_verify_code), R.id.area_verify_code);
                y6(this.f13214o8.f26041j, R.drawable.account_ic_system_code_red);
            }
            return Boolean.FALSE;
        }
        if (com.blankj.utilcode.util.n0.m(strTrim2)) {
            if (bool.booleanValue()) {
                A6(c3(R.string.account_error_type_wrong_password), R.id.area_password);
                y6(this.f13214o8.f26040i, R.drawable.account_ic_password_red);
            }
            return Boolean.FALSE;
        }
        if (r0.k(DataConstant.REGEX_STRONG_PASSWORD, strTrim2)) {
            B6();
            return Boolean.TRUE;
        }
        A6(c3(R.string.account_error_type_wrong_password), R.id.area_password);
        y6(this.f13214o8.f26040i, R.drawable.account_ic_password_red);
        return Boolean.FALSE;
    }

    public final void p6() {
        String strC3 = c3(R.string.account_title_user_agreement);
        String strC32 = c3(R.string.account_title_privacy_policy);
        String strD3 = d3(R.string.account_user_agreement_and_policy, strC3, strC32);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strD3);
        int iIndexOf = strD3.indexOf(strC3);
        if (iIndexOf < 0) {
            iIndexOf = 8;
        }
        int length = strC3.length() + iIndexOf;
        int iIndexOf2 = strD3.indexOf(strC32);
        if (iIndexOf2 < 0) {
            iIndexOf2 = 16;
        }
        int length2 = strC32.length() + iIndexOf2;
        int i10 = R.color.colorPrimary;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.blankj.utilcode.util.t.a(i10)), iIndexOf, length, 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.blankj.utilcode.util.t.a(i10)), iIndexOf2, length2, 18);
        spannableStringBuilder.setSpan(new e(), iIndexOf, length, 18);
        spannableStringBuilder.setSpan(new f(), iIndexOf2, length2, 18);
        this.f13214o8.f26049r.setMovementMethod(LinkMovementMethod.getInstance());
        this.f13214o8.f26049r.setText(spannableStringBuilder);
        this.f13214o8.f26049r.setHighlightColor(0);
    }

    /* JADX INFO: renamed from: x6, reason: merged with bridge method [inline-methods] */
    public final void q6() {
        this.f13214o8.f26047p.setEnabled(true);
        this.f13214o8.f26047p.setText(R.string.account_get_verify_code);
    }

    public final void y6(EditText editText, @v int i10) {
        editText.setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
    }

    public final void z6() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f13214o8.f26045n, (Property<LinearLayout, Float>) View.TRANSLATION_X, 0.0f, 100.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(new BounceInterpolator());
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.start();
    }
}
