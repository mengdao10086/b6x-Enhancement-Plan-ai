package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final v f56429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final v f56431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final v f56432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ImageView f56433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f56434h;

    public t(@n0 ConstraintLayout constraintLayout, @n0 ConstraintLayout constraintLayout2, @n0 v vVar, @n0 ConstraintLayout constraintLayout3, @n0 v vVar2, @n0 v vVar3, @n0 ImageView imageView, @n0 TextView textView) {
        this.f56427a = constraintLayout;
        this.f56428b = constraintLayout2;
        this.f56429c = vVar;
        this.f56430d = constraintLayout3;
        this.f56431e = vVar2;
        this.f56432f = vVar3;
        this.f56433g = imageView;
        this.f56434h = textView;
    }

    @n0
    public static t a(@n0 View view) {
        View viewA;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i10 = R.id.area_comment_content;
        View viewA2 = j2.c.a(view, i10);
        if (viewA2 != null) {
            v vVarA = v.a(viewA2);
            i10 = R.id.area_reply;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout2 != null && (viewA = j2.c.a(view, (i10 = R.id.area_reply_1))) != null) {
                v vVarA2 = v.a(viewA);
                i10 = R.id.area_reply_2;
                View viewA3 = j2.c.a(view, i10);
                if (viewA3 != null) {
                    v vVarA3 = v.a(viewA3);
                    i10 = R.id.btn_more_action;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.btn_show_all;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            return new t(constraintLayout, constraintLayout, vVarA, constraintLayout2, vVarA2, vVarA3, imageView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static t c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static t d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_comment, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56427a;
    }
}
