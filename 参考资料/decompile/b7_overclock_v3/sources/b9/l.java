package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.fdg.flashplay.farsef.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tmall.ultraviewpager.UltraViewPager;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final RecyclerView f9214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f9215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f9216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final UltraViewPager f9217e;

    public l(@n0 ConstraintLayout constraintLayout, @n0 RecyclerView recyclerView, @n0 SmartRefreshLayout smartRefreshLayout, @n0 TextView textView, @n0 UltraViewPager ultraViewPager) {
        this.f9213a = constraintLayout;
        this.f9214b = recyclerView;
        this.f9215c = smartRefreshLayout;
        this.f9216d = textView;
        this.f9217e = ultraViewPager;
    }

    @n0
    public static l a(@n0 View view) {
        int i10 = R.id.rv_game_list;
        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, R.id.rv_game_list);
        if (recyclerView != null) {
            i10 = R.id.smart_refresh_layout;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) j2.c.a(view, R.id.smart_refresh_layout);
            if (smartRefreshLayout != null) {
                i10 = R.id.tv_title;
                TextView textView = (TextView) j2.c.a(view, R.id.tv_title);
                if (textView != null) {
                    i10 = R.id.ultra_view_pager;
                    UltraViewPager ultraViewPager = (UltraViewPager) j2.c.a(view, R.id.ultra_view_pager);
                    if (ultraViewPager != null) {
                        return new l((ConstraintLayout) view, recyclerView, smartRefreshLayout, textView, ultraViewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static l c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static l d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_fragment_mall, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9213a;
    }
}
