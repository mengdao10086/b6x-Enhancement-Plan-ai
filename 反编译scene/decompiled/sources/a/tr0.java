package a;

import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7526a;

    public tr0(Context context) {
        f92.d(context, "ctx");
        this.f7526a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.m30 b() {
        /*
            r10 = this;
            a.su0 r0 = a.wu0.f3480a
            java.lang.String r0 = r0.e()
            java.lang.String r1 = "SOURCE_SCENE_ONLINE"
            boolean r0 = a.f92.a(r0, r1)
            r1 = 1
            r6 = r0 ^ 1
            r0 = 0
            if (r6 != 0) goto L1f
            a.y60 r2 = a.y60.f7952a
            java.lang.String r3 = "/sys/kernel/tracing/kprobe_events"
            boolean r2 = r2.d(r3)
            if (r2 != 0) goto L1d
            goto L1f
        L1d:
            r7 = r0
            goto L20
        L1f:
            r7 = r1
        L20:
            a.rl0 r2 = new a.rl0
            r2.<init>()
            boolean r2 = r2.k()
            if (r2 == 0) goto L49
            a.im0 r2 = a.jm0.f6525a
            java.lang.String r2 = r2.a()
            java.lang.String r3 = "waipio"
            boolean r3 = a.f92.a(r2, r3)
            if (r3 != 0) goto L44
            java.lang.String r3 = "lahaina"
            boolean r2 = a.f92.a(r2, r3)
            if (r2 == 0) goto L42
            goto L44
        L42:
            r2 = r0
            goto L45
        L44:
            r2 = r1
        L45:
            if (r2 == 0) goto L49
            r4 = r1
            goto L4a
        L49:
            r4 = r0
        L4a:
            a.um0 r2 = a.um0.f7612a
            java.lang.String r3 = "ro.boottime.gameopt_hal_service-1-0"
            java.lang.String r2 = r2.a(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L5a
            r3 = r1
            goto L5b
        L5a:
            r3 = r0
        L5b:
            if (r3 == 0) goto L68
            java.lang.String r3 = "error"
            boolean r2 = a.f92.a(r2, r3)
            r2 = r2 ^ r1
            if (r2 == 0) goto L68
            r5 = r1
            goto L69
        L68:
            r5 = r0
        L69:
            a.m30 r8 = new a.m30
            a.g82[] r1 = new a.g82[r1]
            a.sr0 r9 = new a.sr0
            r2 = r9
            r3 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            r1[r0] = r9
            r8.<init>(r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.tr0.b():a.m30");
    }

    public final String c(int i) {
        String string = this.f7526a.getString(i);
        f92.c(string, "ctx.getString(id)");
        return string;
    }
}
