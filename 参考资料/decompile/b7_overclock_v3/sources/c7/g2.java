package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class g2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final CardView f10049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final TextView f10051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10052d;

    public g2(@g.n0 CardView cardView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f10049a = cardView;
        this.f10050b = textView;
        this.f10051c = textView2;
        this.f10052d = textView3;
    }

    @g.n0
    public static g2 a(@g.n0 View view) {
        int i10 = R.id.tv_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.tv_content;
            TextView textView2 = (TextView) j2.c.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.tv_title;
                TextView textView3 = (TextView) j2.c.a(view, i10);
                if (textView3 != null) {
                    return new g2((CardView) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static g2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static g2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_item_my_game_zone_header_notice, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.f10049a;
    }
}
