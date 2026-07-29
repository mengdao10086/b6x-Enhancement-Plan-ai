package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes5.dex */
public interface b extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f23344a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f23345b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f23346c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f23347d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public a() {
            attachInterface(this, f23347d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f23347d);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0254a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f23347d);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f23347d);
                String strA2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f23347d);
                return true;
            }
            parcel.enforceInterface(f23347d);
            String strB = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        /* JADX INFO: renamed from: com.umeng.analytics.pro.b$a$a, reason: collision with other inner class name */
        public static class C0254a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f23348a;

            public C0254a(IBinder iBinder) {
                this.f23348a = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f23347d);
                    this.f23348a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23348a;
            }

            public String b() {
                return a.f23347d;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f23347d);
                    parcelObtain.writeString(str);
                    this.f23348a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f23347d);
                    parcelObtain.writeString(str);
                    this.f23348a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
