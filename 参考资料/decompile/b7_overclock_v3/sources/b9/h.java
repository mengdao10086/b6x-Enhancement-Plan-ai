package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.widget.DividerPaddingLinearLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f9173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9188p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final DividerPaddingLinearLayout f9189q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final DividerPaddingLinearLayout f9190r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public final DividerPaddingLinearLayout f9191s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @n0
    public final DividerPaddingLinearLayout f9192t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @n0
    public final Button f9193u;

    public h(@n0 LinearLayout linearLayout, @n0 ActionItemNormal actionItemNormal, @n0 ActionItemNormal actionItemNormal2, @n0 ActionItemNormal actionItemNormal3, @n0 ActionItemNormal actionItemNormal4, @n0 ActionItemNormal actionItemNormal5, @n0 ActionItemNormal actionItemNormal6, @n0 ActionItemNormal actionItemNormal7, @n0 ActionItemNormal actionItemNormal8, @n0 ActionItemNormal actionItemNormal9, @n0 ActionItemNormal actionItemNormal10, @n0 ActionItemNormal actionItemNormal11, @n0 ActionItemNormal actionItemNormal12, @n0 ActionItemNormal actionItemNormal13, @n0 ActionItemNormal actionItemNormal14, @n0 ActionItemNormal actionItemNormal15, @n0 DividerPaddingLinearLayout dividerPaddingLinearLayout, @n0 DividerPaddingLinearLayout dividerPaddingLinearLayout2, @n0 DividerPaddingLinearLayout dividerPaddingLinearLayout3, @n0 DividerPaddingLinearLayout dividerPaddingLinearLayout4, @n0 Button button) {
        this.f9173a = linearLayout;
        this.f9174b = actionItemNormal;
        this.f9175c = actionItemNormal2;
        this.f9176d = actionItemNormal3;
        this.f9177e = actionItemNormal4;
        this.f9178f = actionItemNormal5;
        this.f9179g = actionItemNormal6;
        this.f9180h = actionItemNormal7;
        this.f9181i = actionItemNormal8;
        this.f9182j = actionItemNormal9;
        this.f9183k = actionItemNormal10;
        this.f9184l = actionItemNormal11;
        this.f9185m = actionItemNormal12;
        this.f9186n = actionItemNormal13;
        this.f9187o = actionItemNormal14;
        this.f9188p = actionItemNormal15;
        this.f9189q = dividerPaddingLinearLayout;
        this.f9190r = dividerPaddingLinearLayout2;
        this.f9191s = dividerPaddingLinearLayout3;
        this.f9192t = dividerPaddingLinearLayout4;
        this.f9193u = button;
    }

    @n0
    public static h a(@n0 View view) {
        int i10 = R.id.ai_app_version;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, R.id.ai_app_version);
        if (actionItemNormal != null) {
            i10 = R.id.ai_connect_type;
            ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, R.id.ai_connect_type);
            if (actionItemNormal2 != null) {
                i10 = R.id.ai_driver_version;
                ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, R.id.ai_driver_version);
                if (actionItemNormal3 != null) {
                    i10 = R.id.ai_firmware_version;
                    ActionItemNormal actionItemNormal4 = (ActionItemNormal) j2.c.a(view, R.id.ai_firmware_version);
                    if (actionItemNormal4 != null) {
                        i10 = R.id.ai_gamepad_mac;
                        ActionItemNormal actionItemNormal5 = (ActionItemNormal) j2.c.a(view, R.id.ai_gamepad_mac);
                        if (actionItemNormal5 != null) {
                            i10 = R.id.ai_gamepad_model;
                            ActionItemNormal actionItemNormal6 = (ActionItemNormal) j2.c.a(view, R.id.ai_gamepad_model);
                            if (actionItemNormal6 != null) {
                                i10 = R.id.ai_headset_mac;
                                ActionItemNormal actionItemNormal7 = (ActionItemNormal) j2.c.a(view, R.id.ai_headset_mac);
                                if (actionItemNormal7 != null) {
                                    i10 = R.id.ai_headset_model;
                                    ActionItemNormal actionItemNormal8 = (ActionItemNormal) j2.c.a(view, R.id.ai_headset_model);
                                    if (actionItemNormal8 != null) {
                                        i10 = R.id.ai_headset_version;
                                        ActionItemNormal actionItemNormal9 = (ActionItemNormal) j2.c.a(view, R.id.ai_headset_version);
                                        if (actionItemNormal9 != null) {
                                            i10 = R.id.ai_phone_model;
                                            ActionItemNormal actionItemNormal10 = (ActionItemNormal) j2.c.a(view, R.id.ai_phone_model);
                                            if (actionItemNormal10 != null) {
                                                i10 = R.id.ai_sys_version;
                                                ActionItemNormal actionItemNormal11 = (ActionItemNormal) j2.c.a(view, R.id.ai_sys_version);
                                                if (actionItemNormal11 != null) {
                                                    i10 = R.id.ai_waspwing_firmware_version;
                                                    ActionItemNormal actionItemNormal12 = (ActionItemNormal) j2.c.a(view, R.id.ai_waspwing_firmware_version);
                                                    if (actionItemNormal12 != null) {
                                                        i10 = R.id.ai_waspwing_mac;
                                                        ActionItemNormal actionItemNormal13 = (ActionItemNormal) j2.c.a(view, R.id.ai_waspwing_mac);
                                                        if (actionItemNormal13 != null) {
                                                            i10 = R.id.ai_waspwing_model;
                                                            ActionItemNormal actionItemNormal14 = (ActionItemNormal) j2.c.a(view, R.id.ai_waspwing_model);
                                                            if (actionItemNormal14 != null) {
                                                                i10 = R.id.ai_waspwing_run_mode;
                                                                ActionItemNormal actionItemNormal15 = (ActionItemNormal) j2.c.a(view, R.id.ai_waspwing_run_mode);
                                                                if (actionItemNormal15 != null) {
                                                                    i10 = R.id.area_gamepad_info;
                                                                    DividerPaddingLinearLayout dividerPaddingLinearLayout = (DividerPaddingLinearLayout) j2.c.a(view, R.id.area_gamepad_info);
                                                                    if (dividerPaddingLinearLayout != null) {
                                                                        i10 = R.id.area_headset_info;
                                                                        DividerPaddingLinearLayout dividerPaddingLinearLayout2 = (DividerPaddingLinearLayout) j2.c.a(view, R.id.area_headset_info);
                                                                        if (dividerPaddingLinearLayout2 != null) {
                                                                            i10 = R.id.area_phone_info;
                                                                            DividerPaddingLinearLayout dividerPaddingLinearLayout3 = (DividerPaddingLinearLayout) j2.c.a(view, R.id.area_phone_info);
                                                                            if (dividerPaddingLinearLayout3 != null) {
                                                                                i10 = R.id.area_waspwing_info;
                                                                                DividerPaddingLinearLayout dividerPaddingLinearLayout4 = (DividerPaddingLinearLayout) j2.c.a(view, R.id.area_waspwing_info);
                                                                                if (dividerPaddingLinearLayout4 != null) {
                                                                                    i10 = R.id.btn_copy;
                                                                                    Button button = (Button) j2.c.a(view, R.id.btn_copy);
                                                                                    if (button != null) {
                                                                                        return new h((LinearLayout) view, actionItemNormal, actionItemNormal2, actionItemNormal3, actionItemNormal4, actionItemNormal5, actionItemNormal6, actionItemNormal7, actionItemNormal8, actionItemNormal9, actionItemNormal10, actionItemNormal11, actionItemNormal12, actionItemNormal13, actionItemNormal14, actionItemNormal15, dividerPaddingLinearLayout, dividerPaddingLinearLayout2, dividerPaddingLinearLayout3, dividerPaddingLinearLayout4, button);
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

    @n0
    public static h c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static h d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_fragment_about_phone, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f9173a;
    }
}
