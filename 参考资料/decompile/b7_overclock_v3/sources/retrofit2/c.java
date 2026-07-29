package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface c<R, T> {

    public static abstract class a {
        public static Type b(int i10, ParameterizedType parameterizedType) {
            return w.g(i10, parameterizedType);
        }

        public static Class<?> c(Type type) {
            return w.h(type);
        }

        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, s sVar);
    }

    Type a();

    T b(b<R> bVar);
}
