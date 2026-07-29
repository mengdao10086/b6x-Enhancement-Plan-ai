package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f36126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f36127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f36128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f36129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Button f36130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f36131f;

    public o(@n0 LinearLayout linearLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 TextView textView, @n0 Button button, @n0 TextView textView2) {
        this.f36126a = linearLayout;
        this.f36127b = imageView;
        this.f36128c = imageView2;
        this.f36129d = textView;
        this.f36130e = button;
        this.f36131f = textView2;
    }

    @n0
    public static o a(@n0 View view) {
        int i10 = R.id.iv_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_content;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tv_content;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_ok;
                    Button button = (Button) j2.c.a(view, i10);
                    if (button != null) {
                        i10 = R.id.tv_title;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            return new o((LinearLayout) view, imageView, imageView2, textView, button, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static o c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static o d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_single_button, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f36126a;
    }
}
