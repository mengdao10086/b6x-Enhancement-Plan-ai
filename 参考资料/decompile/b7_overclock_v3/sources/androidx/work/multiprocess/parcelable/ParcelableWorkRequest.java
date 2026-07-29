package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.x;
import g.n0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import l2.j;
import u2.r;
import x2.b;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableWorkRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableWorkRequest> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f8739a;

    public class a implements Parcelable.Creator<ParcelableWorkRequest> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkRequest createFromParcel(Parcel parcel) {
            return new ParcelableWorkRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableWorkRequest[] newArray(int i10) {
            return new ParcelableWorkRequest[i10];
        }
    }

    public ParcelableWorkRequest(@n0 x xVar) {
        this.f8739a = xVar;
    }

    @n0
    public x a() {
        return this.f8739a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeString(this.f8739a.b());
        parcel.writeStringList(new ArrayList(this.f8739a.c()));
        r rVarD = this.f8739a.d();
        parcel.writeString(rVarD.f51843c);
        parcel.writeString(rVarD.f51844d);
        parcel.writeInt(u2.x.j(rVarD.f51842b));
        new ParcelableData(rVarD.f51845e).writeToParcel(parcel, i10);
        new ParcelableData(rVarD.f51846f).writeToParcel(parcel, i10);
        parcel.writeLong(rVarD.f51847g);
        parcel.writeLong(rVarD.f51848h);
        parcel.writeLong(rVarD.f51849i);
        parcel.writeInt(rVarD.f51851k);
        parcel.writeParcelable(new ParcelableConstraints(rVarD.f51850j), i10);
        parcel.writeInt(u2.x.a(rVarD.f51852l));
        parcel.writeLong(rVarD.f51853m);
        parcel.writeLong(rVarD.f51855o);
        parcel.writeLong(rVarD.f51856p);
        b.b(parcel, rVarD.f51857q);
        parcel.writeInt(u2.x.i(rVarD.f51858r));
    }

    public ParcelableWorkRequest(@n0 Parcel parcel) {
        String string = parcel.readString();
        HashSet hashSet = new HashSet(parcel.createStringArrayList());
        r rVar = new r(string, parcel.readString());
        rVar.f51844d = parcel.readString();
        rVar.f51842b = u2.x.g(parcel.readInt());
        rVar.f51845e = new ParcelableData(parcel).b();
        rVar.f51846f = new ParcelableData(parcel).b();
        rVar.f51847g = parcel.readLong();
        rVar.f51848h = parcel.readLong();
        rVar.f51849i = parcel.readLong();
        rVar.f51851k = parcel.readInt();
        rVar.f51850j = ((ParcelableConstraints) parcel.readParcelable(getClass().getClassLoader())).a();
        rVar.f51852l = u2.x.d(parcel.readInt());
        rVar.f51853m = parcel.readLong();
        rVar.f51855o = parcel.readLong();
        rVar.f51856p = parcel.readLong();
        rVar.f51857q = b.a(parcel);
        rVar.f51858r = u2.x.f(parcel.readInt());
        this.f8739a = new j(UUID.fromString(string), rVar, hashSet);
    }
}
