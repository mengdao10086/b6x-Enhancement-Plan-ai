package com.google.android.material.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public boolean D8;

    public class b extends BottomSheetBehavior.f {
        public b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@n0 View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@n0 View view, int i10) {
            if (i10 == 5) {
                BottomSheetDialogFragment.this.c6();
            }
        }
    }

    public BottomSheetDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public void H5() {
        if (e6(false)) {
            return;
        }
        super.H5();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void I5() {
        if (e6(true)) {
            return;
        }
        super.I5();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @n0
    public Dialog P5(@p0 Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(X1(), N5());
    }

    public final void c6() {
        if (this.D8) {
            super.I5();
        } else {
            super.H5();
        }
    }

    public final void d6(@n0 BottomSheetBehavior<?> bottomSheetBehavior, boolean z10) {
        this.D8 = z10;
        if (bottomSheetBehavior.v0() == 5) {
            c6();
            return;
        }
        if (L5() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) L5()).u();
        }
        bottomSheetBehavior.Y(new b());
        bottomSheetBehavior.Y0(5);
    }

    public final boolean e6(boolean z10) {
        Dialog dialogL5 = L5();
        if (!(dialogL5 instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogL5;
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorQ = aVar.q();
        if (!bottomSheetBehaviorQ.B0() || !aVar.r()) {
            return false;
        }
        d6(bottomSheetBehaviorQ, z10);
        return true;
    }

    @SuppressLint({"ValidFragment"})
    public BottomSheetDialogFragment(@i0 int i10) {
        super(i10);
    }
}
