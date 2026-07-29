package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.d;
import g.n0;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableUpdateRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableUpdateRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParcelableData f8728b;

    public class a implements Parcelable.Creator<ParcelableUpdateRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableUpdateRequest createFromParcel(@n0 Parcel parcel) {
            return new ParcelableUpdateRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableUpdateRequest[] newArray(int i10) {
            return new ParcelableUpdateRequest[i10];
        }
    }

    public ParcelableUpdateRequest(@n0 UUID uuid, @n0 d dVar) {
        this.f8727a = uuid.toString();
        this.f8728b = new ParcelableData(dVar);
    }

    @n0
    public d a() {
        return this.f8728b.b();
    }

    @n0
    public String b() {
        return this.f8727a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeString(this.f8727a);
        this.f8728b.writeToParcel(parcel, i10);
    }

    public ParcelableUpdateRequest(@n0 Parcel parcel) {
        this.f8727a = parcel.readString();
        this.f8728b = new ParcelableData(parcel);
    }
}
