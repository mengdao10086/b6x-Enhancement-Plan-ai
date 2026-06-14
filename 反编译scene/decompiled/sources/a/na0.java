package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class na0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6892a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[aa0.values().length];
        f6892a = iArr;
        iArr[aa0.BOOT_COMPLETED.ordinal()] = 1;
        f6892a[aa0.BATTERY_LOW.ordinal()] = 2;
        f6892a[aa0.BATTERY_FULL.ordinal()] = 3;
        f6892a[aa0.BATTERY_CAPACITY_CHANGED.ordinal()] = 4;
        f6892a[aa0.POWER_CONNECTED.ordinal()] = 5;
        f6892a[aa0.POWER_DISCONNECTED.ordinal()] = 6;
        f6892a[aa0.SCREEN_OFF.ordinal()] = 7;
        f6892a[aa0.SCREEN_ON.ordinal()] = 8;
        int[] iArr2 = new int[aa0.values().length];
        b = iArr2;
        iArr2[aa0.BOOT_COMPLETED.ordinal()] = 1;
        b[aa0.BATTERY_LOW.ordinal()] = 2;
        b[aa0.BATTERY_FULL.ordinal()] = 3;
        b[aa0.BATTERY_CAPACITY_CHANGED.ordinal()] = 4;
        b[aa0.POWER_CONNECTED.ordinal()] = 5;
        b[aa0.POWER_DISCONNECTED.ordinal()] = 6;
        b[aa0.SCREEN_OFF.ordinal()] = 7;
        b[aa0.SCREEN_ON.ordinal()] = 8;
        b[aa0.APP_SWITCH.ordinal()] = 9;
    }
}
