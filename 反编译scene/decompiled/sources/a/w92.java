package a;

import java.util.Random;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w92 extends ThreadLocal<Random> {
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Random initialValue() {
        return new Random();
    }
}
