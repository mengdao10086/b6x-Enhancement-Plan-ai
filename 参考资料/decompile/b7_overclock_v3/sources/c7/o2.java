package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class o2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f10315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final View f10320h;

    public o2(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 NestedScrollView nestedScrollView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 View view) {
        this.f10313a = linearLayout;
        this.f10314b = imageView;
        this.f10315c = nestedScrollView;
        this.f10316d = textView;
        this.f10317e = textView2;
        this.f10318f = textView3;
        this.f10319g = textView4;
        this.f10320h = view;
    }

    @g.n0
    public static o2 a(@g.n0 View view) {
        View viewA;
        int i10 = R.id.iv_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.nsv_info;
            NestedScrollView nestedScrollView = (NestedScrollView) j2.c.a(view, i10);
            if (nestedScrollView != null) {
                i10 = R.id.tv_confirm;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_info;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_title;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.tv_version_info_notice;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null && (viewA = j2.c.a(view, (i10 = R.id.view_divider))) != null) {
                                return new o2((LinearLayout) view, imageView, nestedScrollView, textView, textView2, textView3, textView4, viewA);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static o2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static o2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_layout_dialog_firmware_info, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10313a;
    }
}
