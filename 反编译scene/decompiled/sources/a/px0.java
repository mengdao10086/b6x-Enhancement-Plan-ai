package a;

import android.database.Cursor;
import com.omarea.model.ChargeStatSession;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class px0 extends ChargeStatSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Cursor f2458a;

    public px0(qx0 qx0Var, int i, Cursor cursor) {
        this.f7157a = i;
        this.f2458a = cursor;
        this.session = this.f7157a;
        this.beginTime = this.f2458a.getLong(0);
        this.endTime = this.f2458a.getLong(1);
        this.capacityWh = ((double) ((int) (this.f2458a.getDouble(2) / 10.0d))) / 100.0d;
    }
}
