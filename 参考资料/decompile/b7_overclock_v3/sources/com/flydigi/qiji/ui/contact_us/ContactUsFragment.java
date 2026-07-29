package com.flydigi.qiji.ui.contact_us;

import android.os.Bundle;
import android.view.View;
import androidx.core.os.e;
import com.blankj.utilcode.util.o;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.qiji.ui.contact_us.ContactUsFragment;
import i9.a;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import u9.b;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class ContactUsFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @k
    public static final a f16099o8 = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final ContactUsFragment a() {
            ContactUsFragment contactUsFragment = new ContactUsFragment();
            contactUsFragment.c5(e.a());
            return contactUsFragment;
        }
    }

    public static final void c6(View view) {
        b.o(6, "账号");
    }

    public static final void d6(ContactUsFragment this$0, View view) {
        f0.p(this$0, "this$0");
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, this$0.c3(R.string.app_title_feedback)).withString(DataConstant.WEB_URL, DataConstant.URL_FEEDBACK).navigation();
    }

    public static final void e6(View view) {
        h3.a.j().d(a.i.f31987b).navigation();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.main_fragment_contact_us;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @l Bundle bundle) {
        f0.p(view, "view");
        super.j4(view, bundle);
        View viewFindViewById = view.findViewById(R.id.ai_customer_service);
        if (viewFindViewById != null) {
            o.r(viewFindViewById, new View.OnClickListener() { // from class: f9.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ContactUsFragment.c6(view2);
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R.id.ai_feedback);
        if (viewFindViewById2 != null) {
            o.r(viewFindViewById2, new View.OnClickListener() { // from class: f9.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ContactUsFragment.d6(this.f27998a, view2);
                }
            });
        }
        View viewFindViewById3 = view.findViewById(R.id.ai_about_us);
        if (viewFindViewById3 != null) {
            o.r(viewFindViewById3, new View.OnClickListener() { // from class: f9.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ContactUsFragment.e6(view2);
                }
            });
        }
    }
}
