package gc;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import g.p0;
import gc.f;
import hb.a0;
import hb.d0;
import hb.z;
import hd.c0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements hb.m, f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final z f29146j = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hb.k f29147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Format f29149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<a> f29150d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f29151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public f.a f29152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f29153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a0 f29154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Format[] f29155i;

    public static final class a implements d0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f29156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f29157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public final Format f29158f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final hb.j f29159g = new hb.j();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Format f29160h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public d0 f29161i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f29162j;

        public a(int i10, int i11, @p0 Format format) {
            this.f29156d = i10;
            this.f29157e = i11;
            this.f29158f = format;
        }

        @Override // hb.d0
        public void a(long j10, int i10, int i11, int i12, @p0 d0.a aVar) {
            long j11 = this.f29162j;
            if (j11 != ya.g.f56663b && j10 >= j11) {
                this.f29161i = this.f29159g;
            }
            ((d0) u0.k(this.f29161i)).a(j10, i10, i11, i12, aVar);
        }

        @Override // hb.d0
        public int b(ed.h hVar, int i10, boolean z10, int i11) throws IOException {
            return ((d0) u0.k(this.f29161i)).e(hVar, i10, z10);
        }

        @Override // hb.d0
        public void c(c0 c0Var, int i10, int i11) {
            ((d0) u0.k(this.f29161i)).d(c0Var, i10);
        }

        @Override // hb.d0
        public /* synthetic */ void d(c0 c0Var, int i10) {
            hb.c0.b(this, c0Var, i10);
        }

        @Override // hb.d0
        public /* synthetic */ int e(ed.h hVar, int i10, boolean z10) {
            return hb.c0.a(this, hVar, i10, z10);
        }

        @Override // hb.d0
        public void f(Format format) {
            Format format2 = this.f29158f;
            if (format2 != null) {
                format = format.m0(format2);
            }
            this.f29160h = format;
            ((d0) u0.k(this.f29161i)).f(this.f29160h);
        }

        public void g(@p0 f.a aVar, long j10) {
            if (aVar == null) {
                this.f29161i = this.f29159g;
                return;
            }
            this.f29162j = j10;
            d0 d0VarD = aVar.d(this.f29156d, this.f29157e);
            this.f29161i = d0VarD;
            Format format = this.f29160h;
            if (format != null) {
                d0VarD.f(format);
            }
        }
    }

    public d(hb.k kVar, int i10, Format format) {
        this.f29147a = kVar;
        this.f29148b = i10;
        this.f29149c = format;
    }

    @Override // gc.f
    public boolean a(hb.l lVar) throws IOException {
        int iF = this.f29147a.f(lVar, f29146j);
        hd.a.i(iF != 1);
        return iF == 0;
    }

    @Override // gc.f
    @p0
    public Format[] b() {
        return this.f29155i;
    }

    @Override // gc.f
    public void c(@p0 f.a aVar, long j10, long j11) {
        this.f29152f = aVar;
        this.f29153g = j11;
        if (!this.f29151e) {
            this.f29147a.c(this);
            if (j10 != ya.g.f56663b) {
                this.f29147a.b(0L, j10);
            }
            this.f29151e = true;
            return;
        }
        hb.k kVar = this.f29147a;
        if (j10 == ya.g.f56663b) {
            j10 = 0;
        }
        kVar.b(0L, j10);
        for (int i10 = 0; i10 < this.f29150d.size(); i10++) {
            this.f29150d.valueAt(i10).g(aVar, j11);
        }
    }

    @Override // hb.m
    public d0 d(int i10, int i11) {
        a aVar = this.f29150d.get(i10);
        if (aVar == null) {
            hd.a.i(this.f29155i == null);
            aVar = new a(i10, i11, i11 == this.f29148b ? this.f29149c : null);
            aVar.g(this.f29152f, this.f29153g);
            this.f29150d.put(i10, aVar);
        }
        return aVar;
    }

    @Override // gc.f
    @p0
    public hb.e e() {
        a0 a0Var = this.f29154h;
        if (a0Var instanceof hb.e) {
            return (hb.e) a0Var;
        }
        return null;
    }

    @Override // hb.m
    public void k() {
        Format[] formatArr = new Format[this.f29150d.size()];
        for (int i10 = 0; i10 < this.f29150d.size(); i10++) {
            formatArr[i10] = (Format) hd.a.k(this.f29150d.valueAt(i10).f29160h);
        }
        this.f29155i = formatArr;
    }

    @Override // hb.m
    public void o(a0 a0Var) {
        this.f29154h = a0Var;
    }

    @Override // gc.f
    public void release() {
        this.f29147a.release();
    }
}
