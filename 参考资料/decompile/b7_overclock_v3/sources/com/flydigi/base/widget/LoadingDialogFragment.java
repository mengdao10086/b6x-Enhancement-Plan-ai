package com.flydigi.base.widget;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import g.n0;
import g.p0;
import p5.r;

/* JADX INFO: loaded from: classes2.dex */
public class LoadingDialogFragment extends DialogFragment {
    public static final String E8 = "notice";
    public static final String F8 = "key_cancelable";
    public r D8;

    public static LoadingDialogFragment b6(String str) {
        return c6(str, true);
    }

    public static LoadingDialogFragment c6(String str, boolean z10) {
        LoadingDialogFragment loadingDialogFragment = new LoadingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(E8, str);
        bundle.putBoolean(F8, z10);
        loadingDialogFragment.c5(bundle);
        return loadingDialogFragment;
    }

    @Override // androidx.fragment.app.DialogFragment
    @n0
    public Dialog P5(@p0 Bundle bundle) {
        String string;
        boolean z10;
        Bundle bundleT1 = T1();
        if (bundleT1 != null) {
            string = bundleT1.getString(E8);
            z10 = bundleT1.getBoolean(F8, true);
        } else {
            string = "";
            z10 = false;
        }
        U5(z10);
        r rVarA = r.A(X1(), string);
        this.D8 = rVarA;
        return rVarA;
    }

    public void d6(String str) {
        r rVar = this.D8;
        if (rVar != null) {
            rVar.B(str);
        }
    }
}
