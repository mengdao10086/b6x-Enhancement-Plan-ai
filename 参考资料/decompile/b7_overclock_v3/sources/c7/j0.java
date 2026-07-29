package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class j0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f10132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final View f10138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final View f10139j;

    public j0(@g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 View view, @g.n0 View view2) {
        this.f10130a = constraintLayout;
        this.f10131b = linearLayout;
        this.f10132c = imageView;
        this.f10133d = imageView2;
        this.f10134e = textView;
        this.f10135f = textView2;
        this.f10136g = textView3;
        this.f10137h = textView4;
        this.f10138i = view;
        this.f10139j = view2;
    }

    @g.n0
    public static j0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.area_connect_info;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.iv_battery;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_device;
                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.tv_device_name;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_mapping_mode;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_state;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.tv_tech_name;
                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                if (textView4 != null && (viewA = j2.c.a(view, (i10 = R.id.view_divider1))) != null && (viewA2 = j2.c.a(view, (i10 = R.id.view_divider2))) != null) {
                                    return new j0((ConstraintLayout) view, linearLayout, imageView, imageView2, textView, textView2, textView3, textView4, viewA, viewA2);
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
    public static j0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static j0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_device_detail_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10130a;
    }
}
