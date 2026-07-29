package org.bouncycastle.pqc.jcajce.provider.rainbow;

import ct.d;
import et.j;
import gm.d2;
import java.security.PublicKey;
import org.bouncycastle.util.a;
import ps.e;
import ps.g;
import qs.c;
import zn.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;
    private e rainbowParams;

    public BCRainbowPublicKey(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.docLength = i10;
        this.coeffquadratic = sArr;
        this.coeffsingular = sArr2;
        this.coeffscalar = sArr3;
    }

    public BCRainbowPublicKey(j jVar) {
        this(jVar.d(), jVar.a(), jVar.c(), jVar.b());
    }

    public BCRainbowPublicKey(g gVar) {
        this(gVar.d(), gVar.e(), gVar.g(), gVar.f());
    }

    public short[][] a() {
        return this.coeffquadratic;
    }

    public short[] b() {
        return a.w(this.coeffscalar);
    }

    public short[][] c() {
        short[][] sArr = new short[this.coeffsingular.length][];
        int i10 = 0;
        while (true) {
            short[][] sArr2 = this.coeffsingular;
            if (i10 == sArr2.length) {
                return sArr;
            }
            sArr[i10] = a.w(sArr2[i10]);
            i10++;
        }
    }

    public int d() {
        return this.docLength;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCRainbowPublicKey)) {
            return false;
        }
        BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) obj;
        return this.docLength == bCRainbowPublicKey.d() && c.j(this.coeffquadratic, bCRainbowPublicKey.a()) && c.j(this.coeffsingular, bCRainbowPublicKey.c()) && c.i(this.coeffscalar, bCRainbowPublicKey.b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return d.c(new b(is.g.f35774a, d2.f29657b), new is.j(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.docLength * 37) + a.C0(this.coeffquadratic)) * 37) + a.C0(this.coeffsingular)) * 37) + a.A0(this.coeffscalar);
    }
}
