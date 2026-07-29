package d2;

import android.database.sqlite.SQLiteStatement;
import c2.i;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f25969b;

    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f25969b = sQLiteStatement;
    }

    @Override // c2.i
    public String I0() {
        return this.f25969b.simpleQueryForString();
    }

    @Override // c2.i
    public void X() {
        this.f25969b.execute();
    }

    @Override // c2.i
    public long Y() {
        return this.f25969b.simpleQueryForLong();
    }

    @Override // c2.i
    public long Z1() {
        return this.f25969b.executeInsert();
    }

    @Override // c2.i
    public int a0() {
        return this.f25969b.executeUpdateDelete();
    }
}
