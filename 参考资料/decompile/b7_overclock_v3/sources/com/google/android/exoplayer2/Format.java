package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import g.p0;
import gb.s;
import gb.y;
import hd.u0;
import hd.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new a();

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f16685k1 = -1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final long f16686v1 = Long.MAX_VALUE;
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public int K0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f16687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f16688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f16689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f16691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f16692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f16693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f16694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final String f16695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final Metadata f16696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final String f16697k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @p0
    public final Class<? extends s> f16698k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final String f16699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f16700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<byte[]> f16701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public final DrmInitData f16702o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f16703p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f16704q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f16705r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f16706s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f16707t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f16708u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public final byte[] f16709v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f16710w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public final ColorInfo f16711x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f16712y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f16713z;

    public class a implements Parcelable.Creator<Format> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Format[] newArray(int i10) {
            return new Format[i10];
        }
    }

    public static final class b {
        public int A;
        public int B;
        public int C;

        @p0
        public Class<? extends s> D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public String f16714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public String f16715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public String f16716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f16719f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f16720g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public String f16721h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public Metadata f16722i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public String f16723j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @p0
        public String f16724k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f16725l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @p0
        public List<byte[]> f16726m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @p0
        public DrmInitData f16727n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f16728o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f16729p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f16730q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f16731r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f16732s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f16733t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @p0
        public byte[] f16734u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f16735v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @p0
        public ColorInfo f16736w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f16737x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f16738y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f16739z;

        public /* synthetic */ b(Format format, a aVar) {
            this(format);
        }

        public Format E() {
            return new Format(this, null);
        }

        public b F(int i10) {
            this.C = i10;
            return this;
        }

        public b G(int i10) {
            this.f16719f = i10;
            return this;
        }

        public b H(int i10) {
            this.f16737x = i10;
            return this;
        }

        public b I(@p0 String str) {
            this.f16721h = str;
            return this;
        }

        public b J(@p0 ColorInfo colorInfo) {
            this.f16736w = colorInfo;
            return this;
        }

        public b K(@p0 String str) {
            this.f16723j = str;
            return this;
        }

        public b L(@p0 DrmInitData drmInitData) {
            this.f16727n = drmInitData;
            return this;
        }

        public b M(int i10) {
            this.A = i10;
            return this;
        }

        public b N(int i10) {
            this.B = i10;
            return this;
        }

        public b O(@p0 Class<? extends s> cls) {
            this.D = cls;
            return this;
        }

        public b P(float f10) {
            this.f16731r = f10;
            return this;
        }

        public b Q(int i10) {
            this.f16730q = i10;
            return this;
        }

        public b R(int i10) {
            this.f16714a = Integer.toString(i10);
            return this;
        }

        public b S(@p0 String str) {
            this.f16714a = str;
            return this;
        }

        public b T(@p0 List<byte[]> list) {
            this.f16726m = list;
            return this;
        }

        public b U(@p0 String str) {
            this.f16715b = str;
            return this;
        }

        public b V(@p0 String str) {
            this.f16716c = str;
            return this;
        }

        public b W(int i10) {
            this.f16725l = i10;
            return this;
        }

        public b X(@p0 Metadata metadata) {
            this.f16722i = metadata;
            return this;
        }

        public b Y(int i10) {
            this.f16739z = i10;
            return this;
        }

        public b Z(int i10) {
            this.f16720g = i10;
            return this;
        }

        public b a0(float f10) {
            this.f16733t = f10;
            return this;
        }

        public b b0(@p0 byte[] bArr) {
            this.f16734u = bArr;
            return this;
        }

        public b c0(int i10) {
            this.f16718e = i10;
            return this;
        }

        public b d0(int i10) {
            this.f16732s = i10;
            return this;
        }

        public b e0(@p0 String str) {
            this.f16724k = str;
            return this;
        }

        public b f0(int i10) {
            this.f16738y = i10;
            return this;
        }

        public b g0(int i10) {
            this.f16717d = i10;
            return this;
        }

        public b h0(int i10) {
            this.f16735v = i10;
            return this;
        }

        public b i0(long j10) {
            this.f16728o = j10;
            return this;
        }

        public b j0(int i10) {
            this.f16729p = i10;
            return this;
        }

        public b() {
            this.f16719f = -1;
            this.f16720g = -1;
            this.f16725l = -1;
            this.f16728o = Long.MAX_VALUE;
            this.f16729p = -1;
            this.f16730q = -1;
            this.f16731r = -1.0f;
            this.f16733t = 1.0f;
            this.f16735v = -1;
            this.f16737x = -1;
            this.f16738y = -1;
            this.f16739z = -1;
            this.C = -1;
        }

        public b(Format format) {
            this.f16714a = format.f16687a;
            this.f16715b = format.f16688b;
            this.f16716c = format.f16689c;
            this.f16717d = format.f16690d;
            this.f16718e = format.f16691e;
            this.f16719f = format.f16692f;
            this.f16720g = format.f16693g;
            this.f16721h = format.f16695i;
            this.f16722i = format.f16696j;
            this.f16723j = format.f16697k;
            this.f16724k = format.f16699l;
            this.f16725l = format.f16700m;
            this.f16726m = format.f16701n;
            this.f16727n = format.f16702o;
            this.f16728o = format.f16703p;
            this.f16729p = format.f16704q;
            this.f16730q = format.f16705r;
            this.f16731r = format.f16706s;
            this.f16732s = format.f16707t;
            this.f16733t = format.f16708u;
            this.f16734u = format.f16709v;
            this.f16735v = format.f16710w;
            this.f16736w = format.f16711x;
            this.f16737x = format.f16712y;
            this.f16738y = format.f16713z;
            this.f16739z = format.A;
            this.A = format.B;
            this.B = format.C;
            this.C = format.D;
            this.D = format.f16698k0;
        }
    }

    public /* synthetic */ Format(b bVar, a aVar) {
        this(bVar);
    }

    @Deprecated
    public static Format U(@p0 String str, @p0 String str2, @p0 String str3, @p0 String str4, @p0 String str5, @p0 Metadata metadata, int i10, int i11, int i12, @p0 List<byte[]> list, int i13, int i14, @p0 String str6) {
        return new b().S(str).U(str2).V(str6).g0(i13).c0(i14).G(i10).Z(i10).I(str5).X(metadata).K(str3).e0(str4).T(list).H(i11).f0(i12).E();
    }

    @Deprecated
    public static Format V(@p0 String str, @p0 String str2, @p0 String str3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, @p0 List<byte[]> list, @p0 DrmInitData drmInitData, int i17, @p0 String str4, @p0 Metadata metadata) {
        return new b().S(str).V(str4).g0(i17).G(i10).Z(i10).I(str3).X(metadata).e0(str2).W(i11).T(list).L(drmInitData).H(i12).f0(i13).Y(i14).M(i15).N(i16).E();
    }

    @Deprecated
    public static Format W(@p0 String str, @p0 String str2, @p0 String str3, int i10, int i11, int i12, int i13, int i14, @p0 List<byte[]> list, @p0 DrmInitData drmInitData, int i15, @p0 String str4) {
        return new b().S(str).V(str4).g0(i15).G(i10).Z(i10).I(str3).e0(str2).W(i11).T(list).L(drmInitData).H(i12).f0(i13).Y(i14).E();
    }

    @Deprecated
    public static Format X(@p0 String str, @p0 String str2, @p0 String str3, int i10, int i11, int i12, int i13, @p0 List<byte[]> list, @p0 DrmInitData drmInitData, int i14, @p0 String str4) {
        return new b().S(str).V(str4).g0(i14).G(i10).Z(i10).I(str3).e0(str2).W(i11).T(list).L(drmInitData).H(i12).f0(i13).E();
    }

    @Deprecated
    public static Format Y(@p0 String str, @p0 String str2, @p0 String str3, @p0 String str4, @p0 String str5, int i10, int i11, int i12, @p0 String str6) {
        return new b().S(str).U(str2).V(str6).g0(i11).c0(i12).G(i10).Z(i10).I(str5).K(str3).e0(str4).E();
    }

    @Deprecated
    public static Format Z(@p0 String str, @p0 String str2, int i10, @p0 List<byte[]> list, @p0 String str3) {
        return new b().S(str).V(str3).g0(i10).e0(str2).T(list).E();
    }

    @Deprecated
    public static Format a0(@p0 String str, @p0 String str2) {
        return new b().S(str).e0(str2).E();
    }

    @Deprecated
    public static Format b0(@p0 String str, @p0 String str2, @p0 String str3, @p0 String str4, @p0 String str5, int i10, int i11, int i12, @p0 String str6) {
        return new b().S(str).U(str2).V(str6).g0(i11).c0(i12).G(i10).Z(i10).I(str5).K(str3).e0(str4).E();
    }

    @Deprecated
    public static Format c0(@p0 String str, @p0 String str2, @p0 String str3, @p0 String str4, @p0 String str5, int i10, int i11, int i12, @p0 String str6, int i13) {
        return new b().S(str).U(str2).V(str6).g0(i11).c0(i12).G(i10).Z(i10).I(str5).K(str3).e0(str4).F(i13).E();
    }

    @Deprecated
    public static Format d0(@p0 String str, @p0 String str2, int i10, @p0 String str3) {
        return new b().S(str).V(str3).g0(i10).e0(str2).E();
    }

    @Deprecated
    public static Format e0(@p0 String str, @p0 String str2, int i10, @p0 String str3, int i11, long j10, @p0 List<byte[]> list) {
        return new b().S(str).V(str3).g0(i10).e0(str2).T(list).i0(j10).F(i11).E();
    }

    @Deprecated
    public static Format f0(@p0 String str, @p0 String str2, @p0 String str3, @p0 String str4, @p0 String str5, @p0 Metadata metadata, int i10, int i11, int i12, float f10, @p0 List<byte[]> list, int i13, int i14) {
        return new b().S(str).U(str2).g0(i13).c0(i14).G(i10).Z(i10).I(str5).X(metadata).K(str3).e0(str4).T(list).j0(i11).Q(i12).P(f10).E();
    }

    @Deprecated
    public static Format g0(@p0 String str, @p0 String str2, @p0 String str3, int i10, int i11, int i12, int i13, float f10, @p0 List<byte[]> list, int i14, float f11, @p0 DrmInitData drmInitData) {
        return new b().S(str).G(i10).Z(i10).I(str3).e0(str2).W(i11).T(list).L(drmInitData).j0(i12).Q(i13).P(f10).d0(i14).a0(f11).E();
    }

    @Deprecated
    public static Format h0(@p0 String str, @p0 String str2, @p0 String str3, int i10, int i11, int i12, int i13, float f10, @p0 List<byte[]> list, int i14, float f11, @p0 byte[] bArr, int i15, @p0 ColorInfo colorInfo, @p0 DrmInitData drmInitData) {
        return new b().S(str).G(i10).Z(i10).I(str3).e0(str2).W(i11).T(list).L(drmInitData).j0(i12).Q(i13).P(f10).d0(i14).a0(f11).b0(bArr).h0(i15).J(colorInfo).E();
    }

    @Deprecated
    public static Format i0(@p0 String str, @p0 String str2, @p0 String str3, int i10, int i11, int i12, int i13, float f10, @p0 List<byte[]> list, @p0 DrmInitData drmInitData) {
        return new b().S(str).G(i10).Z(i10).I(str3).e0(str2).W(i11).T(list).L(drmInitData).j0(i12).Q(i13).P(f10).E();
    }

    public static String l0(@p0 Format format) {
        if (format == null) {
            return i0.f11859x;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(format.f16687a);
        sb2.append(", mimeType=");
        sb2.append(format.f16699l);
        if (format.f16694h != -1) {
            sb2.append(", bitrate=");
            sb2.append(format.f16694h);
        }
        if (format.f16695i != null) {
            sb2.append(", codecs=");
            sb2.append(format.f16695i);
        }
        if (format.f16704q != -1 && format.f16705r != -1) {
            sb2.append(", res=");
            sb2.append(format.f16704q);
            sb2.append("x");
            sb2.append(format.f16705r);
        }
        if (format.f16706s != -1.0f) {
            sb2.append(", fps=");
            sb2.append(format.f16706s);
        }
        if (format.f16712y != -1) {
            sb2.append(", channels=");
            sb2.append(format.f16712y);
        }
        if (format.f16713z != -1) {
            sb2.append(", sample_rate=");
            sb2.append(format.f16713z);
        }
        if (format.f16689c != null) {
            sb2.append(", language=");
            sb2.append(format.f16689c);
        }
        if (format.f16688b != null) {
            sb2.append(", label=");
            sb2.append(format.f16688b);
        }
        return sb2.toString();
    }

    @Deprecated
    public Format C(Format format) {
        return m0(format);
    }

    @Deprecated
    public Format F(int i10) {
        return a().W(i10).E();
    }

    @Deprecated
    public Format M(@p0 Metadata metadata) {
        return a().X(metadata).E();
    }

    @Deprecated
    public Format S(long j10) {
        return a().i0(j10).E();
    }

    @Deprecated
    public Format T(int i10, int i11) {
        return a().j0(i10).Q(i11).E();
    }

    public b a() {
        return new b(this, null);
    }

    @Deprecated
    public Format b(int i10) {
        return a().G(i10).Z(i10).E();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Format e(@p0 DrmInitData drmInitData) {
        return a().L(drmInitData).E();
    }

    public boolean equals(@p0 Object obj) {
        int i10;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i11 = this.K0;
        return (i11 == 0 || (i10 = format.K0) == 0 || i11 == i10) && this.f16690d == format.f16690d && this.f16691e == format.f16691e && this.f16692f == format.f16692f && this.f16693g == format.f16693g && this.f16700m == format.f16700m && this.f16703p == format.f16703p && this.f16704q == format.f16704q && this.f16705r == format.f16705r && this.f16707t == format.f16707t && this.f16710w == format.f16710w && this.f16712y == format.f16712y && this.f16713z == format.f16713z && this.A == format.A && this.B == format.B && this.C == format.C && this.D == format.D && Float.compare(this.f16706s, format.f16706s) == 0 && Float.compare(this.f16708u, format.f16708u) == 0 && u0.c(this.f16698k0, format.f16698k0) && u0.c(this.f16687a, format.f16687a) && u0.c(this.f16688b, format.f16688b) && u0.c(this.f16695i, format.f16695i) && u0.c(this.f16697k, format.f16697k) && u0.c(this.f16699l, format.f16699l) && u0.c(this.f16689c, format.f16689c) && Arrays.equals(this.f16709v, format.f16709v) && u0.c(this.f16696j, format.f16696j) && u0.c(this.f16711x, format.f16711x) && u0.c(this.f16702o, format.f16702o) && k0(format);
    }

    public Format g(@p0 Class<? extends s> cls) {
        return a().O(cls).E();
    }

    public int hashCode() {
        if (this.K0 == 0) {
            String str = this.f16687a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f16688b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f16689c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f16690d) * 31) + this.f16691e) * 31) + this.f16692f) * 31) + this.f16693g) * 31;
            String str4 = this.f16695i;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f16696j;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f16697k;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f16699l;
            int iHashCode7 = (((((((((((((((((((((((((((((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.f16700m) * 31) + ((int) this.f16703p)) * 31) + this.f16704q) * 31) + this.f16705r) * 31) + Float.floatToIntBits(this.f16706s)) * 31) + this.f16707t) * 31) + Float.floatToIntBits(this.f16708u)) * 31) + this.f16710w) * 31) + this.f16712y) * 31) + this.f16713z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31;
            Class<? extends s> cls = this.f16698k0;
            this.K0 = iHashCode7 + (cls != null ? cls.hashCode() : 0);
        }
        return this.K0;
    }

    @Deprecated
    public Format j(float f10) {
        return a().P(f10).E();
    }

    public int j0() {
        int i10;
        int i11 = this.f16704q;
        if (i11 == -1 || (i10 = this.f16705r) == -1) {
            return -1;
        }
        return i11 * i10;
    }

    public boolean k0(Format format) {
        if (this.f16701n.size() != format.f16701n.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f16701n.size(); i10++) {
            if (!Arrays.equals(this.f16701n.get(i10), format.f16701n.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public Format m0(Format format) {
        String str;
        if (this == format) {
            return this;
        }
        int iL = w.l(this.f16699l);
        String str2 = format.f16687a;
        String str3 = format.f16688b;
        if (str3 == null) {
            str3 = this.f16688b;
        }
        String str4 = this.f16689c;
        if ((iL == 3 || iL == 1) && (str = format.f16689c) != null) {
            str4 = str;
        }
        int i10 = this.f16692f;
        if (i10 == -1) {
            i10 = format.f16692f;
        }
        int i11 = this.f16693g;
        if (i11 == -1) {
            i11 = format.f16693g;
        }
        String str5 = this.f16695i;
        if (str5 == null) {
            String strS = u0.S(format.f16695i, iL);
            if (u0.p1(strS).length == 1) {
                str5 = strS;
            }
        }
        Metadata metadata = this.f16696j;
        Metadata metadataB = metadata == null ? format.f16696j : metadata.b(format.f16696j);
        float f10 = this.f16706s;
        if (f10 == -1.0f && iL == 2) {
            f10 = format.f16706s;
        }
        return a().S(str2).U(str3).V(str4).g0(this.f16690d | format.f16690d).c0(this.f16691e | format.f16691e).G(i10).Z(i11).I(str5).X(metadataB).L(DrmInitData.g(format.f16702o, this.f16702o)).P(f10).E();
    }

    @Deprecated
    public Format s(int i10, int i11) {
        return a().M(i10).N(i11).E();
    }

    public String toString() {
        return "Format(" + this.f16687a + ", " + this.f16688b + ", " + this.f16697k + ", " + this.f16699l + ", " + this.f16695i + ", " + this.f16694h + ", " + this.f16689c + ", [" + this.f16704q + ", " + this.f16705r + ", " + this.f16706s + "], [" + this.f16712y + ", " + this.f16713z + "])";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f16687a);
        parcel.writeString(this.f16688b);
        parcel.writeString(this.f16689c);
        parcel.writeInt(this.f16690d);
        parcel.writeInt(this.f16691e);
        parcel.writeInt(this.f16692f);
        parcel.writeInt(this.f16693g);
        parcel.writeString(this.f16695i);
        parcel.writeParcelable(this.f16696j, 0);
        parcel.writeString(this.f16697k);
        parcel.writeString(this.f16699l);
        parcel.writeInt(this.f16700m);
        int size = this.f16701n.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeByteArray(this.f16701n.get(i11));
        }
        parcel.writeParcelable(this.f16702o, 0);
        parcel.writeLong(this.f16703p);
        parcel.writeInt(this.f16704q);
        parcel.writeInt(this.f16705r);
        parcel.writeFloat(this.f16706s);
        parcel.writeInt(this.f16707t);
        parcel.writeFloat(this.f16708u);
        u0.B1(parcel, this.f16709v != null);
        byte[] bArr = this.f16709v;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f16710w);
        parcel.writeParcelable(this.f16711x, i10);
        parcel.writeInt(this.f16712y);
        parcel.writeInt(this.f16713z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
    }

    @Deprecated
    public Format z(@p0 String str) {
        return a().U(str).E();
    }

    public Format(b bVar) {
        this.f16687a = bVar.f16714a;
        this.f16688b = bVar.f16715b;
        this.f16689c = u0.S0(bVar.f16716c);
        this.f16690d = bVar.f16717d;
        this.f16691e = bVar.f16718e;
        int i10 = bVar.f16719f;
        this.f16692f = i10;
        int i11 = bVar.f16720g;
        this.f16693g = i11;
        this.f16694h = i11 != -1 ? i11 : i10;
        this.f16695i = bVar.f16721h;
        this.f16696j = bVar.f16722i;
        this.f16697k = bVar.f16723j;
        this.f16699l = bVar.f16724k;
        this.f16700m = bVar.f16725l;
        this.f16701n = bVar.f16726m == null ? Collections.emptyList() : bVar.f16726m;
        DrmInitData drmInitData = bVar.f16727n;
        this.f16702o = drmInitData;
        this.f16703p = bVar.f16728o;
        this.f16704q = bVar.f16729p;
        this.f16705r = bVar.f16730q;
        this.f16706s = bVar.f16731r;
        this.f16707t = bVar.f16732s == -1 ? 0 : bVar.f16732s;
        this.f16708u = bVar.f16733t == -1.0f ? 1.0f : bVar.f16733t;
        this.f16709v = bVar.f16734u;
        this.f16710w = bVar.f16735v;
        this.f16711x = bVar.f16736w;
        this.f16712y = bVar.f16737x;
        this.f16713z = bVar.f16738y;
        this.A = bVar.f16739z;
        this.B = bVar.A == -1 ? 0 : bVar.A;
        this.C = bVar.B != -1 ? bVar.B : 0;
        this.D = bVar.C;
        if (bVar.D != null || drmInitData == null) {
            this.f16698k0 = bVar.D;
        } else {
            this.f16698k0 = y.class;
        }
    }

    public Format(Parcel parcel) {
        this.f16687a = parcel.readString();
        this.f16688b = parcel.readString();
        this.f16689c = parcel.readString();
        this.f16690d = parcel.readInt();
        this.f16691e = parcel.readInt();
        int i10 = parcel.readInt();
        this.f16692f = i10;
        int i11 = parcel.readInt();
        this.f16693g = i11;
        this.f16694h = i11 != -1 ? i11 : i10;
        this.f16695i = parcel.readString();
        this.f16696j = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.f16697k = parcel.readString();
        this.f16699l = parcel.readString();
        this.f16700m = parcel.readInt();
        int i12 = parcel.readInt();
        this.f16701n = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            this.f16701n.add((byte[]) hd.a.g(parcel.createByteArray()));
        }
        DrmInitData drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.f16702o = drmInitData;
        this.f16703p = parcel.readLong();
        this.f16704q = parcel.readInt();
        this.f16705r = parcel.readInt();
        this.f16706s = parcel.readFloat();
        this.f16707t = parcel.readInt();
        this.f16708u = parcel.readFloat();
        this.f16709v = u0.b1(parcel) ? parcel.createByteArray() : null;
        this.f16710w = parcel.readInt();
        this.f16711x = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.f16712y = parcel.readInt();
        this.f16713z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.f16698k0 = drmInitData != null ? y.class : null;
    }
}
