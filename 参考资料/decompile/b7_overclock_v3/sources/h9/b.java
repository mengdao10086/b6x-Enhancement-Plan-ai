package h9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.flydigi.remote.DeviceInfo;
import h9.c;
import h9.d;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // h9.b
        public DeviceInfo E0() throws RemoteException {
            return null;
        }

        @Override // h9.b
        public void O(c cVar) throws RemoteException {
        }

        @Override // h9.b
        public void S(d dVar) throws RemoteException {
        }

        @Override // h9.b
        public void W(c cVar) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // h9.b
        public void b0(d dVar) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: h9.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0365b extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f30721a = "com.flydigi.remote.IRemoteService";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f30722b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f30723c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f30724d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f30725e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f30726f = 5;

        /* JADX INFO: renamed from: h9.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f30727b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f30728a;

            public a(IBinder iBinder) {
                this.f30728a = iBinder;
            }

            @Override // h9.b
            public DeviceInfo E0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0365b.f30721a);
                    if (!this.f30728a.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC0365b.R0() != null) {
                        return AbstractBinderC0365b.R0().E0();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.b
            public void O(c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0365b.f30721a);
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.f30728a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0365b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0365b.R0().O(cVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return AbstractBinderC0365b.f30721a;
            }

            @Override // h9.b
            public void S(d dVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0365b.f30721a);
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (this.f30728a.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC0365b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0365b.R0().S(dVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // h9.b
            public void W(c cVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0365b.f30721a);
                    parcelObtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.f30728a.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0365b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0365b.R0().W(cVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30728a;
            }

            @Override // h9.b
            public void b0(d dVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0365b.f30721a);
                    parcelObtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (this.f30728a.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC0365b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC0365b.R0().b0(dVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0365b() {
            attachInterface(this, f30721a);
        }

        public static b Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f30721a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b R0() {
            return a.f30727b;
        }

        public static boolean S0(b bVar) {
            if (a.f30727b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f30727b = bVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f30721a);
                O(c.b.Q0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f30721a);
                W(c.b.Q0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface(f30721a);
                S(d.b.Q0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 4) {
                parcel.enforceInterface(f30721a);
                b0(d.b.Q0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 5) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f30721a);
                return true;
            }
            parcel.enforceInterface(f30721a);
            DeviceInfo deviceInfoE0 = E0();
            parcel2.writeNoException();
            if (deviceInfoE0 != null) {
                parcel2.writeInt(1);
                deviceInfoE0.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    DeviceInfo E0() throws RemoteException;

    void O(c cVar) throws RemoteException;

    void S(d dVar) throws RemoteException;

    void W(c cVar) throws RemoteException;

    void b0(d dVar) throws RemoteException;
}
