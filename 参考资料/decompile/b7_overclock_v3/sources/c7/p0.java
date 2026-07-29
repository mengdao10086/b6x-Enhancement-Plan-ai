package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class p0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ProgressBar f10327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10329e;

    public p0(@g.n0 ConstraintLayout constraintLayout, @g.n0 ImageView imageView, @g.n0 ProgressBar progressBar, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10325a = constraintLayout;
        this.f10326b = imageView;
        this.f10327c = progressBar;
        this.f10328d = textView;
        this.f10329e = textView2;
    }

    @g.n0
    public static p0 a(@g.n0 View view) {
        int i10 = R.id.iv_upgrade_progress;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.pb_upgrade;
            ProgressBar progressBar = (ProgressBar) j2.c.a(view, i10);
            if (progressBar != null) {
                i10 = R.id.tv_upgrade_message;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_upgrade_progress;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        return new p0((ConstraintLayout) view, imageView, progressBar, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static p0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static p0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_firmware_upgrade, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10325a;
    }
}
