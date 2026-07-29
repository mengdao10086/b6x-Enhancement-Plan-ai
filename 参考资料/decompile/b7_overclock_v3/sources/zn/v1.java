package zn;

import gm.f2;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f59015a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f59016b = new Vector();

    public void a(gm.y yVar, boolean z10, gm.h hVar) {
        try {
            b(yVar, z10, hVar.b().v(gm.j.f29713a));
        } catch (IOException e10) {
            throw new IllegalArgumentException("error encoding value: " + e10);
        }
    }

    public void b(gm.y yVar, boolean z10, byte[] bArr) {
        if (!this.f59015a.containsKey(yVar)) {
            this.f59016b.addElement(yVar);
            this.f59015a.put(yVar, new t1(z10, new f2(bArr)));
        } else {
            throw new IllegalArgumentException("extension " + yVar + " already added");
        }
    }

    public u1 c() {
        return new u1(this.f59016b, this.f59015a);
    }

    public boolean d() {
        return this.f59016b.isEmpty();
    }

    public void e() {
        this.f59015a = new Hashtable();
        this.f59016b = new Vector();
    }
}
