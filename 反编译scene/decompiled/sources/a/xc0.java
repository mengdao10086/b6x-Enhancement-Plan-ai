package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i50 f7875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ StringBuilder f3569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean[] f3570a;

    public xc0(boolean[] zArr, StringBuilder sb, i50 i50Var) {
        this.f3570a = zArr;
        this.f3569a = sb;
        this.f7875a = i50Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3570a[0] = e50.f677a.i0(this.f3569a.toString(), this.f7875a);
        synchronized (this.f7875a) {
            this.f7875a.notify();
        }
    }
}
