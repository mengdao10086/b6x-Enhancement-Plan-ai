package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class j extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f42442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f42443e;

    public j(h hVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, hVar);
        this.f42441c = bigInteger;
        this.f42442d = bigInteger2;
        this.f42443e = bigInteger3;
    }

    public BigInteger e() {
        return this.f42441c;
    }

    @Override // np.g
    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.e().equals(this.f42441c) && jVar.f().equals(this.f42442d) && jVar.g().equals(this.f42443e) && super.equals(obj);
    }

    public BigInteger f() {
        return this.f42442d;
    }

    public BigInteger g() {
        return this.f42443e;
    }

    @Override // np.g
    public int hashCode() {
        return ((this.f42441c.hashCode() ^ this.f42442d.hashCode()) ^ this.f42443e.hashCode()) ^ super.hashCode();
    }
}
