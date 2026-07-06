package a;

import android.database.Cursor;
import com.omarea.model.ChargeStatRecord;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class kx0 extends ChargeStatRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6651a;

    public kx0(qx0 qx0Var, Cursor cursor) {
        this.f6651a = cursor;
        this.capacity = this.f6651a.getInt(0);
        this.current = this.f6651a.getLong(1);
        this.time = this.f6651a.getLong(2);
    }
}
