package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.flydigi.community.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final CoordinatorLayout f56318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final AppBarLayout f56319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Toolbar f56320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final SuperButton f56321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final CollapsingToolbarLayout f56322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ImageView f56323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TabLayout f56324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f56325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f56326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f56327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final ViewPager2 f56328k;

    public f(@n0 CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, @n0 Toolbar toolbar, @n0 SuperButton superButton, @n0 CollapsingToolbarLayout collapsingToolbarLayout, @n0 ImageView imageView, @n0 TabLayout tabLayout, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 ViewPager2 viewPager2) {
        this.f56318a = coordinatorLayout;
        this.f56319b = appBarLayout;
        this.f56320c = toolbar;
        this.f56321d = superButton;
        this.f56322e = collapsingToolbarLayout;
        this.f56323f = imageView;
        this.f56324g = tabLayout;
        this.f56325h = textView;
        this.f56326i = textView2;
        this.f56327j = textView3;
        this.f56328k = viewPager2;
    }

    @n0
    public static f a(@n0 View view) {
        int i10 = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) j2.c.a(view, i10);
        if (appBarLayout != null) {
            i10 = R.id.appbar_layout_toolbar;
            Toolbar toolbar = (Toolbar) j2.c.a(view, i10);
            if (toolbar != null) {
                i10 = R.id.btn_post;
                SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                if (superButton != null) {
                    i10 = R.id.collapsing_toolbar_layout;
                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) j2.c.a(view, i10);
                    if (collapsingToolbarLayout != null) {
                        i10 = R.id.iv_background;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.tab_layout;
                            TabLayout tabLayout = (TabLayout) j2.c.a(view, i10);
                            if (tabLayout != null) {
                                i10 = R.id.tv_count;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_desc;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_title;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.view_pager;
                                            ViewPager2 viewPager2 = (ViewPager2) j2.c.a(view, i10);
                                            if (viewPager2 != null) {
                                                return new f((CoordinatorLayout) view, appBarLayout, toolbar, superButton, collapsingToolbarLayout, imageView, tabLayout, textView, textView2, textView3, viewPager2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static f c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_activity_topic_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.f56318a;
    }
}
