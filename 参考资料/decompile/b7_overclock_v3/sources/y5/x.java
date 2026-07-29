package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f56447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56448c;

    public x(@n0 ConstraintLayout constraintLayout, @n0 TextView textView, @n0 TextView textView2) {
        this.f56446a = constraintLayout;
        this.f56447b = textView;
        this.f56448c = textView2;
    }

    @n0
    public static x a(@n0 View view) {
        int i10 = R.id.tv_comments;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_sort;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                return new x((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static x c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static x d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_comment_header, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56446a;
    }
}
