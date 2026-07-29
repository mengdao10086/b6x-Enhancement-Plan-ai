package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f36094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f36095b;

    public f(@n0 LinearLayout linearLayout, @n0 TextView textView) {
        this.f36094a = linearLayout;
        this.f36095b = textView;
    }

    @n0
    public static f a(@n0 View view) {
        int i10 = R.id.tv_error_tip;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            return new f((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static f c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.base_item_message_state, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f36094a;
    }
}
