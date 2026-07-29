package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import g.n0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import u2.x;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkInfo implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkInfo f8736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f8735b = new String[0];
    public static final Parcelable.Creator<ParcelableWorkInfo> CREATOR = new a();

    public class a implements Parcelable.Creator<ParcelableWorkInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkInfo createFromParcel(Parcel parcel) {
            return new ParcelableWorkInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkInfo[] newArray(int i10) {
            return new ParcelableWorkInfo[i10];
        }
    }

    public ParcelableWorkInfo(@n0 WorkInfo workInfo) {
        this.f8736a = workInfo;
    }

    @n0
    public WorkInfo a() {
        return this.f8736a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeString(this.f8736a.a().toString());
        parcel.writeInt(x.j(this.f8736a.e()));
        new ParcelableData(this.f8736a.b()).writeToParcel(parcel, i10);
        parcel.writeStringArray((String[]) new ArrayList(this.f8736a.f()).toArray(f8735b));
        new ParcelableData(this.f8736a.c()).writeToParcel(parcel, i10);
        parcel.writeInt(this.f8736a.d());
    }

    public ParcelableWorkInfo(@n0 Parcel parcel) {
        this.f8736a = new WorkInfo(UUID.fromString(parcel.readString()), x.g(parcel.readInt()), new ParcelableData(parcel).b(), Arrays.asList(parcel.createStringArray()), new ParcelableData(parcel).b(), parcel.readInt());
    }
}
