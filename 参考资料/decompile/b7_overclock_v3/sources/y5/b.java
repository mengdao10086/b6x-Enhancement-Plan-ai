package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f56260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final FrameLayout f56261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56262d;

    public b(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 FrameLayout frameLayout, @n0 TextView textView) {
        this.f56259a = linearLayout;
        this.f56260b = linearLayout2;
        this.f56261c = frameLayout;
        this.f56262d = textView;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.btn_send_comment;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.fl_container;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.tv_send_comment;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    return new b((LinearLayout) view, linearLayout, frameLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static b c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_activity_comment_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56259a;
    }
}
