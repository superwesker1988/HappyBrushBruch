const deepEqual = (x, y) => {
    const hash = new Set();
    const helper = (left, right) => {
        if (left === right) {
            return true;
        }
        if ((left && typeof left === "object")
            && (right && typeof right === "object")) {
            if (Object.keys(left).length !== Object.keys(right).length) {
                return false;
            }
            hash.add(left);
            for (let prop in left) {
                if (!right.hasOwnProperty(prop)) {
                    return false;
                }
                if (!hash.has(left[prop]) && !helper(left[prop], right[prop])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    };

    return helper(x, y);
};