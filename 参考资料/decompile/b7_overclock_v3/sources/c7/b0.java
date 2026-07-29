package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f9826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f9827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f9828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f9829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f9830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9831g;

    public b0(@g.n0 LinearLayout linearLayout, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6) {
        this.f9825a = linearLayout;
        this.f9826b = textView;
        this.f9827c = textView2;
        this.f9828d = textView3;
        this.f9829e = textView4;
        this.f9830f = textView5;
        this.f9831g = textView6;
    }

    @g.n0
    public static b0 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_option_1;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.tv_option_2;
                TextView textView3 = (TextView) j2.c.a(view, i10);
                if (textView3 != null) {
                    i10 = R.id.tv_option_3;
                    TextView textView4 = (TextView) j2.c.a(view, i10);
                    if (textView4 != null) {
                        i10 = R.id.tv_option_4;
                        TextView textView5 = (TextView) j2.c.a(view, i10);
                        if (textView5 != null) {
                            i10 = R.id.tv_title;
                            TextView textView6 = (TextView) j2.c.a(view, i10);
                            if (textView6 != null) {
                                return new b0((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static b0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static b0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_dialog_usb_debug, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9825a;
    }
}
