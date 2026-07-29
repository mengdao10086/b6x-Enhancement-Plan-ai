package gm;

import com.google.android.material.timepicker.ChipTextInputComboView;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class q0 extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29784b = new a(q0.class, 23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29785a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return q0.G(f2Var.J());
        }
    }

    public q0(String str) {
        this.f29785a = Strings.i(str);
        try {
            J();
        } catch (ParseException e10) {
            throw new IllegalArgumentException("invalid date string: " + e10.getMessage());
        }
    }

    public q0(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", f3.f29690c);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f29785a = Strings.i(simpleDateFormat.format(date));
    }

    public q0(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f29785a = Strings.i(simpleDateFormat.format(date));
    }

    public q0(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.f29785a = bArr;
        if (!N(0) || !N(1)) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    public static q0 G(byte[] bArr) {
        return new q0(bArr);
    }

    public static q0 K(n0 n0Var, boolean z10) {
        return (q0) f29784b.f(n0Var, z10);
    }

    public static q0 L(Object obj) {
        if (obj == null || (obj instanceof q0)) {
            return (q0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof q0) {
                return (q0) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (q0) f29784b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29785a.length);
    }

    public Date H() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return f3.a(simpleDateFormat.parse(I()));
    }

    public String I() {
        StringBuilder sb2;
        String str;
        String strM = M();
        if (strM.charAt(0) < '5') {
            sb2 = new StringBuilder();
            str = "20";
        } else {
            sb2 = new StringBuilder();
            str = Constants.VIA_ACT_TYPE_NINETEEN;
        }
        sb2.append(str);
        sb2.append(strM);
        return sb2.toString();
    }

    public Date J() throws ParseException {
        return f3.a(new SimpleDateFormat("yyMMddHHmmssz").parse(M()));
    }

    public String M() {
        StringBuilder sb2;
        String strSubstring;
        String strC = Strings.c(this.f29785a);
        if (strC.indexOf(45) >= 0 || strC.indexOf(43) >= 0) {
            int iIndexOf = strC.indexOf(45);
            if (iIndexOf < 0) {
                iIndexOf = strC.indexOf(43);
            }
            if (iIndexOf == strC.length() - 3) {
                strC = strC + ChipTextInputComboView.b.f21060b;
            }
            if (iIndexOf == 10) {
                sb2 = new StringBuilder();
                sb2.append(strC.substring(0, 10));
                sb2.append("00GMT");
                sb2.append(strC.substring(10, 13));
                sb2.append(":");
                strSubstring = strC.substring(13, 15);
            } else {
                sb2 = new StringBuilder();
                sb2.append(strC.substring(0, 12));
                sb2.append("GMT");
                sb2.append(strC.substring(12, 15));
                sb2.append(":");
                strSubstring = strC.substring(15, 17);
            }
        } else if (strC.length() == 11) {
            sb2 = new StringBuilder();
            sb2.append(strC.substring(0, 10));
            strSubstring = "00GMT+00:00";
        } else {
            sb2 = new StringBuilder();
            sb2.append(strC.substring(0, 12));
            strSubstring = "GMT+00:00";
        }
        sb2.append(strSubstring);
        return sb2.toString();
    }

    public final boolean N(int i10) {
        byte[] bArr = this.f29785a;
        return bArr.length > i10 && bArr[i10] >= 48 && bArr[i10] <= 57;
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29785a);
    }

    public String toString() {
        return Strings.c(this.f29785a);
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof q0) {
            return org.bouncycastle.util.a.g(this.f29785a, ((q0) c0Var).f29785a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 23, this.f29785a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
