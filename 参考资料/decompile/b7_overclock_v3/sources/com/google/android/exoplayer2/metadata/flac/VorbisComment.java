package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import hb.u;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17257b;

    public class a implements Parcelable.Creator<VorbisComment> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public VorbisComment[] newArray(int i10) {
            return new VorbisComment[i10];
        }
    }

    public VorbisComment(String str, String str2) {
        this.f17256a = str;
        this.f17257b = str2;
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
        if (obj == null || VorbisComment.class != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.f17256a.equals(vorbisComment.f17256a) && this.f17257b.equals(vorbisComment.f17257b);
    }

    public int hashCode() {
        return ((527 + this.f17256a.hashCode()) * 31) + this.f17257b.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "VC: " + this.f17256a + u.f30904o + this.f17257b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17256a);
        parcel.writeString(this.f17257b);
    }

    public VorbisComment(Parcel parcel) {
        this.f17256a = (String) u0.k(parcel.readString());
        this.f17257b = (String) u0.k(parcel.readString());
    }
}
