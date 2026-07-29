package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SchemeData[] f17031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f17033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17034d;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UUID f17036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final String f17037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f17038d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public final byte[] f17039e;

        public class a implements Parcelable.Creator<SchemeData> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SchemeData[] newArray(int i10) {
                return new SchemeData[i10];
            }
        }

        public SchemeData(UUID uuid, String str, @p0 byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public boolean a(SchemeData schemeData) {
            return e() && !schemeData.e() && g(schemeData.f17036b);
        }

        public SchemeData b(@p0 byte[] bArr) {
            return new SchemeData(this.f17036b, this.f17037c, this.f17038d, bArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean e() {
            return this.f17039e != null;
        }

        public boolean equals(@p0 Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return u0.c(this.f17037c, schemeData.f17037c) && u0.c(this.f17038d, schemeData.f17038d) && u0.c(this.f17036b, schemeData.f17036b) && Arrays.equals(this.f17039e, schemeData.f17039e);
        }

        public boolean g(UUID uuid) {
            return ya.g.H1.equals(this.f17036b) || uuid.equals(this.f17036b);
        }

        public int hashCode() {
            if (this.f17035a == 0) {
                int iHashCode = this.f17036b.hashCode() * 31;
                String str = this.f17037c;
                this.f17035a = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f17038d.hashCode()) * 31) + Arrays.hashCode(this.f17039e);
            }
            return this.f17035a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f17036b.getMostSignificantBits());
            parcel.writeLong(this.f17036b.getLeastSignificantBits());
            parcel.writeString(this.f17037c);
            parcel.writeString(this.f17038d);
            parcel.writeByteArray(this.f17039e);
        }

        public SchemeData(UUID uuid, @p0 String str, String str2, @p0 byte[] bArr) {
            this.f17036b = (UUID) hd.a.g(uuid);
            this.f17037c = str;
            this.f17038d = (String) hd.a.g(str2);
            this.f17039e = bArr;
        }

        public SchemeData(Parcel parcel) {
            this.f17036b = new UUID(parcel.readLong(), parcel.readLong());
            this.f17037c = parcel.readString();
            this.f17038d = (String) u0.k(parcel.readString());
            this.f17039e = parcel.createByteArray();
        }
    }

    public class a implements Parcelable.Creator<DrmInitData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DrmInitData[] newArray(int i10) {
            return new DrmInitData[i10];
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public static boolean b(ArrayList<SchemeData> arrayList, int i10, UUID uuid) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (arrayList.get(i11).f17036b.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @p0
    public static DrmInitData g(@p0 DrmInitData drmInitData, @p0 DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f17033c;
            for (SchemeData schemeData : drmInitData.f17031a) {
                if (schemeData.e()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f17033c;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f17031a) {
                if (schemeData2.e() && !b(arrayList, size, schemeData2.f17036b)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, arrayList);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = ya.g.H1;
        return uuid.equals(schemeData.f17036b) ? uuid.equals(schemeData2.f17036b) ? 0 : 1 : schemeData.f17036b.compareTo(schemeData2.f17036b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DrmInitData e(@p0 String str) {
        return u0.c(this.f17033c, str) ? this : new DrmInitData(str, false, this.f17031a);
    }

    @Override // java.util.Comparator
    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return u0.c(this.f17033c, drmInitData.f17033c) && Arrays.equals(this.f17031a, drmInitData.f17031a);
    }

    public int hashCode() {
        if (this.f17032b == 0) {
            String str = this.f17033c;
            this.f17032b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f17031a);
        }
        return this.f17032b;
    }

    public SchemeData j(int i10) {
        return this.f17031a[i10];
    }

    public DrmInitData s(DrmInitData drmInitData) {
        String str;
        String str2 = this.f17033c;
        hd.a.i(str2 == null || (str = drmInitData.f17033c) == null || TextUtils.equals(str2, str));
        String str3 = this.f17033c;
        if (str3 == null) {
            str3 = drmInitData.f17033c;
        }
        return new DrmInitData(str3, (SchemeData[]) u0.U0(this.f17031a, drmInitData.f17031a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17033c);
        parcel.writeTypedArray(this.f17031a, 0);
    }

    public DrmInitData(@p0 String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(@p0 String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(@p0 String str, boolean z10, SchemeData... schemeDataArr) {
        this.f17033c = str;
        schemeDataArr = z10 ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.f17031a = schemeDataArr;
        this.f17034d = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    public DrmInitData(Parcel parcel) {
        this.f17033c = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) u0.k((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.f17031a = schemeDataArr;
        this.f17034d = schemeDataArr.length;
    }
}
