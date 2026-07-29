package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.google.android.material.slider.Slider;

/* JADX INFO: loaded from: classes7.dex */
public final class x2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Slider f10580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10588o;

    public x2(@g.n0 LinearLayout linearLayout, @g.n0 ActionItemNormal actionItemNormal, @g.n0 ConstraintLayout constraintLayout, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ConstraintLayout constraintLayout3, @g.n0 ConstraintLayout constraintLayout4, @g.n0 Slider slider, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8) {
        this.f10574a = linearLayout;
        this.f10575b = actionItemNormal;
        this.f10576c = constraintLayout;
        this.f10577d = constraintLayout2;
        this.f10578e = constraintLayout3;
        this.f10579f = constraintLayout4;
        this.f10580g = slider;
        this.f10581h = textView;
        this.f10582i = textView2;
        this.f10583j = textView3;
        this.f10584k = textView4;
        this.f10585l = textView5;
        this.f10586m = textView6;
        this.f10587n = textView7;
        this.f10588o = textView8;
    }

    @g.n0
    public static x2 a(@g.n0 View view) {
        int i10 = R.id.action_run_mode;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
        if (actionItemNormal != null) {
            i10 = R.id.area_manual;
            ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.area_smart;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout2 != null) {
                    i10 = R.id.btn_run_level_quiet;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) j2.c.a(view, i10);
                    if (constraintLayout3 != null) {
                        i10 = R.id.btn_run_level_standard;
                        ConstraintLayout constraintLayout4 = (ConstraintLayout) j2.c.a(view, i10);
                        if (constraintLayout4 != null) {
                            i10 = R.id.seekbar_manual;
                            Slider slider = (Slider) j2.c.a(view, i10);
                            if (slider != null) {
                                i10 = R.id.tv_max;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_middle;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_min;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_mode_level_quiet_desc;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.tv_mode_level_quiet_title;
                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                if (textView5 != null) {
                                                    i10 = R.id.tv_mode_level_standard_desc;
                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                    if (textView6 != null) {
                                                        i10 = R.id.tv_mode_level_standard_title;
                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                        if (textView7 != null) {
                                                            i10 = R.id.tv_overclock_limit;
                                                            TextView textView8 = (TextView) j2.c.a(view, i10);
                                                            if (textView8 != null) {
                                                                return new x2((LinearLayout) view, actionItemNormal, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, slider, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static x2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static x2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_widget_run_mode_item_b6, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10574a;
    }
}
