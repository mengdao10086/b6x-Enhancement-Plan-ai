package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatButton extends Button implements androidx.core.view.r0, androidx.core.widget.b, androidx.core.widget.v, f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f2137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public l f2138c;

    public AppCompatButton(@g.n0 Context context) {
        this(context, null);
    }

    @g.n0
    private l getEmojiTextViewHelper() {
        if (this.f2138c == null) {
            this.f2138c = new l(this);
        }
        return this.f2138c;
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f2136a;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.O) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            return yVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.O) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            return yVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.O) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            return yVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.O) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f2137b;
        return yVar != null ? yVar.h() : new int[0];
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.O) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            return yVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    @g.p0
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.r.G(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f2136a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2136a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2137b.j();
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2137b.k();
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
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        y yVar = this.f2137b;
        if (yVar == null || androidx.core.widget.b.O || !yVar.l()) {
            return;
        }
        this.f2137b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (androidx.core.widget.b.O) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@g.n0 int[] iArr, int i10) throws IllegalArgumentException {
        if (androidx.core.widget.b.O) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.u(iArr, i10);
        }
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (androidx.core.widget.b.O) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2136a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2136a;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@g.p0 ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.r.H(this, callback));
    }

    @Override // androidx.appcompat.widget.f0
    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(@g.n0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.s(z10);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2136a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2136a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@g.p0 ColorStateList colorStateList) {
        this.f2137b.w(colorStateList);
        this.f2137b.b();
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2137b.x(mode);
        this.f2137b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (androidx.core.widget.b.O) {
            super.setTextSize(i10, f10);
            return;
        }
        y yVar = this.f2137b;
        if (yVar != null) {
            yVar.A(i10, f10);
        }
    }

    public AppCompatButton(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f2136a = eVar;
        eVar.e(attributeSet, i10);
        y yVar = new y(this);
        this.f2137b = yVar;
        yVar.m(attributeSet, i10);
        yVar.b();
        getEmojiTextViewHelper().c(attributeSet, i10);
    }
}
