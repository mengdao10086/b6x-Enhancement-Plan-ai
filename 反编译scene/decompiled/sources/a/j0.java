package a;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j0 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6458a;
    public final /* synthetic */ View b;

    public j0(AlertController alertController, View view, View view2) {
        this.f6458a = view;
        this.b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.f(absListView, this.f6458a, this.b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
