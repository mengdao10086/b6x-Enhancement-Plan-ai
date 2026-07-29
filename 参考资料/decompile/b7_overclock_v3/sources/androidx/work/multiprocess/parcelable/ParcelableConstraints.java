package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.b;
import androidx.work.c;
import g.n0;
import java.util.concurrent.TimeUnit;
import u2.x;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableConstraints implements Parcelable {
    public static final Parcelable.Creator<ParcelableConstraints> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8706a;

    public class a implements Parcelable.Creator<ParcelableConstraints> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableConstraints createFromParcel(Parcel parcel) {
            return new ParcelableConstraints(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableConstraints[] newArray(int i10) {
            return new ParcelableConstraints[i10];
        }
    }

    public ParcelableConstraints(@n0 b bVar) {
        this.f8706a = bVar;
    }

    @n0
    public b a() {
        return this.f8706a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        parcel.writeInt(x.h(this.f8706a.b()));
        x2.b.b(parcel, this.f8706a.f());
        x2.b.b(parcel, this.f8706a.g());
        x2.b.b(parcel, this.f8706a.i());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            x2.b.b(parcel, this.f8706a.h());
        }
        if (i11 >= 24) {
            boolean zE = this.f8706a.e();
            x2.b.b(parcel, zE);
            if (zE) {
                parcel.writeByteArray(x.c(this.f8706a.a()));
            }
            parcel.writeLong(this.f8706a.d());
            parcel.writeLong(this.f8706a.c());
        }
    }

    public ParcelableConstraints(@n0 Parcel parcel) {
        b.a aVar = new b.a();
        aVar.c(x.e(parcel.readInt()));
        aVar.d(x2.b.a(parcel));
        aVar.e(x2.b.a(parcel));
        aVar.g(x2.b.a(parcel));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            aVar.f(x2.b.a(parcel));
        }
        if (i10 >= 24) {
            if (x2.b.a(parcel)) {
                for (c.a aVar2 : x.b(parcel.createByteArray()).b()) {
                    aVar.a(aVar2.a(), aVar2.b());
                }
            }
            long j10 = parcel.readLong();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            aVar.h(j10, timeUnit);
            aVar.j(parcel.readLong(), timeUnit);
        }
        this.f8706a = aVar.b();
    }
}
