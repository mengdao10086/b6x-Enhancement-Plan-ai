package pb;

import g.i1;
import g.p0;
import hb.a0;
import hb.b0;
import hb.l;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f46513m = 72000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f46514n = 100000;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f46515o = 30000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f46516p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f46517q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f46518r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f46519s = 3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f46520t = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f46521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f46524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f46525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f46526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f46527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f46528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f46529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f46530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f46531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f46532l;

    public final class b implements a0 {
        public b() {
        }

        @Override // hb.a0
        public boolean e() {
            return true;
        }

        @Override // hb.a0
        public a0.a g(long j10) {
            return new a0.a(new b0(j10, u0.u((a.this.f46522b + ((a.this.f46524d.c(j10) * (a.this.f46523c - a.this.f46522b)) / a.this.f46526f)) - 30000, a.this.f46522b, a.this.f46523c - 1)));
        }

        @Override // hb.a0
        public long h() {
            return a.this.f46524d.b(a.this.f46526f);
        }
    }

    public a(i iVar, long j10, long j11, long j12, long j13, boolean z10) {
        hd.a.a(j10 >= 0 && j11 > j10);
        this.f46524d = iVar;
        this.f46522b = j10;
        this.f46523c = j11;
        if (j12 == j11 - j10 || z10) {
            this.f46526f = j13;
            this.f46525e = 4;
        } else {
            this.f46525e = 0;
        }
        this.f46521a = new f();
    }

    @Override // pb.g
    public long a(l lVar) throws IOException {
        int i10 = this.f46525e;
        if (i10 == 0) {
            long position = lVar.getPosition();
            this.f46527g = position;
            this.f46525e = 1;
            long j10 = this.f46523c - 65307;
            if (j10 > position) {
                return j10;
            }
        } else if (i10 != 1) {
            if (i10 == 2) {
                long jI = i(lVar);
                if (jI != -1) {
                    return jI;
                }
                this.f46525e = 3;
            } else if (i10 != 3) {
                if (i10 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(lVar);
            this.f46525e = 4;
            return -(this.f46531k + 2);
        }
        this.f46526f = j(lVar);
        this.f46525e = 4;
        return this.f46527g;
    }

    @Override // pb.g
    public void c(long j10) {
        this.f46528h = u0.u(j10, 0L, this.f46526f - 1);
        this.f46525e = 2;
        this.f46529i = this.f46522b;
        this.f46530j = this.f46523c;
        this.f46531k = 0L;
        this.f46532l = this.f46526f;
    }

    @Override // pb.g
    @p0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f46526f != 0) {
            return new b();
        }
        return null;
    }

    public final long i(l lVar) throws IOException {
        if (this.f46529i == this.f46530j) {
            return -1L;
        }
        long position = lVar.getPosition();
        if (!this.f46521a.e(lVar, this.f46530j)) {
            long j10 = this.f46529i;
            if (j10 != position) {
                return j10;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f46521a.b(lVar, false);
        lVar.n();
        long j11 = this.f46528h;
        f fVar = this.f46521a;
        long j12 = fVar.f46561c;
        long j13 = j11 - j12;
        int i10 = fVar.f46566h + fVar.f46567i;
        if (0 <= j13 && j13 < 72000) {
            return -1L;
        }
        if (j13 < 0) {
            this.f46530j = position;
            this.f46532l = j12;
        } else {
            this.f46529i = lVar.getPosition() + ((long) i10);
            this.f46531k = this.f46521a.f46561c;
        }
        long j14 = this.f46530j;
        long j15 = this.f46529i;
        if (j14 - j15 < 100000) {
            this.f46530j = j15;
            return j15;
        }
        long position2 = lVar.getPosition() - (((long) i10) * (j13 <= 0 ? 2L : 1L));
        long j16 = this.f46530j;
        long j17 = this.f46529i;
        return u0.u(position2 + ((j13 * (j16 - j17)) / (this.f46532l - this.f46531k)), j17, j16 - 1);
    }

    @i1
    public long j(l lVar) throws IOException {
        this.f46521a.c();
        if (!this.f46521a.d(lVar)) {
            throw new EOFException();
        }
        do {
            this.f46521a.b(lVar, false);
            f fVar = this.f46521a;
            lVar.o(fVar.f46566h + fVar.f46567i);
            f fVar2 = this.f46521a;
            if ((fVar2.f46560b & 4) == 4 || !fVar2.d(lVar)) {
                break;
            }
        } while (lVar.getPosition() < this.f46523c);
        return this.f46521a.f46561c;
    }

    public final void k(l lVar) throws IOException {
        while (true) {
            this.f46521a.d(lVar);
            this.f46521a.b(lVar, false);
            f fVar = this.f46521a;
            if (fVar.f46561c > this.f46528h) {
                lVar.n();
                return;
            } else {
                lVar.o(fVar.f46566h + fVar.f46567i);
                this.f46529i = lVar.getPosition();
                this.f46531k = this.f46521a.f46561c;
            }
        }
    }
}
