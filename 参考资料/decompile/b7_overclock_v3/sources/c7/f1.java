package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.flydigi.device_manager.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class f1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final View f10016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f10018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f10019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final Button f10020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final Button f10021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Button f10022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final Button f10023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final Button f10024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final Button f10025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final Button f10026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final Button f10027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final Button f10028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final Button f10029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final Button f10030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final Button f10031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final Button f10032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10033r;

    public f1(@g.n0 View view, @g.n0 Button button, @g.n0 Button button2, @g.n0 Button button3, @g.n0 Button button4, @g.n0 Button button5, @g.n0 Button button6, @g.n0 Button button7, @g.n0 Button button8, @g.n0 Button button9, @g.n0 Button button10, @g.n0 Button button11, @g.n0 Button button12, @g.n0 Button button13, @g.n0 Button button14, @g.n0 Button button15, @g.n0 Button button16, @g.n0 LinearLayout linearLayout) {
        this.f10016a = view;
        this.f10017b = button;
        this.f10018c = button2;
        this.f10019d = button3;
        this.f10020e = button4;
        this.f10021f = button5;
        this.f10022g = button6;
        this.f10023h = button7;
        this.f10024i = button8;
        this.f10025j = button9;
        this.f10026k = button10;
        this.f10027l = button11;
        this.f10028m = button12;
        this.f10029n = button13;
        this.f10030o = button14;
        this.f10031p = button15;
        this.f10032q = button16;
        this.f10033r = linearLayout;
    }

    @g.n0
    public static f1 a(@g.n0 View view) {
        int i10 = R.id.btn_alt;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_ctrl;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                i10 = R.id.btn_km_key1;
                Button button3 = (Button) j2.c.a(view, i10);
                if (button3 != null) {
                    i10 = R.id.btn_km_key2;
                    Button button4 = (Button) j2.c.a(view, i10);
                    if (button4 != null) {
                        i10 = R.id.btn_km_key3;
                        Button button5 = (Button) j2.c.a(view, i10);
                        if (button5 != null) {
                            i10 = R.id.btn_km_key4;
                            Button button6 = (Button) j2.c.a(view, i10);
                            if (button6 != null) {
                                i10 = R.id.btn_km_key5;
                                Button button7 = (Button) j2.c.a(view, i10);
                                if (button7 != null) {
                                    i10 = R.id.btn_mouse_backward;
                                    Button button8 = (Button) j2.c.a(view, i10);
                                    if (button8 != null) {
                                        i10 = R.id.btn_mouse_forward;
                                        Button button9 = (Button) j2.c.a(view, i10);
                                        if (button9 != null) {
                                            i10 = R.id.btn_mouse_left;
                                            Button button10 = (Button) j2.c.a(view, i10);
                                            if (button10 != null) {
                                                i10 = R.id.btn_mouse_middle;
                                                Button button11 = (Button) j2.c.a(view, i10);
                                                if (button11 != null) {
                                                    i10 = R.id.btn_mouse_right;
                                                    Button button12 = (Button) j2.c.a(view, i10);
                                                    if (button12 != null) {
                                                        i10 = R.id.btn_mouse_wheel_down;
                                                        Button button13 = (Button) j2.c.a(view, i10);
                                                        if (button13 != null) {
                                                            i10 = R.id.btn_mouse_wheel_up;
                                                            Button button14 = (Button) j2.c.a(view, i10);
                                                            if (button14 != null) {
                                                                i10 = R.id.btn_shift;
                                                                Button button15 = (Button) j2.c.a(view, i10);
                                                                if (button15 != null) {
                                                                    i10 = R.id.btn_win;
                                                                    Button button16 = (Button) j2.c.a(view, i10);
                                                                    if (button16 != null) {
                                                                        i10 = R.id.ll_km_common_key;
                                                                        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                                                        if (linearLayout != null) {
                                                                            return new f1(view, button, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, linearLayout);
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
    public static f1 b(@g.n0 LayoutInflater layoutInflater, @g.n0 ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, androidx.constraintlayout.widget.d.V1);
        layoutInflater.inflate(R.layout.device_fragment_mapping_test_keyboard_mouse, viewGroup);
        return a(viewGroup);
    }

    @Override // j2.b
    @g.n0
    public View getRoot() {
        return this.f10016a;
    }
}
