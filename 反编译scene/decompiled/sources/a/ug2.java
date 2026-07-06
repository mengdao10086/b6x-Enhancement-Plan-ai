package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ug2<U, T extends U> extends ji2<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7595a;

    public ug2(long j, b62<? super U> b62Var) {
        super(b62Var.c(), b62Var);
        this.f7595a = j;
    }

    @Override // a.hc2, a.bg2
    public String i0() {
        return super.i0() + "(timeMillis=" + this.f7595a + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        H(wg2.a(this.f7595a, this));
    }
}
