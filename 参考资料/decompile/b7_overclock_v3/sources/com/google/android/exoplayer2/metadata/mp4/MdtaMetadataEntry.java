package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17322e = "com.android.capture.fps";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17326d;

    public class a implements Parcelable.Creator<MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MdtaMetadataEntry[] newArray(int i10) {
            return new MdtaMetadataEntry[i10];
        }
    }

    public /* synthetic */ MdtaMetadataEntry(Parcel parcel, a aVar) {
        this(parcel);
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
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.f17323a.equals(mdtaMetadataEntry.f17323a) && Arrays.equals(this.f17324b, mdtaMetadataEntry.f17324b) && this.f17325c == mdtaMetadataEntry.f17325c && this.f17326d == mdtaMetadataEntry.f17326d;
    }

    public int hashCode() {
        return ((((((527 + this.f17323a.hashCode()) * 31) + Arrays.hashCode(this.f17324b)) * 31) + this.f17325c) * 31) + this.f17326d;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "mdta: key=" + this.f17323a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17323a);
        parcel.writeByteArray(this.f17324b);
        parcel.writeInt(this.f17325c);
        parcel.writeInt(this.f17326d);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i10, int i11) {
        this.f17323a = str;
        this.f17324b = bArr;
        this.f17325c = i10;
        this.f17326d = i11;
    }

    public MdtaMetadataEntry(Parcel parcel) {
        this.f17323a = (String) u0.k(parcel.readString());
        this.f17324b = (byte[]) u0.k(parcel.createByteArray());
        this.f17325c = parcel.readInt();
        this.f17326d = parcel.readInt();
    }
}
