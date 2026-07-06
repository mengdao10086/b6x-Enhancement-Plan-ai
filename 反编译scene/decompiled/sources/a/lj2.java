package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lj2 extends jj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f6714a;

    public lj2(Runnable runnable, long j, kj2 kj2Var) {
        super(j, kj2Var);
        this.f6714a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6714a.run();
        } finally {
            ((jj2) this).f1550a.f();
        }
    }

    public String toString() {
        return "Task[" + ce2.a(this.f6714a) + '@' + ce2.b(this.f6714a) + ", " + ((jj2) this).f6518a + ", " + ((jj2) this).f1550a + ']';
    }
}
