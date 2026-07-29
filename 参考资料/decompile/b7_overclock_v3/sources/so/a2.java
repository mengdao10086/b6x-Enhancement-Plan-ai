package so;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class a2 implements org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public po.d f50061a;

    public a2(po.d dVar) {
        this.f50061a = dVar;
    }

    public a2(xn.d dVar, BigInteger bigInteger) {
        this(dVar, bigInteger, null);
    }

    public a2(xn.d dVar, BigInteger bigInteger, byte[] bArr) {
        this(new po.d(dVar, bigInteger, bArr));
    }

    public a2(byte[] bArr) {
        this(null, null, bArr);
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        return obj instanceof d2 ? ((d2) obj).m().equals(this) : this.f50061a.M(obj);
    }

    public xn.d a() {
        return this.f50061a.b();
    }

    public BigInteger b() {
        return this.f50061a.c();
    }

    public byte[] c() {
        return this.f50061a.d();
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new a2(this.f50061a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a2) {
            return this.f50061a.equals(((a2) obj).f50061a);
        }
        return false;
    }

    public int hashCode() {
        return this.f50061a.hashCode();
    }
}
