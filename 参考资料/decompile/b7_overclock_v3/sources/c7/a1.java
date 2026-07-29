package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f9795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f9796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f9797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final Button f9798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final Button f9799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Button f9800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final Button f9801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ImageButton f9802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f9803j;

    public a1(@g.n0 FrameLayout frameLayout, @g.n0 Button button, @g.n0 TextView textView, @g.n0 Button button2, @g.n0 Button button3, @g.n0 Button button4, @g.n0 Button button5, @g.n0 Button button6, @g.n0 ImageButton imageButton, @g.n0 TextView textView2) {
        this.f9794a = frameLayout;
        this.f9795b = button;
        this.f9796c = textView;
        this.f9797d = button2;
        this.f9798e = button3;
        this.f9799f = button4;
        this.f9800g = button5;
        this.f9801h = button6;
        this.f9802i = imageButton;
        this.f9803j = textView2;
    }

    @g.n0
    public static a1 a(@g.n0 View view) {
        int i10 = R.id.btn_motion;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_reset_joystick;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.btn_touch_point1;
                Button button2 = (Button) j2.c.a(view, i10);
                if (button2 != null) {
                    i10 = R.id.btn_touch_point2;
                    Button button3 = (Button) j2.c.a(view, i10);
                    if (button3 != null) {
                        i10 = R.id.btn_touch_point3;
                        Button button4 = (Button) j2.c.a(view, i10);
                        if (button4 != null) {
                            i10 = R.id.btn_touch_point4;
                            Button button5 = (Button) j2.c.a(view, i10);
                            if (button5 != null) {
                                i10 = R.id.btn_touch_point5;
                                Button button6 = (Button) j2.c.a(view, i10);
                                if (button6 != null) {
                                    i10 = R.id.ib_back;
                                    ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                                    if (imageButton != null) {
                                        i10 = R.id.tv_action;
                                        TextView textView2 = (TextView) j2.c.a(view, i10);
                                        if (textView2 != null) {
                                            return new a1((FrameLayout) view, button, textView, button2, button3, button4, button5, button6, imageButton, textView2);
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
    public static a1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_keymapping_test, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9794a;
    }
}
