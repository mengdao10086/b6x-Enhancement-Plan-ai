package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.base.widget.MyGridView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final CheckBox f10278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final MyGridView f10279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final MyGridView f10280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final MyGridView f10281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final MyGridView f10282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ImageView f10283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f10286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f10287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10289m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10290n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10291o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10292p;

    public o(@g.n0 RelativeLayout relativeLayout, @g.n0 CheckBox checkBox, @g.n0 MyGridView myGridView, @g.n0 MyGridView myGridView2, @g.n0 MyGridView myGridView3, @g.n0 MyGridView myGridView4, @g.n0 ImageView imageView, @g.n0 RelativeLayout relativeLayout2, @g.n0 LinearLayout linearLayout, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6, @g.n0 TextView textView7) {
        this.f10277a = relativeLayout;
        this.f10278b = checkBox;
        this.f10279c = myGridView;
        this.f10280d = myGridView2;
        this.f10281e = myGridView3;
        this.f10282f = myGridView4;
        this.f10283g = imageView;
        this.f10284h = relativeLayout2;
        this.f10285i = linearLayout;
        this.f10286j = textView;
        this.f10287k = textView2;
        this.f10288l = textView3;
        this.f10289m = textView4;
        this.f10290n = textView5;
        this.f10291o = textView6;
        this.f10292p = textView7;
    }

    @g.n0
    public static o a(@g.n0 View view) {
        int i10 = R.id.cb_reset;
        CheckBox checkBox = (CheckBox) j2.c.a(view, i10);
        if (checkBox != null) {
            i10 = R.id.gridview_0;
            MyGridView myGridView = (MyGridView) j2.c.a(view, i10);
            if (myGridView != null) {
                i10 = R.id.gridview_1;
                MyGridView myGridView2 = (MyGridView) j2.c.a(view, i10);
                if (myGridView2 != null) {
                    i10 = R.id.gridview_2;
                    MyGridView myGridView3 = (MyGridView) j2.c.a(view, i10);
                    if (myGridView3 != null) {
                        i10 = R.id.gridview_3;
                        MyGridView myGridView4 = (MyGridView) j2.c.a(view, i10);
                        if (myGridView4 != null) {
                            i10 = R.id.iv_image;
                            ImageView imageView = (ImageView) j2.c.a(view, i10);
                            if (imageView != null) {
                                i10 = R.id.layout_dialog;
                                RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
                                if (relativeLayout != null) {
                                    i10 = R.id.ll_ok;
                                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                    if (linearLayout != null) {
                                        i10 = R.id.tv_apply;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            i10 = R.id.tv_content;
                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                            if (textView2 != null) {
                                                i10 = R.id.tv_import;
                                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                                if (textView3 != null) {
                                                    i10 = R.id.tv_ok;
                                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                                    if (textView4 != null) {
                                                        i10 = R.id.tv_recover;
                                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                                        if (textView5 != null) {
                                                            i10 = R.id.tv_saveas;
                                                            TextView textView6 = (TextView) j2.c.a(view, i10);
                                                            if (textView6 != null) {
                                                                i10 = R.id.tv_title;
                                                                TextView textView7 = (TextView) j2.c.a(view, i10);
                                                                if (textView7 != null) {
                                                                    return new o((RelativeLayout) view, checkBox, myGridView, myGridView2, myGridView3, myGridView4, imageView, relativeLayout, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
    public static o c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static o d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_cjzc_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10277a;
    }
}
