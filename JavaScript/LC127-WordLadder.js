/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    if (!wordList.some(value => {
        return value === endWord;
    })) {
        return 0;
    }
    const picked = new Set();
    const queue = [];
    const answer = 0;
    queue.push(beginWord);
    picked.add(beginWord);
    while (queue.length) {
        let queueLength = queue.length;
        answer++;
        while (queueLength) {
            queueLength--;
            const curStr = queue.shift();
            picked.add(curStr);
            const nextSteps = getNextSteps(curStr, picked, wordList);
            for (let i = 0; i < nextSteps.length; i++) {
                if (nextSteps[i] === endWord) {
                    return answer;
                }
                queue.push(nextSteps);
            }
        }
    }
    return 0;
};

var getNextSteps = (curStr, picked, wordList) => {
    const nextSteps = [];
    for (let i = 0; i < wordList; i++) {
        if (picked.has(wordList[i])) {
            continue;
        }
        let dffCnt = 0;
        for (let j = 0; j < curStr.length; j++) {
            if (curStr[j] !== wordList[i][j]) {
                diffCnt++;
            }
        }
        if (diffCnt === 1) {
            nextSteps.push(wordList[i]);
        }
    }
    return nextSteps;
};