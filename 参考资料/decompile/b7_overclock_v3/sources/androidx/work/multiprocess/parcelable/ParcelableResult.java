package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.d;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableResult implements Parcelable {
    public static final Parcelable.Creator<ParcelableResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListenableWorker.a f8725a;

    public class a implements Parcelable.Creator<ParcelableResult> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableResult createFromParcel(Parcel parcel) {
            return new ParcelableResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableResult[] newArray(int i10) {
            return new ParcelableResult[i10];
        }
    }

    public ParcelableResult(@n0 ListenableWorker.a aVar) {
        this.f8725a = aVar;
    }

    @n0
    public static ListenableWorker.a b(int i10, @n0 d dVar) {
        if (i10 == 1) {
            return ListenableWorker.a.d();
        }
        if (i10 == 2) {
            return ListenableWorker.a.f(dVar);
        }
        if (i10 == 3) {
            return ListenableWorker.a.b(dVar);
        }
        throw new IllegalStateException(String.format("Unknown result type %s", Integer.valueOf(i10)));
    }

    public static int e(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.b) {
            return 1;
        }
        if (aVar instanceof ListenableWorker.a.c) {
            return 2;
        }
        if (aVar instanceof ListenableWorker.a.C0079a) {
            return 3;
        }
        throw new IllegalStateException(String.format("Unknown Result %s", aVar));
    }

    @n0
    public ListenableWorker.a a() {
        return this.f8725a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeInt(e(this.f8725a));
        new ParcelableData(this.f8725a.c()).writeToParcel(parcel, i10);
    }

    public ParcelableResult(@n0 Parcel parcel) {
        this.f8725a = b(parcel.readInt(), new ParcelableData(parcel).b());
    }
}
