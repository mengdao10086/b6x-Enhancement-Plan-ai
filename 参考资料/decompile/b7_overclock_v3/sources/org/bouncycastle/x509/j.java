package org.bouncycastle.x509;

import gm.c0;
import gm.h0;
import gm.l2;

/* JADX INFO: loaded from: classes6.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.e f46120a;

    public j(gm.h hVar) {
        this.f46120a = zn.e.A(hVar);
    }

    public j(String str, gm.h hVar) {
        this.f46120a = new zn.e(new gm.y(str), new l2(hVar));
    }

    public j(String str, gm.i iVar) {
        this.f46120a = new zn.e(new gm.y(str), new l2(iVar));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f46120a.b();
    }

    public String x() {
        return this.f46120a.x().L();
    }

    public gm.h[] y() {
        h0 h0VarY = this.f46120a.y();
        gm.h[] hVarArr = new gm.h[h0VarY.size()];
        for (int i10 = 0; i10 != h0VarY.size(); i10++) {
            hVarArr[i10] = h0VarY.J(i10);
        }
        return hVarArr;
    }
}
