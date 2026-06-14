package a;

import android.content.ContentResolver;
import android.provider.Settings;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentResolver f7148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2454a;
    public final String b;
    public final String c;
    public String d;
    public String e;
    public String f;

    public pt0(ContentResolver contentResolver) {
        f92.d(contentResolver, "contentResolver");
        this.f7148a = contentResolver;
        this.f2454a = "immersive.navigation";
        this.b = "immersive.status";
        this.c = "immersive.full";
        this.d = "";
        this.e = "";
        this.f = "";
        String string = Settings.Global.getString(contentResolver, "policy_control");
        if (string != null) {
            for (String str : ec2.d0(string, new String[]{":"}, false, 0, 6, null)) {
                if (bc2.x(str, "immersive.full", false, 2, null)) {
                    this.f = str;
                } else if (bc2.x(str, "immersive.navigation", false, 2, null)) {
                    this.d = str;
                } else if (bc2.x(str, "immersive.status", false, 2, null)) {
                    this.e = str;
                }
            }
        }
    }

    public final boolean a(String str) {
        StringBuilder sb;
        char c;
        f92.d(str, "packageName");
        if (d(str)) {
            return true;
        }
        k(str);
        j(str);
        if (this.f.length() == 0) {
            sb = new StringBuilder();
            sb.append(this.c);
            c = '=';
        } else {
            sb = new StringBuilder();
            sb.append(this.f);
            c = ',';
        }
        sb.append(c);
        sb.append(str);
        this.f = sb.toString();
        return h();
    }

    public final boolean b(String str) {
        StringBuilder sb;
        char c;
        f92.d(str, "packageName");
        if (f(str) || d(str)) {
            return true;
        }
        if (this.d.length() == 0) {
            sb = new StringBuilder();
            sb.append(this.f2454a);
            c = '=';
        } else {
            sb = new StringBuilder();
            sb.append(this.d);
            c = ',';
        }
        sb.append(c);
        sb.append(str);
        this.d = sb.toString();
        return h();
    }

    public final boolean c(String str) {
        StringBuilder sb;
        char c;
        f92.d(str, "packageName");
        if (g(str) || d(str)) {
            return true;
        }
        if (this.e.length() == 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            c = '=';
        } else {
            sb = new StringBuilder();
            sb.append(this.e);
            c = ',';
        }
        sb.append(c);
        sb.append(str);
        this.e = sb.toString();
        return h();
    }

    public final boolean d(String str) {
        f92.d(str, "packageName");
        return e(this.f, str);
    }

    public final boolean e(String str, String str2) {
        if (ec2.C(str, '-' + str2, false, 2, null)) {
            return false;
        }
        if (ec2.C(str, str2, false, 2, null)) {
            return true;
        }
        if (ec2.C(str, this.b + "=*", false, 2, null)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("=apps");
        return ec2.C(str, sb.toString(), false, 2, null);
    }

    public final boolean f(String str) {
        f92.d(str, "packageName");
        return e(this.d, str);
    }

    public final boolean g(String str) {
        f92.d(str, "packageName");
        return e(this.e, str);
    }

    public final boolean h() {
        StringBuilder sb = new StringBuilder();
        if (!(this.e.length() == 0)) {
            sb.append(this.e);
        }
        if (!(this.d.length() == 0)) {
            if (!(sb.length() == 0)) {
                sb.append(":");
            }
            sb.append(this.d);
        }
        if (!(this.f.length() == 0)) {
            if (!(sb.length() == 0)) {
                sb.append(":");
            }
            sb.append(this.f);
        }
        return Settings.Global.putString(this.f7148a, "policy_control", sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "packageName"
            a.f92.d(r14, r0)
            boolean r0 = r13.d(r14)
            if (r0 != 0) goto Ld
            r14 = 1
            return r14
        Ld:
            java.lang.String r0 = r13.f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r13.c
            r1.append(r2)
            java.lang.String r2 = "=*"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = a.ec2.C(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L76
            java.lang.String r0 = r13.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r13.c
            r1.append(r5)
            java.lang.String r5 = "=apps"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r0 = a.ec2.C(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L47
            goto L76
        L47:
            java.lang.String r0 = r13.f
            boolean r0 = a.ec2.C(r0, r14, r2, r3, r4)
            if (r0 == 0) goto L8e
            java.lang.String r1 = r13.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 44
            r0.append(r2)
            r0.append(r14)
            java.lang.String r2 = r0.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r7 = a.bc2.t(r1, r2, r3, r4, r5, r6)
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r9 = ""
            r8 = r14
            java.lang.String r14 = a.bc2.t(r7, r8, r9, r10, r11, r12)
            goto L8c
        L76:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r13.f
            r0.append(r1)
            java.lang.String r1 = ",-"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
        L8c:
            r13.f = r14
        L8e:
            boolean r14 = r13.h()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.pt0.i(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "packageName"
            a.f92.d(r14, r0)
            boolean r0 = r13.f(r14)
            if (r0 != 0) goto L13
            boolean r0 = r13.d(r14)
            if (r0 != 0) goto L13
            r14 = 1
            return r14
        L13:
            boolean r0 = r13.d(r14)
            if (r0 == 0) goto L1f
            r13.i(r14)
            r13.c(r14)
        L1f:
            java.lang.String r0 = r13.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r13.f2454a
            r1.append(r2)
            java.lang.String r2 = "=*"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = a.ec2.C(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L88
            java.lang.String r0 = r13.d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r13.f2454a
            r1.append(r5)
            java.lang.String r5 = "=apps"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r0 = a.ec2.C(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L59
            goto L88
        L59:
            java.lang.String r0 = r13.d
            boolean r0 = a.ec2.C(r0, r14, r2, r3, r4)
            if (r0 == 0) goto La0
            java.lang.String r1 = r13.d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 44
            r0.append(r2)
            r0.append(r14)
            java.lang.String r2 = r0.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r7 = a.bc2.t(r1, r2, r3, r4, r5, r6)
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r9 = ""
            r8 = r14
            java.lang.String r14 = a.bc2.t(r7, r8, r9, r10, r11, r12)
            goto L9e
        L88:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r13.d
            r0.append(r1)
            java.lang.String r1 = ",-"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
        L9e:
            r13.d = r14
        La0:
            boolean r14 = r13.h()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.pt0.j(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "packageName"
            a.f92.d(r14, r0)
            boolean r0 = r13.g(r14)
            if (r0 != 0) goto L13
            boolean r0 = r13.d(r14)
            if (r0 != 0) goto L13
            r14 = 1
            return r14
        L13:
            boolean r0 = r13.d(r14)
            if (r0 == 0) goto L1f
            r13.i(r14)
            r13.b(r14)
        L1f:
            java.lang.String r0 = r13.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r13.b
            r1.append(r2)
            java.lang.String r2 = "=*"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = a.ec2.C(r0, r1, r2, r3, r4)
            if (r0 != 0) goto L88
            java.lang.String r0 = r13.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = r13.b
            r1.append(r5)
            java.lang.String r5 = "=apps"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r0 = a.ec2.C(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L59
            goto L88
        L59:
            java.lang.String r0 = r13.e
            boolean r0 = a.ec2.C(r0, r14, r2, r3, r4)
            if (r0 == 0) goto La0
            java.lang.String r1 = r13.e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 44
            r0.append(r2)
            r0.append(r14)
            java.lang.String r2 = r0.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r7 = a.bc2.t(r1, r2, r3, r4, r5, r6)
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r9 = ""
            r8 = r14
            java.lang.String r14 = a.bc2.t(r7, r8, r9, r10, r11, r12)
            goto L9e
        L88:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r13.e
            r0.append(r1)
            java.lang.String r1 = ",-"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
        L9e:
            r13.e = r14
        La0:
            boolean r14 = r13.h()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.pt0.k(java.lang.String):boolean");
    }
}
