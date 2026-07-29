package w0;

import android.os.Build;
import android.telephony.SubscriptionManager;
import g.u;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@v0(22)
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f53825a;

    /* JADX INFO: renamed from: w0.a$a, reason: collision with other inner class name */
    @v0(29)
    public static class C0630a {
        @u
        public static int a(int i10) {
            return SubscriptionManager.getSlotIndex(i10);
        }
    }

    public static int a(int i10) {
        if (i10 == -1) {
            return -1;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            return C0630a.a(i10);
        }
        try {
            if (f53825a == null) {
                if (i11 >= 26) {
                    f53825a = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    f53825a = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                f53825a.setAccessible(true);
            }
            Integer num = (Integer) f53825a.invoke(null, Integer.valueOf(i10));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
