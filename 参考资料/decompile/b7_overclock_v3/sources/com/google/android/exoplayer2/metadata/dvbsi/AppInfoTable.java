package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;

/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17233c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f17234d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17236b;

    public class a implements Parcelable.Creator<AppInfoTable> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) hd.a.g(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AppInfoTable[] newArray(int i10) {
            return new AppInfoTable[i10];
        }
    }

    public AppInfoTable(int i10, String str) {
        this.f17235a = i10;
        this.f17236b = str;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] O() {
        return ub.a.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "Ait(controlCode=" + this.f17235a + ",url=" + this.f17236b + ee.a.f26979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17236b);
        parcel.writeInt(this.f17235a);
    }
}
