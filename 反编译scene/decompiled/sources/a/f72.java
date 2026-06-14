package a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f72 {
    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        f92.d(th, "cause");
        f92.d(th2, "exception");
        Method method = e72.f5976a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public z92 b() {
        return new x92();
    }
}
