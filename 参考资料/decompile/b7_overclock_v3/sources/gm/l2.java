package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class l2 extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29737d;

    public l2() {
        this.f29737d = -1;
    }

    public l2(h hVar) {
        super(hVar);
        this.f29737d = -1;
    }

    public l2(i iVar) {
        super(iVar, true);
        this.f29737d = -1;
    }

    public l2(boolean z10, h[] hVarArr) {
        super(P(z10), hVarArr);
        this.f29737d = -1;
    }

    public l2(h[] hVarArr) {
        super(hVarArr, true);
        this.f29737d = -1;
    }

    public static boolean P(boolean z10) {
        if (z10) {
            return z10;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    public static l2 Q(h0 h0Var) {
        return (l2) h0Var.E();
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        return b0.i(z10, R());
    }

    @Override // gm.h0, gm.c0
    public c0 E() {
        return this.f29698b ? this : super.E();
    }

    @Override // gm.h0, gm.c0
    public c0 F() {
        return this;
    }

    public final int R() throws IOException {
        if (this.f29737d < 0) {
            int length = this.f29697a.length;
            int iA = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iA += this.f29697a[i10].b().E().A(true);
            }
            this.f29737d = iA;
        }
        return this.f29737d;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.v(z10, 49);
        h2 h2VarF = b0Var.f();
        int length = this.f29697a.length;
        int i10 = 0;
        if (this.f29737d >= 0 || length > 16) {
            b0Var.m(R());
            while (i10 < length) {
                this.f29697a[i10].b().E().y(h2VarF, true);
                i10++;
            }
            return;
        }
        c0[] c0VarArr = new c0[length];
        int iA = 0;
        for (int i11 = 0; i11 < length; i11++) {
            c0 c0VarE = this.f29697a[i11].b().E();
            c0VarArr[i11] = c0VarE;
            iA += c0VarE.A(true);
        }
        this.f29737d = iA;
        b0Var.m(iA);
        while (i10 < length) {
            c0VarArr[i10].y(h2VarF, true);
            i10++;
        }
    }
}
