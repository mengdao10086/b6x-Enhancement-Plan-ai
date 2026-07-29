package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.ExpandView;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class g0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f54109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ExpandView f54110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ExpandView f54111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54114g;

    public g0(@g.n0 FrameLayout frameLayout, @g.n0 SuperButton superButton, @g.n0 ExpandView expandView, @g.n0 ExpandView expandView2, @g.n0 FrameLayout frameLayout2, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f54108a = frameLayout;
        this.f54109b = superButton;
        this.f54110c = expandView;
        this.f54111d = expandView2;
        this.f54112e = frameLayout2;
        this.f54113f = textView;
        this.f54114g = textView2;
    }

    @g.n0
    public static g0 a(@g.n0 View view) {
        int i10 = R.id.btn_close;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.ev_combo_first;
            ExpandView expandView = (ExpandView) j2.c.a(view, i10);
            if (expandView != null) {
                i10 = R.id.ev_combo_second;
                ExpandView expandView2 = (ExpandView) j2.c.a(view, i10);
                if (expandView2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i10 = R.id.tv_and;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.wait_click_text;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            return new g0(frameLayout, superButton, expandView, expandView2, frameLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_setting_config_combo_key_listen, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54108a;
    }
}
