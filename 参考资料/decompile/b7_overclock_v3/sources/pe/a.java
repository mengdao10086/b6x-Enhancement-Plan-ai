package pe;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import g.d1;
import g.f;
import g.n0;
import g.p0;
import l.d;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f46602a = {R.attr.theme, com.google.android.material.R.attr.theme};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f46603b = {com.google.android.material.R.attr.materialThemeOverlay};

    @d1
    public static int a(@n0 Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f46602a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    @d1
    public static int b(@n0 Context context, @p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f46603b, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @n0
    public static Context c(@n0 Context context, @p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        int iB = b(context, attributeSet, i10, i11);
        boolean z10 = (context instanceof d) && ((d) context).c() == iB;
        if (iB == 0 || z10) {
            return context;
        }
        d dVar = new d(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            dVar.getTheme().applyStyle(iA, true);
        }
        return dVar;
    }
}
