package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import g.n0;
import g.u;
import g.v0;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1669a = "ResourcesFlusher";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f1670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f1671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f1672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f1673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f1674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f1675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Field f1676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f1677i;

    @v0(16)
    public static class a {
        @u
        public static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    public static void a(@n0 Resources resources) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return;
        }
        if (i10 >= 24) {
            d(resources);
        } else if (i10 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    @v0(21)
    public static void b(@n0 Resources resources) {
        if (!f1671c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1670b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1671c = true;
        }
        Field field = f1670b;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    @v0(23)
    public static void c(@n0 Resources resources) {
        if (!f1671c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1670b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1671c = true;
        }
        Object obj = null;
        Field field = f1670b;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException unused2) {
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    @v0(24)
    public static void d(@n0 Resources resources) {
        Object obj;
        if (!f1677i) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f1676h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1677i = true;
        }
        Field field = f1676h;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException unused2) {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f1671c) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f1670b = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            f1671c = true;
        }
        Field field2 = f1670b;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException unused4) {
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    @v0(16)
    public static void e(@n0 Object obj) {
        if (!f1673e) {
            try {
                f1672d = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            f1673e = true;
        }
        Class<?> cls = f1672d;
        if (cls == null) {
            return;
        }
        if (!f1675g) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f1674f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
            }
            f1675g = true;
        }
        Field field = f1674f;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException unused3) {
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
