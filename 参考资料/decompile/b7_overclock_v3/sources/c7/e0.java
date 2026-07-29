package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.b7.RunModeItem;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f9949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FirmwareUpgradeActionItem f9950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FirmwareUpgradeActionItem f9951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final RunModeItem f9955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f9956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final View f9957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final LinearLayout f9959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final g1 f9960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final ImageView f9961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final ImageView f9962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final RecyclerView f9963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f9964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f9965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.n0
    public final TextView f9966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.n0
    public final TextView f9967s;

    public e0(@g.n0 NestedScrollView nestedScrollView, @g.n0 FirmwareUpgradeActionItem firmwareUpgradeActionItem, @g.n0 FirmwareUpgradeActionItem firmwareUpgradeActionItem2, @g.n0 ActionItemNormal actionItemNormal, @g.n0 ActionItemNormal actionItemNormal2, @g.n0 ActionItemNormal actionItemNormal3, @g.n0 RunModeItem runModeItem, @g.n0 ActionItemNormal actionItemNormal4, @g.n0 View view, @g.n0 LinearLayout linearLayout, @g.n0 LinearLayout linearLayout2, @g.n0 g1 g1Var, @g.n0 ImageView imageView, @g.n0 ImageView imageView2, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f9949a = nestedScrollView;
        this.f9950b = firmwareUpgradeActionItem;
        this.f9951c = firmwareUpgradeActionItem2;
        this.f9952d = actionItemNormal;
        this.f9953e = actionItemNormal2;
        this.f9954f = actionItemNormal3;
        this.f9955g = runModeItem;
        this.f9956h = actionItemNormal4;
        this.f9957i = view;
        this.f9958j = linearLayout;
        this.f9959k = linearLayout2;
        this.f9960l = g1Var;
        this.f9961m = imageView;
        this.f9962n = imageView2;
        this.f9963o = recyclerView;
        this.f9964p = textView;
        this.f9965q = textView2;
        this.f9966r = textView3;
        this.f9967s = textView4;
    }

    @g.n0
    public static e0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.action_common_question;
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = (FirmwareUpgradeActionItem) j2.c.a(view, i10);
        if (firmwareUpgradeActionItem != null) {
            i10 = R.id.action_firmware_upgrade;
            FirmwareUpgradeActionItem firmwareUpgradeActionItem2 = (FirmwareUpgradeActionItem) j2.c.a(view, i10);
            if (firmwareUpgradeActionItem2 != null) {
                i10 = R.id.action_led_switch_manual;
                ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
                if (actionItemNormal != null) {
                    i10 = R.id.action_overclock;
                    ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, i10);
                    if (actionItemNormal2 != null) {
                        i10 = R.id.action_protection;
                        ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, i10);
                        if (actionItemNormal3 != null) {
                            i10 = R.id.action_run_mode;
                            RunModeItem runModeItem = (RunModeItem) j2.c.a(view, i10);
                            if (runModeItem != null) {
                                i10 = R.id.action_temperature;
                                ActionItemNormal actionItemNormal4 = (ActionItemNormal) j2.c.a(view, i10);
                                if (actionItemNormal4 != null && (viewA = j2.c.a(view, (i10 = R.id.area_divider))) != null) {
                                    i10 = R.id.area_function;
                                    LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                    if (linearLayout != null) {
                                        i10 = R.id.area_qa;
                                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                                        if (linearLayout2 != null && (viewA2 = j2.c.a(view, (i10 = R.id.area_todo_tips))) != null) {
                                            g1 g1VarA = g1.a(viewA2);
                                            i10 = R.id.iv_device;
                                            ImageView imageView = (ImageView) j2.c.a(view, i10);
                                            if (imageView != null) {
                                                i10 = R.id.iv_device_bg;
                                                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                                if (imageView2 != null) {
                                                    i10 = R.id.recycler_view;
                                                    RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                                                    if (recyclerView != null) {
                                                        i10 = R.id.tv_device_name;
                                                        TextView textView = (TextView) j2.c.a(view, i10);
                                                        if (textView != null) {
                                                            i10 = R.id.tv_state;
                                                            TextView textView2 = (TextView) j2.c.a(view, i10);
                                                            if (textView2 != null) {
                                                                i10 = R.id.tv_tech_name;
                                                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                                                if (textView3 != null) {
                                                                    i10 = R.id.tv_title_qa;
                                                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                                                    if (textView4 != null) {
                                                                        return new e0((NestedScrollView) view, firmwareUpgradeActionItem, firmwareUpgradeActionItem2, actionItemNormal, actionItemNormal2, actionItemNormal3, runModeItem, actionItemNormal4, viewA, linearLayout, linearLayout2, g1VarA, imageView, imageView2, recyclerView, textView, textView2, textView3, textView4);
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
    public static e0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static e0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_detail_b7, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f9949a;
    }
}
