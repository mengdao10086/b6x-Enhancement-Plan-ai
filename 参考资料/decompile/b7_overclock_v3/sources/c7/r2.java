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
public final class r2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f10406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f10407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f10408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10414n;

    public r2(@g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 LinearLayout linearLayout3, @g.n0 TextView textView, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7) {
        this.f10401a = constraintLayout;
        this.f10402b = linearLayout;
        this.f10403c = linearLayout2;
        this.f10404d = linearLayout3;
        this.f10405e = textView;
        this.f10406f = imageView;
        this.f10407g = imageView2;
        this.f10408h = imageView3;
        this.f10409i = textView2;
        this.f10410j = textView3;
        this.f10411k = textView4;
        this.f10412l = textView5;
        this.f10413m = textView6;
        this.f10414n = textView7;
    }

    @g.n0
    public static r2 a(@g.n0 View view) {
        int i10 = R.id.area_step_1;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_step_2;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.area_step_3;
                LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R.id.btn_help;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.iv_step_1;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.iv_step_2;
                            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.iv_step_3;
                                ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                if (imageView3 != null) {
                                    i10 = R.id.tv_step_1;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_step_2;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_step_3;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.tv_title;
                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                if (textView5 != null) {
                                                    i10 = R.id.tv_usb1_state;
                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                    if (textView6 != null) {
                                                        i10 = R.id.tv_usb2_state;
                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                        if (textView7 != null) {
                                                            return new r2((ConstraintLayout) view, linearLayout, linearLayout2, linearLayout3, textView, imageView, imageView2, imageView3, textView2, textView3, textView4, textView5, textView6, textView7);
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
    public static r2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static r2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_layout_fragment_keyboard_mouse_connect_guide, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10401a;
    }
}
