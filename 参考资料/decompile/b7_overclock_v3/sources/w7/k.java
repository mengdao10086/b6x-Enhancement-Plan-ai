package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ImageView f54204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final EditText f54205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f54206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f54207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f54210h;

    public k(@g.n0 RelativeLayout relativeLayout, @g.n0 ImageView imageView, @g.n0 EditText editText, @g.n0 RelativeLayout relativeLayout2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4) {
        this.f54203a = relativeLayout;
        this.f54204b = imageView;
        this.f54205c = editText;
        this.f54206d = relativeLayout2;
        this.f54207e = textView;
        this.f54208f = textView2;
        this.f54209g = textView3;
        this.f54210h = textView4;
    }

    @g.n0
    public static k a(@g.n0 View view) {
        int i10 = R.id.btn_clear;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.et_text;
            EditText editText = (EditText) j2.c.a(view, i10);
            if (editText != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i10 = R.id.tv_cancel;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_content;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_ok;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.tv_title;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                return new k(relativeLayout, imageView, editText, relativeLayout, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static k c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static k d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_dialog_edit, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f54203a;
    }
}
