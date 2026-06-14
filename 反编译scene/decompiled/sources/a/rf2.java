package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rf2 extends CancellationException implements kd2<rf2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qf2 f7296a;

    public rf2(String str, Throwable th, qf2 qf2Var) {
        super(str);
        this.f7296a = qf2Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // a.kd2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public rf2 a() {
        if (!be2.c()) {
            return null;
        }
        String message = getMessage();
        f92.b(message);
        return new rf2(message, this, this.f7296a);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof rf2) {
                rf2 rf2Var = (rf2) obj;
                if (!f92.a(rf2Var.getMessage(), getMessage()) || !f92.a(rf2Var.f7296a, this.f7296a) || !f92.a(rf2Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (be2.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        f92.b(message);
        int iHashCode = ((message.hashCode() * 31) + this.f7296a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f7296a;
    }
}
