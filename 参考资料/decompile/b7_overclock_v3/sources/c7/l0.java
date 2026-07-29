package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class l0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10186h;

    public l0(@g.n0 ConstraintLayout constraintLayout, @g.n0 Button button, @g.n0 TextView textView, @g.n0 ImageView imageView, @g.n0 LinearLayout linearLayout, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f10179a = constraintLayout;
        this.f10180b = button;
        this.f10181c = textView;
        this.f10182d = imageView;
        this.f10183e = linearLayout;
        this.f10184f = textView2;
        this.f10185g = textView3;
        this.f10186h = textView4;
    }

    @g.n0
    public static l0 a(@g.n0 View view) {
        int i10 = R.id.btn_scan;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_time;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.iv_gif;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.ll_scanning;
                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.tv_message;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_message_warning;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.tv_title;
                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                if (textView4 != null) {
                                    return new l0((ConstraintLayout) view, button, textView, imageView, linearLayout, textView2, textView3, textView4);
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
    public static l0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static l0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_dfu_scan, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10179a;
    }
}
