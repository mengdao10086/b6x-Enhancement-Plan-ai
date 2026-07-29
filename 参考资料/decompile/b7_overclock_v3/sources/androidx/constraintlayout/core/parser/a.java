package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    public a(char[] cArr) {
        super(cArr);
    }

    public static c y(char[] cArr) {
        return new a(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        String strW = w();
        if (i11 > 0 || strW.length() + i10 >= c.f3054f) {
            sb2.append("[\n");
            boolean z10 = true;
            for (c cVar : this.f3053h) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(",\n");
                }
                a(sb2, c.f3055g + i10);
                sb2.append(cVar.v(c.f3055g + i10, i11 - 1));
            }
            sb2.append("\n");
            a(sb2, i10);
            sb2.append("]");
        } else {
            sb2.append(strW);
        }
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        StringBuilder sb2 = new StringBuilder(e() + "[");
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f3053h.size(); i10++) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(this.f3053h.get(i10).w());
        }
        return ((Object) sb2) + "]";
    }
}
