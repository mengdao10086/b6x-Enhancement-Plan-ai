package a;

import android.database.Cursor;
import com.omarea.model.ChargeStatSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ox0 extends ChargeStatSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f7063a;

    public ox0(qx0 qx0Var, Cursor cursor) {
        this.f7063a = cursor;
        this.session = this.f7063a.getInt(0);
        this.beginTime = this.f7063a.getLong(1);
        this.endTime = this.f7063a.getLong(2);
        int i = this.f7063a.getInt(3);
        int i2 = this.f7063a.getInt(4);
        if (i2 <= 0 || i <= 0) {
            return;
        }
        this.capacityRatio = i2 - i;
    }
}
