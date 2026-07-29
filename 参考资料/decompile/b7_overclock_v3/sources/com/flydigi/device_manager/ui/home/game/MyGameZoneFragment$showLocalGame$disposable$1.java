package com.flydigi.device_manager.ui.home.game;

import com.flydigi.data.bean.LocalGameBean;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
public /* synthetic */ class MyGameZoneFragment$showLocalGame$disposable$1 extends FunctionReferenceImpl implements ik.l<LocalGameBean, MyGameItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MyGameZoneFragment$showLocalGame$disposable$1 f15239c = new MyGameZoneFragment$showLocalGame$disposable$1();

    public MyGameZoneFragment$showLocalGame$disposable$1() {
        super(1, MyGameItem.class, "<init>", "<init>(Lcom/flydigi/data/bean/LocalGameBean;)V", 0);
    }

    @Override // ik.l
    @yt.k
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final MyGameItem i(LocalGameBean localGameBean) {
        return new MyGameItem(localGameBean);
    }
}
