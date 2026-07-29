package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import g.n0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20002a;

    public class a implements Parcelable.Creator<DateValidatorPointForward> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward createFromParcel(@n0 Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward[] newArray(int i10) {
            return new DateValidatorPointForward[i10];
        }
    }

    public /* synthetic */ DateValidatorPointForward(long j10, a aVar) {
        this(j10);
    }

    @n0
    public static DateValidatorPointForward a(long j10) {
        return new DateValidatorPointForward(j10);
    }

    @n0
    public static DateValidatorPointForward b() {
        return a(r.t().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean D(long j10) {
        return j10 >= this.f20002a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f20002a == ((DateValidatorPointForward) obj).f20002a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f20002a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeLong(this.f20002a);
    }

    public DateValidatorPointForward(long j10) {
        this.f20002a = j10;
    }
}
