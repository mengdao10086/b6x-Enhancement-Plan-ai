package a;

import android.database.Cursor;
import com.omarea.model.ChargeStatRecord;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mx0 extends ChargeStatRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6850a;

    public mx0(qx0 qx0Var, Cursor cursor) {
        this.f6850a = cursor;
        this.capacity = this.f6850a.getInt(0);
        this.temperature = this.f6850a.getLong(1);
        this.time = this.f6850a.getLong(2);
    }
}
