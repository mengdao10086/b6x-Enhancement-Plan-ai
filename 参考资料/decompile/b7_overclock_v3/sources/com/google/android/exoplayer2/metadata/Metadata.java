package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Entry[] f17218a;

    public interface Entry extends Parcelable {
        @p0
        byte[] O();

        @p0
        Format n();
    }

    public class a implements Parcelable.Creator<Metadata> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Metadata[] newArray(int i10) {
            return new Metadata[i10];
        }
    }

    public Metadata(Entry... entryArr) {
        this.f17218a = entryArr;
    }

    public Metadata a(Entry... entryArr) {
        return entryArr.length == 0 ? this : new Metadata((Entry[]) u0.U0(this.f17218a, entryArr));
    }

    public Metadata b(@p0 Metadata metadata) {
        return metadata == null ? this : a(metadata.f17218a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Entry e(int i10) {
        return this.f17218a[i10];
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f17218a, ((Metadata) obj).f17218a);
    }

    public int g() {
        return this.f17218a.length;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f17218a);
    }

    public String toString() {
        return "entries=" + Arrays.toString(this.f17218a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17218a.length);
        for (Entry entry : this.f17218a) {
            parcel.writeParcelable(entry, 0);
        }
    }

    public Metadata(List<? extends Entry> list) {
        this.f17218a = (Entry[]) list.toArray(new Entry[0]);
    }

    public Metadata(Parcel parcel) {
        this.f17218a = new Entry[parcel.readInt()];
        int i10 = 0;
        while (true) {
            Entry[] entryArr = this.f17218a;
            if (i10 >= entryArr.length) {
                return;
            }
            entryArr[i10] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
            i10++;
        }
    }
}
