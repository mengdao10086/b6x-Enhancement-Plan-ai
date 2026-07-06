package a;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class rd2 {
    public static final void a(l62 l62Var, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) l62Var.get(CoroutineExceptionHandler.f8936a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(l62Var, th);
            } else {
                qd2.a(l62Var, th);
            }
        } catch (Throwable th2) {
            qd2.a(l62Var, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        x32.a(runtimeException, th);
        return runtimeException;
    }
}
