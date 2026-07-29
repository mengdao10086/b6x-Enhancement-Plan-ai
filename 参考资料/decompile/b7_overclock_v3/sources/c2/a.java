package c2;

import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final Object[] f9697b;

    public a(String str, @p0 Object[] objArr) {
        this.f9696a = str;
        this.f9697b = objArr;
    }

    public static void b(f fVar, int i10, Object obj) {
        if (obj == null) {
            fVar.l1(i10);
            return;
        }
        if (obj instanceof byte[]) {
            fVar.E0(i10, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            fVar.R(i10, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            fVar.R(i10, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            fVar.s0(i10, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            fVar.s0(i10, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            fVar.s0(i10, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            fVar.s0(i10, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            fVar.D(i10, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            fVar.s0(i10, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void e(f fVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            i10++;
            b(fVar, i10, obj);
        }
    }

    @Override // c2.g
    public void a(f fVar) {
        e(fVar, this.f9697b);
    }

    @Override // c2.g
    public int c() {
        Object[] objArr = this.f9697b;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    @Override // c2.g
    public String d() {
        return this.f9696a;
    }

    public a(String str) {
        this(str, null);
    }
}
