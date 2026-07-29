package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class h2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f54139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f54140c;

    public h2(@g.n0 LinearLayout linearLayout, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f54138a = linearLayout;
        this.f54139b = textView;
        this.f54140c = textView2;
    }

    @g.n0
    public static h2 a(@g.n0 View view) {
        int i10 = R.id.tv_desc;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_title;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                return new h2((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static h2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static h2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_property_introduction_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54138a;
    }
}
