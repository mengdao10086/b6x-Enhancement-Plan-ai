package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.j;
import gm.k;
import gm.s;
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
import zn.b0;
import zn.c0;
import zn.d1;
import zn.m;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes7.dex */
public class d extends X509CRLEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1.b f45085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f45086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f45087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f45088d;

    public d(d1.b bVar) {
        this.f45085a = bVar;
        this.f45086b = null;
    }

    public d(d1.b bVar, boolean z10, xn.d dVar) {
        this.f45085a = bVar;
        this.f45086b = c(z10, dVar);
    }

    public final y a(gm.y yVar) {
        z zVarX = this.f45085a.x();
        if (zVarX != null) {
            return zVarX.z(yVar);
        }
        return null;
    }

    public final Set b(boolean z10) {
        z zVarX = this.f45085a.x();
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
        b0[] b0VarArrB;
        int i10;
        if (!z10) {
            return null;
        }
        y yVarA = a(y.f59072q);
        if (yVarA == null) {
            return dVar;
        }
        try {
            b0VarArrB = c0.A(yVarA.C()).B();
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
        if (!(obj instanceof d)) {
            return super.equals(this);
        }
        d dVar = (d) obj;
        if (this.f45087c && dVar.f45087c && this.f45088d != dVar.f45088d) {
            return false;
        }
        return this.f45085a.equals(dVar.f45085a);
    }

    @Override // java.security.cert.X509CRLEntry
    public X500Principal getCertificateIssuer() {
        if (this.f45086b == null) {
            return null;
        }
        try {
            return new X500Principal(this.f45086b.getEncoded());
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
            return this.f45085a.v(j.f29713a);
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        y yVarA = a(new gm.y(str));
        if (yVarA == null) {
            return null;
        }
        try {
            return yVarA.A().getEncoded();
        } catch (Exception e10) {
            throw new IllegalStateException("Exception encoding: " + e10.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return b(false);
    }

    @Override // java.security.cert.X509CRLEntry
    public Date getRevocationDate() {
        return this.f45085a.z().x();
    }

    @Override // java.security.cert.X509CRLEntry
    public BigInteger getSerialNumber() {
        return this.f45085a.A().K();
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean hasExtensions() {
        return this.f45085a.x() != null;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }

    @Override // java.security.cert.X509CRLEntry
    public int hashCode() {
        if (!this.f45087c) {
            this.f45088d = super.hashCode();
            this.f45087c = true;
        }
        return this.f45088d;
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
        z zVarX = this.f45085a.x();
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
                            y yVarZ = zVarX.z(yVar);
                            if (yVarZ.A() != null) {
                                s sVar = new s(yVarZ.A().J());
                                stringBuffer.append("                       critical(");
                                stringBuffer.append(yVarZ.D());
                                stringBuffer.append(") ");
                                try {
                                    if (yVar.C(y.f59067l)) {
                                        objA = m.x(k.I(sVar.n()));
                                    } else if (yVar.C(y.f59072q)) {
                                        stringBuffer.append("Certificate issuer: ");
                                        objA = c0.A(sVar.n());
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
