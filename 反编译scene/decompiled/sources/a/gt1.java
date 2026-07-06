package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gt1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f6242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f1062a;

    public gt1(kv1 kv1Var, Runnable runnable) {
        this.f6242a = kv1Var;
        this.f1062a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6242a.f6646a.k();
        z90.b(z90.f8048a, aa0.SCENE_CONFIG, null, 2, null);
        try {
            e42 e42Var = g42.f6169a;
            this.f6242a.a2();
            g42.a(m42.f6769a);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            g42.a(h42.a(th));
        }
        this.f1062a.run();
        s60 s60Var = s60.f7366a;
        String strJ = this.f6242a.J(u61.cmd_power_reboot);
        f92.c(strJ, "getString(R.string.cmd_power_reboot)");
        s60Var.b(strJ);
    }
}
