package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class f2 extends z {
    public f2(h hVar) throws IOException {
        super(hVar.b().v(j.f29713a));
    }

    public f2(byte[] bArr) {
        super(bArr);
    }

    public static void L(b0 b0Var, boolean z10, byte[] bArr, int i10, int i11) throws IOException {
        b0Var.s(z10, 4, bArr, i10, i11);
    }

    public static int M(boolean z10, int i10) {
        return b0.i(z10, i10);
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29836a.length);
    }

    @Override // gm.z, gm.c0
    public c0 E() {
        return this;
    }

    @Override // gm.z, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 4, this.f29836a);
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
