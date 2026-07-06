package a;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l6 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o6 f6677a;

    public l6(o6 o6Var, s6 s6Var) {
        this.f6677a = o6Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6677a.f6986a.setSelection(i);
        if (this.f6677a.f6986a.getOnItemClickListener() != null) {
            o6 o6Var = this.f6677a;
            o6Var.f6986a.performItemClick(view, i, o6Var.b.getItemId(i));
        }
        this.f6677a.dismiss();
    }
}
