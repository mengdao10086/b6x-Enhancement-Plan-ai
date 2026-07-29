package cu;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes6.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: cu.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0285a extends Binder implements a {

        /* JADX INFO: renamed from: cu.a$a$a, reason: collision with other inner class name */
        public static class C0286a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f25916a;

            public C0286a(IBinder iBinder) {
                this.f25916a = iBinder;
            }

            public String Q0(String str, String str2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f25916a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25916a;
            }
        }

        public static a Q0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0286a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
