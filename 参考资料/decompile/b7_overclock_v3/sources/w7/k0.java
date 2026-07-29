package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class k0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f54212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f54213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final SuperButton f54214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final SuperButton f54215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final LinearLayout f54217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f54218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final SuperButton f54219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f54220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f54221k;

    public k0(@g.n0 FrameLayout frameLayout, @g.n0 SuperButton superButton, @g.n0 SuperButton superButton2, @g.n0 SuperButton superButton3, @g.n0 SuperButton superButton4, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 ImageView imageView, @g.n0 SuperButton superButton5, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f54211a = frameLayout;
        this.f54212b = superButton;
        this.f54213c = superButton2;
        this.f54214d = superButton3;
        this.f54215e = superButton4;
        this.f54216f = linearLayout;
        this.f54217g = linearLayout2;
        this.f54218h = imageView;
        this.f54219i = superButton5;
        this.f54220j = textView;
        this.f54221k = textView2;
    }

    @g.n0
    public static k0 a(@g.n0 View view) {
        int i10 = R.id.btn_add;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.btn_apply;
            SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
            if (superButton2 != null) {
                i10 = R.id.btn_cancel;
                SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                if (superButton3 != null) {
                    i10 = R.id.btn_cancel_key;
                    SuperButton superButton4 = (SuperButton) j2.c.a(view, i10);
                    if (superButton4 != null) {
                        i10 = R.id.btn_effect_type;
                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.button_menu_move_bar;
                            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.iv_cancel_key_delete;
                                ImageView imageView = (ImageView) j2.c.a(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.iv_effect_type;
                                    SuperButton superButton5 = (SuperButton) j2.c.a(view, i10);
                                    if (superButton5 != null) {
                                        i10 = R.id.tv_effect_type;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.tv_key_count;
                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                            if (textView2 != null) {
                                                return new k0((FrameLayout) view, superButton, superButton2, superButton3, superButton4, linearLayout, linearLayout2, imageView, superButton5, textView, textView2);
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
    public static k0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static k0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_setting_macro, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54211a;
    }
}
