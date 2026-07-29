package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f47814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f47815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f47816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f47817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f47818f;

    public o(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f47813a = linearLayout;
        this.f47814b = linearLayout2;
        this.f47815c = textView;
        this.f47816d = textView2;
        this.f47817e = textView3;
        this.f47818f = textView4;
    }

    @n0
    public static o a(@n0 View view) {
        int i10 = R.id.ll_double;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.tv_cancel;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_confirm;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_content;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.tv_title;
                        TextView textView4 = (TextView) j2.c.a(view, i10);
                        if (textView4 != null) {
                            return new o((LinearLayout) view, linearLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static o c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static o d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_net_status, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47813a;
    }
}
