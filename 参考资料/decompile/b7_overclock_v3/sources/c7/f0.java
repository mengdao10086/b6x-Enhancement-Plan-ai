package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.DividerPaddingLinearLayout;
import com.flydigi.base.widget.action_item.ActionItemSwitch;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.detail.waspwing.WindSpeedSwitchItem;
import com.flydigi.device_manager.ui.detail.waspwing.WindTemperatureItem;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f9999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FirmwareUpgradeActionItem f10000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ActionItemSwitch f10001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final WindTemperatureItem f10002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final WindSpeedSwitchItem f10003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final View f10004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final DividerPaddingLinearLayout f10005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final g1 f10007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final View f10008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ImageView f10009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.n0
    public final TextView f10011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.n0
    public final TextView f10012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g.n0
    public final TextView f10013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.n0
    public final TextView f10014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g.n0
    public final TextView f10015q;

    public f0(@g.n0 NestedScrollView nestedScrollView, @g.n0 FirmwareUpgradeActionItem firmwareUpgradeActionItem, @g.n0 ActionItemSwitch actionItemSwitch, @g.n0 WindTemperatureItem windTemperatureItem, @g.n0 WindSpeedSwitchItem windSpeedSwitchItem, @g.n0 View view, @g.n0 DividerPaddingLinearLayout dividerPaddingLinearLayout, @g.n0 LinearLayout linearLayout, @g.n0 g1 g1Var, @g.n0 View view2, @g.n0 ImageView imageView, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5) {
        this.f9999a = nestedScrollView;
        this.f10000b = firmwareUpgradeActionItem;
        this.f10001c = actionItemSwitch;
        this.f10002d = windTemperatureItem;
        this.f10003e = windSpeedSwitchItem;
        this.f10004f = view;
        this.f10005g = dividerPaddingLinearLayout;
        this.f10006h = linearLayout;
        this.f10007i = g1Var;
        this.f10008j = view2;
        this.f10009k = imageView;
        this.f10010l = recyclerView;
        this.f10011m = textView;
        this.f10012n = textView2;
        this.f10013o = textView3;
        this.f10014p = textView4;
        this.f10015q = textView5;
    }

    @g.n0
    public static f0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.action_firmware_upgrade;
        FirmwareUpgradeActionItem firmwareUpgradeActionItem = (FirmwareUpgradeActionItem) j2.c.a(view, i10);
        if (firmwareUpgradeActionItem != null) {
            i10 = R.id.action_led_switch;
            ActionItemSwitch actionItemSwitch = (ActionItemSwitch) j2.c.a(view, i10);
            if (actionItemSwitch != null) {
                i10 = R.id.action_temperature;
                WindTemperatureItem windTemperatureItem = (WindTemperatureItem) j2.c.a(view, i10);
                if (windTemperatureItem != null) {
                    i10 = R.id.action_wind_speed_switch;
                    WindSpeedSwitchItem windSpeedSwitchItem = (WindSpeedSwitchItem) j2.c.a(view, i10);
                    if (windSpeedSwitchItem != null && (viewA = j2.c.a(view, (i10 = R.id.area_divider))) != null) {
                        i10 = R.id.area_function;
                        DividerPaddingLinearLayout dividerPaddingLinearLayout = (DividerPaddingLinearLayout) j2.c.a(view, i10);
                        if (dividerPaddingLinearLayout != null) {
                            i10 = R.id.area_qa;
                            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                            if (linearLayout != null && (viewA2 = j2.c.a(view, (i10 = R.id.area_todo_tips))) != null) {
                                g1 g1VarA = g1.a(viewA2);
                                i10 = R.id.divider;
                                View viewA3 = j2.c.a(view, i10);
                                if (viewA3 != null) {
                                    i10 = R.id.iv_device;
                                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                                    if (imageView != null) {
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
                                                                return new f0((NestedScrollView) view, firmwareUpgradeActionItem, actionItemSwitch, windTemperatureItem, windSpeedSwitchItem, viewA, dividerPaddingLinearLayout, linearLayout, g1VarA, viewA3, imageView, recyclerView, textView, textView2, textView3, textView4, textView5);
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
    public static f0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static f0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_detail_waspwing, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f9999a;
    }
}
