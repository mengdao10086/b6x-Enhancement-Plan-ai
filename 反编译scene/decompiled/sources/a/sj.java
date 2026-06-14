package a;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class sj extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uj f7404a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sj(uj ujVar) {
        super(new Handler());
        this.f7404a = ujVar;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f7404a.i();
    }
}
