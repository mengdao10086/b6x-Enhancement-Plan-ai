package vo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f53324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f53325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BigInteger[] f53326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BigInteger[] f53327e;

    public d(String str, BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        g.w(str, "participantId");
        g.w(bigInteger, "gx1");
        g.w(bigInteger2, "gx2");
        g.w(bigIntegerArr, "knowledgeProofForX1");
        g.w(bigIntegerArr2, "knowledgeProofForX2");
        this.f53323a = str;
        this.f53324b = bigInteger;
        this.f53325c = bigInteger2;
        this.f53326d = org.bouncycastle.util.a.T(bigIntegerArr, bigIntegerArr.length);
        this.f53327e = org.bouncycastle.util.a.T(bigIntegerArr2, bigIntegerArr2.length);
    }

    public BigInteger a() {
        return this.f53324b;
    }

    public BigInteger b() {
        return this.f53325c;
    }

    public BigInteger[] c() {
        BigInteger[] bigIntegerArr = this.f53326d;
        return org.bouncycastle.util.a.T(bigIntegerArr, bigIntegerArr.length);
    }

    public BigInteger[] d() {
        BigInteger[] bigIntegerArr = this.f53327e;
        return org.bouncycastle.util.a.T(bigIntegerArr, bigIntegerArr.length);
    }

    public String e() {
        return this.f53323a;
    }
}
