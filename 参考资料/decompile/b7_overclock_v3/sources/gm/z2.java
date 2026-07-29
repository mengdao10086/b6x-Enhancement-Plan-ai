package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class z2 extends f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29837c;

    public z2() {
        this.f29837c = -1;
    }

    public z2(h hVar) {
        super(hVar);
        this.f29837c = -1;
    }

    public z2(i iVar) {
        super(iVar);
        this.f29837c = -1;
    }

    public z2(h[] hVarArr) {
        super(hVarArr);
        this.f29837c = -1;
    }

    public z2(h[] hVarArr, boolean z10) {
        super(hVarArr, z10);
        this.f29837c = -1;
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        return b0.i(z10, T());
    }

    @Override // gm.f0, gm.c0
    public c0 F() {
        return this;
    }

    @Override // gm.f0
    public d N() {
        return new u2(a1.P(G()), false);
    }

    @Override // gm.f0
    public l O() {
        return new w2(this);
    }

    @Override // gm.f0
    public z P() {
        return new f2(e1.N(H()));
    }

    @Override // gm.f0
    public h0 Q() {
        return new b3(false, S());
    }

    public final int T() throws IOException {
        if (this.f29837c < 0) {
            int length = this.f29678a.length;
            int iA = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iA += this.f29678a[i10].b().F().A(true);
            }
            this.f29837c = iA;
        }
        return this.f29837c;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.v(z10, 48);
        y2 y2VarG = b0Var.g();
        int length = this.f29678a.length;
        int i10 = 0;
        if (this.f29837c >= 0 || length > 16) {
            b0Var.m(T());
            while (i10 < length) {
                y2VarG.z(this.f29678a[i10].b(), true);
                i10++;
            }
            return;
        }
        c0[] c0VarArr = new c0[length];
        int iA = 0;
        for (int i11 = 0; i11 < length; i11++) {
            c0 c0VarF = this.f29678a[i11].b().F();
            c0VarArr[i11] = c0VarF;
            iA += c0VarF.A(true);
        }
        this.f29837c = iA;
        b0Var.m(iA);
        while (i10 < length) {
            y2VarG.z(c0VarArr[i10], true);
            i10++;
        }
    }
}
