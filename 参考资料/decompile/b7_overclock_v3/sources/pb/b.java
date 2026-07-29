package pb;

import g.p0;
import hb.a0;
import hb.l;
import hb.r;
import hb.s;
import hb.t;
import hb.u;
import hd.c0;
import hd.u0;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import pb.i;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends i {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte f46534t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f46535u = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public u f46536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public a f46537s;

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u f46538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public u.a f46539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f46540c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f46541d = -1;

        public a(u uVar, u.a aVar) {
            this.f46538a = uVar;
            this.f46539b = aVar;
        }

        @Override // pb.g
        public long a(l lVar) {
            long j10 = this.f46541d;
            if (j10 < 0) {
                return -1L;
            }
            long j11 = -(j10 + 2);
            this.f46541d = -1L;
            return j11;
        }

        @Override // pb.g
        public a0 b() {
            hd.a.i(this.f46540c != -1);
            return new t(this.f46538a, this.f46540c);
        }

        @Override // pb.g
        public void c(long j10) {
            long[] jArr = this.f46539b.f30917a;
            this.f46541d = jArr[u0.j(jArr, j10, true, true)];
        }

        public void d(long j10) {
            this.f46540c = j10;
        }
    }

    public static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(c0 c0Var) {
        return c0Var.a() >= 5 && c0Var.G() == 127 && c0Var.I() == 1179402563;
    }

    @Override // pb.i
    public long f(c0 c0Var) {
        if (o(c0Var.d())) {
            return n(c0Var);
        }
        return -1L;
    }

    @Override // pb.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean i(c0 c0Var, long j10, i.b bVar) {
        byte[] bArrD = c0Var.d();
        u uVar = this.f46536r;
        if (uVar == null) {
            u uVar2 = new u(bArrD, 17);
            this.f46536r = uVar2;
            bVar.f46590a = uVar2.i(Arrays.copyOfRange(bArrD, 9, c0Var.f()), null);
            return true;
        }
        if ((bArrD[0] & 127) == 3) {
            u.a aVarH = s.h(c0Var);
            u uVarC = uVar.c(aVarH);
            this.f46536r = uVarC;
            this.f46537s = new a(uVarC, aVarH);
            return true;
        }
        if (!o(bArrD)) {
            return true;
        }
        a aVar = this.f46537s;
        if (aVar != null) {
            aVar.d(j10);
            bVar.f46591b = this.f46537s;
        }
        hd.a.g(bVar.f46590a);
        return false;
    }

    @Override // pb.i
    public void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f46536r = null;
            this.f46537s = null;
        }
    }

    public final int n(c0 c0Var) {
        int i10 = (c0Var.d()[2] & 255) >> 4;
        if (i10 == 6 || i10 == 7) {
            c0Var.T(4);
            c0Var.N();
        }
        int iJ = r.j(c0Var, i10);
        c0Var.S(0);
        return iJ;
    }
}
