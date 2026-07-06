package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m50 f6876a = new m50(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2021a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2022b;

    public n50() {
        this.f2020a = "";
        this.b = "";
    }

    public /* synthetic */ n50(b92 b92Var) {
        this();
    }

    public n50(g30 g30Var) throws e30 {
        f92.d(g30Var, "jsonObject");
        this.f2020a = "";
        this.b = "";
        if (g30Var.j("isDir")) {
            this.f2021a = g30Var.c("isDir");
        }
        if (g30Var.j("name")) {
            String strI = g30Var.i("name");
            f92.c(strI, "jsonObject.getString(\"name\")");
            this.f2020a = strI;
        }
        if (g30Var.j("absPath")) {
            String strI2 = g30Var.i("absPath");
            f92.c(strI2, "jsonObject.getString(\"absPath\")");
            this.b = strI2;
        }
        if (g30Var.j("size")) {
            this.f2019a = g30Var.h("size");
        }
        if (g30Var.j("exist")) {
            this.f2022b = g30Var.c("exist");
        }
        if (g30Var.j("items")) {
            g30Var.e("items");
        }
    }

    public final int a() {
        if (this.f2021a) {
            return e50.f677a.F0(this.b);
        }
        return 0;
    }

    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this.f2022b;
    }

    public final String d() {
        return this.f2020a;
    }

    public final String e() {
        if (!ec2.C(this.b, "/", false, 2, null)) {
            return "";
        }
        String str = this.b;
        int iS = ec2.S(str, "/", 0, false, 6, null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(0, iS);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final long f() {
        return this.f2019a;
    }

    public final boolean g() {
        return this.f2021a;
    }

    public final ArrayList<n50> h(String str) {
        ArrayList<n50> arrayListA;
        f92.d(str, "suffix");
        if (!this.f2021a) {
            return new ArrayList<>();
        }
        o50 o50VarI0 = e50.f677a.I0(this.b, str);
        return (o50VarI0 == null || (arrayListA = o50VarI0.a()) == null) ? new ArrayList<>() : arrayListA;
    }

    public final void i(String str) {
        f92.d(str, "<set-?>");
        this.b = str;
    }

    public final void j(boolean z) {
        this.f2022b = z;
    }

    public final void k(String str) {
        f92.d(str, "<set-?>");
        this.f2020a = str;
    }
}
