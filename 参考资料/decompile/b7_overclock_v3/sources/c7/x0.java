package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class x0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ViewStub f10557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final View f10558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f10559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f10560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ImageView f10561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final View f10565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final View f10566m;

    public x0(@g.n0 LinearLayout linearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout2, @g.n0 ViewStub viewStub, @g.n0 View view, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 View view2, @g.n0 View view3) {
        this.f10554a = linearLayout;
        this.f10555b = constraintLayout;
        this.f10556c = linearLayout2;
        this.f10557d = viewStub;
        this.f10558e = view;
        this.f10559f = imageView;
        this.f10560g = imageView2;
        this.f10561h = imageView3;
        this.f10562i = textView;
        this.f10563j = textView2;
        this.f10564k = textView3;
        this.f10565l = view2;
        this.f10566m = view3;
    }

    @g.n0
    public static x0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i10 = R.id.area_device_info;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_info;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.area_todo_tips;
                ViewStub viewStub = (ViewStub) j2.c.a(view, i10);
                if (viewStub != null && (viewA = j2.c.a(view, (i10 = R.id.container_divider))) != null) {
                    i10 = R.id.iv_battery;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.iv_device;
                        ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.iv_info_more;
                            ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                            if (imageView3 != null) {
                                i10 = R.id.tv_mapping_mode;
                                TextView textView = (TextView) j2.c.a(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_name;
                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                    if (textView2 != null) {
                                        i10 = R.id.tv_state;
                                        TextView textView3 = (TextView) j2.c.a(view, i10);
                                        if (textView3 != null && (viewA2 = j2.c.a(view, (i10 = R.id.view_divider1))) != null && (viewA3 = j2.c.a(view, (i10 = R.id.view_divider2))) != null) {
                                            return new x0((LinearLayout) view, constraintLayout, linearLayout, viewStub, viewA, imageView, imageView2, imageView3, textView, textView2, textView3, viewA2, viewA3);
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
    public static x0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static x0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_home_gamepad, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10554a;
    }
}
