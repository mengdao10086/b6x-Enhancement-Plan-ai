package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class r5 extends CheckBox implements pj, qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5 f7271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t5 f2713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v6 f2714a;

    public r5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.checkboxStyle);
    }

    public r5(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        t5 t5Var = new t5(this);
        this.f2713a = t5Var;
        t5Var.e(attributeSet, i);
        p5 p5Var = new p5(this);
        this.f7271a = p5Var;
        p5Var.e(attributeSet, i);
        v6 v6Var = new v6(this);
        this.f2714a = v6Var;
        v6Var.m(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            p5Var.b();
        }
        v6 v6Var = this.f2714a;
        if (v6Var != null) {
            v6Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        t5 t5Var = this.f2713a;
        return t5Var != null ? t5Var.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
    }

    @Override // a.pj
    public ColorStateList getSupportButtonTintList() {
        t5 t5Var = this.f2713a;
        if (t5Var != null) {
            return t5Var.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        t5 t5Var = this.f2713a;
        if (t5Var != null) {
            return t5Var.d();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(r2.d(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        t5 t5Var = this.f2713a;
        if (t5Var != null) {
            t5Var.f();
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f7271a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }

    @Override // a.pj
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        t5 t5Var = this.f2713a;
        if (t5Var != null) {
            t5Var.g(colorStateList);
        }
    }

    @Override // a.pj
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        t5 t5Var = this.f2713a;
        if (t5Var != null) {
            t5Var.h(mode);
        }
    }
}
