package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.x;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkRequests implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkRequests> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<x> f8740a;

    public class a implements Parcelable.Creator<ParcelableWorkRequests> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkRequests createFromParcel(Parcel parcel) {
            return new ParcelableWorkRequests(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkRequests[] newArray(int i10) {
            return new ParcelableWorkRequests[i10];
        }
    }

    public ParcelableWorkRequests(@n0 List<x> list) {
        this.f8740a = list;
    }

    @n0
    public List<x> a() {
        return this.f8740a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        ParcelableWorkRequest[] parcelableWorkRequestArr = new ParcelableWorkRequest[this.f8740a.size()];
        for (int i11 = 0; i11 < this.f8740a.size(); i11++) {
            parcelableWorkRequestArr[i11] = new ParcelableWorkRequest(this.f8740a.get(i11));
        }
        parcel.writeParcelableArray(parcelableWorkRequestArr, i10);
    }

    public ParcelableWorkRequests(@n0 Parcel parcel) {
        Parcelable[] parcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        this.f8740a = new ArrayList(parcelableArray.length);
        for (Parcelable parcelable : parcelableArray) {
            this.f8740a.add(((ParcelableWorkRequest) parcelable).a());
        }
    }
}
