package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
public abstract class Traverser<N> {

    public enum Order {
        PREORDER,
        POSTORDER
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n10);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n10);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n10);

    public static final class GraphTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> graph;

        public final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            public BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (N n10 : iterable) {
                    if (this.visited.add(n10)) {
                        this.queue.add(n10);
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N nRemove = this.queue.remove();
                for (N n10 : GraphTraverser.this.graph.successors(nRemove)) {
                    if (this.visited.add(n10)) {
                        this.queue.add(n10);
                    }
                }
                return nRemove;
            }
        }

        public final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors> stack;
            private final Set<N> visited;

            public final class NodeAndSuccessors {

                @NullableDecl
                public final N node;
                public final Iterator<? extends N> successorIterator;

                public NodeAndSuccessors(@NullableDecl N n10, Iterable<? extends N> iterable) {
                    this.node = n10;
                    this.successorIterator = iterable.iterator();
                }
            }

            public DepthFirstIterator(Iterable<? extends N> iterable, Order order) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                this.visited = new HashSet();
                arrayDeque.push(new NodeAndSuccessors(null, iterable));
                this.order = order;
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                N n10;
                while (!this.stack.isEmpty()) {
                    GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors first = this.stack.getFirst();
                    boolean zAdd = this.visited.add(first.node);
                    boolean z10 = true;
                    boolean z11 = !first.successorIterator.hasNext();
                    if ((!zAdd || this.order != Order.PREORDER) && (!z11 || this.order != Order.POSTORDER)) {
                        z10 = false;
                    }
                    if (z11) {
                        this.stack.pop();
                    } else {
                        N next = first.successorIterator.next();
                        if (!this.visited.contains(next)) {
                            this.stack.push(withSuccessors(next));
                        }
                    }
                    if (z10 && (n10 = first.node) != null) {
                        return n10;
                    }
                }
                return (N) endOfData();
            }

            public GraphTraverser<N>.DepthFirstIterator.NodeAndSuccessors withSuccessors(N n10) {
                return new NodeAndSuccessors(n10, GraphTraverser.this.graph.successors(n10));
            }
        }

        public GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        private void checkThatNodeIsInGraph(N n10) {
            this.graph.successors(n10);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n10) {
            Preconditions.checkNotNull(n10);
            return breadthFirst((Iterable) ImmutableSet.of(n10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n10) {
            Preconditions.checkNotNull(n10);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n10) {
            Preconditions.checkNotNull(n10);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it2 = iterable.iterator();
            while (it2.hasNext()) {
                checkThatNodeIsInGraph(it2.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it2 = iterable.iterator();
            while (it2.hasNext()) {
                checkThatNodeIsInGraph(it2.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it2 = iterable.iterator();
            while (it2.hasNext()) {
                checkThatNodeIsInGraph(it2.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.GraphTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }
    }

    public static final class TreeTraverser<N> extends Traverser<N> {
        private final SuccessorsFunction<N> tree;

        public final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();

            public BreadthFirstIterator(Iterable<? extends N> iterable) {
                Iterator<? extends N> it2 = iterable.iterator();
                while (it2.hasNext()) {
                    this.queue.add(it2.next());
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                N nRemove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(nRemove));
                return nRemove;
            }
        }

        public final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> stack;

            public final class NodeAndChildren {
                public final Iterator<? extends N> childIterator;

                @NullableDecl
                public final N node;

                public NodeAndChildren(@NullableDecl N n10, Iterable<? extends N> iterable) {
                    this.node = n10;
                    this.childIterator = iterable.iterator();
                }
            }

            public DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque<TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new ArrayDeque<>();
                this.stack = arrayDeque;
                arrayDeque.addLast(new NodeAndChildren(null, iterable));
            }

            @Override // com.google.common.collect.AbstractIterator
            public N computeNext() {
                while (!this.stack.isEmpty()) {
                    TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren last = this.stack.getLast();
                    if (last.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(last.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        N n10 = last.node;
                        if (n10 != null) {
                            return n10;
                        }
                    }
                }
                return (N) endOfData();
            }

            public TreeTraverser<N>.DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n10) {
                return new NodeAndChildren(n10, TreeTraverser.this.tree.successors(n10));
            }
        }

        public final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack;

            public DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            @Override // java.util.Iterator
            public N next() {
                Iterator<? extends N> last = this.stack.getLast();
                N n10 = (N) Preconditions.checkNotNull(last.next());
                if (!last.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator<? extends N> it2 = TreeTraverser.this.tree.successors(n10).iterator();
                if (it2.hasNext()) {
                    this.stack.addLast(it2);
                }
                return n10;
            }
        }

        public TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        private void checkThatNodeIsInTree(N n10) {
            this.tree.successors(n10);
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(N n10) {
            Preconditions.checkNotNull(n10);
            return breadthFirst((Iterable) ImmutableSet.of(n10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(N n10) {
            Preconditions.checkNotNull(n10);
            return depthFirstPostOrder((Iterable) ImmutableSet.of(n10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(N n10) {
            Preconditions.checkNotNull(n10);
            return depthFirstPreOrder((Iterable) ImmutableSet.of(n10));
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it2 = iterable.iterator();
            while (it2.hasNext()) {
                checkThatNodeIsInTree(it2.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.1
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it2 = iterable.iterator();
            while (it2.hasNext()) {
                checkThatNodeIsInTree(it2.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.3
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        @Override // com.google.common.graph.Traverser
        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            Iterator<? extends N> it2 = iterable.iterator();
            while (it2.hasNext()) {
                checkThatNodeIsInTree(it2.next());
            }
            return new Iterable<N>() { // from class: com.google.common.graph.Traverser.TreeTraverser.2
                @Override // java.lang.Iterable
                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }
    }

    private Traverser() {
    }
}
