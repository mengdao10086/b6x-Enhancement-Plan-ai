package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.home.device.TipView;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class g1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final TipView f10041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TipView f10042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f10043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ProgressBar f10046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10048h;

    public g1(@g.n0 TipView tipView, @g.n0 TipView tipView2, @g.n0 SuperButton superButton, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 ProgressBar progressBar, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f10041a = tipView;
        this.f10042b = tipView2;
        this.f10043c = superButton;
        this.f10044d = textView;
        this.f10045e = textView2;
        this.f10046f = progressBar;
        this.f10047g = textView3;
        this.f10048h = textView4;
    }

    @g.n0
    public static g1 a(@g.n0 View view) {
        TipView tipView = (TipView) view;
        int i10 = R.id.btn_info;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.btn_negative;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.btn_positive;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.pb_loading;
                    ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
                    if (progressBar != null) {
                        i10 = R.id.tv_tips_desc;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.tv_tips_title;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                return new g1(tipView, tipView, superButton, textView, textView2, progressBar, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_my_device_tips, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TipView getRoot() {
        return this.f10041a;
    }
}
