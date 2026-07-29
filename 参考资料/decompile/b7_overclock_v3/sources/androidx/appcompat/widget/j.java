package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class j extends EditText implements androidx.core.view.r0, androidx.core.view.m0, f0, androidx.core.widget.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f2536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f2537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.core.widget.s f2538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final k f2539e;

    public j(@g.n0 Context context) {
        this(context, null);
    }

    @Override // androidx.core.view.m0
    @g.p0
    public androidx.core.view.e a(@g.n0 androidx.core.view.e eVar) {
        return this.f2538d.a(this, eVar);
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return this.f2539e.c();
    }

    public void c(k kVar) {
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

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f2535a;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f2536b;
        if (yVar != null) {
            yVar.b();
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
        e eVar = this.f2535a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2535a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2536b.j();
    }

    @Override // androidx.core.widget.v
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2536b.k();
    }

    @Override // android.widget.TextView
    @g.n0
    @g.v0(api = 26)
    public TextClassifier getTextClassifier() {
        x xVar;
        return (Build.VERSION.SDK_INT >= 28 || (xVar = this.f2537c) == null) ? super.getTextClassifier() : xVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    @g.p0
    public InputConnection onCreateInputConnection(@g.n0 EditorInfo editorInfo) {
        String[] strArrH0;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2536b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = m.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrH0 = androidx.core.view.u0.h0(this)) != null) {
            c1.a.h(editorInfo, strArrH0);
            inputConnectionA = c1.c.d(this, inputConnectionA, editorInfo);
        }
        return this.f2539e.e(inputConnectionA, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (u.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i10) {
        if (u.b(this, i10)) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2535a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2535a;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2536b;
        if (yVar != null) {
            yVar.p();
        }
    }

    @Override // android.widget.TextView
    @g.v0(17)
    public void setCompoundDrawablesRelative(@g.p0 Drawable drawable, @g.p0 Drawable drawable2, @g.p0 Drawable drawable3, @g.p0 Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f2536b;
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
        this.f2539e.f(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@g.p0 KeyListener keyListener) {
        super.setKeyListener(this.f2539e.a(keyListener));
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2535a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2535a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@g.p0 ColorStateList colorStateList) {
        this.f2536b.w(colorStateList);
        this.f2536b.b();
    }

    @Override // androidx.core.widget.v
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@g.p0 PorterDuff.Mode mode) {
        this.f2536b.x(mode);
        this.f2536b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        y yVar = this.f2536b;
        if (yVar != null) {
            yVar.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    @g.v0(api = 26)
    public void setTextClassifier(@g.p0 TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f2537c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.b(textClassifier);
        }
    }

    public j(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @g.p0
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public j(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f2535a = eVar;
        eVar.e(attributeSet, i10);
        y yVar = new y(this);
        this.f2536b = yVar;
        yVar.m(attributeSet, i10);
        yVar.b();
        this.f2537c = new x(this);
        this.f2538d = new androidx.core.widget.s();
        k kVar = new k(this);
        this.f2539e = kVar;
        kVar.d(attributeSet, i10);
        c(kVar);
    }
}
