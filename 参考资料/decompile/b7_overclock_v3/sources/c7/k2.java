package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class k2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ActionItemNormal f10175b;

    public k2(@g.n0 FrameLayout frameLayout, @g.n0 ActionItemNormal actionItemNormal) {
        this.f10174a = frameLayout;
        this.f10175b = actionItemNormal;
    }

    @g.n0
    public static k2 a(@g.n0 View view) {
        int i10 = R.id.item_qa;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
        if (actionItemNormal != null) {
            return new k2((FrameLayout) view, actionItemNormal);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static k2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static k2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_qa, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f10174a;
    }
}
