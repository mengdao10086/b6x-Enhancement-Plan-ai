package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class rb2 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    public static final <T> void a(Appendable appendable, T t, g82<? super T, ? extends CharSequence> g82Var) {
        CharSequence charSequenceValueOf;
        f92.d(appendable, "$this$appendElement");
        if (g82Var == null) {
            if (!(t != 0 ? t instanceof CharSequence : true)) {
                if (t instanceof Character) {
                    appendable.append(((Character) t).charValue());
                    return;
                }
                charSequenceValueOf = String.valueOf((Object) t);
            }
            appendable.append(charSequenceValueOf);
        }
        t = (T) g82Var.f(t);
        charSequenceValueOf = (CharSequence) t;
        appendable.append(charSequenceValueOf);
    }
}
