package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.c;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // androidx.work.multiprocess.b
        public void F0(String tag, c callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.b
        public void L(c callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.b
        public void N0(byte[] request, c callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.b
        public void P0(byte[] request, c callback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.b
        public void b(String name, c callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.b
        public void c(byte[] request, c callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.b
        public void e0(byte[] request, c callback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.b
        public void r0(String id2, c callback) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: androidx.work.multiprocess.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0087b extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f8635a = "androidx.work.multiprocess.IWorkManagerImpl";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f8636b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8637c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8638d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f8639e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f8640f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f8641g = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f8642h = 7;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f8643n = 8;

        /* JADX INFO: renamed from: androidx.work.multiprocess.b$b$a */
        public static class a implements b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f8644b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8645a;

            public a(IBinder remote) {
                this.f8645a = remote;
            }

            @Override // androidx.work.multiprocess.b
            public void F0(String tag, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeString(tag);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(4, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().F0(tag, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.b
            public void L(c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(6, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().L(callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.b
            public void N0(byte[] request, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeByteArray(request);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(8, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().N0(request, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.b
            public void P0(byte[] request, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeByteArray(request);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(2, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().P0(request, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return AbstractBinderC0087b.f8635a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8645a;
            }

            @Override // androidx.work.multiprocess.b
            public void b(String name, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeString(name);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(5, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().b(name, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.b
            public void c(byte[] request, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeByteArray(request);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(1, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().c(request, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.b
            public void e0(byte[] request, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeByteArray(request);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(7, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().e0(request, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.b
            public void r0(String id2, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0087b.f8635a);
                    parcelObtain.writeString(id2);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8645a.transact(3, parcelObtain, null, 1) || AbstractBinderC0087b.R0() == null) {
                        return;
                    }
                    AbstractBinderC0087b.R0().r0(id2, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0087b() {
            attachInterface(this, f8635a);
        }

        public static b Q0(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(f8635a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(obj) : (b) iInterfaceQueryLocalInterface;
        }

        public static b R0() {
            return a.f8644b;
        }

        public static boolean S0(b impl) {
            if (a.f8644b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl == null) {
                return false;
            }
            a.f8644b = impl;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(f8635a);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(f8635a);
                    c(data.createByteArray(), c.b.Q0(data.readStrongBinder()));
                    return true;
                case 2:
                    data.enforceInterface(f8635a);
                    P0(data.createByteArray(), c.b.Q0(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface(f8635a);
                    r0(data.readString(), c.b.Q0(data.readStrongBinder()));
                    return true;
                case 4:
                    data.enforceInterface(f8635a);
                    F0(data.readString(), c.b.Q0(data.readStrongBinder()));
                    return true;
                case 5:
                    data.enforceInterface(f8635a);
                    b(data.readString(), c.b.Q0(data.readStrongBinder()));
                    return true;
                case 6:
                    data.enforceInterface(f8635a);
                    L(c.b.Q0(data.readStrongBinder()));
                    return true;
                case 7:
                    data.enforceInterface(f8635a);
                    e0(data.createByteArray(), c.b.Q0(data.readStrongBinder()));
                    return true;
                case 8:
                    data.enforceInterface(f8635a);
                    N0(data.createByteArray(), c.b.Q0(data.readStrongBinder()));
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void F0(String tag, c callback) throws RemoteException;

    void L(c callback) throws RemoteException;

    void N0(byte[] request, c callback) throws RemoteException;

    void P0(byte[] request, c callback) throws RemoteException;

    void b(String name, c callback) throws RemoteException;

    void c(byte[] request, c callback) throws RemoteException;

    void e0(byte[] request, c callback) throws RemoteException;

    void r0(String id2, c callback) throws RemoteException;
}
