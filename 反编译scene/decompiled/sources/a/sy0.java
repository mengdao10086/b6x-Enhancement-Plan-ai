package a;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sy0 extends g92 implements v72<SQLiteDatabase> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ty0 f7443a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy0(ty0 ty0Var) {
        super(0);
        this.f7443a = ty0Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SQLiteDatabase i() {
        return this.f7443a.getWritableDatabase();
    }
}
