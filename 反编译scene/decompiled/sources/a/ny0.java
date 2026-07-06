package a;

import android.database.Cursor;
import com.omarea.model.FpsWatchSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ny0 extends FpsWatchSession {
    public ny0(Cursor cursor) {
        this.sessionId = Long.valueOf(cursor.getLong(0));
        this.cloudId = cursor.getString(1);
        this.beginTime = Long.valueOf(cursor.getLong(2));
        this.appName = cursor.getString(3);
        this.packageName = cursor.getString(4);
        this.packageVersion = cursor.getString(5);
        this.viewSize = cursor.getString(6);
        this.sessionDesc = cursor.getString(7);
    }
}
