package ft;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class p extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f28794d = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, CommonNetImpl.FLAG_SHARE_JUMP, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f28795c;

    public p(p pVar) {
        this.f28773a = pVar.f28773a;
        this.f28774b = pVar.f28774b;
        this.f28795c = new f(pVar.f28795c);
    }

    public p(q qVar, f fVar) {
        this.f28773a = qVar;
        this.f28774b = qVar.d();
        f fVar2 = new f(fVar);
        this.f28795c = fVar2;
        fVar2.i(this.f28774b);
    }

    public p(q qVar, Random random) {
        this.f28773a = qVar;
        this.f28774b = qVar.d();
        this.f28795c = new f(this.f28774b);
        H(random);
    }

    public p(q qVar, byte[] bArr) {
        this.f28773a = qVar;
        this.f28774b = qVar.d();
        f fVar = new f(this.f28774b, bArr);
        this.f28795c = fVar;
        fVar.i(this.f28774b);
    }

    public p(q qVar, int[] iArr) {
        this.f28773a = qVar;
        this.f28774b = qVar.d();
        f fVar = new f(this.f28774b, iArr);
        this.f28795c = fVar;
        fVar.i(qVar.f28776b);
    }

    public static p A(q qVar) {
        return new p(qVar, new f(qVar.d()));
    }

    public static p z(q qVar) {
        return new p(qVar, new f(qVar.d(), new int[]{1}));
    }

    public final f B() {
        return new f(this.f28795c);
    }

    public final p C() throws RuntimeException {
        if ((this.f28774b & 1) == 0) {
            throw new RuntimeException();
        }
        p pVar = new p(this);
        for (int i10 = 1; i10 <= ((this.f28774b - 1) >> 1); i10++) {
            pVar.v();
            pVar.v();
            pVar.k(this);
        }
        return pVar;
    }

    public p D() throws ArithmeticException {
        if (e()) {
            throw new ArithmeticException();
        }
        f fVar = new f(this.f28774b + 32, "ONE");
        fVar.D();
        f fVar2 = new f(this.f28774b + 32);
        fVar2.D();
        f fVarB = B();
        f fVarE = this.f28773a.e();
        fVarB.D();
        while (!fVarB.p()) {
            fVarB.D();
            fVarE.D();
            int iL = fVarB.l() - fVarE.l();
            if (iL < 0) {
                iL = -iL;
                fVar.D();
                f fVar3 = fVar2;
                fVar2 = fVar;
                fVar = fVar3;
                f fVar4 = fVarE;
                fVarE = fVarB;
                fVarB = fVar4;
            }
            fVarB.M(fVarE, iL);
            fVar.M(fVar2, iL);
        }
        fVar.D();
        return new p((q) this.f28773a, fVar);
    }

    public p E() throws ArithmeticException {
        if (e()) {
            throw new ArithmeticException();
        }
        f fVar = new f(this.f28774b, "ONE");
        f fVar2 = new f(this.f28774b);
        f fVarB = B();
        f fVarE = this.f28773a.e();
        while (true) {
            if (!fVarB.U(0)) {
                fVarB.P();
                if (fVar.U(0)) {
                    fVar.b(this.f28773a.e());
                }
                fVar.P();
            } else {
                if (fVarB.p()) {
                    return new p((q) this.f28773a, fVar);
                }
                fVarB.D();
                fVarE.D();
                if (fVarB.l() < fVarE.l()) {
                    f fVar3 = fVar2;
                    fVar2 = fVar;
                    fVar = fVar3;
                    f fVar4 = fVarE;
                    fVarE = fVarB;
                    fVarB = fVar4;
                }
                fVarB.b(fVarE);
                fVar.b(fVar2);
            }
        }
    }

    public p F() throws ArithmeticException {
        if (e()) {
            throw new ArithmeticException();
        }
        int iD = this.f28773a.d() - 1;
        p pVar = new p(this);
        pVar.f28795c.i((this.f28774b << 1) + 32);
        pVar.f28795c.D();
        int i10 = 1;
        for (int iL = u.l(iD) - 1; iL >= 0; iL--) {
            p pVar2 = new p(pVar);
            for (int i11 = 1; i11 <= i10; i11++) {
                pVar2.Q();
            }
            pVar.a(pVar2);
            i10 <<= 1;
            if ((f28794d[iL] & iD) != 0) {
                pVar.Q();
                pVar.a(this);
                i10++;
            }
        }
        pVar.Q();
        return pVar;
    }

    public p G(int i10) {
        if (i10 == 1) {
            return new p(this);
        }
        p pVarZ = z((q) this.f28773a);
        if (i10 == 0) {
            return pVarZ;
        }
        p pVar = new p(this);
        pVar.f28795c.i((pVar.f28774b << 1) + 32);
        pVar.f28795c.D();
        for (int i11 = 0; i11 < this.f28774b; i11++) {
            if (((1 << i11) & i10) != 0) {
                pVarZ.a(pVar);
            }
            pVar.s();
        }
        return pVarZ;
    }

    public final void H(Random random) {
        this.f28795c.i(this.f28774b);
        this.f28795c.C(random);
    }

    public final void I(int[] iArr) {
        int i10 = this.f28774b;
        int i11 = i10 - iArr[2];
        int i12 = i10 - iArr[1];
        int i13 = i10 - iArr[0];
        for (int iL = this.f28795c.l() - 1; iL >= this.f28774b; iL--) {
            if (this.f28795c.U(iL)) {
                this.f28795c.c0(iL);
                this.f28795c.c0(iL - i11);
                this.f28795c.c0(iL - i12);
                this.f28795c.c0(iL - i13);
                this.f28795c.c0(iL - this.f28774b);
            }
        }
        this.f28795c.D();
        this.f28795c.i(this.f28774b);
    }

    public final void J() {
        if (this.f28795c.l() <= this.f28774b) {
            int iL = this.f28795c.l();
            int i10 = this.f28774b;
            if (iL < i10) {
                this.f28795c.i(i10);
                return;
            }
            return;
        }
        if (((q) this.f28773a).n()) {
            try {
                int iL2 = ((q) this.f28773a).l();
                if (this.f28774b - iL2 > 32) {
                    int iL3 = this.f28795c.l();
                    int i11 = this.f28774b;
                    if (iL3 <= (i11 << 1)) {
                        this.f28795c.F(i11, iL2);
                        return;
                    }
                }
                K(iL2);
                return;
            } catch (RuntimeException unused) {
                throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a trinomial");
            }
        }
        if (!((q) this.f28773a).m()) {
            f fVarG = this.f28795c.G(this.f28773a.e());
            this.f28795c = fVarG;
            fVarG.i(this.f28774b);
            return;
        }
        try {
            int[] iArrJ = ((q) this.f28773a).j();
            if (this.f28774b - iArrJ[2] > 32) {
                int iL4 = this.f28795c.l();
                int i12 = this.f28774b;
                if (iL4 <= (i12 << 1)) {
                    this.f28795c.E(i12, iArrJ);
                    return;
                }
            }
            I(iArrJ);
        } catch (RuntimeException unused2) {
            throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a pentanomial");
        }
    }

    public final void K(int i10) {
        int i11 = this.f28774b - i10;
        int iL = this.f28795c.l();
        while (true) {
            iL--;
            if (iL < this.f28774b) {
                this.f28795c.D();
                this.f28795c.i(this.f28774b);
                return;
            } else if (this.f28795c.U(iL)) {
                this.f28795c.c0(iL);
                this.f28795c.c0(iL - i11);
                this.f28795c.c0(iL - this.f28774b);
            }
        }
    }

    public p L() {
        p pVar = new p(this);
        pVar.O();
        pVar.J();
        return pVar;
    }

    public p M() {
        p pVar = new p(this);
        pVar.P();
        pVar.J();
        return pVar;
    }

    public p N() {
        p pVar = new p(this);
        pVar.Q();
        pVar.J();
        return pVar;
    }

    public void O() {
        this.f28795c.Q();
        J();
    }

    public void P() {
        f fVar = new f(this.f28774b);
        int i10 = 0;
        while (true) {
            if (i10 >= this.f28774b) {
                this.f28795c = fVar;
                return;
            } else {
                if (this.f28795c.a0(((q) this.f28773a).f28796f[(r2 - i10) - 1])) {
                    fVar.I(i10);
                }
                i10++;
            }
        }
    }

    public void Q() {
        this.f28795c.R();
        J();
    }

    @Override // ft.r
    public void a(r rVar) throws RuntimeException {
        if (!(rVar instanceof p)) {
            throw new RuntimeException();
        }
        p pVar = (p) rVar;
        if (!this.f28773a.equals(pVar.f28773a)) {
            throw new RuntimeException();
        }
        if (equals(rVar)) {
            v();
        } else {
            this.f28795c = this.f28795c.y(pVar.f28795c);
            J();
        }
    }

    @Override // ft.r
    public r b(r rVar) throws RuntimeException {
        p pVar = new p(this);
        pVar.a(rVar);
        return pVar;
    }

    @Override // ft.k, ft.r
    public Object clone() {
        return new p(this);
    }

    @Override // ft.r
    public r d(r rVar) throws RuntimeException {
        p pVar = new p(this);
        pVar.k(rVar);
        return pVar;
    }

    @Override // ft.r
    public boolean e() {
        return this.f28795c.q();
    }

    @Override // ft.r
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        l lVar = this.f28773a;
        if (lVar == pVar.f28773a || lVar.e().equals(pVar.f28773a.e())) {
            return this.f28795c.equals(pVar.f28795c);
        }
        return false;
    }

    @Override // ft.r
    public r f() throws ArithmeticException {
        return E();
    }

    @Override // ft.r
    public boolean g() {
        return this.f28795c.p();
    }

    @Override // ft.r
    public int hashCode() {
        return this.f28773a.hashCode() + this.f28795c.hashCode();
    }

    @Override // ft.r
    public String i(int i10) {
        return this.f28795c.Y(i10);
    }

    @Override // ft.r
    public BigInteger j() {
        return this.f28795c.W();
    }

    @Override // ft.r
    public void k(r rVar) throws RuntimeException {
        if (!(rVar instanceof p)) {
            throw new RuntimeException();
        }
        p pVar = (p) rVar;
        if (!this.f28773a.equals(pVar.f28773a)) {
            throw new RuntimeException();
        }
        this.f28795c.b(pVar.f28795c);
    }

    @Override // ft.k
    public void l() {
        this.f28795c.d();
    }

    @Override // ft.k
    public void m() {
        this.f28795c.f();
    }

    @Override // ft.k
    public k p() {
        p pVar = new p(this);
        pVar.q();
        return pVar;
    }

    @Override // ft.k
    public void q() {
        this.f28795c.n();
    }

    @Override // ft.k
    public k r() throws RuntimeException {
        p pVarA;
        p pVar;
        if (e()) {
            return A((q) this.f28773a);
        }
        if ((this.f28774b & 1) == 1) {
            return C();
        }
        do {
            p pVar2 = new p((q) this.f28773a, new Random());
            pVarA = A((q) this.f28773a);
            pVar = (p) pVar2.clone();
            for (int i10 = 1; i10 < this.f28774b; i10++) {
                pVarA.v();
                pVar.v();
                pVarA.k(pVar.b(this));
                pVar.k(pVar2);
            }
        } while (pVar.e());
        if (equals(pVarA.s().d(pVarA))) {
            return pVarA;
        }
        throw new RuntimeException();
    }

    @Override // ft.k
    public k s() {
        return N();
    }

    @Override // ft.k
    public k t() {
        p pVar = new p(this);
        pVar.u();
        return pVar;
    }

    @Override // ft.r
    public byte[] toByteArray() {
        return this.f28795c.V();
    }

    @Override // ft.r
    public String toString() {
        return this.f28795c.Y(16);
    }

    @Override // ft.k
    public void u() {
        this.f28795c.i((this.f28774b << 1) + 32);
        this.f28795c.D();
        for (int i10 = 0; i10 < this.f28773a.d() - 1; i10++) {
            v();
        }
    }

    @Override // ft.k
    public void v() {
        Q();
    }

    @Override // ft.k
    public boolean w(int i10) {
        return this.f28795c.U(i10);
    }

    @Override // ft.k
    public boolean x() {
        return this.f28795c.U(0);
    }

    @Override // ft.k
    public int y() {
        p pVar = new p(this);
        for (int i10 = 1; i10 < this.f28774b; i10++) {
            pVar.v();
            pVar.k(this);
        }
        return pVar.g() ? 1 : 0;
    }
}
