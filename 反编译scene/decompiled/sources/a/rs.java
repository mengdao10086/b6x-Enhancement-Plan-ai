package a;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class rs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LayoutTransition f7327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f2775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Method f2776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2777a;
    public static boolean b;

    public static void a(LayoutTransition layoutTransition) {
        if (!b) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f2776a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            b = true;
        }
        Method method = f2776a;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    public static void b(ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        boolean z2 = false;
        if (f7327a == null) {
            qs qsVar = new qs();
            f7327a = qsVar;
            qsVar.setAnimator(2, null);
            f7327a.setAnimator(0, null);
            f7327a.setAnimator(1, null);
            f7327a.setAnimator(3, null);
            f7327a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition2 = viewGroup.getLayoutTransition();
            if (layoutTransition2 != null) {
                if (layoutTransition2.isRunning()) {
                    a(layoutTransition2);
                }
                if (layoutTransition2 != f7327a) {
                    viewGroup.setTag(rr.transition_layout_save, layoutTransition2);
                }
            }
            layoutTransition = f7327a;
        } else {
            viewGroup.setLayoutTransition(null);
            if (!f2777a) {
                try {
                    Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                    f2775a = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                    Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
                }
                f2777a = true;
            }
            Field field = f2775a;
            if (field != null) {
                try {
                    boolean z3 = field.getBoolean(viewGroup);
                    if (z3) {
                        try {
                            f2775a.setBoolean(viewGroup, false);
                        } catch (IllegalAccessException unused2) {
                            z2 = z3;
                            Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                        }
                    }
                    z2 = z3;
                } catch (IllegalAccessException unused3) {
                }
            }
            if (z2) {
                viewGroup.requestLayout();
            }
            layoutTransition = (LayoutTransition) viewGroup.getTag(rr.transition_layout_save);
            if (layoutTransition == null) {
                return;
            } else {
                viewGroup.setTag(rr.transition_layout_save, null);
            }
        }
        viewGroup.setLayoutTransition(layoutTransition);
    }
}
