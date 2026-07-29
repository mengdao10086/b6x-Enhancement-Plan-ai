package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.base.widget.MyListView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class s implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final ListView f54434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final MyListView f54435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f54436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final ScrollView f54437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f54439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f54440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f54441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.n0
    public final TextView f54442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final TextView f54443k;

    public s(@g.n0 ConstraintLayout constraintLayout, @g.n0 ListView listView, @g.n0 MyListView myListView, @g.n0 ConstraintLayout constraintLayout2, @g.n0 ScrollView scrollView, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3, @g.n0 TextView textView4, @g.n0 TextView textView5, @g.n0 TextView textView6) {
        this.f54433a = constraintLayout;
        this.f54434b = listView;
        this.f54435c = myListView;
        this.f54436d = constraintLayout2;
        this.f54437e = scrollView;
        this.f54438f = textView;
        this.f54439g = textView2;
        this.f54440h = textView3;
        this.f54441i = textView4;
        this.f54442j = textView5;
        this.f54443k = textView6;
    }

    @g.n0
    public static s a(@g.n0 View view) {
        int i10 = R.id.listview_1;
        ListView listView = (ListView) j2.c.a(view, i10);
        if (listView != null) {
            i10 = R.id.listview_2;
            MyListView myListView = (MyListView) j2.c.a(view, i10);
            if (myListView != null) {
                i10 = R.id.rl_top;
                ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.scrollview_list;
                    ScrollView scrollView = (ScrollView) j2.c.a(view, i10);
                    if (scrollView != null) {
                        i10 = R.id.tv_cancel;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_config_null_1;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_desc;
                                TextView textView3 = (TextView) j2.c.a(view, i10);
                                if (textView3 != null) {
                                    i10 = R.id.tv_ok;
                                    TextView textView4 = (TextView) j2.c.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = R.id.tv_recommend_title;
                                        TextView textView5 = (TextView) j2.c.a(view, i10);
                                        if (textView5 != null) {
                                            i10 = R.id.tv_title;
                                            TextView textView6 = (TextView) j2.c.a(view, i10);
                                            if (textView6 != null) {
                                                return new s((ConstraintLayout) view, listView, myListView, constraintLayout, scrollView, textView, textView2, textView3, textView4, textView5, textView6);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static s c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static s d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_layout_import_macro, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f54433a;
    }
}
