package a;

import android.database.Cursor;
import com.omarea.model.ChargeStatTime;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nx0 extends ChargeStatTime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6956a;

    public nx0(qx0 qx0Var, Cursor cursor) {
        this.f6956a = cursor;
        this.capacity = this.f6956a.getInt(0);
        long j = this.f6956a.getLong(1);
        this.startTime = j;
        this.endTime = j;
    }
}
