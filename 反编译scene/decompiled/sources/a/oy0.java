package a;

import android.database.Cursor;
import com.omarea.model.FpsWatchSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oy0 extends FpsWatchSession {
    public oy0(Cursor cursor) {
        this.sessionId = Long.valueOf(cursor.getLong(0));
        this.beginTime = Long.valueOf(cursor.getLong(1));
        this.packageName = cursor.getString(2);
        this.sessionDesc = cursor.getString(3);
        this.duration = cursor.getInt(4);
        this.avgFPS = cursor.getDouble(5);
        this.avgPower = cursor.getDouble(6);
        this.mode = cursor.getString(7);
        this.cloudId = cursor.getString(8);
    }
}
