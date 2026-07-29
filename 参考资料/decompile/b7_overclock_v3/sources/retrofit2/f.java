package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.c0;
import okhttp3.e0;

/* JADX INFO: loaded from: classes6.dex */
public interface f<F, T> {

    public static abstract class a {
        public static Type a(int i10, ParameterizedType parameterizedType) {
            return w.g(i10, parameterizedType);
        }

        public static Class<?> b(Type type) {
            return w.h(type);
        }

        @Nullable
        public f<?, c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
            return null;
        }

        @Nullable
        public f<e0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

        @Nullable
        public f<?, String> e(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }
    }

    @Nullable
    T a(F f10) throws IOException;
}
