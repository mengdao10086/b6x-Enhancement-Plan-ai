package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class j2 extends f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29719c;

    public j2() {
        this.f29719c = -1;
    }

    public j2(h hVar) {
        super(hVar);
        this.f29719c = -1;
    }

    public j2(i iVar) {
        super(iVar);
        this.f29719c = -1;
    }

    public j2(h[] hVarArr) {
        super(hVarArr);
        this.f29719c = -1;
    }

    public j2(h[] hVarArr, boolean z10) {
        super(hVarArr, z10);
        this.f29719c = -1;
    }

    public static j2 T(f0 f0Var) {
        return (j2) f0Var.E();
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        return b0.i(z10, U());
    }

    @Override // gm.f0, gm.c0
    public c0 E() {
        return this;
    }

    @Override // gm.f0, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.f0
    public d N() {
        return new u1(a1.P(G()), false);
    }

    @Override // gm.f0
    public l O() {
        return new v1(this);
    }

    @Override // gm.f0
    public z P() {
        return new f2(e1.N(H()));
    }

    @Override // gm.f0
    public h0 Q() {
        return new b3(false, S());
    }

    public final int U() throws IOException {
        if (this.f29719c < 0) {
            int length = this.f29678a.length;
            int iA = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iA += this.f29678a[i10].b().E().A(true);
            }
            this.f29719c = iA;
        }
        return this.f29719c;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.v(z10, 48);
        h2 h2VarF = b0Var.f();
        int length = this.f29678a.length;
        int i10 = 0;
        if (this.f29719c >= 0 || length > 16) {
            b0Var.m(U());
            while (i10 < length) {
                this.f29678a[i10].b().E().y(h2VarF, true);
                i10++;
            }
            return;
        }
        c0[] c0VarArr = new c0[length];
        int iA = 0;
        for (int i11 = 0; i11 < length; i11++) {
            c0 c0VarE = this.f29678a[i11].b().E();
            c0VarArr[i11] = c0VarE;
            iA += c0VarE.A(true);
        }
        this.f29719c = iA;
        b0Var.m(iA);
        while (i10 < length) {
            c0VarArr[i10].y(h2VarF, true);
            i10++;
        }
    }
}
