package a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ak implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Parcelable f83a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ak f5615a = new yj();
    public static final Parcelable.Creator<ak> CREATOR = new zj();

    public ak() {
        this.f83a = null;
    }

    public /* synthetic */ ak(yj yjVar) {
        this();
    }

    public ak(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f83a = parcelable == null ? f5615a : parcelable;
    }

    public ak(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f83a = parcelable == f5615a ? null : parcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Parcelable q() {
        return this.f83a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f83a, i);
    }
}
