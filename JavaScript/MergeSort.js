const mergeSort = (nums) => {
    if (nums == null || nums.length < 2) {
        return;
    }
    let leftIndex = 0;
    let subLength = 0;
    for (subLength = 1; subLength < nums.length; subLength *= 2) {
        for (leftIndex = 0; leftIndex < nums.length; leftIndex += 2 * subLength) {
            let mid = leftIndex + subLength - 1;
            let rightIndex = Math.min(nums.length - 1, leftIndex + 2 * subLength - 1);
            merge(nums, leftIndex, mid, rightIndex);
        }
    }
}

const merge = (nums, left, mid, right) => {
    if (left === right) {
        return;
    }
    const tempArray = Array(right - left + 1);
    let leftInd = left, rightInd = mid + 1, index = left;
    while (leftInd <= mid && rightInd <= right) {
        if (nums[leftInd] < nums[rightInd]) {
            tempArray[index] = nums[leftInd];
            leftInd++;
        }
        else {
            tempArray[index] = nums[rightInd];
            rightInd++;
        }
        index++;
    }
    while (leftInd <= mid) {
        tempArray[index] = nums[leftInd];
        leftInd++;
        index++;
    }
    while (rightInd <= right) {
        tempArray[index] = nums[rightInd];
        rightInd++
        index++;
    }
    index = left;
    while (index <= right) {
        nums[index] = tempArray[index];
        index++;
    }
}