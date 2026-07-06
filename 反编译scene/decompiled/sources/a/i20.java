package a;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i20 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j20 f6369a;

    public i20(j20 j20Var) {
        this.f6369a = j20Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j20 j20Var = this.f6369a;
        this.f6369a.e(i < 0 ? j20Var.f6465a.v() : j20Var.getAdapter().getItem(i));
        AdapterView.OnItemClickListener onItemClickListener = this.f6369a.getOnItemClickListener();
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = this.f6369a.f6465a.y();
                i = this.f6369a.f6465a.x();
                j = this.f6369a.f6465a.w();
            }
            onItemClickListener.onItemClick(this.f6369a.f6465a.e(), view, i, j);
        }
        this.f6369a.f6465a.dismiss();
    }
}
