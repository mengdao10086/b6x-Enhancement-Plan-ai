package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final CoordinatorLayout f36077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final FragmentContainerView f36078b;

    public b(@n0 CoordinatorLayout coordinatorLayout, @n0 FragmentContainerView fragmentContainerView) {
        this.f36077a = coordinatorLayout;
        this.f36078b = fragmentContainerView;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.fl_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) j2.c.a(view, i10);
        if (fragmentContainerView != null) {
            return new b((CoordinatorLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static b c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_fragment_with_toolbar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.f36077a;
    }
}
