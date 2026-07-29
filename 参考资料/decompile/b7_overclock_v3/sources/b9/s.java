package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ImageView f9237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f9238b;

    public s(@n0 ImageView imageView, @n0 ImageView imageView2) {
        this.f9237a = imageView;
        this.f9238b = imageView2;
    }

    @n0
    public static s a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        ImageView imageView = (ImageView) view;
        return new s(imageView, imageView);
    }

    @n0
    public static s c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static s d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_layout_community_home_banner, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ImageView getRoot() {
        return this.f9237a;
    }
}
