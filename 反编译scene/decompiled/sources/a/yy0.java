package a;

import android.database.Cursor;
import com.omarea.model.PowerStatSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yy0 extends PowerStatSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f8018a;

    public yy0(zy0 zy0Var, Cursor cursor) {
        this.f8018a = cursor;
        this.session = this.f8018a.getInt(0);
        this.beginTime = this.f8018a.getLong(1);
        this.endTime = this.f8018a.getLong(2);
        this.avgPower = this.f8018a.getDouble(3);
        this.used = this.f8018a.getInt(4);
    }
}
