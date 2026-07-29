package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f9822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f9823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9824d;

    public b(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 FrameLayout frameLayout) {
        this.f9821a = linearLayout;
        this.f9822b = imageView;
        this.f9823c = textView;
        this.f9824d = frameLayout;
    }

    @g.n0
    public static b a(@g.n0 View view) {
        int i10 = R.id.btn_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.btn_help;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.container;
                FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
                if (frameLayout != null) {
                    return new b((LinearLayout) view, imageView, textView, frameLayout);
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
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_device_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9821a;
    }
}
