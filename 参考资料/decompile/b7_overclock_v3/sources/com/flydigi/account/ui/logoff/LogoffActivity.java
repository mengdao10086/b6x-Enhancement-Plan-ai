package com.flydigi.account.ui.logoff;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.o;
import com.flydigi.account.R;
import com.flydigi.base.common.p;
import com.flydigi.data.LoginBaseResponse;
import dj.g;
import i9.a;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m5.c0;
import o5.l;
import p5.t;
import top.androidman.SuperButton;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = a.C0378a.f31907d)
public final class LogoffActivity extends p {
    public boolean E7;
    public d5.a K2;

    public static final class a extends t {
        public a() {
        }

        @Override // p5.t, android.text.TextWatcher
        public void onTextChanged(@k CharSequence s10, int i10, int i11, int i12) {
            f0.p(s10, "s");
            d5.a aVar = null;
            if (s10.length() > 0) {
                d5.a aVar2 = LogoffActivity.this.K2;
                if (aVar2 == null) {
                    f0.S("binding");
                    aVar2 = null;
                }
                SuperButton superButton = aVar2.f25996h;
                f0.o(superButton, "binding.ivClearPassword");
                o5.c.b(superButton, Boolean.TRUE, false, 2, null);
                d5.a aVar3 = LogoffActivity.this.K2;
                if (aVar3 == null) {
                    f0.S("binding");
                } else {
                    aVar = aVar3;
                }
                aVar.f25993e.setEnabled(true);
                return;
            }
            d5.a aVar4 = LogoffActivity.this.K2;
            if (aVar4 == null) {
                f0.S("binding");
                aVar4 = null;
            }
            SuperButton superButton2 = aVar4.f25996h;
            f0.o(superButton2, "binding.ivClearPassword");
            o5.c.b(superButton2, Boolean.FALSE, false, 2, null);
            d5.a aVar5 = LogoffActivity.this.K2;
            if (aVar5 == null) {
                f0.S("binding");
            } else {
                aVar = aVar5;
            }
            aVar.f25993e.setEnabled(false);
        }
    }

    public static final void q4(LogoffActivity this$0, CompoundButton compoundButton, boolean z10) {
        f0.p(this$0, "this$0");
        d5.a aVar = this$0.K2;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        aVar.f25990b.setVisibility(z10 ? 0 : 8);
    }

    public static final void r4(LogoffActivity this$0, View view) {
        f0.p(this$0, "this$0");
        d5.a aVar = this$0.K2;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        aVar.f25995g.setText("");
    }

    public static final void s4(LogoffActivity this$0, View view) {
        f0.p(this$0, "this$0");
        d5.a aVar = null;
        if (this$0.E7) {
            d5.a aVar2 = this$0.K2;
            if (aVar2 == null) {
                f0.S("binding");
                aVar2 = null;
            }
            aVar2.f25997i.setImageResource(R.drawable.account_ic_password_visible);
            d5.a aVar3 = this$0.K2;
            if (aVar3 == null) {
                f0.S("binding");
                aVar3 = null;
            }
            aVar3.f25995g.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            d5.a aVar4 = this$0.K2;
            if (aVar4 == null) {
                f0.S("binding");
                aVar4 = null;
            }
            aVar4.f25997i.setImageResource(R.drawable.account_ic_password_invisible);
            d5.a aVar5 = this$0.K2;
            if (aVar5 == null) {
                f0.S("binding");
                aVar5 = null;
            }
            aVar5.f25995g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        this$0.E7 = !this$0.E7;
        d5.a aVar6 = this$0.K2;
        if (aVar6 == null) {
            f0.S("binding");
            aVar6 = null;
        }
        EditText editText = aVar6.f25995g;
        d5.a aVar7 = this$0.K2;
        if (aVar7 == null) {
            f0.S("binding");
        } else {
            aVar = aVar7;
        }
        editText.setSelection(aVar.f25995g.getText().length());
    }

    public static final void t4(final LogoffActivity this$0, View view) {
        f0.p(this$0, "this$0");
        KeyboardUtils.j(this$0);
        this$0.x("", false);
        d5.a aVar = this$0.K2;
        d5.a aVar2 = null;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        aVar.f25993e.setEnabled(false);
        d5.a aVar3 = this$0.K2;
        if (aVar3 == null) {
            f0.S("binding");
        } else {
            aVar2 = aVar3;
        }
        z zVarS0 = ((c5.b) m5.f0.i().k().g(c5.b.class)).v(m5.b.c(aVar2.f25995g.getText().toString())).s0(c0.q()).s0(c0.t()).s0(l.d()).s0(this$0.y1());
        final ik.l<LoginBaseResponse<Object>, z1> lVar = new ik.l<LoginBaseResponse<Object>, z1>() { // from class: com.flydigi.account.ui.logoff.LogoffActivity$onCreate$5$1
            {
                super(1);
            }

            public final void b(LoginBaseResponse<Object> loginBaseResponse) {
                this.this$0.E0();
                a5.f.i().t();
                this.this$0.setResult(-1);
                this.this$0.finish();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(LoginBaseResponse<Object> loginBaseResponse) {
                b(loginBaseResponse);
                return z1.f38230a;
            }
        };
        g gVar = new g() { // from class: com.flydigi.account.ui.logoff.f
            @Override // dj.g
            public final void accept(Object obj) {
                LogoffActivity.u4(lVar, obj);
            }
        };
        final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.account.ui.logoff.LogoffActivity$onCreate$5$2
            {
                super(1);
            }

            public final void b(Throwable th2) {
                d5.a aVar4 = this.this$0.K2;
                if (aVar4 == null) {
                    f0.S("binding");
                    aVar4 = null;
                }
                aVar4.f25993e.setEnabled(true);
                this.this$0.E0();
                ToastUtils.S(th2.getMessage(), new Object[0]);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        };
        zVarS0.F5(gVar, new g() { // from class: com.flydigi.account.ui.logoff.e
            @Override // dj.g
            public final void accept(Object obj) {
                LogoffActivity.v4(lVar2, obj);
            }
        });
    }

    public static final void u4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void v4(ik.l tmp0, Object obj) {
        f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.account_activity_logoff;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@yt.l Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.account_logoff);
        d5.a aVar = this.K2;
        d5.a aVar2 = null;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        aVar.f25994f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.flydigi.account.ui.logoff.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                LogoffActivity.q4(this.f13211a, compoundButton, z10);
            }
        });
        d5.a aVar3 = this.K2;
        if (aVar3 == null) {
            f0.S("binding");
            aVar3 = null;
        }
        aVar3.f25995g.addTextChangedListener(new a());
        d5.a aVar4 = this.K2;
        if (aVar4 == null) {
            f0.S("binding");
            aVar4 = null;
        }
        o.r(aVar4.f25996h, new View.OnClickListener() { // from class: com.flydigi.account.ui.logoff.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogoffActivity.r4(this.f13210a, view);
            }
        });
        d5.a aVar5 = this.K2;
        if (aVar5 == null) {
            f0.S("binding");
            aVar5 = null;
        }
        o.r(aVar5.f25997i, new View.OnClickListener() { // from class: com.flydigi.account.ui.logoff.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogoffActivity.s4(this.f13208a, view);
            }
        });
        d5.a aVar6 = this.K2;
        if (aVar6 == null) {
            f0.S("binding");
        } else {
            aVar2 = aVar6;
        }
        o.r(aVar2.f25993e, new View.OnClickListener() { // from class: com.flydigi.account.ui.logoff.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LogoffActivity.t4(this.f13209a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        d5.a aVarC = d5.a.c(getLayoutInflater());
        f0.o(aVarC, "inflate(layoutInflater)");
        this.K2 = aVarC;
        if (aVarC == null) {
            f0.S("binding");
            aVarC = null;
        }
        setContentView(aVarC.getRoot());
    }
}
