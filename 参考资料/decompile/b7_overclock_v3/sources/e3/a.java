package e3;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        return context.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean b(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}");
    }
}
