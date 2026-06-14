package a;

import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fo0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ho0 f6123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PackageInfo f931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f932a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fo0(ho0 ho0Var, String str, String str2, PackageInfo packageInfo) {
        super(1);
        this.f6123a = ho0Var;
        this.f932a = str;
        this.b = str2;
        this.f931a = packageInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(a.l30 r5) {
        /*
            r4 = this;
            java.lang.String r0 = "$receiver"
            a.f92.d(r5, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            a.ho0 r1 = r4.f6123a
            java.lang.String r1 = a.ho0.y(r1)
            r0.append(r1)
            java.lang.String r1 = r4.f932a
            int r2 = r1.hashCode()
            r3 = 3243(0xcab, float:4.544E-42)
            if (r2 == r3) goto L2d
            r3 = 3460(0xd84, float:4.848E-42)
            if (r2 == r3) goto L22
            goto L38
        L22:
            java.lang.String r2 = "lp"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L38
            java.lang.String r1 = "/lp"
            goto L3a
        L2d:
            java.lang.String r2 = "ep"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L38
            java.lang.String r1 = "/ep"
            goto L3a
        L38:
            java.lang.String r1 = "/hp"
        L3a:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "branch"
            r5.E(r1, r0)
            java.lang.String r0 = r4.b
            java.lang.String r1 = "daemonVersion"
            r5.E(r1, r0)
            android.content.pm.PackageInfo r0 = r4.f931a
            java.lang.String r0 = r0.versionName
            java.lang.String r1 = "versionName"
            r5.E(r1, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "osVersion"
            r5.E(r1, r0)
            a.ho0 r0 = r4.f6123a
            java.lang.String r0 = a.ho0.z(r0)
            java.lang.String r1 = "platform"
            r5.E(r1, r0)
            a.im0 r0 = a.jm0.f6525a
            java.lang.String r0 = r0.a()
            java.lang.String r1 = "machine"
            r5.E(r1, r0)
            a.ho0 r0 = r4.f6123a
            java.lang.String r0 = a.ho0.A(r0)
            java.lang.String r1 = "scheme"
            r5.E(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fo0.a(a.l30):void");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
