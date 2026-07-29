package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f17320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17321c;

    public class a implements Parcelable.Creator<UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UrlLinkFrame[] newArray(int i10) {
            return new UrlLinkFrame[i10];
        }
    }

    public UrlLinkFrame(String str, @p0 String str2, String str3) {
        super(str);
        this.f17320b = str2;
        this.f17321c = str3;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.f17304a.equals(urlLinkFrame.f17304a) && u0.c(this.f17320b, urlLinkFrame.f17320b) && u0.c(this.f17321c, urlLinkFrame.f17321c);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f17304a.hashCode()) * 31;
        String str = this.f17320b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17321c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": url=" + this.f17321c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17304a);
        parcel.writeString(this.f17320b);
        parcel.writeString(this.f17321c);
    }

    public UrlLinkFrame(Parcel parcel) {
        super((String) u0.k(parcel.readString()));
        this.f17320b = parcel.readString();
        this.f17321c = (String) u0.k(parcel.readString());
    }
}
