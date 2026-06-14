package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class vh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f7698a;

    static {
        Object objA;
        try {
            e42 e42Var = g42.f6169a;
            objA = Class.forName("android.os.Build");
            g42.a(objA);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        f7698a = g42.d(objA);
    }

    public static final boolean a() {
        return f7698a;
    }
}
