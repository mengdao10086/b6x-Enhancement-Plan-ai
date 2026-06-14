package a;

import android.database.Cursor;
import com.omarea.model.ActivityCacheInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ex0 extends ActivityCacheInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6050a;

    public ex0(ix0 ix0Var, Cursor cursor) {
        this.f6050a = cursor;
        this.name = this.f6050a.getString(0);
        this.packageName = this.f6050a.getString(1);
        this.exported = this.f6050a.getInt(2) == 1;
        this.enabled = this.f6050a.getInt(3) == 1;
        this.label = this.f6050a.getString(4);
    }
}
