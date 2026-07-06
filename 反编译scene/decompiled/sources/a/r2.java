package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedAPI"})
public abstract class r2 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadLocal<TypedValue> f2683a = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final WeakHashMap<Context, SparseArray<q2>> f2684a = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7262a = new Object();

    public static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f7262a) {
            SparseArray<q2> sparseArray = f2684a.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f2684a.put(context, sparseArray);
            }
            sparseArray.append(i, new q2(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static ColorStateList b(Context context, int i) {
        q2 q2Var;
        synchronized (f7262a) {
            SparseArray<q2> sparseArray = f2684a.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (q2Var = sparseArray.get(i)) != null) {
                if (q2Var.f2535a.equals(context.getResources().getConfiguration())) {
                    return q2Var.f7170a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListB = b(context, i);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListF = f(context, i);
        if (colorStateListF == null) {
            return yb.c(context, i);
        }
        a(context, i, colorStateListF);
        return colorStateListF;
    }

    public static Drawable d(Context context, int i) {
        return d8.h().j(context, i);
    }

    public static TypedValue e() {
        TypedValue typedValue = f2683a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f2683a.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList f(Context context, int i) {
        if (g(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return bc.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    public static boolean g(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValueE = e();
        resources.getValue(i, typedValueE, true);
        int i2 = typedValueE.type;
        return i2 >= 28 && i2 <= 31;
    }
}
