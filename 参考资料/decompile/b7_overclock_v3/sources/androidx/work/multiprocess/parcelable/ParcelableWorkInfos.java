package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkInfos implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkInfos> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WorkInfo> f8737a;

    public class a implements Parcelable.Creator<ParcelableWorkInfos> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkInfos createFromParcel(Parcel parcel) {
            return new ParcelableWorkInfos(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkInfos[] newArray(int i10) {
            return new ParcelableWorkInfos[i10];
        }
    }

    public ParcelableWorkInfos(@n0 List<WorkInfo> list) {
        this.f8737a = list;
    }

    @n0
    public List<WorkInfo> a() {
        return this.f8737a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        ParcelableWorkInfo[] parcelableWorkInfoArr = new ParcelableWorkInfo[this.f8737a.size()];
        for (int i11 = 0; i11 < this.f8737a.size(); i11++) {
            parcelableWorkInfoArr[i11] = new ParcelableWorkInfo(this.f8737a.get(i11));
        }
        parcel.writeParcelableArray(parcelableWorkInfoArr, i10);
    }

    public ParcelableWorkInfos(@n0 Parcel parcel) {
        Parcelable[] parcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        this.f8737a = new ArrayList(parcelableArray.length);
        for (Parcelable parcelable : parcelableArray) {
            this.f8737a.add(((ParcelableWorkInfo) parcelable).a());
        }
    }
}
