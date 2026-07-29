package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.work.multiprocess.c;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: androidx.work.multiprocess.a$a, reason: collision with other inner class name */
    public static class C0085a implements a {
        @Override // androidx.work.multiprocess.a
        public void Y(byte[] request, c callback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.a
        public void q0(byte[] request, c callback) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f8630a = "androidx.work.multiprocess.IListenableWorkerImpl";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f8631b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8632c = 2;

        /* JADX INFO: renamed from: androidx.work.multiprocess.a$b$a, reason: collision with other inner class name */
        public static class C0086a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static a f8633b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f8634a;

            public C0086a(IBinder remote) {
                this.f8634a = remote;
            }

            public String Q0() {
                return b.f8630a;
            }

            @Override // androidx.work.multiprocess.a
            public void Y(byte[] request, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f8630a);
                    parcelObtain.writeByteArray(request);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8634a.transact(1, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().Y(request, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8634a;
            }

            @Override // androidx.work.multiprocess.a
            public void q0(byte[] request, c callback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f8630a);
                    parcelObtain.writeByteArray(request);
                    parcelObtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    if (this.f8634a.transact(2, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().q0(request, callback);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f8630a);
        }

        public static a Q0(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(f8630a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0086a(obj) : (a) iInterfaceQueryLocalInterface;
        }

        public static a R0() {
            return C0086a.f8633b;
        }

        public static boolean S0(a impl) {
            if (C0086a.f8633b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl == null) {
                return false;
            }
            C0086a.f8633b = impl;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1) {
                data.enforceInterface(f8630a);
                Y(data.createByteArray(), c.b.Q0(data.readStrongBinder()));
                return true;
            }
            if (code == 2) {
                data.enforceInterface(f8630a);
                q0(data.createByteArray(), c.b.Q0(data.readStrongBinder()));
                return true;
            }
            if (code != 1598968902) {
                return super.onTransact(code, data, reply, flags);
            }
            reply.writeString(f8630a);
            return true;
        }
    }

    void Y(byte[] request, c callback) throws RemoteException;

    void q0(byte[] request, c callback) throws RemoteException;
}
