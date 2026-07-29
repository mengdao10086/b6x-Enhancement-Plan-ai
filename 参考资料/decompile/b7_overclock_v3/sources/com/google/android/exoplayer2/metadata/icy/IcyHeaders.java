package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import hd.t;
import hd.u0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f17258g = "Icy-MetaData";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f17259h = "1";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f17260i = "IcyHeaders";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f17261j = "icy-br";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f17262k = "icy-genre";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f17263l = "icy-name";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f17264m = "icy-url";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f17265n = "icy-pub";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f17266o = "icy-metaint";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f17268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f17269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final String f17270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17272f;

    public class a implements Parcelable.Creator<IcyHeaders> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IcyHeaders[] newArray(int i10) {
            return new IcyHeaders[i10];
        }
    }

    public IcyHeaders(int i10, @p0 String str, @p0 String str2, @p0 String str3, boolean z10, int i11) {
        hd.a.a(i11 == -1 || i11 > 0);
        this.f17267a = i10;
        this.f17268b = str;
        this.f17269c = str2;
        this.f17270d = str3;
        this.f17271e = z10;
        this.f17272f = i11;
    }

    @p0
    public static IcyHeaders a(Map<String, List<String>> map) {
        boolean z10;
        int i10;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i11;
        List<String> list = map.get(f17261j);
        int i12 = -1;
        boolean z11 = true;
        if (list != null) {
            String str4 = list.get(0);
            try {
                i11 = Integer.parseInt(str4) * 1000;
                if (i11 > 0) {
                    z10 = true;
                } else {
                    try {
                        t.n(f17260i, "Invalid bitrate: " + str4);
                        z10 = false;
                        i11 = -1;
                    } catch (NumberFormatException unused) {
                        t.n(f17260i, "Invalid bitrate header: " + str4);
                        i10 = i11;
                        z10 = false;
                    }
                }
                i10 = i11;
            } catch (NumberFormatException unused2) {
                i11 = -1;
            }
        } else {
            z10 = false;
            i10 = -1;
        }
        List<String> list2 = map.get(f17262k);
        if (list2 != null) {
            str = list2.get(0);
            z10 = true;
        } else {
            str = null;
        }
        List<String> list3 = map.get(f17263l);
        if (list3 != null) {
            str2 = list3.get(0);
            z10 = true;
        } else {
            str2 = null;
        }
        List<String> list4 = map.get(f17264m);
        if (list4 != null) {
            str3 = list4.get(0);
            z10 = true;
        } else {
            str3 = null;
        }
        List<String> list5 = map.get(f17265n);
        if (list5 != null) {
            zEquals = list5.get(0).equals("1");
            z10 = true;
        } else {
            zEquals = false;
        }
        List<String> list6 = map.get(f17266o);
        if (list6 != null) {
            String str5 = list6.get(0);
            try {
                int i13 = Integer.parseInt(str5);
                if (i13 > 0) {
                    i12 = i13;
                } else {
                    try {
                        t.n(f17260i, "Invalid metadata interval: " + str5);
                        z11 = z10;
                    } catch (NumberFormatException unused3) {
                        i12 = i13;
                        t.n(f17260i, "Invalid metadata interval: " + str5);
                    }
                }
                z10 = z11;
            } catch (NumberFormatException unused4) {
            }
        }
        if (z10) {
            return new IcyHeaders(i10, str, str2, str3, zEquals, i12);
        }
        return null;
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
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.f17267a == icyHeaders.f17267a && u0.c(this.f17268b, icyHeaders.f17268b) && u0.c(this.f17269c, icyHeaders.f17269c) && u0.c(this.f17270d, icyHeaders.f17270d) && this.f17271e == icyHeaders.f17271e && this.f17272f == icyHeaders.f17272f;
    }

    public int hashCode() {
        int i10 = (527 + this.f17267a) * 31;
        String str = this.f17268b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17269c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17270d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f17271e ? 1 : 0)) * 31) + this.f17272f;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f17269c + "\", genre=\"" + this.f17268b + "\", bitrate=" + this.f17267a + ", metadataInterval=" + this.f17272f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17267a);
        parcel.writeString(this.f17268b);
        parcel.writeString(this.f17269c);
        parcel.writeString(this.f17270d);
        u0.B1(parcel, this.f17271e);
        parcel.writeInt(this.f17272f);
    }

    public IcyHeaders(Parcel parcel) {
        this.f17267a = parcel.readInt();
        this.f17268b = parcel.readString();
        this.f17269c = parcel.readString();
        this.f17270d = parcel.readString();
        this.f17271e = u0.b1(parcel);
        this.f17272f = parcel.readInt();
    }
}
