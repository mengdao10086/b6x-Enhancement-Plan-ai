package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a9 extends d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a9 f5581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d9 f49a;
    public d9 b;

    public a9() {
        c9 c9Var = new c9();
        this.b = c9Var;
        this.f49a = c9Var;
    }

    public static a9 b() {
        if (f5581a != null) {
            return f5581a;
        }
        synchronized (a9.class) {
            if (f5581a == null) {
                f5581a = new a9();
            }
        }
        return f5581a;
    }

    @Override // a.d9
    public boolean a() {
        return this.f49a.a();
    }
}
