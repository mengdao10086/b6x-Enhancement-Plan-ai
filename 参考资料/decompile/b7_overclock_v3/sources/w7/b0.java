package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f53978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f53979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f53980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f53981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f53982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final LinearLayout f53983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final LinearLayout f53984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f53985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f53986i;

    public b0(@g.n0 RelativeLayout relativeLayout, @g.n0 Button button, @g.n0 Button button2, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f53978a = relativeLayout;
        this.f53979b = button;
        this.f53980c = button2;
        this.f53981d = imageView;
        this.f53982e = imageView2;
        this.f53983f = linearLayout;
        this.f53984g = linearLayout2;
        this.f53985h = textView;
        this.f53986i = textView2;
    }

    @g.n0
    public static b0 a(@g.n0 View view) {
        int i10 = R.id.btn_cancel;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_ok;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                i10 = R.id.iv_cancel_notice;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.iv_setting;
                    ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.layout_cancel_notice;
                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.f15517top;
                            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = R.id.tv_desc;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_notice_desc;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        return new b0((RelativeLayout) view, button, button2, imageView, imageView2, linearLayout, linearLayout2, textView, textView2);
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
    public static b0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static b0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_notice_for_config_ratio, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f53978a;
    }
}
