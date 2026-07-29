package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.flydigi.device_manager.R;
import com.google.android.material.slider.Slider;

/* JADX INFO: loaded from: classes7.dex */
public final class z2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final CheckedTextView f10647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final CheckedTextView f10648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Guideline f10649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final Slider f10651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10653k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10654l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f10659q;

    public z2(@g.n0 ConstraintLayout constraintLayout, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ConstraintLayout constraintLayout3, @g.n0 ImageView imageView, @g.n0 CheckedTextView checkedTextView, @g.n0 CheckedTextView checkedTextView2, @g.n0 Guideline guideline, @g.n0 ConstraintLayout constraintLayout4, @g.n0 Slider slider, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8) {
        this.f10643a = constraintLayout;
        this.f10644b = constraintLayout2;
        this.f10645c = constraintLayout3;
        this.f10646d = imageView;
        this.f10647e = checkedTextView;
        this.f10648f = checkedTextView2;
        this.f10649g = guideline;
        this.f10650h = constraintLayout4;
        this.f10651i = slider;
        this.f10652j = textView;
        this.f10653k = textView2;
        this.f10654l = textView3;
        this.f10655m = textView4;
        this.f10656n = textView5;
        this.f10657o = textView6;
        this.f10658p = textView7;
        this.f10659q = textView8;
    }

    @g.n0
    public static z2 a(@g.n0 View view) {
        int i10 = R.id.area_overclock;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_setting_run_mode;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout2 != null) {
                i10 = R.id.btn_overclock;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.btn_run_mode_manual;
                    CheckedTextView checkedTextView = (CheckedTextView) j2.c.a(view, i10);
                    if (checkedTextView != null) {
                        i10 = R.id.btn_run_mode_smart;
                        CheckedTextView checkedTextView2 = (CheckedTextView) j2.c.a(view, i10);
                        if (checkedTextView2 != null) {
                            i10 = R.id.guide;
                            Guideline guideline = (Guideline) j2.c.a(view, i10);
                            if (guideline != null) {
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                i10 = R.id.seekbar;
                                Slider slider = (Slider) j2.c.a(view, i10);
                                if (slider != null) {
                                    i10 = android.R.id.text1;
                                    TextView textView = (TextView) j2.c.a(view, android.R.id.text1);
                                    if (textView != null) {
                                        i10 = android.R.id.text2;
                                        TextView textView2 = (TextView) j2.c.a(view, android.R.id.text2);
                                        if (textView2 != null) {
                                            i10 = R.id.tv_max;
                                            TextView textView3 = (TextView) j2.c.a(view, i10);
                                            if (textView3 != null) {
                                                i10 = R.id.tv_middle;
                                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                                if (textView4 != null) {
                                                    i10 = R.id.tv_min;
                                                    TextView textView5 = (TextView) j2.c.a(view, i10);
                                                    if (textView5 != null) {
                                                        i10 = R.id.tv_run_mode_hint;
                                                        TextView textView6 = (TextView) j2.c.a(view, i10);
                                                        if (textView6 != null) {
                                                            i10 = R.id.tv_run_mode_smart_hint;
                                                            TextView textView7 = (TextView) j2.c.a(view, i10);
                                                            if (textView7 != null) {
                                                                i10 = R.id.tv_title;
                                                                TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                if (textView8 != null) {
                                                                    return new z2(constraintLayout3, constraintLayout, constraintLayout2, imageView, checkedTextView, checkedTextView2, guideline, constraintLayout3, slider, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static z2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static z2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_widget_wind_seek_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10643a;
    }
}
