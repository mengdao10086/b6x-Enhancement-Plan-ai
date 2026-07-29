package vd;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.loader.ResourcesLoader;
import android.os.Build;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.v0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53083a = "j";

    @v0(api = 21)
    public static void a(@n0 Map<Integer, Integer> map, @n0 TypedArray typedArray, @p0 TypedArray typedArray2, @g.l int i10) {
        if (typedArray2 == null) {
            typedArray2 = typedArray;
        }
        for (int i11 = 0; i11 < typedArray.getIndexCount(); i11++) {
            int resourceId = typedArray2.getResourceId(i11, 0);
            if (resourceId != 0 && typedArray.hasValue(i11) && e(typedArray.getType(i11))) {
                map.put(Integer.valueOf(resourceId), Integer.valueOf(m.j(typedArray.getColor(i11, 0), i10)));
            }
        }
    }

    @v0(api = 30)
    public static boolean b(Context context, Map<Integer, Integer> map) throws Throwable {
        ResourcesLoader resourcesLoaderA = c.a(context, map);
        if (resourcesLoaderA == null) {
            return false;
        }
        context.getResources().addLoaders(resourcesLoaderA);
        return true;
    }

    @n0
    public static void c(@n0 Context context, @n0 k kVar) {
        if (f()) {
            Map<Integer, Integer> mapD = d(context, kVar);
            int iE = kVar.e(0);
            if (!b(context, mapD) || iE == 0) {
                return;
            }
            o.a(context, iE);
        }
    }

    @v0(api = 21)
    public static Map<Integer, Integer> d(Context context, k kVar) {
        HashMap map = new HashMap();
        int iC = m.c(context, kVar.b(), f53083a);
        for (int i10 : kVar.d()) {
            map.put(Integer.valueOf(i10), Integer.valueOf(m.j(h0.d.f(context, i10), iC)));
        }
        i iVarC = kVar.c();
        if (iVarC != null) {
            int[] iArrD = iVarC.d();
            if (iArrD.length > 0) {
                int iE = iVarC.e();
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArrD);
                TypedArray typedArrayObtainStyledAttributes2 = iE != 0 ? new ContextThemeWrapper(context, iE).obtainStyledAttributes(iArrD) : null;
                a(map, typedArrayObtainStyledAttributes, typedArrayObtainStyledAttributes2, iC);
                typedArrayObtainStyledAttributes.recycle();
                if (typedArrayObtainStyledAttributes2 != null) {
                    typedArrayObtainStyledAttributes2.recycle();
                }
            }
        }
        return map;
    }

    public static boolean e(int i10) {
        return 28 <= i10 && i10 <= 31;
    }

    @g.k(api = 30)
    public static boolean f() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @n0
    public static Context g(@n0 Context context, @n0 k kVar) {
        if (!f()) {
            return context;
        }
        Map<Integer, Integer> mapD = d(context, kVar);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, kVar.e(R.style.ThemeOverlay_Material3_HarmonizedColors_Empty));
        contextThemeWrapper.applyOverrideConfiguration(new Configuration());
        return b(contextThemeWrapper, mapD) ? contextThemeWrapper : context;
    }
}
