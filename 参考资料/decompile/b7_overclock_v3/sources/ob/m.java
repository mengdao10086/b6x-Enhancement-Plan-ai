package ob;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.base.Splitter;
import hb.z;
import hd.c0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f43247d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f43248e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f43249f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f43250g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f43251h = 2192;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f43252i = 2816;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f43253j = 2817;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f43254k = 2819;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f43255l = 2820;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f43256m = "SefReader";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f43257n = 1397048916;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f43258o = 12;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f43259p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f43260q = 12;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Splitter f43261r = Splitter.on(':');

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Splitter f43262s = Splitter.on('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f43263a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43264b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f43265c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43268c;

        public a(int i10, long j10, int i11) {
            this.f43266a = i10;
            this.f43267b = j10;
            this.f43268c = i11;
        }
    }

    public static int b(String str) throws ParserException {
        str.hashCode();
        switch (str) {
            case "SlowMotion_Data":
                return f43251h;
            case "Super_SlowMotion_Edit_Data":
                return f43254k;
            case "Super_SlowMotion_Data":
                return f43252i;
            case "Super_SlowMotion_Deflickering_On":
                return f43255l;
            case "Super_SlowMotion_BGM":
                return f43253j;
            default:
                throw new ParserException("Invalid SEF name");
        }
    }

    public static SlowMotionData f(c0 c0Var, int i10) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List<String> listSplitToList = f43262s.splitToList(c0Var.D(i10));
        for (int i11 = 0; i11 < listSplitToList.size(); i11++) {
            List<String> listSplitToList2 = f43261r.splitToList(listSplitToList.get(i11));
            if (listSplitToList2.size() != 3) {
                throw new ParserException();
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong(listSplitToList2.get(0)), Long.parseLong(listSplitToList2.get(1)), 1 << (Integer.parseInt(listSplitToList2.get(2)) - 1)));
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public final void a(hb.l lVar, z zVar) throws IOException {
        c0 c0Var = new c0(8);
        lVar.readFully(c0Var.d(), 0, 8);
        this.f43265c = c0Var.r() + 8;
        if (c0Var.o() != 1397048916) {
            zVar.f30930a = 0L;
        } else {
            zVar.f30930a = lVar.getPosition() - ((long) (this.f43265c - 12));
            this.f43264b = 2;
        }
    }

    public int c(hb.l lVar, z zVar, List<Metadata.Entry> list) throws IOException {
        int i10 = this.f43264b;
        long j10 = 0;
        if (i10 == 0) {
            long length = lVar.getLength();
            if (length != -1 && length >= 8) {
                j10 = length - 8;
            }
            zVar.f30930a = j10;
            this.f43264b = 1;
        } else if (i10 == 1) {
            a(lVar, zVar);
        } else if (i10 == 2) {
            d(lVar, zVar);
        } else {
            if (i10 != 3) {
                throw new IllegalStateException();
            }
            e(lVar, list);
            zVar.f30930a = 0L;
        }
        return 1;
    }

    public final void d(hb.l lVar, z zVar) throws IOException {
        long length = lVar.getLength();
        int i10 = (this.f43265c - 12) - 8;
        c0 c0Var = new c0(i10);
        lVar.readFully(c0Var.d(), 0, i10);
        for (int i11 = 0; i11 < i10 / 12; i11++) {
            c0Var.T(2);
            short sU = c0Var.u();
            if (sU == 2192 || sU == 2816 || sU == 2817 || sU == 2819 || sU == 2820) {
                this.f43263a.add(new a(sU, (length - ((long) this.f43265c)) - ((long) c0Var.r()), c0Var.r()));
            } else {
                c0Var.T(8);
            }
        }
        if (this.f43263a.isEmpty()) {
            zVar.f30930a = 0L;
        } else {
            this.f43264b = 3;
            zVar.f30930a = this.f43263a.get(0).f43267b;
        }
    }

    public final void e(hb.l lVar, List<Metadata.Entry> list) throws IOException {
        long position = lVar.getPosition();
        int length = (int) ((lVar.getLength() - lVar.getPosition()) - ((long) this.f43265c));
        c0 c0Var = new c0(length);
        lVar.readFully(c0Var.d(), 0, length);
        for (int i10 = 0; i10 < this.f43263a.size(); i10++) {
            a aVar = this.f43263a.get(i10);
            c0Var.S((int) (aVar.f43267b - position));
            c0Var.T(4);
            int iR = c0Var.r();
            int iB = b(c0Var.D(iR));
            int i11 = aVar.f43268c - (iR + 8);
            if (iB == 2192) {
                list.add(f(c0Var, i11));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f43263a.clear();
        this.f43264b = 0;
    }
}
