package a;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s5 extends CheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f7363a = {R.attr.checkMark};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v6 f2838a;

    public s5(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public s5(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        v6 v6Var = new v6(this);
        this.f2838a = v6Var;
        v6Var.m(attributeSet, i);
        this.f2838a.b();
        o8 o8VarV = o8.v(getContext(), attributeSet, f7363a, i, 0);
        setCheckMarkDrawable(o8VarV.g(0));
        o8VarV.w();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v6 v6Var = this.f2838a;
        if (v6Var != null) {
            v6Var.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        x5.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(r2.d(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(oj.s(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v6 v6Var = this.f2838a;
        if (v6Var != null) {
            v6Var.q(context, i);
        }
    }
}
