package com.flydigi.base.common;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.g0;
import com.blankj.utilcode.util.d0;
import com.flydigi.base.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import g.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseBottomSheetFragment extends BottomSheetDialogFragment {
    public BottomSheetBehavior<FrameLayout> E8;
    public View F8;
    public final BottomSheetBehavior.f G8 = new a();

    public class a extends BottomSheetBehavior.f {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(@n0 View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(@n0 View view, int i10) {
            if (i10 == 5) {
                d0.c0(BaseBottomSheetFragment.this);
                BaseBottomSheetFragment.this.i6();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j6(FrameLayout frameLayout) {
        ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.g) frameLayout.getLayoutParams())).height = this.F8.getHeight();
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        return layoutInflater.inflate(h6(), viewGroup, false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @n0
    public Dialog P5(Bundle bundle) {
        return X1() == null ? super.P5(bundle) : new com.google.android.material.bottomsheet.a(X1(), R.style.TransparentBottomSheetStyle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void Z5(@n0 FragmentManager fragmentManager, @p0 String str) {
        try {
            g0 g0VarU = fragmentManager.u();
            g0VarU.k(this, str);
            g0VarU.r();
        } catch (IllegalStateException unused) {
        }
    }

    public BottomSheetBehavior<FrameLayout> g6() {
        return this.E8;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void h4() {
        super.h4();
        L5().getWindow().setSoftInputMode(2);
        final FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) L5()).g().n(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.post(new Runnable() { // from class: com.flydigi.base.common.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13344a.j6(frameLayout);
                }
            });
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorI0 = BottomSheetBehavior.i0(frameLayout);
            this.E8 = bottomSheetBehaviorI0;
            bottomSheetBehaviorI0.Y0(3);
            this.E8.Y(this.G8);
        }
    }

    @i0
    public abstract int h6();

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
        this.E8.E0(this.G8);
    }

    public abstract void i6();

    @Override // androidx.fragment.app.Fragment
    public void j4(@n0 View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        this.F8 = view;
    }
}
