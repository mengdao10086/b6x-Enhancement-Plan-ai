package g2;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import g.n0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f28936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f28937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f28938c;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(@n0 Canvas canvas, boolean z10) {
        Method method;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            if (z10) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (i10 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f28938c) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                f28936a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                f28937b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f28938c = true;
        }
        if (z10) {
            try {
                Method method2 = f28936a;
                if (method2 != null) {
                    method2.invoke(canvas, new Object[0]);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
        if (z10 || (method = f28937b) == null) {
            return;
        }
        method.invoke(canvas, new Object[0]);
    }
}
