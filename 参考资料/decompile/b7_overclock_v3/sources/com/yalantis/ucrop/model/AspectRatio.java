package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;

/* JADX INFO: loaded from: classes5.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f24981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f24982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f24983c;

    public static class a implements Parcelable.Creator<AspectRatio> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AspectRatio[] newArray(int i10) {
            return new AspectRatio[i10];
        }
    }

    public AspectRatio(@p0 String str, float f10, float f11) {
        this.f24981a = str;
        this.f24982b = f10;
        this.f24983c = f11;
    }

    @p0
    public String a() {
        return this.f24981a;
    }

    public float b() {
        return this.f24982b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.f24983c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f24981a);
        parcel.writeFloat(this.f24982b);
        parcel.writeFloat(this.f24983c);
    }

    public AspectRatio(Parcel parcel) {
        this.f24981a = parcel.readString();
        this.f24982b = parcel.readFloat();
        this.f24983c = parcel.readFloat();
    }
}
