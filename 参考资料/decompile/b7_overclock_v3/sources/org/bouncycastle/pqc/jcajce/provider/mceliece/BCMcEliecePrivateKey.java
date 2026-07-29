package org.bouncycastle.pqc.jcajce.provider.mceliece;

import ft.e;
import ft.h;
import ft.x;
import ft.y;
import is.g;
import java.io.IOException;
import java.security.PrivateKey;
import ms.q;
import np.c;
import org.bouncycastle.crypto.k;
import pn.u;
import zn.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCMcEliecePrivateKey implements k, PrivateKey {
    private static final long serialVersionUID = 1;
    private q params;

    public BCMcEliecePrivateKey(q qVar) {
        this.params = qVar;
    }

    public h a() {
        return this.params.e();
    }

    public y b() {
        return this.params.f();
    }

    public e c() {
        return this.params.g();
    }

    public int d() {
        return this.params.h();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        return h() == bCMcEliecePrivateKey.h() && d() == bCMcEliecePrivateKey.d() && a().equals(bCMcEliecePrivateKey.a()) && b().equals(bCMcEliecePrivateKey.b()) && m().equals(bCMcEliecePrivateKey.m()) && i().equals(bCMcEliecePrivateKey.i()) && k().equals(bCMcEliecePrivateKey.k());
    }

    public c f() {
        return this.params;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new u(new b(g.f35786m), new is.e(this.params.i(), this.params.h(), this.params.e(), this.params.f(), this.params.j(), this.params.k(), this.params.m())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int h() {
        return this.params.i();
    }

    public int hashCode() {
        return (((((((((((this.params.h() * 37) + this.params.i()) * 37) + this.params.e().hashCode()) * 37) + this.params.f().hashCode()) * 37) + this.params.j().hashCode()) * 37) + this.params.k().hashCode()) * 37) + this.params.m().hashCode();
    }

    public x i() {
        return this.params.j();
    }

    public x k() {
        return this.params.k();
    }

    public y[] l() {
        return this.params.l();
    }

    public e m() {
        return this.params.m();
    }
}
