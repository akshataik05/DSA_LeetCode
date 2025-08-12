var createCounter = function(n) {
    let current = n;
    return function() {
        return current++;
    };
};

const counter = createCounter(10);
console.log(counter());
console.log(counter());
console.log(counter());
