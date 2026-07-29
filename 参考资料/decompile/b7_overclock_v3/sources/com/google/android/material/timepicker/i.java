package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes7.dex */
public class i implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChipTextInputComboView f21138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChipTextInputComboView f21139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeModel f21140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21141d = false;

    public i(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f21138a = chipTextInputComboView;
        this.f21139b = chipTextInputComboView2;
        this.f21140c = timeModel;
    }

    public void a() {
        TextInputLayout textInputLayoutE = this.f21138a.e();
        TextInputLayout textInputLayoutE2 = this.f21139b.e();
        EditText editText = textInputLayoutE.getEditText();
        EditText editText2 = textInputLayoutE2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public final void b(int i10) {
        this.f21139b.setChecked(i10 == 12);
        this.f21138a.setChecked(i10 == 10);
        this.f21140c.f21113f = i10;
    }

    public final boolean c(int i10, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (!(i10 >= 7 && i10 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2)) {
            return false;
        }
        b(12);
        return true;
    }

    public final boolean d(int i10, KeyEvent keyEvent, EditText editText) {
        if (!(i10 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText()))) {
            return false;
        }
        b(10);
        return true;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        boolean z10 = i10 == 5;
        if (z10) {
            b(12);
        }
        return z10;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (this.f21141d) {
            return false;
        }
        this.f21141d = true;
        EditText editText = (EditText) view;
        boolean zD = this.f21140c.f21113f == 12 ? d(i10, keyEvent, editText) : c(i10, keyEvent, editText);
        this.f21141d = false;
        return zD;
    }
}
