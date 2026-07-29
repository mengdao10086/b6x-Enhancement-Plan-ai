package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class r extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42519c;

    public r(BigInteger bigInteger, q qVar) {
        super(true, qVar);
        this.f42519c = bigInteger;
    }

    public BigInteger e() {
        return this.f42519c;
    }

    @Override // np.n
    public boolean equals(Object obj) {
        return (obj instanceof r) && ((r) obj).e().equals(this.f42519c) && super.equals(obj);
    }

    @Override // np.n
    public int hashCode() {
        return this.f42519c.hashCode() ^ super.hashCode();
    }
}
