package ic;

import android.net.Uri;
import cc.y;
import com.google.android.exoplayer2.offline.StreamKey;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b implements y<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f32034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f32035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f32036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f32037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f32038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f32039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final n f32040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final k f32041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final Uri f32042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final g f32043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<f> f32044m;

    @Deprecated
    public b(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, long j16, @p0 n nVar, @p0 Uri uri, List<f> list) {
        this(j10, j11, j12, z10, j13, j14, j15, j16, null, nVar, null, uri, list);
    }

    public static ArrayList<a> c(List<a> list, LinkedList<StreamKey> linkedList) {
        StreamKey streamKeyPoll = linkedList.poll();
        int i10 = streamKeyPoll.f17421a;
        ArrayList<a> arrayList = new ArrayList<>();
        do {
            int i11 = streamKeyPoll.f17422b;
            a aVar = list.get(i11);
            List<i> list2 = aVar.f32028c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.f17423c));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.f17421a != i10) {
                    break;
                }
            } while (streamKeyPoll.f17422b == i11);
            arrayList.add(new a(aVar.f32026a, aVar.f32027b, arrayList2, aVar.f32029d, aVar.f32030e, aVar.f32031f));
        } while (streamKeyPoll.f17421a == i10);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }

    @Override // cc.y
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final b a(List<StreamKey> list) {
        long j10;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j11 = 0;
        int i10 = 0;
        while (true) {
            int iE = e();
            j10 = ya.g.f56663b;
            if (i10 >= iE) {
                break;
            }
            if (((StreamKey) linkedList.peek()).f17421a != i10) {
                long jF = f(i10);
                if (jF != ya.g.f56663b) {
                    j11 += jF;
                }
            } else {
                f fVarD = d(i10);
                arrayList.add(new f(fVarD.f32066a, fVarD.f32067b - j11, c(fVarD.f32068c, linkedList), fVarD.f32069d));
            }
            i10++;
        }
        long j12 = this.f32033b;
        if (j12 != ya.g.f56663b) {
            j10 = j12 - j11;
        }
        return new b(this.f32032a, j10, this.f32034c, this.f32035d, this.f32036e, this.f32037f, this.f32038g, this.f32039h, this.f32043l, this.f32040i, this.f32041j, this.f32042k, arrayList);
    }

    public final f d(int i10) {
        return this.f32044m.get(i10);
    }

    public final int e() {
        return this.f32044m.size();
    }

    public final long f(int i10) {
        if (i10 != this.f32044m.size() - 1) {
            return this.f32044m.get(i10 + 1).f32067b - this.f32044m.get(i10).f32067b;
        }
        long j10 = this.f32033b;
        return j10 == ya.g.f56663b ? ya.g.f56663b : j10 - this.f32044m.get(i10).f32067b;
    }

    public final long g(int i10) {
        return ya.g.c(f(i10));
    }

    public b(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, long j16, @p0 g gVar, @p0 n nVar, @p0 k kVar, @p0 Uri uri, List<f> list) {
        this.f32032a = j10;
        this.f32033b = j11;
        this.f32034c = j12;
        this.f32035d = z10;
        this.f32036e = j13;
        this.f32037f = j14;
        this.f32038g = j15;
        this.f32039h = j16;
        this.f32043l = gVar;
        this.f32040i = nVar;
        this.f32042k = uri;
        this.f32041j = kVar;
        this.f32044m = list == null ? Collections.emptyList() : list;
    }
}
