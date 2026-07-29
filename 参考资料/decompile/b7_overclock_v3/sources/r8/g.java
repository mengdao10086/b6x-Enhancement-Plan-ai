package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.game.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tmall.ultraviewpager.UltraViewPager;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f47788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f47789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RecyclerView f47790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f47791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final UltraViewPager f47792f;

    public g(@n0 LinearLayout linearLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 RecyclerView recyclerView, @n0 SmartRefreshLayout smartRefreshLayout, @n0 UltraViewPager ultraViewPager) {
        this.f47787a = linearLayout;
        this.f47788b = imageView;
        this.f47789c = imageView2;
        this.f47790d = recyclerView;
        this.f47791e = smartRefreshLayout;
        this.f47792f = ultraViewPager;
    }

    @n0
    public static g a(@n0 View view) {
        int i10 = R.id.btn_download;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.btn_search;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.rv_content;
                RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.smart_refresh_layout;
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) j2.c.a(view, i10);
                    if (smartRefreshLayout != null) {
                        i10 = R.id.ultra_view_pager;
                        UltraViewPager ultraViewPager = (UltraViewPager) j2.c.a(view, i10);
                        if (ultraViewPager != null) {
                            return new g((LinearLayout) view, imageView, imageView2, recyclerView, smartRefreshLayout, ultraViewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static g c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static g d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47787a;
    }
}
