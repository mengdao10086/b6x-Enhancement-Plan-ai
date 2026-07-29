package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f17273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f17274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f17275c;

    public class a implements Parcelable.Creator<IcyInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IcyInfo[] newArray(int i10) {
            return new IcyInfo[i10];
        }
    }

    public IcyInfo(byte[] bArr, @p0 String str, @p0 String str2) {
        this.f17273a = bArr;
        this.f17274b = str;
        this.f17275c = str2;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] O() {
        return ub.a.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f17273a, ((IcyInfo) obj).f17273a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f17273a);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f17274b, this.f17275c, Integer.valueOf(this.f17273a.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByteArray(this.f17273a);
        parcel.writeString(this.f17274b);
        parcel.writeString(this.f17275c);
    }

    public IcyInfo(Parcel parcel) {
        this.f17273a = (byte[]) hd.a.g(parcel.createByteArray());
        this.f17274b = parcel.readString();
        this.f17275c = parcel.readString();
    }
}
