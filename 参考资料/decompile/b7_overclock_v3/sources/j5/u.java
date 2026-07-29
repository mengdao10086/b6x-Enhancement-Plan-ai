package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.flydigi.base.R;
import com.google.android.material.appbar.AppBarLayout;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final AppBarLayout f36159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final AppBarLayout f36160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Toolbar f36161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f36162d;

    public u(@n0 AppBarLayout appBarLayout, @n0 AppBarLayout appBarLayout2, @n0 Toolbar toolbar, @n0 TextView textView) {
        this.f36159a = appBarLayout;
        this.f36160b = appBarLayout2;
        this.f36161c = toolbar;
        this.f36162d = textView;
    }

    @n0
    public static u a(@n0 View view) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        int i10 = R.id.toolbar;
        Toolbar toolbar = (Toolbar) j2.c.a(view, i10);
        if (toolbar != null) {
            i10 = R.id.tv_title_toolbar;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new u(appBarLayout, appBarLayout, toolbar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static u c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static u d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_toolbar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppBarLayout getRoot() {
        return this.f36159a;
    }
}
