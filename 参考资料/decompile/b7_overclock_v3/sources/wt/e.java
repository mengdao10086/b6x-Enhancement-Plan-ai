package wt;

/* JADX INFO: loaded from: classes6.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f54818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f54819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f54820c;

    public e(Throwable th2) {
        this.f54818a = th2;
        this.f54819b = false;
    }

    @Override // wt.d
    public void a(Object obj) {
        this.f54820c = obj;
    }

    @Override // wt.d
    public Object b() {
        return this.f54820c;
    }

    public Throwable c() {
        return this.f54818a;
    }

    public boolean d() {
        return this.f54819b;
    }

    public e(Throwable th2, boolean z10) {
        this.f54818a = th2;
        this.f54819b = z10;
    }
}
