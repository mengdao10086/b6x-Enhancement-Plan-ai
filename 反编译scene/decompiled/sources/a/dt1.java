package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dt1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ et1 f5936a;

    public dt1(et1 et1Var) {
        this.f5936a = et1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cl clVarJ = this.f5936a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        new mq1(clVarJ).d();
    }
}
