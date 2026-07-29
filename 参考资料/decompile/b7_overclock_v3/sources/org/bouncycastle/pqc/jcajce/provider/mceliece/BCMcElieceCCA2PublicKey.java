package org.bouncycastle.pqc.jcajce.provider.mceliece;

import ft.e;
import is.d;
import is.g;
import java.io.IOException;
import java.security.PublicKey;
import ms.h;
import np.c;
import org.bouncycastle.crypto.k;
import xs.l;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BCMcElieceCCA2PublicKey implements k, PublicKey {
    private static final long serialVersionUID = 1;
    private h params;

    public BCMcElieceCCA2PublicKey(h hVar) {
        this.params = hVar;
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
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
        return this.params.g() == bCMcElieceCCA2PublicKey.d() && this.params.h() == bCMcElieceCCA2PublicKey.f() && this.params.e().equals(bCMcElieceCCA2PublicKey.a());
    }

    public int f() {
        return this.params.h();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new c1(new b(g.f35787n), new d(this.params.g(), this.params.h(), this.params.e(), l.a(this.params.d()))).getEncoded();
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
        return (("McEliecePublicKey:\n length of the code         : " + this.params.g() + "\n") + " error correction capability: " + this.params.h() + "\n") + " generator matrix           : " + this.params.e().toString();
    }
}
