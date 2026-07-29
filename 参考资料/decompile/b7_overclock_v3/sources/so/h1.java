package so;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h1 extends v1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public po.d f50186f;

    public h1(po.d dVar) {
        super(0);
        this.f50186f = dVar;
    }

    public h1(xn.d dVar, BigInteger bigInteger) {
        this(dVar, bigInteger, null);
    }

    public h1(xn.d dVar, BigInteger bigInteger, byte[] bArr) {
        this(new po.d(dVar, bigInteger, bArr));
    }

    public h1(byte[] bArr) {
        this(null, null, bArr);
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        return obj instanceof j1 ? ((j1) obj).j().equals(this) : this.f50186f.M(obj);
    }

    public xn.d b() {
        return this.f50186f.b();
    }

    public BigInteger c() {
        return this.f50186f.c();
    }

    @Override // so.v1, org.bouncycastle.util.q
    public Object clone() {
        return new h1(this.f50186f);
    }

    public byte[] d() {
        return this.f50186f.d();
    }

    public boolean equals(Object obj) {
        if (obj instanceof h1) {
            return this.f50186f.equals(((h1) obj).f50186f);
        }
        return false;
    }

    public int hashCode() {
        return this.f50186f.hashCode();
    }
}
