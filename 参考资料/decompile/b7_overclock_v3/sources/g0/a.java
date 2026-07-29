package g0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f28854l = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    /* JADX INFO: renamed from: g0.a$a, reason: collision with other inner class name */
    public static class C0338a implements a {
        @Override // g0.a
        public void A0(boolean z10, boolean z11) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f28855a = 1;

        /* JADX INFO: renamed from: g0.a$b$a, reason: collision with other inner class name */
        public static class C0339a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f28856a;

            public C0339a(IBinder iBinder) {
                this.f28856a = iBinder;
            }

            @Override // g0.a
            public void A0(boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f28854l);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.f28856a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String Q0() {
                return a.f28854l;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28856a;
            }
        }

        public b() {
            attachInterface(this, a.f28854l);
        }

        public static a Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f28854l);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0339a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = a.f28854l;
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
            A0(parcel.readInt() != 0, parcel.readInt() != 0);
            return true;
        }
    }

    void A0(boolean z10, boolean z11) throws RemoteException;
}
