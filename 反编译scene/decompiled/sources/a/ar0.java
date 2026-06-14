package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ar0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f112a;
    public Boolean b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f114b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f115c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5635a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f111a = "";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f113b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";

    public static /* synthetic */ String n(ar0 ar0Var, g30 g30Var, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return ar0Var.m(g30Var, str, str2);
    }

    public final String a() {
        return this.c;
    }

    public final boolean b(g30 g30Var, String str) {
        if (g30Var.j(str) && (!f92.a(g30Var.b(str), g30.f959a))) {
            return g30Var.c(str);
        }
        return false;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        return this.f;
    }

    public final Boolean e() {
        return this.f110a;
    }

    public final Boolean f() {
        return this.b;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.f113b;
    }

    public final boolean i() {
        return this.f114b;
    }

    public final boolean j() {
        return this.f115c;
    }

    public final String k() {
        return this.e;
    }

    public final boolean l() {
        return this.f112a;
    }

    public final String m(g30 g30Var, String str, String str2) {
        if (!g30Var.j(str) || !(!f92.a(g30Var.b(str), g30.f959a))) {
            return str2;
        }
        String strI = g30Var.i(str);
        f92.c(strI, "resultObj.getString(prop)");
        return strI;
    }

    public final String o() {
        return this.f111a;
    }

    public final long p() {
        return this.f5635a;
    }

    public final void q(g30 g30Var) throws e30 {
        f92.d(g30Var, "resultObj");
        if (g30Var.j("versionCode") && (!f92.a(g30Var.b("versionCode"), g30.f959a))) {
            this.f5635a = g30Var.h("versionCode");
        }
        this.f111a = n(this, g30Var, "version", null, 4, null);
        this.f113b = n(this, g30Var, "name", null, 4, null);
        this.c = n(this, g30Var, "author", null, 4, null);
        this.d = n(this, g30Var, "module", null, 4, null);
        this.e = n(this, g30Var, "state", null, 4, null);
        this.f = n(this, g30Var, "executor", null, 4, null);
        this.g = n(this, g30Var, "buildTime", null, 4, null);
        if (g30Var.j("features") && (!f92.a(g30Var.b("features"), g30.f959a))) {
            g30 g30VarG = g30Var.g("features");
            f92.c(g30VarG, "features");
            this.f112a = b(g30VarG, "strict");
            this.f114b = b(g30VarG, "pedestal");
            this.f115c = b(g30VarG, "reboot");
            if (g30VarG.j("fas")) {
                this.f110a = Boolean.valueOf(b(g30VarG, "fas"));
            }
            if (g30VarG.j("limiter")) {
                this.b = Boolean.valueOf(b(g30VarG, "limiter"));
            }
        }
    }

    public final void r(long j) {
        this.f5635a = j;
    }
}
