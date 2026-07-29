package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.flydigi.float_view.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54125b;

    public h(@g.n0 FrameLayout frameLayout, @g.n0 FrameLayout frameLayout2) {
        this.f54124a = frameLayout;
        this.f54125b = frameLayout2;
    }

    @g.n0
    public static h a(@g.n0 View view) {
        Objects.requireNonNull(view, "rootView");
        FrameLayout frameLayout = (FrameLayout) view;
        return new h(frameLayout, frameLayout);
    }

    @g.n0
    public static h c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static h d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_container, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54124a;
    }
}
