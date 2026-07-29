package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f54105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f54107d;

    public g(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 LinearLayout linearLayout2, @g.n0 TextView textView) {
        this.f54104a = linearLayout;
        this.f54105b = imageView;
        this.f54106c = linearLayout2;
        this.f54107d = textView;
    }

    @g.n0
    public static g a(@g.n0 View view) {
        int i10 = R.id.iv_unconnected;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.ll_bg;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.tv_content;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    return new g((LinearLayout) view, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_connect_state, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54104a;
    }
}
