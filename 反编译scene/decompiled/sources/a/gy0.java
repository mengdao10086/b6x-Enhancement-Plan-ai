package a;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gy0 extends g92 implements v72<SQLiteDatabase> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ py0 f6252a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy0(py0 py0Var) {
        super(0);
        this.f6252a = py0Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SQLiteDatabase i() {
        return this.f6252a.getWritableDatabase();
    }
}
