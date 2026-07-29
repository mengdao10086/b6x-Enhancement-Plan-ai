package go;

import gm.c0;
import gm.r0;
import gm.y;
import java.io.IOException;
import om.s;
import om.u;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f29845c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29846d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f29847e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29848f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om.e f29849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final om.i f29850b;

    public c(om.e eVar) {
        this.f29849a = eVar;
        this.f29850b = eVar.y().z();
    }

    public c(byte[] bArr) throws IOException {
        this(k(bArr));
    }

    public static om.e k(byte[] bArr) throws IOException {
        try {
            return om.e.A(c0.D(bArr));
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public final om.a a(y yVar) {
        om.i iVar = this.f29850b;
        if (iVar == null) {
            return null;
        }
        om.a[] aVarArrY = iVar.y();
        for (int i10 = 0; i10 != aVarArrY.length; i10++) {
            if (aVarArrY[i10].y().C(yVar)) {
                return aVarArrY[i10];
            }
        }
        return null;
    }

    public om.g b() {
        return this.f29849a.y().y();
    }

    public e c(y yVar) {
        om.a aVarA = a(yVar);
        if (aVarA == null) {
            return null;
        }
        if (aVarA.y().C(om.b.f44268g)) {
            return new i(om.o.x(aVarA.z()));
        }
        if (aVarA.y().C(om.b.f44265d)) {
            return new p(r0.I(aVarA.z()));
        }
        if (aVarA.y().C(om.b.f44266e)) {
            return new a(r0.I(aVarA.z()));
        }
        return null;
    }

    public int d() {
        return this.f29849a.C().z();
    }

    public boolean e(y yVar) {
        return a(yVar) != null;
    }

    public boolean f() {
        return this.f29850b != null;
    }

    public boolean g() {
        return this.f29849a.C() != null;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f29849a.getEncoded();
    }

    public boolean h() {
        u uVarC = this.f29849a.C();
        return uVarC.z() == 1 && s.z(uVarC.y()).A().z() != null;
    }

    public boolean i(cs.h hVar) throws CRMFException, IllegalStateException {
        u uVarC = this.f29849a.C();
        if (uVarC.z() != 1) {
            throw new IllegalStateException("not Signing Key type of proof of possession");
        }
        s sVarZ = s.z(uVarC.y());
        if (sVarZ.A() == null || sVarZ.A().z() == null) {
            return m(hVar, sVarZ);
        }
        throw new IllegalStateException("verification requires password check");
    }

    public boolean j(cs.h hVar, k kVar, char[] cArr) throws CRMFException, IllegalStateException {
        u uVarC = this.f29849a.C();
        if (uVarC.z() != 1) {
            throw new IllegalStateException("not Signing Key type of proof of possession");
        }
        s sVarZ = s.z(uVarC.y());
        if (sVarZ.A() == null || sVarZ.A().A() != null) {
            throw new IllegalStateException("no PKMAC present in proof of possession");
        }
        if (new m(kVar).a(sVarZ.A().z(), cArr, b().B())) {
            return m(hVar, sVarZ);
        }
        return false;
    }

    public om.e l() {
        return this.f29849a;
    }

    public final boolean m(cs.h hVar, s sVar) throws CRMFException {
        try {
            cs.g gVarA = hVar.a(sVar.x());
            b.b(sVar.A() != null ? sVar.A() : this.f29849a.y(), gVarA.b());
            return gVarA.verify(sVar.B().L());
        } catch (OperatorCreationException e10) {
            throw new CRMFException("unable to create verifier: " + e10.getMessage(), e10);
        }
    }
}
