package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f9194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ActionItemNormal f9200g;

    public i(@n0 NestedScrollView nestedScrollView, @n0 ActionItemNormal actionItemNormal, @n0 ActionItemNormal actionItemNormal2, @n0 ActionItemNormal actionItemNormal3, @n0 ActionItemNormal actionItemNormal4, @n0 ActionItemNormal actionItemNormal5, @n0 ActionItemNormal actionItemNormal6) {
        this.f9194a = nestedScrollView;
        this.f9195b = actionItemNormal;
        this.f9196c = actionItemNormal2;
        this.f9197d = actionItemNormal3;
        this.f9198e = actionItemNormal4;
        this.f9199f = actionItemNormal5;
        this.f9200g = actionItemNormal6;
    }

    @n0
    public static i a(@n0 View view) {
        int i10 = R.id.ov_disclaimer;
        ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, R.id.ov_disclaimer);
        if (actionItemNormal != null) {
            i10 = R.id.ov_official_site;
            ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, R.id.ov_official_site);
            if (actionItemNormal2 != null) {
                i10 = R.id.ov_user_agreement;
                ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, R.id.ov_user_agreement);
                if (actionItemNormal3 != null) {
                    i10 = R.id.ov_user_privacy;
                    ActionItemNormal actionItemNormal4 = (ActionItemNormal) j2.c.a(view, R.id.ov_user_privacy);
                    if (actionItemNormal4 != null) {
                        i10 = R.id.ov_wechat;
                        ActionItemNormal actionItemNormal5 = (ActionItemNormal) j2.c.a(view, R.id.ov_wechat);
                        if (actionItemNormal5 != null) {
                            i10 = R.id.ov_weibo;
                            ActionItemNormal actionItemNormal6 = (ActionItemNormal) j2.c.a(view, R.id.ov_weibo);
                            if (actionItemNormal6 != null) {
                                return new i((NestedScrollView) view, actionItemNormal, actionItemNormal2, actionItemNormal3, actionItemNormal4, actionItemNormal5, actionItemNormal6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static i c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static i d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_fragment_about_us, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f9194a;
    }
}
