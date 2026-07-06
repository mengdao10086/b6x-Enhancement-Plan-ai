package a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class j extends Binder implements k {
    public j() {
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    public static k f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new i(iBinder) : (k) iInterfaceQueryLocalInterface;
    }

    public static k g() {
        return i.f6359a;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("android.support.v4.os.IResultReceiver");
            e(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
        if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel2.writeString("android.support.v4.os.IResultReceiver");
        return true;
    }
}
