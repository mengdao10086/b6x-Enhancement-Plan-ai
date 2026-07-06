package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bi2 {
    public bi2() {
    }

    public /* synthetic */ bi2(b92 b92Var) {
        this();
    }

    public final int a(long j) {
        return (j & 2305843009213693952L) != 0 ? 2 : 1;
    }

    public final long b(long j, int i) {
        return d(j, 1073741823L) | (((long) i) << 0);
    }

    public final long c(long j, int i) {
        return d(j, 1152921503533105152L) | (((long) i) << 30);
    }

    public final long d(long j, long j2) {
        return j & (~j2);
    }
}
