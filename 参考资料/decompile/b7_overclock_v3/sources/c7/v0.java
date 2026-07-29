package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class v0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final g2 f10517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10526l;

    public v0(@g.n0 LinearLayout linearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 g2 g2Var, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 FrameLayout frameLayout, @g.n0 FrameLayout frameLayout2, @g.n0 LinearLayout linearLayout2, @g.n0 TextView textView6) {
        this.f10515a = linearLayout;
        this.f10516b = constraintLayout;
        this.f10517c = g2Var;
        this.f10518d = textView;
        this.f10519e = textView2;
        this.f10520f = textView3;
        this.f10521g = textView4;
        this.f10522h = textView5;
        this.f10523i = frameLayout;
        this.f10524j = frameLayout2;
        this.f10525k = linearLayout2;
        this.f10526l = textView6;
    }

    @g.n0
    public static v0 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.area_home;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null && (viewA = j2.c.a(view, (i10 = R.id.area_notice))) != null) {
            g2 g2VarA = g2.a(viewA);
            i10 = R.id.btn_action;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.btn_add;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.btn_headset;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.btn_help;
                        TextView textView4 = (TextView) j2.c.a(view, i10);
                        if (textView4 != null) {
                            i10 = R.id.btn_radiator;
                            TextView textView5 = (TextView) j2.c.a(view, i10);
                            if (textView5 != null) {
                                i10 = R.id.container_game_zone;
                                FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
                                if (frameLayout != null) {
                                    i10 = R.id.container_my_device;
                                    FrameLayout frameLayout2 = (FrameLayout) j2.c.a(view, i10);
                                    if (frameLayout2 != null) {
                                        i10 = R.id.toolbar;
                                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                        if (linearLayout != null) {
                                            i10 = R.id.tv_title;
                                            TextView textView6 = (TextView) j2.c.a(view, i10);
                                            if (textView6 != null) {
                                                return new v0((LinearLayout) view, constraintLayout, g2VarA, textView, textView2, textView3, textView4, textView5, frameLayout, frameLayout2, linearLayout, textView6);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static v0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static v0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10515a;
    }
}
