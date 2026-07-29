package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1175e;

    public class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(int i10, int i11, int i12, int i13, int i14) {
        this.f1171a = i10;
        this.f1172b = i11;
        this.f1173c = i12;
        this.f1174d = i13;
        this.f1175e = i14;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f1171a);
        parcel.writeInt(this.f1173c);
        parcel.writeInt(this.f1174d);
        parcel.writeInt(this.f1175e);
        parcel.writeInt(this.f1172b);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f1171a = parcel.readInt();
        this.f1173c = parcel.readInt();
        this.f1174d = parcel.readInt();
        this.f1175e = parcel.readInt();
        this.f1172b = parcel.readInt();
    }
}
