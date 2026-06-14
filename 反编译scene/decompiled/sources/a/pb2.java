package a;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF51' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:343)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pb2 f7102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final /* synthetic */ pb2[] f2410a;
    public static final pb2 b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2411a;

    /* JADX INFO: Fake field, exist only in values array */
    pb2 EF51;

    static {
        pb2 pb2Var = new pb2("IGNORE_CASE", 0, 2, 0, 2, null);
        f7102a = pb2Var;
        pb2 pb2Var2 = new pb2("MULTILINE", 1, 8, 0, 2, null);
        b = pb2Var2;
        int i = 0;
        int i2 = 2;
        b92 b92Var = null;
        f2410a = new pb2[]{pb2Var, pb2Var2, new pb2("LITERAL", 2, 16, i, i2, b92Var), new pb2("UNIX_LINES", 3, 1, i, i2, b92Var), new pb2("COMMENTS", 4, 4, i, i2, b92Var), new pb2("DOT_MATCHES_ALL", 5, 32, i, i2, b92Var), new pb2("CANON_EQ", 6, 128, i, i2, b92Var)};
    }

    public pb2(String str, int i, int i2, int i3) {
        this.f2411a = i2;
    }

    public /* synthetic */ pb2(String str, int i, int i2, int i3, int i4, b92 b92Var) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }

    public static pb2 valueOf(String str) {
        return (pb2) Enum.valueOf(pb2.class, str);
    }

    public static pb2[] values() {
        return (pb2[]) f2410a.clone();
    }

    public int a() {
        return this.f2411a;
    }
}
