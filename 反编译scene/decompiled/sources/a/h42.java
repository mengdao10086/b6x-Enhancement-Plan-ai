package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class h42 {
    public static final Object a(Throwable th) {
        f92.d(th, "exception");
        return new f42(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof f42) {
            throw ((f42) obj).f6073a;
        }
    }
}
