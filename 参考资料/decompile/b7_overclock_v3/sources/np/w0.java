package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class w0 extends u0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42559c;

    public w0(BigInteger bigInteger, v0 v0Var) {
        super(true, v0Var);
        this.f42559c = bigInteger;
    }

    public BigInteger e() {
        return this.f42559c;
    }

    @Override // np.u0
    public boolean equals(Object obj) {
        if ((obj instanceof w0) && ((w0) obj).e().equals(this.f42559c)) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // np.u0
    public int hashCode() {
        return e().hashCode();
    }
}
