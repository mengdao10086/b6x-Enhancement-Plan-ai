package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class d92 extends x82 implements c92, ka2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5875a;
    public final int b;

    public d92(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.f5875a = i;
        this.b = i2 >> 1;
    }

    @Override // a.x82
    public ha2 b() {
        o92.a(this);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d92) {
            d92 d92Var = (d92) obj;
            return f92.a(g(), d92Var.g()) && e().equals(d92Var.e()) && j().equals(d92Var.j()) && this.b == d92Var.b && this.f5875a == d92Var.f5875a && f92.a(c(), d92Var.c());
        }
        if (obj instanceof ka2) {
            return obj.equals(a());
        }
        return false;
    }

    @Override // a.c92
    public int h() {
        return this.f5875a;
    }

    public int hashCode() {
        return (((g() == null ? 0 : g().hashCode() * 31) + e().hashCode()) * 31) + j().hashCode();
    }

    public String toString() {
        ha2 ha2VarA = a();
        if (ha2VarA != this) {
            return ha2VarA.toString();
        }
        if ("<init>".equals(e())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + e() + " (Kotlin reflection is not available)";
    }
}
