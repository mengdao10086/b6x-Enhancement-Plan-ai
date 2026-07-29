package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.fdg.flashplay.farsef.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f9219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f9220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RecyclerView f9221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final SmartRefreshLayout f9222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f9223f;

    public m(@n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout, @n0 TextView textView, @n0 RecyclerView recyclerView, @n0 SmartRefreshLayout smartRefreshLayout, @n0 TextView textView2) {
        this.f9218a = constraintLayout;
        this.f9219b = linearLayout;
        this.f9220c = textView;
        this.f9221d = recyclerView;
        this.f9222e = smartRefreshLayout;
        this.f9223f = textView2;
    }

    @n0
    public static m a(@n0 View view) {
        int i10 = R.id.area_order_info;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, R.id.area_order_info);
        if (linearLayout != null) {
            i10 = R.id.btn_submit;
            TextView textView = (TextView) j2.c.a(view, R.id.btn_submit);
            if (textView != null) {
                i10 = R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) j2.c.a(view, R.id.recycler_view);
                if (recyclerView != null) {
                    i10 = R.id.refresh_layout;
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) j2.c.a(view, R.id.refresh_layout);
                    if (smartRefreshLayout != null) {
                        i10 = R.id.tv_price;
                        TextView textView2 = (TextView) j2.c.a(view, R.id.tv_price);
                        if (textView2 != null) {
                            return new m((ConstraintLayout) view, linearLayout, textView, recyclerView, smartRefreshLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static m c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static m d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_fragment_mall_product_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9218a;
    }
}
