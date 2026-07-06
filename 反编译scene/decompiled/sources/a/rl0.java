package a;

import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class rl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f7312a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f2750a = "/sys/kernel/ged/hal/custom_boost_gpu_freq";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2751a = true;
    public static Boolean b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f2752b = "/sys/kernel/ged/hal/custom_upbound_gpu_freq";
    public static Boolean c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String f2753c;
    public static String d;
    public static String e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f2754a;

    static {
        System.currentTimeMillis();
    }

    public final String a() {
        String strTrim = x60.f7856a.d("/proc/mtk_mali/gpu_memory").trim().split("\n")[0].replace("\t", " ").trim();
        return strTrim.contains(" ") ? strTrim.substring(strTrim.indexOf(" ")).trim() : "";
    }

    public final String b() {
        String strTrim = x60.f7856a.d("/proc/mali/memory_usage").trim().split("\n")[0].replace("\t", " ").trim();
        if (!strTrim.contains(" ") || !strTrim.contains("bytes") || !strTrim.contains("(")) {
            return "";
        }
        String strTrim2 = strTrim.substring(strTrim.indexOf(" ")).trim();
        return strTrim2.substring(strTrim2.indexOf("(") + 1, strTrim2.indexOf("b")).trim();
    }

    public String[] c() {
        if (k()) {
            String strD = x60.f7856a.d("/sys/class/kgsl/kgsl-3d0/freq_table_mhz");
            if (!strD.isEmpty()) {
                return strD.split("[ ]+");
            }
        }
        return new String[0];
    }

    public String[] d() {
        if (this.f2754a == null) {
            if (l()) {
                d42<String, String> d42VarA = x60.f7856a.a(new String[]{"/proc/gpufreq/gpufreq_opp_dump", "/proc/gpufreqv2/stack_working_opp_table", "/proc/gpufreqv2/gpu_working_opp_table"});
                if (d42VarA != null) {
                    String str = d42VarA.a().equals("/proc/gpufreq/gpufreq_opp_dump") ? "=" : ":";
                    String[] strArrSplit = d42VarA.b().split("\n");
                    int i = 0;
                    for (String str2 : strArrSplit) {
                        String str3 = str2.split(",")[0];
                        strArrSplit[i] = str3.substring(str3.indexOf(str) + 1).trim();
                        i++;
                    }
                    this.f2754a = strArrSplit;
                } else {
                    this.f2754a = new String[0];
                }
            } else if (k() || m()) {
                d42<String, String> d42VarA2 = x60.f7856a.a(new String[]{g() + "/available_frequencies", g() + "/gpu_available_frequencies"});
                String[] strArrSplit2 = d42VarA2 == null ? new String[0] : d42VarA2.d().split("[ ]+");
                this.f2754a = strArrSplit2;
                int i2 = 0;
                for (String str4 : strArrSplit2) {
                    if (str4.length() > 3) {
                        this.f2754a[i2] = str4.substring(0, str4.length() - 3);
                    }
                    i2++;
                }
            }
        }
        return this.f2754a;
    }

    public String e() {
        return x60.f7856a.d(g() + "/governor");
    }

    public String[] f() {
        String strD = x60.f7856a.d(g() + "/available_governors");
        return strD.isEmpty() ? new String[0] : strD.split("[ ]+");
    }

    public final String g() {
        String str;
        if (e50.f677a.y0().equals("basic")) {
            return "";
        }
        if (e == null) {
            if (k()) {
                str = b.booleanValue() ? "/sys/class/kgsl/kgsl-3d0" : "/sys/class/kgsl/kgsl-3d0/devfreq";
            } else if (m()) {
                str = "/sys/class/devfreq/gpufreq";
            } else {
                e = "";
            }
            e = str;
        }
        return e;
    }

    public String h() {
        if (!k() && (!m() || l())) {
            return o(f2752b);
        }
        if (!b.booleanValue()) {
            String strD = x60.f7856a.d(g() + "/max_freq");
            return strD.length() > 3 ? strD.substring(0, strD.length() - 3) : strD;
        }
        String strD2 = x60.f7856a.d(g() + "/max_clock_mhz");
        if (strD2.isEmpty()) {
            return strD2;
        }
        return strD2 + "000";
    }

    public String i() {
        if (!e50.f677a.y0().equals("root")) {
            return null;
        }
        if (!l()) {
            if (f2751a) {
                try {
                    return ((Long.parseLong(x60.f7856a.d("/sys/devices/virtual/kgsl/kgsl/page_alloc")) / 1024) / 1024) + "MB";
                } catch (Exception unused) {
                    f2751a = false;
                }
            }
            return null;
        }
        if (f2753c == null) {
            f2753c = "";
            if (n(s60.f7366a.c("cat /proc/mali/memory_usage | grep \"Total\" | cut -f2 -d \"(\" | cut -f1 -d \" \""))) {
                f2753c = "cat /proc/mali/memory_usage | grep \"Total\" | cut -f2 -d \"(\" | cut -f1 -d \" \"";
            } else if (n(a())) {
                f2753c = "/proc/mtk_mali/gpu_memory";
            } else if (n(b())) {
                f2753c = "/proc/mali/memory_usage";
            }
        }
        if (f2753c.isEmpty()) {
            return "?MB";
        }
        try {
            if ("/proc/mtk_mali/gpu_memory".equals(f2753c)) {
                String strA = a();
                if (!n(strA)) {
                    return "?MB";
                }
                return ((Long.parseLong(strA) * 4) / 1024) + "MB";
            }
            if ("/proc/mali/memory_usage".equals(f2753c)) {
                String strB = b();
                if (!n(strB)) {
                    return "?MB";
                }
                return ((Long.parseLong(strB) / 1024) / 1024) + "MB";
            }
            String strC = s60.f7366a.c(f2753c);
            if (!n(strC)) {
                return "?MB";
            }
            return ((Long.parseLong(strC) / 1024) / 1024) + "MB";
        } catch (Exception unused2) {
            return "?MB";
        }
    }

    public String j() {
        if (!k() && (!m() || l())) {
            return o(f2750a);
        }
        if (!b.booleanValue()) {
            String strD = x60.f7856a.d(g() + "/min_freq");
            return strD.length() > 3 ? strD.substring(0, strD.length() - 3) : strD;
        }
        String strD2 = x60.f7856a.d(g() + "/min_clock_mhz");
        if (strD2.isEmpty()) {
            return strD2;
        }
        return strD2 + "000";
    }

    public boolean k() {
        if (!e50.f677a.y0().equals("root")) {
            return false;
        }
        if (f7312a == null) {
            f7312a = Boolean.valueOf(y60.f7952a.c("/sys/class/kgsl/kgsl-3d0"));
            b = Boolean.valueOf(!y60.f7952a.c("/sys/class/kgsl/kgsl-3d0/devfreq"));
        }
        return f7312a.booleanValue();
    }

    public final boolean l() {
        if (d == null) {
            d = jm0.f6525a.b();
        }
        return d.startsWith("mt");
    }

    public boolean m() {
        if (e50.f677a.y0().equals("basic")) {
            return false;
        }
        if (c == null) {
            c = Boolean.valueOf(y60.f7952a.d(f2750a) || y60.f7952a.g("/sys/class/devfreq/gpufreq"));
        }
        return c.booleanValue();
    }

    public final boolean n(String str) {
        return new nb2("[0-9]{1,}").f(str);
    }

    public final String o(String str) {
        String[] strArrSplit = x60.f7856a.d(str).split("\n");
        if (strArrSplit.length <= 0) {
            return "";
        }
        try {
            return d()[Integer.parseInt(strArrSplit[0])];
        } catch (Exception unused) {
            return "";
        }
    }

    public void p(String str) {
        x60.f7856a.j(g() + "/governor", str);
    }

    public void q(String str) {
        if (e50.f677a.y0().equals("root")) {
            e50.f677a.O0(new String[]{"@gpu_freq_max", str});
        } else if (l()) {
            ul0.o(Arrays.asList(this.f2754a).indexOf(str));
        } else if (k()) {
            vm0.g(Arrays.asList(this.f2754a).indexOf(str));
        }
    }

    public void r(String str) {
        if (e50.f677a.y0().equals("root")) {
            e50.f677a.O0(new String[]{"@gpu_freq_min", str});
        } else if (l()) {
            ul0.p(Arrays.asList(this.f2754a).indexOf(str));
        } else if (k()) {
            vm0.h(Arrays.asList(this.f2754a).indexOf(str));
        }
    }

    public boolean s() {
        return k() || m();
    }
}
