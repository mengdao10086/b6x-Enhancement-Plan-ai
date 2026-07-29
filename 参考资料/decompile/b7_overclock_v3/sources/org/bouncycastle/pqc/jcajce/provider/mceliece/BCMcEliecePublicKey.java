package org.bouncycastle.pqc.jcajce.provider.mceliece;

import ft.e;
import is.f;
import is.g;
import java.io.IOException;
import java.security.PublicKey;
import ms.r;
import np.c;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCMcEliecePublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private r params;

    public BCMcEliecePublicKey(r rVar) {
        this.params = rVar;
    }

    public e a() {
        return this.params.e();
    }

    public int b() {
        return this.params.f();
    }

    public c c() {
        return this.params;
    }

    public int d() {
        return this.params.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        return this.params.g() == bCMcEliecePublicKey.d() && this.params.h() == bCMcEliecePublicKey.f() && this.params.e().equals(bCMcEliecePublicKey.a());
    }

    public int f() {
        return this.params.h();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new c1(new b(g.f35786m), new f(this.params.g(), this.params.h(), this.params.e())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.params.g() + (this.params.h() * 37)) * 37) + this.params.e().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.params.g() + "\n") + " error correction capability: " + this.params.h() + "\n") + " generator matrix           : " + this.params.e();
    }
}
