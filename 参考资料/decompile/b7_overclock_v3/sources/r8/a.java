package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.flydigi.game.R;
import g.n0;
import g.p0;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f47749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f47750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final MagicIndicator f47751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ViewPager f47752e;

    public a(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 MagicIndicator magicIndicator, @n0 ViewPager viewPager) {
        this.f47748a = linearLayout;
        this.f47749b = linearLayout2;
        this.f47750c = linearLayout3;
        this.f47751d = magicIndicator;
        this.f47752e = viewPager;
    }

    @n0
    public static a a(@n0 View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.ll_select;
        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout2 != null) {
            i10 = R.id.magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) j2.c.a(view, i10);
            if (magicIndicator != null) {
                i10 = R.id.vp_game_category;
                ViewPager viewPager = (ViewPager) j2.c.a(view, i10);
                if (viewPager != null) {
                    return new a(linearLayout, linearLayout, linearLayout2, magicIndicator, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_category, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47748a;
    }
}
