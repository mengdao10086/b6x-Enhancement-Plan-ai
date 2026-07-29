package jo;

import java.io.IOException;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f36524d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f36525e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f36526f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f36527g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f36528h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f36529i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f36530j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f36532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X509CertificateHolder f36533c;

    public b(String str, byte[] bArr) throws IOException {
        this(str, org.bouncycastle.util.a.W(bArr, 0, 3), new X509CertificateHolder(org.bouncycastle.util.a.W(bArr, 3, bArr.length)));
    }

    public b(String str, byte[] bArr, X509CertificateHolder x509CertificateHolder) {
        this.f36532b = bArr;
        this.f36531a = str;
        this.f36533c = x509CertificateHolder;
    }

    public static boolean e(byte[] bArr) {
        return (bArr[0] >= 0 || bArr[0] <= 3) && bArr[1] == 0 && bArr[2] == 0;
    }

    public X509CertificateHolder a() {
        return this.f36533c;
    }

    public String b() {
        return this.f36531a;
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f36532b);
    }

    public byte[] d() throws IOException {
        byte[] encoded = this.f36533c.getEncoded();
        byte[] bArr = this.f36532b;
        byte[] bArr2 = new byte[bArr.length + encoded.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(encoded, 0, bArr2, this.f36532b.length, encoded.length);
        return bArr2;
    }
}
