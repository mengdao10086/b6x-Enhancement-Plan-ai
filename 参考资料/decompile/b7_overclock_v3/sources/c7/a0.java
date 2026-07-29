package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final AppCompatCheckBox f9788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f9790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f9791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f9792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9793g;

    public a0(@g.n0 LinearLayout linearLayout, @g.n0 AppCompatCheckBox appCompatCheckBox, @g.n0 LinearLayout linearLayout2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f9787a = linearLayout;
        this.f9788b = appCompatCheckBox;
        this.f9789c = linearLayout2;
        this.f9790d = textView;
        this.f9791e = textView2;
        this.f9792f = textView3;
        this.f9793g = textView4;
    }

    @g.n0
    public static a0 a(@g.n0 View view) {
        int i10 = R.id.cb_reset;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) j2.c.a(view, i10);
        if (appCompatCheckBox != null) {
            i10 = R.id.ll_double;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.tv_cancel;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_content;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_reset;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.tv_title;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                return new a0((LinearLayout) view, appCompatCheckBox, linearLayout, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static a0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_dialog_reset_game_center, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9787a;
    }
}
