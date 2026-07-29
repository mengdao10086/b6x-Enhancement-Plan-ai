package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.util.Strings;
import zn.d1;
import zn.t1;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends X509CRLEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1.b f45449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f45450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f45452d;

    public g0(d1.b bVar) {
        this.f45449a = bVar;
        this.f45450b = null;
    }

    public g0(d1.b bVar, boolean z10, xn.d dVar) {
        this.f45449a = bVar;
        this.f45450b = c(z10, dVar);
    }

    public final zn.y a(gm.y yVar) {
        zn.z zVarX = this.f45449a.x();
        if (zVarX != null) {
            return zVarX.z(yVar);
        }
        return null;
    }

    public final Set b(boolean z10) {
        zn.z zVarX = this.f45449a.x();
        if (zVarX == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumerationI = zVarX.I();
        while (enumerationI.hasMoreElements()) {
            gm.y yVar = (gm.y) enumerationI.nextElement();
            if (z10 == zVarX.z(yVar).D()) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    public final xn.d c(boolean z10, xn.d dVar) {
        zn.b0[] b0VarArrB;
        int i10;
        if (!z10) {
            return null;
        }
        zn.y yVarA = a(zn.y.f59072q);
        if (yVarA == null) {
            return dVar;
        }
        try {
            b0VarArrB = zn.c0.A(yVarA.C()).B();
        } catch (Exception unused) {
        }
        for (i10 = 0; i10 < b0VarArrB.length; i10++) {
            if (b0VarArrB[i10].q() == 4) {
                return xn.d.A(b0VarArrB[i10].A());
            }
            return null;
        }
        return null;
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof g0 ? this.f45449a.equals(((g0) obj).f45449a) : super.equals(this);
    }

    @Override // java.security.cert.X509CRLEntry
    public X500Principal getCertificateIssuer() {
        if (this.f45450b == null) {
            return null;
        }
        try {
            return new X500Principal(this.f45450b.getEncoded());
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return b(true);
    }

    @Override // java.security.cert.X509CRLEntry
    public byte[] getEncoded() throws CRLException {
        try {
            return this.f45449a.v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        zn.y yVarA = a(new gm.y(str));
        if (yVarA == null) {
            return null;
        }
        try {
            return yVarA.A().getEncoded();
        } catch (Exception e10) {
            throw new RuntimeException("error encoding " + e10.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return b(false);
    }

    @Override // java.security.cert.X509CRLEntry
    public Date getRevocationDate() {
        return this.f45449a.z().x();
    }

    @Override // java.security.cert.X509CRLEntry
    public BigInteger getSerialNumber() {
        return this.f45449a.A().K();
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean hasExtensions() {
        return this.f45449a.x() != null;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }

    @Override // java.security.cert.X509CRLEntry
    public int hashCode() {
        if (!this.f45452d) {
            this.f45451c = super.hashCode();
            this.f45452d = true;
        }
        return this.f45451c;
    }

    @Override // java.security.cert.X509CRLEntry
    public String toString() {
        Object objA;
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("      userCertificate: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(strE);
        stringBuffer.append("       revocationDate: ");
        stringBuffer.append(getRevocationDate());
        stringBuffer.append(strE);
        stringBuffer.append("       certificateIssuer: ");
        stringBuffer.append(getCertificateIssuer());
        stringBuffer.append(strE);
        zn.z zVarX = this.f45449a.x();
        if (zVarX != null) {
            Enumeration enumerationI = zVarX.I();
            if (enumerationI.hasMoreElements()) {
                String str = "   crlEntryExtensions:";
                loop0: while (true) {
                    stringBuffer.append(str);
                    while (true) {
                        stringBuffer.append(strE);
                        while (enumerationI.hasMoreElements()) {
                            gm.y yVar = (gm.y) enumerationI.nextElement();
                            zn.y yVarZ = zVarX.z(yVar);
                            if (yVarZ.A() != null) {
                                gm.s sVar = new gm.s(yVarZ.A().J());
                                stringBuffer.append("                       critical(");
                                stringBuffer.append(yVarZ.D());
                                stringBuffer.append(") ");
                                try {
                                    if (yVar.C(t1.f58954k)) {
                                        objA = zn.m.x(gm.k.I(sVar.n()));
                                    } else if (yVar.C(t1.f58959p)) {
                                        stringBuffer.append("Certificate issuer: ");
                                        objA = zn.c0.A(sVar.n());
                                    } else {
                                        stringBuffer.append(yVar.L());
                                        stringBuffer.append(" value = ");
                                        stringBuffer.append(wn.a.c(sVar.n()));
                                        stringBuffer.append(strE);
                                    }
                                    stringBuffer.append(objA);
                                    stringBuffer.append(strE);
                                } catch (Exception unused) {
                                    stringBuffer.append(yVar.L());
                                    stringBuffer.append(" value = ");
                                    str = "*****";
                                }
                            }
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
