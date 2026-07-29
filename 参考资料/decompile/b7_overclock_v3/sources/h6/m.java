package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f30659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f30660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f30661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f30663e;

    public m(@n0 LinearLayout linearLayout, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f30659a = linearLayout;
        this.f30660b = textView;
        this.f30661c = textView2;
        this.f30662d = textView3;
        this.f30663e = textView4;
    }

    @n0
    public static m a(@n0 View view) {
        int i10 = R.id.btn_upgrade;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_firmware_left;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.tv_firmware_right;
                TextView textView3 = (TextView) j2.c.a(view, i10);
                if (textView3 != null) {
                    i10 = R.id.tv_info;
                    TextView textView4 = (TextView) j2.c.a(view, i10);
                    if (textView4 != null) {
                        return new m((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static m c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static m d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_fragment_upgrade_x1, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f30659a;
    }
}
