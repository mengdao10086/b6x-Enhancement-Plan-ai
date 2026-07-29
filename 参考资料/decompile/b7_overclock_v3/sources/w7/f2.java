package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class f2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final SuperButton f54101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f54103d;

    public f2(@g.n0 FrameLayout frameLayout, @g.n0 SuperButton superButton, @g.n0 FrameLayout frameLayout2, @g.n0 TextView textView) {
        this.f54100a = frameLayout;
        this.f54101b = superButton;
        this.f54102c = frameLayout2;
        this.f54103d = textView;
    }

    @g.n0
    public static f2 a(@g.n0 View view) {
        int i10 = R.id.btn_close;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            int i11 = R.id.wait_click_text;
            TextView textView = (TextView) j2.c.a(view, i11);
            if (textView != null) {
                return new f2(frameLayout, superButton, frameLayout, textView);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static f2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static f2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_widget_key_listen, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54100a;
    }
}
