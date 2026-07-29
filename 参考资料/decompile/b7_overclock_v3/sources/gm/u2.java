package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class u2 extends d {
    public u2(byte b10, int i10) {
        super(b10, i10);
    }

    public u2(int i10) {
        super(d.I(i10), d.M(i10));
    }

    public u2(h hVar) throws IOException {
        super(hVar.b().v(j.f29713a), 0);
    }

    public u2(byte[] bArr) {
        this(bArr, 0);
    }

    public u2(byte[] bArr, int i10) {
        super(bArr, i10);
    }

    public u2(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public static void P(b0 b0Var, boolean z10, byte b10, byte[] bArr, int i10, int i11) throws IOException {
        b0Var.p(z10, 3, b10, bArr, i10, i11);
    }

    public static void Q(b0 b0Var, boolean z10, byte[] bArr, int i10, int i11) throws IOException {
        b0Var.s(z10, 3, bArr, i10, i11);
    }

    public static int R(boolean z10, int i10) {
        return b0.i(z10, i10);
    }

    public static u2 S(z zVar) {
        return new u2(zVar.J(), true);
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29651a.length);
    }

    @Override // gm.d, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 3, this.f29651a);
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
