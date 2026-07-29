package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f53951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f53952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f53953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f53954d;

    public a(@g.n0 RelativeLayout relativeLayout, @g.n0 ImageView imageView, @g.n0 RelativeLayout relativeLayout2, @g.n0 TextView textView) {
        this.f53951a = relativeLayout;
        this.f53952b = imageView;
        this.f53953c = relativeLayout2;
        this.f53954d = textView;
    }

    @g.n0
    public static a a(@g.n0 View view) {
        int i10 = R.id.iv_img;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i11 = R.id.tv_name;
            TextView textView = (TextView) j2.c.a(view, i11);
            if (textView != null) {
                return new a(relativeLayout, imageView, relativeLayout, textView);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static a c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_item_common_select_name, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f53951a;
    }
}
