package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import la.f;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class Entry extends f implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16638d;

    public static class a implements Parcelable.Creator<Entry> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Entry[] newArray(int i10) {
            return new Entry[i10];
        }
    }

    public Entry() {
        this.f16638d = 0.0f;
    }

    public boolean C(Entry entry) {
        if (entry == null || entry.a() != a()) {
            return false;
        }
        float fAbs = Math.abs(entry.f16638d - this.f16638d);
        float f10 = k.f55015g;
        return fAbs <= f10 && Math.abs(entry.e() - e()) <= f10;
    }

    public float F() {
        return this.f16638d;
    }

    public void M(float f10) {
        this.f16638d = f10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Entry, x: " + this.f16638d + " y: " + e();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f16638d);
        parcel.writeFloat(e());
        if (a() == null) {
            parcel.writeInt(0);
        } else {
            if (!(a() instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) a(), i10);
        }
    }

    public Entry z() {
        return new Entry(this.f16638d, e(), a());
    }

    public Entry(float f10, float f11) {
        super(f11);
        this.f16638d = f10;
    }

    public Entry(float f10, float f11, Object obj) {
        super(f11, obj);
        this.f16638d = f10;
    }

    public Entry(float f10, float f11, Drawable drawable) {
        super(f11, drawable);
        this.f16638d = f10;
    }

    public Entry(float f10, float f11, Drawable drawable, Object obj) {
        super(f11, drawable, obj);
        this.f16638d = f10;
    }

    public Entry(Parcel parcel) {
        this.f16638d = 0.0f;
        this.f16638d = parcel.readFloat();
        s(parcel.readFloat());
        if (parcel.readInt() == 1) {
            g(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
