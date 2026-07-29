package vc;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f52933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f52934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f52935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f52936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f52937e;

    public b(int i10, int i11, int i12, int i13, int i14) {
        this.f52933a = i10;
        this.f52934b = i11;
        this.f52935c = i12;
        this.f52936d = i13;
        this.f52937e = i14;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static vc.b a(java.lang.String r9) {
        /*
            java.lang.String r0 = "Format:"
            boolean r0 = r9.startsWith(r0)
            hd.a.a(r0)
            r0 = 7
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r9 = android.text.TextUtils.split(r9, r0)
            r0 = 0
            r1 = -1
            r2 = 0
            r4 = -1
            r5 = -1
            r6 = -1
            r7 = -1
        L1b:
            int r3 = r9.length
            if (r2 >= r3) goto L6d
            r3 = r9[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = hd.u0.w1(r3)
            r3.hashCode()
            int r8 = r3.hashCode()
            switch(r8) {
                case 100571: goto L55;
                case 3556653: goto L4a;
                case 109757538: goto L3f;
                case 109780401: goto L34;
                default: goto L32;
            }
        L32:
            r3 = -1
            goto L5f
        L34:
            java.lang.String r8 = "style"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L3d
            goto L32
        L3d:
            r3 = 3
            goto L5f
        L3f:
            java.lang.String r8 = "start"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L48
            goto L32
        L48:
            r3 = 2
            goto L5f
        L4a:
            java.lang.String r8 = "text"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L53
            goto L32
        L53:
            r3 = 1
            goto L5f
        L55:
            java.lang.String r8 = "end"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L5e
            goto L32
        L5e:
            r3 = 0
        L5f:
            switch(r3) {
                case 0: goto L69;
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L63;
                default: goto L62;
            }
        L62:
            goto L6a
        L63:
            r6 = r2
            goto L6a
        L65:
            r4 = r2
            goto L6a
        L67:
            r7 = r2
            goto L6a
        L69:
            r5 = r2
        L6a:
            int r2 = r2 + 1
            goto L1b
        L6d:
            if (r4 == r1) goto L7b
            if (r5 == r1) goto L7b
            if (r7 == r1) goto L7b
            vc.b r0 = new vc.b
            int r8 = r9.length
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            goto L7c
        L7b:
            r0 = 0
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.b.a(java.lang.String):vc.b");
    }
}
