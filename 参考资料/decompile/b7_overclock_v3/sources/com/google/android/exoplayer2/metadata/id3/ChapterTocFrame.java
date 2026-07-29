package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f17289g = "CTOC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f17293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Id3Frame[] f17294f;

    public class a implements Parcelable.Creator<ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame[] newArray(int i10) {
            return new ChapterTocFrame[i10];
        }
    }

    public ChapterTocFrame(String str, boolean z10, boolean z11, String[] strArr, Id3Frame[] id3FrameArr) {
        super(f17289g);
        this.f17290b = str;
        this.f17291c = z10;
        this.f17292d = z11;
        this.f17293e = strArr;
        this.f17294f = id3FrameArr;
    }

    public Id3Frame a(int i10) {
        return this.f17294f[i10];
    }

    public int b() {
        return this.f17294f.length;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.f17291c == chapterTocFrame.f17291c && this.f17292d == chapterTocFrame.f17292d && u0.c(this.f17290b, chapterTocFrame.f17290b) && Arrays.equals(this.f17293e, chapterTocFrame.f17293e) && Arrays.equals(this.f17294f, chapterTocFrame.f17294f);
    }

    public int hashCode() {
        int i10 = (((527 + (this.f17291c ? 1 : 0)) * 31) + (this.f17292d ? 1 : 0)) * 31;
        String str = this.f17290b;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17290b);
        parcel.writeByte(this.f17291c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17292d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f17293e);
        parcel.writeInt(this.f17294f.length);
        for (Id3Frame id3Frame : this.f17294f) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super(f17289g);
        this.f17290b = (String) u0.k(parcel.readString());
        this.f17291c = parcel.readByte() != 0;
        this.f17292d = parcel.readByte() != 0;
        this.f17293e = (String[]) u0.k(parcel.createStringArray());
        int i10 = parcel.readInt();
        this.f17294f = new Id3Frame[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f17294f[i11] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
