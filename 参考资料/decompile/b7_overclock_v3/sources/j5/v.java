package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.base.R;
import com.flydigi.base.widget.CompactViewPager;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final RelativeLayout f36163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f36164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f36165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RelativeLayout f36166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f36167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final CompactViewPager f36168f;

    public v(@n0 RelativeLayout relativeLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 RelativeLayout relativeLayout2, @n0 TextView textView, @n0 CompactViewPager compactViewPager) {
        this.f36163a = relativeLayout;
        this.f36164b = imageView;
        this.f36165c = imageView2;
        this.f36166d = relativeLayout2;
        this.f36167e = textView;
        this.f36168f = compactViewPager;
    }

    @n0
    public static v a(@n0 View view) {
        int i10 = R.id.ib_back;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.ib_download;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.rl_bar;
                RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
                if (relativeLayout != null) {
                    i10 = R.id.tv_notice;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.vp_poster;
                        CompactViewPager compactViewPager = (CompactViewPager) j2.c.a(view, i10);
                        if (compactViewPager != null) {
                            return new v((RelativeLayout) view, imageView, imageView2, relativeLayout, textView, compactViewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static v c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static v d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_layout_fragment_image_preview, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f36163a;
    }
}
