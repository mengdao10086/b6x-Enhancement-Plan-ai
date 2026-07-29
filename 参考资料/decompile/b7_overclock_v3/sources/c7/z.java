package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class z implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10635d;

    public z(@g.n0 ConstraintLayout constraintLayout, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 TextView textView2) {
        this.f10632a = constraintLayout;
        this.f10633b = imageView;
        this.f10634c = textView;
        this.f10635d = textView2;
    }

    @g.n0
    public static z a(@g.n0 View view) {
        int i10 = R.id.iv_bg;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_desc;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_title;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    return new z((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static z c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static z d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_dialog_protection_alert, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10632a;
    }
}
