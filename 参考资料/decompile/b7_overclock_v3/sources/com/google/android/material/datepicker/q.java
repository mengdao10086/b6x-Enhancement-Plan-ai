package com.google.android.material.datepicker;

import g.p0;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f20157c = new q(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Long f20158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final TimeZone f20159b;

    public q(@p0 Long l10, @p0 TimeZone timeZone) {
        this.f20158a = l10;
        this.f20159b = timeZone;
    }

    public static q a(long j10) {
        return new q(Long.valueOf(j10), null);
    }

    public static q b(long j10, @p0 TimeZone timeZone) {
        return new q(Long.valueOf(j10), timeZone);
    }

    public static q e() {
        return f20157c;
    }

    public Calendar c() {
        return d(this.f20159b);
    }

    public Calendar d(@p0 TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = this.f20158a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
