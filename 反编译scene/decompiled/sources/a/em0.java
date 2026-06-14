package a;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class em0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f6020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static am0 f771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mn0 f772a = new mn0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f773a = a42.a(dm0.f5915a);

    public static /* synthetic */ zl0 e(em0 em0Var, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return em0Var.d(str);
    }

    public final kl0 a() {
        return (kl0) this.f773a.getValue();
    }

    public final Object b(b62<? super m42> b62Var) {
        Object objD = this.f772a.d(b62Var);
        return objD == r62.c() ? objD : m42.f6769a;
    }

    public final yl0 c(String str, Integer num) {
        String string;
        String strValueOf;
        this.f772a.e(str != null ? str : "");
        e50 e50Var = e50.f677a;
        if (num == null || (strValueOf = String.valueOf(num.intValue())) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("pkg:");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            string = sb.toString();
        } else {
            string = strValueOf;
        }
        String strJ1 = e50.j1(e50Var, "adb-monitor-fps", string, null, 4, null);
        if (!f92.a(strJ1, "error")) {
            if (strJ1.length() > 0) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                g30 g30Var = new g30(strJ1);
                yl0 yl0Var = new yl0();
                yl0Var.g(k30.a(g30Var, "cpu_load"));
                yl0Var.n(k30.b(g30Var, "cpu_cycles"));
                yl0Var.f(k30.b(g30Var, "cpu_freq"));
                yl0Var.i(g30Var.e("gpu_freq") / 1000);
                yl0Var.j(g30Var.e("gpu_load"));
                yl0Var.p(g30Var.e("ddr_freq"));
                double d = 10;
                yl0Var.o(((double) ((int) (g30Var.d("cpu_temp") * d))) / 10.0d);
                String strI = g30Var.i("view");
                f92.c(strI, "getString(\"view\")");
                yl0Var.D(strI);
                yl0Var.h(((double) ((int) (g30Var.d("fps") * d))) / 10.0d);
                if (g30Var.j("frame_sequence") && (!f92.a(g30Var.b("frame_sequence"), g30.f959a))) {
                    yl0Var.A(k30.b(g30Var, "frame_sequence"));
                }
                yl0Var.C(g30Var.e("jank"));
                yl0Var.z(g30Var.e("big_jank"));
                yl0Var.B(g30Var.e("frame_time"));
                yl0Var.w(g30Var.e("battery_capacity"));
                yl0Var.x(g30Var.d("battery_temp"));
                yl0Var.y(g30Var.d("battery_voltage"));
                Object objB = g30Var.b("threads");
                if (true ^ f92.a(objB, g30.f959a)) {
                    mn0 mn0Var = this.f772a;
                    if (objB == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.json.JSONArray");
                    }
                    yl0Var.E(mn0.c(mn0Var, (d30) objB, 0, 2, null));
                }
                f6020a = jElapsedRealtime;
                f771a = yl0Var;
                return yl0Var;
            }
        }
        return null;
    }

    public final zl0 d(String str) {
        e50 e50Var = e50.f677a;
        if (str == null) {
            str = "";
        }
        String strJ1 = e50.j1(e50Var, "get-accurate-fps", str, null, 4, null);
        if (!(!f92.a(strJ1, "error"))) {
            return null;
        }
        if (!(strJ1.length() > 0)) {
            return null;
        }
        g30 g30Var = new g30(strJ1);
        zl0 zl0Var = new zl0();
        zl0Var.e(((double) ((int) (g30Var.d("fps") * ((double) 10)))) / 10.0d);
        String strI = g30Var.i("layer");
        f92.c(strI, "getString(\"layer\")");
        zl0Var.i(strI);
        zl0Var.h(g30Var.e("jank"));
        zl0Var.d(g30Var.e("big_jank"));
        zl0Var.g(g30Var.e("frame_time"));
        if (g30Var.j("frame_sequence") && (true ^ f92.a(g30Var.b("frame_sequence"), g30.f959a))) {
            zl0Var.f(k30.b(g30Var, "frame_sequence"));
        }
        return zl0Var;
    }

    public final am0 f() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strJ1 = e50.j1(e50.f677a, "adb-monitor-full", "", null, 4, null);
        if (!(!f92.a(strJ1, "error"))) {
            return null;
        }
        if (!(strJ1.length() > 0)) {
            return null;
        }
        g30 g30Var = new g30(strJ1);
        am0 am0Var = new am0();
        am0Var.g(k30.a(g30Var, "cpu_load"));
        am0Var.n(k30.b(g30Var, "cpu_cycles"));
        am0Var.f(k30.b(g30Var, "cpu_freq"));
        am0Var.i(g30Var.e("gpu_freq") / 1000);
        am0Var.j(g30Var.e("gpu_load"));
        am0Var.p(g30Var.e("ddr_freq"));
        double d = 10;
        am0Var.o(((double) ((int) (g30Var.d("cpu_temp") * d))) / 10.0d);
        am0Var.h(((double) ((int) (g30Var.d("fps") * d))) / 10.0d);
        f6020a = jElapsedRealtime;
        f771a = am0Var;
        return am0Var;
    }

    public final bm0 g() {
        Integer numJ;
        Integer numJ2;
        Integer numJ3;
        if (!f92.a(e50.f677a.y0(), "basic")) {
            String strJ1 = e50.j1(e50.f677a, "adb-monitor-home", "", null, 4, null);
            if ((strJ1.length() > 0 ? 1 : 0) == 0 || !(!f92.a(strJ1, "error"))) {
                return null;
            }
            g30 g30Var = new g30(strJ1);
            bm0 bm0Var = new bm0();
            bm0Var.g(k30.a(g30Var, "cpu_load"));
            bm0Var.n(k30.b(g30Var, "cpu_cycles"));
            bm0Var.f(k30.b(g30Var, "cpu_freq"));
            bm0Var.t(k30.b(g30Var, "cpu_freq_min"));
            bm0Var.s(k30.b(g30Var, "cpu_freq_max"));
            bm0Var.i(g30Var.e("gpu_freq") / 1000);
            bm0Var.j(g30Var.e("gpu_load"));
            bm0Var.o(((double) ((int) (g30Var.d("cpu_temp") * ((double) 10)))) / 10.0d);
            return bm0Var;
        }
        bm0 bm0Var2 = new bm0();
        jl0[] jl0VarArrN = a().n();
        if (jl0VarArrN == null) {
            jl0VarArrN = new jl0[0];
        }
        ArrayList arrayList = new ArrayList(jl0VarArrN.length);
        for (jl0 jl0Var : jl0VarArrN) {
            String str = jl0Var.c;
            arrayList.add(Integer.valueOf((str == null || (numJ3 = ac2.j(str)) == null) ? 0 : numJ3.intValue()));
        }
        Object[] array = arrayList.toArray(new Integer[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        bm0Var2.f((Integer[]) array);
        ArrayList arrayList2 = new ArrayList(jl0VarArrN.length);
        for (jl0 jl0Var2 : jl0VarArrN) {
            String str2 = jl0Var2.f6522a;
            arrayList2.add(Integer.valueOf((str2 == null || (numJ2 = ac2.j(str2)) == null) ? 0 : numJ2.intValue()));
        }
        Object[] array2 = arrayList2.toArray(new Integer[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        bm0Var2.s((Integer[]) array2);
        ArrayList arrayList3 = new ArrayList(jl0VarArrN.length);
        for (jl0 jl0Var3 : jl0VarArrN) {
            String str3 = jl0Var3.b;
            arrayList3.add(Integer.valueOf((str3 == null || (numJ = ac2.j(str3)) == null) ? 0 : numJ.intValue()));
        }
        Object[] array3 = arrayList3.toArray(new Integer[0]);
        if (array3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        bm0Var2.t((Integer[]) array3);
        int iB = ga2.b(a().h(), 8);
        Double[] dArr = new Double[iB];
        while (i < iB) {
            dArr[i] = Double.valueOf(0.0d);
            i++;
        }
        bm0Var2.g(dArr);
        bm0Var2.i(-1);
        bm0Var2.j(-1);
        return bm0Var2;
    }

    public final cm0 h() {
        am0 am0Var;
        if (SystemClock.elapsedRealtime() - f6020a < 500 && (am0Var = f771a) != null) {
            return am0Var;
        }
        String strJ1 = e50.j1(e50.f677a, "adb-monitor-min", "", null, 4, null);
        if (!(!f92.a(strJ1, "error"))) {
            return null;
        }
        g30 g30Var = new g30(strJ1);
        cm0 cm0Var = new cm0();
        cm0Var.g(k30.a(g30Var, "cpu_load"));
        cm0Var.f(k30.b(g30Var, "cpu_freq"));
        cm0Var.i(g30Var.e("gpu_freq") / 1000);
        cm0Var.j(g30Var.e("gpu_load"));
        cm0Var.h(((double) ((int) (g30Var.d("fps") * ((double) 10)))) / 10.0d);
        return cm0Var;
    }
}
