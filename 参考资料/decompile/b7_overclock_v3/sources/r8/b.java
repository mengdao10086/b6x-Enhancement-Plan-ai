package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.game.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final RecyclerView f47754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f47755c;

    public b(@n0 LinearLayout linearLayout, @n0 RecyclerView recyclerView, @n0 SmartRefreshLayout smartRefreshLayout) {
        this.f47753a = linearLayout;
        this.f47754b = recyclerView;
        this.f47755c = smartRefreshLayout;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.rv_content;
        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
        if (recyclerView != null) {
            i10 = R.id.smart_refresh_layout;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) j2.c.a(view, i10);
            if (smartRefreshLayout != null) {
                return new b((LinearLayout) view, recyclerView, smartRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static b c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_category_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47753a;
    }
}
