package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import g.d1;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final String A8 = "android:showsDialog";
    public static final String B8 = "android:backStackId";
    public static final String C8 = "android:dialogShowing";

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final int f5609s8 = 0;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final int f5610t8 = 1;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final int f5611u8 = 2;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final int f5612v8 = 3;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final String f5613w8 = "android:savedDialogState";

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final String f5614x8 = "android:style";

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final String f5615y8 = "android:theme";

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final String f5616z8 = "android:cancelable";

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public Handler f5617c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public Runnable f5618d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public DialogInterface.OnCancelListener f5619e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public DialogInterface.OnDismissListener f5620f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public int f5621g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public int f5622h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public boolean f5623i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public boolean f5624j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public int f5625k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public boolean f5626l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public androidx.lifecycle.k0<androidx.lifecycle.y> f5627m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    @p0
    public Dialog f5628n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f5629o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f5630p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f5631q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f5632r8;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogFragment.this.f5620f8.onDismiss(DialogFragment.this.f5628n8);
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(@p0 DialogInterface dialogInterface) {
            if (DialogFragment.this.f5628n8 != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.f5628n8);
            }
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@p0 DialogInterface dialogInterface) {
            if (DialogFragment.this.f5628n8 != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.f5628n8);
            }
        }
    }

    public class d implements androidx.lifecycle.k0<androidx.lifecycle.y> {
        public d() {
        }

        @Override // androidx.lifecycle.k0
        @SuppressLint({"SyntheticAccessor"})
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(androidx.lifecycle.y yVar) {
            if (yVar == null || !DialogFragment.this.f5624j8) {
                return;
            }
            View viewV4 = DialogFragment.this.V4();
            if (viewV4.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogFragment.this.f5628n8 != null) {
                if (FragmentManager.W0(3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("DialogFragment ");
                    sb2.append(this);
                    sb2.append(" setting the content view on ");
                    sb2.append(DialogFragment.this.f5628n8);
                }
                DialogFragment.this.f5628n8.setContentView(viewV4);
            }
        }
    }

    public class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f5637a;

        public e(i iVar) {
            this.f5637a = iVar;
        }

        @Override // androidx.fragment.app.i
        @p0
        public View c(int i10) {
            return this.f5637a.d() ? this.f5637a.c(i10) : DialogFragment.this.Q5(i10);
        }

        @Override // androidx.fragment.app.i
        public boolean d() {
            return this.f5637a.d() || DialogFragment.this.R5();
        }
    }

    public DialogFragment() {
        this.f5618d8 = new a();
        this.f5619e8 = new b();
        this.f5620f8 = new c();
        this.f5621g8 = 0;
        this.f5622h8 = 0;
        this.f5623i8 = true;
        this.f5624j8 = true;
        this.f5625k8 = -1;
        this.f5627m8 = new d();
        this.f5632r8 = false;
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    @Deprecated
    public void E3(@p0 Bundle bundle) {
        super.E3(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void H3(@g.n0 Context context) {
        super.H3(context);
        m3().l(this.f5627m8);
        if (this.f5631q8) {
            return;
        }
        this.f5630p8 = false;
    }

    public void H5() {
        J5(false, false, false);
    }

    public void I5() {
        J5(true, false, false);
    }

    public final void J5(boolean z10, boolean z11, boolean z12) {
        if (this.f5630p8) {
            return;
        }
        this.f5630p8 = true;
        this.f5631q8 = false;
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f5628n8.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f5617c8.getLooper()) {
                    onDismiss(this.f5628n8);
                } else {
                    this.f5617c8.post(this.f5618d8);
                }
            }
        }
        this.f5629o8 = true;
        if (this.f5625k8 >= 0) {
            if (z12) {
                L2().w1(this.f5625k8, 1);
            } else {
                L2().t1(this.f5625k8, 1, z10);
            }
            this.f5625k8 = -1;
            return;
        }
        g0 g0VarU = L2().u();
        g0VarU.Q(true);
        g0VarU.B(this);
        if (z12) {
            g0VarU.s();
        } else if (z10) {
            g0VarU.r();
        } else {
            g0VarU.q();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        this.f5617c8 = new Handler();
        this.f5624j8 = this.f5669y == 0;
        if (bundle != null) {
            this.f5621g8 = bundle.getInt(f5614x8, 0);
            this.f5622h8 = bundle.getInt(f5615y8, 0);
            this.f5623i8 = bundle.getBoolean(f5616z8, true);
            this.f5624j8 = bundle.getBoolean(A8, this.f5624j8);
            this.f5625k8 = bundle.getInt(B8, -1);
        }
    }

    @g.k0
    public void K5() {
        J5(false, false, true);
    }

    @p0
    public Dialog L5() {
        return this.f5628n8;
    }

    public boolean M5() {
        return this.f5624j8;
    }

    @d1
    public int N5() {
        return this.f5622h8;
    }

    public boolean O5() {
        return this.f5623i8;
    }

    @g.k0
    @g.n0
    public Dialog P5(@p0 Bundle bundle) {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateDialog called for DialogFragment ");
            sb2.append(this);
        }
        return new androidx.activity.j(R4(), N5());
    }

    @p0
    public View Q5(int i10) {
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void R3() {
        super.R3();
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            this.f5629o8 = true;
            dialog.setOnDismissListener(null);
            this.f5628n8.dismiss();
            if (!this.f5630p8) {
                onDismiss(this.f5628n8);
            }
            this.f5628n8 = null;
            this.f5632r8 = false;
        }
    }

    public boolean R5() {
        return this.f5632r8;
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void S3() {
        super.S3();
        if (!this.f5631q8 && !this.f5630p8) {
            this.f5630p8 = true;
        }
        m3().p(this.f5627m8);
    }

    public final void S5(@p0 Bundle bundle) {
        if (this.f5624j8 && !this.f5632r8) {
            try {
                this.f5626l8 = true;
                Dialog dialogP5 = P5(bundle);
                this.f5628n8 = dialogP5;
                if (this.f5624j8) {
                    X5(dialogP5, this.f5621g8);
                    Context contextX1 = X1();
                    if (contextX1 instanceof Activity) {
                        this.f5628n8.setOwnerActivity((Activity) contextX1);
                    }
                    this.f5628n8.setCancelable(this.f5623i8);
                    this.f5628n8.setOnCancelListener(this.f5619e8);
                    this.f5628n8.setOnDismissListener(this.f5620f8);
                    this.f5632r8 = true;
                } else {
                    this.f5628n8 = null;
                }
            } finally {
                this.f5626l8 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @g.n0
    public LayoutInflater T3(@p0 Bundle bundle) {
        LayoutInflater layoutInflaterT3 = super.T3(bundle);
        if (this.f5624j8 && !this.f5626l8) {
            S5(bundle);
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("get layout inflater for DialogFragment ");
                sb2.append(this);
                sb2.append(" from dialog context");
            }
            Dialog dialog = this.f5628n8;
            return dialog != null ? layoutInflaterT3.cloneInContext(dialog.getContext()) : layoutInflaterT3;
        }
        if (FragmentManager.W0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.f5624j8) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("mCreatingDialog = true: ");
                sb3.append(str);
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("mShowsDialog = false: ");
                sb4.append(str);
            }
        }
        return layoutInflaterT3;
    }

    @g.n0
    public final Dialog T5() {
        Dialog dialogL5 = L5();
        if (dialogL5 != null) {
            return dialogL5;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void U5(boolean z10) {
        this.f5623i8 = z10;
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            dialog.setCancelable(z10);
        }
    }

    public void V5(boolean z10) {
        this.f5624j8 = z10;
    }

    public void W5(int i10, @d1 int i11) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting style and theme for DialogFragment ");
            sb2.append(this);
            sb2.append(" to ");
            sb2.append(i10);
            sb2.append(", ");
            sb2.append(i11);
        }
        this.f5621g8 = i10;
        if (i10 == 2 || i10 == 3) {
            this.f5622h8 = R.style.Theme.Panel;
        }
        if (i11 != 0) {
            this.f5622h8 = i11;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void X5(@g.n0 Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public int Y5(@g.n0 g0 g0Var, @p0 String str) {
        this.f5630p8 = false;
        this.f5631q8 = true;
        g0Var.k(this, str);
        this.f5629o8 = false;
        int iQ = g0Var.q();
        this.f5625k8 = iQ;
        return iQ;
    }

    public void Z5(@g.n0 FragmentManager fragmentManager, @p0 String str) {
        this.f5630p8 = false;
        this.f5631q8 = true;
        g0 g0VarU = fragmentManager.u();
        g0VarU.Q(true);
        g0VarU.k(this, str);
        g0VarU.q();
    }

    public void a6(@g.n0 FragmentManager fragmentManager, @p0 String str) {
        this.f5630p8 = false;
        this.f5631q8 = true;
        g0 g0VarU = fragmentManager.u();
        g0VarU.Q(true);
        g0VarU.k(this, str);
        g0VarU.s();
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void g4(@g.n0 Bundle bundle) {
        super.g4(bundle);
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean(C8, false);
            bundle.putBundle(f5613w8, bundleOnSaveInstanceState);
        }
        int i10 = this.f5621g8;
        if (i10 != 0) {
            bundle.putInt(f5614x8, i10);
        }
        int i11 = this.f5622h8;
        if (i11 != 0) {
            bundle.putInt(f5615y8, i11);
        }
        boolean z10 = this.f5623i8;
        if (!z10) {
            bundle.putBoolean(f5616z8, z10);
        }
        boolean z11 = this.f5624j8;
        if (!z11) {
            bundle.putBoolean(A8, z11);
        }
        int i12 = this.f5625k8;
        if (i12 != -1) {
            bundle.putInt(B8, i12);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void h4() {
        super.h4();
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            this.f5629o8 = false;
            dialog.show();
            View decorView = this.f5628n8.getWindow().getDecorView();
            ViewTreeLifecycleOwner.b(decorView, this);
            ViewTreeViewModelStoreOwner.b(decorView, this);
            ViewTreeSavedStateRegistryOwner.b(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void i4() {
        super.i4();
        Dialog dialog = this.f5628n8;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @g.n0
    public i j1() {
        return new e(super.j1());
    }

    @Override // androidx.fragment.app.Fragment
    @g.k0
    public void k4(@p0 Bundle bundle) {
        Bundle bundle2;
        super.k4(bundle);
        if (this.f5628n8 == null || bundle == null || (bundle2 = bundle.getBundle(f5613w8)) == null) {
            return;
        }
        this.f5628n8.onRestoreInstanceState(bundle2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@g.n0 DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@g.n0 DialogInterface dialogInterface) {
        if (this.f5629o8) {
            return;
        }
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDismiss called for DialogFragment ");
            sb2.append(this);
        }
        J5(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void r4(@g.n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        Bundle bundle2;
        super.r4(layoutInflater, viewGroup, bundle);
        if (this.C1 != null || this.f5628n8 == null || bundle == null || (bundle2 = bundle.getBundle(f5613w8)) == null) {
            return;
        }
        this.f5628n8.onRestoreInstanceState(bundle2);
    }

    public DialogFragment(@g.i0 int i10) {
        super(i10);
        this.f5618d8 = new a();
        this.f5619e8 = new b();
        this.f5620f8 = new c();
        this.f5621g8 = 0;
        this.f5622h8 = 0;
        this.f5623i8 = true;
        this.f5624j8 = true;
        this.f5625k8 = -1;
        this.f5627m8 = new d();
        this.f5632r8 = false;
    }
}
