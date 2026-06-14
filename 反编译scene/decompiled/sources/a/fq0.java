package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fq0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iq0 f6129a;

    public fq0(iq0 iq0Var) {
        this.f6129a = iq0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6129a.f1406b) {
            return;
        }
        aq0.f101a.f();
        this.f6129a.Q();
        new yw0(true, 30).start();
        if (this.f6129a.I()) {
            if (this.f6129a.o.length() > 0) {
                this.f6129a.R(wu0.f3480a.p(), "standby");
            }
        }
    }
}
