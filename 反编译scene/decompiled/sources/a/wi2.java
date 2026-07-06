package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l62 f3447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f3448a;

    public wi2(l62 l62Var, int i) {
        this.f3447a = l62Var;
        this.f3448a = new Object[i];
    }

    public final void a(Object obj) {
        Object[] objArr = this.f3448a;
        int i = this.f7793a;
        this.f7793a = i + 1;
        objArr[i] = obj;
    }

    public final l62 b() {
        return this.f3447a;
    }

    public final void c() {
        this.f7793a = 0;
    }

    public final Object d() {
        Object[] objArr = this.f3448a;
        int i = this.f7793a;
        this.f7793a = i + 1;
        return objArr[i];
    }
}
