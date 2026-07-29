package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f36118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f36119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f36120c;

    public l(@n0 NestedScrollView nestedScrollView, @n0 ImageView imageView, @n0 TextView textView) {
        this.f36118a = nestedScrollView;
        this.f36119b = imageView;
        this.f36120c = textView;
    }

    @n0
    public static l a(@n0 View view) {
        int i10 = R.id.iv_message;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_error_tip;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new l((NestedScrollView) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static l c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static l d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.base_layout_view_placehoder_error, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f36118a;
    }
}
