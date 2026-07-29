package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class r0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f10394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10396e;

    public r0(@g.n0 ConstraintLayout constraintLayout, @g.n0 Button button, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10392a = constraintLayout;
        this.f10393b = button;
        this.f10394c = imageView;
        this.f10395d = textView;
        this.f10396e = textView2;
    }

    @g.n0
    public static r0 a(@g.n0 View view) {
        int i10 = R.id.btn_open_permission;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.iv_notice;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_count_down;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_notice;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        return new r0((ConstraintLayout) view, button, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static r0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static r0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_float_notice, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10392a;
    }
}
