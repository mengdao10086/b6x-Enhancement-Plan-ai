package com.flydigi.device_manager.ui.sync;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.flydigi.base.common.RefreshableLiveData;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DBManager;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.CloudConfigBean;
import com.flydigi.data.bean.ConfigBean;
import com.flydigi.data.bean.ConfigUploadBean;
import com.flydigi.data.bean.EntitySimpleConfig;
import com.flydigi.data.bean.GetSharedConfigUrlResponse;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.data.bean.ShareUserConfigResponse;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@kotlin.jvm.internal.t0({"SMAP\nSyncConfigViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyncConfigViewModel.kt\ncom/flydigi/device_manager/ui/sync/SyncConfigViewModel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,520:1\n3819#2:521\n4337#2,2:522\n777#3:524\n788#3:525\n1864#3,2:526\n789#3,2:528\n1866#3:530\n791#3:531\n777#3:532\n788#3:533\n1864#3,2:534\n789#3,2:536\n1866#3:538\n791#3:539\n1549#3:540\n1620#3,3:541\n777#3:544\n788#3:545\n1864#3,2:546\n789#3,2:548\n1866#3:550\n791#3:551\n1864#3,3:552\n1864#3,3:555\n777#3:558\n788#3:559\n1864#3,2:560\n789#3,2:562\n1866#3:564\n791#3:565\n1549#3:566\n1620#3,3:567\n777#3:570\n788#3:571\n1864#3,2:572\n789#3,2:574\n1866#3:576\n791#3:577\n1549#3:578\n1620#3,3:579\n766#3:582\n857#3:583\n1549#3:584\n1620#3,3:585\n1549#3:588\n1620#3,3:589\n858#3:592\n777#3:593\n788#3:594\n1864#3,2:595\n789#3,2:597\n1866#3:599\n791#3:600\n*S KotlinDebug\n*F\n+ 1 SyncConfigViewModel.kt\ncom/flydigi/device_manager/ui/sync/SyncConfigViewModel\n*L\n179#1:521\n179#1:522,2\n189#1:524\n189#1:525\n189#1:526,2\n189#1:528,2\n189#1:530\n189#1:531\n197#1:532\n197#1:533\n197#1:534,2\n197#1:536,2\n197#1:538\n197#1:539\n198#1:540\n198#1:541,3\n212#1:544\n212#1:545\n212#1:546,2\n212#1:548,2\n212#1:550\n212#1:551\n281#1:552,3\n289#1:555,3\n301#1:558\n301#1:559\n301#1:560,2\n301#1:562,2\n301#1:564\n301#1:565\n302#1:566\n302#1:567,3\n304#1:570\n304#1:571\n304#1:572,2\n304#1:574,2\n304#1:576\n304#1:577\n305#1:578\n305#1:579,3\n306#1:582\n306#1:583\n308#1:584\n308#1:585,3\n310#1:588\n310#1:589,3\n306#1:592\n382#1:593\n382#1:594\n382#1:595,2\n382#1:597,2\n382#1:599\n382#1:600\n*E\n"})
public final class SyncConfigViewModel extends androidx.lifecycle.x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<LocalGameBean> f15413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<LocalGameBean> f15414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public androidx.lifecycle.j0<Pair<LocalGameBean, String>> f15415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<Pair<LocalGameBean, String>> f15416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final RefreshableLiveData<ArrayList<EntitySimpleConfig>> f15417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final LiveData<ArrayList<EntitySimpleConfig>> f15418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public final RefreshableLiveData<List<CloudConfigBean>> f15419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public final LiveData<List<CloudConfigBean>> f15420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public final LiveData<List<LocalGameBean>> f15421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<Pair<Boolean, String>> f15422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<Pair<Boolean, String>> f15423n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<Pair<Boolean, String>> f15424o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<Pair<Boolean, String>> f15425p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<ConfigBean> f15426q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @yt.k
    public final androidx.lifecycle.j0<Pair<CFGEntityList, String>> f15427r;

    public SyncConfigViewModel() {
        androidx.lifecycle.j0<LocalGameBean> j0Var = new androidx.lifecycle.j0<>();
        this.f15413d = j0Var;
        this.f15414e = j0Var;
        androidx.lifecycle.j0<Pair<LocalGameBean, String>> j0Var2 = new androidx.lifecycle.j0<>();
        this.f15415f = j0Var2;
        this.f15416g = j0Var2;
        RefreshableLiveData<ArrayList<EntitySimpleConfig>> refreshableLiveData = new RefreshableLiveData<>(new ik.a<LiveData<ArrayList<EntitySimpleConfig>>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final LiveData<ArrayList<EntitySimpleConfig>> o() {
                return Transformations.d(this.this$0.f15413d, new ik.l<LocalGameBean, LiveData<ArrayList<EntitySimpleConfig>>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1.1

                    /* JADX INFO: renamed from: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1, reason: invalid class name and collision with other inner class name */
                    @zj.d(c = "com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1", f = "SyncConfigViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
                    public static final class C01581 extends SuspendLambda implements ik.p<androidx.lifecycle.g0<ArrayList<EntitySimpleConfig>>, kotlin.coroutines.c<? super z1>, Object> {
                        public final /* synthetic */ LocalGameBean $it;
                        private /* synthetic */ Object L$0;
                        public int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C01581(LocalGameBean localGameBean, kotlin.coroutines.c<? super C01581> cVar) {
                            super(2, cVar);
                            this.$it = localGameBean;
                        }

                        public static final ArrayList K0(ik.l lVar, Object obj) {
                            return (ArrayList) lVar.i(obj);
                        }

                        @Override // ik.p
                        @yt.l
                        /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
                        public final Object r0(@yt.k androidx.lifecycle.g0<ArrayList<EntitySimpleConfig>> g0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                            return ((C01581) M(g0Var, cVar)).q0(z1.f38230a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @yt.k
                        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                            C01581 c01581 = new C01581(this.$it, cVar);
                            c01581.L$0 = obj;
                            return c01581;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @yt.l
                        public final Object q0(@yt.k Object obj) throws Throwable {
                            Object objH = yj.b.h();
                            int i10 = this.label;
                            if (i10 == 0) {
                                kotlin.u0.n(obj);
                                androidx.lifecycle.g0 g0Var = (androidx.lifecycle.g0) this.L$0;
                                LocalGameBean localGameBean = this.$it;
                                xi.z<CFGEntityList> zVarN0 = e6.z.n0(localGameBean.localPackageName, localGameBean.standardPackageName);
                                final C01591 c01591 = new ik.l<CFGEntityList, ArrayList<EntitySimpleConfig>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel._localConfigsLiveData.1.1.1.1
                                    @Override // ik.l
                                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                                    public final ArrayList<EntitySimpleConfig> i(@yt.k CFGEntityList cfgEntityList) {
                                        kotlin.jvm.internal.f0.p(cfgEntityList, "cfgEntityList");
                                        return e6.z.o0(cfgEntityList);
                                    }
                                };
                                ArrayList it2 = (ArrayList) zVarN0.A3(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: CHECK_CAST (r1v7 'it2' java.util.ArrayList) = (java.util.ArrayList) (wrap:java.lang.Object:0x003b: INVOKE 
                                      (wrap:xi.z:0x0037: INVOKE 
                                      (wrap:xi.z<R>:0x002f: INVOKE 
                                      (r1v3 'zVarN0' xi.z<com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList>)
                                      (wrap:dj.o<? super com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList, ? extends R>:0x002c: CONSTRUCTOR (r3v1 'c01591' com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1$1 A[DONT_INLINE]) A[MD:(ik.l):void (m), WRAPPED] call: com.flydigi.device_manager.ui.sync.e1.<init>(ik.l):void type: CONSTRUCTOR)
                                     VIRTUAL call: xi.z.A3(dj.o):xi.z A[MD:<R>:(dj.o<? super T, ? extends R>):xi.z<R> (m), WRAPPED])
                                      (wrap:xi.h0:0x0033: INVOKE  STATIC call: lj.b.d():xi.h0 A[MD:():xi.h0 (m), WRAPPED] (LINE:4))
                                     VIRTUAL call: xi.z.J5(xi.h0):xi.z A[MD:(xi.h0):xi.z<T> (m), WRAPPED] (LINE:4))
                                     VIRTUAL call: xi.z.k():java.lang.Object A[MD:():T (m), WRAPPED] (LINE:5)) in method: com.flydigi.device_manager.ui.sync.SyncConfigViewModel._localConfigsLiveData.1.1.1.q0(java.lang.Object):java.lang.Object, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.flydigi.device_manager.ui.sync.e1, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:878)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:878)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:345)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 21 more
                                    */
                                /*
                                    this = this;
                                    java.lang.Object r0 = yj.b.h()
                                    int r1 = r5.label
                                    r2 = 1
                                    if (r1 == 0) goto L17
                                    if (r1 != r2) goto Lf
                                    kotlin.u0.n(r6)
                                    goto L4f
                                Lf:
                                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                    r6.<init>(r0)
                                    throw r6
                                L17:
                                    kotlin.u0.n(r6)
                                    java.lang.Object r6 = r5.L$0
                                    androidx.lifecycle.g0 r6 = (androidx.lifecycle.g0) r6
                                    com.flydigi.data.bean.LocalGameBean r1 = r5.$it
                                    java.lang.String r3 = r1.localPackageName
                                    java.lang.String r1 = r1.standardPackageName
                                    xi.z r1 = e6.z.n0(r3, r1)
                                    com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1$1 r3 = new ik.l<com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList, java.util.ArrayList<com.flydigi.data.bean.EntitySimpleConfig>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel._localConfigsLiveData.1.1.1.1
                                        static {
                                            /*
                                                com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1$1 r0 = new com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1$1
                                                r0.<init>()
                                                
                                                // error: 0x0005: SPUT (r0 I:com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1$1) com.flydigi.device_manager.ui.sync.SyncConfigViewModel._localConfigsLiveData.1.1.1.1.a com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1$1$1$1
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1.AnonymousClass1.C01581.C01591.<clinit>():void");
                                        }

                                        {
                                            /*
                                                r1 = this;
                                                r0 = 1
                                                r1.<init>(r0)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1.AnonymousClass1.C01581.C01591.<init>():void");
                                        }

                                        @Override // ik.l
                                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                                        public final java.util.ArrayList<com.flydigi.data.bean.EntitySimpleConfig> i(@yt.k com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList r2) {
                                            /*
                                                r1 = this;
                                                java.lang.String r0 = "cfgEntityList"
                                                kotlin.jvm.internal.f0.p(r2, r0)
                                                java.util.ArrayList r2 = e6.z.o0(r2)
                                                return r2
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1.AnonymousClass1.C01581.C01591.i(com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList):java.util.ArrayList");
                                        }

                                        @Override // ik.l
                                        public /* bridge */ /* synthetic */ java.util.ArrayList<com.flydigi.data.bean.EntitySimpleConfig> i(com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList r1) {
                                            /*
                                                r0 = this;
                                                com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList r1 = (com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList) r1
                                                java.util.ArrayList r1 = r0.i(r1)
                                                return r1
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1.AnonymousClass1.C01581.C01591.i(java.lang.Object):java.lang.Object");
                                        }
                                    }
                                    com.flydigi.device_manager.ui.sync.e1 r4 = new com.flydigi.device_manager.ui.sync.e1
                                    r4.<init>(r3)
                                    xi.z r1 = r1.A3(r4)
                                    xi.h0 r3 = lj.b.d()
                                    xi.z r1 = r1.J5(r3)
                                    java.lang.Object r1 = r1.k()
                                    java.util.ArrayList r1 = (java.util.ArrayList) r1
                                    java.lang.String r3 = "it"
                                    kotlin.jvm.internal.f0.o(r1, r3)
                                    r5.label = r2
                                    java.lang.Object r6 = r6.f(r1, r5)
                                    if (r6 != r0) goto L4f
                                    return r0
                                L4f:
                                    kotlin.z1 r6 = kotlin.z1.f38230a
                                    return r6
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_localConfigsLiveData$1.AnonymousClass1.C01581.q0(java.lang.Object):java.lang.Object");
                            }
                        }

                        @Override // ik.l
                        @yt.l
                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final LiveData<ArrayList<EntitySimpleConfig>> i(LocalGameBean localGameBean) {
                            return CoroutineLiveDataKt.d(null, 0L, new C01581(localGameBean, null), 3, null);
                        }
                    });
                }
            });
            this.f15417h = refreshableLiveData;
            this.f15418i = refreshableLiveData;
            RefreshableLiveData<List<CloudConfigBean>> refreshableLiveData2 = new RefreshableLiveData<>(new ik.a<LiveData<List<? extends CloudConfigBean>>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_cloudConfigsLiveData$1
                {
                    super(0);
                }

                @Override // ik.a
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final LiveData<List<CloudConfigBean>> o() {
                    return Transformations.d(this.this$0.f15413d, new ik.l<LocalGameBean, LiveData<List<CloudConfigBean>>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_cloudConfigsLiveData$1.1

                        /* JADX INFO: renamed from: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_cloudConfigsLiveData$1$1$1, reason: invalid class name and collision with other inner class name */
                        @zj.d(c = "com.flydigi.device_manager.ui.sync.SyncConfigViewModel$_cloudConfigsLiveData$1$1$1", f = "SyncConfigViewModel.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
                        public static final class C01571 extends SuspendLambda implements ik.p<androidx.lifecycle.g0<List<? extends CloudConfigBean>>, kotlin.coroutines.c<? super z1>, Object> {
                            public final /* synthetic */ LocalGameBean $it;
                            private /* synthetic */ Object L$0;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C01571(LocalGameBean localGameBean, kotlin.coroutines.c<? super C01571> cVar) {
                                super(2, cVar);
                                this.$it = localGameBean;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @yt.k
                            public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                                C01571 c01571 = new C01571(this.$it, cVar);
                                c01571.L$0 = obj;
                                return c01571;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @yt.l
                            public final Object q0(@yt.k Object obj) throws Throwable {
                                Object objH = yj.b.h();
                                int i10 = this.label;
                                if (i10 == 0) {
                                    kotlin.u0.n(obj);
                                    androidx.lifecycle.g0 g0Var = (androidx.lifecycle.g0) this.L$0;
                                    List it2 = (List) ((h5.d) m5.f0.i().k().g(h5.d.class)).o(this.$it.localPackageName).s0(m5.c0.p()).s0(m5.c0.t()).J5(lj.b.d()).k();
                                    kotlin.jvm.internal.f0.o(it2, "it");
                                    this.label = 1;
                                    if (g0Var.f(it2, this) == objH) {
                                        return objH;
                                    }
                                } else {
                                    if (i10 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    kotlin.u0.n(obj);
                                }
                                return z1.f38230a;
                            }

                            @Override // ik.p
                            @yt.l
                            /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
                            public final Object r0(@yt.k androidx.lifecycle.g0<List<CloudConfigBean>> g0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
                                return ((C01571) M(g0Var, cVar)).q0(z1.f38230a);
                            }
                        }

                        @Override // ik.l
                        @yt.l
                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final LiveData<List<CloudConfigBean>> i(LocalGameBean localGameBean) {
                            return CoroutineLiveDataKt.d(null, 0L, new C01571(localGameBean, null), 3, null);
                        }
                    });
                }
            });
            this.f15419j = refreshableLiveData2;
            this.f15420k = refreshableLiveData2;
            LiveData<List<InstalledGameBean>> liveDataObservableInstalledGames = DBManager.getInstance().observableInstalledGames();
            kotlin.jvm.internal.f0.o(liveDataObservableInstalledGames, "getInstance().observableInstalledGames()");
            this.f15421l = Transformations.b(liveDataObservableInstalledGames, new ik.l<List<InstalledGameBean>, List<LocalGameBean>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$gameListLiveData$1
                @Override // ik.l
                @yt.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final List<LocalGameBean> i(List<InstalledGameBean> gameList) {
                    kotlin.jvm.internal.f0.o(gameList, "gameList");
                    ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(gameList, 10));
                    for (InstalledGameBean installedGameBean : gameList) {
                        LocalGameBean localGameBean = new LocalGameBean();
                        localGameBean.f14331id = installedGameBean.getId();
                        localGameBean.thumb = installedGameBean.getThumb();
                        localGameBean.name = installedGameBean.getTitle();
                        localGameBean.localPackageName = installedGameBean.getLocalPackageName();
                        localGameBean.standardPackageName = installedGameBean.getStandardPackageName();
                        arrayList.add(localGameBean);
                    }
                    return arrayList;
                }
            });
            this.f15422m = new androidx.lifecycle.j0<>();
            this.f15423n = new androidx.lifecycle.j0<>();
            this.f15424o = new androidx.lifecycle.j0<>();
            this.f15425p = new androidx.lifecycle.j0<>();
            this.f15426q = new androidx.lifecycle.j0<>();
            this.f15427r = new androidx.lifecycle.j0<>();
        }

        public static final void A0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 D0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final xi.e0 W0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void X0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void Y0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void a1(SyncConfigViewModel this$0) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this$0.f15417h.z();
        }

        public static final Boolean c0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (Boolean) tmp0.i(obj);
        }

        public static final xi.e0 c1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void d0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void d1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void e1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void g0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void g1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void h0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void h1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 j0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void l0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 l1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void m0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 m1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void n1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void o1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void p0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 q0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final xi.e0 q1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final CFGEntityList r0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (CFGEntityList) tmp0.i(obj);
        }

        public static final ConfigUploadBean r1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (ConfigUploadBean) tmp0.i(obj);
        }

        public static final void s0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 s1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void t0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void t1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final void u1(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public static final xi.e0 w0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final xi.e0 x0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            return (xi.e0) tmp0.i(obj);
        }

        public static final void y0(ik.l tmp0, Object obj) {
            kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
            tmp0.i(obj);
        }

        public final xi.z<Pair<CloudConfigBean, File>> C0(int[] iArr) {
            ArrayList arrayList;
            List<CloudConfigBean> listF = this.f15420k.f();
            if (listF != null) {
                arrayList = new ArrayList();
                int i10 = 0;
                for (Object obj : listF) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.W();
                    }
                    if (ArraysKt___ArraysKt.R8(iArr, i10)) {
                        arrayList.add(obj);
                    }
                    i10 = i11;
                }
            } else {
                arrayList = null;
            }
            xi.z zVarP2 = xi.z.P2(arrayList);
            final SyncConfigViewModel$downloadConfigFile$2 syncConfigViewModel$downloadConfigFile$2 = SyncConfigViewModel$downloadConfigFile$2.f15434a;
            return zVarP2.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.o0
                @Override // dj.o
                public final Object apply(Object obj2) {
                    return SyncConfigViewModel.D0(syncConfigViewModel$downloadConfigFile$2, obj2);
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
        @yt.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List<java.lang.String> E0(boolean r10, @yt.k int[] r11) {
            /*
                Method dump skipped, instruction units count: 319
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel.E0(boolean, int[]):java.util.List");
        }

        @yt.k
        public final LiveData<List<CloudConfigBean>> F0() {
            return this.f15420k;
        }

        @yt.k
        public final LiveData<LocalGameBean> G0() {
            return this.f15414e;
        }

        @yt.k
        public final androidx.lifecycle.j0<Pair<Boolean, String>> H0() {
            return this.f15425p;
        }

        @yt.k
        public final androidx.lifecycle.j0<Pair<Boolean, String>> I0() {
            return this.f15423n;
        }

        @yt.k
        public final androidx.lifecycle.j0<Pair<CFGEntityList, String>> J0() {
            return this.f15427r;
        }

        @yt.k
        public final LiveData<List<LocalGameBean>> K0() {
            return this.f15421l;
        }

        @yt.k
        public final LiveData<ArrayList<EntitySimpleConfig>> L0() {
            return this.f15418i;
        }

        public final int[] O0(int[] iArr, boolean z10) {
            CloudConfigBean cloudConfigBean;
            if (z10) {
                return iArr;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 : iArr) {
                List<String> listE0 = E0(true, iArr);
                List<CloudConfigBean> listF = this.f15420k.f();
                if (true ^ CollectionsKt___CollectionsKt.R1(listE0, (listF == null || (cloudConfigBean = listF.get(i10)) == null) ? null : cloudConfigBean.title)) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            return CollectionsKt___CollectionsKt.P5(arrayList);
        }

        @yt.k
        public final androidx.lifecycle.j0<Pair<Boolean, String>> Q0() {
            return this.f15422m;
        }

        @yt.k
        public final androidx.lifecycle.j0<Pair<LocalGameBean, String>> R0() {
            return this.f15416g;
        }

        @yt.k
        public final androidx.lifecycle.j0<ConfigBean> S0() {
            return this.f15426q;
        }

        @yt.k
        public final androidx.lifecycle.j0<Pair<Boolean, String>> T0() {
            return this.f15424o;
        }

        public final void U0(boolean z10, final int i10, @yt.k final String newTitle) {
            final LocalGameBean localGameBeanF;
            kotlin.jvm.internal.f0.p(newTitle, "newTitle");
            if (z10 || (localGameBeanF = this.f15413d.f()) == null) {
                return;
            }
            xi.z<CFGEntityList> zVarN0 = e6.z.n0(localGameBeanF.localPackageName, localGameBeanF.standardPackageName);
            final ik.l<CFGEntityList, xi.e0<? extends File>> lVar = new ik.l<CFGEntityList, xi.e0<? extends File>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$renameSingleConfig$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final xi.e0<? extends File> i(@yt.k CFGEntityList configList) {
                    kotlin.jvm.internal.f0.p(configList, "configList");
                    ArrayList arrayList = (ArrayList) this.this$0.f15417h.f();
                    if (arrayList == null) {
                        return null;
                    }
                    int i11 = i10;
                    String str = newTitle;
                    LocalGameBean localGameBean = localGameBeanF;
                    e6.z.t0((EntitySimpleConfig) arrayList.get(i11), configList, str);
                    return e6.z.w0(configList, localGameBean.localPackageName);
                }
            };
            xi.z zVarS0 = zVarN0.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.v0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return SyncConfigViewModel.W0(lVar, obj);
                }
            }).s0(o5.l.d());
            final ik.l<File, z1> lVar2 = new ik.l<File, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$renameSingleConfig$1$2
                {
                    super(1);
                }

                public final void b(File file) {
                    this.this$0.Q0().o(new Pair<>(Boolean.TRUE, ""));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(File file) {
                    b(file);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.g0
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.X0(lVar2, obj);
                }
            };
            final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$renameSingleConfig$1$3
                {
                    super(1);
                }

                public final void b(Throwable th2) {
                    androidx.lifecycle.j0<Pair<Boolean, String>> j0VarQ0 = this.this$0.Q0();
                    Boolean bool = Boolean.FALSE;
                    String message = th2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    j0VarQ0.o(new Pair<>(bool, message));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarS0.G5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.d1
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.Y0(lVar3, obj);
                }
            }, new dj.a() { // from class: com.flydigi.device_manager.ui.sync.u
                @Override // dj.a
                public final void run() {
                    SyncConfigViewModel.a1(this.f15497a);
                }
            });
        }

        public final boolean a0(boolean z10, int i10, @yt.k String newTitle) {
            kotlin.jvm.internal.f0.p(newTitle, "newTitle");
            if (z10) {
                List<CloudConfigBean> listF = this.f15420k.f();
                if (listF != null) {
                    int i11 = 0;
                    for (Object obj : listF) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt__CollectionsKt.W();
                        }
                        CloudConfigBean cloudConfigBean = (CloudConfigBean) obj;
                        if (i11 != i10 && Objects.equals(cloudConfigBean.title, newTitle)) {
                            return true;
                        }
                        i11 = i12;
                    }
                }
            } else {
                ArrayList<EntitySimpleConfig> arrayListF = this.f15418i.f();
                if (arrayListF != null) {
                    int i13 = 0;
                    for (Object obj2 : arrayListF) {
                        int i14 = i13 + 1;
                        if (i13 < 0) {
                            CollectionsKt__CollectionsKt.W();
                        }
                        EntitySimpleConfig entitySimpleConfig = (EntitySimpleConfig) obj2;
                        if (i13 != i10 && Objects.equals(entitySimpleConfig.getName(), newTitle)) {
                            return true;
                        }
                        i13 = i14;
                    }
                }
            }
            return false;
        }

        public final void b0(@yt.k final CFGEntityList newCfgEntityList) {
            kotlin.jvm.internal.f0.p(newCfgEntityList, "newCfgEntityList");
            LocalGameBean localGameBeanF = this.f15413d.f();
            if (localGameBeanF != null) {
                xi.z<CFGEntityList> zVarN0 = e6.z.n0(localGameBeanF.localPackageName, localGameBeanF.standardPackageName);
                final ik.l<CFGEntityList, Boolean> lVar = new ik.l<CFGEntityList, Boolean>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$checkSameNameConfigExist$1$1
                    {
                        super(1);
                    }

                    @Override // ik.l
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Boolean i(@yt.k CFGEntityList cfgEntityList) {
                        kotlin.jvm.internal.f0.p(cfgEntityList, "cfgEntityList");
                        return Boolean.valueOf(e6.z.y(cfgEntityList, newCfgEntityList));
                    }
                };
                xi.z zVarB4 = zVarN0.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.p0
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return SyncConfigViewModel.c0(lVar, obj);
                    }
                }).J5(lj.b.d()).b4(aj.a.c());
                final ik.l<Boolean, z1> lVar2 = new ik.l<Boolean, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$checkSameNameConfigExist$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(boolean z10) {
                        if (z10) {
                            this.this$0.J0().o(new Pair<>(newCfgEntityList, com.blankj.utilcode.util.d1.d(R.string.floatview_config_manager_download_config_conflict_with_local)));
                        } else {
                            this.this$0.b1(newCfgEntityList, true);
                        }
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Boolean bool) {
                        b(bool.booleanValue());
                        return z1.f38230a;
                    }
                };
                zVarB4.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.sync.c1
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.d0(lVar2, obj);
                    }
                });
            }
        }

        public final void b1(@yt.k final CFGEntityList newCfgEntityList, final boolean z10) {
            kotlin.jvm.internal.f0.p(newCfgEntityList, "newCfgEntityList");
            final LocalGameBean localGameBeanF = this.f15413d.f();
            if (localGameBeanF != null) {
                xi.z<CFGEntityList> zVarN0 = e6.z.n0(localGameBeanF.localPackageName, localGameBeanF.standardPackageName);
                final ik.l<CFGEntityList, xi.e0<? extends File>> lVar = new ik.l<CFGEntityList, xi.e0<? extends File>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$saveConfigToLocal$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // ik.l
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final xi.e0<? extends File> i(@yt.k CFGEntityList cfgEntityList) {
                        kotlin.jvm.internal.f0.p(cfgEntityList, "cfgEntityList");
                        return e6.z.g0(localGameBeanF.localPackageName, cfgEntityList, newCfgEntityList, z10);
                    }
                };
                xi.z zVarS0 = zVarN0.M5(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.n0
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return SyncConfigViewModel.c1(lVar, obj);
                    }
                }).s0(o5.l.d());
                final ik.l<File, z1> lVar2 = new ik.l<File, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$saveConfigToLocal$1$2
                    {
                        super(1);
                    }

                    public final void b(File file) {
                        this.this$0.f15417h.z();
                        this.this$0.I0().o(new Pair<>(Boolean.TRUE, ""));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(File file) {
                        b(file);
                        return z1.f38230a;
                    }
                };
                dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.x0
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.d1(lVar2, obj);
                    }
                };
                final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$saveConfigToLocal$1$3
                    {
                        super(1);
                    }

                    public final void b(@yt.k Throwable throwable) {
                        kotlin.jvm.internal.f0.p(throwable, "throwable");
                        androidx.lifecycle.j0<Pair<Boolean, String>> j0VarI0 = this.this$0.I0();
                        Boolean bool = Boolean.FALSE;
                        String message = throwable.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        j0VarI0.o(new Pair<>(bool, message));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                        b(th2);
                        return z1.f38230a;
                    }
                };
                zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.a1
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.e1(lVar3, obj);
                    }
                });
            }
        }

        public final void f0(@yt.k int[] selectedPositions) {
            kotlin.jvm.internal.f0.p(selectedPositions, "selectedPositions");
            List<CloudConfigBean> listF = this.f15420k.f();
            if (listF != null) {
                ArrayList arrayList = new ArrayList();
                int i10 = 0;
                for (Object obj : listF) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.W();
                    }
                    if (ArraysKt___ArraysKt.R8(selectedPositions, i10)) {
                        arrayList.add(obj);
                    }
                    i10 = i11;
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(((CloudConfigBean) it2.next()).f14326id));
                }
                xi.z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).k(m5.f0.i().h().toJson(arrayList2)).s0(m5.c0.r()).s0(m5.c0.t()).s0(o5.l.d());
                final ik.l<BaseResponse<String>, z1> lVar = new ik.l<BaseResponse<String>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$deleteCloudConfig$3$1
                    {
                        super(1);
                    }

                    public final void b(BaseResponse<String> baseResponse) {
                        this.this$0.f15419j.z();
                        this.this$0.H0().o(new Pair<>(Boolean.TRUE, ""));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(BaseResponse<String> baseResponse) {
                        b(baseResponse);
                        return z1.f38230a;
                    }
                };
                dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.w
                    @Override // dj.g
                    public final void accept(Object obj2) {
                        SyncConfigViewModel.g0(lVar, obj2);
                    }
                };
                final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$deleteCloudConfig$3$2
                    {
                        super(1);
                    }

                    public final void b(Throwable th2) {
                        androidx.lifecycle.j0<Pair<Boolean, String>> j0VarH0 = this.this$0.H0();
                        Boolean bool = Boolean.FALSE;
                        String message = th2.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        j0VarH0.o(new Pair<>(bool, message));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                        b(th2);
                        return z1.f38230a;
                    }
                };
                zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.b0
                    @Override // dj.g
                    public final void accept(Object obj2) {
                        SyncConfigViewModel.h0(lVar2, obj2);
                    }
                });
            }
        }

        public final void f1() {
            final LocalGameBean localGameBeanF = this.f15413d.f();
            if (localGameBeanF != null) {
                xi.z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).x(localGameBeanF.localPackageName).s0(m5.c0.p()).s0(m5.c0.t()).s0(o5.l.d());
                final ik.l<ShareUserConfigResponse, z1> lVar = new ik.l<ShareUserConfigResponse, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$shareCloudConfigs$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(ShareUserConfigResponse shareUserConfigResponse) {
                        localGameBeanF.shareCode = shareUserConfigResponse.getCode();
                        this.f15415f.o(new Pair(localGameBeanF, ""));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(ShareUserConfigResponse shareUserConfigResponse) {
                        b(shareUserConfigResponse);
                        return z1.f38230a;
                    }
                };
                dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.e0
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.g1(lVar, obj);
                    }
                };
                final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$shareCloudConfigs$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(Throwable th2) {
                        androidx.lifecycle.j0 j0Var = this.this$0.f15415f;
                        LocalGameBean localGameBean = localGameBeanF;
                        String message = th2.getMessage();
                        if (message == null) {
                            message = com.blankj.utilcode.util.d1.d(R.string.api_error_notice);
                        }
                        j0Var.o(new Pair(localGameBean, message));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                        b(th2);
                        return z1.f38230a;
                    }
                };
                zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.v
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.h1(lVar2, obj);
                    }
                });
            }
        }

        public final void i0(@yt.k int[] selectedPositions) {
            kotlin.jvm.internal.f0.p(selectedPositions, "selectedPositions");
            ArrayList<EntitySimpleConfig> arrayListF = this.f15418i.f();
            if (arrayListF != null) {
                final ArrayList arrayList = new ArrayList();
                int i10 = 0;
                for (Object obj : arrayListF) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.W();
                    }
                    if (ArraysKt___ArraysKt.R8(selectedPositions, i10)) {
                        arrayList.add(obj);
                    }
                    i10 = i11;
                }
                final LocalGameBean localGameBeanF = this.f15413d.f();
                if (localGameBeanF != null) {
                    xi.z<CFGEntityList> zVarN0 = e6.z.n0(localGameBeanF.localPackageName, localGameBeanF.standardPackageName);
                    final ik.l<CFGEntityList, xi.e0<? extends File>> lVar = new ik.l<CFGEntityList, xi.e0<? extends File>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$deleteLocalConfig$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // ik.l
                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final xi.e0<? extends File> i(@yt.k CFGEntityList cfgEntityList) {
                            kotlin.jvm.internal.f0.p(cfgEntityList, "cfgEntityList");
                            e6.z.s0(arrayList, cfgEntityList);
                            return e6.z.w0(cfgEntityList, localGameBeanF.localPackageName);
                        }
                    };
                    xi.z zVarS0 = zVarN0.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.w0
                        @Override // dj.o
                        public final Object apply(Object obj2) {
                            return SyncConfigViewModel.j0(lVar, obj2);
                        }
                    }).s0(m5.c0.t()).s0(o5.l.d());
                    final ik.l<File, z1> lVar2 = new ik.l<File, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$deleteLocalConfig$2$1$2
                        {
                            super(1);
                        }

                        public final void b(File file) {
                            this.this$0.f15417h.z();
                        }

                        @Override // ik.l
                        public /* bridge */ /* synthetic */ z1 i(File file) {
                            b(file);
                            return z1.f38230a;
                        }
                    };
                    dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.y
                        @Override // dj.g
                        public final void accept(Object obj2) {
                            SyncConfigViewModel.l0(lVar2, obj2);
                        }
                    };
                    final SyncConfigViewModel$deleteLocalConfig$2$1$3 syncConfigViewModel$deleteLocalConfig$2$1$3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$deleteLocalConfig$2$1$3
                        public final void b(Throwable th2) {
                        }

                        @Override // ik.l
                        public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                            b(th2);
                            return z1.f38230a;
                        }
                    };
                    zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.z
                        @Override // dj.g
                        public final void accept(Object obj2) {
                            SyncConfigViewModel.m0(syncConfigViewModel$deleteLocalConfig$2$1$3, obj2);
                        }
                    });
                }
            }
        }

        public final void i1(int i10) {
            List<LocalGameBean> listF = this.f15421l.f();
            LocalGameBean localGameBean = listF != null ? listF.get(i10) : null;
            if (com.blankj.utilcode.util.n0.b(this.f15413d.f(), localGameBean)) {
                return;
            }
            this.f15413d.o(localGameBean);
        }

        public final void j1(@yt.k int[] selectedPositions) {
            ArrayList arrayList;
            kotlin.jvm.internal.f0.p(selectedPositions, "selectedPositions");
            ArrayList<EntitySimpleConfig> arrayListF = this.f15418i.f();
            if (arrayListF != null) {
                arrayList = new ArrayList();
                int i10 = 0;
                for (Object obj : arrayListF) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.W();
                    }
                    if (ArraysKt___ArraysKt.R8(selectedPositions, i10)) {
                        arrayList.add(obj);
                    }
                    i10 = i11;
                }
            } else {
                arrayList = null;
            }
            xi.z zVarP2 = xi.z.P2(arrayList);
            final SyncConfigViewModel$uploadConfig$2 syncConfigViewModel$uploadConfig$2 = new SyncConfigViewModel$uploadConfig$2(this);
            xi.z zVarV1 = zVarP2.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.m0
                @Override // dj.o
                public final Object apply(Object obj2) {
                    return SyncConfigViewModel.l1(syncConfigViewModel$uploadConfig$2, obj2);
                }
            }).Y6().v1();
            final Gson gsonH = m5.f0.i().h();
            xi.z zVarA3 = zVarV1.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.h0
                @Override // dj.o
                public final Object apply(Object obj2) {
                    return gsonH.toJson(obj2);
                }
            });
            final ik.l<String, xi.e0<? extends BaseResponse<Object>>> lVar = new ik.l<String, xi.e0<? extends BaseResponse<Object>>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfig$4
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final xi.e0<? extends BaseResponse<Object>> i(@yt.k String it2) {
                    kotlin.jvm.internal.f0.p(it2, "it");
                    h5.d dVar = (h5.d) m5.f0.i().k().g(h5.d.class);
                    LocalGameBean localGameBean = (LocalGameBean) this.this$0.f15413d.f();
                    return dVar.w(localGameBean != null ? localGameBean.localPackageName : null, it2).s0(m5.c0.r()).s0(m5.c0.t()).J5(lj.b.d());
                }
            };
            xi.z zVarS0 = zVarA3.M5(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.k0
                @Override // dj.o
                public final Object apply(Object obj2) {
                    return SyncConfigViewModel.m1(lVar, obj2);
                }
            }).s0(o5.l.d());
            final ik.l<BaseResponse<Object>, z1> lVar2 = new ik.l<BaseResponse<Object>, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfig$5
                {
                    super(1);
                }

                public final void b(BaseResponse<Object> baseResponse) {
                    this.this$0.f15419j.z();
                    this.this$0.T0().o(new Pair<>(Boolean.TRUE, ""));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(BaseResponse<Object> baseResponse) {
                    b(baseResponse);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.f0
                @Override // dj.g
                public final void accept(Object obj2) {
                    SyncConfigViewModel.n1(lVar2, obj2);
                }
            };
            final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfig$6
                {
                    super(1);
                }

                public final void b(Throwable th2) {
                    androidx.lifecycle.j0<Pair<Boolean, String>> j0VarT0 = this.this$0.T0();
                    Boolean bool = Boolean.FALSE;
                    String message = th2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    j0VarT0.o(new Pair<>(bool, message));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.c0
                @Override // dj.g
                public final void accept(Object obj2) {
                    SyncConfigViewModel.o1(lVar3, obj2);
                }
            });
        }

        public final void o0(@yt.k String code) {
            kotlin.jvm.internal.f0.p(code, "code");
            xi.z zVarS0 = ((h5.d) m5.f0.i().k().g(h5.d.class)).p(code).s0(m5.c0.p()).s0(m5.c0.t());
            final ik.l<GetSharedConfigUrlResponse, z1> lVar = new ik.l<GetSharedConfigUrlResponse, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadCloudSharedConfig$1
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void b(GetSharedConfigUrlResponse getSharedConfigUrlResponse) {
                    String packageName = getSharedConfigUrlResponse.getPackageName();
                    LocalGameBean localGameBean = (LocalGameBean) this.this$0.f15413d.f();
                    if (!com.blankj.utilcode.util.n0.b(packageName, localGameBean != null ? localGameBean.localPackageName : null)) {
                        throw new IllegalArgumentException(com.blankj.utilcode.util.d1.d(R.string.floatview_config_manager_download_config_package_name_diff));
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(GetSharedConfigUrlResponse getSharedConfigUrlResponse) {
                    b(getSharedConfigUrlResponse);
                    return z1.f38230a;
                }
            };
            xi.z zVarY1 = zVarS0.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.sync.d0
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.p0(lVar, obj);
                }
            });
            final SyncConfigViewModel$downloadCloudSharedConfig$2 syncConfigViewModel$downloadCloudSharedConfig$2 = new ik.l<GetSharedConfigUrlResponse, xi.e0<? extends File>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadCloudSharedConfig$2
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final xi.e0<? extends File> i(@yt.k GetSharedConfigUrlResponse response) {
                    kotlin.jvm.internal.f0.p(response, "response");
                    return e6.z.F(response.getUrl());
                }
            };
            xi.z zVarL2 = zVarY1.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.r0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return SyncConfigViewModel.q0(syncConfigViewModel$downloadCloudSharedConfig$2, obj);
                }
            });
            final SyncConfigViewModel$downloadCloudSharedConfig$3 syncConfigViewModel$downloadCloudSharedConfig$3 = new ik.l<File, CFGEntityList>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadCloudSharedConfig$3
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CFGEntityList i(@yt.k File file) {
                    kotlin.jvm.internal.f0.p(file, "file");
                    return e6.z.k0(file, "utf-8");
                }
            };
            xi.z zVarS02 = zVarL2.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.j0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return SyncConfigViewModel.r0(syncConfigViewModel$downloadCloudSharedConfig$3, obj);
                }
            }).s0(o5.l.d());
            final ik.l<CFGEntityList, z1> lVar2 = new ik.l<CFGEntityList, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadCloudSharedConfig$4
                {
                    super(1);
                }

                public final void b(CFGEntityList cFGEntityList) {
                    this.this$0.J0().o(new Pair<>(cFGEntityList, ""));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(CFGEntityList cFGEntityList) {
                    b(cFGEntityList);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.a0
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.s0(lVar2, obj);
                }
            };
            final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadCloudSharedConfig$5
                {
                    super(1);
                }

                public final void b(Throwable th2) {
                    androidx.lifecycle.j0<Pair<CFGEntityList, String>> j0VarJ0 = this.this$0.J0();
                    String message = th2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    j0VarJ0.o(new Pair<>(null, message));
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarS02.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.q0
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.t0(lVar3, obj);
                }
            });
        }

        public final void p1(int i10) {
            EntitySimpleConfig entitySimpleConfig;
            ArrayList<EntitySimpleConfig> arrayListF = this.f15418i.f();
            if (arrayListF == null || (entitySimpleConfig = arrayListF.get(i10)) == null) {
                return;
            }
            final EntitySimpleConfig entitySimpleConfig2 = new EntitySimpleConfig();
            entitySimpleConfig2.setCfgEntity(entitySimpleConfig.getCfgEntity().copy());
            entitySimpleConfig2.setName(entitySimpleConfig.getName());
            entitySimpleConfig2.setVersion(entitySimpleConfig.getVersion());
            xi.z zVarM3 = xi.z.m3(e6.z.f0(entitySimpleConfig2));
            final SyncConfigViewModel$uploadConfigForShare$1$1 syncConfigViewModel$uploadConfigForShare$1$1 = new ik.l<File, xi.e0<? extends String>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfigForShare$1$1
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final xi.e0<? extends String> i(@yt.k File file) {
                    kotlin.jvm.internal.f0.p(file, "file");
                    return u9.k.f(file, DataConstant.UPYUN_BUCKET);
                }
            };
            xi.z zVarL2 = zVarM3.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.s0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return SyncConfigViewModel.q1(syncConfigViewModel$uploadConfigForShare$1$1, obj);
                }
            });
            final ik.l<String, ConfigUploadBean> lVar = new ik.l<String, ConfigUploadBean>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfigForShare$1$2
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
                @Override // ik.l
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final com.flydigi.data.bean.ConfigUploadBean i(@yt.k java.lang.String r4) {
                    /*
                        r3 = this;
                        java.lang.String r0 = "url"
                        kotlin.jvm.internal.f0.p(r4, r0)
                        com.flydigi.data.bean.ConfigUploadBean r0 = new com.flydigi.data.bean.ConfigUploadBean
                        r0.<init>()
                        com.flydigi.data.bean.EntitySimpleConfig r1 = r1
                        java.lang.String r2 = r1.getName()
                        r0.title = r2
                        int r2 = r1.getVersion()
                        r0.version = r2
                        r0.url = r4
                        com.flydigi.sdk.gamepad.extension.config.data.CFGEntity r4 = r1.getCfgEntity()
                        java.lang.String r4 = r4.getGamepad()
                        if (r4 != 0) goto L3b
                        int r4 = r1.getVersion()
                        r1 = 1
                        java.lang.String r2 = "apex"
                        if (r4 == r1) goto L3a
                        r1 = 2
                        if (r4 == r1) goto L37
                        r1 = 3
                        if (r4 == r1) goto L34
                        goto L3a
                    L34:
                        java.lang.String r4 = "wasp2"
                        goto L3b
                    L37:
                        java.lang.String r4 = "q1"
                        goto L3b
                    L3a:
                        r4 = r2
                    L3b:
                        r0.setGamepad(r4)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfigForShare$1$2.i(java.lang.String):com.flydigi.data.bean.ConfigUploadBean");
                }
            };
            xi.z zVarA3 = zVarL2.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.i0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return SyncConfigViewModel.r1(lVar, obj);
                }
            });
            final SyncConfigViewModel$uploadConfigForShare$1$3 syncConfigViewModel$uploadConfigForShare$1$3 = new SyncConfigViewModel$uploadConfigForShare$1$3(this);
            xi.z zVarS0 = zVarA3.M5(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.t0
                @Override // dj.o
                public final Object apply(Object obj) {
                    return SyncConfigViewModel.s1(syncConfigViewModel$uploadConfigForShare$1$3, obj);
                }
            }).s0(o5.l.d());
            final SyncConfigViewModel$uploadConfigForShare$1$4 syncConfigViewModel$uploadConfigForShare$1$4 = new SyncConfigViewModel$uploadConfigForShare$1$4(this.f15426q);
            dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.x
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.t1(syncConfigViewModel$uploadConfigForShare$1$4, obj);
                }
            };
            final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$uploadConfigForShare$1$5
                {
                    super(1);
                }

                public final void b(Throwable th2) {
                    this.this$0.S0().o(null);
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarS0.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.b1
                @Override // dj.g
                public final void accept(Object obj) {
                    SyncConfigViewModel.u1(lVar2, obj);
                }
            });
        }

        public final void v0(@yt.k int[] selectedPositions, boolean z10) {
            kotlin.jvm.internal.f0.p(selectedPositions, "selectedPositions");
            final LocalGameBean localGameBeanF = this.f15413d.f();
            if (localGameBeanF != null) {
                xi.z<CFGEntityList> zVarN0 = e6.z.n0(localGameBeanF.localPackageName, localGameBeanF.standardPackageName);
                final SyncConfigViewModel$downloadConfig$1$1 syncConfigViewModel$downloadConfig$1$1 = new SyncConfigViewModel$downloadConfig$1$1(this, selectedPositions, z10);
                xi.z zVarL1 = zVarN0.l2(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.l0
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return SyncConfigViewModel.w0(syncConfigViewModel$downloadConfig$1$1, obj);
                    }
                }).x3().L1();
                final ik.l<CFGEntityList, xi.e0<? extends File>> lVar = new ik.l<CFGEntityList, xi.e0<? extends File>>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadConfig$1$2
                    {
                        super(1);
                    }

                    @Override // ik.l
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final xi.e0<? extends File> i(@yt.k CFGEntityList it2) {
                        kotlin.jvm.internal.f0.p(it2, "it");
                        return e6.z.w0(it2, localGameBeanF.localPackageName);
                    }
                };
                xi.z zVarB4 = zVarL1.M5(new dj.o() { // from class: com.flydigi.device_manager.ui.sync.u0
                    @Override // dj.o
                    public final Object apply(Object obj) {
                        return SyncConfigViewModel.x0(lVar, obj);
                    }
                }).b4(aj.a.c());
                final ik.l<File, z1> lVar2 = new ik.l<File, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadConfig$1$3
                    {
                        super(1);
                    }

                    public final void b(File file) {
                        this.this$0.f15417h.z();
                        this.this$0.I0().o(new Pair<>(Boolean.TRUE, ""));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(File file) {
                        b(file);
                        return z1.f38230a;
                    }
                };
                dj.g gVar = new dj.g() { // from class: com.flydigi.device_manager.ui.sync.y0
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.y0(lVar2, obj);
                    }
                };
                final ik.l<Throwable, z1> lVar3 = new ik.l<Throwable, z1>() { // from class: com.flydigi.device_manager.ui.sync.SyncConfigViewModel$downloadConfig$1$4
                    {
                        super(1);
                    }

                    public final void b(Throwable th2) {
                        androidx.lifecycle.j0<Pair<Boolean, String>> j0VarI0 = this.this$0.I0();
                        Boolean bool = Boolean.FALSE;
                        String message = th2.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        j0VarI0.o(new Pair<>(bool, message));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                        b(th2);
                        return z1.f38230a;
                    }
                };
                zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.device_manager.ui.sync.z0
                    @Override // dj.g
                    public final void accept(Object obj) {
                        SyncConfigViewModel.A0(lVar3, obj);
                    }
                });
            }
        }
    }
