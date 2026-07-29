package h9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {

    public static class a implements d {
        @Override // h9.d
        public void A(byte[] bArr) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // h9.d
        public void l() throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f30738a = "com.flydigi.remote.IRemoteServiceRawCallback";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f30739b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f30740c = 2;

        public static class a implements d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static d f30741b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f30742a;

            public a(IBinder iBinder) {
                this.f30742a = iBinder;
            }

            @Override // h9.d
            public void A(byte[] bArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30738a);
                    parcelObtain.writeByteArray(bArr);
                    if (this.f30742a.transact(1, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().A(bArr);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return b.f30738a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30742a;
            }

            @Override // h9.d
            public void l() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30738a);
                    if (this.f30742a.transact(2, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().l();
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f30738a);
        }

        public static d Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f30738a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) ? new a(iBinder) : (d) iInterfaceQueryLocalInterface;
        }

        public static d R0() {
            return a.f30741b;
        }

        public static boolean S0(d dVar) {
            if (a.f30741b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (dVar == null) {
                return false;
            }
            a.f30741b = dVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f30738a);
                A(parcel.createByteArray());
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f30738a);
                l();
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f30738a);
            return true;
        }
    }

    void A(byte[] bArr) throws RemoteException;

    void l() throws RemoteException;
}
