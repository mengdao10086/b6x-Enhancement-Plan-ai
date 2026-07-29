package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class z implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f54568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f54569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f54570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final Button f54571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final Button f54572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Button f54573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final Button f54574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final Button f54575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final Button f54576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final SuperButton f54577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ImageView f54578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f54580n;

    public z(@g.n0 FrameLayout frameLayout, @g.n0 Button button, @g.n0 Button button2, @g.n0 Button button3, @g.n0 Button button4, @g.n0 Button button5, @g.n0 Button button6, @g.n0 Button button7, @g.n0 Button button8, @g.n0 Button button9, @g.n0 SuperButton superButton, @g.n0 ImageView imageView, @g.n0 FrameLayout frameLayout2, @g.n0 TextView textView) {
        this.f54567a = frameLayout;
        this.f54568b = button;
        this.f54569c = button2;
        this.f54570d = button3;
        this.f54571e = button4;
        this.f54572f = button5;
        this.f54573g = button6;
        this.f54574h = button7;
        this.f54575i = button8;
        this.f54576j = button9;
        this.f54577k = superButton;
        this.f54578l = imageView;
        this.f54579m = frameLayout2;
        this.f54580n = textView;
    }

    @g.n0
    public static z a(@g.n0 View view) {
        int i10 = R.id.btn_touch_point1;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_touch_point2;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                i10 = R.id.btn_touch_point3;
                Button button3 = (Button) j2.c.a(view, i10);
                if (button3 != null) {
                    i10 = R.id.btn_touch_point4;
                    Button button4 = (Button) j2.c.a(view, i10);
                    if (button4 != null) {
                        i10 = R.id.btn_touch_point5;
                        Button button5 = (Button) j2.c.a(view, i10);
                        if (button5 != null) {
                            i10 = R.id.btn_touch_point6;
                            Button button6 = (Button) j2.c.a(view, i10);
                            if (button6 != null) {
                                i10 = R.id.btn_touch_point7;
                                Button button7 = (Button) j2.c.a(view, i10);
                                if (button7 != null) {
                                    i10 = R.id.btn_touch_point8;
                                    Button button8 = (Button) j2.c.a(view, i10);
                                    if (button8 != null) {
                                        i10 = R.id.btn_touch_point9;
                                        Button button9 = (Button) j2.c.a(view, i10);
                                        if (button9 != null) {
                                            i10 = R.id.iv_close;
                                            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                                            if (superButton != null) {
                                                i10 = R.id.iv_cursor;
                                                ImageView imageView = (ImageView) j2.c.a(view, i10);
                                                if (imageView != null) {
                                                    FrameLayout frameLayout = (FrameLayout) view;
                                                    i10 = R.id.tv_notice;
                                                    TextView textView = (TextView) j2.c.a(view, i10);
                                                    if (textView != null) {
                                                        return new z(frameLayout, button, button2, button3, button4, button5, button6, button7, button8, button9, superButton, imageView, frameLayout, textView);
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
    public static z c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static z d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_mapping_test, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54567a;
    }
}
