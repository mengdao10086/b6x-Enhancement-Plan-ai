package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final RecyclerView f56370b;

    public k0(@n0 LinearLayout linearLayout, @n0 RecyclerView recyclerView) {
        this.f56369a = linearLayout;
        this.f56370b = recyclerView;
    }

    @n0
    public static k0 a(@n0 View view) {
        int i10 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
        if (recyclerView != null) {
            return new k0((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static k0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static k0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_pop_window_device_category_choose, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56369a;
    }
}
