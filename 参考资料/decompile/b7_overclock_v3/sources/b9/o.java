package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f9227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f9228b;

    public o(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView) {
        this.f9227a = constraintLayout;
        this.f9228b = imageView;
    }

    @n0
    public static o a(@n0 View view) {
        ImageView imageView = (ImageView) j2.c.a(view, R.id.iv_product_desc);
        if (imageView != null) {
            return new o((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_product_desc)));
    }

    @n0
    public static o c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static o d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_item_mall_product_detail_describe, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f9227a;
    }
}
