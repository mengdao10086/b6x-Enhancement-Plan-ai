package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tj0 f7508a = new tj0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z32 f3037a = a42.a(rj0.f7306a);
    public static final z32 b = a42.a(sj0.f7405a);

    public final boolean a() {
        return ((Boolean) f3037a.getValue()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public final String c(int i) {
        switch (i) {
            case 21:
                return "Android 5.0";
            case 22:
                return "Android 5.1";
            case 23:
                return "Android 6.0";
            case 24:
                return "Android 7.0";
            case 25:
                return "Android 7.1";
            case 26:
                return "Android 8.0";
            case 27:
                return "Android 8.1";
            case 28:
                return "Android 9";
            case 29:
                return "Android 10";
            case 30:
                return "Android 11";
            case 31:
                return "Android 12";
            case 32:
                return "Android 12L";
            case 33:
                return "Android 13";
            case 34:
                return "Android 14";
            case 35:
                return "Android 15";
            case 36:
                return "Android 16";
            default:
                return "SDK(" + i + ')';
        }
    }
}
