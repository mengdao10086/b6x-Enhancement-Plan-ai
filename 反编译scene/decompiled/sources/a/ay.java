package a;

import android.graphics.Typeface;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ay extends sy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cy f5652a;

    public ay(cy cyVar) {
        this.f5652a = cyVar;
    }

    @Override // a.sy
    public void a(int i) {
        this.f5652a.f451a = true;
        by byVar = (by) this.f5652a.f450a.get();
        if (byVar != null) {
            byVar.a();
        }
    }

    @Override // a.sy
    public void b(Typeface typeface, boolean z) {
        if (z) {
            return;
        }
        this.f5652a.f451a = true;
        by byVar = (by) this.f5652a.f450a.get();
        if (byVar != null) {
            byVar.a();
        }
    }
}
