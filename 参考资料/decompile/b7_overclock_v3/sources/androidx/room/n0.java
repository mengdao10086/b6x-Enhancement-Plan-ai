package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import c2.e;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final e.c f7480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Context f7481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.p0
    public final String f7482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final RoomDatabase.c f7483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.p0
    public final List<RoomDatabase.b> f7484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.p0
    public final RoomDatabase.d f7485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final List<Object> f7486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final List<z1.b> f7487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RoomDatabase.JournalMode f7489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.n0
    public final Executor f7490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g.n0
    public final Executor f7491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f7492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent f7493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f7494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f7495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Set<Integer> f7496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.p0
    public final String f7497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.p0
    public final File f7498s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g.p0
    public final Callable<InputStream> f7499t;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, boolean z11, @g.p0 Set<Integer> set) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor, false, z11, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.d) null, (List<Object>) null, (List<z1.b>) null);
    }

    public boolean a(int i10, int i11) {
        Set<Integer> set;
        return !((i10 > i11) && this.f7495p) && this.f7494o && ((set = this.f7496q) == null || !set.contains(Integer.valueOf(i10)));
    }

    @Deprecated
    public boolean b(int i10) {
        return a(i10, i10 + 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, boolean z11, boolean z12, boolean z13, @g.p0 Set<Integer> set) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor2, z11, z12, z13, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.d) null, (List<Object>) null, (List<z1.b>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, boolean z11, boolean z12, boolean z13, @g.p0 Set<Integer> set, @g.p0 String str2, @g.p0 File file) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor2, z11, z12, z13, set, str2, file, (Callable<InputStream>) null, (RoomDatabase.d) null, (List<Object>) null, (List<z1.b>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, @g.n0 RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, boolean z11, boolean z12, boolean z13, @g.p0 Set<Integer> set, @g.p0 String str2, @g.p0 File file, @g.p0 Callable<InputStream> callable) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor2, z11, z12, z13, set, str2, file, callable, (RoomDatabase.d) null, (List<Object>) null, (List<z1.b>) null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, @g.n0 RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, boolean z11, boolean z12, boolean z13, @g.p0 Set<Integer> set, @g.p0 String str2, @g.p0 File file, @g.p0 Callable<InputStream> callable, @g.p0 RoomDatabase.d dVar) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor2, z11, z12, z13, set, str2, file, callable, dVar, (List<Object>) null, (List<z1.b>) null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, @g.n0 RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, boolean z11, boolean z12, boolean z13, @g.p0 Set<Integer> set, @g.p0 String str2, @g.p0 File file, @g.p0 Callable<InputStream> callable, @g.p0 RoomDatabase.d dVar, @g.p0 List<Object> list2) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor2, z11, z12, z13, set, str2, file, callable, dVar, list2, (List<z1.b>) null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, @g.n0 RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, boolean z11, boolean z12, boolean z13, @g.p0 Set<Integer> set, @g.p0 String str2, @g.p0 File file, @g.p0 Callable<InputStream> callable, @g.p0 RoomDatabase.d dVar, @g.p0 List<Object> list2, @g.p0 List<z1.b> list3) {
        this(context, str, cVar, cVar2, list, z10, journalMode, executor, executor2, z11 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z12, z13, set, str2, file, callable, dVar, list2, list3);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public n0(@g.n0 Context context, @g.p0 String str, @g.n0 e.c cVar, @g.n0 RoomDatabase.c cVar2, @g.p0 List<RoomDatabase.b> list, boolean z10, @g.n0 RoomDatabase.JournalMode journalMode, @g.n0 Executor executor, @g.n0 Executor executor2, @g.p0 Intent intent, boolean z11, boolean z12, @g.p0 Set<Integer> set, @g.p0 String str2, @g.p0 File file, @g.p0 Callable<InputStream> callable, @g.p0 RoomDatabase.d dVar, @g.p0 List<Object> list2, @g.p0 List<z1.b> list3) {
        this.f7480a = cVar;
        this.f7481b = context;
        this.f7482c = str;
        this.f7483d = cVar2;
        this.f7484e = list;
        this.f7488i = z10;
        this.f7489j = journalMode;
        this.f7490k = executor;
        this.f7491l = executor2;
        this.f7493n = intent;
        this.f7492m = intent != null;
        this.f7494o = z11;
        this.f7495p = z12;
        this.f7496q = set;
        this.f7497r = str2;
        this.f7498s = file;
        this.f7499t = callable;
        this.f7485f = dVar;
        this.f7486g = list2 == null ? Collections.emptyList() : list2;
        this.f7487h = list3 == null ? Collections.emptyList() : list3;
    }
}
