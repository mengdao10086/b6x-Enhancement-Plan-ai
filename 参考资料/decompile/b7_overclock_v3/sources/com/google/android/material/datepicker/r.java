package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.blankj.utilcode.util.i0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20160a = "UTC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicReference<q> f20161b = new AtomicReference<>();

    public static void A(@p0 q qVar) {
        f20161b.set(qVar);
    }

    public static long a(long j10) {
        Calendar calendarV = v();
        calendarV.setTimeInMillis(j10);
        return f(calendarV).getTimeInMillis();
    }

    public static int b(@n0 String str, @n0 String str2, int i10, int i11) {
        while (i11 >= 0 && i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            if (str.charAt(i11) == '\'') {
                do {
                    i11 += i10;
                    if (i11 < 0 || i11 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i11) != '\'');
            }
            i11 += i10;
        }
        return i11;
    }

    @TargetApi(24)
    public static DateFormat c(Locale locale) {
        return e("MMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat d(Locale locale) {
        return e("MMMEd", locale);
    }

    @TargetApi(24)
    public static DateFormat e(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(u());
        return instanceForSkeleton;
    }

    public static Calendar f(Calendar calendar) {
        Calendar calendarW = w(calendar);
        Calendar calendarV = v();
        calendarV.set(calendarW.get(1), calendarW.get(2), calendarW.get(5));
        return calendarV;
    }

    public static java.text.DateFormat g(int i10, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i10, locale);
        dateInstance.setTimeZone(s());
        return dateInstance;
    }

    public static java.text.DateFormat h() {
        return i(Locale.getDefault());
    }

    public static java.text.DateFormat i(Locale locale) {
        return g(0, locale);
    }

    public static java.text.DateFormat j() {
        return k(Locale.getDefault());
    }

    public static java.text.DateFormat k(Locale locale) {
        return g(2, locale);
    }

    public static java.text.DateFormat l() {
        return m(Locale.getDefault());
    }

    public static java.text.DateFormat m(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) k(locale);
        simpleDateFormat.applyPattern(z(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    public static SimpleDateFormat n(String str) {
        return o(str, Locale.getDefault());
    }

    public static SimpleDateFormat o(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(s());
        return simpleDateFormat;
    }

    public static SimpleDateFormat p() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(s());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String q(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace("y", "yyyy");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    public static q r() {
        q qVar = f20161b.get();
        return qVar == null ? q.e() : qVar;
    }

    public static TimeZone s() {
        return TimeZone.getTimeZone(f20160a);
    }

    public static Calendar t() {
        Calendar calendarC = r().c();
        calendarC.set(11, 0);
        calendarC.set(12, 0);
        calendarC.set(13, 0);
        calendarC.set(14, 0);
        calendarC.setTimeZone(s());
        return calendarC;
    }

    @TargetApi(24)
    public static android.icu.util.TimeZone u() {
        return android.icu.util.TimeZone.getTimeZone(f20160a);
    }

    public static Calendar v() {
        return w(null);
    }

    public static Calendar w(@p0 Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(s());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    public static DateFormat x(Locale locale) {
        return e("yMMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat y(Locale locale) {
        return e("yMMMEd", locale);
    }

    @n0
    public static String z(@n0 String str) {
        int iB = b(str, "yY", 1, 0);
        if (iB >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int iB2 = b(str, "EMd", 1, iB);
        if (iB2 < str.length()) {
            str2 = "EMd" + ag.c.f654g;
        }
        return str.replace(str.substring(b(str, str2, -1, iB) + 1, iB2), i0.f11861z).trim();
    }
}
