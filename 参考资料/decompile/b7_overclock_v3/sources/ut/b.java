package ut;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52444a = "org.greenrobot.eventbus.android.AndroidComponentsImpl";

    public static boolean a() {
        try {
            Class.forName(f52444a);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static a b() {
        try {
            return (a) Class.forName(f52444a).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c() {
        try {
            return Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }
}
