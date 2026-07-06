package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class td2 extends x52 implements pg2<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sd2 f7491a = new sd2(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f3014a;

    public td2(long j) {
        super(f7491a);
        this.f3014a = j;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof td2) && this.f3014a == ((td2) obj).f3014a;
        }
        return true;
    }

    @Override // a.x52, a.l62
    public <R> R fold(R r, k82<? super R, ? super i62, ? extends R> k82Var) {
        return (R) og2.a(this, r, k82Var);
    }

    @Override // a.x52, a.i62, a.l62
    public <E extends i62> E get(j62<E> j62Var) {
        return (E) og2.b(this, j62Var);
    }

    public int hashCode() {
        long j = this.f3014a;
        return (int) (j ^ (j >>> 32));
    }

    public final long l() {
        return this.f3014a;
    }

    @Override // a.x52, a.l62
    public l62 minusKey(j62<?> j62Var) {
        return og2.c(this, j62Var);
    }

    @Override // a.pg2
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void h(l62 l62Var, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // a.pg2
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public String b(l62 l62Var) {
        vd2 vd2Var = (vd2) l62Var.get(vd2.f7684a);
        if (vd2Var != null) {
            vd2Var.l();
            throw null;
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iS = ec2.S(name, " @", 0, false, 6, null);
        if (iS < 0) {
            iS = name.length();
        }
        StringBuilder sb = new StringBuilder("coroutine".length() + iS + 10);
        if (name == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = name.substring(0, iS);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append("coroutine");
        sb.append('#');
        sb.append(this.f3014a);
        m42 m42Var = m42.f6769a;
        String string = sb.toString();
        f92.c(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name;
    }

    @Override // a.x52, a.l62
    public l62 plus(l62 l62Var) {
        return og2.d(this, l62Var);
    }

    public String toString() {
        return "CoroutineId(" + this.f3014a + ')';
    }
}
