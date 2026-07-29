package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f17282h = "CHAP";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Id3Frame[] f17288g;

    public class a implements Parcelable.Creator<ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterFrame[] newArray(int i10) {
            return new ChapterFrame[i10];
        }
    }

    public ChapterFrame(String str, int i10, int i11, long j10, long j11, Id3Frame[] id3FrameArr) {
        super(f17282h);
        this.f17283b = str;
        this.f17284c = i10;
        this.f17285d = i11;
        this.f17286e = j10;
        this.f17287f = j11;
        this.f17288g = id3FrameArr;
    }

    public Id3Frame a(int i10) {
        return this.f17288g[i10];
    }

    public int b() {
        return this.f17288g.length;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.f17284c == chapterFrame.f17284c && this.f17285d == chapterFrame.f17285d && this.f17286e == chapterFrame.f17286e && this.f17287f == chapterFrame.f17287f && u0.c(this.f17283b, chapterFrame.f17283b) && Arrays.equals(this.f17288g, chapterFrame.f17288g);
    }

    public int hashCode() {
        int i10 = (((((((527 + this.f17284c) * 31) + this.f17285d) * 31) + ((int) this.f17286e)) * 31) + ((int) this.f17287f)) * 31;
        String str = this.f17283b;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17283b);
        parcel.writeInt(this.f17284c);
        parcel.writeInt(this.f17285d);
        parcel.writeLong(this.f17286e);
        parcel.writeLong(this.f17287f);
        parcel.writeInt(this.f17288g.length);
        for (Id3Frame id3Frame : this.f17288g) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super(f17282h);
        this.f17283b = (String) u0.k(parcel.readString());
        this.f17284c = parcel.readInt();
        this.f17285d = parcel.readInt();
        this.f17286e = parcel.readLong();
        this.f17287f = parcel.readLong();
        int i10 = parcel.readInt();
        this.f17288g = new Id3Frame[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f17288g[i11] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
