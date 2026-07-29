package p000do;

import gm.c0;
import gm.d;
import gm.d2;
import gm.h;
import gm.i;
import gm.j;
import gm.j2;
import gm.u1;
import gm.w;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import zn.a0;
import zn.b;
import zn.d1;
import zn.e1;
import zn.f;
import zn.g;
import zn.o;
import zn.p;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set f26431a = Collections.unmodifiableSet(new HashSet());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f26432b = Collections.unmodifiableList(new ArrayList());

    public static void a(a0 a0Var, y yVar, boolean z10, h hVar) throws CertIOException {
        try {
            a0Var.a(yVar, z10, hVar);
        } catch (IOException e10) {
            throw new CertIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public static boolean[] b(d dVar) {
        if (dVar == null) {
            return null;
        }
        byte[] bArrH = dVar.H();
        int length = (bArrH.length * 8) - dVar.m();
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 != length; i10++) {
            zArr[i10] = (bArrH[i10 / 8] & (128 >>> (i10 % 8))) != 0;
        }
        return zArr;
    }

    public static u1 c(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i10 = 0; i10 != zArr.length; i10++) {
            int i11 = i10 / 8;
            bArr[i11] = (byte) (bArr[i11] | (zArr[i10] ? 1 << (7 - (i10 % 8)) : 0));
        }
        int length = zArr.length % 8;
        return length == 0 ? new u1(bArr) : new u1(bArr, 8 - length);
    }

    public static a0 d(a0 a0Var, y yVar) {
        z zVarE = a0Var.e();
        a0 a0Var2 = new a0();
        Enumeration enumerationI = zVarE.I();
        boolean z10 = false;
        while (enumerationI.hasMoreElements()) {
            y yVar2 = (y) enumerationI.nextElement();
            if (yVar2.C(yVar)) {
                z10 = true;
            } else {
                a0Var2.c(zVarE.z(yVar2));
            }
        }
        if (z10) {
            return a0Var2;
        }
        throw new IllegalArgumentException("remove - extension (OID = " + yVar + ") not found");
    }

    public static a0 e(a0 a0Var, zn.y yVar) {
        z zVarE = a0Var.e();
        a0 a0Var2 = new a0();
        Enumeration enumerationI = zVarE.I();
        boolean z10 = false;
        while (enumerationI.hasMoreElements()) {
            y yVar2 = (y) enumerationI.nextElement();
            if (yVar2.C(yVar.z())) {
                z10 = true;
                a0Var2.c(yVar);
            } else {
                a0Var2.c(zVarE.z(yVar2));
            }
        }
        if (z10) {
            return a0Var2;
        }
        throw new IllegalArgumentException("replace - original extension (OID = " + yVar.z() + ") not found");
    }

    public static f f(g gVar, b bVar, byte[] bArr) {
        i iVar = new i();
        iVar.a(gVar);
        iVar.a(bVar);
        iVar.a(new u1(bArr));
        return f.y(new j2(iVar));
    }

    public static p g(d1 d1Var, b bVar, byte[] bArr) {
        i iVar = new i();
        iVar.a(d1Var);
        iVar.a(bVar);
        iVar.a(new u1(bArr));
        return p.y(new j2(iVar));
    }

    public static X509AttributeCertificateHolder h(cs.f fVar, g gVar) {
        try {
            return new X509AttributeCertificateHolder(f(gVar, fVar.a(), k(fVar, gVar)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce attribute certificate signature");
        }
    }

    public static X509CRLHolder i(cs.f fVar, d1 d1Var) {
        try {
            return new X509CRLHolder(g(d1Var, fVar.a(), k(fVar, d1Var)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    public static X509CertificateHolder j(cs.f fVar, e1 e1Var) {
        try {
            return new X509CertificateHolder(l(e1Var, fVar.a(), k(fVar, e1Var)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    public static byte[] k(cs.f fVar, w wVar) throws IOException {
        OutputStream outputStreamB = fVar.b();
        wVar.u(outputStreamB, j.f29713a);
        outputStreamB.close();
        return fVar.getSignature();
    }

    public static o l(e1 e1Var, b bVar, byte[] bArr) {
        i iVar = new i();
        iVar.a(e1Var);
        iVar.a(bVar);
        iVar.a(new u1(bArr));
        return o.z(new j2(iVar));
    }

    public static Set m(z zVar) {
        return zVar == null ? f26431a : Collections.unmodifiableSet(new HashSet(Arrays.asList(zVar.y())));
    }

    public static List n(z zVar) {
        return zVar == null ? f26432b : Collections.unmodifiableList(Arrays.asList(zVar.B()));
    }

    public static Set o(z zVar) {
        return zVar == null ? f26431a : Collections.unmodifiableSet(new HashSet(Arrays.asList(zVar.H())));
    }

    public static boolean p(b bVar, b bVar2) {
        if (!bVar.x().C(bVar2.x())) {
            return false;
        }
        if (org.bouncycastle.util.p.d("org.bouncycastle.x509.allow_absent_equiv_NULL")) {
            if (bVar.A() == null) {
                return bVar2.A() == null || bVar2.A().equals(d2.f29657b);
            }
            if (bVar2.A() == null) {
                return bVar.A() == null || bVar.A().equals(d2.f29657b);
            }
        }
        if (bVar.A() != null) {
            return bVar.A().equals(bVar2.A());
        }
        if (bVar2.A() != null) {
            return bVar2.A().equals(bVar.A());
        }
        return true;
    }

    public static c0 q(byte[] bArr) throws IOException {
        c0 c0VarD = c0.D(bArr);
        if (c0VarD != null) {
            return c0VarD;
        }
        throw new IOException("no content found");
    }

    public static Date r(gm.o oVar) {
        try {
            return oVar.K();
        } catch (ParseException e10) {
            throw new IllegalStateException("unable to recover date: " + e10.getMessage());
        }
    }
}
