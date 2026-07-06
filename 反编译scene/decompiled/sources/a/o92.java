package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class o92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p92 f6998a;

    static {
        p92 p92Var = null;
        try {
            p92Var = (p92) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (p92Var == null) {
            p92Var = new p92();
        }
        f6998a = p92Var;
    }

    public static ka2 a(d92 d92Var) {
        f6998a.a(d92Var);
        return d92Var;
    }

    public static ia2 b(Class cls) {
        return f6998a.b(cls);
    }

    public static ja2 c(Class cls) {
        return f6998a.c(cls, "");
    }

    public static String d(c92 c92Var) {
        return f6998a.d(c92Var);
    }

    public static String e(g92 g92Var) {
        return f6998a.e(g92Var);
    }
}
