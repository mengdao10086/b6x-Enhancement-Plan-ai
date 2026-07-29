package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.i1;
import g.p0;
import hd.u0;
import hd.w;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class EventMessage implements Metadata.Entry {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @i1
    public static final String f17237g = "https://aomedia.org/emsg/ID3";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f17238h = "https://developer.apple.com/streaming/emsg-id3";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @i1
    public static final String f17239i = "urn:scte:scte35:2014:bin";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f17246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17247f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Format f17240j = new Format.b().e0(w.f31193k0).E();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Format f17241k = new Format.b().e0(w.f31215v0).E();
    public static final Parcelable.Creator<EventMessage> CREATOR = new a();

    public class a implements Parcelable.Creator<EventMessage> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EventMessage[] newArray(int i10) {
            return new EventMessage[i10];
        }
    }

    public EventMessage(String str, String str2, long j10, long j11, byte[] bArr) {
        this.f17242a = str;
        this.f17243b = str2;
        this.f17244c = j10;
        this.f17245d = j11;
        this.f17246e = bArr;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @p0
    public byte[] O() {
        if (n() != null) {
            return this.f17246e;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.f17244c == eventMessage.f17244c && this.f17245d == eventMessage.f17245d && u0.c(this.f17242a, eventMessage.f17242a) && u0.c(this.f17243b, eventMessage.f17243b) && Arrays.equals(this.f17246e, eventMessage.f17246e);
    }

    public int hashCode() {
        if (this.f17247f == 0) {
            String str = this.f17242a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f17243b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j10 = this.f17244c;
            int i10 = (((iHashCode + iHashCode2) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f17245d;
            this.f17247f = ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f17246e);
        }
        return this.f17247f;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @p0
    public Format n() {
        String str = this.f17242a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f17241k;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f17240j;
            default:
                return null;
        }
    }

    public String toString() {
        return "EMSG: scheme=" + this.f17242a + ", id=" + this.f17245d + ", durationMs=" + this.f17244c + ", value=" + this.f17243b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17242a);
        parcel.writeString(this.f17243b);
        parcel.writeLong(this.f17244c);
        parcel.writeLong(this.f17245d);
        parcel.writeByteArray(this.f17246e);
    }

    public EventMessage(Parcel parcel) {
        this.f17242a = (String) u0.k(parcel.readString());
        this.f17243b = (String) u0.k(parcel.readString());
        this.f17244c = parcel.readLong();
        this.f17245d = parcel.readLong();
        this.f17246e = (byte[]) u0.k(parcel.createByteArray());
    }
}
