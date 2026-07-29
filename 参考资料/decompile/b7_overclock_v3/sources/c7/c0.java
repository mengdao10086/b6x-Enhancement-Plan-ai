package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f9869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f9873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f9874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f9876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f9877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f9878j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f9879k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f9880l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f9881m;

    public c0(@g.n0 NestedScrollView nestedScrollView, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 LinearLayout linearLayout3, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7, @g.n0 TextView textView8, @g.n0 TextView textView9) {
        this.f9869a = nestedScrollView;
        this.f9870b = linearLayout;
        this.f9871c = linearLayout2;
        this.f9872d = linearLayout3;
        this.f9873e = textView;
        this.f9874f = textView2;
        this.f9875g = textView3;
        this.f9876h = textView4;
        this.f9877i = textView5;
        this.f9878j = textView6;
        this.f9879k = textView7;
        this.f9880l = textView8;
        this.f9881m = textView9;
    }

    @g.n0
    public static c0 a(@g.n0 View view) {
        int i10 = R.id.area_active_by_pc;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_active_by_utool;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.area_active_by_wadb;
                LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                if (linearLayout3 != null) {
                    i10 = R.id.btn_switch_to_flashplay_mode;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_active_by_pc;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_active_by_pc_desc;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                i10 = R.id.tv_active_by_utool;
                                TextView textView4 = (TextView) j2.c.a(view, i10);
                                if (textView4 != null) {
                                    i10 = R.id.tv_active_by_utool_desc;
                                    TextView textView5 = (TextView) j2.c.a(view, i10);
                                    if (textView5 != null) {
                                        i10 = R.id.tv_active_by_wadb;
                                        TextView textView6 = (TextView) j2.c.a(view, i10);
                                        if (textView6 != null) {
                                            i10 = R.id.tv_active_by_wadb_desc;
                                            TextView textView7 = (TextView) j2.c.a(view, i10);
                                            if (textView7 != null) {
                                                i10 = R.id.tv_desc;
                                                TextView textView8 = (TextView) j2.c.a(view, i10);
                                                if (textView8 != null) {
                                                    i10 = R.id.tv_title;
                                                    TextView textView9 = (TextView) j2.c.a(view, i10);
                                                    if (textView9 != null) {
                                                        return new c0((NestedScrollView) view, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
    public static c0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_active_type, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f9869a;
    }
}
