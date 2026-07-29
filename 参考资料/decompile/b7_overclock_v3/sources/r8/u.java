package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f47838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f47839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RecyclerView f47840d;

    public u(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 RecyclerView recyclerView) {
        this.f47837a = linearLayout;
        this.f47838b = linearLayout2;
        this.f47839c = linearLayout3;
        this.f47840d = recyclerView;
    }

    @n0
    public static u a(@n0 View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.ll_select;
        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout2 != null) {
            i10 = R.id.rv_content;
            RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
            if (recyclerView != null) {
                return new u(linearLayout, linearLayout, linearLayout2, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static u c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static u d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_view_game_cat, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47837a;
    }
}
