package a;

import android.view.View;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h0 implements NestedScrollView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6257a;
    public final /* synthetic */ View b;

    public h0(AlertController alertController, View view, View view2) {
        this.f6257a = view;
        this.b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.b
    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.f(nestedScrollView, this.f6257a, this.b);
    }
}
