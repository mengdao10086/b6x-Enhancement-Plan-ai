package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f42421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.s f42424d;

    public h(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, org.bouncycastle.crypto.s sVar) {
        this.f42421a = bigInteger;
        this.f42422b = bigInteger2;
        this.f42423c = bigInteger3;
        org.bouncycastle.crypto.s sVar2 = (org.bouncycastle.crypto.s) ((org.bouncycastle.util.m) sVar).d();
        this.f42424d = sVar2;
        sVar2.reset();
    }

    public BigInteger a() {
        return this.f42422b;
    }

    public BigInteger b() {
        return this.f42423c;
    }

    public org.bouncycastle.crypto.s c() {
        return (org.bouncycastle.crypto.s) ((org.bouncycastle.util.m) this.f42424d).d();
    }

    public BigInteger d() {
        return this.f42421a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.d().equals(this.f42421a) && hVar.a().equals(this.f42422b) && hVar.b().equals(this.f42423c);
    }

    public int hashCode() {
        return (d().hashCode() ^ a().hashCode()) ^ b().hashCode();
    }
}
