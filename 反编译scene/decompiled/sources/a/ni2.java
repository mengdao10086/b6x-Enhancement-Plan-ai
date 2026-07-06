package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class ni2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6923a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f6923a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
