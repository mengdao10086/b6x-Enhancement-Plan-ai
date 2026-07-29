package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends IInterface {

    public static class a implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.c
        public void d0(String error) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.c
        public void z0(byte[] response) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f8646a = "androidx.work.multiprocess.IWorkManagerImplCallback";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f8647b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8648c = 2;

        public static class a implements c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static c f8649b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8650a;

            public a(IBinder remote) {
                this.f8650a = remote;
            }

            public String Q0() {
                return b.f8646a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8650a;
            }

            @Override // androidx.work.multiprocess.c
            public void d0(String error) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f8646a);
                    parcelObtain.writeString(error);
                    if (this.f8650a.transact(2, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().d0(error);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.c
            public void z0(byte[] response) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f8646a);
                    parcelObtain.writeByteArray(response);
                    if (this.f8650a.transact(1, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().z0(response);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f8646a);
        }

        public static c Q0(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(f8646a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new a(obj) : (c) iInterfaceQueryLocalInterface;
        }

        public static c R0() {
            return a.f8649b;
        }

        public static boolean S0(c impl) {
            if (a.f8649b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl == null) {
                return false;
            }
            a.f8649b = impl;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1) {
                data.enforceInterface(f8646a);
                z0(data.createByteArray());
                return true;
            }
            if (code == 2) {
                data.enforceInterface(f8646a);
                d0(data.readString());
                return true;
            }
            if (code != 1598968902) {
                return super.onTransact(code, data, reply, flags);
            }
            reply.writeString(f8646a);
            return true;
        }
    }

    void d0(String error) throws RemoteException;

    void z0(byte[] response) throws RemoteException;
}
