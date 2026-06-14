package a;

import com.omarea.vtools.SceneJNI;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String[]> f6617a = new ArrayList<>();
    public static int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SceneJNI f1652a = new SceneJNI();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1651a = -1;

    public boolean A() {
        return jm0.f6525a.d();
    }

    public boolean B() {
        return jm0.f6525a.e();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String C() {
        for (String str : x60.f7856a.d("/proc/cpuinfo").split("\n")) {
            if (str.startsWith("CPU part")) {
                String strTrim = str.split(":")[1].trim();
                byte b2 = -1;
                switch (strTrim.hashCode()) {
                    case 47959285:
                        if (strTrim.equals("0x805")) {
                            b2 = 5;
                        }
                        break;
                    case 48001569:
                        if (strTrim.equals("0xd05")) {
                            b2 = 4;
                        }
                        break;
                    case 48001694:
                        if (strTrim.equals("0xd46")) {
                            b2 = 3;
                        }
                        break;
                    case 48001812:
                        if (strTrim.equals("0xd80")) {
                            b2 = 2;
                        }
                        break;
                    case 48001813:
                        if (strTrim.equals("0xd81")) {
                            b2 = 1;
                        }
                        break;
                    case 48001819:
                        if (strTrim.equals("0xd87")) {
                            b2 = 0;
                        }
                        break;
                }
                if (b2 == 0) {
                    return "a725";
                }
                if (b2 == 1) {
                    return "a720";
                }
                if (b2 == 2) {
                    return "a520";
                }
                if (b2 == 3) {
                    return "a510";
                }
                if (b2 == 4 || b2 == 5) {
                    return "a55";
                }
            }
        }
        return "a53";
    }

    public final void D(int i) {
        if (y60.f7952a.d("/proc/cpudvfs/cpufreq_debug")) {
            String[] strArrD = d(i);
            x60.f7856a.j("/proc/cpudvfs/cpufreq_debug", f().get(i)[0] + " " + strArrD[strArrD.length - 1] + " " + strArrD[0]);
            return;
        }
        if (y60.f7952a.d("/proc/powerhal_cpu_ctrl/perfserv_freq")) {
            StringBuilder sb = new StringBuilder();
            int size = f().size();
            for (int i2 = 0; i2 < size; i2++) {
                String[] strArrD2 = d(i2);
                sb.append(strArrD2[strArrD2.length - 1]);
                sb.append(" ");
                sb.append(strArrD2[0]);
                sb.append(" ");
            }
            x60.f7856a.j("/proc/powerhal_cpu_ctrl/perfserv_freq", sb.toString().trim());
        }
    }

    public void E(int i, boolean z) {
        if (!e50.f677a.y0().equals("root")) {
            if (B()) {
                ul0.l(i, !z);
            }
        } else {
            x60.f7856a.i("/sys/devices/system/cpu/cpu0/online".replace("cpu0", "cpu" + i), z ? "1" : "0");
        }
    }

    public void F(String str, int i) {
        if (i >= f().size()) {
            return;
        }
        String[] strArr = f().get(i);
        if (str == null || strArr.length <= 0) {
            return;
        }
        x60.f7856a.i("/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor".replace("cpu0", "cpu" + strArr[0]), str);
    }

    public void G(int i, String str) {
        if (i >= f().size()) {
            return;
        }
        if (!e50.f677a.y0().equals("root")) {
            if (B()) {
                ul0.m(i, Integer.parseInt(str));
                return;
            } else {
                if (A()) {
                    vm0.e(i, Integer.parseInt(str));
                    return;
                }
                return;
            }
        }
        if (B() && a()) {
            x60.f7856a.j("/proc/ppm/policy/hard_userlimit_max_cpu_freq", i + " " + str);
            return;
        }
        String[] strArr = f().get(i);
        if (str == null || strArr.length <= 0) {
            return;
        }
        if (A()) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(":");
                sb.append(str);
                sb.append(" ");
            }
            String strTrim = sb.toString().trim();
            if (!x60.f7856a.i("/sys/module/msm_performance/parameters/cpu_max_freq", strTrim)) {
                x60.f7856a.i("/sys/kernel/msm_performance/parameters/cpu_max_freq", strTrim);
            }
        } else if (B()) {
            D(i);
        }
        if (x60.f7856a.i("/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq".replace("cpu0", "cpu" + strArr[0]), str)) {
            return;
        }
        x60.f7856a.i("/sys/devices/system/cpu/cpufreq/policy" + strArr[0] + "/scaling_max_freq", str);
    }

    public void H(int i, String str) {
        if (i >= f().size()) {
            return;
        }
        if (!e50.f677a.y0().equals("root")) {
            if (B()) {
                ul0.n(i, Integer.parseInt(str));
                return;
            } else {
                if (A()) {
                    vm0.f(i, Integer.parseInt(str));
                    return;
                }
                return;
            }
        }
        if (B() && a()) {
            x60.f7856a.j("/proc/ppm/policy/hard_userlimit_min_cpu_freq", i + " " + str);
            return;
        }
        String[] strArr = f().get(i);
        if (str == null || strArr.length <= 0) {
            return;
        }
        if (A()) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(":");
                sb.append(str);
                sb.append(" ");
            }
            String strTrim = sb.toString().trim();
            if (!x60.f7856a.i("/sys/module/msm_performance/parameters/cpu_min_freq", strTrim)) {
                x60.f7856a.i("/sys/kernel/msm_performance/parameters/cpu_min_freq", strTrim);
            }
        } else if (B()) {
            D(i);
        }
        if (x60.f7856a.i("/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq".replace("cpu0", "cpu" + strArr[0]), str)) {
            return;
        }
        x60.f7856a.i("/sys/devices/system/cpu/cpufreq/policy" + strArr[0] + "/scaling_min_freq", str);
    }

    public boolean a() {
        if (this.f1651a < 0) {
            if (y60.f7952a.g("/proc/ppm")) {
                this.f1651a = 1;
            } else {
                this.f1651a = 0;
            }
        }
        return this.f1651a > 0;
    }

    public void b(String[] strArr) {
        for (String str : strArr) {
            if (str.equals("touch_boost")) {
                e50.f677a.Z("stop " + str);
            } else {
                x60.f7856a.i(str, "0");
            }
        }
        if (B()) {
            e50.f677a.O0(new String[]{"@mtk_reset"});
        } else if (A()) {
            e50.f677a.O0(new String[]{"@msm_reset"});
        }
    }

    public void c() {
        for (String[] strArr : f()) {
            String str = "/sys/devices/system/cpu/" + ("cpu" + strArr[0]) + "/core_ctl/";
            x60.f7856a.j(str + "enable", "1");
            x60.f7856a.i(str + "max_cpus", "" + strArr.length);
            x60.f7856a.i(str + "min_cpus", "" + strArr.length);
            x60.f7856a.i(str + "enable", "0");
        }
        if (y60.f7952a.c("/sys/module/migt/parameters")) {
            x60.f7856a.i("/sys/module/migt/parameters/choose_cpu_enable", "0");
            x60.f7856a.i("/sys/module/migt/parameters/choose_cpu_exclusive_enable", "0");
        }
    }

    public String[] d(int i) {
        if (i >= f().size()) {
            return new String[0];
        }
        String str = "cpu" + f().get(i)[0];
        String strReplace = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_frequencies".replace("cpu0", str);
        if (new File(strReplace).exists()) {
            String[] strArrSplit = x60.f7856a.d(strReplace).split("[ ]+");
            String strReplace2 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_boost_frequencies".replace("cpu0", str);
            if (!new File(strReplace2).exists()) {
                return strArrSplit;
            }
            String strTrim = x60.f7856a.d(strReplace2).trim();
            if (strTrim.isEmpty()) {
                return strArrSplit;
            }
            String[] strArrSplit2 = strTrim.split("[ ]+");
            String[] strArr = new String[strArrSplit.length + strArrSplit2.length];
            System.arraycopy(strArrSplit, 0, strArr, 0, strArrSplit.length);
            System.arraycopy(strArrSplit2, 0, strArr, strArrSplit.length, strArrSplit2.length);
            return strArr;
        }
        if (!new File("/sys/devices/system/cpu/cpufreq/mp-cpufreq/cluster" + i + "_freq_table").exists()) {
            return new String[0];
        }
        return x60.f7856a.d("/sys/devices/system/cpu/cpufreq/mp-cpufreq/cluster" + i + "_freq_table").split("[ ]+");
    }

    public String[] e() {
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_governors").split("[ ]+");
    }

    public ArrayList<String[]> f() {
        synchronized (f6617a) {
            if (f6617a.isEmpty()) {
                int i = 0;
                while (true) {
                    String strReplace = "/sys/devices/system/cpu/cpu0/cpufreq/related_cpus".replace("0", "" + i);
                    if (!new File(strReplace).exists()) {
                        break;
                    }
                    String strTrim = x60.f7856a.d(strReplace).trim();
                    if (strTrim.isEmpty()) {
                        return g();
                    }
                    String[] strArrSplit = strTrim.split(" +");
                    int i2 = Integer.parseInt(strArrSplit[strArrSplit.length - 1]) + 1;
                    f6617a.add(strArrSplit);
                    i = i2;
                }
            }
            return f6617a;
        }
    }

    public final ArrayList<String[]> g() {
        Iterator<n50> it = y60.f7952a.h("/sys/devices/system/cpu").iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().d().matches("cpu\\d")) {
                i2++;
            }
        }
        f6617a.clear();
        Iterator<n50> it2 = y60.f7952a.h("/sys/devices/system/cpu/cpufreq").iterator();
        while (it2.hasNext()) {
            String strD = it2.next().d();
            if (strD.startsWith("policy")) {
                int i3 = Integer.parseInt(strD.substring(6));
                if (i3 != 0) {
                    String str = "";
                    while (i < i3) {
                        str = str + i;
                        i++;
                    }
                    f6617a.add(str.split(""));
                }
                i = i3;
            }
        }
        if (i2 != 0) {
            String str2 = "";
            while (i < i2) {
                str2 = str2 + i;
                i++;
            }
            f6617a.add(str2.split(""));
        }
        return f6617a;
    }

    public int h() {
        if (b < 1) {
            int length = 0;
            Iterator<String[]> it = f().iterator();
            while (it.hasNext()) {
                length += it.next().length;
            }
            b = length;
        }
        return b;
    }

    public boolean i(int i) {
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/online".replace("cpu0", "cpu" + i)).equals("1");
    }

    public boolean[] j() {
        int iH = h();
        String[] strArr = new String[iH];
        boolean[] zArr = new boolean[iH];
        String strD = x60.f7856a.d("/sys/devices/system/cpu/online");
        if (!strD.isEmpty() && !strD.equals("error")) {
            String[] strArrSplit = strD.split(",");
            for (String str : strArrSplit) {
                if (str.contains("-")) {
                    String[] strArrSplit2 = str.split("-");
                    int i = Integer.parseInt(strArrSplit2[1]);
                    for (int i2 = Integer.parseInt(strArrSplit2[0]); i2 <= i; i2++) {
                        zArr[i2] = true;
                    }
                } else {
                    zArr[Integer.parseInt(str)] = true;
                }
            }
            return zArr;
        }
        for (int i3 = 0; i3 < iH; i3++) {
            strArr[i3] = "/sys/devices/system/cpu/cpu" + i3 + "/online";
        }
        int i4 = 0;
        for (String str2 : x60.f7856a.g(strArr)) {
            zArr[i4] = str2.startsWith("1");
            i4++;
        }
        return zArr;
    }

    public final String k(String str) {
        long kernelPropLong = this.f1652a.getKernelPropLong(str);
        if (kernelPropLong <= -1) {
            return "";
        }
        return "" + kernelPropLong;
    }

    public int l(int i) {
        try {
            return Integer.parseInt(x60.f7856a.d("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq"));
        } catch (Exception unused) {
            return -1;
        }
    }

    public int m(int i) {
        try {
            return Integer.parseInt(x60.f7856a.d("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq"));
        } catch (Exception unused) {
            return -1;
        }
    }

    public jl0[] n() {
        ArrayList<String[]> arrayListF = f();
        String[] strArr = new String[arrayListF.size() * 3];
        Iterator<String[]> it = arrayListF.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            String str = "cpu" + it.next()[0];
            strArr[i2] = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq".replace("cpu0", str);
            strArr[i2 + 1] = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq".replace("cpu0", str);
            strArr[i2 + 2] = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq".replace("cpu0", str);
            i2 += 3;
        }
        String[] strArrG = e50.f677a.y0().equals("basic") ? new String[0] : x60.f7856a.g(strArr);
        int size = arrayListF.size();
        jl0[] jl0VarArr = new jl0[size];
        if (strArrG.length < size) {
            while (i < size) {
                jl0 jl0Var = new jl0();
                jl0Var.c = k(strArr[i * 3]);
                jl0VarArr[i] = jl0Var;
                i++;
            }
        } else {
            while (i < strArrG.length) {
                jl0 jl0Var2 = new jl0();
                jl0Var2.c = strArrG[i];
                jl0Var2.b = strArrG[i + 1];
                jl0Var2.f6522a = strArrG[i + 2];
                jl0VarArr[i / 3] = jl0Var2;
                i += 3;
            }
        }
        return jl0VarArr;
    }

    public String o(int i) {
        if (i >= f().size()) {
            return "";
        }
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq".replace("cpu0", "cpu" + f().get(i)[0]));
    }

    public String p(int i) {
        if (i >= f().size()) {
            return "";
        }
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq".replace("cpu0", "cpu" + f().get(i)[0]));
    }

    public HashMap<String, String> q(int i) {
        return y60.f7952a.k(u(i));
    }

    public HashMap<String, String> r(int i) {
        String str = "cpu" + i;
        String strT = t(str);
        return y60.f7952a.k("/sys/devices/system/cpu/cpu0/".replace("cpu0", str) + "cpufreq/" + strT);
    }

    public String s(int i) {
        if (i >= f().size()) {
            return "";
        }
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor".replace("cpu0", "cpu" + f().get(i)[0]));
    }

    public final String t(String str) {
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor".replace("cpu0", str));
    }

    public String u(int i) {
        if (i >= f().size()) {
            return null;
        }
        String str = "cpu" + f().get(i)[0];
        return "/sys/devices/system/cpu/cpu0/".replace("cpu0", str) + "cpufreq/" + t(str);
    }

    public String v(String str) {
        Iterator<String[]> it = f().iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = str2 + it.next().length + str;
        }
        return (str2.isEmpty() || str.isEmpty()) ? str2 : str2.substring(0, str2.length() - str.length());
    }

    public String[] w() {
        String[] strArr = {"/sys/module/cpufreq_bouncing/parameters/enable", "/sys/module/migt/parameters/glk_freq_limit_walt", "/sys/devices/platform/soc/soc:oplus-omrg/oplus-omrg0/ruler_enable"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            String lowerCase = x60.f7856a.d(str).toLowerCase(Locale.ENGLISH);
            if (lowerCase.equals("1") || lowerCase.equals("y") || lowerCase.equals("enabled")) {
                arrayList.add(str);
            }
        }
        if (new nb2("[0-9]+").f(e50.f677a.i1("pidof", "touch_boost", null))) {
            arrayList.add("touch_boost");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String x(int i) {
        ArrayList<String[]> arrayListF = f();
        if (i >= arrayListF.size()) {
            return "";
        }
        return x60.f7856a.d("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state".replace("cpu0", "cpu" + arrayListF.get(i)[0]));
    }

    public HashMap<Integer, Long> y(int i) {
        int iIndexOf;
        HashMap<Integer, Long> map = new HashMap<>(30);
        String strX = x(i);
        if (strX.isEmpty()) {
            return map;
        }
        for (String str : strX.split("\n")) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty() && (iIndexOf = strTrim.indexOf(32)) != -1) {
                try {
                    map.put(Integer.valueOf(Integer.parseInt(strTrim.substring(0, iIndexOf))), Long.valueOf(Long.parseLong(strTrim.substring(iIndexOf + 1)) * 10));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return map;
    }

    public boolean z() {
        if (l(0) >= 2700000) {
            return true;
        }
        String strC = C();
        return strC.startsWith("a7") || strC.startsWith("x");
    }
}
