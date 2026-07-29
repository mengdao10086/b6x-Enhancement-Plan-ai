package com.flydigi.userBehavior;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.AppConfigDTO;
import com.flydigi.data.bean.UserBehavior;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nUserBehaviorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserBehaviorManager.kt\ncom/flydigi/userBehavior/UserBehaviorManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n1#2:309\n*E\n"})
public final class UserBehaviorManager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final a f16361i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final String f16362j = j1.a().getCacheDir().getAbsolutePath() + "/ub";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Context f16363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final String f16364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final io.reactivex.disposables.a f16365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public ArrayList<UserBehavior> f16369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public ArrayList<UserBehavior> f16370h;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final String a() {
            return UserBehaviorManager.f16362j;
        }
    }

    public UserBehaviorManager(@yt.k Context context, @yt.l String str) {
        f0.p(context, "context");
        this.f16363a = context;
        this.f16364b = str;
        this.f16365c = new io.reactivex.disposables.a();
        this.f16366d = 30;
        this.f16367e = true;
        this.f16369g = new ArrayList<>();
        this.f16370h = new ArrayList<>();
    }

    public static final String A0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final void B0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void C0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void D0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void Q(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void R(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final ArrayList V(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (ArrayList) tmp0.i(obj);
    }

    public static final boolean Y(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return ((Boolean) tmp0.i(obj)).booleanValue();
    }

    public static final void Z(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final boolean a0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return ((Boolean) tmp0.i(obj)).booleanValue();
    }

    public static final ArrayList b0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (ArrayList) tmp0.i(obj);
    }

    public static final void c0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void d0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final File f0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (File) tmp0.i(obj);
    }

    public static final void g0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final String h0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final xi.e0 j0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final ArrayList l0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (ArrayList) tmp0.i(obj);
    }

    public static final String m0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final void n0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void o0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void p0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void q0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void s0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final String t0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (String) tmp0.i(obj);
    }

    public static final xi.e0 u0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final void v0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void w0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final xi.e0 y0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        return (xi.e0) tmp0.i(obj);
    }

    public static final void z0(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public final void P() {
        xi.z zVarB4 = ((h5.c) m5.f0.i().k().g(h5.c.class)).d().s0(m5.c0.p()).s0(m5.c0.t()).J5(lj.b.a()).b4(lj.b.a());
        final ik.l<AppConfigDTO, z1> lVar = new ik.l<AppConfigDTO, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$checkConfig$1
            {
                super(1);
            }

            public final void b(AppConfigDTO appConfigDTO) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("是否需要上报：");
                sb2.append(appConfigDTO.getShouldReport());
                sb2.append(",累积");
                sb2.append(appConfigDTO.getStatisticsBufferSize());
                sb2.append("条后上报");
                UserBehaviorManager userBehaviorManager = this.this$0;
                Integer statisticsBufferSize = appConfigDTO.getStatisticsBufferSize();
                f0.o(statisticsBufferSize, "it.statisticsBufferSize");
                userBehaviorManager.f16366d = statisticsBufferSize.intValue();
                UserBehaviorManager userBehaviorManager2 = this.this$0;
                Boolean shouldReport = appConfigDTO.getShouldReport();
                f0.o(shouldReport, "it.shouldReport");
                userBehaviorManager2.f16367e = shouldReport.booleanValue();
                o5.m mVarL = o5.m.l(DataConstant.SP_FLOAT, 2);
                Boolean shouldReport2 = appConfigDTO.getShouldReport();
                f0.o(shouldReport2, "it.shouldReport");
                mVarL.F(DataConstant.SP_REPORT_USER_BEHAVIOR, shouldReport2.booleanValue());
                o5.m mVarL2 = o5.m.l(DataConstant.SP_FLOAT, 2);
                Integer statisticsBufferSize2 = appConfigDTO.getStatisticsBufferSize();
                f0.o(statisticsBufferSize2, "it.statisticsBufferSize");
                mVarL2.x(DataConstant.SP_REPORT_USER_BEHAVIOR_COUNT, statisticsBufferSize2.intValue());
                Boolean shouldReport3 = appConfigDTO.getShouldReport();
                f0.o(shouldReport3, "it.shouldReport");
                if (shouldReport3.booleanValue()) {
                    this.this$0.X(true);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(AppConfigDTO appConfigDTO) {
                b(appConfigDTO);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.userBehavior.d0
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.Q(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$checkConfig$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f16367e = o5.m.l(DataConstant.SP_FLOAT, 2).e(DataConstant.SP_REPORT_USER_BEHAVIOR);
                this.this$0.f16366d = o5.m.l(DataConstant.SP_FLOAT, 2).m(DataConstant.SP_REPORT_USER_BEHAVIOR_COUNT);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f16365c.b(zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.userBehavior.e
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.R(lVar2, obj);
            }
        }));
    }

    @yt.l
    public final String S() {
        return this.f16364b;
    }

    @yt.k
    public final Context T() {
        return this.f16363a;
    }

    public final xi.z<ArrayList<UserBehavior>> U(String str) {
        xi.z zVarM3 = xi.z.m3(str);
        final UserBehaviorManager$parseJson$1 userBehaviorManager$parseJson$1 = new ik.l<String, ArrayList<UserBehavior>>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$parseJson$1

            public static final class a extends TypeToken<ArrayList<UserBehavior>> {
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ArrayList<UserBehavior> i(@yt.k String it2) {
                f0.p(it2, "it");
                try {
                    ArrayList<UserBehavior> arrayList = (ArrayList) m5.f0.i().h().fromJson(it2, new a().getType());
                    return arrayList == null ? new ArrayList<>() : arrayList;
                } catch (Exception unused) {
                    return new ArrayList<>();
                }
            }
        };
        xi.z<ArrayList<UserBehavior>> zVarJ5 = zVarM3.A3(new dj.o() { // from class: com.flydigi.userBehavior.n
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.V(userBehaviorManager$parseJson$1, obj);
            }
        }).J5(lj.b.a());
        f0.o(zVarJ5, "just(json)\n            .…Schedulers.computation())");
        return zVarJ5;
    }

    public final void W(@yt.l GamepadInfo gamepadInfo, @yt.k String action) {
        String deviceName;
        String firmwareVersion;
        String address;
        f0.p(action, "action");
        if (o5.m.l(DataConstant.SP_FLOAT, 2).f(DataConstant.SP_IS_USER_POLICY_ALLOWED, false)) {
            String str = "";
            String str2 = (gamepadInfo == null || (address = gamepadInfo.getAddress()) == null) ? "" : address;
            if (gamepadInfo == null || (deviceName = gamepadInfo.getDeviceName()) == null) {
                deviceName = "";
            }
            if (gamepadInfo == null || (firmwareVersion = gamepadInfo.getFirmwareVersion()) == null) {
                firmwareVersion = "";
            }
            String str3 = (gamepadInfo == null || !gamepadInfo.isConnected()) ? "未连接" : gamepadInfo.isFlashplayMode() ? "智连模式" : "传统模式";
            if (v5.a.j().m()) {
                String strH = v5.a.j().h();
                if (strH != null) {
                    str = strH;
                }
            } else {
                str = "未激活";
            }
            String str4 = com.blankj.utilcode.util.d.j() + '@' + com.blankj.utilcode.util.d.C() + '@' + this.f16364b + '@' + Process.myPid();
            String strB = com.blankj.utilcode.util.x.b();
            f0.o(strB, "getAndroidID()");
            UserBehavior userBehavior = new UserBehavior(str4, strB, com.blankj.utilcode.util.x.j() + '@' + com.blankj.utilcode.util.x.k() + '@' + Build.VERSION.RELEASE, str2, deviceName + '@' + firmwareVersion + '@' + str3 + '@' + str, action, System.currentTimeMillis());
            userBehavior.toString();
            x0(userBehavior);
        }
    }

    public final void X(final boolean z10) {
        this.f16368f = true;
        xi.z<ArrayList<UserBehavior>> zVarI0 = i0();
        final ik.l<ArrayList<UserBehavior>, Boolean> lVar = new ik.l<ArrayList<UserBehavior>, Boolean>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readAndUploadIfNeed$1
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                boolean z11 = n0.z(it2);
                if (!z11) {
                    this.this$0.f16368f = false;
                }
                return Boolean.valueOf(z11);
            }
        };
        xi.z<ArrayList<UserBehavior>> zVarH2 = zVarI0.h2(new dj.r() { // from class: com.flydigi.userBehavior.v
            @Override // dj.r
            public final boolean a(Object obj) {
                return UserBehaviorManager.Y(lVar, obj);
            }
        });
        final UserBehaviorManager$readAndUploadIfNeed$2 userBehaviorManager$readAndUploadIfNeed$2 = new ik.l<ArrayList<UserBehavior>, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readAndUploadIfNeed$2
            public final void b(ArrayList<UserBehavior> arrayList) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("当前共有");
                sb2.append(arrayList.size());
                sb2.append("条数据待上传");
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<UserBehavior> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        xi.z<ArrayList<UserBehavior>> zVarY1 = zVarH2.Y1(new dj.g() { // from class: com.flydigi.userBehavior.d
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.Z(userBehaviorManager$readAndUploadIfNeed$2, obj);
            }
        });
        final ik.l<ArrayList<UserBehavior>, Boolean> lVar2 = new ik.l<ArrayList<UserBehavior>, Boolean>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readAndUploadIfNeed$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                boolean z11 = (z10 && this.f16366d > 0) || (!z10 && it2.size() >= this.f16366d);
                if (!z11) {
                    this.f16368f = false;
                }
                return Boolean.valueOf(z11);
            }
        };
        xi.z<ArrayList<UserBehavior>> zVarH22 = zVarY1.h2(new dj.r() { // from class: com.flydigi.userBehavior.w
            @Override // dj.r
            public final boolean a(Object obj) {
                return UserBehaviorManager.a0(lVar2, obj);
            }
        });
        final ik.l<ArrayList<UserBehavior>, ArrayList<UserBehavior>> lVar3 = new ik.l<ArrayList<UserBehavior>, ArrayList<UserBehavior>>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readAndUploadIfNeed$4
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ArrayList<UserBehavior> i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                ArrayList<UserBehavior> arrayList = new ArrayList<>();
                Iterator<UserBehavior> it3 = it2.iterator();
                f0.o(it3, "it.iterator()");
                while (it3.hasNext()) {
                    UserBehavior next = it3.next();
                    f0.o(next, "iterator.next()");
                    UserBehavior userBehavior = next;
                    if (!this.this$0.f16370h.contains(userBehavior)) {
                        arrayList.add(userBehavior);
                    }
                }
                return arrayList;
            }
        };
        xi.z zVarB4 = zVarH22.A3(new dj.o() { // from class: com.flydigi.userBehavior.p
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.b0(lVar3, obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d());
        final ik.l<ArrayList<UserBehavior>, z1> lVar4 = new ik.l<ArrayList<UserBehavior>, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readAndUploadIfNeed$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(ArrayList<UserBehavior> it2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("内存中已有");
                sb2.append(this.this$0.f16370h.size());
                sb2.append("条数据");
                this.this$0.f16370h.addAll(it2);
                if (!z10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("已满");
                    sb3.append(this.this$0.f16366d);
                    sb3.append("条,开始上报");
                }
                UserBehaviorManager userBehaviorManager = this.this$0;
                f0.o(it2, "it");
                userBehaviorManager.r0(it2);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<UserBehavior> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.userBehavior.g
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.c0(lVar4, obj);
            }
        };
        final ik.l<Throwable, z1> lVar5 = new ik.l<Throwable, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readAndUploadIfNeed$6
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f16368f = false;
                th2.getMessage();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f16365c.b(zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.userBehavior.c0
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.d0(lVar5, obj);
            }
        }));
    }

    public final xi.z<String> e0() {
        xi.z zVarM3 = xi.z.m3(f16362j);
        final UserBehaviorManager$readLocalCachedUserBehavior$1 userBehaviorManager$readLocalCachedUserBehavior$1 = new ik.l<String, File>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readLocalCachedUserBehavior$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final File i(@yt.k String it2) {
                f0.p(it2, "it");
                return new File(it2);
            }
        };
        xi.z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.userBehavior.q
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.f0(userBehaviorManager$readLocalCachedUserBehavior$1, obj);
            }
        });
        final UserBehaviorManager$readLocalCachedUserBehavior$2 userBehaviorManager$readLocalCachedUserBehavior$2 = new ik.l<File, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readLocalCachedUserBehavior$2
            public final void b(File file) {
                com.blankj.utilcode.util.b0.m(file);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(File file) {
                b(file);
                return z1.f38230a;
            }
        };
        xi.z zVarY1 = zVarA3.Y1(new dj.g() { // from class: com.flydigi.userBehavior.x
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.g0(userBehaviorManager$readLocalCachedUserBehavior$2, obj);
            }
        });
        final UserBehaviorManager$readLocalCachedUserBehavior$3 userBehaviorManager$readLocalCachedUserBehavior$3 = new ik.l<File, String>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readLocalCachedUserBehavior$3
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k File it2) {
                f0.p(it2, "it");
                String strQ = com.blankj.utilcode.util.a0.q(it2);
                return strQ == null ? "" : strQ;
            }
        };
        xi.z<String> zVarJ5 = zVarY1.A3(new dj.o() { // from class: com.flydigi.userBehavior.s
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.h0(userBehaviorManager$readLocalCachedUserBehavior$3, obj);
            }
        }).J5(lj.b.g());
        f0.o(zVarJ5, "just(FILE_USER_BEHAVIOR)…beOn(Schedulers.single())");
        return zVarJ5;
    }

    public final xi.z<ArrayList<UserBehavior>> i0() {
        xi.z<String> zVarE0 = e0();
        final ik.l<String, xi.e0<? extends ArrayList<UserBehavior>>> lVar = new ik.l<String, xi.e0<? extends ArrayList<UserBehavior>>>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$readLocalCachedUserBehaviors$1
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends ArrayList<UserBehavior>> i(@yt.k String it2) {
                f0.p(it2, "it");
                return this.this$0.U(it2);
            }
        };
        xi.z<ArrayList<UserBehavior>> zVarJ5 = zVarE0.M0(new dj.o() { // from class: com.flydigi.userBehavior.j
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.j0(lVar, obj);
            }
        }).J5(lj.b.g());
        f0.o(zVarJ5, "private fun readLocalCac…chedulers.single())\n    }");
        return zVarJ5;
    }

    public final void k0(final ArrayList<UserBehavior> arrayList) {
        xi.z<ArrayList<UserBehavior>> zVarI0 = i0();
        final ik.l<ArrayList<UserBehavior>, ArrayList<UserBehavior>> lVar = new ik.l<ArrayList<UserBehavior>, ArrayList<UserBehavior>>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$removeFromLocalCached$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ArrayList<UserBehavior> i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("上报成功，开始删除本地数据,共");
                sb2.append(it2.size());
                sb2.append("条，需删除");
                sb2.append(arrayList.size());
                sb2.append((char) 26465);
                Iterator<UserBehavior> it3 = it2.iterator();
                f0.o(it3, "it.iterator()");
                while (it3.hasNext()) {
                    UserBehavior next = it3.next();
                    f0.o(next, "iterator.next()");
                    UserBehavior userBehavior = next;
                    if (arrayList.contains(userBehavior)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("删除本地已上报数据：[");
                        sb3.append(userBehavior.getAction());
                        sb3.append("] in ");
                        sb3.append(userBehavior.getTimestamp());
                        it3.remove();
                    }
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("本地剩余数据");
                sb4.append(it2.size());
                sb4.append((char) 26465);
                return it2;
            }
        };
        xi.z<R> zVarA3 = zVarI0.A3(new dj.o() { // from class: com.flydigi.userBehavior.r
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.l0(lVar, obj);
            }
        });
        final UserBehaviorManager$removeFromLocalCached$2 userBehaviorManager$removeFromLocalCached$2 = new ik.l<ArrayList<UserBehavior>, String>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$removeFromLocalCached$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                return m5.f0.i().h().toJson(it2);
            }
        };
        xi.z zVarA32 = zVarA3.A3(new dj.o() { // from class: com.flydigi.userBehavior.t
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.m0(userBehaviorManager$removeFromLocalCached$2, obj);
            }
        });
        final UserBehaviorManager$removeFromLocalCached$3 userBehaviorManager$removeFromLocalCached$3 = new ik.l<String, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$removeFromLocalCached$3
            public final void b(String str) {
                com.blankj.utilcode.util.a0.V(UserBehaviorManager.f16361i.a(), str);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        xi.z zVarY1 = zVarA32.Y1(new dj.g() { // from class: com.flydigi.userBehavior.m
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.n0(userBehaviorManager$removeFromLocalCached$3, obj);
            }
        });
        final ik.l<String, z1> lVar2 = new ik.l<String, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$removeFromLocalCached$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(String str) {
                Iterator it2 = this.this$0.f16370h.iterator();
                f0.o(it2, "uploadingData.iterator()");
                while (it2.hasNext()) {
                    Object next = it2.next();
                    f0.o(next, "iterator.next()");
                    UserBehavior userBehavior = (UserBehavior) next;
                    if (arrayList.contains(userBehavior)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("删除内存中的已上报数据：[");
                        sb2.append(userBehavior.getAction());
                        sb2.append("] in ");
                        sb2.append(userBehavior.getTimestamp());
                        it2.remove();
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("内存中剩余数据");
                sb3.append(this.this$0.f16370h.size());
                sb3.append((char) 26465);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        xi.z zVarB4 = zVarY1.Y1(new dj.g() { // from class: com.flydigi.userBehavior.z
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.o0(lVar2, obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d());
        final ik.l<String, z1> lVar3 = new ik.l<String, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$removeFromLocalCached$5
            {
                super(1);
            }

            public final void b(String str) {
                this.this$0.f16368f = false;
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.userBehavior.i
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.p0(lVar3, obj);
            }
        };
        final ik.l<Throwable, z1> lVar4 = new ik.l<Throwable, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$removeFromLocalCached$6
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f16368f = false;
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f16365c.b(zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.userBehavior.a0
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.q0(lVar4, obj);
            }
        }));
    }

    public final void r0(final ArrayList<UserBehavior> arrayList) {
        xi.z zVarM3 = xi.z.m3(arrayList);
        final UserBehaviorManager$uploadUserBehavior$1 userBehaviorManager$uploadUserBehavior$1 = new ik.l<ArrayList<UserBehavior>, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$uploadUserBehavior$1
            public final void b(ArrayList<UserBehavior> arrayList2) {
                for (UserBehavior userBehavior : arrayList2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("上报数据：[");
                    sb2.append(userBehavior.getAction());
                    sb2.append("] in ");
                    sb2.append(userBehavior.getTimestamp());
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<UserBehavior> arrayList2) {
                b(arrayList2);
                return z1.f38230a;
            }
        };
        xi.z zVarY1 = zVarM3.Y1(new dj.g() { // from class: com.flydigi.userBehavior.e0
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.s0(userBehaviorManager$uploadUserBehavior$1, obj);
            }
        });
        final UserBehaviorManager$uploadUserBehavior$2 userBehaviorManager$uploadUserBehavior$2 = new ik.l<ArrayList<UserBehavior>, String>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$uploadUserBehavior$2
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                return m5.f0.i().h().toJson(it2);
            }
        };
        xi.z zVarA3 = zVarY1.A3(new dj.o() { // from class: com.flydigi.userBehavior.o
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.t0(userBehaviorManager$uploadUserBehavior$2, obj);
            }
        });
        final UserBehaviorManager$uploadUserBehavior$3 userBehaviorManager$uploadUserBehavior$3 = new ik.l<String, xi.e0<? extends BaseResponse<Object>>>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$uploadUserBehavior$3
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends BaseResponse<Object>> i(@yt.k String it2) {
                f0.p(it2, "it");
                return ((h5.c) m5.f0.i().k().g(h5.c.class)).c(it2).J5(lj.b.a()).b4(lj.b.a());
            }
        };
        xi.z zVarB4 = zVarA3.l2(new dj.o() { // from class: com.flydigi.userBehavior.u
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.u0(userBehaviorManager$uploadUserBehavior$3, obj);
            }
        }).J5(lj.b.a()).b4(lj.b.a());
        final ik.l<BaseResponse<Object>, z1> lVar = new ik.l<BaseResponse<Object>, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$uploadUserBehavior$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BaseResponse<Object> baseResponse) {
                if (baseResponse.state == 0) {
                    this.this$0.k0(arrayList);
                } else {
                    this.this$0.f16368f = false;
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(BaseResponse<Object> baseResponse) {
                b(baseResponse);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.userBehavior.b
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.v0(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$uploadUserBehavior$5
            {
                super(1);
            }

            public final void b(Throwable th2) {
                this.this$0.f16368f = false;
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f16365c.b(zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.userBehavior.h
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.w0(lVar2, obj);
            }
        }));
    }

    public final void x0(UserBehavior userBehavior) {
        this.f16369g.add(userBehavior);
        if (this.f16368f) {
            return;
        }
        xi.z<String> zVarE0 = e0();
        final ik.l<String, xi.e0<? extends ArrayList<UserBehavior>>> lVar = new ik.l<String, xi.e0<? extends ArrayList<UserBehavior>>>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$writeUserBehaviorToLocalCache$1
            {
                super(1);
            }

            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final xi.e0<? extends ArrayList<UserBehavior>> i(@yt.k String it2) {
                f0.p(it2, "it");
                return this.this$0.U(it2);
            }
        };
        xi.z<R> zVarM0 = zVarE0.M0(new dj.o() { // from class: com.flydigi.userBehavior.k
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.y0(lVar, obj);
            }
        });
        final ik.l<ArrayList<UserBehavior>, z1> lVar2 = new ik.l<ArrayList<UserBehavior>, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$writeUserBehaviorToLocalCache$2
            {
                super(1);
            }

            public final void b(ArrayList<UserBehavior> arrayList) {
                arrayList.addAll(this.this$0.f16369g);
                this.this$0.f16369g.clear();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(ArrayList<UserBehavior> arrayList) {
                b(arrayList);
                return z1.f38230a;
            }
        };
        xi.z zVarY1 = zVarM0.Y1(new dj.g() { // from class: com.flydigi.userBehavior.b0
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.z0(lVar2, obj);
            }
        });
        final UserBehaviorManager$writeUserBehaviorToLocalCache$3 userBehaviorManager$writeUserBehaviorToLocalCache$3 = new ik.l<ArrayList<UserBehavior>, String>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$writeUserBehaviorToLocalCache$3
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k ArrayList<UserBehavior> it2) {
                f0.p(it2, "it");
                return m5.f0.i().h().toJson(it2);
            }
        };
        xi.z zVarA3 = zVarY1.A3(new dj.o() { // from class: com.flydigi.userBehavior.l
            @Override // dj.o
            public final Object apply(Object obj) {
                return UserBehaviorManager.A0(userBehaviorManager$writeUserBehaviorToLocalCache$3, obj);
            }
        });
        final UserBehaviorManager$writeUserBehaviorToLocalCache$4 userBehaviorManager$writeUserBehaviorToLocalCache$4 = new ik.l<String, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$writeUserBehaviorToLocalCache$4
            public final void b(String str) {
                com.blankj.utilcode.util.a0.V(UserBehaviorManager.f16361i.a(), str);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        xi.z zVarB4 = zVarA3.Y1(new dj.g() { // from class: com.flydigi.userBehavior.f
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.B0(userBehaviorManager$writeUserBehaviorToLocalCache$4, obj);
            }
        }).J5(lj.b.d()).b4(lj.b.d());
        final ik.l<String, z1> lVar3 = new ik.l<String, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$writeUserBehaviorToLocalCache$5
            {
                super(1);
            }

            public final void b(String str) {
                this.this$0.X(false);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(String str) {
                b(str);
                return z1.f38230a;
            }
        };
        dj.g gVar = new dj.g() { // from class: com.flydigi.userBehavior.c
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.C0(lVar3, obj);
            }
        };
        final UserBehaviorManager$writeUserBehaviorToLocalCache$6 userBehaviorManager$writeUserBehaviorToLocalCache$6 = new ik.l<Throwable, z1>() { // from class: com.flydigi.userBehavior.UserBehaviorManager$writeUserBehaviorToLocalCache$6
            public final void b(Throwable th2) {
                th2.getMessage();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        this.f16365c.b(zVarB4.F5(gVar, new dj.g() { // from class: com.flydigi.userBehavior.y
            @Override // dj.g
            public final void accept(Object obj) {
                UserBehaviorManager.D0(userBehaviorManager$writeUserBehaviorToLocalCache$6, obj);
            }
        }));
    }

    public /* synthetic */ UserBehaviorManager(Context context, String str, int i10, kotlin.jvm.internal.u uVar) {
        this(context, (i10 & 2) != 0 ? "official" : str);
    }
}
