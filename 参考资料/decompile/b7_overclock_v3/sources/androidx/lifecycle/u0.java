package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final List<Class<?>> f6260a = CollectionsKt__CollectionsKt.L(Application.class, r0.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final List<Class<?>> f6261b = kotlin.collections.s.k(r0.class);

    @yt.l
    public static final <T> Constructor<T> c(@yt.k Class<T> modelClass, @yt.k List<? extends Class<?>> signature) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        kotlin.jvm.internal.f0.p(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.f0.o(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.f0.o(parameterTypes, "constructor.parameterTypes");
            List listIz = ArraysKt___ArraysKt.iz(parameterTypes);
            if (kotlin.jvm.internal.f0.g(signature, listIz)) {
                kotlin.jvm.internal.f0.n(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == listIz.size() && listIz.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends x0> T d(@yt.k Class<T> modelClass, @yt.k Constructor<T> constructor, @yt.k Object... params) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.jvm.internal.f0.p(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + modelClass, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e12.getCause());
        }
    }
}
