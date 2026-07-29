package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Month f19980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Month f19981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final DateValidator f19982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public Month f19983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f19986g;

    public interface DateValidator extends Parcelable {
        boolean D(long j10);
    }

    public class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(@n0 Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i10) {
            return new CalendarConstraints[i10];
        }
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i10, a aVar) {
        this(month, month2, dateValidator, month3, i10);
    }

    @n0
    public Month C() {
        return this.f19981b;
    }

    public int F() {
        return this.f19984e;
    }

    public int M() {
        return this.f19986g;
    }

    @p0
    public Month S() {
        return this.f19983d;
    }

    @n0
    public Month T() {
        return this.f19980a;
    }

    public int U() {
        return this.f19985f;
    }

    public boolean V(long j10) {
        if (this.f19980a.M(1) <= j10) {
            Month month = this.f19981b;
            if (j10 <= month.M(month.f20085e)) {
                return true;
            }
        }
        return false;
    }

    public void W(@p0 Month month) {
        this.f19983d = month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f19980a.equals(calendarConstraints.f19980a) && this.f19981b.equals(calendarConstraints.f19981b) && androidx.core.util.j.a(this.f19983d, calendarConstraints.f19983d) && this.f19984e == calendarConstraints.f19984e && this.f19982c.equals(calendarConstraints.f19982c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f19980a, this.f19981b, this.f19983d, Integer.valueOf(this.f19984e), this.f19982c});
    }

    public Month s(Month month) {
        return month.compareTo(this.f19980a) < 0 ? this.f19980a : month.compareTo(this.f19981b) > 0 ? this.f19981b : month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f19980a, 0);
        parcel.writeParcelable(this.f19981b, 0);
        parcel.writeParcelable(this.f19983d, 0);
        parcel.writeParcelable(this.f19982c, 0);
        parcel.writeInt(this.f19984e);
    }

    public DateValidator z() {
        return this.f19982c;
    }

    public CalendarConstraints(@n0 Month month, @n0 Month month2, @n0 DateValidator dateValidator, @p0 Month month3, int i10) {
        this.f19980a = month;
        this.f19981b = month2;
        this.f19983d = month3;
        this.f19984e = i10;
        this.f19982c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i10 < 0 || i10 > r.v().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f19986g = month.W(month2) + 1;
        this.f19985f = (month2.f20083c - month.f20083c) + 1;
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f19987f = r.a(Month.g(1900, 0).f20086f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final long f19988g = r.a(Month.g(2100, 11).f20086f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f19989h = "DEEP_COPY_VALIDATOR_KEY";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f19992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DateValidator f19994e;

        public b() {
            this.f19990a = f19987f;
            this.f19991b = f19988g;
            this.f19994e = DateValidatorPointForward.a(Long.MIN_VALUE);
        }

        @n0
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(f19989h, this.f19994e);
            Month monthJ = Month.j(this.f19990a);
            Month monthJ2 = Month.j(this.f19991b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(f19989h);
            Long l10 = this.f19992c;
            return new CalendarConstraints(monthJ, monthJ2, dateValidator, l10 == null ? null : Month.j(l10.longValue()), this.f19993d, null);
        }

        @n0
        public b b(long j10) {
            this.f19991b = j10;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public b c(int i10) {
            this.f19993d = i10;
            return this;
        }

        @n0
        public b d(long j10) {
            this.f19992c = Long.valueOf(j10);
            return this;
        }

        @n0
        public b e(long j10) {
            this.f19990a = j10;
            return this;
        }

        @n0
        public b f(@n0 DateValidator dateValidator) {
            this.f19994e = dateValidator;
            return this;
        }

        public b(@n0 CalendarConstraints calendarConstraints) {
            this.f19990a = f19987f;
            this.f19991b = f19988g;
            this.f19994e = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f19990a = calendarConstraints.f19980a.f20086f;
            this.f19991b = calendarConstraints.f19981b.f20086f;
            this.f19992c = Long.valueOf(calendarConstraints.f19983d.f20086f);
            this.f19993d = calendarConstraints.f19984e;
            this.f19994e = calendarConstraints.f19982c;
        }
    }
}
