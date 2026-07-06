package a;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tj extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uj f7507a;

    public tj(uj ujVar) {
        this.f7507a = ujVar;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        uj ujVar = this.f7507a;
        ujVar.b = true;
        ujVar.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        uj ujVar = this.f7507a;
        ujVar.b = false;
        ujVar.notifyDataSetInvalidated();
    }
}
