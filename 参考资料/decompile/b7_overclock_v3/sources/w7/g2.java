package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class g2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f54120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f54121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f54122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54123f;

    public g2(@g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f54118a = constraintLayout;
        this.f54119b = linearLayout;
        this.f54120c = textView;
        this.f54121d = textView2;
        this.f54122e = textView3;
        this.f54123f = textView4;
    }

    @g.n0
    public static g2 a(@g.n0 View view) {
        int i10 = R.id.area_key;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.btn_add;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.btn_delete;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_desc;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.tv_title;
                        TextView textView4 = (TextView) j2.c.a(view, i10);
                        if (textView4 != null) {
                            return new g2((ConstraintLayout) view, linearLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_key_set_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54118a;
    }
}
