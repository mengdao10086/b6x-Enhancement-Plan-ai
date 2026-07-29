package gt;

import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import org.bouncycastle.tsp.TSPException;
import zn.b0;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public un.j f30084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Date f30085b;

    public j(un.j jVar) throws TSPException, IOException {
        this.f30084a = jVar;
        try {
            this.f30085b = jVar.z().K();
        } catch (ParseException unused) {
            throw new TSPException("unable to parse genTime field");
        }
    }

    public un.a a() {
        return this.f30084a.x();
    }

    public byte[] b() throws IOException {
        return this.f30084a.getEncoded();
    }

    public z c() {
        return this.f30084a.y();
    }

    public Date d() {
        return this.f30085b;
    }

    public a e() {
        if (a() != null) {
            return new a(a());
        }
        return null;
    }

    public zn.b f() {
        return this.f30084a.B().x();
    }

    public y g() {
        return this.f30084a.B().x().x();
    }

    public byte[] h() {
        return this.f30084a.B().y();
    }

    public BigInteger i() {
        if (this.f30084a.C() != null) {
            return this.f30084a.C().K();
        }
        return null;
    }

    public y j() {
        return this.f30084a.E();
    }

    public BigInteger k() {
        return this.f30084a.F().K();
    }

    public b0 l() {
        return this.f30084a.G();
    }

    public boolean m() {
        return this.f30084a.D().L();
    }

    public un.j n() {
        return this.f30084a;
    }

    public un.j o() {
        return this.f30084a;
    }
}
