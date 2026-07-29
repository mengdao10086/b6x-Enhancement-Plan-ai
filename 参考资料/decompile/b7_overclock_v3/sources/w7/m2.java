package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class m2 implements j2.b {

    @g.n0
    public final TextView A;

    @g.n0
    public final TextView B;

    @g.n0
    public final TextView C;

    @g.n0
    public final TextView D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageButton f54277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageButton f54278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageButton f54279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageButton f54280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageButton f54283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ImageView f54284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ImageButton f54285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ImageView f54286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final View f54287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ImageButton f54288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final SeekBar f54289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final SeekBar f54290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f54291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final TextView f54292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final TextView f54293s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g.n0
    public final TextView f54294t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @g.n0
    public final TextView f54295u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @g.n0
    public final TextView f54296v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @g.n0
    public final TextView f54297w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @g.n0
    public final TextView f54298x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @g.n0
    public final TextView f54299y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @g.n0
    public final TextView f54300z;

    public m2(@g.n0 ConstraintLayout constraintLayout, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ImageButton imageButton, @g.n0 ImageButton imageButton2, @g.n0 ImageButton imageButton3, @g.n0 ImageButton imageButton4, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 ImageButton imageButton5, @g.n0 ImageView imageView, @g.n0 ImageButton imageButton6, @g.n0 ImageView imageView2, @g.n0 View view, @g.n0 ImageButton imageButton7, @g.n0 SeekBar seekBar, @g.n0 SeekBar seekBar2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8, @g.n0 TextView textView9, @g.n0 TextView textView10, @g.n0 TextView textView11, @g.n0 TextView textView12, @g.n0 TextView textView13, @g.n0 TextView textView14) {
        this.f54275a = constraintLayout;
        this.f54276b = constraintLayout2;
        this.f54277c = imageButton;
        this.f54278d = imageButton2;
        this.f54279e = imageButton3;
        this.f54280f = imageButton4;
        this.f54281g = linearLayout;
        this.f54282h = linearLayout2;
        this.f54283i = imageButton5;
        this.f54284j = imageView;
        this.f54285k = imageButton6;
        this.f54286l = imageView2;
        this.f54287m = view;
        this.f54288n = imageButton7;
        this.f54289o = seekBar;
        this.f54290p = seekBar2;
        this.f54291q = textView;
        this.f54292r = textView2;
        this.f54293s = textView3;
        this.f54294t = textView4;
        this.f54295u = textView5;
        this.f54296v = textView6;
        this.f54297w = textView7;
        this.f54298x = textView8;
        this.f54299y = textView9;
        this.f54300z = textView10;
        this.A = textView11;
        this.B = textView12;
        this.C = textView13;
        this.D = textView14;
    }

    @g.n0
    public static m2 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.area_locking;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.btn_minus_down;
            ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
            if (imageButton != null) {
                i10 = R.id.btn_minus_up;
                ImageButton imageButton2 = (ImageButton) j2.c.a(view, i10);
                if (imageButton2 != null) {
                    i10 = R.id.btn_plus_down;
                    ImageButton imageButton3 = (ImageButton) j2.c.a(view, i10);
                    if (imageButton3 != null) {
                        i10 = R.id.btn_plus_up;
                        ImageButton imageButton4 = (ImageButton) j2.c.a(view, i10);
                        if (imageButton4 != null) {
                            i10 = R.id.cb_down;
                            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout != null) {
                                i10 = R.id.cb_up;
                                LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R.id.iv_cb_down;
                                    ImageButton imageButton5 = (ImageButton) j2.c.a(view, i10);
                                    if (imageButton5 != null) {
                                        i10 = R.id.iv_cb_down_help;
                                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                                        if (imageView != null) {
                                            i10 = R.id.iv_cb_up;
                                            ImageButton imageButton6 = (ImageButton) j2.c.a(view, i10);
                                            if (imageButton6 != null) {
                                                i10 = R.id.iv_cb_up_help;
                                                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                                if (imageView2 != null && (viewA = j2.c.a(view, (i10 = R.id.iv_line))) != null) {
                                                    i10 = R.id.iv_locking;
                                                    ImageButton imageButton7 = (ImageButton) j2.c.a(view, i10);
                                                    if (imageButton7 != null) {
                                                        i10 = R.id.seekbar_down;
                                                        SeekBar seekBar = (SeekBar) j2.c.a(view, i10);
                                                        if (seekBar != null) {
                                                            i10 = R.id.seekbar_up;
                                                            SeekBar seekBar2 = (SeekBar) j2.c.a(view, i10);
                                                            if (seekBar2 != null) {
                                                                i10 = android.R.id.text1;
                                                                TextView textView = (TextView) j2.c.a(view, android.R.id.text1);
                                                                if (textView != null) {
                                                                    i10 = R.id.tv_cb_down;
                                                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                                                    if (textView2 != null) {
                                                                        i10 = R.id.tv_cb_up;
                                                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                                                        if (textView3 != null) {
                                                                            i10 = R.id.tv_minus_down_hint;
                                                                            TextView textView4 = (TextView) j2.c.a(view, i10);
                                                                            if (textView4 != null) {
                                                                                i10 = R.id.tv_minus_up_hint;
                                                                                TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                                if (textView5 != null) {
                                                                                    i10 = R.id.tv_name_down;
                                                                                    TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                                    if (textView6 != null) {
                                                                                        i10 = R.id.tv_name_up;
                                                                                        TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                                        if (textView7 != null) {
                                                                                            i10 = R.id.tv_plus_down_hint;
                                                                                            TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                                            if (textView8 != null) {
                                                                                                i10 = R.id.tv_plus_up_hint;
                                                                                                TextView textView9 = (TextView) j2.c.a(view, i10);
                                                                                                if (textView9 != null) {
                                                                                                    i10 = R.id.tv_title;
                                                                                                    TextView textView10 = (TextView) j2.c.a(view, i10);
                                                                                                    if (textView10 != null) {
                                                                                                        i10 = R.id.tv_unit_down;
                                                                                                        TextView textView11 = (TextView) j2.c.a(view, i10);
                                                                                                        if (textView11 != null) {
                                                                                                            i10 = R.id.tv_unit_up;
                                                                                                            TextView textView12 = (TextView) j2.c.a(view, i10);
                                                                                                            if (textView12 != null) {
                                                                                                                i10 = R.id.tv_value_down;
                                                                                                                TextView textView13 = (TextView) j2.c.a(view, i10);
                                                                                                                if (textView13 != null) {
                                                                                                                    i10 = R.id.tv_value_up;
                                                                                                                    TextView textView14 = (TextView) j2.c.a(view, i10);
                                                                                                                    if (textView14 != null) {
                                                                                                                        return new m2((ConstraintLayout) view, constraintLayout, imageButton, imageButton2, imageButton3, imageButton4, linearLayout, linearLayout2, imageButton5, imageView, imageButton6, imageView2, viewA, imageButton7, seekBar, seekBar2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
    public static m2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static m2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_two_seekbar_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54275a;
    }
}
