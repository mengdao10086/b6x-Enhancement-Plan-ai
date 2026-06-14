package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class df2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final li2 f5894a = new li2("REMOVED_TASK");
    public static final li2 b = new li2("CLOSED_EMPTY");

    public static final long c(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
