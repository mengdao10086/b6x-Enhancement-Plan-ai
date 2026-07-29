package ed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import ed.d;
import g.p0;
import hd.j0;
import hd.u0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements d, z {
    public static final int A = 3;
    public static final int B = 4;

    @p0
    public static n C = null;
    public static final int D = 2000;
    public static final int E = 524288;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ImmutableListMultimap<String, Integer> f26927p = j();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ImmutableList<Long> f26928q = ImmutableList.of(6100000L, 3800000L, 2100000L, 1300000L, 590000L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ImmutableList<Long> f26929r = ImmutableList.of(218000L, 159000L, 145000L, 130000L, 112000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ImmutableList<Long> f26930s = ImmutableList.of(2200000L, 1300000L, 930000L, 730000L, 530000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ImmutableList<Long> f26931t = ImmutableList.of(4800000L, 2700000L, 1800000L, 1200000L, 630000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ImmutableList<Long> f26932u = ImmutableList.of(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f26933v = 1000000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f26934w = 2000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f26935x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f26936y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f26937z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Context f26938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableMap<Integer, Long> f26939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.a.C0309a f26940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f26941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.c f26942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f26944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f26945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f26947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f26948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f26949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f26950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f26951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26952o;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final Context f26953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Integer, Long> f26954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public hd.c f26956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f26957e;

        public b(Context context) {
            this.f26953a = context == null ? null : context.getApplicationContext();
            this.f26954b = c(u0.U(context));
            this.f26955c = 2000;
            this.f26956d = hd.c.f30965a;
            this.f26957e = true;
        }

        public static ImmutableList<Integer> b(String str) {
            ImmutableList<Integer> immutableList = n.f26927p.get(str);
            return immutableList.isEmpty() ? ImmutableList.of(2, 2, 2, 2, 2) : immutableList;
        }

        public static Map<Integer, Long> c(String str) {
            ImmutableList<Integer> immutableListB = b(str);
            HashMap map = new HashMap(6);
            map.put(0, 1000000L);
            ImmutableList<Long> immutableList = n.f26928q;
            map.put(2, immutableList.get(immutableListB.get(0).intValue()));
            map.put(3, n.f26929r.get(immutableListB.get(1).intValue()));
            map.put(4, n.f26930s.get(immutableListB.get(2).intValue()));
            map.put(5, n.f26931t.get(immutableListB.get(3).intValue()));
            map.put(9, n.f26932u.get(immutableListB.get(4).intValue()));
            map.put(7, immutableList.get(immutableListB.get(0).intValue()));
            return map;
        }

        public n a() {
            return new n(this.f26953a, this.f26954b, this.f26955c, this.f26956d, this.f26957e);
        }

        public b d(hd.c cVar) {
            this.f26956d = cVar;
            return this;
        }

        public b e(int i10, long j10) {
            this.f26954b.put(Integer.valueOf(i10), Long.valueOf(j10));
            return this;
        }

        public b f(long j10) {
            Iterator<Integer> it2 = this.f26954b.keySet().iterator();
            while (it2.hasNext()) {
                e(it2.next().intValue(), j10);
            }
            return this;
        }

        public b g(String str) {
            this.f26954b = c(u0.y1(str));
            return this;
        }

        public b h(boolean z10) {
            this.f26957e = z10;
            return this;
        }

        public b i(int i10) {
            this.f26955c = i10;
            return this;
        }
    }

    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static c f26958c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f26959a = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<WeakReference<n>> f26960b = new ArrayList<>();

        public static synchronized c b(Context context) {
            if (f26958c == null) {
                f26958c = new c();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(f26958c, intentFilter);
            }
            return f26958c;
        }

        public synchronized void d(final n nVar) {
            e();
            this.f26960b.add(new WeakReference<>(nVar));
            this.f26959a.post(new Runnable() { // from class: ed.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f26961a.c(nVar);
                }
            });
        }

        public final void e() {
            for (int size = this.f26960b.size() - 1; size >= 0; size--) {
                if (this.f26960b.get(size).get() == null) {
                    this.f26960b.remove(size);
                }
            }
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final void c(n nVar) {
            nVar.o();
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            e();
            for (int i10 = 0; i10 < this.f26960b.size(); i10++) {
                n nVar = this.f26960b.get(i10).get();
                if (nVar != null) {
                    c(nVar);
                }
            }
        }
    }

    public static ImmutableListMultimap<String, Integer> j() {
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        builder.putAll("AD", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("AE", (Object[]) new Integer[]{1, 4, 4, 4, 1});
        builder.putAll("AF", (Object[]) new Integer[]{4, 4, 3, 4, 2});
        builder.putAll("AG", (Object[]) new Integer[]{2, 2, 1, 1, 2});
        builder.putAll("AI", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll(com.umeng.socialize.a.h.f24555a, (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll("AM", (Object[]) new Integer[]{2, 2, 1, 2, 2});
        builder.putAll("AO", (Object[]) new Integer[]{3, 4, 4, 2, 2});
        builder.putAll("AR", (Object[]) new Integer[]{2, 4, 2, 2, 2});
        builder.putAll("AS", (Object[]) new Integer[]{2, 2, 4, 3, 2});
        builder.putAll("AT", (Object[]) new Integer[]{0, 3, 0, 0, 2});
        builder.putAll("AU", (Object[]) new Integer[]{0, 2, 0, 1, 1});
        builder.putAll("AW", (Object[]) new Integer[]{1, 2, 0, 4, 2});
        builder.putAll("AX", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll("AZ", (Object[]) new Integer[]{3, 3, 3, 4, 2});
        builder.putAll("BA", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll("BB", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll("BD", (Object[]) new Integer[]{2, 0, 3, 3, 2});
        builder.putAll("BE", (Object[]) new Integer[]{0, 1, 2, 3, 2});
        builder.putAll("BF", (Object[]) new Integer[]{4, 4, 4, 2, 2});
        builder.putAll("BG", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll("BH", (Object[]) new Integer[]{1, 0, 2, 4, 2});
        builder.putAll("BI", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll("BJ", (Object[]) new Integer[]{4, 4, 3, 4, 2});
        builder.putAll("BL", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll("BM", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("BN", (Object[]) new Integer[]{4, 0, 1, 1, 2});
        builder.putAll("BO", (Object[]) new Integer[]{2, 3, 3, 2, 2});
        builder.putAll("BQ", (Object[]) new Integer[]{1, 2, 1, 2, 2});
        builder.putAll("BR", (Object[]) new Integer[]{2, 4, 2, 1, 2});
        builder.putAll("BS", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll("BT", (Object[]) new Integer[]{3, 0, 3, 2, 2});
        builder.putAll("BW", (Object[]) new Integer[]{3, 4, 2, 2, 2});
        builder.putAll("BY", (Object[]) new Integer[]{1, 0, 2, 1, 2});
        builder.putAll("BZ", (Object[]) new Integer[]{2, 2, 2, 1, 2});
        builder.putAll("CA", (Object[]) new Integer[]{0, 3, 1, 2, 3});
        builder.putAll("CD", (Object[]) new Integer[]{4, 3, 2, 2, 2});
        builder.putAll("CF", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll("CG", (Object[]) new Integer[]{3, 4, 1, 1, 2});
        builder.putAll("CH", (Object[]) new Integer[]{0, 1, 0, 0, 0});
        builder.putAll("CI", (Object[]) new Integer[]{3, 3, 3, 3, 2});
        builder.putAll("CK", (Object[]) new Integer[]{3, 2, 1, 0, 2});
        builder.putAll("CL", (Object[]) new Integer[]{1, 1, 2, 3, 2});
        builder.putAll("CM", (Object[]) new Integer[]{3, 4, 3, 2, 2});
        builder.putAll("CN", (Object[]) new Integer[]{2, 2, 2, 1, 3});
        builder.putAll("CO", (Object[]) new Integer[]{2, 4, 3, 2, 2});
        builder.putAll("CR", (Object[]) new Integer[]{2, 3, 4, 4, 2});
        builder.putAll("CU", (Object[]) new Integer[]{4, 4, 2, 1, 2});
        builder.putAll("CV", (Object[]) new Integer[]{2, 3, 3, 3, 2});
        builder.putAll("CW", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("CY", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("CZ", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll("DE", (Object[]) new Integer[]{0, 1, 1, 2, 0});
        builder.putAll("DJ", (Object[]) new Integer[]{4, 1, 4, 4, 2});
        builder.putAll("DK", (Object[]) new Integer[]{0, 0, 1, 0, 2});
        builder.putAll("DM", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll("DO", (Object[]) new Integer[]{3, 4, 4, 4, 2});
        builder.putAll("DZ", (Object[]) new Integer[]{3, 2, 4, 4, 2});
        builder.putAll("EC", (Object[]) new Integer[]{2, 4, 3, 2, 2});
        builder.putAll("EE", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll("EG", (Object[]) new Integer[]{3, 4, 2, 1, 2});
        builder.putAll("EH", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll("ER", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll("ES", (Object[]) new Integer[]{0, 1, 2, 1, 2});
        builder.putAll("ET", (Object[]) new Integer[]{4, 4, 4, 1, 2});
        builder.putAll("FI", (Object[]) new Integer[]{0, 0, 1, 0, 0});
        builder.putAll("FJ", (Object[]) new Integer[]{3, 0, 3, 3, 2});
        builder.putAll("FK", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll("FM", (Object[]) new Integer[]{4, 2, 4, 3, 2});
        builder.putAll("FO", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll("FR", (Object[]) new Integer[]{1, 0, 2, 1, 2});
        builder.putAll("GA", (Object[]) new Integer[]{3, 3, 1, 0, 2});
        builder.putAll("GB", (Object[]) new Integer[]{0, 0, 1, 2, 2});
        builder.putAll("GD", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll("GE", (Object[]) new Integer[]{1, 0, 1, 3, 2});
        builder.putAll("GF", (Object[]) new Integer[]{2, 2, 2, 4, 2});
        builder.putAll("GG", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll("GH", (Object[]) new Integer[]{3, 2, 3, 2, 2});
        builder.putAll("GI", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll("GL", (Object[]) new Integer[]{1, 2, 2, 1, 2});
        builder.putAll("GM", (Object[]) new Integer[]{4, 3, 2, 4, 2});
        builder.putAll("GN", (Object[]) new Integer[]{4, 3, 4, 2, 2});
        builder.putAll("GP", (Object[]) new Integer[]{2, 2, 3, 4, 2});
        builder.putAll("GQ", (Object[]) new Integer[]{4, 2, 3, 4, 2});
        builder.putAll("GR", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll("GT", (Object[]) new Integer[]{3, 2, 3, 2, 2});
        builder.putAll("GU", (Object[]) new Integer[]{1, 2, 4, 4, 2});
        builder.putAll("GW", (Object[]) new Integer[]{3, 4, 4, 3, 2});
        builder.putAll("GY", (Object[]) new Integer[]{3, 3, 1, 0, 2});
        builder.putAll("HK", (Object[]) new Integer[]{0, 2, 3, 4, 2});
        builder.putAll("HN", (Object[]) new Integer[]{3, 0, 3, 3, 2});
        builder.putAll("HR", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll("HT", (Object[]) new Integer[]{4, 3, 4, 4, 2});
        builder.putAll("HU", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll("ID", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll("IE", (Object[]) new Integer[]{0, 0, 1, 1, 2});
        builder.putAll("IL", (Object[]) new Integer[]{1, 0, 2, 3, 2});
        builder.putAll("IM", (Object[]) new Integer[]{0, 2, 0, 1, 2});
        builder.putAll("IN", (Object[]) new Integer[]{2, 1, 3, 3, 2});
        builder.putAll("IO", (Object[]) new Integer[]{4, 2, 2, 4, 2});
        builder.putAll("IQ", (Object[]) new Integer[]{3, 2, 4, 3, 2});
        builder.putAll("IR", (Object[]) new Integer[]{4, 2, 3, 4, 2});
        builder.putAll("IS", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll("IT", (Object[]) new Integer[]{0, 0, 1, 1, 2});
        builder.putAll("JE", (Object[]) new Integer[]{2, 2, 0, 2, 2});
        builder.putAll("JM", (Object[]) new Integer[]{3, 3, 4, 4, 2});
        builder.putAll("JO", (Object[]) new Integer[]{1, 2, 1, 1, 2});
        builder.putAll("JP", (Object[]) new Integer[]{0, 2, 0, 1, 3});
        builder.putAll("KE", (Object[]) new Integer[]{3, 4, 2, 2, 2});
        builder.putAll(ze.k.f58515q, (Object[]) new Integer[]{1, 0, 2, 2, 2});
        builder.putAll("KH", (Object[]) new Integer[]{2, 0, 4, 3, 2});
        builder.putAll("KI", (Object[]) new Integer[]{4, 2, 3, 1, 2});
        builder.putAll("KM", (Object[]) new Integer[]{4, 2, 2, 3, 2});
        builder.putAll("KN", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll("KP", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll("KR", (Object[]) new Integer[]{0, 2, 1, 1, 1});
        builder.putAll("KW", (Object[]) new Integer[]{2, 3, 1, 1, 1});
        builder.putAll("KY", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("KZ", (Object[]) new Integer[]{1, 2, 2, 3, 2});
        builder.putAll("LA", (Object[]) new Integer[]{2, 2, 1, 1, 2});
        builder.putAll(ze.k.f58516r, (Object[]) new Integer[]{3, 2, 0, 0, 2});
        builder.putAll("LC", (Object[]) new Integer[]{1, 1, 0, 0, 2});
        builder.putAll("LI", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll("LK", (Object[]) new Integer[]{2, 0, 2, 3, 2});
        builder.putAll("LR", (Object[]) new Integer[]{3, 4, 3, 2, 2});
        builder.putAll("LS", (Object[]) new Integer[]{3, 3, 2, 3, 2});
        builder.putAll("LT", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll("LU", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll("LV", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll("LY", (Object[]) new Integer[]{4, 2, 4, 3, 2});
        builder.putAll("MA", (Object[]) new Integer[]{2, 1, 2, 1, 2});
        builder.putAll("MC", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll("MD", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("ME", (Object[]) new Integer[]{1, 2, 1, 2, 2});
        builder.putAll("MF", (Object[]) new Integer[]{1, 2, 1, 0, 2});
        builder.putAll("MG", (Object[]) new Integer[]{3, 4, 3, 3, 2});
        builder.putAll("MH", (Object[]) new Integer[]{4, 2, 2, 4, 2});
        builder.putAll("MK", (Object[]) new Integer[]{1, 0, 0, 0, 2});
        builder.putAll("ML", (Object[]) new Integer[]{4, 4, 1, 1, 2});
        builder.putAll("MM", (Object[]) new Integer[]{2, 3, 2, 2, 2});
        builder.putAll("MN", (Object[]) new Integer[]{2, 4, 1, 1, 2});
        builder.putAll("MO", (Object[]) new Integer[]{0, 2, 4, 4, 2});
        builder.putAll("MP", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll("MQ", (Object[]) new Integer[]{2, 2, 2, 3, 2});
        builder.putAll("MR", (Object[]) new Integer[]{3, 0, 4, 2, 2});
        builder.putAll("MS", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll("MT", (Object[]) new Integer[]{0, 2, 0, 1, 2});
        builder.putAll("MU", (Object[]) new Integer[]{3, 1, 2, 3, 2});
        builder.putAll("MV", (Object[]) new Integer[]{4, 3, 1, 4, 2});
        builder.putAll("MW", (Object[]) new Integer[]{4, 1, 1, 0, 2});
        builder.putAll("MX", (Object[]) new Integer[]{2, 4, 3, 3, 2});
        builder.putAll("MY", (Object[]) new Integer[]{2, 0, 3, 3, 2});
        builder.putAll("MZ", (Object[]) new Integer[]{3, 3, 2, 3, 2});
        builder.putAll("NA", (Object[]) new Integer[]{4, 3, 2, 2, 2});
        builder.putAll("NC", (Object[]) new Integer[]{2, 0, 4, 4, 2});
        builder.putAll("NE", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll("NF", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll("NG", (Object[]) new Integer[]{3, 3, 2, 2, 2});
        builder.putAll("NI", (Object[]) new Integer[]{3, 1, 4, 4, 2});
        builder.putAll("NL", (Object[]) new Integer[]{0, 2, 4, 2, 0});
        builder.putAll(HlsPlaylistParser.W, (Object[]) new Integer[]{0, 1, 1, 0, 2});
        builder.putAll("NP", (Object[]) new Integer[]{2, 0, 4, 3, 2});
        builder.putAll("NR", (Object[]) new Integer[]{4, 2, 3, 1, 2});
        builder.putAll("NU", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll("NZ", (Object[]) new Integer[]{0, 2, 1, 2, 4});
        builder.putAll("OM", (Object[]) new Integer[]{2, 2, 0, 2, 2});
        builder.putAll("PA", (Object[]) new Integer[]{1, 3, 3, 4, 2});
        builder.putAll("PE", (Object[]) new Integer[]{2, 4, 4, 4, 2});
        builder.putAll("PF", (Object[]) new Integer[]{2, 2, 1, 1, 2});
        builder.putAll("PG", (Object[]) new Integer[]{4, 3, 3, 2, 2});
        builder.putAll("PH", (Object[]) new Integer[]{3, 0, 3, 4, 4});
        builder.putAll("PK", (Object[]) new Integer[]{3, 2, 3, 3, 2});
        builder.putAll("PL", (Object[]) new Integer[]{1, 0, 2, 2, 2});
        builder.putAll("PM", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll("PR", (Object[]) new Integer[]{1, 2, 2, 3, 4});
        builder.putAll("PS", (Object[]) new Integer[]{3, 3, 2, 2, 2});
        builder.putAll("PT", (Object[]) new Integer[]{1, 1, 0, 0, 2});
        builder.putAll("PW", (Object[]) new Integer[]{1, 2, 3, 0, 2});
        builder.putAll("PY", (Object[]) new Integer[]{2, 0, 3, 3, 2});
        builder.putAll("QA", (Object[]) new Integer[]{2, 3, 1, 2, 2});
        builder.putAll("RE", (Object[]) new Integer[]{1, 0, 2, 1, 2});
        builder.putAll("RO", (Object[]) new Integer[]{1, 1, 1, 2, 2});
        builder.putAll("RS", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll("RU", (Object[]) new Integer[]{0, 1, 0, 1, 2});
        builder.putAll("RW", (Object[]) new Integer[]{4, 3, 3, 4, 2});
        builder.putAll("SA", (Object[]) new Integer[]{2, 2, 2, 1, 2});
        builder.putAll("SB", (Object[]) new Integer[]{4, 2, 4, 2, 2});
        builder.putAll("SC", (Object[]) new Integer[]{4, 2, 0, 1, 2});
        builder.putAll("SD", (Object[]) new Integer[]{4, 4, 4, 3, 2});
        builder.putAll("SE", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll("SG", (Object[]) new Integer[]{0, 0, 3, 3, 4});
        builder.putAll("SH", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll("SI", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll("SJ", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll("SK", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll("SL", (Object[]) new Integer[]{4, 3, 3, 1, 2});
        builder.putAll("SM", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll("SN", (Object[]) new Integer[]{4, 4, 4, 3, 2});
        builder.putAll("SO", (Object[]) new Integer[]{3, 4, 4, 4, 2});
        builder.putAll("SR", (Object[]) new Integer[]{3, 2, 3, 1, 2});
        builder.putAll("SS", (Object[]) new Integer[]{4, 1, 4, 2, 2});
        builder.putAll("ST", (Object[]) new Integer[]{2, 2, 1, 2, 2});
        builder.putAll("SV", (Object[]) new Integer[]{2, 1, 4, 4, 2});
        builder.putAll("SX", (Object[]) new Integer[]{2, 2, 1, 0, 2});
        builder.putAll("SY", (Object[]) new Integer[]{4, 3, 2, 2, 2});
        builder.putAll("SZ", (Object[]) new Integer[]{3, 4, 3, 4, 2});
        builder.putAll("TC", (Object[]) new Integer[]{1, 2, 1, 0, 2});
        builder.putAll("TD", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll("TG", (Object[]) new Integer[]{3, 2, 1, 0, 2});
        builder.putAll("TH", (Object[]) new Integer[]{1, 3, 4, 3, 0});
        builder.putAll("TJ", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll("TL", (Object[]) new Integer[]{4, 1, 4, 4, 2});
        builder.putAll("TM", (Object[]) new Integer[]{4, 2, 1, 2, 2});
        builder.putAll("TN", (Object[]) new Integer[]{2, 1, 1, 1, 2});
        builder.putAll("TO", (Object[]) new Integer[]{3, 3, 4, 2, 2});
        builder.putAll("TR", (Object[]) new Integer[]{1, 2, 1, 1, 2});
        builder.putAll("TT", (Object[]) new Integer[]{1, 3, 1, 3, 2});
        builder.putAll("TV", (Object[]) new Integer[]{3, 2, 2, 4, 2});
        builder.putAll("TW", (Object[]) new Integer[]{0, 0, 0, 0, 1});
        builder.putAll("TZ", (Object[]) new Integer[]{3, 3, 3, 2, 2});
        builder.putAll("UA", (Object[]) new Integer[]{0, 3, 0, 0, 2});
        builder.putAll("UG", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll("US", (Object[]) new Integer[]{0, 1, 3, 3, 3});
        builder.putAll("UY", (Object[]) new Integer[]{2, 1, 1, 1, 2});
        builder.putAll("UZ", (Object[]) new Integer[]{2, 0, 3, 2, 2});
        builder.putAll("VC", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll("VE", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll("VG", (Object[]) new Integer[]{2, 2, 1, 2, 2});
        builder.putAll("VI", (Object[]) new Integer[]{1, 2, 2, 4, 2});
        builder.putAll("VN", (Object[]) new Integer[]{0, 1, 4, 4, 2});
        builder.putAll("VU", (Object[]) new Integer[]{4, 1, 3, 1, 2});
        builder.putAll("WS", (Object[]) new Integer[]{3, 1, 4, 2, 2});
        builder.putAll("XK", (Object[]) new Integer[]{1, 1, 1, 0, 2});
        builder.putAll("YE", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll("YT", (Object[]) new Integer[]{3, 2, 1, 3, 2});
        builder.putAll("ZA", (Object[]) new Integer[]{2, 3, 2, 2, 2});
        builder.putAll("ZM", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll("ZW", (Object[]) new Integer[]{3, 3, 3, 3, 2});
        return builder.build();
    }

    public static synchronized n l(Context context) {
        if (C == null) {
            C = new b(context).a();
        }
        return C;
    }

    public static boolean m(com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
        return z10 && !bVar.d(8);
    }

    @Override // ed.z
    public synchronized void a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
        if (m(bVar, z10)) {
            hd.a.i(this.f26943f > 0);
            long jE = this.f26942e.e();
            int i10 = (int) (jE - this.f26944g);
            this.f26947j += (long) i10;
            long j10 = this.f26948k;
            long j11 = this.f26945h;
            this.f26948k = j10 + j11;
            if (i10 > 0) {
                this.f26941d.c((int) Math.sqrt(j11), (j11 * 8000.0f) / i10);
                if (this.f26947j >= 2000 || this.f26948k >= PlaybackStateCompat.K0) {
                    this.f26949l = (long) this.f26941d.f(0.5f);
                }
                n(i10, this.f26945h, this.f26949l);
                this.f26944g = jE;
                this.f26945h = 0L;
            }
            this.f26943f--;
        }
    }

    @Override // ed.z
    public synchronized void b(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
        if (m(bVar, z10)) {
            if (this.f26943f == 0) {
                this.f26944g = this.f26942e.e();
            }
            this.f26943f++;
        }
    }

    @Override // ed.d
    public void c(Handler handler, d.a aVar) {
        hd.a.g(handler);
        hd.a.g(aVar);
        this.f26940c.b(handler, aVar);
    }

    @Override // ed.d
    public z d() {
        return this;
    }

    @Override // ed.d
    public synchronized long e() {
        return this.f26949l;
    }

    @Override // ed.d
    public void f(d.a aVar) {
        this.f26940c.e(aVar);
    }

    @Override // ed.z
    public synchronized void g(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10, int i10) {
        if (m(bVar, z10)) {
            this.f26945h += (long) i10;
        }
    }

    @Override // ed.z
    public void h(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
    }

    public final long k(int i10) {
        Long l10 = this.f26939b.get(Integer.valueOf(i10));
        if (l10 == null) {
            l10 = this.f26939b.get(0);
        }
        if (l10 == null) {
            l10 = 1000000L;
        }
        return l10.longValue();
    }

    public final void n(int i10, long j10, long j11) {
        if (i10 == 0 && j10 == 0 && j11 == this.f26950m) {
            return;
        }
        this.f26950m = j11;
        this.f26940c.c(i10, j10, j11);
    }

    public final synchronized void o() {
        int iI0;
        if (this.f26951n) {
            iI0 = this.f26952o;
        } else {
            Context context = this.f26938a;
            iI0 = context == null ? 0 : u0.i0(context);
        }
        if (this.f26946i == iI0) {
            return;
        }
        this.f26946i = iI0;
        if (iI0 != 1 && iI0 != 0 && iI0 != 8) {
            this.f26949l = k(iI0);
            long jE = this.f26942e.e();
            n(this.f26943f > 0 ? (int) (jE - this.f26944g) : 0, this.f26945h, this.f26949l);
            this.f26944g = jE;
            this.f26945h = 0L;
            this.f26948k = 0L;
            this.f26947j = 0L;
            this.f26941d.i();
        }
    }

    public synchronized void p(int i10) {
        this.f26952o = i10;
        this.f26951n = true;
        o();
    }

    @Deprecated
    public n() {
        this(null, ImmutableMap.of(), 2000, hd.c.f30965a, false);
    }

    public n(@p0 Context context, Map<Integer, Long> map, int i10, hd.c cVar, boolean z10) {
        this.f26938a = context == null ? null : context.getApplicationContext();
        this.f26939b = ImmutableMap.copyOf((Map) map);
        this.f26940c = new d.a.C0309a();
        this.f26941d = new j0(i10);
        this.f26942e = cVar;
        int iI0 = context == null ? 0 : u0.i0(context);
        this.f26946i = iI0;
        this.f26949l = k(iI0);
        if (context == null || !z10) {
            return;
        }
        c.b(context).d(this);
    }
}
