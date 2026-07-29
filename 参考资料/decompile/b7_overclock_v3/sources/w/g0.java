package w;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f53457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f53461e;

    public void a(t.e eVar) {
        this.f53458b = eVar.l();
        this.f53459c = eVar.w();
        this.f53460d = eVar.q();
        this.f53461e = eVar.h();
        this.f53457a = (int) eVar.t();
    }

    public int b() {
        return this.f53461e - this.f53459c;
    }

    public int c() {
        return this.f53460d - this.f53458b;
    }
}
