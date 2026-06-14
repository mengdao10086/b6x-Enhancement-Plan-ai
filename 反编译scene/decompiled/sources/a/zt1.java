package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zt1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ au1 f8097a;

    public zt1(au1 au1Var) {
        this.f8097a = au1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s60 s60Var = s60.f7366a;
        String strJ = this.f8097a.f5643a.f614a.J(u61.cmd_power_reboot);
        f92.c(strJ, "getString(R.string.cmd_power_reboot)");
        s60Var.b(strJ);
    }
}
