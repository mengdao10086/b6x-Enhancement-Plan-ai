package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.k0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends kotlin.coroutines.a implements k0 {

    @l
    private volatile Object _preHandler;

    public b() {
        super(k0.f38888w2);
        this._preHandler = this;
    }

    @Override // kotlinx.coroutines.k0
    public void V1(@k CoroutineContext coroutineContext, @k Throwable th2) {
        int i10 = Build.VERSION.SDK_INT;
        if (26 <= i10 && i10 < 28) {
            Method methodH2 = h2();
            Object objInvoke = methodH2 != null ? methodH2.invoke(null, new Object[0]) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
            }
        }
    }

    public final Method h2() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z10 = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z10 = true;
                }
            }
            if (z10) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }
}
