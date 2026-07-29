package po;

import gm.z;
import java.math.BigInteger;
import mm.y;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.q;

/* JADX INFO: loaded from: classes5.dex */
public class d implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f46930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f46931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46932c;

    public d(xn.d dVar, BigInteger bigInteger) {
        this(dVar, bigInteger, null);
    }

    public d(xn.d dVar, BigInteger bigInteger, byte[] bArr) {
        this.f46931b = dVar;
        this.f46932c = bigInteger;
        this.f46930a = bArr;
    }

    public d(byte[] bArr) {
        this(null, null, bArr);
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (obj instanceof X509CertificateHolder) {
            X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
            if (c() != null) {
                y yVar = new y(x509CertificateHolder.y());
                return yVar.y().equals(this.f46931b) && yVar.z().N(this.f46932c);
            }
            if (this.f46930a != null) {
                zn.y yVarB = x509CertificateHolder.b(zn.y.f59058e);
                if (yVarB == null) {
                    return org.bouncycastle.util.a.g(this.f46930a, a.a(x509CertificateHolder.p()));
                }
                return org.bouncycastle.util.a.g(this.f46930a, z.I(yVarB.C()).J());
            }
        } else if (obj instanceof byte[]) {
            return org.bouncycastle.util.a.g(this.f46930a, (byte[]) obj);
        }
        return false;
    }

    public final boolean a(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    public xn.d b() {
        return this.f46931b;
    }

    public BigInteger c() {
        return this.f46932c;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new d(this.f46931b, this.f46932c, this.f46930a);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f46930a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return org.bouncycastle.util.a.g(this.f46930a, dVar.f46930a) && a(this.f46932c, dVar.f46932c) && a(this.f46931b, dVar.f46931b);
    }

    public int hashCode() {
        int iS0 = org.bouncycastle.util.a.s0(this.f46930a);
        BigInteger bigInteger = this.f46932c;
        if (bigInteger != null) {
            iS0 ^= bigInteger.hashCode();
        }
        xn.d dVar = this.f46931b;
        return dVar != null ? iS0 ^ dVar.hashCode() : iS0;
    }
}
