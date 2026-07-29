package yg;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes5.dex */
public class b implements ViewPager.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f57344a = 0.75f;

    @Override // androidx.viewpager.widget.ViewPager.k
    public void a(View view, float f10) {
        view.getWidth();
        float fAbs = ((1.0f - Math.abs(f10)) * 0.25f) + 0.75f;
        if (f10 < 0.0f) {
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
        } else if (f10 == 0.0f) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f10 <= 1.0f) {
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
        }
    }
}
