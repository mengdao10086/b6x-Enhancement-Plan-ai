package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.community.R;
import com.google.android.material.imageview.ShapeableImageView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ShapeableImageView f56264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final TextView f56265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f56267e;

    public b0(@n0 LinearLayout linearLayout, @n0 ShapeableImageView shapeableImageView, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3) {
        this.f56263a = linearLayout;
        this.f56264b = shapeableImageView;
        this.f56265c = textView;
        this.f56266d = textView2;
        this.f56267e = textView3;
    }

    @n0
    public static b0 a(@n0 View view) {
        int i10 = R.id.civ_avatar;
        ShapeableImageView shapeableImageView = (ShapeableImageView) j2.c.a(view, i10);
        if (shapeableImageView != null) {
            i10 = R.id.tv_author;
            TextView textView = (TextView) j2.c.a(view, i10);
            if (textView != null) {
                i10 = R.id.tv_content;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_time;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        return new b0((LinearLayout) view, shapeableImageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static b0 c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b0 d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_my_message, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56263a;
    }
}
