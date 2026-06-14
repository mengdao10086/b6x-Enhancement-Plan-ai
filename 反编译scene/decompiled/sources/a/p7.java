package a;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p7 extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t7 f7091a;

    public p7(t7 t7Var) {
        this.f7091a = t7Var;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        if (this.f7091a.a()) {
            this.f7091a.c();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f7091a.dismiss();
    }
}
