package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class t2 extends a {
    public t2(int i10, h hVar) throws IOException {
        this(true, i10, hVar);
    }

    public t2(int i10, i iVar) {
        super(new d3(false, 64, i10, (h) x2.a(iVar)));
    }

    public t2(int i10, byte[] bArr) {
        super(new d3(false, 64, i10, (h) new f2(bArr)));
    }

    public t2(n0 n0Var) {
        super(n0Var);
    }

    public t2(boolean z10, int i10, h hVar) throws IOException {
        super(new d3(z10, 64, i10, hVar));
    }

    @Override // gm.a, gm.c0
    public c0 F() {
        return this;
    }
}
