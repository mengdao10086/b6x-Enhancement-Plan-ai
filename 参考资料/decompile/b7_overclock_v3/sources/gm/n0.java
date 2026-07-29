package gm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n0 extends c0 implements o0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f29747e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29748f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f29749g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f29750h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f29753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f29754d;

    public n0(int i10, int i11, int i12, h hVar) {
        Objects.requireNonNull(hVar, "'obj' cannot be null");
        if (i11 == 0 || (i11 & 192) != i11) {
            throw new IllegalArgumentException("invalid tag class: " + i11);
        }
        this.f29751a = hVar instanceof g ? 1 : i10;
        this.f29752b = i11;
        this.f29753c = i12;
        this.f29754d = hVar;
    }

    public n0(boolean z10, int i10, int i11, h hVar) {
        this(z10 ? 1 : 2, i10, i11, hVar);
    }

    public n0(boolean z10, int i10, h hVar) {
        this(z10, 128, i10, hVar);
    }

    public static n0 G(c0 c0Var) {
        if (c0Var instanceof n0) {
            return (n0) c0Var;
        }
        throw new IllegalStateException("unexpected object: " + c0Var.getClass().getName());
    }

    public static c0 H(int i10, int i11, i iVar) {
        d3 d3Var = iVar.i() == 1 ? new d3(3, i10, i11, iVar.g(0)) : new d3(4, i10, i11, x2.a(iVar));
        return i10 != 64 ? d3Var : new t2(d3Var);
    }

    public static c0 I(int i10, int i11, i iVar) {
        n1 n1Var = iVar.i() == 1 ? new n1(3, i10, i11, iVar.g(0)) : new n1(4, i10, i11, c1.a(iVar));
        return i10 != 64 ? n1Var : new y0(n1Var);
    }

    public static c0 J(int i10, int i11, byte[] bArr) {
        d3 d3Var = new d3(4, i10, i11, new f2(bArr));
        return i10 != 64 ? d3Var : new t2(d3Var);
    }

    public static n0 S(n0 n0Var, boolean z10) {
        if (128 != n0Var.r()) {
            throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
        }
        if (z10) {
            return n0Var.Q();
        }
        throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
    }

    public static n0 T(Object obj) {
        if (obj == null || (obj instanceof n0)) {
            return (n0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof n0) {
                return (n0) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return G(c0.D((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.c0
    public c0 E() {
        return new n2(this.f29751a, this.f29752b, this.f29753c, this.f29754d);
    }

    @Override // gm.c0
    public c0 F() {
        return new d3(this.f29751a, this.f29752b, this.f29753c, this.f29754d);
    }

    public abstract String K();

    public w L() {
        h hVar = this.f29754d;
        return hVar instanceof w ? (w) hVar : hVar.b();
    }

    public c0 M(boolean z10, int i10) {
        t0 t0VarA = u0.a(i10);
        if (t0VarA != null) {
            return N(z10, t0VarA);
        }
        throw new IllegalArgumentException("unsupported UNIVERSAL tag number: " + i10);
    }

    public c0 N(boolean z10, t0 t0Var) {
        if (z10) {
            if (W()) {
                return t0Var.b(this.f29754d.b());
            }
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        if (1 == this.f29751a) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        c0 c0VarB = this.f29754d.b();
        int i10 = this.f29751a;
        return i10 != 3 ? i10 != 4 ? t0Var.b(c0VarB) : c0VarB instanceof f0 ? t0Var.d((f0) c0VarB) : t0Var.e((f2) c0VarB) : t0Var.d(Y(c0VarB));
    }

    public byte[] O() {
        try {
            byte[] bArrV = this.f29754d.b().v(K());
            if (W()) {
                return bArrV;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrV);
            s.u(byteArrayInputStream, byteArrayInputStream.read());
            int iM = s.m(byteArrayInputStream, byteArrayInputStream.available(), false);
            int iAvailable = byteArrayInputStream.available();
            int i10 = iM < 0 ? iAvailable - 2 : iAvailable;
            if (i10 < 0) {
                throw new ASN1ParsingException("failed to get contents");
            }
            byte[] bArr = new byte[i10];
            System.arraycopy(bArrV, bArrV.length - iAvailable, bArr, 0, i10);
            return bArr;
        } catch (IOException e10) {
            throw new ASN1ParsingException("failed to get contents", e10);
        }
    }

    public w P() {
        if (!W()) {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        h hVar = this.f29754d;
        return hVar instanceof w ? (w) hVar : hVar.b();
    }

    public n0 Q() {
        if (W()) {
            return G(this.f29754d.b());
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public n0 R(int i10, int i11) {
        if (i10 == 0 || (i10 & 192) != i10) {
            throw new IllegalArgumentException("invalid base tag class: " + i10);
        }
        int i12 = this.f29751a;
        if (i12 != 1) {
            return i12 != 2 ? Z(i10, i11) : v0.a(G(this.f29754d.b()), i10, i11);
        }
        throw new IllegalStateException("object explicit - implicit expected.");
    }

    public c0 U() {
        if (128 == r()) {
            return this.f29754d.b();
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public boolean V() {
        return z();
    }

    public boolean W() {
        int i10 = this.f29751a;
        return i10 == 1 || i10 == 3;
    }

    public boolean X() {
        int i10 = this.f29751a;
        return i10 == 3 || i10 == 4;
    }

    public abstract f0 Y(c0 c0Var);

    public abstract n0 Z(int i10, int i11);

    @Override // gm.o0
    public boolean e(int i10, int i11) {
        return this.f29752b == i10 && this.f29753c == i11;
    }

    @Override // gm.o0
    public o0 f(int i10, int i11) throws IOException {
        return R(i10, i11);
    }

    @Override // gm.o0
    public h g() throws IOException {
        return P();
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return (((this.f29752b * 7919) ^ this.f29753c) ^ (W() ? 15 : 240)) ^ this.f29754d.b().hashCode();
    }

    @Override // gm.o0
    public o0 j() throws IOException {
        return Q();
    }

    @Override // gm.o0
    public h l(int i10, boolean z10) throws IOException {
        if (128 == r()) {
            return p(z10, i10);
        }
        throw new ASN1Exception("this method only valid for CONTEXT_SPECIFIC tags");
    }

    @Override // gm.h3
    public final c0 o() {
        return this;
    }

    @Override // gm.o0
    public h p(boolean z10, int i10) throws IOException {
        c0 c0VarM = M(z10, i10);
        return i10 != 3 ? i10 != 4 ? i10 != 16 ? i10 != 17 ? c0VarM : ((h0) c0VarM).M() : ((f0) c0VarM).M() : ((z) c0VarM).K() : ((d) c0VarM).O();
    }

    @Override // gm.o0
    public int q() {
        return this.f29753c;
    }

    @Override // gm.o0
    public int r() {
        return this.f29752b;
    }

    @Override // gm.o0
    public boolean s(int i10) {
        return this.f29752b == 128 && this.f29753c == i10;
    }

    public String toString() {
        return v0.k(this.f29752b, this.f29753c) + this.f29754d;
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof a) {
            return c0Var.C(this);
        }
        if (!(c0Var instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) c0Var;
        if (this.f29753c != n0Var.f29753c || this.f29752b != n0Var.f29752b) {
            return false;
        }
        if (this.f29751a != n0Var.f29751a && W() != n0Var.W()) {
            return false;
        }
        c0 c0VarB = this.f29754d.b();
        c0 c0VarB2 = n0Var.f29754d.b();
        if (c0VarB == c0VarB2) {
            return true;
        }
        if (W()) {
            return c0VarB.x(c0VarB2);
        }
        try {
            return org.bouncycastle.util.a.g(getEncoded(), n0Var.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }
}
