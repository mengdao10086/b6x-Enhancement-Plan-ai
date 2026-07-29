package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f54161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f54163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f54164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f54167h;

    public j(@g.n0 RelativeLayout relativeLayout, @g.n0 SuperButton superButton, @g.n0 RelativeLayout relativeLayout2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f54160a = relativeLayout;
        this.f54161b = superButton;
        this.f54162c = relativeLayout2;
        this.f54163d = textView;
        this.f54164e = textView2;
        this.f54165f = textView3;
        this.f54166g = textView4;
        this.f54167h = textView5;
    }

    @g.n0
    public static j a(@g.n0 View view) {
        int i10 = R.id.btn_close;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i10 = R.id.tv_cancel;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_content;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_never_notice;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.tv_ok;
                        TextView textView4 = (TextView) j2.c.a(view, i10);
                        if (textView4 != null) {
                            i10 = R.id.tv_title;
                            TextView textView5 = (TextView) j2.c.a(view, i10);
                            if (textView5 != null) {
                                return new j(relativeLayout, superButton, relativeLayout, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static j c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static j d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_dialog_common, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54160a;
    }
}
