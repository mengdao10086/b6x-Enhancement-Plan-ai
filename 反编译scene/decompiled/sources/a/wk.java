package a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wk extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f7797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f3450a;
    public boolean v;
    public boolean w;
    public boolean x;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f3451a = new vk(this);
    public int f = 0;
    public int g = 0;
    public boolean t = true;
    public boolean u = true;
    public int h = -1;

    @Override // androidx.fragment.app.Fragment
    public void A0(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        super.A0(bundle);
        Dialog dialog = this.f7797a;
        if (dialog != null && (bundleOnSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.f;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.g;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.t;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.u;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.h;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    public void A1(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0() {
        super.B0();
        Dialog dialog = this.f7797a;
        if (dialog != null) {
            this.v = false;
            dialog.show();
        }
    }

    public void B1(jl jlVar, String str) {
        this.w = false;
        this.x = true;
        hm hmVarA = jlVar.a();
        hmVarA.c(this, str);
        hmVarA.f();
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
        Dialog dialog = this.f7797a;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y(Bundle bundle) {
        Bundle bundle2;
        super.Y(bundle);
        if (this.u) {
            View viewM = M();
            if (viewM != null) {
                if (viewM.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f7797a.setContentView(viewM);
            }
            cl clVarJ = j();
            if (clVarJ != null) {
                this.f7797a.setOwnerActivity(clVarJ);
            }
            this.f7797a.setCancelable(this.t);
            this.f7797a.setOnCancelListener(this);
            this.f7797a.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f7797a.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b0(Context context) {
        super.b0(context);
        if (this.x) {
            return;
        }
        this.w = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        this.f3450a = new Handler();
        this.u = ((Fragment) this).e == 0;
        if (bundle != null) {
            this.f = bundle.getInt("android:style", 0);
            this.g = bundle.getInt("android:theme", 0);
            this.t = bundle.getBoolean("android:cancelable", true);
            this.u = bundle.getBoolean("android:showsDialog", this.u);
            this.h = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l0() {
        super.l0();
        Dialog dialog = this.f7797a;
        if (dialog != null) {
            this.v = true;
            dialog.setOnDismissListener(null);
            this.f7797a.dismiss();
            if (!this.w) {
                onDismiss(this.f7797a);
            }
            this.f7797a = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void m0() {
        super.m0();
        if (this.x || this.w) {
            return;
        }
        this.w = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater n0(Bundle bundle) {
        Context contextE;
        if (!this.u) {
            return super.n0(bundle);
        }
        Dialog dialogY1 = y1(bundle);
        this.f7797a = dialogY1;
        if (dialogY1 != null) {
            A1(dialogY1, this.f);
            contextE = this.f7797a.getContext();
        } else {
            contextE = ((Fragment) this).f4252a.e();
        }
        return (LayoutInflater) contextE.getSystemService("layout_inflater");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.v) {
            return;
        }
        w1(true, true);
    }

    public void v1() {
        w1(false, false);
    }

    public void w1(boolean z, boolean z2) {
        if (this.w) {
            return;
        }
        this.w = true;
        this.x = false;
        Dialog dialog = this.f7797a;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f7797a.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.f3450a.getLooper()) {
                    onDismiss(this.f7797a);
                } else {
                    this.f3450a.post(this.f3451a);
                }
            }
        }
        this.v = true;
        if (this.h >= 0) {
            e1().h(this.h, 1);
            this.h = -1;
            return;
        }
        hm hmVarA = e1().a();
        hmVarA.l(this);
        if (z) {
            hmVarA.g();
        } else {
            hmVarA.f();
        }
    }

    public Dialog x1() {
        return this.f7797a;
    }

    public abstract Dialog y1(Bundle bundle);

    public void z1(boolean z) {
        this.t = z;
        Dialog dialog = this.f7797a;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }
}
