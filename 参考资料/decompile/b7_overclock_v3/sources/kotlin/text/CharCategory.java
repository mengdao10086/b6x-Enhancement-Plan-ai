package kotlin.text;

/* JADX INFO: loaded from: classes5.dex */
public enum CharCategory {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");


    @yt.k
    public static final a Companion = new a(null);

    @yt.k
    private final String code;
    private final int value;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final CharCategory a(int i10) {
            if (new qk.m(0, 16).p(i10)) {
                return CharCategory.values()[i10];
            }
            if (new qk.m(18, 30).p(i10)) {
                return CharCategory.values()[i10 - 1];
            }
            throw new IllegalArgumentException("Category #" + i10 + " is not defined.");
        }
    }

    CharCategory(int i10, String str) {
        this.value = i10;
        this.code = str;
    }

    public final boolean contains(char c10) {
        return Character.getType(c10) == this.value;
    }

    @yt.k
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
