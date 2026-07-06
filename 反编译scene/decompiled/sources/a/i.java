package a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f6359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IBinder f1297a;

    public i(IBinder iBinder) {
        this.f1297a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1297a;
    }

    @Override // a.k
    public void e(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
            parcelObtain.writeInt(i);
            if (bundle != null) {
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (this.f1297a.transact(1, parcelObtain, null, 1) || j.g() == null) {
                return;
            }
            j.g().e(i, bundle);
        } finally {
            parcelObtain.recycle();
        }
    }
}
