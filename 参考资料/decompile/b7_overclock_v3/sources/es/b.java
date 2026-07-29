package es;

import gm.c0;
import gm.f0;
import gm.h0;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.PKCSIOException;
import pn.s;
import zn.a0;
import zn.c1;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static pn.a[] f27113b = new pn.a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pn.e f27114a;

    public b(pn.e eVar) {
        Objects.requireNonNull(eVar, "certificationRequest cannot be null");
        this.f27114a = eVar;
    }

    public b(byte[] bArr) throws IOException {
        this(j(bArr));
    }

    public static pn.e j(byte[] bArr) throws IOException {
        try {
            pn.e eVarY = pn.e.y(c0.D(bArr));
            if (eVarY != null) {
                return eVarY;
            }
            throw new PKCSIOException("empty data passed to constructor");
        } catch (ClassCastException e10) {
            throw new PKCSIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new PKCSIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public pn.a[] a() {
        h0 h0VarX = this.f27114a.x().x();
        if (h0VarX == null) {
            return f27113b;
        }
        pn.a[] aVarArr = new pn.a[h0VarX.size()];
        for (int i10 = 0; i10 != h0VarX.size(); i10++) {
            aVarArr[i10] = pn.a.A(h0VarX.J(i10));
        }
        return aVarArr;
    }

    public pn.a[] b(y yVar) {
        h0 h0VarX = this.f27114a.x().x();
        if (h0VarX == null) {
            return f27113b;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != h0VarX.size(); i10++) {
            pn.a aVarA = pn.a.A(h0VarX.J(i10));
            if (aVarA.x().C(yVar)) {
                arrayList.add(aVarA);
            }
        }
        return arrayList.size() == 0 ? f27113b : (pn.a[]) arrayList.toArray(new pn.a[arrayList.size()]);
    }

    public byte[] c() throws IOException {
        return this.f27114a.getEncoded();
    }

    public z d() {
        pn.a[] aVarArrA = a();
        for (int i10 = 0; i10 != aVarArrA.length; i10++) {
            pn.a aVar = aVarArrA[i10];
            if (aVar.x() == s.F4) {
                a0 a0Var = new a0();
                Enumeration enumerationL = f0.J(aVar.y().J(0)).L();
                while (enumerationL.hasMoreElements()) {
                    f0 f0VarJ = f0.J(enumerationL.nextElement());
                    boolean z10 = f0VarJ.size() == 3 && gm.f.J(f0VarJ.K(1)).L();
                    if (f0VarJ.size() == 2) {
                        a0Var.b(y.N(f0VarJ.K(0)), false, gm.z.I(f0VarJ.K(1)).J());
                    } else {
                        if (f0VarJ.size() != 3) {
                            throw new IllegalArgumentException("incorrect sequence size of Extension get " + f0VarJ.size() + " expected 2 or three");
                        }
                        a0Var.b(y.N(f0VarJ.K(0)), z10, gm.z.I(f0VarJ.K(2)).J());
                    }
                }
                return a0Var.e();
            }
        }
        return null;
    }

    public byte[] e() {
        return this.f27114a.z().L();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return k().equals(((b) obj).k());
        }
        return false;
    }

    public zn.b f() {
        return this.f27114a.A();
    }

    public xn.d g() {
        return xn.d.A(this.f27114a.x().z());
    }

    public c1 h() {
        return this.f27114a.x().A();
    }

    public int hashCode() {
        return k().hashCode();
    }

    public boolean i(cs.h hVar) throws PKCSException {
        pn.f fVarX = this.f27114a.x();
        try {
            cs.g gVarA = hVar.a(this.f27114a.A());
            OutputStream outputStreamB = gVarA.b();
            outputStreamB.write(fVarX.v(gm.j.f29713a));
            outputStreamB.close();
            return gVarA.verify(e());
        } catch (Exception e10) {
            throw new PKCSException("unable to process signature: " + e10.getMessage(), e10);
        }
    }

    public pn.e k() {
        return this.f27114a;
    }
}
