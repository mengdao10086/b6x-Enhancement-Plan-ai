package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final CardView f56275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f56276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Space f56278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f56279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f56280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f56281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f56282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f56283i;

    public c0(@n0 CardView cardView, @n0 TextView textView, @n0 TextView textView2, @n0 Space space, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6, @n0 TextView textView7) {
        this.f56275a = cardView;
        this.f56276b = textView;
        this.f56277c = textView2;
        this.f56278d = space;
        this.f56279e = textView3;
        this.f56280f = textView4;
        this.f56281g = textView5;
        this.f56282h = textView6;
        this.f56283i = textView7;
    }

    @n0
    public static c0 a(@n0 View view) {
        int i10 = R.id.btn_delete;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.btn_edit;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.divider;
                Space space = (Space) j2.c.a(view, i10);
                if (space != null) {
                    i10 = R.id.tv_comment_num;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.tv_content;
                        TextView textView4 = (TextView) j2.c.a(view, i10);
                        if (textView4 != null) {
                            i10 = R.id.tv_game;
                            TextView textView5 = (TextView) j2.c.a(view, i10);
                            if (textView5 != null) {
                                i10 = R.id.tv_like_num;
                                TextView textView6 = (TextView) j2.c.a(view, i10);
                                if (textView6 != null) {
                                    i10 = R.id.tv_time;
                                    TextView textView7 = (TextView) j2.c.a(view, i10);
                                    if (textView7 != null) {
                                        return new c0((CardView) view, textView, textView2, space, textView3, textView4, textView5, textView6, textView7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static c0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static c0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_my_published_article, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.f56275a;
    }
}
