package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f9239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f9240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f9241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f9242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f9243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f9244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f9245g;

    public t(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f9239a = linearLayout;
        this.f9240b = linearLayout2;
        this.f9241c = linearLayout3;
        this.f9242d = textView;
        this.f9243e = textView2;
        this.f9244f = textView3;
        this.f9245g = textView4;
    }

    @n0
    public static t a(@n0 View view) {
        int i10 = R.id.ll_double;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, R.id.ll_double);
        if (linearLayout != null) {
            i10 = R.id.ll_ok;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, R.id.ll_ok);
            if (linearLayout2 != null) {
                i10 = R.id.tv_cancel;
                TextView textView = (TextView) j2.c.a(view, R.id.tv_cancel);
                if (textView != null) {
                    i10 = R.id.tv_confirm;
                    TextView textView2 = (TextView) j2.c.a(view, R.id.tv_confirm);
                    if (textView2 != null) {
                        i10 = R.id.tv_content;
                        TextView textView3 = (TextView) j2.c.a(view, R.id.tv_content);
                        if (textView3 != null) {
                            i10 = R.id.tv_ok;
                            TextView textView4 = (TextView) j2.c.a(view, R.id.tv_ok);
                            if (textView4 != null) {
                                return new t((LinearLayout) view, linearLayout, linearLayout2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static t c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static t d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_layout_dialog_update, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9239a;
    }
}
