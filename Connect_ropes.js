class MinHeap {
    constructor() {
        this.heap = [];
    }
    push(val) {
        this.heap.push(val);
        this.bubbleUp();
    }
    pop() {
        if (this.size() === 1) return this.heap.pop();
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        return min;
    }
    size() { return this.heap.length; }
    
    bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0) {
            let parent = Math.floor((index - 1) / 2);
            if (this.heap[parent] <= this.heap[index]) break;
            [this.heap[parent], this.heap[index]] = [this.heap[index], this.heap[parent]];
            index = parent;
        }
    }
    bubbleDown() {
        let index = 0;
        while (true) {
            let left = 2 * index + 1, right = 2 * index + 2, smallest = index;
            if (left < this.size() && this.heap[left] < this.heap[smallest]) smallest = left;
            if (right < this.size() && this.heap[right] < this.heap[smallest]) smallest = right;
            if (smallest === index) break;
            [this.heap[smallest], this.heap[index]] = [this.heap[index], this.heap[smallest]];
            index = smallest;
        }
    }
}

module.exports = {
    solve: function(A) {
        if (!A || A.length <= 1) return 0;
        const heap = new MinHeap();
        for (let x of A) heap.push(x);

        let totalCost = 0;
        while (heap.size() > 1) {
            let cost = heap.pop() + heap.pop();
            totalCost += cost;
            heap.push(cost);
        }
        return totalCost;
    }
};
