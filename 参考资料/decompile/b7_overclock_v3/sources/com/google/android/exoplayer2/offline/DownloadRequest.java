package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.collect.ImmutableList;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f17408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f17409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<StreamKey> f17410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final byte[] f17411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public final String f17412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f17413g;

    public static class UnsupportedRequestException extends IOException {
    }

    public class a implements Parcelable.Creator<DownloadRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadRequest[] newArray(int i10) {
            return new DownloadRequest[i10];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f17415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public String f17416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public List<StreamKey> f17417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public byte[] f17418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public String f17419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public byte[] f17420g;

        public b(String str, Uri uri) {
            this.f17414a = str;
            this.f17415b = uri;
        }

        public DownloadRequest a() {
            String str = this.f17414a;
            Uri uri = this.f17415b;
            String str2 = this.f17416c;
            List listOf = this.f17417d;
            if (listOf == null) {
                listOf = ImmutableList.of();
            }
            return new DownloadRequest(str, uri, str2, listOf, this.f17418e, this.f17419f, this.f17420g, null);
        }

        public b b(@p0 String str) {
            this.f17419f = str;
            return this;
        }

        public b c(@p0 byte[] bArr) {
            this.f17420g = bArr;
            return this;
        }

        public b d(@p0 byte[] bArr) {
            this.f17418e = bArr;
            return this;
        }

        public b e(@p0 String str) {
            this.f17416c = str;
            return this;
        }

        public b f(@p0 List<StreamKey> list) {
            this.f17417d = list;
            return this;
        }
    }

    public /* synthetic */ DownloadRequest(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2, a aVar) {
        this(str, uri, str2, list, bArr, str3, bArr2);
    }

    public DownloadRequest a(String str) {
        return new DownloadRequest(str, this.f17408b, this.f17409c, this.f17410d, this.f17411e, this.f17412f, this.f17413g);
    }

    public DownloadRequest b(@p0 byte[] bArr) {
        return new DownloadRequest(this.f17407a, this.f17408b, this.f17409c, this.f17410d, bArr, this.f17412f, this.f17413g);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DownloadRequest e(DownloadRequest downloadRequest) {
        List listEmptyList;
        hd.a.a(this.f17407a.equals(downloadRequest.f17407a));
        if (this.f17410d.isEmpty() || downloadRequest.f17410d.isEmpty()) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = new ArrayList(this.f17410d);
            for (int i10 = 0; i10 < downloadRequest.f17410d.size(); i10++) {
                StreamKey streamKey = downloadRequest.f17410d.get(i10);
                if (!listEmptyList.contains(streamKey)) {
                    listEmptyList.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f17407a, downloadRequest.f17408b, downloadRequest.f17409c, listEmptyList, downloadRequest.f17411e, downloadRequest.f17412f, downloadRequest.f17413g);
    }

    public boolean equals(@p0 Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.f17407a.equals(downloadRequest.f17407a) && this.f17408b.equals(downloadRequest.f17408b) && u0.c(this.f17409c, downloadRequest.f17409c) && this.f17410d.equals(downloadRequest.f17410d) && Arrays.equals(this.f17411e, downloadRequest.f17411e) && u0.c(this.f17412f, downloadRequest.f17412f) && Arrays.equals(this.f17413g, downloadRequest.f17413g);
    }

    public v0 g() {
        return new v0.c().z(this.f17407a).F(this.f17408b).j(this.f17412f).B(this.f17409c).C(this.f17410d).l(this.f17411e).a();
    }

    public final int hashCode() {
        int iHashCode = ((this.f17407a.hashCode() * 31 * 31) + this.f17408b.hashCode()) * 31;
        String str = this.f17409c;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f17410d.hashCode()) * 31) + Arrays.hashCode(this.f17411e)) * 31;
        String str2 = this.f17412f;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f17413g);
    }

    public String toString() {
        return this.f17409c + ":" + this.f17407a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17407a);
        parcel.writeString(this.f17408b.toString());
        parcel.writeString(this.f17409c);
        parcel.writeInt(this.f17410d.size());
        for (int i11 = 0; i11 < this.f17410d.size(); i11++) {
            parcel.writeParcelable(this.f17410d.get(i11), 0);
        }
        parcel.writeByteArray(this.f17411e);
        parcel.writeString(this.f17412f);
        parcel.writeByteArray(this.f17413g);
    }

    public DownloadRequest(String str, Uri uri, @p0 String str2, List<StreamKey> list, @p0 byte[] bArr, @p0 String str3, @p0 byte[] bArr2) {
        int iB0 = u0.B0(uri, str2);
        if (iB0 == 0 || iB0 == 2 || iB0 == 1) {
            hd.a.b(str3 == null, "customCacheKey must be null for type: " + iB0);
        }
        this.f17407a = str;
        this.f17408b = uri;
        this.f17409c = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.f17410d = Collections.unmodifiableList(arrayList);
        this.f17411e = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.f17412f = str3;
        this.f17413g = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : u0.f31159f;
    }

    public DownloadRequest(Parcel parcel) {
        this.f17407a = (String) u0.k(parcel.readString());
        this.f17408b = Uri.parse((String) u0.k(parcel.readString()));
        this.f17409c = parcel.readString();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.f17410d = Collections.unmodifiableList(arrayList);
        this.f17411e = parcel.createByteArray();
        this.f17412f = parcel.readString();
        this.f17413g = (byte[]) u0.k(parcel.createByteArray());
    }
}
