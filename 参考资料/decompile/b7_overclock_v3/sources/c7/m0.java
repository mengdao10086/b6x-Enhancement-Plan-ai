package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class m0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ImageView f10216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10221j;

    public m0(@g.n0 ConstraintLayout constraintLayout, @g.n0 Button button, @g.n0 TextView textView, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 LinearLayout linearLayout, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f10212a = constraintLayout;
        this.f10213b = button;
        this.f10214c = textView;
        this.f10215d = imageView;
        this.f10216e = imageView2;
        this.f10217f = linearLayout;
        this.f10218g = textView2;
        this.f10219h = textView3;
        this.f10220i = textView4;
        this.f10221j = textView5;
    }

    @g.n0
    public static m0 a(@g.n0 View view) {
        int i10 = R.id.btn_scan;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_time;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.iv_step_1;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.iv_step_2;
                    ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.ll_scanning;
                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout != null) {
                            i10 = R.id.tv_step_1;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_step_2;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.tv_step_2_hint;
                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R.id.tv_title;
                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                        if (textView5 != null) {
                                            return new m0((ConstraintLayout) view, button, textView, imageView, imageView2, linearLayout, textView2, textView3, textView4, textView5);
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
    public static m0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static m0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_dfu_scan_krly, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10212a;
    }
}
