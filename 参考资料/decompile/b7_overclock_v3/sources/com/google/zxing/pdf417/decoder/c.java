package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f21563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f21564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f21565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f21566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f21567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f21570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f21571i;

    public c(af.b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        boolean z10 = lVar == null || lVar2 == null;
        boolean z11 = lVar3 == null || lVar4 == null;
        if (z10 && z11) {
            throw NotFoundException.b();
        }
        if (z10) {
            lVar = new l(0.0f, lVar3.d());
            lVar2 = new l(0.0f, lVar4.d());
        } else if (z11) {
            lVar3 = new l(bVar.m() - 1, lVar.d());
            lVar4 = new l(bVar.m() - 1, lVar2.d());
        }
        this.f21563a = bVar;
        this.f21564b = lVar;
        this.f21565c = lVar2;
        this.f21566d = lVar3;
        this.f21567e = lVar4;
        this.f21568f = (int) Math.min(lVar.c(), lVar2.c());
        this.f21569g = (int) Math.max(lVar3.c(), lVar4.c());
        this.f21570h = (int) Math.min(lVar.d(), lVar3.d());
        this.f21571i = (int) Math.max(lVar2.d(), lVar4.d());
    }

    public static c j(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f21563a, cVar.f21564b, cVar.f21565c, cVar2.f21566d, cVar2.f21567e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.pdf417.decoder.c a(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
            r12 = this;
            ve.l r0 = r12.f21564b
            ve.l r1 = r12.f21565c
            ve.l r2 = r12.f21566d
            ve.l r3 = r12.f21567e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            ve.l r13 = new ve.l
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            ve.l r13 = r12.f21565c
            goto L34
        L32:
            ve.l r13 = r12.f21567e
        L34:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            af.b r14 = r12.f21563a
            int r14 = r14.i()
            if (r0 < r14) goto L4a
            af.b r14 = r12.f21563a
            int r14 = r14.i()
            int r0 = r14 + (-1)
        L4a:
            ve.l r14 = new ve.l
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            com.google.zxing.pdf417.decoder.c r13 = new com.google.zxing.pdf417.decoder.c
            af.b r7 = r12.f21563a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.c.a(int, int, boolean):com.google.zxing.pdf417.decoder.c");
    }

    public l b() {
        return this.f21565c;
    }

    public l c() {
        return this.f21567e;
    }

    public int d() {
        return this.f21569g;
    }

    public int e() {
        return this.f21571i;
    }

    public int f() {
        return this.f21568f;
    }

    public int g() {
        return this.f21570h;
    }

    public l h() {
        return this.f21564b;
    }

    public l i() {
        return this.f21566d;
    }

    public c(c cVar) {
        this.f21563a = cVar.f21563a;
        this.f21564b = cVar.f21564b;
        this.f21565c = cVar.f21565c;
        this.f21566d = cVar.f21566d;
        this.f21567e = cVar.f21567e;
        this.f21568f = cVar.f21568f;
        this.f21569g = cVar.f21569g;
        this.f21570h = cVar.f21570h;
        this.f21571i = cVar.f21571i;
    }
}
