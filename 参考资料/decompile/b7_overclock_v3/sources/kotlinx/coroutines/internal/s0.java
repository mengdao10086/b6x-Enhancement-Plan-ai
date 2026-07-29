package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38832a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f38832a;
    }

    @yt.l
    public static final String b(@yt.k String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
