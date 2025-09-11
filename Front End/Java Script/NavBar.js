document.getElementById("reportForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let name = document.getElementById("studentName").value.trim();
    let marksInput = document.getElementById("marksInput").value.trim();
    let marksArray = marksInput.split(",").map(Number);

    if (marksArray.length !== 4 || marksArray.some(isNaN)) {
        alert("Please enter exactly 4 valid numbers separated by commas.");
        return;
    }

    let total = marksArray.reduce((a, b) => a + b, 0);
    let average = (total / 4).toFixed(2);
    let grade = average >= 90 ? 'A+' : average >= 80 ? 'A' : average >= 70 ? 'B' : average >= 60 ? 'C' : 'F';

    document.getElementById("output").innerHTML = `
        <h4>Report Card</h4>
        <p><strong>Name:</strong> ${name}</p>
        <p><strong>Marks:</strong> Math: ${marksArray[0]}, Science: ${marksArray[1]}, English: ${marksArray[2]}, History: ${marksArray[3]}</p>
        <p><strong>Total Marks:</strong> ${total}</p>
        <p><strong>Average:</strong> ${average}</p>
        <p><strong>Grade:</strong> ${grade}</p>
    `;
});