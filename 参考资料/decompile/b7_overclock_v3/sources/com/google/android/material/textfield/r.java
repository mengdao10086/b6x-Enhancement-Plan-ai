package com.google.android.material.textfield;

import a1.c;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.y0;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.b0;
import com.google.android.material.textfield.TextInputLayout;
import g.c1;
import g.d0;
import g.d1;
import g.n0;
import g.p0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public class r extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f20967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final FrameLayout f20968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final CheckableImageButton f20969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f20970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f20971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f20972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final CheckableImageButton f20973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f20974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.j> f20976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f20977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f20978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnLongClickListener f20979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public CharSequence f20980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final TextView f20981o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f20982p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public EditText f20983q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public final AccessibilityManager f20984r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public c.e f20985s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextWatcher f20986t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextInputLayout.i f20987u;

    public class a extends com.google.android.material.internal.s {
        public a() {
        }

        @Override // com.google.android.material.internal.s, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.o().a(editable);
        }

        @Override // com.google.android.material.internal.s, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            r.this.o().b(charSequence, i10, i11, i12);
        }
    }

    public class b implements TextInputLayout.i {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@n0 TextInputLayout textInputLayout) {
            if (r.this.f20983q == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.f20983q != null) {
                r.this.f20983q.removeTextChangedListener(r.this.f20986t);
                if (r.this.f20983q.getOnFocusChangeListener() == r.this.o().e()) {
                    r.this.f20983q.setOnFocusChangeListener(null);
                }
            }
            r.this.f20983q = textInputLayout.getEditText();
            if (r.this.f20983q != null) {
                r.this.f20983q.addTextChangedListener(r.this.f20986t);
            }
            r.this.o().n(r.this.f20983q);
            r rVar = r.this;
            rVar.h0(rVar.o());
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.h();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.O();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<s> f20991a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f20992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20994d;

        public d(r rVar, y0 y0Var) {
            this.f20992b = rVar;
            this.f20993c = y0Var.u(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.f20994d = y0Var.u(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        public final s b(int i10) {
            if (i10 == -1) {
                return new g(this.f20992b);
            }
            if (i10 == 0) {
                return new w(this.f20992b);
            }
            if (i10 == 1) {
                return new y(this.f20992b, this.f20994d);
            }
            if (i10 == 2) {
                return new f(this.f20992b);
            }
            if (i10 == 3) {
                return new p(this.f20992b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i10);
        }

        public s c(int i10) {
            s sVar = this.f20991a.get(i10);
            if (sVar != null) {
                return sVar;
            }
            s sVarB = b(i10);
            this.f20991a.append(i10, sVarB);
            return sVarB;
        }
    }

    public r(TextInputLayout textInputLayout, y0 y0Var) {
        super(textInputLayout.getContext());
        this.f20975i = 0;
        this.f20976j = new LinkedHashSet<>();
        this.f20986t = new a();
        b bVar = new b();
        this.f20987u = bVar;
        this.f20984r = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f20967a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f20968b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonK = k(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f20969c = checkableImageButtonK;
        CheckableImageButton checkableImageButtonK2 = k(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f20973g = checkableImageButtonK2;
        this.f20974h = new d(this, y0Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f20981o = appCompatTextView;
        B(y0Var);
        A(y0Var);
        C(y0Var);
        frameLayout.addView(checkableImageButtonK2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonK);
        textInputLayout.h(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public final void A(y0 y0Var) {
        int i10 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (!y0Var.C(i10)) {
            int i11 = R.styleable.TextInputLayout_endIconTint;
            if (y0Var.C(i11)) {
                this.f20977k = ie.c.b(getContext(), y0Var, i11);
            }
            int i12 = R.styleable.TextInputLayout_endIconTintMode;
            if (y0Var.C(i12)) {
                this.f20978l = b0.m(y0Var.o(i12, -1), null);
            }
        }
        int i13 = R.styleable.TextInputLayout_endIconMode;
        if (y0Var.C(i13)) {
            V(y0Var.o(i13, 0));
            int i14 = R.styleable.TextInputLayout_endIconContentDescription;
            if (y0Var.C(i14)) {
                S(y0Var.x(i14));
            }
            Q(y0Var.a(R.styleable.TextInputLayout_endIconCheckable, true));
            return;
        }
        if (y0Var.C(i10)) {
            int i15 = R.styleable.TextInputLayout_passwordToggleTint;
            if (y0Var.C(i15)) {
                this.f20977k = ie.c.b(getContext(), y0Var, i15);
            }
            int i16 = R.styleable.TextInputLayout_passwordToggleTintMode;
            if (y0Var.C(i16)) {
                this.f20978l = b0.m(y0Var.o(i16, -1), null);
            }
            V(y0Var.a(i10, false) ? 1 : 0);
            S(y0Var.x(R.styleable.TextInputLayout_passwordToggleContentDescription));
        }
    }

    public final void A0() {
        int visibility = this.f20981o.getVisibility();
        int i10 = (this.f20980n == null || this.f20982p) ? 8 : 0;
        if (visibility != i10) {
            o().q(i10 == 0);
        }
        x0();
        this.f20981o.setVisibility(i10);
        this.f20967a.F0();
    }

    public final void B(y0 y0Var) {
        int i10 = R.styleable.TextInputLayout_errorIconTint;
        if (y0Var.C(i10)) {
            this.f20970d = ie.c.b(getContext(), y0Var, i10);
        }
        int i11 = R.styleable.TextInputLayout_errorIconTintMode;
        if (y0Var.C(i11)) {
            this.f20971e = b0.m(y0Var.o(i11, -1), null);
        }
        int i12 = R.styleable.TextInputLayout_errorIconDrawable;
        if (y0Var.C(i12)) {
            c0(y0Var.h(i12));
        }
        this.f20969c.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        u0.R1(this.f20969c, 2);
        this.f20969c.setClickable(false);
        this.f20969c.setPressable(false);
        this.f20969c.setFocusable(false);
    }

    public final void C(y0 y0Var) {
        this.f20981o.setVisibility(8);
        this.f20981o.setId(R.id.textinput_suffix_text);
        this.f20981o.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        u0.D1(this.f20981o, 1);
        r0(y0Var.u(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        int i10 = R.styleable.TextInputLayout_suffixTextColor;
        if (y0Var.C(i10)) {
            s0(y0Var.d(i10));
        }
        q0(y0Var.x(R.styleable.TextInputLayout_suffixText));
    }

    public boolean D() {
        return this.f20973g.a();
    }

    public boolean E() {
        return z() && this.f20973g.isChecked();
    }

    public boolean F() {
        return this.f20968b.getVisibility() == 0 && this.f20973g.getVisibility() == 0;
    }

    public boolean G() {
        return this.f20969c.getVisibility() == 0;
    }

    public boolean H() {
        return this.f20975i == 1;
    }

    public void I(boolean z10) {
        this.f20982p = z10;
        A0();
    }

    public void J() {
        y0();
        L();
        K();
        if (o().t()) {
            v0(this.f20967a.v0());
        }
    }

    public void K() {
        t.c(this.f20967a, this.f20973g, this.f20977k);
    }

    public void L() {
        t.c(this.f20967a, this.f20969c, this.f20970d);
    }

    public void M(boolean z10) {
        boolean z11;
        boolean zIsActivated;
        boolean zIsChecked;
        s sVarO = o();
        boolean z12 = true;
        if (!sVarO.l() || (zIsChecked = this.f20973g.isChecked()) == sVarO.m()) {
            z11 = false;
        } else {
            this.f20973g.setChecked(!zIsChecked);
            z11 = true;
        }
        if (!sVarO.j() || (zIsActivated = this.f20973g.isActivated()) == sVarO.k()) {
            z12 = z11;
        } else {
            P(!zIsActivated);
        }
        if (z10 || z12) {
            K();
        }
    }

    public void N(@n0 TextInputLayout.j jVar) {
        this.f20976j.remove(jVar);
    }

    public final void O() {
        AccessibilityManager accessibilityManager;
        c.e eVar = this.f20985s;
        if (eVar == null || (accessibilityManager = this.f20984r) == null) {
            return;
        }
        a1.c.g(accessibilityManager, eVar);
    }

    public void P(boolean z10) {
        this.f20973g.setActivated(z10);
    }

    public void Q(boolean z10) {
        this.f20973g.setCheckable(z10);
    }

    public void R(@c1 int i10) {
        S(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void S(@p0 CharSequence charSequence) {
        if (n() != charSequence) {
            this.f20973g.setContentDescription(charSequence);
        }
    }

    public void T(@g.v int i10) {
        U(i10 != 0 ? i.a.b(getContext(), i10) : null);
    }

    public void U(@p0 Drawable drawable) {
        this.f20973g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f20967a, this.f20973g, this.f20977k, this.f20978l);
            K();
        }
    }

    public void V(int i10) {
        if (this.f20975i == i10) {
            return;
        }
        u0(o());
        int i11 = this.f20975i;
        this.f20975i = i10;
        l(i11);
        a0(i10 != 0);
        s sVarO = o();
        T(t(sVarO));
        R(sVarO.c());
        Q(sVarO.l());
        if (!sVarO.i(this.f20967a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f20967a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
        t0(sVarO);
        W(sVarO.f());
        EditText editText = this.f20983q;
        if (editText != null) {
            sVarO.n(editText);
            h0(sVarO);
        }
        t.a(this.f20967a, this.f20973g, this.f20977k, this.f20978l);
        M(true);
    }

    public void W(@p0 View.OnClickListener onClickListener) {
        t.f(this.f20973g, onClickListener, this.f20979m);
    }

    public void X(@p0 View.OnLongClickListener onLongClickListener) {
        this.f20979m = onLongClickListener;
        t.g(this.f20973g, onLongClickListener);
    }

    public void Y(@p0 ColorStateList colorStateList) {
        if (this.f20977k != colorStateList) {
            this.f20977k = colorStateList;
            t.a(this.f20967a, this.f20973g, colorStateList, this.f20978l);
        }
    }

    public void Z(@p0 PorterDuff.Mode mode) {
        if (this.f20978l != mode) {
            this.f20978l = mode;
            t.a(this.f20967a, this.f20973g, this.f20977k, mode);
        }
    }

    public void a0(boolean z10) {
        if (F() != z10) {
            this.f20973g.setVisibility(z10 ? 0 : 8);
            x0();
            z0();
            this.f20967a.F0();
        }
    }

    public void b0(@g.v int i10) {
        c0(i10 != 0 ? i.a.b(getContext(), i10) : null);
        L();
    }

    public void c0(@p0 Drawable drawable) {
        this.f20969c.setImageDrawable(drawable);
        y0();
        t.a(this.f20967a, this.f20969c, this.f20970d, this.f20971e);
    }

    public void d0(@p0 View.OnClickListener onClickListener) {
        t.f(this.f20969c, onClickListener, this.f20972f);
    }

    public void e0(@p0 View.OnLongClickListener onLongClickListener) {
        this.f20972f = onLongClickListener;
        t.g(this.f20969c, onLongClickListener);
    }

    public void f0(@p0 ColorStateList colorStateList) {
        if (this.f20970d != colorStateList) {
            this.f20970d = colorStateList;
            t.a(this.f20967a, this.f20969c, colorStateList, this.f20971e);
        }
    }

    public void g(@n0 TextInputLayout.j jVar) {
        this.f20976j.add(jVar);
    }

    public void g0(@p0 PorterDuff.Mode mode) {
        if (this.f20971e != mode) {
            this.f20971e = mode;
            t.a(this.f20967a, this.f20969c, this.f20970d, mode);
        }
    }

    public final void h() {
        if (this.f20985s == null || this.f20984r == null || !u0.O0(this)) {
            return;
        }
        a1.c.b(this.f20984r, this.f20985s);
    }

    public final void h0(s sVar) {
        if (this.f20983q == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f20983q.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f20973g.setOnFocusChangeListener(sVar.g());
        }
    }

    public void i() {
        this.f20973g.performClick();
        this.f20973g.jumpDrawablesToCurrentState();
    }

    public void i0(@c1 int i10) {
        j0(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void j() {
        this.f20976j.clear();
    }

    public void j0(@p0 CharSequence charSequence) {
        this.f20973g.setContentDescription(charSequence);
    }

    public final CheckableImageButton k(ViewGroup viewGroup, LayoutInflater layoutInflater, @d0 int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        t.d(checkableImageButton);
        if (ie.c.i(getContext())) {
            androidx.core.view.r.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public void k0(@g.v int i10) {
        m0(i10 != 0 ? i.a.b(getContext(), i10) : null);
    }

    public final void l(int i10) {
        Iterator<TextInputLayout.j> it2 = this.f20976j.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.f20967a, i10);
        }
    }

    @p0
    public CheckableImageButton m() {
        if (G()) {
            return this.f20969c;
        }
        if (z() && F()) {
            return this.f20973g;
        }
        return null;
    }

    public void m0(@p0 Drawable drawable) {
        this.f20973g.setImageDrawable(drawable);
    }

    @p0
    public CharSequence n() {
        return this.f20973g.getContentDescription();
    }

    public void n0(boolean z10) {
        if (z10 && this.f20975i != 1) {
            V(1);
        } else {
            if (z10) {
                return;
            }
            V(0);
        }
    }

    public s o() {
        return this.f20974h.c(this.f20975i);
    }

    public void o0(@p0 ColorStateList colorStateList) {
        this.f20977k = colorStateList;
        t.a(this.f20967a, this.f20973g, colorStateList, this.f20978l);
    }

    @p0
    public Drawable p() {
        return this.f20973g.getDrawable();
    }

    public void p0(@p0 PorterDuff.Mode mode) {
        this.f20978l = mode;
        t.a(this.f20967a, this.f20973g, this.f20977k, mode);
    }

    public int q() {
        return this.f20975i;
    }

    public void q0(@p0 CharSequence charSequence) {
        this.f20980n = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f20981o.setText(charSequence);
        A0();
    }

    public CheckableImageButton r() {
        return this.f20973g;
    }

    public void r0(@d1 int i10) {
        androidx.core.widget.r.E(this.f20981o, i10);
    }

    public Drawable s() {
        return this.f20969c.getDrawable();
    }

    public void s0(@n0 ColorStateList colorStateList) {
        this.f20981o.setTextColor(colorStateList);
    }

    public final int t(s sVar) {
        int i10 = this.f20974h.f20993c;
        return i10 == 0 ? sVar.d() : i10;
    }

    public final void t0(@n0 s sVar) {
        sVar.s();
        this.f20985s = sVar.h();
        h();
    }

    @p0
    public CharSequence u() {
        return this.f20973g.getContentDescription();
    }

    public final void u0(@n0 s sVar) {
        O();
        this.f20985s = null;
        sVar.u();
    }

    @p0
    public Drawable v() {
        return this.f20973g.getDrawable();
    }

    public final void v0(boolean z10) {
        if (!z10 || p() == null) {
            t.a(this.f20967a, this.f20973g, this.f20977k, this.f20978l);
            return;
        }
        Drawable drawableMutate = n0.c.r(p()).mutate();
        n0.c.n(drawableMutate, this.f20967a.getErrorCurrentTextColors());
        this.f20973g.setImageDrawable(drawableMutate);
    }

    @p0
    public CharSequence w() {
        return this.f20980n;
    }

    public void w0(boolean z10) {
        if (this.f20975i == 1) {
            this.f20973g.performClick();
            if (z10) {
                this.f20973g.jumpDrawablesToCurrentState();
            }
        }
    }

    @p0
    public ColorStateList x() {
        return this.f20981o.getTextColors();
    }

    public final void x0() {
        this.f20968b.setVisibility((this.f20973g.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility(F() || G() || ((this.f20980n == null || this.f20982p) ? '\b' : (char) 0) == 0 ? 0 : 8);
    }

    public TextView y() {
        return this.f20981o;
    }

    public final void y0() {
        this.f20969c.setVisibility(s() != null && this.f20967a.S() && this.f20967a.v0() ? 0 : 8);
        x0();
        z0();
        if (z()) {
            return;
        }
        this.f20967a.F0();
    }

    public boolean z() {
        return this.f20975i != 0;
    }

    public void z0() {
        if (this.f20967a.f20885d == null) {
            return;
        }
        u0.d2(this.f20981o, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f20967a.f20885d.getPaddingTop(), (F() || G()) ? 0 : u0.j0(this.f20967a.f20885d), this.f20967a.f20885d.getPaddingBottom());
    }
}
