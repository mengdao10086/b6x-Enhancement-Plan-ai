package yg;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes5.dex */
public class c implements ViewPager.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f57345a;

    @Override // androidx.viewpager.widget.ViewPager.k
    public void a(View view, float f10) {
        view.setTranslationX(view.getWidth() * (-f10));
        float height = f10 * view.getHeight();
        this.f57345a = height;
        view.setTranslationY(height);
    }

    public float b() {
        return this.f57345a;
    }
}
