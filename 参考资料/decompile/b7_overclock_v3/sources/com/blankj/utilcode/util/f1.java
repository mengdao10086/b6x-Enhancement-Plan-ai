package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Map<String, SimpleDateFormat>> f11761a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11762b = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f11763c = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f11764d = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};

    public static class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap();
        }
    }

    public f1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(Date date, int i10) {
        return w(date, K(), i10);
    }

    public static boolean A0(long j10) {
        return D0(N0(j10));
    }

    public static String B(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        if (jCurrentTimeMillis < 0) {
            return String.format("%tc", Long.valueOf(j10));
        }
        if (jCurrentTimeMillis < 1000) {
            return "刚刚";
        }
        if (jCurrentTimeMillis < 60000) {
            return String.format(Locale.getDefault(), "%d秒前", Long.valueOf(jCurrentTimeMillis / 1000));
        }
        if (jCurrentTimeMillis < 3600000) {
            return String.format(Locale.getDefault(), "%d分钟前", Long.valueOf(jCurrentTimeMillis / 60000));
        }
        long jO0 = o0();
        return j10 >= jO0 ? String.format("今天%tR", Long.valueOf(j10)) : j10 >= jO0 - 86400000 ? String.format("昨天%tR", Long.valueOf(j10)) : String.format("%tF", Long.valueOf(j10));
    }

    public static boolean B0(String str) {
        return D0(V0(str, s()));
    }

    public static String C(String str) {
        return D(str, s());
    }

    public static boolean C0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return D0(V0(str, dateFormat));
    }

    public static String D(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return B(Y0(str, dateFormat));
    }

    public static boolean D0(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return z0(calendar.get(1));
    }

    public static String E(Date date) {
        return B(date.getTime());
    }

    public static boolean E0() {
        return !u0();
    }

    public static long F(long j10, long j11, int i10) {
        return j10 + Z0(j11, i10);
    }

    public static boolean F0(long j10) {
        return !v0(j10);
    }

    public static long G(String str, long j10, int i10) {
        return H(str, s(), j10, i10);
    }

    public static boolean G0(String str) {
        return !w0(str);
    }

    public static long H(String str, @g.n0 DateFormat dateFormat, long j10, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Y0(str, dateFormat) + Z0(j10, i10);
    }

    public static boolean H0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return !x0(str, dateFormat);
    }

    public static long I(Date date, long j10, int i10) {
        return a(date) + Z0(j10, i10);
    }

    public static boolean I0(Date date) {
        return !y0(date);
    }

    public static long J(long j10, int i10) {
        return F(L(), j10, i10);
    }

    public static boolean J0(long j10) {
        long jO0 = o0();
        return j10 >= jO0 && j10 < jO0 + 86400000;
    }

    public static Date K() {
        return new Date();
    }

    public static boolean K0(String str) {
        return J0(Y0(str, s()));
    }

    public static long L() {
        return System.currentTimeMillis();
    }

    public static boolean L0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return J0(Y0(str, dateFormat));
    }

    public static String M() {
        return R0(System.currentTimeMillis(), s());
    }

    public static boolean M0(Date date) {
        return J0(date.getTime());
    }

    public static String N(@g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R0(System.currentTimeMillis(), dateFormat);
    }

    public static Date N0(long j10) {
        return new Date(j10);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static SimpleDateFormat O(String str) {
        Map<String, SimpleDateFormat> map = f11761a.get();
        SimpleDateFormat simpleDateFormat = map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String O0(long j10, int i10) {
        if (i10 <= 0) {
            return null;
        }
        int iMin = Math.min(i10, 5);
        String[] strArr = {"天", "小时", "分钟", "秒", "毫秒"};
        if (j10 == 0) {
            return 0 + strArr[iMin - 1];
        }
        StringBuilder sb2 = new StringBuilder();
        if (j10 < 0) {
            sb2.append("-");
            j10 = -j10;
        }
        int[] iArr = {w3.e.f53895e, w3.e.f53894d, 60000, 1000, 1};
        for (int i11 = 0; i11 < iMin; i11++) {
            if (j10 >= iArr[i11]) {
                long j11 = j10 / ((long) iArr[i11]);
                j10 -= ((long) iArr[i11]) * j11;
                sb2.append(j11);
                sb2.append(strArr[i11]);
            }
        }
        return sb2.toString();
    }

    public static String P(long j10, long j11, int i10) {
        return Q(j10, s(), j11, i10);
    }

    public static String P0(long j10) {
        return R0(j10, s());
    }

    public static String Q(long j10, @g.n0 DateFormat dateFormat, long j11, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R0(j10 + Z0(j11, i10), dateFormat);
    }

    public static String Q0(long j10, @g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R0(j10, O(str));
    }

    public static String R(String str, long j10, int i10) {
        return S(str, s(), j10, i10);
    }

    public static String R0(long j10, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return dateFormat.format(new Date(j10));
    }

    public static String S(String str, @g.n0 DateFormat dateFormat, long j10, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R0(Y0(str, dateFormat) + Z0(j10, i10), dateFormat);
    }

    public static long S0(long j10, int i10) {
        return j10 / ((long) i10);
    }

    public static String T(Date date, long j10, int i10) {
        return U(date, s(), j10, i10);
    }

    public static Date T0(String str) {
        return V0(str, s());
    }

    public static String U(Date date, @g.n0 DateFormat dateFormat, long j10, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return R0(a(date) + Z0(j10, i10), dateFormat);
    }

    public static Date U0(String str, @g.n0 String str2) {
        Objects.requireNonNull(str2, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return V0(str, O(str2));
    }

    public static String V(long j10, int i10) {
        return W(j10, s(), i10);
    }

    public static Date V0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return dateFormat.parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String W(long j10, @g.n0 DateFormat dateFormat, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Q(L(), dateFormat, j10, i10);
    }

    public static long W0(String str) {
        return Y0(str, s());
    }

    public static long X(long j10, long j11, int i10) {
        return S0(j10 - j11, i10);
    }

    public static long X0(String str, @g.n0 String str2) {
        Objects.requireNonNull(str2, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Y0(str, O(str2));
    }

    public static long Y(String str, String str2, int i10) {
        return Z(str, str2, s(), i10);
    }

    public static long Y0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return dateFormat.parse(str).getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return -1L;
        }
    }

    public static long Z(String str, String str2, @g.n0 DateFormat dateFormat, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return S0(Y0(str, dateFormat) - Y0(str2, dateFormat), i10);
    }

    public static long Z0(long j10, int i10) {
        return j10 * ((long) i10);
    }

    public static long a(Date date) {
        return date.getTime();
    }

    public static long a0(Date date, Date date2, int i10) {
        return S0(a(date) - a(date2), i10);
    }

    public static String b(Date date) {
        return d(date, s());
    }

    public static long b0(long j10, int i10) {
        return X(j10, System.currentTimeMillis(), i10);
    }

    public static String c(Date date, @g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pattern' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return O(str).format(date);
    }

    public static long c0(String str, int i10) {
        return Z(str, M(), s(), i10);
    }

    public static String d(Date date, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return dateFormat.format(date);
    }

    public static long d0(String str, @g.n0 DateFormat dateFormat, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Z(str, N(dateFormat), dateFormat, i10);
    }

    public static String e(long j10) {
        return h(new Date(j10));
    }

    public static long e0(Date date, int i10) {
        return a0(date, new Date(), i10);
    }

    public static String f(String str) {
        return h(V0(str, s()));
    }

    public static String f0(long j10) {
        return i0(new Date(j10));
    }

    public static String g(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(V0(str, dateFormat));
    }

    public static String g0(String str) {
        return i0(V0(str, s()));
    }

    public static String h(Date date) {
        return new SimpleDateFormat(i1.a.S4, Locale.CHINA).format(date);
    }

    public static String h0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return i0(V0(str, dateFormat));
    }

    public static String i(int i10) {
        return f11762b[i10 % 12];
    }

    public static String i0(Date date) {
        return new SimpleDateFormat("EEEE", Locale.US).format(date);
    }

    public static String j(long j10) {
        return m(N0(j10));
    }

    public static int j0(int i10) {
        return Calendar.getInstance().get(i10);
    }

    public static String k(String str) {
        return m(V0(str, s()));
    }

    public static int k0(long j10, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return calendar.get(i10);
    }

    public static String l(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return m(V0(str, dateFormat));
    }

    public static int l0(String str, int i10) {
        return n0(V0(str, s()), i10);
    }

    public static String m(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return f11762b[calendar.get(1) % 12];
    }

    public static int m0(String str, @g.n0 DateFormat dateFormat, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return n0(V0(str, dateFormat), i10);
    }

    public static Date n(long j10, long j11, int i10) {
        return N0(j10 + Z0(j11, i10));
    }

    public static int n0(Date date, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(i10);
    }

    public static Date o(String str, long j10, int i10) {
        return p(str, s(), j10, i10);
    }

    public static long o0() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static Date p(String str, @g.n0 DateFormat dateFormat, long j10, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return N0(Y0(str, dateFormat) + Z0(j10, i10));
    }

    public static String p0(int i10, int i11) {
        String[] strArr = f11764d;
        int i12 = i10 - 1;
        if (i11 < f11763c[i12]) {
            i12 = (i10 + 10) % 12;
        }
        return strArr[i12];
    }

    public static Date q(Date date, long j10, int i10) {
        return N0(a(date) + Z0(j10, i10));
    }

    public static String q0(long j10) {
        return t0(N0(j10));
    }

    public static Date r(long j10, int i10) {
        return n(L(), j10, i10);
    }

    public static String r0(String str) {
        return t0(V0(str, s()));
    }

    public static SimpleDateFormat s() {
        return O("yyyy-MM-dd HH:mm:ss");
    }

    public static String s0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t0(V0(str, dateFormat));
    }

    public static String t(long j10, long j11, int i10) {
        return O0(j10 - j11, i10);
    }

    public static String t0(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return p0(calendar.get(2) + 1, calendar.get(5));
    }

    public static String u(String str, String str2, int i10) {
        return O0(Y0(str, s()) - Y0(str2, s()), i10);
    }

    public static boolean u0() {
        return Calendar.getInstance().get(9) == 0;
    }

    public static String v(String str, String str2, @g.n0 DateFormat dateFormat, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return O0(Y0(str, dateFormat) - Y0(str2, dateFormat), i10);
    }

    public static boolean v0(long j10) {
        return k0(j10, 9) == 0;
    }

    public static String w(Date date, Date date2, int i10) {
        return O0(a(date) - a(date2), i10);
    }

    public static boolean w0(String str) {
        return m0(str, s(), 9) == 0;
    }

    public static String x(long j10, int i10) {
        return t(j10, System.currentTimeMillis(), i10);
    }

    public static boolean x0(String str, @g.n0 DateFormat dateFormat) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return m0(str, dateFormat, 9) == 0;
    }

    public static String y(String str, int i10) {
        return v(str, M(), s(), i10);
    }

    public static boolean y0(Date date) {
        return n0(date, 9) == 0;
    }

    public static String z(String str, @g.n0 DateFormat dateFormat, int i10) {
        Objects.requireNonNull(dateFormat, "Argument 'format' of type DateFormat (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return v(str, N(dateFormat), dateFormat, i10);
    }

    public static boolean z0(int i10) {
        return (i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0;
    }
}
