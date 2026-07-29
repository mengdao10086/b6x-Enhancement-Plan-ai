package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputEditText extends androidx.appcompat.widget.j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f20863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20864g;

    public TextInputEditText(@n0 Context context) {
        this(context, null);
    }

    @p0
    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    @p0
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @n0
    public final String d(@n0 TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z10 = !TextUtils.isEmpty(text);
        String str = "";
        String string = TextUtils.isEmpty(hint) ^ true ? hint.toString() : "";
        if (!z10) {
            return !TextUtils.isEmpty(string) ? string : "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) text);
        if (!TextUtils.isEmpty(string)) {
            str = ", " + string;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public boolean e() {
        return this.f20864g;
    }

    public final boolean f(@p0 TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f20864g;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@p0 Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!f(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f20863f);
        rect.bottom = this.f20863f.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@p0 Rect rect, @p0 Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        return f(textInputLayout) ? textInputLayout.getGlobalVisibleRect(rect, point) : super.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    @p0
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.a0()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.a0() && super.getHint() == null && com.google.android.material.internal.i.c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.j, android.widget.TextView, android.view.View
    @p0
    public InputConnection onCreateInputConnection(@n0 EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        accessibilityNodeInfo.setText(d(textInputLayout));
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@p0 Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!f(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f20863f.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f20863f);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z10) {
        this.f20864g = z10;
    }

    public TextInputEditText(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public TextInputEditText(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(pe.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f20863f = new Rect();
        TypedArray typedArrayK = com.google.android.material.internal.t.k(context, attributeSet, R.styleable.TextInputEditText, i10, R.style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayK.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayK.recycle();
    }
}
