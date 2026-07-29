package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableRemoteWorkRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRemoteWorkRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParcelableWorkerParameters f8724b;

    public class a implements Parcelable.Creator<ParcelableRemoteWorkRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableRemoteWorkRequest createFromParcel(Parcel parcel) {
            return new ParcelableRemoteWorkRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableRemoteWorkRequest[] newArray(int i10) {
            return new ParcelableRemoteWorkRequest[i10];
        }
    }

    public ParcelableRemoteWorkRequest(@n0 String str, @n0 WorkerParameters workerParameters) {
        this.f8723a = str;
        this.f8724b = new ParcelableWorkerParameters(workerParameters);
    }

    @n0
    public ParcelableWorkerParameters a() {
        return this.f8724b;
    }

    @n0
    public String b() {
        return this.f8723a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeString(this.f8723a);
        this.f8724b.writeToParcel(parcel, i10);
    }

    public ParcelableRemoteWorkRequest(@n0 Parcel parcel) {
        this.f8723a = parcel.readString();
        this.f8724b = new ParcelableWorkerParameters(parcel);
    }
}
