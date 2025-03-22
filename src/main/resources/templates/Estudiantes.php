<?php
$servername = "localhost";
$username = "userrollerspeed";
$password = "12345";
$dbname = "rollerspeed"; // Nombre de tu base de datos

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Consulta para obtener solo estudiantes
$sql = "SELECT id, nombre, correo FROM aspirantes WHERE rol = 'Estudiante'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        echo "<tr>
                <td>" . $row["id"] . "</td>
                <td>" . $row["nombre"] . "</td>
                <td>" . $row["correo"] . "</td>
              </tr>";
    }
} else {
    echo "<tr><td colspan='3'>No hay estudiantes registrados</td></tr>";
}

$conn->close();
?>
