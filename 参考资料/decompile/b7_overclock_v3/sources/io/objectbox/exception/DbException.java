package io.objectbox.exception;

/* JADX INFO: loaded from: classes5.dex */
public class DbException extends RuntimeException {
    private final int errorCode;

    public DbException(String str) {
        super(str);
        this.errorCode = 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.errorCode == 0) {
            return super.toString();
        }
        return super.toString() + " (error code " + this.errorCode + ee.a.f26979d;
    }

    public DbException(String str, Throwable th2) {
        super(str, th2);
        this.errorCode = 0;
    }

    public DbException(String str, int i10) {
        super(str);
        this.errorCode = i10;
    }
}
