package ze;

import com.google.zxing.client.result.ParsedResultType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f58475m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long[] f58476n = {604800000, 86400000, 3600000, 60000, 1000};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f58477o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f58479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f58480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f58481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f58482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f58483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f58484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String[] f58485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f58486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final double f58487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final double f58488l;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d10, double d11) {
        super(ParsedResultType.CALENDAR);
        this.f58478b = str;
        try {
            long jS = s(str2);
            this.f58479c = jS;
            if (str3 == null) {
                long jU = u(str4);
                this.f58481e = jU < 0 ? -1L : jS + jU;
            } else {
                try {
                    this.f58481e = s(str3);
                } catch (ParseException e10) {
                    throw new IllegalArgumentException(e10.toString());
                }
            }
            this.f58480d = str2.length() == 8;
            this.f58482f = str3 != null && str3.length() == 8;
            this.f58483g = str5;
            this.f58484h = str6;
            this.f58485i = strArr;
            this.f58486j = str7;
            this.f58487k = d10;
            this.f58488l = d11;
        } catch (ParseException e11) {
            throw new IllegalArgumentException(e11.toString());
        }
    }

    public static String e(boolean z10, long j10) {
        if (j10 < 0) {
            return null;
        }
        return (z10 ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(Long.valueOf(j10));
    }

    public static long s(String str) throws ParseException {
        if (!f58477o.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        }
        if (str.length() != 16 || str.charAt(15) != 'Z') {
            return t(str);
        }
        long jT = t(str.substring(0, 15));
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long j10 = jT + ((long) gregorianCalendar.get(15));
        gregorianCalendar.setTime(new Date(j10));
        return j10 + ((long) gregorianCalendar.get(16));
    }

    public static long t(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }

    public static long u(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f58475m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j10 = 0;
        int i10 = 0;
        while (true) {
            long[] jArr = f58476n;
            if (i10 >= jArr.length) {
                return j10;
            }
            int i11 = i10 + 1;
            String strGroup = matcher.group(i11);
            if (strGroup != null) {
                j10 += jArr[i10] * ((long) Integer.parseInt(strGroup));
            }
            i10 = i11;
        }
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(100);
        q.c(this.f58478b, sb2);
        q.c(e(this.f58480d, this.f58479c), sb2);
        q.c(e(this.f58482f, this.f58481e), sb2);
        q.c(this.f58483g, sb2);
        q.c(this.f58484h, sb2);
        q.d(this.f58485i, sb2);
        q.c(this.f58486j, sb2);
        return sb2.toString();
    }

    public String[] f() {
        return this.f58485i;
    }

    public String g() {
        return this.f58486j;
    }

    @Deprecated
    public Date h() {
        if (this.f58481e < 0) {
            return null;
        }
        return new Date(this.f58481e);
    }

    public long i() {
        return this.f58481e;
    }

    public double j() {
        return this.f58487k;
    }

    public String k() {
        return this.f58483g;
    }

    public double l() {
        return this.f58488l;
    }

    public String m() {
        return this.f58484h;
    }

    @Deprecated
    public Date n() {
        return new Date(this.f58479c);
    }

    public long o() {
        return this.f58479c;
    }

    public String p() {
        return this.f58478b;
    }

    public boolean q() {
        return this.f58482f;
    }

    public boolean r() {
        return this.f58480d;
    }
}
