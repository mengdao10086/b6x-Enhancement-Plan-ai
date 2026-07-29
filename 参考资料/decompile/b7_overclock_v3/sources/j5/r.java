package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f36142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final RecyclerView f36143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f36144c;

    public r(@n0 SmartRefreshLayout smartRefreshLayout, @n0 RecyclerView recyclerView, @n0 SmartRefreshLayout smartRefreshLayout2) {
        this.f36142a = smartRefreshLayout;
        this.f36143b = recyclerView;
        this.f36144c = smartRefreshLayout2;
    }

    @n0
    public static r a(@n0 View view) {
        int i10 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view;
        return new r(smartRefreshLayout, recyclerView, smartRefreshLayout);
    }

    @n0
    public static r c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static r d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_recycler_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout getRoot() {
        return this.f36142a;
    }
}
