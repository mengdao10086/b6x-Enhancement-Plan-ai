package gt;

import gm.t;
import gm.y;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.tsp.TSPIOException;
import un.k;
import zn.a0;
import zn.z;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final cs.j f30039d = new cs.j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f30040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.f f30041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f30042c = new a0();

    public void a(y yVar, boolean z10, gm.h hVar) throws TSPIOException {
        c.a(this.f30042c, yVar, z10, hVar);
    }

    public void b(y yVar, boolean z10, byte[] bArr) {
        this.f30042c.b(yVar, z10, bArr);
    }

    public void c(String str, boolean z10, gm.h hVar) throws IOException {
        d(str, z10, hVar.b().getEncoded());
    }

    public void d(String str, boolean z10, byte[] bArr) {
        this.f30042c.b(new y(str), z10, bArr);
    }

    public d e(y yVar, byte[] bArr) {
        return i(f30039d.b(yVar), bArr);
    }

    public d f(y yVar, byte[] bArr, BigInteger bigInteger) {
        return j(f30039d.b(yVar), bArr, bigInteger);
    }

    public d g(String str, byte[] bArr) {
        return h(str, bArr, null);
    }

    public d h(String str, byte[] bArr, BigInteger bigInteger) {
        if (str == null) {
            throw new IllegalArgumentException("No digest algorithm specified");
        }
        un.h hVar = new un.h(f30039d.b(new y(str)), bArr);
        z zVarE = this.f30042c.h() ? null : this.f30042c.e();
        y yVar = this.f30040a;
        return bigInteger != null ? new d(new k(hVar, yVar, new t(bigInteger), this.f30041b, zVarE)) : new d(new k(hVar, yVar, null, this.f30041b, zVarE));
    }

    public d i(zn.b bVar, byte[] bArr) {
        return j(bVar, bArr, null);
    }

    public d j(zn.b bVar, byte[] bArr, BigInteger bigInteger) {
        if (bVar == null) {
            throw new IllegalArgumentException("digest algorithm not specified");
        }
        un.h hVar = new un.h(bVar, bArr);
        z zVarE = this.f30042c.h() ? null : this.f30042c.e();
        y yVar = this.f30040a;
        return bigInteger != null ? new d(new k(hVar, yVar, new t(bigInteger), this.f30041b, zVarE)) : new d(new k(hVar, yVar, null, this.f30041b, zVarE));
    }

    public void k(boolean z10) {
        this.f30041b = gm.f.K(z10);
    }

    public void l(y yVar) {
        this.f30040a = yVar;
    }

    public void m(String str) {
        this.f30040a = new y(str);
    }
}
