package com.omarea.vtools.activities;

import a.f92;
import a.g91;
import a.t61;
import a.y60;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.omarea.Scene;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActivityEditor extends g91 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f5242a;
    public boolean b;

    public View _$_findCachedViewById(int i) {
        if (this.f5242a == null) {
            this.f5242a = new HashMap();
        }
        View view = (View) this.f5242a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f5242a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Scene.c cVar;
        String str;
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2131362069) {
            EditText editText = (EditText) _$_findCachedViewById(t61.text_content);
            y60 y60Var = y60.f7952a;
            String str2 = this.f8643a;
            f92.b(str2);
            editText.setText(y60Var.i(str2));
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2131362070) {
            EditText editText2 = (EditText) _$_findCachedViewById(t61.text_content);
            f92.c(editText2, "text_content");
            String string = editText2.getText().toString();
            y60 y60Var2 = y60.f7952a;
            String str3 = this.f8643a;
            f92.b(str3);
            if (y60Var2.l(str3, string)) {
                cVar = Scene.f4798a;
                str = "OK";
            } else {
                cVar = Scene.f4798a;
                str = "Fail!";
            }
            Scene.c.p(cVar, str, 0, 2, null);
        }
    }

    @Override // a.g91, a.v0, a.cl, androidx.activity.ComponentActivity, a.gb, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558447);
        setBackArrow();
        onViewCreated();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    @Override // a.g91, a.cl, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            r7 = this;
            super.onResume()
            java.lang.String r0 = r7.f8643a
            if (r0 == 0) goto L3d
            a.f92.b(r0)
            r1 = 0
            r2 = 2
            r3 = 0
            java.lang.String r4 = "/"
            boolean r0 = a.ec2.C(r0, r4, r1, r2, r3)
            if (r0 == 0) goto L3d
            java.lang.String r0 = r7.f8643a
            a.f92.b(r0)
            java.lang.String r1 = r7.f8643a
            a.f92.b(r1)
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            java.lang.String r2 = "/"
            int r1 = a.ec2.S(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L35
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r1 = "(this as java.lang.String).substring(startIndex)"
            a.f92.c(r0, r1)
            goto L44
        L35:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L3d:
            r0 = 2131887110(0x7f120406, float:1.9408818E38)
            java.lang.String r0 = r7.getString(r0)
        L44:
            r7.setTitle(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.vtools.activities.ActivityEditor.onResume():void");
    }

    public final void onViewCreated() {
        String string;
        ((Button) _$_findCachedViewById(t61.btn_confirm)).setOnClickListener(this);
        ((Button) _$_findCachedViewById(t61.btn_cancel)).setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("rootMode")) {
                Bundle extras2 = intent.getExtras();
                f92.b(extras2);
                extras2.getBoolean("rootMode");
            }
            Bundle extras3 = intent.getExtras();
            if (extras3 == null || !extras3.containsKey("file")) {
                string = null;
            } else {
                Bundle extras4 = intent.getExtras();
                f92.b(extras4);
                string = extras4.getString("file");
            }
            this.f8643a = string;
            Bundle extras5 = intent.getExtras();
            this.b = extras5 != null && extras5.containsKey("readonly");
            if (this.f8643a == null) {
                finish();
            } else {
                EditText editText = (EditText) _$_findCachedViewById(t61.text_content);
                y60 y60Var = y60.f7952a;
                String str = this.f8643a;
                f92.b(str);
                editText.setText(y60Var.i(str));
            }
            if (this.b) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(t61.actions);
                f92.c(linearLayout, "actions");
                linearLayout.setVisibility(8);
                EditText editText2 = (EditText) _$_findCachedViewById(t61.text_content);
                f92.c(editText2, "text_content");
                editText2.setKeyListener(null);
                ((EditText) _$_findCachedViewById(t61.text_content)).setTextIsSelectable(true);
            }
        }
    }
}
