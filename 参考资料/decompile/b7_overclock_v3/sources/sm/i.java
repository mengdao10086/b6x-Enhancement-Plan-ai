package sm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.y;
import gm.z;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class i extends l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f49980j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f49981k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f49982l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f49983m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49984n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f49985o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f49986p = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f49987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f49988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f49989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f49990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f49991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f49992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f49993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BigInteger f49994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49995i;

    public i(f0 f0Var) throws IllegalArgumentException {
        Enumeration enumerationL = f0Var.L();
        this.f49987a = y.N(enumerationL.nextElement());
        this.f49995i = 0;
        while (enumerationL.hasMoreElements()) {
            Object objNextElement = enumerationL.nextElement();
            if (!(objNextElement instanceof n0)) {
                throw new IllegalArgumentException("Unknown Object Identifier!");
            }
            n0 n0Var = (n0) objNextElement;
            switch (n0Var.q()) {
                case 1:
                    M(n.y(n0Var).z());
                    break;
                case 2:
                    K(n.y(n0Var).z());
                    break;
                case 3:
                    O(n.y(n0Var).z());
                    break;
                case 4:
                    I(z.H(n0Var, false));
                    break;
                case 5:
                    L(n.y(n0Var).z());
                    break;
                case 6:
                    N(z.H(n0Var, false));
                    break;
                case 7:
                    J(n.y(n0Var).z());
                    break;
                default:
                    this.f49995i = 0;
                    throw new IllegalArgumentException("Unknown Object Identifier!");
            }
        }
        int i10 = this.f49995i;
        if (i10 != 32 && i10 != 127) {
            throw new IllegalArgumentException("All options must be either present or absent!");
        }
    }

    public i(y yVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, BigInteger bigInteger4, byte[] bArr2, int i10) {
        this.f49987a = yVar;
        M(bigInteger);
        K(bigInteger2);
        O(bigInteger3);
        I(new f2(bArr));
        L(bigInteger4);
        N(new f2(bArr2));
        J(BigInteger.valueOf(i10));
    }

    public i(y yVar, byte[] bArr) throws IllegalArgumentException {
        this.f49987a = yVar;
        N(new f2(bArr));
    }

    public byte[] A() {
        if ((this.f49995i & 8) != 0) {
            return org.bouncycastle.util.a.p(this.f49991e);
        }
        return null;
    }

    public BigInteger B() {
        if ((this.f49995i & 64) != 0) {
            return this.f49994h;
        }
        return null;
    }

    public BigInteger C() {
        if ((this.f49995i & 2) != 0) {
            return this.f49989c;
        }
        return null;
    }

    public BigInteger D() {
        if ((this.f49995i & 16) != 0) {
            return this.f49992f;
        }
        return null;
    }

    public BigInteger E() {
        if ((this.f49995i & 1) != 0) {
            return this.f49988b;
        }
        return null;
    }

    public byte[] F() {
        if ((this.f49995i & 32) != 0) {
            return org.bouncycastle.util.a.p(this.f49993g);
        }
        return null;
    }

    public BigInteger G() {
        if ((this.f49995i & 4) != 0) {
            return this.f49990d;
        }
        return null;
    }

    public boolean H() {
        return this.f49988b != null;
    }

    public final void I(z zVar) throws IllegalArgumentException {
        int i10 = this.f49995i;
        if ((i10 & 8) != 0) {
            throw new IllegalArgumentException("Base Point G already set");
        }
        this.f49995i = i10 | 8;
        this.f49991e = zVar.J();
    }

    public final void J(BigInteger bigInteger) throws IllegalArgumentException {
        int i10 = this.f49995i;
        if ((i10 & 64) != 0) {
            throw new IllegalArgumentException("Cofactor F already set");
        }
        this.f49995i = i10 | 64;
        this.f49994h = bigInteger;
    }

    public final void K(BigInteger bigInteger) throws IllegalArgumentException {
        int i10 = this.f49995i;
        if ((i10 & 2) != 0) {
            throw new IllegalArgumentException("First Coef A already set");
        }
        this.f49995i = i10 | 2;
        this.f49989c = bigInteger;
    }

    public final void L(BigInteger bigInteger) throws IllegalArgumentException {
        int i10 = this.f49995i;
        if ((i10 & 16) != 0) {
            throw new IllegalArgumentException("Order of base point R already set");
        }
        this.f49995i = i10 | 16;
        this.f49992f = bigInteger;
    }

    public final void M(BigInteger bigInteger) {
        int i10 = this.f49995i;
        if ((i10 & 1) != 0) {
            throw new IllegalArgumentException("Prime Modulus P already set");
        }
        this.f49995i = i10 | 1;
        this.f49988b = bigInteger;
    }

    public final void N(z zVar) throws IllegalArgumentException {
        int i10 = this.f49995i;
        if ((i10 & 32) != 0) {
            throw new IllegalArgumentException("Public Point Y already set");
        }
        this.f49995i = i10 | 32;
        this.f49993g = zVar.J();
    }

    public final void O(BigInteger bigInteger) throws IllegalArgumentException {
        int i10 = this.f49995i;
        if ((i10 & 4) != 0) {
            throw new IllegalArgumentException("Second Coef B already set");
        }
        this.f49995i = i10 | 4;
        this.f49990d = bigInteger;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new j2(z(this.f49987a, !H()));
    }

    @Override // sm.l
    public y y() {
        return this.f49987a;
    }

    public gm.i z(y yVar, boolean z10) {
        gm.i iVar = new gm.i(8);
        iVar.a(yVar);
        if (!z10) {
            iVar.a(new n(1, E()));
            iVar.a(new n(2, C()));
            iVar.a(new n(3, G()));
            iVar.a(new n2(false, 4, (gm.h) new f2(A())));
            iVar.a(new n(5, D()));
        }
        iVar.a(new n2(false, 6, (gm.h) new f2(F())));
        if (!z10) {
            iVar.a(new n(7, B()));
        }
        return iVar;
    }
}
