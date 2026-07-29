package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.view.FirmwareUpgradeActionItem;
import com.flydigi.device_manager.view.MappingTestActionItem;

/* JADX INFO: loaded from: classes7.dex */
public final class u0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final NestedScrollView f10492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final FirmwareUpgradeActionItem f10494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final MappingTestActionItem f10497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final j0 f10498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final View f10499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10500i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final g1 f10501j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final RecyclerView f10502k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final TextView f10503l;

    public u0(@g.n0 NestedScrollView nestedScrollView, @g.n0 ActionItemNormal actionItemNormal, @g.n0 FirmwareUpgradeActionItem firmwareUpgradeActionItem, @g.n0 ActionItemNormal actionItemNormal2, @g.n0 ActionItemNormal actionItemNormal3, @g.n0 MappingTestActionItem mappingTestActionItem, @g.n0 j0 j0Var, @g.n0 View view, @g.n0 LinearLayout linearLayout, @g.n0 g1 g1Var, @g.n0 RecyclerView recyclerView, @g.n0 TextView textView) {
        this.f10492a = nestedScrollView;
        this.f10493b = actionItemNormal;
        this.f10494c = firmwareUpgradeActionItem;
        this.f10495d = actionItemNormal2;
        this.f10496e = actionItemNormal3;
        this.f10497f = mappingTestActionItem;
        this.f10498g = j0Var;
        this.f10499h = view;
        this.f10500i = linearLayout;
        this.f10501j = g1Var;
        this.f10502k = recyclerView;
        this.f10503l = textView;
    }

    @g.n0
    public static u0 a(@g.n0 View view) {
        View viewA;
        View viewA2;
        int i10 = R.id.action_apex_space;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
        if (actionItemNormal != null) {
            i10 = R.id.action_firmware_upgrade;
            FirmwareUpgradeActionItem firmwareUpgradeActionItem = (FirmwareUpgradeActionItem) j2.c.a(view, i10);
            if (firmwareUpgradeActionItem != null) {
                i10 = R.id.action_flymapping_driver;
                ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, i10);
                if (actionItemNormal2 != null) {
                    i10 = R.id.action_switch_mapping_mode;
                    ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, i10);
                    if (actionItemNormal3 != null) {
                        i10 = R.id.action_test;
                        MappingTestActionItem mappingTestActionItem = (MappingTestActionItem) j2.c.a(view, i10);
                        if (mappingTestActionItem != null && (viewA = j2.c.a(view, (i10 = R.id.area_device_card))) != null) {
                            j0 j0VarA = j0.a(viewA);
                            i10 = R.id.area_divider;
                            View viewA3 = j2.c.a(view, i10);
                            if (viewA3 != null) {
                                i10 = R.id.area_qa;
                                LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
                                if (linearLayout != null && (viewA2 = j2.c.a(view, (i10 = R.id.area_todo_tips))) != null) {
                                    g1 g1VarA = g1.a(viewA2);
                                    i10 = R.id.recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                                    if (recyclerView != null) {
                                        i10 = R.id.tv_title_qa;
                                        TextView textView = (TextView) j2.c.a(view, i10);
                                        if (textView != null) {
                                            return new u0((NestedScrollView) view, actionItemNormal, firmwareUpgradeActionItem, actionItemNormal2, actionItemNormal3, mappingTestActionItem, j0VarA, viewA3, linearLayout, g1VarA, recyclerView, textView);
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
    public static u0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static u0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_gamepad_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f10492a;
    }
}
