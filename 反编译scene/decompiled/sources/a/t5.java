package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t5 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompoundButton f2960a;
    public boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f7466a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f2959a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2961a = false;
    public boolean b = false;

    public t5(CompoundButton compoundButton) {
        this.f2960a = compoundButton;
    }

    public void a() {
        Drawable drawableA = gj.a(this.f2960a);
        if (drawableA != null) {
            if (this.f2961a || this.b) {
                Drawable drawableMutate = kd.r(drawableA).mutate();
                if (this.f2961a) {
                    kd.o(drawableMutate, this.f7466a);
                }
                if (this.b) {
                    kd.p(drawableMutate, this.f2959a);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2960a.getDrawableState());
                }
                this.f2960a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public int b(int i) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = gj.a(this.f2960a)) == null) ? i : i + drawableA.getIntrinsicWidth();
    }

    public ColorStateList c() {
        return this.f7466a;
    }

    public PorterDuff.Mode d() {
        return this.f2959a;
    }

    public void e(AttributeSet attributeSet, int i) {
        boolean z;
        int iN;
        int iN2;
        o8 o8VarV = o8.v(this.f2960a.getContext(), attributeSet, c0.CompoundButton, i, 0);
        CompoundButton compoundButton = this.f2960a;
        eh.i0(compoundButton, compoundButton.getContext(), c0.CompoundButton, attributeSet, o8VarV.r(), i, 0);
        try {
            if (!o8VarV.s(c0.CompoundButton_buttonCompat) || (iN2 = o8VarV.n(c0.CompoundButton_buttonCompat, 0)) == 0) {
                z = false;
            } else {
                try {
                    this.f2960a.setButtonDrawable(r2.d(this.f2960a.getContext(), iN2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z && o8VarV.s(c0.CompoundButton_android_button) && (iN = o8VarV.n(c0.CompoundButton_android_button, 0)) != 0) {
                this.f2960a.setButtonDrawable(r2.d(this.f2960a.getContext(), iN));
            }
            if (o8VarV.s(c0.CompoundButton_buttonTint)) {
                gj.c(this.f2960a, o8VarV.c(c0.CompoundButton_buttonTint));
            }
            if (o8VarV.s(c0.CompoundButton_buttonTintMode)) {
                gj.d(this.f2960a, e7.d(o8VarV.k(c0.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            o8VarV.w();
        }
    }

    public void f() {
        if (this.c) {
            this.c = false;
        } else {
            this.c = true;
            a();
        }
    }

    public void g(ColorStateList colorStateList) {
        this.f7466a = colorStateList;
        this.f2961a = true;
        a();
    }

    public void h(PorterDuff.Mode mode) {
        this.f2959a = mode;
        this.b = true;
        a();
    }
}
