package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import f0.v;
import g.c1;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1
    public static final int f18729b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v.n f18730a;

    public d(Context context, String str) {
        this.f18730a = new v.n(context.getApplicationContext(), str);
    }

    public Notification a(Context context, @g.v int i10, @p0 PendingIntent pendingIntent, @p0 String str) {
        return c(context, i10, pendingIntent, str, R.string.exo_download_completed);
    }

    public Notification b(Context context, @g.v int i10, @p0 PendingIntent pendingIntent, @p0 String str) {
        return c(context, i10, pendingIntent, str, R.string.exo_download_failed);
    }

    public final Notification c(Context context, @g.v int i10, @p0 PendingIntent pendingIntent, @p0 String str, @c1 int i11) {
        return d(context, i10, pendingIntent, str, i11, 0, 0, false, false, true);
    }

    public final Notification d(Context context, @g.v int i10, @p0 PendingIntent pendingIntent, @p0 String str, @c1 int i11, int i12, int i13, boolean z10, boolean z11, boolean z12) {
        this.f18730a.t0(i10);
        this.f18730a.P(i11 == 0 ? null : context.getResources().getString(i11));
        this.f18730a.N(pendingIntent);
        this.f18730a.z0(str != null ? new v.l().A(str) : null);
        this.f18730a.l0(i12, i13, z10);
        this.f18730a.i0(z11);
        this.f18730a.r0(z12);
        return this.f18730a.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.app.Notification e(android.content.Context r21, @g.v int r22, @g.p0 android.app.PendingIntent r23, @g.p0 java.lang.String r24, java.util.List<cc.c> r25) {
        /*
            r20 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 1
            r8 = 0
        L9:
            int r9 = r25.size()
            if (r3 >= r9) goto L45
            r9 = r25
            java.lang.Object r10 = r9.get(r3)
            cc.c r10 = (cc.c) r10
            int r11 = r10.f10712b
            r12 = 5
            if (r11 != r12) goto L1e
            r5 = 1
            goto L42
        L1e:
            r12 = 7
            if (r11 == r12) goto L25
            r12 = 2
            if (r11 == r12) goto L25
            goto L42
        L25:
            float r4 = r10.b()
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 == 0) goto L31
            float r2 = r2 + r4
            r7 = 0
        L31:
            long r10 = r10.a()
            r12 = 0
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 <= 0) goto L3d
            r4 = 1
            goto L3e
        L3d:
            r4 = 0
        L3e:
            r8 = r8 | r4
            int r6 = r6 + 1
            r4 = 1
        L42:
            int r3 = r3 + 1
            goto L9
        L45:
            if (r4 == 0) goto L4b
            int r3 = com.google.android.exoplayer2.ui.R.string.exo_download_downloading
        L49:
            r14 = r3
            goto L51
        L4b:
            if (r5 == 0) goto L50
            int r3 = com.google.android.exoplayer2.ui.R.string.exo_download_removing
            goto L49
        L50:
            r14 = 0
        L51:
            if (r4 == 0) goto L61
            float r3 = (float) r6
            float r2 = r2 / r3
            int r2 = (int) r2
            if (r7 == 0) goto L5b
            if (r8 == 0) goto L5b
            goto L5c
        L5b:
            r0 = 0
        L5c:
            r17 = r0
            r16 = r2
            goto L65
        L61:
            r16 = 0
            r17 = 1
        L65:
            r15 = 100
            r18 = 1
            r19 = 0
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            android.app.Notification r0 = r9.d(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.d.e(android.content.Context, int, android.app.PendingIntent, java.lang.String, java.util.List):android.app.Notification");
    }
}
