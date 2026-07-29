package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.base.widget.TagFlowLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TagFlowLayout f56372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TagFlowLayout f56373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageButton f56374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final RecyclerView f56375e;

    public l(@n0 LinearLayout linearLayout, @n0 TagFlowLayout tagFlowLayout, @n0 TagFlowLayout tagFlowLayout2, @n0 ImageButton imageButton, @n0 RecyclerView recyclerView) {
        this.f56371a = linearLayout;
        this.f56372b = tagFlowLayout;
        this.f56373c = tagFlowLayout2;
        this.f56374d = imageButton;
        this.f56375e = recyclerView;
    }

    @n0
    public static l a(@n0 View view) {
        int i10 = R.id.area_search_history_keywords;
        TagFlowLayout tagFlowLayout = (TagFlowLayout) j2.c.a(view, i10);
        if (tagFlowLayout != null) {
            i10 = R.id.area_search_hot_keywords;
            TagFlowLayout tagFlowLayout2 = (TagFlowLayout) j2.c.a(view, i10);
            if (tagFlowLayout2 != null) {
                i10 = R.id.btn_delete;
                ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                if (imageButton != null) {
                    i10 = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                    if (recyclerView != null) {
                        return new l((LinearLayout) view, tagFlowLayout, tagFlowLayout2, imageButton, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static l c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static l d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_fragment_search, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56371a;
    }
}
