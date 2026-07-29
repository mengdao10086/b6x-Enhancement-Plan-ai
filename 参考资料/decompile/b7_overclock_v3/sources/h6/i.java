package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f30601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f30602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageView f30603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ImageView f30604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f30605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f30606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f30607h;

    public i(@n0 LinearLayout linearLayout, @n0 Button button, @n0 TextView textView, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f30600a = linearLayout;
        this.f30601b = button;
        this.f30602c = textView;
        this.f30603d = imageView;
        this.f30604e = imageView2;
        this.f30605f = textView2;
        this.f30606g = textView3;
        this.f30607h = textView4;
    }

    @n0
    public static i a(@n0 View view) {
        int i10 = R.id.btn_connect;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_help;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.iv_step_1;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.iv_step_2;
                    ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.tv_connect_bluetooth_desc;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_step_1_desc;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.tv_step_1_title;
                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                if (textView4 != null) {
                                    return new i((LinearLayout) view, button, textView, imageView, imageView2, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static i c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static i d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_fragment_connect, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30600a;
    }
}
