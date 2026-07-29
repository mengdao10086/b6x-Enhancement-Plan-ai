package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f30572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f30573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f30574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f30576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextView f30577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f30578g;

    public e(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 ImageView imageView2, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f30572a = constraintLayout;
        this.f30573b = imageView;
        this.f30574c = imageView2;
        this.f30575d = textView;
        this.f30576e = textView2;
        this.f30577f = textView3;
        this.f30578g = textView4;
    }

    @n0
    public static e a(@n0 View view) {
        int i10 = R.id.btn_action;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_icon;
            ImageView imageView2 = (ImageView) j2.c.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tv_desc;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_state;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_state_hint;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            i10 = R.id.tv_title;
                            TextView textView4 = (TextView) j2.c.a(view, i10);
                            if (textView4 != null) {
                                return new e((ConstraintLayout) view, imageView, imageView2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static e c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static e d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_action_item_firmware_upgrade, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f30572a;
    }
}
