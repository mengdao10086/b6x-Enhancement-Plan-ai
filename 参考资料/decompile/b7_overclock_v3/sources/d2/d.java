package d2;

import android.database.sqlite.SQLiteProgram;
import c2.f;

/* JADX INFO: loaded from: classes2.dex */
public class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f25968a;

    public d(SQLiteProgram sQLiteProgram) {
        this.f25968a = sQLiteProgram;
    }

    @Override // c2.f
    public void D(int i10, String str) {
        this.f25968a.bindString(i10, str);
    }

    @Override // c2.f
    public void E0(int i10, byte[] bArr) {
        this.f25968a.bindBlob(i10, bArr);
    }

    @Override // c2.f
    public void M1() {
        this.f25968a.clearBindings();
    }

    @Override // c2.f
    public void R(int i10, double d10) {
        this.f25968a.bindDouble(i10, d10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25968a.close();
    }

    @Override // c2.f
    public void l1(int i10) {
        this.f25968a.bindNull(i10);
    }

    @Override // c2.f
    public void s0(int i10, long j10) {
        this.f25968a.bindLong(i10, j10);
    }
}
