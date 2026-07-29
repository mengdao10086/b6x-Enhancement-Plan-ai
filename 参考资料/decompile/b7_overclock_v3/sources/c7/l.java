package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.base.widget.MyListView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final MyListView f10178c;

    public l(@g.n0 RelativeLayout relativeLayout, @g.n0 TextView textView, @g.n0 MyListView myListView) {
        this.f10176a = relativeLayout;
        this.f10177b = textView;
        this.f10178c = myListView;
    }

    @g.n0
    public static l a(@g.n0 View view) {
        int i10 = R.id.config_notice;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.listview;
            MyListView myListView = (MyListView) j2.c.a(view, i10);
            if (myListView != null) {
                return new l((RelativeLayout) view, textView, myListView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static l c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static l d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_cjzc_config_manage, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10176a;
    }
}
