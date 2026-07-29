package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class s extends RadioButton implements androidx.core.widget.u, androidx.core.view.r0, f0, androidx.core.widget.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f2676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f2677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f2678d;

    public s(Context context) {
        this(context, null);
    }

    @g.n0
    private l getEmojiTextViewHelper() {
        if (this.f2678d == null) {
            this.f2678d = new l(this);
        }
        return this.f2678d;
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f2676b;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f2677c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        h hVar = this.f2675a;
        return hVar != null ? hVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f2676b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2676b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.u
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportButtonTintList() {
        h hVar = this.f2675a;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.u
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportButtonTintMode() {
        h hVar = this.f2675a;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2677c.j();
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2677c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2676b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2676b;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        h hVar = this.f2675a;
        if (hVar != null) {
            hVar.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2677c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelative(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2677c;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(@g.n0 InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2676b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2676b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.u
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintList(@g.p0 ColorStateList colorStateList) {
        h hVar = this.f2675a;
        if (hVar != null) {
            hVar.g(colorStateList);
        }
    }

    @Override // androidx.core.widget.u
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintMode(@g.p0 PorterDuff.Mode mode) {
        h hVar = this.f2675a;
        if (hVar != null) {
            hVar.h(mode);
        }
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@g.p0 ColorStateList colorStateList) {
        this.f2677c.w(colorStateList);
        this.f2677c.b();
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2677c.x(mode);
        this.f2677c.b();
    }

    public s(Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public s(Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        t0.a(this, getContext());
        h hVar = new h(this);
        this.f2675a = hVar;
        hVar.e(attributeSet, i10);
        e eVar = new e(this);
        this.f2676b = eVar;
        eVar.e(attributeSet, i10);
        y yVar = new y(this);
        this.f2677c = yVar;
        yVar.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@g.v int i10) {
        setButtonDrawable(i.a.b(getContext(), i10));
    }
}
