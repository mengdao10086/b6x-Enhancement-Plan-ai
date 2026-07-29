package pb;

import com.google.android.exoplayer2.Format;
import hb.a0;
import hb.d0;
import hb.l;
import hb.m;
import hb.z;
import hd.c0;
import hd.u0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f46573n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f46574o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f46575p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f46576q = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f46578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f46579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f46580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f46581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f46582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f46583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f46584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f46585i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f46587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f46588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f46589m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f46577a = new e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f46586j = new b();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Format f46590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f46591b;
    }

    public static final class c implements g {
        public c() {
        }

        @Override // pb.g
        public long a(l lVar) {
            return -1L;
        }

        @Override // pb.g
        public a0 b() {
            return new a0.b(ya.g.f56663b);
        }

        @Override // pb.g
        public void c(long j10) {
        }
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    public final void a() {
        hd.a.k(this.f46578b);
        u0.k(this.f46579c);
    }

    public long b(long j10) {
        return (j10 * 1000000) / ((long) this.f46585i);
    }

    public long c(long j10) {
        return (((long) this.f46585i) * j10) / 1000000;
    }

    public void d(m mVar, d0 d0Var) {
        this.f46579c = mVar;
        this.f46578b = d0Var;
        l(true);
    }

    public void e(long j10) {
        this.f46583g = j10;
    }

    public abstract long f(c0 c0Var);

    public final int g(l lVar, z zVar) throws IOException {
        a();
        int i10 = this.f46584h;
        if (i10 == 0) {
            return j(lVar);
        }
        if (i10 == 1) {
            lVar.o((int) this.f46582f);
            this.f46584h = 2;
            return 0;
        }
        if (i10 == 2) {
            u0.k(this.f46580d);
            return k(lVar, zVar);
        }
        if (i10 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    public final boolean h(l lVar) throws IOException {
        while (this.f46577a.d(lVar)) {
            this.f46587k = lVar.getPosition() - this.f46582f;
            if (!i(this.f46577a.c(), this.f46582f, this.f46586j)) {
                return true;
            }
            this.f46582f = lVar.getPosition();
        }
        this.f46584h = 3;
        return false;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean i(c0 c0Var, long j10, b bVar) throws IOException;

    @RequiresNonNull({"trackOutput"})
    public final int j(l lVar) throws IOException {
        if (!h(lVar)) {
            return -1;
        }
        Format format = this.f46586j.f46590a;
        this.f46585i = format.f16713z;
        if (!this.f46589m) {
            this.f46578b.f(format);
            this.f46589m = true;
        }
        g gVar = this.f46586j.f46591b;
        if (gVar != null) {
            this.f46580d = gVar;
        } else if (lVar.getLength() == -1) {
            this.f46580d = new c();
        } else {
            f fVarB = this.f46577a.b();
            this.f46580d = new pb.a(this, this.f46582f, lVar.getLength(), fVarB.f46566h + fVarB.f46567i, fVarB.f46561c, (fVarB.f46560b & 4) != 0);
        }
        this.f46584h = 2;
        this.f46577a.f();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    public final int k(l lVar, z zVar) throws IOException {
        long jA = this.f46580d.a(lVar);
        if (jA >= 0) {
            zVar.f30930a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.f46588l) {
            this.f46579c.o((a0) hd.a.k(this.f46580d.b()));
            this.f46588l = true;
        }
        if (this.f46587k <= 0 && !this.f46577a.d(lVar)) {
            this.f46584h = 3;
            return -1;
        }
        this.f46587k = 0L;
        c0 c0VarC = this.f46577a.c();
        long jF = f(c0VarC);
        if (jF >= 0) {
            long j10 = this.f46583g;
            if (j10 + jF >= this.f46581e) {
                long jB = b(j10);
                this.f46578b.d(c0VarC, c0VarC.f());
                this.f46578b.a(jB, 1, c0VarC.f(), 0, null);
                this.f46581e = -1L;
            }
        }
        this.f46583g += jF;
        return 0;
    }

    public void l(boolean z10) {
        if (z10) {
            this.f46586j = new b();
            this.f46582f = 0L;
            this.f46584h = 0;
        } else {
            this.f46584h = 1;
        }
        this.f46581e = -1L;
        this.f46583g = 0L;
    }

    public final void m(long j10, long j11) {
        this.f46577a.e();
        if (j10 == 0) {
            l(!this.f46588l);
        } else if (this.f46584h != 0) {
            this.f46581e = c(j11);
            ((g) u0.k(this.f46580d)).c(this.f46581e);
            this.f46584h = 2;
        }
    }
}
