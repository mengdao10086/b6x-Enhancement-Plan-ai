package gc;

import com.google.android.exoplayer2.Format;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f29136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f29137l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f29138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f29139n;

    public a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @p0 Object obj, long j10, long j11, long j12, long j13, long j14) {
        super(aVar, bVar, format, i10, obj, j10, j11, j14);
        this.f29136k = j12;
        this.f29137l = j13;
    }

    public final int i(int i10) {
        return ((int[]) hd.a.k(this.f29139n))[i10];
    }

    public final c j() {
        return (c) hd.a.k(this.f29138m);
    }

    public void k(c cVar) {
        this.f29138m = cVar;
        this.f29139n = cVar.a();
    }
}
