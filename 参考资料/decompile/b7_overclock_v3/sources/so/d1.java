package so;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class d1 extends v1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public po.d f50133f;

    public d1(po.d dVar) {
        super(2);
        this.f50133f = dVar;
    }

    public d1(xn.d dVar, BigInteger bigInteger) {
        this(dVar, bigInteger, null);
    }

    public d1(xn.d dVar, BigInteger bigInteger, byte[] bArr) {
        this(new po.d(dVar, bigInteger, bArr));
    }

    public d1(byte[] bArr) {
        this(null, null, bArr);
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        return obj instanceof f1 ? ((f1) obj).j().equals(this) : this.f50133f.M(obj);
    }

    public xn.d b() {
        return this.f50133f.b();
    }

    public BigInteger c() {
        return this.f50133f.c();
    }

    @Override // so.v1, org.bouncycastle.util.q
    public Object clone() {
        return new d1(this.f50133f);
    }

    public byte[] d() {
        return this.f50133f.d();
    }

    public boolean equals(Object obj) {
        if (obj instanceof d1) {
            return this.f50133f.equals(((d1) obj).f50133f);
        }
        return false;
    }

    public int hashCode() {
        return this.f50133f.hashCode();
    }
}
