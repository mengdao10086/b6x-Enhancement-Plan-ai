package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f17806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f17807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<VariantInfo> f17808c;

    public class a implements Parcelable.Creator<HlsTrackMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public HlsTrackMetadataEntry[] newArray(int i10) {
            return new HlsTrackMetadataEntry[i10];
        }
    }

    public HlsTrackMetadataEntry(@p0 String str, @p0 String str2, List<VariantInfo> list) {
        this.f17806a = str;
        this.f17807b = str2;
        this.f17808c = Collections.unmodifiableList(new ArrayList(list));
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
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        return TextUtils.equals(this.f17806a, hlsTrackMetadataEntry.f17806a) && TextUtils.equals(this.f17807b, hlsTrackMetadataEntry.f17807b) && this.f17808c.equals(hlsTrackMetadataEntry.f17808c);
    }

    public int hashCode() {
        String str = this.f17806a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f17807b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f17808c.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HlsTrackMetadataEntry");
        if (this.f17806a != null) {
            str = " [" + this.f17806a + ", " + this.f17807b + "]";
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17806a);
        parcel.writeString(this.f17807b);
        int size = this.f17808c.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeParcelable(this.f17808c.get(i11), 0);
        }
    }

    public HlsTrackMetadataEntry(Parcel parcel) {
        this.f17806a = parcel.readString();
        this.f17807b = parcel.readString();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f17808c = Collections.unmodifiableList(arrayList);
    }

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final String f17811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final String f17812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public final String f17813e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public final String f17814f;

        public class a implements Parcelable.Creator<VariantInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public VariantInfo[] newArray(int i10) {
                return new VariantInfo[i10];
            }
        }

        public VariantInfo(int i10, int i11, @p0 String str, @p0 String str2, @p0 String str3, @p0 String str4) {
            this.f17809a = i10;
            this.f17810b = i11;
            this.f17811c = str;
            this.f17812d = str2;
            this.f17813e = str3;
            this.f17814f = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            return this.f17809a == variantInfo.f17809a && this.f17810b == variantInfo.f17810b && TextUtils.equals(this.f17811c, variantInfo.f17811c) && TextUtils.equals(this.f17812d, variantInfo.f17812d) && TextUtils.equals(this.f17813e, variantInfo.f17813e) && TextUtils.equals(this.f17814f, variantInfo.f17814f);
        }

        public int hashCode() {
            int i10 = ((this.f17809a * 31) + this.f17810b) * 31;
            String str = this.f17811c;
            int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f17812d;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f17813e;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f17814f;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f17809a);
            parcel.writeInt(this.f17810b);
            parcel.writeString(this.f17811c);
            parcel.writeString(this.f17812d);
            parcel.writeString(this.f17813e);
            parcel.writeString(this.f17814f);
        }

        public VariantInfo(Parcel parcel) {
            this.f17809a = parcel.readInt();
            this.f17810b = parcel.readInt();
            this.f17811c = parcel.readString();
            this.f17812d = parcel.readString();
            this.f17813e = parcel.readString();
            this.f17814f = parcel.readString();
        }
    }
}
