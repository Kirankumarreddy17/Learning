document.getElementById("reportForm").addEventListener("submit", function(event) {
    event.preventDefault();

    // Subjects (array)
    const subjects = ["Math", "Science", "English", "History", "Computer"];

    // Get user input
    let marksInput = document.getElementById("marksInput").value;
    let marksArray = marksInput.split(",").map(m => parseFloat(m.trim()));

    // Check if subject count matches
    if (marksArray.length !== subjects.length) {
        alert("Please enter marks for exactly ${subjects.length} subjects");
        return;
    }

    // Calculate total
    let totalMarks = marksArray.reduce((sum, mark) => sum + mark, 0);

    // Calculate percentage
    let percentage = (totalMarks / (subjects.length * 100)) * 100;

    // Determine grade
    let grade;
    if (percentage >= 90) grade = "A+";
    else if (percentage >= 80) grade = "A";
    else if (percentage >= 70) grade = "B";
    else if (percentage >= 60) grade = "C";
    else if (percentage >= 50) grade = "D";
    else grade = "F";

    // Prepare JSON result
    const reportCard = {
        Subjects: subjects,
        Marks: marksArray,
        Total: totalMarks,
        Percentage: percentage.toFixed(2) + "%",
        Grade: grade
    };

    // Display result
    document.getElementById("resultJSON").textContent = JSON.stringify(reportCard, null, 4);
    document.getElementById("resultCard").style.display = "block";
});