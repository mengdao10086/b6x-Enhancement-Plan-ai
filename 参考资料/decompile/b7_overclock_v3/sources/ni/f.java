package ni;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f42203b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Map<String, Field>> f42204a = new HashMap();

    public static f b() {
        return f42203b;
    }

    @Nonnull
    public synchronized Field a(Class<?> cls, String str) {
        Field declaredField;
        Map<String, Field> map = this.f42204a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.f42204a.put(cls, map);
        }
        declaredField = map.get(str);
        if (declaredField == null) {
            try {
                declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                map.put(str, declaredField);
            } catch (NoSuchFieldException e10) {
                throw new IllegalStateException(e10);
            }
        }
        return declaredField;
    }
}
