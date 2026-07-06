package a;

import android.database.Cursor;
import com.omarea.model.PowerStatRecord;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wy0 extends PowerStatRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f7834a;

    public wy0(zy0 zy0Var, Cursor cursor) {
        this.f7834a = cursor;
        boolean z = false;
        long j = this.f7834a.getLong(0);
        this.startTime = j;
        this.endTime = j;
        this.capacity = this.f7834a.getInt(1);
        this.screenOn = this.f7834a.getInt(2) == 1;
        int i = this.f7834a.getInt(3);
        if (i != 3 && i != 4) {
            z = true;
        }
        this.charging = z;
        this.packageName = this.f7834a.getString(4);
    }
}
