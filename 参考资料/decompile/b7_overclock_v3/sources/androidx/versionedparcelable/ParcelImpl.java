package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import i2.d;
import i2.e;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f8037a;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i10) {
            return new ParcelImpl[i10];
        }
    }

    public ParcelImpl(e eVar) {
        this.f8037a = eVar;
    }

    public <T extends e> T a() {
        return (T) this.f8037a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        new d(parcel).l1(this.f8037a);
    }

    public ParcelImpl(Parcel parcel) {
        this.f8037a = new d(parcel).g0();
    }
}
