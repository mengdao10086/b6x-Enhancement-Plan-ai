package a;

import java.io.BufferedReader;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s72 implements pa2<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedReader f7371a;

    public s72(BufferedReader bufferedReader) {
        f92.d(bufferedReader, "reader");
        this.f7371a = bufferedReader;
    }

    @Override // a.pa2
    public Iterator<String> iterator() {
        return new r72(this);
    }
}
