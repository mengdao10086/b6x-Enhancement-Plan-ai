package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final CheckedTextView f2470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f2471b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2472c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2473d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2474e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2475f;

    public g(@g.n0 CheckedTextView checkedTextView) {
        this.f2470a = checkedTextView;
    }

    public void a() {
        Drawable drawableA = androidx.core.widget.c.a(this.f2470a);
        if (drawableA != null) {
            if (this.f2473d || this.f2474e) {
                Drawable drawableMutate = n0.c.r(drawableA).mutate();
                if (this.f2473d) {
                    n0.c.o(drawableMutate, this.f2471b);
                }
                if (this.f2474e) {
                    n0.c.p(drawableMutate, this.f2472c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2470a.getDrawableState());
                }
                this.f2470a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList b() {
        return this.f2471b;
    }

    public PorterDuff.Mode c() {
        return this.f2472c;
    }

    public void d(@g.p0 AttributeSet attributeSet, int i10) {
        boolean z10;
        int iU;
        int iU2;
        Context context = this.f2470a.getContext();
        int[] iArr = R.styleable.CheckedTextView;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        CheckedTextView checkedTextView = this.f2470a;
        androidx.core.view.u0.z1(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, y0VarG.B(), i10, 0);
        try {
            int i11 = R.styleable.CheckedTextView_checkMarkCompat;
            if (!y0VarG.C(i11) || (iU2 = y0VarG.u(i11, 0)) == 0) {
                z10 = false;
            } else {
                try {
                    CheckedTextView checkedTextView2 = this.f2470a;
                    checkedTextView2.setCheckMarkDrawable(i.a.b(checkedTextView2.getContext(), iU2));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                    z10 = false;
                }
            }
            if (!z10) {
                int i12 = R.styleable.CheckedTextView_android_checkMark;
                if (y0VarG.C(i12) && (iU = y0VarG.u(i12, 0)) != 0) {
                    CheckedTextView checkedTextView3 = this.f2470a;
                    checkedTextView3.setCheckMarkDrawable(i.a.b(checkedTextView3.getContext(), iU));
                }
            }
            int i13 = R.styleable.CheckedTextView_checkMarkTint;
            if (y0VarG.C(i13)) {
                androidx.core.widget.c.d(this.f2470a, y0VarG.d(i13));
            }
            int i14 = R.styleable.CheckedTextView_checkMarkTintMode;
            if (y0VarG.C(i14)) {
                androidx.core.widget.c.e(this.f2470a, d0.e(y0VarG.o(i14, -1), null));
            }
        } finally {
            y0VarG.I();
        }
    }

    public void e() {
        if (this.f2475f) {
            this.f2475f = false;
        } else {
            this.f2475f = true;
            a();
        }
    }

    public void f(ColorStateList colorStateList) {
        this.f2471b = colorStateList;
        this.f2473d = true;
        a();
    }

    public void g(@g.p0 PorterDuff.Mode mode) {
        this.f2472c = mode;
        this.f2474e = true;
        a();
    }
}
