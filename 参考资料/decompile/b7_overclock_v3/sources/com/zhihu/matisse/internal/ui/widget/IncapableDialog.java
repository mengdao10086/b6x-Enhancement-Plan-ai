package com.zhihu.matisse.internal.ui.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.e;
import androidx.fragment.app.DialogFragment;
import com.zhihu.matisse.R;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public class IncapableDialog extends DialogFragment {
    public static final String D8 = "extra_title";
    public static final String E8 = "extra_message";

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    public static IncapableDialog b6(String str, String str2) {
        IncapableDialog incapableDialog = new IncapableDialog();
        Bundle bundle = new Bundle();
        bundle.putString(D8, str);
        bundle.putString(E8, str2);
        incapableDialog.c5(bundle);
        return incapableDialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    @n0
    public Dialog P5(Bundle bundle) {
        String string = T1().getString(D8);
        String string2 = T1().getString(E8);
        e.a aVar = new e.a(w1());
        if (!TextUtils.isEmpty(string)) {
            aVar.setTitle(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            aVar.l(string2);
        }
        aVar.setPositiveButton(R.string.button_ok, new a());
        return aVar.create();
    }
}
