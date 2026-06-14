package a;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s82 extends w42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean[] f2861a;

    public s82(boolean[] zArr) {
        f92.d(zArr, "array");
        this.f2861a = zArr;
    }

    @Override // a.w42
    public boolean b() {
        try {
            boolean[] zArr = this.f2861a;
            int i = this.f7374a;
            this.f7374a = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f7374a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7374a < this.f2861a.length;
    }
}
