package dg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.permissionx.guolindev.R;
import g.n0;
import g.p0;
import j2.c;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f26247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f26248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Button f26249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final LinearLayout f26250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f26251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Button f26252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final LinearLayout f26253g;

    public a(@n0 LinearLayout linearLayout, @n0 TextView textView, @n0 Button button, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 Button button2, @n0 LinearLayout linearLayout4) {
        this.f26247a = linearLayout;
        this.f26248b = textView;
        this.f26249c = button;
        this.f26250d = linearLayout2;
        this.f26251e = linearLayout3;
        this.f26252f = button2;
        this.f26253g = linearLayout4;
    }

    @n0
    public static a a(@n0 View view) {
        int i10 = R.id.messageText;
        TextView textView = (TextView) c.a(view, i10);
        if (textView != null) {
            i10 = R.id.negativeBtn;
            Button button = (Button) c.a(view, i10);
            if (button != null) {
                i10 = R.id.negativeLayout;
                LinearLayout linearLayout = (LinearLayout) c.a(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.permissionsLayout;
                    LinearLayout linearLayout2 = (LinearLayout) c.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.positiveBtn;
                        Button button2 = (Button) c.a(view, i10);
                        if (button2 != null) {
                            i10 = R.id.positiveLayout;
                            LinearLayout linearLayout3 = (LinearLayout) c.a(view, i10);
                            if (linearLayout3 != null) {
                                return new a((LinearLayout) view, textView, button, linearLayout, linearLayout2, button2, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.permissionx_default_dialog_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f26247a;
    }
}
