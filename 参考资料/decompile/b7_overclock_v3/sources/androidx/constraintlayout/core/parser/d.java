package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.motion.widget.i;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ArrayList<String> f3061i;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f3061i = arrayList;
        arrayList.add("ConstraintSets");
        f3061i.add("Variables");
        f3061i.add("Generate");
        f3061i.add("Transitions");
        f3061i.add(i.f3726f);
        f3061i.add("KeyAttributes");
        f3061i.add("KeyPositions");
        f3061i.add("KeyCycles");
    }

    public d(char[] cArr) {
        super(cArr);
    }

    public static c Z(String str, c cVar) {
        d dVar = new d(str.toCharArray());
        dVar.u(0L);
        dVar.s(str.length() - 1);
        dVar.c0(cVar);
        return dVar;
    }

    public static c y(char[] cArr) {
        return new d(cArr);
    }

    public String a0() {
        return b();
    }

    public c b0() {
        if (this.f3053h.size() > 0) {
            return this.f3053h.get(0);
        }
        return null;
    }

    public void c0(c cVar) {
        if (this.f3053h.size() > 0) {
            this.f3053h.set(0, cVar);
        } else {
            this.f3053h.add(cVar);
        }
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(e());
        a(sb2, i10);
        String strB = b();
        if (this.f3053h.size() <= 0) {
            return strB + ": <> ";
        }
        sb2.append(strB);
        sb2.append(": ");
        if (f3061i.contains(strB)) {
            i11 = 3;
        }
        if (i11 > 0) {
            sb2.append(this.f3053h.get(0).v(i10, i11 - 1));
        } else {
            String strW = this.f3053h.get(0).w();
            if (strW.length() + i10 < c.f3054f) {
                sb2.append(strW);
            } else {
                sb2.append(this.f3053h.get(0).v(i10, i11 - 1));
            }
        }
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        if (this.f3053h.size() <= 0) {
            return e() + b() + ": <> ";
        }
        return e() + b() + ": " + this.f3053h.get(0).w();
    }
}
