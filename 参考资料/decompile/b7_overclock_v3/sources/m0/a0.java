package m0;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
import g.n0;
import g.v0;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@v0(28)
public class a0 extends z {
    public static final String B = "createFromFamiliesWithDefault";
    public static final int C = -1;
    public static final String D = "sans-serif";

    @Override // m0.z
    public Method B(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // m0.z, m0.x, m0.c0
    @n0
    public Typeface g(@n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        return Typeface.create(typeface, i10, z10);
    }

    @Override // m0.z
    public Typeface p(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f40605m, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f40611s.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }
}
