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
public final class n implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f9225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f9226c;

    public n(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 TextView textView) {
        this.f9224a = constraintLayout;
        this.f9225b = imageView;
        this.f9226c = textView;
    }

    @n0
    public static n a(@n0 View view) {
        int i10 = R.id.iv_product;
        ImageView imageView = (ImageView) j2.c.a(view, R.id.iv_product);
        if (imageView != null) {
            i10 = R.id.tv_product;
            TextView textView = (TextView) j2.c.a(view, R.id.tv_product);
            if (textView != null) {
                return new n((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static n c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static n d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_item_mall_product, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9224a;
    }
}
