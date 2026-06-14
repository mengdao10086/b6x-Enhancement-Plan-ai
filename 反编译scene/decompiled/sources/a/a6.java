package a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a6 extends MultiAutoCompleteTextView implements qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f5572a = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p5 f32a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v6 f33a;

    public a6(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t.autoCompleteTextViewStyle);
    }

    public a6(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        o8 o8VarV = o8.v(getContext(), attributeSet, f5572a, i, 0);
        if (o8VarV.s(0)) {
            setDropDownBackgroundDrawable(o8VarV.g(0));
        }
        o8VarV.w();
        p5 p5Var = new p5(this);
        this.f32a = p5Var;
        p5Var.e(attributeSet, i);
        v6 v6Var = new v6(this);
        this.f33a = v6Var;
        v6Var.m(attributeSet, i);
        this.f33a.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            p5Var.b();
        }
        v6 v6Var = this.f33a;
        if (v6Var != null) {
            v6Var.b();
        }
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
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
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(r2.d(getContext(), i));
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f32a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v6 v6Var = this.f33a;
        if (v6Var != null) {
            v6Var.q(context, i);
        }
    }
}
