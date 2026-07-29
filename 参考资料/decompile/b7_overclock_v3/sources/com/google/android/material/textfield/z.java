package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import g.d1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public class z extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f21047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f21048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public CharSequence f21049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f21050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f21051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f21052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnLongClickListener f21053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21054h;

    public z(TextInputLayout textInputLayout, y0 y0Var) {
        super(textInputLayout.getContext());
        this.f21047a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, androidx.core.view.m.f5025b));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f21050d = checkableImageButton;
        t.d(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f21048b = appCompatTextView;
        g(y0Var);
        f(y0Var);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    @p0
    public CharSequence a() {
        return this.f21049c;
    }

    @p0
    public ColorStateList b() {
        return this.f21048b.getTextColors();
    }

    @n0
    public TextView c() {
        return this.f21048b;
    }

    @p0
    public CharSequence d() {
        return this.f21050d.getContentDescription();
    }

    @p0
    public Drawable e() {
        return this.f21050d.getDrawable();
    }

    public final void f(y0 y0Var) {
        this.f21048b.setVisibility(8);
        this.f21048b.setId(R.id.textinput_prefix_text);
        this.f21048b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        u0.D1(this.f21048b, 1);
        m(y0Var.u(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        int i10 = R.styleable.TextInputLayout_prefixTextColor;
        if (y0Var.C(i10)) {
            n(y0Var.d(i10));
        }
        l(y0Var.x(R.styleable.TextInputLayout_prefixText));
    }

    public final void g(y0 y0Var) {
        if (ie.c.i(getContext())) {
            androidx.core.view.r.g((ViewGroup.MarginLayoutParams) this.f21050d.getLayoutParams(), 0);
        }
        r(null);
        s(null);
        int i10 = R.styleable.TextInputLayout_startIconTint;
        if (y0Var.C(i10)) {
            this.f21051e = ie.c.b(getContext(), y0Var, i10);
        }
        int i11 = R.styleable.TextInputLayout_startIconTintMode;
        if (y0Var.C(i11)) {
            this.f21052f = b0.m(y0Var.o(i11, -1), null);
        }
        int i12 = R.styleable.TextInputLayout_startIconDrawable;
        if (y0Var.C(i12)) {
            q(y0Var.h(i12));
            int i13 = R.styleable.TextInputLayout_startIconContentDescription;
            if (y0Var.C(i13)) {
                p(y0Var.x(i13));
            }
            o(y0Var.a(R.styleable.TextInputLayout_startIconCheckable, true));
        }
    }

    public boolean h() {
        return this.f21050d.a();
    }

    public boolean i() {
        return this.f21050d.getVisibility() == 0;
    }

    public void j(boolean z10) {
        this.f21054h = z10;
        y();
    }

    public void k() {
        t.c(this.f21047a, this.f21050d, this.f21051e);
    }

    public void l(@p0 CharSequence charSequence) {
        this.f21049c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f21048b.setText(charSequence);
        y();
    }

    public void m(@d1 int i10) {
        androidx.core.widget.r.E(this.f21048b, i10);
    }

    public void n(@n0 ColorStateList colorStateList) {
        this.f21048b.setTextColor(colorStateList);
    }

    public void o(boolean z10) {
        this.f21050d.setCheckable(z10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        x();
    }

    public void p(@p0 CharSequence charSequence) {
        if (d() != charSequence) {
            this.f21050d.setContentDescription(charSequence);
        }
    }

    public void q(@p0 Drawable drawable) {
        this.f21050d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f21047a, this.f21050d, this.f21051e, this.f21052f);
            v(true);
            k();
        } else {
            v(false);
            r(null);
            s(null);
            p(null);
        }
    }

    public void r(@p0 View.OnClickListener onClickListener) {
        t.f(this.f21050d, onClickListener, this.f21053g);
    }

    public void s(@p0 View.OnLongClickListener onLongClickListener) {
        this.f21053g = onLongClickListener;
        t.g(this.f21050d, onLongClickListener);
    }

    public void t(@p0 ColorStateList colorStateList) {
        if (this.f21051e != colorStateList) {
            this.f21051e = colorStateList;
            t.a(this.f21047a, this.f21050d, colorStateList, this.f21052f);
        }
    }

    public void u(@p0 PorterDuff.Mode mode) {
        if (this.f21052f != mode) {
            this.f21052f = mode;
            t.a(this.f21047a, this.f21050d, this.f21051e, mode);
        }
    }

    public void v(boolean z10) {
        if (i() != z10) {
            this.f21050d.setVisibility(z10 ? 0 : 8);
            x();
            y();
        }
    }

    public void w(@n0 a1.d dVar) {
        if (this.f21048b.getVisibility() != 0) {
            dVar.Y1(this.f21050d);
        } else {
            dVar.t1(this.f21048b);
            dVar.Y1(this.f21048b);
        }
    }

    public void x() {
        EditText editText = this.f21047a.f20885d;
        if (editText == null) {
            return;
        }
        u0.d2(this.f21048b, i() ? 0 : u0.k0(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void y() {
        int i10 = (this.f21049c == null || this.f21054h) ? 8 : 0;
        setVisibility(this.f21050d.getVisibility() == 0 || i10 == 0 ? 0 : 8);
        this.f21048b.setVisibility(i10);
        this.f21047a.F0();
    }
}
