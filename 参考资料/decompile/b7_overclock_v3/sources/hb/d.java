package hb;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30812a = "CeaUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30813b = 1195456820;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30814c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f30815d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f30816e = 181;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f30817f = 49;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f30818g = 47;

    public static void a(long j10, hd.c0 c0Var, d0[] d0VarArr) {
        while (true) {
            if (c0Var.a() <= 1) {
                return;
            }
            int iC = c(c0Var);
            int iC2 = c(c0Var);
            int iE = c0Var.e() + iC2;
            if (iC2 == -1 || iC2 > c0Var.a()) {
                hd.t.n(f30812a, "Skipping remainder of malformed SEI NAL unit.");
                iE = c0Var.f();
            } else if (iC == 4 && iC2 >= 8) {
                int iG = c0Var.G();
                int iM = c0Var.M();
                int iO = iM == 49 ? c0Var.o() : 0;
                int iG2 = c0Var.G();
                if (iM == 47) {
                    c0Var.T(1);
                }
                boolean z10 = iG == 181 && (iM == 49 || iM == 47) && iG2 == 3;
                if (iM == 49) {
                    z10 &= iO == 1195456820;
                }
                if (z10) {
                    b(j10, c0Var, d0VarArr);
                }
            }
            c0Var.S(iE);
        }
    }

    public static void b(long j10, hd.c0 c0Var, d0[] d0VarArr) {
        int iG = c0Var.G();
        if ((iG & 64) != 0) {
            c0Var.T(1);
            int i10 = (iG & 31) * 3;
            int iE = c0Var.e();
            for (d0 d0Var : d0VarArr) {
                c0Var.S(iE);
                d0Var.d(c0Var, i10);
                d0Var.a(j10, 1, i10, 0, null);
            }
        }
    }

    public static int c(hd.c0 c0Var) {
        int i10 = 0;
        while (c0Var.a() != 0) {
            int iG = c0Var.G();
            i10 += iG;
            if (iG != 255) {
                return i10;
            }
        }
        return -1;
    }
}
