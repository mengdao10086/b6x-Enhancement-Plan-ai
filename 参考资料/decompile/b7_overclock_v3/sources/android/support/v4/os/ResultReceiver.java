package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;
import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f1280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public android.support.v4.os.a f1281c;

    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i10) {
            return new ResultReceiver[i10];
        }
    }

    public class b extends a.b {
        public b() {
        }

        @Override // android.support.v4.os.a
        public void a(int i10, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f1280b;
            if (handler != null) {
                handler.post(resultReceiver.new c(i10, bundle));
            } else {
                resultReceiver.a(i10, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f1284b;

        public c(int i10, Bundle bundle) {
            this.f1283a = i10;
            this.f1284b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f1283a, this.f1284b);
        }
    }

    public ResultReceiver(Handler handler) {
        this.f1279a = true;
        this.f1280b = handler;
    }

    public void a(int i10, Bundle bundle) {
    }

    public void b(int i10, Bundle bundle) {
        if (this.f1279a) {
            Handler handler = this.f1280b;
            if (handler != null) {
                handler.post(new c(i10, bundle));
                return;
            } else {
                a(i10, bundle);
                return;
            }
        }
        android.support.v4.os.a aVar = this.f1281c;
        if (aVar != null) {
            try {
                aVar.a(i10, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f1281c == null) {
                this.f1281c = new b();
            }
            parcel.writeStrongBinder(this.f1281c.asBinder());
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f1279a = false;
        this.f1280b = null;
        this.f1281c = a.b.Q0(parcel.readStrongBinder());
    }
}
