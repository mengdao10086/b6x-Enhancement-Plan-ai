package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.primitives.Floats;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17338b;

    public class a implements Parcelable.Creator<SmtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SmtaMetadataEntry[] newArray(int i10) {
            return new SmtaMetadataEntry[i10];
        }
    }

    public /* synthetic */ SmtaMetadataEntry(Parcel parcel, a aVar) {
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
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        return this.f17337a == smtaMetadataEntry.f17337a && this.f17338b == smtaMetadataEntry.f17338b;
    }

    public int hashCode() {
        return ((527 + Floats.hashCode(this.f17337a)) * 31) + this.f17338b;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f17337a + ", svcTemporalLayerCount=" + this.f17338b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f17337a);
        parcel.writeInt(this.f17338b);
    }

    public SmtaMetadataEntry(float f10, int i10) {
        this.f17337a = f10;
        this.f17338b = i10;
    }

    public SmtaMetadataEntry(Parcel parcel) {
        this.f17337a = parcel.readFloat();
        this.f17338b = parcel.readInt();
    }
}
