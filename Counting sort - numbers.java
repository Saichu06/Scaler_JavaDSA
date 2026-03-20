function countSort(arr) {
    if (arr.length === 0) {
        return [];
    }

    const n = arr.length;
    const maxVal = Math.max(...arr);

    // create and initialize cntArr
    const cntArr = new Array(maxVal + 1).fill(0);

    // count frequency of each element
    for (let v of arr) {
        cntArr[v]++;
    }

    // compute prefix sums
    for (let i = 1; i <= maxVal; i++) {
        cntArr[i] += cntArr[i - 1];
    }

    // build output array
    const ans = new Array(n);
    for (let i = n - 1; i >= 0; i--) {
        const v = arr[i];
        ans[cntArr[v] - 1] = v;
        cntArr[v]--;
    }

    return ans;
}

// Example usage:
const arr = [2, 5, 3, 0, 2, 3, 0, 3];
const ans = countSort(arr);
console.log(ans);  // [0, 0, 2, 2, 3, 3, 3, 5]