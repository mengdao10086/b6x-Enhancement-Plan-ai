package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.d;
import androidx.work.impl.WorkDatabase;
import g.n0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import l2.i;
import v2.q;
import v2.r;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkerParameters implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkerParameters> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final UUID f8741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final d f8742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Set<String> f8743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final WorkerParameters.a f8744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8745e;

    public class a implements Parcelable.Creator<ParcelableWorkerParameters> {
        @Override // android.os.Parcelable.Creator
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkerParameters createFromParcel(Parcel parcel) {
            return new ParcelableWorkerParameters(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkerParameters[] newArray(int i10) {
            return new ParcelableWorkerParameters[i10];
        }
    }

    public ParcelableWorkerParameters(@n0 WorkerParameters workerParameters) {
        this.f8741a = workerParameters.c();
        this.f8742b = workerParameters.d();
        this.f8743c = workerParameters.i();
        this.f8744d = workerParameters.h();
        this.f8745e = workerParameters.g();
    }

    @n0
    public d a() {
        return this.f8742b;
    }

    @n0
    public UUID b() {
        return this.f8741a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f8745e;
    }

    @n0
    public Set<String> g() {
        return this.f8743c;
    }

    @n0
    public WorkerParameters j(@n0 i iVar) {
        androidx.work.a aVarF = iVar.F();
        WorkDatabase workDatabaseM = iVar.M();
        w2.a aVarO = iVar.O();
        return new WorkerParameters(this.f8741a, this.f8742b, this.f8743c, this.f8744d, this.f8745e, aVarF.e(), aVarO, aVarF.m(), new r(workDatabaseM, aVarO), new q(workDatabaseM, iVar.J(), aVarO));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeString(this.f8741a.toString());
        new ParcelableData(this.f8742b).writeToParcel(parcel, i10);
        parcel.writeStringList(new ArrayList(this.f8743c));
        new ParcelableRuntimeExtras(this.f8744d).writeToParcel(parcel, i10);
        parcel.writeInt(this.f8745e);
    }

    public ParcelableWorkerParameters(@n0 Parcel parcel) {
        this.f8741a = UUID.fromString(parcel.readString());
        this.f8742b = new ParcelableData(parcel).b();
        this.f8743c = new HashSet(parcel.createStringArrayList());
        this.f8744d = new ParcelableRuntimeExtras(parcel).a();
        this.f8745e = parcel.readInt();
    }
}
