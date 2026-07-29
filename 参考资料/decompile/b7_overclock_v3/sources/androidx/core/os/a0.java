package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@v0(17)
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public static Method f4647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public static Constructor<UserHandle> f4648b;

    @v0(24)
    public static class a {
        private a() {
        }

        @n0
        public static UserHandle a(int i10) {
            return UserHandle.getUserHandleForUid(i10);
        }
    }

    public static Method a() throws NoSuchMethodException {
        if (f4647a == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
            f4647a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f4647a;
    }

    public static Constructor<UserHandle> b() throws NoSuchMethodException {
        if (f4648b == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
            f4648b = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return f4648b;
    }

    @n0
    public static UserHandle c(int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(i10);
        }
        try {
            return b().newInstance((Integer) a().invoke(null, Integer.valueOf(i10)));
        } catch (IllegalAccessException e10) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e10);
            throw illegalAccessError;
        } catch (InstantiationException e11) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e11);
            throw instantiationError;
        } catch (NoSuchMethodException e12) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e12);
            throw noSuchMethodError;
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }
}
