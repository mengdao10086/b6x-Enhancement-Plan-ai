package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.game.R;
import com.flydigi.game.widget.SearchRecoView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f47793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageButton f47794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f47795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Button f47796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final EditText f47797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final RecyclerView f47798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final SearchRecoView f47799g;

    public h(@n0 LinearLayout linearLayout, @n0 ImageButton imageButton, @n0 ImageView imageView, @n0 Button button, @n0 EditText editText, @n0 RecyclerView recyclerView, @n0 SearchRecoView searchRecoView) {
        this.f47793a = linearLayout;
        this.f47794b = imageButton;
        this.f47795c = imageView;
        this.f47796d = button;
        this.f47797e = editText;
        this.f47798f = recyclerView;
        this.f47799g = searchRecoView;
    }

    @n0
    public static h a(@n0 View view) {
        int i10 = R.id.btn_back;
        ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
        if (imageButton != null) {
            i10 = R.id.btn_clear;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.btn_search;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.et_search;
                    EditText editText = (EditText) j2.c.a(view, i10);
                    if (editText != null) {
                        i10 = R.id.rv_content;
                        RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                        if (recyclerView != null) {
                            i10 = R.id.search_reco_view;
                            SearchRecoView searchRecoView = (SearchRecoView) j2.c.a(view, i10);
                            if (searchRecoView != null) {
                                return new h((LinearLayout) view, imageButton, imageView, button, editText, recyclerView, searchRecoView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static h c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static h d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_fragment_search, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f47793a;
    }
}
