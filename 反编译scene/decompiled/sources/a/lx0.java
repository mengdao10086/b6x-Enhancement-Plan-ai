package a;

import android.database.Cursor;
import com.omarea.model.ChargeStatRecord;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lx0 extends ChargeStatRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cursor f6744a;

    public lx0(qx0 qx0Var, Cursor cursor) {
        this.f6744a = cursor;
        this.capacity = this.f6744a.getInt(0);
        this.power = this.f6744a.getDouble(1);
        this.time = this.f6744a.getLong(2);
    }
}
