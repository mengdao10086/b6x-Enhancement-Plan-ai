package a;

import android.database.Cursor;
import com.omarea.model.ActivityCacheInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hx0 extends ActivityCacheInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6351a;

    public hx0(ix0 ix0Var, Cursor cursor) {
        this.f6351a = cursor;
        this.name = this.f6351a.getString(0);
        this.packageName = this.f6351a.getString(1);
        this.exported = this.f6351a.getInt(2) == 1;
        this.enabled = this.f6351a.getInt(3) == 1;
    }
}
