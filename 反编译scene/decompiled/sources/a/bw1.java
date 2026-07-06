package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bw1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f5739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v72 f304a;

    public bw1(bx1 bx1Var, v72 v72Var) {
        this.f5739a = bx1Var;
        this.f304a = v72Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB0 = hz0.f1282a.B0();
        if (!(strB0 == null || strB0.length() == 0)) {
            this.f304a.i();
            return;
        }
        cl clVarJ = this.f5739a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        new zm1(clVarJ, this.f5739a.S1(), this.f5739a.R1()).j();
    }
}
