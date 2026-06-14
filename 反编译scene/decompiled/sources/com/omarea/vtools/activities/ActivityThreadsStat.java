package com.omarea.vtools.activities;

import a.b51;
import a.f92;
import a.fy0;
import a.g91;
import a.m42;
import a.py0;
import a.t61;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.Scene;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityThreadsStat extends g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final py0 f8922a = new py0(Scene.f4798a.c());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f5540a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5541a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f8923a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ fy0 f5542a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f5544a;

        public a(long j, List list, fy0 fy0Var) {
            this.f8923a = j;
            this.f5544a = list;
            this.f5542a = fy0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = (RecyclerView) ActivityThreadsStat.this._$_findCachedViewById(t61.thread_stats);
            f92.c(recyclerView, "thread_stats");
            recyclerView.setAdapter(new b51(ActivityThreadsStat.this.getContext(), this.f8923a, this.f5544a, this.f5542a));
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f5541a == null) {
            this.f5541a = new HashMap();
        }
        View view = (View) this.f5541a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5541a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void j(long j) {
        this.f5540a.post(new a(j, this.f8922a.n(j), this.f8922a.o(j)));
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(2131558467);
        setBackArrow();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(t61.thread_stats);
        f92.c(recyclerView, "thread_stats");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.H2(1);
        linearLayoutManager.J2(false);
        m42 m42Var = m42.f6769a;
        recyclerView.setLayoutManager(linearLayoutManager);
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        j(extras.getLong("sessionId"));
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        Bundle extras;
        super.onResume();
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("appName");
        if (string == null || string.length() == 0) {
            return;
        }
        setTitle(string);
    }
}
