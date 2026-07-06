package a;

import android.os.BatteryManager;
import android.os.Build;
import com.omarea.Scene;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static double f6087a = -1.0d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static long f866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f871a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f875b;
    public static double c;
    public static double d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final fa0 f867a = new fa0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z32 f868a = a42.a(ca0.f5770a);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final z32 f874b = a42.a(ba0.f5687a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static int f865a = -1;
    public static double b = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static long f873b = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static int f872b = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f870a = "";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static long f876c = System.currentTimeMillis() - ((long) 5000);

    public static /* synthetic */ void r(fa0 fa0Var, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        fa0Var.q(str, str2);
    }

    public static /* synthetic */ long z(fa0 fa0Var, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        return fa0Var.y(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final double A() {
        /*
            r7 = this;
            a.e50 r0 = a.e50.f677a
            java.lang.String r0 = r0.y0()
            java.lang.String r1 = "basic"
            boolean r1 = a.f92.a(r0, r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L94
            java.lang.String r1 = "root"
            boolean r0 = a.f92.a(r0, r1)
            r1 = 0
            if (r0 == 0) goto L67
            java.lang.Boolean r0 = a.fa0.f869a
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            boolean r0 = a.f92.a(r0, r3)
            r0 = r0 ^ r2
            if (r0 == 0) goto L67
            a.j92 r0 = new a.j92
            r0.<init>()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            double r3 = (double) r3
            r0.f6490a = r3
            a.ea0 r3 = new a.ea0
            r3.<init>(r0, r1)
            java.lang.Object r1 = a.oc2.f(r1, r3, r2, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            double r3 = r1.doubleValue()
            java.lang.Boolean r1 = a.fa0.f869a
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r1 = a.f92.a(r1, r5)
            if (r1 == 0) goto L50
            double r0 = r0.f6490a
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L94
        L4d:
            a.fa0.f6087a = r3
            goto L94
        L50:
            double r0 = r0.f6490a
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L57
            goto L58
        L57:
            r2 = 0
        L58:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            a.fa0.f869a = r0
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = a.f92.a(r0, r1)
            if (r0 == 0) goto L94
            goto L4d
        L67:
            a.da0 r0 = new a.da0
            r0.<init>(r1)
            java.lang.Object r0 = a.oc2.f(r1, r0, r2, r1)
            com.omarea.model.BatteryStatus r0 = (com.omarea.model.BatteryStatus) r0
            double r1 = r0.temperature
            double r3 = r0.voltage
            r5 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L84
            r5 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L84
            a.fa0.b = r3
        L84:
            r0 = 10
            double r3 = (double) r0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L94
            r0 = 100
            double r3 = (double) r0
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L94
            a.fa0.f6087a = r1
        L94:
            double r0 = a.fa0.f6087a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fa0.A():double");
    }

    public final void B() {
        f873b = (e().getLongProperty(2) / ((long) Scene.f4798a.g().getInt(m61.f6775a.c(), hz0.f1282a.L()))) * ((long) (Scene.f4798a.b(m61.f6775a.a(), false) ? 2 : 1));
    }

    public final int a() {
        return f865a;
    }

    public final long b() {
        return f873b;
    }

    public final int c() {
        return f872b;
    }

    public final double d() {
        return b;
    }

    public final BatteryManager e() {
        return (BatteryManager) f874b.getValue();
    }

    public final String f() {
        int iG = g();
        q92 q92Var = q92.f7191a;
        String str = String.format("%.1fW?", Arrays.copyOf(new Object[]{Double.valueOf(((double) iG) / ((double) 1000))}, 1));
        f92.c(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final int g() {
        double dP = ((f873b * p()) + (f871a ? 1.2d : 0.0d)) / 0.92d;
        if (dP < 0) {
            return 0;
        }
        return (int) dP;
    }

    public final boolean h() {
        int i = f872b;
        return i == 2 || i == 5;
    }

    public final String i() {
        String str = f875b;
        return str != null ? str : f870a;
    }

    public final String j() {
        return f870a;
    }

    public final int k() {
        return ((Number) f868a.getValue()).intValue();
    }

    public final double l() {
        return (k() <= 2510 && b >= 5.0d) ? ((double) k()) * 3.86d * ((double) 2) : ((double) k()) * 3.86d;
    }

    public final boolean m() {
        int i = f872b;
        return i == 3 || i == 4;
    }

    public final String n() {
        String str;
        long j = f873b;
        int i = f872b;
        double dP = ((double) ((int) (j * p()))) / ((double) 1000);
        if (dP >= 100 || dP <= -100) {
            q92 q92Var = q92.f7191a;
            str = String.format("%.1fW", Arrays.copyOf(new Object[]{Double.valueOf(dP)}, 1));
        } else {
            q92 q92Var2 = q92.f7191a;
            str = String.format("%.2fW", Arrays.copyOf(new Object[]{Double.valueOf(dP)}, 1));
        }
        f92.c(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final double o() {
        return f6087a;
    }

    public final double p() {
        double d2 = 0;
        if (b <= d2) {
            return 4.0d;
        }
        if (d > 0.0d && System.currentTimeMillis() - f876c < 3000) {
            return d;
        }
        double dB = hl0.f6321a.b();
        if (dB <= d2) {
            return b;
        }
        f876c = System.currentTimeMillis();
        if (c == 0.0d) {
            int i = (int) (dB > 3.1d ? dB / 3.1d : dB / 3.0d);
            double d3 = b;
            int i2 = (int) (d3 > 3.1d ? d3 / 3.1d : d3 / 3.0d);
            c = i == i2 ? 1.0d : i > i2 ? 2.0d : 0.5d;
        }
        double d4 = dB / c;
        d = d4;
        b = d4;
        return d4;
    }

    public final void q(String str, String str2) {
        f92.d(str, "app");
        f870a = str;
        f875b = str2;
    }

    public final void s(int i) {
        f865a = i;
    }

    public final void t(int i) {
        f872b = i;
    }

    public final void u(double d2) {
        b = d2;
    }

    public final void v(boolean z) {
        f871a = z;
    }

    public final void w(double d2) {
        f6087a = d2;
    }

    public final void x() {
        int intProperty;
        B();
        f865a = e().getIntProperty(4);
        if (Build.VERSION.SDK_INT < 26 || (intProperty = e().getIntProperty(6)) == 1) {
            return;
        }
        f872b = intProperty;
    }

    public final long y(long j) {
        if (j == 0 || System.currentTimeMillis() - j >= f866a) {
            x();
            A();
            f866a = System.currentTimeMillis();
        }
        return f866a;
    }
}
