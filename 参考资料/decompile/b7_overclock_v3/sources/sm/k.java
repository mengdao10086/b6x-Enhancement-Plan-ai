package sm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f50000a;

    public k(String str) {
        this.f50000a = a(str);
    }

    public k(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f50000a = a(simpleDateFormat.format(date));
    }

    public k(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f50000a = a(simpleDateFormat.format(date));
    }

    public k(byte[] bArr) {
        this.f50000a = bArr;
    }

    public final byte[] a(String str) {
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[6];
        for (int i10 = 0; i10 != 6; i10++) {
            bArr[i10] = (byte) (charArray[i10] - '0');
        }
        return bArr;
    }

    public Date b() throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse("20" + toString());
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f50000a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return org.bouncycastle.util.a.g(this.f50000a, ((k) obj).f50000a);
        }
        return false;
    }

    public int hashCode() {
        return org.bouncycastle.util.a.s0(this.f50000a);
    }

    public String toString() {
        int length = this.f50000a.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) ((this.f50000a[i10] & 255) + 48);
        }
        return new String(cArr);
    }
}
