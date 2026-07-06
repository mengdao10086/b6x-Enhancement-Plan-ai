package a;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w6 extends TextView implements qg, qj, fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5 f7759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t6 f3398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v6 f3399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Future<xe> f3400a;

    public w6(Context context) {
        this(context, null);
    }

    public w6(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public w6(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        p5 p5Var = new p5(this);
        this.f7759a = p5Var;
        p5Var.e(attributeSet, i);
        v6 v6Var = new v6(this);
        this.f3399a = v6Var;
        v6Var.m(attributeSet, i);
        this.f3399a.b();
        this.f3398a = new t6(this);
    }

    public final void d() {
        Future<xe> future = this.f3400a;
        if (future != null) {
            try {
                this.f3400a = null;
                oj.p(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            p5Var.b();
        }
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (fj.f6112a) {
            return super.getAutoSizeMaxTextSize();
        }
        v6 v6Var = this.f3399a;
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
        v6 v6Var = this.f3399a;
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
        v6 v6Var = this.f3399a;
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
        v6 v6Var = this.f3399a;
        return v6Var != null ? v6Var.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (fj.f6112a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            return v6Var.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return oj.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return oj.c(this);
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3399a.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3399a.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        d();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        t6 t6Var;
        return (Build.VERSION.SDK_INT >= 28 || (t6Var = this.f3398a) == null) ? super.getTextClassifier() : t6Var.a();
    }

    public we getTextMetricsParamsCompat() {
        return oj.g(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        x5.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.o(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        d();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        v6 v6Var = this.f3399a;
        if (v6Var == null || fj.f6112a || !v6Var.l()) {
            return;
        }
        this.f3399a.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (fj.f6112a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        v6 v6Var = this.f3399a;
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
        v6 v6Var = this.f3399a;
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
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.u(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? r2.d(context, i) : null, i2 != 0 ? r2.d(context, i2) : null, i3 != 0 ? r2.d(context, i3) : null, i4 != 0 ? r2.d(context, i4) : null);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? r2.d(context, i) : null, i2 != 0 ? r2.d(context, i2) : null, i3 != 0 ? r2.d(context, i3) : null, i4 != 0 ? r2.d(context, i4) : null);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(oj.s(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            oj.m(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            oj.n(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        oj.o(this, i);
    }

    public void setPrecomputedText(xe xeVar) {
        oj.p(this, xeVar);
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f7759a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }

    @Override // a.qj
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3399a.v(colorStateList);
        this.f3399a.b();
    }

    @Override // a.qj
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3399a.w(mode);
        this.f3399a.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.q(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        t6 t6Var;
        if (Build.VERSION.SDK_INT >= 28 || (t6Var = this.f3398a) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            t6Var.b(textClassifier);
        }
    }

    public void setTextFuture(Future<xe> future) {
        this.f3400a = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(we weVar) {
        oj.r(this, weVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (fj.f6112a) {
            super.setTextSize(i, f);
            return;
        }
        v6 v6Var = this.f3399a;
        if (v6Var != null) {
            v6Var.z(i, f);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface typefaceA = (typeface == null || i <= 0) ? null : zc.a(getContext(), typeface, i);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        super.setTypeface(typeface, i);
    }
}
