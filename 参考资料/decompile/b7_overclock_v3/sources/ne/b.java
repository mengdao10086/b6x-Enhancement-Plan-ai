package ne;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.google.android.material.tabs.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f42078b = 0.5f;

    @Override // com.google.android.material.tabs.a
    public void d(TabLayout tabLayout, View view, View view2, float f10, @n0 Drawable drawable) {
        if (f10 >= 0.5f) {
            view = view2;
        }
        RectF rectFA = com.google.android.material.tabs.a.a(tabLayout, view);
        float fB = f10 < 0.5f ? kd.a.b(1.0f, 0.0f, 0.0f, 0.5f, f10) : kd.a.b(0.0f, 1.0f, 0.5f, 1.0f, f10);
        drawable.setBounds((int) rectFA.left, drawable.getBounds().top, (int) rectFA.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (fB * 255.0f));
    }
}
