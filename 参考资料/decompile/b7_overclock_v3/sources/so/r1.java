package so;

/* JADX INFO: loaded from: classes5.dex */
public class r1 extends v1 {
    public r1() {
        super(3);
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        return obj instanceof t1;
    }

    @Override // so.v1, org.bouncycastle.util.q
    public Object clone() {
        return new r1();
    }

    public boolean equals(Object obj) {
        return obj instanceof r1;
    }

    public int hashCode() {
        return 3;
    }
}
