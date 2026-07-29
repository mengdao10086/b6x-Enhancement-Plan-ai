package g4;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import e4.j;
import g.i1;
import g4.d;
import java.util.HashMap;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f29019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f29020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DecodeFormat f29021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f29022d;

    public b(j jVar, e eVar, DecodeFormat decodeFormat) {
        this.f29019a = jVar;
        this.f29020b = eVar;
        this.f29021c = decodeFormat;
    }

    public static int b(d dVar) {
        return o.g(dVar.d(), dVar.b(), dVar.a());
    }

    @i1
    public c a(d... dVarArr) {
        long jA = (this.f29019a.a() - this.f29019a.e()) + this.f29020b.a();
        int iC = 0;
        for (d dVar : dVarArr) {
            iC += dVar.c();
        }
        float f10 = jA / iC;
        HashMap map = new HashMap();
        for (d dVar2 : dVarArr) {
            map.put(dVar2, Integer.valueOf(Math.round(dVar2.c() * f10) / b(dVar2)));
        }
        return new c(map);
    }

    public void c(d.a... aVarArr) {
        a aVar = this.f29022d;
        if (aVar != null) {
            aVar.cancel();
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            d.a aVar2 = aVarArr[i10];
            if (aVar2.b() == null) {
                aVar2.c(this.f29021c == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            dVarArr[i10] = aVar2.a();
        }
        a aVar3 = new a(this.f29020b, this.f29019a, a(dVarArr));
        this.f29022d = aVar3;
        o.x(aVar3);
    }
}
