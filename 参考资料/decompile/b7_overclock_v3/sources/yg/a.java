package yg;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes5.dex */
public class a implements ViewPager.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f57342a = 0.5f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f57343b = 30.0f;

    @Override // androidx.viewpager.widget.ViewPager.k
    public void a(View view, float f10) {
        float fAbs = ((1.0f - Math.abs(f10)) * 0.5f) + 0.5f;
        float fAbs2 = Math.abs(f10) * 30.0f;
        if (f10 <= 0.0f) {
            view.setTranslationX(view.getWidth() * (-f10) * 0.19f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setPivotX(view.getWidth() * 0.5f);
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
            view.setRotationY(fAbs2);
            return;
        }
        if (f10 <= 1.0f) {
            view.setTranslationX(view.getWidth() * (-f10) * 0.19f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setPivotX(view.getWidth() * 0.5f);
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
            view.setRotationY(-fAbs2);
        }
    }
}
