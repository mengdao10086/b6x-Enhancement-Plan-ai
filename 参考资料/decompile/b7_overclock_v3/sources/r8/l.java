package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.flydigi.game.R;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ImageView f47807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f47808b;

    public l(@n0 ImageView imageView, @n0 ImageView imageView2) {
        this.f47807a = imageView;
        this.f47808b = imageView2;
    }

    @n0
    public static l a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        ImageView imageView = (ImageView) view;
        return new l(imageView, imageView);
    }

    @n0
    public static l c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static l d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_item_game_poster, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ImageView getRoot() {
        return this.f47807a;
    }
}
