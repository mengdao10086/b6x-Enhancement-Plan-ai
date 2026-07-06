package a;

import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class py extends sy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qy f7158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sy f2459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextPaint f2460a;

    public py(qy qyVar, TextPaint textPaint, sy syVar) {
        this.f7158a = qyVar;
        this.f2460a = textPaint;
        this.f2459a = syVar;
    }

    @Override // a.sy
    public void a(int i) {
        this.f2459a.a(i);
    }

    @Override // a.sy
    public void b(Typeface typeface, boolean z) {
        this.f7158a.k(this.f2460a, typeface);
        this.f2459a.b(typeface, z);
    }
}
