package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class g0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final LinearLayout f10039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10040b;

    public g0(@g.n0 LinearLayout linearLayout, @g.n0 ActionItemNormal actionItemNormal) {
        this.f10039a = linearLayout;
        this.f10040b = actionItemNormal;
    }

    @g.n0
    public static g0 a(@g.n0 View view) {
        int i10 = R.id.action_setting_appearance;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
        if (actionItemNormal != null) {
            return new g0((LinearLayout) view, actionItemNormal);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_detail_waspwing_more_settings, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f10039a;
    }
}
