<?php
session_start();

$servername = "localhost";
$username = "userrollerspeed";
$password = "12345";
$dbname = "aspirantes";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Obtener datos del formulario
$user = $_POST['username'];
$pass = $_POST['password'];


// Consultar la base de datos
$sql = "SELECT * FROM users WHERE username = '$user'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Verificar contraseña
    $row = $result->fetch_assoc();
    if (password_verify($pass, $row['password'])) {
        $_SESSION['username'] = $user;
        echo "Inicio de sesión exitoso";
        // Redirigir o realizar otras acciones
    } else {
        echo "Contraseña incorrecta";
    }
} else {
    echo "Usuario no encontrado";
}

$conn->close();
?>
