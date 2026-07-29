package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class b3 extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29643d;

    public b3() {
        this.f29643d = -1;
    }

    public b3(h hVar) {
        super(hVar);
        this.f29643d = -1;
    }

    public b3(i iVar) {
        super(iVar, false);
        this.f29643d = -1;
    }

    public b3(boolean z10, h[] hVarArr) {
        super(z10, hVarArr);
        this.f29643d = -1;
    }

    public b3(h[] hVarArr) {
        super(hVarArr, false);
        this.f29643d = -1;
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        return b0.i(z10, P());
    }

    @Override // gm.h0, gm.c0
    public c0 F() {
        return this;
    }

    public final int P() throws IOException {
        if (this.f29643d < 0) {
            int length = this.f29697a.length;
            int iA = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iA += this.f29697a[i10].b().F().A(true);
            }
            this.f29643d = iA;
        }
        return this.f29643d;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.v(z10, 49);
        y2 y2VarG = b0Var.g();
        int length = this.f29697a.length;
        int i10 = 0;
        if (this.f29643d >= 0 || length > 16) {
            b0Var.m(P());
            while (i10 < length) {
                y2VarG.z(this.f29697a[i10].b(), true);
                i10++;
            }
            return;
        }
        c0[] c0VarArr = new c0[length];
        int iA = 0;
        for (int i11 = 0; i11 < length; i11++) {
            c0 c0VarF = this.f29697a[i11].b().F();
            c0VarArr[i11] = c0VarF;
            iA += c0VarF.A(true);
        }
        this.f29643d = iA;
        b0Var.m(iA);
        while (i10 < length) {
            y2VarG.z(c0VarArr[i10], true);
            i10++;
        }
    }
}
