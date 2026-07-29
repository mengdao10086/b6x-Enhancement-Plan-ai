package p000do;

import cs.o;
import cs.p;
import gm.t;
import gm.y;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.q;
import xn.d;
import zn.b;
import zn.b0;
import zn.c0;
import zn.f0;
import zn.h0;
import zn.o0;

/* JADX INFO: loaded from: classes5.dex */
public class a implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static p f26428b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f26429a;

    public a(int i10, y yVar, y yVar2, byte[] bArr) {
        this.f26429a = new f0(new o0(i10, yVar2, new b(yVar), org.bouncycastle.util.a.p(bArr)));
    }

    public a(gm.f0 f0Var) {
        this.f26429a = f0.z(f0Var);
    }

    public a(X509CertificateHolder x509CertificateHolder) {
        this.f26429a = new f0(new h0(a(x509CertificateHolder.f()), new t(x509CertificateHolder.l())));
    }

    public a(d dVar) {
        this.f26429a = new f0(a(dVar));
    }

    public a(d dVar, BigInteger bigInteger) {
        this.f26429a = new f0(new h0(a(dVar), new t(bigInteger)));
    }

    public static void k(p pVar) {
        f26428b = pVar;
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
        if (this.f26429a.x() != null) {
            return this.f26429a.x().B().N(x509CertificateHolder.l()) && j(x509CertificateHolder.f(), this.f26429a.x().z());
        }
        if (this.f26429a.y() != null && j(x509CertificateHolder.o(), this.f26429a.y())) {
            return true;
        }
        if (this.f26429a.A() != null) {
            try {
                o oVarA = f26428b.a(this.f26429a.A().x());
                OutputStream outputStreamB = oVarA.b();
                int iC = c();
                if (iC == 0) {
                    outputStreamB.write(x509CertificateHolder.p().getEncoded());
                } else if (iC == 1) {
                    outputStreamB.write(x509CertificateHolder.getEncoded());
                }
                outputStreamB.close();
                org.bouncycastle.util.a.g(oVarA.c(), f());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final c0 a(d dVar) {
        return new c0(new b0(dVar));
    }

    public b b() {
        if (this.f26429a.A() != null) {
            return this.f26429a.A().x();
        }
        return null;
    }

    public int c() {
        if (this.f26429a.A() != null) {
            return this.f26429a.A().y().M();
        }
        return -1;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new a((gm.f0) this.f26429a.b());
    }

    public d[] d() {
        if (this.f26429a.y() != null) {
            return h(this.f26429a.y().B());
        }
        return null;
    }

    public d[] e() {
        if (this.f26429a.x() != null) {
            return h(this.f26429a.x().z().B());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return this.f26429a.equals(((a) obj).f26429a);
        }
        return false;
    }

    public byte[] f() {
        if (this.f26429a.A() != null) {
            return this.f26429a.A().B().H();
        }
        return null;
    }

    public y g() {
        if (this.f26429a.A() == null) {
            return null;
        }
        new y(this.f26429a.A().C().L());
        return null;
    }

    public final d[] h(b0[] b0VarArr) {
        ArrayList arrayList = new ArrayList(b0VarArr.length);
        for (int i10 = 0; i10 != b0VarArr.length; i10++) {
            if (b0VarArr[i10].q() == 4) {
                arrayList.add(d.A(b0VarArr[i10].A()));
            }
        }
        return (d[]) arrayList.toArray(new d[arrayList.size()]);
    }

    public int hashCode() {
        return this.f26429a.hashCode();
    }

    public BigInteger i() {
        if (this.f26429a.x() != null) {
            return this.f26429a.x().B().K();
        }
        return null;
    }

    public final boolean j(d dVar, c0 c0Var) {
        b0[] b0VarArrB = c0Var.B();
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            b0 b0Var = b0VarArrB[i10];
            if (b0Var.q() == 4 && d.A(b0Var.A()).equals(dVar)) {
                return true;
            }
        }
        return false;
    }
}
