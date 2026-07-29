package lo;

import gm.c0;
import gm.s;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.ocsp.OCSPException;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f40081b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40082c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40083d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40084e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40085f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f40086g = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.g f40087a;

    public g(s sVar) throws IOException {
        try {
            nn.g gVarY = nn.g.y(sVar.n());
            this.f40087a = gVarY;
            if (gVarY == null) {
                throw new CertIOException("malformed response: no response data found");
            }
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed response: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed response: " + e11.getMessage(), e11);
        } catch (ASN1Exception e12) {
            throw new CertIOException("malformed response: " + e12.getMessage(), e12);
        }
    }

    public g(InputStream inputStream) throws IOException {
        this(new s(inputStream));
    }

    public g(nn.g gVar) {
        this.f40087a = gVar;
    }

    public g(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public byte[] a() throws IOException {
        return this.f40087a.getEncoded();
    }

    public Object b() throws OCSPException {
        nn.k kVarZ = this.f40087a.z();
        if (kVarZ == null) {
            return null;
        }
        if (!kVarZ.A().C(nn.e.f42257b)) {
            return kVarZ.z();
        }
        try {
            return new a(nn.a.z(c0.D(kVarZ.z().J())));
        } catch (Exception e10) {
            throw new OCSPException("problem decoding object: " + e10, e10);
        }
    }

    public int c() {
        return this.f40087a.A().y();
    }

    public nn.g d() {
        return this.f40087a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.f40087a.equals(((g) obj).f40087a);
        }
        return false;
    }

    public int hashCode() {
        return this.f40087a.hashCode();
    }
}
