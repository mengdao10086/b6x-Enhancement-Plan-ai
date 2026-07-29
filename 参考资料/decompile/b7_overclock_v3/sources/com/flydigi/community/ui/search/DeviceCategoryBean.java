package com.flydigi.community.ui.search;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceCategoryBean implements Parcelable {
    public static final Parcelable.Creator<DeviceCategoryBean> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14036c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14037d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14038e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14039f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14041b;

    public class a implements Parcelable.Creator<DeviceCategoryBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceCategoryBean createFromParcel(Parcel parcel) {
            return new DeviceCategoryBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceCategoryBean[] newArray(int i10) {
            return new DeviceCategoryBean[i10];
        }
    }

    public DeviceCategoryBean() {
    }

    public String a() {
        return this.f14041b;
    }

    public int b() {
        return this.f14040a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.f14041b = str;
    }

    public void g(int i10) {
        this.f14040a = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f14040a);
        parcel.writeString(this.f14041b);
    }

    public DeviceCategoryBean(Parcel parcel) {
        this.f14040a = parcel.readInt();
        this.f14041b = parcel.readString();
    }
}
