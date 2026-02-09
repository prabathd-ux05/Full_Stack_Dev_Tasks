
const teamName = "Tigers";   
let score = 0;              

function updateScore(points) {
    score += points;
    console.log(`${teamName} Score: ${score}`);
}


updateScore(2);
updateScore(4);
updateScore(1);
