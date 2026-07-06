package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w5 extends EditText implements qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5 f7757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final t6 f3393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v6 f3394a;

    public w5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.editTextStyle);
    }

    public w5(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        p5 p5Var = new p5(this);
        this.f7757a = p5Var;
        p5Var.e(attributeSet, i);
        v6 v6Var = new v6(this);
        this.f3394a = v6Var;
        v6Var.m(attributeSet, i);
        this.f3394a.b();
        this.f3393a = new t6(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            p5Var.b();
        }
        v6 v6Var = this.f3394a;
        if (v6Var != null) {
            v6Var.b();
        }
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        t6 t6Var;
        return (Build.VERSION.SDK_INT >= 28 || (t6Var = this.f3393a) == null) ? super.getTextClassifier() : t6Var.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        x5.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(oj.s(this, callback));
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f7757a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v6 v6Var = this.f3394a;
        if (v6Var != null) {
            v6Var.q(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        t6 t6Var;
        if (Build.VERSION.SDK_INT >= 28 || (t6Var = this.f3393a) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            t6Var.b(textClassifier);
        }
    }
}
