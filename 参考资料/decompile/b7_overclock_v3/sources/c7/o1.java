package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class o1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f10308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10312g;

    public o1(@g.n0 LinearLayout linearLayout, @g.n0 TextView textView, @g.n0 SuperButton superButton, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f10306a = linearLayout;
        this.f10307b = textView;
        this.f10308c = superButton;
        this.f10309d = textView2;
        this.f10310e = textView3;
        this.f10311f = textView4;
        this.f10312g = textView5;
    }

    @g.n0
    public static o1 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.iv_result;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.tv_game_name;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_hint;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.tv_result;
                        TextView textView4 = (TextView) j2.c.a(view, i10);
                        if (textView4 != null) {
                            i10 = R.id.tv_share_code;
                            TextView textView5 = (TextView) j2.c.a(view, i10);
                            if (textView5 != null) {
                                return new o1((LinearLayout) view, textView, superButton, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static o1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static o1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_share_success, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10306a;
    }
}
