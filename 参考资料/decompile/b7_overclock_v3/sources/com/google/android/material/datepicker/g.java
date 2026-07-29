package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.b0;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g<S> {
    public static /* synthetic */ void a(EditText[] editTextArr, View view, boolean z10) {
        for (EditText editText : editTextArr) {
            if (editText.hasFocus()) {
                return;
            }
        }
        b0.k(view);
    }

    public static void b(@n0 final EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.datepicker.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                g.a(editTextArr, view, z10);
            }
        };
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
        b0.q(editTextArr[0]);
    }
}
