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
public final class y implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final v f56451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final v f56453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final v f56454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ImageView f56455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f56456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final View f56457i;

    public y(@n0 ConstraintLayout constraintLayout, @n0 ConstraintLayout constraintLayout2, @n0 v vVar, @n0 ConstraintLayout constraintLayout3, @n0 v vVar2, @n0 v vVar3, @n0 ImageView imageView, @n0 TextView textView, @n0 View view) {
        this.f56449a = constraintLayout;
        this.f56450b = constraintLayout2;
        this.f56451c = vVar;
        this.f56452d = constraintLayout3;
        this.f56453e = vVar2;
        this.f56454f = vVar3;
        this.f56455g = imageView;
        this.f56456h = textView;
        this.f56457i = view;
    }

    @n0
    public static y a(@n0 View view) {
        View viewA;
        View viewA2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i10 = R.id.area_comment_content;
        View viewA3 = j2.c.a(view, i10);
        if (viewA3 != null) {
            v vVarA = v.a(viewA3);
            i10 = R.id.area_reply;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
            if (constraintLayout2 != null && (viewA = j2.c.a(view, (i10 = R.id.area_reply_1))) != null) {
                v vVarA2 = v.a(viewA);
                i10 = R.id.area_reply_2;
                View viewA4 = j2.c.a(view, i10);
                if (viewA4 != null) {
                    v vVarA3 = v.a(viewA4);
                    i10 = R.id.btn_more_action;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.btn_show_all;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null && (viewA2 = j2.c.a(view, (i10 = R.id.divider))) != null) {
                            return new y(constraintLayout, constraintLayout, vVarA, constraintLayout2, vVarA2, vVarA3, imageView, textView, viewA2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static y c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static y d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_comment_host, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56449a;
    }
}
