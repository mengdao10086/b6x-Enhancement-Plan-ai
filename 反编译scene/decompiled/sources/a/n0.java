package a;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n0 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f6856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController f1982a;

    public n0(q0 q0Var, AlertController alertController) {
        this.f6856a = q0Var;
        this.f1982a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6856a.f2518d.onClick(this.f1982a.f3959a, i);
        if (this.f6856a.f2521d) {
            return;
        }
        this.f1982a.f3959a.dismiss();
    }
}
