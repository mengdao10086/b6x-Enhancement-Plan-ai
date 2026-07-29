package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class l2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageButton f54257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f54258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageButton f54259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f54260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageView f54261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f54262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f54263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f54264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54265m;

    public l2(@g.n0 LinearLayout linearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout2, @g.n0 LinearLayout linearLayout3, @g.n0 ImageButton imageButton, @g.n0 ImageView imageView, @g.n0 ImageButton imageButton2, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f54253a = linearLayout;
        this.f54254b = constraintLayout;
        this.f54255c = linearLayout2;
        this.f54256d = linearLayout3;
        this.f54257e = imageButton;
        this.f54258f = imageView;
        this.f54259g = imageButton2;
        this.f54260h = imageView2;
        this.f54261i = imageView3;
        this.f54262j = textView;
        this.f54263k = textView2;
        this.f54264l = textView3;
        this.f54265m = textView4;
    }

    @g.n0
    public static l2 a(@g.n0 View view) {
        int i10 = R.id.area_checkbox;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_title;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.container;
                LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R.id.iv_checkbox_1;
                    ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                    if (imageButton != null) {
                        i10 = R.id.iv_checkbox_1_help;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.iv_checkbox_2;
                            ImageButton imageButton2 = (ImageButton) j2.c.a(view, i10);
                            if (imageButton2 != null) {
                                i10 = R.id.iv_checkbox_2_help;
                                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                if (imageView2 != null) {
                                    i10 = R.id.iv_title_help;
                                    ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                    if (imageView3 != null) {
                                        i10 = R.id.tv_checkbox_1;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.tv_checkbox_2;
                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                            if (textView2 != null) {
                                                i10 = R.id.tv_desc;
                                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                                if (textView3 != null) {
                                                    i10 = R.id.tv_title;
                                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                                    if (textView4 != null) {
                                                        return new l2((LinearLayout) view, constraintLayout, linearLayout, linearLayout2, imageButton, imageView, imageButton2, imageView2, imageView3, textView, textView2, textView3, textView4);
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
    public static l2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static l2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_two_checkbox_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54253a;
    }
}
