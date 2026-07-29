package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f36098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ProgressBar f36099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f36100c;

    public h(@n0 LinearLayout linearLayout, @n0 ProgressBar progressBar, @n0 TextView textView) {
        this.f36098a = linearLayout;
        this.f36099b = progressBar;
        this.f36100c = textView;
    }

    @n0
    public static h a(@n0 View view) {
        int i10 = R.id.progress;
        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
        if (progressBar != null) {
            i10 = R.id.tv_state;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new h((LinearLayout) view, progressBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static h c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static h d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.base_item_progress, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f36098a;
    }
}
