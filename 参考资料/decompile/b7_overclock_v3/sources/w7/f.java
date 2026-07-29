package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.daasuu.bl.BubbleLayout;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final BubbleLayout f54069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final BubbleLayout f54070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f54071c;

    public f(@g.n0 BubbleLayout bubbleLayout, @g.n0 BubbleLayout bubbleLayout2, @g.n0 TextView textView) {
        this.f54069a = bubbleLayout;
        this.f54070b = bubbleLayout2;
        this.f54071c = textView;
    }

    @g.n0
    public static f a(@g.n0 View view) {
        BubbleLayout bubbleLayout = (BubbleLayout) view;
        int i10 = R.id.tv_bubble;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            return new f(bubbleLayout, bubbleLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static f c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static f d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_bubble_setting_config, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BubbleLayout getRoot() {
        return this.f54069a;
    }
}
