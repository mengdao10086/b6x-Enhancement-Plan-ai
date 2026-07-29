package com.game.motionelf.activity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b9.g;
import com.fdg.flashplay.farsef.R;
import com.flydigi.data.DataConstant;
import com.trello.rxlifecycle3.components.support.RxDialogFragment;
import g.n0;
import g.p0;
import o5.p;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public class UserPolicyDialog extends RxDialogFragment implements View.OnClickListener {
    public c E8;
    public g F8;

    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16437a;

        public a(String str) {
            this.f16437a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@n0 View view) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=818&hideTop=1" : "https://bbs.flydigi.com/reads/1035&hideTop=1").withString(DataConstant.WEB_TITLE, this.f16437a).navigation();
        }
    }

    public class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16439a;

        public b(String str) {
            this.f16439a = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@n0 View view) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, p.d() ? "https://next.flydigi.com/read.php?id=1008&hideTop=1" : "https://bbs.flydigi.com/reads/1034&hideTop=1").withString(DataConstant.WEB_TITLE, this.f16439a).navigation();
        }
    }

    public interface c {
        void a();

        void cancel();
    }

    public static UserPolicyDialog c6() {
        return new UserPolicyDialog();
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    @l
    public View O3(@k @n0 LayoutInflater layoutInflater, @p0 @l ViewGroup viewGroup, @p0 @l Bundle bundle) {
        g gVarD = g.d(layoutInflater, viewGroup, false);
        this.F8 = gVarD;
        return gVarD.getRoot();
    }

    public void d6(c cVar) {
        this.E8 = cVar;
    }

    @Override // com.trello.rxlifecycle3.components.support.RxDialogFragment, androidx.fragment.app.Fragment
    public void j4(View view, @p0 @l Bundle bundle) {
        super.j4(view, bundle);
        String strC3 = c3(R.string.account_title_user_agreement);
        String strC32 = c3(R.string.account_title_privacy_policy);
        String strD3 = d3(R.string.app_user_info_access_policy, strC32, c3(R.string.app_user_policy_agree), strC3, strC32);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strD3);
        int iIndexOf = strD3.indexOf(strC3);
        int length = strC3.length() + iIndexOf;
        int iIndexOf2 = strD3.indexOf(strC32, length);
        int length2 = strC32.length() + iIndexOf2;
        spannableStringBuilder.setSpan(new UnderlineSpan(), iIndexOf, length, 18);
        spannableStringBuilder.setSpan(new UnderlineSpan(), iIndexOf2, length2, 18);
        spannableStringBuilder.setSpan(new a(strC3), iIndexOf, length, 18);
        spannableStringBuilder.setSpan(new b(strC32), iIndexOf2, length2, 18);
        this.F8.f9171g.setMovementMethod(LinkMovementMethod.getInstance());
        this.F8.f9171g.setText(spannableStringBuilder);
        this.F8.f9167c.setOnClickListener(this);
        this.F8.f9166b.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btn_refuse) {
            c cVar = this.E8;
            if (cVar != null) {
                cVar.cancel();
                return;
            }
            return;
        }
        if (id2 != R.id.btn_allow || this.E8 == null) {
            return;
        }
        H5();
        this.E8.a();
    }
}
