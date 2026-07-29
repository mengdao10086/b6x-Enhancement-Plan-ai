package gm;

import com.google.android.material.timepicker.ChipTextInputComboView;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class o extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29756b = new a(o.class, 24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29757a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return o.J(f2Var.J());
        }
    }

    public o(String str) {
        this.f29757a = Strings.i(str);
        try {
            K();
        } catch (ParseException e10) {
            throw new IllegalArgumentException("invalid date string: " + e10.getMessage());
        }
    }

    public o(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", f3.f29690c);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f29757a = Strings.i(simpleDateFormat.format(date));
    }

    public o(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f29757a = Strings.i(simpleDateFormat.format(date));
    }

    public o(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("GeneralizedTime string too short");
        }
        this.f29757a = bArr;
        if (!S(0) || !S(1) || !S(2) || !S(3)) {
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
    }

    public static o J(byte[] bArr) {
        return new o(bArr);
    }

    public static o L(n0 n0Var, boolean z10) {
        return (o) f29756b.f(n0Var, z10);
    }

    public static o M(Object obj) {
        if (obj == null || (obj instanceof o)) {
            return (o) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof o) {
                return (o) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (o) f29756b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29757a.length);
    }

    @Override // gm.c0
    public c0 E() {
        return new z1(this.f29757a);
    }

    @Override // gm.c0
    public c0 F() {
        return new z1(this.f29757a);
    }

    public final SimpleDateFormat G() {
        SimpleDateFormat simpleDateFormat = P() ? new SimpleDateFormat("yyyyMMddHHmmss.SSSz") : R() ? new SimpleDateFormat("yyyyMMddHHmmssz") : Q() ? new SimpleDateFormat("yyyyMMddHHmmz") : new SimpleDateFormat("yyyyMMddHHz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat;
    }

    public final String H(String str) {
        String str2;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str2 = "-";
        } else {
            str2 = com.google.android.material.badge.a.f19590u;
        }
        int i10 = rawOffset / w3.e.f53894d;
        int i11 = (rawOffset - (((i10 * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime()) {
                if (P()) {
                    str = T(str);
                }
                if (timeZone.inDaylightTime(G().parse(str + "GMT" + str2 + I(i10) + ":" + I(i11)))) {
                    i10 += str2.equals(com.google.android.material.badge.a.f19590u) ? 1 : -1;
                }
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str2 + I(i10) + ":" + I(i11);
    }

    public final String I(int i10) {
        if (i10 >= 10) {
            return Integer.toString(i10);
        }
        return "0" + i10;
    }

    public Date K() throws ParseException {
        SimpleDateFormat simpleDateFormatG;
        String strC = Strings.c(this.f29757a);
        if (strC.endsWith("Z")) {
            simpleDateFormatG = P() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'") : R() ? new SimpleDateFormat("yyyyMMddHHmmss'Z'") : Q() ? new SimpleDateFormat("yyyyMMddHHmm'Z'") : new SimpleDateFormat("yyyyMMddHH'Z'");
            simpleDateFormatG.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (strC.indexOf(45) > 0 || strC.indexOf(43) > 0) {
            strC = N();
            simpleDateFormatG = G();
        } else {
            simpleDateFormatG = P() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS") : R() ? new SimpleDateFormat("yyyyMMddHHmmss") : Q() ? new SimpleDateFormat("yyyyMMddHHmm") : new SimpleDateFormat("yyyyMMddHH");
            simpleDateFormatG.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (P()) {
            strC = T(strC);
        }
        return f3.a(simpleDateFormatG.parse(strC));
    }

    public String N() {
        String strC = Strings.c(this.f29757a);
        if (strC.charAt(strC.length() - 1) == 'Z') {
            return strC.substring(0, strC.length() - 1) + "GMT+00:00";
        }
        int length = strC.length() - 6;
        char cCharAt = strC.charAt(length);
        if ((cCharAt == '-' || cCharAt == '+') && strC.indexOf("GMT") == length - 3) {
            return strC;
        }
        int length2 = strC.length() - 5;
        char cCharAt2 = strC.charAt(length2);
        if (cCharAt2 == '-' || cCharAt2 == '+') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strC.substring(0, length2));
            sb2.append("GMT");
            int i10 = length2 + 3;
            sb2.append(strC.substring(length2, i10));
            sb2.append(":");
            sb2.append(strC.substring(i10));
            return sb2.toString();
        }
        int length3 = strC.length() - 3;
        char cCharAt3 = strC.charAt(length3);
        if (cCharAt3 != '-' && cCharAt3 != '+') {
            return strC + H(strC);
        }
        return strC.substring(0, length3) + "GMT" + strC.substring(length3) + ":00";
    }

    public String O() {
        return Strings.c(this.f29757a);
    }

    public boolean P() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f29757a;
            if (i10 == bArr.length) {
                return false;
            }
            if (bArr[i10] == 46 && i10 == 14) {
                return true;
            }
            i10++;
        }
    }

    public boolean Q() {
        return S(10) && S(11);
    }

    public boolean R() {
        return S(12) && S(13);
    }

    public final boolean S(int i10) {
        byte[] bArr = this.f29757a;
        return bArr.length > i10 && bArr[i10] >= 48 && bArr[i10] <= 57;
    }

    public final String T(String str) {
        String str2;
        StringBuilder sb2;
        char cCharAt;
        String strSubstring = str.substring(14);
        int i10 = 1;
        while (i10 < strSubstring.length() && '0' <= (cCharAt = strSubstring.charAt(i10)) && cCharAt <= '9') {
            i10++;
        }
        int i11 = i10 - 1;
        if (i11 > 3) {
            str2 = strSubstring.substring(0, 4) + strSubstring.substring(i10);
            sb2 = new StringBuilder();
        } else if (i11 == 1) {
            str2 = strSubstring.substring(0, i10) + ChipTextInputComboView.b.f21060b + strSubstring.substring(i10);
            sb2 = new StringBuilder();
        } else {
            if (i11 != 2) {
                return str;
            }
            str2 = strSubstring.substring(0, i10) + "0" + strSubstring.substring(i10);
            sb2 = new StringBuilder();
        }
        sb2.append(str.substring(0, 14));
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29757a);
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof o) {
            return org.bouncycastle.util.a.g(this.f29757a, ((o) c0Var).f29757a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 24, this.f29757a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
