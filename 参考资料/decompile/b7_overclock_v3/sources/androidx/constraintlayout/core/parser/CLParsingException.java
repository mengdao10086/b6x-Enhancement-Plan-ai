package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes2.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String str, c cVar) {
        this.mReason = str;
        if (cVar != null) {
            this.mElementClass = cVar.m();
            this.mLineNumber = cVar.j();
        } else {
            this.mElementClass = "unknown";
            this.mLineNumber = 0;
        }
    }

    public String a() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ee.a.f26979d;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + a();
    }
}
