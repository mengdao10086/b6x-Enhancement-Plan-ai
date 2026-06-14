package a;

import a.v4;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v1 implements v4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f7647a;

    public v1(w1 w1Var) {
        this.f7647a = w1Var;
    }

    @Override // a.v4.a
    public void b(i4 i4Var, boolean z) {
        i4 i4VarD = i4Var.D();
        boolean z2 = i4VarD != i4Var;
        w1 w1Var = this.f7647a;
        if (z2) {
            i4Var = i4VarD;
        }
        u1 u1VarE0 = w1Var.e0(i4Var);
        if (u1VarE0 != null) {
            if (!z2) {
                this.f7647a.U(u1VarE0, z);
            } else {
                this.f7647a.Q(u1VarE0.f7553a, u1VarE0, i4VarD);
                this.f7647a.U(u1VarE0, true);
            }
        }
    }

    @Override // a.v4.a
    public boolean c(i4 i4Var) {
        Window.Callback callbackL0;
        if (i4Var != i4Var.D()) {
            return true;
        }
        w1 w1Var = this.f7647a;
        if (!w1Var.f || (callbackL0 = w1Var.l0()) == null || this.f7647a.p) {
            return true;
        }
        callbackL0.onMenuOpened(108, i4Var);
        return true;
    }
}
