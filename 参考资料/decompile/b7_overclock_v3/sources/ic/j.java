package ic;

import com.google.android.exoplayer2.Format;
import g.i1;
import g.p0;
import hd.u0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final h f32093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f32095c;

    public static abstract class a extends j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f32096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f32097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public final List<d> f32098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f32099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f32100h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @i1
        public final long f32101i;

        public a(@p0 h hVar, long j10, long j11, long j12, long j13, @p0 List<d> list, long j14, long j15, long j16) {
            super(hVar, j10, j11);
            this.f32096d = j12;
            this.f32097e = j13;
            this.f32098f = list;
            this.f32101i = j14;
            this.f32099g = j15;
            this.f32100h = j16;
        }

        public int c(long j10, long j11) {
            int iG = g(j10);
            return iG != -1 ? iG : (int) (i((j11 - this.f32100h) + this.f32101i, j10) - d(j10, j11));
        }

        public long d(long j10, long j11) {
            if (g(j10) == -1) {
                long j12 = this.f32099g;
                if (j12 != ya.g.f56663b) {
                    return Math.max(e(), i((j11 - this.f32100h) - j12, j10));
                }
            }
            return e();
        }

        public long e() {
            return this.f32096d;
        }

        public long f(long j10, long j11) {
            if (this.f32098f != null) {
                return ya.g.f56663b;
            }
            long jD = d(j10, j11) + ((long) c(j10, j11));
            return (j(jD) + h(jD, j10)) - this.f32101i;
        }

        public abstract int g(long j10);

        public final long h(long j10, long j11) {
            List<d> list = this.f32098f;
            if (list != null) {
                return (list.get((int) (j10 - this.f32096d)).f32107b * 1000000) / this.f32094b;
            }
            int iG = g(j11);
            return (iG == -1 || j10 != (e() + ((long) iG)) - 1) ? (this.f32097e * 1000000) / this.f32094b : j11 - j(j10);
        }

        public long i(long j10, long j11) {
            long jE = e();
            long jG = g(j11);
            if (jG == 0) {
                return jE;
            }
            if (this.f32098f == null) {
                long j12 = this.f32096d + (j10 / ((this.f32097e * 1000000) / this.f32094b));
                return j12 < jE ? jE : jG == -1 ? j12 : Math.min(j12, (jE + jG) - 1);
            }
            long j13 = (jG + jE) - 1;
            long j14 = jE;
            while (j14 <= j13) {
                long j15 = ((j13 - j14) / 2) + j14;
                long j16 = j(j15);
                if (j16 < j10) {
                    j14 = j15 + 1;
                } else {
                    if (j16 <= j10) {
                        return j15;
                    }
                    j13 = j15 - 1;
                }
            }
            return j14 == jE ? j14 : j13;
        }

        public final long j(long j10) {
            List<d> list = this.f32098f;
            return u0.h1(list != null ? list.get((int) (j10 - this.f32096d)).f32106a - this.f32095c : (j10 - this.f32096d) * this.f32097e, 1000000L, this.f32094b);
        }

        public abstract h k(i iVar, long j10);

        public boolean l() {
            return this.f32098f != null;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public final List<h> f32102j;

        public b(h hVar, long j10, long j11, long j12, long j13, @p0 List<d> list, long j14, @p0 List<h> list2, long j15, long j16) {
            super(hVar, j10, j11, j12, j13, list, j14, j15, j16);
            this.f32102j = list2;
        }

        @Override // ic.j.a
        public int g(long j10) {
            return this.f32102j.size();
        }

        @Override // ic.j.a
        public h k(i iVar, long j10) {
            return this.f32102j.get((int) (j10 - this.f32096d));
        }

        @Override // ic.j.a
        public boolean l() {
            return true;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public final m f32103j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        public final m f32104k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f32105l;

        public c(h hVar, long j10, long j11, long j12, long j13, long j14, @p0 List<d> list, long j15, @p0 m mVar, @p0 m mVar2, long j16, long j17) {
            super(hVar, j10, j11, j12, j14, list, j15, j16, j17);
            this.f32103j = mVar;
            this.f32104k = mVar2;
            this.f32105l = j13;
        }

        @Override // ic.j
        @p0
        public h a(i iVar) {
            m mVar = this.f32103j;
            if (mVar == null) {
                return super.a(iVar);
            }
            Format format = iVar.f32082c;
            return new h(mVar.a(format.f16687a, 0L, format.f16694h, 0L), 0L, -1L);
        }

        @Override // ic.j.a
        public int g(long j10) {
            List<d> list = this.f32098f;
            if (list != null) {
                return list.size();
            }
            long j11 = this.f32105l;
            if (j11 != -1) {
                return (int) ((j11 - this.f32096d) + 1);
            }
            if (j10 != ya.g.f56663b) {
                return (int) u0.n(j10, (this.f32097e * 1000000) / this.f32094b);
            }
            return -1;
        }

        @Override // ic.j.a
        public h k(i iVar, long j10) {
            List<d> list = this.f32098f;
            long j11 = list != null ? list.get((int) (j10 - this.f32096d)).f32106a : (j10 - this.f32096d) * this.f32097e;
            m mVar = this.f32104k;
            Format format = iVar.f32082c;
            return new h(mVar.a(format.f16687a, j10, format.f16694h, j11), 0L, -1L);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f32106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f32107b;

        public d(long j10, long j11) {
            this.f32106a = j10;
            this.f32107b = j11;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f32106a == dVar.f32106a && this.f32107b == dVar.f32107b;
        }

        public int hashCode() {
            return (((int) this.f32106a) * 31) + ((int) this.f32107b);
        }
    }

    public j(@p0 h hVar, long j10, long j11) {
        this.f32093a = hVar;
        this.f32094b = j10;
        this.f32095c = j11;
    }

    @p0
    public h a(i iVar) {
        return this.f32093a;
    }

    public long b() {
        return u0.h1(this.f32095c, 1000000L, this.f32094b);
    }

    public static class e extends j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f32108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f32109e;

        public e(@p0 h hVar, long j10, long j11, long j12, long j13) {
            super(hVar, j10, j11);
            this.f32108d = j12;
            this.f32109e = j13;
        }

        @p0
        public h c() {
            long j10 = this.f32109e;
            if (j10 <= 0) {
                return null;
            }
            return new h(null, this.f32108d, j10);
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
