/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.

Corner Cases:

 

 

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    const path1 = path.replace(/\/\//g, "/");
    const stack = [];
    const path2 = path2.replace(/\/\B|\/\.|\/\.\./g, (matched) => {
        if (matched === "/..") {
            if (stack.length === 0) {
                stack.push("/");
            } else {
                stack.pop();
            }
        } else if (matched === "/.") {
            return "";
        } else {
            stack.push(matched);
        }
    })
    return stack.join("");
};