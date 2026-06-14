package com.omarea.vtools.activities;

import a.b62;
import a.b92;
import a.d30;
import a.d72;
import a.f92;
import a.g91;
import a.h60;
import a.j60;
import a.k82;
import a.lz0;
import a.m42;
import a.oz0;
import a.qc2;
import a.qe2;
import a.rx0;
import a.wd2;
import a.x62;
import a.xd2;
import a.zi0;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityPerfOptions extends g91 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8803a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f5396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5397a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public final void a(Context context, int i, String str, String str2) {
            f92.d(context, "context");
            f92.d(str, "store");
            f92.d(str2, "title");
            Intent intent = new Intent(context, (Class<?>) ActivityPerfOptions.class);
            intent.putExtra("config", i);
            intent.putExtra("store", str);
            intent.putExtra("title", str2);
            context.startActivity(intent);
        }

        public final void b(Context context, d30 d30Var, String str, String str2) {
            f92.d(context, "context");
            f92.d(d30Var, "jsonObject");
            f92.d(str, "store");
            f92.d(str2, "title");
            Intent intent = new Intent(context, (Class<?>) ActivityPerfOptions.class);
            intent.putExtra("configJson", d30Var.toString());
            intent.putExtra("store", str);
            intent.putExtra("title", str2);
            context.startActivity(intent);
        }
    }

    @x62(c = "com.omarea.vtools.activities.ActivityPerfOptions$onViewCreated$1", f = "ActivityPerfOptions.kt", l = {112}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8804a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5399a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5400b;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = ActivityPerfOptions.this.new b(b62Var);
            bVar.f8804a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b3 A[RETURN] */
        @Override // a.s62
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a.r62.c()
                int r1 = r7.b
                r2 = 1
                if (r1 == 0) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r0 = r7.f5400b
                a.n92 r0 = (a.n92) r0
                java.lang.Object r0 = r7.f5399a
                a.wd2 r0 = (a.wd2) r0
                a.h42.b(r8)
                goto Lb4
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L20:
                a.h42.b(r8)
                a.wd2 r8 = r7.f8804a
                a.n92 r1 = new a.n92
                r1.<init>()
                r3 = 0
                r1.f6891a = r3
                com.omarea.vtools.activities.ActivityPerfOptions r4 = com.omarea.vtools.activities.ActivityPerfOptions.this
                android.content.Intent r4 = r4.getIntent()
                if (r4 == 0) goto L56
                java.lang.String r5 = "dir"
                boolean r4 = r4.hasExtra(r5)
                if (r4 != r2) goto L56
                com.omarea.vtools.activities.ActivityPerfOptions r4 = com.omarea.vtools.activities.ActivityPerfOptions.this
                android.content.Intent r6 = r4.getIntent()
                java.lang.String r5 = r6.getStringExtra(r5)
                a.f92.b(r5)
                java.lang.String r6 = "intent.getStringExtra(\"dir\")!!"
                a.f92.c(r5, r6)
                java.util.ArrayList r4 = com.omarea.vtools.activities.ActivityPerfOptions.k(r4, r5)
            L53:
                r1.f6891a = r4
                goto L9e
            L56:
                r4 = 2131820552(0x7f110008, float:1.9273822E38)
                com.omarea.vtools.activities.ActivityPerfOptions r5 = com.omarea.vtools.activities.ActivityPerfOptions.this
                android.content.Intent r5 = r5.getIntent()
                if (r5 == 0) goto L7d
                java.lang.String r6 = "configJson"
                boolean r5 = r5.hasExtra(r6)
                if (r5 != r2) goto L7d
                com.omarea.vtools.activities.ActivityPerfOptions r4 = com.omarea.vtools.activities.ActivityPerfOptions.this
                android.content.Intent r4 = r4.getIntent()
                java.lang.String r4 = r4.getStringExtra(r6)
                com.omarea.vtools.activities.ActivityPerfOptions r5 = com.omarea.vtools.activities.ActivityPerfOptions.this
                a.f92.b(r4)
                java.util.ArrayList r4 = com.omarea.vtools.activities.ActivityPerfOptions.l(r5, r4)
                goto L53
            L7d:
                com.omarea.vtools.activities.ActivityPerfOptions r5 = com.omarea.vtools.activities.ActivityPerfOptions.this
                android.content.Intent r5 = r5.getIntent()
                if (r5 == 0) goto L9e
                java.lang.String r6 = "config"
                boolean r5 = r5.hasExtra(r6)
                if (r5 != r2) goto L9e
                com.omarea.vtools.activities.ActivityPerfOptions r5 = com.omarea.vtools.activities.ActivityPerfOptions.this
                android.content.Intent r5 = r5.getIntent()
                int r4 = r5.getIntExtra(r6, r4)
                com.omarea.vtools.activities.ActivityPerfOptions r5 = com.omarea.vtools.activities.ActivityPerfOptions.this
                java.util.ArrayList r4 = com.omarea.vtools.activities.ActivityPerfOptions.m(r5, r4)
                goto L53
            L9e:
                a.fg2 r4 = a.qe2.c()
                a.be1 r5 = new a.be1
                r5.<init>(r7, r1, r3)
                r7.f5399a = r8
                r7.f5400b = r1
                r7.b = r2
                java.lang.Object r8 = a.oc2.g(r4, r5, r7)
                if (r8 != r0) goto Lb4
                return r0
            Lb4:
                a.m42 r8 = a.m42.f6769a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityPerfOptions.b.j(java.lang.Object):java.lang.Object");
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5397a == null) {
            this.f5397a = new HashMap();
        }
        View view = (View) this.f5397a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5397a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final ArrayList<oz0> n(String str) {
        ArrayList<oz0> arrayList = new ArrayList<>();
        arrayList.add(new zi0().a(str));
        return arrayList;
    }

    public final ArrayList<oz0> o(String str) {
        return new lz0(new j60(this), this.f5396a != null ? new rx0(getContext(), this.f5396a) : null).d(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.getId();
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle extras;
        Bundle extras2;
        super.onCreate(bundle);
        setContentView(2131558460);
        setBackArrow();
        Intent intent = getIntent();
        setTitle((intent == null || (extras2 = intent.getExtras()) == null || !extras2.containsKey("title")) ? "" : getIntent().getStringExtra("title"));
        Intent intent2 = getIntent();
        this.f5396a = (intent2 == null || (extras = intent2.getExtras()) == null || !extras.containsKey("store")) ? null : getIntent().getStringExtra("store");
        onViewCreated();
    }

    public final void onViewCreated() {
        qc2.d(xd2.a(qe2.b()), null, null, new b(null), 3, null);
    }

    public final ArrayList<oz0> p(int i) {
        return new lz0(new j60(this), this.f5396a != null ? new rx0(getContext(), this.f5396a) : null).d(h60.f6280a.b(this, i));
    }
}
