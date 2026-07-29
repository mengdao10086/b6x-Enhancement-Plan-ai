package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.game.R;
import com.flydigi.game.widget.GameItemView;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final GameItemView f47800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final GameItemView f47801b;

    public i(@n0 GameItemView gameItemView, @n0 GameItemView gameItemView2) {
        this.f47800a = gameItemView;
        this.f47801b = gameItemView2;
    }

    @n0
    public static i a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        GameItemView gameItemView = (GameItemView) view;
        return new i(gameItemView, gameItemView);
    }

    @n0
    public static i c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static i d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_item_game, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public GameItemView getRoot() {
        return this.f47800a;
    }
}
