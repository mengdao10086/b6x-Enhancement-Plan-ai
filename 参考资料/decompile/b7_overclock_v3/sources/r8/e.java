package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.game.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f47764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final RecyclerView f47765b;

    public e(@n0 SmartRefreshLayout smartRefreshLayout, @n0 RecyclerView recyclerView) {
        this.f47764a = smartRefreshLayout;
        this.f47765b = recyclerView;
    }

    @n0
    public static e a(@n0 View view) {
        int i10 = R.id.rv_content;
        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
        if (recyclerView != null) {
            return new e((SmartRefreshLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static e c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static e d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_downloaded, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout getRoot() {
        return this.f47764a;
    }
}
