package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class i0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f54144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f54145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final SuperButton f54146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final SuperButton f54147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f54149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f54151i;

    public i0(@g.n0 FrameLayout frameLayout, @g.n0 SuperButton superButton, @g.n0 SuperButton superButton2, @g.n0 SuperButton superButton3, @g.n0 SuperButton superButton4, @g.n0 FrameLayout frameLayout2, @g.n0 ImageView imageView, @g.n0 FrameLayout frameLayout3, @g.n0 TextView textView) {
        this.f54143a = frameLayout;
        this.f54144b = superButton;
        this.f54145c = superButton2;
        this.f54146d = superButton3;
        this.f54147e = superButton4;
        this.f54148f = frameLayout2;
        this.f54149g = imageView;
        this.f54150h = frameLayout3;
        this.f54151i = textView;
    }

    @g.n0
    public static i0 a(@g.n0 View view) {
        int i10 = R.id.btn_apply;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.btn_cancel;
            SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
            if (superButton2 != null) {
                i10 = R.id.btn_save_as;
                SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                if (superButton3 != null) {
                    i10 = R.id.btn_test;
                    SuperButton superButton4 = (SuperButton) j2.c.a(view, i10);
                    if (superButton4 != null) {
                        i10 = R.id.button_menu_move_bar;
                        FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
                        if (frameLayout != null) {
                            i10 = R.id.iv_expand;
                            ImageView imageView = (ImageView) j2.c.a(view, i10);
                            if (imageView != null) {
                                i10 = R.id.ll_panel_key;
                                FrameLayout frameLayout2 = (FrameLayout) j2.c.a(view, i10);
                                if (frameLayout2 != null) {
                                    i10 = R.id.tv_config_title;
                                    TextView textView = (TextView) j2.c.a(view, i10);
                                    if (textView != null) {
                                        return new i0((FrameLayout) view, superButton, superButton2, superButton3, superButton4, frameLayout, imageView, frameLayout2, textView);
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
    public static i0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_setting_config_menu, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54143a;
    }
}
