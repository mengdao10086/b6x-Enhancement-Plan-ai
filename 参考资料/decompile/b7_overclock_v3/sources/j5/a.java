package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.flydigi.base.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f36067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final FrameLayout f36068b;

    public a(@n0 FrameLayout frameLayout, @n0 FrameLayout frameLayout2) {
        this.f36067a = frameLayout;
        this.f36068b = frameLayout2;
    }

    @n0
    public static a a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        FrameLayout frameLayout = (FrameLayout) view;
        return new a(frameLayout, frameLayout);
    }

    @n0
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_fragment, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f36067a;
    }
}
