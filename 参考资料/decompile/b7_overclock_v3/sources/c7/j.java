package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageView f10122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ImageView f10123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ImageView f10124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ImageView f10125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ImageView f10126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ImageView f10127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10129p;

    public j(@g.n0 LinearLayout linearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 ConstraintLayout constraintLayout2, @g.n0 LinearLayout linearLayout2, @g.n0 LinearLayout linearLayout3, @g.n0 LinearLayout linearLayout4, @g.n0 LinearLayout linearLayout5, @g.n0 ConstraintLayout constraintLayout3, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 ImageView imageView5, @g.n0 ImageView imageView6, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10114a = linearLayout;
        this.f10115b = constraintLayout;
        this.f10116c = constraintLayout2;
        this.f10117d = linearLayout2;
        this.f10118e = linearLayout3;
        this.f10119f = linearLayout4;
        this.f10120g = linearLayout5;
        this.f10121h = constraintLayout3;
        this.f10122i = imageView;
        this.f10123j = imageView2;
        this.f10124k = imageView3;
        this.f10125l = imageView4;
        this.f10126m = imageView5;
        this.f10127n = imageView6;
        this.f10128o = textView;
        this.f10129p = textView2;
    }

    @g.n0
    public static j a(@g.n0 View view) {
        int i10 = R.id.area_experimental_smart;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_manual;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout2 != null) {
                i10 = R.id.area_quick_switch;
                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.area_quick_switch_experiment_smart;
                    LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.area_quick_switch_manual;
                        LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout3 != null) {
                            i10 = R.id.area_quick_switch_smart;
                            LinearLayout linearLayout4 = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout4 != null) {
                                i10 = R.id.area_smart;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) j2.c.a(view, i10);
                                if (constraintLayout3 != null) {
                                    i10 = R.id.btn_action_area_quick_switch_experiment_smart;
                                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                                    if (imageView != null) {
                                        i10 = R.id.btn_action_area_quick_switch_manual;
                                        ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                        if (imageView2 != null) {
                                            i10 = R.id.btn_action_area_quick_switch_smart;
                                            ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                            if (imageView3 != null) {
                                                i10 = R.id.btn_action_experimental_smart;
                                                ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                                                if (imageView4 != null) {
                                                    i10 = R.id.btn_action_manual;
                                                    ImageView imageView5 = (ImageView) j2.c.a(view, i10);
                                                    if (imageView5 != null) {
                                                        i10 = R.id.btn_action_smart;
                                                        ImageView imageView6 = (ImageView) j2.c.a(view, i10);
                                                        if (imageView6 != null) {
                                                            i10 = R.id.tv_label_quick_switch;
                                                            TextView textView = (TextView) j2.c.a(view, i10);
                                                            if (textView != null) {
                                                                i10 = R.id.tv_label_quick_switch_desc;
                                                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                                                if (textView2 != null) {
                                                                    return new j((LinearLayout) view, constraintLayout, constraintLayout2, linearLayout, linearLayout2, linearLayout3, linearLayout4, constraintLayout3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2);
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
    public static j c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static j d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_waspwing_run_mode, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10114a;
    }
}
