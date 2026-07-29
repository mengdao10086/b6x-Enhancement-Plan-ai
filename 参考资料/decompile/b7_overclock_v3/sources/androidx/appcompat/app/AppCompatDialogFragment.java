package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;
import g.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment
    @n0
    public Dialog P5(@p0 Bundle bundle) {
        return new j(X1(), N5());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void X5(@n0 Dialog dialog, int i10) {
        if (!(dialog instanceof j)) {
            super.X5(dialog, i10);
            return;
        }
        j jVar = (j) dialog;
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        jVar.k(1);
    }

    public AppCompatDialogFragment(@i0 int i10) {
        super(i10);
    }
}
