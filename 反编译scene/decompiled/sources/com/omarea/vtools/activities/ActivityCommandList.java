package com.omarea.vtools.activities;

import a.f92;
import a.g50;
import a.g91;
import a.m42;
import a.p80;
import a.q80;
import a.r91;
import a.se0;
import a.t61;
import a.u61;
import a.v01;
import a.w01;
import a.xx0;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.ui.BlurViewRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityCommandList extends g91 implements v01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f8607a;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ActivityCommandList.this.startActivity(new Intent(ActivityCommandList.this, (Class<?>) ActivityCustomCommand.class));
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8609a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ g50 f5209a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ w01 f5210a;

        public b(g50 g50Var, w01 w01Var, int i) {
            this.f5209a = g50Var;
            this.f5210a = w01Var;
            this.f8609a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new xx0(ActivityCommandList.this).b(this.f5209a);
            this.f5210a.C(this.f8609a);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8610a = new c();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f8611a = new d();

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f8607a == null) {
            this.f8607a = new HashMap();
        }
        View view = (View) this.f8607a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f8607a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // a.v01
    public void a(View view, int i) {
        f92.d(view, "view");
        BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) _$_findCachedViewById(t61.list_commands);
        f92.c(blurViewRecyclerView, "list_commands");
        RecyclerView.g adapter = blurViewRecyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterCommandList");
        }
        w01 w01Var = (w01) adapter;
        g50 g50VarZ = w01Var.z(i);
        p80.a aVar = p80.f2403a;
        String strB = g50VarZ.b();
        String strA = g50VarZ.a();
        String string = getString(u61.btn_delete);
        f92.c(string, "getString(R.string.btn_delete)");
        aVar.h(this, (16 & 2) != 0 ? "" : strB, (16 & 4) != 0 ? "" : strA, (16 & 8) != 0 ? null : new q80(string, new b(g50VarZ, w01Var, i), false, 4, null), (16 & 16) != 0 ? null : null);
    }

    public final void j(g50 g50Var) {
        f92.d(g50Var, "item");
        RunnableNode runnableNode = new RunnableNode("");
        runnableNode.setTitle("TEST-EXECUTOR");
        runnableNode.setDesc("COMMAND >> " + runnableNode.getTitle());
        se0 se0VarA = se0.f7388a.a(runnableNode, c.f8610a, d.f8611a, '\'' + g50Var.a() + '\'', null, false);
        se0VarA.B1(getSupportFragmentManager(), "");
        se0VarA.z1(false);
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558444);
        setBackArrow();
        ((FloatingActionButton) _$_findCachedViewById(t61.list_add_command)).setOnClickListener(new a());
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // a.g91, a.cl, android.app.Activity
    public void onResume() {
        super.onResume();
        setTitle(getString(u61.menu_command_list));
        ArrayList<g50> arrayListA = new xx0(this).a();
        BlurViewRecyclerView blurViewRecyclerView = (BlurViewRecyclerView) _$_findCachedViewById(t61.list_commands);
        f92.c(blurViewRecyclerView, "list_commands");
        blurViewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        BlurViewRecyclerView blurViewRecyclerView2 = (BlurViewRecyclerView) _$_findCachedViewById(t61.list_commands);
        f92.c(blurViewRecyclerView2, "list_commands");
        w01 w01Var = new w01(this, arrayListA);
        w01Var.D(this);
        w01Var.E(new r91(this));
        m42 m42Var = m42.f6769a;
        blurViewRecyclerView2.setAdapter(w01Var);
    }
}
