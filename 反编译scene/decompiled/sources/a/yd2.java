package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class yd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f7973a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[zd2.values().length];
        f7973a = iArr;
        iArr[zd2.DEFAULT.ordinal()] = 1;
        f7973a[zd2.ATOMIC.ordinal()] = 2;
        f7973a[zd2.UNDISPATCHED.ordinal()] = 3;
        f7973a[zd2.LAZY.ordinal()] = 4;
        int[] iArr2 = new int[zd2.values().length];
        b = iArr2;
        iArr2[zd2.DEFAULT.ordinal()] = 1;
        b[zd2.ATOMIC.ordinal()] = 2;
        b[zd2.UNDISPATCHED.ordinal()] = 3;
        b[zd2.LAZY.ordinal()] = 4;
    }
}
