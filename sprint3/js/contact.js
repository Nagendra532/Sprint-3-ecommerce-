// Optional: You can add client-side validation here if needed

document.getElementById('newItemForm').addEventListener('submit', function (event) {
    event.preventDefault();
    
    fetch('send_email.php', {
        method: 'POST',
        body: new FormData(event.target),
    })
    .then(response => response.text())
    .then(data => {
        alert(data); // Display a success or error message to the user
    })
    .catch(error => {
        console.error('Error:', error);
    });
});
