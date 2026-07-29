package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class c3 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f9895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f9896c;

    public c3(@g.n0 FrameLayout frameLayout, @g.n0 TextView textView, @g.n0 ImageView imageView) {
        this.f9894a = frameLayout;
        this.f9895b = textView;
        this.f9896c = imageView;
    }

    @g.n0
    public static c3 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.btn_close;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                return new c3((FrameLayout) view, textView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static c3 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c3 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_dialog_alpha_group_invitation, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9894a;
    }
}
