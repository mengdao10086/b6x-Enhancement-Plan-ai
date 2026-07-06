package a;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o61 implements q61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q61 f6988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IBinder f2210a;

    public o61(IBinder iBinder) {
        this.f2210a = iBinder;
    }

    @Override // a.q61
    public String a(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.omarea.vaddin.IAppConfigAidlInterface");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            if (!this.f2210a.transact(9, parcelObtain, parcelObtain2, 0) && p61.g() != null) {
                return p61.g().a(str, str2);
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2210a;
    }

    @Override // a.q61
    public boolean b(String str, String str2) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.omarea.vaddin.IAppConfigAidlInterface");
            parcelObtain.writeString(str);
            parcelObtain.writeString(str2);
            if (!this.f2210a.transact(5, parcelObtain, parcelObtain2, 0) && p61.g() != null) {
                return p61.g().b(str, str2);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // a.q61
    public boolean c(String str, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.omarea.vaddin.IAppConfigAidlInterface");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(z ? 1 : 0);
            if (!this.f2210a.transact(4, parcelObtain, parcelObtain2, 0) && p61.g() != null) {
                return p61.g().c(str, z);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // a.q61
    public boolean d(String str, boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.omarea.vaddin.IAppConfigAidlInterface");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(z ? 1 : 0);
            if (!this.f2210a.transact(7, parcelObtain, parcelObtain2, 0) && p61.g() != null) {
                return p61.g().d(str, z);
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
