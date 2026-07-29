package c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9656j = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static class C0103a implements a {
        @Override // c.a
        public void I0(String str, int i10, String str2, Notification notification) throws RemoteException {
        }

        @Override // c.a
        public void P(String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // c.a
        public void p0(String str, int i10, String str2) throws RemoteException {
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f9657a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f9658b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9659c = 3;

        /* JADX INFO: renamed from: c.a$b$a, reason: collision with other inner class name */
        public static class C0104a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f9660a;

            public C0104a(IBinder iBinder) {
                this.f9660a = iBinder;
            }

            @Override // c.a
            public void I0(String str, int i10, String str2, Notification notification) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f9656j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    c.d(parcelObtain, notification, 0);
                    this.f9660a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // c.a
            public void P(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f9656j);
                    parcelObtain.writeString(str);
                    this.f9660a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return a.f9656j;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9660a;
            }

            @Override // c.a
            public void p0(String str, int i10, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f9656j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    this.f9660a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, a.f9656j);
        }

        public static a Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f9656j);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0104a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = a.f9656j;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 == 1) {
                I0(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) c.c(parcel, Notification.CREATOR));
            } else if (i10 == 2) {
                p0(parcel.readString(), parcel.readInt(), parcel.readString());
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                P(parcel.readString());
            }
            return true;
        }
    }

    public static class c {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void I0(String str, int i10, String str2, Notification notification) throws RemoteException;

    void P(String str) throws RemoteException;

    void p0(String str, int i10, String str2) throws RemoteException;
}
