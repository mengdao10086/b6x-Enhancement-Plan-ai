package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.view.ProductHelpItem;

/* JADX INFO: loaded from: classes7.dex */
public final class i1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f10102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ProductHelpItem f10103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f10106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10110i;

    public i1(@g.n0 NestedScrollView nestedScrollView, @g.n0 ProductHelpItem productHelpItem, @g.n0 ActionItemNormal actionItemNormal, @g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f10102a = nestedScrollView;
        this.f10103b = productHelpItem;
        this.f10104c = actionItemNormal;
        this.f10105d = linearLayout;
        this.f10106e = imageView;
        this.f10107f = recyclerView;
        this.f10108g = textView;
        this.f10109h = textView2;
        this.f10110i = textView3;
    }

    @g.n0
    public static i1 a(@g.n0 View view) {
        int i10 = R.id.action_help;
        ProductHelpItem productHelpItem = (ProductHelpItem) j2.c.a(view, i10);
        if (productHelpItem != null) {
            i10 = R.id.action_test;
            ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
            if (actionItemNormal != null) {
                i10 = R.id.area_qa;
                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.iv_device;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                        if (recyclerView != null) {
                            i10 = R.id.tv_device_name;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                i10 = R.id.tv_tech_name;
                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.tv_title_qa;
                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                    if (textView3 != null) {
                                        return new i1((NestedScrollView) view, productHelpItem, actionItemNormal, linearLayout, imageView, recyclerView, textView, textView2, textView3);
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

    @g.n0
    public static i1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_non_gamepad_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f10102a;
    }
}
