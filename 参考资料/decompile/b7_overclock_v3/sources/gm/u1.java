package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class u1 extends d {
    public u1(byte b10, int i10) {
        super(b10, i10);
    }

    public u1(int i10) {
        super(d.I(i10), d.M(i10));
    }

    public u1(h hVar) throws IOException {
        super(hVar.b().v(j.f29713a), 0);
    }

    public u1(byte[] bArr) {
        this(bArr, 0);
    }

    public u1(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    public u1(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static u1 P(d dVar) {
        return (u1) dVar.E();
    }

    public static u1 Q(z zVar) {
        return new u1(zVar.J(), true);
    }

    public static u1 R(n0 n0Var, boolean z10) {
        c0 c0VarU = n0Var.U();
        return (z10 || (c0VarU instanceof u1)) ? S(c0VarU) : Q(z.I(c0VarU));
    }

    public static u1 S(Object obj) {
        if (obj == null || (obj instanceof u1)) {
            return (u1) obj;
        }
        if (obj instanceof d) {
            return P((d) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return P((d) c0.D((byte[]) obj));
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29651a.length);
    }

    @Override // gm.d, gm.c0
    public c0 E() {
        return this;
    }

    @Override // gm.d, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        byte[] bArr = this.f29651a;
        int i10 = bArr[0] & 255;
        int length = bArr.length - 1;
        byte b10 = bArr[length];
        byte b11 = (byte) ((255 << i10) & bArr[length]);
        if (b10 == b11) {
            b0Var.r(z10, 3, bArr);
        } else {
            b0Var.t(z10, 3, bArr, 0, length, b11);
        }
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
