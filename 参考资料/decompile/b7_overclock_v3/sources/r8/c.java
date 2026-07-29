package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.flydigi.game.R;
import g.n0;
import g.p0;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final MagicIndicator f47757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ProgressBar f47758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f47759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f47760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ViewPager f47761f;

    public c(@n0 LinearLayout linearLayout, @n0 MagicIndicator magicIndicator, @n0 ProgressBar progressBar, @n0 TextView textView, @n0 TextView textView2, @n0 ViewPager viewPager) {
        this.f47756a = linearLayout;
        this.f47757b = magicIndicator;
        this.f47758c = progressBar;
        this.f47759d = textView;
        this.f47760e = textView2;
        this.f47761f = viewPager;
    }

    @n0
    public static c a(@n0 View view) {
        int i10 = R.id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) j2.c.a(view, i10);
        if (magicIndicator != null) {
            i10 = R.id.pb_storage;
            ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
            if (progressBar != null) {
                i10 = R.id.tv_storage_free;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_storage_used;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.vp_download;
                        ViewPager viewPager = (ViewPager) j2.c.a(view, i10);
                        if (viewPager != null) {
                            return new c((LinearLayout) view, magicIndicator, progressBar, textView, textView2, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static c c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static c d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_download, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47756a;
    }
}
