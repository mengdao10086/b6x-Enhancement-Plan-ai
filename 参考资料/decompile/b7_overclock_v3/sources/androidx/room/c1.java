package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.b1;

/* JADX INFO: loaded from: classes2.dex */
public interface c1 extends IInterface {

    public static class a implements c1 {
        @Override // androidx.room.c1
        public void G0(int i10, String[] strArr) throws RemoteException {
        }

        @Override // androidx.room.c1
        public void K0(b1 b1Var, int i10) throws RemoteException {
        }

        @Override // androidx.room.c1
        public int R(b1 b1Var, String str) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements c1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f7349a = "androidx.room.IMultiInstanceInvalidationService";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f7350b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f7351c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f7352d = 3;

        public static class a implements c1 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static c1 f7353b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f7354a;

            public a(IBinder iBinder) {
                this.f7354a = iBinder;
            }

            @Override // androidx.room.c1
            public void G0(int i10, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7349a);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeStringArray(strArr);
                    if (this.f7354a.transact(3, parcelObtain, null, 1) || b.R0() == null) {
                        return;
                    }
                    b.R0().G0(i10, strArr);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.room.c1
            public void K0(b1 b1Var, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7349a);
                    parcelObtain.writeStrongBinder(b1Var != null ? b1Var.asBinder() : null);
                    parcelObtain.writeInt(i10);
                    if (this.f7354a.transact(2, parcelObtain, parcelObtain2, 0) || b.R0() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.R0().K0(b1Var, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return b.f7349a;
            }

            @Override // androidx.room.c1
            public int R(b1 b1Var, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f7349a);
                    parcelObtain.writeStrongBinder(b1Var != null ? b1Var.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (!this.f7354a.transact(1, parcelObtain, parcelObtain2, 0) && b.R0() != null) {
                        return b.R0().R(b1Var, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7354a;
            }
        }

        public b() {
            attachInterface(this, f7349a);
        }

        public static c1 Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f7349a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c1)) ? new a(iBinder) : (c1) iInterfaceQueryLocalInterface;
        }

        public static c1 R0() {
            return a.f7353b;
        }

        public static boolean S0(c1 c1Var) {
            if (a.f7353b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (c1Var == null) {
                return false;
            }
            a.f7353b = c1Var;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f7349a);
                int iR = R(b1.b.Q0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iR);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f7349a);
                K0(b1.b.Q0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface(f7349a);
                G0(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f7349a);
            return true;
        }
    }

    void G0(int i10, String[] strArr) throws RemoteException;

    void K0(b1 b1Var, int i10) throws RemoteException;

    int R(b1 b1Var, String str) throws RemoteException;
}
