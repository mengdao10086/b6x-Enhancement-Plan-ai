package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ml0 {
    public String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6819a = "/sys/class/devfreq/mtk-dvfsrc-devfreq/cur_freq";
    public final String c = x60.f7856a.b() + "/clk/measure_only_mccc_clk/clk_measure";
    public final String d = "/sys/devices/system/cpu/bus_dcvs/DDR/cur_freq";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1944a = jm0.f6525a.e();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f1945b = f92.a(e50.f677a.y0(), "root");
    public final String e = "/sys/class/devfreq/mtk-dvfsrc-devfreq/available_frequencies";

    public final int a() {
        if (this.f1945b) {
            return this.f1944a ? b() : e();
        }
        return -1;
    }

    public final int b() {
        if (this.b == null) {
            this.b = "";
            d42<String, String> d42VarA = x60.f7856a.a(new String[]{"/sys/kernel/helio-dvfsrc/dvfsrc_dump", "/sys/devices/platform/10012000.dvfsrc/helio-dvfsrc/dvfsrc_dump", "/sys/devices/platform/1c00f000.dvfsrc/1c00f000.dvfsrc:dvfsrc-helper/dvfsrc_dump", "/sys/devices/platform/soc/1c00f000.dvfsrc/helio-dvfsrc/dvfsrc_dump", this.f6819a});
            if (d42VarA != null) {
                this.b = d42VarA.c();
            }
        }
        if (f92.a(this.b, "")) {
            return -1;
        }
        if (f92.a(this.b, this.f6819a)) {
            return c();
        }
        x60 x60Var = x60.f7856a;
        String str = this.b;
        f92.b(str);
        String strD = x60Var.d(str);
        if (ec2.C(strD, "DDR", false, 2, null)) {
            List listD0 = ec2.d0(strD, new String[]{"\n"}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD0) {
                String str2 = (String) obj;
                if (bc2.x(str2, "DDR", false, 2, null) && ec2.C(str2, ":", false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            String str3 = (String) i52.C(arrayList);
            if (str3 != null) {
                String str4 = (String) i52.J(ec2.d0(str3, new String[]{":"}, false, 0, 6, null));
                Locale locale = Locale.ENGLISH;
                f92.c(locale, "Locale.ENGLISH");
                if (str4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str4.toLowerCase(locale);
                f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                try {
                    if (ec2.C(lowerCase, "khz", false, 2, null)) {
                        String strT = bc2.t(lowerCase, "khz", "", false, 4, null);
                        if (strT != null) {
                            return Integer.parseInt(ec2.r0(strT).toString()) / 1000;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String strT2 = bc2.t(lowerCase, "mbps", "", false, 4, null);
                    if (strT2 != null) {
                        return Integer.parseInt(ec2.r0(strT2).toString());
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                } catch (Exception unused) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public final int c() {
        try {
            long j = 1000;
            return (int) (((Long.parseLong(x60.f7856a.d(this.f6819a)) / j) / j) / ((long) 2));
        } catch (Exception unused) {
            return -1;
        }
    }

    public final List<Integer> d() {
        boolean z = true;
        d42<String, String> d42VarA = x60.f7856a.a(new String[]{this.e, "/sys/devices/system/cpu/bus_dcvs/DDR/available_frequencies"});
        String strD = d42VarA != null ? d42VarA.d() : null;
        if (strD != null && strD.length() != 0) {
            z = false;
        }
        if (z) {
            return new ArrayList();
        }
        f92.b(d42VarA);
        List<String> listH = new nb2("\\s").h(d42VarA.d(), 0);
        ArrayList arrayList = new ArrayList(z42.m(listH, 10));
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
        }
        if (f92.a(d42VarA.c(), this.e)) {
            ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf((int) (((Number) it2.next()).longValue() / ((long) 1000))));
            }
            return i52.a0(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(z42.m(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Integer.valueOf((int) ((Number) it3.next()).longValue()));
        }
        return i52.a0(arrayList3);
    }

    public final int e() {
        String str = this.b;
        if (str == null) {
            d42<String, String> d42VarA = x60.f7856a.a(new String[]{this.c, this.d});
            if (d42VarA != null) {
                this.b = d42VarA.c();
            } else {
                this.b = "";
            }
        } else if (f92.a(str, "")) {
            return -1;
        }
        x60 x60Var = x60.f7856a;
        String str2 = this.b;
        f92.b(str2);
        String strD = x60Var.d(str2);
        try {
            return f92.a(this.b, this.c) ? (int) (Long.parseLong(strD) / ((long) 500000)) : Integer.parseInt(strD) / 500;
        } catch (Exception unused) {
            return -1;
        }
    }
}
