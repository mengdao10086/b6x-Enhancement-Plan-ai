package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.base.widget.DividerPaddingLinearLayout;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.led.ColorPickerView;
import com.flydigi.device_manager.ui.detail.waspwing.led.OnItemClickSpinner;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.slider.Slider;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final DividerPaddingLinearLayout f10054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Button f10059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ColorPickerView f10060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ShapeableImageView f10061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final Slider f10062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final Slider f10063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final SwitchMaterial f10064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final OnItemClickSpinner f10065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f10069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final TextView f10070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final TextView f10071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g.n0
    public final TextView f10072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @g.n0
    public final TextView f10073u;

    public h(@g.n0 LinearLayout linearLayout, @g.n0 DividerPaddingLinearLayout dividerPaddingLinearLayout, @g.n0 ConstraintLayout constraintLayout, @g.n0 LinearLayout linearLayout2, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ConstraintLayout constraintLayout3, @g.n0 Button button, @g.n0 ColorPickerView colorPickerView, @g.n0 ShapeableImageView shapeableImageView, @g.n0 Slider slider, @g.n0 Slider slider2, @g.n0 SwitchMaterial switchMaterial, @g.n0 OnItemClickSpinner onItemClickSpinner, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8) {
        this.f10053a = linearLayout;
        this.f10054b = dividerPaddingLinearLayout;
        this.f10055c = constraintLayout;
        this.f10056d = linearLayout2;
        this.f10057e = constraintLayout2;
        this.f10058f = constraintLayout3;
        this.f10059g = button;
        this.f10060h = colorPickerView;
        this.f10061i = shapeableImageView;
        this.f10062j = slider;
        this.f10063k = slider2;
        this.f10064l = switchMaterial;
        this.f10065m = onItemClickSpinner;
        this.f10066n = textView;
        this.f10067o = textView2;
        this.f10068p = textView3;
        this.f10069q = textView4;
        this.f10070r = textView5;
        this.f10071s = textView6;
        this.f10072t = textView7;
        this.f10073u = textView8;
    }

    @g.n0
    public static h a(@g.n0 View view) {
        int i10 = R.id.area_colors;
        DividerPaddingLinearLayout dividerPaddingLinearLayout = (DividerPaddingLinearLayout) j2.c.a(view, i10);
        if (dividerPaddingLinearLayout != null) {
            i10 = R.id.area_led_config;
            ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.area_led_type;
                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.area_light;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
                    if (constraintLayout2 != null) {
                        i10 = R.id.area_speed;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) j2.c.a(view, i10);
                        if (constraintLayout3 != null) {
                            i10 = R.id.btn_reset_color;
                            Button button = (Button) j2.c.a(view, i10);
                            if (button != null) {
                                i10 = R.id.cpv_led_color;
                                ColorPickerView colorPickerView = (ColorPickerView) j2.c.a(view, i10);
                                if (colorPickerView != null) {
                                    i10 = R.id.iv_add;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) j2.c.a(view, i10);
                                    if (shapeableImageView != null) {
                                        i10 = R.id.seekbar_light;
                                        Slider slider = (Slider) j2.c.a(view, i10);
                                        if (slider != null) {
                                            i10 = R.id.seekbar_speed;
                                            Slider slider2 = (Slider) j2.c.a(view, i10);
                                            if (slider2 != null) {
                                                i10 = R.id.sm_led_state;
                                                SwitchMaterial switchMaterial = (SwitchMaterial) j2.c.a(view, i10);
                                                if (switchMaterial != null) {
                                                    i10 = R.id.spinner_led_type;
                                                    OnItemClickSpinner onItemClickSpinner = (OnItemClickSpinner) j2.c.a(view, i10);
                                                    if (onItemClickSpinner != null) {
                                                        i10 = R.id.tv_default;
                                                        TextView textView = (TextView) j2.c.a(view, i10);
                                                        if (textView != null) {
                                                            i10 = R.id.tv_fast;
                                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                                            if (textView2 != null) {
                                                                i10 = R.id.tv_high;
                                                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                                                if (textView3 != null) {
                                                                    i10 = R.id.tv_label_quick_switch;
                                                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                                                    if (textView4 != null) {
                                                                        i10 = R.id.tv_led_type_circle_smart_desc;
                                                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                        if (textView5 != null) {
                                                                            i10 = R.id.tv_low;
                                                                            TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                            if (textView6 != null) {
                                                                                i10 = R.id.tv_middle;
                                                                                TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                                if (textView7 != null) {
                                                                                    i10 = R.id.tv_slow;
                                                                                    TextView textView8 = (TextView) j2.c.a(view, i10);
                                                                                    if (textView8 != null) {
                                                                                        return new h((LinearLayout) view, dividerPaddingLinearLayout, constraintLayout, linearLayout, constraintLayout2, constraintLayout3, button, colorPickerView, shapeableImageView, slider, slider2, switchMaterial, onItemClickSpinner, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
    public static h c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static h d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_activity_waspwing_led, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10053a;
    }
}
