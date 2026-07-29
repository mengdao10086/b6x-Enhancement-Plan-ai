package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17305e = "----";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17308d;

    public class a implements Parcelable.Creator<InternalFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public InternalFrame[] newArray(int i10) {
            return new InternalFrame[i10];
        }
    }

    public InternalFrame(String str, String str2, String str3) {
        super(f17305e);
        this.f17306b = str;
        this.f17307c = str2;
        this.f17308d = str3;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return u0.c(this.f17307c, internalFrame.f17307c) && u0.c(this.f17306b, internalFrame.f17306b) && u0.c(this.f17308d, internalFrame.f17308d);
    }

    public int hashCode() {
        String str = this.f17306b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17307c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17308d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": domain=" + this.f17306b + ", description=" + this.f17307c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17304a);
        parcel.writeString(this.f17306b);
        parcel.writeString(this.f17308d);
    }

    public InternalFrame(Parcel parcel) {
        super(f17305e);
        this.f17306b = (String) u0.k(parcel.readString());
        this.f17307c = (String) u0.k(parcel.readString());
        this.f17308d = (String) u0.k(parcel.readString());
    }
}
