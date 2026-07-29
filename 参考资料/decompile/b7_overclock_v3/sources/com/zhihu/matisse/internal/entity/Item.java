package com.zhihu.matisse.internal.entity;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import com.google.android.exoplayer2.offline.b;
import com.umeng.analytics.pro.ar;
import com.zhihu.matisse.MimeType;
import g.p0;

/* JADX INFO: loaded from: classes5.dex */
public class Item implements Parcelable {
    public static final Parcelable.Creator<Item> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f25095f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25096g = "Capture";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f25097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f25099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f25100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f25101e;

    public static class a implements Parcelable.Creator<Item> {
        @Override // android.os.Parcelable.Creator
        @p0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Item createFromParcel(Parcel parcel) {
            return new Item(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Item[] newArray(int i10) {
            return new Item[i10];
        }
    }

    public /* synthetic */ Item(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static Item s(Cursor cursor) {
        return new Item(cursor.getLong(cursor.getColumnIndex(ar.f23316d)), cursor.getString(cursor.getColumnIndex(b.f17433i)), cursor.getLong(cursor.getColumnIndex("_size")), cursor.getLong(cursor.getColumnIndex("duration")));
    }

    public Uri a() {
        return this.f25099c;
    }

    public boolean b() {
        return this.f25097a == -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return MimeType.isGif(this.f25098b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        if (this.f25097a != item.f25097a) {
            return false;
        }
        String str = this.f25098b;
        if ((str == null || !str.equals(item.f25098b)) && !(this.f25098b == null && item.f25098b == null)) {
            return false;
        }
        Uri uri = this.f25099c;
        return ((uri != null && uri.equals(item.f25099c)) || (this.f25099c == null && item.f25099c == null)) && this.f25100d == item.f25100d && this.f25101e == item.f25101e;
    }

    public boolean g() {
        return MimeType.isImage(this.f25098b);
    }

    public int hashCode() {
        int iHashCode = Long.valueOf(this.f25097a).hashCode() + 31;
        String str = this.f25098b;
        if (str != null) {
            iHashCode = (iHashCode * 31) + str.hashCode();
        }
        return (((((iHashCode * 31) + this.f25099c.hashCode()) * 31) + Long.valueOf(this.f25100d).hashCode()) * 31) + Long.valueOf(this.f25101e).hashCode();
    }

    public boolean j() {
        return MimeType.isVideo(this.f25098b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f25097a);
        parcel.writeString(this.f25098b);
        parcel.writeParcelable(this.f25099c, 0);
        parcel.writeLong(this.f25100d);
        parcel.writeLong(this.f25101e);
    }

    public Item(long j10, String str, long j11, long j12) {
        this.f25097a = j10;
        this.f25098b = str;
        this.f25099c = ContentUris.withAppendedId(g() ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : j() ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Files.getContentUri("external"), j10);
        this.f25100d = j11;
        this.f25101e = j12;
    }

    public Item(Parcel parcel) {
        this.f25097a = parcel.readLong();
        this.f25098b = parcel.readString();
        this.f25099c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f25100d = parcel.readLong();
        this.f25101e = parcel.readLong();
    }
}
