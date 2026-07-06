package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qg2 f7212a = new qg2();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadLocal<ve2> f2570a = new ThreadLocal<>();

    public final ve2 a() {
        return f2570a.get();
    }

    public final ve2 b() {
        ve2 ve2Var = f2570a.get();
        if (ve2Var != null) {
            return ve2Var;
        }
        ve2 ve2VarA = cf2.a();
        f2570a.set(ve2VarA);
        return ve2VarA;
    }

    public final void c() {
        f2570a.set(null);
    }

    public final void d(ve2 ve2Var) {
        f2570a.set(ve2Var);
    }
}
