package cp;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f25605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f25606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f25607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f25608d;

    public q() {
    }

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f25605a = bigInteger;
        this.f25606b = bigInteger2;
        this.f25607c = bigInteger3;
        this.f25608d = bigInteger4;
    }

    public q(byte[] bArr) {
        int iA = org.bouncycastle.util.o.a(bArr, 0) + 4;
        this.f25605a = new BigInteger(org.bouncycastle.util.a.W(bArr, 4, iA));
        int iA2 = org.bouncycastle.util.o.a(bArr, iA);
        int i10 = iA + 4;
        int i11 = iA2 + i10;
        this.f25606b = new BigInteger(org.bouncycastle.util.a.W(bArr, i10, i11));
        int iA3 = org.bouncycastle.util.o.a(bArr, i11);
        int i12 = i11 + 4;
        int i13 = iA3 + i12;
        this.f25607c = new BigInteger(org.bouncycastle.util.a.W(bArr, i12, i13));
        int iA4 = org.bouncycastle.util.o.a(bArr, i13);
        int i14 = i13 + 4;
        this.f25608d = new BigInteger(org.bouncycastle.util.a.W(bArr, i14, iA4 + i14));
    }

    public BigInteger a() {
        return this.f25607c;
    }

    public BigInteger b() {
        return this.f25605a;
    }

    public BigInteger c() {
        return this.f25606b;
    }

    public BigInteger d() {
        return this.f25608d;
    }

    public void e(BigInteger bigInteger) {
        this.f25607c = bigInteger;
    }

    public void f(BigInteger bigInteger) {
        this.f25605a = bigInteger;
    }

    public void g(BigInteger bigInteger) {
        this.f25606b = bigInteger;
    }

    public void h(BigInteger bigInteger) {
        this.f25608d = bigInteger;
    }

    public byte[] i() {
        byte[] byteArray = this.f25605a.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.f25606b.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.f25607c.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.f25608d.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[length + length2 + length3 + length4 + 16];
        org.bouncycastle.util.o.h(length, bArr, 0);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        int i10 = length + 4;
        org.bouncycastle.util.o.h(length2, bArr, i10);
        int i11 = i10 + 4;
        System.arraycopy(byteArray2, 0, bArr, i11, length2);
        int i12 = i11 + length2;
        org.bouncycastle.util.o.h(length3, bArr, i12);
        int i13 = i12 + 4;
        System.arraycopy(byteArray3, 0, bArr, i13, length3);
        int i14 = i13 + length3;
        org.bouncycastle.util.o.h(length4, bArr, i14);
        System.arraycopy(byteArray4, 0, bArr, i14 + 4, length4);
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("u1: " + this.f25605a.toString());
        stringBuffer.append("\nu2: " + this.f25606b.toString());
        stringBuffer.append("\ne: " + this.f25607c.toString());
        stringBuffer.append("\nv: " + this.f25608d.toString());
        return stringBuffer.toString();
    }
}
