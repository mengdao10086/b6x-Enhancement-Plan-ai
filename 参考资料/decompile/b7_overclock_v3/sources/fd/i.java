package fd;

import g.p0;
import hd.t;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f28073f = "CachedContent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f28075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeSet<r> f28076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f28077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f28078e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f28079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f28080b;

        public a(long j10, long j11) {
            this.f28079a = j10;
            this.f28080b = j11;
        }

        public boolean a(long j10, long j11) {
            long j12 = this.f28080b;
            if (j12 == -1) {
                return j10 >= this.f28079a;
            }
            if (j11 == -1) {
                return false;
            }
            long j13 = this.f28079a;
            return j13 <= j10 && j10 + j11 <= j13 + j12;
        }

        public boolean b(long j10, long j11) {
            long j12 = this.f28079a;
            if (j12 > j10) {
                return j11 == -1 || j10 + j11 > j12;
            }
            long j13 = this.f28080b;
            return j13 == -1 || j12 + j13 > j10;
        }
    }

    public i(int i10, String str) {
        this(i10, str, n.f28119f);
    }

    public void a(r rVar) {
        this.f28076c.add(rVar);
    }

    public boolean b(m mVar) {
        this.f28078e = this.f28078e.f(mVar);
        return !r2.equals(r0);
    }

    public long c(long j10, long j11) {
        hd.a.a(j10 >= 0);
        hd.a.a(j11 >= 0);
        r rVarE = e(j10, j11);
        if (rVarE.d()) {
            return -Math.min(rVarE.e() ? Long.MAX_VALUE : rVarE.f28056c, j11);
        }
        long j12 = j10 + j11;
        long j13 = j12 >= 0 ? j12 : Long.MAX_VALUE;
        long jMax = rVarE.f28055b + rVarE.f28056c;
        if (jMax < j13) {
            for (r rVar : this.f28076c.tailSet(rVarE, false)) {
                long j14 = rVar.f28055b;
                if (j14 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j14 + rVar.f28056c);
                if (jMax >= j13) {
                    break;
                }
            }
        }
        return Math.min(jMax - j10, j11);
    }

    public n d() {
        return this.f28078e;
    }

    public r e(long j10, long j11) {
        r rVarJ = r.j(this.f28075b, j10);
        r rVarFloor = this.f28076c.floor(rVarJ);
        if (rVarFloor != null && rVarFloor.f28055b + rVarFloor.f28056c > j10) {
            return rVarFloor;
        }
        r rVarCeiling = this.f28076c.ceiling(rVarJ);
        if (rVarCeiling != null) {
            long j12 = rVarCeiling.f28055b - j10;
            j11 = j11 == -1 ? j12 : Math.min(j12, j11);
        }
        return r.i(this.f28075b, j10, j11);
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f28074a == iVar.f28074a && this.f28075b.equals(iVar.f28075b) && this.f28076c.equals(iVar.f28076c) && this.f28078e.equals(iVar.f28078e);
    }

    public TreeSet<r> f() {
        return this.f28076c;
    }

    public boolean g() {
        return this.f28076c.isEmpty();
    }

    public boolean h(long j10, long j11) {
        for (int i10 = 0; i10 < this.f28077d.size(); i10++) {
            if (this.f28077d.get(i10).a(j10, j11)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f28074a * 31) + this.f28075b.hashCode()) * 31) + this.f28078e.hashCode();
    }

    public boolean i() {
        return this.f28077d.isEmpty();
    }

    public boolean j(long j10, long j11) {
        for (int i10 = 0; i10 < this.f28077d.size(); i10++) {
            if (this.f28077d.get(i10).b(j10, j11)) {
                return false;
            }
        }
        this.f28077d.add(new a(j10, j11));
        return true;
    }

    public boolean k(g gVar) {
        if (!this.f28076c.remove(gVar)) {
            return false;
        }
        File file = gVar.f28058e;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public r l(r rVar, long j10, boolean z10) {
        hd.a.i(this.f28076c.remove(rVar));
        File file = (File) hd.a.g(rVar.f28058e);
        if (z10) {
            File fileK = r.k((File) hd.a.g(file.getParentFile()), this.f28074a, rVar.f28055b, j10);
            if (file.renameTo(fileK)) {
                file = fileK;
            } else {
                t.n(f28073f, "Failed to rename " + file + " to " + fileK);
            }
        }
        r rVarF = rVar.f(file, j10);
        this.f28076c.add(rVarF);
        return rVarF;
    }

    public void m(long j10) {
        for (int i10 = 0; i10 < this.f28077d.size(); i10++) {
            if (this.f28077d.get(i10).f28079a == j10) {
                this.f28077d.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public i(int i10, String str, n nVar) {
        this.f28074a = i10;
        this.f28075b = str;
        this.f28078e = nVar;
        this.f28076c = new TreeSet<>();
        this.f28077d = new ArrayList<>();
    }
}
