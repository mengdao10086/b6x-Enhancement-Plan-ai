package org.bouncycastle.pqc.jcajce.provider.mceliece;

import ft.e;
import ft.h;
import ft.x;
import ft.y;
import java.io.IOException;
import java.security.PrivateKey;
import ms.g;
import np.c;
import pn.u;
import xs.l;
import zn.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCMcElieceCCA2PrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private g params;

    public BCMcElieceCCA2PrivateKey(g gVar) {
        this.params = gVar;
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
        if (obj == null || !(obj instanceof BCMcElieceCCA2PrivateKey)) {
            return false;
        }
        BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) obj;
        return h() == bCMcElieceCCA2PrivateKey.h() && d() == bCMcElieceCCA2PrivateKey.d() && a().equals(bCMcElieceCCA2PrivateKey.a()) && b().equals(bCMcElieceCCA2PrivateKey.b()) && i().equals(bCMcElieceCCA2PrivateKey.i()) && c().equals(bCMcElieceCCA2PrivateKey.c());
    }

    public c f() {
        return this.params;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new u(new b(is.g.f35787n), new is.c(h(), d(), a(), b(), i(), l.a(this.params.d()))).getEncoded();
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
        return (((((((((this.params.h() * 37) + this.params.i()) * 37) + this.params.e().hashCode()) * 37) + this.params.f().hashCode()) * 37) + this.params.j().hashCode()) * 37) + this.params.g().hashCode();
    }

    public x i() {
        return this.params.j();
    }

    public y[] k() {
        return this.params.k();
    }

    public int l() {
        return this.params.f().n();
    }
}
