package a;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o0 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f6964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController.RecycleListView f2181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AlertController f2182a;

    public o0(q0 q0Var, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f6964a = q0Var;
        this.f2181a = recycleListView;
        this.f2182a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.f6964a.f2507a;
        if (zArr != null) {
            zArr[i] = this.f2181a.isItemChecked(i);
        }
        this.f6964a.f2496a.onClick(this.f2182a.f3959a, i, this.f2181a.isItemChecked(i));
    }
}
