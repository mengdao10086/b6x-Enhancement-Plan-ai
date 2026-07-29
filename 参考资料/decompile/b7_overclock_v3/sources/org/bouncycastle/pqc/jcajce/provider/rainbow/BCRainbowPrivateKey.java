package org.bouncycastle.pqc.jcajce.provider.rainbow;

import et.i;
import gm.d2;
import is.g;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import pn.u;
import ps.a;
import ps.f;
import qs.c;
import zn.b;

/* JADX INFO: loaded from: classes6.dex */
public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private short[][] A1inv;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private short[] f46011b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private short[] f46012b2;
    private a[] layers;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f46013vi;

    public BCRainbowPrivateKey(i iVar) {
        this(iVar.c(), iVar.a(), iVar.d(), iVar.b(), iVar.f(), iVar.e());
    }

    public BCRainbowPrivateKey(f fVar) {
        this(fVar.g(), fVar.e(), fVar.h(), fVar.f(), fVar.j(), fVar.i());
    }

    public BCRainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, a[] aVarArr) {
        this.A1inv = sArr;
        this.f46011b1 = sArr2;
        this.A2inv = sArr3;
        this.f46012b2 = sArr4;
        this.f46013vi = iArr;
        this.layers = aVarArr;
    }

    public short[] a() {
        return this.f46011b1;
    }

    public short[] b() {
        return this.f46012b2;
    }

    public short[][] c() {
        return this.A1inv;
    }

    public short[][] d() {
        return this.A2inv;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCRainbowPrivateKey)) {
            return false;
        }
        BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) obj;
        boolean zEquals = ((((c.j(this.A1inv, bCRainbowPrivateKey.c())) && c.j(this.A2inv, bCRainbowPrivateKey.d())) && c.i(this.f46011b1, bCRainbowPrivateKey.a())) && c.i(this.f46012b2, bCRainbowPrivateKey.b())) && Arrays.equals(this.f46013vi, bCRainbowPrivateKey.h());
        if (this.layers.length != bCRainbowPrivateKey.f().length) {
            return false;
        }
        for (int length = this.layers.length - 1; length >= 0; length--) {
            zEquals &= this.layers[length].equals(bCRainbowPrivateKey.f()[length]);
        }
        return zEquals;
    }

    public a[] f() {
        return this.layers;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new u(new b(g.f35774a, d2.f29657b), new is.i(this.A1inv, this.f46011b1, this.A2inv, this.f46012b2, this.f46013vi, this.layers)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int[] h() {
        return this.f46013vi;
    }

    public int hashCode() {
        int length = (((((((((this.layers.length * 37) + org.bouncycastle.util.a.C0(this.A1inv)) * 37) + org.bouncycastle.util.a.A0(this.f46011b1)) * 37) + org.bouncycastle.util.a.C0(this.A2inv)) * 37) + org.bouncycastle.util.a.A0(this.f46012b2)) * 37) + org.bouncycastle.util.a.v0(this.f46013vi);
        for (int length2 = this.layers.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.layers[length2].hashCode();
        }
        return length;
    }
}
