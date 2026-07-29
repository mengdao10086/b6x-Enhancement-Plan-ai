package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.primitives.Longs;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17331e;

    public class a implements Parcelable.Creator<MotionPhotoMetadata> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MotionPhotoMetadata[] newArray(int i10) {
            return new MotionPhotoMetadata[i10];
        }
    }

    public /* synthetic */ MotionPhotoMetadata(Parcel parcel, a aVar) {
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
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.f17327a == motionPhotoMetadata.f17327a && this.f17328b == motionPhotoMetadata.f17328b && this.f17329c == motionPhotoMetadata.f17329c && this.f17330d == motionPhotoMetadata.f17330d && this.f17331e == motionPhotoMetadata.f17331e;
    }

    public int hashCode() {
        return ((((((((527 + Longs.hashCode(this.f17327a)) * 31) + Longs.hashCode(this.f17328b)) * 31) + Longs.hashCode(this.f17329c)) * 31) + Longs.hashCode(this.f17330d)) * 31) + Longs.hashCode(this.f17331e);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f17327a + ", photoSize=" + this.f17328b + ", photoPresentationTimestampUs=" + this.f17329c + ", videoStartPosition=" + this.f17330d + ", videoSize=" + this.f17331e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f17327a);
        parcel.writeLong(this.f17328b);
        parcel.writeLong(this.f17329c);
        parcel.writeLong(this.f17330d);
        parcel.writeLong(this.f17331e);
    }

    public MotionPhotoMetadata(long j10, long j11, long j12, long j13, long j14) {
        this.f17327a = j10;
        this.f17328b = j11;
        this.f17329c = j12;
        this.f17330d = j13;
        this.f17331e = j14;
    }

    public MotionPhotoMetadata(Parcel parcel) {
        this.f17327a = parcel.readLong();
        this.f17328b = parcel.readLong();
        this.f17329c = parcel.readLong();
        this.f17330d = parcel.readLong();
        this.f17331e = parcel.readLong();
    }
}
