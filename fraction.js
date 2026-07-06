module.exports = {
    solve: function(A, B, C) {
        let n = A.length;
        let items = [];

        for (let i = 0; i < n; i++) {
            items.push({
                value: A[i],
                weight: B[i],
                ratio: A[i] / B[i]
            });
        }

        items.sort((a, b) => b.ratio - a.ratio);

        let totalValue = 0;
        let currentCapacity = C;

        for (let i = 0; i < n; i++) {
            if (currentCapacity <= 0) break;

            if (items[i].weight <= currentCapacity) {
                totalValue += items[i].value;
                currentCapacity -= items[i].weight;
            } else {
                totalValue += items[i].ratio * currentCapacity;
                currentCapacity = 0;
            }
        }

        // Add a tiny epsilon before flooring to handle precision issues
        return Math.floor(totalValue * 100 + 1e-9);
    }
};
