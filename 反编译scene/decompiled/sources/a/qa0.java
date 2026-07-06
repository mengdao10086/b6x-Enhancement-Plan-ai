package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class qa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7192a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[aa0.values().length];
        f7192a = iArr;
        iArr[aa0.SCREEN_ON.ordinal()] = 1;
        f7192a[aa0.SCREEN_OFF.ordinal()] = 2;
        f7192a[aa0.POWER_CONNECTED.ordinal()] = 3;
        f7192a[aa0.POWER_DISCONNECTED.ordinal()] = 4;
        f7192a[aa0.BATTERY_CHANGED.ordinal()] = 5;
        f7192a[aa0.BATTERY_FULL.ordinal()] = 6;
        int[] iArr2 = new int[aa0.values().length];
        b = iArr2;
        iArr2[aa0.SCREEN_ON.ordinal()] = 1;
        b[aa0.SCREEN_OFF.ordinal()] = 2;
        b[aa0.POWER_CONNECTED.ordinal()] = 3;
        b[aa0.BATTERY_FULL.ordinal()] = 4;
        b[aa0.POWER_DISCONNECTED.ordinal()] = 5;
        b[aa0.BATTERY_CHANGED.ordinal()] = 6;
    }
}
