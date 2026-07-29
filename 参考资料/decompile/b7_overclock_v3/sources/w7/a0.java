package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f53955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f53956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f53957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f53958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f53959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f53960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final Space f53961g;

    public a0(@g.n0 RelativeLayout relativeLayout, @g.n0 RelativeLayout relativeLayout2, @g.n0 Button button, @g.n0 Button button2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 Space space) {
        this.f53955a = relativeLayout;
        this.f53956b = relativeLayout2;
        this.f53957c = button;
        this.f53958d = button2;
        this.f53959e = textView;
        this.f53960f = textView2;
        this.f53961g = space;
    }

    @g.n0
    public static a0 a(@g.n0 View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i10 = R.id.layout_question_cancel;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.layout_question_confirm;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                i10 = R.id.tv_warning_content;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_warning_title;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.view_divider;
                        Space space = (Space) j2.c.a(view, i10);
                        if (space != null) {
                            return new a0(relativeLayout, relativeLayout, button, button2, textView, textView2, space);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static a0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static a0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_notice_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f53955a;
    }
}
