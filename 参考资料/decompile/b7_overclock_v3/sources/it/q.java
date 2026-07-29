package it;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator<byte[]> f35864b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<byte[]> f35865a = new LinkedList<>();

    public void a(byte[] bArr) {
        if (this.f35865a.size() == 0 || f35864b.compare(bArr, this.f35865a.get(0)) < 0) {
            this.f35865a.addFirst(bArr);
            return;
        }
        int i10 = 1;
        while (i10 < this.f35865a.size() && f35864b.compare(this.f35865a.get(i10), bArr) <= 0) {
            i10++;
        }
        if (i10 == this.f35865a.size()) {
            this.f35865a.add(bArr);
        } else {
            this.f35865a.add(i10, bArr);
        }
    }

    public List<byte[]> b() {
        return new ArrayList(this.f35865a);
    }
}
