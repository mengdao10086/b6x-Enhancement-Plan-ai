package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f9779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f9780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final Button f9782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final Button f9783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final Button f9785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f9786i;

    public a(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 LinearLayout linearLayout2, @g.n0 Button button, @g.n0 Button button2, @g.n0 TextView textView, @g.n0 Button button3, @g.n0 TextView textView2) {
        this.f9778a = linearLayout;
        this.f9779b = imageView;
        this.f9780c = imageView2;
        this.f9781d = linearLayout2;
        this.f9782e = button;
        this.f9783f = button2;
        this.f9784g = textView;
        this.f9785h = button3;
        this.f9786i = textView2;
    }

    @g.n0
    public static a a(@g.n0 View view) {
        int i10 = R.id.iv_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_content;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.ll_double;
                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.tv_cancel;
                    Button button = (Button) j2.c.a(view, i10);
                    if (button != null) {
                        i10 = R.id.tv_confirm;
                        Button button2 = (Button) j2.c.a(view, i10);
                        if (button2 != null) {
                            i10 = R.id.tv_content;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                i10 = R.id.tv_ok;
                                Button button3 = (Button) j2.c.a(view, i10);
                                if (button3 != null) {
                                    i10 = R.id.tv_title;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        return new a((LinearLayout) view, imageView, imageView2, linearLayout, button, button2, textView, button3, textView2);
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
    public static a c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9778a;
    }
}
