package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageButton f56269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f56270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Button f56271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final FrameLayout f56272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final EditText f56273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final Toolbar f56274g;

    public c(@n0 LinearLayout linearLayout, @n0 ImageButton imageButton, @n0 ImageView imageView, @n0 Button button, @n0 FrameLayout frameLayout, @n0 EditText editText, @n0 Toolbar toolbar) {
        this.f56268a = linearLayout;
        this.f56269b = imageButton;
        this.f56270c = imageView;
        this.f56271d = button;
        this.f56272e = frameLayout;
        this.f56273f = editText;
        this.f56274g = toolbar;
    }

    @n0
    public static c a(@n0 View view) {
        int i10 = R.id.btn_back;
        ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
        if (imageButton != null) {
            i10 = R.id.btn_clear;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.btn_search;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.container_fragment;
                    FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
                    if (frameLayout != null) {
                        i10 = R.id.et_search;
                        EditText editText = (EditText) j2.c.a(view, i10);
                        if (editText != null) {
                            i10 = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) j2.c.a(view, i10);
                            if (toolbar != null) {
                                return new c((LinearLayout) view, imageButton, imageView, button, frameLayout, editText, toolbar);
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
        View viewInflate = layoutInflater.inflate(R.layout.community_activity_community_search, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56268a;
    }
}
