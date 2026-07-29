package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f30594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f30595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f30596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageView f30597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f30598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f30599f;

    public h(@n0 FrameLayout frameLayout, @n0 Button button, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 TextView textView, @n0 TextView textView2) {
        this.f30594a = frameLayout;
        this.f30595b = button;
        this.f30596c = imageView;
        this.f30597d = imageView2;
        this.f30598e = textView;
        this.f30599f = textView2;
    }

    @n0
    public static h a(@n0 View view) {
        int i10 = R.id.btn_action;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_close;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_pic;
                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.tv_state;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_title;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            return new h((FrameLayout) view, button, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static h c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static h d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_dialog_help_connect, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f30594a;
    }
}
