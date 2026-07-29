package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f9201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9204d;

    public j(@n0 FrameLayout frameLayout, @n0 ActionItemNormal actionItemNormal, @n0 ActionItemNormal actionItemNormal2, @n0 ActionItemNormal actionItemNormal3) {
        this.f9201a = frameLayout;
        this.f9202b = actionItemNormal;
        this.f9203c = actionItemNormal2;
        this.f9204d = actionItemNormal3;
    }

    @n0
    public static j a(@n0 View view) {
        int i10 = R.id.ai_about_us;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, R.id.ai_about_us);
        if (actionItemNormal != null) {
            i10 = R.id.ai_customer_service;
            ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, R.id.ai_customer_service);
            if (actionItemNormal2 != null) {
                i10 = R.id.ai_feedback;
                ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, R.id.ai_feedback);
                if (actionItemNormal3 != null) {
                    return new j((FrameLayout) view, actionItemNormal, actionItemNormal2, actionItemNormal3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static j c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static j d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_fragment_contact_us, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9201a;
    }
}
