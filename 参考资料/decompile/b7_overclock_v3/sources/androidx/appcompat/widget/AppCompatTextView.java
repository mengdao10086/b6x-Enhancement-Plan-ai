package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import y0.g;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatTextView extends TextView implements androidx.core.view.r0, androidx.core.widget.v, androidx.core.widget.b, f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f2176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f2177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public l f2178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.p0
    public Future<y0.g> f2180f;

    public AppCompatTextView(@g.n0 Context context) {
        this(context, null);
    }

    @g.n0
    private l getEmojiTextViewHelper() {
        if (this.f2178d == null) {
            this.f2178d = new l(this);
        }
        return this.f2178d;
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f2175a;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f2176b;
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
        y yVar = this.f2176b;
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
        y yVar = this.f2176b;
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
        y yVar = this.f2176b;
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
        y yVar = this.f2176b;
        return yVar != null ? yVar.h() : new int[0];
    }

    @Override // android.widget.TextView, androidx.core.widget.b
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.O) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f2176b;
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.r.i(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.r.j(this);
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f2175a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2175a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2176b.j();
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2176b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        i();
        return super.getText();
    }

    @Override // android.widget.TextView
    @g.n0
    @g.v0(api = 26)
    public TextClassifier getTextClassifier() {
        x xVar;
        return (Build.VERSION.SDK_INT >= 28 || (xVar = this.f2177c) == null) ? super.getTextClassifier() : xVar.a();
    }

    @g.n0
    public g.a getTextMetricsParamsCompat() {
        return androidx.core.widget.r.o(this);
    }

    public final void i() {
        Future<y0.g> future = this.f2180f;
        if (future != null) {
            try {
                this.f2180f = null;
                androidx.core.widget.r.D(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2176b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return m.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        i();
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        y yVar = this.f2176b;
        if (yVar == null || androidx.core.widget.b.O || !yVar.l()) {
            return;
        }
        this.f2176b.c();
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
        y yVar = this.f2176b;
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
        y yVar = this.f2176b;
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
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2175a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2175a;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelative(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.p();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@g.t0 @g.f0(from = 0) int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i10);
        } else {
            androidx.core.widget.r.A(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@g.t0 @g.f0(from = 0) int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i10);
        } else {
            androidx.core.widget.r.B(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(@g.t0 @g.f0(from = 0) int i10) {
        androidx.core.widget.r.C(this, i10);
    }

    public void setPrecomputedText(@g.n0 y0.g gVar) {
        androidx.core.widget.r.D(this, gVar);
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2175a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2175a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@g.p0 ColorStateList colorStateList) {
        this.f2176b.w(colorStateList);
        this.f2176b.b();
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2176b.x(mode);
        this.f2176b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    @g.v0(api = 26)
    public void setTextClassifier(@g.p0 TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f2177c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.b(textClassifier);
        }
    }

    public void setTextFuture(@g.p0 Future<y0.g> future) {
        this.f2180f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@g.n0 g.a aVar) {
        androidx.core.widget.r.F(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (androidx.core.widget.b.O) {
            super.setTextSize(i10, f10);
            return;
        }
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.A(i10, f10);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@g.p0 Typeface typeface, int i10) {
        if (this.f2179e) {
            return;
        }
        Typeface typefaceB = null;
        if (typeface != null && i10 > 0) {
            typefaceB = m0.w.b(getContext(), typeface, i10);
        }
        this.f2179e = true;
        if (typefaceB != null) {
            typeface = typefaceB;
        }
        try {
            super.setTypeface(typeface, i10);
        } finally {
            this.f2179e = false;
        }
    }

    public AppCompatTextView(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        this.f2179e = false;
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f2175a = eVar;
        eVar.e(attributeSet, i10);
        y yVar = new y(this);
        this.f2176b = yVar;
        yVar.m(attributeSet, i10);
        yVar.b();
        this.f2177c = new x(this);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i10 != 0 ? i.a.b(context, i10) : null, i11 != 0 ? i.a.b(context, i11) : null, i12 != 0 ? i.a.b(context, i12) : null, i13 != 0 ? i.a.b(context, i13) : null);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i10 != 0 ? i.a.b(context, i10) : null, i11 != 0 ? i.a.b(context, i11) : null, i12 != 0 ? i.a.b(context, i12) : null, i13 != 0 ? i.a.b(context, i13) : null);
        y yVar = this.f2176b;
        if (yVar != null) {
            yVar.p();
        }
    }
}
