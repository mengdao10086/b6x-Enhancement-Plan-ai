package f;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import f.a;
import g.v0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.d1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import qk.v;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    public static class a extends f.a<Uri, Boolean> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k Uri input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            f0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Boolean> b(@yt.k Context context, @yt.k Uri input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Boolean c(int i10, @yt.l Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$GetContent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    public static class c extends f.a<String, Uri> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            f0.o(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Uri> b(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @v0(18)
    public static class d extends f.a<String, List<Uri>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f27339a = new a(null);

        @v0(18)
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @yt.k
            public final List<Uri> a(@yt.k Intent intent) {
                f0.p(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt__CollectionsKt.E();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i10 = 0; i10 < itemCount; i10++) {
                        Uri uri = clipData.getItemAt(i10).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }
        }

        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            f0.o(intentPutExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return intentPutExtra;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<List<Uri>> b(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final List<Uri> c(int i10, @yt.l Intent intent) {
            List<Uri> listA;
            if (!(i10 == -1)) {
                intent = null;
            }
            return (intent == null || (listA = f27339a.a(intent)) == null) ? CollectionsKt__CollectionsKt.E() : listA;
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @v0(19)
    public static class e extends f.a<String[], Uri> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String[] input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            f0.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Uri> b(@yt.k Context context, @yt.k String[] input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @v0(21)
    public static class f extends f.a<Uri, Uri> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.l Uri uri) {
            f0.p(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Uri> b(@yt.k Context context, @yt.l Uri uri) {
            f0.p(context, "context");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @v0(19)
    public static class g extends f.a<String[], List<Uri>> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String[] input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            f0.o(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<List<Uri>> b(@yt.k Context context, @yt.k String[] input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final List<Uri> c(int i10, @yt.l Intent intent) {
            List<Uri> listA;
            if (!(i10 == -1)) {
                intent = null;
            }
            return (intent == null || (listA = d.f27339a.a(intent)) == null) ? CollectionsKt__CollectionsKt.E() : listA;
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickContact\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    public static final class h extends f.a<Void, Uri> {
        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.l Void r22) {
            f0.p(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            f0.o(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Uri c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @v0(19)
    public static class j extends f.a<androidx.activity.result.j, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f27342a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final String f27343b = "androidx.activity.result.contract.action.PICK_IMAGES";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public static final String f27344c = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public static final String f27345d = "com.google.android.gms.provider.action.PICK_IMAGES";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public static final String f27346e = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            public static /* synthetic */ void a() {
            }

            public static /* synthetic */ void b() {
            }

            @hk.m
            @yt.l
            public final ResolveInfo c(@yt.k Context context) {
                f0.p(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(j.f27345d), 1114112);
            }

            @hk.m
            @yt.l
            public final ResolveInfo d(@yt.k Context context) {
                f0.p(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(j.f27343b), 1114112);
            }

            @yt.l
            public final String e(@yt.k f input) {
                f0.p(input, "input");
                if (input instanceof c) {
                    return "image/*";
                }
                if (input instanceof e) {
                    return "video/*";
                }
                if (input instanceof d) {
                    return ((d) input).a();
                }
                if (input instanceof C0317b) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }

            @hk.m
            public final boolean f(@yt.k Context context) {
                f0.p(context, "context");
                return c(context) != null;
            }

            @hk.m
            @kotlin.k(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @kotlin.t0(expression = "isPhotoPickerAvailable(context)", imports = {}))
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean g() {
                return j();
            }

            @hk.m
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean h(@yt.k Context context) {
                f0.p(context, "context");
                return j() || i(context) || f(context);
            }

            @hk.m
            public final boolean i(@yt.k Context context) {
                f0.p(context, "context");
                return d(context) != null;
            }

            @hk.m
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean j() {
                int i10 = Build.VERSION.SDK_INT;
                return i10 >= 33 || (i10 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2);
            }
        }

        /* JADX INFO: renamed from: f.b$j$b, reason: collision with other inner class name */
        public static final class C0317b implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.k
            public static final C0317b f27347a = new C0317b();
        }

        public static final class c implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.k
            public static final c f27348a = new c();
        }

        public static final class d implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.k
            public final String f27349a;

            public d(@yt.k String mimeType) {
                f0.p(mimeType, "mimeType");
                this.f27349a = mimeType;
            }

            @yt.k
            public final String a() {
                return this.f27349a;
            }
        }

        public static final class e implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.k
            public static final e f27350a = new e();
        }

        public interface f {
        }

        @hk.m
        @yt.l
        public static final ResolveInfo e(@yt.k Context context) {
            return f27342a.c(context);
        }

        @hk.m
        @yt.l
        public static final ResolveInfo g(@yt.k Context context) {
            return f27342a.d(context);
        }

        @hk.m
        public static final boolean h(@yt.k Context context) {
            return f27342a.f(context);
        }

        @hk.m
        @kotlin.k(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @kotlin.t0(expression = "isPhotoPickerAvailable(context)", imports = {}))
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean i() {
            return f27342a.g();
        }

        @hk.m
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean j(@yt.k Context context) {
            return f27342a.h(context);
        }

        @hk.m
        public static final boolean k(@yt.k Context context) {
            return f27342a.i(context);
        }

        @hk.m
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean l() {
            return f27342a.j();
        }

        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k androidx.activity.result.j input) {
            Intent intent;
            f0.p(context, "context");
            f0.p(input, "input");
            a aVar = f27342a;
            if (aVar.j()) {
                Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
                intent2.setType(aVar.e(input.a()));
                return intent2;
            }
            if (aVar.i(context)) {
                ResolveInfo resolveInfoD = aVar.d(context);
                if (resolveInfoD == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                ActivityInfo activityInfo = resolveInfoD.activityInfo;
                intent = new Intent(f27343b);
                intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.setType(aVar.e(input.a()));
            } else {
                if (!aVar.f(context)) {
                    Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent3.setType(aVar.e(input.a()));
                    if (intent3.getType() != null) {
                        return intent3;
                    }
                    intent3.setType("*/*");
                    intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                    return intent3;
                }
                ResolveInfo resolveInfoC = aVar.c(context);
                if (resolveInfoC == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                ActivityInfo activityInfo2 = resolveInfoC.activityInfo;
                intent = new Intent(f27345d);
                intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent.setType(aVar.e(input.a()));
            }
            return intent;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Uri> b(@yt.k Context context, @yt.k androidx.activity.result.j input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            if (data == null) {
                data = (Uri) CollectionsKt___CollectionsKt.B2(d.f27339a.a(intent));
            }
            return data;
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,959:1\n12541#2,2:960\n8676#2,2:962\n9358#2,4:964\n11365#2:968\n11700#2,3:969\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions\n*L\n188#1:960,2\n195#1:962,2\n195#1:964,4\n208#1:968\n208#1:969,3\n*E\n"})
    public static final class k extends f.a<String[], Map<String, Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f27351a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final String f27352b = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public static final String f27353c = "androidx.activity.result.contract.extra.PERMISSIONS";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public static final String f27354d = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @yt.k
            public final Intent a(@yt.k String[] input) {
                f0.p(input, "input");
                Intent intentPutExtra = new Intent(k.f27352b).putExtra(k.f27353c, input);
                f0.o(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            }
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String[] input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return f27351a.a(input);
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a.C0315a<Map<String, Boolean>> b(@yt.k Context context, @yt.k String[] input) {
            f0.p(context, "context");
            f0.p(input, "input");
            boolean z10 = true;
            if (input.length == 0) {
                return new a.C0315a<>(s0.z());
            }
            int length = input.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (!(h0.d.a(context, input[i10]) == 0)) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (!z10) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(v.u(r0.j(input.length), 16));
            for (String str : input) {
                Pair pairA = d1.a(str, Boolean.TRUE);
                linkedHashMap.put(pairA.f(), pairA.h());
            }
            return new a.C0315a<>(linkedHashMap);
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<String, Boolean> c(int i10, @yt.l Intent intent) {
            if (i10 != -1) {
                return s0.z();
            }
            if (intent == null) {
                return s0.z();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(f27353c);
            int[] intArrayExtra = intent.getIntArrayExtra(f27354d);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return s0.z();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i11 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i11 == 0));
            }
            return s0.B0(CollectionsKt___CollectionsKt.d6(ArraysKt___ArraysKt.ub(stringArrayExtra), arrayList));
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,959:1\n12774#2,2:960\n*S KotlinDebug\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$RequestPermission\n*L\n228#1:960,2\n*E\n"})
    public static final class l extends f.a<String, Boolean> {
        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return k.f27351a.a(new String[]{input});
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a.C0315a<Boolean> b(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            if (h0.d.a(context, input) == 0) {
                return new a.C0315a<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0026  */
        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Boolean c(int r5, @yt.l android.content.Intent r6) {
            /*
                r4 = this;
                if (r6 == 0) goto L2c
                r0 = -1
                if (r5 == r0) goto L6
                goto L2c
            L6:
                java.lang.String r5 = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS"
                int[] r5 = r6.getIntArrayExtra(r5)
                r6 = 1
                r0 = 0
                if (r5 == 0) goto L26
                int r1 = r5.length
                r2 = 0
            L12:
                if (r2 >= r1) goto L22
                r3 = r5[r2]
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 == 0) goto L1f
                r5 = 1
                goto L23
            L1f:
                int r2 = r2 + 1
                goto L12
            L22:
                r5 = 0
            L23:
                if (r5 != r6) goto L26
                goto L27
            L26:
                r6 = 0
            L27:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
                return r5
            L2c:
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: f.b.l.c(int, android.content.Intent):java.lang.Boolean");
        }
    }

    public static final class m extends f.a<Intent, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f27355a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final String f27356b = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k Intent input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return input;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, @yt.l Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static final class n extends f.a<IntentSenderRequest, ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f27357a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final String f27358b = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public static final String f27359c = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public static final String f27360d = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k IntentSenderRequest input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent intentPutExtra = new Intent(f27358b).putExtra(f27359c, input);
            f0.o(intentPutExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return intentPutExtra;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, @yt.l Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static class o extends f.a<Uri, Boolean> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k Uri input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            f0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Boolean> b(@yt.k Context context, @yt.k Uri input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Boolean c(int i10, @yt.l Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    public static class p extends f.a<Void, Bitmap> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.l Void r22) {
            f0.p(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Bitmap> b(@yt.k Context context, @yt.l Void r22) {
            f0.p(context, "context");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Bitmap c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$TakeVideo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @kotlin.k(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class q extends f.a<Uri, Bitmap> {
        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k Uri input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent intentPutExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            f0.o(intentPutExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return intentPutExtra;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Bitmap> b(@yt.k Context context, @yt.k Uri input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Bitmap c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: f.b$b, reason: collision with other inner class name */
    @t0({"SMAP\nActivityResultContracts.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultContracts.kt\nandroidx/activity/result/contract/ActivityResultContracts$CreateDocument\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,959:1\n1#2:960\n*E\n"})
    @v0(19)
    public static class C0316b extends f.a<String, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final String f27338a;

        public C0316b(@yt.k String mimeType) {
            f0.p(mimeType, "mimeType");
            this.f27338a = mimeType;
        }

        @Override // f.a
        @g.i
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.f27338a).putExtra("android.intent.extra.TITLE", input);
            f0.o(intentPutExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return intentPutExtra;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<Uri> b(@yt.k Context context, @yt.k String input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Uri c(int i10, @yt.l Intent intent) {
            if (!(i10 == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @kotlin.k(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @kotlin.t0(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public C0316b() {
            this("*/*");
        }
    }

    @v0(19)
    public static class i extends f.a<androidx.activity.result.j, List<Uri>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final a f27340b = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f27341a;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int a() {
                if (j.f27342a.j()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }
        }

        public i() {
            this(0, 1, null);
        }

        public /* synthetic */ i(int i10, int i11, u uVar) {
            this((i11 & 1) != 0 ? f27340b.a() : i10);
        }

        @Override // f.a
        @g.i
        @yt.k
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@yt.k Context context, @yt.k androidx.activity.result.j input) {
            f0.p(context, "context");
            f0.p(input, "input");
            j.a aVar = j.f27342a;
            if (aVar.j()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(aVar.e(input.a()));
                if (!(this.f27341a <= MediaStore.getPickImagesMaxLimit())) {
                    throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f27341a);
                return intent;
            }
            if (aVar.i(context)) {
                ResolveInfo resolveInfoD = aVar.d(context);
                if (resolveInfoD == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                ActivityInfo activityInfo = resolveInfoD.activityInfo;
                Intent intent2 = new Intent(j.f27343b);
                intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent2.setType(aVar.e(input.a()));
                intent2.putExtra(j.f27346e, this.f27341a);
                return intent2;
            }
            if (aVar.f(context)) {
                ResolveInfo resolveInfoC = aVar.c(context);
                if (resolveInfoC == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                ActivityInfo activityInfo2 = resolveInfoC.activityInfo;
                Intent intent3 = new Intent(j.f27345d);
                intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                intent3.putExtra(j.f27346e, this.f27341a);
                return intent3;
            }
            Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent4.setType(aVar.e(input.a()));
            intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent4.getType() != null) {
                return intent4;
            }
            intent4.setType("*/*");
            intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent4;
        }

        @Override // f.a
        @yt.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final a.C0315a<List<Uri>> b(@yt.k Context context, @yt.k androidx.activity.result.j input) {
            f0.p(context, "context");
            f0.p(input, "input");
            return null;
        }

        @Override // f.a
        @yt.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final List<Uri> c(int i10, @yt.l Intent intent) {
            List<Uri> listA;
            if (!(i10 == -1)) {
                intent = null;
            }
            return (intent == null || (listA = d.f27339a.a(intent)) == null) ? CollectionsKt__CollectionsKt.E() : listA;
        }

        public i(int i10) {
            this.f27341a = i10;
            if (!(i10 > 1)) {
                throw new IllegalArgumentException("Max items must be higher than 1".toString());
            }
        }
    }
}
