const student = {
    id: 101,
    name: "Prabath",
    marks: {
        math: 90,
        science: 88
    }
};

const { name, marks: { math } } = student;
console.log(name);
console.log(math);

const subjects = ["Math", "Science", "English"];
const [first, second] = subjects;

console.log(first);
console.log(second);
