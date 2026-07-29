package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.daasuu.bl.BubbleLayout;
import com.flydigi.device_manager.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class h1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final SmartRefreshLayout f10084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final BubbleLayout f10085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final SmartRefreshLayout f10087d;

    public h1(@g.n0 SmartRefreshLayout smartRefreshLayout, @g.n0 BubbleLayout bubbleLayout, @g.n0 RecyclerView recyclerView, @g.n0 SmartRefreshLayout smartRefreshLayout2) {
        this.f10084a = smartRefreshLayout;
        this.f10085b = bubbleLayout;
        this.f10086c = recyclerView;
        this.f10087d = smartRefreshLayout2;
    }

    @g.n0
    public static h1 a(@g.n0 View view) {
        int i10 = R.id.bubble;
        BubbleLayout bubbleLayout = (BubbleLayout) j2.c.a(view, i10);
        if (bubbleLayout != null) {
            i10 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
            if (recyclerView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view;
                return new h1(smartRefreshLayout, bubbleLayout, recyclerView, smartRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static h1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static h1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_my_game_zone, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SmartRefreshLayout getRoot() {
        return this.f10084a;
    }
}
