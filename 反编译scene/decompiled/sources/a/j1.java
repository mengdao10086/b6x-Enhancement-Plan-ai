package a;

import a.k3;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j1 implements k3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k3.a f6461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w1 f1489a;

    public j1(w1 w1Var, k3.a aVar) {
        this.f1489a = w1Var;
        this.f6461a = aVar;
    }

    @Override // a.k3.a
    public boolean a(k3 k3Var, MenuItem menuItem) {
        return this.f6461a.a(k3Var, menuItem);
    }

    @Override // a.k3.a
    public boolean b(k3 k3Var, Menu menu) {
        return this.f6461a.b(k3Var, menu);
    }

    @Override // a.k3.a
    public void c(k3 k3Var) {
        this.f6461a.c(k3Var);
        w1 w1Var = this.f1489a;
        if (w1Var.f3341a != null) {
            w1Var.f3340a.getDecorView().removeCallbacks(this.f1489a.f3345a);
        }
        w1 w1Var2 = this.f1489a;
        if (w1Var2.f3343a != null) {
            w1Var2.b0();
            w1 w1Var3 = this.f1489a;
            lh lhVarC = eh.c(w1Var3.f3343a);
            lhVarC.a(0.0f);
            w1Var3.f3330a = lhVarC;
            this.f1489a.f3330a.f(new i1(this));
        }
        w1 w1Var4 = this.f1489a;
        w0 w0Var = w1Var4.f3334a;
        if (w0Var != null) {
            w0Var.onSupportActionModeFinished(w1Var4.f3329a);
        }
        w1 w1Var5 = this.f1489a;
        w1Var5.f3329a = null;
        eh.h0(w1Var5.f3339a);
    }

    @Override // a.k3.a
    public boolean d(k3 k3Var, Menu menu) {
        eh.h0(this.f1489a.f3339a);
        return this.f6461a.d(k3Var, menu);
    }
}
