package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f19995c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f19996d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final d f19999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final List<CalendarConstraints.DateValidator> f20000b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f19997e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f19998f = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    public class a implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@n0 List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.D(j10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    public class b implements d {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@n0 List<CalendarConstraints.DateValidator> list, long j10) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.D(j10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    public class c implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator createFromParcel(@n0 Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i10 = parcel.readInt();
            d dVar = (i10 != 2 && i10 == 1) ? CompositeDateValidator.f19997e : CompositeDateValidator.f19998f;
            return new CompositeDateValidator((List) androidx.core.util.o.l(arrayList), dVar, null);
        }

        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator[] newArray(int i10) {
            return new CompositeDateValidator[i10];
        }
    }

    public interface d {
        boolean a(@n0 List<CalendarConstraints.DateValidator> list, long j10);

        int getId();
    }

    public /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @n0
    public static CalendarConstraints.DateValidator e(@n0 List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, f19998f);
    }

    @n0
    public static CalendarConstraints.DateValidator g(@n0 List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, f19997e);
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean D(long j10) {
        return this.f19999a.a(this.f20000b, j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f20000b.equals(compositeDateValidator.f20000b) && this.f19999a.getId() == compositeDateValidator.f19999a.getId();
    }

    public int hashCode() {
        return this.f20000b.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeList(this.f20000b);
        parcel.writeInt(this.f19999a.getId());
    }

    public CompositeDateValidator(@n0 List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f20000b = list;
        this.f19999a = dVar;
    }
}
