package com.permissionx.guolindev.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RationaleDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (bundle != null) {
            H5();
        }
    }

    @p0
    public abstract View b6();

    @n0
    public abstract List<String> c6();

    @n0
    public abstract View d6();
}
