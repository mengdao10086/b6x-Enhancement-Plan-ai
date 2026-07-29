package vo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f53329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger[] f53330c;

    public e(String str, BigInteger bigInteger, BigInteger[] bigIntegerArr) {
        g.w(str, "participantId");
        g.w(bigInteger, "a");
        g.w(bigIntegerArr, "knowledgeProofForX2s");
        this.f53328a = str;
        this.f53329b = bigInteger;
        this.f53330c = org.bouncycastle.util.a.T(bigIntegerArr, bigIntegerArr.length);
    }

    public BigInteger a() {
        return this.f53329b;
    }

    public BigInteger[] b() {
        BigInteger[] bigIntegerArr = this.f53330c;
        return org.bouncycastle.util.a.T(bigIntegerArr, bigIntegerArr.length);
    }

    public String c() {
        return this.f53328a;
    }
}
