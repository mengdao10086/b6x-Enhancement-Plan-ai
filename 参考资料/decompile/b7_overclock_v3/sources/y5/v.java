package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.base.widget.ExpandableTextView;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f56438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ExpandableTextView f56440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final SuperButton f56441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f56442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f56443g;

    public v(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 TextView textView, @n0 ExpandableTextView expandableTextView, @n0 SuperButton superButton, @n0 TextView textView2, @n0 TextView textView3) {
        this.f56437a = constraintLayout;
        this.f56438b = imageView;
        this.f56439c = textView;
        this.f56440d = expandableTextView;
        this.f56441e = superButton;
        this.f56442f = textView2;
        this.f56443g = textView3;
    }

    @n0
    public static v a(@n0 View view) {
        int i10 = R.id.iv_avatar;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_author_flag;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_content;
                ExpandableTextView expandableTextView = (ExpandableTextView) j2.c.a(view, i10);
                if (expandableTextView != null) {
                    i10 = R.id.tv_like_num;
                    SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                    if (superButton != null) {
                        i10 = R.id.tv_nickname;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_time;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                return new v((ConstraintLayout) view, imageView, textView, expandableTextView, superButton, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static v c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static v d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_comment_content, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56437a;
    }
}
