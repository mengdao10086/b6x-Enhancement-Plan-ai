package a;

import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f6752a;

    public m(o oVar) {
        this.f6752a = oVar;
    }

    @Override // a.k
    public void e(int i, Bundle bundle) {
        o oVar = this.f6752a;
        Handler handler = oVar.f2180a;
        if (handler != null) {
            handler.post(new n(oVar, i, bundle));
        } else {
            oVar.q(i, bundle);
        }
    }
}
