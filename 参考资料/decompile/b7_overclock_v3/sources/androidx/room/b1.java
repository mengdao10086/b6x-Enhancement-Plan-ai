package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface b1 extends IInterface {

    public static class a implements b1 {
        @Override // androidx.room.b1
        public void J(String[] strArr) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f7337a = "androidx.room.IMultiInstanceInvalidationCallback";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7338b = 1;

        public static class a implements b1 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b1 f7339b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f7340a;

            public a(IBinder iBinder) {
                this.f7340a = iBinder;
            }

            @Override // androidx.room.b1
            public void J(String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7337a);
                    parcelObtain.writeStringArray(strArr);
                    if (this.f7340a.transact(1, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().J(strArr);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return b.f7337a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7340a;
            }
        }

        public b() {
            attachInterface(this, f7337a);
        }

        public static b1 Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f7337a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b1)) ? new a(iBinder) : (b1) iInterfaceQueryLocalInterface;
        }

        public static b1 R0() {
            return a.f7339b;
        }

        public static boolean S0(b1 b1Var) {
            if (a.f7339b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (b1Var == null) {
                return false;
            }
            a.f7339b = b1Var;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f7337a);
                J(parcel.createStringArray());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f7337a);
            return true;
        }
    }

    void J(String[] strArr) throws RemoteException;
}
