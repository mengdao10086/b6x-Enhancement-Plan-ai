package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q5 extends Button implements qg, fj, qj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5 f7179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v6 f2547a;

    public q5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.buttonStyle);
    }

    public q5(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        p5 p5Var = new p5(this);
        this.f7179a = p5Var;
        p5Var.e(attributeSet, i);
        v6 v6Var = new v6(this);
        this.f2547a = v6Var;
        v6Var.m(attributeSet, i);
        this.f2547a.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            p5Var.b();
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (fj.f6112a) {
            return super.getAutoSizeMaxTextSize();
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            return v6Var.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (fj.f6112a) {
            return super.getAutoSizeMinTextSize();
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            return v6Var.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (fj.f6112a) {
            return super.getAutoSizeStepGranularity();
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            return v6Var.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (fj.f6112a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        v6 v6Var = this.f2547a;
        return v6Var != null ? v6Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (fj.f6112a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            return v6Var.i();
        }
        return 0;
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2547a.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2547a.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.o(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        v6 v6Var = this.f2547a;
        if (v6Var == null || fj.f6112a || !v6Var.l()) {
            return;
        }
        this.f2547a.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (fj.f6112a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.s(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (fj.f6112a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.t(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (fj.f6112a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.u(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(oj.s(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.r(z);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f7179a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }

    @Override // a.qj
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2547a.v(colorStateList);
        this.f2547a.b();
    }

    @Override // a.qj
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2547a.w(mode);
        this.f2547a.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.q(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (fj.f6112a) {
            super.setTextSize(i, f);
            return;
        }
        v6 v6Var = this.f2547a;
        if (v6Var != null) {
            v6Var.z(i, f);
        }
    }
}
