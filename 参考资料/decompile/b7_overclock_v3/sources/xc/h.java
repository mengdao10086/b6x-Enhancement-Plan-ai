package xc;

import g.i1;
import hd.u0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements qc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f55159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f55160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, g> f55161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, e> f55162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f55163e;

    public h(d dVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.f55159a = dVar;
        this.f55162d = map2;
        this.f55163e = map3;
        this.f55161c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f55160b = dVar.j();
    }

    @i1
    public Map<String, g> a() {
        return this.f55161c;
    }

    @i1
    public d b() {
        return this.f55159a;
    }

    @Override // qc.f
    public int c(long j10) {
        int iF = u0.f(this.f55160b, j10, false, false);
        if (iF < this.f55160b.length) {
            return iF;
        }
        return -1;
    }

    @Override // qc.f
    public long d(int i10) {
        return this.f55160b[i10];
    }

    @Override // qc.f
    public List<qc.b> e(long j10) {
        return this.f55159a.h(j10, this.f55161c, this.f55162d, this.f55163e);
    }

    @Override // qc.f
    public int f() {
        return this.f55160b.length;
    }
}
