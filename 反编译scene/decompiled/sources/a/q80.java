package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f7187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2554a;

    public q80(String str, Runnable runnable, boolean z) {
        f92.d(str, "text");
        this.f2553a = str;
        this.f7187a = runnable;
        this.f2554a = z;
    }

    public /* synthetic */ q80(String str, Runnable runnable, boolean z, int i, b92 b92Var) {
        this(str, (i & 2) != 0 ? null : runnable, (i & 4) != 0 ? true : z);
    }

    public final boolean a() {
        return this.f2554a;
    }

    public final Runnable b() {
        return this.f7187a;
    }

    public final String c() {
        return this.f2553a;
    }
}
