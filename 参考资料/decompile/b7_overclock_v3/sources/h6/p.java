package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f30691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f30692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Button f30694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f30695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f30696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final Button f30697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final Button f30698i;

    public p(@n0 LinearLayout linearLayout, @n0 Button button, @n0 TextView textView, @n0 TextView textView2, @n0 Button button2, @n0 TextView textView3, @n0 TextView textView4, @n0 Button button3, @n0 Button button4) {
        this.f30690a = linearLayout;
        this.f30691b = button;
        this.f30692c = textView;
        this.f30693d = textView2;
        this.f30694e = button2;
        this.f30695f = textView3;
        this.f30696g = textView4;
        this.f30697h = button3;
        this.f30698i = button4;
    }

    @n0
    public static p a(@n0 View view) {
        int i10 = R.id.cancel_dual_pick;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.dual_pick_file_left_title;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.dual_pick_file_right_title;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.ok_dual_pick;
                    Button button2 = (Button) j2.c.a(view, i10);
                    if (button2 != null) {
                        i10 = R.id.ota_file_left;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.ota_file_right;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                i10 = R.id.pick_ota_file_left;
                                Button button3 = (Button) j2.c.a(view, i10);
                                if (button3 != null) {
                                    i10 = R.id.pick_ota_file_right;
                                    Button button4 = (Button) j2.c.a(view, i10);
                                    if (button4 != null) {
                                        return new p((LinearLayout) view, button, textView, textView2, button2, textView3, textView4, button3, button4);
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

    @n0
    public static p c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static p d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.ota_daul_pick_file, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30690a;
    }
}
