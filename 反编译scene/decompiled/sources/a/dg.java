package a;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f5895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f554a;

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f554a) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                f5895a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f554a = true;
        }
        Field field = f5895a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                a(layoutInflater, factory2);
            }
        }
    }
}
