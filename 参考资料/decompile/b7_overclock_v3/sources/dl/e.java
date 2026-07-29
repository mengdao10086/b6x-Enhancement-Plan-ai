package dl;

import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    public static class a implements ViewPager.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MagicIndicator f26306a;

        public a(MagicIndicator magicIndicator) {
            this.f26306a = magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            this.f26306a.a(i10);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            this.f26306a.b(i10, f10, i11);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            this.f26306a.c(i10);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.e(new a(magicIndicator));
    }
}
