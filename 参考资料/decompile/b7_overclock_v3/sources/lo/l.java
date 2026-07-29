package lo;

import gm.d2;
import gm.f2;
import java.io.OutputStream;
import org.bouncycastle.cert.ocsp.OCSPException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zn.b f40099b = new zn.b(on.b.f44365i, d2.f29657b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.j f40100a;

    public l(nn.j jVar) {
        this.f40100a = jVar;
    }

    public l(xn.d dVar) {
        this.f40100a = new nn.j(dVar);
    }

    public l(c1 c1Var, cs.o oVar) throws OCSPException {
        try {
            if (!oVar.a().equals(f40099b)) {
                throw new IllegalArgumentException("only SHA-1 can be used with RespID - found: " + oVar.a().x());
            }
            OutputStream outputStreamB = oVar.b();
            outputStreamB.write(c1Var.C().H());
            outputStreamB.close();
            this.f40100a = new nn.j(new f2(oVar.c()));
        } catch (Exception e10) {
            throw new OCSPException("problem creating ID: " + e10, e10);
        }
    }

    public nn.j a() {
        return this.f40100a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return this.f40100a.equals(((l) obj).f40100a);
        }
        return false;
    }

    public int hashCode() {
        return this.f40100a.hashCode();
    }
}
