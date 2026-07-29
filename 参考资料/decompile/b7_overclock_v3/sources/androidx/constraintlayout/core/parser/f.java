package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class f extends b implements Iterable<d> {

    public class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f3063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3064b = 0;

        public a(f fVar) {
            this.f3063a = fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3064b < this.f3063a.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            d dVar = (d) this.f3063a.f3053h.get(this.f3064b);
            this.f3064b++;
            return dVar;
        }
    }

    public f(char[] cArr) {
        super(cArr);
    }

    public static f Z(char[] cArr) {
        return new f(cArr);
    }

    public String a0() {
        return v(0, 0);
    }

    @Override // java.lang.Iterable
    public Iterator<d> iterator() {
        return new a(this);
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(e());
        sb2.append("{\n");
        boolean z10 = true;
        for (c cVar : this.f3053h) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(",\n");
            }
            sb2.append(cVar.v(c.f3055g + i10, i11 - 1));
        }
        sb2.append("\n");
        a(sb2, i10);
        sb2.append(zc.a.f58317e);
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        StringBuilder sb2 = new StringBuilder(e() + "{ ");
        boolean z10 = true;
        for (c cVar : this.f3053h) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(cVar.w());
        }
        sb2.append(" }");
        return sb2.toString();
    }
}
