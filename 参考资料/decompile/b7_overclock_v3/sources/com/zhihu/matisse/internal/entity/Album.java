package com.zhihu.matisse.internal.entity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.zhihu.matisse.R;
import g.p0;

/* JADX INFO: loaded from: classes5.dex */
public class Album implements Parcelable {
    public static final Parcelable.Creator<Album> CREATOR = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25089e = String.valueOf(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25090f = "All";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f25092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f25093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25094d;

    public static class a implements Parcelable.Creator<Album> {
        @Override // android.os.Parcelable.Creator
        @p0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Album createFromParcel(Parcel parcel) {
            return new Album(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Album[] newArray(int i10) {
            return new Album[i10];
        }
    }

    public /* synthetic */ Album(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static Album C(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("uri"));
        String string2 = cursor.getString(cursor.getColumnIndex(uh.a.f52129z));
        if (string == null) {
            string = "";
        }
        return new Album(string2, Uri.parse(string), cursor.getString(cursor.getColumnIndex(uh.a.A)), cursor.getLong(cursor.getColumnIndex(uh.a.C)));
    }

    public void a() {
        this.f25094d++;
    }

    public long b() {
        return this.f25094d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.f25092b;
    }

    public String g(Context context) {
        return s() ? context.getString(R.string.album_name_all) : this.f25093c;
    }

    public String j() {
        return this.f25091a;
    }

    public boolean s() {
        return f25089e.equals(this.f25091a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f25091a);
        parcel.writeParcelable(this.f25092b, 0);
        parcel.writeString(this.f25093c);
        parcel.writeLong(this.f25094d);
    }

    public boolean z() {
        return this.f25094d == 0;
    }

    public Album(String str, Uri uri, String str2, long j10) {
        this.f25091a = str;
        this.f25092b = uri;
        this.f25093c = str2;
        this.f25094d = j10;
    }

    public Album(Parcel parcel) {
        this.f25091a = parcel.readString();
        this.f25092b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f25093c = parcel.readString();
        this.f25094d = parcel.readLong();
    }
}
