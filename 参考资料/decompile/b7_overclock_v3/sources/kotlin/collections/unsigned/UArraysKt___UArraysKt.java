package kotlin.collections.unsigned;

import bk.f;
import hk.h;
import ik.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.c2;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.h0;
import kotlin.collections.i0;
import kotlin.collections.k0;
import kotlin.collections.r0;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.collections.z;
import kotlin.d1;
import kotlin.h1;
import kotlin.i1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.l1;
import kotlin.m0;
import kotlin.m1;
import kotlin.p1;
import kotlin.q;
import kotlin.q1;
import kotlin.random.Random;
import kotlin.s;
import kotlin.v0;
import kotlin.v1;
import kotlin.w1;
import kotlin.z1;
import qk.m;
import qk.v;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\n_UArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,10877:1\n3919#1:10878\n3927#1:10879\n3935#1:10880\n3943#1:10881\n3919#1:10882\n3927#1:10883\n3935#1:10884\n3943#1:10885\n3919#1:10886\n3927#1:10887\n3935#1:10888\n3943#1:10889\n3919#1:10939\n3927#1:10940\n3935#1:10941\n3943#1:10942\n3919#1:10943\n3927#1:10944\n3935#1:10945\n3943#1:10946\n3919#1:10947\n3927#1:10948\n3935#1:10949\n3943#1:10950\n3919#1:11007\n3927#1:11008\n3935#1:11009\n3943#1:11010\n3919#1:11011\n3927#1:11012\n3935#1:11013\n3943#1:11014\n3919#1:11015\n3927#1:11016\n3935#1:11017\n3943#1:11018\n3919#1:11019\n3927#1:11020\n3935#1:11021\n3943#1:11022\n3919#1:11023\n3927#1:11024\n3935#1:11025\n3943#1:11026\n3919#1:11027\n3927#1:11028\n3935#1:11029\n3943#1:11030\n3919#1:11031\n3927#1:11032\n3935#1:11033\n3943#1:11034\n3919#1:11035\n3927#1:11036\n3935#1:11037\n3943#1:11038\n3919#1:11039\n3927#1:11040\n3935#1:11041\n3943#1:11042\n3919#1:11043\n3927#1:11044\n3935#1:11045\n3943#1:11046\n3919#1:11047\n3927#1:11048\n3935#1:11049\n3943#1:11050\n3919#1:11051\n3927#1:11052\n3935#1:11053\n3943#1:11054\n3919#1:11055\n3927#1:11056\n3935#1:11057\n3943#1:11058\n3919#1:11059\n3927#1:11060\n3935#1:11061\n3943#1:11062\n3919#1:11063\n3927#1:11064\n3935#1:11065\n3943#1:11066\n3919#1:11067\n3927#1:11068\n3935#1:11069\n3943#1:11070\n3919#1:11071\n3927#1:11072\n3935#1:11073\n3943#1:11074\n3919#1:11075\n3927#1:11076\n3935#1:11077\n3943#1:11078\n3919#1:11079\n3927#1:11080\n3935#1:11081\n3943#1:11082\n3919#1:11083\n3927#1:11084\n3935#1:11085\n3943#1:11086\n3919#1:11087\n3927#1:11088\n3935#1:11089\n3943#1:11090\n3919#1:11091\n3927#1:11092\n3935#1:11093\n3943#1:11094\n3919#1:11095\n3927#1:11096\n3935#1:11097\n3943#1:11098\n3919#1:11099\n3927#1:11100\n3935#1:11101\n3943#1:11102\n3919#1:11103\n3927#1:11104\n3935#1:11105\n3943#1:11106\n3919#1:11107\n3927#1:11108\n3935#1:11109\n3943#1:11110\n3919#1:11111\n3927#1:11112\n3935#1:11113\n3943#1:11114\n3919#1:11115\n3927#1:11116\n3935#1:11117\n3943#1:11118\n3919#1:11119\n3927#1:11120\n3935#1:11121\n3943#1:11122\n3919#1:11123\n3927#1:11124\n3935#1:11125\n3943#1:11126\n3919#1:11127\n3927#1:11128\n3935#1:11129\n3943#1:11130\n3919#1:11131\n3927#1:11132\n3935#1:11133\n3943#1:11134\n3919#1:11135\n3927#1:11136\n3935#1:11137\n3943#1:11138\n3919#1:11139\n3927#1:11140\n3935#1:11141\n3943#1:11142\n3919#1:11143\n3927#1:11144\n3935#1:11145\n3943#1:11146\n3919#1:11147\n3927#1:11148\n3935#1:11149\n3943#1:11150\n3919#1:11151\n3927#1:11152\n3935#1:11153\n3943#1:11154\n3919#1:11155\n3927#1:11156\n3935#1:11157\n3943#1:11158\n1663#2,6:10890\n1675#2,6:10896\n1639#2,6:10902\n1651#2,6:10908\n1771#2,6:10914\n1783#2,6:10920\n1747#2,6:10926\n1759#2,6:10932\n1#3:10938\n361#4,7:10951\n361#4,7:10958\n361#4,7:10965\n361#4,7:10972\n361#4,7:10979\n361#4,7:10986\n361#4,7:10993\n361#4,7:11000\n*S KotlinDebug\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n*L\n326#1:10878\n338#1:10879\n350#1:10880\n362#1:10881\n692#1:10882\n702#1:10883\n712#1:10884\n722#1:10885\n733#1:10886\n744#1:10887\n755#1:10888\n766#1:10889\n1718#1:10939\n1735#1:10940\n1752#1:10941\n1769#1:10942\n2546#1:10943\n2563#1:10944\n2580#1:10945\n2597#1:10946\n2913#1:10947\n2929#1:10948\n2945#1:10949\n2961#1:10950\n5717#1:11007\n5737#1:11008\n5757#1:11009\n5777#1:11010\n5798#1:11011\n5820#1:11012\n5842#1:11013\n5864#1:11014\n5977#1:11015\n5996#1:11016\n6015#1:11017\n6034#1:11018\n6056#1:11019\n6085#1:11020\n6114#1:11021\n6143#1:11022\n6168#1:11023\n6193#1:11024\n6218#1:11025\n6243#1:11026\n6273#1:11027\n6296#1:11028\n6319#1:11029\n6342#1:11030\n6365#1:11031\n6388#1:11032\n6411#1:11033\n6434#1:11034\n6455#1:11035\n6478#1:11036\n6501#1:11037\n6524#1:11038\n6547#1:11039\n6568#1:11040\n6589#1:11041\n6610#1:11042\n6631#1:11043\n6652#1:11044\n6673#1:11045\n6694#1:11046\n6713#1:11047\n6734#1:11048\n6755#1:11049\n6776#1:11050\n6799#1:11051\n6822#1:11052\n6845#1:11053\n6868#1:11054\n6889#1:11055\n6910#1:11056\n6931#1:11057\n6952#1:11058\n6969#1:11059\n6984#1:11060\n6999#1:11061\n7014#1:11062\n7033#1:11063\n7052#1:11064\n7071#1:11065\n7090#1:11066\n7105#1:11067\n7120#1:11068\n7135#1:11069\n7150#1:11070\n7169#1:11071\n7188#1:11072\n7207#1:11073\n7226#1:11074\n7248#1:11075\n7277#1:11076\n7306#1:11077\n7335#1:11078\n7360#1:11079\n7385#1:11080\n7410#1:11081\n7435#1:11082\n7465#1:11083\n7488#1:11084\n7511#1:11085\n7534#1:11086\n7557#1:11087\n7580#1:11088\n7603#1:11089\n7626#1:11090\n7647#1:11091\n7670#1:11092\n7693#1:11093\n7716#1:11094\n7739#1:11095\n7760#1:11096\n7781#1:11097\n7802#1:11098\n7823#1:11099\n7844#1:11100\n7865#1:11101\n7886#1:11102\n7905#1:11103\n7926#1:11104\n7947#1:11105\n7968#1:11106\n7991#1:11107\n8014#1:11108\n8037#1:11109\n8060#1:11110\n8081#1:11111\n8102#1:11112\n8123#1:11113\n8144#1:11114\n8161#1:11115\n8176#1:11116\n8191#1:11117\n8206#1:11118\n8225#1:11119\n8244#1:11120\n8263#1:11121\n8282#1:11122\n8297#1:11123\n8312#1:11124\n8327#1:11125\n8342#1:11126\n8560#1:11127\n8585#1:11128\n8610#1:11129\n8635#1:11130\n8660#1:11131\n8685#1:11132\n8710#1:11133\n8735#1:11134\n8759#1:11135\n8783#1:11136\n8807#1:11137\n8831#1:11138\n8856#1:11139\n8881#1:11140\n8906#1:11141\n8931#1:11142\n8953#1:11143\n8978#1:11144\n9003#1:11145\n9028#1:11146\n9053#1:11147\n9079#1:11148\n9105#1:11149\n9131#1:11150\n9156#1:11151\n9181#1:11152\n9206#1:11153\n9231#1:11154\n9257#1:11155\n9282#1:11156\n9307#1:11157\n9332#1:11158\n816#1:10890,6\n826#1:10896,6\n836#1:10902,6\n846#1:10908,6\n856#1:10914,6\n866#1:10920,6\n876#1:10926,6\n886#1:10932,6\n4935#1:10951,7\n4955#1:10958,7\n4975#1:10965,7\n4995#1:10972,7\n5016#1:10979,7\n5037#1:10986,7\n5058#1:10993,7\n5079#1:11000,7\n*E\n"})
public class UArraysKt___UArraysKt extends b {
    @f
    @s
    @v0(version = "1.3")
    public static final long A0(long[] component1) {
        f0.p(component1, "$this$component1");
        return q1.p(component1, 0);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] A1(byte[] copyOf, int i10) {
        f0.p(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, i10);
        f0.o(bArrCopyOf, "copyOf(this, newSize)");
        return i1.e(bArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> A2(long[] filterIndexed, p<? super Integer, ? super p1, Boolean> predicate) {
        f0.p(filterIndexed, "$this$filterIndexed");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(filterIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            long jP = q1.p(filterIndexed, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), p1.d(jP)).booleanValue()) {
                arrayList.add(p1.d(jP));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C A3(byte[] flatMapIndexedTo, C destination, p<? super Integer, ? super h1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = i1.r(flatMapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), h1.d(i1.p(flatMapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @s
    @v0(version = "1.3")
    @l
    public static final l1 A4(@k int[] getOrNull, int i10) {
        f0.p(getOrNull, "$this$getOrNull");
        if (i10 < 0 || i10 > ArraysKt___ArraysKt.Ve(getOrNull)) {
            return null;
        }
        return l1.d(m1.p(getOrNull, i10));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> A5(int[] map, ik.l<? super l1, ? extends R> transform) {
        f0.p(map, "$this$map");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(m1.r(map));
        int iR = m1.r(map);
        for (int i10 = 0; i10 < iR; i10++) {
            arrayList.add(transform.i(l1.d(m1.p(map, i10))));
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R A6(short[] maxOfWithOrNull, Comparator<? super R> comparator, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (w1.u(maxOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(v1.d(w1.p(maxOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(maxOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R A7(short[] minOfWith, Comparator<? super R> comparator, ik.l<? super v1, ? extends R> selector) {
        f0.p(minOfWith, "$this$minOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (w1.u(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(v1.d(w1.p(minOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(minOfWith, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte A8(byte[] random) {
        f0.p(random, "$this$random");
        return D8(random, Random.f38003a);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final void A9(int[] reverse, int i10, int i11) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.zr(reverse, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final h1 Aa(byte[] singleOrNull, ik.l<? super h1, Boolean> predicate) {
        f0.p(singleOrNull, "$this$singleOrNull");
        f0.p(predicate, "predicate");
        int iR = i1.r(singleOrNull);
        h1 h1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(singleOrNull, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                if (z10) {
                    return null;
                }
                h1VarD = h1.d(bP);
                z10 = true;
            }
        }
        if (z10) {
            return h1VarD;
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final long[] Ab(@k long[] sortedArrayDescending) {
        f0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (q1.u(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrE = q1.e(jArrCopyOf);
        nb(jArrE);
        return jArrE;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> Ac(int[] takeLastWhile, ik.l<? super l1, Boolean> predicate) {
        f0.p(takeLastWhile, "$this$takeLastWhile");
        f0.p(predicate, "predicate");
        for (int iVe = ArraysKt___ArraysKt.Ve(takeLastWhile); -1 < iVe; iVe--) {
            if (!predicate.i(l1.d(m1.p(takeLastWhile, iVe))).booleanValue()) {
                return Q1(takeLastWhile, iVe + 1);
            }
        }
        return CollectionsKt___CollectionsKt.Q5(m1.b(takeLastWhile));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short B0(short[] component1) {
        f0.p(component1, "$this$component1");
        return w1.p(component1, 0);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] B1(long[] copyOf) {
        f0.p(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        return q1.e(jArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> B2(short[] filterIndexed, p<? super Integer, ? super v1, Boolean> predicate) {
        f0.p(filterIndexed, "$this$filterIndexed");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(filterIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            short sP = w1.p(filterIndexed, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), v1.d(sP)).booleanValue()) {
                arrayList.add(v1.d(sP));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C B3(long[] flatMapIndexedTo, C destination, p<? super Integer, ? super p1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = q1.r(flatMapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), p1.d(q1.p(flatMapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @s
    @v0(version = "1.3")
    @l
    public static final p1 B4(@k long[] getOrNull, int i10) {
        f0.p(getOrNull, "$this$getOrNull");
        if (i10 < 0 || i10 > ArraysKt___ArraysKt.We(getOrNull)) {
            return null;
        }
        return p1.d(q1.p(getOrNull, i10));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> B5(short[] map, ik.l<? super v1, ? extends R> transform) {
        f0.p(map, "$this$map");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(w1.r(map));
        int iR = w1.r(map);
        for (int i10 = 0; i10 < iR; i10++) {
            arrayList.add(transform.i(v1.d(w1.p(map, i10))));
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R B6(int[] maxOfWithOrNull, Comparator<? super R> comparator, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (m1.u(maxOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(l1.d(m1.p(maxOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(maxOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R B7(int[] minOfWith, Comparator<? super R> comparator, ik.l<? super l1, ? extends R> selector) {
        f0.p(minOfWith, "$this$minOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (m1.u(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(l1.d(m1.p(minOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(minOfWith, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @s
    @v0(version = "1.3")
    public static final long B8(@k long[] random, @k Random random2) {
        f0.p(random, "$this$random");
        f0.p(random2, "random");
        if (q1.u(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return q1.p(random, random2.p(q1.r(random)));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void B9(short[] reverse) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.Er(reverse);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final p1 Ba(long[] singleOrNull, ik.l<? super p1, Boolean> predicate) {
        f0.p(singleOrNull, "$this$singleOrNull");
        f0.p(predicate, "predicate");
        int iR = q1.r(singleOrNull);
        p1 p1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(singleOrNull, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                if (z10) {
                    return null;
                }
                p1VarD = p1.d(jP);
                z10 = true;
            }
        }
        if (z10) {
            return p1VarD;
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final short[] Bb(@k short[] sortedArrayDescending) {
        f0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (w1.u(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrE = w1.e(sArrCopyOf);
        pb(sArrE);
        return sArrE;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> Bc(short[] takeLastWhile, ik.l<? super v1, Boolean> predicate) {
        f0.p(takeLastWhile, "$this$takeLastWhile");
        f0.p(predicate, "predicate");
        for (int iYe = ArraysKt___ArraysKt.Ye(takeLastWhile); -1 < iYe; iYe--) {
            if (!predicate.i(v1.d(w1.p(takeLastWhile, iYe))).booleanValue()) {
                return P1(takeLastWhile, iYe + 1);
            }
        }
        return CollectionsKt___CollectionsKt.Q5(w1.b(takeLastWhile));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int C0(int[] component2) {
        f0.p(component2, "$this$component2");
        return m1.p(component2, 1);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] C1(short[] copyOf, int i10) {
        f0.p(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, i10);
        f0.o(sArrCopyOf, "copyOf(this, newSize)");
        return w1.e(sArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super l1>> C C2(int[] filterIndexedTo, C destination, p<? super Integer, ? super l1, Boolean> predicate) {
        f0.p(filterIndexedTo, "$this$filterIndexedTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = m1.r(filterIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            int iP = m1.p(filterIndexedTo, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), l1.d(iP)).booleanValue()) {
                destination.add(l1.d(iP));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C C3(long[] flatMapTo, C destination, ik.l<? super p1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapTo, "$this$flatMapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = q1.r(flatMapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(destination, transform.i(p1.d(q1.p(flatMapTo, i10))));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, V> Map<K, List<V>> C4(long[] groupBy, ik.l<? super p1, ? extends K> keySelector, ik.l<? super p1, ? extends V> valueTransform) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = q1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(groupBy, i10);
            K kI = keySelector.i(p1.d(jP));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(p1.d(jP)));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> C5(byte[] mapIndexed, p<? super Integer, ? super h1, ? extends R> transform) {
        f0.p(mapIndexed, "$this$mapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(i1.r(mapIndexed));
        int iR = i1.r(mapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            arrayList.add(transform.r0(Integer.valueOf(i11), h1.d(i1.p(mapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final l1 C6(@k int[] maxOrNull) {
        f0.p(maxOrNull, "$this$maxOrNull");
        if (m1.u(maxOrNull)) {
            return null;
        }
        int iP = m1.p(maxOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOrNull)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(maxOrNull, it2.b());
            if (Integer.compare(iP ^ Integer.MIN_VALUE, iP2 ^ Integer.MIN_VALUE) < 0) {
                iP = iP2;
            }
        }
        return l1.d(iP);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R C7(long[] minOfWithOrNull, Comparator<? super R> comparator, ik.l<? super p1, ? extends R> selector) {
        f0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (q1.u(minOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(p1.d(q1.p(minOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(minOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long C8(long[] random) {
        f0.p(random, "$this$random");
        return B8(random, Random.f38003a);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> C9(@k int[] reversed) {
        f0.p(reversed, "$this$reversed");
        if (m1.u(reversed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<l1> listT5 = CollectionsKt___CollectionsKt.T5(m1.b(reversed));
        z.m1(listT5);
        return listT5;
    }

    @s
    @v0(version = "1.3")
    @l
    public static final p1 Ca(@k long[] singleOrNull) {
        f0.p(singleOrNull, "$this$singleOrNull");
        if (q1.r(singleOrNull) == 1) {
            return p1.d(q1.p(singleOrNull, 0));
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> Cb(@k int[] sortedDescending) {
        f0.p(sortedDescending, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrE = m1.e(iArrCopyOf);
        Wa(iArrE);
        return C9(iArrE);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> Cc(byte[] takeWhile, ik.l<? super h1, Boolean> predicate) {
        f0.p(takeWhile, "$this$takeWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(takeWhile);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(takeWhile, i10);
            if (!predicate.i(h1.d(bP)).booleanValue()) {
                break;
            }
            arrayList.add(h1.d(bP));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte D0(byte[] component2) {
        f0.p(component2, "$this$component2");
        return i1.p(component2, 1);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] D1(int[] copyOf, int i10) {
        f0.p(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, i10);
        f0.o(iArrCopyOf, "copyOf(this, newSize)");
        return m1.e(iArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super v1>> C D2(short[] filterIndexedTo, C destination, p<? super Integer, ? super v1, Boolean> predicate) {
        f0.p(filterIndexedTo, "$this$filterIndexedTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = w1.r(filterIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            short sP = w1.p(filterIndexedTo, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), v1.d(sP)).booleanValue()) {
                destination.add(v1.d(sP));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C D3(short[] flatMapTo, C destination, ik.l<? super v1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapTo, "$this$flatMapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = w1.r(flatMapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(destination, transform.i(v1.d(w1.p(flatMapTo, i10))));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, V> Map<K, List<V>> D4(short[] groupBy, ik.l<? super v1, ? extends K> keySelector, ik.l<? super v1, ? extends V> valueTransform) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = w1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(groupBy, i10);
            K kI = keySelector.i(v1.d(sP));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(v1.d(sP)));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> D5(int[] mapIndexed, p<? super Integer, ? super l1, ? extends R> transform) {
        f0.p(mapIndexed, "$this$mapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(m1.r(mapIndexed));
        int iR = m1.r(mapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            arrayList.add(transform.r0(Integer.valueOf(i11), l1.d(m1.p(mapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final h1 D6(@k byte[] maxOrNull) {
        f0.p(maxOrNull, "$this$maxOrNull");
        if (i1.u(maxOrNull)) {
            return null;
        }
        byte bP = i1.p(maxOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOrNull)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(maxOrNull, it2.b());
            if (f0.t(bP & 255, bP2 & 255) < 0) {
                bP = bP2;
            }
        }
        return h1.d(bP);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R D7(byte[] minOfWithOrNull, Comparator<? super R> comparator, ik.l<? super h1, ? extends R> selector) {
        f0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (i1.u(minOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(h1.d(i1.p(minOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(minOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @s
    @v0(version = "1.3")
    public static final byte D8(@k byte[] random, @k Random random2) {
        f0.p(random, "$this$random");
        f0.p(random2, "random");
        if (i1.u(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return i1.p(random, random2.p(i1.r(random)));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> D9(@k byte[] reversed) {
        f0.p(reversed, "$this$reversed");
        if (i1.u(reversed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<h1> listT5 = CollectionsKt___CollectionsKt.T5(i1.b(reversed));
        z.m1(listT5);
        return listT5;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final l1 Da(int[] singleOrNull, ik.l<? super l1, Boolean> predicate) {
        f0.p(singleOrNull, "$this$singleOrNull");
        f0.p(predicate, "predicate");
        int iR = m1.r(singleOrNull);
        l1 l1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(singleOrNull, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                if (z10) {
                    return null;
                }
                l1VarD = l1.d(iP);
                z10 = true;
            }
        }
        if (z10) {
            return l1VarD;
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> Db(@k byte[] sortedDescending) {
        f0.p(sortedDescending, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrE = i1.e(bArrCopyOf);
        db(bArrE);
        return D9(bArrE);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> Dc(long[] takeWhile, ik.l<? super p1, Boolean> predicate) {
        f0.p(takeWhile, "$this$takeWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(takeWhile);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(takeWhile, i10);
            if (!predicate.i(p1.d(jP)).booleanValue()) {
                break;
            }
            arrayList.add(p1.d(jP));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long E0(long[] component2) {
        f0.p(component2, "$this$component2");
        return q1.p(component2, 1);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] E1(long[] copyOf, int i10) {
        f0.p(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, i10);
        f0.o(jArrCopyOf, "copyOf(this, newSize)");
        return q1.e(jArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super h1>> C E2(byte[] filterIndexedTo, C destination, p<? super Integer, ? super h1, Boolean> predicate) {
        f0.p(filterIndexedTo, "$this$filterIndexedTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = i1.r(filterIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            byte bP = i1.p(filterIndexedTo, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), h1.d(bP)).booleanValue()) {
                destination.add(h1.d(bP));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C E3(int[] flatMapTo, C destination, ik.l<? super l1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapTo, "$this$flatMapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = m1.r(flatMapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(destination, transform.i(l1.d(m1.p(flatMapTo, i10))));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K> Map<K, List<h1>> E4(byte[] groupBy, ik.l<? super h1, ? extends K> keySelector) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = i1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(groupBy, i10);
            K kI = keySelector.i(h1.d(bP));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(h1.d(bP));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> E5(long[] mapIndexed, p<? super Integer, ? super p1, ? extends R> transform) {
        f0.p(mapIndexed, "$this$mapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(q1.r(mapIndexed));
        int iR = q1.r(mapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            arrayList.add(transform.r0(Integer.valueOf(i11), p1.d(q1.p(mapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final p1 E6(@k long[] maxOrNull) {
        f0.p(maxOrNull, "$this$maxOrNull");
        if (q1.u(maxOrNull)) {
            return null;
        }
        long jP = q1.p(maxOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOrNull)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(maxOrNull, it2.b());
            if (Long.compare(jP ^ Long.MIN_VALUE, jP2 ^ Long.MIN_VALUE) < 0) {
                jP = jP2;
            }
        }
        return p1.d(jP);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R E7(short[] minOfWithOrNull, Comparator<? super R> comparator, ik.l<? super v1, ? extends R> selector) {
        f0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (w1.u(minOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(v1.d(w1.p(minOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(minOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short E8(short[] random) {
        f0.p(random, "$this$random");
        return F8(random, Random.f38003a);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> E9(@k long[] reversed) {
        f0.p(reversed, "$this$reversed");
        if (q1.u(reversed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<p1> listT5 = CollectionsKt___CollectionsKt.T5(q1.b(reversed));
        z.m1(listT5);
        return listT5;
    }

    @s
    @v0(version = "1.3")
    @l
    public static final v1 Ea(@k short[] singleOrNull) {
        f0.p(singleOrNull, "$this$singleOrNull");
        if (w1.r(singleOrNull) == 1) {
            return v1.d(w1.p(singleOrNull, 0));
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> Eb(@k long[] sortedDescending) {
        f0.p(sortedDescending, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrE = q1.e(jArrCopyOf);
        eb(jArrE);
        return E9(jArrE);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> Ec(int[] takeWhile, ik.l<? super l1, Boolean> predicate) {
        f0.p(takeWhile, "$this$takeWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(takeWhile);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(takeWhile, i10);
            if (!predicate.i(l1.d(iP)).booleanValue()) {
                break;
            }
            arrayList.add(l1.d(iP));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short F0(short[] component2) {
        f0.p(component2, "$this$component2");
        return w1.p(component2, 1);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] F1(short[] copyOf) {
        f0.p(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        return w1.e(sArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super p1>> C F2(long[] filterIndexedTo, C destination, p<? super Integer, ? super p1, Boolean> predicate) {
        f0.p(filterIndexedTo, "$this$filterIndexedTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = q1.r(filterIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            long jP = q1.p(filterIndexedTo, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), p1.d(jP)).booleanValue()) {
                destination.add(p1.d(jP));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C F3(byte[] flatMapTo, C destination, ik.l<? super h1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapTo, "$this$flatMapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = i1.r(flatMapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(destination, transform.i(h1.d(i1.p(flatMapTo, i10))));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, V> Map<K, List<V>> F4(int[] groupBy, ik.l<? super l1, ? extends K> keySelector, ik.l<? super l1, ? extends V> valueTransform) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = m1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(groupBy, i10);
            K kI = keySelector.i(l1.d(iP));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(l1.d(iP)));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> F5(short[] mapIndexed, p<? super Integer, ? super v1, ? extends R> transform) {
        f0.p(mapIndexed, "$this$mapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(w1.r(mapIndexed));
        int iR = w1.r(mapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            arrayList.add(transform.r0(Integer.valueOf(i11), v1.d(w1.p(mapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final v1 F6(@k short[] maxOrNull) {
        f0.p(maxOrNull, "$this$maxOrNull");
        if (w1.u(maxOrNull)) {
            return null;
        }
        short sP = w1.p(maxOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOrNull)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(maxOrNull, it2.b());
            if (f0.t(sP & v1.f38215d, 65535 & sP2) < 0) {
                sP = sP2;
            }
        }
        return v1.d(sP);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R F7(int[] minOfWithOrNull, Comparator<? super R> comparator, ik.l<? super l1, ? extends R> selector) {
        f0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (m1.u(minOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(l1.d(m1.p(minOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(minOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @s
    @v0(version = "1.3")
    public static final short F8(@k short[] random, @k Random random2) {
        f0.p(random, "$this$random");
        f0.p(random2, "random");
        if (w1.u(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return w1.p(random, random2.p(w1.r(random)));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> F9(@k short[] reversed) {
        f0.p(reversed, "$this$reversed");
        if (w1.u(reversed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<v1> listT5 = CollectionsKt___CollectionsKt.T5(w1.b(reversed));
        z.m1(listT5);
        return listT5;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final v1 Fa(short[] singleOrNull, ik.l<? super v1, Boolean> predicate) {
        f0.p(singleOrNull, "$this$singleOrNull");
        f0.p(predicate, "predicate");
        int iR = w1.r(singleOrNull);
        v1 v1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(singleOrNull, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                if (z10) {
                    return null;
                }
                v1VarD = v1.d(sP);
                z10 = true;
            }
        }
        if (z10) {
            return v1VarD;
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> Fb(@k short[] sortedDescending) {
        f0.p(sortedDescending, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrE = w1.e(sArrCopyOf);
        hb(sArrE);
        return F9(sArrE);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> Fc(short[] takeWhile, ik.l<? super v1, Boolean> predicate) {
        f0.p(takeWhile, "$this$takeWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(takeWhile);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(takeWhile, i10);
            if (!predicate.i(v1.d(sP)).booleanValue()) {
                break;
            }
            arrayList.add(v1.d(sP));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int G0(int[] component3) {
        f0.p(component3, "$this$component3");
        return m1.p(component3, 2);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] G1(long[] copyOfRange, int i10, int i11) {
        f0.p(copyOfRange, "$this$copyOfRange");
        return q1.e(kotlin.collections.m.L1(copyOfRange, i10, i11));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> G2(byte[] filterNot, ik.l<? super h1, Boolean> predicate) {
        f0.p(filterNot, "$this$filterNot");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(filterNot);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(filterNot, i10);
            if (!predicate.i(h1.d(bP)).booleanValue()) {
                arrayList.add(h1.d(bP));
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R G3(long[] fold, R r10, p<? super R, ? super p1, ? extends R> operation) {
        f0.p(fold, "$this$fold");
        f0.p(operation, "operation");
        int iR = q1.r(fold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, p1.d(q1.p(fold, i10)));
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K> Map<K, List<p1>> G4(long[] groupBy, ik.l<? super p1, ? extends K> keySelector) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = q1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(groupBy, i10);
            K kI = keySelector.i(p1.d(jP));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(p1.d(jP));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C G5(int[] mapIndexedTo, C destination, p<? super Integer, ? super l1, ? extends R> transform) {
        f0.p(mapIndexedTo, "$this$mapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = m1.r(mapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            destination.add(transform.r0(Integer.valueOf(i11), l1.d(m1.p(mapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @h(name = "maxOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final byte G6(@k byte[] max) {
        f0.p(max, "$this$max");
        if (i1.u(max)) {
            throw new NoSuchElementException();
        }
        byte bP = i1.p(max, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(max)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(max, it2.b());
            if (f0.t(bP & 255, bP2 & 255) < 0) {
                bP = bP2;
            }
        }
        return bP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final l1 G7(@k int[] minOrNull) {
        f0.p(minOrNull, "$this$minOrNull");
        if (m1.u(minOrNull)) {
            return null;
        }
        int iP = m1.p(minOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOrNull)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(minOrNull, it2.b());
            if (Integer.compare(iP ^ Integer.MIN_VALUE, iP2 ^ Integer.MIN_VALUE) > 0) {
                iP = iP2;
            }
        }
        return l1.d(iP);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final l1 G8(int[] randomOrNull) {
        f0.p(randomOrNull, "$this$randomOrNull");
        return H8(randomOrNull, Random.f38003a);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] G9(int[] reversedArray) {
        f0.p(reversedArray, "$this$reversedArray");
        return m1.e(ArraysKt___ArraysKt.Vr(reversedArray));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> Ga(@k long[] slice, @k Iterable<Integer> indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(p1.d(q1.p(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int Gb(int[] sum) {
        f0.p(sum, "$this$sum");
        return l1.j(ArraysKt___ArraysKt.Aw(sum));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] Gc(byte[] toByteArray) {
        f0.p(toByteArray, "$this$toByteArray");
        byte[] bArrCopyOf = Arrays.copyOf(toByteArray, toByteArray.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte H0(byte[] component3) {
        f0.p(component3, "$this$component3");
        return i1.p(component3, 2);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] H1(byte[] copyOfRange, int i10, int i11) {
        f0.p(copyOfRange, "$this$copyOfRange");
        return i1.e(kotlin.collections.m.G1(copyOfRange, i10, i11));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> H2(long[] filterNot, ik.l<? super p1, Boolean> predicate) {
        f0.p(filterNot, "$this$filterNot");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(filterNot);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(filterNot, i10);
            if (!predicate.i(p1.d(jP)).booleanValue()) {
                arrayList.add(p1.d(jP));
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R H3(byte[] fold, R r10, p<? super R, ? super h1, ? extends R> operation) {
        f0.p(fold, "$this$fold");
        f0.p(operation, "operation");
        int iR = i1.r(fold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, h1.d(i1.p(fold, i10)));
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, V> Map<K, List<V>> H4(byte[] groupBy, ik.l<? super h1, ? extends K> keySelector, ik.l<? super h1, ? extends V> valueTransform) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = i1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(groupBy, i10);
            K kI = keySelector.i(h1.d(bP));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(h1.d(bP)));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C H5(short[] mapIndexedTo, C destination, p<? super Integer, ? super v1, ? extends R> transform) {
        f0.p(mapIndexedTo, "$this$mapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = w1.r(mapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            destination.add(transform.r0(Integer.valueOf(i11), v1.d(w1.p(mapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @h(name = "maxOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final int H6(@k int[] max) {
        f0.p(max, "$this$max");
        if (m1.u(max)) {
            throw new NoSuchElementException();
        }
        int iP = m1.p(max, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(max)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(max, it2.b());
            if (Integer.compare(iP ^ Integer.MIN_VALUE, iP2 ^ Integer.MIN_VALUE) < 0) {
                iP = iP2;
            }
        }
        return iP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final h1 H7(@k byte[] minOrNull) {
        f0.p(minOrNull, "$this$minOrNull");
        if (i1.u(minOrNull)) {
            return null;
        }
        byte bP = i1.p(minOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOrNull)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(minOrNull, it2.b());
            if (f0.t(bP & 255, bP2 & 255) > 0) {
                bP = bP2;
            }
        }
        return h1.d(bP);
    }

    @s
    @v0(version = "1.4")
    @l
    @c2(markerClass = {q.class})
    public static final l1 H8(@k int[] randomOrNull, @k Random random) {
        f0.p(randomOrNull, "$this$randomOrNull");
        f0.p(random, "random");
        if (m1.u(randomOrNull)) {
            return null;
        }
        return l1.d(m1.p(randomOrNull, random.p(m1.r(randomOrNull))));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] H9(byte[] reversedArray) {
        f0.p(reversedArray, "$this$reversedArray");
        return i1.e(ArraysKt___ArraysKt.Rr(reversedArray));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> Ha(@k int[] slice, @k Iterable<Integer> indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(l1.d(m1.p(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int Hb(byte[] sum) {
        f0.p(sum, "$this$sum");
        int iJ = l1.j(0);
        int iR = i1.r(sum);
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + l1.j(i1.p(sum, i10) & 255));
        }
        return iJ;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] Hc(int[] toIntArray) {
        f0.p(toIntArray, "$this$toIntArray");
        int[] iArrCopyOf = Arrays.copyOf(toIntArray, toIntArray.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        return iArrCopyOf;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long I0(long[] component3) {
        f0.p(component3, "$this$component3");
        return q1.p(component3, 2);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] I1(short[] copyOfRange, int i10, int i11) {
        f0.p(copyOfRange, "$this$copyOfRange");
        return w1.e(kotlin.collections.m.N1(copyOfRange, i10, i11));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> I2(int[] filterNot, ik.l<? super l1, Boolean> predicate) {
        f0.p(filterNot, "$this$filterNot");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(filterNot);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(filterNot, i10);
            if (!predicate.i(l1.d(iP)).booleanValue()) {
                arrayList.add(l1.d(iP));
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R I3(int[] fold, R r10, p<? super R, ? super l1, ? extends R> operation) {
        f0.p(fold, "$this$fold");
        f0.p(operation, "operation");
        int iR = m1.r(fold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, l1.d(m1.p(fold, i10)));
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K> Map<K, List<l1>> I4(int[] groupBy, ik.l<? super l1, ? extends K> keySelector) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = m1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(groupBy, i10);
            K kI = keySelector.i(l1.d(iP));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(l1.d(iP));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C I5(byte[] mapIndexedTo, C destination, p<? super Integer, ? super h1, ? extends R> transform) {
        f0.p(mapIndexedTo, "$this$mapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = i1.r(mapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            destination.add(transform.r0(Integer.valueOf(i11), h1.d(i1.p(mapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @h(name = "maxOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final long I6(@k long[] max) {
        f0.p(max, "$this$max");
        if (q1.u(max)) {
            throw new NoSuchElementException();
        }
        long jP = q1.p(max, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(max)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(max, it2.b());
            if (Long.compare(jP ^ Long.MIN_VALUE, jP2 ^ Long.MIN_VALUE) < 0) {
                jP = jP2;
            }
        }
        return jP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final p1 I7(@k long[] minOrNull) {
        f0.p(minOrNull, "$this$minOrNull");
        if (q1.u(minOrNull)) {
            return null;
        }
        long jP = q1.p(minOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOrNull)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(minOrNull, it2.b());
            if (Long.compare(jP ^ Long.MIN_VALUE, jP2 ^ Long.MIN_VALUE) > 0) {
                jP = jP2;
            }
        }
        return p1.d(jP);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final h1 I8(byte[] randomOrNull) {
        f0.p(randomOrNull, "$this$randomOrNull");
        return L8(randomOrNull, Random.f38003a);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] I9(long[] reversedArray) {
        f0.p(reversedArray, "$this$reversedArray");
        return q1.e(ArraysKt___ArraysKt.Wr(reversedArray));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> Ia(@k short[] slice, @k Iterable<Integer> indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(v1.d(w1.p(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long Ib(long[] sum) {
        f0.p(sum, "$this$sum");
        return p1.j(ArraysKt___ArraysKt.Cw(sum));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] Ic(long[] toLongArray) {
        f0.p(toLongArray, "$this$toLongArray");
        long[] jArrCopyOf = Arrays.copyOf(toLongArray, toLongArray.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        return jArrCopyOf;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short J0(short[] component3) {
        f0.p(component3, "$this$component3");
        return w1.p(component3, 2);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] J1(int[] copyOfRange, int i10, int i11) {
        f0.p(copyOfRange, "$this$copyOfRange");
        return m1.e(kotlin.collections.m.K1(copyOfRange, i10, i11));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> J2(short[] filterNot, ik.l<? super v1, Boolean> predicate) {
        f0.p(filterNot, "$this$filterNot");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(filterNot);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(filterNot, i10);
            if (!predicate.i(v1.d(sP)).booleanValue()) {
                arrayList.add(v1.d(sP));
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R J3(short[] fold, R r10, p<? super R, ? super v1, ? extends R> operation) {
        f0.p(fold, "$this$fold");
        f0.p(operation, "operation");
        int iR = w1.r(fold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, v1.d(w1.p(fold, i10)));
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K> Map<K, List<v1>> J4(short[] groupBy, ik.l<? super v1, ? extends K> keySelector) {
        f0.p(groupBy, "$this$groupBy");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iR = w1.r(groupBy);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(groupBy, i10);
            K kI = keySelector.i(v1.d(sP));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(v1.d(sP));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C J5(long[] mapIndexedTo, C destination, p<? super Integer, ? super p1, ? extends R> transform) {
        f0.p(mapIndexedTo, "$this$mapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = q1.r(mapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            destination.add(transform.r0(Integer.valueOf(i11), p1.d(q1.p(mapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @h(name = "maxOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final short J6(@k short[] max) {
        f0.p(max, "$this$max");
        if (w1.u(max)) {
            throw new NoSuchElementException();
        }
        short sP = w1.p(max, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(max)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(max, it2.b());
            if (f0.t(sP & v1.f38215d, 65535 & sP2) < 0) {
                sP = sP2;
            }
        }
        return sP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final v1 J7(@k short[] minOrNull) {
        f0.p(minOrNull, "$this$minOrNull");
        if (w1.u(minOrNull)) {
            return null;
        }
        short sP = w1.p(minOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOrNull)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(minOrNull, it2.b());
            if (f0.t(sP & v1.f38215d, 65535 & sP2) > 0) {
                sP = sP2;
            }
        }
        return v1.d(sP);
    }

    @s
    @v0(version = "1.4")
    @l
    @c2(markerClass = {q.class})
    public static final p1 J8(@k long[] randomOrNull, @k Random random) {
        f0.p(randomOrNull, "$this$randomOrNull");
        f0.p(random, "random");
        if (q1.u(randomOrNull)) {
            return null;
        }
        return p1.d(q1.p(randomOrNull, random.p(q1.r(randomOrNull))));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] J9(short[] reversedArray) {
        f0.p(reversedArray, "$this$reversedArray");
        return w1.e(ArraysKt___ArraysKt.Yr(reversedArray));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> Ja(@k byte[] slice, @k Iterable<Integer> indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(h1.d(i1.p(slice, it2.next().intValue())));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int Jb(short[] sum) {
        f0.p(sum, "$this$sum");
        int iJ = l1.j(0);
        int iR = w1.r(sum);
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + l1.j(w1.p(sum, i10) & v1.f38215d));
        }
        return iJ;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] Jc(short[] toShortArray) {
        f0.p(toShortArray, "$this$toShortArray");
        short[] sArrCopyOf = Arrays.copyOf(toShortArray, toShortArray.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        return sArrCopyOf;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int K0(int[] component4) {
        f0.p(component4, "$this$component4");
        return m1.p(component4, 3);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int K1(byte[] count, ik.l<? super h1, Boolean> predicate) {
        f0.p(count, "$this$count");
        f0.p(predicate, "predicate");
        int iR = i1.r(count);
        int i10 = 0;
        for (int i11 = 0; i11 < iR; i11++) {
            if (predicate.i(h1.d(i1.p(count, i11))).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super p1>> C K2(long[] filterNotTo, C destination, ik.l<? super p1, Boolean> predicate) {
        f0.p(filterNotTo, "$this$filterNotTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = q1.r(filterNotTo);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(filterNotTo, i10);
            if (!predicate.i(p1.d(jP)).booleanValue()) {
                destination.add(p1.d(jP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R K3(byte[] foldIndexed, R r10, ik.q<? super Integer, ? super R, ? super h1, ? extends R> operation) {
        f0.p(foldIndexed, "$this$foldIndexed");
        f0.p(operation, "operation");
        int iR = i1.r(foldIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, h1.d(i1.p(foldIndexed, i10)));
            i10++;
            i11++;
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, M extends Map<? super K, List<l1>>> M K4(int[] groupByTo, M destination, ik.l<? super l1, ? extends K> keySelector) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        int iR = m1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(groupByTo, i10);
            K kI = keySelector.i(l1.d(iP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(l1.d(iP));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C K5(long[] mapTo, C destination, ik.l<? super p1, ? extends R> transform) {
        f0.p(mapTo, "$this$mapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = q1.r(mapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            destination.add(transform.i(p1.d(q1.p(mapTo, i10))));
        }
        return destination;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final h1 K6(@k byte[] maxWithOrNull, @k Comparator<? super h1> comparator) {
        f0.p(maxWithOrNull, "$this$maxWithOrNull");
        f0.p(comparator, "comparator");
        if (i1.u(maxWithOrNull)) {
            return null;
        }
        byte bP = i1.p(maxWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxWithOrNull)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(maxWithOrNull, it2.b());
            if (comparator.compare(h1.d(bP), h1.d(bP2)) < 0) {
                bP = bP2;
            }
        }
        return h1.d(bP);
    }

    @h(name = "minOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final byte K7(@k byte[] min) {
        f0.p(min, "$this$min");
        if (i1.u(min)) {
            throw new NoSuchElementException();
        }
        byte bP = i1.p(min, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(min)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(min, it2.b());
            if (f0.t(bP & 255, bP2 & 255) > 0) {
                bP = bP2;
            }
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final p1 K8(long[] randomOrNull) {
        f0.p(randomOrNull, "$this$randomOrNull");
        return J8(randomOrNull, Random.f38003a);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> K9(long[] runningFold, R r10, p<? super R, ? super p1, ? extends R> operation) {
        f0.p(runningFold, "$this$runningFold");
        f0.p(operation, "operation");
        if (q1.u(runningFold)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(q1.r(runningFold) + 1);
        arrayList.add(r10);
        int iR = q1.r(runningFold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, p1.d(q1.p(runningFold, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> Ka(@k short[] slice, @k m indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : b.d(w1.e(kotlin.collections.m.N1(slice, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final int Kb(byte[] sumBy, ik.l<? super h1, l1> selector) {
        f0.p(sumBy, "$this$sumBy");
        f0.p(selector, "selector");
        int iR = i1.r(sumBy);
        int iJ = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(h1.d(i1.p(sumBy, i10))).l0());
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final l1[] Kc(@k int[] toTypedArray) {
        f0.p(toTypedArray, "$this$toTypedArray");
        int iR = m1.r(toTypedArray);
        l1[] l1VarArr = new l1[iR];
        for (int i10 = 0; i10 < iR; i10++) {
            l1VarArr[i10] = l1.d(m1.p(toTypedArray, i10));
        }
        return l1VarArr;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte L0(byte[] component4) {
        f0.p(component4, "$this$component4");
        return i1.p(component4, 3);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int L1(long[] count, ik.l<? super p1, Boolean> predicate) {
        f0.p(count, "$this$count");
        f0.p(predicate, "predicate");
        int iR = q1.r(count);
        int i10 = 0;
        for (int i11 = 0; i11 < iR; i11++) {
            if (predicate.i(p1.d(q1.p(count, i11))).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super v1>> C L2(short[] filterNotTo, C destination, ik.l<? super v1, Boolean> predicate) {
        f0.p(filterNotTo, "$this$filterNotTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = w1.r(filterNotTo);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(filterNotTo, i10);
            if (!predicate.i(v1.d(sP)).booleanValue()) {
                destination.add(v1.d(sP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R L3(short[] foldIndexed, R r10, ik.q<? super Integer, ? super R, ? super v1, ? extends R> operation) {
        f0.p(foldIndexed, "$this$foldIndexed");
        f0.p(operation, "operation");
        int iR = w1.r(foldIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, v1.d(w1.p(foldIndexed, i10)));
            i10++;
            i11++;
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, M extends Map<? super K, List<h1>>> M L4(byte[] groupByTo, M destination, ik.l<? super h1, ? extends K> keySelector) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        int iR = i1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(groupByTo, i10);
            K kI = keySelector.i(h1.d(bP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(h1.d(bP));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C L5(short[] mapTo, C destination, ik.l<? super v1, ? extends R> transform) {
        f0.p(mapTo, "$this$mapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = w1.r(mapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            destination.add(transform.i(v1.d(w1.p(mapTo, i10))));
        }
        return destination;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final l1 L6(@k int[] maxWithOrNull, @k Comparator<? super l1> comparator) {
        f0.p(maxWithOrNull, "$this$maxWithOrNull");
        f0.p(comparator, "comparator");
        if (m1.u(maxWithOrNull)) {
            return null;
        }
        int iP = m1.p(maxWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxWithOrNull)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(maxWithOrNull, it2.b());
            if (comparator.compare(l1.d(iP), l1.d(iP2)) < 0) {
                iP = iP2;
            }
        }
        return l1.d(iP);
    }

    @h(name = "minOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final int L7(@k int[] min) {
        f0.p(min, "$this$min");
        if (m1.u(min)) {
            throw new NoSuchElementException();
        }
        int iP = m1.p(min, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(min)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(min, it2.b());
            if (Integer.compare(iP ^ Integer.MIN_VALUE, iP2 ^ Integer.MIN_VALUE) > 0) {
                iP = iP2;
            }
        }
        return iP;
    }

    @s
    @v0(version = "1.4")
    @l
    @c2(markerClass = {q.class})
    public static final h1 L8(@k byte[] randomOrNull, @k Random random) {
        f0.p(randomOrNull, "$this$randomOrNull");
        f0.p(random, "random");
        if (i1.u(randomOrNull)) {
            return null;
        }
        return h1.d(i1.p(randomOrNull, random.p(i1.r(randomOrNull))));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> L9(byte[] runningFold, R r10, p<? super R, ? super h1, ? extends R> operation) {
        f0.p(runningFold, "$this$runningFold");
        f0.p(operation, "operation");
        if (i1.u(runningFold)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(i1.r(runningFold) + 1);
        arrayList.add(r10);
        int iR = i1.r(runningFold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, h1.d(i1.p(runningFold, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> La(@k long[] slice, @k m indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : b.c(q1.e(kotlin.collections.m.L1(slice, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final int Lb(long[] sumBy, ik.l<? super p1, l1> selector) {
        f0.p(sumBy, "$this$sumBy");
        f0.p(selector, "selector");
        int iR = q1.r(sumBy);
        int iJ = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(p1.d(q1.p(sumBy, i10))).l0());
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final h1[] Lc(@k byte[] toTypedArray) {
        f0.p(toTypedArray, "$this$toTypedArray");
        int iR = i1.r(toTypedArray);
        h1[] h1VarArr = new h1[iR];
        for (int i10 = 0; i10 < iR; i10++) {
            h1VarArr[i10] = h1.d(i1.p(toTypedArray, i10));
        }
        return h1VarArr;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long M0(long[] component4) {
        f0.p(component4, "$this$component4");
        return q1.p(component4, 3);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int M1(int[] count, ik.l<? super l1, Boolean> predicate) {
        f0.p(count, "$this$count");
        f0.p(predicate, "predicate");
        int iR = m1.r(count);
        int i10 = 0;
        for (int i11 = 0; i11 < iR; i11++) {
            if (predicate.i(l1.d(m1.p(count, i11))).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super l1>> C M2(int[] filterNotTo, C destination, ik.l<? super l1, Boolean> predicate) {
        f0.p(filterNotTo, "$this$filterNotTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = m1.r(filterNotTo);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(filterNotTo, i10);
            if (!predicate.i(l1.d(iP)).booleanValue()) {
                destination.add(l1.d(iP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R M3(long[] foldIndexed, R r10, ik.q<? super Integer, ? super R, ? super p1, ? extends R> operation) {
        f0.p(foldIndexed, "$this$foldIndexed");
        f0.p(operation, "operation");
        int iR = q1.r(foldIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, p1.d(q1.p(foldIndexed, i10)));
            i10++;
            i11++;
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s
    @v0(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M M4(int[] groupByTo, M destination, ik.l<? super l1, ? extends K> keySelector, ik.l<? super l1, ? extends V> valueTransform) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        int iR = m1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(groupByTo, i10);
            K kI = keySelector.i(l1.d(iP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(l1.d(iP)));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C M5(int[] mapTo, C destination, ik.l<? super l1, ? extends R> transform) {
        f0.p(mapTo, "$this$mapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = m1.r(mapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            destination.add(transform.i(l1.d(m1.p(mapTo, i10))));
        }
        return destination;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final v1 M6(@k short[] maxWithOrNull, @k Comparator<? super v1> comparator) {
        f0.p(maxWithOrNull, "$this$maxWithOrNull");
        f0.p(comparator, "comparator");
        if (w1.u(maxWithOrNull)) {
            return null;
        }
        short sP = w1.p(maxWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxWithOrNull)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(maxWithOrNull, it2.b());
            if (comparator.compare(v1.d(sP), v1.d(sP2)) < 0) {
                sP = sP2;
            }
        }
        return v1.d(sP);
    }

    @h(name = "minOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final long M7(@k long[] min) {
        f0.p(min, "$this$min");
        if (q1.u(min)) {
            throw new NoSuchElementException();
        }
        long jP = q1.p(min, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(min)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(min, it2.b());
            if (Long.compare(jP ^ Long.MIN_VALUE, jP2 ^ Long.MIN_VALUE) > 0) {
                jP = jP2;
            }
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final v1 M8(short[] randomOrNull) {
        f0.p(randomOrNull, "$this$randomOrNull");
        return N8(randomOrNull, Random.f38003a);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> M9(int[] runningFold, R r10, p<? super R, ? super l1, ? extends R> operation) {
        f0.p(runningFold, "$this$runningFold");
        f0.p(operation, "operation");
        if (m1.u(runningFold)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(m1.r(runningFold) + 1);
        arrayList.add(r10);
        int iR = m1.r(runningFold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, l1.d(m1.p(runningFold, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> Ma(@k byte[] slice, @k m indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : b.b(i1.e(kotlin.collections.m.G1(slice, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final int Mb(int[] sumBy, ik.l<? super l1, l1> selector) {
        f0.p(sumBy, "$this$sumBy");
        f0.p(selector, "selector");
        int iR = m1.r(sumBy);
        int iJ = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(l1.d(m1.p(sumBy, i10))).l0());
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final p1[] Mc(@k long[] toTypedArray) {
        f0.p(toTypedArray, "$this$toTypedArray");
        int iR = q1.r(toTypedArray);
        p1[] p1VarArr = new p1[iR];
        for (int i10 = 0; i10 < iR; i10++) {
            p1VarArr[i10] = p1.d(q1.p(toTypedArray, i10));
        }
        return p1VarArr;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short N0(short[] component4) {
        f0.p(component4, "$this$component4");
        return w1.p(component4, 3);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int N1(short[] count, ik.l<? super v1, Boolean> predicate) {
        f0.p(count, "$this$count");
        f0.p(predicate, "predicate");
        int iR = w1.r(count);
        int i10 = 0;
        for (int i11 = 0; i11 < iR; i11++) {
            if (predicate.i(v1.d(w1.p(count, i11))).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super h1>> C N2(byte[] filterNotTo, C destination, ik.l<? super h1, Boolean> predicate) {
        f0.p(filterNotTo, "$this$filterNotTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = i1.r(filterNotTo);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(filterNotTo, i10);
            if (!predicate.i(h1.d(bP)).booleanValue()) {
                destination.add(h1.d(bP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R N3(int[] foldIndexed, R r10, ik.q<? super Integer, ? super R, ? super l1, ? extends R> operation) {
        f0.p(foldIndexed, "$this$foldIndexed");
        f0.p(operation, "operation");
        int iR = m1.r(foldIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, l1.d(m1.p(foldIndexed, i10)));
            i10++;
            i11++;
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s
    @v0(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M N4(long[] groupByTo, M destination, ik.l<? super p1, ? extends K> keySelector, ik.l<? super p1, ? extends V> valueTransform) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        int iR = q1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(groupByTo, i10);
            K kI = keySelector.i(p1.d(jP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(p1.d(jP)));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, C extends Collection<? super R>> C N5(byte[] mapTo, C destination, ik.l<? super h1, ? extends R> transform) {
        f0.p(mapTo, "$this$mapTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = i1.r(mapTo);
        for (int i10 = 0; i10 < iR; i10++) {
            destination.add(transform.i(h1.d(i1.p(mapTo, i10))));
        }
        return destination;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final p1 N6(@k long[] maxWithOrNull, @k Comparator<? super p1> comparator) {
        f0.p(maxWithOrNull, "$this$maxWithOrNull");
        f0.p(comparator, "comparator");
        if (q1.u(maxWithOrNull)) {
            return null;
        }
        long jP = q1.p(maxWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxWithOrNull)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(maxWithOrNull, it2.b());
            if (comparator.compare(p1.d(jP), p1.d(jP2)) < 0) {
                jP = jP2;
            }
        }
        return p1.d(jP);
    }

    @h(name = "minOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final short N7(@k short[] min) {
        f0.p(min, "$this$min");
        if (w1.u(min)) {
            throw new NoSuchElementException();
        }
        short sP = w1.p(min, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(min)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(min, it2.b());
            if (f0.t(sP & v1.f38215d, 65535 & sP2) > 0) {
                sP = sP2;
            }
        }
        return sP;
    }

    @s
    @v0(version = "1.4")
    @l
    @c2(markerClass = {q.class})
    public static final v1 N8(@k short[] randomOrNull, @k Random random) {
        f0.p(randomOrNull, "$this$randomOrNull");
        f0.p(random, "random");
        if (w1.u(randomOrNull)) {
            return null;
        }
        return v1.d(w1.p(randomOrNull, random.p(w1.r(randomOrNull))));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> N9(short[] runningFold, R r10, p<? super R, ? super v1, ? extends R> operation) {
        f0.p(runningFold, "$this$runningFold");
        f0.p(operation, "operation");
        if (w1.u(runningFold)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(w1.r(runningFold) + 1);
        arrayList.add(r10);
        int iR = w1.r(runningFold);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, v1.d(w1.p(runningFold, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> Na(@k int[] slice, @k m indices) {
        f0.p(slice, "$this$slice");
        f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : b.a(m1.e(kotlin.collections.m.K1(slice, indices.a().intValue(), indices.e().intValue() + 1)));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final int Nb(short[] sumBy, ik.l<? super v1, l1> selector) {
        f0.p(sumBy, "$this$sumBy");
        f0.p(selector, "selector");
        int iR = w1.r(sumBy);
        int iJ = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(v1.d(w1.p(sumBy, i10))).l0());
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final v1[] Nc(@k short[] toTypedArray) {
        f0.p(toTypedArray, "$this$toTypedArray");
        int iR = w1.r(toTypedArray);
        v1[] v1VarArr = new v1[iR];
        for (int i10 = 0; i10 < iR; i10++) {
            v1VarArr[i10] = v1.d(w1.p(toTypedArray, i10));
        }
        return v1VarArr;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int O0(int[] component5) {
        f0.p(component5, "$this$component5");
        return m1.p(component5, 4);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> O1(@k byte[] drop, int i10) {
        f0.p(drop, "$this$drop");
        if (i10 >= 0) {
            return uc(drop, v.u(i1.r(drop) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super p1>> C O2(long[] filterTo, C destination, ik.l<? super p1, Boolean> predicate) {
        f0.p(filterTo, "$this$filterTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = q1.r(filterTo);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(filterTo, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                destination.add(p1.d(jP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R O3(long[] foldRight, R r10, p<? super p1, ? super R, ? extends R> operation) {
        f0.p(foldRight, "$this$foldRight");
        f0.p(operation, "operation");
        for (int iWe = ArraysKt___ArraysKt.We(foldRight); iWe >= 0; iWe--) {
            r10 = operation.r0(p1.d(q1.p(foldRight, iWe)), r10);
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, M extends Map<? super K, List<p1>>> M O4(long[] groupByTo, M destination, ik.l<? super p1, ? extends K> keySelector) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        int iR = q1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(groupByTo, i10);
            K kI = keySelector.i(p1.d(jP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(p1.d(jP));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> h1 O5(byte[] maxByOrNull, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxByOrNull, "$this$maxByOrNull");
        f0.p(selector, "selector");
        if (i1.u(maxByOrNull)) {
            return null;
        }
        byte bP = i1.p(maxByOrNull, 0);
        int iRe = ArraysKt___ArraysKt.Re(maxByOrNull);
        if (iRe == 0) {
            return h1.d(bP);
        }
        R rI = selector.i(h1.d(bP));
        k0 it2 = new m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(maxByOrNull, it2.b());
            R rI2 = selector.i(h1.d(bP2));
            if (rI.compareTo(rI2) < 0) {
                bP = bP2;
                rI = rI2;
            }
        }
        return h1.d(bP);
    }

    @h(name = "maxWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final byte O6(@k byte[] maxWith, @k Comparator<? super h1> comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        if (i1.u(maxWith)) {
            throw new NoSuchElementException();
        }
        byte bP = i1.p(maxWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxWith)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(maxWith, it2.b());
            if (comparator.compare(h1.d(bP), h1.d(bP2)) < 0) {
                bP = bP2;
            }
        }
        return bP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final h1 O7(@k byte[] minWithOrNull, @k Comparator<? super h1> comparator) {
        f0.p(minWithOrNull, "$this$minWithOrNull");
        f0.p(comparator, "comparator");
        if (i1.u(minWithOrNull)) {
            return null;
        }
        byte bP = i1.p(minWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minWithOrNull)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(minWithOrNull, it2.b());
            if (comparator.compare(h1.d(bP), h1.d(bP2)) > 0) {
                bP = bP2;
            }
        }
        return h1.d(bP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte O8(byte[] reduce, p<? super h1, ? super h1, h1> operation) {
        f0.p(reduce, "$this$reduce");
        f0.p(operation, "operation");
        if (i1.u(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bP = i1.p(reduce, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(reduce)).iterator();
        while (it2.hasNext()) {
            bP = operation.r0(h1.d(bP), h1.d(i1.p(reduce, it2.b()))).j0();
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> O9(byte[] runningFoldIndexed, R r10, ik.q<? super Integer, ? super R, ? super h1, ? extends R> operation) {
        f0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        f0.p(operation, "operation");
        if (i1.u(runningFoldIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(i1.r(runningFoldIndexed) + 1);
        arrayList.add(r10);
        int iR = i1.r(runningFoldIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, h1.d(i1.p(runningFoldIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final int[] Oa(@k int[] sliceArray, @k Collection<Integer> indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return m1.e(ArraysKt___ArraysKt.Eu(sliceArray, indices));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final double Ob(byte[] sumByDouble, ik.l<? super h1, Double> selector) {
        f0.p(sumByDouble, "$this$sumByDouble");
        f0.p(selector, "selector");
        int iR = i1.r(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(h1.d(i1.p(sumByDouble, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] Oc(byte[] bArr) {
        f0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        return i1.e(bArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte P0(byte[] component5) {
        f0.p(component5, "$this$component5");
        return i1.p(component5, 4);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> P1(@k short[] drop, int i10) {
        f0.p(drop, "$this$drop");
        if (i10 >= 0) {
            return vc(drop, v.u(w1.r(drop) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super v1>> C P2(short[] filterTo, C destination, ik.l<? super v1, Boolean> predicate) {
        f0.p(filterTo, "$this$filterTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = w1.r(filterTo);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(filterTo, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                destination.add(v1.d(sP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R P3(byte[] foldRight, R r10, p<? super h1, ? super R, ? extends R> operation) {
        f0.p(foldRight, "$this$foldRight");
        f0.p(operation, "operation");
        for (int iRe = ArraysKt___ArraysKt.Re(foldRight); iRe >= 0; iRe--) {
            r10 = operation.r0(h1.d(i1.p(foldRight, iRe)), r10);
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <K, M extends Map<? super K, List<v1>>> M P4(short[] groupByTo, M destination, ik.l<? super v1, ? extends K> keySelector) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        int iR = w1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(groupByTo, i10);
            K kI = keySelector.i(v1.d(sP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(v1.d(sP));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> p1 P5(long[] maxByOrNull, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxByOrNull, "$this$maxByOrNull");
        f0.p(selector, "selector");
        if (q1.u(maxByOrNull)) {
            return null;
        }
        long jP = q1.p(maxByOrNull, 0);
        int iWe = ArraysKt___ArraysKt.We(maxByOrNull);
        if (iWe == 0) {
            return p1.d(jP);
        }
        R rI = selector.i(p1.d(jP));
        k0 it2 = new m(1, iWe).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(maxByOrNull, it2.b());
            R rI2 = selector.i(p1.d(jP2));
            if (rI.compareTo(rI2) < 0) {
                jP = jP2;
                rI = rI2;
            }
        }
        return p1.d(jP);
    }

    @h(name = "maxWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final int P6(@k int[] maxWith, @k Comparator<? super l1> comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        if (m1.u(maxWith)) {
            throw new NoSuchElementException();
        }
        int iP = m1.p(maxWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxWith)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(maxWith, it2.b());
            if (comparator.compare(l1.d(iP), l1.d(iP2)) < 0) {
                iP = iP2;
            }
        }
        return iP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final l1 P7(@k int[] minWithOrNull, @k Comparator<? super l1> comparator) {
        f0.p(minWithOrNull, "$this$minWithOrNull");
        f0.p(comparator, "comparator");
        if (m1.u(minWithOrNull)) {
            return null;
        }
        int iP = m1.p(minWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minWithOrNull)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(minWithOrNull, it2.b());
            if (comparator.compare(l1.d(iP), l1.d(iP2)) > 0) {
                iP = iP2;
            }
        }
        return l1.d(iP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int P8(int[] reduce, p<? super l1, ? super l1, l1> operation) {
        f0.p(reduce, "$this$reduce");
        f0.p(operation, "operation");
        if (m1.u(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iP = m1.p(reduce, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(reduce)).iterator();
        while (it2.hasNext()) {
            iP = operation.r0(l1.d(iP), l1.d(m1.p(reduce, it2.b()))).l0();
        }
        return iP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> P9(short[] runningFoldIndexed, R r10, ik.q<? super Integer, ? super R, ? super v1, ? extends R> operation) {
        f0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        f0.p(operation, "operation");
        if (w1.u(runningFoldIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(w1.r(runningFoldIndexed) + 1);
        arrayList.add(r10);
        int iR = w1.r(runningFoldIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, v1.d(w1.p(runningFoldIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final short[] Pa(@k short[] sliceArray, @k m indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return w1.e(ArraysKt___ArraysKt.Lu(sliceArray, indices));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final double Pb(long[] sumByDouble, ik.l<? super p1, Double> selector) {
        f0.p(sumByDouble, "$this$sumByDouble");
        f0.p(selector, "selector");
        int iR = q1.r(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(p1.d(q1.p(sumByDouble, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] Pc(@k h1[] h1VarArr) {
        f0.p(h1VarArr, "<this>");
        int length = h1VarArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = h1VarArr[i10].j0();
        }
        return i1.e(bArr);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long Q0(long[] component5) {
        f0.p(component5, "$this$component5");
        return q1.p(component5, 4);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> Q1(@k int[] drop, int i10) {
        f0.p(drop, "$this$drop");
        if (i10 >= 0) {
            return wc(drop, v.u(m1.r(drop) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super l1>> C Q2(int[] filterTo, C destination, ik.l<? super l1, Boolean> predicate) {
        f0.p(filterTo, "$this$filterTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = m1.r(filterTo);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(filterTo, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                destination.add(l1.d(iP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R Q3(int[] foldRight, R r10, p<? super l1, ? super R, ? extends R> operation) {
        f0.p(foldRight, "$this$foldRight");
        f0.p(operation, "operation");
        for (int iVe = ArraysKt___ArraysKt.Ve(foldRight); iVe >= 0; iVe--) {
            r10 = operation.r0(l1.d(m1.p(foldRight, iVe)), r10);
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s
    @v0(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M Q4(short[] groupByTo, M destination, ik.l<? super v1, ? extends K> keySelector, ik.l<? super v1, ? extends V> valueTransform) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        int iR = w1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(groupByTo, i10);
            K kI = keySelector.i(v1.d(sP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(v1.d(sP)));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> l1 Q5(int[] maxByOrNull, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxByOrNull, "$this$maxByOrNull");
        f0.p(selector, "selector");
        if (m1.u(maxByOrNull)) {
            return null;
        }
        int iP = m1.p(maxByOrNull, 0);
        int iVe = ArraysKt___ArraysKt.Ve(maxByOrNull);
        if (iVe == 0) {
            return l1.d(iP);
        }
        R rI = selector.i(l1.d(iP));
        k0 it2 = new m(1, iVe).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(maxByOrNull, it2.b());
            R rI2 = selector.i(l1.d(iP2));
            if (rI.compareTo(rI2) < 0) {
                iP = iP2;
                rI = rI2;
            }
        }
        return l1.d(iP);
    }

    @h(name = "maxWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final long Q6(@k long[] maxWith, @k Comparator<? super p1> comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        if (q1.u(maxWith)) {
            throw new NoSuchElementException();
        }
        long jP = q1.p(maxWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxWith)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(maxWith, it2.b());
            if (comparator.compare(p1.d(jP), p1.d(jP2)) < 0) {
                jP = jP2;
            }
        }
        return jP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final v1 Q7(@k short[] minWithOrNull, @k Comparator<? super v1> comparator) {
        f0.p(minWithOrNull, "$this$minWithOrNull");
        f0.p(comparator, "comparator");
        if (w1.u(minWithOrNull)) {
            return null;
        }
        short sP = w1.p(minWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minWithOrNull)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(minWithOrNull, it2.b());
            if (comparator.compare(v1.d(sP), v1.d(sP2)) > 0) {
                sP = sP2;
            }
        }
        return v1.d(sP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long Q8(long[] reduce, p<? super p1, ? super p1, p1> operation) {
        f0.p(reduce, "$this$reduce");
        f0.p(operation, "operation");
        if (q1.u(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jP = q1.p(reduce, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(reduce)).iterator();
        while (it2.hasNext()) {
            jP = operation.r0(p1.d(jP), p1.d(q1.p(reduce, it2.b()))).l0();
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> Q9(long[] runningFoldIndexed, R r10, ik.q<? super Integer, ? super R, ? super p1, ? extends R> operation) {
        f0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        f0.p(operation, "operation");
        if (q1.u(runningFoldIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(q1.r(runningFoldIndexed) + 1);
        arrayList.add(r10);
        int iR = q1.r(runningFoldIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, p1.d(q1.p(runningFoldIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final long[] Qa(@k long[] sliceArray, @k m indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return q1.e(ArraysKt___ArraysKt.Hu(sliceArray, indices));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final double Qb(int[] sumByDouble, ik.l<? super l1, Double> selector) {
        f0.p(sumByDouble, "$this$sumByDouble");
        f0.p(selector, "selector");
        int iR = m1.r(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(l1.d(m1.p(sumByDouble, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] Qc(int[] iArr) {
        f0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        return m1.e(iArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short R0(short[] component5) {
        f0.p(component5, "$this$component5");
        return w1.p(component5, 4);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> R1(@k long[] drop, int i10) {
        f0.p(drop, "$this$drop");
        if (i10 >= 0) {
            return xc(drop, v.u(q1.r(drop) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <C extends Collection<? super h1>> C R2(byte[] filterTo, C destination, ik.l<? super h1, Boolean> predicate) {
        f0.p(filterTo, "$this$filterTo");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int iR = i1.r(filterTo);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(filterTo, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                destination.add(h1.d(bP));
            }
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R R3(short[] foldRight, R r10, p<? super v1, ? super R, ? extends R> operation) {
        f0.p(foldRight, "$this$foldRight");
        f0.p(operation, "operation");
        for (int iYe = ArraysKt___ArraysKt.Ye(foldRight); iYe >= 0; iYe--) {
            r10 = operation.r0(v1.d(w1.p(foldRight, iYe)), r10);
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    @s
    @v0(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M R4(byte[] groupByTo, M destination, ik.l<? super h1, ? extends K> keySelector, ik.l<? super h1, ? extends V> valueTransform) {
        f0.p(groupByTo, "$this$groupByTo");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        int iR = i1.r(groupByTo);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(groupByTo, i10);
            K kI = keySelector.i(h1.d(bP));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(h1.d(bP)));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> v1 R5(short[] maxByOrNull, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxByOrNull, "$this$maxByOrNull");
        f0.p(selector, "selector");
        if (w1.u(maxByOrNull)) {
            return null;
        }
        short sP = w1.p(maxByOrNull, 0);
        int iYe = ArraysKt___ArraysKt.Ye(maxByOrNull);
        if (iYe == 0) {
            return v1.d(sP);
        }
        R rI = selector.i(v1.d(sP));
        k0 it2 = new m(1, iYe).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(maxByOrNull, it2.b());
            R rI2 = selector.i(v1.d(sP2));
            if (rI.compareTo(rI2) < 0) {
                sP = sP2;
                rI = rI2;
            }
        }
        return v1.d(sP);
    }

    @h(name = "maxWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final short R6(@k short[] maxWith, @k Comparator<? super v1> comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        if (w1.u(maxWith)) {
            throw new NoSuchElementException();
        }
        short sP = w1.p(maxWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxWith)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(maxWith, it2.b());
            if (comparator.compare(v1.d(sP), v1.d(sP2)) < 0) {
                sP = sP2;
            }
        }
        return sP;
    }

    @s
    @v0(version = "1.4")
    @l
    public static final p1 R7(@k long[] minWithOrNull, @k Comparator<? super p1> comparator) {
        f0.p(minWithOrNull, "$this$minWithOrNull");
        f0.p(comparator, "comparator");
        if (q1.u(minWithOrNull)) {
            return null;
        }
        long jP = q1.p(minWithOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minWithOrNull)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(minWithOrNull, it2.b());
            if (comparator.compare(p1.d(jP), p1.d(jP2)) > 0) {
                jP = jP2;
            }
        }
        return p1.d(jP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short R8(short[] reduce, p<? super v1, ? super v1, v1> operation) {
        f0.p(reduce, "$this$reduce");
        f0.p(operation, "operation");
        if (w1.u(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sP = w1.p(reduce, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(reduce)).iterator();
        while (it2.hasNext()) {
            sP = operation.r0(v1.d(sP), v1.d(w1.p(reduce, it2.b()))).j0();
        }
        return sP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> R9(int[] runningFoldIndexed, R r10, ik.q<? super Integer, ? super R, ? super l1, ? extends R> operation) {
        f0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        f0.p(operation, "operation");
        if (m1.u(runningFoldIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(m1.r(runningFoldIndexed) + 1);
        arrayList.add(r10);
        int iR = m1.r(runningFoldIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, l1.d(m1.p(runningFoldIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] Ra(@k byte[] sliceArray, @k m indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return i1.e(ArraysKt___ArraysKt.xu(sliceArray, indices));
    }

    @f
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @kotlin.l(warningSince = "1.5")
    public static final double Rb(short[] sumByDouble, ik.l<? super v1, Double> selector) {
        f0.p(sumByDouble, "$this$sumByDouble");
        f0.p(selector, "selector");
        int iR = w1.r(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(v1.d(w1.p(sumByDouble, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final int[] Rc(@k l1[] l1VarArr) {
        f0.p(l1VarArr, "<this>");
        int length = l1VarArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = l1VarArr[i10].l0();
        }
        return m1.e(iArr);
    }

    @s
    @v0(version = "1.4")
    public static final boolean S0(@l short[] sArr, @l short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> S1(@k byte[] dropLast, int i10) {
        f0.p(dropLast, "$this$dropLast");
        if (i10 >= 0) {
            return qc(dropLast, v.u(i1.r(dropLast) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final h1 S2(byte[] find, ik.l<? super h1, Boolean> predicate) {
        f0.p(find, "$this$find");
        f0.p(predicate, "predicate");
        int iR = i1.r(find);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(find, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                return h1.d(bP);
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R S3(byte[] foldRightIndexed, R r10, ik.q<? super Integer, ? super h1, ? super R, ? extends R> operation) {
        f0.p(foldRightIndexed, "$this$foldRightIndexed");
        f0.p(operation, "operation");
        for (int iRe = ArraysKt___ArraysKt.Re(foldRightIndexed); iRe >= 0; iRe--) {
            r10 = operation.A(Integer.valueOf(iRe), h1.d(i1.p(foldRightIndexed, iRe)), r10);
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int S4(long[] indexOf, long j10) {
        f0.p(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.ig(indexOf, j10);
    }

    @h(name = "maxByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> byte S5(byte[] maxBy, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (i1.u(maxBy)) {
            throw new NoSuchElementException();
        }
        byte bP = i1.p(maxBy, 0);
        int iRe = ArraysKt___ArraysKt.Re(maxBy);
        if (iRe == 0) {
            return bP;
        }
        R rI = selector.i(h1.d(bP));
        k0 it2 = new m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(maxBy, it2.b());
            R rI2 = selector.i(h1.d(bP2));
            if (rI.compareTo(rI2) < 0) {
                bP = bP2;
                rI = rI2;
            }
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> h1 S6(byte[] minByOrNull, ik.l<? super h1, ? extends R> selector) {
        f0.p(minByOrNull, "$this$minByOrNull");
        f0.p(selector, "selector");
        if (i1.u(minByOrNull)) {
            return null;
        }
        byte bP = i1.p(minByOrNull, 0);
        int iRe = ArraysKt___ArraysKt.Re(minByOrNull);
        if (iRe == 0) {
            return h1.d(bP);
        }
        R rI = selector.i(h1.d(bP));
        k0 it2 = new m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(minByOrNull, it2.b());
            R rI2 = selector.i(h1.d(bP2));
            if (rI.compareTo(rI2) > 0) {
                bP = bP2;
                rI = rI2;
            }
        }
        return h1.d(bP);
    }

    @h(name = "minWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final byte S7(@k byte[] minWith, @k Comparator<? super h1> comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        if (i1.u(minWith)) {
            throw new NoSuchElementException();
        }
        byte bP = i1.p(minWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minWith)).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(minWith, it2.b());
            if (comparator.compare(h1.d(bP), h1.d(bP2)) > 0) {
                bP = bP2;
            }
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int S8(int[] reduceIndexed, ik.q<? super Integer, ? super l1, ? super l1, l1> operation) {
        f0.p(reduceIndexed, "$this$reduceIndexed");
        f0.p(operation, "operation");
        if (m1.u(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iP = m1.p(reduceIndexed, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(reduceIndexed)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            iP = operation.A(Integer.valueOf(iB), l1.d(iP), l1.d(m1.p(reduceIndexed, iB))).l0();
        }
        return iP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<h1> S9(byte[] runningReduce, p<? super h1, ? super h1, h1> operation) {
        f0.p(runningReduce, "$this$runningReduce");
        f0.p(operation, "operation");
        if (i1.u(runningReduce)) {
            return CollectionsKt__CollectionsKt.E();
        }
        byte bP = i1.p(runningReduce, 0);
        ArrayList arrayList = new ArrayList(i1.r(runningReduce));
        arrayList.add(h1.d(bP));
        int iR = i1.r(runningReduce);
        for (int i10 = 1; i10 < iR; i10++) {
            bP = operation.r0(h1.d(bP), h1.d(i1.p(runningReduce, i10))).j0();
            arrayList.add(h1.d(bP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final long[] Sa(@k long[] sliceArray, @k Collection<Integer> indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return q1.e(ArraysKt___ArraysKt.Gu(sliceArray, indices));
    }

    @h(name = "sumOfDouble")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double Sb(byte[] sumOf, ik.l<? super h1, Double> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = i1.r(sumOf);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(h1.d(i1.p(sumOf, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] Sc(long[] jArr) {
        f0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        return q1.e(jArrCopyOf);
    }

    @s
    @v0(version = "1.4")
    public static final boolean T0(@l int[] iArr, @l int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> T1(@k short[] dropLast, int i10) {
        f0.p(dropLast, "$this$dropLast");
        if (i10 >= 0) {
            return rc(dropLast, v.u(w1.r(dropLast) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final p1 T2(long[] find, ik.l<? super p1, Boolean> predicate) {
        f0.p(find, "$this$find");
        f0.p(predicate, "predicate");
        int iR = q1.r(find);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(find, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                return p1.d(jP);
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R T3(short[] foldRightIndexed, R r10, ik.q<? super Integer, ? super v1, ? super R, ? extends R> operation) {
        f0.p(foldRightIndexed, "$this$foldRightIndexed");
        f0.p(operation, "operation");
        for (int iYe = ArraysKt___ArraysKt.Ye(foldRightIndexed); iYe >= 0; iYe--) {
            r10 = operation.A(Integer.valueOf(iYe), v1.d(w1.p(foldRightIndexed, iYe)), r10);
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int T4(short[] indexOf, short s10) {
        f0.p(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.kg(indexOf, s10);
    }

    @h(name = "maxByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> int T5(int[] maxBy, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (m1.u(maxBy)) {
            throw new NoSuchElementException();
        }
        int iP = m1.p(maxBy, 0);
        int iVe = ArraysKt___ArraysKt.Ve(maxBy);
        if (iVe == 0) {
            return iP;
        }
        R rI = selector.i(l1.d(iP));
        k0 it2 = new m(1, iVe).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(maxBy, it2.b());
            R rI2 = selector.i(l1.d(iP2));
            if (rI.compareTo(rI2) < 0) {
                iP = iP2;
                rI = rI2;
            }
        }
        return iP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> p1 T6(long[] minByOrNull, ik.l<? super p1, ? extends R> selector) {
        f0.p(minByOrNull, "$this$minByOrNull");
        f0.p(selector, "selector");
        if (q1.u(minByOrNull)) {
            return null;
        }
        long jP = q1.p(minByOrNull, 0);
        int iWe = ArraysKt___ArraysKt.We(minByOrNull);
        if (iWe == 0) {
            return p1.d(jP);
        }
        R rI = selector.i(p1.d(jP));
        k0 it2 = new m(1, iWe).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(minByOrNull, it2.b());
            R rI2 = selector.i(p1.d(jP2));
            if (rI.compareTo(rI2) > 0) {
                jP = jP2;
                rI = rI2;
            }
        }
        return p1.d(jP);
    }

    @h(name = "minWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final int T7(@k int[] minWith, @k Comparator<? super l1> comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        if (m1.u(minWith)) {
            throw new NoSuchElementException();
        }
        int iP = m1.p(minWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minWith)).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(minWith, it2.b());
            if (comparator.compare(l1.d(iP), l1.d(iP2)) > 0) {
                iP = iP2;
            }
        }
        return iP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte T8(byte[] reduceIndexed, ik.q<? super Integer, ? super h1, ? super h1, h1> operation) {
        f0.p(reduceIndexed, "$this$reduceIndexed");
        f0.p(operation, "operation");
        if (i1.u(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bP = i1.p(reduceIndexed, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(reduceIndexed)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            bP = operation.A(Integer.valueOf(iB), h1.d(bP), h1.d(i1.p(reduceIndexed, iB))).j0();
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<l1> T9(int[] runningReduce, p<? super l1, ? super l1, l1> operation) {
        f0.p(runningReduce, "$this$runningReduce");
        f0.p(operation, "operation");
        if (m1.u(runningReduce)) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iP = m1.p(runningReduce, 0);
        ArrayList arrayList = new ArrayList(m1.r(runningReduce));
        arrayList.add(l1.d(iP));
        int iR = m1.r(runningReduce);
        for (int i10 = 1; i10 < iR; i10++) {
            iP = operation.r0(l1.d(iP), l1.d(m1.p(runningReduce, i10))).l0();
            arrayList.add(l1.d(iP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final short[] Ta(@k short[] sliceArray, @k Collection<Integer> indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return w1.e(ArraysKt___ArraysKt.Ku(sliceArray, indices));
    }

    @h(name = "sumOfDouble")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double Tb(int[] sumOf, ik.l<? super l1, Double> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = m1.r(sumOf);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(l1.d(m1.p(sumOf, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final long[] Tc(@k p1[] p1VarArr) {
        f0.p(p1VarArr, "<this>");
        int length = p1VarArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = p1VarArr[i10].l0();
        }
        return q1.e(jArr);
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean U0(int[] contentEquals, int[] other) {
        f0.p(contentEquals, "$this$contentEquals");
        f0.p(other, "other");
        return T0(contentEquals, other);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> U1(@k int[] dropLast, int i10) {
        f0.p(dropLast, "$this$dropLast");
        if (i10 >= 0) {
            return sc(dropLast, v.u(m1.r(dropLast) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final l1 U2(int[] find, ik.l<? super l1, Boolean> predicate) {
        f0.p(find, "$this$find");
        f0.p(predicate, "predicate");
        int iR = m1.r(find);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(find, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                return l1.d(iP);
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R U3(long[] foldRightIndexed, R r10, ik.q<? super Integer, ? super p1, ? super R, ? extends R> operation) {
        f0.p(foldRightIndexed, "$this$foldRightIndexed");
        f0.p(operation, "operation");
        for (int iWe = ArraysKt___ArraysKt.We(foldRightIndexed); iWe >= 0; iWe--) {
            r10 = operation.A(Integer.valueOf(iWe), p1.d(q1.p(foldRightIndexed, iWe)), r10);
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int U4(byte[] indexOf, byte b10) {
        f0.p(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.dg(indexOf, b10);
    }

    @h(name = "maxByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> long U5(long[] maxBy, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (q1.u(maxBy)) {
            throw new NoSuchElementException();
        }
        long jP = q1.p(maxBy, 0);
        int iWe = ArraysKt___ArraysKt.We(maxBy);
        if (iWe == 0) {
            return jP;
        }
        R rI = selector.i(p1.d(jP));
        k0 it2 = new m(1, iWe).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(maxBy, it2.b());
            R rI2 = selector.i(p1.d(jP2));
            if (rI.compareTo(rI2) < 0) {
                jP = jP2;
                rI = rI2;
            }
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> l1 U6(int[] minByOrNull, ik.l<? super l1, ? extends R> selector) {
        f0.p(minByOrNull, "$this$minByOrNull");
        f0.p(selector, "selector");
        if (m1.u(minByOrNull)) {
            return null;
        }
        int iP = m1.p(minByOrNull, 0);
        int iVe = ArraysKt___ArraysKt.Ve(minByOrNull);
        if (iVe == 0) {
            return l1.d(iP);
        }
        R rI = selector.i(l1.d(iP));
        k0 it2 = new m(1, iVe).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(minByOrNull, it2.b());
            R rI2 = selector.i(l1.d(iP2));
            if (rI.compareTo(rI2) > 0) {
                iP = iP2;
                rI = rI2;
            }
        }
        return l1.d(iP);
    }

    @h(name = "minWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final long U7(@k long[] minWith, @k Comparator<? super p1> comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        if (q1.u(minWith)) {
            throw new NoSuchElementException();
        }
        long jP = q1.p(minWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minWith)).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(minWith, it2.b());
            if (comparator.compare(p1.d(jP), p1.d(jP2)) > 0) {
                jP = jP2;
            }
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short U8(short[] reduceIndexed, ik.q<? super Integer, ? super v1, ? super v1, v1> operation) {
        f0.p(reduceIndexed, "$this$reduceIndexed");
        f0.p(operation, "operation");
        if (w1.u(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sP = w1.p(reduceIndexed, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(reduceIndexed)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sP = operation.A(Integer.valueOf(iB), v1.d(sP), v1.d(w1.p(reduceIndexed, iB))).j0();
        }
        return sP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<p1> U9(long[] runningReduce, p<? super p1, ? super p1, p1> operation) {
        f0.p(runningReduce, "$this$runningReduce");
        f0.p(operation, "operation");
        if (q1.u(runningReduce)) {
            return CollectionsKt__CollectionsKt.E();
        }
        long jP = q1.p(runningReduce, 0);
        ArrayList arrayList = new ArrayList(q1.r(runningReduce));
        arrayList.add(p1.d(jP));
        int iR = q1.r(runningReduce);
        for (int i10 = 1; i10 < iR; i10++) {
            jP = operation.r0(p1.d(jP), p1.d(q1.p(runningReduce, i10))).l0();
            arrayList.add(p1.d(jP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final int[] Ua(@k int[] sliceArray, @k m indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return m1.e(ArraysKt___ArraysKt.Fu(sliceArray, indices));
    }

    @h(name = "sumOfDouble")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double Ub(long[] sumOf, ik.l<? super p1, Double> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = q1.r(sumOf);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(p1.d(q1.p(sumOf, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final short[] Uc(@k v1[] v1VarArr) {
        f0.p(v1VarArr, "<this>");
        int length = v1VarArr.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = v1VarArr[i10].j0();
        }
        return w1.e(sArr);
    }

    @s
    @v0(version = "1.4")
    public static final boolean V0(@l byte[] bArr, @l byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> V1(@k long[] dropLast, int i10) {
        f0.p(dropLast, "$this$dropLast");
        if (i10 >= 0) {
            return tc(dropLast, v.u(q1.r(dropLast) - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @f
    @s
    @v0(version = "1.3")
    public static final v1 V2(short[] find, ik.l<? super v1, Boolean> predicate) {
        f0.p(find, "$this$find");
        f0.p(predicate, "predicate");
        int iR = w1.r(find);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(find, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                return v1.d(sP);
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> R V3(int[] foldRightIndexed, R r10, ik.q<? super Integer, ? super l1, ? super R, ? extends R> operation) {
        f0.p(foldRightIndexed, "$this$foldRightIndexed");
        f0.p(operation, "operation");
        for (int iVe = ArraysKt___ArraysKt.Ve(foldRightIndexed); iVe >= 0; iVe--) {
            r10 = operation.A(Integer.valueOf(iVe), l1.d(m1.p(foldRightIndexed, iVe)), r10);
        }
        return r10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int V4(int[] indexOf, int i10) {
        f0.p(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.hg(indexOf, i10);
    }

    @h(name = "maxByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> short V5(short[] maxBy, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (w1.u(maxBy)) {
            throw new NoSuchElementException();
        }
        short sP = w1.p(maxBy, 0);
        int iYe = ArraysKt___ArraysKt.Ye(maxBy);
        if (iYe == 0) {
            return sP;
        }
        R rI = selector.i(v1.d(sP));
        k0 it2 = new m(1, iYe).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(maxBy, it2.b());
            R rI2 = selector.i(v1.d(sP2));
            if (rI.compareTo(rI2) < 0) {
                sP = sP2;
                rI = rI2;
            }
        }
        return sP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> v1 V6(short[] minByOrNull, ik.l<? super v1, ? extends R> selector) {
        f0.p(minByOrNull, "$this$minByOrNull");
        f0.p(selector, "selector");
        if (w1.u(minByOrNull)) {
            return null;
        }
        short sP = w1.p(minByOrNull, 0);
        int iYe = ArraysKt___ArraysKt.Ye(minByOrNull);
        if (iYe == 0) {
            return v1.d(sP);
        }
        R rI = selector.i(v1.d(sP));
        k0 it2 = new m(1, iYe).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(minByOrNull, it2.b());
            R rI2 = selector.i(v1.d(sP2));
            if (rI.compareTo(rI2) > 0) {
                sP = sP2;
                rI = rI2;
            }
        }
        return v1.d(sP);
    }

    @h(name = "minWithOrThrow-U")
    @s
    @v0(version = "1.7")
    public static final short V7(@k short[] minWith, @k Comparator<? super v1> comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        if (w1.u(minWith)) {
            throw new NoSuchElementException();
        }
        short sP = w1.p(minWith, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minWith)).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(minWith, it2.b());
            if (comparator.compare(v1.d(sP), v1.d(sP2)) > 0) {
                sP = sP2;
            }
        }
        return sP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long V8(long[] reduceIndexed, ik.q<? super Integer, ? super p1, ? super p1, p1> operation) {
        f0.p(reduceIndexed, "$this$reduceIndexed");
        f0.p(operation, "operation");
        if (q1.u(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jP = q1.p(reduceIndexed, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(reduceIndexed)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            jP = operation.A(Integer.valueOf(iB), p1.d(jP), p1.d(q1.p(reduceIndexed, iB))).l0();
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<v1> V9(short[] runningReduce, p<? super v1, ? super v1, v1> operation) {
        f0.p(runningReduce, "$this$runningReduce");
        f0.p(operation, "operation");
        if (w1.u(runningReduce)) {
            return CollectionsKt__CollectionsKt.E();
        }
        short sP = w1.p(runningReduce, 0);
        ArrayList arrayList = new ArrayList(w1.r(runningReduce));
        arrayList.add(v1.d(sP));
        int iR = w1.r(runningReduce);
        for (int i10 = 1; i10 < iR; i10++) {
            sP = operation.r0(v1.d(sP), v1.d(w1.p(runningReduce, i10))).j0();
            arrayList.add(v1.d(sP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] Va(@k byte[] sliceArray, @k Collection<Integer> indices) {
        f0.p(sliceArray, "$this$sliceArray");
        f0.p(indices, "indices");
        return i1.e(ArraysKt___ArraysKt.wu(sliceArray, indices));
    }

    @h(name = "sumOfDouble")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double Vb(short[] sumOf, ik.l<? super v1, Double> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = w1.r(sumOf);
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < iR; i10++) {
            dDoubleValue += selector.i(v1.d(w1.p(sumOf, i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] Vc(short[] sArr) {
        f0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        return w1.e(sArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean W(byte[] all, ik.l<? super h1, Boolean> predicate) {
        f0.p(all, "$this$all");
        f0.p(predicate, "predicate");
        int iR = i1.r(all);
        for (int i10 = 0; i10 < iR; i10++) {
            if (!predicate.i(h1.d(i1.p(all, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean W0(byte[] contentEquals, byte[] other) {
        f0.p(contentEquals, "$this$contentEquals");
        f0.p(other, "other");
        return V0(contentEquals, other);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> W1(byte[] dropLastWhile, ik.l<? super h1, Boolean> predicate) {
        f0.p(dropLastWhile, "$this$dropLastWhile");
        f0.p(predicate, "predicate");
        for (int iRe = ArraysKt___ArraysKt.Re(dropLastWhile); -1 < iRe; iRe--) {
            if (!predicate.i(h1.d(i1.p(dropLastWhile, iRe))).booleanValue()) {
                return qc(dropLastWhile, iRe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @f
    @s
    @v0(version = "1.3")
    public static final h1 W2(byte[] findLast, ik.l<? super h1, Boolean> predicate) {
        f0.p(findLast, "$this$findLast");
        f0.p(predicate, "predicate");
        int iR = i1.r(findLast) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                byte bP = i1.p(findLast, iR);
                if (predicate.i(h1.d(bP)).booleanValue()) {
                    return h1.d(bP);
                }
                if (i10 < 0) {
                    break;
                }
                iR = i10;
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void W3(byte[] forEach, ik.l<? super h1, z1> action) {
        f0.p(forEach, "$this$forEach");
        f0.p(action, "action");
        int iR = i1.r(forEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(h1.d(i1.p(forEach, i10)));
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int W4(byte[] indexOfFirst, ik.l<? super h1, Boolean> predicate) {
        f0.p(indexOfFirst, "$this$indexOfFirst");
        f0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(h1.d(h1.j(indexOfFirst[i10]))).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double W5(byte[] maxOf, ik.l<? super h1, Double> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (i1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(h1.d(i1.p(maxOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(h1.d(i1.p(maxOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @h(name = "minByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> byte W6(byte[] minBy, ik.l<? super h1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (i1.u(minBy)) {
            throw new NoSuchElementException();
        }
        byte bP = i1.p(minBy, 0);
        int iRe = ArraysKt___ArraysKt.Re(minBy);
        if (iRe == 0) {
            return bP;
        }
        R rI = selector.i(h1.d(bP));
        k0 it2 = new m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte bP2 = i1.p(minBy, it2.b());
            R rI2 = selector.i(h1.d(bP2));
            if (rI.compareTo(rI2) > 0) {
                bP = bP2;
                rI = rI2;
            }
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean W7(int[] none) {
        f0.p(none, "$this$none");
        return m1.u(none);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final l1 W8(int[] reduceIndexedOrNull, ik.q<? super Integer, ? super l1, ? super l1, l1> operation) {
        f0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        f0.p(operation, "operation");
        if (m1.u(reduceIndexedOrNull)) {
            return null;
        }
        int iP = m1.p(reduceIndexedOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(reduceIndexedOrNull)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            iP = operation.A(Integer.valueOf(iB), l1.d(iP), l1.d(m1.p(reduceIndexedOrNull, iB))).l0();
        }
        return l1.d(iP);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<l1> W9(int[] runningReduceIndexed, ik.q<? super Integer, ? super l1, ? super l1, l1> operation) {
        f0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        f0.p(operation, "operation");
        if (m1.u(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iP = m1.p(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(m1.r(runningReduceIndexed));
        arrayList.add(l1.d(iP));
        int iR = m1.r(runningReduceIndexed);
        for (int i10 = 1; i10 < iR; i10++) {
            iP = operation.A(Integer.valueOf(i10), l1.d(iP), l1.d(m1.p(runningReduceIndexed, i10))).l0();
            arrayList.add(l1.d(iP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    public static final void Wa(@k int[] sort) {
        f0.p(sort, "$this$sort");
        if (m1.r(sort) > 1) {
            kotlin.collections.h1.l(sort, 0, m1.r(sort));
        }
    }

    @h(name = "sumOfInt")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final int Wb(byte[] sumOf, ik.l<? super h1, Integer> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = i1.r(sumOf);
        int iIntValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iIntValue += selector.i(h1.d(i1.p(sumOf, i10))).intValue();
        }
        return iIntValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final Iterable<h0<l1>> Wc(@k final int[] withIndex) {
        f0.p(withIndex, "$this$withIndex");
        return new i0(new ik.a<Iterator<? extends l1>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<l1> o() {
                return m1.v(withIndex);
            }
        });
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean X(long[] all, ik.l<? super p1, Boolean> predicate) {
        f0.p(all, "$this$all");
        f0.p(predicate, "predicate");
        int iR = q1.r(all);
        for (int i10 = 0; i10 < iR; i10++) {
            if (!predicate.i(p1.d(q1.p(all, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @s
    @v0(version = "1.4")
    public static final boolean X0(@l long[] jArr, @l long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> X1(long[] dropLastWhile, ik.l<? super p1, Boolean> predicate) {
        f0.p(dropLastWhile, "$this$dropLastWhile");
        f0.p(predicate, "predicate");
        for (int iWe = ArraysKt___ArraysKt.We(dropLastWhile); -1 < iWe; iWe--) {
            if (!predicate.i(p1.d(q1.p(dropLastWhile, iWe))).booleanValue()) {
                return tc(dropLastWhile, iWe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @f
    @s
    @v0(version = "1.3")
    public static final p1 X2(long[] findLast, ik.l<? super p1, Boolean> predicate) {
        f0.p(findLast, "$this$findLast");
        f0.p(predicate, "predicate");
        int iR = q1.r(findLast) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                long jP = q1.p(findLast, iR);
                if (predicate.i(p1.d(jP)).booleanValue()) {
                    return p1.d(jP);
                }
                if (i10 < 0) {
                    break;
                }
                iR = i10;
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void X3(long[] forEach, ik.l<? super p1, z1> action) {
        f0.p(forEach, "$this$forEach");
        f0.p(action, "action");
        int iR = q1.r(forEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(p1.d(q1.p(forEach, i10)));
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int X4(long[] indexOfFirst, ik.l<? super p1, Boolean> predicate) {
        f0.p(indexOfFirst, "$this$indexOfFirst");
        f0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(p1.d(p1.j(indexOfFirst[i10]))).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float X5(byte[] maxOf, ik.l<? super h1, Float> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (i1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(h1.d(i1.p(maxOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(h1.d(i1.p(maxOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @h(name = "minByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> int X6(int[] minBy, ik.l<? super l1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (m1.u(minBy)) {
            throw new NoSuchElementException();
        }
        int iP = m1.p(minBy, 0);
        int iVe = ArraysKt___ArraysKt.Ve(minBy);
        if (iVe == 0) {
            return iP;
        }
        R rI = selector.i(l1.d(iP));
        k0 it2 = new m(1, iVe).iterator();
        while (it2.hasNext()) {
            int iP2 = m1.p(minBy, it2.b());
            R rI2 = selector.i(l1.d(iP2));
            if (rI.compareTo(rI2) > 0) {
                iP = iP2;
                rI = rI2;
            }
        }
        return iP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean X7(byte[] none) {
        f0.p(none, "$this$none");
        return i1.u(none);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final h1 X8(byte[] reduceIndexedOrNull, ik.q<? super Integer, ? super h1, ? super h1, h1> operation) {
        f0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        f0.p(operation, "operation");
        if (i1.u(reduceIndexedOrNull)) {
            return null;
        }
        byte bP = i1.p(reduceIndexedOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(reduceIndexedOrNull)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            bP = operation.A(Integer.valueOf(iB), h1.d(bP), h1.d(i1.p(reduceIndexedOrNull, iB))).j0();
        }
        return h1.d(bP);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<h1> X9(byte[] runningReduceIndexed, ik.q<? super Integer, ? super h1, ? super h1, h1> operation) {
        f0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        f0.p(operation, "operation");
        if (i1.u(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        byte bP = i1.p(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(i1.r(runningReduceIndexed));
        arrayList.add(h1.d(bP));
        int iR = i1.r(runningReduceIndexed);
        for (int i10 = 1; i10 < iR; i10++) {
            bP = operation.A(Integer.valueOf(i10), h1.d(bP), h1.d(i1.p(runningReduceIndexed, i10))).j0();
            arrayList.add(h1.d(bP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    public static final void Xa(@k long[] sort, int i10, int i11) {
        f0.p(sort, "$this$sort");
        kotlin.collections.b.f37685a.d(i10, i11, q1.r(sort));
        kotlin.collections.h1.i(sort, i10, i11);
    }

    @h(name = "sumOfInt")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final int Xb(int[] sumOf, ik.l<? super l1, Integer> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = m1.r(sumOf);
        int iIntValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iIntValue += selector.i(l1.d(m1.p(sumOf, i10))).intValue();
        }
        return iIntValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final Iterable<h0<h1>> Xc(@k final byte[] withIndex) {
        f0.p(withIndex, "$this$withIndex");
        return new i0(new ik.a<Iterator<? extends h1>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<h1> o() {
                return i1.v(withIndex);
            }
        });
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean Y(int[] all, ik.l<? super l1, Boolean> predicate) {
        f0.p(all, "$this$all");
        f0.p(predicate, "predicate");
        int iR = m1.r(all);
        for (int i10 = 0; i10 < iR; i10++) {
            if (!predicate.i(l1.d(m1.p(all, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean Y0(short[] contentEquals, short[] other) {
        f0.p(contentEquals, "$this$contentEquals");
        f0.p(other, "other");
        return S0(contentEquals, other);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> Y1(int[] dropLastWhile, ik.l<? super l1, Boolean> predicate) {
        f0.p(dropLastWhile, "$this$dropLastWhile");
        f0.p(predicate, "predicate");
        for (int iVe = ArraysKt___ArraysKt.Ve(dropLastWhile); -1 < iVe; iVe--) {
            if (!predicate.i(l1.d(m1.p(dropLastWhile, iVe))).booleanValue()) {
                return sc(dropLastWhile, iVe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @f
    @s
    @v0(version = "1.3")
    public static final l1 Y2(int[] findLast, ik.l<? super l1, Boolean> predicate) {
        f0.p(findLast, "$this$findLast");
        f0.p(predicate, "predicate");
        int iR = m1.r(findLast) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                int iP = m1.p(findLast, iR);
                if (predicate.i(l1.d(iP)).booleanValue()) {
                    return l1.d(iP);
                }
                if (i10 < 0) {
                    break;
                }
                iR = i10;
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void Y3(int[] forEach, ik.l<? super l1, z1> action) {
        f0.p(forEach, "$this$forEach");
        f0.p(action, "action");
        int iR = m1.r(forEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(l1.d(m1.p(forEach, i10)));
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int Y4(int[] indexOfFirst, ik.l<? super l1, Boolean> predicate) {
        f0.p(indexOfFirst, "$this$indexOfFirst");
        f0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(l1.d(l1.j(indexOfFirst[i10]))).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Y5(byte[] maxOf, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (i1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(h1.d(i1.p(maxOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(maxOf, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @h(name = "minByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> long Y6(long[] minBy, ik.l<? super p1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (q1.u(minBy)) {
            throw new NoSuchElementException();
        }
        long jP = q1.p(minBy, 0);
        int iWe = ArraysKt___ArraysKt.We(minBy);
        if (iWe == 0) {
            return jP;
        }
        R rI = selector.i(p1.d(jP));
        k0 it2 = new m(1, iWe).iterator();
        while (it2.hasNext()) {
            long jP2 = q1.p(minBy, it2.b());
            R rI2 = selector.i(p1.d(jP2));
            if (rI.compareTo(rI2) > 0) {
                jP = jP2;
                rI = rI2;
            }
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean Y7(byte[] none, ik.l<? super h1, Boolean> predicate) {
        f0.p(none, "$this$none");
        f0.p(predicate, "predicate");
        int iR = i1.r(none);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(h1.d(i1.p(none, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final v1 Y8(short[] reduceIndexedOrNull, ik.q<? super Integer, ? super v1, ? super v1, v1> operation) {
        f0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        f0.p(operation, "operation");
        if (w1.u(reduceIndexedOrNull)) {
            return null;
        }
        short sP = w1.p(reduceIndexedOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(reduceIndexedOrNull)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sP = operation.A(Integer.valueOf(iB), v1.d(sP), v1.d(w1.p(reduceIndexedOrNull, iB))).j0();
        }
        return v1.d(sP);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<v1> Y9(short[] runningReduceIndexed, ik.q<? super Integer, ? super v1, ? super v1, v1> operation) {
        f0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        f0.p(operation, "operation");
        if (w1.u(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        short sP = w1.p(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(w1.r(runningReduceIndexed));
        arrayList.add(v1.d(sP));
        int iR = w1.r(runningReduceIndexed);
        for (int i10 = 1; i10 < iR; i10++) {
            sP = operation.A(Integer.valueOf(i10), v1.d(sP), v1.d(w1.p(runningReduceIndexed, i10))).j0();
            arrayList.add(v1.d(sP));
        }
        return arrayList;
    }

    public static /* synthetic */ void Ya(long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = q1.r(jArr);
        }
        Xa(jArr, i10, i11);
    }

    @h(name = "sumOfInt")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final int Yb(long[] sumOf, ik.l<? super p1, Integer> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = q1.r(sumOf);
        int iIntValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iIntValue += selector.i(p1.d(q1.p(sumOf, i10))).intValue();
        }
        return iIntValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final Iterable<h0<p1>> Yc(@k final long[] withIndex) {
        f0.p(withIndex, "$this$withIndex");
        return new i0(new ik.a<Iterator<? extends p1>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<p1> o() {
                return q1.v(withIndex);
            }
        });
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean Z(short[] all, ik.l<? super v1, Boolean> predicate) {
        f0.p(all, "$this$all");
        f0.p(predicate, "predicate");
        int iR = w1.r(all);
        for (int i10 = 0; i10 < iR; i10++) {
            if (!predicate.i(v1.d(w1.p(all, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean Z0(long[] contentEquals, long[] other) {
        f0.p(contentEquals, "$this$contentEquals");
        f0.p(other, "other");
        return X0(contentEquals, other);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> Z1(short[] dropLastWhile, ik.l<? super v1, Boolean> predicate) {
        f0.p(dropLastWhile, "$this$dropLastWhile");
        f0.p(predicate, "predicate");
        for (int iYe = ArraysKt___ArraysKt.Ye(dropLastWhile); -1 < iYe; iYe--) {
            if (!predicate.i(v1.d(w1.p(dropLastWhile, iYe))).booleanValue()) {
                return rc(dropLastWhile, iYe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @f
    @s
    @v0(version = "1.3")
    public static final v1 Z2(short[] findLast, ik.l<? super v1, Boolean> predicate) {
        f0.p(findLast, "$this$findLast");
        f0.p(predicate, "predicate");
        int iR = w1.r(findLast) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                short sP = w1.p(findLast, iR);
                if (predicate.i(v1.d(sP)).booleanValue()) {
                    return v1.d(sP);
                }
                if (i10 < 0) {
                    break;
                }
                iR = i10;
            }
        }
        return null;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void Z3(short[] forEach, ik.l<? super v1, z1> action) {
        f0.p(forEach, "$this$forEach");
        f0.p(action, "action");
        int iR = w1.r(forEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(v1.d(w1.p(forEach, i10)));
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int Z4(short[] indexOfFirst, ik.l<? super v1, Boolean> predicate) {
        f0.p(indexOfFirst, "$this$indexOfFirst");
        f0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(v1.d(v1.j(indexOfFirst[i10]))).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double Z5(long[] maxOf, ik.l<? super p1, Double> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (q1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(p1.d(q1.p(maxOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(p1.d(q1.p(maxOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @h(name = "minByOrThrow-U")
    @f
    @s
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> short Z6(short[] minBy, ik.l<? super v1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (w1.u(minBy)) {
            throw new NoSuchElementException();
        }
        short sP = w1.p(minBy, 0);
        int iYe = ArraysKt___ArraysKt.Ye(minBy);
        if (iYe == 0) {
            return sP;
        }
        R rI = selector.i(v1.d(sP));
        k0 it2 = new m(1, iYe).iterator();
        while (it2.hasNext()) {
            short sP2 = w1.p(minBy, it2.b());
            R rI2 = selector.i(v1.d(sP2));
            if (rI.compareTo(rI2) > 0) {
                sP = sP2;
                rI = rI2;
            }
        }
        return sP;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean Z7(long[] none, ik.l<? super p1, Boolean> predicate) {
        f0.p(none, "$this$none");
        f0.p(predicate, "predicate");
        int iR = q1.r(none);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(p1.d(q1.p(none, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final p1 Z8(long[] reduceIndexedOrNull, ik.q<? super Integer, ? super p1, ? super p1, p1> operation) {
        f0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        f0.p(operation, "operation");
        if (q1.u(reduceIndexedOrNull)) {
            return null;
        }
        long jP = q1.p(reduceIndexedOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(reduceIndexedOrNull)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            jP = operation.A(Integer.valueOf(iB), p1.d(jP), p1.d(q1.p(reduceIndexedOrNull, iB))).l0();
        }
        return p1.d(jP);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final List<p1> Z9(long[] runningReduceIndexed, ik.q<? super Integer, ? super p1, ? super p1, p1> operation) {
        f0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        f0.p(operation, "operation");
        if (q1.u(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.E();
        }
        long jP = q1.p(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(q1.r(runningReduceIndexed));
        arrayList.add(p1.d(jP));
        int iR = q1.r(runningReduceIndexed);
        for (int i10 = 1; i10 < iR; i10++) {
            jP = operation.A(Integer.valueOf(i10), p1.d(jP), p1.d(q1.p(runningReduceIndexed, i10))).l0();
            arrayList.add(p1.d(jP));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    public static final void Za(@k byte[] sort, int i10, int i11) {
        f0.p(sort, "$this$sort");
        kotlin.collections.b.f37685a.d(i10, i11, i1.r(sort));
        kotlin.collections.h1.j(sort, i10, i11);
    }

    @h(name = "sumOfInt")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final int Zb(short[] sumOf, ik.l<? super v1, Integer> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = w1.r(sumOf);
        int iIntValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            iIntValue += selector.i(v1.d(w1.p(sumOf, i10))).intValue();
        }
        return iIntValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final Iterable<h0<v1>> Zc(@k final short[] withIndex) {
        f0.p(withIndex, "$this$withIndex");
        return new i0(new ik.a<Iterator<? extends v1>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<v1> o() {
                return w1.v(withIndex);
            }
        });
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean a0(int[] any) {
        f0.p(any, "$this$any");
        return ArraysKt___ArraysKt.M5(any);
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int a1(int[] contentHashCode) {
        f0.p(contentHashCode, "$this$contentHashCode");
        return e1(contentHashCode);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> a2(byte[] dropWhile, ik.l<? super h1, Boolean> predicate) {
        f0.p(dropWhile, "$this$dropWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(dropWhile);
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(dropWhile, i10);
            if (z10) {
                arrayList.add(h1.d(bP));
            } else if (!predicate.i(h1.d(bP)).booleanValue()) {
                arrayList.add(h1.d(bP));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int a3(int[] first) {
        f0.p(first, "$this$first");
        return l1.j(ArraysKt___ArraysKt.oc(first));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void a4(byte[] forEachIndexed, p<? super Integer, ? super h1, z1> action) {
        f0.p(forEachIndexed, "$this$forEachIndexed");
        f0.p(action, "action");
        int iR = i1.r(forEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), h1.d(i1.p(forEachIndexed, i10)));
            i10++;
            i11++;
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int a5(byte[] indexOfLast, ik.l<? super h1, Boolean> predicate) {
        f0.p(indexOfLast, "$this$indexOfLast");
        f0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (predicate.i(h1.d(h1.j(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float a6(long[] maxOf, ik.l<? super p1, Float> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (q1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(p1.d(q1.p(maxOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(p1.d(q1.p(maxOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double a7(byte[] minOf, ik.l<? super h1, Double> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (i1.u(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(h1.d(i1.p(minOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(h1.d(i1.p(minOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean a8(long[] none) {
        f0.p(none, "$this$none");
        return q1.u(none);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final h1 a9(byte[] reduceOrNull, p<? super h1, ? super h1, h1> operation) {
        f0.p(reduceOrNull, "$this$reduceOrNull");
        f0.p(operation, "operation");
        if (i1.u(reduceOrNull)) {
            return null;
        }
        byte bP = i1.p(reduceOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(reduceOrNull)).iterator();
        while (it2.hasNext()) {
            bP = operation.r0(h1.d(bP), h1.d(i1.p(reduceOrNull, it2.b()))).j0();
        }
        return h1.d(bP);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> aa(long[] scan, R r10, p<? super R, ? super p1, ? extends R> operation) {
        f0.p(scan, "$this$scan");
        f0.p(operation, "operation");
        if (q1.u(scan)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(q1.r(scan) + 1);
        arrayList.add(r10);
        int iR = q1.r(scan);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, p1.d(q1.p(scan, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static /* synthetic */ void ab(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = i1.r(bArr);
        }
        Za(bArr, i10, i11);
    }

    @h(name = "sumOfLong")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final long ac(byte[] sumOf, ik.l<? super h1, Long> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = i1.r(sumOf);
        long jLongValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            jLongValue += selector.i(h1.d(i1.p(sumOf, i10))).longValue();
        }
        return jLongValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> ad(int[] zip, Iterable<? extends R> other, p<? super l1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iR = m1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(transform.r0(l1.d(m1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean b0(byte[] any) {
        f0.p(any, "$this$any");
        return ArraysKt___ArraysKt.E5(any);
    }

    @s
    @v0(version = "1.4")
    public static final int b1(@l byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> b2(long[] dropWhile, ik.l<? super p1, Boolean> predicate) {
        f0.p(dropWhile, "$this$dropWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(dropWhile);
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(dropWhile, i10);
            if (z10) {
                arrayList.add(p1.d(jP));
            } else if (!predicate.i(p1.d(jP)).booleanValue()) {
                arrayList.add(p1.d(jP));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte b3(byte[] first) {
        f0.p(first, "$this$first");
        return h1.j(ArraysKt___ArraysKt.gc(first));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void b4(int[] forEachIndexed, p<? super Integer, ? super l1, z1> action) {
        f0.p(forEachIndexed, "$this$forEachIndexed");
        f0.p(action, "action");
        int iR = m1.r(forEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), l1.d(m1.p(forEachIndexed, i10)));
            i10++;
            i11++;
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int b5(long[] indexOfLast, ik.l<? super p1, Boolean> predicate) {
        f0.p(indexOfLast, "$this$indexOfLast");
        f0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (predicate.i(p1.d(p1.j(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R b6(long[] maxOf, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (q1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(p1.d(q1.p(maxOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(maxOf, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float b7(byte[] minOf, ik.l<? super h1, Float> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (i1.u(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(h1.d(i1.p(minOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(h1.d(i1.p(minOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean b8(int[] none, ik.l<? super l1, Boolean> predicate) {
        f0.p(none, "$this$none");
        f0.p(predicate, "predicate");
        int iR = m1.r(none);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(l1.d(m1.p(none, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final l1 b9(int[] reduceOrNull, p<? super l1, ? super l1, l1> operation) {
        f0.p(reduceOrNull, "$this$reduceOrNull");
        f0.p(operation, "operation");
        if (m1.u(reduceOrNull)) {
            return null;
        }
        int iP = m1.p(reduceOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(reduceOrNull)).iterator();
        while (it2.hasNext()) {
            iP = operation.r0(l1.d(iP), l1.d(m1.p(reduceOrNull, it2.b()))).l0();
        }
        return l1.d(iP);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> ba(byte[] scan, R r10, p<? super R, ? super h1, ? extends R> operation) {
        f0.p(scan, "$this$scan");
        f0.p(operation, "operation");
        if (i1.u(scan)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(i1.r(scan) + 1);
        arrayList.add(r10);
        int iR = i1.r(scan);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, h1.d(i1.p(scan, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    public static final void bb(@k short[] sort, int i10, int i11) {
        f0.p(sort, "$this$sort");
        kotlin.collections.b.f37685a.d(i10, i11, w1.r(sort));
        kotlin.collections.h1.k(sort, i10, i11);
    }

    @h(name = "sumOfLong")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final long bc(int[] sumOf, ik.l<? super l1, Long> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = m1.r(sumOf);
        long jLongValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            jLongValue += selector.i(l1.d(m1.p(sumOf, i10))).longValue();
        }
        return jLongValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> bd(long[] zip, R[] other, p<? super p1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(q1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(p1.d(q1.p(zip, i10)), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean c0(byte[] any, ik.l<? super h1, Boolean> predicate) {
        f0.p(any, "$this$any");
        f0.p(predicate, "predicate");
        int iR = i1.r(any);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(h1.d(i1.p(any, i10))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int c1(byte[] contentHashCode) {
        f0.p(contentHashCode, "$this$contentHashCode");
        return b1(contentHashCode);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> c2(int[] dropWhile, ik.l<? super l1, Boolean> predicate) {
        f0.p(dropWhile, "$this$dropWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(dropWhile);
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(dropWhile, i10);
            if (z10) {
                arrayList.add(l1.d(iP));
            } else if (!predicate.i(l1.d(iP)).booleanValue()) {
                arrayList.add(l1.d(iP));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte c3(byte[] first, ik.l<? super h1, Boolean> predicate) {
        f0.p(first, "$this$first");
        f0.p(predicate, "predicate");
        int iR = i1.r(first);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(first, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                return bP;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void c4(long[] forEachIndexed, p<? super Integer, ? super p1, z1> action) {
        f0.p(forEachIndexed, "$this$forEachIndexed");
        f0.p(action, "action");
        int iR = q1.r(forEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), p1.d(q1.p(forEachIndexed, i10)));
            i10++;
            i11++;
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int c5(int[] indexOfLast, ik.l<? super l1, Boolean> predicate) {
        f0.p(indexOfLast, "$this$indexOfLast");
        f0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (predicate.i(l1.d(l1.j(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double c6(int[] maxOf, ik.l<? super l1, Double> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (m1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(l1.d(m1.p(maxOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(l1.d(m1.p(maxOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R c7(byte[] minOf, ik.l<? super h1, ? extends R> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (i1.u(minOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(h1.d(i1.p(minOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(minOf, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean c8(short[] none) {
        f0.p(none, "$this$none");
        return w1.u(none);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final p1 c9(long[] reduceOrNull, p<? super p1, ? super p1, p1> operation) {
        f0.p(reduceOrNull, "$this$reduceOrNull");
        f0.p(operation, "operation");
        if (q1.u(reduceOrNull)) {
            return null;
        }
        long jP = q1.p(reduceOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(reduceOrNull)).iterator();
        while (it2.hasNext()) {
            jP = operation.r0(p1.d(jP), p1.d(q1.p(reduceOrNull, it2.b()))).l0();
        }
        return p1.d(jP);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> ca(int[] scan, R r10, p<? super R, ? super l1, ? extends R> operation) {
        f0.p(scan, "$this$scan");
        f0.p(operation, "operation");
        if (m1.u(scan)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(m1.r(scan) + 1);
        arrayList.add(r10);
        int iR = m1.r(scan);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, l1.d(m1.p(scan, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static /* synthetic */ void cb(short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = w1.r(sArr);
        }
        bb(sArr, i10, i11);
    }

    @h(name = "sumOfLong")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final long cc(long[] sumOf, ik.l<? super p1, Long> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = q1.r(sumOf);
        long jLongValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            jLongValue += selector.i(p1.d(q1.p(sumOf, i10))).longValue();
        }
        return jLongValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<l1, R>> cd(@k int[] zip, @k R[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(m1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iP = m1.p(zip, i10);
            arrayList.add(d1.a(l1.d(iP), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean d0(long[] any, ik.l<? super p1, Boolean> predicate) {
        f0.p(any, "$this$any");
        f0.p(predicate, "predicate");
        int iR = q1.r(any);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(p1.d(q1.p(any, i10))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int d1(long[] contentHashCode) {
        f0.p(contentHashCode, "$this$contentHashCode");
        return h1(contentHashCode);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> d2(short[] dropWhile, ik.l<? super v1, Boolean> predicate) {
        f0.p(dropWhile, "$this$dropWhile");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(dropWhile);
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(dropWhile, i10);
            if (z10) {
                arrayList.add(v1.d(sP));
            } else if (!predicate.i(v1.d(sP)).booleanValue()) {
                arrayList.add(v1.d(sP));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long d3(long[] first, ik.l<? super p1, Boolean> predicate) {
        f0.p(first, "$this$first");
        f0.p(predicate, "predicate");
        int iR = q1.r(first);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(first, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                return jP;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void d4(short[] forEachIndexed, p<? super Integer, ? super v1, z1> action) {
        f0.p(forEachIndexed, "$this$forEachIndexed");
        f0.p(action, "action");
        int iR = w1.r(forEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), v1.d(w1.p(forEachIndexed, i10)));
            i10++;
            i11++;
        }
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int d5(short[] indexOfLast, ik.l<? super v1, Boolean> predicate) {
        f0.p(indexOfLast, "$this$indexOfLast");
        f0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (predicate.i(v1.d(v1.j(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float d6(int[] maxOf, ik.l<? super l1, Float> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (m1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(l1.d(m1.p(maxOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(l1.d(m1.p(maxOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double d7(long[] minOf, ik.l<? super p1, Double> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (q1.u(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(p1.d(q1.p(minOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(p1.d(q1.p(minOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean d8(short[] none, ik.l<? super v1, Boolean> predicate) {
        f0.p(none, "$this$none");
        f0.p(predicate, "predicate");
        int iR = w1.r(none);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(v1.d(w1.p(none, i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final v1 d9(short[] reduceOrNull, p<? super v1, ? super v1, v1> operation) {
        f0.p(reduceOrNull, "$this$reduceOrNull");
        f0.p(operation, "operation");
        if (w1.u(reduceOrNull)) {
            return null;
        }
        short sP = w1.p(reduceOrNull, 0);
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(reduceOrNull)).iterator();
        while (it2.hasNext()) {
            sP = operation.r0(v1.d(sP), v1.d(w1.p(reduceOrNull, it2.b()))).j0();
        }
        return v1.d(sP);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> da(short[] scan, R r10, p<? super R, ? super v1, ? extends R> operation) {
        f0.p(scan, "$this$scan");
        f0.p(operation, "operation");
        if (w1.u(scan)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(w1.r(scan) + 1);
        arrayList.add(r10);
        int iR = w1.r(scan);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.r0(r10, v1.d(w1.p(scan, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    public static final void db(@k byte[] sort) {
        f0.p(sort, "$this$sort");
        if (i1.r(sort) > 1) {
            kotlin.collections.h1.j(sort, 0, i1.r(sort));
        }
    }

    @h(name = "sumOfLong")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final long dc(short[] sumOf, ik.l<? super v1, Long> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iR = w1.r(sumOf);
        long jLongValue = 0;
        for (int i10 = 0; i10 < iR; i10++) {
            jLongValue += selector.i(v1.d(w1.p(sumOf, i10))).longValue();
        }
        return jLongValue;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<p1, R>> dd(@k long[] zip, @k Iterable<? extends R> other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iR = q1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(d1.a(p1.d(q1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean e0(long[] any) {
        f0.p(any, "$this$any");
        return ArraysKt___ArraysKt.O5(any);
    }

    @s
    @v0(version = "1.4")
    public static final int e1(@l int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short e2(short[] elementAtOrElse, int i10, ik.l<? super Integer, v1> defaultValue) {
        f0.p(elementAtOrElse, "$this$elementAtOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.Ye(elementAtOrElse)) ? defaultValue.i(Integer.valueOf(i10)).j0() : w1.p(elementAtOrElse, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long e3(long[] first) {
        f0.p(first, "$this$first");
        return p1.j(ArraysKt___ArraysKt.qc(first));
    }

    @k
    public static final m e4(@k int[] indices) {
        f0.p(indices, "$this$indices");
        return ArraysKt___ArraysKt.Me(indices);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int e5(int[] last) {
        f0.p(last, "$this$last");
        return l1.j(ArraysKt___ArraysKt.Xh(last));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R e6(int[] maxOf, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (m1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(l1.d(m1.p(maxOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(maxOf, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float e7(long[] minOf, ik.l<? super p1, Float> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (q1.u(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(p1.d(q1.p(minOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(p1.d(q1.p(minOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final byte[] e8(byte[] onEach, ik.l<? super h1, z1> action) {
        f0.p(onEach, "$this$onEach");
        f0.p(action, "action");
        int iR = i1.r(onEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(h1.d(i1.p(onEach, i10)));
        }
        return onEach;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte e9(byte[] reduceRight, p<? super h1, ? super h1, h1> operation) {
        f0.p(reduceRight, "$this$reduceRight");
        f0.p(operation, "operation");
        int iRe = ArraysKt___ArraysKt.Re(reduceRight);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bP = i1.p(reduceRight, iRe);
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bP = operation.r0(h1.d(i1.p(reduceRight, i10)), h1.d(bP)).j0();
        }
        return bP;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> ea(byte[] scanIndexed, R r10, ik.q<? super Integer, ? super R, ? super h1, ? extends R> operation) {
        f0.p(scanIndexed, "$this$scanIndexed");
        f0.p(operation, "operation");
        if (i1.u(scanIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(i1.r(scanIndexed) + 1);
        arrayList.add(r10);
        int iR = i1.r(scanIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, h1.d(i1.p(scanIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    public static final void eb(@k long[] sort) {
        f0.p(sort, "$this$sort");
        if (q1.r(sort) > 1) {
            kotlin.collections.h1.i(sort, 0, q1.r(sort));
        }
    }

    @h(name = "sumOfUByte")
    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int ec(@k h1[] h1VarArr) {
        f0.p(h1VarArr, "<this>");
        int iJ = 0;
        for (h1 h1Var : h1VarArr) {
            iJ = l1.j(iJ + l1.j(h1Var.j0() & 255));
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<l1, R>> ed(@k int[] zip, @k Iterable<? extends R> other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iR = m1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(d1.a(l1.d(m1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean f0(int[] any, ik.l<? super l1, Boolean> predicate) {
        f0.p(any, "$this$any");
        f0.p(predicate, "predicate");
        int iR = m1.r(any);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(l1.d(m1.p(any, i10))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @s
    @v0(version = "1.4")
    public static final int f1(@l short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int f2(int[] elementAtOrElse, int i10, ik.l<? super Integer, l1> defaultValue) {
        f0.p(elementAtOrElse, "$this$elementAtOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.Ve(elementAtOrElse)) ? defaultValue.i(Integer.valueOf(i10)).l0() : m1.p(elementAtOrElse, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int f3(int[] first, ik.l<? super l1, Boolean> predicate) {
        f0.p(first, "$this$first");
        f0.p(predicate, "predicate");
        int iR = m1.r(first);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(first, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                return iP;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void f4(int[] iArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte f5(byte[] last) {
        f0.p(last, "$this$last");
        return h1.j(ArraysKt___ArraysKt.Ph(last));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double f6(short[] maxOf, ik.l<? super v1, Double> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (w1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(v1.d(w1.p(maxOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(v1.d(w1.p(maxOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R f7(long[] minOf, ik.l<? super p1, ? extends R> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (q1.u(minOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(p1.d(q1.p(minOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(minOf, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final long[] f8(long[] onEach, ik.l<? super p1, z1> action) {
        f0.p(onEach, "$this$onEach");
        f0.p(action, "action");
        int iR = q1.r(onEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(p1.d(q1.p(onEach, i10)));
        }
        return onEach;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int f9(int[] reduceRight, p<? super l1, ? super l1, l1> operation) {
        f0.p(reduceRight, "$this$reduceRight");
        f0.p(operation, "operation");
        int iVe = ArraysKt___ArraysKt.Ve(reduceRight);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iP = m1.p(reduceRight, iVe);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iP = operation.r0(l1.d(m1.p(reduceRight, i10)), l1.d(iP)).l0();
        }
        return iP;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> fa(short[] scanIndexed, R r10, ik.q<? super Integer, ? super R, ? super v1, ? extends R> operation) {
        f0.p(scanIndexed, "$this$scanIndexed");
        f0.p(operation, "operation");
        if (w1.u(scanIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(w1.r(scanIndexed) + 1);
        arrayList.add(r10);
        int iR = w1.r(scanIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, v1.d(w1.p(scanIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.4")
    public static final void fb(@k int[] sort, int i10, int i11) {
        f0.p(sort, "$this$sort");
        kotlin.collections.b.f37685a.d(i10, i11, m1.r(sort));
        kotlin.collections.h1.l(sort, i10, i11);
    }

    @h(name = "sumOfUInt")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final int fc(byte[] sumOf, ik.l<? super h1, l1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iJ = l1.j(0);
        int iR = i1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(h1.d(i1.p(sumOf, i10))).l0());
        }
        return iJ;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <V> List<V> fd(byte[] zip, byte[] other, p<? super h1, ? super h1, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(i1.r(zip), i1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(h1.d(i1.p(zip, i10)), h1.d(i1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean g0(short[] any) {
        f0.p(any, "$this$any");
        return ArraysKt___ArraysKt.S5(any);
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int g1(short[] contentHashCode) {
        f0.p(contentHashCode, "$this$contentHashCode");
        return f1(contentHashCode);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long g2(long[] elementAtOrElse, int i10, ik.l<? super Integer, p1> defaultValue) {
        f0.p(elementAtOrElse, "$this$elementAtOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.We(elementAtOrElse)) ? defaultValue.i(Integer.valueOf(i10)).l0() : q1.p(elementAtOrElse, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short g3(short[] first) {
        f0.p(first, "$this$first");
        return v1.j(ArraysKt___ArraysKt.uc(first));
    }

    @k
    public static final m g4(@k byte[] indices) {
        f0.p(indices, "$this$indices");
        return ArraysKt___ArraysKt.Ie(indices);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte g5(byte[] last, ik.l<? super h1, Boolean> predicate) {
        f0.p(last, "$this$last");
        f0.p(predicate, "predicate");
        int iR = i1.r(last) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                byte bP = i1.p(last, iR);
                if (!predicate.i(h1.d(bP)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    iR = i10;
                } else {
                    return bP;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float g6(short[] maxOf, ik.l<? super v1, Float> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (w1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(v1.d(w1.p(maxOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(v1.d(w1.p(maxOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double g7(int[] minOf, ik.l<? super l1, Double> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (m1.u(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(l1.d(m1.p(minOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(l1.d(m1.p(minOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final int[] g8(int[] onEach, ik.l<? super l1, z1> action) {
        f0.p(onEach, "$this$onEach");
        f0.p(action, "action");
        int iR = m1.r(onEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(l1.d(m1.p(onEach, i10)));
        }
        return onEach;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long g9(long[] reduceRight, p<? super p1, ? super p1, p1> operation) {
        f0.p(reduceRight, "$this$reduceRight");
        f0.p(operation, "operation");
        int iWe = ArraysKt___ArraysKt.We(reduceRight);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jP = q1.p(reduceRight, iWe);
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jP = operation.r0(p1.d(q1.p(reduceRight, i10)), p1.d(jP)).l0();
        }
        return jP;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> ga(long[] scanIndexed, R r10, ik.q<? super Integer, ? super R, ? super p1, ? extends R> operation) {
        f0.p(scanIndexed, "$this$scanIndexed");
        f0.p(operation, "operation");
        if (q1.u(scanIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(q1.r(scanIndexed) + 1);
        arrayList.add(r10);
        int iR = q1.r(scanIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, p1.d(q1.p(scanIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static /* synthetic */ void gb(int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = m1.r(iArr);
        }
        fb(iArr, i10, i11);
    }

    @h(name = "sumOfUInt")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final int gc(int[] sumOf, ik.l<? super l1, l1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iJ = l1.j(0);
        int iR = m1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(l1.d(m1.p(sumOf, i10))).l0());
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<v1, R>> gd(@k short[] zip, @k Iterable<? extends R> other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iR = w1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(d1.a(v1.d(w1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final boolean h0(short[] any, ik.l<? super v1, Boolean> predicate) {
        f0.p(any, "$this$any");
        f0.p(predicate, "predicate");
        int iR = w1.r(any);
        for (int i10 = 0; i10 < iR; i10++) {
            if (predicate.i(v1.d(w1.p(any, i10))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @s
    @v0(version = "1.4")
    public static final int h1(@l long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte h2(byte[] elementAtOrElse, int i10, ik.l<? super Integer, h1> defaultValue) {
        f0.p(elementAtOrElse, "$this$elementAtOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.Re(elementAtOrElse)) ? defaultValue.i(Integer.valueOf(i10)).j0() : i1.p(elementAtOrElse, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short h3(short[] first, ik.l<? super v1, Boolean> predicate) {
        f0.p(first, "$this$first");
        f0.p(predicate, "predicate");
        int iR = w1.r(first);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(first, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                return sP;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void h4(byte[] bArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long h5(long[] last, ik.l<? super p1, Boolean> predicate) {
        f0.p(last, "$this$last");
        f0.p(predicate, "predicate");
        int iR = q1.r(last) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                long jP = q1.p(last, iR);
                if (!predicate.i(p1.d(jP)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    iR = i10;
                } else {
                    return jP;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R h6(short[] maxOf, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxOf, "$this$maxOf");
        f0.p(selector, "selector");
        if (w1.u(maxOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(v1.d(w1.p(maxOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(maxOf, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float h7(int[] minOf, ik.l<? super l1, Float> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (m1.u(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(l1.d(m1.p(minOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(l1.d(m1.p(minOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final short[] h8(short[] onEach, ik.l<? super v1, z1> action) {
        f0.p(onEach, "$this$onEach");
        f0.p(action, "action");
        int iR = w1.r(onEach);
        for (int i10 = 0; i10 < iR; i10++) {
            action.i(v1.d(w1.p(onEach, i10)));
        }
        return onEach;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short h9(short[] reduceRight, p<? super v1, ? super v1, v1> operation) {
        f0.p(reduceRight, "$this$reduceRight");
        f0.p(operation, "operation");
        int iYe = ArraysKt___ArraysKt.Ye(reduceRight);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sP = w1.p(reduceRight, iYe);
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sP = operation.r0(v1.d(w1.p(reduceRight, i10)), v1.d(sP)).j0();
        }
        return sP;
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final <R> List<R> ha(int[] scanIndexed, R r10, ik.q<? super Integer, ? super R, ? super l1, ? extends R> operation) {
        f0.p(scanIndexed, "$this$scanIndexed");
        f0.p(operation, "operation");
        if (m1.u(scanIndexed)) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(m1.r(scanIndexed) + 1);
        arrayList.add(r10);
        int iR = m1.r(scanIndexed);
        for (int i10 = 0; i10 < iR; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, l1.d(m1.p(scanIndexed, i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    public static final void hb(@k short[] sort) {
        f0.p(sort, "$this$sort");
        if (w1.r(sort) > 1) {
            kotlin.collections.h1.k(sort, 0, w1.r(sort));
        }
    }

    @h(name = "sumOfUInt")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final int hc(long[] sumOf, ik.l<? super p1, l1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iJ = l1.j(0);
        int iR = q1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(p1.d(q1.p(sumOf, i10))).l0());
        }
        return iJ;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<h1, R>> hd(@k byte[] zip, @k Iterable<? extends R> other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iR = i1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(d1.a(h1.d(i1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] i0(byte[] asByteArray) {
        f0.p(asByteArray, "$this$asByteArray");
        return asByteArray;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String i1(int[] contentToString) {
        f0.p(contentToString, "$this$contentToString");
        return m1(contentToString);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final h1 i2(byte[] elementAtOrNull, int i10) {
        f0.p(elementAtOrNull, "$this$elementAtOrNull");
        return y4(elementAtOrNull, i10);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final l1 i3(@k int[] firstOrNull) {
        f0.p(firstOrNull, "$this$firstOrNull");
        if (m1.u(firstOrNull)) {
            return null;
        }
        return l1.d(m1.p(firstOrNull, 0));
    }

    @k
    public static final m i4(@k long[] indices) {
        f0.p(indices, "$this$indices");
        return ArraysKt___ArraysKt.Ne(indices);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long i5(long[] last) {
        f0.p(last, "$this$last");
        return p1.j(ArraysKt___ArraysKt.Zh(last));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R i6(byte[] maxOfOrNull, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (i1.u(maxOfOrNull)) {
            return null;
        }
        R rI = selector.i(h1.d(i1.p(maxOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(maxOfOrNull, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R i7(int[] minOf, ik.l<? super l1, ? extends R> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (m1.u(minOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(l1.d(m1.p(minOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(minOf, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final byte[] i8(byte[] onEachIndexed, p<? super Integer, ? super h1, z1> action) {
        f0.p(onEachIndexed, "$this$onEachIndexed");
        f0.p(action, "action");
        int iR = i1.r(onEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), h1.d(i1.p(onEachIndexed, i10)));
            i10++;
            i11++;
        }
        return onEachIndexed;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int i9(int[] reduceRightIndexed, ik.q<? super Integer, ? super l1, ? super l1, l1> operation) {
        f0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        f0.p(operation, "operation");
        int iVe = ArraysKt___ArraysKt.Ve(reduceRightIndexed);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iP = m1.p(reduceRightIndexed, iVe);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iP = operation.A(Integer.valueOf(i10), l1.d(m1.p(reduceRightIndexed, i10)), l1.d(iP)).l0();
        }
        return iP;
    }

    @s
    @v0(version = "1.4")
    public static final void ia(@k int[] shuffle) {
        f0.p(shuffle, "$this$shuffle");
        ja(shuffle, Random.f38003a);
    }

    @s
    @v0(version = "1.3")
    public static final void ib(@k int[] sortDescending) {
        f0.p(sortDescending, "$this$sortDescending");
        if (m1.r(sortDescending) > 1) {
            Wa(sortDescending);
            ArraysKt___ArraysKt.yr(sortDescending);
        }
    }

    @h(name = "sumOfUInt")
    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int ic(@k l1[] l1VarArr) {
        f0.p(l1VarArr, "<this>");
        int iJ = 0;
        for (l1 l1Var : l1VarArr) {
            iJ = l1.j(iJ + l1Var.l0());
        }
        return iJ;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <V> List<V> id(int[] zip, int[] other, p<? super l1, ? super l1, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(m1.r(zip), m1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(l1.d(m1.p(zip, i10)), l1.d(m1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] j0(int[] asIntArray) {
        f0.p(asIntArray, "$this$asIntArray");
        return asIntArray;
    }

    @s
    @v0(version = "1.4")
    @k
    public static final String j1(@l byte[] bArr) {
        String strH3;
        return (bArr == null || (strH3 = CollectionsKt___CollectionsKt.h3(i1.b(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? com.blankj.utilcode.util.i0.f11859x : strH3;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final v1 j2(short[] elementAtOrNull, int i10) {
        f0.p(elementAtOrNull, "$this$elementAtOrNull");
        return z4(elementAtOrNull, i10);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final h1 j3(@k byte[] firstOrNull) {
        f0.p(firstOrNull, "$this$firstOrNull");
        if (i1.u(firstOrNull)) {
            return null;
        }
        return h1.d(i1.p(firstOrNull, 0));
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void j4(long[] jArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int j5(int[] last, ik.l<? super l1, Boolean> predicate) {
        f0.p(last, "$this$last");
        f0.p(predicate, "predicate");
        int iR = m1.r(last) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                int iP = m1.p(last, iR);
                if (!predicate.i(l1.d(iP)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    iR = i10;
                } else {
                    return iP;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double j6(byte[] maxOfOrNull, ik.l<? super h1, Double> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (i1.u(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(h1.d(i1.p(maxOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(h1.d(i1.p(maxOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final double j7(short[] minOf, ik.l<? super v1, Double> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (w1.u(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(v1.d(w1.p(minOf, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOf)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(v1.d(w1.p(minOf, it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final int[] j8(int[] onEachIndexed, p<? super Integer, ? super l1, z1> action) {
        f0.p(onEachIndexed, "$this$onEachIndexed");
        f0.p(action, "action");
        int iR = m1.r(onEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), l1.d(m1.p(onEachIndexed, i10)));
            i10++;
            i11++;
        }
        return onEachIndexed;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte j9(byte[] reduceRightIndexed, ik.q<? super Integer, ? super h1, ? super h1, h1> operation) {
        f0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        f0.p(operation, "operation");
        int iRe = ArraysKt___ArraysKt.Re(reduceRightIndexed);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bP = i1.p(reduceRightIndexed, iRe);
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bP = operation.A(Integer.valueOf(i10), h1.d(i1.p(reduceRightIndexed, i10)), h1.d(bP)).j0();
        }
        return bP;
    }

    @s
    @v0(version = "1.4")
    public static final void ja(@k int[] shuffle, @k Random random) {
        f0.p(shuffle, "$this$shuffle");
        f0.p(random, "random");
        for (int iVe = ArraysKt___ArraysKt.Ve(shuffle); iVe > 0; iVe--) {
            int iP = random.p(iVe + 1);
            int iP2 = m1.p(shuffle, iVe);
            m1.w(shuffle, iVe, m1.p(shuffle, iP));
            m1.w(shuffle, iP, iP2);
        }
    }

    @s
    @v0(version = "1.4")
    public static final void jb(@k long[] sortDescending, int i10, int i11) {
        f0.p(sortDescending, "$this$sortDescending");
        Xa(sortDescending, i10, i11);
        ArraysKt___ArraysKt.Br(sortDescending, i10, i11);
    }

    @h(name = "sumOfUInt")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final int jc(short[] sumOf, ik.l<? super v1, l1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        int iJ = l1.j(0);
        int iR = w1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            iJ = l1.j(iJ + selector.i(v1.d(w1.p(sumOf, i10))).l0());
        }
        return iJ;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> jd(byte[] zip, R[] other, p<? super h1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(i1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(h1.d(i1.p(zip, i10)), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] k0(long[] asLongArray) {
        f0.p(asLongArray, "$this$asLongArray");
        return asLongArray;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String k1(byte[] contentToString) {
        f0.p(contentToString, "$this$contentToString");
        return j1(contentToString);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final l1 k2(int[] elementAtOrNull, int i10) {
        f0.p(elementAtOrNull, "$this$elementAtOrNull");
        return A4(elementAtOrNull, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final h1 k3(byte[] firstOrNull, ik.l<? super h1, Boolean> predicate) {
        f0.p(firstOrNull, "$this$firstOrNull");
        f0.p(predicate, "predicate");
        int iR = i1.r(firstOrNull);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(firstOrNull, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                return h1.d(bP);
            }
        }
        return null;
    }

    @k
    public static final m k4(@k short[] indices) {
        f0.p(indices, "$this$indices");
        return ArraysKt___ArraysKt.Pe(indices);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short k5(short[] last) {
        f0.p(last, "$this$last");
        return v1.j(ArraysKt___ArraysKt.di(last));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float k6(byte[] maxOfOrNull, ik.l<? super h1, Float> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (i1.u(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(h1.d(i1.p(maxOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(h1.d(i1.p(maxOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final float k7(short[] minOf, ik.l<? super v1, Float> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (w1.u(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(v1.d(w1.p(minOf, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOf)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(v1.d(w1.p(minOf, it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final long[] k8(long[] onEachIndexed, p<? super Integer, ? super p1, z1> action) {
        f0.p(onEachIndexed, "$this$onEachIndexed");
        f0.p(action, "action");
        int iR = q1.r(onEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), p1.d(q1.p(onEachIndexed, i10)));
            i10++;
            i11++;
        }
        return onEachIndexed;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short k9(short[] reduceRightIndexed, ik.q<? super Integer, ? super v1, ? super v1, v1> operation) {
        f0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        f0.p(operation, "operation");
        int iYe = ArraysKt___ArraysKt.Ye(reduceRightIndexed);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sP = w1.p(reduceRightIndexed, iYe);
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sP = operation.A(Integer.valueOf(i10), v1.d(w1.p(reduceRightIndexed, i10)), v1.d(sP)).j0();
        }
        return sP;
    }

    @s
    @v0(version = "1.4")
    public static final void ka(@k byte[] shuffle) {
        f0.p(shuffle, "$this$shuffle");
        na(shuffle, Random.f38003a);
    }

    @s
    @v0(version = "1.4")
    public static final void kb(@k byte[] sortDescending, int i10, int i11) {
        f0.p(sortDescending, "$this$sortDescending");
        Za(sortDescending, i10, i11);
        ArraysKt___ArraysKt.rr(sortDescending, i10, i11);
    }

    @h(name = "sumOfULong")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final long kc(byte[] sumOf, ik.l<? super h1, p1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        long j10 = p1.j(0L);
        int iR = i1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            j10 = p1.j(j10 + selector.i(h1.d(i1.p(sumOf, i10))).l0());
        }
        return j10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <V> List<V> kd(long[] zip, long[] other, p<? super p1, ? super p1, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(q1.r(zip), q1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(p1.d(q1.p(zip, i10)), p1.d(q1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] l0(short[] asShortArray) {
        f0.p(asShortArray, "$this$asShortArray");
        return asShortArray;
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String l1(long[] contentToString) {
        f0.p(contentToString, "$this$contentToString");
        return p1(contentToString);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final p1 l2(long[] elementAtOrNull, int i10) {
        f0.p(elementAtOrNull, "$this$elementAtOrNull");
        return B4(elementAtOrNull, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final p1 l3(long[] firstOrNull, ik.l<? super p1, Boolean> predicate) {
        f0.p(firstOrNull, "$this$firstOrNull");
        f0.p(predicate, "predicate");
        int iR = q1.r(firstOrNull);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(firstOrNull, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                return p1.d(jP);
            }
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void l4(short[] sArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short l5(short[] last, ik.l<? super v1, Boolean> predicate) {
        f0.p(last, "$this$last");
        f0.p(predicate, "predicate");
        int iR = w1.r(last) - 1;
        if (iR >= 0) {
            while (true) {
                int i10 = iR - 1;
                short sP = w1.p(last, iR);
                if (!predicate.i(v1.d(sP)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    iR = i10;
                } else {
                    return sP;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R l6(long[] maxOfOrNull, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (q1.u(maxOfOrNull)) {
            return null;
        }
        R rI = selector.i(p1.d(q1.p(maxOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(maxOfOrNull, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R l7(short[] minOf, ik.l<? super v1, ? extends R> selector) {
        f0.p(minOf, "$this$minOf");
        f0.p(selector, "selector");
        if (w1.u(minOf)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(v1.d(w1.p(minOf, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOf)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(minOf, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final short[] l8(short[] onEachIndexed, p<? super Integer, ? super v1, z1> action) {
        f0.p(onEachIndexed, "$this$onEachIndexed");
        f0.p(action, "action");
        int iR = w1.r(onEachIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            action.r0(Integer.valueOf(i11), v1.d(w1.p(onEachIndexed, i10)));
            i10++;
            i11++;
        }
        return onEachIndexed;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long l9(long[] reduceRightIndexed, ik.q<? super Integer, ? super p1, ? super p1, p1> operation) {
        f0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        f0.p(operation, "operation");
        int iWe = ArraysKt___ArraysKt.We(reduceRightIndexed);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jP = q1.p(reduceRightIndexed, iWe);
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jP = operation.A(Integer.valueOf(i10), p1.d(q1.p(reduceRightIndexed, i10)), p1.d(jP)).l0();
        }
        return jP;
    }

    @s
    @v0(version = "1.4")
    public static final void la(@k long[] shuffle, @k Random random) {
        f0.p(shuffle, "$this$shuffle");
        f0.p(random, "random");
        for (int iWe = ArraysKt___ArraysKt.We(shuffle); iWe > 0; iWe--) {
            int iP = random.p(iWe + 1);
            long jP = q1.p(shuffle, iWe);
            q1.w(shuffle, iWe, q1.p(shuffle, iP));
            q1.w(shuffle, iP, jP);
        }
    }

    @s
    @v0(version = "1.4")
    public static final void lb(@k short[] sortDescending, int i10, int i11) {
        f0.p(sortDescending, "$this$sortDescending");
        bb(sortDescending, i10, i11);
        ArraysKt___ArraysKt.Fr(sortDescending, i10, i11);
    }

    @h(name = "sumOfULong")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final long lc(int[] sumOf, ik.l<? super l1, p1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        long j10 = p1.j(0L);
        int iR = m1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            j10 = p1.j(j10 + selector.i(l1.d(m1.p(sumOf, i10))).l0());
        }
        return j10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> ld(long[] zip, Iterable<? extends R> other, p<? super p1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iR = q1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(transform.r0(p1.d(q1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] m0(byte[] bArr) {
        f0.p(bArr, "<this>");
        return i1.e(bArr);
    }

    @s
    @v0(version = "1.4")
    @k
    public static final String m1(@l int[] iArr) {
        String strH3;
        return (iArr == null || (strH3 = CollectionsKt___CollectionsKt.h3(m1.b(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? com.blankj.utilcode.util.i0.f11859x : strH3;
    }

    @s
    @v0(version = "1.3")
    public static final void m2(@k int[] fill, int i10, int i11, int i12) {
        f0.p(fill, "$this$fill");
        kotlin.collections.m.l2(fill, i10, i11, i12);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final p1 m3(@k long[] firstOrNull) {
        f0.p(firstOrNull, "$this$firstOrNull");
        if (q1.u(firstOrNull)) {
            return null;
        }
        return p1.d(q1.p(firstOrNull, 0));
    }

    public static final int m4(@k int[] lastIndex) {
        f0.p(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.Ve(lastIndex);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int m5(long[] lastIndexOf, long j10) {
        f0.p(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.mi(lastIndexOf, j10);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double m6(long[] maxOfOrNull, ik.l<? super p1, Double> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (q1.u(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(p1.d(q1.p(maxOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(p1.d(q1.p(maxOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R m7(byte[] minOfOrNull, ik.l<? super h1, ? extends R> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (i1.u(minOfOrNull)) {
            return null;
        }
        R rI = selector.i(h1.d(i1.p(minOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(minOfOrNull, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] m8(long[] plus, long j10) {
        f0.p(plus, "$this$plus");
        return q1.e(kotlin.collections.m.U3(plus, j10));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final l1 m9(int[] reduceRightIndexedOrNull, ik.q<? super Integer, ? super l1, ? super l1, l1> operation) {
        f0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        f0.p(operation, "operation");
        int iVe = ArraysKt___ArraysKt.Ve(reduceRightIndexedOrNull);
        if (iVe < 0) {
            return null;
        }
        int iP = m1.p(reduceRightIndexedOrNull, iVe);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iP = operation.A(Integer.valueOf(i10), l1.d(m1.p(reduceRightIndexedOrNull, i10)), l1.d(iP)).l0();
        }
        return l1.d(iP);
    }

    @s
    @v0(version = "1.4")
    public static final void ma(@k long[] shuffle) {
        f0.p(shuffle, "$this$shuffle");
        la(shuffle, Random.f38003a);
    }

    @s
    @v0(version = "1.3")
    public static final void mb(@k byte[] sortDescending) {
        f0.p(sortDescending, "$this$sortDescending");
        if (i1.r(sortDescending) > 1) {
            db(sortDescending);
            ArraysKt___ArraysKt.qr(sortDescending);
        }
    }

    @h(name = "sumOfULong")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final long mc(long[] sumOf, ik.l<? super p1, p1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        long j10 = p1.j(0L);
        int iR = q1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            j10 = p1.j(j10 + selector.i(p1.d(q1.p(sumOf, i10))).l0());
        }
        return j10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> md(byte[] zip, Iterable<? extends R> other, p<? super h1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iR = i1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(transform.r0(h1.d(i1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] n0(int[] iArr) {
        f0.p(iArr, "<this>");
        return m1.e(iArr);
    }

    @s
    @v0(version = "1.4")
    @k
    public static final String n1(@l short[] sArr) {
        String strH3;
        return (sArr == null || (strH3 = CollectionsKt___CollectionsKt.h3(w1.b(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? com.blankj.utilcode.util.i0.f11859x : strH3;
    }

    public static /* synthetic */ void n2(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = m1.r(iArr);
        }
        m2(iArr, i10, i11, i12);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final l1 n3(int[] firstOrNull, ik.l<? super l1, Boolean> predicate) {
        f0.p(firstOrNull, "$this$firstOrNull");
        f0.p(predicate, "predicate");
        int iR = m1.r(firstOrNull);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(firstOrNull, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                return l1.d(iP);
            }
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void n4(int[] iArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int n5(short[] lastIndexOf, short s10) {
        f0.p(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.oi(lastIndexOf, s10);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float n6(long[] maxOfOrNull, ik.l<? super p1, Float> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (q1.u(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(p1.d(q1.p(maxOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(p1.d(q1.p(maxOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double n7(byte[] minOfOrNull, ik.l<? super h1, Double> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (i1.u(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(h1.d(i1.p(minOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(h1.d(i1.p(minOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final int[] n8(@k int[] plus, @k Collection<l1> elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        int iR = m1.r(plus);
        int[] iArrCopyOf = Arrays.copyOf(plus, m1.r(plus) + elements.size());
        f0.o(iArrCopyOf, "copyOf(this, newSize)");
        Iterator<l1> it2 = elements.iterator();
        while (it2.hasNext()) {
            iArrCopyOf[iR] = it2.next().l0();
            iR++;
        }
        return m1.e(iArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final h1 n9(byte[] reduceRightIndexedOrNull, ik.q<? super Integer, ? super h1, ? super h1, h1> operation) {
        f0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        f0.p(operation, "operation");
        int iRe = ArraysKt___ArraysKt.Re(reduceRightIndexedOrNull);
        if (iRe < 0) {
            return null;
        }
        byte bP = i1.p(reduceRightIndexedOrNull, iRe);
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bP = operation.A(Integer.valueOf(i10), h1.d(i1.p(reduceRightIndexedOrNull, i10)), h1.d(bP)).j0();
        }
        return h1.d(bP);
    }

    @s
    @v0(version = "1.4")
    public static final void na(@k byte[] shuffle, @k Random random) {
        f0.p(shuffle, "$this$shuffle");
        f0.p(random, "random");
        for (int iRe = ArraysKt___ArraysKt.Re(shuffle); iRe > 0; iRe--) {
            int iP = random.p(iRe + 1);
            byte bP = i1.p(shuffle, iRe);
            i1.w(shuffle, iRe, i1.p(shuffle, iP));
            i1.w(shuffle, iP, bP);
        }
    }

    @s
    @v0(version = "1.3")
    public static final void nb(@k long[] sortDescending) {
        f0.p(sortDescending, "$this$sortDescending");
        if (q1.r(sortDescending) > 1) {
            eb(sortDescending);
            ArraysKt___ArraysKt.Ar(sortDescending);
        }
    }

    @h(name = "sumOfULong")
    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final long nc(@k p1[] p1VarArr) {
        f0.p(p1VarArr, "<this>");
        long j10 = 0;
        for (p1 p1Var : p1VarArr) {
            j10 = p1.j(j10 + p1Var.l0());
        }
        return j10;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> nd(int[] zip, R[] other, p<? super l1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(m1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(l1.d(m1.p(zip, i10)), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] o0(long[] jArr) {
        f0.p(jArr, "<this>");
        return q1.e(jArr);
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @s
    @v0(version = "1.3")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String o1(short[] contentToString) {
        f0.p(contentToString, "$this$contentToString");
        return n1(contentToString);
    }

    @s
    @v0(version = "1.3")
    public static final void o2(@k short[] fill, short s10, int i10, int i11) {
        f0.p(fill, "$this$fill");
        kotlin.collections.m.o2(fill, s10, i10, i11);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final v1 o3(@k short[] firstOrNull) {
        f0.p(firstOrNull, "$this$firstOrNull");
        if (w1.u(firstOrNull)) {
            return null;
        }
        return v1.d(w1.p(firstOrNull, 0));
    }

    public static final int o4(@k byte[] lastIndex) {
        f0.p(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.Re(lastIndex);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int o5(byte[] lastIndexOf, byte b10) {
        f0.p(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.hi(lastIndexOf, b10);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R o6(int[] maxOfOrNull, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (m1.u(maxOfOrNull)) {
            return null;
        }
        R rI = selector.i(l1.d(m1.p(maxOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(maxOfOrNull, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float o7(byte[] minOfOrNull, ik.l<? super h1, Float> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (i1.u(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(h1.d(i1.p(minOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(h1.d(i1.p(minOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] o8(short[] plus, short s10) {
        f0.p(plus, "$this$plus");
        return w1.e(kotlin.collections.m.b4(plus, s10));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final v1 o9(short[] reduceRightIndexedOrNull, ik.q<? super Integer, ? super v1, ? super v1, v1> operation) {
        f0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        f0.p(operation, "operation");
        int iYe = ArraysKt___ArraysKt.Ye(reduceRightIndexedOrNull);
        if (iYe < 0) {
            return null;
        }
        short sP = w1.p(reduceRightIndexedOrNull, iYe);
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sP = operation.A(Integer.valueOf(i10), v1.d(w1.p(reduceRightIndexedOrNull, i10)), v1.d(sP)).j0();
        }
        return v1.d(sP);
    }

    @s
    @v0(version = "1.4")
    public static final void oa(@k short[] shuffle) {
        f0.p(shuffle, "$this$shuffle");
        pa(shuffle, Random.f38003a);
    }

    @s
    @v0(version = "1.4")
    public static final void ob(@k int[] sortDescending, int i10, int i11) {
        f0.p(sortDescending, "$this$sortDescending");
        fb(sortDescending, i10, i11);
        ArraysKt___ArraysKt.zr(sortDescending, i10, i11);
    }

    @h(name = "sumOfULong")
    @m0
    @f
    @s
    @v0(version = "1.5")
    @c2(markerClass = {s.class})
    public static final long oc(short[] sumOf, ik.l<? super v1, p1> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        long j10 = p1.j(0L);
        int iR = w1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            j10 = p1.j(j10 + selector.i(v1.d(w1.p(sumOf, i10))).l0());
        }
        return j10;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<Pair<l1, l1>> od(@k int[] zip, @k int[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(m1.r(zip), m1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(d1.a(l1.d(m1.p(zip, i10)), l1.d(m1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] p0(short[] sArr) {
        f0.p(sArr, "<this>");
        return w1.e(sArr);
    }

    @s
    @v0(version = "1.4")
    @k
    public static final String p1(@l long[] jArr) {
        String strH3;
        return (jArr == null || (strH3 = CollectionsKt___CollectionsKt.h3(q1.b(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? com.blankj.utilcode.util.i0.f11859x : strH3;
    }

    public static /* synthetic */ void p2(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = w1.r(sArr);
        }
        o2(sArr, s10, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final v1 p3(short[] firstOrNull, ik.l<? super v1, Boolean> predicate) {
        f0.p(firstOrNull, "$this$firstOrNull");
        f0.p(predicate, "predicate");
        int iR = w1.r(firstOrNull);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(firstOrNull, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                return v1.d(sP);
            }
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void p4(byte[] bArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int p5(int[] lastIndexOf, int i10) {
        f0.p(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.li(lastIndexOf, i10);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double p6(int[] maxOfOrNull, ik.l<? super l1, Double> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (m1.u(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(l1.d(m1.p(maxOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(l1.d(m1.p(maxOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R p7(long[] minOfOrNull, ik.l<? super p1, ? extends R> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (q1.u(minOfOrNull)) {
            return null;
        }
        R rI = selector.i(p1.d(q1.p(minOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(minOfOrNull, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] p8(int[] plus, int[] elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        return m1.e(kotlin.collections.m.T3(plus, elements));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final p1 p9(long[] reduceRightIndexedOrNull, ik.q<? super Integer, ? super p1, ? super p1, p1> operation) {
        f0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        f0.p(operation, "operation");
        int iWe = ArraysKt___ArraysKt.We(reduceRightIndexedOrNull);
        if (iWe < 0) {
            return null;
        }
        long jP = q1.p(reduceRightIndexedOrNull, iWe);
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jP = operation.A(Integer.valueOf(i10), p1.d(q1.p(reduceRightIndexedOrNull, i10)), p1.d(jP)).l0();
        }
        return p1.d(jP);
    }

    @s
    @v0(version = "1.4")
    public static final void pa(@k short[] shuffle, @k Random random) {
        f0.p(shuffle, "$this$shuffle");
        f0.p(random, "random");
        for (int iYe = ArraysKt___ArraysKt.Ye(shuffle); iYe > 0; iYe--) {
            int iP = random.p(iYe + 1);
            short sP = w1.p(shuffle, iYe);
            w1.w(shuffle, iYe, w1.p(shuffle, iP));
            w1.w(shuffle, iP, sP);
        }
    }

    @s
    @v0(version = "1.3")
    public static final void pb(@k short[] sortDescending) {
        f0.p(sortDescending, "$this$sortDescending");
        if (w1.r(sortDescending) > 1) {
            hb(sortDescending);
            ArraysKt___ArraysKt.Er(sortDescending);
        }
    }

    @h(name = "sumOfUShort")
    @c2(markerClass = {s.class})
    @v0(version = "1.5")
    public static final int pc(@k v1[] v1VarArr) {
        f0.p(v1VarArr, "<this>");
        int iJ = 0;
        for (v1 v1Var : v1VarArr) {
            iJ = l1.j(iJ + l1.j(v1Var.j0() & v1.f38215d));
        }
        return iJ;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> pd(short[] zip, R[] other, p<? super v1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(w1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(v1.d(w1.p(zip, i10)), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V> Map<h1, V> q0(byte[] associateWith, ik.l<? super h1, ? extends V> valueSelector) {
        f0.p(associateWith, "$this$associateWith");
        f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.u(r0.j(i1.r(associateWith)), 16));
        int iR = i1.r(associateWith);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(associateWith, i10);
            linkedHashMap.put(h1.d(bP), valueSelector.i(h1.d(bP)));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] q1(long[] copyInto, long[] destination, int i10, int i11, int i12) {
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.b1(copyInto, destination, i10, i11, i12);
        return destination;
    }

    @s
    @v0(version = "1.3")
    public static final void q2(@k long[] fill, long j10, int i10, int i11) {
        f0.p(fill, "$this$fill");
        kotlin.collections.m.m2(fill, j10, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> q3(byte[] flatMap, ik.l<? super h1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMap, "$this$flatMap");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(flatMap);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(arrayList, transform.i(h1.d(i1.p(flatMap, i10))));
        }
        return arrayList;
    }

    public static final int q4(@k long[] lastIndex) {
        f0.p(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.We(lastIndex);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final l1 q5(@k int[] lastOrNull) {
        f0.p(lastOrNull, "$this$lastOrNull");
        if (m1.u(lastOrNull)) {
            return null;
        }
        return l1.d(m1.p(lastOrNull, m1.r(lastOrNull) - 1));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float q6(int[] maxOfOrNull, ik.l<? super l1, Float> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (m1.u(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(l1.d(m1.p(maxOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(l1.d(m1.p(maxOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double q7(long[] minOfOrNull, ik.l<? super p1, Double> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (q1.u(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(p1.d(q1.p(minOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(p1.d(q1.p(minOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] q8(byte[] plus, byte b10) {
        f0.p(plus, "$this$plus");
        return i1.e(kotlin.collections.m.F3(plus, b10));
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final h1 q9(byte[] reduceRightOrNull, p<? super h1, ? super h1, h1> operation) {
        f0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        f0.p(operation, "operation");
        int iRe = ArraysKt___ArraysKt.Re(reduceRightOrNull);
        if (iRe < 0) {
            return null;
        }
        byte bP = i1.p(reduceRightOrNull, iRe);
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bP = operation.r0(h1.d(i1.p(reduceRightOrNull, i10)), h1.d(bP)).j0();
        }
        return h1.d(bP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int qa(int[] single) {
        f0.p(single, "$this$single");
        return l1.j(ArraysKt___ArraysKt.Ct(single));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> qb(@k int[] sorted) {
        f0.p(sorted, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrE = m1.e(iArrCopyOf);
        Wa(iArrE);
        return b.a(iArrE);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> qc(@k byte[] take, int i10) {
        f0.p(take, "$this$take");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= i1.r(take)) {
            return CollectionsKt___CollectionsKt.Q5(i1.b(take));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(h1.d(i1.p(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i10);
        int iR = i1.r(take);
        int i11 = 0;
        for (int i12 = 0; i12 < iR; i12++) {
            arrayList.add(h1.d(i1.p(take, i12)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<p1, R>> qd(@k long[] zip, @k R[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(q1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            long jP = q1.p(zip, i10);
            arrayList.add(d1.a(p1.d(jP), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V> Map<p1, V> r0(long[] associateWith, ik.l<? super p1, ? extends V> valueSelector) {
        f0.p(associateWith, "$this$associateWith");
        f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.u(r0.j(q1.r(associateWith)), 16));
        int iR = q1.r(associateWith);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(associateWith, i10);
            linkedHashMap.put(p1.d(jP), valueSelector.i(p1.d(jP)));
        }
        return linkedHashMap;
    }

    public static /* synthetic */ long[] r1(long[] copyInto, long[] destination, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = q1.r(copyInto);
        }
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.b1(copyInto, destination, i10, i11, i12);
        return destination;
    }

    public static /* synthetic */ void r2(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = q1.r(jArr);
        }
        q2(jArr, j10, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> r3(long[] flatMap, ik.l<? super p1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMap, "$this$flatMap");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(flatMap);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(arrayList, transform.i(p1.d(q1.p(flatMap, i10))));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void r4(long[] jArr) {
    }

    @s
    @v0(version = "1.3")
    @l
    public static final h1 r5(@k byte[] lastOrNull) {
        f0.p(lastOrNull, "$this$lastOrNull");
        if (i1.u(lastOrNull)) {
            return null;
        }
        return h1.d(i1.p(lastOrNull, i1.r(lastOrNull) - 1));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R r6(short[] maxOfOrNull, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (w1.u(maxOfOrNull)) {
            return null;
        }
        R rI = selector.i(v1.d(w1.p(maxOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(maxOfOrNull, it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float r7(long[] minOfOrNull, ik.l<? super p1, Float> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (q1.u(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(p1.d(q1.p(minOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(p1.d(q1.p(minOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] r8(byte[] plus, byte[] elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        return i1.e(kotlin.collections.m.H3(plus, elements));
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final l1 r9(int[] reduceRightOrNull, p<? super l1, ? super l1, l1> operation) {
        f0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        f0.p(operation, "operation");
        int iVe = ArraysKt___ArraysKt.Ve(reduceRightOrNull);
        if (iVe < 0) {
            return null;
        }
        int iP = m1.p(reduceRightOrNull, iVe);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iP = operation.r0(l1.d(m1.p(reduceRightOrNull, i10)), l1.d(iP)).l0();
        }
        return l1.d(iP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte ra(byte[] single) {
        f0.p(single, "$this$single");
        return h1.j(ArraysKt___ArraysKt.ut(single));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> rb(@k byte[] sorted) {
        f0.p(sorted, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrE = i1.e(bArrCopyOf);
        db(bArrE);
        return b.b(bArrE);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> rc(@k short[] take, int i10) {
        f0.p(take, "$this$take");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= w1.r(take)) {
            return CollectionsKt___CollectionsKt.Q5(w1.b(take));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(v1.d(w1.p(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i10);
        int iR = w1.r(take);
        int i11 = 0;
        for (int i12 = 0; i12 < iR; i12++) {
            arrayList.add(v1.d(w1.p(take, i12)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <V> List<V> rd(short[] zip, short[] other, p<? super v1, ? super v1, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(w1.r(zip), w1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(v1.d(w1.p(zip, i10)), v1.d(w1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V> Map<l1, V> s0(int[] associateWith, ik.l<? super l1, ? extends V> valueSelector) {
        f0.p(associateWith, "$this$associateWith");
        f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.u(r0.j(m1.r(associateWith)), 16));
        int iR = m1.r(associateWith);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(associateWith, i10);
            linkedHashMap.put(l1.d(iP), valueSelector.i(l1.d(iP)));
        }
        return linkedHashMap;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] s1(short[] copyInto, short[] destination, int i10, int i11, int i12) {
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.d1(copyInto, destination, i10, i11, i12);
        return destination;
    }

    @s
    @v0(version = "1.3")
    public static final void s2(@k byte[] fill, byte b10, int i10, int i11) {
        f0.p(fill, "$this$fill");
        kotlin.collections.m.h2(fill, b10, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> s3(int[] flatMap, ik.l<? super l1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMap, "$this$flatMap");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(flatMap);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(arrayList, transform.i(l1.d(m1.p(flatMap, i10))));
        }
        return arrayList;
    }

    public static final int s4(@k short[] lastIndex) {
        f0.p(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.Ye(lastIndex);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final h1 s5(byte[] lastOrNull, ik.l<? super h1, Boolean> predicate) {
        f0.p(lastOrNull, "$this$lastOrNull");
        f0.p(predicate, "predicate");
        int iR = i1.r(lastOrNull) - 1;
        if (iR < 0) {
            return null;
        }
        while (true) {
            int i10 = iR - 1;
            byte bP = i1.p(lastOrNull, iR);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                return h1.d(bP);
            }
            if (i10 < 0) {
                return null;
            }
            iR = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double s6(short[] maxOfOrNull, ik.l<? super v1, Double> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (w1.u(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(v1.d(w1.p(maxOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(v1.d(w1.p(maxOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R s7(int[] minOfOrNull, ik.l<? super l1, ? extends R> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (m1.u(minOfOrNull)) {
            return null;
        }
        R rI = selector.i(l1.d(m1.p(minOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(minOfOrNull, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final long[] s8(@k long[] plus, @k Collection<p1> elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        int iR = q1.r(plus);
        long[] jArrCopyOf = Arrays.copyOf(plus, q1.r(plus) + elements.size());
        f0.o(jArrCopyOf, "copyOf(this, newSize)");
        Iterator<p1> it2 = elements.iterator();
        while (it2.hasNext()) {
            jArrCopyOf[iR] = it2.next().l0();
            iR++;
        }
        return q1.e(jArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final p1 s9(long[] reduceRightOrNull, p<? super p1, ? super p1, p1> operation) {
        f0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        f0.p(operation, "operation");
        int iWe = ArraysKt___ArraysKt.We(reduceRightOrNull);
        if (iWe < 0) {
            return null;
        }
        long jP = q1.p(reduceRightOrNull, iWe);
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jP = operation.r0(p1.d(q1.p(reduceRightOrNull, i10)), p1.d(jP)).l0();
        }
        return p1.d(jP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte sa(byte[] single, ik.l<? super h1, Boolean> predicate) {
        f0.p(single, "$this$single");
        f0.p(predicate, "predicate");
        int iR = i1.r(single);
        h1 h1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(single, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                h1VarD = h1.d(bP);
                z10 = true;
            }
        }
        if (z10) {
            return h1VarD.j0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> sb(@k long[] sorted) {
        f0.p(sorted, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrE = q1.e(jArrCopyOf);
        eb(jArrE);
        return b.c(jArrE);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> sc(@k int[] take, int i10) {
        f0.p(take, "$this$take");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= m1.r(take)) {
            return CollectionsKt___CollectionsKt.Q5(m1.b(take));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(l1.d(m1.p(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i10);
        int iR = m1.r(take);
        int i11 = 0;
        for (int i12 = 0; i12 < iR; i12++) {
            arrayList.add(l1.d(m1.p(take, i12)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R, V> List<V> sd(short[] zip, Iterable<? extends R> other, p<? super v1, ? super R, ? extends V> transform) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iR = w1.r(zip);
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), iR));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= iR) {
                break;
            }
            arrayList.add(transform.r0(v1.d(w1.p(zip, i10)), r10));
            i10++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V> Map<v1, V> t0(short[] associateWith, ik.l<? super v1, ? extends V> valueSelector) {
        f0.p(associateWith, "$this$associateWith");
        f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.u(r0.j(w1.r(associateWith)), 16));
        int iR = w1.r(associateWith);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(associateWith, i10);
            linkedHashMap.put(v1.d(sP), valueSelector.i(v1.d(sP)));
        }
        return linkedHashMap;
    }

    public static /* synthetic */ short[] t1(short[] copyInto, short[] destination, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = w1.r(copyInto);
        }
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.d1(copyInto, destination, i10, i11, i12);
        return destination;
    }

    public static /* synthetic */ void t2(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = i1.r(bArr);
        }
        s2(bArr, b10, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> t3(short[] flatMap, ik.l<? super v1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMap, "$this$flatMap");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(flatMap);
        for (int i10 = 0; i10 < iR; i10++) {
            x.n0(arrayList, transform.i(v1.d(w1.p(flatMap, i10))));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    public static /* synthetic */ void t4(short[] sArr) {
    }

    @f
    @s
    @v0(version = "1.3")
    public static final p1 t5(long[] lastOrNull, ik.l<? super p1, Boolean> predicate) {
        f0.p(lastOrNull, "$this$lastOrNull");
        f0.p(predicate, "predicate");
        int iR = q1.r(lastOrNull) - 1;
        if (iR < 0) {
            return null;
        }
        while (true) {
            int i10 = iR - 1;
            long jP = q1.p(lastOrNull, iR);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                return p1.d(jP);
            }
            if (i10 < 0) {
                return null;
            }
            iR = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float t6(short[] maxOfOrNull, ik.l<? super v1, Float> selector) {
        f0.p(maxOfOrNull, "$this$maxOfOrNull");
        f0.p(selector, "selector");
        if (w1.u(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(v1.d(w1.p(maxOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(v1.d(w1.p(maxOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double t7(int[] minOfOrNull, ik.l<? super l1, Double> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (m1.u(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(l1.d(m1.p(minOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(l1.d(m1.p(minOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short[] t8(short[] plus, short[] elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        return w1.e(kotlin.collections.m.c4(plus, elements));
    }

    @f
    @s
    @v0(version = "1.4")
    @c2(markerClass = {q.class})
    public static final v1 t9(short[] reduceRightOrNull, p<? super v1, ? super v1, v1> operation) {
        f0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        f0.p(operation, "operation");
        int iYe = ArraysKt___ArraysKt.Ye(reduceRightOrNull);
        if (iYe < 0) {
            return null;
        }
        short sP = w1.p(reduceRightOrNull, iYe);
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sP = operation.r0(v1.d(w1.p(reduceRightOrNull, i10)), v1.d(sP)).j0();
        }
        return v1.d(sP);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long ta(long[] single, ik.l<? super p1, Boolean> predicate) {
        f0.p(single, "$this$single");
        f0.p(predicate, "predicate");
        int iR = q1.r(single);
        p1 p1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(single, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                p1VarD = p1.d(jP);
                z10 = true;
            }
        }
        if (z10) {
            return p1VarD.l0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> tb(@k short[] sorted) {
        f0.p(sorted, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrE = w1.e(sArrCopyOf);
        hb(sArrE);
        return b.d(sArrE);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> tc(@k long[] take, int i10) {
        f0.p(take, "$this$take");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= q1.r(take)) {
            return CollectionsKt___CollectionsKt.Q5(q1.b(take));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(p1.d(q1.p(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i10);
        int iR = q1.r(take);
        int i11 = 0;
        for (int i12 = 0; i12 < iR; i12++) {
            arrayList.add(p1.d(q1.p(take, i12)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<Pair<h1, h1>> td(@k byte[] zip, @k byte[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(i1.r(zip), i1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(d1.a(h1.d(i1.p(zip, i10)), h1.d(i1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V, M extends Map<? super l1, ? super V>> M u0(int[] associateWithTo, M destination, ik.l<? super l1, ? extends V> valueSelector) {
        f0.p(associateWithTo, "$this$associateWithTo");
        f0.p(destination, "destination");
        f0.p(valueSelector, "valueSelector");
        int iR = m1.r(associateWithTo);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(associateWithTo, i10);
            destination.put(l1.d(iP), valueSelector.i(l1.d(iP)));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] u1(byte[] copyInto, byte[] destination, int i10, int i11, int i12) {
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.W0(copyInto, destination, i10, i11, i12);
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> u2(byte[] filter, ik.l<? super h1, Boolean> predicate) {
        f0.p(filter, "$this$filter");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(filter);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(filter, i10);
            if (predicate.i(h1.d(bP)).booleanValue()) {
                arrayList.add(h1.d(bP));
            }
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> u3(byte[] flatMapIndexed, p<? super Integer, ? super h1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexed, "$this$flatMapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(flatMapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), h1.d(i1.p(flatMapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short u4(short[] getOrElse, int i10, ik.l<? super Integer, v1> defaultValue) {
        f0.p(getOrElse, "$this$getOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.Ye(getOrElse)) ? defaultValue.i(Integer.valueOf(i10)).j0() : w1.p(getOrElse, i10);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final p1 u5(@k long[] lastOrNull) {
        f0.p(lastOrNull, "$this$lastOrNull");
        if (q1.u(lastOrNull)) {
            return null;
        }
        return p1.d(q1.p(lastOrNull, q1.r(lastOrNull) - 1));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R u6(long[] maxOfWith, Comparator<? super R> comparator, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxOfWith, "$this$maxOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (q1.u(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(p1.d(q1.p(maxOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(maxOfWith, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float u7(int[] minOfOrNull, ik.l<? super l1, Float> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (m1.u(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(l1.d(m1.p(minOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(l1.d(m1.p(minOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final short[] u8(@k short[] plus, @k Collection<v1> elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        int iR = w1.r(plus);
        short[] sArrCopyOf = Arrays.copyOf(plus, w1.r(plus) + elements.size());
        f0.o(sArrCopyOf, "copyOf(this, newSize)");
        Iterator<v1> it2 = elements.iterator();
        while (it2.hasNext()) {
            sArrCopyOf[iR] = it2.next().j0();
            iR++;
        }
        return w1.e(sArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void u9(int[] reverse) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.yr(reverse);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long ua(long[] single) {
        f0.p(single, "$this$single");
        return p1.j(ArraysKt___ArraysKt.Et(single));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final int[] ub(@k int[] sortedArray) {
        f0.p(sortedArray, "$this$sortedArray");
        if (m1.u(sortedArray)) {
            return sortedArray;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrE = m1.e(iArrCopyOf);
        Wa(iArrE);
        return iArrE;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<h1> uc(@k byte[] takeLast, int i10) {
        f0.p(takeLast, "$this$takeLast");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iR = i1.r(takeLast);
        if (i10 >= iR) {
            return CollectionsKt___CollectionsKt.Q5(i1.b(takeLast));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(h1.d(i1.p(takeLast, iR - 1)));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = iR - i10; i11 < iR; i11++) {
            arrayList.add(h1.d(i1.p(takeLast, i11)));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<Pair<v1, v1>> ud(@k short[] zip, @k short[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(w1.r(zip), w1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(d1.a(v1.d(w1.p(zip, i10)), v1.d(w1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V, M extends Map<? super h1, ? super V>> M v0(byte[] associateWithTo, M destination, ik.l<? super h1, ? extends V> valueSelector) {
        f0.p(associateWithTo, "$this$associateWithTo");
        f0.p(destination, "destination");
        f0.p(valueSelector, "valueSelector");
        int iR = i1.r(associateWithTo);
        for (int i10 = 0; i10 < iR; i10++) {
            byte bP = i1.p(associateWithTo, i10);
            destination.put(h1.d(bP), valueSelector.i(h1.d(bP)));
        }
        return destination;
    }

    public static /* synthetic */ byte[] v1(byte[] copyInto, byte[] destination, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = i1.r(copyInto);
        }
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.W0(copyInto, destination, i10, i11, i12);
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> v2(long[] filter, ik.l<? super p1, Boolean> predicate) {
        f0.p(filter, "$this$filter");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(filter);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(filter, i10);
            if (predicate.i(p1.d(jP)).booleanValue()) {
                arrayList.add(p1.d(jP));
            }
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> v3(int[] flatMapIndexed, p<? super Integer, ? super l1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexed, "$this$flatMapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(flatMapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), l1.d(m1.p(flatMapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int v4(int[] getOrElse, int i10, ik.l<? super Integer, l1> defaultValue) {
        f0.p(getOrElse, "$this$getOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.Ve(getOrElse)) ? defaultValue.i(Integer.valueOf(i10)).l0() : m1.p(getOrElse, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final l1 v5(int[] lastOrNull, ik.l<? super l1, Boolean> predicate) {
        f0.p(lastOrNull, "$this$lastOrNull");
        f0.p(predicate, "predicate");
        int iR = m1.r(lastOrNull) - 1;
        if (iR < 0) {
            return null;
        }
        while (true) {
            int i10 = iR - 1;
            int iP = m1.p(lastOrNull, iR);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                return l1.d(iP);
            }
            if (i10 < 0) {
                return null;
            }
            iR = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R v6(byte[] maxOfWith, Comparator<? super R> comparator, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxOfWith, "$this$maxOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (i1.u(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(h1.d(i1.p(maxOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(maxOfWith, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R v7(short[] minOfOrNull, ik.l<? super v1, ? extends R> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (w1.u(minOfOrNull)) {
            return null;
        }
        R rI = selector.i(v1.d(w1.p(minOfOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(minOfOrNull, it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] v8(int[] plus, int i10) {
        f0.p(plus, "$this$plus");
        return m1.e(kotlin.collections.m.R3(plus, i10));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final void v9(long[] reverse, int i10, int i11) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.Br(reverse, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int va(int[] single, ik.l<? super l1, Boolean> predicate) {
        f0.p(single, "$this$single");
        f0.p(predicate, "predicate");
        int iR = m1.r(single);
        l1 l1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(single, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                l1VarD = l1.d(iP);
                z10 = true;
            }
        }
        if (z10) {
            return l1VarD.l0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] vb(@k byte[] sortedArray) {
        f0.p(sortedArray, "$this$sortedArray");
        if (i1.u(sortedArray)) {
            return sortedArray;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrE = i1.e(bArrCopyOf);
        db(bArrE);
        return bArrE;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<v1> vc(@k short[] takeLast, int i10) {
        f0.p(takeLast, "$this$takeLast");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iR = w1.r(takeLast);
        if (i10 >= iR) {
            return CollectionsKt___CollectionsKt.Q5(w1.b(takeLast));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(v1.d(w1.p(takeLast, iR - 1)));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = iR - i10; i11 < iR; i11++) {
            arrayList.add(v1.d(w1.p(takeLast, i11)));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<h1, R>> vd(@k byte[] zip, @k R[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(i1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            byte bP = i1.p(zip, i10);
            arrayList.add(d1.a(h1.d(bP), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V, M extends Map<? super p1, ? super V>> M w0(long[] associateWithTo, M destination, ik.l<? super p1, ? extends V> valueSelector) {
        f0.p(associateWithTo, "$this$associateWithTo");
        f0.p(destination, "destination");
        f0.p(valueSelector, "valueSelector");
        int iR = q1.r(associateWithTo);
        for (int i10 = 0; i10 < iR; i10++) {
            long jP = q1.p(associateWithTo, i10);
            destination.put(p1.d(jP), valueSelector.i(p1.d(jP)));
        }
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] w1(int[] copyInto, int[] destination, int i10, int i11, int i12) {
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.a1(copyInto, destination, i10, i11, i12);
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> w2(int[] filter, ik.l<? super l1, Boolean> predicate) {
        f0.p(filter, "$this$filter");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(filter);
        for (int i10 = 0; i10 < iR; i10++) {
            int iP = m1.p(filter, i10);
            if (predicate.i(l1.d(iP)).booleanValue()) {
                arrayList.add(l1.d(iP));
            }
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> w3(long[] flatMapIndexed, p<? super Integer, ? super p1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexed, "$this$flatMapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = q1.r(flatMapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), p1.d(q1.p(flatMapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long w4(long[] getOrElse, int i10, ik.l<? super Integer, p1> defaultValue) {
        f0.p(getOrElse, "$this$getOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.We(getOrElse)) ? defaultValue.i(Integer.valueOf(i10)).l0() : q1.p(getOrElse, i10);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final v1 w5(@k short[] lastOrNull) {
        f0.p(lastOrNull, "$this$lastOrNull");
        if (w1.u(lastOrNull)) {
            return null;
        }
        return v1.d(w1.p(lastOrNull, w1.r(lastOrNull) - 1));
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R w6(short[] maxOfWith, Comparator<? super R> comparator, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxOfWith, "$this$maxOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (w1.u(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(v1.d(w1.p(maxOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(maxOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(v1.d(w1.p(maxOfWith, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Double w7(short[] minOfOrNull, ik.l<? super v1, Double> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (w1.u(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.i(v1.d(w1.p(minOfOrNull, 0))).doubleValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(v1.d(w1.p(minOfOrNull, it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long[] w8(long[] plus, long[] elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        return q1.e(kotlin.collections.m.W3(plus, elements));
    }

    @f
    @s
    @v0(version = "1.4")
    public static final void w9(byte[] reverse, int i10, int i11) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.rr(reverse, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short wa(short[] single) {
        f0.p(single, "$this$single");
        return v1.j(ArraysKt___ArraysKt.It(single));
    }

    @s
    @v0(version = "1.3")
    @k
    public static final long[] wb(@k long[] sortedArray) {
        f0.p(sortedArray, "$this$sortedArray");
        if (q1.u(sortedArray)) {
            return sortedArray;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        f0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrE = q1.e(jArrCopyOf);
        eb(jArrE);
        return jArrE;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<l1> wc(@k int[] takeLast, int i10) {
        f0.p(takeLast, "$this$takeLast");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iR = m1.r(takeLast);
        if (i10 >= iR) {
            return CollectionsKt___CollectionsKt.Q5(m1.b(takeLast));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(l1.d(m1.p(takeLast, iR - 1)));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = iR - i10; i11 < iR; i11++) {
            arrayList.add(l1.d(m1.p(takeLast, i11)));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final <R> List<Pair<v1, R>> wd(@k short[] zip, @k R[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(w1.r(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            short sP = w1.p(zip, i10);
            arrayList.add(d1.a(v1.d(sP), other[i10]));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.4")
    public static final <V, M extends Map<? super v1, ? super V>> M x0(short[] associateWithTo, M destination, ik.l<? super v1, ? extends V> valueSelector) {
        f0.p(associateWithTo, "$this$associateWithTo");
        f0.p(destination, "destination");
        f0.p(valueSelector, "valueSelector");
        int iR = w1.r(associateWithTo);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(associateWithTo, i10);
            destination.put(v1.d(sP), valueSelector.i(v1.d(sP)));
        }
        return destination;
    }

    public static /* synthetic */ int[] x1(int[] copyInto, int[] destination, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = m1.r(copyInto);
        }
        f0.p(copyInto, "$this$copyInto");
        f0.p(destination, "destination");
        kotlin.collections.m.a1(copyInto, destination, i10, i11, i12);
        return destination;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<v1> x2(short[] filter, ik.l<? super v1, Boolean> predicate) {
        f0.p(filter, "$this$filter");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(filter);
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(filter, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                arrayList.add(v1.d(sP));
            }
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> List<R> x3(short[] flatMapIndexed, p<? super Integer, ? super v1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexed, "$this$flatMapIndexed");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iR = w1.r(flatMapIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), v1.d(w1.p(flatMapIndexed, i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte x4(byte[] getOrElse, int i10, ik.l<? super Integer, h1> defaultValue) {
        f0.p(getOrElse, "$this$getOrElse");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > ArraysKt___ArraysKt.Re(getOrElse)) ? defaultValue.i(Integer.valueOf(i10)).j0() : i1.p(getOrElse, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final v1 x5(short[] lastOrNull, ik.l<? super v1, Boolean> predicate) {
        f0.p(lastOrNull, "$this$lastOrNull");
        f0.p(predicate, "predicate");
        int iR = w1.r(lastOrNull) - 1;
        if (iR < 0) {
            return null;
        }
        while (true) {
            int i10 = iR - 1;
            short sP = w1.p(lastOrNull, iR);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                return v1.d(sP);
            }
            if (i10 < 0) {
                return null;
            }
            iR = i10;
        }
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R x6(int[] maxOfWith, Comparator<? super R> comparator, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxOfWith, "$this$maxOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (m1.u(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(l1.d(m1.p(maxOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ve(maxOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(l1.d(m1.p(maxOfWith, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final Float x7(short[] minOfOrNull, ik.l<? super v1, Float> selector) {
        f0.p(minOfOrNull, "$this$minOfOrNull");
        f0.p(selector, "selector");
        if (w1.u(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.i(v1.d(w1.p(minOfOrNull, 0))).floatValue();
        k0 it2 = new m(1, ArraysKt___ArraysKt.Ye(minOfOrNull)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(v1.d(w1.p(minOfOrNull, it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] x8(@k byte[] plus, @k Collection<h1> elements) {
        f0.p(plus, "$this$plus");
        f0.p(elements, "elements");
        int iR = i1.r(plus);
        byte[] bArrCopyOf = Arrays.copyOf(plus, i1.r(plus) + elements.size());
        f0.o(bArrCopyOf, "copyOf(this, newSize)");
        Iterator<h1> it2 = elements.iterator();
        while (it2.hasNext()) {
            bArrCopyOf[iR] = it2.next().j0();
            iR++;
        }
        return i1.e(bArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.4")
    public static final void x9(short[] reverse, int i10, int i11) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.Fr(reverse, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short xa(short[] single, ik.l<? super v1, Boolean> predicate) {
        f0.p(single, "$this$single");
        f0.p(predicate, "predicate");
        int iR = w1.r(single);
        v1 v1VarD = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < iR; i10++) {
            short sP = w1.p(single, i10);
            if (predicate.i(v1.d(sP)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                v1VarD = v1.d(sP);
                z10 = true;
            }
        }
        if (z10) {
            return v1VarD.j0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s
    @v0(version = "1.3")
    @k
    public static final short[] xb(@k short[] sortedArray) {
        f0.p(sortedArray, "$this$sortedArray");
        if (w1.u(sortedArray)) {
            return sortedArray;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        f0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrE = w1.e(sArrCopyOf);
        hb(sArrE);
        return sArrE;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<p1> xc(@k long[] takeLast, int i10) {
        f0.p(takeLast, "$this$takeLast");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iR = q1.r(takeLast);
        if (i10 >= iR) {
            return CollectionsKt___CollectionsKt.Q5(q1.b(takeLast));
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(p1.d(q1.p(takeLast, iR - 1)));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = iR - i10; i11 < iR; i11++) {
            arrayList.add(p1.d(q1.p(takeLast, i11)));
        }
        return arrayList;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final List<Pair<p1, p1>> xd(@k long[] zip, @k long[] other) {
        f0.p(zip, "$this$zip");
        f0.p(other, "other");
        int iMin = Math.min(q1.r(zip), q1.r(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(d1.a(p1.d(q1.p(zip, i10)), p1.d(q1.p(other, i10))));
        }
        return arrayList;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int y0(int[] component1) {
        f0.p(component1, "$this$component1");
        return m1.p(component1, 0);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int[] y1(int[] copyOf) {
        f0.p(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        return m1.e(iArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> y2(byte[] filterIndexed, p<? super Integer, ? super h1, Boolean> predicate) {
        f0.p(filterIndexed, "$this$filterIndexed");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = i1.r(filterIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            byte bP = i1.p(filterIndexed, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), h1.d(bP)).booleanValue()) {
                arrayList.add(h1.d(bP));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C y3(int[] flatMapIndexedTo, C destination, p<? super Integer, ? super l1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = m1.r(flatMapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), l1.d(m1.p(flatMapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @s
    @v0(version = "1.3")
    @l
    public static final h1 y4(@k byte[] getOrNull, int i10) {
        f0.p(getOrNull, "$this$getOrNull");
        if (i10 < 0 || i10 > ArraysKt___ArraysKt.Re(getOrNull)) {
            return null;
        }
        return h1.d(i1.p(getOrNull, i10));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> y5(byte[] map, ik.l<? super h1, ? extends R> transform) {
        f0.p(map, "$this$map");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(i1.r(map));
        int iR = i1.r(map);
        for (int i10 = 0; i10 < iR; i10++) {
            arrayList.add(transform.i(h1.d(i1.p(map, i10))));
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R y6(long[] maxOfWithOrNull, Comparator<? super R> comparator, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (q1.u(maxOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(p1.d(q1.p(maxOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(maxOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(maxOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R y7(long[] minOfWith, Comparator<? super R> comparator, ik.l<? super p1, ? extends R> selector) {
        f0.p(minOfWith, "$this$minOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (q1.u(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(p1.d(q1.p(minOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.We(minOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(p1.d(q1.p(minOfWith, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int y8(int[] random) {
        f0.p(random, "$this$random");
        return z8(random, Random.f38003a);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void y9(byte[] reverse) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.qr(reverse);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final l1 ya(@k int[] singleOrNull) {
        f0.p(singleOrNull, "$this$singleOrNull");
        if (m1.r(singleOrNull) == 1) {
            return l1.d(m1.p(singleOrNull, 0));
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final int[] yb(@k int[] sortedArrayDescending) {
        f0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (m1.u(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        f0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrE = m1.e(iArrCopyOf);
        ib(iArrE);
        return iArrE;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<h1> yc(byte[] takeLastWhile, ik.l<? super h1, Boolean> predicate) {
        f0.p(takeLastWhile, "$this$takeLastWhile");
        f0.p(predicate, "predicate");
        for (int iRe = ArraysKt___ArraysKt.Re(takeLastWhile); -1 < iRe; iRe--) {
            if (!predicate.i(h1.d(i1.p(takeLastWhile, iRe))).booleanValue()) {
                return O1(takeLastWhile, iRe + 1);
            }
        }
        return CollectionsKt___CollectionsKt.Q5(i1.b(takeLastWhile));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte z0(byte[] component1) {
        f0.p(component1, "$this$component1");
        return i1.p(component1, 0);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte[] z1(byte[] copyOf) {
        f0.p(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        return i1.e(bArrCopyOf);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<l1> z2(int[] filterIndexed, p<? super Integer, ? super l1, Boolean> predicate) {
        f0.p(filterIndexed, "$this$filterIndexed");
        f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iR = m1.r(filterIndexed);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            int iP = m1.p(filterIndexed, i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), l1.d(iP)).booleanValue()) {
                arrayList.add(l1.d(iP));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C z3(short[] flatMapIndexedTo, C destination, p<? super Integer, ? super v1, ? extends Iterable<? extends R>> transform) {
        f0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int iR = w1.r(flatMapIndexedTo);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iR) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), v1.d(w1.p(flatMapIndexedTo, i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @s
    @v0(version = "1.3")
    @l
    public static final v1 z4(@k short[] getOrNull, int i10) {
        f0.p(getOrNull, "$this$getOrNull");
        if (i10 < 0 || i10 > ArraysKt___ArraysKt.Ye(getOrNull)) {
            return null;
        }
        return v1.d(w1.p(getOrNull, i10));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final <R> List<R> z5(long[] map, ik.l<? super p1, ? extends R> transform) {
        f0.p(map, "$this$map");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(q1.r(map));
        int iR = q1.r(map);
        for (int i10 = 0; i10 < iR; i10++) {
            arrayList.add(transform.i(p1.d(q1.p(map, i10))));
        }
        return arrayList;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R z6(byte[] maxOfWithOrNull, Comparator<? super R> comparator, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (i1.u(maxOfWithOrNull)) {
            return null;
        }
        R rI = selector.i(h1.d(i1.p(maxOfWithOrNull, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(maxOfWithOrNull)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(maxOfWithOrNull, it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final <R> R z7(byte[] minOfWith, Comparator<? super R> comparator, ik.l<? super h1, ? extends R> selector) {
        f0.p(minOfWith, "$this$minOfWith");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (i1.u(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(h1.d(i1.p(minOfWith, 0)));
        k0 it2 = new m(1, ArraysKt___ArraysKt.Re(minOfWith)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(h1.d(i1.p(minOfWith, it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @s
    @v0(version = "1.3")
    public static final int z8(@k int[] random, @k Random random2) {
        f0.p(random, "$this$random");
        f0.p(random2, "random");
        if (m1.u(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return m1.p(random, random2.p(m1.r(random)));
    }

    @f
    @s
    @v0(version = "1.3")
    public static final void z9(long[] reverse) {
        f0.p(reverse, "$this$reverse");
        ArraysKt___ArraysKt.Ar(reverse);
    }

    @s
    @v0(version = "1.3")
    @l
    public static final h1 za(@k byte[] singleOrNull) {
        f0.p(singleOrNull, "$this$singleOrNull");
        if (i1.r(singleOrNull) == 1) {
            return h1.d(i1.p(singleOrNull, 0));
        }
        return null;
    }

    @s
    @v0(version = "1.3")
    @k
    public static final byte[] zb(@k byte[] sortedArrayDescending) {
        f0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (i1.u(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        f0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrE = i1.e(bArrCopyOf);
        mb(bArrE);
        return bArrE;
    }

    @f
    @s
    @v0(version = "1.3")
    public static final List<p1> zc(long[] takeLastWhile, ik.l<? super p1, Boolean> predicate) {
        f0.p(takeLastWhile, "$this$takeLastWhile");
        f0.p(predicate, "predicate");
        for (int iWe = ArraysKt___ArraysKt.We(takeLastWhile); -1 < iWe; iWe--) {
            if (!predicate.i(p1.d(q1.p(takeLastWhile, iWe))).booleanValue()) {
                return R1(takeLastWhile, iWe + 1);
            }
        }
        return CollectionsKt___CollectionsKt.Q5(q1.b(takeLastWhile));
    }
}
