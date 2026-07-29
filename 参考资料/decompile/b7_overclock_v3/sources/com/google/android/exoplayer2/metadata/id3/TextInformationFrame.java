package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f17318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17319c;

    public class a implements Parcelable.Creator<TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TextInformationFrame[] newArray(int i10) {
            return new TextInformationFrame[i10];
        }
    }

    public TextInformationFrame(String str, @p0 String str2, String str3) {
        super(str);
        this.f17318b = str2;
        this.f17319c = str3;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return this.f17304a.equals(textInformationFrame.f17304a) && u0.c(this.f17318b, textInformationFrame.f17318b) && u0.c(this.f17319c, textInformationFrame.f17319c);
    }

    public int hashCode() {
        int iHashCode = (527 + this.f17304a.hashCode()) * 31;
        String str = this.f17318b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17319c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": description=" + this.f17318b + ": value=" + this.f17319c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17304a);
        parcel.writeString(this.f17318b);
        parcel.writeString(this.f17319c);
    }

    public TextInformationFrame(Parcel parcel) {
        super((String) u0.k(parcel.readString()));
        this.f17318b = parcel.readString();
        this.f17319c = (String) u0.k(parcel.readString());
    }
}
