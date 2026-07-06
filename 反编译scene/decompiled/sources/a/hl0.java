package a;

import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dl0 f6321a = new dl0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f1177a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1178a;
    public static Boolean c;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Boolean f1181b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f1179a = a42.a(fl0.f6117a);
    public final z32 b = a42.a(el0.f6018a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f1180a = Boolean.FALSE;

    public static /* synthetic */ void A(hl0 hl0Var, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        hl0Var.z(i, z);
    }

    public final boolean B(boolean z) {
        return x60.f7856a.j("/sys/class/power_supply/usb/pd_allowed", z ? "1" : "0") && x60.f7856a.j("/sys/class/power_supply/usb/pd_active", "1");
    }

    public final void C(boolean z) {
        x60.f7856a.j("/sys/class/power_supply/battery/step_charging_enabled", z ? "1" : "0");
    }

    public final boolean D() {
        return y60.f7952a.g("/sys/class/power_supply/battery/step_charging_enabled");
    }

    public final String E(String str) {
        int i;
        int length = str.length() <= 4 ? str.length() : 4;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(0, length);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble(strSubstring);
        StringBuilder sb = new StringBuilder();
        if (d > 3000) {
            i = 1000;
        } else {
            if (d <= 300) {
                if (d > 30) {
                    i = 10;
                }
                sb.append(String.valueOf(d));
                sb.append("v");
                return sb.toString();
            }
            i = 100;
        }
        d /= (double) i;
        sb.append(String.valueOf(d));
        sb.append("v");
        return sb.toString();
    }

    public final boolean f() {
        return x60.f7856a.a(new String[]{"/sys/class/power_supply/battery/battery_charging_enabled", "/sys/class/power_supply/battery/input_suspend", "/sys/class/qcom-battery/input_suspend", "/sys/class/power_supply/battery/night_charging", "/sys/class/cms_class/disable_charge"}) != null || g();
    }

    public final boolean g() {
        return x60.f7856a.a(new String[]{"/sys/class/power_supply/battery/night_charging", "/sys/class/qcom-battery/night_charging", "/sys/devices/platform/11e01000.i2c/i2c-5/5-0034/11e01000.i2c:mt6375@34:mtk_gauge/power_supply/battery/night_charging", "/proc/oplus-votable/CHG_DISABLE/force_active", "/sys/class/power_supply/battery/charging_enabled", "/sys/class/power_supply/battery/battery_charging_enabled", "/sys/class/power_supply/battery/mmi_charging_enable", "/sys/class/power_supply/battery/charge_control_limit", "/sys/class/meizu/charger/wired_level", "/sys/class/meizu/charger/wired/wired_level", "/sys/class/cms_class/disable_charge"}) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:281:0x04e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h() {
        /*
            Method dump skipped, instruction units count: 1301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.hl0.h():java.lang.String");
    }

    public final int i() {
        String strD = x60.f7856a.d("/sys/class/power_supply/battery/capacity");
        if (new nb2("^[0-9]+").f(strD)) {
            return Integer.parseInt(strD);
        }
        return 0;
    }

    public final int j() {
        String strD = x60.f7856a.d("/sys/class/power_supply/bms/charge_full");
        if (new nb2("^[0-9]+").f(strD)) {
            return Integer.parseInt(strD) / 1000;
        }
        return 0;
    }

    public final int k() {
        d42<String, String> d42VarA = x60.f7856a.a(new String[]{"/sys/class/oplus_chg/battery/battery_cc", "/sys/class/power_supply/battery/cycle_count", "/sys/class/qcom-battery/fg1_cycle", "/sys/class/qcom-battery/fake_cycle", "/sys/class/power_supply/mtk-battery/cycle_count"});
        String strD = d42VarA != null ? d42VarA.d() : null;
        if (strD != null) {
            return Integer.parseInt(strD);
        }
        return -1;
    }

    public final float l(int i) {
        if (this.f1181b == null) {
            this.f1181b = Boolean.valueOf(y60.f7952a.d("/sys/class/power_supply/bms/capacity_raw"));
        }
        if (f92.a(this.f1181b, Boolean.TRUE)) {
            try {
                String strD = x60.f7856a.d("/sys/class/power_supply/bms/capacity_raw");
                int i2 = Integer.parseInt(strD);
                float fAbs = Math.abs(i2 - i);
                float f = i2 / 100.0f;
                float f2 = i;
                if (fAbs <= Math.abs(f - f2)) {
                    f = Float.parseFloat(strD);
                }
                if (Math.abs(f - f2) <= 7) {
                    return f;
                }
                this.f1181b = Boolean.FALSE;
                return -1.0f;
            } catch (Exception unused) {
                this.f1181b = Boolean.FALSE;
            }
        }
        return -1.0f;
    }

    public final boolean m() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final String n() {
        String strD;
        if (this.f1180a == null) {
            this.f1180a = Boolean.valueOf(y60.f7952a.d("/sys/class/power_supply/main/constant_charge_current_max"));
        }
        if (f92.a(this.f1180a, Boolean.TRUE)) {
            strD = x60.f7856a.d("/sys/class/power_supply/main/constant_charge_current_max");
        } else {
            d42<String, String> d42VarA = x60.f7856a.a(new String[]{"/sys/class/xm_power/charger/charger_thermal/wired_chg_curr", "/sys/class/power_supply/battery/constant_charge_current_max", "/sys/class/power_supply/battery/constant_charge_current"});
            if (d42VarA == null || (strD = d42VarA.d()) == null) {
                strD = "";
            }
        }
        if (strD.length() <= 3) {
            if (!(strD.length() > 0)) {
                return "?mA";
            }
            try {
                return Integer.parseInt(strD) == 0 ? "0" : strD;
            } catch (Exception unused) {
                return strD;
            }
        }
        StringBuilder sb = new StringBuilder();
        int length = strD.length() - 3;
        if (strD == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strD.substring(0, length);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append("mA");
        return sb.toString();
    }

    public final boolean o() {
        return ((Boolean) this.f1179a.getValue()).booleanValue();
    }

    public final boolean p() {
        String str;
        String[] strArrG = x60.f7856a.g(new String[]{"/sys/class/oplus_chg/usb/fast_chg_type", "/sys/class/power_supply/usb/online", "/sys/class/power_supply/usb/voltage_max"});
        String str2 = strArrG[0];
        Integer numJ = str2 != null ? ac2.j(str2) : null;
        return numJ != null ? numJ.intValue() == 0 && f92.a(strArrG[1], "1") : f92.a(strArrG[1], "1") && (str = strArrG[2]) != null && bc2.x(str, "5", false, 2, null);
    }

    public final boolean q() {
        return f92.a(x60.f7856a.d("/sys/class/power_supply/battery/step_charging_enabled"), "1");
    }

    public final String r() {
        List listE;
        String[] strArr;
        Object obj;
        int i;
        int i2;
        String strSubstring;
        String strD = x60.f7856a.d("/sys/class/power_supply/usb/uevent");
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        String language = locale.getLanguage();
        f92.c(language, "Locale.getDefault().language");
        boolean z = false;
        int i3 = 2;
        Object obj2 = null;
        if (!ec2.C(language, "zh", false, 2, null)) {
            return new nb2("POWER_SUPPLY_").g(strD, "");
        }
        List<String> listH = new nb2("\n").h(strD, 0);
        if (listH.isEmpty()) {
            listE = y42.e();
        } else {
            ListIterator<String> listIterator = listH.listIterator(listH.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    listE = i52.V(listH, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listE = y42.e();
        }
        Object[] array = listE.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr2 = (String[]) array;
        StringBuilder sb = new StringBuilder();
        int length = strArr2.length;
        float f = 0.0f;
        int i4 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (i4 < length) {
            String str = strArr2[i4];
            try {
                if (bc2.x(str, "POWER_SUPPLY_VOLTAGE_NOW=", z, i3, obj2)) {
                    try {
                        sb.append("当前电压 = ");
                        int length2 = str.length();
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String strSubstring2 = str.substring(25, length2);
                        f92.c(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String strE = E(strSubstring2);
                        f = Float.parseFloat(bc2.t(strE, "v", "", false, 4, null));
                        sb.append(strE);
                        strArr = strArr2;
                        i = length;
                        obj = null;
                        i2 = 2;
                        try {
                            sb.append("\n");
                        } catch (Exception unused) {
                            sb.append("\n");
                        }
                    } catch (Exception unused2) {
                        strArr = strArr2;
                        i = length;
                        obj = null;
                        i2 = 2;
                        sb.append("\n");
                    }
                } else {
                    strArr = strArr2;
                    i = length;
                    obj = null;
                    try {
                        if (bc2.x(str, "POWER_SUPPLY_CURRENT_MAX=", false, 2, null)) {
                            try {
                                int length3 = str.length();
                                if (str == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                f92.c(str.substring(25, length3), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                float f3 = (Integer.parseInt(r4) / 1000) / 1000.0f;
                                if (f3 > 0) {
                                    sb.append("最大电流 = ");
                                    sb.append(f3);
                                    sb.append("A");
                                    obj = null;
                                    i2 = 2;
                                }
                                obj = null;
                                i2 = 2;
                            } catch (Exception unused3) {
                                obj = null;
                                i2 = 2;
                                sb.append("\n");
                            }
                        } else {
                            int i5 = 2;
                            try {
                                if (bc2.x(str, "POWER_SUPPLY_TYPE=", false, 2, null)) {
                                    sb.append("充电协议 = ");
                                    int length4 = str.length();
                                    if (str == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    strSubstring = str.substring(18, length4);
                                    f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                } else if (bc2.x(str, "POWER_SUPPLY_PD_VOLTAGE_MAX=", false, 2, null)) {
                                    sb.append("最大电压(PD) = ");
                                    int length5 = str.length();
                                    if (str == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    String strSubstring3 = str.substring(28, length5);
                                    f92.c(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    strSubstring = E(strSubstring3);
                                } else if (bc2.x(str, "POWER_SUPPLY_CONNECTOR_TEMP=", false, 2, null)) {
                                    sb.append("接口温度 = ");
                                    int length6 = str.length();
                                    if (str == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    f92.c(str.substring(28, length6), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    sb.append(Integer.parseInt(r1) / 10.0f);
                                    strSubstring = "℃";
                                } else if (bc2.x(str, "POWER_SUPPLY_PD_VOLTAGE_MIN=", false, 2, null)) {
                                    sb.append("最小电压(PD) = ");
                                    int length7 = str.length();
                                    if (str == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    String strSubstring4 = str.substring(28, length7);
                                    f92.c(strSubstring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    strSubstring = E(strSubstring4);
                                } else if (bc2.x(str, "POWER_SUPPLY_CURRENT_NOW=", false, 2, null)) {
                                    sb.append("当前电流 = ");
                                    int length8 = str.length();
                                    if (str == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    strSubstring = str.substring(25, length8);
                                    f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                } else {
                                    if (bc2.x(str, "POWER_SUPPLY_PD_CURRENT_MAX=", false, 2, null)) {
                                        int length9 = str.length();
                                        if (str == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        f92.c(str.substring(28, length9), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        float f4 = (Integer.parseInt(r1) / 1000) / 1000.0f;
                                        if (f4 > 0) {
                                            sb.append("最大电流(PD) = ");
                                            sb.append(f4);
                                            sb.append("A");
                                            obj = null;
                                            i2 = 2;
                                        }
                                    } else if (bc2.x(str, "POWER_SUPPLY_INPUT_CURRENT_NOW=", false, 2, null)) {
                                        int length10 = str.length();
                                        if (str == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        f92.c(str.substring(31, length10), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        f2 = (Integer.parseInt(r1) / 1000) / 1000.0f;
                                    } else {
                                        try {
                                            if (bc2.x(str, "POWER_SUPPLY_QUICK_CHARGE_TYPE=", false, 2, null)) {
                                                sb.append("快充类型 = ");
                                                int length11 = str.length();
                                                if (str == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                }
                                                strSubstring = str.substring(31, length11);
                                                f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                if (f92.a(strSubstring, "0")) {
                                                    strSubstring = "慢速充电";
                                                } else {
                                                    sb.append("类型");
                                                }
                                            } else {
                                                i5 = 2;
                                                try {
                                                    if (bc2.x(str, "POWER_SUPPLY_REAL_TYPE=", false, 2, null)) {
                                                        sb.append("输电协议 = ");
                                                        int length12 = str.length();
                                                        if (str == null) {
                                                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                        }
                                                        strSubstring = str.substring(23, length12);
                                                        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                    } else {
                                                        obj = null;
                                                        try {
                                                            if (bc2.x(str, "POWER_SUPPLY_HVDCP3_TYPE=", false, 2, null)) {
                                                                sb.append("高压快充 = ");
                                                                int length13 = str.length();
                                                                if (str == null) {
                                                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                }
                                                                strSubstring = str.substring(25, length13);
                                                                f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                                if (f92.a(strSubstring, "0")) {
                                                                    strSubstring = "否";
                                                                } else {
                                                                    sb.append("类型");
                                                                }
                                                            } else {
                                                                obj = null;
                                                                i2 = 2;
                                                                if (bc2.x(str, "POWER_SUPPLY_PD_AUTHENTICATION=", false, 2, null)) {
                                                                    sb.append("PD认证 = ");
                                                                    int length14 = str.length();
                                                                    if (str == null) {
                                                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                                                    }
                                                                    String strSubstring5 = str.substring(31, length14);
                                                                    f92.c(strSubstring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                                    boolean zA = f92.a(strSubstring5, "1");
                                                                    try {
                                                                        sb.append(zA ? "已认证" : "未认证");
                                                                        z2 = zA;
                                                                    } catch (Exception unused4) {
                                                                        z2 = zA;
                                                                        sb.append("\n");
                                                                    }
                                                                } else {
                                                                    continue;
                                                                }
                                                            }
                                                        } catch (Exception unused5) {
                                                            i2 = 2;
                                                        }
                                                    }
                                                } catch (Exception unused6) {
                                                    obj = null;
                                                    i2 = i5;
                                                    sb.append("\n");
                                                    i4++;
                                                    obj2 = obj;
                                                    i3 = i2;
                                                    strArr2 = strArr;
                                                    length = i;
                                                    z = false;
                                                }
                                            }
                                        } catch (Exception unused7) {
                                            obj = null;
                                            i2 = 2;
                                        }
                                    }
                                    obj = null;
                                    i2 = 2;
                                }
                                sb.append(strSubstring);
                                obj = null;
                                i2 = 2;
                            } catch (Exception unused8) {
                                obj = null;
                            }
                        }
                        sb.append("\n");
                    } catch (Exception unused9) {
                        i2 = 2;
                    }
                }
            } catch (Exception unused10) {
                strArr = strArr2;
                obj = obj2;
                i = length;
                i2 = i3;
            }
            i4++;
            obj2 = obj;
            i3 = i2;
            strArr2 = strArr;
            length = i;
            z = false;
        }
        if (!z2) {
            float f5 = 0;
            if (f > f5 && f2 > f5) {
                sb.append("当前电流 = ");
                sb.append(f2);
                sb.append("A");
                sb.append("\n参考功率 = ");
                sb.append(((int) ((f * f2) * 100)) / 100.0f);
                sb.append("W");
            }
        }
        String string = sb.toString();
        f92.c(string, "stringBuilder.toString()");
        return string;
    }

    public final boolean s() {
        return f92.a(e50.j1(e50.f677a, "charge-control", "pause", null, 4, null), "true");
    }

    public final boolean t() {
        return f92.a(x60.f7856a.d("/sys/class/power_supply/usb/pd_active"), "1");
    }

    public final boolean u() {
        return f92.a(x60.f7856a.d("/sys/class/power_supply/usb/pd_allowed"), "1");
    }

    public final boolean v() {
        return y60.f7952a.d("/sys/class/power_supply/usb/pd_allowed") || y60.f7952a.d("/sys/class/power_supply/usb/pd_active");
    }

    public final boolean w() {
        return f92.a(e50.j1(e50.f677a, "charge-control", "resume", null, 4, null), "true");
    }

    public final void x(int i) {
        x60.f7856a.i("/sys/class/power_supply/battery/capacity", String.valueOf(i));
        x60.f7856a.i("/sys/class/power_supply/maxfg/capacity", String.valueOf(i));
    }

    public final void y(int i) {
        x60.f7856a.j("/sys/class/power_supply/bms/charge_full", String.valueOf(i * 1000));
    }

    public final void z(int i, boolean z) {
        if (!f1178a || z) {
            f1178a = true;
            qc2.d(xd2.a(qe2.b()), null, null, new gl0(i, null), 3, null);
        }
    }
}
