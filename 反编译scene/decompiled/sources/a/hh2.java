package a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hh2 {
    static {
        Object objA;
        try {
            e42 e42Var = g42.f6169a;
            objA = new fh2(a(Looper.getMainLooper(), true), null, 2, null);
            g42.a(objA);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
    }

    public static final Handler a(Looper looper, boolean z) throws IllegalAccessException, InvocationTargetException {
        int i;
        if (!z || (i = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
