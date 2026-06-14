package a;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class th0 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uh0 f7501a;

    public th0(uh0 uh0Var) {
        this.f7501a = uh0Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        vh0 vh0Var = this.f7501a.f7597a;
        l92 l92Var = vh0Var.f7696a;
        if (i != l92Var.f6687a) {
            l92Var.f6687a = i;
            vh0Var.f3281a.a(Integer.valueOf(i));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        vh0 vh0Var = this.f7501a.f7597a;
        l92 l92Var = vh0Var.f7696a;
        if (-1 != l92Var.f6687a) {
            l92Var.f6687a = -1;
            vh0Var.f3281a.a(-1);
        }
    }
}
