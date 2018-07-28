const getAllPalidromicTimes = () => {
    const answer = [];
    for (let min = 0; min < 60; min++) {
        const hr = getPalidromicHour(min);
        if (hr < 24) {
            answer.push(`${hr}:${min}`);
        }
    }
    return asnwer;
}
