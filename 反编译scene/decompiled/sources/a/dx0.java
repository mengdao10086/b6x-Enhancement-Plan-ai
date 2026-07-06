package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5945a;
    public String b;

    public final String a() {
        if (this.f5945a == null) {
            e();
        }
        return this.f5945a;
    }

    public final String b() {
        if (this.b == null) {
            e();
        }
        String str = this.b;
        f92.b(str);
        return str;
    }

    public final void c(String str) {
        this.f5945a = str;
    }

    public final void d(String str) {
        f92.d(str, "value");
        this.b = str;
    }

    public final dx0 e() {
        this.f5945a = "";
        this.b = "";
        if (f92.a(e50.f677a.y0(), "root")) {
            try {
                g30 g30Var = new g30(e50.f677a.R0());
                if (g30Var.j("mode")) {
                    this.f5945a = g30Var.i("mode");
                }
                if (g30Var.j("scene")) {
                    this.b = g30Var.i("scene");
                }
                if (g30Var.j("category")) {
                    g30Var.i("category");
                }
            } catch (Exception unused) {
            }
        }
        return this;
    }
}
