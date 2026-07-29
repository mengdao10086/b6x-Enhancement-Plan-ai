package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.TwoViewHorLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.b6.RunModeItem;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f9903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FirmwareUpgradeActionItem f9905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final RunModeItem f9908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final View f9911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TwoViewHorLayout f9914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final g1 f9915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final View f9916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final ImageView f9917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final ImageView f9918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final ImageView f9919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final ImageView f9920r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final RecyclerView f9921s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g.n0
    public final TextView f9922t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @g.n0
    public final TextView f9923u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @g.n0
    public final TextView f9924v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @g.n0
    public final TextView f9925w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @g.n0
    public final TextView f9926x;

    public d0(@g.n0 NestedScrollView nestedScrollView, @g.n0 ActionItemNormal actionItemNormal, @g.n0 FirmwareUpgradeActionItem firmwareUpgradeActionItem, @g.n0 ActionItemNormal actionItemNormal2, @g.n0 ActionItemNormal actionItemNormal3, @g.n0 RunModeItem runModeItem, @g.n0 ActionItemNormal actionItemNormal4, @g.n0 ActionItemNormal actionItemNormal5, @g.n0 View view, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 TwoViewHorLayout twoViewHorLayout, @g.n0 g1 g1Var, @g.n0 View view2, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 ImageView imageView3, @g.n0 ImageView imageView4, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f9903a = nestedScrollView;
        this.f9904b = actionItemNormal;
        this.f9905c = firmwareUpgradeActionItem;
        this.f9906d = actionItemNormal2;
        this.f9907e = actionItemNormal3;
        this.f9908f = runModeItem;
        this.f9909g = actionItemNormal4;
        this.f9910h = actionItemNormal5;
        this.f9911i = view;
        this.f9912j = linearLayout;
        this.f9913k = linearLayout2;
        this.f9914l = twoViewHorLayout;
        this.f9915m = g1Var;
        this.f9916n = view2;
        this.f9917o = imageView;
        this.f9918p = imageView2;
        this.f9919q = imageView3;
        this.f9920r = imageView4;
        this.f9921s = recyclerView;
        this.f9922t = textView;
        this.f9923u = textView2;
        this.f9924v = textView3;
        this.f9925w = textView4;
        this.f9926x = textView5;
    }

    @g.n0
    public static d0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.action_experimental_mode;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
        if (actionItemNormal != null) {
            i10 = R.id.action_firmware_upgrade;
            FirmwareUpgradeActionItem firmwareUpgradeActionItem = (FirmwareUpgradeActionItem) j2.c.a(view, i10);
            if (firmwareUpgradeActionItem != null) {
                i10 = R.id.action_led_switch_manual;
                ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, i10);
                if (actionItemNormal2 != null) {
                    i10 = R.id.action_protection;
                    ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, i10);
                    if (actionItemNormal3 != null) {
                        i10 = R.id.action_run_mode;
                        RunModeItem runModeItem = (RunModeItem) j2.c.a(view, i10);
                        if (runModeItem != null) {
                            i10 = R.id.action_setting_more;
                            ActionItemNormal actionItemNormal4 = (ActionItemNormal) j2.c.a(view, i10);
                            if (actionItemNormal4 != null) {
                                i10 = R.id.action_temperature;
                                ActionItemNormal actionItemNormal5 = (ActionItemNormal) j2.c.a(view, i10);
                                if (actionItemNormal5 != null && (viewA = j2.c.a(view, (i10 = R.id.area_divider))) != null) {
                                    i10 = R.id.area_function;
                                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                    if (linearLayout != null) {
                                        i10 = R.id.area_qa;
                                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R.id.area_tech_name;
                                            TwoViewHorLayout twoViewHorLayout = (TwoViewHorLayout) j2.c.a(view, i10);
                                            if (twoViewHorLayout != null && (viewA2 = j2.c.a(view, (i10 = R.id.area_todo_tips))) != null) {
                                                g1 g1VarA = g1.a(viewA2);
                                                i10 = R.id.divider;
                                                View viewA3 = j2.c.a(view, i10);
                                                if (viewA3 != null) {
                                                    i10 = R.id.iv_device;
                                                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                                                    if (imageView != null) {
                                                        i10 = R.id.iv_device_bg;
                                                        ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                                        if (imageView2 != null) {
                                                            i10 = R.id.iv_overclock_state;
                                                            ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                                            if (imageView3 != null) {
                                                                i10 = R.id.iv_tech_name;
                                                                ImageView imageView4 = (ImageView) j2.c.a(view, i10);
                                                                if (imageView4 != null) {
                                                                    i10 = R.id.recycler_view;
                                                                    RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                                                                    if (recyclerView != null) {
                                                                        i10 = R.id.tv_device_name;
                                                                        TextView textView = (TextView) j2.c.a(view, i10);
                                                                        if (textView != null) {
                                                                            i10 = R.id.tv_overclock_state;
                                                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                                                            if (textView2 != null) {
                                                                                i10 = R.id.tv_state;
                                                                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                                                                if (textView3 != null) {
                                                                                    i10 = R.id.tv_tech_name;
                                                                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                                                                    if (textView4 != null) {
                                                                                        i10 = R.id.tv_title_qa;
                                                                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                                        if (textView5 != null) {
                                                                                            return new d0((NestedScrollView) view, actionItemNormal, firmwareUpgradeActionItem, actionItemNormal2, actionItemNormal3, runModeItem, actionItemNormal4, actionItemNormal5, viewA, linearLayout, linearLayout2, twoViewHorLayout, g1VarA, viewA3, imageView, imageView2, imageView3, imageView4, recyclerView, textView, textView2, textView3, textView4, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static d0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static d0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_detail_b6, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f9903a;
    }
}
