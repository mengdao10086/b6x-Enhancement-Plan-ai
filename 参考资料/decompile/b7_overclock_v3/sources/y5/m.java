package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f56377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f56378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final RecyclerView f56382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f56383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f56384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final View f56385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f56386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final View f56387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final TextView f56388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final View f56389n;

    public m(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 ConstraintLayout constraintLayout, @n0 ConstraintLayout constraintLayout2, @n0 ConstraintLayout constraintLayout3, @n0 RecyclerView recyclerView, @n0 TextView textView, @n0 TextView textView2, @n0 View view, @n0 TextView textView3, @n0 View view2, @n0 TextView textView4, @n0 View view3) {
        this.f56376a = linearLayout;
        this.f56377b = linearLayout2;
        this.f56378c = linearLayout3;
        this.f56379d = constraintLayout;
        this.f56380e = constraintLayout2;
        this.f56381f = constraintLayout3;
        this.f56382g = recyclerView;
        this.f56383h = textView;
        this.f56384i = textView2;
        this.f56385j = view;
        this.f56386k = textView3;
        this.f56387l = view2;
        this.f56388m = textView4;
        this.f56389n = view3;
    }

    @n0
    public static m a(@n0 View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i10 = R.id.area_filter;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.btn_handle_category;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.btn_type_all;
                ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.btn_type_config;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
                    if (constraintLayout2 != null) {
                        i10 = R.id.btn_type_raider;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) j2.c.a(view, i10);
                        if (constraintLayout3 != null) {
                            i10 = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                            if (recyclerView != null) {
                                i10 = R.id.tv_handle_category;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_type_all;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null && (viewA = j2.c.a(view, (i10 = R.id.tv_type_all_indicator))) != null) {
                                        i10 = R.id.tv_type_config;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null && (viewA2 = j2.c.a(view, (i10 = R.id.tv_type_config_indicator))) != null) {
                                            i10 = R.id.tv_type_raider;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null && (viewA3 = j2.c.a(view, (i10 = R.id.tv_type_raider_indicator))) != null) {
                                                return new m((LinearLayout) view, linearLayout, linearLayout2, constraintLayout, constraintLayout2, constraintLayout3, recyclerView, textView, textView2, viewA, textView3, viewA2, textView4, viewA3);
                                            }
                                        }
                                    }
                                }
                            }
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
        View viewInflate = layoutInflater.inflate(R.layout.community_fragment_search_result, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56376a;
    }
}
