package com.just.agentweb.filechooser;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public class FileParcel implements Parcelable {
    public static final Parcelable.Creator<FileParcel> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22019c;

    public static class a implements Parcelable.Creator<FileParcel> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileParcel createFromParcel(Parcel parcel) {
            return new FileParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileParcel[] newArray(int i10) {
            return new FileParcel[i10];
        }
    }

    public FileParcel(Parcel parcel) {
        this.f22017a = parcel.readInt();
        this.f22018b = parcel.readString();
        this.f22019c = parcel.readString();
    }

    public String a() {
        return this.f22018b;
    }

    public String b() {
        return this.f22019c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f22017a;
    }

    public void g(String str) {
        this.f22018b = str;
    }

    public void j(String str) {
        this.f22019c = str;
    }

    public void s(int i10) {
        this.f22017a = i10;
    }

    public String toString() {
        return "FileParcel{mId=" + this.f22017a + ", mContentPath='" + this.f22018b + "', mFileBase64='" + this.f22019c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22017a);
        parcel.writeString(this.f22018b);
        parcel.writeString(this.f22019c);
    }

    public FileParcel(int i10, String str, String str2) {
        this.f22017a = i10;
        this.f22018b = str;
        this.f22019c = str2;
    }
}
