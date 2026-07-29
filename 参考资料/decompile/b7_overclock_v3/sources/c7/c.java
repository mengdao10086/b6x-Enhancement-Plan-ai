package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f9867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9868c;

    public c(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 FrameLayout frameLayout) {
        this.f9866a = linearLayout;
        this.f9867b = imageView;
        this.f9868c = frameLayout;
    }

    @g.n0
    public static c a(@g.n0 View view) {
        int i10 = R.id.btn_back;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.fl_container;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                return new c((LinearLayout) view, imageView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static c c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_device_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9866a;
    }
}
