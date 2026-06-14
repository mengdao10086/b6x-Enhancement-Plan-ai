package a;

import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class im0 {
    public im0() {
    }

    public /* synthetic */ im0(b92 b92Var) {
        this();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.im0.a():java.lang.String");
    }

    public final String b() {
        if (jm0.f1561a == null) {
            String strA = um0.f7612a.a("ro.board.platform");
            Locale locale = Locale.ENGLISH;
            f92.c(locale, "Locale.ENGLISH");
            if (strA == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strA.toLowerCase(locale);
            f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.length() > 0) {
                String str = "mt6893";
                if (f92.a(lowerCase, "mt6893")) {
                    String strD = x60.f7856a.d("/sys/devices/system/cpu/cpu7/cpufreq/scaling_available_frequencies");
                    if (!f92.a(strD, "error") && !ec2.C(strD, "3000000", false, 2, null)) {
                        str = "mt6891";
                    }
                } else {
                    str = "mt6885";
                    if (f92.a(lowerCase, "mt6885")) {
                        String strD2 = x60.f7856a.d("/sys/devices/system/cpu/cpu4/cpufreq/scaling_available_frequencies");
                        if (f92.a(strD2, "error") || ec2.C(strD2, "2600000", false, 2, null)) {
                            str = "mt6889";
                        }
                    } else {
                        if (f92.a(lowerCase, "lito")) {
                            return a();
                        }
                        if (f92.a(lowerCase, "lahaina")) {
                            String strA2 = a();
                            return f92.a(strA2, "sm8350") ? "lahaina" : strA2;
                        }
                        if (f92.a(lowerCase, "waipio")) {
                            lowerCase = "taro";
                        }
                        jm0.f1561a = lowerCase;
                    }
                }
                jm0.f1561a = str;
            }
        }
        String str2 = jm0.f1561a;
        return str2 != null ? str2 : "";
    }

    public final String c() {
        String upperCase;
        if (jm0.c == null) {
            jm0.c = um0.f7612a.a("ro.soc.model");
            String str = jm0.c;
            if (str == null || str.length() == 0) {
                jm0.c = b();
            }
            String str2 = jm0.c;
            if (str2 != null) {
                Locale locale = Locale.getDefault();
                f92.c(locale, "Locale.getDefault()");
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                upperCase = str2.toUpperCase(locale);
                f92.c(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            } else {
                upperCase = null;
            }
            jm0.c = upperCase;
        }
        String str3 = jm0.c;
        return str3 != null ? str3 : "";
    }

    public final boolean d() {
        if (e50.f677a.y0().equals("root")) {
            return y60.f7952a.g("/sys/class/kgsl/kgsl-3d0");
        }
        String strA = um0.f7612a.a("ro.baseband");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strA.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return f92.a(lowerCase, "msm") || f92.a(lowerCase, "sdm");
    }

    public final boolean e() {
        return new nb2("mt[0-9]{2,}").f(b());
    }
}
