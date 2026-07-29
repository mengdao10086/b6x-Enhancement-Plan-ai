package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
public class p extends MultiAutoCompleteTextView implements androidx.core.view.r0, f0, androidx.core.widget.v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f2619d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f2621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final k f2622c;

    public p(@g.n0 Context context) {
        this(context, null);
    }

    public void a(k kVar) {
        KeyListener keyListener = getKeyListener();
        if (kVar.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = kVar.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return this.f2622c.c();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f2620a;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f2621b;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f2620a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2620a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2621b.j();
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2621b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f2622c.e(m.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2620a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2620a;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2621b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelative(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2621b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@g.v int i10) {
        setDropDownBackgroundDrawable(i.a.b(getContext(), i10));
    }

    @Override // androidx.appcompat.widget.f0
    public void setEmojiCompatEnabled(boolean z10) {
        this.f2622c.f(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@g.p0 KeyListener keyListener) {
        super.setKeyListener(this.f2622c.a(keyListener));
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2620a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2620a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@g.p0 ColorStateList colorStateList) {
        this.f2621b.w(colorStateList);
        this.f2621b.b();
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2621b.x(mode);
        this.f2621b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        y yVar = this.f2621b;
        if (yVar != null) {
            yVar.q(context, i10);
        }
    }

    public p(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public p(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        t0.a(this, getContext());
        y0 y0VarG = y0.G(getContext(), attributeSet, f2619d, i10, 0);
        if (y0VarG.C(0)) {
            setDropDownBackgroundDrawable(y0VarG.h(0));
        }
        y0VarG.I();
        e eVar = new e(this);
        this.f2620a = eVar;
        eVar.e(attributeSet, i10);
        y yVar = new y(this);
        this.f2621b = yVar;
        yVar.m(attributeSet, i10);
        yVar.b();
        k kVar = new k(this);
        this.f2622c = kVar;
        kVar.d(attributeSet, i10);
        a(kVar);
    }
}
