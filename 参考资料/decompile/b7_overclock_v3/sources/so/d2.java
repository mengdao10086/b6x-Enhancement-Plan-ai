package so;

import gm.l2;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignerDigestMismatchException;
import org.bouncycastle.cms.CMSVerifierCertificateNotValidException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2 f50134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f50135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f50136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gm.y f50137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f50138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public mm.b f50139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mm.b f50140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f50141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final mm.v0 f50142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zn.b f50143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zn.b f50144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final gm.h0 f50145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final gm.h0 f50146m;

    public d2(mm.v0 v0Var, gm.y yVar, d0 d0Var, byte[] bArr) {
        a2 a2Var;
        this.f50142i = v0Var;
        this.f50137d = yVar;
        this.f50138e = yVar == null;
        mm.u0 u0VarC = v0Var.C();
        boolean z10 = u0VarC.z();
        gm.h hVarX = u0VarC.x();
        if (z10) {
            a2Var = new a2(gm.z.I(hVarX).J());
        } else {
            mm.y yVarX = mm.y.x(hVarX);
            a2Var = new a2(yVarX.y(), yVarX.z().K());
        }
        this.f50134a = a2Var;
        this.f50143j = v0Var.y();
        this.f50145l = v0Var.x();
        this.f50146m = v0Var.D();
        this.f50144k = v0Var.z();
        this.f50136c = v0Var.A().J();
        this.f50135b = d0Var;
        this.f50141h = bArr;
    }

    public d2(d2 d2Var) {
        this(d2Var, d2Var.f50142i);
    }

    public d2(d2 d2Var, mm.v0 v0Var) {
        this.f50142i = v0Var;
        this.f50137d = d2Var.f50137d;
        this.f50138e = d2Var.t();
        this.f50134a = d2Var.m();
        this.f50143j = v0Var.y();
        this.f50145l = v0Var.x();
        this.f50146m = v0Var.D();
        this.f50144k = v0Var.z();
        this.f50136c = v0Var.A().J();
        this.f50135b = d2Var.f50135b;
        this.f50141h = d2Var.f50141h;
        this.f50139f = o();
        this.f50140g = r();
    }

    public static d2 a(d2 d2Var, e2 e2Var) {
        mm.v0 v0Var = d2Var.f50142i;
        mm.b bVarR = d2Var.r();
        gm.i iVarH = bVarR != null ? bVarR.h() : new gm.i();
        gm.i iVar = new gm.i();
        Iterator<d2> it2 = e2Var.b().iterator();
        while (it2.hasNext()) {
            iVar.a(it2.next().v());
        }
        iVarH.a(new mm.a(mm.j.f41341d, new l2(iVar)));
        return new d2(new mm.v0(v0Var.C(), v0Var.y(), v0Var.x(), v0Var.z(), v0Var.A(), new l2(iVarH)), d2Var.f50137d, d2Var.f50135b, null);
    }

    public static d2 u(d2 d2Var, mm.b bVar) {
        mm.v0 v0Var = d2Var.f50142i;
        return new d2(new mm.v0(v0Var.C(), v0Var.y(), v0Var.x(), v0Var.z(), v0Var.A(), bVar != null ? new l2(bVar.h()) : null), d2Var.f50137d, d2Var.f50135b, null);
    }

    public final void A() throws CMSException {
        gm.c0 c0VarQ = q(mm.j.f41339b, "message-digest");
        if (c0VarQ == null) {
            if (this.f50145l != null) {
                throw new CMSException("the message-digest signed attribute type MUST be present when there are any signed attributes present");
            }
        } else {
            if (!(c0VarQ instanceof gm.z)) {
                throw new CMSException("message-digest attribute value not of ASN.1 type 'OCTET STRING'");
            }
            if (!org.bouncycastle.util.a.I(this.f50141h, ((gm.z) c0VarQ).J())) {
                throw new CMSSignerDigestMismatchException("message-digest attribute value does not match calculated value");
            }
        }
    }

    public final boolean b(f2 f2Var) throws CMSException {
        String strF = q0.f50286a.f(k());
        try {
            cs.g gVarB = f2Var.b(this.f50144k, this.f50142i.y());
            try {
                OutputStream outputStreamB = gVarB.b();
                if (this.f50141h == null) {
                    cs.o oVarC = f2Var.c(i());
                    if (this.f50135b != null) {
                        OutputStream outputStreamB2 = oVarC.b();
                        if (this.f50145l != null) {
                            this.f50135b.d(outputStreamB2);
                            outputStreamB.write(j());
                        } else if (gVarB instanceof cs.e0) {
                            this.f50135b.d(outputStreamB2);
                        } else {
                            kt.e eVar = new kt.e(outputStreamB2, outputStreamB);
                            this.f50135b.d(eVar);
                            eVar.close();
                        }
                        outputStreamB2.close();
                    } else {
                        if (this.f50145l == null) {
                            throw new CMSException("data not encapsulated in signature - use detached constructor.");
                        }
                        outputStreamB.write(j());
                    }
                    this.f50141h = oVarC.c();
                } else if (this.f50145l == null) {
                    d0 d0Var = this.f50135b;
                    if (d0Var != null) {
                        d0Var.d(outputStreamB);
                    }
                } else {
                    outputStreamB.write(j());
                }
                outputStreamB.close();
                y();
                mm.b bVarO = o();
                x(bVarO);
                A();
                z(bVarO);
                try {
                    if (this.f50145l != null || this.f50141h == null || !(gVarB instanceof cs.e0)) {
                        return gVarB.verify(n());
                    }
                    cs.e0 e0Var = (cs.e0) gVarB;
                    return strF.equals("RSA") ? e0Var.c(new zn.t(new zn.b(this.f50143j.x(), gm.d2.f29657b), this.f50141h).v(gm.j.f29713a), n()) : e0Var.c(this.f50141h, n());
                } catch (IOException e10) {
                    throw new CMSException("can't process mime object to create signature.", e10);
                }
            } catch (IOException e11) {
                throw new CMSException("can't process mime object to create signature.", e11);
            } catch (OperatorCreationException e12) {
                throw new CMSException("can't create digest calculator: " + e12.getMessage(), e12);
            }
        } catch (OperatorCreationException e13) {
            throw new CMSException("can't create content verifier: " + e13.getMessage(), e13);
        }
    }

    public final byte[] c(gm.h hVar) throws IOException {
        if (hVar != null) {
            return hVar.b().getEncoded();
        }
        return null;
    }

    public byte[] d() {
        byte[] bArr = this.f50141h;
        if (bArr != null) {
            return org.bouncycastle.util.a.p(bArr);
        }
        throw new IllegalStateException("method can only be called after verify.");
    }

    public gm.y e() {
        return this.f50137d;
    }

    public e2 f() {
        mm.b bVarR = r();
        if (bVarR == null) {
            return new e2(new ArrayList(0));
        }
        ArrayList arrayList = new ArrayList();
        gm.i iVarE = bVarR.e(mm.j.f41341d);
        for (int i10 = 0; i10 < iVarE.i(); i10++) {
            gm.h0 h0VarY = ((mm.a) iVarE.g(i10)).y();
            h0VarY.size();
            Enumeration enumerationK = h0VarY.K();
            while (enumerationK.hasMoreElements()) {
                arrayList.add(new d2(mm.v0.B(enumerationK.nextElement()), null, new e0(n()), null));
            }
        }
        return new e2(arrayList);
    }

    public String g() {
        return this.f50143j.x().L();
    }

    public byte[] h() {
        try {
            return c(this.f50143j.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting digest parameters " + e10);
        }
    }

    public zn.b i() {
        return this.f50143j;
    }

    public byte[] j() throws IOException {
        gm.h0 h0Var = this.f50145l;
        if (h0Var != null) {
            return h0Var.v(gm.j.f29713a);
        }
        return null;
    }

    public String k() {
        return this.f50144k.x().L();
    }

    public byte[] l() {
        try {
            return c(this.f50144k.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public a2 m() {
        return this.f50134a;
    }

    public byte[] n() {
        return org.bouncycastle.util.a.p(this.f50136c);
    }

    public mm.b o() {
        gm.h0 h0Var = this.f50145l;
        if (h0Var != null && this.f50139f == null) {
            this.f50139f = new mm.b(h0Var);
        }
        return this.f50139f;
    }

    public final mm.w0 p() throws CMSException {
        gm.c0 c0VarQ = q(mm.j.f41340c, "signing-time");
        if (c0VarQ == null) {
            return null;
        }
        try {
            return mm.w0.z(c0VarQ);
        } catch (IllegalArgumentException unused) {
            throw new CMSException("signing-time attribute value not a valid 'Time' structure");
        }
    }

    public final gm.c0 q(gm.y yVar, String str) throws CMSException {
        gm.i iVarE;
        int i10;
        mm.b bVarR = r();
        if (bVarR != null && bVarR.e(yVar).i() > 0) {
            throw new CMSException("The " + str + " attribute MUST NOT be an unsigned attribute");
        }
        mm.b bVarO = o();
        if (bVarO == null || (i10 = (iVarE = bVarO.e(yVar)).i()) == 0) {
            return null;
        }
        if (i10 != 1) {
            throw new CMSException("The SignedAttributes in a signerInfo MUST NOT include multiple instances of the " + str + " attribute");
        }
        gm.h0 h0VarY = ((mm.a) iVarE.g(0)).y();
        if (h0VarY.size() == 1) {
            return h0VarY.J(0).b();
        }
        throw new CMSException("A " + str + " attribute MUST have a single attribute value");
    }

    public mm.b r() {
        gm.h0 h0Var = this.f50146m;
        if (h0Var != null && this.f50140g == null) {
            this.f50140g = new mm.b(h0Var);
        }
        return this.f50140g;
    }

    public int s() {
        return this.f50142i.E().Q();
    }

    public boolean t() {
        return this.f50138e;
    }

    public mm.v0 v() {
        return this.f50142i;
    }

    public boolean w(f2 f2Var) throws CMSException {
        mm.w0 w0VarP = p();
        if (!f2Var.d() || w0VarP == null || f2Var.a().w(w0VarP.x())) {
            return b(f2Var);
        }
        throw new CMSVerifierCertificateNotValidException("verifier not valid at signingTime");
    }

    public final void x(mm.b bVar) throws CMSException {
        mm.b bVarR = r();
        if (bVarR != null && bVarR.e(mm.j.f41344g).i() > 0) {
            throw new CMSException("A cmsAlgorithmProtect attribute MUST be a signed attribute");
        }
        if (bVar != null) {
            gm.i iVarE = bVar.e(mm.j.f41344g);
            if (iVarE.i() > 1) {
                throw new CMSException("Only one instance of a cmsAlgorithmProtect attribute can be present");
            }
            if (iVarE.i() > 0) {
                mm.a aVarA = mm.a.A(iVarE.g(0));
                if (aVarA.y().size() != 1) {
                    throw new CMSException("A cmsAlgorithmProtect attribute MUST contain exactly one value");
                }
                mm.i iVarY = mm.i.y(aVarA.z()[0]);
                if (!t0.p(iVarY.x(), this.f50142i.y())) {
                    throw new CMSException("CMS Algorithm Identifier Protection check failed for digestAlgorithm");
                }
                if (!t0.p(iVarY.A(), this.f50142i.z())) {
                    throw new CMSException("CMS Algorithm Identifier Protection check failed for signatureAlgorithm");
                }
            }
        }
    }

    public final void y() throws CMSException {
        gm.c0 c0VarQ = q(mm.j.f41338a, fh.e.f28453j);
        if (c0VarQ == null) {
            if (!this.f50138e && this.f50145l != null) {
                throw new CMSException("The content-type attribute type MUST be present whenever signed attributes are present in signed-data");
            }
        } else {
            if (this.f50138e) {
                throw new CMSException("[For counter signatures,] the signedAttributes field MUST NOT contain a content-type attribute");
            }
            if (!(c0VarQ instanceof gm.y)) {
                throw new CMSException("content-type attribute value not of ASN.1 type 'OBJECT IDENTIFIER'");
            }
            if (!((gm.y) c0VarQ).C(this.f50137d)) {
                throw new CMSException("content-type attribute value does not match eContentType");
            }
        }
    }

    public final void z(mm.b bVar) throws CMSException {
        if (bVar != null && bVar.e(mm.j.f41341d).i() > 0) {
            throw new CMSException("A countersignature attribute MUST NOT be a signed attribute");
        }
        mm.b bVarR = r();
        if (bVarR != null) {
            gm.i iVarE = bVarR.e(mm.j.f41341d);
            for (int i10 = 0; i10 < iVarE.i(); i10++) {
                if (mm.a.A(iVarE.g(i10)).y().size() < 1) {
                    throw new CMSException("A countersignature attribute MUST contain at least one AttributeValue");
                }
            }
        }
    }
}
