package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.base.widget.action_item.ActionItemSwitch;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class t0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ActionItemSwitch f10469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ActionItemSwitch f10470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ActionItemSwitch f10471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final ActionItemSwitch f10474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10479l;

    public t0(@g.n0 LinearLayout linearLayout, @g.n0 ActionItemSwitch actionItemSwitch, @g.n0 ActionItemSwitch actionItemSwitch2, @g.n0 ActionItemSwitch actionItemSwitch3, @g.n0 ActionItemNormal actionItemNormal, @g.n0 ActionItemNormal actionItemNormal2, @g.n0 ActionItemSwitch actionItemSwitch4, @g.n0 ActionItemNormal actionItemNormal3, @g.n0 ActionItemNormal actionItemNormal4, @g.n0 ActionItemNormal actionItemNormal5, @g.n0 ActionItemNormal actionItemNormal6, @g.n0 ActionItemNormal actionItemNormal7) {
        this.f10468a = linearLayout;
        this.f10469b = actionItemSwitch;
        this.f10470c = actionItemSwitch2;
        this.f10471d = actionItemSwitch3;
        this.f10472e = actionItemNormal;
        this.f10473f = actionItemNormal2;
        this.f10474g = actionItemSwitch4;
        this.f10475h = actionItemNormal3;
        this.f10476i = actionItemNormal4;
        this.f10477j = actionItemNormal5;
        this.f10478k = actionItemNormal6;
        this.f10479l = actionItemNormal7;
    }

    @g.n0
    public static t0 a(@g.n0 View view) {
        int i10 = R.id.action_cast_assist;
        ActionItemSwitch actionItemSwitch = (ActionItemSwitch) j2.c.a(view, i10);
        if (actionItemSwitch != null) {
            i10 = R.id.action_driver_compatible;
            ActionItemSwitch actionItemSwitch2 = (ActionItemSwitch) j2.c.a(view, i10);
            if (actionItemSwitch2 != null) {
                i10 = R.id.action_hide_float_view;
                ActionItemSwitch actionItemSwitch3 = (ActionItemSwitch) j2.c.a(view, i10);
                if (actionItemSwitch3 != null) {
                    i10 = R.id.action_open_app_stats_usage;
                    ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
                    if (actionItemNormal != null) {
                        i10 = R.id.action_open_usb_debug;
                        ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, i10);
                        if (actionItemNormal2 != null) {
                            i10 = R.id.action_pad_support;
                            ActionItemSwitch actionItemSwitch4 = (ActionItemSwitch) j2.c.a(view, i10);
                            if (actionItemSwitch4 != null) {
                                i10 = R.id.action_pubg_native_support_mode;
                                ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, i10);
                                if (actionItemNormal3 != null) {
                                    i10 = R.id.action_quit_alpha_group;
                                    ActionItemNormal actionItemNormal4 = (ActionItemNormal) j2.c.a(view, i10);
                                    if (actionItemNormal4 != null) {
                                        i10 = R.id.action_quit_key_mapping;
                                        ActionItemNormal actionItemNormal5 = (ActionItemNormal) j2.c.a(view, i10);
                                        if (actionItemNormal5 != null) {
                                            i10 = R.id.action_rest_game_center;
                                            ActionItemNormal actionItemNormal6 = (ActionItemNormal) j2.c.a(view, i10);
                                            if (actionItemNormal6 != null) {
                                                i10 = R.id.action_write_config_to_flash;
                                                ActionItemNormal actionItemNormal7 = (ActionItemNormal) j2.c.a(view, i10);
                                                if (actionItemNormal7 != null) {
                                                    return new t0((LinearLayout) view, actionItemSwitch, actionItemSwitch2, actionItemSwitch3, actionItemNormal, actionItemNormal2, actionItemSwitch4, actionItemNormal3, actionItemNormal4, actionItemNormal5, actionItemNormal6, actionItemNormal7);
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
    public static t0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static t0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_game_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10468a;
    }
}
