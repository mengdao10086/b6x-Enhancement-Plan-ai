package com.google.zxing.qrcode.decoder;

import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21606a;

    public f(boolean z10) {
        this.f21606a = z10;
    }

    public void a(l[] lVarArr) {
        if (!this.f21606a || lVarArr == null || lVarArr.length < 3) {
            return;
        }
        l lVar = lVarArr[0];
        lVarArr[0] = lVarArr[2];
        lVarArr[2] = lVar;
    }

    public boolean b() {
        return this.f21606a;
    }
}
