package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f36121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ProgressBar f36122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f36123c;

    public m(@n0 NestedScrollView nestedScrollView, @n0 ProgressBar progressBar, @n0 TextView textView) {
        this.f36121a = nestedScrollView;
        this.f36122b = progressBar;
        this.f36123c = textView;
    }

    @n0
    public static m a(@n0 View view) {
        int i10 = R.id.pb_loading;
        ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
        if (progressBar != null) {
            i10 = R.id.tv_loading;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new m((NestedScrollView) view, progressBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static m c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static m d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.base_layout_view_placeholder_loading, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f36121a;
    }
}
