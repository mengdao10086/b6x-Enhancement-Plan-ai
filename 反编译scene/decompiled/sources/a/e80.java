package a;

import a.p80;
import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class e80 extends wk {
    public View c;
    public int i;
    public final int j;
    public final boolean y;

    public e80(int i, boolean z) {
        this.j = i;
        this.y = z;
        this.i = z ? a30.dialog_full_screen_dark : a30.dialog_full_screen_light;
    }

    public abstract void C1();

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        Dialog dialogX1;
        Window window;
        f92.d(view, "view");
        super.D0(view, bundle);
        cl clVarJ = j();
        if (clVarJ == null || (dialogX1 = x1()) == null || (window = dialogX1.getWindow()) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            window.setWindowAnimations(R.style.Animation.Translucent);
        }
        p80.a aVar = p80.f2403a;
        f92.c(window, "this");
        aVar.K(window, clVarJ);
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        View viewInflate = layoutInflater.inflate(this.j, viewGroup);
        f92.c(viewInflate, "inflater.inflate(layout, container)");
        this.c = viewInflate;
        if (viewInflate != null) {
            return viewInflate;
        }
        f92.m("currentView");
        throw null;
    }

    @Override // a.wk, androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        C1();
    }

    @Override // a.wk, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        f92.d(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        cl clVarJ = j();
        if (clVarJ != null) {
            p80.a aVar = p80.f2403a;
            f92.c(clVarJ, "this");
            aVar.L(clVarJ);
        }
    }

    @Override // a.wk
    public Dialog y1(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 23) {
            cl clVarJ = j();
            f92.b(clVarJ);
            return new Dialog(clVarJ, -1);
        }
        cl clVarJ2 = j();
        f92.b(clVarJ2);
        int i = this.i;
        if (i == 0) {
            i = a30.dialog_full_screen_light;
        }
        return new Dialog(clVarJ2, i);
    }
}
