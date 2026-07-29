package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f36132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f36133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f36134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Button f36135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Button f36136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f36137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f36138g;

    public p(@n0 FrameLayout frameLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 Button button, @n0 Button button2, @n0 TextView textView, @n0 TextView textView2) {
        this.f36132a = frameLayout;
        this.f36133b = imageView;
        this.f36134c = imageView2;
        this.f36135d = button;
        this.f36136e = button2;
        this.f36137f = textView;
        this.f36138g = textView2;
    }

    @n0
    public static p a(@n0 View view) {
        int i10 = R.id.iv_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_content;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tv_cancel;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.tv_confirm;
                    Button button2 = (Button) j2.c.a(view, i10);
                    if (button2 != null) {
                        i10 = R.id.tv_content;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_title;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                return new p((FrameLayout) view, imageView, imageView2, button, button2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static p c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static p d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_two_button, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f36132a;
    }
}
