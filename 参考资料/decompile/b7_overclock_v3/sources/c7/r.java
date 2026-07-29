package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f10388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ImageView f10389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10391f;

    public r(@g.n0 RelativeLayout relativeLayout, @g.n0 TextView textView, @g.n0 Button button, @g.n0 ImageView imageView, @g.n0 TextView textView2, @g.n0 RelativeLayout relativeLayout2) {
        this.f10386a = relativeLayout;
        this.f10387b = textView;
        this.f10388c = button;
        this.f10389d = imageView;
        this.f10390e = textView2;
        this.f10391f = relativeLayout2;
    }

    @g.n0
    public static r a(@g.n0 View view) {
        int i10 = R.id.action_name;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.clear_key;
            Button button = (Button) j2.c.a(view, i10);
            if (button != null) {
                i10 = R.id.image_key;
                ImageView imageView = (ImageView) j2.c.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.key_notice;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        return new r(relativeLayout, textView, button, imageView, textView2, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static r c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static r d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_cjzc_listen, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10386a;
    }
}
