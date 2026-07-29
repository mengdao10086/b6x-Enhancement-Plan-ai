package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f56359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SuperButton f56360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final SuperButton f56361d;

    public j(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 SuperButton superButton, @n0 SuperButton superButton2) {
        this.f56358a = linearLayout;
        this.f56359b = linearLayout2;
        this.f56360c = superButton;
        this.f56361d = superButton2;
    }

    @n0
    public static j a(@n0 View view) {
        int i10 = R.id.area_search;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.btn_post;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.btn_search;
                SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                if (superButton2 != null) {
                    return new j((LinearLayout) view, linearLayout, superButton, superButton2);
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
        View viewInflate = layoutInflater.inflate(R.layout.community_fragment_home_item_search_bar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56358a;
    }
}
