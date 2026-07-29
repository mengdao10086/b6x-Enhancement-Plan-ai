package n4;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.s;
import g.n0;
import java.security.MessageDigest;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public class f implements c4.h<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c4.h<Bitmap> f41846c;

    public f(c4.h<Bitmap> hVar) {
        this.f41846c = (c4.h) m.d(hVar);
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        this.f41846c.a(messageDigest);
    }

    @Override // c4.h
    @n0
    public s<c> b(@n0 Context context, @n0 s<c> sVar, int i10, int i11) {
        c cVar = sVar.get();
        s<Bitmap> gVar = new com.bumptech.glide.load.resource.bitmap.g(cVar.h(), com.bumptech.glide.b.e(context).h());
        s<Bitmap> sVarB = this.f41846c.b(context, gVar, i10, i11);
        if (!gVar.equals(sVarB)) {
            gVar.a();
        }
        cVar.r(this.f41846c, sVarB.get());
        return sVar;
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f41846c.equals(((f) obj).f41846c);
        }
        return false;
    }

    @Override // c4.b
    public int hashCode() {
        return this.f41846c.hashCode();
    }
}
