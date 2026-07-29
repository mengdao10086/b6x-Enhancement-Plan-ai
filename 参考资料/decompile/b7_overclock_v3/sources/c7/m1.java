package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.device_manager.R;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class m1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ProgressBar f10227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TabLayout f10229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final MaterialDivider f10233l;

    public m1(@g.n0 FrameLayout frameLayout, @g.n0 LinearLayout linearLayout, @g.n0 FrameLayout frameLayout2, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 ProgressBar progressBar, @g.n0 RecyclerView recyclerView, @g.n0 TabLayout tabLayout, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 MaterialDivider materialDivider) {
        this.f10222a = frameLayout;
        this.f10223b = linearLayout;
        this.f10224c = frameLayout2;
        this.f10225d = imageView;
        this.f10226e = textView;
        this.f10227f = progressBar;
        this.f10228g = recyclerView;
        this.f10229h = tabLayout;
        this.f10230i = textView2;
        this.f10231j = textView3;
        this.f10232k = textView4;
        this.f10233l = materialDivider;
    }

    @g.n0
    public static m1 a(@g.n0 View view) {
        int i10 = R.id.area_scan_state;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_title;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.btn_close;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.btn_help;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.progress;
                        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                        if (progressBar != null) {
                            i10 = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                            if (recyclerView != null) {
                                i10 = R.id.tab_layout;
                                TabLayout tabLayout = (TabLayout) j2.c.a(view, i10);
                                if (tabLayout != null) {
                                    i10 = R.id.tv_state;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_title;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_title_connection;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.view_divider;
                                                MaterialDivider materialDivider = (MaterialDivider) j2.c.a(view, i10);
                                                if (materialDivider != null) {
                                                    return new m1((FrameLayout) view, linearLayout, frameLayout, imageView, textView, progressBar, recyclerView, tabLayout, textView2, textView3, textView4, materialDivider);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static m1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static m1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_scan, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f10222a;
    }
}
