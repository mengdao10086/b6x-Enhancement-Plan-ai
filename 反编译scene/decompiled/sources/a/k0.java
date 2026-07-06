package a;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController f1587a;
    public final /* synthetic */ View b;

    public k0(AlertController alertController, View view, View view2) {
        this.f1587a = alertController;
        this.f6558a = view;
        this.b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.f(this.f1587a.f3970a, this.f6558a, this.b);
    }
}
