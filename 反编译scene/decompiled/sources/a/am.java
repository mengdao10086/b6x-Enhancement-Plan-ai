package a;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class am implements Parcelable {
    public static final Parcelable.Creator<am> CREATOR = new zl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f85a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<fm> f86a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uk[] f87a;
    public ArrayList<String> b;

    public am() {
        this.f85a = null;
    }

    public am(Parcel parcel) {
        this.f85a = null;
        this.f86a = parcel.createTypedArrayList(fm.CREATOR);
        this.b = parcel.createStringArrayList();
        this.f87a = (uk[]) parcel.createTypedArray(uk.CREATOR);
        this.f85a = parcel.readString();
        this.f5619a = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f86a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.f87a, i);
        parcel.writeString(this.f85a);
        parcel.writeInt(this.f5619a);
    }
}
