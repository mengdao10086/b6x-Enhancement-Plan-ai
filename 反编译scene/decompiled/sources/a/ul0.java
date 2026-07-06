package a;

import android.os.IBinder;
import android.os.Parcel;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ul0 extends hm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7609a = "com.mediatek.powerhalmgr.IPowerHalMgr";
    public static final String b = "power_hal_mgr_service";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashMap<Integer, Integer> f3197a = new HashMap<>();

    public static void b(boolean z) {
        q(33931264, z ? 1 : 0);
    }

    public static void c(int i) {
        Integer num = f3197a.get(Integer.valueOf(i));
        if (num != null) {
            k(num.intValue());
        }
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            byte b2 = bArr[i2];
            if (i3 > 31 && i3 <= 122) {
                b2 = (byte) (((((i3 + 91) - 32) - (i % 10)) % 91) + 32);
            }
            bArr2[i2] = b2;
            i = bArr[i2] == 10 ? 0 : i + 1;
        }
        return bArr2;
    }

    public static String e(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("/vendor/etc/thermal/" + str));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            return new String(d(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void f() {
        try {
            IBinder iBinderA = hm0.a(b);
            if (iBinderA == null) {
                return;
            }
            for (int i = 0; i < 256; i++) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(f7609a);
                parcelObtain.writeInt(i);
                iBinderA.transact(5, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain2.readInt();
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Exception unused) {
        }
    }

    public static void g(boolean z) {
        q(33571072, z ? 1 : 0);
    }

    public static ArrayList<String> h() {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File("/vendor/etc/thermal");
        nb2 nb2Var = new nb2("thermal_policy_[0-9]{2}.conf");
        if (file.canRead()) {
            for (String str : file.list()) {
                if (nb2Var.f(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static int i(int i, int i2, int[] iArr) {
        try {
            IBinder iBinderA = hm0.a(b);
            if (iBinderA == null) {
                return -1;
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(f7609a);
                parcelObtain.writeInt(i);
                parcelObtain.writeInt(i2);
                parcelObtain.writeIntArray(iArr);
                iBinderA.transact(22, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void j() {
        Iterator<Map.Entry<Integer, Integer>> it = f3197a.entrySet().iterator();
        while (it.hasNext()) {
            k(it.next().getValue().intValue());
        }
        f3197a.clear();
    }

    public static int k(int i) {
        try {
            IBinder iBinderA = hm0.a(b);
            if (iBinderA == null) {
                return -1;
            }
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(f7609a);
                parcelObtain.writeInt(i);
                iBinderA.transact(23, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void l(int i, boolean z) {
        int i2;
        switch (i) {
            case 0:
                i2 = 8438016;
                break;
            case 1:
                i2 = 8438272;
                break;
            case 2:
                i2 = 8438528;
                break;
            case 3:
                i2 = 8438784;
                break;
            case 4:
                i2 = 8439040;
                break;
            case 5:
                i2 = 8439296;
                break;
            case 6:
                i2 = 8439552;
                break;
            case 7:
                i2 = 8439808;
                break;
            default:
                return;
        }
        if (z) {
            q(i2, 1);
        } else {
            c(i2);
        }
    }

    public static void m(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = 4210688;
        } else if (i == 1) {
            i3 = 4210944;
        } else if (i != 2) {
            return;
        } else {
            i3 = 4211200;
        }
        q(i3, i2);
    }

    public static void n(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = 4194304;
        } else if (i == 1) {
            i3 = 4194560;
        } else if (i != 2) {
            return;
        } else {
            i3 = 4194816;
        }
        q(i3, i2);
    }

    public static void o(int i) {
        q(12599296, i);
    }

    public static void p(int i) {
        q(12582912, i);
    }

    public static void q(int i, int i2) {
        if (f3197a.get(Integer.valueOf(i)) != null) {
            k(i);
        }
        f3197a.put(Integer.valueOf(i), Integer.valueOf(i(i, 0, new int[]{i, i2})));
    }

    public static void r() {
        File file = new File("/vendor/etc/thermal");
        nb2 nb2Var = new nb2("thermal_policy_[0-9]{2}.conf");
        int i = 0;
        if (file.canRead()) {
            String[] list = file.list();
            int length = list.length;
            long j = 2147483647L;
            int i2 = 0;
            while (i < length) {
                String str = list[i];
                if (nb2Var.f(str)) {
                    int i3 = Integer.parseInt(str.substring(str.lastIndexOf("_") + 1, str.lastIndexOf(".")));
                    long length2 = new File("/vendor/etc/thermal/" + str).length();
                    if (length2 < j) {
                        i2 = i3;
                        j = length2;
                    }
                }
                i++;
            }
            i = i2;
        }
        if (i > 0) {
            s(i);
        }
    }

    public static void s(int i) {
        q(50331648, i);
    }

    public static void t() {
        q(54542336, 1);
    }

    public static void u(boolean z) {
        q(54560000, z ? 1 : 0);
    }
}
