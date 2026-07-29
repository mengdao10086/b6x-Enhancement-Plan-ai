package r8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.game.R;
import com.flydigi.game.widget.DownloadGameItemView;
import g.n0;
import g.p0;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final DownloadGameItemView f47802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final DownloadGameItemView f47803b;

    public j(@n0 DownloadGameItemView downloadGameItemView, @n0 DownloadGameItemView downloadGameItemView2) {
        this.f47802a = downloadGameItemView;
        this.f47803b = downloadGameItemView2;
    }

    @n0
    public static j a(@n0 View view) {
        Objects.requireNonNull(view, "rootView");
        DownloadGameItemView downloadGameItemView = (DownloadGameItemView) view;
        return new j(downloadGameItemView, downloadGameItemView);
    }

    @n0
    public static j c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static j d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.game_item_game_download, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DownloadGameItemView getRoot() {
        return this.f47802a;
    }
}
