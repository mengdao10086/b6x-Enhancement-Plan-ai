package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ye f6099a = new df(null, false);
    public static final ye b = new df(null, true);
    public static final ye c = new df(af.f5600a, false);
    public static final ye d = new df(af.f5600a, true);

    static {
        ze zeVar = ze.f8062a;
        ef efVar = ef.f5995a;
    }

    public static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
