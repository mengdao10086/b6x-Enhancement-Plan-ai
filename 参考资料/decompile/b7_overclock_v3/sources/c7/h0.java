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
public final class h0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f10078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f10079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f10080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10083j;

    public h0(@g.n0 LinearLayout linearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ConstraintLayout constraintLayout3, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f10074a = linearLayout;
        this.f10075b = constraintLayout;
        this.f10076c = constraintLayout2;
        this.f10077d = constraintLayout3;
        this.f10078e = imageView;
        this.f10079f = imageView2;
        this.f10080g = imageView3;
        this.f10081h = textView;
        this.f10082i = textView2;
        this.f10083j = textView3;
    }

    @g.n0
    public static h0 a(@g.n0 View view) {
        int i10 = R.id.area_appearance_mhy;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_appearance_normal;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout2 != null) {
                i10 = R.id.area_appearance_op;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout3 != null) {
                    i10 = R.id.iv_selected_mhy;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.iv_selected_op;
                        ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.iv_selected_standard;
                            ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                            if (imageView3 != null) {
                                i10 = R.id.tv_ip_type_mhy_desc;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_ip_type_op_desc;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_ip_type_standard_desc;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null) {
                                            return new h0((LinearLayout) view, constraintLayout, constraintLayout2, constraintLayout3, imageView, imageView2, imageView3, textView, textView2, textView3);
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
    public static h0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static h0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_detail_waspwing_setting_appearance, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10074a;
    }
}
