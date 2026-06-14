package a;

import android.os.IBinder;
import android.os.Parcel;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class vm0 extends hm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7707a = "com.qualcomm.qti.IPerfManager";
    public static final String b = "vendor.perfservice";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashMap<Integer, Integer> f3292a = new HashMap<>();

    public static int b(int i, int[] iArr) {
        try {
            IBinder iBinderA = hm0.a(b);
            if (iBinderA == null) {
                return -1;
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(f7707a);
                parcelObtain.writeInt(i);
                parcelObtain.writeInt(iArr != null ? iArr.length : 0);
                parcelObtain.writeIntArray(iArr);
                iBinderA.transact(4, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int c() {
        try {
            IBinder iBinderA = hm0.a(b);
            if (iBinderA == null) {
                return -1;
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(f7707a);
                iBinderA.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int d(int i) {
        try {
            IBinder iBinderA = hm0.a(b);
            if (iBinderA == null) {
                return -1;
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(f7707a);
                parcelObtain.writeInt(i);
                iBinderA.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void e(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = 1082147072;
        } else if (i == 1) {
            i3 = 1082146816;
        } else if (i != 2) {
            return;
        } else {
            i3 = 1082147328;
        }
        i(i3, i2 / 1000);
    }

    public static void f(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = 1082130688;
        } else if (i == 1) {
            i3 = 1082130432;
        } else if (i != 2) {
            return;
        } else {
            i3 = 1082130944;
        }
        i(i3, i2 / 1000);
    }

    public static void g(int i) {
        i(1115717632, i);
    }

    public static void h(int i) {
        i(1115701248, i);
    }

    public static void i(int i, int i2) {
        if (f3292a.get(Integer.valueOf(i)) != null) {
            d(i);
        }
        f3292a.put(Integer.valueOf(i), Integer.valueOf(b(i, new int[]{i, i2})));
    }
}
