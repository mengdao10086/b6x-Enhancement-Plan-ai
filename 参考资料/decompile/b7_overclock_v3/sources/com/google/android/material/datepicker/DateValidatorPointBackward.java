package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import g.n0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20001a;

    public class a implements Parcelable.Creator<DateValidatorPointBackward> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointBackward createFromParcel(@n0 Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointBackward[] newArray(int i10) {
            return new DateValidatorPointBackward[i10];
        }
    }

    public /* synthetic */ DateValidatorPointBackward(long j10, a aVar) {
        this(j10);
    }

    @n0
    public static DateValidatorPointBackward a(long j10) {
        return new DateValidatorPointBackward(j10);
    }

    @n0
    public static DateValidatorPointBackward b() {
        return a(r.t().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean D(long j10) {
        return j10 <= this.f20001a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointBackward) && this.f20001a == ((DateValidatorPointBackward) obj).f20001a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f20001a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeLong(this.f20001a);
    }

    public DateValidatorPointBackward(long j10) {
        this.f20001a = j10;
    }
}
