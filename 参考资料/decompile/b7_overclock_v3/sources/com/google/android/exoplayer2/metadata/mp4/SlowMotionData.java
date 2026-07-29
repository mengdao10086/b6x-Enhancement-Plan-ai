package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SlowMotionData implements Metadata.Entry {
    public static final Parcelable.Creator<SlowMotionData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Segment> f17332a;

    public static final class Segment implements Parcelable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Comparator<Segment> f17333d = new Comparator() { // from class: ac.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SlowMotionData.Segment.b((SlowMotionData.Segment) obj, (SlowMotionData.Segment) obj2);
            }
        };
        public static final Parcelable.Creator<Segment> CREATOR = new a();

        public class a implements Parcelable.Creator<Segment> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Segment createFromParcel(Parcel parcel) {
                return new Segment(parcel.readLong(), parcel.readLong(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Segment[] newArray(int i10) {
                return new Segment[i10];
            }
        }

        public Segment(long j10, long j11, int i10) {
            hd.a.a(j10 < j11);
            this.f17334a = j10;
            this.f17335b = j11;
            this.f17336c = i10;
        }

        public static /* synthetic */ int b(Segment segment, Segment segment2) {
            return ComparisonChain.start().compare(segment.f17334a, segment2.f17334a).compare(segment.f17335b, segment2.f17335b).compare(segment.f17336c, segment2.f17336c).result();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Segment.class != obj.getClass()) {
                return false;
            }
            Segment segment = (Segment) obj;
            return this.f17334a == segment.f17334a && this.f17335b == segment.f17335b && this.f17336c == segment.f17336c;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f17334a), Long.valueOf(this.f17335b), Integer.valueOf(this.f17336c));
        }

        public String toString() {
            return u0.I("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f17334a), Long.valueOf(this.f17335b), Integer.valueOf(this.f17336c));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeLong(this.f17334a);
            parcel.writeLong(this.f17335b);
            parcel.writeInt(this.f17336c);
        }
    }

    public class a implements Parcelable.Creator<SlowMotionData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SlowMotionData createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Segment.class.getClassLoader());
            return new SlowMotionData(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SlowMotionData[] newArray(int i10) {
            return new SlowMotionData[i10];
        }
    }

    public SlowMotionData(List<Segment> list) {
        this.f17332a = list;
        hd.a.a(!a(list));
    }

    public static boolean a(List<Segment> list) {
        if (list.isEmpty()) {
            return false;
        }
        long j10 = list.get(0).f17335b;
        for (int i10 = 1; i10 < list.size(); i10++) {
            if (list.get(i10).f17334a < j10) {
                return true;
            }
            j10 = list.get(i10).f17335b;
        }
        return false;
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
        if (obj == null || SlowMotionData.class != obj.getClass()) {
            return false;
        }
        return this.f17332a.equals(((SlowMotionData) obj).f17332a);
    }

    public int hashCode() {
        return this.f17332a.hashCode();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f17332a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeList(this.f17332a);
    }
}
