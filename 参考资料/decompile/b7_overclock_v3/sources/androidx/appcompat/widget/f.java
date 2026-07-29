package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class f extends CheckedTextView implements androidx.core.widget.t, androidx.core.view.r0, f0, androidx.core.widget.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f2459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f2460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public l f2461d;

    public f(@g.n0 Context context) {
        this(context, null);
    }

    @g.n0
    private l getEmojiTextViewHelper() {
        if (this.f2461d == null) {
            this.f2461d = new l(this);
        }
        return this.f2461d;
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f2460c;
        if (yVar != null) {
            yVar.b();
        }
        e eVar = this.f2459b;
        if (eVar != null) {
            eVar.b();
        }
        g gVar = this.f2458a;
        if (gVar != null) {
            gVar.a();
        }
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
        e eVar = this.f2459b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2459b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.t
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCheckMarkTintList() {
        g gVar = this.f2458a;
        if (gVar != null) {
            return gVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.t
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        g gVar = this.f2458a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2460c.j();
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2460c.k();
    }

    @Override // android.widget.TextView, android.view.View
    @g.p0
    public InputConnection onCreateInputConnection(@g.n0 EditorInfo editorInfo) {
        return m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2459b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2459b;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@g.p0 Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        g gVar = this.f2458a;
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2460c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelative(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2460c;
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

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2459b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2459b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.t
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintList(@g.p0 ColorStateList colorStateList) {
        g gVar = this.f2458a;
        if (gVar != null) {
            gVar.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.t
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintMode(@g.p0 PorterDuff.Mode mode) {
        g gVar = this.f2458a;
        if (gVar != null) {
            gVar.g(mode);
        }
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@g.p0 ColorStateList colorStateList) {
        this.f2460c.w(colorStateList);
        this.f2460c.b();
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2460c.x(mode);
        this.f2460c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(@g.n0 Context context, int i10) {
        super.setTextAppearance(context, i10);
        y yVar = this.f2460c;
        if (yVar != null) {
            yVar.q(context, i10);
        }
    }

    public f(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public f(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        t0.a(this, getContext());
        y yVar = new y(this);
        this.f2460c = yVar;
        yVar.m(attributeSet, i10);
        yVar.b();
        e eVar = new e(this);
        this.f2459b = eVar;
        eVar.e(attributeSet, i10);
        g gVar = new g(this);
        this.f2458a = gVar;
        gVar.d(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@g.v int i10) {
        setCheckMarkDrawable(i.a.b(getContext(), i10));
    }
}
