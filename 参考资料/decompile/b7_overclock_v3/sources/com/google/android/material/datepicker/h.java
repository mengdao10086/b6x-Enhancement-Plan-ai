package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import g.p0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static androidx.core.util.k<String, String> a(@p0 Long l10, @p0 Long l11) {
        return b(l10, l11, null);
    }

    public static androidx.core.util.k<String, String> b(@p0 Long l10, @p0 Long l11, @p0 SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return androidx.core.util.k.a(null, null);
        }
        if (l10 == null) {
            return androidx.core.util.k.a(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return androidx.core.util.k.a(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar calendarT = r.t();
        Calendar calendarV = r.v();
        calendarV.setTimeInMillis(l10.longValue());
        Calendar calendarV2 = r.v();
        calendarV2.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.util.k.a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        return calendarV.get(1) == calendarV2.get(1) ? calendarV.get(1) == calendarT.get(1) ? androidx.core.util.k.a(f(l10.longValue(), Locale.getDefault()), f(l11.longValue(), Locale.getDefault())) : androidx.core.util.k.a(f(l10.longValue(), Locale.getDefault()), k(l11.longValue(), Locale.getDefault())) : androidx.core.util.k.a(k(l10.longValue(), Locale.getDefault()), k(l11.longValue(), Locale.getDefault()));
    }

    public static String c(long j10) {
        return d(j10, null);
    }

    public static String d(long j10, @p0 SimpleDateFormat simpleDateFormat) {
        Calendar calendarT = r.t();
        Calendar calendarV = r.v();
        calendarV.setTimeInMillis(j10);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j10)) : calendarT.get(1) == calendarV.get(1) ? e(j10) : j(j10);
    }

    public static String e(long j10) {
        return f(j10, Locale.getDefault());
    }

    public static String f(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? r.c(locale).format(new Date(j10)) : r.m(locale).format(new Date(j10));
    }

    public static String g(long j10) {
        return h(j10, Locale.getDefault());
    }

    public static String h(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? r.d(locale).format(new Date(j10)) : r.i(locale).format(new Date(j10));
    }

    public static String i(long j10) {
        return DateUtils.formatDateTime(null, j10, 8228);
    }

    public static String j(long j10) {
        return k(j10, Locale.getDefault());
    }

    public static String k(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? r.x(locale).format(new Date(j10)) : r.k(locale).format(new Date(j10));
    }

    public static String l(long j10) {
        return m(j10, Locale.getDefault());
    }

    public static String m(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? r.y(locale).format(new Date(j10)) : r.i(locale).format(new Date(j10));
    }
}
