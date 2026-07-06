package a;

import android.content.Context;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zu1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cv1 f8098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v72 f3888a;

    public zu1(cv1 cv1Var, v72 v72Var) {
        this.f8098a = cv1Var;
        this.f3888a = v72Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uy0 uy0Var = vy0.f7734a;
        Context contextP = this.f8098a.f5832a.p();
        f92.b(contextP);
        f92.c(contextP, "this.context!!");
        uy0.b(uy0Var, contextP, null, 2, null).b();
        yx0 yx0Var = zx0.f8105a;
        Context contextP2 = this.f8098a.f5832a.p();
        f92.b(contextP2);
        f92.c(contextP2, "this.context!!");
        zx0 zx0VarA = yx0Var.a(contextP2, "SmartP.db");
        String strF = zx0VarA.f();
        if (strF.length() > 0) {
            try {
                e42 e42Var = g42.f6169a;
                g30 g30VarD = zx0.d(zx0VarA, new g30(strF), false, 2, null);
                if (g30VarD != null && (!f92.a(g30VarD.A(2), strF))) {
                    zx0VarA.m(g30VarD);
                }
                g42.a(m42.f6769a);
            } catch (Throwable th) {
                e42 e42Var2 = g42.f6169a;
                g42.a(h42.a(th));
            }
        }
        yx0 yx0Var2 = zx0.f8105a;
        Context contextP3 = this.f8098a.f5832a.p();
        f92.b(contextP3);
        f92.c(contextP3, "this.context!!");
        zx0 zx0VarA2 = yx0Var2.a(contextP3, "teg_config.db");
        String strF2 = zx0VarA2.f();
        if (strF2.length() > 0) {
            try {
                e42 e42Var3 = g42.f6169a;
                g30 g30VarD2 = zx0.d(zx0VarA2, new g30(strF2), false, 2, null);
                if (g30VarD2 != null && (!f92.a(g30VarD2.A(2), strF2))) {
                    zx0VarA2.m(g30VarD2);
                }
                g42.a(m42.f6769a);
            } catch (Throwable th2) {
                e42 e42Var4 = g42.f6169a;
                g42.a(h42.a(th2));
            }
        }
        Scene.c.p(Scene.f4798a, "^_^", 0, 2, null);
        this.f3888a.i();
    }
}
