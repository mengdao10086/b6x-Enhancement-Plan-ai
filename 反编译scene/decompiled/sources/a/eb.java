package a;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f5985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f715a;

    public static IBinder a(Bundle bundle, String str) {
        if (!f715a) {
            try {
                Method method = Bundle.class.getMethod("getIBinder", String.class);
                f5985a = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
            }
            f715a = true;
        }
        Method method2 = f5985a;
        if (method2 != null) {
            try {
                return (IBinder) method2.invoke(bundle, str);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                f5985a = null;
            }
        }
        return null;
    }
}
