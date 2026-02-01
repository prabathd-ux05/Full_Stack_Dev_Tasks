function highlight(element) {
    element.style.border = "2px solid #4a46e5";
}

function removeHighlight(element) {
    element.style.border = "1px solid #ccc";
}

function validateName() {
    let name = document.getElementById("name").value;
    document.getElementById("nameError").innerText =
        name.length < 3 ? "Name must be at least 3 characters" : "";
}

function validateEmail() {
    let email = document.getElementById("email").value;
    document.getElementById("emailError").innerText =
        email.includes("@") ? "" : "Invalid email format";
}

function validateFeedback() {
    let feedback = document.getElementById("feedback").value;
    document.getElementById("feedbackError").innerText =
        feedback.length < 10 ? "Feedback too short" : "";
}

function submitForm() {
    alert("✅ Feedback submitted successfully!");
}
