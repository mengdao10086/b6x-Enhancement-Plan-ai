package a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class r20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f7263a = {R.attr.theme, zu.theme};
    public static final int[] b = {zu.materialThemeOverlay};

    public static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7263a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    public static int b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i, int i2) {
        int iB = b(context, attributeSet, i, i2);
        boolean z = (context instanceof m3) && ((m3) context).c() == iB;
        if (iB == 0 || z) {
            return context;
        }
        m3 m3Var = new m3(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            m3Var.getTheme().applyStyle(iA, true);
        }
        return m3Var;
    }
}
