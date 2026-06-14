package a;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f5665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f199a;
    public static Field b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f200b;
    public static Field c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f201c;
    public static boolean d;

    public static void a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            d(resources);
        } else if (i >= 23) {
            c(resources);
        } else if (i >= 21) {
            b(resources);
        }
    }

    public static void b(Resources resources) {
        if (!f199a) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f198a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f199a = true;
        }
        Field field = f198a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    public static void c(Resources resources) {
        if (!f199a) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f198a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f199a = true;
        }
        Object obj = null;
        Field field = f198a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    public static void d(Resources resources) {
        Object obj;
        if (!d) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            d = true;
        }
        Field field = c;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f199a) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f198a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f199a = true;
        }
        Field field2 = f198a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    public static void e(Object obj) {
        if (!f200b) {
            try {
                f5665a = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f200b = true;
        }
        Class<?> cls = f5665a;
        if (cls == null) {
            return;
        }
        if (!f201c) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f201c = true;
        }
        Field field = b;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
