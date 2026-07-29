package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f1286i = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* JADX INFO: renamed from: android.support.v4.os.a$a, reason: collision with other inner class name */
    public static class C0024a implements a {
        @Override // android.support.v4.os.a
        public void a(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1287a = 1;

        /* JADX INFO: renamed from: android.support.v4.os.a$b$a, reason: collision with other inner class name */
        public static class C0025a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f1288a;

            public C0025a(IBinder iBinder) {
                this.f1288a = iBinder;
            }

            public String Q0() {
                return a.f1286i;
            }

            @Override // android.support.v4.os.a
            public void a(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f1286i);
                    parcelObtain.writeInt(i10);
                    c.d(parcelObtain, bundle, 0);
                    this.f1288a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1288a;
            }
        }

        public b() {
            attachInterface(this, a.f1286i);
        }

        public static a Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f1286i);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0025a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = a.f1286i;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            a(parcel.readInt(), (Bundle) c.c(parcel, Bundle.CREATOR));
            return true;
        }
    }

    public static class c {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void a(int i10, Bundle bundle) throws RemoteException;
}
