package a;

import android.database.Cursor;
import com.omarea.model.PowerStatSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xy0 extends PowerStatSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f7930a;

    public xy0(zy0 zy0Var, Cursor cursor) {
        this.f7930a = cursor;
        this.session = this.f7930a.getInt(0);
        this.beginTime = this.f7930a.getLong(1);
        this.endTime = this.f7930a.getLong(2);
        this.avgPower = this.f7930a.getDouble(3);
        this.used = this.f7930a.getInt(4);
    }
}
