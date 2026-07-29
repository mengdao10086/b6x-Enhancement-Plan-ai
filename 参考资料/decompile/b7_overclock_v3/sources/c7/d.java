package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import com.flydigi.device_manager.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final CoordinatorLayout f9897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f9898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FloatingActionButton f9899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FragmentContainerView f9900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final Toolbar f9901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f9902f;

    public d(@g.n0 CoordinatorLayout coordinatorLayout, @g.n0 NestedScrollView nestedScrollView, @g.n0 FloatingActionButton floatingActionButton, @g.n0 FragmentContainerView fragmentContainerView, @g.n0 Toolbar toolbar, @g.n0 TextView textView) {
        this.f9897a = coordinatorLayout;
        this.f9898b = nestedScrollView;
        this.f9899c = floatingActionButton;
        this.f9900d = fragmentContainerView;
        this.f9901e = toolbar;
        this.f9902f = textView;
    }

    @g.n0
    public static d a(@g.n0 View view) {
        int i10 = R.id.area_diagnose_info;
        NestedScrollView nestedScrollView = (NestedScrollView) j2.c.a(view, i10);
        if (nestedScrollView != null) {
            i10 = R.id.fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) j2.c.a(view, i10);
            if (floatingActionButton != null) {
                i10 = R.id.fl_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) j2.c.a(view, i10);
                if (fragmentContainerView != null) {
                    i10 = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) j2.c.a(view, i10);
                    if (toolbar != null) {
                        i10 = R.id.tv_info;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            return new d((CoordinatorLayout) view, nestedScrollView, floatingActionButton, fragmentContainerView, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static d c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static d d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_diagnose, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.f9897a;
    }
}
