package es;

import gm.c0;
import gm.f0;
import gm.z;
import java.io.IOException;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.PKCSIOException;
import pn.n;
import pn.r;
import pn.t;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f27119a;

    public f(t tVar) {
        this.f27119a = tVar;
    }

    public f(byte[] bArr) throws IOException {
        this(g(bArr));
    }

    public static t g(byte[] bArr) throws IOException {
        try {
            return t.y(c0.D(bArr));
        } catch (ClassCastException e10) {
            throw new PKCSIOException("malformed data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new PKCSIOException("malformed data: " + e11.getMessage(), e11);
        }
    }

    public pn.g[] a() {
        f0 f0VarJ = f0.J(z.I(this.f27119a.x().x()).J());
        pn.g[] gVarArr = new pn.g[f0VarJ.size()];
        for (int i10 = 0; i10 != f0VarJ.size(); i10++) {
            gVarArr[i10] = pn.g.z(f0VarJ.K(i10));
        }
        return gVarArr;
    }

    public byte[] b() throws IOException {
        return h().getEncoded();
    }

    public byte[] c(String str) throws IOException {
        return h().v(str);
    }

    public zn.b d() {
        n nVarZ = this.f27119a.z();
        if (nVarZ != null) {
            return nVarZ.z().x();
        }
        return null;
    }

    public boolean e() {
        return this.f27119a.z() != null;
    }

    public boolean f(e eVar, char[] cArr) throws PKCSException {
        if (!e()) {
            throw new IllegalStateException("no MAC present on PFX");
        }
        n nVarZ = this.f27119a.z();
        try {
            return org.bouncycastle.util.a.I(new a(eVar.a(new zn.b(nVarZ.z().x().x(), new r(nVarZ.A(), nVarZ.y().intValue())))).a(cArr, z.I(this.f27119a.x().x()).J()).getEncoded(), this.f27119a.z().getEncoded());
        } catch (IOException e10) {
            throw new PKCSException("unable to process AuthSafe: " + e10.getMessage());
        }
    }

    public t h() {
        return this.f27119a;
    }
}
