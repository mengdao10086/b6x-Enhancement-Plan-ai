package zr;

import co.r;
import gm.j2;
import gm.t;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import mm.n;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.pem.PemGenerationException;
import pn.s;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class b implements lt.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y[] f59648c = {r.W0, on.b.f44366j};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f59649d = {jt.l.f36949q, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f59650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f59651b;

    public b(Object obj) {
        this.f59650a = obj;
        this.f59651b = null;
    }

    public b(Object obj, f fVar) {
        this.f59650a = obj;
        this.f59651b = fVar;
    }

    public final lt.b a(Object obj) throws IOException {
        byte[] encoded;
        String str;
        if (obj instanceof lt.b) {
            return (lt.b) obj;
        }
        if (obj instanceof lt.c) {
            return ((lt.c) obj).generate();
        }
        if (obj instanceof X509CertificateHolder) {
            encoded = ((X509CertificateHolder) obj).getEncoded();
            str = i.f59660f;
        } else if (obj instanceof X509CRLHolder) {
            encoded = ((X509CRLHolder) obj).getEncoded();
            str = i.f59663i;
        } else if (obj instanceof m) {
            encoded = ((m) obj).b();
            str = i.f59661g;
        } else if (obj instanceof u) {
            u uVar = (u) obj;
            y yVarX = uVar.B().x();
            if (yVarX.C(s.f46854x3)) {
                encoded = uVar.G().b().getEncoded();
                str = i.f59670p;
            } else {
                y[] yVarArr = f59648c;
                if (yVarX.C(yVarArr[0]) || yVarX.C(yVarArr[1])) {
                    zn.s sVarZ = zn.s.z(uVar.B().A());
                    gm.i iVar = new gm.i();
                    iVar.a(new t(0L));
                    iVar.a(new t(sVarZ.A()));
                    iVar.a(new t(sVarZ.B()));
                    iVar.a(new t(sVarZ.x()));
                    BigInteger bigIntegerK = t.I(uVar.G()).K();
                    iVar.a(new t(sVarZ.x().modPow(bigIntegerK, sVarZ.A())));
                    iVar.a(new t(bigIntegerK));
                    encoded = new j2(iVar).getEncoded();
                    str = i.f59671q;
                } else if (yVarX.C(r.f11174l0)) {
                    encoded = uVar.G().b().getEncoded();
                    str = i.f59672r;
                } else {
                    encoded = uVar.getEncoded();
                    str = i.f59674t;
                }
            }
        } else if (obj instanceof c1) {
            encoded = ((c1) obj).getEncoded();
            str = i.f59668n;
        } else if (obj instanceof X509AttributeCertificateHolder) {
            encoded = ((X509AttributeCertificateHolder) obj).getEncoded();
            str = i.f59666l;
        } else if (obj instanceof es.b) {
            encoded = ((es.b) obj).c();
            str = i.f59658d;
        } else if (obj instanceof es.k) {
            encoded = ((es.k) obj).b();
            str = i.f59673s;
        } else {
            if (!(obj instanceof n)) {
                throw new PemGenerationException("unknown object passed - can't encode.");
            }
            encoded = ((n) obj).getEncoded();
            str = i.f59664j;
        }
        f fVar = this.f59651b;
        if (fVar == null) {
            return new lt.b(str, encoded);
        }
        String strO = Strings.o(fVar.getAlgorithm());
        if (strO.equals("DESEDE")) {
            strO = "DES-EDE3-CBC";
        }
        byte[] bArrB = this.f59651b.b();
        byte[] bArrA = this.f59651b.a(encoded);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new lt.a("Proc-Type", "4,ENCRYPTED"));
        arrayList.add(new lt.a("DEK-Info", strO + ag.c.f654g + b(bArrB)));
        return new lt.b(str, arrayList, bArrA);
    }

    public final String b(byte[] bArr) throws IOException {
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            byte[] bArr2 = f59649d;
            cArr[i12] = (char) bArr2[i11 >>> 4];
            cArr[i12 + 1] = (char) bArr2[i11 & 15];
        }
        return new String(cArr);
    }

    @Override // lt.c
    public lt.b generate() throws PemGenerationException {
        try {
            return a(this.f59650a);
        } catch (IOException e10) {
            throw new PemGenerationException("encoding exception: " + e10.getMessage(), e10);
        }
    }
}
