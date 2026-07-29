package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f36091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ProgressBar f36092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final FrameLayout f36093c;

    public e(@n0 FrameLayout frameLayout, @n0 ProgressBar progressBar, @n0 FrameLayout frameLayout2) {
        this.f36091a = frameLayout;
        this.f36092b = progressBar;
        this.f36093c = frameLayout2;
    }

    @n0
    public static e a(@n0 View view) {
        int i10 = R.id.pb_progress;
        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
        if (progressBar != null) {
            i10 = R.id.web_container;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                return new e((FrameLayout) view, progressBar, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static e c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static e d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.base_fragment_web, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f36091a;
    }
}
