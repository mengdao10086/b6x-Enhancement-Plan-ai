package a;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ca2 extends q52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5772a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f360b;
    public final int c;

    public ca2(int i, int i2, int i3) {
        this.c = i3;
        this.f5772a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f360b = z;
        this.b = z ? i : this.f5772a;
    }

    @Override // a.q52
    public int b() {
        int i = this.b;
        if (i != this.f5772a) {
            this.b = this.c + i;
        } else {
            if (!this.f360b) {
                throw new NoSuchElementException();
            }
            this.f360b = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f360b;
    }
}
