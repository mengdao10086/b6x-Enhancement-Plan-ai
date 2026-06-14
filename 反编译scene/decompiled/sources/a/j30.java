package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1498a;

    public j30(String str) {
        if (str != null && str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        this.f1498a = str;
    }

    public final int a() throws e30 {
        while (this.f6468a < this.f1498a.length()) {
            String str = this.f1498a;
            int i = this.f6468a;
            this.f6468a = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                if (cCharAt != '#') {
                    if (cCharAt != '/' || this.f6468a == this.f1498a.length()) {
                        return cCharAt;
                    }
                    char cCharAt2 = this.f1498a.charAt(this.f6468a);
                    if (cCharAt2 == '*') {
                        int i2 = this.f6468a + 1;
                        this.f6468a = i2;
                        int iIndexOf = this.f1498a.indexOf("*/", i2);
                        if (iIndexOf == -1) {
                            throw j("Unterminated comment");
                        }
                        this.f6468a = iIndexOf + 2;
                    } else {
                        if (cCharAt2 != '/') {
                            return cCharAt;
                        }
                        this.f6468a++;
                    }
                }
                i();
            }
        }
        return -1;
    }

    public String b(char c) throws e30 {
        int i = this.f6468a;
        StringBuilder sb = null;
        while (this.f6468a < this.f1498a.length()) {
            String str = this.f1498a;
            int i2 = this.f6468a;
            this.f6468a = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt == c) {
                String str2 = this.f1498a;
                if (sb == null) {
                    return str2.substring(i, this.f6468a - 1);
                }
                sb.append((CharSequence) str2, i, this.f6468a - 1);
                return sb.toString();
            }
            if (cCharAt == '\\') {
                if (this.f6468a == this.f1498a.length()) {
                    throw j("Unterminated escape sequence");
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.f1498a, i, this.f6468a - 1);
                sb.append(f());
                i = this.f6468a;
            }
        }
        throw j("Unterminated string");
    }

    public final String c(String str) {
        int i = this.f6468a;
        while (this.f6468a < this.f1498a.length()) {
            char cCharAt = this.f1498a.charAt(this.f6468a);
            if (cCharAt == '\r' || cCharAt == '\n' || str.indexOf(cCharAt) != -1) {
                return this.f1498a.substring(i, this.f6468a);
            }
            this.f6468a++;
        }
        return this.f1498a.substring(i);
    }

    public Object d() {
        int iA = a();
        if (iA == -1) {
            throw j("End of input");
        }
        if (iA == 34 || iA == 39) {
            return b((char) iA);
        }
        if (iA == 91) {
            return e();
        }
        if (iA == 123) {
            return h();
        }
        this.f6468a--;
        return g();
    }

    public final d30 e() throws e30 {
        d30 d30Var = new d30();
        boolean z = false;
        while (true) {
            int iA = a();
            if (iA == -1) {
                throw j("Unterminated array");
            }
            if (iA == 44 || iA == 59) {
                d30Var.k(null);
            } else {
                if (iA == 93) {
                    if (z) {
                        d30Var.k(null);
                    }
                    return d30Var;
                }
                this.f6468a--;
                d30Var.k(d());
                int iA2 = a();
                if (iA2 != 44 && iA2 != 59) {
                    if (iA2 == 93) {
                        return d30Var;
                    }
                    throw j("Unterminated array");
                }
            }
            z = true;
        }
    }

    public final char f() throws e30 {
        String str = this.f1498a;
        int i = this.f6468a;
        this.f6468a = i + 1;
        char cCharAt = str.charAt(i);
        if (cCharAt == 'b') {
            return '\b';
        }
        if (cCharAt == 'f') {
            return '\f';
        }
        if (cCharAt == 'n') {
            return '\n';
        }
        if (cCharAt == 'r') {
            return '\r';
        }
        if (cCharAt == 't') {
            return '\t';
        }
        if (cCharAt != 'u') {
            return cCharAt;
        }
        if (this.f6468a + 4 > this.f1498a.length()) {
            throw j("Unterminated escape sequence");
        }
        String str2 = this.f1498a;
        int i2 = this.f6468a;
        String strSubstring = str2.substring(i2, i2 + 4);
        this.f6468a += 4;
        try {
            return (char) Integer.parseInt(strSubstring, 16);
        } catch (NumberFormatException unused) {
            throw j("Invalid escape sequence: " + strSubstring);
        }
    }

    public final Object g() throws e30 {
        String strSubstring;
        int i;
        String strC = c("{}[]/\\:,=;# \t\f");
        if (strC.length() == 0) {
            throw j("Expected literal value");
        }
        if ("null".equalsIgnoreCase(strC)) {
            return g30.f959a;
        }
        if ("true".equalsIgnoreCase(strC)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(strC)) {
            return Boolean.FALSE;
        }
        if (strC.indexOf(46) == -1) {
            if (strC.startsWith("0x") || strC.startsWith("0X")) {
                strSubstring = strC.substring(2);
                i = 16;
            } else if (!strC.startsWith("0") || strC.length() <= 1) {
                i = 10;
                strSubstring = strC;
            } else {
                strSubstring = strC.substring(1);
                i = 8;
            }
            try {
                long j = Long.parseLong(strSubstring, i);
                return (j > 2147483647L || j < -2147483648L) ? Long.valueOf(j) : Integer.valueOf((int) j);
            } catch (NumberFormatException unused) {
            }
        }
        try {
            return Double.valueOf(strC);
        } catch (NumberFormatException unused2) {
            return strC;
        }
    }

    public final g30 h() throws e30 {
        g30 g30Var = new g30();
        int iA = a();
        if (iA == 125) {
            return g30Var;
        }
        if (iA != -1) {
            this.f6468a--;
        }
        while (true) {
            Object objD = d();
            if (!(objD instanceof String)) {
                if (objD == null) {
                    throw j("Names cannot be null");
                }
                throw j("Names must be strings, but " + objD + " is of type " + objD.getClass().getName());
            }
            int iA2 = a();
            if (iA2 != 58 && iA2 != 61) {
                throw j("Expected ':' after " + objD);
            }
            if (this.f6468a < this.f1498a.length() && this.f1498a.charAt(this.f6468a) == '>') {
                this.f6468a++;
            }
            g30Var.x((String) objD, d());
            int iA3 = a();
            if (iA3 != 44 && iA3 != 59) {
                if (iA3 == 125) {
                    return g30Var;
                }
                throw j("Unterminated object");
            }
        }
    }

    public final void i() {
        while (this.f6468a < this.f1498a.length()) {
            char cCharAt = this.f1498a.charAt(this.f6468a);
            if (cCharAt == '\r' || cCharAt == '\n') {
                this.f6468a++;
                return;
            }
            this.f6468a++;
        }
    }

    public e30 j(String str) {
        return new e30(str + this);
    }

    public String toString() {
        return " at character " + this.f6468a + " of " + this.f1498a;
    }
}
