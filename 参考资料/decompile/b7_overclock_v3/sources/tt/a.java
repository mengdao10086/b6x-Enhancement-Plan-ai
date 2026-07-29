package tt;

/* JADX INFO: loaded from: classes6.dex */
public class a implements Runnable, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f51631a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f51632b;

    public a(c cVar) {
        this.f51632b = cVar;
    }

    @Override // tt.k
    public void a(p pVar, Object obj) {
        this.f51631a.a(i.a(pVar, obj));
        this.f51632b.g().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVarB = this.f51631a.b();
        if (iVarB == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f51632b.l(iVarB);
    }
}
