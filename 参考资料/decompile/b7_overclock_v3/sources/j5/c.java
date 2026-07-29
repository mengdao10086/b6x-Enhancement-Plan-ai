package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f36079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f36080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f36081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ImageView f36082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f36083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f36084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f36085g;

    public c(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 ImageView imageView3, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3) {
        this.f36079a = constraintLayout;
        this.f36080b = imageView;
        this.f36081c = imageView2;
        this.f36082d = imageView3;
        this.f36083e = textView;
        this.f36084f = textView2;
        this.f36085g = textView3;
    }

    @n0
    public static c a(@n0 View view) {
        int i10 = R.id.btn_action;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_icon;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.iv_title;
                ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                if (imageView3 != null) {
                    i10 = R.id.tv_desc;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        i10 = R.id.tv_state;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.tv_title;
                            TextView textView3 = (TextView) j2.c.a(view, i10);
                            if (textView3 != null) {
                                return new c((ConstraintLayout) view, imageView, imageView2, imageView3, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static c c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static c d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.base_action_item_normal, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f36079a;
    }
}
