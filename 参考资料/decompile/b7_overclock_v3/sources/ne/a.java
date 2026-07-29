package ne;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.google.android.material.tabs.a {
    public static float e(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return (float) (1.0d - Math.cos((((double) f10) * 3.141592653589793d) / 2.0d));
    }

    public static float f(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return (float) Math.sin((((double) f10) * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.a
    public void d(TabLayout tabLayout, View view, View view2, float f10, @n0 Drawable drawable) {
        float f11;
        float fE;
        RectF rectFA = com.google.android.material.tabs.a.a(tabLayout, view);
        RectF rectFA2 = com.google.android.material.tabs.a.a(tabLayout, view2);
        if (rectFA.left < rectFA2.left) {
            f11 = e(f10);
            fE = f(f10);
        } else {
            f11 = f(f10);
            fE = e(f10);
        }
        drawable.setBounds(kd.a.c((int) rectFA.left, (int) rectFA2.left, f11), drawable.getBounds().top, kd.a.c((int) rectFA.right, (int) rectFA2.right, fE), drawable.getBounds().bottom);
    }
}
