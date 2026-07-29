package com.arialyy.aria.core.loader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LoaderStructure {
    private List<ILoaderComponent> parts = new ArrayList();

    public void accept(ILoaderVisitor iLoaderVisitor) {
        Iterator<ILoaderComponent> it2 = this.parts.iterator();
        while (it2.hasNext()) {
            it2.next().accept(iLoaderVisitor);
        }
    }

    public LoaderStructure addComponent(ILoaderComponent iLoaderComponent) {
        this.parts.add(iLoaderComponent);
        return this;
    }
}
