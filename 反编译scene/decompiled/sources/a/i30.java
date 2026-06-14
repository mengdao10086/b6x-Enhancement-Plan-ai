package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f1307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<h30> f1308a;

    public i30() {
        this.f1307a = new StringBuilder();
        this.f1308a = new ArrayList();
        this.f6371a = null;
    }

    public i30(int i) {
        this.f1307a = new StringBuilder();
        this.f1308a = new ArrayList();
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        this.f6371a = new String(cArr);
    }

    public i30 a() {
        j(h30.EMPTY_ARRAY, "[");
        return this;
    }

    public final void b() throws e30 {
        h30 h30VarK = k();
        if (h30VarK == h30.NONEMPTY_OBJECT) {
            this.f1307a.append(',');
        } else if (h30VarK != h30.EMPTY_OBJECT) {
            throw new e30("Nesting problem");
        }
        h();
        l(h30.DANGLING_KEY);
    }

    public final void c() throws e30 {
        if (this.f1308a.isEmpty()) {
            return;
        }
        h30 h30VarK = k();
        if (h30VarK == h30.EMPTY_ARRAY) {
            l(h30.NONEMPTY_ARRAY);
        } else {
            if (h30VarK != h30.NONEMPTY_ARRAY) {
                if (h30VarK == h30.DANGLING_KEY) {
                    this.f1307a.append(this.f6371a == null ? ":" : ": ");
                    l(h30.NONEMPTY_OBJECT);
                    return;
                } else {
                    if (h30VarK != h30.NULL) {
                        throw new e30("Nesting problem");
                    }
                    return;
                }
            }
            this.f1307a.append(',');
        }
        h();
    }

    public i30 d(h30 h30Var, h30 h30Var2, String str) throws e30 {
        h30 h30VarK = k();
        if (h30VarK != h30Var2 && h30VarK != h30Var) {
            throw new e30("Nesting problem");
        }
        this.f1308a.remove(r3.size() - 1);
        if (h30VarK == h30Var2) {
            h();
        }
        this.f1307a.append(str);
        return this;
    }

    public i30 e() {
        d(h30.EMPTY_ARRAY, h30.NONEMPTY_ARRAY, "]");
        return this;
    }

    public i30 f() {
        d(h30.EMPTY_OBJECT, h30.NONEMPTY_OBJECT, "}");
        return this;
    }

    public i30 g(String str) {
        if (str == null) {
            throw new e30("Names must be non-null");
        }
        b();
        m(str);
        return this;
    }

    public final void h() {
        if (this.f6371a == null) {
            return;
        }
        this.f1307a.append("\n");
        for (int i = 0; i < this.f1308a.size(); i++) {
            this.f1307a.append(this.f6371a);
        }
    }

    public i30 i() {
        j(h30.EMPTY_OBJECT, "{");
        return this;
    }

    public i30 j(h30 h30Var, String str) throws e30 {
        if (this.f1308a.isEmpty() && this.f1307a.length() > 0) {
            throw new e30("Nesting problem: multiple top-level roots");
        }
        c();
        this.f1308a.add(h30Var);
        this.f1307a.append(str);
        return this;
    }

    public final h30 k() throws e30 {
        if (this.f1308a.isEmpty()) {
            throw new e30("Nesting problem");
        }
        return this.f1308a.get(r0.size() - 1);
    }

    public final void l(h30 h30Var) {
        this.f1308a.set(r0.size() - 1, h30Var);
    }

    public final void m(String str) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        this.f1307a.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb = this.f1307a;
                str2 = "\\f";
            } else if (cCharAt != '\r') {
                if (cCharAt == '\"' || cCharAt == '\\') {
                    sb2 = this.f1307a;
                    sb2.append('\\');
                } else {
                    switch (cCharAt) {
                        case '\b':
                            sb = this.f1307a;
                            str2 = "\\b";
                            break;
                        case '\t':
                            sb = this.f1307a;
                            str2 = "\\t";
                            break;
                        case '\n':
                            sb = this.f1307a;
                            str2 = "\\n";
                            break;
                        default:
                            if (cCharAt <= 31) {
                                this.f1307a.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            } else {
                                sb2 = this.f1307a;
                            }
                            break;
                    }
                }
                sb2.append(cCharAt);
            } else {
                sb = this.f1307a;
                str2 = "\\r";
            }
            sb.append(str2);
        }
        this.f1307a.append("\"");
    }

    public i30 n(Object obj) {
        if (this.f1308a.isEmpty()) {
            throw new e30("Nesting problem");
        }
        if (obj instanceof d30) {
            ((d30) obj).l(this);
            return this;
        }
        if (obj instanceof g30) {
            ((g30) obj).C(this);
            return this;
        }
        c();
        if (obj == null || (obj instanceof Boolean) || obj == g30.f959a) {
            this.f1307a.append(obj);
        } else if (obj instanceof Number) {
            this.f1307a.append(g30.l((Number) obj));
        } else {
            m(obj.toString());
        }
        return this;
    }

    public String toString() {
        if (this.f1307a.length() == 0) {
            return null;
        }
        return this.f1307a.toString();
    }
}
