package eb;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f26759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f26767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26768k;

    public void a(long j10) {
        b(j10, 1);
    }

    public final void b(long j10, int i10) {
        this.f26767j += j10;
        this.f26768k += i10;
    }

    public synchronized void c() {
    }

    public void d(d dVar) {
        this.f26758a += dVar.f26758a;
        this.f26759b += dVar.f26759b;
        this.f26760c += dVar.f26760c;
        this.f26761d += dVar.f26761d;
        this.f26762e += dVar.f26762e;
        this.f26763f += dVar.f26763f;
        this.f26764g += dVar.f26764g;
        this.f26765h = Math.max(this.f26765h, dVar.f26765h);
        this.f26766i += dVar.f26766i;
        b(dVar.f26767j, dVar.f26768k);
    }
}
