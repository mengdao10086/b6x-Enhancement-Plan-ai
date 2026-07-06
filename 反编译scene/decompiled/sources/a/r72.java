package a;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r72 implements Iterator<String>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s72 f7279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2720a;
    public boolean b;

    public r72(s72 s72Var) {
        this.f7279a = s72Var;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f2720a;
        this.f2720a = null;
        f92.b(str);
        return str;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws IOException {
        if (this.f2720a == null && !this.b) {
            String line = this.f7279a.f7371a.readLine();
            this.f2720a = line;
            if (line == null) {
                this.b = true;
            }
        }
        return this.f2720a != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
