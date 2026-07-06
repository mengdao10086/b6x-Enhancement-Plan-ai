package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class zi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8075a;

    static {
        int[] iArr = new int[bj2.values().length];
        f8075a = iArr;
        iArr[bj2.PARKING.ordinal()] = 1;
        f8075a[bj2.BLOCKING.ordinal()] = 2;
        f8075a[bj2.CPU_ACQUIRED.ordinal()] = 3;
        f8075a[bj2.DORMANT.ordinal()] = 4;
        f8075a[bj2.TERMINATED.ordinal()] = 5;
    }
}
