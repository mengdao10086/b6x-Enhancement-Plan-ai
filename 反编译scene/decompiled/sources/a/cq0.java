package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class cq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f5818a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[aa0.values().length];
        f5818a = iArr;
        iArr[aa0.APP_SWITCH.ordinal()] = 1;
        f5818a[aa0.SCREEN_ON.ordinal()] = 2;
        f5818a[aa0.SCREEN_OFF.ordinal()] = 3;
        f5818a[aa0.POWER_CONNECTED.ordinal()] = 4;
        f5818a[aa0.POWER_DISCONNECTED.ordinal()] = 5;
        f5818a[aa0.SCENE_CONFIG.ordinal()] = 6;
        f5818a[aa0.SCENE_APP_CONFIG.ordinal()] = 7;
        int[] iArr2 = new int[aa0.values().length];
        b = iArr2;
        iArr2[aa0.APP_SWITCH.ordinal()] = 1;
        b[aa0.SCREEN_OFF.ordinal()] = 2;
        b[aa0.SCREEN_ON.ordinal()] = 3;
        b[aa0.SCENE_CONFIG.ordinal()] = 4;
        b[aa0.SCENE_APP_CONFIG.ordinal()] = 5;
        b[aa0.POWER_CONNECTED.ordinal()] = 6;
        b[aa0.POWER_DISCONNECTED.ordinal()] = 7;
    }
}
