package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes2.dex */
public class g extends c {
    public g(char[] cArr) {
        super(cArr);
    }

    public static c x(char[] cArr) {
        return new g(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, i10);
        sb2.append("'");
        sb2.append(b());
        sb2.append("'");
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        return "'" + b() + "'";
    }
}
