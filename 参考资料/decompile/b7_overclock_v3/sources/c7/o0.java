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
public final class o0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f10296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final Button f10297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ImageView f10298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f10300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f10301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10305m;

    public o0(@g.n0 LinearLayout linearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout2, @g.n0 Button button, @g.n0 Button button2, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7) {
        this.f10293a = linearLayout;
        this.f10294b = constraintLayout;
        this.f10295c = linearLayout2;
        this.f10296d = button;
        this.f10297e = button2;
        this.f10298f = imageView;
        this.f10299g = textView;
        this.f10300h = textView2;
        this.f10301i = textView3;
        this.f10302j = textView4;
        this.f10303k = textView5;
        this.f10304l = textView6;
        this.f10305m = textView7;
    }

    @g.n0
    public static o0 a(@g.n0 View view) {
        int i10 = R.id.area_firmware_info;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_new_firmware_info;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.btn_list;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.btn_upgrade;
                    Button button2 = (Button) j2.c.a(view, i10);
                    if (button2 != null) {
                        i10 = R.id.iv_device;
                        ImageView imageView = (ImageView) j2.c.a(view, i10);
                        if (imageView != null) {
                            i10 = R.id.tv_device_name;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                i10 = R.id.tv_file_size;
                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.tv_firmware_info;
                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                    if (textView3 != null) {
                                        i10 = R.id.tv_firmware_up_to_date;
                                        TextView textView4 = (TextView) j2.c.a(view, i10);
                                        if (textView4 != null) {
                                            i10 = R.id.tv_loading;
                                            TextView textView5 = (TextView) j2.c.a(view, i10);
                                            if (textView5 != null) {
                                                i10 = R.id.tv_message_for_krly;
                                                TextView textView6 = (TextView) j2.c.a(view, i10);
                                                if (textView6 != null) {
                                                    i10 = R.id.tv_title;
                                                    TextView textView7 = (TextView) j2.c.a(view, i10);
                                                    if (textView7 != null) {
                                                        return new o0((LinearLayout) view, constraintLayout, linearLayout, button, button2, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static o0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static o0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_firmware_latest, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10293a;
    }
}
