package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f10157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f10158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f10160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10166k;

    public k(@g.n0 LinearLayout linearLayout, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6) {
        this.f10156a = linearLayout;
        this.f10157b = imageView;
        this.f10158c = imageView2;
        this.f10159d = imageView3;
        this.f10160e = imageView4;
        this.f10161f = textView;
        this.f10162g = textView2;
        this.f10163h = textView3;
        this.f10164i = textView4;
        this.f10165j = textView5;
        this.f10166k = textView6;
    }

    @g.n0
    public static k a(@g.n0 View view) {
        int i10 = R.id.iv_cold_level;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_temperature_cold_surface;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.iv_temperature_hot_surface;
                ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                if (imageView3 != null) {
                    i10 = R.id.iv_wind_level;
                    ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                    if (imageView4 != null) {
                        i10 = R.id.tv_cold_level;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_hot_protection_desc;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_temperature_cold_surface;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.tv_temperature_hot_surface;
                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R.id.tv_wind_level;
                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                        if (textView5 != null) {
                                            i10 = R.id.tv_temperature_dianya;
                                            TextView textView6 = (TextView) j2.c.a(view, i10);
                                            if (textView6 != null) {
                                                return new k((LinearLayout) view, imageView, imageView2, imageView3, imageView4, textView, textView2, textView3, textView4, textView5, textView6);
                                            }
                                        }
                                    }
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
    public static k c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static k d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_waspwing_statistics, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10156a;
    }
}
