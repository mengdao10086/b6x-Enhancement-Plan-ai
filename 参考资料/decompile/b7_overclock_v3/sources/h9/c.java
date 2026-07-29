package h9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.flydigi.remote.DeviceInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {

    public static class a implements c {
        @Override // h9.c
        public void H0(DeviceInfo deviceInfo) throws RemoteException {
        }

        @Override // h9.c
        public void J0() throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // h9.c
        public void k0(boolean z10) throws RemoteException {
        }

        @Override // h9.c
        public void n() throws RemoteException {
        }

        @Override // h9.c
        public void v0() throws RemoteException {
        }

        @Override // h9.c
        public void x0() throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f30729a = "com.flydigi.remote.IRemoteServiceCallback";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f30730b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f30731c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f30732d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f30733e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f30734f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f30735g = 6;

        public static class a implements c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static c f30736b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f30737a;

            public a(IBinder iBinder) {
                this.f30737a = iBinder;
            }

            @Override // h9.c
            public void H0(DeviceInfo deviceInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30729a);
                    if (deviceInfo != null) {
                        parcelObtain.writeInt(1);
                        deviceInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f30737a.transact(1, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().H0(deviceInfo);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void J0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30729a);
                    if (this.f30737a.transact(3, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().J0();
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return b.f30729a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30737a;
            }

            @Override // h9.c
            public void k0(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30729a);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30737a.transact(6, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().k0(z10);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void n() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30729a);
                    if (this.f30737a.transact(2, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().n();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void v0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30729a);
                    if (this.f30737a.transact(5, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().v0();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // h9.c
            public void x0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30729a);
                    if (this.f30737a.transact(4, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().x0();
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f30729a);
        }

        public static c Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f30729a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        public static c R0() {
            return a.f30736b;
        }

        public static boolean S0(c cVar) {
            if (a.f30736b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (cVar == null) {
                return false;
            }
            a.f30736b = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f30729a);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f30729a);
                    H0(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(f30729a);
                    n();
                    return true;
                case 3:
                    parcel.enforceInterface(f30729a);
                    J0();
                    return true;
                case 4:
                    parcel.enforceInterface(f30729a);
                    x0();
                    return true;
                case 5:
                    parcel.enforceInterface(f30729a);
                    v0();
                    return true;
                case 6:
                    parcel.enforceInterface(f30729a);
                    k0(parcel.readInt() != 0);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void H0(DeviceInfo deviceInfo) throws RemoteException;

    void J0() throws RemoteException;

    void k0(boolean z10) throws RemoteException;

    void n() throws RemoteException;

    void v0() throws RemoteException;

    void x0() throws RemoteException;
}
