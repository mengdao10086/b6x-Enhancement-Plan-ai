package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class i2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10113c;

    public i2(@g.n0 ConstraintLayout constraintLayout, @g.n0 ImageView imageView, @g.n0 TextView textView) {
        this.f10111a = constraintLayout;
        this.f10112b = imageView;
        this.f10113c = textView;
    }

    @g.n0
    public static i2 a(@g.n0 View view) {
        int i10 = R.id.iv_device;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_device_name;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                return new i2((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static i2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static i2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_product, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10111a;
    }
}
