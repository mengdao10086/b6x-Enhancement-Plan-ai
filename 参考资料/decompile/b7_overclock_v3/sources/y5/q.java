package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final SuperButton f56418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56420d;

    public q(@n0 ConstraintLayout constraintLayout, @n0 SuperButton superButton, @n0 TextView textView, @n0 TextView textView2) {
        this.f56417a = constraintLayout;
        this.f56418b = superButton;
        this.f56419c = textView;
        this.f56420d = textView2;
    }

    @n0
    public static q a(@n0 View view) {
        int i10 = R.id.iv_arrow;
        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
        if (superButton != null) {
            i10 = R.id.tv_tag;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_title;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    return new q((ConstraintLayout) view, superButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static q c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static q d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_article_notice, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56417a;
    }
}
