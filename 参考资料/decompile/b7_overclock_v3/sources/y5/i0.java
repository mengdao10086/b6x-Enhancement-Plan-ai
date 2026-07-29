package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f56356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56357c;

    public i0(@n0 LinearLayout linearLayout, @n0 TextView textView, @n0 TextView textView2) {
        this.f56355a = linearLayout;
        this.f56356b = textView;
        this.f56357c = textView2;
    }

    @n0
    public static i0 a(@n0 View view) {
        int i10 = R.id.tv_tag_prefix;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_title;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                return new i0((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static i0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static i0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_tag_topic, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56355a;
    }
}
