package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class r1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final View f10400d;

    public r1(@g.n0 RelativeLayout relativeLayout, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 View view) {
        this.f10397a = relativeLayout;
        this.f10398b = imageView;
        this.f10399c = textView;
        this.f10400d = view;
    }

    @g.n0
    public static r1 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.iv_icon;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_name;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null && (viewA = j2.c.a(view, (i10 = R.id.view_cover))) != null) {
                return new r1((RelativeLayout) view, imageView, textView, viewA);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static r1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static r1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_config_sync_game, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10397a;
    }
}
