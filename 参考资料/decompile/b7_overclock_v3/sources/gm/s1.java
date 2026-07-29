package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class s1 extends a {
    public s1(int i10, h hVar) throws IOException {
        this(true, i10, hVar);
    }

    public s1(int i10, i iVar) {
        super(new n2(false, 64, i10, (h) x1.a(iVar)));
    }

    public s1(int i10, byte[] bArr) {
        super(new n2(false, 64, i10, (h) new f2(bArr)));
    }

    public s1(n0 n0Var) {
        super(n0Var);
    }

    public s1(boolean z10, int i10, h hVar) throws IOException {
        super(new n2(z10, 64, i10, hVar));
    }

    @Override // gm.a, gm.c0
    public c0 E() {
        return this;
    }

    @Override // gm.a, gm.c0
    public c0 F() {
        return this;
    }
}
