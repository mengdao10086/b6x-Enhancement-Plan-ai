package com.permissionx.guolindev.request;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import bg.c;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.permissionx.guolindev.dialog.RationaleDialogFragment;
import com.umeng.analytics.pro.an;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001:B7\u0012\b\u0010d\u001a\u0004\u0018\u000109\u0012\b\u0010D\u001a\u0004\u0018\u00010A\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\b0L\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0L¢\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0003J\u0016\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u0000J\u0016\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0017J>\u0010 \u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u001e\u0010#\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020!J\u001e\u0010&\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$J\u001c\u0010(\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u00100\u001a\u00020\u001bJ\u0006\u00101\u001a\u00020\u001bJ\u0006\u00102\u001a\u00020\u001bJ\u0006\u00103\u001a\u00020\u001bJ\u0006\u00104\u001a\u00020\u001bJ\u0006\u00105\u001a\u00020\u001bJ\u0006\u00106\u001a\u00020\u001bJ\u000f\u00107\u001a\u00020\u0002H\u0000¢\u0006\u0004\b7\u00108R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00101R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00101R\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u00101R\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b7\u0010JR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010MR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010MR\u0016\u0010Q\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010PR\u0016\u0010S\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bR\u0010PR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bT\u0010MR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bV\u0010MR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010MR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010MR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010MR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010MR\u0014\u0010^\u001a\u00020\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010]R\u0014\u0010a\u001a\u00020_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010`R\u0011\u0010c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\bV\u0010b¨\u0006g"}, d2 = {"Lcom/permissionx/guolindev/request/t;", "", "Lkotlin/z1;", i1.a.R4, "q", i1.a.W4, m0.k.f40564b, "", "", "permissions", "h", "Lcg/a;", "callback", "n", "Lcg/b;", "o", "Lcg/c;", "p", "g", "", "lightColor", "darkColor", "C", "Lcg/d;", SsManifestParser.e.J, "Lcom/permissionx/guolindev/request/b;", "chainTask", "", "showReasonOrGoSettings", "message", "positiveText", "negativeText", "M", "Leg/c;", "dialog", "L", "Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;", "dialogFragment", "K", "", "x", an.aB, "y", an.aD, "v", "u", "w", "t", "D", "I", "J", "G", "F", "H", i1.a.S4, "f", "()V", "Landroidx/fragment/app/g;", "a", "Landroidx/fragment/app/g;", "i", "()Landroidx/fragment/app/g;", "B", "(Landroidx/fragment/app/g;)V", androidx.appcompat.widget.c.f2369r, "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "fragment", "c", "d", "e", "originRequestOrientation", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "currentDialog", "", "Ljava/util/Set;", "normalPermissions", "specialPermissions", "Z", "explainReasonBeforeRequest", xf.j.f55230b, "showDialogCalled", "k", "permissionsWontRequest", com.flydigi.sdk.bluetooth.l.f16298a, "grantedPermissions", "deniedPermissions", "permanentDeniedPermissions", "tempPermanentDeniedPermissions", "forwardPermissions", "Landroidx/fragment/app/FragmentManager;", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/permissionx/guolindev/request/InvisibleFragment;", "()Lcom/permissionx/guolindev/request/InvisibleFragment;", "invisibleFragment", "()I", "targetSdkVersion", "fragmentActivity", "<init>", "(Landroidx/fragment/app/g;Landroidx/fragment/app/Fragment;Ljava/util/Set;Ljava/util/Set;)V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class t {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public static final a f22132u = new a(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @yt.k
    public static final String f22133v = "InvisibleFragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.fragment.app.g f22134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public Fragment f22135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.l
    public Dialog f22139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hk.e
    public boolean f22142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hk.e
    public boolean f22143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @hk.e
    @yt.k
    public Set<String> f22149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @hk.e
    @yt.l
    public cg.d f22150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @hk.e
    @yt.l
    public cg.a f22151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @hk.e
    @yt.l
    public cg.b f22152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @hk.e
    @yt.l
    public cg.c f22153t;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/permissionx/guolindev/request/t$a;", "", "", "FRAGMENT_TAG", "Ljava/lang/String;", "<init>", "()V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public t(@yt.l androidx.fragment.app.g gVar, @yt.l Fragment fragment, @yt.k Set<String> normalPermissions, @yt.k Set<String> specialPermissions) {
        f0.p(normalPermissions, "normalPermissions");
        f0.p(specialPermissions, "specialPermissions");
        this.f22136c = -1;
        this.f22137d = -1;
        this.f22138e = -1;
        this.f22144k = new LinkedHashSet();
        this.f22145l = new LinkedHashSet();
        this.f22146m = new LinkedHashSet();
        this.f22147n = new LinkedHashSet();
        this.f22148o = new LinkedHashSet();
        this.f22149p = new LinkedHashSet();
        if (gVar != null) {
            B(gVar);
        }
        if (gVar == null && fragment != null) {
            androidx.fragment.app.g gVarP4 = fragment.P4();
            f0.o(gVarP4, "fragment.requireActivity()");
            B(gVarP4);
        }
        this.f22135b = fragment;
        this.f22140g = normalPermissions;
        this.f22141h = specialPermissions;
    }

    public static final void N(eg.c dialog, boolean z10, b chainTask, List permissions, t this$0, View view) {
        f0.p(dialog, "$dialog");
        f0.p(chainTask, "$chainTask");
        f0.p(permissions, "$permissions");
        f0.p(this$0, "this$0");
        dialog.dismiss();
        if (z10) {
            chainTask.V(permissions);
        } else {
            this$0.h(permissions);
        }
    }

    public static final void O(eg.c dialog, b chainTask, View view) {
        f0.p(dialog, "$dialog");
        f0.p(chainTask, "$chainTask");
        dialog.dismiss();
        chainTask.U();
    }

    public static final void P(t this$0, DialogInterface dialogInterface) {
        f0.p(this$0, "this$0");
        this$0.f22139f = null;
    }

    public static final void Q(RationaleDialogFragment dialogFragment, boolean z10, b chainTask, List permissions, t this$0, View view) {
        f0.p(dialogFragment, "$dialogFragment");
        f0.p(chainTask, "$chainTask");
        f0.p(permissions, "$permissions");
        f0.p(this$0, "this$0");
        dialogFragment.H5();
        if (z10) {
            chainTask.V(permissions);
        } else {
            this$0.h(permissions);
        }
    }

    public static final void R(RationaleDialogFragment dialogFragment, b chainTask, View view) {
        f0.p(dialogFragment, "$dialogFragment");
        f0.p(chainTask, "$chainTask");
        dialogFragment.H5();
        chainTask.U();
    }

    public final void A() {
        if (Build.VERSION.SDK_INT != 26) {
            i().setRequestedOrientation(this.f22138e);
        }
    }

    public final void B(@yt.k androidx.fragment.app.g gVar) {
        f0.p(gVar, "<set-?>");
        this.f22134a = gVar;
    }

    @yt.k
    public final t C(int i10, int i11) {
        this.f22136c = i10;
        this.f22137d = i11;
        return this;
    }

    public final boolean D() {
        return this.f22141h.contains(u.f22155f);
    }

    public final boolean E() {
        return this.f22141h.contains(v.f22157f);
    }

    public final boolean F() {
        return this.f22141h.contains(x.f22161f);
    }

    public final boolean G() {
        return this.f22141h.contains(y.f22163f);
    }

    public final boolean H() {
        return this.f22141h.contains(c.a.f9430a);
    }

    public final boolean I() {
        return this.f22141h.contains("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public final boolean J() {
        return this.f22141h.contains("android.permission.WRITE_SETTINGS");
    }

    public final void K(@yt.k final b chainTask, final boolean z10, @yt.k final RationaleDialogFragment dialogFragment) {
        f0.p(chainTask, "chainTask");
        f0.p(dialogFragment, "dialogFragment");
        this.f22143j = true;
        final List<String> listC6 = dialogFragment.c6();
        f0.o(listC6, "dialogFragment.permissionsToRequest");
        if (listC6.isEmpty()) {
            chainTask.U();
            return;
        }
        dialogFragment.a6(j(), "PermissionXRationaleDialogFragment");
        View viewD6 = dialogFragment.d6();
        f0.o(viewD6, "dialogFragment.positiveButton");
        View viewB6 = dialogFragment.b6();
        dialogFragment.U5(false);
        viewD6.setClickable(true);
        viewD6.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.Q(dialogFragment, z10, chainTask, listC6, this, view);
            }
        });
        if (viewB6 != null) {
            viewB6.setClickable(true);
            viewB6.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.R(dialogFragment, chainTask, view);
                }
            });
        }
    }

    public final void L(@yt.k final b chainTask, final boolean z10, @yt.k final eg.c dialog) {
        f0.p(chainTask, "chainTask");
        f0.p(dialog, "dialog");
        this.f22143j = true;
        final List<String> listB = dialog.b();
        f0.o(listB, "dialog.permissionsToRequest");
        if (listB.isEmpty()) {
            chainTask.U();
            return;
        }
        this.f22139f = dialog;
        dialog.show();
        if ((dialog instanceof eg.a) && ((eg.a) dialog).f()) {
            dialog.dismiss();
            chainTask.U();
        }
        View viewC = dialog.c();
        f0.o(viewC, "dialog.positiveButton");
        View viewA = dialog.a();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        viewC.setClickable(true);
        viewC.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.N(dialog, z10, chainTask, listB, this, view);
            }
        });
        if (viewA != null) {
            viewA.setClickable(true);
            viewA.setOnClickListener(new View.OnClickListener() { // from class: com.permissionx.guolindev.request.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t.O(dialog, chainTask, view);
                }
            });
        }
        Dialog dialog2 = this.f22139f;
        if (dialog2 != null) {
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.permissionx.guolindev.request.o
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    t.P(this.f22117a, dialogInterface);
                }
            });
        }
    }

    public final void M(@yt.k b chainTask, boolean z10, @yt.k List<String> permissions, @yt.k String message, @yt.k String positiveText, @yt.l String str) {
        f0.p(chainTask, "chainTask");
        f0.p(permissions, "permissions");
        f0.p(message, "message");
        f0.p(positiveText, "positiveText");
        L(chainTask, z10, new eg.a(i(), permissions, message, positiveText, str, this.f22136c, this.f22137d));
    }

    public final void S() {
        m();
        w wVar = new w();
        wVar.a(new z(this));
        wVar.a(new u(this));
        wVar.a(new b0(this));
        wVar.a(new c0(this));
        wVar.a(new y(this));
        wVar.a(new x(this));
        wVar.a(new a0(this));
        wVar.a(new v(this));
        wVar.b();
    }

    public final void f() {
        q();
        A();
    }

    @yt.k
    public final t g() {
        this.f22142i = true;
        return this;
    }

    public final void h(List<String> list) {
        this.f22149p.clear();
        this.f22149p.addAll(list);
        k().Z5();
    }

    @yt.k
    public final androidx.fragment.app.g i() {
        androidx.fragment.app.g gVar = this.f22134a;
        if (gVar != null) {
            return gVar;
        }
        f0.S(androidx.appcompat.widget.c.f2369r);
        return null;
    }

    public final FragmentManager j() {
        Fragment fragment = this.f22135b;
        FragmentManager fragmentManagerU1 = fragment != null ? fragment.U1() : null;
        if (fragmentManagerU1 != null) {
            return fragmentManagerU1;
        }
        FragmentManager fragmentManagerN3 = i().n3();
        f0.o(fragmentManagerN3, "activity.supportFragmentManager");
        return fragmentManagerN3;
    }

    public final InvisibleFragment k() {
        Fragment fragmentS0 = j().s0(f22133v);
        if (fragmentS0 != null) {
            return (InvisibleFragment) fragmentS0;
        }
        InvisibleFragment invisibleFragment = new InvisibleFragment();
        j().u().k(invisibleFragment, f22133v).t();
        return invisibleFragment;
    }

    public final int l() {
        return i().getApplicationInfo().targetSdkVersion;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void m() {
        if (Build.VERSION.SDK_INT != 26) {
            this.f22138e = i().getRequestedOrientation();
            int i10 = i().getResources().getConfiguration().orientation;
            if (i10 == 1) {
                i().setRequestedOrientation(7);
            } else {
                if (i10 != 2) {
                    return;
                }
                i().setRequestedOrientation(6);
            }
        }
    }

    @yt.k
    public final t n(@yt.l cg.a aVar) {
        this.f22151r = aVar;
        return this;
    }

    @yt.k
    public final t o(@yt.l cg.b bVar) {
        this.f22152s = bVar;
        return this;
    }

    @yt.k
    public final t p(@yt.l cg.c cVar) {
        this.f22153t = cVar;
        return this;
    }

    public final void q() {
        Fragment fragmentS0 = j().s0(f22133v);
        if (fragmentS0 != null) {
            j().u().B(fragmentS0).t();
        }
    }

    public final void r(@yt.l cg.d dVar) {
        this.f22150q = dVar;
        S();
    }

    public final void s(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().l6(this, chainTask);
    }

    public final void t(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().o6(this, chainTask);
    }

    public final void u(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().q6(this, chainTask);
    }

    public final void v(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().s6(this, chainTask);
    }

    public final void w(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().v6(this, chainTask);
    }

    public final void x(@yt.k Set<String> permissions, @yt.k b chainTask) {
        f0.p(permissions, "permissions");
        f0.p(chainTask, "chainTask");
        k().w6(this, permissions, chainTask);
    }

    public final void y(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().y6(this, chainTask);
    }

    public final void z(@yt.k b chainTask) {
        f0.p(chainTask, "chainTask");
        k().A6(this, chainTask);
    }
}
