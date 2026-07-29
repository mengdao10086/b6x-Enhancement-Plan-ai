package com.flydigi.base.widget;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.e;
import androidx.fragment.app.DialogFragment;
import com.blankj.utilcode.util.KeyboardUtils;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class EditTextDialog extends DialogFragment {
    public static final String F8 = "title";
    public static final String G8 = "hint";
    public static final String H8 = "submit_text";
    public EditText D8;
    public a E8;

    public interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d6(View view) {
        a aVar;
        if (TextUtils.isEmpty(this.D8.getText().toString()) || (aVar = this.E8) == null) {
            return;
        }
        aVar.a(this.D8.getText().toString());
        H5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e6(View view) {
        H5();
    }

    public static EditTextDialog f6(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString(G8, str2);
        bundle.putString(H8, str3);
        EditTextDialog editTextDialog = new EditTextDialog();
        editTextDialog.c5(bundle);
        return editTextDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    @n0
    public Dialog P5(@p0 Bundle bundle) {
        e.a aVar = new e.a(X1());
        View viewInflate = View.inflate(X1(), R.layout.base_layout_edittext_dialog, null);
        aVar.setView(viewInflate);
        e eVarCreate = aVar.create();
        if (eVarCreate.getWindow() != null) {
            eVarCreate.getWindow().setBackgroundDrawable(new ColorDrawable(V2().getColor(R.color.color_black_trans)));
        }
        this.D8 = (EditText) viewInflate.findViewById(R.id.et_text);
        Button button = (Button) viewInflate.findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() { // from class: p5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46419a.d6(view);
            }
        });
        viewInflate.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() { // from class: p5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46420a.e6(view);
            }
        });
        if (T1() != null) {
            String string = T1().getString("title");
            String string2 = T1().getString(G8);
            String string3 = T1().getString(H8);
            ((TextView) viewInflate.findViewById(R.id.tv_title)).setText(string);
            button.setText(string3);
            this.D8.setHint(string2);
        }
        return eVarCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        this.D8.requestFocus();
        KeyboardUtils.s(this.D8);
    }

    public void g6(a aVar) {
        this.E8 = aVar;
    }
}
