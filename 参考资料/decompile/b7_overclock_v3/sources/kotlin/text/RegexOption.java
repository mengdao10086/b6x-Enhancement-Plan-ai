package kotlin.text;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'IGNORE_CASE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
public final class RegexOption implements g {
    private static final /* synthetic */ RegexOption[] $VALUES = $values();
    public static final RegexOption CANON_EQ;
    public static final RegexOption COMMENTS;
    public static final RegexOption DOT_MATCHES_ALL;
    public static final RegexOption IGNORE_CASE;
    public static final RegexOption LITERAL;
    public static final RegexOption MULTILINE;
    public static final RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        int i10 = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, i10, 0, 2, null);
        int i11 = 0;
        int i12 = 2;
        kotlin.jvm.internal.u uVar = null;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, i11, i12, uVar);
        int i13 = 0;
        int i14 = 2;
        kotlin.jvm.internal.u uVar2 = null;
        LITERAL = new RegexOption("LITERAL", i10, 16, i13, i14, uVar2);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, i11, i12, uVar);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, i13, i14, uVar2);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, i11, i12, uVar);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, i13, i14, uVar2);
    }

    private RegexOption(String str, int i10, int i11, int i12) {
        this.value = i11;
        this.mask = i12;
    }

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    @Override // kotlin.text.g
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.g
    public int getValue() {
        return this.value;
    }

    public /* synthetic */ RegexOption(String str, int i10, int i11, int i12, int i13, kotlin.jvm.internal.u uVar) {
        this(str, i10, i11, (i13 & 2) != 0 ? i11 : i12);
    }
}
