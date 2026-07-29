package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class j2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageButton f54191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageButton f54192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f54194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final SeekBar f54195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f54196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f54197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f54198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f54199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f54200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f54201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f54202n;

    public j2(@g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 ImageButton imageButton, @g.n0 ImageButton imageButton2, @g.n0 LinearLayout linearLayout3, @g.n0 ImageView imageView, @g.n0 SeekBar seekBar, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7) {
        this.f54189a = linearLayout;
        this.f54190b = linearLayout2;
        this.f54191c = imageButton;
        this.f54192d = imageButton2;
        this.f54193e = linearLayout3;
        this.f54194f = imageView;
        this.f54195g = seekBar;
        this.f54196h = textView;
        this.f54197i = textView2;
        this.f54198j = textView3;
        this.f54199k = textView4;
        this.f54200l = textView5;
        this.f54201m = textView6;
        this.f54202n = textView7;
    }

    @g.n0
    public static j2 a(@g.n0 View view) {
        int i10 = R.id.area_content;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.btn_minus;
            ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
            if (imageButton != null) {
                i10 = R.id.btn_plus;
                ImageButton imageButton2 = (ImageButton) j2.c.a(view, i10);
                if (imageButton2 != null) {
                    i10 = R.id.container;
                    LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.iv_name_help;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.seekbar;
                            SeekBar seekBar = (SeekBar) j2.c.a(view, i10);
                            if (seekBar != null) {
                                i10 = R.id.tv_desc;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_minus_hint;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_name;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            i10 = R.id.tv_plus_hint;
                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                            if (textView4 != null) {
                                                i10 = R.id.tv_title;
                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                if (textView5 != null) {
                                                    i10 = R.id.tv_unit;
                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                    if (textView6 != null) {
                                                        i10 = R.id.tv_value;
                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                        if (textView7 != null) {
                                                            return new j2((LinearLayout) view, linearLayout, imageButton, imageButton2, linearLayout2, imageView, seekBar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
    public static j2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static j2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_single_seekbar_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f54189a;
    }
}
