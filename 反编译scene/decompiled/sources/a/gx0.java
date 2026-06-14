package a;

import android.database.Cursor;
import com.omarea.model.ActivityCacheInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gx0 extends ActivityCacheInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6251a;

    public gx0(ix0 ix0Var, Cursor cursor) {
        this.f6251a = cursor;
        this.name = this.f6251a.getString(0);
        this.packageName = this.f6251a.getString(1);
        this.exported = this.f6251a.getInt(2) == 1;
        this.enabled = this.f6251a.getInt(3) == 1;
    }
}
