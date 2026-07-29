package os;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46218a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f46219b = 6;

    public static String a(int i10) {
        if (i10 == 5) {
            return "qTESLA-p-I";
        }
        if (i10 == 6) {
            return "qTESLA-p-III";
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }

    public static int b(int i10) {
        if (i10 == 5) {
            return i.f46247y;
        }
        if (i10 == 6) {
            return j.f46278x;
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }

    public static int c(int i10) {
        if (i10 == 5) {
            return i.f46248z;
        }
        if (i10 == 6) {
            return j.f46279y;
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }

    public static int d(int i10) {
        if (i10 == 5) {
            return i.f46246x;
        }
        if (i10 == 6) {
            return j.f46277w;
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }

    public static void e(int i10) {
        if (i10 == 5 || i10 == 6) {
            return;
        }
        throw new IllegalArgumentException("unknown security category: " + i10);
    }
}
