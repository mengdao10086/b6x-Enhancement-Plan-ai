package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ug0 f7693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3278a;
    public String b;

    public final String a() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        f92.m("fullName");
        throw null;
    }

    public final ug0 b() {
        ug0 ug0Var = this.f7693a;
        if (ug0Var != null) {
            return ug0Var;
        }
        f92.m("mode");
        throw null;
    }

    public final String c() {
        String str = this.f3278a;
        if (str != null) {
            return str;
        }
        f92.m("name");
        throw null;
    }

    public final void d(String str) {
        f92.d(str, "<set-?>");
        this.b = str;
    }

    public final void e(ug0 ug0Var) {
        f92.d(ug0Var, "<set-?>");
        this.f7693a = ug0Var;
    }

    public final void f(String str) {
        f92.d(str, "<set-?>");
        this.f3278a = str;
    }
}
