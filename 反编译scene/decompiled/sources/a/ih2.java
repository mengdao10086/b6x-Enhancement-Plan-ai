package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ih2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f1372a = new Object[16];
    public int b;

    public final void a(T t) {
        Object[] objArr = this.f1372a;
        int i = this.b;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.b = length;
        if (length == this.f6414a) {
            b();
        }
    }

    public final void b() {
        Object[] objArr = this.f1372a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        s42.e(objArr, objArr2, 0, this.f6414a, 0, 10, null);
        Object[] objArr3 = this.f1372a;
        int length2 = objArr3.length;
        int i = this.f6414a;
        s42.e(objArr3, objArr2, length2 - i, 0, i, 4, null);
        this.f1372a = objArr2;
        this.f6414a = 0;
        this.b = length;
    }

    public final boolean c() {
        return this.f6414a == this.b;
    }

    public final T d() {
        int i = this.f6414a;
        if (i == this.b) {
            return null;
        }
        Object[] objArr = this.f1372a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.f6414a = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
