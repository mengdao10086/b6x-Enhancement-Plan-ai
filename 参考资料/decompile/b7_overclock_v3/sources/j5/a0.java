package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f36069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final FrameLayout f36070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final FrameLayout f36071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final LinearLayout f36072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ProgressBar f36073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f36074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f36075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f36076h;

    public a0(@n0 FrameLayout frameLayout, @n0 FrameLayout frameLayout2, @n0 FrameLayout frameLayout3, @n0 LinearLayout linearLayout, @n0 ProgressBar progressBar, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3) {
        this.f36069a = frameLayout;
        this.f36070b = frameLayout2;
        this.f36071c = frameLayout3;
        this.f36072d = linearLayout;
        this.f36073e = progressBar;
        this.f36074f = textView;
        this.f36075g = textView2;
        this.f36076h = textView3;
    }

    @n0
    public static a0 a(@n0 View view) {
        int i10 = R.id.load_more_load_end_view;
        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
        if (frameLayout != null) {
            i10 = R.id.load_more_load_fail_view;
            FrameLayout frameLayout2 = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout2 != null) {
                i10 = R.id.load_more_loading_view;
                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.loading_progress;
                    ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                    if (progressBar != null) {
                        i10 = R.id.loading_text;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_no_more;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_prompt;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    return new a0((FrameLayout) view, frameLayout, frameLayout2, linearLayout, progressBar, textView, textView2, textView3);
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
    public static a0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.view_load_more, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f36069a;
    }
}
