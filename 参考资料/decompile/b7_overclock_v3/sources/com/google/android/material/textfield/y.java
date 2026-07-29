package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import g.c1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class y extends s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public EditText f21045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f21046g;

    public y(@n0 r rVar, @g.v int i10) {
        super(rVar);
        this.f21044e = R.drawable.design_password_eye;
        this.f21046g = new View.OnClickListener() { // from class: com.google.android.material.textfield.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21043a.y(view);
            }
        };
        if (i10 != 0) {
            this.f21044e = i10;
        }
    }

    public static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f21045f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (w()) {
            this.f21045f.setTransformationMethod(null);
        } else {
            this.f21045f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            this.f21045f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
        r();
    }

    @Override // com.google.android.material.textfield.s
    @c1
    public int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.s
    @g.v
    public int d() {
        return this.f21044e;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f21046g;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return !w();
    }

    @Override // com.google.android.material.textfield.s
    public void n(@p0 EditText editText) {
        this.f21045f = editText;
        r();
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        if (x(this.f21045f)) {
            this.f21045f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f21045f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f21045f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
