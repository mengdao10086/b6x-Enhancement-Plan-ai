package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f9230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f9231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f9232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f9233e;

    public p(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3) {
        this.f9229a = constraintLayout;
        this.f9230b = imageView;
        this.f9231c = textView;
        this.f9232d = textView2;
        this.f9233e = textView3;
    }

    @n0
    public static p a(@n0 View view) {
        int i10 = R.id.iv_product;
        ImageView imageView = (ImageView) j2.c.a(view, R.id.iv_product);
        if (imageView != null) {
            i10 = R.id.tv_price;
            TextView textView = (TextView) j2.c.a(view, R.id.tv_price);
            if (textView != null) {
                i10 = R.id.tv_price_unit;
                TextView textView2 = (TextView) j2.c.a(view, R.id.tv_price_unit);
                if (textView2 != null) {
                    i10 = R.id.tv_product;
                    TextView textView3 = (TextView) j2.c.a(view, R.id.tv_product);
                    if (textView3 != null) {
                        return new p((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static p c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static p d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_item_mall_product_detail_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9229a;
    }
}
