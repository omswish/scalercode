// Using a simple MinHeap class
class MinHeap {
    constructor() { this.data = []; }
    push(val) {
        this.data.push(val);
        this.bubbleUp(this.data.length - 1);
    }
    pop() {
        if (this.size() === 1) return this.data.pop();
        const top = this.data[0];
        this.data[0] = this.data.pop();
        this.bubbleDown(0);
        return top;
    }
    peek() { return this.data[0]; }
    size() { return this.data.length; }
    bubbleUp(idx) {
        while (idx > 0) {
            let p = (idx - 1) >> 1;
            if (this.data[idx] < this.data[p]) {
                [this.data[idx], this.data[p]] = [this.data[p], this.data[idx]];
                idx = p;
            } else break;
        }
    }
    bubbleDown(idx) {
        while (true) {
            let left = 2 * idx + 1, right = 2 * idx + 2, small = idx;
            if (left < this.size() && this.data[left] < this.data[small]) small = left;
            if (right < this.size() && this.data[right] < this.data[small]) small = right;
            if (small !== idx) {
                [this.data[idx], this.data[small]] = [this.data[small], this.data[idx]];
                idx = small;
            } else break;
        }
    }
}

module.exports = {
    solve: function(A, B) {
        const heap = new MinHeap();
        const result = [];
        
        for (let i = 0; i < B.length; i++) {
            if (heap.size() < A) {
                heap.push(B[i]);
            } else if (B[i] > heap.peek()) {
                heap.pop();
                heap.push(B[i]);
            }
            
            if (heap.size() < A) {
                result.push(-1);
            } else {
                result.push(heap.peek());
            }
        }
        return result;
    }
};
