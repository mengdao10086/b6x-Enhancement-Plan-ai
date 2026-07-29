package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final CompoundButton f2479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f2480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2481c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2482d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2483e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2484f;

    public h(@g.n0 CompoundButton compoundButton) {
        this.f2479a = compoundButton;
    }

    public void a() {
        Drawable drawableA = androidx.core.widget.d.a(this.f2479a);
        if (drawableA != null) {
            if (this.f2482d || this.f2483e) {
                Drawable drawableMutate = n0.c.r(drawableA).mutate();
                if (this.f2482d) {
                    n0.c.o(drawableMutate, this.f2480b);
                }
                if (this.f2483e) {
                    n0.c.p(drawableMutate, this.f2481c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2479a.getDrawableState());
                }
                this.f2479a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public int b(int i10) {
        return i10;
    }

    public ColorStateList c() {
        return this.f2480b;
    }

    public PorterDuff.Mode d() {
        return this.f2481c;
    }

    public void e(@g.p0 AttributeSet attributeSet, int i10) {
        boolean z10;
        int iU;
        int iU2;
        Context context = this.f2479a.getContext();
        int[] iArr = R.styleable.CompoundButton;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        CompoundButton compoundButton = this.f2479a;
        androidx.core.view.u0.z1(compoundButton, compoundButton.getContext(), iArr, attributeSet, y0VarG.B(), i10, 0);
        try {
            int i11 = R.styleable.CompoundButton_buttonCompat;
            if (!y0VarG.C(i11) || (iU2 = y0VarG.u(i11, 0)) == 0) {
                z10 = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.f2479a;
                    compoundButton2.setButtonDrawable(i.a.b(compoundButton2.getContext(), iU2));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                    z10 = false;
                }
            }
            if (!z10) {
                int i12 = R.styleable.CompoundButton_android_button;
                if (y0VarG.C(i12) && (iU = y0VarG.u(i12, 0)) != 0) {
                    CompoundButton compoundButton3 = this.f2479a;
                    compoundButton3.setButtonDrawable(i.a.b(compoundButton3.getContext(), iU));
                }
            }
            int i13 = R.styleable.CompoundButton_buttonTint;
            if (y0VarG.C(i13)) {
                androidx.core.widget.d.d(this.f2479a, y0VarG.d(i13));
            }
            int i14 = R.styleable.CompoundButton_buttonTintMode;
            if (y0VarG.C(i14)) {
                androidx.core.widget.d.e(this.f2479a, d0.e(y0VarG.o(i14, -1), null));
            }
        } finally {
            y0VarG.I();
        }
    }

    public void f() {
        if (this.f2484f) {
            this.f2484f = false;
        } else {
            this.f2484f = true;
            a();
        }
    }

    public void g(ColorStateList colorStateList) {
        this.f2480b = colorStateList;
        this.f2482d = true;
        a();
    }

    public void h(@g.p0 PorterDuff.Mode mode) {
        this.f2481c = mode;
        this.f2483e = true;
        a();
    }
}
