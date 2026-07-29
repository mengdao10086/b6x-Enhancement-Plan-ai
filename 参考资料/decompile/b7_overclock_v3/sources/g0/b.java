package g0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import g0.a;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f28857m = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    public static class a implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // g0.b
        public void t0(g0.a aVar) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: g0.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0340b extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f28858a = 1;

        /* JADX INFO: renamed from: g0.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f28859a;

            public a(IBinder iBinder) {
                this.f28859a = iBinder;
            }

            public String Q0() {
                return b.f28857m;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28859a;
            }

            @Override // g0.b
            public void t0(g0.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f28857m);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f28859a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0340b() {
            attachInterface(this, b.f28857m);
        }

        public static b Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.f28857m);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = b.f28857m;
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
            t0(a.b.Q0(parcel.readStrongBinder()));
            return true;
        }
    }

    void t0(g0.a aVar) throws RemoteException;
}
