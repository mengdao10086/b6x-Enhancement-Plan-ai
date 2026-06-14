package a;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zj0 {
    @SuppressLint({"PrivateApi"})
    public double a(Context context) {
        try {
            return (int) ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), new Object[0])).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }
}
