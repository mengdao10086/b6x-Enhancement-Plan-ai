package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class t<T> {
    public static <T> t<T> b(s sVar, Method method) {
        q qVarB = q.b(sVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (w.j(genericReturnType)) {
            throw w.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return j.f(sVar, method, qVarB);
        }
        throw w.m(method, "Service methods cannot return void.", new Object[0]);
    }

    @Nullable
    public abstract T a(Object[] objArr);
}
