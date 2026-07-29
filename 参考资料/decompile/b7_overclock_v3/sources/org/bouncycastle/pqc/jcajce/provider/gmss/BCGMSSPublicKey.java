package org.bouncycastle.pqc.jcajce.provider.gmss;

import ct.d;
import is.g;
import java.security.PublicKey;
import ks.f;
import ks.h;
import org.bouncycastle.crypto.k;
import zn.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCGMSSPublicKey implements k, PublicKey {
    private static final long serialVersionUID = 1;
    private f gmssParameterSet;
    private f gmssParams;
    private byte[] publicKeyBytes;

    public BCGMSSPublicKey(h hVar) {
        this(hVar.e(), hVar.d());
    }

    public BCGMSSPublicKey(byte[] bArr, f fVar) {
        this.gmssParameterSet = fVar;
        this.publicKeyBytes = bArr;
    }

    public f a() {
        return this.gmssParameterSet;
    }

    public byte[] b() {
        return this.publicKeyBytes;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return d.c(new b(g.f35780g, new is.h(this.gmssParameterSet.c(), this.gmssParameterSet.a(), this.gmssParameterSet.d(), this.gmssParameterSet.b()).b()), new is.b(this.publicKeyBytes));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public String toString() {
        String str = "GMSS public key : " + new String(jt.h.h(this.publicKeyBytes)) + "\nHeight of Trees: \n";
        for (int i10 = 0; i10 < this.gmssParameterSet.a().length; i10++) {
            str = str + "Layer " + i10 + " : " + this.gmssParameterSet.a()[i10] + " WinternitzParameter: " + this.gmssParameterSet.d()[i10] + " K: " + this.gmssParameterSet.b()[i10] + "\n";
        }
        return str;
    }
}
