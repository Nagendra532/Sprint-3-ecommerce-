<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $productDetail = $_POST['productDetail'];

    // Configure your email settings
    $to = 'recipient@example.com';  // Replace with your recipient's email address
    $subject = 'Contact Form Submission';
    $message = "Name: $name\nEmail/Phone: $email\nProduct Details: $productDetail";

    // Send the email
    if (mail($to, $subject, $message)) {
        echo 'Email sent successfully';
    } else {
        echo 'Email could not be sent';
    }
} else {
    echo 'Invalid request';
}
?>
