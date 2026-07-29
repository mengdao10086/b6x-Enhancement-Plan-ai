package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f53970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FrameLayout f53971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f53972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f53973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f53974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f53975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f53976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f53977h;

    public b(@g.n0 ConstraintLayout constraintLayout, @g.n0 FrameLayout frameLayout, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f53970a = constraintLayout;
        this.f53971b = frameLayout;
        this.f53972c = imageView;
        this.f53973d = imageView2;
        this.f53974e = imageView3;
        this.f53975f = textView;
        this.f53976g = textView2;
        this.f53977h = textView3;
    }

    @g.n0
    public static b a(@g.n0 View view) {
        int i10 = R.id.area_shortcut;
        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.iv_arrow;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_current_in_use;
                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.iv_shortcut;
                    ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                    if (imageView3 != null) {
                        i10 = R.id.tv_in_top;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_name;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_shortcut;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    return new b((ConstraintLayout) view, frameLayout, imageView, imageView2, imageView3, textView, textView2, textView3);
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
    public static b c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static b d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_item_local_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f53970a;
    }
}
