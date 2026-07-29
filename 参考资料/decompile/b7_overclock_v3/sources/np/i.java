package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class i extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f42432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f42433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f42434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BigInteger f42435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f42436h;

    public i(h hVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, hVar);
        this.f42431c = bigInteger;
        this.f42432d = bigInteger2;
        this.f42433e = bigInteger3;
        this.f42434f = bigInteger4;
        this.f42435g = bigInteger5;
    }

    public j e() {
        return this.f42436h;
    }

    @Override // np.g
    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return iVar.f().equals(this.f42431c) && iVar.g().equals(this.f42432d) && iVar.h().equals(this.f42433e) && iVar.i().equals(this.f42434f) && iVar.j().equals(this.f42435g) && super.equals(obj);
    }

    public BigInteger f() {
        return this.f42431c;
    }

    public BigInteger g() {
        return this.f42432d;
    }

    public BigInteger h() {
        return this.f42433e;
    }

    @Override // np.g
    public int hashCode() {
        return ((((this.f42431c.hashCode() ^ this.f42432d.hashCode()) ^ this.f42433e.hashCode()) ^ this.f42434f.hashCode()) ^ this.f42435g.hashCode()) ^ super.hashCode();
    }

    public BigInteger i() {
        return this.f42434f;
    }

    public BigInteger j() {
        return this.f42435g;
    }

    public void k(j jVar) {
        this.f42436h = jVar;
    }
}
