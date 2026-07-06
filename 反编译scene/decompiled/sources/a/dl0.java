package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dl0 {
    public dl0() {
    }

    public /* synthetic */ dl0(b92 b92Var) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(a.b62<? super com.omarea.model.BatteryStatus> r18) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.dl0.a(a.b62):java.lang.Object");
    }

    public final double b() {
        Boolean bool;
        if (!(!f92.a(e50.f677a.y0(), "basic"))) {
            return -1.0d;
        }
        if (hl0.c == null) {
            d42<String, String> d42VarA = x60.f7856a.a(new String[]{"/sys/class/power_supply/battery/voltage_now", "/sys/devices/platform/soc/soc:oplus,mms_gauge/oplus_mms/gauge/battery/voltage_now"});
            String strD = d42VarA != null ? d42VarA.d() : null;
            if ((strD == null || strD.length() == 0) || !new nb2("[0-9]{2,}").f(strD)) {
                bool = Boolean.FALSE;
            } else {
                hl0.f1177a = d42VarA.c();
                bool = Boolean.TRUE;
            }
            hl0.c = bool;
        }
        if (!f92.a(hl0.c, Boolean.TRUE)) {
            return -1.0d;
        }
        String strD2 = x60.f7856a.d(hl0.f1177a);
        try {
            if (strD2.length() > 4) {
                if (strD2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                strD2 = strD2.substring(0, 4);
                f92.c(strD2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            if (strD2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strD2.substring(0, 1);
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            sb.append(".");
            if (strD2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring2 = strD2.substring(1);
            f92.c(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(strSubstring2);
            return Double.parseDouble(sb.toString());
        } catch (Exception unused) {
            return -1.0d;
        }
    }
}
