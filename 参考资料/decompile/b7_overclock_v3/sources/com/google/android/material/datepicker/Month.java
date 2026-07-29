package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import g.n0;
import g.p0;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes3.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Calendar f20081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f20086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public String f20087g;

    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(@n0 Parcel parcel) {
            return Month.g(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i10) {
            return new Month[i10];
        }
    }

    public Month(@n0 Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarF = r.f(calendar);
        this.f20081a = calendarF;
        this.f20082b = calendarF.get(2);
        this.f20083c = calendarF.get(1);
        this.f20084d = calendarF.getMaximum(7);
        this.f20085e = calendarF.getActualMaximum(5);
        this.f20086f = calendarF.getTimeInMillis();
    }

    @n0
    public static Month g(int i10, int i11) {
        Calendar calendarV = r.v();
        calendarV.set(1, i10);
        calendarV.set(2, i11);
        return new Month(calendarV);
    }

    @n0
    public static Month j(long j10) {
        Calendar calendarV = r.v();
        calendarV.setTimeInMillis(j10);
        return new Month(calendarV);
    }

    @n0
    public static Month s() {
        return new Month(r.t());
    }

    public int F(int i10) {
        int i11 = this.f20081a.get(7);
        if (i10 <= 0) {
            i10 = this.f20081a.getFirstDayOfWeek();
        }
        int i12 = i11 - i10;
        return i12 < 0 ? i12 + this.f20084d : i12;
    }

    public long M(int i10) {
        Calendar calendarF = r.f(this.f20081a);
        calendarF.set(5, i10);
        return calendarF.getTimeInMillis();
    }

    public int S(long j10) {
        Calendar calendarF = r.f(this.f20081a);
        calendarF.setTimeInMillis(j10);
        return calendarF.get(5);
    }

    @n0
    public String T() {
        if (this.f20087g == null) {
            this.f20087g = h.i(this.f20081a.getTimeInMillis());
        }
        return this.f20087g;
    }

    public long U() {
        return this.f20081a.getTimeInMillis();
    }

    @n0
    public Month V(int i10) {
        Calendar calendarF = r.f(this.f20081a);
        calendarF.add(2, i10);
        return new Month(calendarF);
    }

    public int W(@n0 Month month) {
        if (this.f20081a instanceof GregorianCalendar) {
            return ((month.f20083c - this.f20083c) * 12) + (month.f20082b - this.f20082b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(@n0 Month month) {
        return this.f20081a.compareTo(month.f20081a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f20082b == month.f20082b && this.f20083c == month.f20083c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20082b), Integer.valueOf(this.f20083c)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeInt(this.f20083c);
        parcel.writeInt(this.f20082b);
    }
}
