package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import g.f0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f21106h = "%02d";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f21107i = "%d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21114g;

    public class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i10) {
            return new TimeModel[i10];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, f21106h);
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public static int s(int i10) {
        return i10 >= 12 ? 1 : 0;
    }

    public void C(int i10) {
        this.f21114g = s(i10);
        this.f21111d = i10;
    }

    public void F(@f0(from = 0, to = 59) int i10) {
        this.f21112e = i10 % 60;
    }

    public void M(int i10) {
        if (i10 != this.f21114g) {
            this.f21114g = i10;
            int i11 = this.f21111d;
            if (i11 < 12 && i10 == 1) {
                this.f21111d = i11 + 12;
            } else {
                if (i11 < 12 || i10 != 0) {
                    return;
                }
                this.f21111d = i11 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        if (this.f21110c == 1) {
            return this.f21111d % 24;
        }
        int i10 = this.f21111d;
        if (i10 % 12 == 0) {
            return 12;
        }
        return this.f21114g == 1 ? i10 - 12 : i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f21111d == timeModel.f21111d && this.f21112e == timeModel.f21112e && this.f21110c == timeModel.f21110c && this.f21113f == timeModel.f21113f;
    }

    public b g() {
        return this.f21109b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f21110c), Integer.valueOf(this.f21111d), Integer.valueOf(this.f21112e), Integer.valueOf(this.f21113f)});
    }

    public b j() {
        return this.f21108a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21111d);
        parcel.writeInt(this.f21112e);
        parcel.writeInt(this.f21113f);
        parcel.writeInt(this.f21110c);
    }

    public void z(int i10) {
        if (this.f21110c == 1) {
            this.f21111d = i10;
        } else {
            this.f21111d = (i10 % 12) + (this.f21114g != 1 ? 0 : 12);
        }
    }

    public TimeModel(int i10) {
        this(0, 0, 10, i10);
    }

    public TimeModel(int i10, int i11, int i12, int i13) {
        this.f21111d = i10;
        this.f21112e = i11;
        this.f21113f = i12;
        this.f21110c = i13;
        this.f21114g = s(i10);
        this.f21108a = new b(59);
        this.f21109b = new b(i13 == 1 ? 24 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
