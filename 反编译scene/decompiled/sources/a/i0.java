package a;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController f1298a;
    public final /* synthetic */ View b;

    public i0(AlertController alertController, View view, View view2) {
        this.f1298a = alertController;
        this.f6360a = view;
        this.b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.f(this.f1298a.f3972a, this.f6360a, this.b);
    }
}
