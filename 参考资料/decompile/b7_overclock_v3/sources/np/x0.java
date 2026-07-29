package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class x0 extends u0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42563c;

    public x0(BigInteger bigInteger, v0 v0Var) {
        super(false, v0Var);
        this.f42563c = bigInteger;
    }

    public BigInteger e() {
        return this.f42563c;
    }

    @Override // np.u0
    public boolean equals(Object obj) {
        return (obj instanceof x0) && ((x0) obj).e().equals(this.f42563c) && super.equals(obj);
    }

    @Override // np.u0
    public int hashCode() {
        return this.f42563c.hashCode() ^ super.hashCode();
    }
}
