package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17295e = "COMM";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17298d;

    public class a implements Parcelable.Creator<CommentFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommentFrame[] newArray(int i10) {
            return new CommentFrame[i10];
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super(f17295e);
        this.f17296b = str;
        this.f17297c = str2;
        this.f17298d = str3;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return u0.c(this.f17297c, commentFrame.f17297c) && u0.c(this.f17296b, commentFrame.f17296b) && u0.c(this.f17298d, commentFrame.f17298d);
    }

    public int hashCode() {
        String str = this.f17296b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17297c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17298d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": language=" + this.f17296b + ", description=" + this.f17297c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17304a);
        parcel.writeString(this.f17296b);
        parcel.writeString(this.f17298d);
    }

    public CommentFrame(Parcel parcel) {
        super(f17295e);
        this.f17296b = (String) u0.k(parcel.readString());
        this.f17297c = (String) u0.k(parcel.readString());
        this.f17298d = (String) u0.k(parcel.readString());
    }
}
