package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class ka0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6588a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[aa0.values().length];
        f6588a = iArr;
        iArr[aa0.BATTERY_FULL.ordinal()] = 1;
        f6588a[aa0.POWER_CONNECTED.ordinal()] = 2;
        f6588a[aa0.POWER_DISCONNECTED.ordinal()] = 3;
        f6588a[aa0.BATTERY_CHANGED.ordinal()] = 4;
        int[] iArr2 = new int[aa0.values().length];
        b = iArr2;
        iArr2[aa0.POWER_CONNECTED.ordinal()] = 1;
        b[aa0.POWER_DISCONNECTED.ordinal()] = 2;
        b[aa0.BATTERY_FULL.ordinal()] = 3;
        b[aa0.BATTERY_CHANGED.ordinal()] = 4;
    }
}
