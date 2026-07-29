package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.widget.NoScrollViewPager;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f56285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f56288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final NoScrollViewPager f56289f;

    public d(@n0 LinearLayout linearLayout, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 NoScrollViewPager noScrollViewPager) {
        this.f56284a = linearLayout;
        this.f56285b = textView;
        this.f56286c = textView2;
        this.f56287d = textView3;
        this.f56288e = textView4;
        this.f56289f = noScrollViewPager;
    }

    @n0
    public static d a(@n0 View view) {
        int i10 = R.id.btn_type_comment;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.btn_type_like;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.tv_type_comment_num;
                TextView textView3 = (TextView) j2.c.a(view, i10);
                if (textView3 != null) {
                    i10 = R.id.tv_type_like_num;
                    TextView textView4 = (TextView) j2.c.a(view, i10);
                    if (textView4 != null) {
                        i10 = R.id.view_pager;
                        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) j2.c.a(view, i10);
                        if (noScrollViewPager != null) {
                            return new d((LinearLayout) view, textView, textView2, textView3, textView4, noScrollViewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static d c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static d d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_activity_message_center, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56284a;
    }
}
