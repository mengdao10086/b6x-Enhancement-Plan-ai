package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.c2;
import kotlin.l1;
import kotlin.p1;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.z1;
import uj.g;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,24693:1\n12794#1,2:24694\n12804#1,2:24696\n1282#1,2:24698\n1290#1,2:24700\n1298#1,2:24702\n1306#1,2:24704\n1314#1,2:24706\n1322#1,2:24708\n1330#1,2:24710\n1338#1,2:24712\n1346#1,2:24714\n2298#1,5:24716\n2311#1,5:24721\n2324#1,5:24726\n2337#1,5:24731\n2350#1,5:24736\n2363#1,5:24741\n2376#1,5:24746\n2389#1,5:24751\n2402#1,5:24756\n4307#1,2:24762\n4317#1,2:24764\n4327#1,2:24766\n4337#1,2:24768\n4347#1,2:24770\n4357#1,2:24772\n4367#1,2:24774\n4377#1,2:24776\n4387#1,2:24778\n3974#1:24780\n13644#1,2:24781\n3975#1,2:24783\n13646#1:24785\n3977#1:24786\n3988#1:24787\n13654#1,2:24788\n3989#1,2:24790\n13656#1:24792\n3991#1:24793\n4002#1:24794\n13664#1,2:24795\n4003#1,2:24797\n13666#1:24799\n4005#1:24800\n4016#1:24801\n13674#1,2:24802\n4017#1,2:24804\n13676#1:24806\n4019#1:24807\n4030#1:24808\n13684#1,2:24809\n4031#1,2:24811\n13686#1:24813\n4033#1:24814\n4044#1:24815\n13694#1,2:24816\n4045#1,2:24818\n13696#1:24820\n4047#1:24821\n4058#1:24822\n13704#1,2:24823\n4059#1,2:24825\n13706#1:24827\n4061#1:24828\n4072#1:24829\n13714#1,2:24830\n4073#1,2:24832\n13716#1:24834\n4075#1:24835\n4086#1:24836\n13724#1,2:24837\n4087#1,2:24839\n13726#1:24841\n4089#1:24842\n13644#1,3:24843\n13654#1,3:24846\n13664#1,3:24849\n13674#1,3:24852\n13684#1,3:24855\n13694#1,3:24858\n13704#1,3:24861\n13714#1,3:24864\n13724#1,3:24867\n4107#1,2:24870\n4217#1,2:24872\n4227#1,2:24874\n4237#1,2:24876\n4247#1,2:24878\n4257#1,2:24880\n4267#1,2:24882\n4277#1,2:24884\n4287#1,2:24886\n4297#1,2:24888\n9358#1,4:24890\n9373#1,4:24894\n9388#1,4:24898\n9403#1,4:24902\n9418#1,4:24906\n9433#1,4:24910\n9448#1,4:24914\n9463#1,4:24918\n9478#1,4:24922\n9071#1,4:24926\n9087#1,4:24930\n9103#1,4:24934\n9119#1,4:24938\n9135#1,4:24942\n9151#1,4:24946\n9167#1,4:24950\n9183#1,4:24954\n9199#1,4:24958\n9215#1,4:24962\n9231#1,4:24966\n9247#1,4:24970\n9263#1,4:24974\n9279#1,4:24978\n9295#1,4:24982\n9311#1,4:24986\n9327#1,4:24990\n9343#1,4:24994\n9646#1,4:24998\n10664#1,5:25002\n10675#1,5:25007\n10686#1,5:25012\n10697#1,5:25017\n10708#1,5:25022\n10719#1,5:25027\n10730#1,5:25032\n10741#1,5:25037\n10752#1,5:25042\n10767#1,5:25047\n11008#1,3:25052\n11011#1,3:25062\n11025#1,3:25065\n11028#1,3:25075\n11042#1,3:25078\n11045#1,3:25088\n11059#1,3:25091\n11062#1,3:25101\n11076#1,3:25104\n11079#1,3:25114\n11093#1,3:25117\n11096#1,3:25127\n11110#1,3:25130\n11113#1,3:25140\n11127#1,3:25143\n11130#1,3:25153\n11144#1,3:25156\n11147#1,3:25166\n11162#1,3:25169\n11165#1,3:25179\n11180#1,3:25182\n11183#1,3:25192\n11198#1,3:25195\n11201#1,3:25205\n11216#1,3:25208\n11219#1,3:25218\n11234#1,3:25221\n11237#1,3:25231\n11252#1,3:25234\n11255#1,3:25244\n11270#1,3:25247\n11273#1,3:25257\n11288#1,3:25260\n11291#1,3:25270\n11306#1,3:25273\n11309#1,3:25283\n11670#1,3:25412\n11680#1,3:25415\n11690#1,3:25418\n11700#1,3:25421\n11710#1,3:25424\n11720#1,3:25427\n11730#1,3:25430\n11740#1,3:25433\n11750#1,3:25436\n11536#1,4:25439\n11549#1,4:25443\n11562#1,4:25447\n11575#1,4:25451\n11588#1,4:25455\n11601#1,4:25459\n11614#1,4:25463\n11627#1,4:25467\n11640#1,4:25471\n11525#1:25475\n13644#1,2:25476\n13646#1:25479\n11526#1:25480\n13644#1,3:25481\n11661#1:25484\n13579#1:25485\n13580#1:25487\n11662#1:25488\n13579#1,2:25489\n13644#1,3:25491\n13654#1,3:25494\n13664#1,3:25497\n13674#1,3:25500\n13684#1,3:25503\n13694#1,3:25506\n13704#1,3:25509\n13714#1,3:25512\n13724#1,3:25515\n20893#1,2:25518\n20895#1,6:25521\n21109#1,2:25527\n21111#1,6:25530\n23305#1,6:25536\n23321#1,6:25542\n23337#1,6:25548\n23353#1,6:25554\n23369#1,6:25560\n23385#1,6:25566\n23401#1,6:25572\n23417#1,6:25578\n23433#1,6:25584\n23539#1,8:25590\n23557#1,8:25598\n23575#1,8:25606\n23593#1,8:25614\n23611#1,8:25622\n23629#1,8:25630\n23647#1,8:25638\n23665#1,8:25646\n23683#1,8:25654\n23781#1,6:25662\n23797#1,6:25668\n23813#1,6:25674\n23829#1,6:25680\n23845#1,6:25686\n23861#1,6:25692\n23877#1,6:25698\n23893#1,6:25704\n1#2:24761\n1#2:25478\n1#2:25486\n1#2:25520\n1#2:25529\n361#3,7:25055\n361#3,7:25068\n361#3,7:25081\n361#3,7:25094\n361#3,7:25107\n361#3,7:25120\n361#3,7:25133\n361#3,7:25146\n361#3,7:25159\n361#3,7:25172\n361#3,7:25185\n361#3,7:25198\n361#3,7:25211\n361#3,7:25224\n361#3,7:25237\n361#3,7:25250\n361#3,7:25263\n361#3,7:25276\n361#3,7:25286\n361#3,7:25293\n361#3,7:25300\n361#3,7:25307\n361#3,7:25314\n361#3,7:25321\n361#3,7:25328\n361#3,7:25335\n361#3,7:25342\n361#3,7:25349\n361#3,7:25356\n361#3,7:25363\n361#3,7:25370\n361#3,7:25377\n361#3,7:25384\n361#3,7:25391\n361#3,7:25398\n361#3,7:25405\n*S KotlinDebug\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n556#1:24694,2\n565#1:24696,2\n832#1:24698,2\n842#1:24700,2\n852#1:24702,2\n862#1:24704,2\n872#1:24706,2\n882#1:24708,2\n892#1:24710,2\n902#1:24712,2\n912#1:24714,2\n922#1:24716,5\n932#1:24721,5\n942#1:24726,5\n952#1:24731,5\n962#1:24736,5\n972#1:24741,5\n982#1:24746,5\n992#1:24751,5\n1002#1:24756,5\n3792#1:24762,2\n3801#1:24764,2\n3810#1:24766,2\n3819#1:24768,2\n3828#1:24770,2\n3837#1:24772,2\n3846#1:24774,2\n3855#1:24776,2\n3864#1:24778,2\n3875#1:24780\n3875#1:24781,2\n3875#1:24783,2\n3875#1:24785\n3875#1:24786\n3886#1:24787\n3886#1:24788,2\n3886#1:24790,2\n3886#1:24792\n3886#1:24793\n3897#1:24794\n3897#1:24795,2\n3897#1:24797,2\n3897#1:24799\n3897#1:24800\n3908#1:24801\n3908#1:24802,2\n3908#1:24804,2\n3908#1:24806\n3908#1:24807\n3919#1:24808\n3919#1:24809,2\n3919#1:24811,2\n3919#1:24813\n3919#1:24814\n3930#1:24815\n3930#1:24816,2\n3930#1:24818,2\n3930#1:24820\n3930#1:24821\n3941#1:24822\n3941#1:24823,2\n3941#1:24825,2\n3941#1:24827\n3941#1:24828\n3952#1:24829\n3952#1:24830,2\n3952#1:24832,2\n3952#1:24834\n3952#1:24835\n3963#1:24836\n3963#1:24837,2\n3963#1:24839,2\n3963#1:24841\n3963#1:24842\n3974#1:24843,3\n3988#1:24846,3\n4002#1:24849,3\n4016#1:24852,3\n4030#1:24855,3\n4044#1:24858,3\n4058#1:24861,3\n4072#1:24864,3\n4086#1:24867,3\n4098#1:24870,2\n4117#1:24872,2\n4126#1:24874,2\n4135#1:24876,2\n4144#1:24878,2\n4153#1:24880,2\n4162#1:24882,2\n4171#1:24884,2\n4180#1:24886,2\n4189#1:24888,2\n8677#1:24890,4\n8692#1:24894,4\n8707#1:24898,4\n8722#1:24902,4\n8737#1:24906,4\n8752#1:24910,4\n8767#1:24914,4\n8782#1:24918,4\n8797#1:24922,4\n8812#1:24926,4\n8827#1:24930,4\n8842#1:24934,4\n8857#1:24938,4\n8872#1:24942,4\n8887#1:24946,4\n8902#1:24950,4\n8917#1:24954,4\n8932#1:24958,4\n8946#1:24962,4\n8960#1:24966,4\n8974#1:24970,4\n8988#1:24974,4\n9002#1:24978,4\n9016#1:24982,4\n9030#1:24986,4\n9044#1:24990,4\n9058#1:24994,4\n9497#1:24998,4\n10242#1:25002,5\n10251#1:25007,5\n10260#1:25012,5\n10269#1:25017,5\n10278#1:25022,5\n10287#1:25027,5\n10296#1:25032,5\n10305#1:25037,5\n10314#1:25042,5\n10327#1:25047,5\n10783#1:25052,3\n10783#1:25062,3\n10795#1:25065,3\n10795#1:25075,3\n10807#1:25078,3\n10807#1:25088,3\n10819#1:25091,3\n10819#1:25101,3\n10831#1:25104,3\n10831#1:25114,3\n10843#1:25117,3\n10843#1:25127,3\n10855#1:25130,3\n10855#1:25140,3\n10867#1:25143,3\n10867#1:25153,3\n10879#1:25156,3\n10879#1:25166,3\n10892#1:25169,3\n10892#1:25179,3\n10905#1:25182,3\n10905#1:25192,3\n10918#1:25195,3\n10918#1:25205,3\n10931#1:25208,3\n10931#1:25218,3\n10944#1:25221,3\n10944#1:25231,3\n10957#1:25234,3\n10957#1:25244,3\n10970#1:25247,3\n10970#1:25257,3\n10983#1:25260,3\n10983#1:25270,3\n10996#1:25273,3\n10996#1:25283,3\n11335#1:25412,3\n11345#1:25415,3\n11355#1:25418,3\n11365#1:25421,3\n11375#1:25424,3\n11385#1:25427,3\n11395#1:25430,3\n11405#1:25433,3\n11415#1:25436,3\n11425#1:25439,4\n11435#1:25443,4\n11445#1:25447,4\n11455#1:25451,4\n11465#1:25455,4\n11475#1:25459,4\n11485#1:25463,4\n11495#1:25467,4\n11505#1:25471,4\n11515#1:25475\n11515#1:25476,2\n11515#1:25479\n11515#1:25480\n11525#1:25481,3\n11653#1:25484\n11653#1:25485\n11653#1:25487\n11653#1:25488\n11661#1:25489,2\n19161#1:25491,3\n19173#1:25494,3\n19185#1:25497,3\n19197#1:25500,3\n19209#1:25503,3\n19221#1:25506,3\n19233#1:25509,3\n19245#1:25512,3\n19257#1:25515,3\n21725#1:25518,2\n21725#1:25521,6\n21887#1:25527,2\n21887#1:25530,6\n23214#1:25536,6\n23224#1:25542,6\n23234#1:25548,6\n23244#1:25554,6\n23254#1:25560,6\n23264#1:25566,6\n23274#1:25572,6\n23284#1:25578,6\n23294#1:25584,6\n23448#1:25590,8\n23458#1:25598,8\n23468#1:25606,8\n23478#1:25614,8\n23488#1:25622,8\n23498#1:25630,8\n23508#1:25638,8\n23518#1:25646,8\n23528#1:25654,8\n23700#1:25662,6\n23710#1:25668,6\n23720#1:25674,6\n23730#1:25680,6\n23740#1:25686,6\n23750#1:25692,6\n23760#1:25698,6\n23770#1:25704,6\n11515#1:25478\n11653#1:25486\n21725#1:25520\n21887#1:25529\n10783#1:25055,7\n10795#1:25068,7\n10807#1:25081,7\n10819#1:25094,7\n10831#1:25107,7\n10843#1:25120,7\n10855#1:25133,7\n10867#1:25146,7\n10879#1:25159,7\n10892#1:25172,7\n10905#1:25185,7\n10918#1:25198,7\n10931#1:25211,7\n10944#1:25224,7\n10957#1:25237,7\n10970#1:25250,7\n10983#1:25263,7\n10996#1:25276,7\n11010#1:25286,7\n11027#1:25293,7\n11044#1:25300,7\n11061#1:25307,7\n11078#1:25314,7\n11095#1:25321,7\n11112#1:25328,7\n11129#1:25335,7\n11146#1:25342,7\n11164#1:25349,7\n11182#1:25356,7\n11200#1:25363,7\n11218#1:25370,7\n11236#1:25377,7\n11254#1:25384,7\n11272#1:25391,7\n11290#1:25398,7\n11308#1:25405,7\n*E\n"})
public class ArraysKt___ArraysKt extends kotlin.collections.m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24236#2:71\n*E\n"})
    public static final class a<T> implements Iterable<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f37644a;

        public a(Object[] objArr) {
            this.f37644a = objArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.h.a(this.f37644a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24244#2:71\n*E\n"})
    public static final class b implements Iterable<Byte>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f37645a;

        public b(byte[] bArr) {
            this.f37645a = bArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.i.b(this.f37645a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24252#2:71\n*E\n"})
    public static final class c implements Iterable<Short>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ short[] f37646a;

        public c(short[] sArr) {
            this.f37646a = sArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.i.h(this.f37646a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24260#2:71\n*E\n"})
    public static final class d implements Iterable<Integer>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f37647a;

        public d(int[] iArr) {
            this.f37647a = iArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.i.f(this.f37647a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24268#2:71\n*E\n"})
    public static final class e implements Iterable<Long>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f37648a;

        public e(long[] jArr) {
            this.f37648a = jArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.i.g(this.f37648a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24276#2:71\n*E\n"})
    public static final class f implements Iterable<Float>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f37649a;

        public f(float[] fArr) {
            this.f37649a = fArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.i.e(this.f37649a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24284#2:71\n*E\n"})
    public static final class g implements Iterable<Double>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double[] f37650a;

        public g(double[] dArr) {
            this.f37650a = dArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.i.d(this.f37650a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24292#2:71\n*E\n"})
    public static final class h implements Iterable<Boolean>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f37651a;

        public h(boolean[] zArr) {
            this.f37651a = zArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.i.a(this.f37651a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24300#2:71\n*E\n"})
    public static final class i implements Iterable<Character>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f37652a;

        public i(char[] cArr) {
            this.f37652a = cArr;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.i.c(this.f37652a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24310#2:681\n*E\n"})
    public static final class j<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f37653a;

        public j(Object[] objArr) {
            this.f37653a = objArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.h.a(this.f37653a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24320#2:681\n*E\n"})
    public static final class k implements kotlin.sequences.m<Byte> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f37654a;

        public k(byte[] bArr) {
            this.f37654a = bArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.i.b(this.f37654a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24330#2:681\n*E\n"})
    public static final class l implements kotlin.sequences.m<Short> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ short[] f37655a;

        public l(short[] sArr) {
            this.f37655a = sArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.i.h(this.f37655a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24340#2:681\n*E\n"})
    public static final class m implements kotlin.sequences.m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f37656a;

        public m(int[] iArr) {
            this.f37656a = iArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.i.f(this.f37656a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24350#2:681\n*E\n"})
    public static final class n implements kotlin.sequences.m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f37657a;

        public n(long[] jArr) {
            this.f37657a = jArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.i.g(this.f37657a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24360#2:681\n*E\n"})
    public static final class o implements kotlin.sequences.m<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f37658a;

        public o(float[] fArr) {
            this.f37658a = fArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.i.e(this.f37658a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24370#2:681\n*E\n"})
    public static final class p implements kotlin.sequences.m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double[] f37659a;

        public p(double[] dArr) {
            this.f37659a = dArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.i.d(this.f37659a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24380#2:681\n*E\n"})
    public static final class q implements kotlin.sequences.m<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f37660a;

        public q(boolean[] zArr) {
            this.f37660a = zArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.i.a(this.f37660a);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24390#2:681\n*E\n"})
    public static final class r implements kotlin.sequences.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f37661a;

        public r(char[] cArr) {
            this.f37661a = cArr;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.i.c(this.f37661a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @kotlin.jvm.internal.t0({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt$groupingBy$1\n*L\n1#1,24693:1\n*E\n"})
    public static final class s<K, T> implements d0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T[] f37662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f37663b;

        /* JADX WARN: Multi-variable type inference failed */
        public s(T[] tArr, ik.l<? super T, ? extends K> lVar) {
            this.f37662a = tArr;
            this.f37663b = lVar;
        }

        @Override // kotlin.collections.d0
        public K a(T t10) {
            return this.f37663b.i(t10);
        }

        @Override // kotlin.collections.d0
        @yt.k
        public Iterator<T> b() {
            return kotlin.jvm.internal.h.a(this.f37662a);
        }
    }

    public static final boolean A5(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (!predicate.i(Long.valueOf(j10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K, V> Map<K, V> A6(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(cArr.length), 16));
        for (char c10 : cArr) {
            linkedHashMap.put(keySelector.i(Character.valueOf(c10)), valueTransform.i(Character.valueOf(c10)));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Character, ? super V>> M A7(char[] cArr, M destination, ik.l<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (char c10 : cArr) {
            destination.put(Character.valueOf(c10), valueSelector.i(Character.valueOf(c10)));
        }
        return destination;
    }

    @bk.f
    public static final long A8(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr[3];
    }

    @yt.k
    public static final <K> List<Float> A9(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (hashSet.add(selector.i(Float.valueOf(f10)))) {
                arrayList.add(Float.valueOf(f10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Pair<Float, Float>> AA(@yt.k float[] fArr, @yt.k float[] other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Float.valueOf(fArr[i10]), Float.valueOf(other[i10])));
        }
        return arrayList;
    }

    @bk.f
    public static final Byte Aa(byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return kf(bArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Integer>> C Ab(@yt.k int[] iArr, @yt.k C destination, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (!predicate.i(Integer.valueOf(i10)).booleanValue()) {
                destination.add(Integer.valueOf(i10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Boolean Ac(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C Ad(@yt.k float[] fArr, @yt.k C destination, @yt.k ik.l<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (float f10 : fArr) {
            x.n0(destination, transform.i(Float.valueOf(f10)));
        }
        return destination;
    }

    public static final void Ae(@yt.k char[] cArr, @yt.k ik.p<? super Integer, ? super Character, z1> action) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Character.valueOf(cArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K> Map<K, List<Integer>> Af(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 : iArr) {
            K kI = keySelector.i(Integer.valueOf(i10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i10));
        }
        return linkedHashMap;
    }

    public static final int Ag(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final String Ah(@yt.k float[] fArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Float, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) ih(fArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Integer Ai(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Float Aj(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f10);
        }
        R rI = selector.i(Float.valueOf(f10));
        k0 it2 = new qk.m(1, iUe).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            R rI2 = selector.i(Float.valueOf(f11));
            if (rI.compareTo(rI2) < 0) {
                f10 = f11;
                rI = rI2;
            }
        }
        return Float.valueOf(f10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Ak(double[] dArr, ik.l<? super Double, Double> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Double.valueOf(dArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Double.valueOf(dArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    @yt.k
    public static final <T extends Comparable<? super T>> T Al(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (t10.compareTo(t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float Am(long[] jArr, ik.l<? super Long, Float> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Long.valueOf(jArr[0])).floatValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Long.valueOf(jArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R An(float[] fArr, Comparator<? super R> comparator, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean Ao(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    @kotlin.v0(version = "1.3")
    public static final short Ap(@yt.k short[] sArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[random.p(sArr.length)];
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float Aq(@yt.k float[] fArr, @yt.k ik.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = operation.r0(Float.valueOf(fFloatValue), Float.valueOf(fArr[it2.b()])).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static final void Ar(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iWe = We(jArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            long j10 = jArr[iB];
            jArr[iB] = jArr[iWe];
            jArr[iWe] = j10;
            iWe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Boolean> As(boolean[] zArr, ik.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        boolean zBooleanValue = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(zBooleanValue));
        int length = zArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            zBooleanValue = operation.r0(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i10])).booleanValue();
            arrayList.add(Boolean.valueOf(zBooleanValue));
        }
        return arrayList;
    }

    public static final float At(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final double[] Au(@yt.k double[] dArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            dArr2[i10] = dArr[it2.next().intValue()];
            i10++;
        }
        return dArr2;
    }

    @yt.k
    public static final int[] Av(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.f0.o(iArrCopyOf, "copyOf(this, size)");
        Yu(iArrCopyOf);
        return iArrCopyOf;
    }

    public static final int Aw(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        return i10;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long Ax(boolean[] zArr, ik.l<? super Boolean, Long> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (boolean z10 : zArr) {
            jLongValue += selector.i(Boolean.valueOf(z10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Long> Ay(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (!predicate.i(Long.valueOf(j10)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Long> Az(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return (Set) My(jArr, new LinkedHashSet(r0.j(jArr.length)));
    }

    public static final <T> boolean B5(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (!predicate.i(t10).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K> Map<K, Double> B6(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(dArr.length), 16));
        for (double d10 : dArr) {
            linkedHashMap.put(keySelector.i(Double.valueOf(d10)), Double.valueOf(d10));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Double, ? super V>> M B7(double[] dArr, M destination, ik.l<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (double d10 : dArr) {
            destination.put(Double.valueOf(d10), valueSelector.i(Double.valueOf(d10)));
        }
        return destination;
    }

    @bk.f
    public static final <T> T B8(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr[3];
    }

    @yt.k
    public static final <K> List<Integer> B9(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (hashSet.add(selector.i(Integer.valueOf(i10)))) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <V> List<V> BA(@yt.k float[] fArr, @yt.k float[] other, @yt.k ik.p<? super Float, ? super Float, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Float.valueOf(fArr[i10]), Float.valueOf(other[i10])));
        }
        return arrayList;
    }

    @bk.f
    public static final Character Ba(char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return lf(cArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Long>> C Bb(@yt.k long[] jArr, @yt.k C destination, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (!predicate.i(Long.valueOf(j10)).booleanValue()) {
                destination.add(Long.valueOf(j10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Boolean Bc(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return Boolean.valueOf(z10);
            }
        }
        return null;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C Bd(@yt.k int[] iArr, @yt.k C destination, @yt.k ik.l<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (int i10 : iArr) {
            x.n0(destination, transform.i(Integer.valueOf(i10)));
        }
        return destination;
    }

    public static final void Be(@yt.k double[] dArr, @yt.k ik.p<? super Integer, ? super Double, z1> action) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Double.valueOf(dArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> Bf(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends K> keySelector, @yt.k ik.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 : iArr) {
            K kI = keySelector.i(Integer.valueOf(i10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Integer.valueOf(i10)));
        }
        return linkedHashMap;
    }

    public static final <T> int Bg(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final String Bh(@yt.k int[] iArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Integer, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) jh(iArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Integer Bi(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            int i11 = iArr[length];
            if (predicate.i(Integer.valueOf(i11)).booleanValue()) {
                return Integer.valueOf(i11);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Integer Bj(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i10);
        }
        R rI = selector.i(Integer.valueOf(i10));
        k0 it2 = new qk.m(1, iVe).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            R rI2 = selector.i(Integer.valueOf(i11));
            if (rI.compareTo(rI2) < 0) {
                i10 = i11;
                rI = rI2;
            }
        }
        return Integer.valueOf(i10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Bk(float[] fArr, ik.l<? super Float, Double> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Float.valueOf(fArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Float.valueOf(fArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final short Bl(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (s10 < s11) {
                s10 = s11;
            }
        }
        return s10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> float Bm(T[] tArr, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(tArr[0]).floatValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(tArr[it2.b()]).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Bn(int[] iArr, Comparator<? super R> comparator, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean Bo(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final boolean Bp(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return Cp(zArr, Random.f38003a);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer Bq(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            iIntValue = operation.r0(Integer.valueOf(iIntValue), Integer.valueOf(iArr[it2.b()])).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @kotlin.v0(version = "1.4")
    public static final void Br(@yt.k long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, jArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            long j10 = jArr[i10];
            jArr[i10] = jArr[i13];
            jArr[i13] = j10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Byte> Bs(byte[] bArr, ik.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            bByteValue = operation.A(Integer.valueOf(i10), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i10])).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    public static final float Bt(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Float fValueOf = null;
        boolean z10 = false;
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                fValueOf = Float.valueOf(f10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(fValueOf, "null cannot be cast to non-null type kotlin.Float");
        return fValueOf.floatValue();
    }

    @yt.k
    public static final double[] Bu(@yt.k double[] dArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new double[0] : kotlin.collections.m.I1(dArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final long[] Bv(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.f0.o(jArrCopyOf, "copyOf(this, size)");
        av(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final int Bw(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int i10 = 0;
        for (short s10 : sArr) {
            i10 += s10;
        }
        return i10;
    }

    @hk.h(name = "sumOfShort")
    public static final int Bx(@yt.k Short[] shArr) {
        kotlin.jvm.internal.f0.p(shArr, "<this>");
        int iShortValue = 0;
        for (Short sh2 : shArr) {
            iShortValue += sh2.shortValue();
        }
        return iShortValue;
    }

    @yt.k
    public static final <T> List<T> By(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (!predicate.i(t10).booleanValue()) {
                break;
            }
            arrayList.add(t10);
        }
        return arrayList;
    }

    @yt.k
    public static final <T> Set<T> Bz(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (Set) Ny(tArr, new LinkedHashSet(r0.j(tArr.length)));
    }

    public static final boolean C5(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (!predicate.i(Short.valueOf(s10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K, V> Map<K, V> C6(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends K> keySelector, @yt.k ik.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(dArr.length), 16));
        for (double d10 : dArr) {
            linkedHashMap.put(keySelector.i(Double.valueOf(d10)), valueTransform.i(Double.valueOf(d10)));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Float, ? super V>> M C7(float[] fArr, M destination, ik.l<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (float f10 : fArr) {
            destination.put(Float.valueOf(f10), valueSelector.i(Float.valueOf(f10)));
        }
        return destination;
    }

    @bk.f
    public static final short C8(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr[3];
    }

    @yt.k
    public static final <K> List<Long> C9(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (hashSet.add(selector.i(Long.valueOf(j10)))) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R> List<Pair<Float, R>> CA(@yt.k float[] fArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            float f10 = fArr[i10];
            arrayList.add(kotlin.d1.a(Float.valueOf(f10), other[i10]));
        }
        return arrayList;
    }

    @bk.f
    public static final Double Ca(double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return mf(dArr, i10);
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C Cb(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (!predicate.i(t10).booleanValue()) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @yt.l
    public static final Byte Cc(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C Cd(@yt.k long[] jArr, @yt.k C destination, @yt.k ik.l<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (long j10 : jArr) {
            x.n0(destination, transform.i(Long.valueOf(j10)));
        }
        return destination;
    }

    public static final void Ce(@yt.k float[] fArr, @yt.k ik.p<? super Integer, ? super Float, z1> action) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Float.valueOf(fArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K> Map<K, List<Long>> Cf(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j10 : jArr) {
            K kI = keySelector.i(Long.valueOf(j10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j10));
        }
        return linkedHashMap;
    }

    public static final int Cg(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final String Ch(@yt.k long[] jArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Long, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) kh(jArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Long Ci(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Long Cj(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j10);
        }
        R rI = selector.i(Long.valueOf(j10));
        k0 it2 = new qk.m(1, iWe).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            R rI2 = selector.i(Long.valueOf(j11));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Ck(int[] iArr, ik.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Integer.valueOf(iArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Integer.valueOf(iArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean Cl(@yt.k boolean[] zArr, @yt.k Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) < 0) {
                z10 = z11;
            }
        }
        return Boolean.valueOf(z10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float Cm(short[] sArr, ik.l<? super Short, Float> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Short.valueOf(sArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Short.valueOf(sArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Cn(long[] jArr, Comparator<? super R> comparator, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean Co(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    @kotlin.v0(version = "1.3")
    public static final boolean Cp(@yt.k boolean[] zArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[random.p(zArr.length)];
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long Cq(@yt.k long[] jArr, @yt.k ik.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            jLongValue = operation.r0(Long.valueOf(jLongValue), Long.valueOf(jArr[it2.b()])).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final <T> void Cr(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iXe = Xe(tArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            T t10 = tArr[iB];
            tArr[iB] = tArr[iXe];
            tArr[iXe] = t10;
            iXe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Character> Cs(char[] cArr, ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        char cCharValue = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(cCharValue));
        int length = cArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            cCharValue = operation.A(Integer.valueOf(i10), Character.valueOf(cCharValue), Character.valueOf(cArr[i10])).charValue();
            arrayList.add(Character.valueOf(cCharValue));
        }
        return arrayList;
    }

    public static final int Ct(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final float[] Cu(@yt.k float[] fArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            fArr2[i10] = fArr[it2.next().intValue()];
            i10++;
        }
        return fArr2;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> T[] Cv(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.f0.o(objArrCopyOf, "copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        kotlin.collections.m.I4(tArr2, uj.g.x());
        return tArr2;
    }

    public static final long Cw(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        return j10;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Cx(byte[] bArr, ik.l<? super Byte, l1> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (byte b10 : bArr) {
            iJ = l1.j(iJ + selector.i(Byte.valueOf(b10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final List<Short> Cy(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (!predicate.i(Short.valueOf(s10)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Short> Cz(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return (Set) Oy(sArr, new LinkedHashSet(r0.j(sArr.length)));
    }

    public static final boolean D5(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (!predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K> Map<K, Float> D6(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(fArr.length), 16));
        for (float f10 : fArr) {
            linkedHashMap.put(keySelector.i(Float.valueOf(f10)), Float.valueOf(f10));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Integer, ? super V>> M D7(int[] iArr, M destination, ik.l<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (int i10 : iArr) {
            destination.put(Integer.valueOf(i10), valueSelector.i(Integer.valueOf(i10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean D8(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr[3];
    }

    @yt.k
    public static final <T, K> List<T> D9(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (hashSet.add(selector.i(t10))) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R, V> List<V> DA(@yt.k float[] fArr, @yt.k R[] other, @yt.k ik.p<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Float.valueOf(fArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @bk.f
    public static final Float Da(float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return nf(fArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Short>> C Db(@yt.k short[] sArr, @yt.k C destination, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (!predicate.i(Short.valueOf(s10)).booleanValue()) {
                destination.add(Short.valueOf(s10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Byte Dc(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return Byte.valueOf(b10);
            }
        }
        return null;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C Dd(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (T t10 : tArr) {
            x.n0(destination, transform.i(t10));
        }
        return destination;
    }

    public static final void De(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, z1> action) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Integer.valueOf(iArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> Df(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends K> keySelector, @yt.k ik.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j10 : jArr) {
            K kI = keySelector.i(Long.valueOf(j10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Long.valueOf(j10)));
        }
        return linkedHashMap;
    }

    public static final int Dg(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <T> String Dh(@yt.k T[] tArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) lh(tArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Long Di(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            long j10 = jArr[length];
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                return Long.valueOf(j10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T, R extends Comparable<? super R>> T Dj(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t10;
        }
        R rI = selector.i(t10);
        k0 it2 = new qk.m(1, iXe).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            R rI2 = selector.i(t11);
            if (rI.compareTo(rI2) < 0) {
                t10 = t11;
                rI = rI2;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Dk(long[] jArr, ik.l<? super Long, Double> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Long.valueOf(jArr[0])).doubleValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Long.valueOf(jArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte Dl(@yt.k byte[] bArr, @yt.k Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) < 0) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float Dm(boolean[] zArr, ik.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Boolean.valueOf(zArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Boolean.valueOf(zArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R Dn(T[] tArr, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean Do(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Boolean Dp(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return Ep(zArr, Random.f38003a);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S Dq(@yt.k T[] tArr, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S sR0 = (S) tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            sR0 = operation.r0(sR0, (Object) tArr[it2.b()]);
        }
        return sR0;
    }

    @kotlin.v0(version = "1.4")
    public static final <T> void Dr(@yt.k T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, tArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            T t10 = tArr[i10];
            tArr[i10] = tArr[i13];
            tArr[i13] = t10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Double> Ds(double[] dArr, ik.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            dDoubleValue = operation.A(Integer.valueOf(i10), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i10])).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static final int Dt(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Integer numValueOf = null;
        boolean z10 = false;
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                numValueOf = Integer.valueOf(i10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(numValueOf, "null cannot be cast to non-null type kotlin.Int");
        return numValueOf.intValue();
    }

    @yt.k
    public static final float[] Du(@yt.k float[] fArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new float[0] : kotlin.collections.m.J1(fArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final short[] Dv(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.f0.o(sArrCopyOf, "copyOf(this, size)");
        ev(sArrCopyOf);
        return sArrCopyOf;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Dw(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Integer> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (byte b10 : bArr) {
            iIntValue += selector.i(Byte.valueOf(b10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Dx(char[] cArr, ik.l<? super Character, l1> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (char c10 : cArr) {
            iJ = l1.j(iJ + selector.i(Character.valueOf(c10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final List<Boolean> Dy(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (!predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Boolean> Dz(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return (Set) Py(zArr, new LinkedHashSet(r0.j(zArr.length)));
    }

    public static final boolean E5(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    @yt.k
    public static final <K, V> Map<K, V> E6(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends K> keySelector, @yt.k ik.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(fArr.length), 16));
        for (float f10 : fArr) {
            linkedHashMap.put(keySelector.i(Float.valueOf(f10)), valueTransform.i(Float.valueOf(f10)));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Long, ? super V>> M E7(long[] jArr, M destination, ik.l<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (long j10 : jArr) {
            destination.put(Long.valueOf(j10), valueSelector.i(Long.valueOf(j10)));
        }
        return destination;
    }

    @bk.f
    public static final byte E8(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr[4];
    }

    @yt.k
    public static final <K> List<Short> E9(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (hashSet.add(selector.i(Short.valueOf(s10)))) {
                arrayList.add(Short.valueOf(s10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R> List<Pair<Integer, R>> EA(@yt.k int[] iArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Integer.valueOf(iArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final Integer Ea(int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return of(iArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Boolean>> C Eb(@yt.k boolean[] zArr, @yt.k C destination, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (!predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                destination.add(Boolean.valueOf(z10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Character Ec(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C Ed(@yt.k short[] sArr, @yt.k C destination, @yt.k ik.l<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (short s10 : sArr) {
            x.n0(destination, transform.i(Short.valueOf(s10)));
        }
        return destination;
    }

    public static final void Ee(@yt.k long[] jArr, @yt.k ik.p<? super Integer, ? super Long, z1> action) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Long.valueOf(jArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <T, K> Map<K, List<T>> Ef(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : tArr) {
            K kI = keySelector.i(t10);
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(t10);
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Set<Byte> Eg(@yt.k byte[] bArr, @yt.k Iterable<Byte> other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Byte> setVz = vz(bArr);
        x.O0(setVz, other);
        return setVz;
    }

    @yt.k
    public static final String Eh(@yt.k short[] sArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Short, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) mh(sArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final <T> T Ei(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Short Ej(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s10);
        }
        R rI = selector.i(Short.valueOf(s10));
        k0 it2 = new qk.m(1, iYe).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            R rI2 = selector.i(Short.valueOf(s11));
            if (rI.compareTo(rI2) < 0) {
                s10 = s11;
                rI = rI2;
            }
        }
        return Short.valueOf(s10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Double Ek(T[] tArr, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(tArr[0]).doubleValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(tArr[it2.b()]).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character El(@yt.k char[] cArr, @yt.k Comparator<? super Character> comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) < 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Em(byte[] bArr, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R En(short[] sArr, Comparator<? super R> comparator, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final <T> boolean Eo(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean Ep(@yt.k boolean[] zArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.p(zArr.length)]);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short Eq(@yt.k short[] sArr, @yt.k ik.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            sShortValue = operation.r0(Short.valueOf(sShortValue), Short.valueOf(sArr[it2.b()])).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static final void Er(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iYe = Ye(sArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            short s10 = sArr[iB];
            sArr[iB] = sArr[iYe];
            sArr[iYe] = s10;
            iYe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Float> Es(float[] fArr, ik.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            fFloatValue = operation.A(Integer.valueOf(i10), Float.valueOf(fFloatValue), Float.valueOf(fArr[i10])).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static final long Et(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final int[] Eu(@yt.k int[] iArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            iArr2[i10] = iArr[it2.next().intValue()];
            i10++;
        }
        return iArr2;
    }

    @yt.k
    public static final <T> T[] Ev(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.f0.o(tArr2, "copyOf(this, size)");
        kotlin.collections.m.I4(tArr2, comparator);
        return tArr2;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Ew(@yt.k char[] cArr, @yt.k ik.l<? super Character, Integer> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (char c10 : cArr) {
            iIntValue += selector.i(Character.valueOf(c10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Ex(double[] dArr, ik.l<? super Double, l1> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (double d10 : dArr) {
            iJ = l1.j(iJ + selector.i(Double.valueOf(d10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final boolean[] Ey(@yt.k Boolean[] boolArr) {
        kotlin.jvm.internal.f0.p(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = boolArr[i10].booleanValue();
        }
        return zArr;
    }

    @yt.k
    public static final Set<Byte> Ez(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? (Set) Hy(bArr, new LinkedHashSet(r0.j(bArr.length))) : c1.f(Byte.valueOf(bArr[0])) : d1.k();
    }

    public static final boolean F5(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K> Map<K, Integer> F6(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(iArr.length), 16));
        for (int i10 : iArr) {
            linkedHashMap.put(keySelector.i(Integer.valueOf(i10)), Integer.valueOf(i10));
        }
        return linkedHashMap;
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M F7(@yt.k K[] kArr, @yt.k M destination, @yt.k ik.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(kArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (K k10 : kArr) {
            destination.put(k10, valueSelector.i(k10));
        }
        return destination;
    }

    @bk.f
    public static final char F8(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr[4];
    }

    @yt.k
    public static final <K> List<Boolean> F9(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (hashSet.add(selector.i(Boolean.valueOf(z10)))) {
                arrayList.add(Boolean.valueOf(z10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R, V> List<V> FA(@yt.k int[] iArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Integer.valueOf(iArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final Long Fa(long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return pf(jArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Byte>> C Fb(@yt.k byte[] bArr, @yt.k C destination, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                destination.add(Byte.valueOf(b10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Character Fc(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                return Character.valueOf(c10);
            }
        }
        return null;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C Fd(@yt.k boolean[] zArr, @yt.k C destination, @yt.k ik.l<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (boolean z10 : zArr) {
            x.n0(destination, transform.i(Boolean.valueOf(z10)));
        }
        return destination;
    }

    public static final <T> void Fe(@yt.k T[] tArr, @yt.k ik.p<? super Integer, ? super T, z1> action) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), tArr[i10]);
            i10++;
            i11++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, K, V> Map<K, List<V>> Ff(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a0.b bVar : tArr) {
            K kI = keySelector.i(bVar);
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(bVar));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Set<Character> Fg(@yt.k char[] cArr, @yt.k Iterable<Character> other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Character> setWz = wz(cArr);
        x.O0(setWz, other);
        return setWz;
    }

    @yt.k
    public static final String Fh(@yt.k boolean[] zArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Boolean, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) nh(zArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final <T> T Fi(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            T t10 = tArr[length];
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> byte Fj(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return b10;
        }
        R rI = selector.i(Byte.valueOf(b10));
        k0 it2 = new qk.m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            R rI2 = selector.i(Byte.valueOf(b11));
            if (rI.compareTo(rI2) < 0) {
                b10 = b11;
                rI = rI2;
            }
        }
        return b10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Fk(short[] sArr, ik.l<? super Short, Double> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Short.valueOf(sArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Short.valueOf(sArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double Fl(@yt.k double[] dArr, @yt.k Comparator<? super Double> comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) < 0) {
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Fm(char[] cArr, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Fn(boolean[] zArr, Comparator<? super R> comparator, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final <T> boolean Fo(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Byte Fp(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return Gp(bArr, Random.f38003a);
    }

    public static final byte Fq(@yt.k byte[] bArr, @yt.k ik.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bByteValue = operation.r0(Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return bByteValue;
    }

    @kotlin.v0(version = "1.4")
    public static final void Fr(@yt.k short[] sArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, sArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            short s10 = sArr[i10];
            sArr[i10] = sArr[i13];
            sArr[i13] = s10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Integer> Fs(int[] iArr, ik.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            iIntValue = operation.A(Integer.valueOf(i10), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i10])).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static final long Ft(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Long lValueOf = null;
        boolean z10 = false;
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                lValueOf = Long.valueOf(j10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(lValueOf, "null cannot be cast to non-null type kotlin.Long");
        return lValueOf.longValue();
    }

    @yt.k
    public static final int[] Fu(@yt.k int[] iArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new int[0] : kotlin.collections.m.K1(iArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Byte> Fv(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return fw(bArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Fw(@yt.k double[] dArr, @yt.k ik.l<? super Double, Integer> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (double d10 : dArr) {
            iIntValue += selector.i(Double.valueOf(d10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Fx(float[] fArr, ik.l<? super Float, l1> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (float f10 : fArr) {
            iJ = l1.j(iJ + selector.i(Float.valueOf(f10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final byte[] Fy(@yt.k Byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr2[i10] = bArr[i10].byteValue();
        }
        return bArr2;
    }

    @yt.k
    public static final Set<Character> Fz(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? (Set) Iy(cArr, new LinkedHashSet(r0.j(qk.v.B(cArr.length, 128)))) : c1.f(Character.valueOf(cArr[0])) : d1.k();
    }

    public static final boolean G5(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    @yt.k
    public static final <K, V> Map<K, V> G6(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends K> keySelector, @yt.k ik.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(iArr.length), 16));
        for (int i10 : iArr) {
            linkedHashMap.put(keySelector.i(Integer.valueOf(i10)), valueTransform.i(Integer.valueOf(i10)));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Short, ? super V>> M G7(short[] sArr, M destination, ik.l<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (short s10 : sArr) {
            destination.put(Short.valueOf(s10), valueSelector.i(Short.valueOf(s10)));
        }
        return destination;
    }

    @bk.f
    public static final double G8(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr[4];
    }

    @yt.k
    public static final List<Byte> G9(@yt.k byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (i10 >= 0) {
            return dy(bArr, qk.v.u(bArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final List<Pair<Integer, Integer>> GA(@yt.k int[] iArr, @yt.k int[] other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Integer.valueOf(iArr[i10]), Integer.valueOf(other[i10])));
        }
        return arrayList;
    }

    @bk.f
    public static final <T> T Ga(T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (T) qf(tArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Character>> C Gb(@yt.k char[] cArr, @yt.k C destination, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                destination.add(Character.valueOf(c10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Double Gc(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    public static final <R> R Gd(@yt.k byte[] bArr, R r10, @yt.k ik.p<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (byte b10 : bArr) {
            r10 = operation.r0(r10, Byte.valueOf(b10));
        }
        return r10;
    }

    public static final void Ge(@yt.k short[] sArr, @yt.k ik.p<? super Integer, ? super Short, z1> action) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Short.valueOf(sArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K> Map<K, List<Short>> Gf(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s10 : sArr) {
            K kI = keySelector.i(Short.valueOf(s10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s10));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Set<Double> Gg(@yt.k double[] dArr, @yt.k Iterable<Double> other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Double> setXz = xz(dArr);
        x.O0(setXz, other);
        return setXz;
    }

    public static /* synthetic */ String Gh(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return xh(bArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.l
    public static final Short Gi(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> char Gj(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return c10;
        }
        R rI = selector.i(Character.valueOf(c10));
        k0 it2 = new qk.m(1, iSe).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            R rI2 = selector.i(Character.valueOf(c11));
            if (rI.compareTo(rI2) < 0) {
                c10 = c11;
                rI = rI2;
            }
        }
        return c10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Gk(boolean[] zArr, ik.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Boolean.valueOf(zArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Boolean.valueOf(zArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float Gl(@yt.k float[] fArr, @yt.k Comparator<? super Float> comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) < 0) {
                f10 = f11;
            }
        }
        return Float.valueOf(f10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Gm(double[] dArr, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte Gn(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (b10 > b11) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    public static final boolean Go(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte Gp(@yt.k byte[] bArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.p(bArr.length)]);
    }

    public static final char Gq(@yt.k char[] cArr, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            cCharValue = operation.r0(Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return cCharValue;
    }

    public static final void Gr(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iZe = Ze(zArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            boolean z10 = zArr[iB];
            zArr[iB] = zArr[iZe];
            zArr[iZe] = z10;
            iZe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Long> Gs(long[] jArr, ik.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            jLongValue = operation.A(Integer.valueOf(i10), Long.valueOf(jLongValue), Long.valueOf(jArr[i10])).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static final <T> T Gt(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final long[] Gu(@yt.k long[] jArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            jArr2[i10] = jArr[it2.next().intValue()];
            i10++;
        }
        return jArr2;
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Character> Gv(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return gw(cArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Gw(@yt.k float[] fArr, @yt.k ik.l<? super Float, Integer> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (float f10 : fArr) {
            iIntValue += selector.i(Float.valueOf(f10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Gx(int[] iArr, ik.l<? super Integer, l1> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (int i10 : iArr) {
            iJ = l1.j(iJ + selector.i(Integer.valueOf(i10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final char[] Gy(@yt.k Character[] chArr) {
        kotlin.jvm.internal.f0.p(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = chArr[i10].charValue();
        }
        return cArr;
    }

    @yt.k
    public static final Set<Double> Gz(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? (Set) Jy(dArr, new LinkedHashSet(r0.j(dArr.length))) : c1.f(Double.valueOf(dArr[0])) : d1.k();
    }

    public static final boolean H5(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K> Map<K, Long> H6(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(jArr.length), 16));
        for (long j10 : jArr) {
            linkedHashMap.put(keySelector.i(Long.valueOf(j10)), Long.valueOf(j10));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Boolean, ? super V>> M H7(boolean[] zArr, M destination, ik.l<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (boolean z10 : zArr) {
            destination.put(Boolean.valueOf(z10), valueSelector.i(Boolean.valueOf(z10)));
        }
        return destination;
    }

    @bk.f
    public static final float H8(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr[4];
    }

    @yt.k
    public static final List<Character> H9(@yt.k char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (i10 >= 0) {
            return ey(cArr, qk.v.u(cArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <V> List<V> HA(@yt.k int[] iArr, @yt.k int[] other, @yt.k ik.p<? super Integer, ? super Integer, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Integer.valueOf(iArr[i10]), Integer.valueOf(other[i10])));
        }
        return arrayList;
    }

    @bk.f
    public static final Short Ha(short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return rf(sArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Double>> C Hb(@yt.k double[] dArr, @yt.k C destination, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                destination.add(Double.valueOf(d10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Double Hc(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                return Double.valueOf(d10);
            }
        }
        return null;
    }

    public static final <R> R Hd(@yt.k char[] cArr, R r10, @yt.k ik.p<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (char c10 : cArr) {
            r10 = operation.r0(r10, Character.valueOf(c10));
        }
        return r10;
    }

    public static final void He(@yt.k boolean[] zArr, @yt.k ik.p<? super Integer, ? super Boolean, z1> action) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Boolean.valueOf(zArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> Hf(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends K> keySelector, @yt.k ik.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s10 : sArr) {
            K kI = keySelector.i(Short.valueOf(s10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Short.valueOf(s10)));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Set<Float> Hg(@yt.k float[] fArr, @yt.k Iterable<Float> other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Float> setYz = yz(fArr);
        x.O0(setYz, other);
        return setYz;
    }

    public static /* synthetic */ String Hh(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return yh(cArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.l
    public static final Short Hi(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            short s10 = sArr[length];
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                return Short.valueOf(s10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> double Hj(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return d10;
        }
        R rI = selector.i(Double.valueOf(d10));
        k0 it2 = new qk.m(1, iTe).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            R rI2 = selector.i(Double.valueOf(d11));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                d10 = d11;
            }
        }
        return d10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Hk(byte[] bArr, ik.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Byte.valueOf(bArr[0])).floatValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Byte.valueOf(bArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer Hl(@yt.k int[] iArr, @yt.k Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) < 0) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Hm(float[] fArr, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character Hn(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (kotlin.jvm.internal.f0.t(c10, c11) > 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    public static final boolean Ho(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Character Hp(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return Ip(cArr, Random.f38003a);
    }

    public static final double Hq(@yt.k double[] dArr, @yt.k ik.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            dDoubleValue = operation.r0(Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.v0(version = "1.4")
    public static final void Hr(@yt.k boolean[] zArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, zArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            boolean z10 = zArr[i10];
            zArr[i10] = zArr[i13];
            zArr[i13] = z10;
            i13--;
            i10++;
        }
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <S, T extends S> List<S> Hs(@yt.k T[] tArr, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        S sA = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sA);
        int length = tArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sA = operation.A(Integer.valueOf(i10), sA, (Object) tArr[i10]);
            arrayList.add(sA);
        }
        return arrayList;
    }

    public static final <T> T Ht(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : tArr) {
            if (predicate.i(t11).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final long[] Hu(@yt.k long[] jArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new long[0] : kotlin.collections.m.L1(jArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Double> Hv(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return hw(dArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Hw(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Integer> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (int i10 : iArr) {
            iIntValue += selector.i(Integer.valueOf(i10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Hx(long[] jArr, ik.l<? super Long, l1> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (long j10 : jArr) {
            iJ = l1.j(iJ + selector.i(Long.valueOf(j10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final <C extends Collection<? super Byte>> C Hy(@yt.k byte[] bArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (byte b10 : bArr) {
            destination.add(Byte.valueOf(b10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Float> Hz(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? (Set) Ky(fArr, new LinkedHashSet(r0.j(fArr.length))) : c1.f(Float.valueOf(fArr[0])) : d1.k();
    }

    public static final boolean I5(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    @yt.k
    public static final <K, V> Map<K, V> I6(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends K> keySelector, @yt.k ik.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(jArr.length), 16));
        for (long j10 : jArr) {
            linkedHashMap.put(keySelector.i(Long.valueOf(j10)), valueTransform.i(Long.valueOf(j10)));
        }
        return linkedHashMap;
    }

    public static final double I7(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (byte b10 : bArr) {
            d10 += (double) b10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @bk.f
    public static final int I8(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr[4];
    }

    @yt.k
    public static final List<Double> I9(@yt.k double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (i10 >= 0) {
            return fy(dArr, qk.v.u(dArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<Pair<Integer, R>> IA(@yt.k int[] iArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = iArr[i10];
            arrayList.add(kotlin.d1.a(Integer.valueOf(i11), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Byte> Ia(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Float>> C Ib(@yt.k float[] fArr, @yt.k C destination, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                destination.add(Float.valueOf(f10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Float Ic(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R Id(@yt.k double[] dArr, R r10, @yt.k ik.p<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (double d10 : dArr) {
            r10 = operation.r0(r10, Double.valueOf(d10));
        }
        return r10;
    }

    @yt.k
    public static final qk.m Ie(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return new qk.m(0, Re(bArr));
    }

    @yt.k
    public static final <K> Map<K, List<Boolean>> If(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z10 : zArr) {
            K kI = keySelector.i(Boolean.valueOf(z10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z10));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Set<Integer> Ig(@yt.k int[] iArr, @yt.k Iterable<Integer> other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Integer> setZz = zz(iArr);
        x.O0(setZz, other);
        return setZz;
    }

    public static /* synthetic */ String Ih(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return zh(dArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <R> List<R> Ii(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(transform.i(Byte.valueOf(b10)));
        }
        return arrayList;
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> float Ij(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return f10;
        }
        R rI = selector.i(Float.valueOf(f10));
        k0 it2 = new qk.m(1, iUe).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            R rI2 = selector.i(Float.valueOf(f11));
            if (rI.compareTo(rI2) < 0) {
                f10 = f11;
                rI = rI2;
            }
        }
        return f10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Ik(char[] cArr, ik.l<? super Character, Float> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Character.valueOf(cArr[0])).floatValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Character.valueOf(cArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long Il(@yt.k long[] jArr, @yt.k Comparator<? super Long> comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) < 0) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Im(int[] iArr, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T extends Comparable<? super T>> T In(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (t10.compareTo(t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    public static final boolean Io(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character Ip(@yt.k char[] cArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.p(cArr.length)]);
    }

    public static final float Iq(@yt.k float[] fArr, @yt.k ik.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            fFloatValue = operation.r0(Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return fFloatValue;
    }

    @yt.k
    public static final List<Byte> Ir(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Byte> listMz = mz(bArr);
        z.m1(listMz);
        return listMz;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Short> Is(short[] sArr, ik.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sShortValue = operation.A(Integer.valueOf(i10), Short.valueOf(sShortValue), Short.valueOf(sArr[i10])).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static final short It(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final <T> T[] Iu(@yt.k T[] tArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        T[] tArr2 = (T[]) kotlin.collections.k.a(tArr, indices.size());
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            tArr2[i10] = tArr[it2.next().intValue()];
            i10++;
        }
        return tArr2;
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Float> Iv(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return iw(fArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Iw(@yt.k long[] jArr, @yt.k ik.l<? super Long, Integer> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (long j10 : jArr) {
            iIntValue += selector.i(Long.valueOf(j10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final <T> int Ix(T[] tArr, ik.l<? super T, l1> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (T t10 : tArr) {
            iJ = l1.j(iJ + selector.i(t10).l0());
        }
        return iJ;
    }

    @yt.k
    public static final <C extends Collection<? super Character>> C Iy(@yt.k char[] cArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (char c10 : cArr) {
            destination.add(Character.valueOf(c10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Integer> Iz(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? (Set) Ly(iArr, new LinkedHashSet(r0.j(iArr.length))) : c1.f(Integer.valueOf(iArr[0])) : d1.k();
    }

    public static final boolean J5(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <T, K> Map<K, T> J6(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(tArr.length), 16));
        for (T t10 : tArr) {
            linkedHashMap.put(keySelector.i(t10), t10);
        }
        return linkedHashMap;
    }

    public static final double J7(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (double d11 : dArr) {
            d10 += d11;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @bk.f
    public static final long J8(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr[4];
    }

    @yt.k
    public static final List<Float> J9(@yt.k float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (i10 >= 0) {
            return gy(fArr, qk.v.u(fArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, V> List<V> JA(@yt.k int[] iArr, @yt.k R[] other, @yt.k ik.p<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Integer.valueOf(iArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Character> Ja(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Integer>> C Jb(@yt.k int[] iArr, @yt.k C destination, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                destination.add(Integer.valueOf(i10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Float Jc(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                return Float.valueOf(f10);
            }
        }
        return null;
    }

    public static final <R> R Jd(@yt.k float[] fArr, R r10, @yt.k ik.p<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (float f10 : fArr) {
            r10 = operation.r0(r10, Float.valueOf(f10));
        }
        return r10;
    }

    @yt.k
    public static final qk.m Je(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return new qk.m(0, Se(cArr));
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> Jf(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends K> keySelector, @yt.k ik.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z10 : zArr) {
            K kI = keySelector.i(Boolean.valueOf(z10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Boolean.valueOf(z10)));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Set<Long> Jg(@yt.k long[] jArr, @yt.k Iterable<Long> other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Long> setAz = Az(jArr);
        x.O0(setAz, other);
        return setAz;
    }

    public static /* synthetic */ String Jh(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Ah(fArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <R> List<R> Ji(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(transform.i(Character.valueOf(c10)));
        }
        return arrayList;
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> int Jj(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return i10;
        }
        R rI = selector.i(Integer.valueOf(i10));
        k0 it2 = new qk.m(1, iVe).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            R rI2 = selector.i(Integer.valueOf(i11));
            if (rI.compareTo(rI2) < 0) {
                i10 = i11;
                rI = rI2;
            }
        }
        return i10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Jk(double[] dArr, ik.l<? super Double, Float> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Double.valueOf(dArr[0])).floatValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Double.valueOf(dArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T> T Jl(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (comparator.compare(t10, t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Jm(long[] jArr, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double Jn(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMin = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dMin = Math.min(dMin, dArr[it2.b()]);
        }
        return Double.valueOf(dMin);
    }

    public static final boolean Jo(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Jp(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return Kp(dArr, Random.f38003a);
    }

    public static final int Jq(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iIntValue = operation.r0(Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Character> Jr(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Character> listNz = nz(cArr);
        z.m1(listNz);
        return listNz;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Boolean> Js(boolean[] zArr, ik.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        boolean zBooleanValue = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(zBooleanValue));
        int length = zArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            zBooleanValue = operation.A(Integer.valueOf(i10), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i10])).booleanValue();
            arrayList.add(Boolean.valueOf(zBooleanValue));
        }
        return arrayList;
    }

    public static final short Jt(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Short shValueOf = null;
        boolean z10 = false;
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                shValueOf = Short.valueOf(s10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(shValueOf, "null cannot be cast to non-null type kotlin.Short");
        return shValueOf.shortValue();
    }

    @yt.k
    public static final <T> T[] Ju(@yt.k T[] tArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? (T[]) kotlin.collections.m.M1(tArr, 0, 0) : (T[]) kotlin.collections.m.M1(tArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Integer> Jv(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return jw(iArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> int Jw(@yt.k T[] tArr, @yt.k ik.l<? super T, Integer> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (T t10 : tArr) {
            iIntValue += selector.i(t10).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Jx(short[] sArr, ik.l<? super Short, l1> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (short s10 : sArr) {
            iJ = l1.j(iJ + selector.i(Short.valueOf(s10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final <C extends Collection<? super Double>> C Jy(@yt.k double[] dArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (double d10 : dArr) {
            destination.add(Double.valueOf(d10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Long> Jz(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? (Set) My(jArr, new LinkedHashSet(r0.j(jArr.length))) : c1.f(Long.valueOf(jArr[0])) : d1.k();
    }

    public static final boolean K5(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    @yt.k
    public static final <T, K, V> Map<K, V> K6(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(tArr.length), 16));
        for (T t10 : tArr) {
            linkedHashMap.put(keySelector.i(t10), valueTransform.i(t10));
        }
        return linkedHashMap;
    }

    public static final double K7(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (float f10 : fArr) {
            d10 += (double) f10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @bk.f
    public static final <T> T K8(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr[4];
    }

    @yt.k
    public static final List<Integer> K9(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (i10 >= 0) {
            return hy(iArr, qk.v.u(iArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<Pair<Long, R>> KA(@yt.k long[] jArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Long.valueOf(jArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> Ka(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Long>> C Kb(@yt.k long[] jArr, @yt.k C destination, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                destination.add(Long.valueOf(j10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Integer Kc(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final <R> R Kd(@yt.k int[] iArr, R r10, @yt.k ik.p<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int i10 : iArr) {
            r10 = operation.r0(r10, Integer.valueOf(i10));
        }
        return r10;
    }

    @yt.k
    public static final qk.m Ke(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return new qk.m(0, Te(dArr));
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Byte>>> M Kf(@yt.k byte[] bArr, @yt.k M destination, @yt.k ik.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (byte b10 : bArr) {
            K kI = keySelector.i(Byte.valueOf(b10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b10));
        }
        return destination;
    }

    @yt.k
    public static final <T> Set<T> Kg(@yt.k T[] tArr, @yt.k Iterable<? extends T> other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<T> setBz = Bz(tArr);
        x.O0(setBz, other);
        return setBz;
    }

    public static /* synthetic */ String Kh(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Bh(iArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <R> List<R> Ki(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(transform.i(Double.valueOf(d10)));
        }
        return arrayList;
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> long Kj(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return j10;
        }
        R rI = selector.i(Long.valueOf(j10));
        k0 it2 = new qk.m(1, iWe).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            R rI2 = selector.i(Long.valueOf(j11));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                j10 = j11;
            }
        }
        return j10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Kk(float[] fArr, ik.l<? super Float, Float> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Float.valueOf(fArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Float.valueOf(fArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short Kl(@yt.k short[] sArr, @yt.k Comparator<? super Short> comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) < 0) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R Km(T[] tArr, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double Kn(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        k0 it2 = new qk.m(1, Xe(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, dArr[it2.b()].doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final byte[] Ko(byte[] bArr, ik.l<? super Byte, z1> action) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (byte b10 : bArr) {
            action.i(Byte.valueOf(b10));
        }
        return bArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double Kp(@yt.k double[] dArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.p(dArr.length)]);
    }

    public static final long Kq(@yt.k long[] jArr, @yt.k ik.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jLongValue = operation.r0(Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Double> Kr(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Double> listOz = oz(dArr);
        z.m1(listOz);
        return listOz;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ks(byte[] bArr, R r10, ik.p<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        for (byte b10 : bArr) {
            r10 = operation.r0(r10, Byte.valueOf(b10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static final boolean Kt(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final short[] Ku(@yt.k short[] sArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            sArr2[i10] = sArr[it2.next().intValue()];
            i10++;
        }
        return sArr2;
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Long> Kv(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return kw(jArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Kw(@yt.k short[] sArr, @yt.k ik.l<? super Short, Integer> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (short s10 : sArr) {
            iIntValue += selector.i(Short.valueOf(s10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfUInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int Kx(boolean[] zArr, ik.l<? super Boolean, l1> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (boolean z10 : zArr) {
            iJ = l1.j(iJ + selector.i(Boolean.valueOf(z10)).l0());
        }
        return iJ;
    }

    @yt.k
    public static final <C extends Collection<? super Float>> C Ky(@yt.k float[] fArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (float f10 : fArr) {
            destination.add(Float.valueOf(f10));
        }
        return destination;
    }

    @yt.k
    public static final <T> Set<T> Kz(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) Ny(tArr, new LinkedHashSet(r0.j(tArr.length))) : c1.f(tArr[0]) : d1.k();
    }

    public static final boolean L5(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K> Map<K, Short> L6(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(sArr.length), 16));
        for (short s10 : sArr) {
            linkedHashMap.put(keySelector.i(Short.valueOf(s10)), Short.valueOf(s10));
        }
        return linkedHashMap;
    }

    public static final double L7(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (int i11 : iArr) {
            d10 += (double) i11;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @bk.f
    public static final short L8(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr[4];
    }

    @yt.k
    public static final List<Long> L9(@yt.k long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (i10 >= 0) {
            return iy(jArr, qk.v.u(jArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, V> List<V> LA(@yt.k long[] jArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Long.valueOf(jArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Float> La(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C Lb(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                destination.add(t10);
            }
        }
        return destination;
    }

    @yt.l
    public static final Integer Lc(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                return Integer.valueOf(i10);
            }
        }
        return null;
    }

    public static final <R> R Ld(@yt.k long[] jArr, R r10, @yt.k ik.p<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (long j10 : jArr) {
            r10 = operation.r0(r10, Long.valueOf(j10));
        }
        return r10;
    }

    @yt.k
    public static final qk.m Le(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return new qk.m(0, Ue(fArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Lf(@yt.k byte[] bArr, @yt.k M destination, @yt.k ik.l<? super Byte, ? extends K> keySelector, @yt.k ik.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (byte b10 : bArr) {
            K kI = keySelector.i(Byte.valueOf(b10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Byte.valueOf(b10)));
        }
        return destination;
    }

    @yt.k
    public static final Set<Short> Lg(@yt.k short[] sArr, @yt.k Iterable<Short> other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Short> setCz = Cz(sArr);
        x.O0(setCz, other);
        return setCz;
    }

    public static /* synthetic */ String Lh(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Ch(jArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <R> List<R> Li(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(transform.i(Float.valueOf(f10)));
        }
        return arrayList;
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T Lj(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t10;
        }
        R rI = selector.i(t10);
        k0 it2 = new qk.m(1, iXe).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            R rI2 = selector.i(t11);
            if (rI.compareTo(rI2) < 0) {
                t10 = t11;
                rI = rI2;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Lk(int[] iArr, ik.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Integer.valueOf(iArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Integer.valueOf(iArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final byte Ll(@yt.k byte[] bArr, @yt.k Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) < 0) {
                b10 = b11;
            }
        }
        return b10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Lm(short[] sArr, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float Ln(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMin = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fMin = Math.min(fMin, fArr[it2.b()]);
        }
        return Float.valueOf(fMin);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final char[] Lo(char[] cArr, ik.l<? super Character, z1> action) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (char c10 : cArr) {
            action.i(Character.valueOf(c10));
        }
        return cArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Lp(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return Mp(fArr, Random.f38003a);
    }

    public static final <S, T extends S> S Lq(@yt.k T[] tArr, @yt.k ik.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sR0 = (S) tArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sR0 = operation.r0((Object) tArr[i10], sR0);
        }
        return sR0;
    }

    @yt.k
    public static final List<Float> Lr(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Float> listPz = pz(fArr);
        z.m1(listPz);
        return listPz;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ls(char[] cArr, R r10, ik.p<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        for (char c10 : cArr) {
            r10 = operation.r0(r10, Character.valueOf(c10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static final boolean Lt(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z10 = false;
        for (boolean z11 : zArr) {
            if (predicate.i(Boolean.valueOf(z11)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                boolValueOf = Boolean.valueOf(z11);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(boolValueOf, "null cannot be cast to non-null type kotlin.Boolean");
        return boolValueOf.booleanValue();
    }

    @yt.k
    public static final short[] Lu(@yt.k short[] sArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new short[0] : kotlin.collections.m.N1(sArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final <T, R extends Comparable<? super R>> List<T> Lv(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return lw(tArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Lw(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (boolean z10 : zArr) {
            iIntValue += selector.i(Boolean.valueOf(z10)).intValue();
        }
        return iIntValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Lx(byte[] bArr, ik.l<? super Byte, p1> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (byte b10 : bArr) {
            j10 = p1.j(j10 + selector.i(Byte.valueOf(b10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final <C extends Collection<? super Integer>> C Ly(@yt.k int[] iArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (int i10 : iArr) {
            destination.add(Integer.valueOf(i10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Short> Lz(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? (Set) Oy(sArr, new LinkedHashSet(r0.j(sArr.length))) : c1.f(Short.valueOf(sArr[0])) : d1.k();
    }

    public static final boolean M5(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    @yt.k
    public static final <K, V> Map<K, V> M6(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends K> keySelector, @yt.k ik.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(sArr.length), 16));
        for (short s10 : sArr) {
            linkedHashMap.put(keySelector.i(Short.valueOf(s10)), valueTransform.i(Short.valueOf(s10)));
        }
        return linkedHashMap;
    }

    public static final double M7(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (long j10 : jArr) {
            d10 += j10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @bk.f
    public static final boolean M8(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr[4];
    }

    @yt.k
    public static final <T> List<T> M9(@yt.k T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (i10 >= 0) {
            return jy(tArr, qk.v.u(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final List<Pair<Long, Long>> MA(@yt.k long[] jArr, @yt.k long[] other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Long.valueOf(jArr[i10]), Long.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> Ma(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Short>> C Mb(@yt.k short[] sArr, @yt.k C destination, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                destination.add(Short.valueOf(s10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Long Mc(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Md(@yt.k T[] tArr, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (a0.b bVar : tArr) {
            r10 = operation.r0(r10, bVar);
        }
        return r10;
    }

    @yt.k
    public static final qk.m Me(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return new qk.m(0, Ve(iArr));
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Character>>> M Mf(@yt.k char[] cArr, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (char c10 : cArr) {
            K kI = keySelector.i(Character.valueOf(c10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Boolean> Mg(@yt.k boolean[] zArr, @yt.k Iterable<Boolean> other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Boolean> setDz = Dz(zArr);
        x.O0(setDz, other);
        return setDz;
    }

    public static /* synthetic */ String Mh(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Dh(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <R> List<R> Mi(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(transform.i(Integer.valueOf(i10)));
        }
        return arrayList;
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> short Mj(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return s10;
        }
        R rI = selector.i(Short.valueOf(s10));
        k0 it2 = new qk.m(1, iYe).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            R rI2 = selector.i(Short.valueOf(s11));
            if (rI.compareTo(rI2) < 0) {
                s10 = s11;
                rI = rI2;
            }
        }
        return s10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Mk(long[] jArr, ik.l<? super Long, Float> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Long.valueOf(jArr[0])).floatValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Long.valueOf(jArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final char Ml(@yt.k char[] cArr, @yt.k Comparator<? super Character> comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) < 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Mm(boolean[] zArr, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float Mn(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        k0 it2 = new qk.m(1, Xe(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, fArr[it2.b()].floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double[] Mo(double[] dArr, ik.l<? super Double, z1> action) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (double d10 : dArr) {
            action.i(Double.valueOf(d10));
        }
        return dArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float Mp(@yt.k float[] fArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.p(fArr.length)]);
    }

    public static final short Mq(@yt.k short[] sArr, @yt.k ik.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sShortValue = operation.r0(Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return sShortValue;
    }

    @yt.k
    public static final List<Integer> Mr(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Integer> listQz = qz(iArr);
        z.m1(listQz);
        return listQz;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ms(double[] dArr, R r10, ik.p<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        for (double d10 : dArr) {
            r10 = operation.r0(r10, Double.valueOf(d10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Boolean Mt(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    @yt.k
    public static final boolean[] Mu(@yt.k boolean[] zArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            zArr2[i10] = zArr[it2.next().intValue()];
            i10++;
        }
        return zArr2;
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Short> Mv(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return mw(sArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Mw(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b10 : bArr) {
            dDoubleValue += selector.i(Byte.valueOf(b10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Mx(char[] cArr, ik.l<? super Character, p1> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (char c10 : cArr) {
            j10 = p1.j(j10 + selector.i(Character.valueOf(c10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final <C extends Collection<? super Long>> C My(@yt.k long[] jArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (long j10 : jArr) {
            destination.add(Long.valueOf(j10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Boolean> Mz(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? (Set) Py(zArr, new LinkedHashSet(r0.j(zArr.length))) : c1.f(Boolean.valueOf(zArr[0])) : d1.k();
    }

    public static final boolean N5(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K> Map<K, Boolean> N6(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(zArr.length), 16));
        for (boolean z10 : zArr) {
            linkedHashMap.put(keySelector.i(Boolean.valueOf(z10)), Boolean.valueOf(z10));
        }
        return linkedHashMap;
    }

    public static final double N7(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (short s10 : sArr) {
            d10 += (double) s10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    public static final boolean N8(@yt.k byte[] bArr, byte b10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return dg(bArr, b10) >= 0;
    }

    @yt.k
    public static final List<Short> N9(@yt.k short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (i10 >= 0) {
            return ky(sArr, qk.v.u(sArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <V> List<V> NA(@yt.k long[] jArr, @yt.k long[] other, @yt.k ik.p<? super Long, ? super Long, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Long.valueOf(jArr[i10]), Long.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Long> Na(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Boolean>> C Nb(@yt.k boolean[] zArr, @yt.k C destination, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                destination.add(Boolean.valueOf(z10));
            }
        }
        return destination;
    }

    @yt.l
    public static final Long Nc(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                return Long.valueOf(j10);
            }
        }
        return null;
    }

    public static final <R> R Nd(@yt.k short[] sArr, R r10, @yt.k ik.p<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (short s10 : sArr) {
            r10 = operation.r0(r10, Short.valueOf(s10));
        }
        return r10;
    }

    @yt.k
    public static final qk.m Ne(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return new qk.m(0, We(jArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Nf(@yt.k char[] cArr, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (char c10 : cArr) {
            K kI = keySelector.i(Character.valueOf(c10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Character.valueOf(c10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean Ng(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    public static /* synthetic */ String Nh(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Eh(sArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <R> List<R> Ni(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(transform.i(Long.valueOf(j10)));
        }
        return arrayList;
    }

    @hk.h(name = "maxByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> boolean Nj(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return z10;
        }
        R rI = selector.i(Boolean.valueOf(z10));
        k0 it2 = new qk.m(1, iZe).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            R rI2 = selector.i(Boolean.valueOf(z11));
            if (rI.compareTo(rI2) < 0) {
                z10 = z11;
                rI = rI2;
            }
        }
        return z10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Float Nk(T[] tArr, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(tArr[0]).floatValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(tArr[it2.b()]).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double Nl(@yt.k double[] dArr, @yt.k Comparator<? super Double> comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) < 0) {
                d10 = d11;
            }
        }
        return d10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Nm(byte[] bArr, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer Nn(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (i10 > i11) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float[] No(float[] fArr, ik.l<? super Float, z1> action) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (float f10 : fArr) {
            action.i(Float.valueOf(f10));
        }
        return fArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Integer Np(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return Op(iArr, Random.f38003a);
    }

    public static final boolean Nq(@yt.k boolean[] zArr, @yt.k ik.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i10 = iZe - 1; i10 >= 0; i10--) {
            zBooleanValue = operation.r0(Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return zBooleanValue;
    }

    @yt.k
    public static final List<Long> Nr(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Long> listRz = rz(jArr);
        z.m1(listRz);
        return listRz;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ns(float[] fArr, R r10, ik.p<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        for (float f10 : fArr) {
            r10 = operation.r0(r10, Float.valueOf(f10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Boolean Nt(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z10 = false;
        for (boolean z11 : zArr) {
            if (predicate.i(Boolean.valueOf(z11)).booleanValue()) {
                if (z10) {
                    return null;
                }
                boolValueOf = Boolean.valueOf(z11);
                z10 = true;
            }
        }
        if (z10) {
            return boolValueOf;
        }
        return null;
    }

    @yt.k
    public static final boolean[] Nu(@yt.k boolean[] zArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : kotlin.collections.m.O1(zArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Boolean> Nv(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return nw(zArr, new g.a(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Nw(@yt.k char[] cArr, @yt.k ik.l<? super Character, Double> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c10 : cArr) {
            dDoubleValue += selector.i(Character.valueOf(c10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Nx(double[] dArr, ik.l<? super Double, p1> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (double d10 : dArr) {
            j10 = p1.j(j10 + selector.i(Double.valueOf(d10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C Ny(@yt.k T[] tArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (T t10 : tArr) {
            destination.add(t10);
        }
        return destination;
    }

    @yt.k
    public static final short[] Nz(@yt.k Short[] shArr) {
        kotlin.jvm.internal.f0.p(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = shArr[i10].shortValue();
        }
        return sArr;
    }

    public static final boolean O5(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    @yt.k
    public static final <K, V> Map<K, V> O6(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends K> keySelector, @yt.k ik.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(zArr.length), 16));
        for (boolean z10 : zArr) {
            linkedHashMap.put(keySelector.i(Boolean.valueOf(z10)), valueTransform.i(Boolean.valueOf(z10)));
        }
        return linkedHashMap;
    }

    @hk.h(name = "averageOfByte")
    public static final double O7(@yt.k Byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        double dByteValue = 0.0d;
        int i10 = 0;
        for (Byte b10 : bArr) {
            dByteValue += (double) b10.byteValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i10);
    }

    public static final boolean O8(@yt.k char[] cArr, char c10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return eg(cArr, c10) >= 0;
    }

    @yt.k
    public static final List<Boolean> O9(@yt.k boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (i10 >= 0) {
            return ly(zArr, qk.v.u(zArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<Pair<Long, R>> OA(@yt.k long[] jArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            long j10 = jArr[i10];
            arrayList.add(kotlin.d1.a(Long.valueOf(j10), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> Oa(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @bk.f
    public static final Boolean Ob(boolean[] zArr, ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return Boolean.valueOf(z10);
            }
        }
        return null;
    }

    @yt.l
    public static final <T> T Oc(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <R> R Od(@yt.k boolean[] zArr, R r10, @yt.k ik.p<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (boolean z10 : zArr) {
            r10 = operation.r0(r10, Boolean.valueOf(z10));
        }
        return r10;
    }

    @yt.k
    public static final <T> qk.m Oe(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return new qk.m(0, Xe(tArr));
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Double>>> M Of(@yt.k double[] dArr, @yt.k M destination, @yt.k ik.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (double d10 : dArr) {
            K kI = keySelector.i(Double.valueOf(d10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d10));
        }
        return destination;
    }

    @bk.f
    public static final boolean Og(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    public static /* synthetic */ String Oh(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, ik.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Fh(zArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @yt.k
    public static final <T, R> List<R> Oi(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t10 : tArr) {
            arrayList.add(transform.i(t10));
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Oj(byte[] bArr, ik.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Byte.valueOf(bArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Byte.valueOf(bArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Ok(short[] sArr, ik.l<? super Short, Float> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Short.valueOf(sArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Short.valueOf(sArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float Ol(@yt.k float[] fArr, @yt.k Comparator<? super Float> comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) < 0) {
                f10 = f11;
            }
        }
        return f10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Om(char[] cArr, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long On(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (j10 > j11) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int[] Oo(int[] iArr, ik.l<? super Integer, z1> action) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (int i10 : iArr) {
            action.i(Integer.valueOf(i10));
        }
        return iArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer Op(@yt.k int[] iArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.p(iArr.length)]);
    }

    public static final byte Oq(@yt.k byte[] bArr, @yt.k ik.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bByteValue = operation.A(Integer.valueOf(i10), Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return bByteValue;
    }

    @yt.k
    public static final <T> List<T> Or(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<T> listSz = sz(tArr);
        z.m1(listSz);
        return listSz;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Os(int[] iArr, R r10, ik.p<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        for (int i10 : iArr) {
            r10 = operation.r0(r10, Integer.valueOf(i10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Byte Ot(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void Ou(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.m.I4(tArr, new g.a(selector));
        }
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Byte> Ov(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return fw(bArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Ow(@yt.k double[] dArr, @yt.k ik.l<? super Double, Double> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d10 : dArr) {
            dDoubleValue += selector.i(Double.valueOf(d10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Ox(float[] fArr, ik.l<? super Float, p1> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (float f10 : fArr) {
            j10 = p1.j(j10 + selector.i(Float.valueOf(f10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final <C extends Collection<? super Short>> C Oy(@yt.k short[] sArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (short s10 : sArr) {
            destination.add(Short.valueOf(s10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Byte> Oz(@yt.k byte[] bArr, @yt.k Iterable<Byte> other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Byte> setVz = vz(bArr);
        x.n0(setVz, other);
        return setVz;
    }

    public static final boolean P5(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Byte>> M P6(@yt.k byte[] bArr, @yt.k M destination, @yt.k ik.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (byte b10 : bArr) {
            destination.put(keySelector.i(Byte.valueOf(b10)), Byte.valueOf(b10));
        }
        return destination;
    }

    @hk.h(name = "averageOfDouble")
    public static final double P7(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double dDoubleValue = 0.0d;
        int i10 = 0;
        for (Double d10 : dArr) {
            dDoubleValue += d10.doubleValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i10);
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.t0(expression = "any { it == element }", imports = {}))
    @kotlin.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean P8(double[] dArr, double d10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        for (double d11 : dArr) {
            if (d11 == d10) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final List<Byte> P9(@yt.k byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (i10 >= 0) {
            return Ux(bArr, qk.v.u(bArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, V> List<V> PA(@yt.k long[] jArr, @yt.k R[] other, @yt.k ik.p<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Long.valueOf(jArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Short> Pa(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            }
        }
        return arrayList;
    }

    @bk.f
    public static final Byte Pb(byte[] bArr, ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return Byte.valueOf(b10);
            }
        }
        return null;
    }

    @yt.l
    public static final <T> T Pc(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    public static final <R> R Pd(@yt.k byte[] bArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Byte.valueOf(bArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    @yt.k
    public static final qk.m Pe(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return new qk.m(0, Ye(sArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Pf(@yt.k double[] dArr, @yt.k M destination, @yt.k ik.l<? super Double, ? extends K> keySelector, @yt.k ik.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (double d10 : dArr) {
            K kI = keySelector.i(Double.valueOf(d10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Double.valueOf(d10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean Pg(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    public static final byte Ph(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return bArr[Re(bArr)];
    }

    @yt.k
    public static final <R> List<R> Pi(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(transform.i(Short.valueOf(s10)));
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Pj(char[] cArr, ik.l<? super Character, Double> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Character.valueOf(cArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Character.valueOf(cArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float Pk(boolean[] zArr, ik.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Boolean.valueOf(zArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Boolean.valueOf(zArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final int Pl(@yt.k int[] iArr, @yt.k Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) < 0) {
                i10 = i11;
            }
        }
        return i10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Pm(double[] dArr, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short Pn(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (s10 > s11) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long[] Po(long[] jArr, ik.l<? super Long, z1> action) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (long j10 : jArr) {
            action.i(Long.valueOf(j10));
        }
        return jArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Long Pp(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return Qp(jArr, Random.f38003a);
    }

    public static final char Pq(@yt.k char[] cArr, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            cCharValue = operation.A(Integer.valueOf(i10), Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return cCharValue;
    }

    @yt.k
    public static final List<Short> Pr(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Short> listTz = tz(sArr);
        z.m1(listTz);
        return listTz;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ps(long[] jArr, R r10, ik.p<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        for (long j10 : jArr) {
            r10 = operation.r0(r10, Long.valueOf(j10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Byte Pt(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Byte bValueOf = null;
        boolean z10 = false;
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                bValueOf = Byte.valueOf(b10);
                z10 = true;
            }
        }
        if (z10) {
            return bValueOf;
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void Pu(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.m.I4(tArr, new g.c(selector));
        }
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Character> Pv(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return gw(cArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Pw(@yt.k float[] fArr, @yt.k ik.l<? super Float, Double> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f10 : fArr) {
            dDoubleValue += selector.i(Float.valueOf(f10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Px(int[] iArr, ik.l<? super Integer, p1> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (int i10 : iArr) {
            j10 = p1.j(j10 + selector.i(Integer.valueOf(i10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final <C extends Collection<? super Boolean>> C Py(@yt.k boolean[] zArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (boolean z10 : zArr) {
            destination.add(Boolean.valueOf(z10));
        }
        return destination;
    }

    @yt.k
    public static final Set<Character> Pz(@yt.k char[] cArr, @yt.k Iterable<Character> other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Character> setWz = wz(cArr);
        x.n0(setWz, other);
        return setWz;
    }

    public static final <T> boolean Q5(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M Q6(@yt.k byte[] bArr, @yt.k M destination, @yt.k ik.l<? super Byte, ? extends K> keySelector, @yt.k ik.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (byte b10 : bArr) {
            destination.put(keySelector.i(Byte.valueOf(b10)), valueTransform.i(Byte.valueOf(b10)));
        }
        return destination;
    }

    @hk.h(name = "averageOfFloat")
    public static final double Q7(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        double dFloatValue = 0.0d;
        int i10 = 0;
        for (Float f10 : fArr) {
            dFloatValue += (double) f10.floatValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i10);
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.t0(expression = "any { it == element }", imports = {}))
    @kotlin.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean Q8(float[] fArr, float f10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        for (float f11 : fArr) {
            if (f11 == f10) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final List<Character> Q9(@yt.k char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (i10 >= 0) {
            return Vx(cArr, qk.v.u(cArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <T, R> List<Pair<T, R>> QA(@yt.k T[] tArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(tArr[i10], r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Boolean> Qa(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            }
        }
        return arrayList;
    }

    @bk.f
    public static final Character Qb(char[] cArr, ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                return Character.valueOf(c10);
            }
        }
        return null;
    }

    @yt.l
    public static final Short Qc(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R Qd(@yt.k char[] cArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Character.valueOf(cArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    @yt.k
    public static final qk.m Qe(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return new qk.m(0, Ze(zArr));
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Float>>> M Qf(@yt.k float[] fArr, @yt.k M destination, @yt.k ik.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (float f10 : fArr) {
            K kI = keySelector.i(Float.valueOf(f10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f10));
        }
        return destination;
    }

    @bk.f
    public static final boolean Qg(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    public static final byte Qh(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                byte b10 = bArr[length];
                if (!predicate.i(Byte.valueOf(b10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return b10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R> List<R> Qi(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(transform.i(Boolean.valueOf(z10)));
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Qj(double[] dArr, ik.l<? super Double, Double> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Double.valueOf(dArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Double.valueOf(dArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Qk(byte[] bArr, Comparator<? super R> comparator, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final long Ql(@yt.k long[] jArr, @yt.k Comparator<? super Long> comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) < 0) {
                j10 = j11;
            }
        }
        return j10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Qm(float[] fArr, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final byte Qn(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (b10 > b11) {
                b10 = b11;
            }
        }
        return b10;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> T[] Qo(T[] tArr, ik.l<? super T, z1> action) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (T t10 : tArr) {
            action.i(t10);
        }
        return tArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long Qp(@yt.k long[] jArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.p(jArr.length)]);
    }

    public static final double Qq(@yt.k double[] dArr, @yt.k ik.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            dDoubleValue = operation.A(Integer.valueOf(i10), Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Boolean> Qr(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        List<Boolean> listUz = uz(zArr);
        z.m1(listUz);
        return listUz;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> Qs(@yt.k T[] tArr, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        for (a0.b bVar : tArr) {
            r10 = operation.r0(r10, bVar);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Character Qt(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final void Qu(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length > 1) {
            kotlin.collections.m.h4(bArr);
            qr(bArr);
        }
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Double> Qv(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return hw(dArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Qw(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 : iArr) {
            dDoubleValue += selector.i(Integer.valueOf(i10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Qx(long[] jArr, ik.l<? super Long, p1> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (long j11 : jArr) {
            j10 = p1.j(j10 + selector.i(Long.valueOf(j11)).l0());
        }
        return j10;
    }

    @yt.k
    public static final double[] Qy(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr2[i10] = dArr[i10].doubleValue();
        }
        return dArr2;
    }

    @yt.k
    public static final Set<Double> Qz(@yt.k double[] dArr, @yt.k Iterable<Double> other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Double> setXz = xz(dArr);
        x.n0(setXz, other);
        return setXz;
    }

    public static final <T> boolean R5(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Character>> M R6(@yt.k char[] cArr, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (char c10 : cArr) {
            destination.put(keySelector.i(Character.valueOf(c10)), Character.valueOf(c10));
        }
        return destination;
    }

    @hk.h(name = "averageOfInt")
    public static final double R7(@yt.k Integer[] numArr) {
        kotlin.jvm.internal.f0.p(numArr, "<this>");
        double dIntValue = 0.0d;
        int i10 = 0;
        for (Integer num : numArr) {
            dIntValue += (double) num.intValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i10);
    }

    public static final boolean R8(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return hg(iArr, i10) >= 0;
    }

    @yt.k
    public static final List<Double> R9(@yt.k double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (i10 >= 0) {
            return Wx(dArr, qk.v.u(dArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, R, V> List<V> RA(@yt.k T[] tArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(tArr[i10], r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Byte> Ra(@yt.k byte[] bArr, @yt.k ik.p<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Double Rb(double[] dArr, ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                return Double.valueOf(d10);
            }
        }
        return null;
    }

    @yt.l
    public static final Short Rc(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                return Short.valueOf(s10);
            }
        }
        return null;
    }

    public static final <R> R Rd(@yt.k double[] dArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Double.valueOf(dArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int Re(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Rf(@yt.k float[] fArr, @yt.k M destination, @yt.k ik.l<? super Float, ? extends K> keySelector, @yt.k ik.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (float f10 : fArr) {
            K kI = keySelector.i(Float.valueOf(f10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Float.valueOf(f10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean Rg(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    public static final char Rh(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return cArr[Se(cArr)];
    }

    @yt.k
    public static final <R> List<R> Ri(@yt.k byte[] bArr, @yt.k ik.p<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Rj(float[] fArr, ik.l<? super Float, Double> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Float.valueOf(fArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Float.valueOf(fArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Rk(char[] cArr, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T> T Rl(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (comparator.compare(t10, t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Rm(int[] iArr, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final char Rn(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (kotlin.jvm.internal.f0.t(c10, c11) > 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final short[] Ro(short[] sArr, ik.l<? super Short, z1> action) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (short s10 : sArr) {
            action.i(Short.valueOf(s10));
        }
        return sArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> T Rp(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (T) Sp(tArr, Random.f38003a);
    }

    public static final float Rq(@yt.k float[] fArr, @yt.k ik.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            fFloatValue = operation.A(Integer.valueOf(i10), Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return fFloatValue;
    }

    @yt.k
    public static final byte[] Rr(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int iRe = Re(bArr);
        k0 it2 = new qk.m(0, iRe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            bArr2[iRe - iB] = bArr[iB];
        }
        return bArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Rs(short[] sArr, R r10, ik.p<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        for (short s10 : sArr) {
            r10 = operation.r0(r10, Short.valueOf(s10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Character Rt(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                chValueOf = Character.valueOf(c10);
                z10 = true;
            }
        }
        if (z10) {
            return chValueOf;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final void Ru(@yt.k byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.collections.m.i4(bArr, i10, i11);
        rr(bArr, i10, i11);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Float> Rv(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return iw(fArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Rw(@yt.k long[] jArr, @yt.k ik.l<? super Long, Double> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j10 : jArr) {
            dDoubleValue += selector.i(Long.valueOf(j10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final <T> long Rx(T[] tArr, ik.l<? super T, p1> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (T t10 : tArr) {
            j10 = p1.j(j10 + selector.i(t10).l0());
        }
        return j10;
    }

    @yt.k
    public static final float[] Ry(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            fArr2[i10] = fArr[i10].floatValue();
        }
        return fArr2;
    }

    @yt.k
    public static final Set<Float> Rz(@yt.k float[] fArr, @yt.k Iterable<Float> other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Float> setYz = yz(fArr);
        x.n0(setYz, other);
        return setYz;
    }

    public static final boolean S5(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M S6(@yt.k char[] cArr, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (char c10 : cArr) {
            destination.put(keySelector.i(Character.valueOf(c10)), valueTransform.i(Character.valueOf(c10)));
        }
        return destination;
    }

    @hk.h(name = "averageOfLong")
    public static final double S7(@yt.k Long[] lArr) {
        kotlin.jvm.internal.f0.p(lArr, "<this>");
        double dLongValue = 0.0d;
        int i10 = 0;
        for (Long l10 : lArr) {
            dLongValue += l10.longValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i10);
    }

    public static final boolean S8(@yt.k long[] jArr, long j10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return ig(jArr, j10) >= 0;
    }

    @yt.k
    public static final List<Float> S9(@yt.k float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (i10 >= 0) {
            return Xx(fArr, qk.v.u(fArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <T, R> List<Pair<T, R>> SA(@yt.k T[] tArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(tArr[i10], other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Character> Sa(@yt.k char[] cArr, @yt.k ik.p<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char c10 = cArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Float Sb(float[] fArr, ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                return Float.valueOf(f10);
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Sc(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            x.n0(arrayList, transform.i(Byte.valueOf(b10)));
        }
        return arrayList;
    }

    public static final <R> R Sd(@yt.k float[] fArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Float.valueOf(fArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int Se(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr.length - 1;
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Integer>>> M Sf(@yt.k int[] iArr, @yt.k M destination, @yt.k ik.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (int i10 : iArr) {
            K kI = keySelector.i(Integer.valueOf(i10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i10));
        }
        return destination;
    }

    @bk.f
    public static final boolean Sg(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    public static final char Sh(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char c10 = cArr[length];
                if (!predicate.i(Character.valueOf(c10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return c10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R> List<R> Si(@yt.k char[] cArr, @yt.k ik.p<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Sj(int[] iArr, ik.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Integer.valueOf(iArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Integer.valueOf(iArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Sk(double[] dArr, Comparator<? super R> comparator, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final short Sl(@yt.k short[] sArr, @yt.k Comparator<? super Short> comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) < 0) {
                s10 = s11;
            }
        }
        return s10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Sm(long[] jArr, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double Sn(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dMin = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dMin = Math.min(dMin, dArr[it2.b()]);
        }
        return dMin;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean[] So(boolean[] zArr, ik.l<? super Boolean, z1> action) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (boolean z10 : zArr) {
            action.i(Boolean.valueOf(z10));
        }
        return zArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T> T Sp(@yt.k T[] tArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.p(tArr.length)];
    }

    public static final int Sq(@yt.k int[] iArr, @yt.k ik.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iIntValue = operation.A(Integer.valueOf(i10), Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final char[] Sr(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int iSe = Se(cArr);
        k0 it2 = new qk.m(0, iSe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            cArr2[iSe - iB] = cArr[iB];
        }
        return cArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ss(boolean[] zArr, R r10, ik.p<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        for (boolean z10 : zArr) {
            r10 = operation.r0(r10, Boolean.valueOf(z10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Double St(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final void Su(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length > 1) {
            kotlin.collections.m.j4(cArr);
            sr(cArr);
        }
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Integer> Sv(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return jw(iArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> double Sw(@yt.k T[] tArr, @yt.k ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t10 : tArr) {
            dDoubleValue += selector.i(t10).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Sx(short[] sArr, ik.l<? super Short, p1> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (short s10 : sArr) {
            j10 = p1.j(j10 + selector.i(Short.valueOf(s10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final HashSet<Byte> Sy(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return (HashSet) Hy(bArr, new HashSet(r0.j(bArr.length)));
    }

    @yt.k
    public static final Set<Integer> Sz(@yt.k int[] iArr, @yt.k Iterable<Integer> other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Integer> setZz = zz(iArr);
        x.n0(setZz, other);
        return setZz;
    }

    public static final boolean T5(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Double>> M T6(@yt.k double[] dArr, @yt.k M destination, @yt.k ik.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (double d10 : dArr) {
            destination.put(keySelector.i(Double.valueOf(d10)), Double.valueOf(d10));
        }
        return destination;
    }

    @hk.h(name = "averageOfShort")
    public static final double T7(@yt.k Short[] shArr) {
        kotlin.jvm.internal.f0.p(shArr, "<this>");
        double dShortValue = 0.0d;
        int i10 = 0;
        for (Short sh2 : shArr) {
            dShortValue += (double) sh2.shortValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i10);
    }

    public static final <T> boolean T8(@yt.k T[] tArr, T t10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return jg(tArr, t10) >= 0;
    }

    @yt.k
    public static final List<Integer> T9(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (i10 >= 0) {
            return Yx(iArr, qk.v.u(iArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <T, R, V> List<V> TA(@yt.k T[] tArr, @yt.k R[] other, @yt.k ik.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(tArr[i10], other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> Ta(@yt.k double[] dArr, @yt.k ik.p<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            double d10 = dArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Integer Tb(int[] iArr, ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                return Integer.valueOf(i10);
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Tc(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            x.n0(arrayList, transform.i(Character.valueOf(c10)));
        }
        return arrayList;
    }

    public static final <R> R Td(@yt.k int[] iArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Integer.valueOf(iArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int Te(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Tf(@yt.k int[] iArr, @yt.k M destination, @yt.k ik.l<? super Integer, ? extends K> keySelector, @yt.k ik.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (int i10 : iArr) {
            K kI = keySelector.i(Integer.valueOf(i10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Integer.valueOf(i10)));
        }
        return destination;
    }

    @bk.f
    public static final <T> boolean Tg(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    public static final double Th(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return dArr[Te(dArr)];
    }

    @yt.k
    public static final <R> List<R> Ti(@yt.k double[] dArr, @yt.k ik.p<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Tj(long[] jArr, ik.l<? super Long, Double> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Long.valueOf(jArr[0])).doubleValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Long.valueOf(jArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Tk(float[] fArr, Comparator<? super R> comparator, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final boolean Tl(@yt.k boolean[] zArr, @yt.k Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) < 0) {
                z10 = z11;
            }
        }
        return z10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R Tm(T[] tArr, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double Tn(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        k0 it2 = new qk.m(1, Xe(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, dArr[it2.b()].doubleValue());
        }
        return dDoubleValue;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final byte[] To(byte[] bArr, ik.p<? super Integer, ? super Byte, z1> action) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Byte.valueOf(bArr[i10]));
            i10++;
            i11++;
        }
        return bArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Short Tp(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return Up(sArr, Random.f38003a);
    }

    public static final long Tq(@yt.k long[] jArr, @yt.k ik.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jLongValue = operation.A(Integer.valueOf(i10), Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final double[] Tr(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int iTe = Te(dArr);
        k0 it2 = new qk.m(0, iTe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            dArr2[iTe - iB] = dArr[iB];
        }
        return dArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ts(byte[] bArr, R r10, ik.q<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Byte.valueOf(bArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Double Tt(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Double dValueOf = null;
        boolean z10 = false;
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                dValueOf = Double.valueOf(d10);
                z10 = true;
            }
        }
        if (z10) {
            return dValueOf;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final void Tu(@yt.k char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.collections.m.k4(cArr, i10, i11);
        tr(cArr, i10, i11);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Long> Tv(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return kw(jArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Tw(@yt.k short[] sArr, @yt.k ik.l<? super Short, Double> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s10 : sArr) {
            dDoubleValue += selector.i(Short.valueOf(s10)).doubleValue();
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long Tx(boolean[] zArr, ik.l<? super Boolean, p1> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (boolean z10 : zArr) {
            j10 = p1.j(j10 + selector.i(Boolean.valueOf(z10)).l0());
        }
        return j10;
    }

    @yt.k
    public static final HashSet<Character> Ty(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return (HashSet) Iy(cArr, new HashSet(r0.j(qk.v.B(cArr.length, 128))));
    }

    @yt.k
    public static final Set<Long> Tz(@yt.k long[] jArr, @yt.k Iterable<Long> other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Long> setAz = Az(jArr);
        x.n0(setAz, other);
        return setAz;
    }

    public static final boolean U5(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M U6(@yt.k double[] dArr, @yt.k M destination, @yt.k ik.l<? super Double, ? extends K> keySelector, @yt.k ik.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (double d10 : dArr) {
            destination.put(keySelector.i(Double.valueOf(d10)), valueTransform.i(Double.valueOf(d10)));
        }
        return destination;
    }

    @bk.f
    public static final byte U7(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr[0];
    }

    public static final boolean U8(@yt.k short[] sArr, short s10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return kg(sArr, s10) >= 0;
    }

    @yt.k
    public static final List<Long> U9(@yt.k long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (i10 >= 0) {
            return Zx(jArr, qk.v.u(jArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<Pair<Short, R>> UA(@yt.k short[] sArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Short.valueOf(sArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Float> Ua(@yt.k float[] fArr, @yt.k ik.p<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            float f10 = fArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Long Ub(long[] jArr, ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                return Long.valueOf(j10);
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Uc(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            x.n0(arrayList, transform.i(Double.valueOf(d10)));
        }
        return arrayList;
    }

    public static final <R> R Ud(@yt.k long[] jArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Long.valueOf(jArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int Ue(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr.length - 1;
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Long>>> M Uf(@yt.k long[] jArr, @yt.k M destination, @yt.k ik.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (long j10 : jArr) {
            K kI = keySelector.i(Long.valueOf(j10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j10));
        }
        return destination;
    }

    @bk.f
    public static final boolean Ug(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    public static final double Uh(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                double d10 = dArr[length];
                if (!predicate.i(Double.valueOf(d10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return d10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R> List<R> Ui(@yt.k float[] fArr, @yt.k ik.p<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> double Uj(T[] tArr, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(tArr[0]).doubleValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(tArr[it2.b()]).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Uk(int[] iArr, Comparator<? super R> comparator, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Boolean Ul(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z10);
        }
        R rI = selector.i(Boolean.valueOf(z10));
        k0 it2 = new qk.m(1, iZe).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            R rI2 = selector.i(Boolean.valueOf(z11));
            if (rI.compareTo(rI2) > 0) {
                z10 = z11;
                rI = rI2;
            }
        }
        return Boolean.valueOf(z10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Um(short[] sArr, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float Un(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fMin = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fMin = Math.min(fMin, fArr[it2.b()]);
        }
        return fMin;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final char[] Uo(char[] cArr, ik.p<? super Integer, ? super Character, z1> action) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Character.valueOf(cArr[i10]));
            i10++;
            i11++;
        }
        return cArr;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short Up(@yt.k short[] sArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.p(sArr.length)]);
    }

    public static final <S, T extends S> S Uq(@yt.k T[] tArr, @yt.k ik.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sA = (S) tArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sA = operation.A(Integer.valueOf(i10), (Object) tArr[i10], sA);
        }
        return sA;
    }

    @yt.k
    public static final float[] Ur(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int iUe = Ue(fArr);
        k0 it2 = new qk.m(0, iUe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            fArr2[iUe - iB] = fArr[iB];
        }
        return fArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Us(char[] cArr, R r10, ik.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Character.valueOf(cArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Float Ut(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final void Uu(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length > 1) {
            kotlin.collections.m.l4(dArr);
            ur(dArr);
        }
    }

    @yt.k
    public static final <T, R extends Comparable<? super R>> List<T> Uv(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return lw(tArr, new g.c(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Uw(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z10 : zArr) {
            dDoubleValue += selector.i(Boolean.valueOf(z10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Byte> Ux(@yt.k byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= bArr.length) {
            return cz(bArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final HashSet<Double> Uy(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return (HashSet) Jy(dArr, new HashSet(r0.j(dArr.length)));
    }

    @yt.k
    public static final <T> Set<T> Uz(@yt.k T[] tArr, @yt.k Iterable<? extends T> other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<T> setBz = Bz(tArr);
        x.n0(setBz, other);
        return setBz;
    }

    public static final boolean V5(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Float>> M V6(@yt.k float[] fArr, @yt.k M destination, @yt.k ik.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (float f10 : fArr) {
            destination.put(keySelector.i(Float.valueOf(f10)), Float.valueOf(f10));
        }
        return destination;
    }

    @bk.f
    public static final char V7(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr[0];
    }

    public static final boolean V8(@yt.k boolean[] zArr, boolean z10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return lg(zArr, z10) >= 0;
    }

    @yt.k
    public static final <T> List<T> V9(@yt.k T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (i10 >= 0) {
            return ay(tArr, qk.v.u(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, V> List<V> VA(@yt.k short[] sArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Short.valueOf(sArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> Va(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            int i13 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Integer.valueOf(i12)).booleanValue()) {
                arrayList.add(Integer.valueOf(i12));
            }
            i10++;
            i11 = i13;
        }
        return arrayList;
    }

    @bk.f
    public static final <T> T Vb(T[] tArr, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Vc(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            x.n0(arrayList, transform.i(Float.valueOf(f10)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Vd(@yt.k T[] tArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = operation.A(Integer.valueOf(i11), r10, tArr[i10]);
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int Ve(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Vf(@yt.k long[] jArr, @yt.k M destination, @yt.k ik.l<? super Long, ? extends K> keySelector, @yt.k ik.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (long j10 : jArr) {
            K kI = keySelector.i(Long.valueOf(j10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Long.valueOf(j10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean Vg(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    public static final float Vh(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return fArr[Ue(fArr)];
    }

    @yt.k
    public static final <R> List<R> Vi(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Vj(short[] sArr, ik.l<? super Short, Double> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Short.valueOf(sArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Short.valueOf(sArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Vk(long[] jArr, Comparator<? super R> comparator, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Byte Vl(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b10);
        }
        R rI = selector.i(Byte.valueOf(b10));
        k0 it2 = new qk.m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            R rI2 = selector.i(Byte.valueOf(b11));
            if (rI.compareTo(rI2) > 0) {
                b10 = b11;
                rI = rI2;
            }
        }
        return Byte.valueOf(b10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Vm(boolean[] zArr, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float Vn(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = fArr[0].floatValue();
        k0 it2 = new qk.m(1, Xe(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, fArr[it2.b()].floatValue());
        }
        return fFloatValue;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double[] Vo(double[] dArr, ik.p<? super Integer, ? super Double, z1> action) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Double.valueOf(dArr[i10]));
            i10++;
            i11++;
        }
        return dArr;
    }

    public static final byte Vp(@yt.k byte[] bArr, @yt.k ik.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            bByteValue = operation.r0(Byte.valueOf(bByteValue), Byte.valueOf(bArr[it2.b()])).byteValue();
        }
        return bByteValue;
    }

    public static final short Vq(@yt.k short[] sArr, @yt.k ik.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sShortValue = operation.A(Integer.valueOf(i10), Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return sShortValue;
    }

    @yt.k
    public static final int[] Vr(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int iVe = Ve(iArr);
        k0 it2 = new qk.m(0, iVe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            iArr2[iVe - iB] = iArr[iB];
        }
        return iArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Vs(double[] dArr, R r10, ik.q<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Double.valueOf(dArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Float Vt(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Float fValueOf = null;
        boolean z10 = false;
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                fValueOf = Float.valueOf(f10);
                z10 = true;
            }
        }
        if (z10) {
            return fValueOf;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final void Vu(@yt.k double[] dArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.collections.m.m4(dArr, i10, i11);
        vr(dArr, i10, i11);
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Short> Vv(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return mw(sArr, new g.c(selector));
    }

    @hk.h(name = "sumOfByte")
    public static final int Vw(@yt.k Byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int iByteValue = 0;
        for (Byte b10 : bArr) {
            iByteValue += b10.byteValue();
        }
        return iByteValue;
    }

    @yt.k
    public static final List<Character> Vx(@yt.k char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= cArr.length) {
            return dz(cArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final HashSet<Float> Vy(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return (HashSet) Ky(fArr, new HashSet(r0.j(fArr.length)));
    }

    @yt.k
    public static final Set<Short> Vz(@yt.k short[] sArr, @yt.k Iterable<Short> other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Short> setCz = Cz(sArr);
        x.n0(setCz, other);
        return setCz;
    }

    @yt.k
    public static final Iterable<Byte> W5(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new b(bArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M W6(@yt.k float[] fArr, @yt.k M destination, @yt.k ik.l<? super Float, ? extends K> keySelector, @yt.k ik.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (float f10 : fArr) {
            destination.put(keySelector.i(Float.valueOf(f10)), valueTransform.i(Float.valueOf(f10)));
        }
        return destination;
    }

    @bk.f
    public static final double W7(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr[0];
    }

    @bk.f
    public static final int W8(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr.length;
    }

    @yt.k
    public static final List<Short> W9(@yt.k short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (i10 >= 0) {
            return by(sArr, qk.v.u(sArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<Pair<Short, R>> WA(@yt.k short[] sArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            short s10 = sArr[i10];
            arrayList.add(kotlin.d1.a(Short.valueOf(s10), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Long> Wa(@yt.k long[] jArr, @yt.k ik.p<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            long j10 = jArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Short Wb(short[] sArr, ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                return Short.valueOf(s10);
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Wc(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            x.n0(arrayList, transform.i(Integer.valueOf(i10)));
        }
        return arrayList;
    }

    public static final <R> R Wd(@yt.k short[] sArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Short.valueOf(sArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int We(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr.length - 1;
    }

    @yt.k
    public static final <T, K, M extends Map<? super K, List<T>>> M Wf(@yt.k T[] tArr, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (T t10 : tArr) {
            K kI = keySelector.i(t10);
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(t10);
        }
        return destination;
    }

    @bk.f
    public static final boolean Wg(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final float Wh(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                float f10 = fArr[length];
                if (!predicate.i(Float.valueOf(f10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return f10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R> List<R> Wi(@yt.k long[] jArr, @yt.k ik.p<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Wj(boolean[] zArr, ik.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Boolean.valueOf(zArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Boolean.valueOf(zArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R Wk(T[] tArr, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Character Wl(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c10);
        }
        R rI = selector.i(Character.valueOf(c10));
        k0 it2 = new qk.m(1, iSe).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            R rI2 = selector.i(Character.valueOf(c11));
            if (rI.compareTo(rI2) > 0) {
                c10 = c11;
                rI = rI2;
            }
        }
        return Character.valueOf(c10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Wm(byte[] bArr, ik.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Byte.valueOf(bArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Byte.valueOf(bArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final int Wn(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (i10 > i11) {
                i10 = i11;
            }
        }
        return i10;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float[] Wo(float[] fArr, ik.p<? super Integer, ? super Float, z1> action) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Float.valueOf(fArr[i10]));
            i10++;
            i11++;
        }
        return fArr;
    }

    public static final char Wp(@yt.k char[] cArr, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            cCharValue = operation.r0(Character.valueOf(cCharValue), Character.valueOf(cArr[it2.b()])).charValue();
        }
        return cCharValue;
    }

    public static final boolean Wq(@yt.k boolean[] zArr, @yt.k ik.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i10 = iZe - 1; i10 >= 0; i10--) {
            zBooleanValue = operation.A(Integer.valueOf(i10), Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return zBooleanValue;
    }

    @yt.k
    public static final long[] Wr(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int iWe = We(jArr);
        k0 it2 = new qk.m(0, iWe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            jArr2[iWe - iB] = jArr[iB];
        }
        return jArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ws(float[] fArr, R r10, ik.q<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Float.valueOf(fArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Integer Wt(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final void Wu(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length > 1) {
            kotlin.collections.m.n4(fArr);
            wr(fArr);
        }
    }

    @yt.k
    public static final <R extends Comparable<? super R>> List<Boolean> Wv(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        return nw(zArr, new g.c(selector));
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Ww(byte[] bArr, ik.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b10 : bArr) {
            dDoubleValue += selector.i(Byte.valueOf(b10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Double> Wx(@yt.k double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= dArr.length) {
            return ez(dArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final HashSet<Integer> Wy(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return (HashSet) Ly(iArr, new HashSet(r0.j(iArr.length)));
    }

    @yt.k
    public static final Set<Boolean> Wz(@yt.k boolean[] zArr, @yt.k Iterable<Boolean> other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Boolean> setDz = Dz(zArr);
        x.n0(setDz, other);
        return setDz;
    }

    @yt.k
    public static final Iterable<Character> X5(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new i(cArr);
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Integer>> M X6(@yt.k int[] iArr, @yt.k M destination, @yt.k ik.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (int i10 : iArr) {
            destination.put(keySelector.i(Integer.valueOf(i10)), Integer.valueOf(i10));
        }
        return destination;
    }

    @bk.f
    public static final float X7(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr[0];
    }

    public static final int X8(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final List<Boolean> X9(@yt.k boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (i10 >= 0) {
            return cy(zArr, qk.v.u(zArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, V> List<V> XA(@yt.k short[] sArr, @yt.k R[] other, @yt.k ik.p<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Short.valueOf(sArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> Xa(@yt.k T[] tArr, @yt.k ik.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            T t10 = tArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), t10).booleanValue()) {
                arrayList.add(t10);
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Boolean Xb(boolean[] zArr, ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                boolean z10 = zArr[length];
                if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                    return Boolean.valueOf(z10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Xc(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            x.n0(arrayList, transform.i(Long.valueOf(j10)));
        }
        return arrayList;
    }

    public static final <R> R Xd(@yt.k boolean[] zArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Boolean.valueOf(zArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final <T> int Xe(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, K, V, M extends Map<? super K, List<V>>> M Xf(@yt.k T[] tArr, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (T t10 : tArr) {
            K kI = keySelector.i(t10);
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(t10));
        }
        return destination;
    }

    @bk.f
    public static final boolean Xg(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static final int Xh(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[Ve(iArr)];
    }

    @yt.k
    public static final <T, R> List<R> Xi(@yt.k T[] tArr, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float Xj(byte[] bArr, ik.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Byte.valueOf(bArr[0])).floatValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Byte.valueOf(bArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Xk(short[] sArr, Comparator<? super R> comparator, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Double Xl(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d10);
        }
        R rI = selector.i(Double.valueOf(d10));
        k0 it2 = new qk.m(1, iTe).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            R rI2 = selector.i(Double.valueOf(d11));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Xm(char[] cArr, ik.l<? super Character, Double> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Character.valueOf(cArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Character.valueOf(cArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final long Xn(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (j10 > j11) {
                j10 = j11;
            }
        }
        return j10;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int[] Xo(int[] iArr, ik.p<? super Integer, ? super Integer, z1> action) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Integer.valueOf(iArr[i10]));
            i10++;
            i11++;
        }
        return iArr;
    }

    public static final double Xp(@yt.k double[] dArr, @yt.k ik.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = operation.r0(Double.valueOf(dDoubleValue), Double.valueOf(dArr[it2.b()])).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean Xq(@yt.k boolean[] zArr, @yt.k ik.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i10 = iZe - 1; i10 >= 0; i10--) {
            zBooleanValue = operation.A(Integer.valueOf(i10), Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @yt.k
    public static final <T> T[] Xr(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) kotlin.collections.k.a(tArr, tArr.length);
        int iXe = Xe(tArr);
        k0 it2 = new qk.m(0, iXe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            tArr2[iXe - iB] = tArr[iB];
        }
        return tArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Xs(int[] iArr, R r10, ik.q<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Integer.valueOf(iArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Integer Xt(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Integer numValueOf = null;
        boolean z10 = false;
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                numValueOf = Integer.valueOf(i10);
                z10 = true;
            }
        }
        if (z10) {
            return numValueOf;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final void Xu(@yt.k float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.collections.m.o4(fArr, i10, i11);
        xr(fArr, i10, i11);
    }

    @yt.k
    public static final List<Byte> Xv(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.h4(bArrCopyOf);
        return Ir(bArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Xw(char[] cArr, ik.l<? super Character, Double> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c10 : cArr) {
            dDoubleValue += selector.i(Character.valueOf(c10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Float> Xx(@yt.k float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= fArr.length) {
            return fz(fArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final HashSet<Long> Xy(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return (HashSet) My(jArr, new HashSet(r0.j(jArr.length)));
    }

    @yt.k
    public static final Iterable<h0<Byte>> Xz(@yt.k final byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Byte>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Byte> o() {
                return kotlin.jvm.internal.i.b(bArr);
            }
        });
    }

    @yt.k
    public static final Iterable<Double> Y5(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new g(dArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M Y6(@yt.k int[] iArr, @yt.k M destination, @yt.k ik.l<? super Integer, ? extends K> keySelector, @yt.k ik.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (int i10 : iArr) {
            destination.put(keySelector.i(Integer.valueOf(i10)), valueTransform.i(Integer.valueOf(i10)));
        }
        return destination;
    }

    @bk.f
    public static final int Y7(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr[0];
    }

    @bk.f
    public static final int Y8(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr.length;
    }

    @yt.k
    public static final List<Byte> Y9(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iRe = Re(bArr); -1 < iRe; iRe--) {
            if (!predicate.i(Byte.valueOf(bArr[iRe])).booleanValue()) {
                return Ux(bArr, iRe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final List<Pair<Short, Short>> YA(@yt.k short[] sArr, @yt.k short[] other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Short.valueOf(sArr[i10]), Short.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Short> Ya(@yt.k short[] sArr, @yt.k ik.p<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            short s10 = sArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Byte Yb(byte[] bArr, ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                byte b10 = bArr[length];
                if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                    return Byte.valueOf(b10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @yt.k
    public static final <T, R> List<R> Yc(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            x.n0(arrayList, transform.i(t10));
        }
        return arrayList;
    }

    public static final <R> R Yd(@yt.k byte[] bArr, R r10, @yt.k ik.p<? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iRe = Re(bArr); iRe >= 0; iRe--) {
            r10 = operation.r0(Byte.valueOf(bArr[iRe]), r10);
        }
        return r10;
    }

    public static final int Ye(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr.length - 1;
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Short>>> M Yf(@yt.k short[] sArr, @yt.k M destination, @yt.k ik.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (short s10 : sArr) {
            K kI = keySelector.i(Short.valueOf(s10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s10));
        }
        return destination;
    }

    @bk.f
    public static final boolean Yg(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final int Yh(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                int i11 = iArr[length];
                if (!predicate.i(Integer.valueOf(i11)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return i11;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R> List<R> Yi(@yt.k short[] sArr, @yt.k ik.p<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float Yj(char[] cArr, ik.l<? super Character, Float> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Character.valueOf(cArr[0])).floatValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Character.valueOf(cArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Yk(boolean[] zArr, Comparator<? super R> comparator, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Float Yl(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f10);
        }
        R rI = selector.i(Float.valueOf(f10));
        k0 it2 = new qk.m(1, iUe).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            R rI2 = selector.i(Float.valueOf(f11));
            if (rI.compareTo(rI2) > 0) {
                f10 = f11;
                rI = rI2;
            }
        }
        return Float.valueOf(f10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Ym(double[] dArr, ik.l<? super Double, Double> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Double.valueOf(dArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Double.valueOf(dArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    @yt.k
    public static final <T extends Comparable<? super T>> T Yn(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (t10.compareTo(t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long[] Yo(long[] jArr, ik.p<? super Integer, ? super Long, z1> action) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Long.valueOf(jArr[i10]));
            i10++;
            i11++;
        }
        return jArr;
    }

    public static final float Yp(@yt.k float[] fArr, @yt.k ik.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = operation.r0(Float.valueOf(fFloatValue), Float.valueOf(fArr[it2.b()])).floatValue();
        }
        return fFloatValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte Yq(@yt.k byte[] bArr, @yt.k ik.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            return null;
        }
        byte bByteValue = bArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bByteValue = operation.A(Integer.valueOf(i10), Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @yt.k
    public static final short[] Yr(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int iYe = Ye(sArr);
        k0 it2 = new qk.m(0, iYe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sArr2[iYe - iB] = sArr[iB];
        }
        return sArr2;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> Ys(long[] jArr, R r10, ik.q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Long.valueOf(jArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Long Yt(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final void Yu(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length > 1) {
            kotlin.collections.m.p4(iArr);
            yr(iArr);
        }
    }

    @yt.k
    public static final List<Character> Yv(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.f0.o(cArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.j4(cArrCopyOf);
        return Jr(cArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Yw(double[] dArr, ik.l<? super Double, Double> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d10 : dArr) {
            dDoubleValue += selector.i(Double.valueOf(d10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Integer> Yx(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= iArr.length) {
            return gz(iArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (int i12 : iArr) {
            arrayList.add(Integer.valueOf(i12));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <T> HashSet<T> Yy(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (HashSet) Ny(tArr, new HashSet(r0.j(tArr.length)));
    }

    @yt.k
    public static final Iterable<h0<Character>> Yz(@yt.k final char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Character>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Character> o() {
                return kotlin.jvm.internal.i.c(cArr);
            }
        });
    }

    @yt.k
    public static final Iterable<Float> Z5(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new f(fArr);
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Long>> M Z6(@yt.k long[] jArr, @yt.k M destination, @yt.k ik.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (long j10 : jArr) {
            destination.put(keySelector.i(Long.valueOf(j10)), Long.valueOf(j10));
        }
        return destination;
    }

    @bk.f
    public static final long Z7(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr[0];
    }

    public static final int Z8(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final List<Character> Z9(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iSe = Se(cArr); -1 < iSe; iSe--) {
            if (!predicate.i(Character.valueOf(cArr[iSe])).booleanValue()) {
                return Vx(cArr, iSe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <V> List<V> ZA(@yt.k short[] sArr, @yt.k short[] other, @yt.k ik.p<? super Short, ? super Short, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Short.valueOf(sArr[i10]), Short.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Boolean> Za(@yt.k boolean[] zArr, @yt.k ik.p<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            boolean z10 = zArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @bk.f
    public static final Character Zb(char[] cArr, ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char c10 = cArr[length];
                if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                    return Character.valueOf(c10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> Zc(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            x.n0(arrayList, transform.i(Short.valueOf(s10)));
        }
        return arrayList;
    }

    public static final <R> R Zd(@yt.k char[] cArr, R r10, @yt.k ik.p<? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iSe = Se(cArr); iSe >= 0; iSe--) {
            r10 = operation.r0(Character.valueOf(cArr[iSe]), r10);
        }
        return r10;
    }

    public static final int Ze(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M Zf(@yt.k short[] sArr, @yt.k M destination, @yt.k ik.l<? super Short, ? extends K> keySelector, @yt.k ik.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (short s10 : sArr) {
            K kI = keySelector.i(Short.valueOf(s10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Short.valueOf(s10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean Zg(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static final long Zh(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[We(jArr)];
    }

    @yt.k
    public static final <R> List<R> Zi(@yt.k boolean[] zArr, @yt.k ik.p<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float Zj(double[] dArr, ik.l<? super Double, Float> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Double.valueOf(dArr[0])).floatValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Double.valueOf(dArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R Zk(byte[] bArr, Comparator<? super R> comparator, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Integer Zl(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i10);
        }
        R rI = selector.i(Integer.valueOf(i10));
        k0 it2 = new qk.m(1, iVe).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            R rI2 = selector.i(Integer.valueOf(i11));
            if (rI.compareTo(rI2) > 0) {
                i10 = i11;
                rI = rI2;
            }
        }
        return Integer.valueOf(i10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double Zm(float[] fArr, ik.l<? super Float, Double> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Float.valueOf(fArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Float.valueOf(fArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "minOrThrow")
    @kotlin.v0(version = "1.7")
    public static final short Zn(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (s10 > s11) {
                s10 = s11;
            }
        }
        return s10;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> T[] Zo(T[] tArr, ik.p<? super Integer, ? super T, z1> action) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), tArr[i10]);
            i10++;
            i11++;
        }
        return tArr;
    }

    public static final int Zp(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            iIntValue = operation.r0(Integer.valueOf(iIntValue), Integer.valueOf(iArr[it2.b()])).intValue();
        }
        return iIntValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character Zq(@yt.k char[] cArr, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            return null;
        }
        char cCharValue = cArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            cCharValue = operation.A(Integer.valueOf(i10), Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @yt.k
    public static final boolean[] Zr(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int iZe = Ze(zArr);
        k0 it2 = new qk.m(0, iZe).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            zArr2[iZe - iB] = zArr[iB];
        }
        return zArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> Zs(@yt.k T[] tArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, tArr[i10]);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final Long Zt(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Long lValueOf = null;
        boolean z10 = false;
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                lValueOf = Long.valueOf(j10);
                z10 = true;
            }
        }
        if (z10) {
            return lValueOf;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final void Zu(@yt.k int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.collections.m.q4(iArr, i10, i11);
        zr(iArr, i10, i11);
    }

    @yt.k
    public static final List<Double> Zv(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.f0.o(dArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.l4(dArrCopyOf);
        return Kr(dArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double Zw(float[] fArr, ik.l<? super Float, Double> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f10 : fArr) {
            dDoubleValue += selector.i(Float.valueOf(f10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Long> Zx(@yt.k long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= jArr.length) {
            return hz(jArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final HashSet<Short> Zy(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return (HashSet) Oy(sArr, new HashSet(r0.j(sArr.length)));
    }

    @yt.k
    public static final Iterable<h0<Double>> Zz(@yt.k final double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Double>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Double> o() {
                return kotlin.jvm.internal.i.d(dArr);
            }
        });
    }

    @yt.k
    public static final Iterable<Integer> a6(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new d(iArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M a7(@yt.k long[] jArr, @yt.k M destination, @yt.k ik.l<? super Long, ? extends K> keySelector, @yt.k ik.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (long j10 : jArr) {
            destination.put(keySelector.i(Long.valueOf(j10)), valueTransform.i(Long.valueOf(j10)));
        }
        return destination;
    }

    @bk.f
    public static final <T> T a8(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr[0];
    }

    @bk.f
    public static final int a9(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr.length;
    }

    @yt.k
    public static final Iterable<h0<Float>> aA(@yt.k final float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Float>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Float> o() {
                return kotlin.jvm.internal.i.e(fArr);
            }
        });
    }

    @yt.k
    public static final <R> List<Pair<Boolean, R>> aB(@yt.k boolean[] zArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Boolean.valueOf(zArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> aa(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iTe = Te(dArr); -1 < iTe; iTe--) {
            if (!predicate.i(Double.valueOf(dArr[iTe])).booleanValue()) {
                return Wx(dArr, iTe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <C extends Collection<? super Byte>> C ab(@yt.k byte[] bArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Byte.valueOf(b10)).booleanValue()) {
                destination.add(Byte.valueOf(b10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @bk.f
    public static final Double ac(double[] dArr, ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                double d10 = dArr[length];
                if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                    return Double.valueOf(d10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @yt.k
    public static final <R> List<R> ad(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            x.n0(arrayList, transform.i(Boolean.valueOf(z10)));
        }
        return arrayList;
    }

    public static final <R> R ae(@yt.k double[] dArr, R r10, @yt.k ik.p<? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iTe = Te(dArr); iTe >= 0; iTe--) {
            r10 = operation.r0(Double.valueOf(dArr[iTe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final byte af(byte[] bArr, int i10, ik.l<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Re(bArr)) ? defaultValue.i(Integer.valueOf(i10)).byteValue() : bArr[i10];
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Boolean>>> M ag(@yt.k boolean[] zArr, @yt.k M destination, @yt.k ik.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (boolean z10 : zArr) {
            K kI = keySelector.i(Boolean.valueOf(z10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z10));
        }
        return destination;
    }

    @bk.f
    public static final boolean ah(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final long ai(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                long j10 = jArr[length];
                if (!predicate.i(Long.valueOf(j10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return j10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <T, R> List<R> aj(@yt.k T[] tArr, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            R rR0 = transform.r0(Integer.valueOf(i11), tArr[i10]);
            if (rR0 != null) {
                arrayList.add(rR0);
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float ak(float[] fArr, ik.l<? super Float, Float> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Float.valueOf(fArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Float.valueOf(fArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R al(char[] cArr, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Long am(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j10);
        }
        R rI = selector.i(Long.valueOf(j10));
        k0 it2 = new qk.m(1, iWe).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            R rI2 = selector.i(Long.valueOf(j11));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double an(int[] iArr, ik.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Integer.valueOf(iArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Integer.valueOf(iArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean ao(@yt.k boolean[] zArr, @yt.k Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) > 0) {
                z10 = z11;
            }
        }
        return Boolean.valueOf(z10);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final short[] ap(short[] sArr, ik.p<? super Integer, ? super Short, z1> action) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Short.valueOf(sArr[i10]));
            i10++;
            i11++;
        }
        return sArr;
    }

    public static final long aq(@yt.k long[] jArr, @yt.k ik.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            jLongValue = operation.r0(Long.valueOf(jLongValue), Long.valueOf(jArr[it2.b()])).longValue();
        }
        return jLongValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double ar(@yt.k double[] dArr, @yt.k ik.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            return null;
        }
        double dDoubleValue = dArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            dDoubleValue = operation.A(Integer.valueOf(i10), Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> as(byte[] bArr, R r10, ik.p<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        for (byte b10 : bArr) {
            r10 = operation.r0(r10, Byte.valueOf(b10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> at(short[] sArr, R r10, ik.q<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Short.valueOf(sArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final <T> T au(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final void av(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length > 1) {
            kotlin.collections.m.r4(jArr);
            Ar(jArr);
        }
    }

    @yt.k
    public static final List<Float> aw(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.f0.o(fArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.n4(fArrCopyOf);
        return Lr(fArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double ax(int[] iArr, ik.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 : iArr) {
            dDoubleValue += selector.i(Integer.valueOf(i10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <T> List<T> ay(@yt.k T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= tArr.length) {
            return iz(tArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (T t10 : tArr) {
            arrayList.add(t10);
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final HashSet<Boolean> az(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return (HashSet) Py(zArr, new HashSet(r0.j(zArr.length)));
    }

    @yt.k
    public static final Iterable<Long> b6(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new e(jArr);
    }

    @yt.k
    public static final <T, K, M extends Map<? super K, ? super T>> M b7(@yt.k T[] tArr, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (T t10 : tArr) {
            destination.put(keySelector.i(t10), t10);
        }
        return destination;
    }

    @bk.f
    public static final short b8(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr[0];
    }

    public static final int b9(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final Iterable<h0<Integer>> bA(@yt.k final int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Integer>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Integer> o() {
                return kotlin.jvm.internal.i.f(iArr);
            }
        });
    }

    @yt.k
    public static final <R, V> List<V> bB(@yt.k boolean[] zArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Boolean.valueOf(zArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Float> ba(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iUe = Ue(fArr); -1 < iUe; iUe--) {
            if (!predicate.i(Float.valueOf(fArr[iUe])).booleanValue()) {
                return Xx(fArr, iUe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <C extends Collection<? super Character>> C bb(@yt.k char[] cArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char c10 = cArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Character.valueOf(c10)).booleanValue()) {
                destination.add(Character.valueOf(c10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @bk.f
    public static final Float bc(float[] fArr, ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                float f10 = fArr[length];
                if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                    return Float.valueOf(f10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> bd(byte[] bArr, ik.p<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R be(@yt.k float[] fArr, R r10, @yt.k ik.p<? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iUe = Ue(fArr); iUe >= 0; iUe--) {
            r10 = operation.r0(Float.valueOf(fArr[iUe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final char bf(char[] cArr, int i10, ik.l<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Se(cArr)) ? defaultValue.i(Integer.valueOf(i10)).charValue() : cArr[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M bg(@yt.k boolean[] zArr, @yt.k M destination, @yt.k ik.l<? super Boolean, ? extends K> keySelector, @yt.k ik.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (boolean z10 : zArr) {
            K kI = keySelector.i(Boolean.valueOf(z10));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Boolean.valueOf(z10)));
        }
        return destination;
    }

    @bk.f
    public static final boolean bh(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final <T> T bi(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[Xe(tArr)];
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C bj(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            R rR0 = transform.r0(Integer.valueOf(i11), tArr[i10]);
            if (rR0 != null) {
                destination.add(rR0);
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float bk(int[] iArr, ik.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Integer.valueOf(iArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Integer.valueOf(iArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R bl(double[] dArr, Comparator<? super R> comparator, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T, R extends Comparable<? super R>> T bm(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t10;
        }
        R rI = selector.i(t10);
        k0 it2 = new qk.m(1, iXe).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            R rI2 = selector.i(t11);
            if (rI.compareTo(rI2) > 0) {
                t10 = t11;
                rI = rI2;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double bn(long[] jArr, ik.l<? super Long, Double> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Long.valueOf(jArr[0])).doubleValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Long.valueOf(jArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte bo(@yt.k byte[] bArr, @yt.k Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) > 0) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean[] bp(boolean[] zArr, ik.p<? super Integer, ? super Boolean, z1> action) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Boolean.valueOf(zArr[i10]));
            i10++;
            i11++;
        }
        return zArr;
    }

    public static final <S, T extends S> S bq(@yt.k T[] tArr, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sR0 = (S) tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            sR0 = operation.r0(sR0, (Object) tArr[it2.b()]);
        }
        return sR0;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float br(@yt.k float[] fArr, @yt.k ik.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            return null;
        }
        float fFloatValue = fArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            fFloatValue = operation.A(Integer.valueOf(i10), Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> bs(char[] cArr, R r10, ik.p<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        for (char c10 : cArr) {
            r10 = operation.r0(r10, Character.valueOf(c10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> bt(boolean[] zArr, R r10, ik.q<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Boolean.valueOf(zArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.l
    public static final <T> T bu(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : tArr) {
            if (predicate.i(t11).booleanValue()) {
                if (z10) {
                    return null;
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final void bv(@yt.k long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.collections.m.s4(jArr, i10, i11);
        Br(jArr, i10, i11);
    }

    @yt.k
    public static final List<Integer> bw(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.f0.o(iArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.p4(iArrCopyOf);
        return Mr(iArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double bx(long[] jArr, ik.l<? super Long, Double> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j10 : jArr) {
            dDoubleValue += selector.i(Long.valueOf(j10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Short> by(@yt.k short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= sArr.length) {
            return jz(sArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final int[] bz(@yt.k Integer[] numArr) {
        kotlin.jvm.internal.f0.p(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    @yt.k
    public static final <T> Iterable<T> c6(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new a(tArr);
    }

    @yt.k
    public static final <T, K, V, M extends Map<? super K, ? super V>> M c7(@yt.k T[] tArr, @yt.k M destination, @yt.k ik.l<? super T, ? extends K> keySelector, @yt.k ik.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (T t10 : tArr) {
            destination.put(keySelector.i(t10), valueTransform.i(t10));
        }
        return destination;
    }

    @bk.f
    public static final boolean c8(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr[0];
    }

    @bk.f
    public static final int c9(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr.length;
    }

    @yt.k
    public static final Iterable<h0<Long>> cA(@yt.k final long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Long>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Long> o() {
                return kotlin.jvm.internal.i.g(jArr);
            }
        });
    }

    @yt.k
    public static final <R> List<Pair<Boolean, R>> cB(@yt.k boolean[] zArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            boolean z10 = zArr[i10];
            arrayList.add(kotlin.d1.a(Boolean.valueOf(z10), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> ca(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iVe = Ve(iArr); -1 < iVe; iVe--) {
            if (!predicate.i(Integer.valueOf(iArr[iVe])).booleanValue()) {
                return Yx(iArr, iVe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <C extends Collection<? super Double>> C cb(@yt.k double[] dArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            double d10 = dArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Double.valueOf(d10)).booleanValue()) {
                destination.add(Double.valueOf(d10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @bk.f
    public static final Integer cc(int[] iArr, ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                int i11 = iArr[length];
                if (predicate.i(Integer.valueOf(i11)).booleanValue()) {
                    return Integer.valueOf(i11);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> cd(char[] cArr, ik.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R ce(@yt.k int[] iArr, R r10, @yt.k ik.p<? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iVe = Ve(iArr); iVe >= 0; iVe--) {
            r10 = operation.r0(Integer.valueOf(iArr[iVe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final double cf(double[] dArr, int i10, ik.l<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Te(dArr)) ? defaultValue.i(Integer.valueOf(i10)).doubleValue() : dArr[i10];
    }

    @kotlin.v0(version = "1.1")
    @yt.k
    public static final <T, K> d0<T, K> cg(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        return new s(tArr, keySelector);
    }

    @bk.f
    public static final <T> boolean ch(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final <T> T ci(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                T t10 = tArr[length];
                if (!predicate.i(t10).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return t10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C cj(@yt.k byte[] bArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float ck(long[] jArr, ik.l<? super Long, Float> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Long.valueOf(jArr[0])).floatValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Long.valueOf(jArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R cl(float[] fArr, Comparator<? super R> comparator, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Short cm(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s10);
        }
        R rI = selector.i(Short.valueOf(s10));
        k0 it2 = new qk.m(1, iYe).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            R rI2 = selector.i(Short.valueOf(s11));
            if (rI.compareTo(rI2) > 0) {
                s10 = s11;
                rI = rI2;
            }
        }
        return Short.valueOf(s10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Double cn(T[] tArr, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(tArr[0]).doubleValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(tArr[it2.b()]).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character co(@yt.k char[] cArr, @yt.k Comparator<? super Character> comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) > 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    @yt.k
    public static final Pair<List<Byte>, List<Byte>> cp(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            } else {
                arrayList2.add(Byte.valueOf(b10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final short cq(@yt.k short[] sArr, @yt.k ik.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            sShortValue = operation.r0(Short.valueOf(sShortValue), Short.valueOf(sArr[it2.b()])).shortValue();
        }
        return sShortValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer cr(@yt.k int[] iArr, @yt.k ik.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            return null;
        }
        int iIntValue = iArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iIntValue = operation.A(Integer.valueOf(i10), Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> cs(double[] dArr, R r10, ik.p<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        for (double d10 : dArr) {
            r10 = operation.r0(r10, Double.valueOf(d10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void ct(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        dt(bArr, Random.f38003a);
    }

    @yt.l
    public static final Short cu(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final <T extends Comparable<? super T>> void cv(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.collections.m.I4(tArr, uj.g.x());
    }

    @yt.k
    public static final List<Long> cw(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.f0.o(jArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.r4(jArrCopyOf);
        return Nr(jArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    public static final double cx(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double dDoubleValue = 0.0d;
        for (Double d10 : dArr) {
            dDoubleValue += d10.doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Boolean> cy(@yt.k boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        if (i10 >= zArr.length) {
            return kz(zArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Byte> cz(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? mz(bArr) : kotlin.collections.s.k(Byte.valueOf(bArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final Iterable<Short> d6(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new c(sArr);
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Short>> M d7(@yt.k short[] sArr, @yt.k M destination, @yt.k ik.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (short s10 : sArr) {
            destination.put(keySelector.i(Short.valueOf(s10)), Short.valueOf(s10));
        }
        return destination;
    }

    @bk.f
    public static final byte d8(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr[1];
    }

    public static final int d9(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final <T> Iterable<h0<T>> dA(@yt.k final T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return new i0(new ik.a<Iterator<? extends T>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<T> o() {
                return kotlin.jvm.internal.h.a(tArr);
            }
        });
    }

    @yt.k
    public static final <R, V> List<V> dB(@yt.k boolean[] zArr, @yt.k R[] other, @yt.k ik.p<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Boolean.valueOf(zArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Long> da(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iWe = We(jArr); -1 < iWe; iWe--) {
            if (!predicate.i(Long.valueOf(jArr[iWe])).booleanValue()) {
                return Zx(jArr, iWe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <C extends Collection<? super Float>> C db(@yt.k float[] fArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            float f10 = fArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Float.valueOf(f10)).booleanValue()) {
                destination.add(Float.valueOf(f10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @bk.f
    public static final Long dc(long[] jArr, ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                long j10 = jArr[length];
                if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                    return Long.valueOf(j10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> dd(double[] dArr, ik.p<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R de(@yt.k long[] jArr, R r10, @yt.k ik.p<? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iWe = We(jArr); iWe >= 0; iWe--) {
            r10 = operation.r0(Long.valueOf(jArr[iWe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final float df(float[] fArr, int i10, ik.l<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ue(fArr)) ? defaultValue.i(Integer.valueOf(i10)).floatValue() : fArr[i10];
    }

    public static final int dg(@yt.k byte[] bArr, byte b10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @bk.f
    public static final boolean dh(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static final short di(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[Ye(sArr)];
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C dj(@yt.k char[] cArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> float dk(T[] tArr, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(tArr[0]).floatValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(tArr[it2.b()]).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R dl(int[] iArr, Comparator<? super R> comparator, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> byte dm(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return b10;
        }
        R rI = selector.i(Byte.valueOf(b10));
        k0 it2 = new qk.m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            R rI2 = selector.i(Byte.valueOf(b11));
            if (rI.compareTo(rI2) > 0) {
                b10 = b11;
                rI = rI2;
            }
        }
        return b10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double dn(short[] sArr, ik.l<? super Short, Double> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Short.valueOf(sArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Short.valueOf(sArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final Double m8do(@yt.k double[] dArr, @yt.k Comparator<? super Double> comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) > 0) {
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @yt.k
    public static final Pair<List<Character>, List<Character>> dp(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            } else {
                arrayList2.add(Character.valueOf(c10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean dq(@yt.k boolean[] zArr, @yt.k ik.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            zBooleanValue = operation.r0(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[it2.b()])).booleanValue();
        }
        return zBooleanValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long dr(@yt.k long[] jArr, @yt.k ik.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            return null;
        }
        long jLongValue = jArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jLongValue = operation.A(Integer.valueOf(i10), Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> ds(float[] fArr, R r10, ik.p<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        for (float f10 : fArr) {
            r10 = operation.r0(r10, Float.valueOf(f10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void dt(@yt.k byte[] bArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iRe = Re(bArr); iRe > 0; iRe--) {
            int iP = random.p(iRe + 1);
            byte b10 = bArr[iRe];
            bArr[iRe] = bArr[iP];
            bArr[iP] = b10;
        }
    }

    @yt.l
    public static final Short du(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Short shValueOf = null;
        boolean z10 = false;
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                shValueOf = Short.valueOf(s10);
                z10 = true;
            }
        }
        if (z10) {
            return shValueOf;
        }
        return null;
    }

    @kotlin.v0(version = "1.4")
    public static final <T extends Comparable<? super T>> void dv(@yt.k T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.collections.m.J4(tArr, uj.g.x(), i10, i11);
    }

    @yt.k
    public static final <T extends Comparable<? super T>> List<T> dw(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return lw(tArr, uj.g.x());
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> double dx(T[] tArr, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t10 : tArr) {
            dDoubleValue += selector.i(t10).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Byte> dy(@yt.k byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = bArr.length;
        if (i10 >= length) {
            return cz(bArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Byte.valueOf(bArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Character> dz(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? nz(cArr) : kotlin.collections.s.k(Character.valueOf(cArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final Iterable<Boolean> e6(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new h(zArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M e7(@yt.k short[] sArr, @yt.k M destination, @yt.k ik.l<? super Short, ? extends K> keySelector, @yt.k ik.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (short s10 : sArr) {
            destination.put(keySelector.i(Short.valueOf(s10)), valueTransform.i(Short.valueOf(s10)));
        }
        return destination;
    }

    @bk.f
    public static final char e8(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr[1];
    }

    @bk.f
    public static final int e9(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr.length;
    }

    @yt.k
    public static final Iterable<h0<Short>> eA(@yt.k final short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Short>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Short> o() {
                return kotlin.jvm.internal.i.h(sArr);
            }
        });
    }

    @yt.k
    public static final List<Pair<Boolean, Boolean>> eB(@yt.k boolean[] zArr, @yt.k boolean[] other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Boolean.valueOf(zArr[i10]), Boolean.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> ea(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iXe = Xe(tArr); -1 < iXe; iXe--) {
            if (!predicate.i(tArr[iXe]).booleanValue()) {
                return ay(tArr, iXe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <C extends Collection<? super Integer>> C eb(@yt.k int[] iArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            int i13 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Integer.valueOf(i12)).booleanValue()) {
                destination.add(Integer.valueOf(i12));
            }
            i10++;
            i11 = i13;
        }
        return destination;
    }

    @bk.f
    public static final <T> T ec(T[] tArr, ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                T t10 = tArr[length];
                if (predicate.i(t10).booleanValue()) {
                    return t10;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> ed(float[] fArr, ik.p<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ee(@yt.k T[] tArr, R r10, @yt.k ik.p<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iXe = Xe(tArr); iXe >= 0; iXe--) {
            r10 = operation.r0(tArr[iXe], r10);
        }
        return r10;
    }

    @bk.f
    public static final int ef(int[] iArr, int i10, ik.l<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ve(iArr)) ? defaultValue.i(Integer.valueOf(i10)).intValue() : iArr[i10];
    }

    public static final int eg(@yt.k char[] cArr, char c10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @bk.f
    public static final boolean eh(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final short ei(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                short s10 = sArr[length];
                if (!predicate.i(Short.valueOf(s10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return s10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C ej(@yt.k double[] dArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float ek(short[] sArr, ik.l<? super Short, Float> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Short.valueOf(sArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Short.valueOf(sArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R el(long[] jArr, Comparator<? super R> comparator, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> char em(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return c10;
        }
        R rI = selector.i(Character.valueOf(c10));
        k0 it2 = new qk.m(1, iSe).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            R rI2 = selector.i(Character.valueOf(c11));
            if (rI.compareTo(rI2) > 0) {
                c10 = c11;
                rI = rI2;
            }
        }
        return c10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double en(boolean[] zArr, ik.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Boolean.valueOf(zArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Boolean.valueOf(zArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float eo(@yt.k float[] fArr, @yt.k Comparator<? super Float> comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) > 0) {
                f10 = f11;
            }
        }
        return Float.valueOf(f10);
    }

    @yt.k
    public static final Pair<List<Double>, List<Double>> ep(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            } else {
                arrayList2.add(Double.valueOf(d10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final byte eq(@yt.k byte[] bArr, @yt.k ik.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            bByteValue = operation.A(Integer.valueOf(iB), Byte.valueOf(bByteValue), Byte.valueOf(bArr[iB])).byteValue();
        }
        return bByteValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S er(@yt.k T[] tArr, @yt.k ik.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            return null;
        }
        S sA = (S) tArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sA = operation.A(Integer.valueOf(i10), (Object) tArr[i10], sA);
        }
        return sA;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> es(int[] iArr, R r10, ik.p<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        for (int i10 : iArr) {
            r10 = operation.r0(r10, Integer.valueOf(i10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void et(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        ft(cArr, Random.f38003a);
    }

    @yt.k
    public static final List<Byte> eu(@yt.k byte[] bArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final void ev(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length > 1) {
            kotlin.collections.m.x4(sArr);
            Er(sArr);
        }
    }

    @yt.k
    public static final List<Short> ew(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.f0.o(sArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.x4(sArrCopyOf);
        return Pr(sArrCopyOf);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double ex(short[] sArr, ik.l<? super Short, Double> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s10 : sArr) {
            dDoubleValue += selector.i(Short.valueOf(s10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Character> ey(@yt.k char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = cArr.length;
        if (i10 >= length) {
            return dz(cArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Character.valueOf(cArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> ez(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? oz(dArr) : kotlin.collections.s.k(Double.valueOf(dArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final kotlin.sequences.m<Byte> f6(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr.length == 0 ? SequencesKt__SequencesKt.g() : new k(bArr);
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Boolean>> M f7(@yt.k boolean[] zArr, @yt.k M destination, @yt.k ik.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        for (boolean z10 : zArr) {
            destination.put(keySelector.i(Boolean.valueOf(z10)), Boolean.valueOf(z10));
        }
        return destination;
    }

    @bk.f
    public static final double f8(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr[1];
    }

    public static final int f9(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (int i11 : iArr) {
            if (predicate.i(Integer.valueOf(i11)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final Iterable<h0<Boolean>> fA(@yt.k final boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return new i0(new ik.a<Iterator<? extends Boolean>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Boolean> o() {
                return kotlin.jvm.internal.i.a(zArr);
            }
        });
    }

    @yt.k
    public static final <V> List<V> fB(@yt.k boolean[] zArr, @yt.k boolean[] other, @yt.k ik.p<? super Boolean, ? super Boolean, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Boolean.valueOf(zArr[i10]), Boolean.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Short> fa(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iYe = Ye(sArr); -1 < iYe; iYe--) {
            if (!predicate.i(Short.valueOf(sArr[iYe])).booleanValue()) {
                return by(sArr, iYe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <C extends Collection<? super Long>> C fb(@yt.k long[] jArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            long j10 = jArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Long.valueOf(j10)).booleanValue()) {
                destination.add(Long.valueOf(j10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @bk.f
    public static final Short fc(short[] sArr, ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                short s10 = sArr[length];
                if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                    return Short.valueOf(s10);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> fd(int[] iArr, ik.p<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R fe(@yt.k short[] sArr, R r10, @yt.k ik.p<? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iYe = Ye(sArr); iYe >= 0; iYe--) {
            r10 = operation.r0(Short.valueOf(sArr[iYe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final long ff(long[] jArr, int i10, ik.l<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > We(jArr)) ? defaultValue.i(Integer.valueOf(i10)).longValue() : jArr[i10];
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.t0(expression = "indexOfFirst { it == element }", imports = {}))
    @kotlin.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int fg(double[] dArr, double d10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (d10 == dArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A fh(@yt.k byte[] bArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Byte, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Byte.valueOf(b10)));
            } else {
                buffer.append(String.valueOf((int) b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean fi(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[Ze(zArr)];
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C fj(@yt.k float[] fArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float fk(boolean[] zArr, ik.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Boolean.valueOf(zArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Boolean.valueOf(zArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R fl(T[] tArr, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> double fm(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return d10;
        }
        R rI = selector.i(Double.valueOf(d10));
        k0 it2 = new qk.m(1, iTe).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            R rI2 = selector.i(Double.valueOf(d11));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                d10 = d11;
            }
        }
        return d10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float fn(byte[] bArr, ik.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Byte.valueOf(bArr[0])).floatValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Byte.valueOf(bArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer fo(@yt.k int[] iArr, @yt.k Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) > 0) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @yt.k
    public static final Pair<List<Float>, List<Float>> fp(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            } else {
                arrayList2.add(Float.valueOf(f10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final char fq(@yt.k char[] cArr, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            cCharValue = operation.A(Integer.valueOf(iB), Character.valueOf(cCharValue), Character.valueOf(cArr[iB])).charValue();
        }
        return cCharValue;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short fr(@yt.k short[] sArr, @yt.k ik.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            return null;
        }
        short sShortValue = sArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sShortValue = operation.A(Integer.valueOf(i10), Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> fs(long[] jArr, R r10, ik.p<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        for (long j10 : jArr) {
            r10 = operation.r0(r10, Long.valueOf(j10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void ft(@yt.k char[] cArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iSe = Se(cArr); iSe > 0; iSe--) {
            int iP = random.p(iSe + 1);
            char c10 = cArr[iSe];
            cArr[iSe] = cArr[iP];
            cArr[iP] = c10;
        }
    }

    @yt.k
    public static final List<Byte> fu(@yt.k byte[] bArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.n(kotlin.collections.m.G1(bArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @kotlin.v0(version = "1.4")
    public static final void fv(@yt.k short[] sArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.collections.m.y4(sArr, i10, i11);
        Fr(sArr, i10, i11);
    }

    @yt.k
    public static final List<Byte> fw(@yt.k byte[] bArr, @yt.k Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Byte[] bArrO5 = kotlin.collections.m.o5(bArr);
        kotlin.collections.m.I4(bArrO5, comparator);
        return kotlin.collections.m.t(bArrO5);
    }

    @hk.h(name = "sumOfDouble")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double fx(boolean[] zArr, ik.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z10 : zArr) {
            dDoubleValue += selector.i(Boolean.valueOf(z10)).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final List<Double> fy(@yt.k double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = dArr.length;
        if (i10 >= length) {
            return ez(dArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Double.valueOf(dArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Float> fz(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? pz(fArr) : kotlin.collections.s.k(Float.valueOf(fArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final kotlin.sequences.m<Character> g6(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr.length == 0 ? SequencesKt__SequencesKt.g() : new r(cArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M g7(@yt.k boolean[] zArr, @yt.k M destination, @yt.k ik.l<? super Boolean, ? extends K> keySelector, @yt.k ik.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        for (boolean z10 : zArr) {
            destination.put(keySelector.i(Boolean.valueOf(z10)), valueTransform.i(Boolean.valueOf(z10)));
        }
        return destination;
    }

    @bk.f
    public static final float g8(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr[1];
    }

    @bk.f
    public static final int g9(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr.length;
    }

    @yt.k
    public static final <R> List<Pair<Byte, R>> gA(@yt.k byte[] bArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Byte.valueOf(bArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Boolean> ga(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iZe = Ze(zArr); -1 < iZe; iZe--) {
            if (!predicate.i(Boolean.valueOf(zArr[iZe])).booleanValue()) {
                return cy(zArr, iZe + 1);
            }
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <T, C extends Collection<? super T>> C gb(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            T t10 = tArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), t10).booleanValue()) {
                destination.add(t10);
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    public static final byte gc(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return bArr[0];
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> gd(long[] jArr, ik.p<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R ge(@yt.k boolean[] zArr, R r10, @yt.k ik.p<? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iZe = Ze(zArr); iZe >= 0; iZe--) {
            r10 = operation.r0(Boolean.valueOf(zArr[iZe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final <T> T gf(T[] tArr, int i10, ik.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Xe(tArr)) ? defaultValue.i(Integer.valueOf(i10)) : tArr[i10];
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.t0(expression = "indexOfFirst { it == element }", imports = {}))
    @kotlin.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int gg(float[] fArr, float f10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (f10 == fArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A gh(@yt.k char[] cArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Character, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (char c10 : cArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Character.valueOf(c10)));
            } else {
                buffer.append(c10);
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean gi(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                boolean z10 = zArr[length];
                if (!predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return z10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C gj(@yt.k int[] iArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R gk(byte[] bArr, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R gl(short[] sArr, Comparator<? super R> comparator, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> float gm(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return f10;
        }
        R rI = selector.i(Float.valueOf(f10));
        k0 it2 = new qk.m(1, iUe).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            R rI2 = selector.i(Float.valueOf(f11));
            if (rI.compareTo(rI2) > 0) {
                f10 = f11;
                rI = rI2;
            }
        }
        return f10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float gn(char[] cArr, ik.l<? super Character, Float> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Character.valueOf(cArr[0])).floatValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Character.valueOf(cArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long go(@yt.k long[] jArr, @yt.k Comparator<? super Long> comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) > 0) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @yt.k
    public static final Pair<List<Integer>, List<Integer>> gp(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            } else {
                arrayList2.add(Integer.valueOf(i10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final double gq(@yt.k double[] dArr, @yt.k ik.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            dDoubleValue = operation.A(Integer.valueOf(iB), Double.valueOf(dDoubleValue), Double.valueOf(dArr[iB])).doubleValue();
        }
        return dDoubleValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean gr(@yt.k boolean[] zArr, @yt.k ik.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i10 = iZe - 1; i10 >= 0; i10--) {
            zBooleanValue = operation.r0(Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> gs(@yt.k T[] tArr, R r10, @yt.k ik.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        for (a0.b bVar : tArr) {
            r10 = operation.r0(r10, bVar);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void gt(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        ht(dArr, Random.f38003a);
    }

    @yt.k
    public static final List<Character> gu(@yt.k char[] cArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Byte> gv(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        Byte[] bArrO5 = kotlin.collections.m.o5(bArr);
        kotlin.collections.m.v4(bArrO5);
        return kotlin.collections.m.t(bArrO5);
    }

    @yt.k
    public static final List<Character> gw(@yt.k char[] cArr, @yt.k Comparator<? super Character> comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Character[] chArrP5 = kotlin.collections.m.p5(cArr);
        kotlin.collections.m.I4(chArrP5, comparator);
        return kotlin.collections.m.t(chArrP5);
    }

    @hk.h(name = "sumOfFloat")
    public static final float gx(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        float fFloatValue = 0.0f;
        for (Float f10 : fArr) {
            fFloatValue += f10.floatValue();
        }
        return fFloatValue;
    }

    @yt.k
    public static final List<Float> gy(@yt.k float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = fArr.length;
        if (i10 >= length) {
            return fz(fArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Float.valueOf(fArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> gz(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? qz(iArr) : kotlin.collections.s.k(Integer.valueOf(iArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final kotlin.sequences.m<Double> h6(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr.length == 0 ? SequencesKt__SequencesKt.g() : new p(dArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M h7(@yt.k byte[] bArr, @yt.k M destination, @yt.k ik.l<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (byte b10 : bArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Byte.valueOf(b10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final int h8(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr[1];
    }

    public static final int h9(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final <R, V> List<V> hA(@yt.k byte[] bArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Byte.valueOf(bArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Byte> ha(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (byte b10 : bArr) {
            if (z10) {
                arrayList.add(Byte.valueOf(b10));
            } else if (!predicate.i(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Short>> C hb(@yt.k short[] sArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            short s10 = sArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Short.valueOf(s10)).booleanValue()) {
                destination.add(Short.valueOf(s10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    public static final byte hc(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return b10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> List<R> hd(T[] tArr, ik.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R he(@yt.k byte[] bArr, R r10, @yt.k ik.q<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iRe = Re(bArr); iRe >= 0; iRe--) {
            r10 = operation.A(Integer.valueOf(iRe), Byte.valueOf(bArr[iRe]), r10);
        }
        return r10;
    }

    @bk.f
    public static final short hf(short[] sArr, int i10, ik.l<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ye(sArr)) ? defaultValue.i(Integer.valueOf(i10)).shortValue() : sArr[i10];
    }

    public static final int hg(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A hh(@yt.k double[] dArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Double, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (double d10 : dArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Double.valueOf(d10)));
            } else {
                buffer.append(String.valueOf(d10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int hi(@yt.k byte[] bArr, byte b10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (b10 == bArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C hj(@yt.k long[] jArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R hk(char[] cArr, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R hl(boolean[] zArr, Comparator<? super R> comparator, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> int hm(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return i10;
        }
        R rI = selector.i(Integer.valueOf(i10));
        k0 it2 = new qk.m(1, iVe).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            R rI2 = selector.i(Integer.valueOf(i11));
            if (rI.compareTo(rI2) > 0) {
                i10 = i11;
                rI = rI2;
            }
        }
        return i10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float hn(double[] dArr, ik.l<? super Double, Float> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Double.valueOf(dArr[0])).floatValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Double.valueOf(dArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T> T ho(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (comparator.compare(t10, t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @yt.k
    public static final Pair<List<Long>, List<Long>> hp(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            } else {
                arrayList2.add(Long.valueOf(j10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final float hq(@yt.k float[] fArr, @yt.k ik.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            fFloatValue = operation.A(Integer.valueOf(iB), Float.valueOf(fFloatValue), Float.valueOf(fArr[iB])).floatValue();
        }
        return fFloatValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte hr(@yt.k byte[] bArr, @yt.k ik.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            return null;
        }
        byte bByteValue = bArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            bByteValue = operation.r0(Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> hs(short[] sArr, R r10, ik.p<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        for (short s10 : sArr) {
            r10 = operation.r0(r10, Short.valueOf(s10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void ht(@yt.k double[] dArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iTe = Te(dArr); iTe > 0; iTe--) {
            int iP = random.p(iTe + 1);
            double d10 = dArr[iTe];
            dArr[iTe] = dArr[iP];
            dArr[iP] = d10;
        }
    }

    @yt.k
    public static final List<Character> hu(@yt.k char[] cArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.o(kotlin.collections.m.H1(cArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final List<Character> hv(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        Character[] chArrP5 = kotlin.collections.m.p5(cArr);
        kotlin.collections.m.v4(chArrP5);
        return kotlin.collections.m.t(chArrP5);
    }

    @yt.k
    public static final List<Double> hw(@yt.k double[] dArr, @yt.k Comparator<? super Double> comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Double[] dArrQ5 = kotlin.collections.m.q5(dArr);
        kotlin.collections.m.I4(dArrQ5, comparator);
        return kotlin.collections.m.t(dArrQ5);
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int hx(byte[] bArr, ik.l<? super Byte, Integer> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (byte b10 : bArr) {
            iIntValue += selector.i(Byte.valueOf(b10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Integer> hy(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = iArr.length;
        if (i10 >= length) {
            return gz(iArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Integer.valueOf(iArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Long> hz(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? rz(jArr) : kotlin.collections.s.k(Long.valueOf(jArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final kotlin.sequences.m<Float> i6(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr.length == 0 ? SequencesKt__SequencesKt.g() : new o(fArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M i7(@yt.k char[] cArr, @yt.k M destination, @yt.k ik.l<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (char c10 : cArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Character.valueOf(c10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final long i8(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr[1];
    }

    @bk.f
    public static final <T> int i9(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr.length;
    }

    @yt.k
    public static final List<Pair<Byte, Byte>> iA(@yt.k byte[] bArr, @yt.k byte[] other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Byte.valueOf(bArr[i10]), Byte.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Character> ia(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (char c10 : cArr) {
            if (z10) {
                arrayList.add(Character.valueOf(c10));
            } else if (!predicate.i(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <C extends Collection<? super Boolean>> C ib(@yt.k boolean[] zArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            boolean z10 = zArr[i10];
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Boolean.valueOf(z10)).booleanValue()) {
                destination.add(Boolean.valueOf(z10));
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    public static final char ic(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return cArr[0];
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> id(short[] sArr, ik.p<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R ie(@yt.k char[] cArr, R r10, @yt.k ik.q<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iSe = Se(cArr); iSe >= 0; iSe--) {
            r10 = operation.A(Integer.valueOf(iSe), Character.valueOf(cArr[iSe]), r10);
        }
        return r10;
    }

    @bk.f
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static final boolean m9if(boolean[] zArr, int i10, ik.l<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ze(zArr)) ? defaultValue.i(Integer.valueOf(i10)).booleanValue() : zArr[i10];
    }

    public static final int ig(@yt.k long[] jArr, long j10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A ih(@yt.k float[] fArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Float, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (float f10 : fArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Float.valueOf(f10)));
            } else {
                buffer.append(String.valueOf(f10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int ii(@yt.k char[] cArr, char c10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (c10 == cArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C ij(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R ik(double[] dArr, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte il(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (b10 < b11) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> long im(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return j10;
        }
        R rI = selector.i(Long.valueOf(j10));
        k0 it2 = new qk.m(1, iWe).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            R rI2 = selector.i(Long.valueOf(j11));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                j10 = j11;
            }
        }
        return j10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float in(float[] fArr, ik.l<? super Float, Float> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Float.valueOf(fArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Float.valueOf(fArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short io(@yt.k short[] sArr, @yt.k Comparator<? super Short> comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) > 0) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @yt.k
    public static final <T> Pair<List<T>, List<T>> ip(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            } else {
                arrayList2.add(t10);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final int iq(@yt.k int[] iArr, @yt.k ik.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            iIntValue = operation.A(Integer.valueOf(iB), Integer.valueOf(iIntValue), Integer.valueOf(iArr[iB])).intValue();
        }
        return iIntValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character ir(@yt.k char[] cArr, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            return null;
        }
        char cCharValue = cArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            cCharValue = operation.r0(Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> is(boolean[] zArr, R r10, ik.p<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        for (boolean z10 : zArr) {
            r10 = operation.r0(r10, Boolean.valueOf(z10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void it(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        jt(fArr, Random.f38003a);
    }

    @yt.k
    public static final List<Double> iu(@yt.k double[] dArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> iv(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        Double[] dArrQ5 = kotlin.collections.m.q5(dArr);
        kotlin.collections.m.v4(dArrQ5);
        return kotlin.collections.m.t(dArrQ5);
    }

    @yt.k
    public static final List<Float> iw(@yt.k float[] fArr, @yt.k Comparator<? super Float> comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Float[] fArrR5 = kotlin.collections.m.r5(fArr);
        kotlin.collections.m.I4(fArrR5, comparator);
        return kotlin.collections.m.t(fArrR5);
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int ix(char[] cArr, ik.l<? super Character, Integer> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (char c10 : cArr) {
            iIntValue += selector.i(Character.valueOf(c10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Long> iy(@yt.k long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = jArr.length;
        if (i10 >= length) {
            return hz(jArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Long.valueOf(jArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> iz(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? sz(tArr) : kotlin.collections.s.k(tArr[0]) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final kotlin.sequences.m<Integer> j6(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr.length == 0 ? SequencesKt__SequencesKt.g() : new m(iArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M j7(@yt.k double[] dArr, @yt.k M destination, @yt.k ik.l<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (double d10 : dArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Double.valueOf(d10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final <T> T j8(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr[1];
    }

    public static final <T> int j9(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final <V> List<V> jA(@yt.k byte[] bArr, @yt.k byte[] other, @yt.k ik.p<? super Byte, ? super Byte, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Byte.valueOf(bArr[i10]), Byte.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> ja(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (double d10 : dArr) {
            if (z10) {
                arrayList.add(Double.valueOf(d10));
            } else if (!predicate.i(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
                z10 = true;
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R> List<R> jb(Object[] objArr) {
        kotlin.jvm.internal.f0.p(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            kotlin.jvm.internal.f0.y(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final char jc(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                return c10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedIterable")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> jd(boolean[] zArr, ik.p<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(arrayList, transform.r0(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R je(@yt.k double[] dArr, R r10, @yt.k ik.q<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iTe = Te(dArr); iTe >= 0; iTe--) {
            r10 = operation.A(Integer.valueOf(iTe), Double.valueOf(dArr[iTe]), r10);
        }
        return r10;
    }

    @yt.l
    public static final Boolean jf(@yt.k boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (i10 < 0 || i10 > Ze(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i10]);
    }

    public static final <T> int jg(@yt.k T[] tArr, T t10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.f0.g(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A jh(@yt.k int[] iArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Integer, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (int i12 : iArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Integer.valueOf(i12)));
            } else {
                buffer.append(String.valueOf(i12));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.t0(expression = "indexOfLast { it == element }", imports = {}))
    @kotlin.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int ji(double[] dArr, double d10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (d10 == dArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C jj(@yt.k short[] sArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R jk(float[] fArr, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character jl(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (kotlin.jvm.internal.f0.t(c10, c11) < 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T jm(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t10;
        }
        R rI = selector.i(t10);
        k0 it2 = new qk.m(1, iXe).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            R rI2 = selector.i(t11);
            if (rI.compareTo(rI2) > 0) {
                t10 = t11;
                rI = rI2;
            }
        }
        return t10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float jn(int[] iArr, ik.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Integer.valueOf(iArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Integer.valueOf(iArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final byte jo(@yt.k byte[] bArr, @yt.k Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) > 0) {
                b10 = b11;
            }
        }
        return b10;
    }

    @yt.k
    public static final Pair<List<Short>, List<Short>> jp(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            } else {
                arrayList2.add(Short.valueOf(s10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final long jq(@yt.k long[] jArr, @yt.k ik.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            jLongValue = operation.A(Integer.valueOf(iB), Long.valueOf(jLongValue), Long.valueOf(jArr[iB])).longValue();
        }
        return jLongValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double jr(@yt.k double[] dArr, @yt.k ik.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            return null;
        }
        double dDoubleValue = dArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            dDoubleValue = operation.r0(Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> js(byte[] bArr, R r10, ik.q<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Byte.valueOf(bArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void jt(@yt.k float[] fArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iUe = Ue(fArr); iUe > 0; iUe--) {
            int iP = random.p(iUe + 1);
            float f10 = fArr[iUe];
            fArr[iUe] = fArr[iP];
            fArr[iP] = f10;
        }
    }

    @yt.k
    public static final List<Double> ju(@yt.k double[] dArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.p(kotlin.collections.m.I1(dArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final List<Float> jv(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        Float[] fArrR5 = kotlin.collections.m.r5(fArr);
        kotlin.collections.m.v4(fArrR5);
        return kotlin.collections.m.t(fArrR5);
    }

    @yt.k
    public static final List<Integer> jw(@yt.k int[] iArr, @yt.k Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Integer[] numArrS5 = kotlin.collections.m.s5(iArr);
        kotlin.collections.m.I4(numArrS5, comparator);
        return kotlin.collections.m.t(numArrS5);
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int jx(double[] dArr, ik.l<? super Double, Integer> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (double d10 : dArr) {
            iIntValue += selector.i(Double.valueOf(d10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final <T> List<T> jy(@yt.k T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = tArr.length;
        if (i10 >= length) {
            return iz(tArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    @yt.k
    public static final List<Short> jz(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? tz(sArr) : kotlin.collections.s.k(Short.valueOf(sArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final kotlin.sequences.m<Long> k6(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr.length == 0 ? SequencesKt__SequencesKt.g() : new n(jArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M k7(@yt.k float[] fArr, @yt.k M destination, @yt.k ik.l<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (float f10 : fArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Float.valueOf(f10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final short k8(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr[1];
    }

    @bk.f
    public static final int k9(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr.length;
    }

    @yt.k
    public static final <R> List<Pair<Byte, R>> kA(@yt.k byte[] bArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            byte b10 = bArr[i10];
            arrayList.add(kotlin.d1.a(Byte.valueOf(b10), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Float> ka(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (float f10 : fArr) {
            if (z10) {
                arrayList.add(Float.valueOf(f10));
            } else if (!predicate.i(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
                z10 = true;
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C kb(Object[] objArr, C destination) {
        kotlin.jvm.internal.f0.p(objArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (Object obj : objArr) {
            kotlin.jvm.internal.f0.y(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final double kc(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return dArr[0];
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C kd(byte[] bArr, C destination, ik.p<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final <R> R ke(@yt.k float[] fArr, R r10, @yt.k ik.q<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iUe = Ue(fArr); iUe >= 0; iUe--) {
            r10 = operation.A(Integer.valueOf(iUe), Float.valueOf(fArr[iUe]), r10);
        }
        return r10;
    }

    @yt.l
    public static final Byte kf(@yt.k byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (i10 < 0 || i10 > Re(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i10]);
    }

    public static final int kg(@yt.k short[] sArr, short s10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A kh(@yt.k long[] jArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Long, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (long j10 : jArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Long.valueOf(j10)));
            } else {
                buffer.append(String.valueOf(j10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.t0(expression = "indexOfLast { it == element }", imports = {}))
    @kotlin.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int ki(float[] fArr, float f10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (f10 == fArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C kj(@yt.k boolean[] zArr, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            destination.add(transform.r0(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R kk(int[] iArr, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <T extends Comparable<? super T>> T kl(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (t10.compareTo(t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> short km(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return s10;
        }
        R rI = selector.i(Short.valueOf(s10));
        k0 it2 = new qk.m(1, iYe).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            R rI2 = selector.i(Short.valueOf(s11));
            if (rI.compareTo(rI2) > 0) {
                s10 = s11;
                rI = rI2;
            }
        }
        return s10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float kn(long[] jArr, ik.l<? super Long, Float> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Long.valueOf(jArr[0])).floatValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Long.valueOf(jArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final char ko(@yt.k char[] cArr, @yt.k Comparator<? super Character> comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) > 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @yt.k
    public static final Pair<List<Boolean>, List<Boolean>> kp(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            } else {
                arrayList2.add(Boolean.valueOf(z10));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final <S, T extends S> S kq(@yt.k T[] tArr, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sA = (S) tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sA = operation.A(Integer.valueOf(iB), sA, (Object) tArr[iB]);
        }
        return sA;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float kr(@yt.k float[] fArr, @yt.k ik.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            return null;
        }
        float fFloatValue = fArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            fFloatValue = operation.r0(Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> ks(char[] cArr, R r10, ik.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Character.valueOf(cArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void kt(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        lt(iArr, Random.f38003a);
    }

    @yt.k
    public static final List<Float> ku(@yt.k float[] fArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> kv(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        Integer[] numArrS5 = kotlin.collections.m.s5(iArr);
        kotlin.collections.m.v4(numArrS5);
        return kotlin.collections.m.t(numArrS5);
    }

    @yt.k
    public static final List<Long> kw(@yt.k long[] jArr, @yt.k Comparator<? super Long> comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Long[] lArrT5 = kotlin.collections.m.t5(jArr);
        kotlin.collections.m.I4(lArrT5, comparator);
        return kotlin.collections.m.t(lArrT5);
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int kx(float[] fArr, ik.l<? super Float, Integer> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (float f10 : fArr) {
            iIntValue += selector.i(Float.valueOf(f10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Short> ky(@yt.k short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = sArr.length;
        if (i10 >= length) {
            return jz(sArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Short.valueOf(sArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Boolean> kz(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? uz(zArr) : kotlin.collections.s.k(Boolean.valueOf(zArr[0])) : CollectionsKt__CollectionsKt.E();
    }

    @yt.k
    public static final <T> kotlin.sequences.m<T> l6(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr.length == 0 ? SequencesKt__SequencesKt.g() : new j(tArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M l7(@yt.k int[] iArr, @yt.k M destination, @yt.k ik.l<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (int i10 : iArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Integer.valueOf(i10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final boolean l8(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr[1];
    }

    public static final int l9(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final <R, V> List<V> lA(@yt.k byte[] bArr, @yt.k R[] other, @yt.k ik.p<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Byte.valueOf(bArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> la(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (int i10 : iArr) {
            if (z10) {
                arrayList.add(Integer.valueOf(i10));
            } else if (!predicate.i(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Byte> lb(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (!predicate.i(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            }
        }
        return arrayList;
    }

    public static final double lc(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                return d10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C ld(char[] cArr, C destination, ik.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final <R> R le(@yt.k int[] iArr, R r10, @yt.k ik.q<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iVe = Ve(iArr); iVe >= 0; iVe--) {
            r10 = operation.A(Integer.valueOf(iVe), Integer.valueOf(iArr[iVe]), r10);
        }
        return r10;
    }

    @yt.l
    public static final Character lf(@yt.k char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (i10 < 0 || i10 > Se(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i10]);
    }

    public static final int lg(@yt.k boolean[] zArr, boolean z10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (z10 == zArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <T, A extends Appendable> A lh(@yt.k T[] tArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            kotlin.text.n.b(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int li(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return -1;
    }

    @yt.k
    public static final <T, R> List<R> lj(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            R rI = transform.i(t10);
            if (rI != null) {
                arrayList.add(rI);
            }
        }
        return arrayList;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R lk(long[] jArr, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double ll(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMax = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dMax = Math.max(dMax, dArr[it2.b()]);
        }
        return Double.valueOf(dMax);
    }

    @hk.h(name = "minByOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <R extends Comparable<? super R>> boolean lm(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return z10;
        }
        R rI = selector.i(Boolean.valueOf(z10));
        k0 it2 = new qk.m(1, iZe).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            R rI2 = selector.i(Boolean.valueOf(z11));
            if (rI.compareTo(rI2) > 0) {
                z10 = z11;
                rI = rI2;
            }
        }
        return z10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> Float ln(T[] tArr, ik.l<? super T, Float> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(tArr[0]).floatValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(tArr[it2.b()]).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double lo(@yt.k double[] dArr, @yt.k Comparator<? super Double> comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) > 0) {
                d10 = d11;
            }
        }
        return d10;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final byte lp(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return mp(bArr, Random.f38003a);
    }

    public static final short lq(@yt.k short[] sArr, @yt.k ik.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sShortValue = operation.A(Integer.valueOf(iB), Short.valueOf(sShortValue), Short.valueOf(sArr[iB])).shortValue();
        }
        return sShortValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer lr(@yt.k int[] iArr, @yt.k ik.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            return null;
        }
        int iIntValue = iArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            iIntValue = operation.r0(Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> ls(double[] dArr, R r10, ik.q<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Double.valueOf(dArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void lt(@yt.k int[] iArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iVe = Ve(iArr); iVe > 0; iVe--) {
            int iP = random.p(iVe + 1);
            int i10 = iArr[iVe];
            iArr[iVe] = iArr[iP];
            iArr[iP] = i10;
        }
    }

    @yt.k
    public static final List<Float> lu(@yt.k float[] fArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.q(kotlin.collections.m.J1(fArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final List<Long> lv(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        Long[] lArrT5 = kotlin.collections.m.t5(jArr);
        kotlin.collections.m.v4(lArrT5);
        return kotlin.collections.m.t(lArrT5);
    }

    @yt.k
    public static final <T> List<T> lw(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return kotlin.collections.m.t(Ev(tArr, comparator));
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int lx(int[] iArr, ik.l<? super Integer, Integer> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (int i10 : iArr) {
            iIntValue += selector.i(Integer.valueOf(i10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Boolean> ly(@yt.k boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int length = zArr.length;
        if (i10 >= length) {
            return kz(zArr);
        }
        if (i10 == 1) {
            return kotlin.collections.s.k(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Boolean.valueOf(zArr[i11]));
        }
        return arrayList;
    }

    @yt.k
    public static final long[] lz(@yt.k Long[] lArr) {
        kotlin.jvm.internal.f0.p(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    @yt.k
    public static final kotlin.sequences.m<Short> m6(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr.length == 0 ? SequencesKt__SequencesKt.g() : new l(sArr);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M m7(@yt.k long[] jArr, @yt.k M destination, @yt.k ik.l<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (long j10 : jArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Long.valueOf(j10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final byte m8(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr[2];
    }

    @bk.f
    public static final int m9(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr.length;
    }

    @yt.k
    public static final <R> List<Pair<Character, R>> mA(@yt.k char[] cArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Character.valueOf(cArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final List<Long> ma(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (long j10 : jArr) {
            if (z10) {
                arrayList.add(Long.valueOf(j10));
            } else if (!predicate.i(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Character> mb(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (!predicate.i(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            }
        }
        return arrayList;
    }

    public static final float mc(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return fArr[0];
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C md(double[] dArr, C destination, ik.p<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final <R> R me(@yt.k long[] jArr, R r10, @yt.k ik.q<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iWe = We(jArr); iWe >= 0; iWe--) {
            r10 = operation.A(Integer.valueOf(iWe), Long.valueOf(jArr[iWe]), r10);
        }
        return r10;
    }

    @yt.l
    public static final Double mf(@yt.k double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (i10 < 0 || i10 > Te(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i10]);
    }

    public static final int mg(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Byte.valueOf(bArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A mh(@yt.k short[] sArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Short, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (short s10 : sArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Short.valueOf(s10)));
            } else {
                buffer.append(String.valueOf((int) s10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int mi(@yt.k long[] jArr, long j10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (j10 == jArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C mj(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (T t10 : tArr) {
            R rI = transform.i(t10);
            if (rI != null) {
                destination.add(rI);
            }
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R mk(T[] tArr, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double ml(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        k0 it2 = new qk.m(1, Xe(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, dArr[it2.b()].doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double mm(byte[] bArr, ik.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Byte.valueOf(bArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Byte.valueOf(bArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float mn(short[] sArr, ik.l<? super Short, Float> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Short.valueOf(sArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Short.valueOf(sArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float mo(@yt.k float[] fArr, @yt.k Comparator<? super Float> comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            float f11 = fArr[it2.b()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) > 0) {
                f10 = f11;
            }
        }
        return f10;
    }

    @kotlin.v0(version = "1.3")
    public static final byte mp(@yt.k byte[] bArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (bArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return bArr[random.p(bArr.length)];
    }

    public static final boolean mq(@yt.k boolean[] zArr, @yt.k ik.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            zBooleanValue = operation.A(Integer.valueOf(iB), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[iB])).booleanValue();
        }
        return zBooleanValue;
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long mr(@yt.k long[] jArr, @yt.k ik.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            return null;
        }
        long jLongValue = jArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            jLongValue = operation.r0(Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> ms(float[] fArr, R r10, ik.q<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Float.valueOf(fArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void mt(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        nt(jArr, Random.f38003a);
    }

    @yt.k
    public static final List<Integer> mu(@yt.k int[] iArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> List<T> mv(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return kotlin.collections.m.t(uv(tArr));
    }

    @yt.k
    public static final List<Short> mw(@yt.k short[] sArr, @yt.k Comparator<? super Short> comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Short[] shArrU5 = kotlin.collections.m.u5(sArr);
        kotlin.collections.m.I4(shArrU5, comparator);
        return kotlin.collections.m.t(shArrU5);
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int mx(long[] jArr, ik.l<? super Long, Integer> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (long j10 : jArr) {
            iIntValue += selector.i(Long.valueOf(j10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Byte> my(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iRe = Re(bArr); -1 < iRe; iRe--) {
            if (!predicate.i(Byte.valueOf(bArr[iRe])).booleanValue()) {
                return G9(bArr, iRe + 1);
            }
        }
        return cz(bArr);
    }

    @yt.k
    public static final List<Byte> mz(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    @yt.k
    public static final kotlin.sequences.m<Boolean> n6(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr.length == 0 ? SequencesKt__SequencesKt.g() : new q(zArr);
    }

    @yt.k
    public static final <T, K, V, M extends Map<? super K, ? super V>> M n7(@yt.k T[] tArr, @yt.k M destination, @yt.k ik.l<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (T t10 : tArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(t10);
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final char n8(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr[2];
    }

    public static final int n9(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int i10 = 0;
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final <R, V> List<V> nA(@yt.k char[] cArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Character.valueOf(cArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @yt.k
    public static final <T> List<T> na(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (T t10 : tArr) {
            if (z10) {
                arrayList.add(t10);
            } else if (!predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Double> nb(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (!predicate.i(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            }
        }
        return arrayList;
    }

    public static final float nc(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                return f10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C nd(float[] fArr, C destination, ik.p<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ne(@yt.k T[] tArr, R r10, @yt.k ik.q<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iXe = Xe(tArr); iXe >= 0; iXe--) {
            r10 = operation.A(Integer.valueOf(iXe), tArr[iXe], r10);
        }
        return r10;
    }

    @yt.l
    public static final Float nf(@yt.k float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (i10 < 0 || i10 > Ue(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i10]);
    }

    public static final int ng(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Character.valueOf(cArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <A extends Appendable> A nh(@yt.k boolean[] zArr, @yt.k A buffer, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Boolean, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (boolean z10 : zArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.i(Boolean.valueOf(z10)));
            } else {
                buffer.append(String.valueOf(z10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> int ni(@yt.k T[] tArr, T t10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (t10 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i11 = length2 - 1;
                    if (kotlin.jvm.internal.f0.g(t10, tArr[length2])) {
                        return length2;
                    }
                    if (i11 < 0) {
                        break;
                    }
                    length2 = i11;
                }
            }
        }
        return -1;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C nj(@yt.k byte[] bArr, @yt.k C destination, @yt.k ik.l<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (byte b10 : bArr) {
            destination.add(transform.i(Byte.valueOf(b10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R nk(short[] sArr, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float nl(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMax = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fMax = Math.max(fMax, fArr[it2.b()]);
        }
        return Float.valueOf(fMax);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double nm(char[] cArr, ik.l<? super Character, Double> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Character.valueOf(cArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Character.valueOf(cArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Float nn(boolean[] zArr, ik.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.i(Boolean.valueOf(zArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Boolean.valueOf(zArr[it2.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final int no(@yt.k int[] iArr, @yt.k Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) > 0) {
                i10 = i11;
            }
        }
        return i10;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final char np(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return op(cArr, Random.f38003a);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean nq(@yt.k boolean[] zArr, @yt.k ik.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            zBooleanValue = operation.A(Integer.valueOf(iB), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[iB])).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S nr(@yt.k T[] tArr, @yt.k ik.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            return null;
        }
        S sR0 = (S) tArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sR0 = operation.r0((Object) tArr[i10], sR0);
        }
        return sR0;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> ns(int[] iArr, R r10, ik.q<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Integer.valueOf(iArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void nt(@yt.k long[] jArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iWe = We(jArr); iWe > 0; iWe--) {
            int iP = random.p(iWe + 1);
            long j10 = jArr[iWe];
            jArr[iWe] = jArr[iP];
            jArr[iP] = j10;
        }
    }

    @yt.k
    public static final List<Integer> nu(@yt.k int[] iArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.r(kotlin.collections.m.K1(iArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final List<Short> nv(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        Short[] shArrU5 = kotlin.collections.m.u5(sArr);
        kotlin.collections.m.v4(shArrU5);
        return kotlin.collections.m.t(shArrU5);
    }

    @yt.k
    public static final List<Boolean> nw(@yt.k boolean[] zArr, @yt.k Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Boolean[] boolArrN5 = kotlin.collections.m.n5(zArr);
        kotlin.collections.m.I4(boolArrN5, comparator);
        return kotlin.collections.m.t(boolArrN5);
    }

    @hk.h(name = "sumOfInt")
    public static final int nx(@yt.k Integer[] numArr) {
        kotlin.jvm.internal.f0.p(numArr, "<this>");
        int iIntValue = 0;
        for (Integer num : numArr) {
            iIntValue += num.intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Character> ny(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iSe = Se(cArr); -1 < iSe; iSe--) {
            if (!predicate.i(Character.valueOf(cArr[iSe])).booleanValue()) {
                return H9(cArr, iSe + 1);
            }
        }
        return dz(cArr);
    }

    @yt.k
    public static final List<Character> nz(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V> Map<K, V> o6(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(bArr.length), 16));
        for (byte b10 : bArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Byte.valueOf(b10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M o7(@yt.k short[] sArr, @yt.k M destination, @yt.k ik.l<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (short s10 : sArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Short.valueOf(s10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final double o8(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr[2];
    }

    @yt.k
    public static final List<Byte> o9(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(vz(bArr));
    }

    @yt.k
    public static final List<Pair<Character, Character>> oA(@yt.k char[] cArr, @yt.k char[] other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Character.valueOf(cArr[i10]), Character.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Short> oa(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (short s10 : sArr) {
            if (z10) {
                arrayList.add(Short.valueOf(s10));
            } else if (!predicate.i(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Float> ob(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (!predicate.i(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            }
        }
        return arrayList;
    }

    public static final int oc(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[0];
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C od(int[] iArr, C destination, ik.p<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final <R> R oe(@yt.k short[] sArr, R r10, @yt.k ik.q<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iYe = Ye(sArr); iYe >= 0; iYe--) {
            r10 = operation.A(Integer.valueOf(iYe), Short.valueOf(sArr[iYe]), r10);
        }
        return r10;
    }

    @yt.l
    public static final Integer of(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (i10 < 0 || i10 > Ve(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static final int og(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Double.valueOf(dArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    public static final int oi(@yt.k short[] sArr, short s10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (s10 == sArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C oj(@yt.k char[] cArr, @yt.k C destination, @yt.k ik.l<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (char c10 : cArr) {
            destination.add(transform.i(Character.valueOf(c10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R ok(boolean[] zArr, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float ol(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        k0 it2 = new qk.m(1, Xe(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, fArr[it2.b()].floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double om(double[] dArr, ik.l<? super Double, Double> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Double.valueOf(dArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Double.valueOf(dArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R on(byte[] bArr, Comparator<? super R> comparator, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final long oo(@yt.k long[] jArr, @yt.k Comparator<? super Long> comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) > 0) {
                j10 = j11;
            }
        }
        return j10;
    }

    @kotlin.v0(version = "1.3")
    public static final char op(@yt.k char[] cArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (cArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return cArr[random.p(cArr.length)];
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte oq(@yt.k byte[] bArr, @yt.k ik.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            bByteValue = operation.A(Integer.valueOf(iB), Byte.valueOf(bByteValue), Byte.valueOf(bArr[iB])).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short or(@yt.k short[] sArr, @yt.k ik.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            return null;
        }
        short sShortValue = sArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            sShortValue = operation.r0(Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> os(long[] jArr, R r10, ik.q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Long.valueOf(jArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final <T> void ot(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        pt(tArr, Random.f38003a);
    }

    @yt.k
    public static final List<Long> ou(@yt.k long[] jArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final byte[] ov(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.h4(bArrCopyOf);
        return bArrCopyOf;
    }

    @yt.k
    public static final Set<Byte> ow(@yt.k byte[] bArr, @yt.k Iterable<Byte> other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Byte> setVz = vz(bArr);
        x.E0(setVz, other);
        return setVz;
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> int ox(T[] tArr, ik.l<? super T, Integer> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (T t10 : tArr) {
            iIntValue += selector.i(t10).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Double> oy(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iTe = Te(dArr); -1 < iTe; iTe--) {
            if (!predicate.i(Double.valueOf(dArr[iTe])).booleanValue()) {
                return I9(dArr, iTe + 1);
            }
        }
        return ez(dArr);
    }

    @yt.k
    public static final List<Double> oz(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V> Map<K, V> p6(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(cArr.length), 16));
        for (char c10 : cArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Character.valueOf(c10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M p7(@yt.k boolean[] zArr, @yt.k M destination, @yt.k ik.l<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (boolean z10 : zArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Boolean.valueOf(z10));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @bk.f
    public static final float p8(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr[2];
    }

    @yt.k
    public static final List<Character> p9(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(wz(cArr));
    }

    @yt.k
    public static final <V> List<V> pA(@yt.k char[] cArr, @yt.k char[] other, @yt.k ik.p<? super Character, ? super Character, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Character.valueOf(cArr[i10]), Character.valueOf(other[i10])));
        }
        return arrayList;
    }

    @yt.k
    public static final List<Boolean> pa(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (boolean z11 : zArr) {
            if (z10) {
                arrayList.add(Boolean.valueOf(z11));
            } else if (!predicate.i(Boolean.valueOf(z11)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z11));
                z10 = true;
            }
        }
        return arrayList;
    }

    @yt.k
    public static final List<Integer> pb(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (!predicate.i(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    public static final int pc(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (predicate.i(Integer.valueOf(i10)).booleanValue()) {
                return i10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C pd(long[] jArr, C destination, ik.p<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final <R> R pe(@yt.k boolean[] zArr, R r10, @yt.k ik.q<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        for (int iZe = Ze(zArr); iZe >= 0; iZe--) {
            r10 = operation.A(Integer.valueOf(iZe), Boolean.valueOf(zArr[iZe]), r10);
        }
        return r10;
    }

    @yt.l
    public static final Long pf(@yt.k long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (i10 < 0 || i10 > We(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i10]);
    }

    public static final int pg(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Float.valueOf(fArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    public static final int pi(@yt.k boolean[] zArr, boolean z10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (z10 == zArr[length]) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C pj(@yt.k double[] dArr, @yt.k C destination, @yt.k ik.l<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (double d10 : dArr) {
            destination.add(transform.i(Double.valueOf(d10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R pk(byte[] bArr, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer pl(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (i10 < i11) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double pm(float[] fArr, ik.l<? super Float, Double> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Float.valueOf(fArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Float.valueOf(fArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R pn(char[] cArr, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final <T> T po(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            T t11 = tArr[it2.b()];
            if (comparator.compare(t10, t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final double pp(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return qp(dArr, Random.f38003a);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character pq(@yt.k char[] cArr, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            cCharValue = operation.A(Integer.valueOf(iB), Character.valueOf(cCharValue), Character.valueOf(cArr[iB])).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @yt.k
    public static final <T> T[] pr(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        for (T t10 : tArr) {
            if (t10 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> ps(@yt.k T[] tArr, R r10, @yt.k ik.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, tArr[i10]);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final <T> void pt(@yt.k T[] tArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iXe = Xe(tArr); iXe > 0; iXe--) {
            int iP = random.p(iXe + 1);
            T t10 = tArr[iXe];
            tArr[iXe] = tArr[iP];
            tArr[iP] = t10;
        }
    }

    @yt.k
    public static final List<Long> pu(@yt.k long[] jArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.s(kotlin.collections.m.L1(jArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final char[] pv(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.f0.o(cArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.j4(cArrCopyOf);
        return cArrCopyOf;
    }

    @yt.k
    public static final Set<Character> pw(@yt.k char[] cArr, @yt.k Iterable<Character> other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Character> setWz = wz(cArr);
        x.E0(setWz, other);
        return setWz;
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int px(short[] sArr, ik.l<? super Short, Integer> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (short s10 : sArr) {
            iIntValue += selector.i(Short.valueOf(s10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Float> py(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iUe = Ue(fArr); -1 < iUe; iUe--) {
            if (!predicate.i(Float.valueOf(fArr[iUe])).booleanValue()) {
                return J9(fArr, iUe + 1);
            }
        }
        return fz(fArr);
    }

    @yt.k
    public static final List<Float> pz(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V> Map<K, V> q6(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(dArr.length), 16));
        for (double d10 : dArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Double.valueOf(d10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Byte, V> q7(byte[] bArr, ik.l<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(bArr.length), 16));
        for (byte b10 : bArr) {
            linkedHashMap.put(Byte.valueOf(b10), valueSelector.i(Byte.valueOf(b10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final int q8(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr[2];
    }

    @yt.k
    public static final List<Double> q9(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(xz(dArr));
    }

    @yt.k
    public static final <R> List<Pair<Character, R>> qA(@yt.k char[] cArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            char c10 = cArr[i10];
            arrayList.add(kotlin.d1.a(Character.valueOf(c10), other[i10]));
        }
        return arrayList;
    }

    @bk.f
    public static final byte qa(byte[] bArr, int i10, ik.l<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Re(bArr)) ? defaultValue.i(Integer.valueOf(i10)).byteValue() : bArr[i10];
    }

    @yt.k
    public static final List<Long> qb(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (!predicate.i(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        return arrayList;
    }

    public static final long qc(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[0];
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C qd(T[] tArr, C destination, ik.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final void qe(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, z1> action) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (byte b10 : bArr) {
            action.i(Byte.valueOf(b10));
        }
    }

    @yt.l
    public static final <T> T qf(@yt.k T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (i10 < 0 || i10 > Xe(tArr)) {
            return null;
        }
        return tArr[i10];
    }

    public static final int qg(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Integer.valueOf(iArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Boolean qi(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C qj(@yt.k float[] fArr, @yt.k C destination, @yt.k ik.l<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (float f10 : fArr) {
            destination.add(transform.i(Float.valueOf(f10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R qk(char[] cArr, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long ql(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (j10 < j11) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double qm(int[] iArr, ik.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Integer.valueOf(iArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Integer.valueOf(iArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R qn(double[] dArr, Comparator<? super R> comparator, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final short qo(@yt.k short[] sArr, @yt.k Comparator<? super Short> comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) > 0) {
                s10 = s11;
            }
        }
        return s10;
    }

    @kotlin.v0(version = "1.3")
    public static final double qp(@yt.k double[] dArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (dArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return dArr[random.p(dArr.length)];
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double qq(@yt.k double[] dArr, @yt.k ik.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            dDoubleValue = operation.A(Integer.valueOf(iB), Double.valueOf(dDoubleValue), Double.valueOf(dArr[iB])).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final void qr(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iRe = Re(bArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            byte b10 = bArr[iB];
            bArr[iB] = bArr[iRe];
            bArr[iRe] = b10;
            iRe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> qs(short[] sArr, R r10, ik.q<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Short.valueOf(sArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void qt(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        rt(sArr, Random.f38003a);
    }

    @yt.k
    public static final <T> List<T> qu(@yt.k T[] tArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(tArr[it2.next().intValue()]);
        }
        return arrayList;
    }

    @yt.k
    public static final double[] qv(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.f0.o(dArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.l4(dArrCopyOf);
        return dArrCopyOf;
    }

    @yt.k
    public static final Set<Double> qw(@yt.k double[] dArr, @yt.k Iterable<Double> other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Double> setXz = xz(dArr);
        x.E0(setXz, other);
        return setXz;
    }

    @hk.h(name = "sumOfInt")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int qx(boolean[] zArr, ik.l<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        int iIntValue = 0;
        for (boolean z10 : zArr) {
            iIntValue += selector.i(Boolean.valueOf(z10)).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final List<Integer> qy(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iVe = Ve(iArr); -1 < iVe; iVe--) {
            if (!predicate.i(Integer.valueOf(iArr[iVe])).booleanValue()) {
                return K9(iArr, iVe + 1);
            }
        }
        return gz(iArr);
    }

    @yt.k
    public static final List<Integer> qz(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V> Map<K, V> r6(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(fArr.length), 16));
        for (float f10 : fArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Float.valueOf(f10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Character, V> r7(char[] cArr, ik.l<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(qk.v.B(cArr.length, 128)), 16));
        for (char c10 : cArr) {
            linkedHashMap.put(Character.valueOf(c10), valueSelector.i(Character.valueOf(c10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final long r8(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr[2];
    }

    @yt.k
    public static final List<Float> r9(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(yz(fArr));
    }

    @yt.k
    public static final <R, V> List<V> rA(@yt.k char[] cArr, @yt.k R[] other, @yt.k ik.p<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Character.valueOf(cArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @bk.f
    public static final char ra(char[] cArr, int i10, ik.l<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Se(cArr)) ? defaultValue.i(Integer.valueOf(i10)).charValue() : cArr[i10];
    }

    @yt.k
    public static final <T> List<T> rb(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (!predicate.i(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final long rc(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (long j10 : jArr) {
            if (predicate.i(Long.valueOf(j10)).booleanValue()) {
                return j10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C rd(short[] sArr, C destination, ik.p<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final void re(@yt.k char[] cArr, @yt.k ik.l<? super Character, z1> action) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (char c10 : cArr) {
            action.i(Character.valueOf(c10));
        }
    }

    @yt.l
    public static final Short rf(@yt.k short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (i10 < 0 || i10 > Ye(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i10]);
    }

    public static final int rg(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Long.valueOf(jArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Boolean ri(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            boolean z10 = zArr[length];
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return Boolean.valueOf(z10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C rj(@yt.k int[] iArr, @yt.k C destination, @yt.k ik.l<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (int i10 : iArr) {
            destination.add(transform.i(Integer.valueOf(i10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R rk(double[] dArr, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short rl(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            short s11 = sArr[it2.b()];
            if (s10 < s11) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double rm(long[] jArr, ik.l<? super Long, Double> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Long.valueOf(jArr[0])).doubleValue();
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Long.valueOf(jArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R rn(float[] fArr, Comparator<? super R> comparator, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "minWithOrThrow")
    @kotlin.v0(version = "1.7")
    public static final boolean ro(@yt.k boolean[] zArr, @yt.k Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) > 0) {
                z10 = z11;
            }
        }
        return z10;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final float rp(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return sp(fArr, Random.f38003a);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Float rq(@yt.k float[] fArr, @yt.k ik.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            fFloatValue = operation.A(Integer.valueOf(iB), Float.valueOf(fFloatValue), Float.valueOf(fArr[iB])).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.v0(version = "1.4")
    public static final void rr(@yt.k byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, bArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            bArr[i10] = bArr[i13];
            bArr[i13] = b10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> List<R> rs(boolean[] zArr, R r10, ik.q<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Boolean.valueOf(zArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void rt(@yt.k short[] sArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iYe = Ye(sArr); iYe > 0; iYe--) {
            int iP = random.p(iYe + 1);
            short s10 = sArr[iYe];
            sArr[iYe] = sArr[iP];
            sArr[iP] = s10;
        }
    }

    @yt.k
    public static final <T> List<T> ru(@yt.k T[] tArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.t(kotlin.collections.m.M1(tArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final float[] rv(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.f0.o(fArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.n4(fArrCopyOf);
        return fArrCopyOf;
    }

    @yt.k
    public static final Set<Float> rw(@yt.k float[] fArr, @yt.k Iterable<Float> other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Float> setYz = yz(fArr);
        x.E0(setYz, other);
        return setYz;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long rx(byte[] bArr, ik.l<? super Byte, Long> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (byte b10 : bArr) {
            jLongValue += selector.i(Byte.valueOf(b10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Long> ry(@yt.k long[] jArr, @yt.k ik.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iWe = We(jArr); -1 < iWe; iWe--) {
            if (!predicate.i(Long.valueOf(jArr[iWe])).booleanValue()) {
                return L9(jArr, iWe + 1);
            }
        }
        return hz(jArr);
    }

    @yt.k
    public static final List<Long> rz(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V> Map<K, V> s6(@yt.k int[] iArr, @yt.k ik.l<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(iArr.length), 16));
        for (int i10 : iArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Integer.valueOf(i10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Double, V> s7(double[] dArr, ik.l<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(dArr.length), 16));
        for (double d10 : dArr) {
            linkedHashMap.put(Double.valueOf(d10), valueSelector.i(Double.valueOf(d10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final <T> T s8(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr[2];
    }

    @yt.k
    public static final List<Integer> s9(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(zz(iArr));
    }

    @yt.k
    public static final <R> List<Pair<Double, R>> sA(@yt.k double[] dArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Double.valueOf(dArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final double sa(double[] dArr, int i10, ik.l<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Te(dArr)) ? defaultValue.i(Integer.valueOf(i10)).doubleValue() : dArr[i10];
    }

    @yt.k
    public static final List<Short> sb(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (!predicate.i(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            }
        }
        return arrayList;
    }

    public static final <T> T sc(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C sd(boolean[] zArr, C destination, ik.p<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.n0(destination, transform.r0(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final void se(@yt.k double[] dArr, @yt.k ik.l<? super Double, z1> action) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (double d10 : dArr) {
            action.i(Double.valueOf(d10));
        }
    }

    @yt.k
    public static final <K> Map<K, List<Byte>> sf(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b10 : bArr) {
            K kI = keySelector.i(Byte.valueOf(b10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b10));
        }
        return linkedHashMap;
    }

    public static final <T> int sg(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(tArr[i10]).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Byte si(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C sj(@yt.k long[] jArr, @yt.k C destination, @yt.k ik.l<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (long j10 : jArr) {
            destination.add(transform.i(Long.valueOf(j10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R sk(float[] fArr, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rI = selector.i(Float.valueOf(fArr[0]));
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Float.valueOf(fArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final byte sl(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            if (b10 < b11) {
                b10 = b11;
            }
        }
        return b10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> double sm(T[] tArr, ik.l<? super T, Double> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(tArr[0]).doubleValue();
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(tArr[it2.b()]).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R sn(int[] iArr, Comparator<? super R> comparator, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean so(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    @kotlin.v0(version = "1.3")
    public static final float sp(@yt.k float[] fArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return fArr[random.p(fArr.length)];
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Integer sq(@yt.k int[] iArr, @yt.k ik.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            iIntValue = operation.A(Integer.valueOf(iB), Integer.valueOf(iIntValue), Integer.valueOf(iArr[iB])).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final void sr(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iSe = Se(cArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            char c10 = cArr[iB];
            cArr[iB] = cArr[iSe];
            cArr[iSe] = c10;
            iSe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Byte> ss(byte[] bArr, ik.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            bByteValue = operation.r0(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i10])).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void st(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        tt(zArr, Random.f38003a);
    }

    @yt.k
    public static final List<Short> su(@yt.k short[] sArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final int[] sv(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.f0.o(iArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.p4(iArrCopyOf);
        return iArrCopyOf;
    }

    @yt.k
    public static final Set<Integer> sw(@yt.k int[] iArr, @yt.k Iterable<Integer> other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Integer> setZz = zz(iArr);
        x.E0(setZz, other);
        return setZz;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long sx(char[] cArr, ik.l<? super Character, Long> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (char c10 : cArr) {
            jLongValue += selector.i(Character.valueOf(c10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final <T> List<T> sy(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iXe = Xe(tArr); -1 < iXe; iXe--) {
            if (!predicate.i(tArr[iXe]).booleanValue()) {
                return M9(tArr, iXe + 1);
            }
        }
        return iz(tArr);
    }

    @yt.k
    public static final <T> List<T> sz(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.s(tArr));
    }

    @yt.k
    public static final <K, V> Map<K, V> t6(@yt.k long[] jArr, @yt.k ik.l<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(jArr.length), 16));
        for (long j10 : jArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Long.valueOf(j10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Float, V> t7(float[] fArr, ik.l<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(fArr.length), 16));
        for (float f10 : fArr) {
            linkedHashMap.put(Float.valueOf(f10), valueSelector.i(Float.valueOf(f10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final short t8(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr[2];
    }

    @yt.k
    public static final List<Long> t9(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(Az(jArr));
    }

    @yt.k
    public static final <R, V> List<V> tA(@yt.k double[] dArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Double.valueOf(dArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final float ta(float[] fArr, int i10, ik.l<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ue(fArr)) ? defaultValue.i(Integer.valueOf(i10)).floatValue() : fArr[i10];
    }

    @yt.k
    public static final List<Boolean> tb(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (!predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            }
        }
        return arrayList;
    }

    public static final <T> T tc(@yt.k T[] tArr, @yt.k ik.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (T t10 : tArr) {
            if (predicate.i(t10).booleanValue()) {
                return t10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapIndexedSequence")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> List<R> td(T[] tArr, ik.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.o0(arrayList, transform.r0(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final void te(@yt.k float[] fArr, @yt.k ik.l<? super Float, z1> action) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (float f10 : fArr) {
            action.i(Float.valueOf(f10));
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> tf(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends K> keySelector, @yt.k ik.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b10 : bArr) {
            K kI = keySelector.i(Byte.valueOf(b10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Byte.valueOf(b10)));
        }
        return linkedHashMap;
    }

    public static final int tg(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Short.valueOf(sArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Byte ti(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            byte b10 = bArr[length];
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return Byte.valueOf(b10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @yt.k
    public static final <T, R, C extends Collection<? super R>> C tj(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (T t10 : tArr) {
            destination.add(transform.i(t10));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R tk(int[] iArr, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rI = selector.i(Integer.valueOf(iArr[0]));
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Integer.valueOf(iArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final char tl(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            if (kotlin.jvm.internal.f0.t(c10, c11) < 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double tm(short[] sArr, ik.l<? super Short, Double> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Short.valueOf(sArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Short.valueOf(sArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R tn(long[] jArr, Comparator<? super R> comparator, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean to(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final int tp(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return up(iArr, Random.f38003a);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Long tq(@yt.k long[] jArr, @yt.k ik.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            jLongValue = operation.A(Integer.valueOf(iB), Long.valueOf(jLongValue), Long.valueOf(jArr[iB])).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @kotlin.v0(version = "1.4")
    public static final void tr(@yt.k char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, cArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            char c10 = cArr[i10];
            cArr[i10] = cArr[i13];
            cArr[i13] = c10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Character> ts(char[] cArr, ik.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        char cCharValue = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(cCharValue));
        int length = cArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            cCharValue = operation.r0(Character.valueOf(cCharValue), Character.valueOf(cArr[i10])).charValue();
            arrayList.add(Character.valueOf(cCharValue));
        }
        return arrayList;
    }

    @kotlin.v0(version = "1.4")
    public static final void tt(@yt.k boolean[] zArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        for (int iZe = Ze(zArr); iZe > 0; iZe--) {
            int iP = random.p(iZe + 1);
            boolean z10 = zArr[iZe];
            zArr[iZe] = zArr[iP];
            zArr[iP] = z10;
        }
    }

    @yt.k
    public static final List<Short> tu(@yt.k short[] sArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.u(kotlin.collections.m.N1(sArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final long[] tv(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.f0.o(jArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.r4(jArrCopyOf);
        return jArrCopyOf;
    }

    @yt.k
    public static final Set<Long> tw(@yt.k long[] jArr, @yt.k Iterable<Long> other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Long> setAz = Az(jArr);
        x.E0(setAz, other);
        return setAz;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long tx(double[] dArr, ik.l<? super Double, Long> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (double d10 : dArr) {
            jLongValue += selector.i(Double.valueOf(d10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Short> ty(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iYe = Ye(sArr); -1 < iYe; iYe--) {
            if (!predicate.i(Short.valueOf(sArr[iYe])).booleanValue()) {
                return N9(sArr, iYe + 1);
            }
        }
        return jz(sArr);
    }

    @yt.k
    public static final List<Short> tz(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T, K, V> Map<K, V> u6(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(tArr.length), 16));
        for (a0.b bVar : tArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(bVar);
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Integer, V> u7(int[] iArr, ik.l<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(iArr.length), 16));
        for (int i10 : iArr) {
            linkedHashMap.put(Integer.valueOf(i10), valueSelector.i(Integer.valueOf(i10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final boolean u8(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr[2];
    }

    @yt.k
    public static final <T> List<T> u9(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(Bz(tArr));
    }

    @yt.k
    public static final List<Pair<Double, Double>> uA(@yt.k double[] dArr, @yt.k double[] other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Double.valueOf(dArr[i10]), Double.valueOf(other[i10])));
        }
        return arrayList;
    }

    @bk.f
    public static final int ua(int[] iArr, int i10, ik.l<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ve(iArr)) ? defaultValue.i(Integer.valueOf(i10)).intValue() : iArr[i10];
    }

    @yt.k
    public static final <T> List<T> ub(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (List) vb(tArr, new ArrayList());
    }

    public static final short uc(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[0];
    }

    @hk.h(name = "flatMapIndexedSequenceTo")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C ud(T[] tArr, C destination, ik.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            x.o0(destination, transform.r0(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return destination;
    }

    public static final void ue(@yt.k int[] iArr, @yt.k ik.l<? super Integer, z1> action) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (int i10 : iArr) {
            action.i(Integer.valueOf(i10));
        }
    }

    @yt.k
    public static final <K> Map<K, List<Character>> uf(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c10 : cArr) {
            K kI = keySelector.i(Character.valueOf(c10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c10));
        }
        return linkedHashMap;
    }

    public static final int ug(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Boolean.valueOf(zArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Character ui(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C uj(@yt.k short[] sArr, @yt.k C destination, @yt.k ik.l<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (short s10 : sArr) {
            destination.add(transform.i(Short.valueOf(s10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R uk(long[] jArr, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rI = selector.i(Long.valueOf(jArr[0]));
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Long.valueOf(jArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double ul(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dMax = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dMax = Math.max(dMax, dArr[it2.b()]);
        }
        return dMax;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final double um(boolean[] zArr, ik.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Boolean.valueOf(zArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Boolean.valueOf(zArr[it2.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R> R un(T[] tArr, Comparator<? super R> comparator, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean uo(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    @kotlin.v0(version = "1.3")
    public static final int up(@yt.k int[] iArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[random.p(iArr.length)];
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <S, T extends S> S uq(@yt.k T[] tArr, @yt.k ik.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S sA = (S) tArr[0];
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sA = operation.A(Integer.valueOf(iB), sA, (Object) tArr[iB]);
        }
        return sA;
    }

    public static final void ur(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iTe = Te(dArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            double d10 = dArr[iB];
            dArr[iB] = dArr[iTe];
            dArr[iTe] = d10;
            iTe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Double> us(double[] dArr, ik.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            dDoubleValue = operation.r0(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i10])).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static final byte ut(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final List<Boolean> uu(@yt.k boolean[] zArr, @yt.k Iterable<Integer> indices) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        int iY = t.Y(indices, 10);
        if (iY == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> T[] uv(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.f0.o(objArrCopyOf, "copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        kotlin.collections.m.v4(tArr2);
        return tArr2;
    }

    @yt.k
    public static final <T> Set<T> uw(@yt.k T[] tArr, @yt.k Iterable<? extends T> other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<T> setBz = Bz(tArr);
        x.E0(setBz, other);
        return setBz;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long ux(float[] fArr, ik.l<? super Float, Long> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (float f10 : fArr) {
            jLongValue += selector.i(Float.valueOf(f10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Boolean> uy(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int iZe = Ze(zArr); -1 < iZe; iZe--) {
            if (!predicate.i(Boolean.valueOf(zArr[iZe])).booleanValue()) {
                return O9(zArr, iZe + 1);
            }
        }
        return kz(zArr);
    }

    @yt.k
    public static final List<Boolean> uz(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    public static final boolean v5(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (!predicate.i(Byte.valueOf(b10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K, V> Map<K, V> v6(@yt.k short[] sArr, @yt.k ik.l<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(sArr.length), 16));
        for (short s10 : sArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Short.valueOf(s10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Long, V> v7(long[] jArr, ik.l<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(jArr.length), 16));
        for (long j10 : jArr) {
            linkedHashMap.put(Long.valueOf(j10), valueSelector.i(Long.valueOf(j10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final byte v8(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr[3];
    }

    @yt.k
    public static final List<Short> v9(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(Cz(sArr));
    }

    @yt.k
    public static final <V> List<V> vA(@yt.k double[] dArr, @yt.k double[] other, @yt.k ik.p<? super Double, ? super Double, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Double.valueOf(dArr[i10]), Double.valueOf(other[i10])));
        }
        return arrayList;
    }

    @bk.f
    public static final long va(long[] jArr, int i10, ik.l<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > We(jArr)) ? defaultValue.i(Integer.valueOf(i10)).longValue() : jArr[i10];
    }

    @yt.k
    public static final <C extends Collection<? super T>, T> C vb(@yt.k T[] tArr, @yt.k C destination) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static final short vc(@yt.k short[] sArr, @yt.k ik.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (short s10 : sArr) {
            if (predicate.i(Short.valueOf(s10)).booleanValue()) {
                return s10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @hk.h(name = "flatMapSequence")
    @kotlin.m0
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R> List<R> vd(@yt.k T[] tArr, @yt.k ik.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            x.o0(arrayList, transform.i(t10));
        }
        return arrayList;
    }

    public static final void ve(@yt.k long[] jArr, @yt.k ik.l<? super Long, z1> action) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (long j10 : jArr) {
            action.i(Long.valueOf(j10));
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> vf(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c10 : cArr) {
            K kI = keySelector.i(Character.valueOf(c10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Character.valueOf(c10)));
        }
        return linkedHashMap;
    }

    public static final int vg(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Character vi(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            char c10 = cArr[length];
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                return Character.valueOf(c10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C vj(@yt.k boolean[] zArr, @yt.k C destination, @yt.k ik.l<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (boolean z10 : zArr) {
            destination.add(transform.i(Boolean.valueOf(z10)));
        }
        return destination;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T, R extends Comparable<? super R>> R vk(T[] tArr, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rI = selector.i(tArr[0]);
        k0 it2 = new qk.m(1, Xe(tArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(tArr[it2.b()]);
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final double vl(@yt.k Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        k0 it2 = new qk.m(1, Xe(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, dArr[it2.b()].doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float vm(byte[] bArr, ik.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Byte.valueOf(bArr[0])).floatValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Byte.valueOf(bArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R vn(short[] sArr, Comparator<? super R> comparator, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean vo(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final long vp(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return wp(jArr, Random.f38003a);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Short vq(@yt.k short[] sArr, @yt.k ik.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            sShortValue = operation.A(Integer.valueOf(iB), Short.valueOf(sShortValue), Short.valueOf(sArr[iB])).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @kotlin.v0(version = "1.4")
    public static final void vr(@yt.k double[] dArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, dArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            double d10 = dArr[i10];
            dArr[i10] = dArr[i13];
            dArr[i13] = d10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Float> vs(float[] fArr, ik.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            fFloatValue = operation.r0(Float.valueOf(fFloatValue), Float.valueOf(fArr[i10])).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static final byte vt(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Byte bValueOf = null;
        boolean z10 = false;
        for (byte b10 : bArr) {
            if (predicate.i(Byte.valueOf(b10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                bValueOf = Byte.valueOf(b10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(bValueOf, "null cannot be cast to non-null type kotlin.Byte");
        return bValueOf.byteValue();
    }

    @yt.k
    public static final List<Boolean> vu(@yt.k boolean[] zArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.E() : kotlin.collections.m.v(kotlin.collections.m.O1(zArr, indices.a().intValue(), indices.e().intValue() + 1));
    }

    @yt.k
    public static final short[] vv(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.f0.o(sArrCopyOf, "copyOf(this, size)");
        kotlin.collections.m.x4(sArrCopyOf);
        return sArrCopyOf;
    }

    @yt.k
    public static final Set<Short> vw(@yt.k short[] sArr, @yt.k Iterable<Short> other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Short> setCz = Cz(sArr);
        x.E0(setCz, other);
        return setCz;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long vx(int[] iArr, ik.l<? super Integer, Long> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (int i10 : iArr) {
            jLongValue += selector.i(Integer.valueOf(i10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Byte> vy(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (!predicate.i(Byte.valueOf(b10)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Byte> vz(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return (Set) Hy(bArr, new LinkedHashSet(r0.j(bArr.length)));
    }

    public static final boolean w5(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (!predicate.i(Character.valueOf(c10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K, V> Map<K, V> w6(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(zArr.length), 16));
        for (boolean z10 : zArr) {
            Pair<? extends K, ? extends V> pairI = transform.i(Boolean.valueOf(z10));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <K, V> Map<K, V> w7(@yt.k K[] kArr, @yt.k ik.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(kArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(kArr.length), 16));
        for (K k10 : kArr) {
            linkedHashMap.put(k10, valueSelector.i(k10));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final char w8(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr[3];
    }

    @yt.k
    public static final List<Boolean> w9(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return CollectionsKt___CollectionsKt.Q5(Dz(zArr));
    }

    @yt.k
    public static final <R> List<Pair<Double, R>> wA(@yt.k double[] dArr, @yt.k R[] other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            double d10 = dArr[i10];
            arrayList.add(kotlin.d1.a(Double.valueOf(d10), other[i10]));
        }
        return arrayList;
    }

    @bk.f
    public static final <T> T wa(T[] tArr, int i10, ik.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Xe(tArr)) ? defaultValue.i(Integer.valueOf(i10)) : tArr[i10];
    }

    @yt.k
    public static final <C extends Collection<? super Byte>> C wb(@yt.k byte[] bArr, @yt.k C destination, @yt.k ik.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (byte b10 : bArr) {
            if (!predicate.i(Byte.valueOf(b10)).booleanValue()) {
                destination.add(Byte.valueOf(b10));
            }
        }
        return destination;
    }

    public static final boolean wc(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[0];
    }

    @hk.h(name = "flatMapSequenceTo")
    @kotlin.m0
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <T, R, C extends Collection<? super R>> C wd(@yt.k T[] tArr, @yt.k C destination, @yt.k ik.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (T t10 : tArr) {
            x.o0(destination, transform.i(t10));
        }
        return destination;
    }

    public static final <T> void we(@yt.k T[] tArr, @yt.k ik.l<? super T, z1> action) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (T t10 : tArr) {
            action.i(t10);
        }
    }

    @yt.k
    public static final <K> Map<K, List<Double>> wf(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d10 : dArr) {
            K kI = keySelector.i(Double.valueOf(d10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d10));
        }
        return linkedHashMap;
    }

    public static final int wg(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.l
    public static final Double wi(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Boolean wj(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z10);
        }
        R rI = selector.i(Boolean.valueOf(z10));
        k0 it2 = new qk.m(1, iZe).iterator();
        while (it2.hasNext()) {
            boolean z11 = zArr[it2.b()];
            R rI2 = selector.i(Boolean.valueOf(z11));
            if (rI.compareTo(rI2) < 0) {
                z10 = z11;
                rI = rI2;
            }
        }
        return Boolean.valueOf(z10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R wk(short[] sArr, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rI = selector.i(Short.valueOf(sArr[0]));
        k0 it2 = new qk.m(1, Ye(sArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Short.valueOf(sArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float wl(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fMax = fArr[0];
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fMax = Math.max(fMax, fArr[it2.b()]);
        }
        return fMax;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float wm(char[] cArr, ik.l<? super Character, Float> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Character.valueOf(cArr[0])).floatValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Character.valueOf(cArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R wn(boolean[] zArr, Comparator<? super R> comparator, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean wo(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    @kotlin.v0(version = "1.3")
    public static final long wp(@yt.k long[] jArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[random.p(jArr.length)];
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Boolean wq(@yt.k boolean[] zArr, @yt.k ik.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            zBooleanValue = operation.r0(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[it2.b()])).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final void wr(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iUe = Ue(fArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            float f10 = fArr[iB];
            fArr[iB] = fArr[iUe];
            fArr[iUe] = f10;
            iUe--;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Integer> ws(int[] iArr, ik.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            iIntValue = operation.r0(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i10])).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static final char wt(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final byte[] wu(@yt.k byte[] bArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            bArr2[i10] = bArr[it2.next().intValue()];
            i10++;
        }
        return bArr2;
    }

    @yt.k
    public static final byte[] wv(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "copyOf(this, size)");
        Qu(bArrCopyOf);
        return bArrCopyOf;
    }

    @yt.k
    public static final Set<Boolean> ww(@yt.k boolean[] zArr, @yt.k Iterable<Boolean> other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Set<Boolean> setDz = Dz(zArr);
        x.E0(setDz, other);
        return setDz;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long wx(long[] jArr, ik.l<? super Long, Long> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (long j10 : jArr) {
            jLongValue += selector.i(Long.valueOf(j10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Character> wy(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (!predicate.i(Character.valueOf(c10)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Character> wz(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return (Set) Iy(cArr, new LinkedHashSet(r0.j(qk.v.B(cArr.length, 128))));
    }

    public static final boolean x5(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (!predicate.i(Double.valueOf(d10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K> Map<K, Byte> x6(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(bArr.length), 16));
        for (byte b10 : bArr) {
            linkedHashMap.put(keySelector.i(Byte.valueOf(b10)), Byte.valueOf(b10));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Short, V> x7(short[] sArr, ik.l<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(sArr.length), 16));
        for (short s10 : sArr) {
            linkedHashMap.put(Short.valueOf(s10), valueSelector.i(Short.valueOf(s10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final double x8(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr[3];
    }

    @yt.k
    public static final <K> List<Byte> x9(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (hashSet.add(selector.i(Byte.valueOf(b10)))) {
                arrayList.add(Byte.valueOf(b10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R, V> List<V> xA(@yt.k double[] dArr, @yt.k R[] other, @yt.k ik.p<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Double.valueOf(dArr[i10]), other[i10]));
        }
        return arrayList;
    }

    @bk.f
    public static final short xa(short[] sArr, int i10, ik.l<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ye(sArr)) ? defaultValue.i(Integer.valueOf(i10)).shortValue() : sArr[i10];
    }

    @yt.k
    public static final <C extends Collection<? super Character>> C xb(@yt.k char[] cArr, @yt.k C destination, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (char c10 : cArr) {
            if (!predicate.i(Character.valueOf(c10)).booleanValue()) {
                destination.add(Character.valueOf(c10));
            }
        }
        return destination;
    }

    public static final boolean xc(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (boolean z10 : zArr) {
            if (predicate.i(Boolean.valueOf(z10)).booleanValue()) {
                return z10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C xd(@yt.k byte[] bArr, @yt.k C destination, @yt.k ik.l<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (byte b10 : bArr) {
            x.n0(destination, transform.i(Byte.valueOf(b10)));
        }
        return destination;
    }

    public static final void xe(@yt.k short[] sArr, @yt.k ik.l<? super Short, z1> action) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (short s10 : sArr) {
            action.i(Short.valueOf(s10));
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> xf(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends K> keySelector, @yt.k ik.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d10 : dArr) {
            K kI = keySelector.i(Double.valueOf(d10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Double.valueOf(d10)));
        }
        return linkedHashMap;
    }

    public static final int xg(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final String xh(@yt.k byte[] bArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) fh(bArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Double xi(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            double d10 = dArr[length];
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                return Double.valueOf(d10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Byte xj(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b10);
        }
        R rI = selector.i(Byte.valueOf(b10));
        k0 it2 = new qk.m(1, iRe).iterator();
        while (it2.hasNext()) {
            byte b11 = bArr[it2.b()];
            R rI2 = selector.i(Byte.valueOf(b11));
            if (rI.compareTo(rI2) < 0) {
                b10 = b11;
                rI = rI2;
            }
        }
        return Byte.valueOf(b10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R xk(boolean[] zArr, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rI = selector.i(Boolean.valueOf(zArr[0]));
        k0 it2 = new qk.m(1, Ze(zArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Boolean.valueOf(zArr[it2.b()]));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final float xl(@yt.k Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = fArr[0].floatValue();
        k0 it2 = new qk.m(1, Xe(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, fArr[it2.b()].floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float xm(double[] dArr, ik.l<? super Double, Float> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Double.valueOf(dArr[0])).floatValue();
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Double.valueOf(dArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R xn(byte[] bArr, Comparator<? super R> comparator, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rI = selector.i(Byte.valueOf(bArr[0]));
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Byte.valueOf(bArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean xo(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final <T> T xp(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (T) yp(tArr, Random.f38003a);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Byte xq(@yt.k byte[] bArr, @yt.k ik.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            bByteValue = operation.r0(Byte.valueOf(bByteValue), Byte.valueOf(bArr[it2.b()])).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @kotlin.v0(version = "1.4")
    public static final void xr(@yt.k float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, fArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            float f10 = fArr[i10];
            fArr[i10] = fArr[i13];
            fArr[i13] = f10;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Long> xs(long[] jArr, ik.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            jLongValue = operation.r0(Long.valueOf(jLongValue), Long.valueOf(jArr[i10])).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static final char xt(@yt.k char[] cArr, @yt.k ik.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (char c10 : cArr) {
            if (predicate.i(Character.valueOf(c10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                chValueOf = Character.valueOf(c10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(chValueOf, "null cannot be cast to non-null type kotlin.Char");
        return chValueOf.charValue();
    }

    @yt.k
    public static final byte[] xu(@yt.k byte[] bArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new byte[0] : kotlin.collections.m.G1(bArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final char[] xv(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.f0.o(cArrCopyOf, "copyOf(this, size)");
        Su(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final double xw(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double d10 = 0.0d;
        for (double d11 : dArr) {
            d10 += d11;
        }
        return d10;
    }

    @hk.h(name = "sumOfLong")
    public static final long xx(@yt.k Long[] lArr) {
        kotlin.jvm.internal.f0.p(lArr, "<this>");
        long jLongValue = 0;
        for (Long l10 : lArr) {
            jLongValue += l10.longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Double> xy(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (!predicate.i(Double.valueOf(d10)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Double> xz(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return (Set) Jy(dArr, new LinkedHashSet(r0.j(dArr.length)));
    }

    public static final boolean y5(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (!predicate.i(Float.valueOf(f10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K, V> Map<K, V> y6(@yt.k byte[] bArr, @yt.k ik.l<? super Byte, ? extends K> keySelector, @yt.k ik.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(bArr.length), 16));
        for (byte b10 : bArr) {
            linkedHashMap.put(keySelector.i(Byte.valueOf(b10)), valueTransform.i(Byte.valueOf(b10)));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V> Map<Boolean, V> y7(boolean[] zArr, ik.l<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(zArr.length), 16));
        for (boolean z10 : zArr) {
            linkedHashMap.put(Boolean.valueOf(z10), valueSelector.i(Boolean.valueOf(z10)));
        }
        return linkedHashMap;
    }

    @bk.f
    public static final float y8(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr[3];
    }

    @yt.k
    public static final <K> List<Character> y9(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (hashSet.add(selector.i(Character.valueOf(c10)))) {
                arrayList.add(Character.valueOf(c10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R> List<Pair<Float, R>> yA(@yt.k float[] fArr, @yt.k Iterable<? extends R> other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(kotlin.d1.a(Float.valueOf(fArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final boolean ya(boolean[] zArr, int i10, ik.l<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > Ze(zArr)) ? defaultValue.i(Integer.valueOf(i10)).booleanValue() : zArr[i10];
    }

    @yt.k
    public static final <C extends Collection<? super Double>> C yb(@yt.k double[] dArr, @yt.k C destination, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (double d10 : dArr) {
            if (!predicate.i(Double.valueOf(d10)).booleanValue()) {
                destination.add(Double.valueOf(d10));
            }
        }
        return destination;
    }

    @bk.f
    @kotlin.v0(version = "1.5")
    public static final <T, R> R yc(T[] tArr, ik.l<? super T, ? extends R> transform) {
        R rI;
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = tArr.length;
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                rI = transform.i(tArr[i10]);
                if (rI != null) {
                    break;
                }
                i10++;
            } else {
                rI = null;
                break;
            }
        }
        if (rI != null) {
            return rI;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C yd(@yt.k char[] cArr, @yt.k C destination, @yt.k ik.l<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (char c10 : cArr) {
            x.n0(destination, transform.i(Character.valueOf(c10)));
        }
        return destination;
    }

    public static final void ye(@yt.k boolean[] zArr, @yt.k ik.l<? super Boolean, z1> action) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        for (boolean z10 : zArr) {
            action.i(Boolean.valueOf(z10));
        }
    }

    @yt.k
    public static final <K> Map<K, List<Float>> yf(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f10 : fArr) {
            K kI = keySelector.i(Float.valueOf(f10));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f10));
        }
        return linkedHashMap;
    }

    public static final int yg(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final String yh(@yt.k char[] cArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Character, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) gh(cArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Float yi(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Character yj(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c10);
        }
        R rI = selector.i(Character.valueOf(c10));
        k0 it2 = new qk.m(1, iSe).iterator();
        while (it2.hasNext()) {
            char c11 = cArr[it2.b()];
            R rI2 = selector.i(Character.valueOf(c11));
            if (rI.compareTo(rI2) < 0) {
                c10 = c11;
                rI = rI2;
            }
        }
        return Character.valueOf(c10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double yk(byte[] bArr, ik.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Byte.valueOf(bArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Re(bArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Byte.valueOf(bArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final int yl(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            int i11 = iArr[it2.b()];
            if (i10 < i11) {
                i10 = i11;
            }
        }
        return i10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float ym(float[] fArr, ik.l<? super Float, Float> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Float.valueOf(fArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ue(fArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Float.valueOf(fArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R yn(char[] cArr, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(cArr[0]));
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(cArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean yo(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    @kotlin.v0(version = "1.3")
    public static final <T> T yp(@yt.k T[] tArr, @yt.k Random random) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(random, "random");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[random.p(tArr.length)];
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Character yq(@yt.k char[] cArr, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            cCharValue = operation.r0(Character.valueOf(cCharValue), Character.valueOf(cArr[it2.b()])).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static final void yr(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iVe = Ve(iArr);
        k0 it2 = new qk.m(0, length).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            int i10 = iArr[iB];
            iArr[iB] = iArr[iVe];
            iArr[iVe] = i10;
            iVe--;
        }
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.k
    public static final <S, T extends S> List<S> ys(@yt.k T[] tArr, @yt.k ik.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        S sR0 = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sR0);
        int length = tArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sR0 = operation.r0(sR0, (Object) tArr[i10]);
            arrayList.add(sR0);
        }
        return arrayList;
    }

    public static final double yt(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @yt.k
    public static final char[] yu(@yt.k char[] cArr, @yt.k Collection<Integer> indices) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            cArr2[i10] = cArr[it2.next().intValue()];
            i10++;
        }
        return cArr2;
    }

    @yt.k
    public static final double[] yv(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.f0.o(dArrCopyOf, "copyOf(this, size)");
        Uu(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final float yw(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        float f10 = 0.0f;
        for (float f11 : fArr) {
            f10 += f11;
        }
        return f10;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> long yx(T[] tArr, ik.l<? super T, Long> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (T t10 : tArr) {
            jLongValue += selector.i(t10).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Float> yy(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (!predicate.i(Float.valueOf(f10)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Float> yz(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return (Set) Ky(fArr, new LinkedHashSet(r0.j(fArr.length)));
    }

    public static final boolean z5(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (int i10 : iArr) {
            if (!predicate.i(Integer.valueOf(i10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final <K> Map<K, Character> z6(@yt.k char[] cArr, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(cArr.length), 16));
        for (char c10 : cArr) {
            linkedHashMap.put(keySelector.i(Character.valueOf(c10)), Character.valueOf(c10));
        }
        return linkedHashMap;
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <V, M extends Map<? super Byte, ? super V>> M z7(byte[] bArr, M destination, ik.l<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(valueSelector, "valueSelector");
        for (byte b10 : bArr) {
            destination.put(Byte.valueOf(b10), valueSelector.i(Byte.valueOf(b10)));
        }
        return destination;
    }

    @bk.f
    public static final int z8(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr[3];
    }

    @yt.k
    public static final <K> List<Double> z9(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends K> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (hashSet.add(selector.i(Double.valueOf(d10)))) {
                arrayList.add(Double.valueOf(d10));
            }
        }
        return arrayList;
    }

    @yt.k
    public static final <R, V> List<V> zA(@yt.k float[] fArr, @yt.k Iterable<? extends R> other, @yt.k ik.p<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t.Y(other, 10), length));
        int i10 = 0;
        for (R r10 : other) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(transform.r0(Float.valueOf(fArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @bk.f
    public static final Boolean za(boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return jf(zArr, i10);
    }

    @yt.k
    public static final <C extends Collection<? super Float>> C zb(@yt.k float[] fArr, @yt.k C destination, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (!predicate.i(Float.valueOf(f10)).booleanValue()) {
                destination.add(Float.valueOf(f10));
            }
        }
        return destination;
    }

    @bk.f
    @kotlin.v0(version = "1.5")
    public static final <T, R> R zc(T[] tArr, ik.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (T t10 : tArr) {
            R rI = transform.i(t10);
            if (rI != null) {
                return rI;
            }
        }
        return null;
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C zd(@yt.k double[] dArr, @yt.k C destination, @yt.k ik.l<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(transform, "transform");
        for (double d10 : dArr) {
            x.n0(destination, transform.i(Double.valueOf(d10)));
        }
        return destination;
    }

    public static final void ze(@yt.k byte[] bArr, @yt.k ik.p<? super Integer, ? super Byte, z1> action) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            action.r0(Integer.valueOf(i11), Byte.valueOf(bArr[i10]));
            i10++;
            i11++;
        }
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> zf(@yt.k float[] fArr, @yt.k ik.l<? super Float, ? extends K> keySelector, @yt.k ik.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(keySelector, "keySelector");
        kotlin.jvm.internal.f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f10 : fArr) {
            K kI = keySelector.i(Float.valueOf(f10));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Float.valueOf(f10)));
        }
        return linkedHashMap;
    }

    public static final int zg(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    @yt.k
    public static final String zh(@yt.k double[] dArr, @yt.k CharSequence separator, @yt.k CharSequence prefix, @yt.k CharSequence postfix, int i10, @yt.k CharSequence truncated, @yt.l ik.l<? super Double, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(separator, "separator");
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        kotlin.jvm.internal.f0.p(postfix, "postfix");
        kotlin.jvm.internal.f0.p(truncated, "truncated");
        String string = ((StringBuilder) hh(dArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.f0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @yt.l
    public static final Float zi(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            float f10 = fArr[length];
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                return Float.valueOf(f10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @kotlin.v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Double zj(@yt.k double[] dArr, @yt.k ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d10);
        }
        R rI = selector.i(Double.valueOf(d10));
        k0 it2 = new qk.m(1, iTe).iterator();
        while (it2.hasNext()) {
            double d11 = dArr[it2.b()];
            R rI2 = selector.i(Double.valueOf(d11));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final Double zk(char[] cArr, ik.l<? super Character, Double> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Character.valueOf(cArr[0])).doubleValue();
        k0 it2 = new qk.m(1, Se(cArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Character.valueOf(cArr[it2.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @hk.h(name = "maxOrThrow")
    @kotlin.v0(version = "1.7")
    public static final long zl(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        k0 it2 = new qk.m(1, We(jArr)).iterator();
        while (it2.hasNext()) {
            long j11 = jArr[it2.b()];
            if (j10 < j11) {
                j10 = j11;
            }
        }
        return j10;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final float zm(int[] iArr, ik.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Integer.valueOf(iArr[0])).floatValue();
        k0 it2 = new qk.m(1, Ve(iArr)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Integer.valueOf(iArr[it2.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <R> R zn(double[] dArr, Comparator<? super R> comparator, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rI = selector.i(Double.valueOf(dArr[0]));
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Double.valueOf(dArr[it2.b()]));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    public static final boolean zo(@yt.k float[] fArr, @yt.k ik.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        for (float f10 : fArr) {
            if (predicate.i(Float.valueOf(f10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @bk.f
    @kotlin.v0(version = "1.3")
    public static final short zp(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return Ap(sArr, Random.f38003a);
    }

    @c2(markerClass = {kotlin.q.class})
    @kotlin.v0(version = "1.4")
    @yt.l
    public static final Double zq(@yt.k double[] dArr, @yt.k ik.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        k0 it2 = new qk.m(1, Te(dArr)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = operation.r0(Double.valueOf(dDoubleValue), Double.valueOf(dArr[it2.b()])).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.v0(version = "1.4")
    public static final void zr(@yt.k int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.collections.b.f37685a.d(i10, i11, iArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            int i14 = iArr[i10];
            iArr[i10] = iArr[i13];
            iArr[i13] = i14;
            i13--;
            i10++;
        }
    }

    @bk.f
    @kotlin.v0(version = "1.4")
    public static final List<Short> zs(short[] sArr, ik.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sShortValue = operation.r0(Short.valueOf(sShortValue), Short.valueOf(sArr[i10])).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static final double zt(@yt.k double[] dArr, @yt.k ik.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        Double dValueOf = null;
        boolean z10 = false;
        for (double d10 : dArr) {
            if (predicate.i(Double.valueOf(d10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                dValueOf = Double.valueOf(d10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.f0.n(dValueOf, "null cannot be cast to non-null type kotlin.Double");
        return dValueOf.doubleValue();
    }

    @yt.k
    public static final char[] zu(@yt.k char[] cArr, @yt.k qk.m indices) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(indices, "indices");
        return indices.isEmpty() ? new char[0] : kotlin.collections.m.H1(cArr, indices.a().intValue(), indices.e().intValue() + 1);
    }

    @yt.k
    public static final float[] zv(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.f0.o(fArrCopyOf, "copyOf(this, size)");
        Wu(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final int zw(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int i10 = 0;
        for (byte b10 : bArr) {
            i10 += b10;
        }
        return i10;
    }

    @hk.h(name = "sumOfLong")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final long zx(short[] sArr, ik.l<? super Short, Long> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        long jLongValue = 0;
        for (short s10 : sArr) {
            jLongValue += selector.i(Short.valueOf(s10)).longValue();
        }
        return jLongValue;
    }

    @yt.k
    public static final List<Integer> zy(@yt.k int[] iArr, @yt.k ik.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (!predicate.i(Integer.valueOf(i10)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    @yt.k
    public static final Set<Integer> zz(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return (Set) Ly(iArr, new LinkedHashSet(r0.j(iArr.length)));
    }
}
