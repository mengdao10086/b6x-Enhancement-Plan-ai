package a;

import android.content.Context;
import com.omarea.model.CpuStatus;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tx0 extends g60<CpuStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z32 f7543a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tx0(Context context) {
        super(context);
        f92.d(context, "context");
        this.b = "cpuconfig.dat";
        this.f7543a = a42.a(sx0.f7441a);
    }

    public static /* synthetic */ CpuStatus i(tx0 tx0Var, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return tx0Var.h(str);
    }

    public static /* synthetic */ boolean k(tx0 tx0Var, CpuStatus cpuStatus, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return tx0Var.j(cpuStatus, str);
    }

    public final void e(String str) {
        CpuStatus cpuStatusC;
        if (str == null) {
            str = this.b;
        }
        if (!a(str) || (cpuStatusC = c(str)) == null) {
            return;
        }
        new zq0(false).c(cpuStatusC);
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return ((Boolean) this.f7543a.getValue()).booleanValue();
    }

    public final CpuStatus h(String str) {
        if (str == null) {
            str = this.b;
        }
        return (CpuStatus) super.c(str);
    }

    public final boolean j(CpuStatus cpuStatus, String str) {
        if (str == null) {
            str = this.b;
        }
        return super.d(cpuStatus, str);
    }

    public final boolean l() {
        new bv0().g(new zq0(g()).d(c(wu0.f3480a.p()), c(wu0.f3480a.c()), c(wu0.f3480a.o()), c(wu0.f3480a.i())), g());
        return true;
    }
}
